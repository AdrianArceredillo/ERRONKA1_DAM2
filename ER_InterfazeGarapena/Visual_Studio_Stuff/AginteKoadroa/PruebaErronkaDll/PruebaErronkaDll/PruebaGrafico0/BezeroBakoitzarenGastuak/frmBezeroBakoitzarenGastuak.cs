using GrafikoaDll_Bigarrena;
using Npgsql;
using PruebaErronkaDll;
using PruebaGrafico0.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

//Total gastado por cada cliente
/*
 * Consulta en pgAdmin4 - query
 * 
 * SELECT public."sale_order_line"."order_partner_id", sum(public."sale_order_line"."price_total") as Gastado FROM public.sale_order_line 
 * GROUP BY public."sale_order_line"."order_partner_id" 
 * ORDER BY Gastado DESC
 * 
 */



namespace PruebaGrafico0.BezeroBakoitzarenGastuak
{
    public partial class frmBezeroBakoitzarenGastuak : Form
    {
        public frmBezeroBakoitzarenGastuak()
        {
            InitializeComponent();
        }

        private void frmBezeroBakoitzarenGastuak_Load(object sender, EventArgs e)
        {
            using (var db = new PruebaErronkaDbContext())
            {
                var bezeroenGastuakData = db.Salmentak
                    .Include("Bezeroak")
                    //.Where(b => b.price_total >= 100)
                    .Where(b => b.res_Partner.name == "Biltegiko Nagusia")
                    .GroupBy(b => b.res_Partner.name)


                    //.GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                if (bezeroenGastuakData != null)
                {
                    if (bezeroenGastuakData.Count > 0)
                    {
                        //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        var kontrolak = bezeroenGastuakChart1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Compras de Clientes - Odoo";
                            kontrola.DataSource = bezeroenGastuakData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }

                    }
                }

                //bigarren grafikoa
                //BezeroBakoitzarenErosketakDLL

                //var bezeroenEroskeraHistoria = db.Salmentak
                //    .Include("Bezeroak")
                //    .Where(b => b.res_Partner.id == b.order_partner_id)
                //    .Where(b => b.res_Partner.name == "Biltegiko Nagusia")
                //    .GroupBy(b => b.res_Partner.name)
                //    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                var bezeroenEroskeraHistoria = db.Salmentak
                    .Include("product_template")
                    //.Where(b => b.res_Partner.id == b.order_partner_id)
                    .Where(b => b.res_Partner.name == "Biltegiko Nagusia")
                    .GroupBy(b => b.product_id)
                    .ToDictionary(g => g.Key, g => g.Count());

                if (bezeroenEroskeraHistoria != null)
                {
                    if (bezeroenEroskeraHistoria.Count > 0)
                    {
                        var kontrolak = bezeroBakoitzarenErosketak1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Erosketen Historia";
                            kontrola.DataSource = bezeroenEroskeraHistoria;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }




            }
        }
    }
}


//usar sentencias SQL de forma literal (sin llamadas a clases):
//https://stackoverflow.com/questions/17838913/postgresql-create-database-table-dynamically
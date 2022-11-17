using Microsoft.SqlServer.Server;
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

namespace PruebaGrafico0
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var db = new PruebaErronkaDbContext())
            {
                var salmentaData = db.Salmentak
                    //.GroupBy(b => b.product_id)
                    .GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                if (salmentaData != null)
                {
                    if (salmentaData.Count > 0)
                    {
                        //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        var kontrolak = pruebaErronkaDll2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Productos Comprados - Odoo";
                            kontrola.DataSource = salmentaData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }

                    }
                }


                //grafikoa_Bigarrena1

            }
        }
    }
}

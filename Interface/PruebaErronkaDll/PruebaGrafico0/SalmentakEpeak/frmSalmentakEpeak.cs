using BezeroBakoitzarenErosketak;
using BezeroBakoitzarenGastuakDLL;
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
using System.Xml.Linq;

namespace PruebaGrafico0.SalmentakEpeak
{
    public partial class frmSalmentakEpeak : Form
    {

        #region "DECLARACIONES"
        String fechaInicio = "", fechaFin = "";
        #endregion

        public frmSalmentakEpeak()
        {
            InitializeComponent();
        }

        private void btnVerResultadoGrafico_Click(object sender, EventArgs e)
        {
            if (fechaInicio.Equals("") || fechaFin.Equals(""))
            {
                MessageBox.Show("Alguna de las fechas no es correcta! Vuelve a intentarlo. ", "Atención", System.Windows.Forms.MessageBoxButtons.YesNo);
            } 
            else
            {
                this.refrescarGrafico(fechaInicio, fechaFin);
            }

            //fechaInicio = dtpHasieraData.Value.ToString("yyyy-MM-dd");
            //fechaFin = dtpAmaieraData.Value.ToString("yyyy-MM-dd");
            this.lblFechaInicio.Text = "Denbora-tartea: " + fechaInicio.ToString() + "tik, " + fechaFin.ToString() + "era. ";
        }

        private void dtpHasieraData_ValueChanged(object sender, EventArgs e)
        {
            fechaInicio = dtpHasieraData.Value.ToString("yyyy-MM-dd");
        }

        private void dtpAmaieraData_ValueChanged(object sender, EventArgs e)
        {
            fechaFin = dtpAmaieraData.Value.ToString("yyyy-MM-dd");
        }

        private void frmSalmentakEpeak_Load(object sender, EventArgs e)
        {
            /*
            using (var db = new PruebaErronkaDbContext())
            {
                var denboraTartekoSalmentak = db.SalmentakGeneral
                    .Include("Bezeroak")
                    .Where(b => b.create_date <= DateTime.Parse(fechaInicio) && b.create_date >= DateTime.Parse(fechaFin))
                    //.Where(b => b.create_date >= DateTime.Parse(fechaFin))
                    .GroupBy(b => b.create_date.Year)


                    //.GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                if (denboraTartekoSalmentak != null)
                {
                    if (denboraTartekoSalmentak.Count > 0)
                    {
                        //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        var kontrolak = salmentakDenboraTarteanDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Denbora-tartearen Salmentak";
                            kontrola.DataSource = denboraTartekoSalmentak;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }

                    }
                }
            }
            */
        }

        private void refrescarGrafico(string fechaInicial, string fechaFinal)
        {
            DateTime dt_Inicio;
            var isValidDate_Inicio = DateTime.TryParse(fechaInicial, out dt_Inicio);

            DateTime dt_Fin;
            var isValidDate_Fin = DateTime.TryParse(fechaFinal, out dt_Fin);

            using (var db = new PruebaErronkaDbContext())
            {
                var denboraTartekoSalmentak = db.SalmentakGeneral
                    .Include("Bezeroak")
                    //.Where(b => b.create_date < dt_Inicio && b.create_date >= dt_Fin)
                    .Where(b => b.create_date > dt_Inicio && b.create_date < dt_Fin)
                    .GroupBy(b => b.create_date.ToString())


                    //.GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                if (denboraTartekoSalmentak != null)
                {
                    if (denboraTartekoSalmentak.Count > 0)
                    {
                        //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        var kontrolak = salmentakDenboraTarteanDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            //kontrola.Titles[0].Text = "Denbora-tartearen Salmentak";
                            kontrola.DataSource = denboraTartekoSalmentak;
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

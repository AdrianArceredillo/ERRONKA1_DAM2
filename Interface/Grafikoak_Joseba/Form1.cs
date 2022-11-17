using Grafikoak_Joseba.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Entity.Infrastructure;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;
using HJAA_Grafikoak_HaritzOtero;


namespace Grafikoak_Joseba
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load_1(object sender, EventArgs e)
        {
            using (var db = new HJAADbContext())
            {
                //Graf1
                var produktuakData = db.Sales
                    //.Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));

                if (produktuakData != null)
                {
                    if (produktuakData.Count >= 0)
                    {
                        var kontrolak = graf12.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "PRODUKTUEN SALMENTAK";
                            kontrola.DataSource = produktuakData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }
                //prueba
                //Graf2
                var erosketakData = db.Purchases
                    .Include("Suppliers")
                    //.Where(b => b.date_planned.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Suppliers.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                    if (erosketakData != null)
                    {
                        if (erosketakData.Count >= 0)
                        {
                            var kontrolak = graf21.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "EROSKETAK";
                                kontrola.DataSource = erosketakData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }

                //Graf3
                var workersData = db.Sales
                    .Include("Workers")
                    //.Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Workers.login)
                    //.ToDictionary(g => g.Key, g => g.Sum(b => b.untaxed_amount_invoiced));
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_total));

                if (workersData != null)
                {
                    if (workersData.Count >= 0)
                    {
                        var kontrolak = graf31.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "LANGILEEN SALMENTAK";
                            kontrola.DataSource = workersData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

                //Graf4
                //var benefitData = db.
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            using (var db = new HJAADbContext())
            { 
                if (comboBox1.Text != "")
                {
                    //Graf1
                    var produktuakData = db.Sales
                    .Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));

                    if (produktuakData != null)
                    {
                        if (produktuakData.Count >= 0)
                        {
                            var kontrolak = graf12.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "PRODUKTUEN SALMENTAK";
                                kontrola.DataSource = produktuakData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }
                }
                else
                {
                    var produktuakData = db.Sales
                    //.Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));

                    if (produktuakData != null)
                    {
                        if (produktuakData.Count >= 0)
                        {
                            var kontrolak = graf12.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "PRODUKTUEN SALMENTAK";
                                kontrola.DataSource = produktuakData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }

                }

                if (comboBox1.Text != "")
                {
                    //Graf2
                    var erosketakData = db.Purchases
                    .Include("Suppliers")
                    .Where(b => b.date_planned.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Suppliers.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                    if (erosketakData != null)
                    {
                        if (erosketakData.Count >= 0)
                        {
                            var kontrolak = graf21.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "EROSKETAK";
                                kontrola.DataSource = erosketakData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }

                    }
                }
                else
                {
                    var erosketakData = db.Purchases
                    .Include("Suppliers")
                    //.Where(b => b.date_planned.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Suppliers.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                    if (erosketakData != null)
                    {
                        if (erosketakData.Count >= 0)
                        {
                            var kontrolak = graf21.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "EROSKETAK";
                                kontrola.DataSource = erosketakData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }
                }

                if (comboBox1.Text != "")
                {
                    //Graf3
                    var workersData = db.Sales
                    .Include("Workers")
                    .Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Workers.login)
                    //.ToDictionary(g => g.Key, g => g.Sum(b => b.untaxed_amount_invoiced));
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_total));

                    if (workersData != null)
                    {
                        if (workersData.Count >= 0)
                        {
                            var kontrolak = graf31.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "LANGILEEN SALMENTAK";
                                kontrola.DataSource = workersData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }
                }
                else
                {
                    var workersData = db.Sales
                    .Include("Workers")
                    //.Where(b => b.create_date.Year.ToString() == comboBox1.Text)
                    .GroupBy(b => b.Workers.login)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_total));

                    if (workersData != null)
                    {
                        if (workersData.Count >= 0)
                        {
                            var kontrolak = graf31.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.Titles[0].Text = "LANGILEEN SALMENTAK";
                                kontrola.DataSource = workersData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }
                }
            }
        }

        private void graf21_Load(object sender, EventArgs e)
        {

        }

        private void btnStockarenInformazioa_Click(object sender, EventArgs e)
        {
            frmHaritzOtero _frmHaritzOtero = new frmHaritzOtero();
            _frmHaritzOtero.ShowDialog();
        }
    }
}





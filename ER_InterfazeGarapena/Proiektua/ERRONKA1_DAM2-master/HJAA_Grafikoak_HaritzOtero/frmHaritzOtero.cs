using HJAA_Grafikoak_HaritzOtero.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Entity;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace HJAA_Grafikoak_HaritzOtero
{
    public partial class frmHaritzOtero : Form
    {
        public frmHaritzOtero()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {




            using (var db = new HJAADBContext())
            {
                //1 grafikoa
                var produKtuakData = db.product_template
                    .GroupBy(b => b.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.list_price));

                if (produKtuakData != null)
                {
                    if (produKtuakData.Count() > 0)
                    {
                        var kontrolak = userControl12.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();

                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "PRODUKTU GARESTIENAK";
                            kontrola.DataSource = produKtuakData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

                //stock-en labelak bete
                var data = db.stock_quant
                    .Where(b => b.location_id.Equals(8))
                    .ToDictionary(f => f.id, f => f.quantity);

                Label[] labels = new Label[7];
                labels[0] = label1;
                labels[1] = label2;
                labels[2] = label3;
                labels[3] = label4;
                labels[4] = label5;
                labels[5] = label6;
                labels[6] = label7;

                int[] balioenArraya = data.Values.ToArray();
                
                for (int i = 0; i <= balioenArraya.Length-1; i++)
                {

                    labels[i].Text = balioenArraya[i].ToString();
                }



               

                //2. grafikoa
                var produktuStock = db.stock_quant
                .Where(b => b.location_id.Equals(8))
                .Include(x => x.product_product.product_template)
                .ToDictionary(x => x.product_product.product_template.name, b => b.quantity);
                

                if (produktuStock != null)
                {
                    if (produktuStock.Count() > 0)
                    {
                        var controles = userControl11.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();

                        foreach (var control in controles)
                        {
                            control.Titles[0].Text = "PRODUKTUEN STOCK";
                            control.DataSource = produktuStock;
                            control.Series[0].YValueMembers = "Value";
                            control.Series[0].XValueMember = "Key";
                            control.DataBind();
                        }
                    }
                }
            }
        }
    }
}

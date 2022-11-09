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




namespace PruebaGrafico0.AtalNagusiaForm
{
    public partial class frmAtalNagusia : Form
    {
        public frmAtalNagusia()
        {
            InitializeComponent();
        }

        private void frmAtalNagusia_Load(object sender, EventArgs e)
        {
            this.gbDatuMota.ForeColor = System.Drawing.Color.Green;


        }

        private void btnVerTabPrueba_Click(object sender, EventArgs e)
        {
            if (this.tabControlSalmentak.SelectedTab == this.tabBezeroak)
            {
                this.lblVerCurrentTab.Text = this.tabBezeroak.Name.ToString();
            }
        }

        private void refrescarGrafico(string p1, string p2, string p3, string todos)
        {

            string checkear_Filtro = "";
            if (todos.Equals("verTodos"))
            {
                using (var db = new PruebaErronkaDbContext())
                {
                    string productos_Seleccionados = "";
                    string prod_Sel_Prueba = this.cboxMonitor4K.Text;


                    var salmentaData = db.Salmentak
                        .Include("Bezeroak")
                        //.Where(b => b.res_Partner.name.Equals(prod_Sel_Prueba))
                        //.Where(b => b.name.Equals(prod_Sel_Prueba))
                        .Where(b => b.name != "nada")
                        .GroupBy(b => b.name)
                        .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));


                    if (salmentaData != null)
                    {
                        if (salmentaData.Count > 0)
                        {
                            //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                //kontrola.Titles[0].Text = "Denbora-tartearen Salmentak";
                                kontrola.DataSource = salmentaData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }

                        }
                    }
                }
            }
            else
            {
                using (var db = new PruebaErronkaDbContext())
                {
                    string productos_Seleccionados = "";
                    string prod_Sel_Prueba = this.cboxMonitor4K.Text;


                    var salmentaData = db.Salmentak
                        .Include("Bezeroak")
                        //.Where(b => b.res_Partner.name.Equals(prod_Sel_Prueba))
                        //.Where(b => b.name.Equals(prod_Sel_Prueba))
                        .Where(b => b.name == p1 || b.name == p2 || b.name == p3)
                        .GroupBy(b => b.name)
                        .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));


                    if (salmentaData != null)
                    {
                        if (salmentaData.Count > 0)
                        {
                            //var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                //kontrola.Titles[0].Text = "Denbora-tartearen Salmentak";
                                kontrola.DataSource = salmentaData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }

                        }
                    }
                }
            }


        }

        public string filtroTeclado()
        {
            string filtro_teclado = "";

            if (this.cboxTecladoInalambrico.Checked)
            {
                //this.cboxVerTodosLosProductos.Checked = false;
                filtro_teclado = this.cboxTecladoInalambrico.Text.ToString();
            }
            else
            {
                filtro_teclado = "nada";
            }
            return filtro_teclado;
        }

        public string filtroMonitor()
        {
            string filtro_monitor = "";

            if (this.cboxMonitor4K.Checked)
            {
                //this.cboxVerTodosLosProductos.Checked = false;
                filtro_monitor = this.cboxMonitor4K.Text.ToString();
            }
            else
            {
                filtro_monitor = "nada";
            }
            return filtro_monitor;
        }

        public string filtroUsb()
        {
            string filtro_usb = "";

            if (this.cboxUsb30.Checked)
            {
                //this.cboxVerTodosLosProductos.Checked = false;
                filtro_usb = this.cboxUsb30.Text.ToString();
            }
            else
            {
                filtro_usb = "nada";
            }
            return filtro_usb;
        }

        public string filtroVerTodos()
        {
            string filtro_Todos = "";

            if (this.cboxVerTodosLosProductos.Checked)
            {
                //deseleccionar los demás productos
                this.cboxTecladoInalambrico.Checked = false;
                this.cboxMonitor4K.Checked = false;
                this.cboxUsb30.Checked = false;
                filtro_Todos = "verTodos";
            }
            return filtro_Todos;
        }

        public string filtroProductosSeleccionados()
        {
            string filtro_Productos = " sale_order_line.id != -2";







            //ver todos los productos



            return filtro_Productos;

        }


        private void cambiarEstadoListaProductos(bool est)
        {
            this.cboxTecladoInalambrico.Checked = est;
            this.cboxMonitor4K.Checked = est;
            this.cboxUsb30.Checked = est;

        }

        private void cboxVerTodosLosProductos_CheckedChanged(object sender, EventArgs e)
        {

            if (this.cboxVerTodosLosProductos.Checked)
            {
                this.cboxTecladoInalambrico.Checked = false;
                this.cboxTecladoInalambrico.Enabled = false;

                this.cboxMonitor4K.Checked = false;
                this.cboxMonitor4K.Enabled = false;

                this.cboxUsb30.Checked = false;
                this.cboxUsb30.Enabled = false;
            }
            else
            {
                this.cboxTecladoInalambrico.Enabled = true;
                this.cboxMonitor4K.Enabled = true;
                this.cboxUsb30.Enabled = true;
            }

            ////this.cambiarEstadoListaProductos(false);
            //this.cboxTecladoInalambrico.Checked = false;
            //this.cboxMonitor4K.Checked = false;
            //this.cboxUsb30.Checked = false;
        }

        private void cboxTecladoInalambrico_CheckedChanged(object sender, EventArgs e)
        {
            //this.cboxVerTodosLosProductos.Checked = false;
        }

        private void cboxMonitor4K_CheckedChanged(object sender, EventArgs e)
        {
            //this.cboxVerTodosLosProductos.Checked = false;
        }

        private void cboxUsb30_CheckedChanged(object sender, EventArgs e)
        {
            //this.cboxVerTodosLosProductos.Checked = false;
        }

        private void btnVerGraficoProductos_Click(object sender, EventArgs e)
        {
            this.pruebaErronkaDll1.Visible = true;


            this.lblVerConsultaActual.Text = this.filtroProductosSeleccionados();

            //comprobar filtros de productos
            this.filtroTeclado();
            this.filtroMonitor();
            this.filtroUsb();
            this.filtroVerTodos();

            this.refrescarGrafico(
                this.filtroTeclado(),
                this.filtroMonitor(),
                this.filtroUsb(),
                this.filtroVerTodos()
                );
        }

        private void btnEsconderGrafico_Click(object sender, EventArgs e)
        {
            this.pruebaErronkaDll1.Visible = false;
        }


    }
}

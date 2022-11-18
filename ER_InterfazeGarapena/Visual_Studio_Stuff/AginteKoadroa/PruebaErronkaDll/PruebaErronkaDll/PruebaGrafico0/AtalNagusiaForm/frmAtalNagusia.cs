using Microsoft.SqlServer.Server;
using PruebaGrafico0.Models;
using SalmentakDenboraTarteanDLL;
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

        #region "DECLARACIONES"
        String fechaInicio = "", fechaFin = "";
        #endregion


        public frmAtalNagusia()
        {
            InitializeComponent();
        }

        private void frmAtalNagusia_Load(object sender, EventArgs e)
        {

        }

        private void btnVerTabPrueba_Click(object sender, EventArgs e)
        {
            if (this.tabControlSalmentak.SelectedTab == this.tabBezeroak)
            {
                this.lblVerCurrentTab.Text = this.tabBezeroak.Name.ToString();
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



        private void btnEsconderGrafico_Click(object sender, EventArgs e)
        {
            this.pruebaErronkaDll1.Visible = false;
        }

        private void cbElegirCliente_SelectedIndexChanged(object sender, EventArgs e)
        {
            //if (cbElegirCliente.SelectedIndex < 0)
            if (cbElegirCliente.Text.Equals(""))
            {
                cbElegirCliente.Text = "Please, select any value";
                this.btnVerGraficoClientes.Enabled = false;
            }
            else
            {
                cbElegirCliente.Text = cbElegirCliente.SelectedText;
                this.btnVerGraficoClientes.Enabled = true;
            }
        }

        #region "VER GRÁFICOS"
        private void btnVerGraficoClientes_Click(object sender, EventArgs e)
        {
            this.totalGastoClienteGrafico.Visible = true;
            this.clienteHistorialCompraGrafico.Visible = true;

            if (this.cbElegirCliente.Text.Equals(""))
            {
                this.cbElegirCliente.Text = "Please, select any value";
                MessageBox.Show("Ez da bezerorik hautatu. Aukeratu bat informazioa kontsultatzeko. ", "Bezeroaren hautaketa");
            }
            else
            {
                this.refrescarGraficoClientes();
            }

            
        }

        private void btnVerGraficoProductos_Click(object sender, EventArgs e)
        {
            this.pruebaErronkaDll1.Visible = true;
            this.lblVerConsultaActual.Text = this.filtroProductosSeleccionados();

            //comprobar filtros de productos
            string teclado_F = this.filtroTeclado();
            string monitor_F = this.filtroMonitor();
            string usb_F = this.filtroUsb();
            string todos_F = this.filtroVerTodos();

            this.refrescarGraficoProductos(teclado_F, monitor_F, usb_F, todos_F);
        }

        #endregion


        #region "DECLARACIÓN DE LOS GRÁFICOS"
        private void refrescarGraficoProductos(string p1, string p2, string p3, string todos)
        {
            if (todos.Equals("verTodos"))
            {
                using (var db = new PruebaErronkaDbContext())
                {
                    string prod_Sel_Prueba = this.cboxMonitor4K.Text;

                    var salmentaData = db.Salmentak
                        .Include("Bezeroak")
                        .Where(b => b.name != "nada")
                        .GroupBy(b => b.name)
                        .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                    if (salmentaData != null)
                    {
                        if (salmentaData.Count > 0)
                        {
                            var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
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
                    string prod_Sel_Prueba = this.cboxMonitor4K.Text;

                    var salmentaData = db.Salmentak
                        .Include("Bezeroak")
                        .Where(b => b.name == p1 || b.name == p2 || b.name == p3)
                        .GroupBy(b => b.name)
                        .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                    if (salmentaData != null)
                    {
                        if (salmentaData.Count > 0)
                        {
                            var kontrolak = pruebaErronkaDll1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                            foreach (var kontrola in kontrolak)
                            {
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

        private void refrescarGraficoClientes()
        {
            string cliente_Seleccionado = this.cbElegirCliente.Text;

            using (var db = new PruebaErronkaDbContext())
            {
                var bezeroenGastuakData = db.Salmentak
                    .Include("Bezeroak")
                    .Where(b => b.res_Partner.name == cliente_Seleccionado)
                    .GroupBy(b => b.res_Partner.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.price_subtotal));

                if (bezeroenGastuakData != null)
                {
                    if (bezeroenGastuakData.Count > 0)
                    {
                        var kontrolak = totalGastoClienteGrafico.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Bezeroaren Gastuak";
                            kontrola.DataSource = bezeroenGastuakData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

                var bezeroenEroskeraHistoria = db.Salmentak
                    .Include("product_template")
                    .Where(b => b.res_Partner.name == cliente_Seleccionado)
                    .GroupBy(b => b.product_id)
                    .ToDictionary(g => g.Key, g => g.Count());

                if (bezeroenEroskeraHistoria != null)
                {
                    if (bezeroenEroskeraHistoria.Count > 0)
                    {
                        var kontrolak = clienteHistorialCompraGrafico.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
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

        private void refrescarGraficoIntervalosTiempo(string fechaInicial, string fechaFinal)
        {
            DateTime dt_Inicio, dt_Fin;
            
            var isValidDate_Inicio = DateTime.TryParse(fechaInicial, out dt_Inicio);
            var isValidDate_Fin = DateTime.TryParse(fechaFinal, out dt_Fin);

            using (var db = new PruebaErronkaDbContext())
            {
                var denboraTartekoSalmentak = db.SalmentakGeneral
                    .Include("Bezeroak")
                    .Where(b => b.create_date > dt_Inicio && b.create_date < dt_Fin)
                    .GroupBy(b => b.create_date.ToString())
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.amount_total));

                if (denboraTartekoSalmentak != null)
                {
                    if (denboraTartekoSalmentak.Count > 0)
                    {
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


        #endregion

        private void btnVerGraficoIntervalosTiempo_Click(object sender, EventArgs e)
        {
            if (fechaInicio.Equals("") || fechaFin.Equals(""))
            {
                this.lblAukeraturikoEpea.Visible = false;
                MessageBox.Show("Sartutako datetako bat ez da zuzena, saiatu berriro.. ", "Kontuz", System.Windows.Forms.MessageBoxButtons.YesNo);
            }
            else
            {
                this.refrescarGraficoIntervalosTiempo(fechaInicio, fechaFin);
                this.lblAukeraturikoEpea.Visible = true;
                this.lblAukeraturikoEpea.Text = " Hasiera eguna: " + fechaInicio.ToString() + " / Bukaera eguna: " + fechaFin.ToString() + ". ";

            }

        }

        private void dtpHasieraData_ValueChanged(object sender, EventArgs e)
        {
            fechaInicio = dtpHasieraData.Value.ToString("yyyy-MM-dd");
        }

        private void dtpAmaieraData_ValueChanged(object sender, EventArgs e)
        {
            fechaFin = dtpAmaieraData.Value.ToString("yyyy-MM-dd");
            this.pruebaErronkaDll1.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.salmentakDenboraTarteanDll1.Visible = false;
        }

        private void btnEsconderGraficoClientes_Click(object sender, EventArgs e)
        {
            this.totalGastoClienteGrafico.Visible = false;
            this.clienteHistorialCompraGrafico.Visible = false;
            this.totalGastoClienteGrafico.Visible = false;
        }

    }
}

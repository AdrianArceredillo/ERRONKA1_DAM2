namespace PruebaErronkaDll
{
    partial class PruebaErronkaDll
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Title title1 = new System.Windows.Forms.DataVisualization.Charting.Title();
            this.PruebaErro = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.PruebaErro)).BeginInit();
            this.SuspendLayout();
            // 
            // PruebaErro
            // 
            this.PruebaErro.BackColor = System.Drawing.Color.Transparent;
            chartArea1.AxisX.MajorGrid.LineColor = System.Drawing.Color.Transparent;
            chartArea1.AxisX.MajorTickMark.LineColor = System.Drawing.Color.DimGray;
            chartArea1.Name = "ChartArea1";
            this.PruebaErro.ChartAreas.Add(chartArea1);
            legend1.Enabled = false;
            legend1.Name = "Legend1";
            this.PruebaErro.Legends.Add(legend1);
            this.PruebaErro.Location = new System.Drawing.Point(3, 3);
            this.PruebaErro.Name = "PruebaErro";
            series1.ChartArea = "ChartArea1";
            series1.Color = System.Drawing.Color.Magenta;
            series1.IsValueShownAsLabel = true;
            series1.LabelForeColor = System.Drawing.Color.Orange;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.PruebaErro.Series.Add(series1);
            this.PruebaErro.Size = new System.Drawing.Size(541, 300);
            this.PruebaErro.TabIndex = 0;
            this.PruebaErro.Text = "chart1";
            title1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            title1.ForeColor = System.Drawing.Color.Orange;
            title1.Name = "Title1";
            title1.Text = "Productos / Stock";
            this.PruebaErro.Titles.Add(title1);
            // 
            // PruebaErronkaDll
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.PruebaErro);
            this.Name = "PruebaErronkaDll";
            this.Size = new System.Drawing.Size(547, 307);
            this.Load += new System.EventHandler(this.UserControl1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.PruebaErro)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart PruebaErro;
    }
}

namespace SalmentakDenboraTarteanDLL
{
    partial class SalmentakDenboraTarteanDll
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
            this.salmentakDenboraTarteanChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.salmentakDenboraTarteanChart)).BeginInit();
            this.SuspendLayout();
            // 
            // salmentakDenboraTarteanChart
            // 
            chartArea1.AxisX.MajorGrid.LineColor = System.Drawing.Color.Transparent;
            chartArea1.AxisY.MajorGrid.LineColor = System.Drawing.Color.Transparent;
            chartArea1.Name = "ChartArea1";
            this.salmentakDenboraTarteanChart.ChartAreas.Add(chartArea1);
            legend1.Enabled = false;
            legend1.Name = "Legend1";
            this.salmentakDenboraTarteanChart.Legends.Add(legend1);
            this.salmentakDenboraTarteanChart.Location = new System.Drawing.Point(0, 3);
            this.salmentakDenboraTarteanChart.Name = "salmentakDenboraTarteanChart";
            series1.ChartArea = "ChartArea1";
            series1.Color = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
            series1.IsValueShownAsLabel = true;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.salmentakDenboraTarteanChart.Series.Add(series1);
            this.salmentakDenboraTarteanChart.Size = new System.Drawing.Size(300, 300);
            this.salmentakDenboraTarteanChart.TabIndex = 0;
            this.salmentakDenboraTarteanChart.Text = "chart1";
            // 
            // SalmentakDenboraTarteanDll
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.salmentakDenboraTarteanChart);
            this.Name = "SalmentakDenboraTarteanDll";
            this.Size = new System.Drawing.Size(324, 325);
            ((System.ComponentModel.ISupportInitialize)(this.salmentakDenboraTarteanChart)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart salmentakDenboraTarteanDLL;
        private System.Windows.Forms.DataVisualization.Charting.Chart salmentakDenboraTarteanChart;
    }
}

namespace BezeroBakoitzarenErosketak
{
    partial class BezeroBakoitzarenErosketak
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
            this.bezeroBakoitzarenGastuak = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.bezeroBakoitzarenGastuak)).BeginInit();
            this.SuspendLayout();
            // 
            // bezeroBakoitzarenGastuak
            // 
            chartArea1.Name = "ChartArea1";
            this.bezeroBakoitzarenGastuak.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.bezeroBakoitzarenGastuak.Legends.Add(legend1);
            this.bezeroBakoitzarenGastuak.Location = new System.Drawing.Point(3, 3);
            this.bezeroBakoitzarenGastuak.Name = "bezeroBakoitzarenGastuak";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Doughnut;
            series1.IsValueShownAsLabel = true;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            series1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.SeaGreen;
            this.bezeroBakoitzarenGastuak.Series.Add(series1);
            this.bezeroBakoitzarenGastuak.Size = new System.Drawing.Size(322, 168);
            this.bezeroBakoitzarenGastuak.TabIndex = 0;
            this.bezeroBakoitzarenGastuak.Text = "chart1";
            title1.Name = "Title1";
            this.bezeroBakoitzarenGastuak.Titles.Add(title1);
            // 
            // BezeroBakoitzarenErosketak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.bezeroBakoitzarenGastuak);
            this.Name = "BezeroBakoitzarenErosketak";
            this.Size = new System.Drawing.Size(331, 178);
            ((System.ComponentModel.ISupportInitialize)(this.bezeroBakoitzarenGastuak)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart bezeroBakoitzarenGastuak;
    }
}

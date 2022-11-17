namespace PruebaGrafico0.SalmentakEpeak
{
    partial class frmSalmentakEpeak
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.salmentakDenboraTarteanDll1 = new SalmentakDenboraTarteanDLL.SalmentakDenboraTarteanDll();
            this.lblFechaInicio = new System.Windows.Forms.Label();
            this.btnVerResultadoGrafico = new System.Windows.Forms.Button();
            this.dtpHasieraData = new System.Windows.Forms.DateTimePicker();
            this.lblHasiera = new System.Windows.Forms.Label();
            this.lblAmaiera = new System.Windows.Forms.Label();
            this.dtpAmaieraData = new System.Windows.Forms.DateTimePicker();
            this.SuspendLayout();
            // 
            // salmentakDenboraTarteanDll1
            // 
            this.salmentakDenboraTarteanDll1.Location = new System.Drawing.Point(12, 12);
            this.salmentakDenboraTarteanDll1.Name = "salmentakDenboraTarteanDll1";
            this.salmentakDenboraTarteanDll1.Size = new System.Drawing.Size(324, 325);
            this.salmentakDenboraTarteanDll1.TabIndex = 0;
            // 
            // lblFechaInicio
            // 
            this.lblFechaInicio.AutoSize = true;
            this.lblFechaInicio.Location = new System.Drawing.Point(423, 91);
            this.lblFechaInicio.Name = "lblFechaInicio";
            this.lblFechaInicio.Size = new System.Drawing.Size(57, 13);
            this.lblFechaInicio.TabIndex = 7;
            this.lblFechaInicio.Text = "Selección:";
            // 
            // btnVerResultadoGrafico
            // 
            this.btnVerResultadoGrafico.Location = new System.Drawing.Point(342, 86);
            this.btnVerResultadoGrafico.Name = "btnVerResultadoGrafico";
            this.btnVerResultadoGrafico.Size = new System.Drawing.Size(75, 23);
            this.btnVerResultadoGrafico.TabIndex = 6;
            this.btnVerResultadoGrafico.Text = "Ver Fecha";
            this.btnVerResultadoGrafico.UseVisualStyleBackColor = true;
            this.btnVerResultadoGrafico.Click += new System.EventHandler(this.btnVerResultadoGrafico_Click);
            // 
            // dtpHasieraData
            // 
            this.dtpHasieraData.Location = new System.Drawing.Point(342, 12);
            this.dtpHasieraData.Name = "dtpHasieraData";
            this.dtpHasieraData.Size = new System.Drawing.Size(200, 20);
            this.dtpHasieraData.TabIndex = 5;
            this.dtpHasieraData.ValueChanged += new System.EventHandler(this.dtpHasieraData_ValueChanged);
            // 
            // lblHasiera
            // 
            this.lblHasiera.AutoSize = true;
            this.lblHasiera.Location = new System.Drawing.Point(548, 19);
            this.lblHasiera.Name = "lblHasiera";
            this.lblHasiera.Size = new System.Drawing.Size(18, 13);
            this.lblHasiera.TabIndex = 8;
            this.lblHasiera.Text = "tik";
            // 
            // lblAmaiera
            // 
            this.lblAmaiera.AutoSize = true;
            this.lblAmaiera.Location = new System.Drawing.Point(548, 44);
            this.lblAmaiera.Name = "lblAmaiera";
            this.lblAmaiera.Size = new System.Drawing.Size(22, 13);
            this.lblAmaiera.TabIndex = 10;
            this.lblAmaiera.Text = "era";
            // 
            // dtpAmaieraData
            // 
            this.dtpAmaieraData.Location = new System.Drawing.Point(342, 38);
            this.dtpAmaieraData.Name = "dtpAmaieraData";
            this.dtpAmaieraData.Size = new System.Drawing.Size(200, 20);
            this.dtpAmaieraData.TabIndex = 9;
            this.dtpAmaieraData.ValueChanged += new System.EventHandler(this.dtpAmaieraData_ValueChanged);
            // 
            // frmSalmentakEpeak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.lblAmaiera);
            this.Controls.Add(this.dtpAmaieraData);
            this.Controls.Add(this.lblHasiera);
            this.Controls.Add(this.lblFechaInicio);
            this.Controls.Add(this.btnVerResultadoGrafico);
            this.Controls.Add(this.dtpHasieraData);
            this.Controls.Add(this.salmentakDenboraTarteanDll1);
            this.Name = "frmSalmentakEpeak";
            this.Text = "Denbora-tarte bateko Salmentak";
            this.Load += new System.EventHandler(this.frmSalmentakEpeak_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private SalmentakDenboraTarteanDLL.SalmentakDenboraTarteanDll salmentakDenboraTarteanDll1;
        private System.Windows.Forms.Label lblFechaInicio;
        private System.Windows.Forms.Button btnVerResultadoGrafico;
        private System.Windows.Forms.DateTimePicker dtpHasieraData;
        private System.Windows.Forms.Label lblHasiera;
        private System.Windows.Forms.Label lblAmaiera;
        private System.Windows.Forms.DateTimePicker dtpAmaieraData;
    }
}
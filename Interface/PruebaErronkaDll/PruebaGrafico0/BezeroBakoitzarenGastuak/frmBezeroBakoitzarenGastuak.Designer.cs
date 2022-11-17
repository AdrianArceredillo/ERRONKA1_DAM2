namespace PruebaGrafico0.BezeroBakoitzarenGastuak
{
    partial class frmBezeroBakoitzarenGastuak
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
            this.bezeroBakoitzarenErosketak1 = new BezeroBakoitzarenErosketak.BezeroBakoitzarenErosketak();
            this.bezeroenGastuakChart1 = new BezeroBakoitzarenGastuakDLL.bezeroenGastuakChart();
            this.dtpDatePickerPrueba = new System.Windows.Forms.DateTimePicker();
            this.btnFechaDPickerPrueba = new System.Windows.Forms.Button();
            this.lblFechaInicio = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // bezeroBakoitzarenErosketak1
            // 
            this.bezeroBakoitzarenErosketak1.Location = new System.Drawing.Point(12, 246);
            this.bezeroBakoitzarenErosketak1.Name = "bezeroBakoitzarenErosketak1";
            this.bezeroBakoitzarenErosketak1.Size = new System.Drawing.Size(390, 202);
            this.bezeroBakoitzarenErosketak1.TabIndex = 1;
            // 
            // bezeroenGastuakChart1
            // 
            this.bezeroenGastuakChart1.Location = new System.Drawing.Point(12, 12);
            this.bezeroenGastuakChart1.Name = "bezeroenGastuakChart1";
            this.bezeroenGastuakChart1.Size = new System.Drawing.Size(584, 228);
            this.bezeroenGastuakChart1.TabIndex = 0;
            // 
            // dtpDatePickerPrueba
            // 
            this.dtpDatePickerPrueba.Location = new System.Drawing.Point(758, 191);
            this.dtpDatePickerPrueba.Name = "dtpDatePickerPrueba";
            this.dtpDatePickerPrueba.Size = new System.Drawing.Size(200, 20);
            this.dtpDatePickerPrueba.TabIndex = 2;
            // 
            // btnFechaDPickerPrueba
            // 
            this.btnFechaDPickerPrueba.Location = new System.Drawing.Point(758, 217);
            this.btnFechaDPickerPrueba.Name = "btnFechaDPickerPrueba";
            this.btnFechaDPickerPrueba.Size = new System.Drawing.Size(75, 23);
            this.btnFechaDPickerPrueba.TabIndex = 3;
            this.btnFechaDPickerPrueba.Text = "Ver Fecha";
            this.btnFechaDPickerPrueba.UseVisualStyleBackColor = true;
            this.btnFechaDPickerPrueba.Click += new System.EventHandler(this.btnFechaDPickerPrueba_Click);
            // 
            // lblFechaInicio
            // 
            this.lblFechaInicio.AutoSize = true;
            this.lblFechaInicio.Location = new System.Drawing.Point(839, 222);
            this.lblFechaInicio.Name = "lblFechaInicio";
            this.lblFechaInicio.Size = new System.Drawing.Size(57, 13);
            this.lblFechaInicio.TabIndex = 4;
            this.lblFechaInicio.Text = "Selección:";
            // 
            // frmBezeroBakoitzarenGastuak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1118, 449);
            this.Controls.Add(this.lblFechaInicio);
            this.Controls.Add(this.btnFechaDPickerPrueba);
            this.Controls.Add(this.dtpDatePickerPrueba);
            this.Controls.Add(this.bezeroBakoitzarenErosketak1);
            this.Controls.Add(this.bezeroenGastuakChart1);
            this.Name = "frmBezeroBakoitzarenGastuak";
            this.Text = "Bezero Bakoitzaren Gastuak";
            this.Load += new System.EventHandler(this.frmBezeroBakoitzarenGastuak_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BezeroBakoitzarenGastuakDLL.bezeroenGastuakChart bezeroenGastuakChart1;
        private BezeroBakoitzarenErosketak.BezeroBakoitzarenErosketak bezeroBakoitzarenErosketak1;
        private System.Windows.Forms.DateTimePicker dtpDatePickerPrueba;
        private System.Windows.Forms.Button btnFechaDPickerPrueba;
        private System.Windows.Forms.Label lblFechaInicio;
    }
}
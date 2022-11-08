namespace PruebaGrafico0.AtalNagusiaForm
{
    partial class frmAtalNagusia
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmAtalNagusia));
            this.gbDatuMota = new System.Windows.Forms.GroupBox();
            this.radioButton1 = new System.Windows.Forms.RadioButton();
            this.radioButton2 = new System.Windows.Forms.RadioButton();
            this.radioButton3 = new System.Windows.Forms.RadioButton();
            this.clDatuMota = new System.Windows.Forms.CheckedListBox();
            this.gbDatuMota.SuspendLayout();
            this.SuspendLayout();
            // 
            // gbDatuMota
            // 
            this.gbDatuMota.BackColor = System.Drawing.Color.Transparent;
            this.gbDatuMota.Controls.Add(this.radioButton3);
            this.gbDatuMota.Controls.Add(this.radioButton2);
            this.gbDatuMota.Controls.Add(this.radioButton1);
            this.gbDatuMota.Font = new System.Drawing.Font("Noto Sans Lao", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gbDatuMota.ForeColor = System.Drawing.SystemColors.WindowFrame;
            this.gbDatuMota.Location = new System.Drawing.Point(12, 271);
            this.gbDatuMota.Name = "gbDatuMota";
            this.gbDatuMota.Size = new System.Drawing.Size(200, 258);
            this.gbDatuMota.TabIndex = 0;
            this.gbDatuMota.TabStop = false;
            this.gbDatuMota.Text = "a";
            // 
            // radioButton1
            // 
            this.radioButton1.AutoSize = true;
            this.radioButton1.Location = new System.Drawing.Point(6, 25);
            this.radioButton1.Name = "radioButton1";
            this.radioButton1.Size = new System.Drawing.Size(99, 22);
            this.radioButton1.TabIndex = 0;
            this.radioButton1.TabStop = true;
            this.radioButton1.Text = "Salmentak";
            this.radioButton1.UseVisualStyleBackColor = true;
            // 
            // radioButton2
            // 
            this.radioButton2.AutoSize = true;
            this.radioButton2.Location = new System.Drawing.Point(6, 53);
            this.radioButton2.Name = "radioButton2";
            this.radioButton2.Size = new System.Drawing.Size(104, 22);
            this.radioButton2.TabIndex = 1;
            this.radioButton2.TabStop = true;
            this.radioButton2.Text = "Produktuak";
            this.radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton3
            // 
            this.radioButton3.AutoSize = true;
            this.radioButton3.Location = new System.Drawing.Point(6, 81);
            this.radioButton3.Name = "radioButton3";
            this.radioButton3.Size = new System.Drawing.Size(92, 22);
            this.radioButton3.TabIndex = 1;
            this.radioButton3.TabStop = true;
            this.radioButton3.Text = "Bezeroak";
            this.radioButton3.UseVisualStyleBackColor = true;
            // 
            // clDatuMota
            // 
            this.clDatuMota.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.clDatuMota.FormattingEnabled = true;
            this.clDatuMota.Items.AddRange(new object[] {
            "Salmentak",
            "Produktuak",
            "Bezeroak"});
            this.clDatuMota.Location = new System.Drawing.Point(512, 347);
            this.clDatuMota.Name = "clDatuMota";
            this.clDatuMota.Size = new System.Drawing.Size(120, 90);
            this.clDatuMota.TabIndex = 1;
            // 
            // frmAtalNagusia
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1122, 608);
            this.Controls.Add(this.clDatuMota);
            this.Controls.Add(this.gbDatuMota);
            this.DoubleBuffered = true;
            this.Name = "frmAtalNagusia";
            this.Text = "Datuak eta Estatistikak";
            this.Load += new System.EventHandler(this.frmAtalNagusia_Load);
            this.gbDatuMota.ResumeLayout(false);
            this.gbDatuMota.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox gbDatuMota;
        private System.Windows.Forms.RadioButton radioButton1;
        private System.Windows.Forms.RadioButton radioButton3;
        private System.Windows.Forms.RadioButton radioButton2;
        private System.Windows.Forms.CheckedListBox clDatuMota;
    }
}
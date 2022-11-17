namespace Grafikoak_Joseba
{
    partial class Form1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.graf31 = new Graf3.Graf3();
            this.btnStockarenInformazioa = new System.Windows.Forms.Button();
            this.graf12 = new Graf1.Graf1();
            this.graf21 = new Graf2.Graf2();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(12, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(134, 128);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // btnExit
            // 
            this.btnExit.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.btnExit.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.btnExit.Location = new System.Drawing.Point(1804, 53);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(90, 52);
            this.btnExit.TabIndex = 3;
            this.btnExit.Text = "ITXI SAIOA";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // comboBox1
            // 
            this.comboBox1.Items.AddRange(new object[] {
            "",
            "2022",
            "2021",
            "2020",
            "2019"});
            this.comboBox1.Location = new System.Drawing.Point(898, 88);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(138, 21);
            this.comboBox1.TabIndex = 7;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Yu Gothic", 25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(885, 37);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(166, 42);
            this.label1.TabIndex = 6;
            this.label1.Text = "URTEAK";
            // 
            // graf31
            // 
            this.graf31.Location = new System.Drawing.Point(124, 637);
            this.graf31.Name = "graf31";
            this.graf31.Size = new System.Drawing.Size(700, 400);
            this.graf31.TabIndex = 8;
            // 
            // btnStockarenInformazioa
            // 
            this.btnStockarenInformazioa.Font = new System.Drawing.Font("Mongolian Baiti", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnStockarenInformazioa.Location = new System.Drawing.Point(1386, 794);
            this.btnStockarenInformazioa.Name = "btnStockarenInformazioa";
            this.btnStockarenInformazioa.Size = new System.Drawing.Size(203, 87);
            this.btnStockarenInformazioa.TabIndex = 9;
            this.btnStockarenInformazioa.Text = "IKUSI STOCKAREN INFORMAZIOA";
            this.btnStockarenInformazioa.UseVisualStyleBackColor = true;
            this.btnStockarenInformazioa.Click += new System.EventHandler(this.btnStockarenInformazioa_Click);
            // 
            // graf12
            // 
            this.graf12.Location = new System.Drawing.Point(124, 185);
            this.graf12.Name = "graf12";
            this.graf12.Size = new System.Drawing.Size(700, 400);
            this.graf12.TabIndex = 4;
            // 
            // graf21
            // 
            this.graf21.BackColor = System.Drawing.SystemColors.Control;
            this.graf21.Location = new System.Drawing.Point(1111, 185);
            this.graf21.Name = "graf21";
            this.graf21.Size = new System.Drawing.Size(700, 400);
            this.graf21.TabIndex = 1;
            this.graf21.Load += new System.EventHandler(this.graf21_Load);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1924, 1061);
            this.Controls.Add(this.btnStockarenInformazioa);
            this.Controls.Add(this.graf31);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.graf12);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.graf21);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "HJAA Enpresa";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.Form1_Load_1);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private Graf2.Graf2 graf21;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnExit;
        private Graf1.Graf1 graf12;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.Label label1;
        private Graf3.Graf3 graf31;
        private System.Windows.Forms.Button btnStockarenInformazioa;
    }
}


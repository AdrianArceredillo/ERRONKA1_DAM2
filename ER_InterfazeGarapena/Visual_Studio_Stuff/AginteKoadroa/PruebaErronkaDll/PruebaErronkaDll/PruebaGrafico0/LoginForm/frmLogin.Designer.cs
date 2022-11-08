namespace PruebaGrafico0.LoginForm
{
    partial class frmLogin
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmLogin));
            this.txtLoginUsername = new System.Windows.Forms.TextBox();
            this.txtLoginPassword = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btnSartu = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.btnDelayPrueba = new System.Windows.Forms.Button();
            this.lblDelay = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtLoginUsername
            // 
            this.txtLoginUsername.Location = new System.Drawing.Point(426, 73);
            this.txtLoginUsername.Name = "txtLoginUsername";
            this.txtLoginUsername.Size = new System.Drawing.Size(298, 20);
            this.txtLoginUsername.TabIndex = 0;
            // 
            // txtLoginPassword
            // 
            this.txtLoginPassword.Location = new System.Drawing.Point(426, 119);
            this.txtLoginPassword.Name = "txtLoginPassword";
            this.txtLoginPassword.Size = new System.Drawing.Size(298, 20);
            this.txtLoginPassword.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(57, 327);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(168, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Fuente 1: Noto Kufi Arabic; 8,25pt";
            this.label1.Visible = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(231, 327);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Color 1: GrayText";
            this.label2.Visible = false;
            // 
            // btnSartu
            // 
            this.btnSartu.BackColor = System.Drawing.Color.SlateBlue;
            this.btnSartu.Font = new System.Drawing.Font("Noto Kufi Arabic", 8.25F);
            this.btnSartu.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.btnSartu.Location = new System.Drawing.Point(426, 208);
            this.btnSartu.Name = "btnSartu";
            this.btnSartu.Size = new System.Drawing.Size(90, 25);
            this.btnSartu.TabIndex = 5;
            this.btnSartu.Text = "Sartu";
            this.btnSartu.UseVisualStyleBackColor = false;
            this.btnSartu.Click += new System.EventHandler(this.btnSartu_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(57, 350);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(138, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Tema (color): 128; 128; 255";
            this.label3.Visible = false;
            // 
            // btnDelayPrueba
            // 
            this.btnDelayPrueba.Location = new System.Drawing.Point(522, 208);
            this.btnDelayPrueba.Name = "btnDelayPrueba";
            this.btnDelayPrueba.Size = new System.Drawing.Size(75, 23);
            this.btnDelayPrueba.TabIndex = 7;
            this.btnDelayPrueba.Text = "Delay";
            this.btnDelayPrueba.UseVisualStyleBackColor = true;
            this.btnDelayPrueba.Visible = false;
            this.btnDelayPrueba.Click += new System.EventHandler(this.btnDelayPrueba_Click);
            // 
            // lblDelay
            // 
            this.lblDelay.AutoSize = true;
            this.lblDelay.Location = new System.Drawing.Point(423, 245);
            this.lblDelay.Name = "lblDelay";
            this.lblDelay.Size = new System.Drawing.Size(74, 13);
            this.lblDelay.TabIndex = 8;
            this.lblDelay.Text = "Konprobaketa";
            this.lblDelay.Visible = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(57, 372);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(75, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Size: 813; 484";
            this.label4.Visible = false;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.panel1.Controls.Add(this.btnSartu);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.lblDelay);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.btnDelayPrueba);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.txtLoginUsername);
            this.panel1.Controls.Add(this.txtLoginPassword);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(797, 445);
            this.panel1.TabIndex = 10;
            // 
            // frmLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(797, 445);
            this.Controls.Add(this.panel1);
            this.DoubleBuffered = true;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmLogin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Ongi etorri!";
            this.Load += new System.EventHandler(this.frmLogin_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox txtLoginUsername;
        private System.Windows.Forms.TextBox txtLoginPassword;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnSartu;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnDelayPrueba;
        private System.Windows.Forms.Label lblDelay;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Panel panel1;
    }
}
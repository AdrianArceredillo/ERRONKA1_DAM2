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
            this.gbChooseUserType = new System.Windows.Forms.GroupBox();
            this.rdbUserTypeLangilea = new System.Windows.Forms.RadioButton();
            this.rdbUserTypeBezeroa = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.gbChooseUserType.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtLoginUsername
            // 
            this.txtLoginUsername.Location = new System.Drawing.Point(434, 79);
            this.txtLoginUsername.Name = "txtLoginUsername";
            this.txtLoginUsername.Size = new System.Drawing.Size(298, 20);
            this.txtLoginUsername.TabIndex = 0;
            // 
            // txtLoginPassword
            // 
            this.txtLoginPassword.Location = new System.Drawing.Point(434, 127);
            this.txtLoginPassword.Name = "txtLoginPassword";
            this.txtLoginPassword.Size = new System.Drawing.Size(298, 20);
            this.txtLoginPassword.TabIndex = 1;
            // 
            // gbChooseUserType
            // 
            this.gbChooseUserType.BackColor = System.Drawing.Color.Transparent;
            this.gbChooseUserType.Controls.Add(this.rdbUserTypeLangilea);
            this.gbChooseUserType.Controls.Add(this.rdbUserTypeBezeroa);
            this.gbChooseUserType.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gbChooseUserType.Location = new System.Drawing.Point(434, 212);
            this.gbChooseUserType.Name = "gbChooseUserType";
            this.gbChooseUserType.Size = new System.Drawing.Size(188, 54);
            this.gbChooseUserType.TabIndex = 2;
            this.gbChooseUserType.TabStop = false;
            // 
            // rdbUserTypeLangilea
            // 
            this.rdbUserTypeLangilea.AutoSize = true;
            this.rdbUserTypeLangilea.Font = new System.Drawing.Font("Noto Kufi Arabic", 8.25F);
            this.rdbUserTypeLangilea.ForeColor = System.Drawing.SystemColors.GrayText;
            this.rdbUserTypeLangilea.Location = new System.Drawing.Point(93, 19);
            this.rdbUserTypeLangilea.Name = "rdbUserTypeLangilea";
            this.rdbUserTypeLangilea.Size = new System.Drawing.Size(82, 25);
            this.rdbUserTypeLangilea.TabIndex = 1;
            this.rdbUserTypeLangilea.TabStop = true;
            this.rdbUserTypeLangilea.Text = "Langilea";
            this.rdbUserTypeLangilea.UseVisualStyleBackColor = true;
            // 
            // rdbUserTypeBezeroa
            // 
            this.rdbUserTypeBezeroa.AutoSize = true;
            this.rdbUserTypeBezeroa.Font = new System.Drawing.Font("Noto Kufi Arabic", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdbUserTypeBezeroa.ForeColor = System.Drawing.SystemColors.GrayText;
            this.rdbUserTypeBezeroa.Location = new System.Drawing.Point(6, 19);
            this.rdbUserTypeBezeroa.Name = "rdbUserTypeBezeroa";
            this.rdbUserTypeBezeroa.Size = new System.Drawing.Size(81, 25);
            this.rdbUserTypeBezeroa.TabIndex = 0;
            this.rdbUserTypeBezeroa.TabStop = true;
            this.rdbUserTypeBezeroa.Text = "Bezeroa";
            this.rdbUserTypeBezeroa.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 342);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(168, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Fuente 1: Noto Kufi Arabic; 8,25pt";
            this.label1.Visible = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(206, 342);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Color 1: GrayText";
            this.label2.Visible = false;
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.SlateBlue;
            this.button1.Font = new System.Drawing.Font("Noto Kufi Arabic", 8.25F);
            this.button1.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.button1.Location = new System.Drawing.Point(642, 231);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(90, 25);
            this.button1.TabIndex = 5;
            this.button1.Text = "Sartu";
            this.button1.UseVisualStyleBackColor = false;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(32, 365);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(138, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Tema (color): 128; 128; 255";
            // 
            // frmLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(797, 445);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.gbChooseUserType);
            this.Controls.Add(this.txtLoginPassword);
            this.Controls.Add(this.txtLoginUsername);
            this.Name = "frmLogin";
            this.Text = "Inicio de Sesión";
            this.Load += new System.EventHandler(this.frmLogin_Load);
            this.gbChooseUserType.ResumeLayout(false);
            this.gbChooseUserType.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtLoginUsername;
        private System.Windows.Forms.TextBox txtLoginPassword;
        private System.Windows.Forms.GroupBox gbChooseUserType;
        private System.Windows.Forms.RadioButton rdbUserTypeBezeroa;
        private System.Windows.Forms.RadioButton rdbUserTypeLangilea;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label3;
    }
}
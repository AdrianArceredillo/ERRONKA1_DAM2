namespace PruebaGrafico0
{
    partial class Form1
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

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.helpProvider1 = new System.Windows.Forms.HelpProvider();
            this.pruebaErronkaDll2 = new PruebaErronkaDll.PruebaErronkaDll();
            this.SuspendLayout();
            // 
            // pruebaErronkaDll2
            // 
            this.pruebaErronkaDll2.Location = new System.Drawing.Point(12, 126);
            this.pruebaErronkaDll2.Name = "pruebaErronkaDll2";
            this.pruebaErronkaDll2.Size = new System.Drawing.Size(547, 307);
            this.pruebaErronkaDll2.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(797, 445);
            this.Controls.Add(this.pruebaErronkaDll2);
            this.DoubleBuffered = true;
            this.HelpButton = true;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.HelpProvider helpProvider1;
        private PruebaErronkaDll.PruebaErronkaDll pruebaErronkaDll2;
    }
}


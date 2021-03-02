package android.support.v7.h;

public final class b implements d {
    final d adk;
    int adl = 0;
    int adm = -1;
    int adn = -1;
    Object ado = null;

    public b(d dVar) {
        this.adk = dVar;
    }

    public final void hz() {
        if (this.adl != 0) {
            switch (this.adl) {
                case 1:
                    this.adk.f(this.adm, this.adn);
                    break;
                case 2:
                    this.adk.k(this.adm, this.adn);
                    break;
                case 3:
                    this.adk.c(this.adm, this.adn, this.ado);
                    break;
            }
            this.ado = null;
            this.adl = 0;
        }
    }

    @Override // android.support.v7.h.d
    public final void f(int i2, int i3) {
        if (this.adl != 1 || i2 < this.adm || i2 > this.adm + this.adn) {
            hz();
            this.adm = i2;
            this.adn = i3;
            this.adl = 1;
            return;
        }
        this.adn += i3;
        this.adm = Math.min(i2, this.adm);
    }

    @Override // android.support.v7.h.d
    public final void k(int i2, int i3) {
        if (this.adl != 2 || this.adm < i2 || this.adm > i2 + i3) {
            hz();
            this.adm = i2;
            this.adn = i3;
            this.adl = 2;
            return;
        }
        this.adn += i3;
        this.adm = i2;
    }

    @Override // android.support.v7.h.d
    public final void l(int i2, int i3) {
        hz();
        this.adk.l(i2, i3);
    }

    @Override // android.support.v7.h.d
    public final void c(int i2, int i3, Object obj) {
        if (this.adl != 3 || i2 > this.adm + this.adn || i2 + i3 < this.adm || this.ado != obj) {
            hz();
            this.adm = i2;
            this.adn = i3;
            this.ado = obj;
            this.adl = 3;
            return;
        }
        int i4 = this.adm + this.adn;
        this.adm = Math.min(i2, this.adm);
        this.adn = Math.max(i4, i2 + i3) - this.adm;
    }
}

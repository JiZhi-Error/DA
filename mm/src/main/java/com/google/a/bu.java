package com.google.a;

import com.google.a.a;
import com.google.a.a.AbstractC0085a;
import com.google.a.az;

public final class bu<MType extends a, BType extends a.AbstractC0085a, IType extends az> implements a.b {
    private boolean bWv;
    private a.b bYP;
    BType bZa;
    MType bZb;

    public bu(MType mtype, a.b bVar, boolean z) {
        this.bZb = (MType) ((a) ae.checkNotNull(mtype));
        this.bYP = bVar;
        this.bWv = z;
    }

    public final MType Hu() {
        if (this.bZb == null) {
            this.bZb = (MType) ((a) this.bZa.Bm());
        }
        return this.bZb;
    }

    public final MType Hv() {
        this.bWv = true;
        return Hu();
    }

    public final BType Hw() {
        if (this.bZa == null) {
            this.bZa = (BType) ((a.AbstractC0085a) this.bZb.a(this));
            this.bZa.c(this.bZb);
            this.bZa.yF();
        }
        return this.bZa;
    }

    public final bu<MType, BType, IType> b(MType mtype) {
        if (this.bZa == null && this.bZb == this.bZb.AQ()) {
            this.bZb = mtype;
        } else {
            Hw().c(mtype);
        }
        onChanged();
        return this;
    }

    private void onChanged() {
        if (this.bZa != null) {
            this.bZb = null;
        }
        if (this.bWv && this.bYP != null) {
            this.bYP.yH();
            this.bWv = false;
        }
    }

    @Override // com.google.a.a.b
    public final void yH() {
        onChanged();
    }
}

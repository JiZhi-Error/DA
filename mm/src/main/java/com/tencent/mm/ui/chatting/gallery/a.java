package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.ca;

public abstract class a {
    protected b Pwu;

    public a(b bVar) {
        this.Pwu = bVar;
    }

    public void detach() {
        this.Pwu = null;
    }

    public boolean a(k kVar, ca caVar, int i2) {
        return false;
    }

    public final k amM(int i2) {
        if (this.Pwu == null) {
            return null;
        }
        View abm = this.Pwu.abm(i2);
        if (abm == null) {
            return null;
        }
        return (k) abm.getTag();
    }

    public final void amN(int i2) {
        View abm;
        if (this.Pwu != null && (abm = this.Pwu.abm(i2)) != null && abm.getTag() != null) {
            a((k) abm.getTag(), this.Pwu.amt(i2), i2);
        }
    }
}

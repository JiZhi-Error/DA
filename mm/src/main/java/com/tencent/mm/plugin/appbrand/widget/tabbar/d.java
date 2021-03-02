package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.s;

public abstract class d {
    int index = -1;
    s kGT;
    String oFe;
    c oFf;
    a oFg;
    protected volatile e oFh;

    public interface a {
        void destroy(int i2);
    }

    public abstract void cdf();

    public final void a(e eVar) {
        this.oFh = eVar;
    }

    public final void a(a aVar) {
        this.oFg = aVar;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final String cdg() {
        if (this.oFe == null || this.oFe.isEmpty()) {
            return null;
        }
        return this.oFe;
    }

    public d(String str, c cVar, s sVar) {
        this.oFe = str;
        this.kGT = sVar;
        this.oFf = cVar;
    }

    public d(String str, c cVar) {
        this.oFe = str;
        this.oFf = cVar;
    }

    public final void cancel() {
        this.oFh = null;
    }

    /* access modifiers changed from: protected */
    public final void X(Bitmap bitmap) {
        e eVar = this.oFh;
        if (eVar != null) {
            eVar.a(bitmap, this);
        }
    }
}

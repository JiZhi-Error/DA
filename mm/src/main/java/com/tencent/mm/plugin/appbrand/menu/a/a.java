package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.ui.base.m;

public abstract class a<T extends ac> {
    public final int nfG;

    public abstract void a(Context context, T t, String str, t tVar);

    public a(int i2) {
        this.nfG = i2;
    }

    public void a(Context context, T t, m mVar, String str) {
    }

    public final int bPj() {
        return this.nfG;
    }
}

package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c;
import java.util.List;

public abstract class q<T> extends c.a {
    protected final List<T> oew;
    protected final List<T> oex;

    public q(List<T> list, List<T> list2) {
        this.oew = list;
        this.oex = list2;
    }

    @Override // android.support.v7.h.c.a
    public final int aB() {
        if (this.oew == null) {
            return 0;
        }
        return this.oew.size();
    }

    @Override // android.support.v7.h.c.a
    public final int aC() {
        if (this.oex == null) {
            return 0;
        }
        return this.oex.size();
    }
}

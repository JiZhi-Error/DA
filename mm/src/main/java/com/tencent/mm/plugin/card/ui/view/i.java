package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i {
    n qjX;

    public abstract void initView();

    public final void a(n nVar) {
        this.qjX = nVar;
        initView();
    }

    public void destroy() {
        this.qjX = null;
    }

    public void update() {
    }

    public void cxw() {
    }

    /* access modifiers changed from: protected */
    public final View findViewById(int i2) {
        return this.qjX.findViewById(i2);
    }

    /* access modifiers changed from: protected */
    public final String getString(int i2) {
        return this.qjX.getString(i2);
    }
}

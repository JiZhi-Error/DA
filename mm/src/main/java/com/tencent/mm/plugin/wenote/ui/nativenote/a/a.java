package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a extends RecyclerView.v {
    protected k JJu;

    public abstract void a(c cVar, int i2, int i3);

    public abstract int cCY();

    public a(View view, k kVar) {
        super(view);
        this.JJu = kVar;
    }
}

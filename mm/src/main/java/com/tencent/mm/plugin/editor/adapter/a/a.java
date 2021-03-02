package com.tencent.mm.plugin.editor.adapter.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public abstract class a extends RecyclerView.v {
    protected j qNG;

    public abstract void a(com.tencent.mm.plugin.editor.model.a.a aVar, int i2, int i3);

    public abstract int cCY();

    public a(View view, j jVar) {
        super(view);
        this.qNG = jVar;
    }
}

package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.storage.ca;

public abstract class a<T extends RecyclerView.v> {
    protected int aqi;
    protected int fs;
    g qnE;
    protected int qnF = 0;
    public ca qnv;

    public abstract int getType();

    public a(g gVar) {
        this.qnE = gVar;
    }

    public a(g gVar, ca caVar) {
        this.qnE = gVar;
        this.qnv = caVar;
    }

    public long getTimeStamp() {
        return this.qnv.field_createTime;
    }

    public String getFileExt() {
        return "";
    }

    public String getFileName() {
        return "";
    }

    public int cyt() {
        return 0;
    }

    public final synchronized void cyu() {
        this.qnF = 1;
    }

    public final synchronized void cyv() {
        this.qnF = 3;
    }

    public final synchronized void fm(int i2, int i3) {
        this.qnF = 2;
        this.fs = i2;
        this.aqi = i3;
    }

    public final synchronized void cyw() {
        this.qnF = 4;
    }

    public final synchronized void cyx() {
        this.qnF = 5;
    }

    public final synchronized void cyy() {
        this.qnF = 0;
    }

    public final boolean isInvalid() {
        return this.qnF == 4 || this.qnF == 5;
    }

    public void a(T t, int i2, a aVar) {
    }

    public void V(T t) {
    }

    public void a(View view, a aVar) {
    }

    public String toString() {
        return "MsgItem{msgInfo=" + this.qnv.field_msgId + '}';
    }

    public boolean equals(Object obj) {
        if (this.qnv == null || !(obj instanceof ca) || obj == null) {
            return super.equals(obj);
        }
        return this.qnv.field_msgId == ((ca) obj).field_msgId;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.qnE.cyC().getContext();
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.choosemsgfile.b.d.a cys() {
        return this.qnE.cyC().cys();
    }

    public final void a(boolean z, a aVar, T t) {
        this.qnE.a(z, aVar, t);
    }

    public final boolean isEnable() {
        return !this.qnE.cyC().cys().isInvalid() || this.qnE.cyC().cys().BY(this.qnv.field_msgId);
    }
}

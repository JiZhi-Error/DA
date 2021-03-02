package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a extends RecyclerView.a implements g {
    static g.b qoq;
    protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> opg;
    private c qon;
    private boolean qoo = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
    g.a qop;

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g
    public final c cyC() {
        return this.qon;
    }

    public a(c cVar, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> list) {
        this.qon = cVar;
        this.opg = list;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        return EM(i2).getType();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2, List list) {
        EM(i2);
        super.a(vVar, i2, list);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        if (!this.qoo) {
            Log.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", Boolean.valueOf(this.qoo));
            return;
        }
        EM(i2).a(vVar, i2, EM(i2 + 1));
    }

    @Override // android.support.v7.widget.RecyclerView.a, com.tencent.mm.plugin.choosemsgfile.b.c.g
    public final int getItemCount() {
        return this.opg.size();
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g
    public final com.tencent.mm.plugin.choosemsgfile.b.b.a EM(int i2) {
        if (this.opg == null || this.opg.size() <= i2) {
            return null;
        }
        return this.opg.get(i2);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g
    public final void a(boolean z, com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, RecyclerView.v vVar) {
        if (this.qop != null) {
            this.qop.a(z, aVar, vVar);
        }
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g
    public boolean cyD() {
        return false;
    }
}

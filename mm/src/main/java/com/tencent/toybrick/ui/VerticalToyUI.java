package com.tencent.toybrick.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a;
import com.tencent.toybrick.g.a;

public abstract class VerticalToyUI<T extends a> extends BaseToyUI<g> {
    static final /* synthetic */ boolean $assertionsDisabled = (!VerticalToyUI.class.desiredAssertionStatus());
    private a.C2220a Snl;
    private b SoK;
    private com.tencent.toybrick.d.a SoL;
    protected T SoM = null;

    @Override // com.tencent.toybrick.ui.BaseToyUI, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Class cls = null;
        try {
            this.SoM = (T) ((com.tencent.toybrick.g.a) cls.newInstance());
        } catch (InstantiationException e2) {
            as.printErrStackTrace("VerticalToyUI", e2, "", new Object[0]);
        } catch (IllegalAccessException e3) {
            as.printErrStackTrace("VerticalToyUI", e3, "", new Object[0]);
        }
        this.SoL = new com.tencent.toybrick.d.a(this);
        this.Snl = this.SoL.Snl;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.j3e);
        getBaseContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.aqE = 4;
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        b bVar = new b(this, this.Snl);
        this.SoK = bVar;
        recyclerView.setAdapter(bVar);
        recyclerView.setRecycledViewPool(com.tencent.toybrick.b.a.hpI());
        recyclerView.setViewCacheExtension(new RecyclerView.t() {
            /* class com.tencent.toybrick.ui.VerticalToyUI.AnonymousClass1 */
        });
        c cVar = new c(this);
        cVar.Snl = this.Snl;
        recyclerView.a(cVar);
        if (this.SoK != null) {
            this.SoK.atj.notifyChanged();
        }
    }
}

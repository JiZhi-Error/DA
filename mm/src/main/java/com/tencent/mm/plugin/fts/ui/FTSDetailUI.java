package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public class FTSDetailUI extends FTSBaseUI {
    private int mve;
    private int rjr;
    private j xbA;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111940);
        super.onCreate(bundle);
        ((n) g.ah(n.class)).getFTSImageLoader().dOn();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.query = stringExtra;
        this.xaN.getFtsEditText().O(stringExtra, null);
        Log.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", this.query, Integer.valueOf(this.rjr), Integer.valueOf(this.mve));
        dPc();
        this.xaN.getFtsEditText().gWY();
        AppMethodBeat.o(111940);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPh() {
        AppMethodBeat.i(111941);
        this.rjr = getIntent().getIntExtra("detail_type", 0);
        this.mve = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.o(111941);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111942);
        if (this.xbA == null) {
            this.xbA = new j(eVar, this.rjr, this.mve);
        }
        j jVar = this.xbA;
        AppMethodBeat.o(111942);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(a aVar, boolean z) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.an8;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(111943);
        this.xbA.finish();
        ((n) g.ah(n.class)).getFTSImageLoader().dOk();
        super.onDestroy();
        AppMethodBeat.o(111943);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final String getHint() {
        AppMethodBeat.i(111944);
        String Nu = n.Nu(this.rjr);
        if (Nu == null) {
            String string = getString(R.string.yn);
            AppMethodBeat.o(111944);
            return string;
        }
        AppMethodBeat.o(111944);
        return Nu;
    }
}

package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI extends FTSBaseUI {
    private int mve;
    private String query;
    private String wWT;
    private m xcm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112031);
        super.onCreate(bundle);
        ((n) g.ah(n.class)).getFTSImageLoader().dOn();
        a aVar = new a(this, (byte) 0);
        aVar.gCv = this.wWT;
        List<a.c> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        v(this.query, arrayList);
        dPc();
        AppMethodBeat.o(112031);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPh() {
        AppMethodBeat.i(112032);
        super.dPh();
        this.wWT = getIntent().getStringExtra("key_talker_query");
        this.query = getIntent().getStringExtra("key_query");
        this.mve = getIntent().getIntExtra("Search_Scene", 0);
        Log.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", this.query, this.wWT);
        AppMethodBeat.o(112032);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(112033);
        if (this.xcm == null) {
            this.xcm = new m(this, this.wWT, this.mve);
        }
        m mVar = this.xcm;
        AppMethodBeat.o(112033);
        return mVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.anx;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(112034);
        this.xcm.finish();
        ((n) g.ah(n.class)).getFTSImageLoader().dOl();
        super.onDestroy();
        AppMethodBeat.o(112034);
    }

    class a implements a.c {
        private String gCv;

        private a() {
        }

        /* synthetic */ a(FTSTalkerMessageUI fTSTalkerMessageUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.search.a.c
        public final String getTagName() {
            return this.gCv;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(168772);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(168772);
    }
}

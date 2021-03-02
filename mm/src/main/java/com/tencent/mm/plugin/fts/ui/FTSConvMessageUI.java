package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI extends FTSBaseUI {
    private int mve;
    private String query;
    private String wWS;
    private h xbp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPh() {
        AppMethodBeat.i(111913);
        super.dPh();
        this.wWS = getIntent().getStringExtra("key_conv");
        this.query = getIntent().getStringExtra("key_query");
        this.mve = getIntent().getIntExtra("Search_Scene", 0);
        AppMethodBeat.o(111913);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111914);
        super.onCreate(bundle);
        a aVar = new a(this, (byte) 0);
        aVar.gCv = d.arL(this.wWS);
        List<a.c> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        v(this.query, arrayList);
        dPc();
        AppMethodBeat.o(111914);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.an3;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(111915);
        this.xbp.finish();
        super.onDestroy();
        AppMethodBeat.o(111915);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111916);
        if (this.xbp == null) {
            this.xbp = new h(eVar, this.wWS, this.mve);
        }
        h hVar = this.xbp;
        AppMethodBeat.o(111916);
        return hVar;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final boolean awE() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final String getHint() {
        AppMethodBeat.i(111917);
        String string = getString(R.string.gh8);
        AppMethodBeat.o(111917);
        return string;
    }

    class a implements a.c {
        private String gCv;

        private a() {
        }

        /* synthetic */ a(FTSConvMessageUI fTSConvMessageUI, byte b2) {
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
        AppMethodBeat.i(168768);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(168768);
    }
}

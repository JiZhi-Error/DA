package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI extends FTSBaseUI {
    private int dDG;
    private int mve;
    private String query;
    private String talker;
    private String wWS;
    private String wWT;
    private i xbs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111926);
        super.onCreate(bundle);
        ((n) g.ah(n.class)).getFTSImageLoader().dOn();
        a aVar = new a(this, (byte) 0);
        aVar.gCv = this.wWT;
        a aVar2 = new a(this, (byte) 0);
        aVar2.gCv = ">";
        a aVar3 = new a(this, (byte) 0);
        aVar3.gCv = d.arL(this.wWS);
        List<a.c> arrayList = new ArrayList<>();
        if (this.dDG == 2) {
            arrayList.add(aVar);
            arrayList.add(aVar2);
            arrayList.add(aVar3);
        } else {
            arrayList.add(aVar3);
            arrayList.add(aVar2);
            arrayList.add(aVar);
        }
        v(this.query, arrayList);
        dPc();
        AppMethodBeat.o(111926);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPh() {
        AppMethodBeat.i(111927);
        super.dPh();
        this.wWS = getIntent().getStringExtra("key_conv");
        this.talker = getIntent().getStringExtra("key_talker");
        this.query = getIntent().getStringExtra("key_query");
        this.wWT = getIntent().getStringExtra("key_talker_query");
        this.dDG = getIntent().getIntExtra("detail_type", 1);
        this.mve = getIntent().getIntExtra("Search_Scene", 0);
        Log.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", this.query, this.talker, this.wWS, Integer.valueOf(this.dDG));
        AppMethodBeat.o(111927);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111928);
        if (this.xbs == null) {
            this.xbs = new i(this, this.talker, this.wWT, this.wWS, this.mve, this.dDG);
        }
        i iVar = this.xbs;
        AppMethodBeat.o(111928);
        return iVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.anx;
    }

    class a implements a.c {
        private String gCv;

        private a() {
        }

        /* synthetic */ a(FTSConvTalkerMessageUI fTSConvTalkerMessageUI, byte b2) {
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
        AppMethodBeat.i(168770);
        super.a(str2, str2, list, bVar);
        AppMethodBeat.o(168770);
    }
}

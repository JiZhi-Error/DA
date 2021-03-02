package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ah;

public final class g extends d implements l {
    private MMHandler ndA = new MMHandler();
    private k wWP;
    private String wWS;
    private a wXa;
    private ah xbi;

    public g(e eVar, String str) {
        super(eVar);
        AppMethodBeat.i(111878);
        this.wWS = str;
        if (ab.Iw(str)) {
            this.xbi = ((c) com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(str);
        }
        AppMethodBeat.o(111878);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final com.tencent.mm.plugin.fts.a.d.a.a No(int i2) {
        AppMethodBeat.i(111879);
        d dVar = new d(i2);
        dVar.lqW = this.wWP.wXb.get(i2);
        dVar.wWd = this.wWP.wWd;
        dVar.rjr = -14;
        dVar.xbi = this.xbi;
        dVar.wXL = i2;
        dVar.pageType = 6;
        if (dVar.position == getCount() - 1) {
            dVar.wXK = true;
        }
        AppMethodBeat.o(111879);
        return dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(111880);
        clearCache();
        if (this.wXa != null) {
            ((n) com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
        }
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWS = this.wWS;
        jVar.wWY = e.wXB;
        jVar.wWX.add("create_talker_message​");
        jVar.wWZ = this;
        jVar.handler = this.ndA;
        jVar.kXb = 3;
        this.wXa = ((n) com.tencent.mm.kernel.g.ah(n.class)).search(3, jVar);
        Log.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", this.query);
        AppMethodBeat.o(111880);
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(111881);
        switch (kVar.resultCode) {
            case 0:
                this.wWP = kVar;
                setCount(kVar.wXb.size());
                notifyDataSetChanged();
                ax(getCount(), true);
                AppMethodBeat.o(111881);
                return;
            case -3:
            case -2:
            case -1:
                setCount(0);
                notifyDataSetChanged();
                ax(getCount(), true);
                break;
        }
        AppMethodBeat.o(111881);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(111882);
        super.finish();
        if (this.wXa != null) {
            ((n) com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
        }
        AppMethodBeat.o(111882);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }
}

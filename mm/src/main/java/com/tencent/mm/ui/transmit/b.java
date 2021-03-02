package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;

public final class b extends o {
    private MMCreateChatroomUI QxW;
    private l QxX = new l() {
        /* class com.tencent.mm.ui.transmit.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(39231);
            if (kVar.resultCode == 0) {
                b.this.wWP = kVar;
            } else {
                b.this.wWP = null;
            }
            if (kVar.wXb.size() == 0) {
                m mVar = new m();
                mVar.wVX = "no_result​";
                kVar.wXb = new ArrayList();
                kVar.wXb.add(mVar);
            }
            b.this.clearCache();
            b.this.notifyDataSetChanged();
            b.this.PWf.B(kVar.wTn.query, kVar.wXb.size(), true);
            AppMethodBeat.o(39231);
        }
    };
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    String query;
    k wWP;
    private a wXa;

    public b(MMCreateChatroomUI mMCreateChatroomUI, int i2) {
        super(mMCreateChatroomUI, false, i2);
        AppMethodBeat.i(39232);
        this.QxW = mMCreateChatroomUI;
        AppMethodBeat.o(39232);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(39233);
        this.query = str;
        j jVar = new j();
        jVar.handler = this.handler;
        jVar.wWZ = this.QxX;
        jVar.query = str;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
        jVar.wWU = new int[]{131072};
        jVar.wWX.add("filehelper");
        jVar.wWX.add(z.aTY());
        jVar.wWX.addAll(this.QxW.Qya.gYd());
        this.wXa = ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(39233);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void clearData() {
        AppMethodBeat.i(39234);
        if (this.wXa != null) {
            ((n) g.ah(n.class)).cancelSearchTask(this.wXa);
        }
        this.query = null;
        AppMethodBeat.o(39234);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        com.tencent.mm.ui.contact.a.a aVar;
        AppMethodBeat.i(39235);
        m mVar = this.wWP.wXb.get(i2);
        if (mVar.wVX.equals("no_result​")) {
            aVar = new i(i2);
        } else {
            e eVar = new e(i2);
            eVar.lqW = mVar;
            eVar.wWd = this.wWP.wWd;
            eVar.PWh = eWh();
            eVar.hkH = true;
            eVar.wXL = i2 + 1;
            eVar.gE(eVar.lqW.type, eVar.lqW.wVW);
            aVar = eVar;
        }
        aVar.query = this.query;
        aVar.scene = this.scene;
        aVar.PWh = false;
        AppMethodBeat.o(39235);
        return aVar;
    }

    public final int getCount() {
        AppMethodBeat.i(39236);
        if (this.wWP == null || this.wWP.wXb == null) {
            AppMethodBeat.o(39236);
            return 0;
        }
        int size = this.wWP.wXb.size();
        AppMethodBeat.o(39236);
        return size;
    }
}

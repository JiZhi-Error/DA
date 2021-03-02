package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class b extends o {
    private l Bdt = new l() {
        /* class com.tencent.mm.plugin.profile.ui.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(26954);
            if (kVar.resultCode == 0) {
                b.this.mWl = kVar.wXb;
                if (b.this.PWf != null) {
                    b.this.PWf.B(kVar.wTn.query, b.this.mWl.size(), true);
                }
            }
            b.this.clearCache();
            b.this.notifyDataSetChanged();
            AppMethodBeat.o(26954);
        }
    };
    private as contact;
    private MMHandler handler = new MMHandler();
    private List<m> mWl;
    private String query;
    private a wXa;

    public b(n nVar, int i2, as asVar) {
        super(nVar, false, i2);
        AppMethodBeat.i(26955);
        this.contact = asVar;
        AppMethodBeat.o(26955);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(26956);
        d dVar = new d(i2, this.contact);
        bg.aVF();
        ((com.tencent.mm.ui.contact.a.a) dVar).contact = c.aSN().Kn(this.mWl.get(i2).wVX);
        AppMethodBeat.o(26956);
        return dVar;
    }

    public final int getCount() {
        AppMethodBeat.i(26957);
        if (this.mWl == null) {
            AppMethodBeat.o(26957);
            return 0;
        }
        int size = this.mWl.size();
        AppMethodBeat.o(26957);
        return size;
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(26958);
        this.query = str;
        j jVar = new j();
        jVar.query = str;
        jVar.handler = this.handler;
        jVar.wWZ = this.Bdt;
        jVar.wWS = this.contact.field_username;
        jVar.kXb = 7;
        this.wXa = ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(2, jVar);
        AppMethodBeat.o(26958);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void clearData() {
        AppMethodBeat.i(26959);
        this.query = null;
        if (this.wXa != null) {
            ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
        }
        AppMethodBeat.o(26959);
    }
}

package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a extends q implements l {
    as contact;
    MMHandler handler = new MMHandler(Looper.getMainLooper());
    private List<m> mWl;

    public a(n nVar, int i2, as asVar) {
        super(nVar, (List<String>) new ArrayList(), true, false, i2);
        AppMethodBeat.i(26950);
        this.contact = asVar;
        AppMethodBeat.o(26950);
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.a$a  reason: collision with other inner class name */
    static class C1583a implements Comparator<m> {
        private C1583a() {
        }

        /* synthetic */ C1583a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(m mVar, m mVar2) {
            m mVar3 = mVar;
            m mVar4 = mVar2;
            if (mVar4.timestamp > mVar3.timestamp) {
                return 1;
            }
            if (mVar4.timestamp < mVar3.timestamp) {
                return -1;
            }
            return 0;
        }
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(26951);
        d dVar = new d(i2, this.contact);
        bg.aVF();
        ((com.tencent.mm.ui.contact.a.a) dVar).contact = c.aSN().Kn(this.mWl.get(i2).wVX);
        AppMethodBeat.o(26951);
        return dVar;
    }

    public final int getCount() {
        AppMethodBeat.i(26952);
        if (this.mWl == null) {
            AppMethodBeat.o(26952);
            return 0;
        }
        int size = this.mWl.size();
        AppMethodBeat.o(26952);
        return size;
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(26953);
        if (kVar.resultCode == 0) {
            this.mWl = kVar.wXb;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(26953);
    }
}

package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;

public final class d extends m {
    public ah xbi;
    public CharSequence xcC;
    private a xcD = new a();

    public d(int i2) {
        super(i2);
        AppMethodBeat.i(112060);
        AppMethodBeat.o(112060);
    }

    public class a extends m.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.m.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112059);
            d dVar = (d) aVar2;
            m.a aVar3 = (m.a) aVar;
            n.q(aVar3.lrc, d.this.wXK);
            if (Util.isNullOrNil(dVar.lqW.talker)) {
                a.b.c(aVar3.gvv, dVar.lqW.wVX);
            } else {
                a.b.c(aVar3.gvv, dVar.lqW.talker);
            }
            n.a(dVar.xcC, aVar3.gvw);
            n.a(dVar.hXr, aVar3.gBb);
            n.a(dVar.xdx, aVar3.timeTV);
            AppMethodBeat.o(112059);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final a.b axc() {
        return this.xcD;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        String str;
        AppMethodBeat.i(112061);
        super.a(context, aVar, objArr);
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.lqW.talker);
        if (Kn == null) {
            str = com.tencent.mm.plugin.fts.a.d.arL(this.lqW.wVX);
        } else if (!Util.isNullOrNil(Kn.field_conRemark)) {
            str = Kn.field_conRemark;
        } else if (this.xbi != null) {
            str = this.xbi.getDisplayName(this.lqW.talker);
            if (Util.isNullOrNil(str)) {
                str = Kn.field_nickname;
            }
        } else {
            str = Kn.field_nickname;
        }
        if (!Util.isNullOrNil(str)) {
            this.xcC = com.tencent.mm.pluginsdk.ui.span.l.d(context, str, (float) b.c.wZX);
        }
        AppMethodBeat.o(112061);
    }
}

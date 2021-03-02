package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends m {
    private a xcY = new a();
    CharSequence xcZ;

    public g(int i2) {
        super(i2);
        AppMethodBeat.i(112072);
        AppMethodBeat.o(112072);
    }

    public class a extends m.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.m.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112070);
            View inflate = LayoutInflater.from(context).inflate(R.layout.anr, viewGroup, false);
            m.a aVar = g.this.xdz;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.gvw = (TextView) inflate.findViewById(R.id.fzg);
            aVar.gBb = (TextView) inflate.findViewById(R.id.fn8);
            aVar.lrc = inflate.findViewById(R.id.brt);
            aVar.timeTV = (TextView) inflate.findViewById(R.id.in3);
            aVar.gvv.getLayoutParams().width = com.tencent.mm.cb.a.aG(context, R.dimen.jv);
            aVar.gvv.getLayoutParams().height = com.tencent.mm.cb.a.aG(context, R.dimen.jv);
            inflate.setTag(aVar);
            AppMethodBeat.o(112070);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.m.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112071);
            g gVar = (g) aVar2;
            m.a aVar3 = (m.a) aVar;
            n.q(aVar3.lrc, g.this.wXK);
            if (Util.isNullOrNil(gVar.lqW.talker)) {
                a.b.c(aVar3.gvv, gVar.lqW.wVX);
            } else {
                a.b.c(aVar3.gvv, gVar.lqW.talker);
            }
            n.a(gVar.xcZ, aVar3.gvw);
            n.a(gVar.hXr, aVar3.gBb);
            n.a(gVar.xdx, aVar3.timeTV);
            AppMethodBeat.o(112071);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final a.b axc() {
        return this.xcY;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112073);
        super.a(context, aVar, objArr);
        String arL = d.arL(this.lqW.talker);
        if (Util.isNullOrNil(arL)) {
            arL = d.arL(this.lqW.wVX);
        }
        this.xcZ = l.d(context, arL, (float) b.c.wZX);
        AppMethodBeat.o(112073);
    }
}

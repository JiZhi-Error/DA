package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m;

public final class p extends m {
    public int dDG;
    public m xcP;
    private a xdG = new a();

    public p(int i2) {
        super(i2);
        AppMethodBeat.i(112112);
        AppMethodBeat.o(112112);
    }

    public class a extends m.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.m.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112110);
            View inflate = LayoutInflater.from(context).inflate(R.layout.anr, viewGroup, false);
            m.a aVar = p.this.xdz;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.gvw = (TextView) inflate.findViewById(R.id.fzg);
            aVar.gBb = (TextView) inflate.findViewById(R.id.fn8);
            aVar.lrc = inflate.findViewById(R.id.brt);
            aVar.timeTV = (TextView) inflate.findViewById(R.id.in3);
            aVar.gvv.getLayoutParams().width = com.tencent.mm.cb.a.aG(context, R.dimen.jv);
            aVar.gvv.getLayoutParams().height = com.tencent.mm.cb.a.aG(context, R.dimen.jv);
            inflate.setTag(aVar);
            AppMethodBeat.o(112110);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.m.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235404);
            boolean a2 = ((n) g.ah(n.class)).getItemClickHandler(p.this.qcr).a(context, view, aVar);
            AppMethodBeat.o(235404);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final a.b axc() {
        return this.xdG;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.m
    public final int dOM() {
        if (this.xdw < 2) {
            return 0;
        }
        return 2;
    }
}

package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence xcp;
    private b xcq = new b();
    private C1381a xcr = new C1381a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112052);
            View inflate = LayoutInflater.from(context).inflate(R.layout.anv, viewGroup, false);
            C1381a aVar = new C1381a();
            aVar.nnL = (ImageView) inflate.findViewById(R.id.dtx);
            aVar.xcs = (TextView) inflate.findViewById(R.id.ior);
            aVar.contentView = inflate.findViewById(R.id.hee);
            inflate.setTag(aVar);
            AppMethodBeat.o(112052);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112053);
            C1381a aVar3 = (C1381a) aVar;
            n.r(aVar3.contentView, a.this.wXK);
            n.a(a.this.xcp, aVar3.xcs);
            aVar3.nnL.setImageResource(R.raw.search_add_icon_green);
            AppMethodBeat.o(112053);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.a$a  reason: collision with other inner class name */
    public class C1381a extends a.AbstractC1374a {
        public View contentView;
        public ImageView nnL;
        public TextView xcs;

        public C1381a() {
            super();
        }
    }

    public a(int i2) {
        super(7, i2);
        AppMethodBeat.i(112054);
        AppMethodBeat.o(112054);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112055);
        this.xcp = f.a(context.getResources().getString(R.string.djb), "", e.c(this.wWd.wWB, this.wWd.wWB)).wWu;
        AppMethodBeat.o(112055);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xcq;
    }
}

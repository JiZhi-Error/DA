package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;

public final class l extends com.tencent.mm.plugin.fts.a.d.a.a {
    CharSequence xds;
    private a.b xdt = new b();
    a.AbstractC1374a xdu = new a();

    public l(int i2) {
        super(11, i2);
        AppMethodBeat.i(112095);
        AppMethodBeat.o(112095);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112093);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ane, viewGroup, false);
            a aVar = (a) l.this.xdu;
            aVar.xcX = (TextView) inflate.findViewById(R.id.dy9);
            aVar.xcK = inflate.findViewById(R.id.g8b);
            inflate.setTag(aVar);
            AppMethodBeat.o(112093);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112094);
            a aVar3 = (a) aVar;
            n.a(l.this.xds, aVar3.xcX);
            if (l.this.position == 0) {
                aVar3.xcK.setVisibility(8);
                AppMethodBeat.o(112094);
                return;
            }
            aVar3.xcK.setVisibility(0);
            AppMethodBeat.o(112094);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class a extends a.AbstractC1374a {
        public View xcK;
        public TextView xcX;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdt;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112096);
        this.xds = f.a(context.getString(R.string.gfv), context.getString(R.string.gfu), TextUtils.ellipsize(this.wWd.wWB, b.c.wZY, 400.0f, TextUtils.TruncateAt.MIDDLE).toString());
        AppMethodBeat.o(112096);
    }
}

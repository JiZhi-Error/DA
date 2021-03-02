package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;

public final class i extends a {
    private b QaI = new b();
    a.C2110a QaJ = new a();
    private CharSequence xds;

    public i(int i2) {
        super(6, i2);
        AppMethodBeat.i(102963);
        AppMethodBeat.o(102963);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(102961);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq3, viewGroup, false);
            a aVar = (a) i.this.QaJ;
            aVar.xcX = (TextView) inflate.findViewById(R.id.dy9);
            inflate.setTag(aVar);
            AppMethodBeat.o(102961);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102962);
            n.a(i.this.xds, ((a) aVar).xcX);
            AppMethodBeat.o(102962);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public TextView xcX;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        AppMethodBeat.i(102964);
        this.xds = f.a(context.getString(R.string.gfv), context.getString(R.string.gfu), e.c(this.query, this.query)).wWu;
        AppMethodBeat.o(102964);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.QaI;
    }
}

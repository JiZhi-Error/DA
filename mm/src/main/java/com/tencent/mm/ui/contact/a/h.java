package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;

public final class h extends a {
    private b QaF = new b();
    a QaG = new a();
    public String header;

    public h(int i2) {
        super(0, i2);
        AppMethodBeat.i(102960);
        AppMethodBeat.o(102960);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(102958);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq2, viewGroup, false);
            a aVar = h.this.QaG;
            aVar.qqq = (TextView) inflate.findViewById(R.id.dp0);
            inflate.setTag(aVar);
            if (h.this.VlU) {
                View findViewById = inflate.findViewById(R.id.jzt);
                if (findViewById != null) {
                    findViewById.setBackgroundResource(R.color.w);
                }
                aVar.qqq.setTextColor(aVar.qqq.getContext().getResources().getColor(R.color.BW_100_Alpha_0_5));
            }
            AppMethodBeat.o(102958);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102959);
            n.b(((h) aVar2).header, ((a) aVar).qqq);
            AppMethodBeat.o(102959);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public TextView qqq;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.QaF;
    }
}

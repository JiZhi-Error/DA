package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class k extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String header;
    private b xdp = new b();
    private a xdq = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112089);
            View inflate = LayoutInflater.from(context).inflate(R.layout.and, viewGroup, false);
            a aVar = (a) k.this.dPz();
            aVar.qqq = (TextView) inflate.findViewById(R.id.dp0);
            aVar.xcK = inflate.findViewById(R.id.g8b);
            aVar.contentView = inflate.findViewById(R.id.hee);
            inflate.setTag(aVar);
            AppMethodBeat.o(112089);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112090);
            a aVar3 = (a) aVar;
            n.b(k.this.header, aVar3.qqq);
            if (k.this.position == 0) {
                aVar3.xcK.setVisibility(8);
            } else {
                aVar3.xcK.setVisibility(0);
            }
            n.s(aVar3.contentView, k.this.wXK);
            AppMethodBeat.o(112090);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class a extends a.AbstractC1374a {
        public View contentView;
        public TextView qqq;
        public View xcK;

        public a() {
            super();
        }
    }

    public k(int i2) {
        super(0, i2);
        AppMethodBeat.i(112091);
        AppMethodBeat.o(112091);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112092);
        this.header = Util.nullAs(n.Nu(this.rjr), "");
        Log.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", this.header);
        AppMethodBeat.o(112092);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public a.b axc() {
        return this.xdp;
    }

    public a.AbstractC1374a dPz() {
        return this.xdq;
    }
}

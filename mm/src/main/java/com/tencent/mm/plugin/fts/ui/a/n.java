package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class n extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String jCp;
    private b xdB = new b();
    private a xdC = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112102);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ans, viewGroup, false);
            a aVar = new a();
            aVar.xcs = (TextView) inflate.findViewById(R.id.ior);
            aVar.nnL = (ImageView) inflate.findViewById(R.id.dtx);
            aVar.contentView = inflate.findViewById(R.id.hee);
            inflate.setTag(aVar);
            AppMethodBeat.o(112102);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112103);
            a aVar3 = (a) aVar;
            com.tencent.mm.plugin.fts.ui.n.r(aVar3.contentView, n.this.wXK);
            aVar3.xcs.setText(((n) aVar2).jCp);
            aVar3.nnL.setImageResource(R.raw.fts_more_button_icon);
            AppMethodBeat.o(112103);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235403);
            Intent intent = new Intent();
            intent.putExtra("detail_query", n.this.wWd.wWB);
            intent.putExtra("detail_type", n.this.rjr);
            intent.putExtra("Search_Scene", n.this.mve);
            d.d(context, ".ui.FTSDetailUI", intent);
            AppMethodBeat.o(235403);
            return true;
        }
    }

    public class a extends a.AbstractC1374a {
        public View contentView;
        public ImageView nnL;
        public TextView xcs;

        public a() {
            super();
        }
    }

    public n(int i2) {
        super(8, i2);
        AppMethodBeat.i(112105);
        AppMethodBeat.o(112105);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112106);
        String Nu = com.tencent.mm.plugin.fts.ui.n.Nu(this.rjr);
        if (Nu == null) {
            this.jCp = "";
        } else {
            this.jCp = context.getResources().getString(R.string.gfp, Nu);
        }
        Log.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", this.jCp);
        AppMethodBeat.o(112106);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public a.b axc() {
        return this.xdB;
    }
}

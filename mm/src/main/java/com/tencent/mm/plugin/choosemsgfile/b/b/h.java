package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class h extends d {
    private String qnH;
    private String qnS;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.plugin.choosemsgfile.b.b.a] */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.d
    public final /* bridge */ /* synthetic */ void a(m mVar, int i2, a aVar) {
        AppMethodBeat.i(162330);
        a(mVar, i2, aVar);
        AppMethodBeat.o(162330);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.d
    public final String aWd() {
        AppMethodBeat.i(123276);
        if (this.qnH == null) {
            o.bhj();
            this.qnH = t.Qx(this.qnv.field_imgPath);
        }
        String str = this.qnH;
        AppMethodBeat.o(123276);
        return str;
    }

    public h(g gVar, ca caVar) {
        super(gVar, caVar);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.d
    public final void a(m mVar, int i2, a aVar) {
        AppMethodBeat.i(162329);
        super.a(mVar, i2, aVar);
        mVar.qof.setVisibility(0);
        mVar.qog.setVisibility(0);
        TextView textView = mVar.qog;
        if (this.qnS == null) {
            this.qnS = Util.formatSecToMin(u.QN(this.qnv.field_imgPath).iFw);
        }
        textView.setText(Util.nullAs(this.qnS, ""));
        AppMethodBeat.o(162329);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int getType() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final void a(View view, a aVar) {
        AppMethodBeat.i(123278);
        c.a(this.qnE.cyC().getContext(), view, aVar);
        AppMethodBeat.o(123278);
    }
}

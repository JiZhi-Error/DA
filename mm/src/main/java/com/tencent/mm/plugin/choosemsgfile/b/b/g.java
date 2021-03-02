package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public class g extends d {
    private String qnH;

    public g(com.tencent.mm.plugin.choosemsgfile.b.c.g gVar, ca caVar) {
        super(gVar, caVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.d
    public String aWd() {
        AppMethodBeat.i(123274);
        if (this.qnH == null) {
            this.qnH = q.bcR().d(this.qnv.field_imgPath, false, false);
            if (!Util.isNullOrNil(this.qnH) && !this.qnH.endsWith("hd") && s.YS(this.qnH + "hd")) {
                this.qnH += "hd";
            }
        }
        String str = this.qnH;
        AppMethodBeat.o(123274);
        return str;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int getType() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final void a(View view, a aVar) {
        AppMethodBeat.i(123275);
        c.a(this.qnE.cyC().getContext(), view, aVar);
        AppMethodBeat.o(123275);
    }
}

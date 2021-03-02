package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.ca;

public final class b extends g {
    private k.b qnG;
    private String qnH;

    private k.b cyz() {
        AppMethodBeat.i(123259);
        if (this.qnG == null) {
            this.qnG = k.b.HD(this.qnv.field_content);
        }
        k.b bVar = this.qnG;
        AppMethodBeat.o(123259);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final String getFileExt() {
        AppMethodBeat.i(123260);
        if (cyz() != null) {
            String str = cyz().iwJ;
            AppMethodBeat.o(123260);
            return str;
        }
        AppMethodBeat.o(123260);
        return "";
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final String getFileName() {
        AppMethodBeat.i(123261);
        if (cyz() != null) {
            String str = cyz().title;
            AppMethodBeat.o(123261);
            return str;
        }
        AppMethodBeat.o(123261);
        return "";
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int cyt() {
        AppMethodBeat.i(123262);
        if (cyz() != null) {
            int i2 = cyz().iwI;
            AppMethodBeat.o(123262);
            return i2;
        }
        AppMethodBeat.o(123262);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.d, com.tencent.mm.plugin.choosemsgfile.b.b.g
    public final String aWd() {
        c bdx;
        AppMethodBeat.i(123263);
        if (!(this.qnH != null || cyz() == null || cyz().dCK == null || cyz().dCK.length() <= 0 || (bdx = a.cgO().bdx(cyz().dCK)) == null)) {
            this.qnH = bdx.field_fileFullPath;
        }
        if (this.qnH != null) {
            String str = this.qnH;
            AppMethodBeat.o(123263);
            return str;
        }
        AppMethodBeat.o(123263);
        return "";
    }

    public b(g gVar, ca caVar) {
        super(gVar, caVar);
    }
}

package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.facedetect.b.i;
import com.tencent.mm.protocal.l;

/* access modifiers changed from: package-private */
public final class h extends o {
    i.a sPF = new i.a();
    i.b sPG = new i.b();

    h() {
        AppMethodBeat.i(103590);
        AppMethodBeat.o(103590);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 733;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.sPG;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.sPF;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}

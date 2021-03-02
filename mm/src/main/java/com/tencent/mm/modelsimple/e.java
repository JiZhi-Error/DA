package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.z;

final class e extends o {
    private final z.a jiY = new z.a();
    private final z.b jiZ = new z.b();

    e() {
        AppMethodBeat.i(150912);
        AppMethodBeat.o(150912);
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.jiY;
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.jiZ;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 26;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/sendcard";
    }
}

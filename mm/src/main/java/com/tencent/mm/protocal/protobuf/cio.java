package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cio extends a {
    public String appId;
    public String path;
    public String query;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192787);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.path != null) {
                aVar.e(2, this.path);
            }
            if (this.query != null) {
                aVar.e(3, this.query);
            }
            AppMethodBeat.o(192787);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(2, this.path);
            }
            if (this.query != null) {
                f2 += g.a.a.b.b.a.f(3, this.query);
            }
            AppMethodBeat.o(192787);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192787);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cio cio = (cio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cio.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(192787);
                    return 0;
                case 2:
                    cio.path = aVar3.UbS.readString();
                    AppMethodBeat.o(192787);
                    return 0;
                case 3:
                    cio.query = aVar3.UbS.readString();
                    AppMethodBeat.o(192787);
                    return 0;
                default:
                    AppMethodBeat.o(192787);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192787);
            return -1;
        }
    }
}
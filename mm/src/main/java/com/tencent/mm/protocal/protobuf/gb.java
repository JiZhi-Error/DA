package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class gb extends a {
    public long KJQ;
    public int KJR;
    public int KJS;
    public int Scene;
    public String SessionId;
    public String Url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6390);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            aVar.bb(2, this.KJQ);
            aVar.aM(3, this.KJR);
            if (this.SessionId != null) {
                aVar.e(4, this.SessionId);
            }
            aVar.aM(5, this.Scene);
            aVar.aM(6, this.KJS);
            AppMethodBeat.o(6390);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Url != null ? g.a.a.b.b.a.f(1, this.Url) + 0 : 0) + g.a.a.b.b.a.r(2, this.KJQ) + g.a.a.b.b.a.bu(3, this.KJR);
            if (this.SessionId != null) {
                f2 += g.a.a.b.b.a.f(4, this.SessionId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Scene) + g.a.a.b.b.a.bu(6, this.KJS);
            AppMethodBeat.o(6390);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6390);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gb gbVar = (gb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gbVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(6390);
                    return 0;
                case 2:
                    gbVar.KJQ = aVar3.UbS.zl();
                    AppMethodBeat.o(6390);
                    return 0;
                case 3:
                    gbVar.KJR = aVar3.UbS.zi();
                    AppMethodBeat.o(6390);
                    return 0;
                case 4:
                    gbVar.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(6390);
                    return 0;
                case 5:
                    gbVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(6390);
                    return 0;
                case 6:
                    gbVar.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(6390);
                    return 0;
                default:
                    AppMethodBeat.o(6390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6390);
            return -1;
        }
    }
}

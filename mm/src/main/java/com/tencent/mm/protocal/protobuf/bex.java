package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bex extends a {
    public int CreateTime;
    public int KCC;
    public String KHi;
    public String KHk;
    public String LOD;
    public String UserName;
    public String xNU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149139);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHi != null) {
                aVar.e(1, this.KHi);
            }
            aVar.aM(2, this.CreateTime);
            aVar.aM(3, this.KCC);
            if (this.KHk != null) {
                aVar.e(4, this.KHk);
            }
            if (this.LOD != null) {
                aVar.e(5, this.LOD);
            }
            if (this.UserName != null) {
                aVar.e(6, this.UserName);
            }
            if (this.xNU != null) {
                aVar.e(7, this.xNU);
            }
            AppMethodBeat.o(149139);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KHi != null ? g.a.a.b.b.a.f(1, this.KHi) + 0 : 0) + g.a.a.b.b.a.bu(2, this.CreateTime) + g.a.a.b.b.a.bu(3, this.KCC);
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(4, this.KHk);
            }
            if (this.LOD != null) {
                f2 += g.a.a.b.b.a.f(5, this.LOD);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(6, this.UserName);
            }
            if (this.xNU != null) {
                f2 += g.a.a.b.b.a.f(7, this.xNU);
            }
            AppMethodBeat.o(149139);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149139);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bex bex = (bex) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bex.KHi = aVar3.UbS.readString();
                    AppMethodBeat.o(149139);
                    return 0;
                case 2:
                    bex.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(149139);
                    return 0;
                case 3:
                    bex.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(149139);
                    return 0;
                case 4:
                    bex.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(149139);
                    return 0;
                case 5:
                    bex.LOD = aVar3.UbS.readString();
                    AppMethodBeat.o(149139);
                    return 0;
                case 6:
                    bex.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(149139);
                    return 0;
                case 7:
                    bex.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(149139);
                    return 0;
                default:
                    AppMethodBeat.o(149139);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149139);
            return -1;
        }
    }
}

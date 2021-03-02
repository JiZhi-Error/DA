package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cye extends a {
    public boolean LVl;
    public boolean LVm;
    public String MbW;
    public int MbZ;
    public int Mel;
    public String dNI;
    public String md5;
    public String url;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123633);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.MbW != null) {
                aVar.e(2, this.MbW);
            }
            aVar.aM(3, this.MbZ);
            aVar.aM(4, this.version);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.md5 != null) {
                aVar.e(6, this.md5);
            }
            aVar.cc(20, this.LVl);
            aVar.cc(21, this.LVm);
            aVar.aM(22, this.Mel);
            AppMethodBeat.o(123633);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.MbW != null) {
                f2 += g.a.a.b.b.a.f(2, this.MbW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MbZ) + g.a.a.b.b.a.bu(4, this.version);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(5, this.url);
            }
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(6, this.md5);
            }
            int fS = bu + g.a.a.b.b.a.fS(20) + 1 + g.a.a.b.b.a.fS(21) + 1 + g.a.a.b.b.a.bu(22, this.Mel);
            AppMethodBeat.o(123633);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123633);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cye cye = (cye) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cye.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123633);
                    return 0;
                case 2:
                    cye.MbW = aVar3.UbS.readString();
                    AppMethodBeat.o(123633);
                    return 0;
                case 3:
                    cye.MbZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123633);
                    return 0;
                case 4:
                    cye.version = aVar3.UbS.zi();
                    AppMethodBeat.o(123633);
                    return 0;
                case 5:
                    cye.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123633);
                    return 0;
                case 6:
                    cye.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(123633);
                    return 0;
                case 20:
                    cye.LVl = aVar3.UbS.yZ();
                    AppMethodBeat.o(123633);
                    return 0;
                case 21:
                    cye.LVm = aVar3.UbS.yZ();
                    AppMethodBeat.o(123633);
                    return 0;
                case 22:
                    cye.Mel = aVar3.UbS.zi();
                    AppMethodBeat.o(123633);
                    return 0;
                default:
                    AppMethodBeat.o(123633);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123633);
            return -1;
        }
    }
}

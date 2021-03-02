package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ddb extends a {
    public String HFD;
    public String LZw;
    public String MIh;
    public int MeU;
    public String yUB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LZw != null) {
                aVar.e(1, this.LZw);
            }
            if (this.MIh != null) {
                aVar.e(2, this.MIh);
            }
            if (this.HFD != null) {
                aVar.e(3, this.HFD);
            }
            if (this.yUB != null) {
                aVar.e(4, this.yUB);
            }
            aVar.aM(5, this.MeU);
            AppMethodBeat.o(72549);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LZw != null ? g.a.a.b.b.a.f(1, this.LZw) + 0 : 0;
            if (this.MIh != null) {
                f2 += g.a.a.b.b.a.f(2, this.MIh);
            }
            if (this.HFD != null) {
                f2 += g.a.a.b.b.a.f(3, this.HFD);
            }
            if (this.yUB != null) {
                f2 += g.a.a.b.b.a.f(4, this.yUB);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MeU);
            AppMethodBeat.o(72549);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddb ddb = (ddb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddb.LZw = aVar3.UbS.readString();
                    AppMethodBeat.o(72549);
                    return 0;
                case 2:
                    ddb.MIh = aVar3.UbS.readString();
                    AppMethodBeat.o(72549);
                    return 0;
                case 3:
                    ddb.HFD = aVar3.UbS.readString();
                    AppMethodBeat.o(72549);
                    return 0;
                case 4:
                    ddb.yUB = aVar3.UbS.readString();
                    AppMethodBeat.o(72549);
                    return 0;
                case 5:
                    ddb.MeU = aVar3.UbS.zi();
                    AppMethodBeat.o(72549);
                    return 0;
                default:
                    AppMethodBeat.o(72549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72549);
            return -1;
        }
    }
}

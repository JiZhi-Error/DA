package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ecj extends a {
    public long Asv;
    public b NcA;
    public String id;
    public int type;
    public String wVT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209817);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.wVT != null) {
                aVar.e(2, this.wVT);
            }
            aVar.bb(3, this.Asv);
            aVar.aM(4, this.type);
            if (this.NcA != null) {
                aVar.c(5, this.NcA);
            }
            AppMethodBeat.o(209817);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.wVT != null) {
                f2 += g.a.a.b.b.a.f(2, this.wVT);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.Asv) + g.a.a.b.b.a.bu(4, this.type);
            if (this.NcA != null) {
                r += g.a.a.b.b.a.b(5, this.NcA);
            }
            AppMethodBeat.o(209817);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209817);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecj ecj = (ecj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecj.id = aVar3.UbS.readString();
                    AppMethodBeat.o(209817);
                    return 0;
                case 2:
                    ecj.wVT = aVar3.UbS.readString();
                    AppMethodBeat.o(209817);
                    return 0;
                case 3:
                    ecj.Asv = aVar3.UbS.zl();
                    AppMethodBeat.o(209817);
                    return 0;
                case 4:
                    ecj.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209817);
                    return 0;
                case 5:
                    ecj.NcA = aVar3.UbS.hPo();
                    AppMethodBeat.o(209817);
                    return 0;
                default:
                    AppMethodBeat.o(209817);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209817);
            return -1;
        }
    }
}

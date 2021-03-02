package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class czh extends a {
    public String MEA;
    public int MEB;
    public int MEC;
    public long createTime;
    public String dRL;
    public String iBd;
    public long oNJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225979);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dRL != null) {
                aVar.e(1, this.dRL);
            }
            if (this.MEA != null) {
                aVar.e(2, this.MEA);
            }
            if (this.iBd != null) {
                aVar.e(3, this.iBd);
            }
            aVar.bb(4, this.createTime);
            aVar.aM(5, this.MEB);
            aVar.bb(6, this.oNJ);
            aVar.aM(7, this.MEC);
            AppMethodBeat.o(225979);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dRL != null ? g.a.a.b.b.a.f(1, this.dRL) + 0 : 0;
            if (this.MEA != null) {
                f2 += g.a.a.b.b.a.f(2, this.MEA);
            }
            if (this.iBd != null) {
                f2 += g.a.a.b.b.a.f(3, this.iBd);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.createTime) + g.a.a.b.b.a.bu(5, this.MEB) + g.a.a.b.b.a.r(6, this.oNJ) + g.a.a.b.b.a.bu(7, this.MEC);
            AppMethodBeat.o(225979);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225979);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czh czh = (czh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czh.dRL = aVar3.UbS.readString();
                    AppMethodBeat.o(225979);
                    return 0;
                case 2:
                    czh.MEA = aVar3.UbS.readString();
                    AppMethodBeat.o(225979);
                    return 0;
                case 3:
                    czh.iBd = aVar3.UbS.readString();
                    AppMethodBeat.o(225979);
                    return 0;
                case 4:
                    czh.createTime = aVar3.UbS.zl();
                    AppMethodBeat.o(225979);
                    return 0;
                case 5:
                    czh.MEB = aVar3.UbS.zi();
                    AppMethodBeat.o(225979);
                    return 0;
                case 6:
                    czh.oNJ = aVar3.UbS.zl();
                    AppMethodBeat.o(225979);
                    return 0;
                case 7:
                    czh.MEC = aVar3.UbS.zi();
                    AppMethodBeat.o(225979);
                    return 0;
                default:
                    AppMethodBeat.o(225979);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225979);
            return -1;
        }
    }
}

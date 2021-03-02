package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class dna extends a {
    public String KSV;
    public long MQr;
    public int MQs;
    public boolean MQt;
    public boolean MQu;
    public int MQv;
    public boolean MQw;
    public int xNc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124546);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KSV != null) {
                aVar.e(1, this.KSV);
            }
            aVar.bb(2, this.MQr);
            aVar.aM(3, this.MQs);
            aVar.cc(4, this.MQt);
            aVar.cc(5, this.MQu);
            aVar.aM(6, this.MQv);
            aVar.aM(7, this.xNc);
            aVar.cc(8, this.MQw);
            AppMethodBeat.o(124546);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KSV != null ? g.a.a.b.b.a.f(1, this.KSV) + 0 : 0) + g.a.a.b.b.a.r(2, this.MQr) + g.a.a.b.b.a.bu(3, this.MQs) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.MQv) + g.a.a.b.b.a.bu(7, this.xNc) + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(124546);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124546);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dna dna = (dna) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dna.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(124546);
                    return 0;
                case 2:
                    dna.MQr = aVar3.UbS.zl();
                    AppMethodBeat.o(124546);
                    return 0;
                case 3:
                    dna.MQs = aVar3.UbS.zi();
                    AppMethodBeat.o(124546);
                    return 0;
                case 4:
                    dna.MQt = aVar3.UbS.yZ();
                    AppMethodBeat.o(124546);
                    return 0;
                case 5:
                    dna.MQu = aVar3.UbS.yZ();
                    AppMethodBeat.o(124546);
                    return 0;
                case 6:
                    dna.MQv = aVar3.UbS.zi();
                    AppMethodBeat.o(124546);
                    return 0;
                case 7:
                    dna.xNc = aVar3.UbS.zi();
                    AppMethodBeat.o(124546);
                    return 0;
                case 8:
                    dna.MQw = aVar3.UbS.yZ();
                    AppMethodBeat.o(124546);
                    return 0;
                default:
                    AppMethodBeat.o(124546);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124546);
            return -1;
        }
    }
}

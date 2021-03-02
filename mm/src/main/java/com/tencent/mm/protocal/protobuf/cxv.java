package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cxv extends a {
    public String APx;
    public LinkedList<cxv> Iow = new LinkedList<>();
    public String MCI;
    public LinkedList<cxu> MCJ = new LinkedList<>();
    public int MCK;
    public int MCL;
    public int qwL;
    public String type;

    public cxv() {
        AppMethodBeat.i(117537);
        AppMethodBeat.o(117537);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117538);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MCI != null) {
                aVar.e(1, this.MCI);
            }
            if (this.APx != null) {
                aVar.e(2, this.APx);
            }
            aVar.e(3, 8, this.MCJ);
            aVar.aM(4, this.qwL);
            if (this.type != null) {
                aVar.e(5, this.type);
            }
            aVar.e(6, 8, this.Iow);
            aVar.aM(7, this.MCK);
            aVar.aM(8, this.MCL);
            AppMethodBeat.o(117538);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MCI != null ? g.a.a.b.b.a.f(1, this.MCI) + 0 : 0;
            if (this.APx != null) {
                f2 += g.a.a.b.b.a.f(2, this.APx);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.MCJ) + g.a.a.b.b.a.bu(4, this.qwL);
            if (this.type != null) {
                c2 += g.a.a.b.b.a.f(5, this.type);
            }
            int c3 = c2 + g.a.a.a.c(6, 8, this.Iow) + g.a.a.b.b.a.bu(7, this.MCK) + g.a.a.b.b.a.bu(8, this.MCL);
            AppMethodBeat.o(117538);
            return c3;
        } else if (i2 == 2) {
            this.MCJ.clear();
            this.Iow.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117538);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxv cxv = (cxv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxv.MCI = aVar3.UbS.readString();
                    AppMethodBeat.o(117538);
                    return 0;
                case 2:
                    cxv.APx = aVar3.UbS.readString();
                    AppMethodBeat.o(117538);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cxu cxu = new cxu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cxu.populateBuilderWithField(aVar4, cxu, a.getNextFieldNumber(aVar4))) {
                        }
                        cxv.MCJ.add(cxu);
                    }
                    AppMethodBeat.o(117538);
                    return 0;
                case 4:
                    cxv.qwL = aVar3.UbS.zi();
                    AppMethodBeat.o(117538);
                    return 0;
                case 5:
                    cxv.type = aVar3.UbS.readString();
                    AppMethodBeat.o(117538);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cxv cxv2 = new cxv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cxv2.populateBuilderWithField(aVar5, cxv2, a.getNextFieldNumber(aVar5))) {
                        }
                        cxv.Iow.add(cxv2);
                    }
                    AppMethodBeat.o(117538);
                    return 0;
                case 7:
                    cxv.MCK = aVar3.UbS.zi();
                    AppMethodBeat.o(117538);
                    return 0;
                case 8:
                    cxv.MCL = aVar3.UbS.zi();
                    AppMethodBeat.o(117538);
                    return 0;
                default:
                    AppMethodBeat.o(117538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117538);
            return -1;
        }
    }
}

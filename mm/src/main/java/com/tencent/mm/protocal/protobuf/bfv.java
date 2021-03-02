package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfv extends a {
    public exc LPr;
    public ewz LPs;
    public exb LPt;
    public boolean LPu;
    public boolean LPv;
    public String LPw;
    public String LPx;
    public int LPy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200199);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LPr != null) {
                aVar.ni(1, this.LPr.computeSize());
                this.LPr.writeFields(aVar);
            }
            if (this.LPs != null) {
                aVar.ni(2, this.LPs.computeSize());
                this.LPs.writeFields(aVar);
            }
            if (this.LPt != null) {
                aVar.ni(3, this.LPt.computeSize());
                this.LPt.writeFields(aVar);
            }
            aVar.cc(4, this.LPu);
            aVar.cc(5, this.LPv);
            if (this.LPw != null) {
                aVar.e(6, this.LPw);
            }
            if (this.LPx != null) {
                aVar.e(7, this.LPx);
            }
            aVar.aM(99, this.LPy);
            AppMethodBeat.o(200199);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LPr != null ? g.a.a.a.nh(1, this.LPr.computeSize()) + 0 : 0;
            if (this.LPs != null) {
                nh += g.a.a.a.nh(2, this.LPs.computeSize());
            }
            if (this.LPt != null) {
                nh += g.a.a.a.nh(3, this.LPt.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            if (this.LPw != null) {
                fS += g.a.a.b.b.a.f(6, this.LPw);
            }
            if (this.LPx != null) {
                fS += g.a.a.b.b.a.f(7, this.LPx);
            }
            int bu = fS + g.a.a.b.b.a.bu(99, this.LPy);
            AppMethodBeat.o(200199);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200199);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfv bfv = (bfv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        exc exc = new exc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = exc.populateBuilderWithField(aVar4, exc, a.getNextFieldNumber(aVar4))) {
                        }
                        bfv.LPr = exc;
                    }
                    AppMethodBeat.o(200199);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ewz ewz = new ewz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ewz.populateBuilderWithField(aVar5, ewz, a.getNextFieldNumber(aVar5))) {
                        }
                        bfv.LPs = ewz;
                    }
                    AppMethodBeat.o(200199);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        exb exb = new exb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = exb.populateBuilderWithField(aVar6, exb, a.getNextFieldNumber(aVar6))) {
                        }
                        bfv.LPt = exb;
                    }
                    AppMethodBeat.o(200199);
                    return 0;
                case 4:
                    bfv.LPu = aVar3.UbS.yZ();
                    AppMethodBeat.o(200199);
                    return 0;
                case 5:
                    bfv.LPv = aVar3.UbS.yZ();
                    AppMethodBeat.o(200199);
                    return 0;
                case 6:
                    bfv.LPw = aVar3.UbS.readString();
                    AppMethodBeat.o(200199);
                    return 0;
                case 7:
                    bfv.LPx = aVar3.UbS.readString();
                    AppMethodBeat.o(200199);
                    return 0;
                case 99:
                    bfv.LPy = aVar3.UbS.zi();
                    AppMethodBeat.o(200199);
                    return 0;
                default:
                    AppMethodBeat.o(200199);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200199);
            return -1;
        }
    }
}

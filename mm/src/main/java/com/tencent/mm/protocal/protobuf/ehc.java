package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ehc extends a {
    public String CeI;
    public dqe KEP;
    public String KNW;
    public long NgL;
    public int NgM;
    public aib NgN;
    public float size;
    public String text;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91713);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NgL);
            if (this.CeI != null) {
                aVar.e(2, this.CeI);
            }
            if (this.text != null) {
                aVar.e(3, this.text);
            }
            aVar.E(4, this.size);
            if (this.KEP != null) {
                aVar.ni(5, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            aVar.aM(6, this.NgM);
            if (this.KNW != null) {
                aVar.e(7, this.KNW);
            }
            if (this.NgN != null) {
                aVar.ni(8, this.NgN.computeSize());
                this.NgN.writeFields(aVar);
            }
            AppMethodBeat.o(91713);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NgL) + 0;
            if (this.CeI != null) {
                r += g.a.a.b.b.a.f(2, this.CeI);
            }
            if (this.text != null) {
                r += g.a.a.b.b.a.f(3, this.text);
            }
            int fS = r + g.a.a.b.b.a.fS(4) + 4;
            if (this.KEP != null) {
                fS += g.a.a.a.nh(5, this.KEP.computeSize());
            }
            int bu = fS + g.a.a.b.b.a.bu(6, this.NgM);
            if (this.KNW != null) {
                bu += g.a.a.b.b.a.f(7, this.KNW);
            }
            if (this.NgN != null) {
                bu += g.a.a.a.nh(8, this.NgN.computeSize());
            }
            AppMethodBeat.o(91713);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91713);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehc ehc = (ehc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ehc.NgL = aVar3.UbS.zl();
                    AppMethodBeat.o(91713);
                    return 0;
                case 2:
                    ehc.CeI = aVar3.UbS.readString();
                    AppMethodBeat.o(91713);
                    return 0;
                case 3:
                    ehc.text = aVar3.UbS.readString();
                    AppMethodBeat.o(91713);
                    return 0;
                case 4:
                    ehc.size = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(91713);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size2 = awh.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqe.populateBuilderWithField(aVar4, dqe, a.getNextFieldNumber(aVar4))) {
                        }
                        ehc.KEP = dqe;
                    }
                    AppMethodBeat.o(91713);
                    return 0;
                case 6:
                    ehc.NgM = aVar3.UbS.zi();
                    AppMethodBeat.o(91713);
                    return 0;
                case 7:
                    ehc.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91713);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size3 = awh2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        aib aib = new aib();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aib.populateBuilderWithField(aVar5, aib, a.getNextFieldNumber(aVar5))) {
                        }
                        ehc.NgN = aib;
                    }
                    AppMethodBeat.o(91713);
                    return 0;
                default:
                    AppMethodBeat.o(91713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91713);
            return -1;
        }
    }
}

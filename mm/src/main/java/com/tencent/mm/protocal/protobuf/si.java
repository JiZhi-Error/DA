package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class si extends a {
    public dqe KEP;
    public String KNW;
    public ccy KZS;
    public abm KZT;
    public int gTu;
    public int pTI;
    public int state;
    public String text;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91384);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.state);
            if (this.KEP != null) {
                aVar.ni(2, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            aVar.aM(3, this.gTu);
            if (this.KZS != null) {
                aVar.ni(4, this.KZS.computeSize());
                this.KZS.writeFields(aVar);
            }
            if (this.text != null) {
                aVar.e(5, this.text);
            }
            if (this.KNW != null) {
                aVar.e(6, this.KNW);
            }
            aVar.aM(7, this.pTI);
            if (this.KZT != null) {
                aVar.ni(8, this.KZT.computeSize());
                this.KZT.writeFields(aVar);
            }
            AppMethodBeat.o(91384);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.state) + 0;
            if (this.KEP != null) {
                bu += g.a.a.a.nh(2, this.KEP.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.gTu);
            if (this.KZS != null) {
                bu2 += g.a.a.a.nh(4, this.KZS.computeSize());
            }
            if (this.text != null) {
                bu2 += g.a.a.b.b.a.f(5, this.text);
            }
            if (this.KNW != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KNW);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.pTI);
            if (this.KZT != null) {
                bu3 += g.a.a.a.nh(8, this.KZT.computeSize());
            }
            AppMethodBeat.o(91384);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91384);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            si siVar = (si) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    siVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91384);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqe.populateBuilderWithField(aVar4, dqe, a.getNextFieldNumber(aVar4))) {
                        }
                        siVar.KEP = dqe;
                    }
                    AppMethodBeat.o(91384);
                    return 0;
                case 3:
                    siVar.gTu = aVar3.UbS.zi();
                    AppMethodBeat.o(91384);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccy.populateBuilderWithField(aVar5, ccy, a.getNextFieldNumber(aVar5))) {
                        }
                        siVar.KZS = ccy;
                    }
                    AppMethodBeat.o(91384);
                    return 0;
                case 5:
                    siVar.text = aVar3.UbS.readString();
                    AppMethodBeat.o(91384);
                    return 0;
                case 6:
                    siVar.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91384);
                    return 0;
                case 7:
                    siVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(91384);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        abm abm = new abm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = abm.populateBuilderWithField(aVar6, abm, a.getNextFieldNumber(aVar6))) {
                        }
                        siVar.KZT = abm;
                    }
                    AppMethodBeat.o(91384);
                    return 0;
                default:
                    AppMethodBeat.o(91384);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91384);
            return -1;
        }
    }
}

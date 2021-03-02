package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aal extends a implements dyp {
    public int LlE;
    public int LlF;
    public int LlG;
    public LinkedList<eeo> LlH = new LinkedList<>();
    public LinkedList<eeo> LlI = new LinkedList<>();
    public LinkedList<eeo> LlJ = new LinkedList<>();
    public int LlK;
    public int LlL;
    public int LlM;
    public cbi LlN;
    public int Ret;

    public aal() {
        AppMethodBeat.i(143969);
        AppMethodBeat.o(143969);
    }

    @Override // com.tencent.mm.protocal.protobuf.dyp
    public final int getRet() {
        return this.Ret;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143970);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            aVar.aM(2, this.LlE);
            aVar.aM(3, this.LlF);
            aVar.aM(4, this.LlG);
            aVar.e(5, 8, this.LlH);
            aVar.e(6, 8, this.LlI);
            aVar.e(7, 8, this.LlJ);
            aVar.aM(8, this.LlK);
            aVar.aM(9, this.LlL);
            aVar.aM(10, this.LlM);
            if (this.LlN != null) {
                aVar.ni(11, this.LlN.computeSize());
                this.LlN.writeFields(aVar);
            }
            AppMethodBeat.o(143970);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.LlE) + g.a.a.b.b.a.bu(3, this.LlF) + g.a.a.b.b.a.bu(4, this.LlG) + g.a.a.a.c(5, 8, this.LlH) + g.a.a.a.c(6, 8, this.LlI) + g.a.a.a.c(7, 8, this.LlJ) + g.a.a.b.b.a.bu(8, this.LlK) + g.a.a.b.b.a.bu(9, this.LlL) + g.a.a.b.b.a.bu(10, this.LlM);
            if (this.LlN != null) {
                bu += g.a.a.a.nh(11, this.LlN.computeSize());
            }
            AppMethodBeat.o(143970);
            return bu;
        } else if (i2 == 2) {
            this.LlH.clear();
            this.LlI.clear();
            this.LlJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143970);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aal aal = (aal) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aal.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 2:
                    aal.LlE = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 3:
                    aal.LlF = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 4:
                    aal.LlG = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eeo eeo = new eeo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eeo.populateBuilderWithField(aVar4, eeo, a.getNextFieldNumber(aVar4))) {
                        }
                        aal.LlH.add(eeo);
                    }
                    AppMethodBeat.o(143970);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eeo eeo2 = new eeo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eeo2.populateBuilderWithField(aVar5, eeo2, a.getNextFieldNumber(aVar5))) {
                        }
                        aal.LlI.add(eeo2);
                    }
                    AppMethodBeat.o(143970);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eeo eeo3 = new eeo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eeo3.populateBuilderWithField(aVar6, eeo3, a.getNextFieldNumber(aVar6))) {
                        }
                        aal.LlJ.add(eeo3);
                    }
                    AppMethodBeat.o(143970);
                    return 0;
                case 8:
                    aal.LlK = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 9:
                    aal.LlL = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 10:
                    aal.LlM = aVar3.UbS.zi();
                    AppMethodBeat.o(143970);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cbi cbi = new cbi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cbi.populateBuilderWithField(aVar7, cbi, a.getNextFieldNumber(aVar7))) {
                        }
                        aal.LlN = cbi;
                    }
                    AppMethodBeat.o(143970);
                    return 0;
                default:
                    AppMethodBeat.o(143970);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143970);
            return -1;
        }
    }
}

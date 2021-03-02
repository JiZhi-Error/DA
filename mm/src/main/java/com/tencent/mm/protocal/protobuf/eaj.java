package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eaj extends a {
    public int MZH;
    public ebp MZI;
    public dio MZJ;
    public agf MZK;
    public deh MZL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125802);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MZH);
            if (this.MZI != null) {
                aVar.ni(2, this.MZI.computeSize());
                this.MZI.writeFields(aVar);
            }
            if (this.MZJ != null) {
                aVar.ni(3, this.MZJ.computeSize());
                this.MZJ.writeFields(aVar);
            }
            if (this.MZK != null) {
                aVar.ni(4, this.MZK.computeSize());
                this.MZK.writeFields(aVar);
            }
            if (this.MZL != null) {
                aVar.ni(5, this.MZL.computeSize());
                this.MZL.writeFields(aVar);
            }
            AppMethodBeat.o(125802);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MZH) + 0;
            if (this.MZI != null) {
                bu += g.a.a.a.nh(2, this.MZI.computeSize());
            }
            if (this.MZJ != null) {
                bu += g.a.a.a.nh(3, this.MZJ.computeSize());
            }
            if (this.MZK != null) {
                bu += g.a.a.a.nh(4, this.MZK.computeSize());
            }
            if (this.MZL != null) {
                bu += g.a.a.a.nh(5, this.MZL.computeSize());
            }
            AppMethodBeat.o(125802);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125802);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eaj eaj = (eaj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eaj.MZH = aVar3.UbS.zi();
                    AppMethodBeat.o(125802);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ebp ebp = new ebp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ebp.populateBuilderWithField(aVar4, ebp, a.getNextFieldNumber(aVar4))) {
                        }
                        eaj.MZI = ebp;
                    }
                    AppMethodBeat.o(125802);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dio dio = new dio();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dio.populateBuilderWithField(aVar5, dio, a.getNextFieldNumber(aVar5))) {
                        }
                        eaj.MZJ = dio;
                    }
                    AppMethodBeat.o(125802);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        agf agf = new agf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = agf.populateBuilderWithField(aVar6, agf, a.getNextFieldNumber(aVar6))) {
                        }
                        eaj.MZK = agf;
                    }
                    AppMethodBeat.o(125802);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        deh deh = new deh();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = deh.populateBuilderWithField(aVar7, deh, a.getNextFieldNumber(aVar7))) {
                        }
                        eaj.MZL = deh;
                    }
                    AppMethodBeat.o(125802);
                    return 0;
                default:
                    AppMethodBeat.o(125802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125802);
            return -1;
        }
    }
}

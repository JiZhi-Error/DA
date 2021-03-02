package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class doj extends dop {
    public int MRJ;
    public LinkedList<dqi> MRK = new LinkedList<>();
    public dqi MRL;
    public dqi MRM;
    public int Scene;

    public doj() {
        AppMethodBeat.i(148654);
        AppMethodBeat.o(148654);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148655);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MRJ);
            aVar.e(3, 8, this.MRK);
            if (this.MRL != null) {
                aVar.ni(4, this.MRL.computeSize());
                this.MRL.writeFields(aVar);
            }
            if (this.MRM != null) {
                aVar.ni(5, this.MRM.computeSize());
                this.MRM.writeFields(aVar);
            }
            aVar.aM(6, this.Scene);
            AppMethodBeat.o(148655);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MRJ) + g.a.a.a.c(3, 8, this.MRK);
            if (this.MRL != null) {
                nh += g.a.a.a.nh(4, this.MRL.computeSize());
            }
            if (this.MRM != null) {
                nh += g.a.a.a.nh(5, this.MRM.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Scene);
            AppMethodBeat.o(148655);
            return bu;
        } else if (i2 == 2) {
            this.MRK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(148655);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doj doj = (doj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        doj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148655);
                    return 0;
                case 2:
                    doj.MRJ = aVar3.UbS.zi();
                    AppMethodBeat.o(148655);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        doj.MRK.add(dqi);
                    }
                    AppMethodBeat.o(148655);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        doj.MRL = dqi2;
                    }
                    AppMethodBeat.o(148655);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        doj.MRM = dqi3;
                    }
                    AppMethodBeat.o(148655);
                    return 0;
                case 6:
                    doj.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(148655);
                    return 0;
                default:
                    AppMethodBeat.o(148655);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148655);
            return -1;
        }
    }
}

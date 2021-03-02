package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eut extends dop {
    public int Lri;
    public int MPZ;
    public long NpN;
    public eus NqI;
    public eus NsN;
    public eus NsO;
    public eus NsP;
    public eus NsQ;
    public int NsR;
    public LinkedList<dqi> NsS = new LinkedList<>();
    public LinkedList<dqi> NsT = new LinkedList<>();
    public LinkedList<dqi> NsU = new LinkedList<>();
    public int NsV;
    public LinkedList<dqi> NsW = new LinkedList<>();

    public eut() {
        AppMethodBeat.i(115921);
        AppMethodBeat.o(115921);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115922);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NqI == null) {
                b bVar = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(115922);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.NqI != null) {
                aVar.ni(2, this.NqI.computeSize());
                this.NqI.writeFields(aVar);
            }
            if (this.NsN != null) {
                aVar.ni(3, this.NsN.computeSize());
                this.NsN.writeFields(aVar);
            }
            if (this.NsO != null) {
                aVar.ni(4, this.NsO.computeSize());
                this.NsO.writeFields(aVar);
            }
            if (this.NsP != null) {
                aVar.ni(5, this.NsP.computeSize());
                this.NsP.writeFields(aVar);
            }
            aVar.bb(6, this.NpN);
            if (this.NsQ != null) {
                aVar.ni(7, this.NsQ.computeSize());
                this.NsQ.writeFields(aVar);
            }
            aVar.aM(8, this.NsR);
            aVar.e(9, 8, this.NsS);
            aVar.aM(10, this.Lri);
            aVar.e(11, 8, this.NsT);
            aVar.aM(12, this.MPZ);
            aVar.e(13, 8, this.NsU);
            aVar.aM(14, this.NsV);
            aVar.e(15, 8, this.NsW);
            AppMethodBeat.o(115922);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.NqI != null) {
                nh += g.a.a.a.nh(2, this.NqI.computeSize());
            }
            if (this.NsN != null) {
                nh += g.a.a.a.nh(3, this.NsN.computeSize());
            }
            if (this.NsO != null) {
                nh += g.a.a.a.nh(4, this.NsO.computeSize());
            }
            if (this.NsP != null) {
                nh += g.a.a.a.nh(5, this.NsP.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(6, this.NpN);
            if (this.NsQ != null) {
                r += g.a.a.a.nh(7, this.NsQ.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(8, this.NsR) + g.a.a.a.c(9, 8, this.NsS) + g.a.a.b.b.a.bu(10, this.Lri) + g.a.a.a.c(11, 8, this.NsT) + g.a.a.b.b.a.bu(12, this.MPZ) + g.a.a.a.c(13, 8, this.NsU) + g.a.a.b.b.a.bu(14, this.NsV) + g.a.a.a.c(15, 8, this.NsW);
            AppMethodBeat.o(115922);
            return bu;
        } else if (i2 == 2) {
            this.NsS.clear();
            this.NsT.clear();
            this.NsU.clear();
            this.NsW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NqI == null) {
                b bVar2 = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(115922);
                throw bVar2;
            }
            AppMethodBeat.o(115922);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eut eut = (eut) objArr[1];
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
                        eut.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eus eus = new eus();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eus.populateBuilderWithField(aVar5, eus, dop.getNextFieldNumber(aVar5))) {
                        }
                        eut.NqI = eus;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eus eus2 = new eus();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eus2.populateBuilderWithField(aVar6, eus2, dop.getNextFieldNumber(aVar6))) {
                        }
                        eut.NsN = eus2;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eus eus3 = new eus();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eus3.populateBuilderWithField(aVar7, eus3, dop.getNextFieldNumber(aVar7))) {
                        }
                        eut.NsO = eus3;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eus eus4 = new eus();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eus4.populateBuilderWithField(aVar8, eus4, dop.getNextFieldNumber(aVar8))) {
                        }
                        eut.NsP = eus4;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 6:
                    eut.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115922);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eus eus5 = new eus();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eus5.populateBuilderWithField(aVar9, eus5, dop.getNextFieldNumber(aVar9))) {
                        }
                        eut.NsQ = eus5;
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 8:
                    eut.NsR = aVar3.UbS.zi();
                    AppMethodBeat.o(115922);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi.populateBuilderWithField(aVar10, dqi, dop.getNextFieldNumber(aVar10))) {
                        }
                        eut.NsS.add(dqi);
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 10:
                    eut.Lri = aVar3.UbS.zi();
                    AppMethodBeat.o(115922);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dqi2.populateBuilderWithField(aVar11, dqi2, dop.getNextFieldNumber(aVar11))) {
                        }
                        eut.NsT.add(dqi2);
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 12:
                    eut.MPZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115922);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dqi3.populateBuilderWithField(aVar12, dqi3, dop.getNextFieldNumber(aVar12))) {
                        }
                        eut.NsU.add(dqi3);
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                case 14:
                    eut.NsV = aVar3.UbS.zi();
                    AppMethodBeat.o(115922);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = dqi4.populateBuilderWithField(aVar13, dqi4, dop.getNextFieldNumber(aVar13))) {
                        }
                        eut.NsW.add(dqi4);
                    }
                    AppMethodBeat.o(115922);
                    return 0;
                default:
                    AppMethodBeat.o(115922);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115922);
            return -1;
        }
    }
}

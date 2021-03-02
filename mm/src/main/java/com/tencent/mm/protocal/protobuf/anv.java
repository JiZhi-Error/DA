package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class anv extends a {
    public cjt LzA;
    public cjh LzB;
    public cjt Lzv;
    public FinderFeedReportObject Lzw;
    public bal Lzx;
    public aqg Lzy;
    public cjt Lzz;
    public int kdU;
    public cjm vTj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209322);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.kdU);
            if (this.vTj != null) {
                aVar.ni(2, this.vTj.computeSize());
                this.vTj.writeFields(aVar);
            }
            if (this.Lzv != null) {
                aVar.ni(3, this.Lzv.computeSize());
                this.Lzv.writeFields(aVar);
            }
            if (this.Lzw != null) {
                aVar.ni(4, this.Lzw.computeSize());
                this.Lzw.writeFields(aVar);
            }
            if (this.Lzx != null) {
                aVar.ni(5, this.Lzx.computeSize());
                this.Lzx.writeFields(aVar);
            }
            if (this.Lzy != null) {
                aVar.ni(6, this.Lzy.computeSize());
                this.Lzy.writeFields(aVar);
            }
            if (this.Lzz != null) {
                aVar.ni(7, this.Lzz.computeSize());
                this.Lzz.writeFields(aVar);
            }
            if (this.LzA != null) {
                aVar.ni(8, this.LzA.computeSize());
                this.LzA.writeFields(aVar);
            }
            if (this.LzB != null) {
                aVar.ni(9, this.LzB.computeSize());
                this.LzB.writeFields(aVar);
            }
            AppMethodBeat.o(209322);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.kdU) + 0;
            if (this.vTj != null) {
                bu += g.a.a.a.nh(2, this.vTj.computeSize());
            }
            if (this.Lzv != null) {
                bu += g.a.a.a.nh(3, this.Lzv.computeSize());
            }
            if (this.Lzw != null) {
                bu += g.a.a.a.nh(4, this.Lzw.computeSize());
            }
            if (this.Lzx != null) {
                bu += g.a.a.a.nh(5, this.Lzx.computeSize());
            }
            if (this.Lzy != null) {
                bu += g.a.a.a.nh(6, this.Lzy.computeSize());
            }
            if (this.Lzz != null) {
                bu += g.a.a.a.nh(7, this.Lzz.computeSize());
            }
            if (this.LzA != null) {
                bu += g.a.a.a.nh(8, this.LzA.computeSize());
            }
            if (this.LzB != null) {
                bu += g.a.a.a.nh(9, this.LzB.computeSize());
            }
            AppMethodBeat.o(209322);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209322);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anv anv = (anv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anv.kdU = aVar3.UbS.zi();
                    AppMethodBeat.o(209322);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjm cjm = new cjm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjm.populateBuilderWithField(aVar4, cjm, a.getNextFieldNumber(aVar4))) {
                        }
                        anv.vTj = cjm;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjt cjt = new cjt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjt.populateBuilderWithField(aVar5, cjt, a.getNextFieldNumber(aVar5))) {
                        }
                        anv.Lzv = cjt;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderFeedReportObject finderFeedReportObject = new FinderFeedReportObject();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderFeedReportObject.populateBuilderWithField(aVar6, finderFeedReportObject, a.getNextFieldNumber(aVar6))) {
                        }
                        anv.Lzw = finderFeedReportObject;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bal bal = new bal();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bal.populateBuilderWithField(aVar7, bal, a.getNextFieldNumber(aVar7))) {
                        }
                        anv.Lzx = bal;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        aqg aqg = new aqg();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = aqg.populateBuilderWithField(aVar8, aqg, a.getNextFieldNumber(aVar8))) {
                        }
                        anv.Lzy = aqg;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cjt cjt2 = new cjt();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cjt2.populateBuilderWithField(aVar9, cjt2, a.getNextFieldNumber(aVar9))) {
                        }
                        anv.Lzz = cjt2;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cjt cjt3 = new cjt();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cjt3.populateBuilderWithField(aVar10, cjt3, a.getNextFieldNumber(aVar10))) {
                        }
                        anv.LzA = cjt3;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        cjh cjh = new cjh();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = cjh.populateBuilderWithField(aVar11, cjh, a.getNextFieldNumber(aVar11))) {
                        }
                        anv.LzB = cjh;
                    }
                    AppMethodBeat.o(209322);
                    return 0;
                default:
                    AppMethodBeat.o(209322);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209322);
            return -1;
        }
    }
}

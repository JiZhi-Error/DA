package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcu extends a {
    public String IFO;
    public String LLO;
    public int LLP;
    public int LLQ;
    public boolean LLR;
    public int LLS;
    public String LLT;
    public bdb LLU;
    public bcv LLV;
    public LinkedList<bcv> LLW = new LinkedList<>();
    public bcv LLX;
    public bcv LLY;
    public bcv LLZ;
    public bcv LMa;
    public String LrN;
    public long id;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public String sessionBuffer;
    public int tQR;
    public int tQT;
    public String tQU;
    public b tVe;
    public boolean uOm;
    public long uOx;

    public bcu() {
        AppMethodBeat.i(209682);
        AppMethodBeat.o(209682);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209683);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uOx);
            if (this.IFO != null) {
                aVar.e(2, this.IFO);
            }
            if (this.LLO != null) {
                aVar.e(3, this.LLO);
            }
            aVar.aM(4, this.LLP);
            aVar.e(5, 8, this.object);
            aVar.aM(6, this.LLQ);
            if (this.tVe != null) {
                aVar.c(7, this.tVe);
            }
            aVar.aM(8, this.tQR);
            aVar.cc(9, this.LLR);
            aVar.aM(10, this.LLS);
            aVar.cc(11, this.uOm);
            if (this.tQU != null) {
                aVar.e(12, this.tQU);
            }
            aVar.aM(13, this.tQT);
            if (this.LLT != null) {
                aVar.e(14, this.LLT);
            }
            aVar.bb(15, this.id);
            if (this.sessionBuffer != null) {
                aVar.e(16, this.sessionBuffer);
            }
            if (this.LLU != null) {
                aVar.ni(17, this.LLU.computeSize());
                this.LLU.writeFields(aVar);
            }
            if (this.LLV != null) {
                aVar.ni(18, this.LLV.computeSize());
                this.LLV.writeFields(aVar);
            }
            aVar.e(19, 8, this.LLW);
            if (this.LLX != null) {
                aVar.ni(20, this.LLX.computeSize());
                this.LLX.writeFields(aVar);
            }
            if (this.LLY != null) {
                aVar.ni(21, this.LLY.computeSize());
                this.LLY.writeFields(aVar);
            }
            if (this.LrN != null) {
                aVar.e(22, this.LrN);
            }
            if (this.LLZ != null) {
                aVar.ni(23, this.LLZ.computeSize());
                this.LLZ.writeFields(aVar);
            }
            if (this.LMa != null) {
                aVar.ni(24, this.LMa.computeSize());
                this.LMa.writeFields(aVar);
            }
            AppMethodBeat.o(209683);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uOx) + 0;
            if (this.IFO != null) {
                r += g.a.a.b.b.a.f(2, this.IFO);
            }
            if (this.LLO != null) {
                r += g.a.a.b.b.a.f(3, this.LLO);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.LLP) + g.a.a.a.c(5, 8, this.object) + g.a.a.b.b.a.bu(6, this.LLQ);
            if (this.tVe != null) {
                bu += g.a.a.b.b.a.b(7, this.tVe);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.tQR) + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.bu(10, this.LLS) + g.a.a.b.b.a.fS(11) + 1;
            if (this.tQU != null) {
                bu2 += g.a.a.b.b.a.f(12, this.tQU);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.tQT);
            if (this.LLT != null) {
                bu3 += g.a.a.b.b.a.f(14, this.LLT);
            }
            int r2 = bu3 + g.a.a.b.b.a.r(15, this.id);
            if (this.sessionBuffer != null) {
                r2 += g.a.a.b.b.a.f(16, this.sessionBuffer);
            }
            if (this.LLU != null) {
                r2 += g.a.a.a.nh(17, this.LLU.computeSize());
            }
            if (this.LLV != null) {
                r2 += g.a.a.a.nh(18, this.LLV.computeSize());
            }
            int c2 = r2 + g.a.a.a.c(19, 8, this.LLW);
            if (this.LLX != null) {
                c2 += g.a.a.a.nh(20, this.LLX.computeSize());
            }
            if (this.LLY != null) {
                c2 += g.a.a.a.nh(21, this.LLY.computeSize());
            }
            if (this.LrN != null) {
                c2 += g.a.a.b.b.a.f(22, this.LrN);
            }
            if (this.LLZ != null) {
                c2 += g.a.a.a.nh(23, this.LLZ.computeSize());
            }
            if (this.LMa != null) {
                c2 += g.a.a.a.nh(24, this.LMa.computeSize());
            }
            AppMethodBeat.o(209683);
            return c2;
        } else if (i2 == 2) {
            this.object.clear();
            this.LLW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209683);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcu bcu = (bcu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcu.uOx = aVar3.UbS.zl();
                    AppMethodBeat.o(209683);
                    return 0;
                case 2:
                    bcu.IFO = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 3:
                    bcu.LLO = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 4:
                    bcu.LLP = aVar3.UbS.zi();
                    AppMethodBeat.o(209683);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        bcu.object.add(finderObject);
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 6:
                    bcu.LLQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209683);
                    return 0;
                case 7:
                    bcu.tVe = aVar3.UbS.hPo();
                    AppMethodBeat.o(209683);
                    return 0;
                case 8:
                    bcu.tQR = aVar3.UbS.zi();
                    AppMethodBeat.o(209683);
                    return 0;
                case 9:
                    bcu.LLR = aVar3.UbS.yZ();
                    AppMethodBeat.o(209683);
                    return 0;
                case 10:
                    bcu.LLS = aVar3.UbS.zi();
                    AppMethodBeat.o(209683);
                    return 0;
                case 11:
                    bcu.uOm = aVar3.UbS.yZ();
                    AppMethodBeat.o(209683);
                    return 0;
                case 12:
                    bcu.tQU = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 13:
                    bcu.tQT = aVar3.UbS.zi();
                    AppMethodBeat.o(209683);
                    return 0;
                case 14:
                    bcu.LLT = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 15:
                    bcu.id = aVar3.UbS.zl();
                    AppMethodBeat.o(209683);
                    return 0;
                case 16:
                    bcu.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bdb bdb = new bdb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bdb.populateBuilderWithField(aVar5, bdb, a.getNextFieldNumber(aVar5))) {
                        }
                        bcu.LLU = bdb;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bcv bcv = new bcv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bcv.populateBuilderWithField(aVar6, bcv, a.getNextFieldNumber(aVar6))) {
                        }
                        bcu.LLV = bcv;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bcv bcv2 = new bcv();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bcv2.populateBuilderWithField(aVar7, bcv2, a.getNextFieldNumber(aVar7))) {
                        }
                        bcu.LLW.add(bcv2);
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bcv bcv3 = new bcv();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bcv3.populateBuilderWithField(aVar8, bcv3, a.getNextFieldNumber(aVar8))) {
                        }
                        bcu.LLX = bcv3;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bcv bcv4 = new bcv();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bcv4.populateBuilderWithField(aVar9, bcv4, a.getNextFieldNumber(aVar9))) {
                        }
                        bcu.LLY = bcv4;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 22:
                    bcu.LrN = aVar3.UbS.readString();
                    AppMethodBeat.o(209683);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bcv bcv5 = new bcv();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bcv5.populateBuilderWithField(aVar10, bcv5, a.getNextFieldNumber(aVar10))) {
                        }
                        bcu.LLZ = bcv5;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bcv bcv6 = new bcv();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bcv6.populateBuilderWithField(aVar11, bcv6, a.getNextFieldNumber(aVar11))) {
                        }
                        bcu.LMa = bcv6;
                    }
                    AppMethodBeat.o(209683);
                    return 0;
                default:
                    AppMethodBeat.o(209683);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209683);
            return -1;
        }
    }
}

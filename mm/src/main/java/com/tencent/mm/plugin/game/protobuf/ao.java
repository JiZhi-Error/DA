package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ao extends a {
    public String jfi;
    public String xIy;
    public String xJt;
    public int xJv;
    public int xJy;
    public s xKA;
    public cn xKp;
    public el xKq;
    public cy xKr;
    public cz xKs;
    public bg xKt;
    public dh xKu;
    public be xKv;
    public t xKw;
    public dc xKx;
    public dp xKy;
    public s xKz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41732);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xJy);
            aVar.aM(2, this.xJv);
            if (this.xJt != null) {
                aVar.e(3, this.xJt);
            }
            if (this.jfi != null) {
                aVar.e(4, this.jfi);
            }
            if (this.xIy != null) {
                aVar.e(17, this.xIy);
            }
            if (this.xKp != null) {
                aVar.ni(5, this.xKp.computeSize());
                this.xKp.writeFields(aVar);
            }
            if (this.xKq != null) {
                aVar.ni(6, this.xKq.computeSize());
                this.xKq.writeFields(aVar);
            }
            if (this.xKr != null) {
                aVar.ni(7, this.xKr.computeSize());
                this.xKr.writeFields(aVar);
            }
            if (this.xKs != null) {
                aVar.ni(8, this.xKs.computeSize());
                this.xKs.writeFields(aVar);
            }
            if (this.xKt != null) {
                aVar.ni(9, this.xKt.computeSize());
                this.xKt.writeFields(aVar);
            }
            if (this.xKu != null) {
                aVar.ni(10, this.xKu.computeSize());
                this.xKu.writeFields(aVar);
            }
            if (this.xKv != null) {
                aVar.ni(11, this.xKv.computeSize());
                this.xKv.writeFields(aVar);
            }
            if (this.xKw != null) {
                aVar.ni(12, this.xKw.computeSize());
                this.xKw.writeFields(aVar);
            }
            if (this.xKx != null) {
                aVar.ni(13, this.xKx.computeSize());
                this.xKx.writeFields(aVar);
            }
            if (this.xKy != null) {
                aVar.ni(14, this.xKy.computeSize());
                this.xKy.writeFields(aVar);
            }
            if (this.xKz != null) {
                aVar.ni(15, this.xKz.computeSize());
                this.xKz.writeFields(aVar);
            }
            if (this.xKA != null) {
                aVar.ni(16, this.xKA.computeSize());
                this.xKA.writeFields(aVar);
            }
            AppMethodBeat.o(41732);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xJy) + 0 + g.a.a.b.b.a.bu(2, this.xJv);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(3, this.xJt);
            }
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(4, this.jfi);
            }
            if (this.xIy != null) {
                bu += g.a.a.b.b.a.f(17, this.xIy);
            }
            if (this.xKp != null) {
                bu += g.a.a.a.nh(5, this.xKp.computeSize());
            }
            if (this.xKq != null) {
                bu += g.a.a.a.nh(6, this.xKq.computeSize());
            }
            if (this.xKr != null) {
                bu += g.a.a.a.nh(7, this.xKr.computeSize());
            }
            if (this.xKs != null) {
                bu += g.a.a.a.nh(8, this.xKs.computeSize());
            }
            if (this.xKt != null) {
                bu += g.a.a.a.nh(9, this.xKt.computeSize());
            }
            if (this.xKu != null) {
                bu += g.a.a.a.nh(10, this.xKu.computeSize());
            }
            if (this.xKv != null) {
                bu += g.a.a.a.nh(11, this.xKv.computeSize());
            }
            if (this.xKw != null) {
                bu += g.a.a.a.nh(12, this.xKw.computeSize());
            }
            if (this.xKx != null) {
                bu += g.a.a.a.nh(13, this.xKx.computeSize());
            }
            if (this.xKy != null) {
                bu += g.a.a.a.nh(14, this.xKy.computeSize());
            }
            if (this.xKz != null) {
                bu += g.a.a.a.nh(15, this.xKz.computeSize());
            }
            if (this.xKA != null) {
                bu += g.a.a.a.nh(16, this.xKA.computeSize());
            }
            AppMethodBeat.o(41732);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41732);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ao aoVar = (ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aoVar.xJy = aVar3.UbS.zi();
                    AppMethodBeat.o(41732);
                    return 0;
                case 2:
                    aoVar.xJv = aVar3.UbS.zi();
                    AppMethodBeat.o(41732);
                    return 0;
                case 3:
                    aoVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41732);
                    return 0;
                case 4:
                    aoVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41732);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cn cnVar = new cn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnVar.populateBuilderWithField(aVar4, cnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aoVar.xKp = cnVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        el elVar = new el();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = elVar.populateBuilderWithField(aVar5, elVar, a.getNextFieldNumber(aVar5))) {
                        }
                        aoVar.xKq = elVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cy cyVar = new cy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cyVar.populateBuilderWithField(aVar6, cyVar, a.getNextFieldNumber(aVar6))) {
                        }
                        aoVar.xKr = cyVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cz czVar = new cz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = czVar.populateBuilderWithField(aVar7, czVar, a.getNextFieldNumber(aVar7))) {
                        }
                        aoVar.xKs = czVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bg bgVar = new bg();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bgVar.populateBuilderWithField(aVar8, bgVar, a.getNextFieldNumber(aVar8))) {
                        }
                        aoVar.xKt = bgVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dh dhVar = new dh();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dhVar.populateBuilderWithField(aVar9, dhVar, a.getNextFieldNumber(aVar9))) {
                        }
                        aoVar.xKu = dhVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        be beVar = new be();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = beVar.populateBuilderWithField(aVar10, beVar, a.getNextFieldNumber(aVar10))) {
                        }
                        aoVar.xKv = beVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        t tVar = new t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = tVar.populateBuilderWithField(aVar11, tVar, a.getNextFieldNumber(aVar11))) {
                        }
                        aoVar.xKw = tVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dc dcVar = new dc();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dcVar.populateBuilderWithField(aVar12, dcVar, a.getNextFieldNumber(aVar12))) {
                        }
                        aoVar.xKx = dcVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        dp dpVar = new dp();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = dpVar.populateBuilderWithField(aVar13, dpVar, a.getNextFieldNumber(aVar13))) {
                        }
                        aoVar.xKy = dpVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        s sVar = new s();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = sVar.populateBuilderWithField(aVar14, sVar, a.getNextFieldNumber(aVar14))) {
                        }
                        aoVar.xKz = sVar;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        s sVar2 = new s();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = sVar2.populateBuilderWithField(aVar15, sVar2, a.getNextFieldNumber(aVar15))) {
                        }
                        aoVar.xKA = sVar2;
                    }
                    AppMethodBeat.o(41732);
                    return 0;
                case 17:
                    aoVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41732);
                    return 0;
                default:
                    AppMethodBeat.o(41732);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41732);
            return -1;
        }
    }
}

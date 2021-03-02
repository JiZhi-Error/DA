package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ty extends a {
    public abz LcA;
    public agz LcB;
    public String LcC;
    public abz LcD;
    public String LcE;
    public abz LcF;
    public boolean LcG;
    public boolean LcH;
    public int Lck;
    public int Lcl;
    public LinkedList<vj> Lcm = new LinkedList<>();
    public LinkedList<vj> Lcn = new LinkedList<>();
    public LinkedList<vj> Lco = new LinkedList<>();
    public LinkedList<String> Lcp = new LinkedList<>();
    public int Lcq;
    public int Lcr;
    public LinkedList<abz> Lcs = new LinkedList<>();
    public long Lct;
    public int Lcu;
    public String Lcv;
    public abz Lcw;
    public LinkedList<bg> Lcx = new LinkedList<>();
    public abz Lcy;
    public abz Lcz;
    public String code;
    public int status;

    public ty() {
        AppMethodBeat.i(113948);
        AppMethodBeat.o(113948);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113949);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.status);
            aVar.aM(2, this.Lck);
            aVar.aM(3, this.Lcl);
            aVar.e(4, 8, this.Lcm);
            aVar.e(5, 8, this.Lcn);
            aVar.e(6, 8, this.Lco);
            aVar.e(7, 1, this.Lcp);
            aVar.aM(8, this.Lcq);
            if (this.code != null) {
                aVar.e(9, this.code);
            }
            aVar.aM(10, this.Lcr);
            aVar.e(11, 8, this.Lcs);
            aVar.bb(12, this.Lct);
            aVar.aM(13, this.Lcu);
            if (this.Lcv != null) {
                aVar.e(14, this.Lcv);
            }
            if (this.Lcw != null) {
                aVar.ni(15, this.Lcw.computeSize());
                this.Lcw.writeFields(aVar);
            }
            aVar.e(16, 8, this.Lcx);
            if (this.Lcy != null) {
                aVar.ni(17, this.Lcy.computeSize());
                this.Lcy.writeFields(aVar);
            }
            if (this.Lcz != null) {
                aVar.ni(18, this.Lcz.computeSize());
                this.Lcz.writeFields(aVar);
            }
            if (this.LcA != null) {
                aVar.ni(19, this.LcA.computeSize());
                this.LcA.writeFields(aVar);
            }
            if (this.LcB != null) {
                aVar.ni(20, this.LcB.computeSize());
                this.LcB.writeFields(aVar);
            }
            if (this.LcC != null) {
                aVar.e(21, this.LcC);
            }
            if (this.LcD != null) {
                aVar.ni(22, this.LcD.computeSize());
                this.LcD.writeFields(aVar);
            }
            if (this.LcE != null) {
                aVar.e(23, this.LcE);
            }
            if (this.LcF != null) {
                aVar.ni(24, this.LcF.computeSize());
                this.LcF.writeFields(aVar);
            }
            aVar.cc(25, this.LcG);
            aVar.cc(26, this.LcH);
            AppMethodBeat.o(113949);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.status) + 0 + g.a.a.b.b.a.bu(2, this.Lck) + g.a.a.b.b.a.bu(3, this.Lcl) + g.a.a.a.c(4, 8, this.Lcm) + g.a.a.a.c(5, 8, this.Lcn) + g.a.a.a.c(6, 8, this.Lco) + g.a.a.a.c(7, 1, this.Lcp) + g.a.a.b.b.a.bu(8, this.Lcq);
            if (this.code != null) {
                bu += g.a.a.b.b.a.f(9, this.code);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Lcr) + g.a.a.a.c(11, 8, this.Lcs) + g.a.a.b.b.a.r(12, this.Lct) + g.a.a.b.b.a.bu(13, this.Lcu);
            if (this.Lcv != null) {
                bu2 += g.a.a.b.b.a.f(14, this.Lcv);
            }
            if (this.Lcw != null) {
                bu2 += g.a.a.a.nh(15, this.Lcw.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(16, 8, this.Lcx);
            if (this.Lcy != null) {
                c2 += g.a.a.a.nh(17, this.Lcy.computeSize());
            }
            if (this.Lcz != null) {
                c2 += g.a.a.a.nh(18, this.Lcz.computeSize());
            }
            if (this.LcA != null) {
                c2 += g.a.a.a.nh(19, this.LcA.computeSize());
            }
            if (this.LcB != null) {
                c2 += g.a.a.a.nh(20, this.LcB.computeSize());
            }
            if (this.LcC != null) {
                c2 += g.a.a.b.b.a.f(21, this.LcC);
            }
            if (this.LcD != null) {
                c2 += g.a.a.a.nh(22, this.LcD.computeSize());
            }
            if (this.LcE != null) {
                c2 += g.a.a.b.b.a.f(23, this.LcE);
            }
            if (this.LcF != null) {
                c2 += g.a.a.a.nh(24, this.LcF.computeSize());
            }
            int fS = c2 + g.a.a.b.b.a.fS(25) + 1 + g.a.a.b.b.a.fS(26) + 1;
            AppMethodBeat.o(113949);
            return fS;
        } else if (i2 == 2) {
            this.Lcm.clear();
            this.Lcn.clear();
            this.Lco.clear();
            this.Lcp.clear();
            this.Lcs.clear();
            this.Lcx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113949);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ty tyVar = (ty) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tyVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 2:
                    tyVar.Lck = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 3:
                    tyVar.Lcl = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        vj vjVar = new vj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vjVar.populateBuilderWithField(aVar4, vjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        tyVar.Lcm.add(vjVar);
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        vj vjVar2 = new vj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = vjVar2.populateBuilderWithField(aVar5, vjVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        tyVar.Lcn.add(vjVar2);
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        vj vjVar3 = new vj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = vjVar3.populateBuilderWithField(aVar6, vjVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        tyVar.Lco.add(vjVar3);
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 7:
                    tyVar.Lcp.add(aVar3.UbS.readString());
                    AppMethodBeat.o(113949);
                    return 0;
                case 8:
                    tyVar.Lcq = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 9:
                    tyVar.code = aVar3.UbS.readString();
                    AppMethodBeat.o(113949);
                    return 0;
                case 10:
                    tyVar.Lcr = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        abz abz = new abz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = abz.populateBuilderWithField(aVar7, abz, a.getNextFieldNumber(aVar7))) {
                        }
                        tyVar.Lcs.add(abz);
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 12:
                    tyVar.Lct = aVar3.UbS.zl();
                    AppMethodBeat.o(113949);
                    return 0;
                case 13:
                    tyVar.Lcu = aVar3.UbS.zi();
                    AppMethodBeat.o(113949);
                    return 0;
                case 14:
                    tyVar.Lcv = aVar3.UbS.readString();
                    AppMethodBeat.o(113949);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        abz abz2 = new abz();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = abz2.populateBuilderWithField(aVar8, abz2, a.getNextFieldNumber(aVar8))) {
                        }
                        tyVar.Lcw = abz2;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bg bgVar = new bg();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bgVar.populateBuilderWithField(aVar9, bgVar, a.getNextFieldNumber(aVar9))) {
                        }
                        tyVar.Lcx.add(bgVar);
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        abz abz3 = new abz();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = abz3.populateBuilderWithField(aVar10, abz3, a.getNextFieldNumber(aVar10))) {
                        }
                        tyVar.Lcy = abz3;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        abz abz4 = new abz();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = abz4.populateBuilderWithField(aVar11, abz4, a.getNextFieldNumber(aVar11))) {
                        }
                        tyVar.Lcz = abz4;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        abz abz5 = new abz();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = abz5.populateBuilderWithField(aVar12, abz5, a.getNextFieldNumber(aVar12))) {
                        }
                        tyVar.LcA = abz5;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        agz agz = new agz();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = agz.populateBuilderWithField(aVar13, agz, a.getNextFieldNumber(aVar13))) {
                        }
                        tyVar.LcB = agz;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 21:
                    tyVar.LcC = aVar3.UbS.readString();
                    AppMethodBeat.o(113949);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        abz abz6 = new abz();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = abz6.populateBuilderWithField(aVar14, abz6, a.getNextFieldNumber(aVar14))) {
                        }
                        tyVar.LcD = abz6;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 23:
                    tyVar.LcE = aVar3.UbS.readString();
                    AppMethodBeat.o(113949);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        abz abz7 = new abz();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = abz7.populateBuilderWithField(aVar15, abz7, a.getNextFieldNumber(aVar15))) {
                        }
                        tyVar.LcF = abz7;
                    }
                    AppMethodBeat.o(113949);
                    return 0;
                case 25:
                    tyVar.LcG = aVar3.UbS.yZ();
                    AppMethodBeat.o(113949);
                    return 0;
                case 26:
                    tyVar.LcH = aVar3.UbS.yZ();
                    AppMethodBeat.o(113949);
                    return 0;
                default:
                    AppMethodBeat.o(113949);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113949);
            return -1;
        }
    }
}

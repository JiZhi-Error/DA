package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adp extends a {
    public String Desc;
    public int LoU;
    public LinkedList<cnb> LoV = new LinkedList<>();
    public int LoW;
    public String LoX;
    public cli LoY;
    public bcl LoZ;
    public jo Lpa;
    public bcf Lpb;
    public axf Lpc;
    public col Lpd;
    public bcl Lpe;
    public String Title;
    public String Url;
    public bcj dME;
    public int izD;
    public css jfy;

    public adp() {
        AppMethodBeat.i(125718);
        AppMethodBeat.o(125718);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125719);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Desc != null) {
                aVar.e(1, this.Desc);
            }
            aVar.aM(2, this.LoU);
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            aVar.e(5, 8, this.LoV);
            aVar.aM(6, this.LoW);
            if (this.LoX != null) {
                aVar.e(7, this.LoX);
            }
            if (this.LoY != null) {
                aVar.ni(8, this.LoY.computeSize());
                this.LoY.writeFields(aVar);
            }
            if (this.dME != null) {
                aVar.ni(9, this.dME.computeSize());
                this.dME.writeFields(aVar);
            }
            if (this.LoZ != null) {
                aVar.ni(10, this.LoZ.computeSize());
                this.LoZ.writeFields(aVar);
            }
            if (this.Lpa != null) {
                aVar.ni(11, this.Lpa.computeSize());
                this.Lpa.writeFields(aVar);
            }
            if (this.Lpb != null) {
                aVar.ni(12, this.Lpb.computeSize());
                this.Lpb.writeFields(aVar);
            }
            if (this.Lpc != null) {
                aVar.ni(13, this.Lpc.computeSize());
                this.Lpc.writeFields(aVar);
            }
            if (this.Lpd != null) {
                aVar.ni(14, this.Lpd.computeSize());
                this.Lpd.writeFields(aVar);
            }
            aVar.aM(15, this.izD);
            if (this.Lpe != null) {
                aVar.ni(16, this.Lpe.computeSize());
                this.Lpe.writeFields(aVar);
            }
            if (this.jfy != null) {
                aVar.ni(17, this.jfy.computeSize());
                this.jfy.writeFields(aVar);
            }
            AppMethodBeat.o(125719);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Desc != null ? g.a.a.b.b.a.f(1, this.Desc) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LoU);
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(4, this.Url);
            }
            int c2 = f2 + g.a.a.a.c(5, 8, this.LoV) + g.a.a.b.b.a.bu(6, this.LoW);
            if (this.LoX != null) {
                c2 += g.a.a.b.b.a.f(7, this.LoX);
            }
            if (this.LoY != null) {
                c2 += g.a.a.a.nh(8, this.LoY.computeSize());
            }
            if (this.dME != null) {
                c2 += g.a.a.a.nh(9, this.dME.computeSize());
            }
            if (this.LoZ != null) {
                c2 += g.a.a.a.nh(10, this.LoZ.computeSize());
            }
            if (this.Lpa != null) {
                c2 += g.a.a.a.nh(11, this.Lpa.computeSize());
            }
            if (this.Lpb != null) {
                c2 += g.a.a.a.nh(12, this.Lpb.computeSize());
            }
            if (this.Lpc != null) {
                c2 += g.a.a.a.nh(13, this.Lpc.computeSize());
            }
            if (this.Lpd != null) {
                c2 += g.a.a.a.nh(14, this.Lpd.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(15, this.izD);
            if (this.Lpe != null) {
                bu += g.a.a.a.nh(16, this.Lpe.computeSize());
            }
            if (this.jfy != null) {
                bu += g.a.a.a.nh(17, this.jfy.computeSize());
            }
            AppMethodBeat.o(125719);
            return bu;
        } else if (i2 == 2) {
            this.LoV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125719);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adp adp = (adp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adp.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(125719);
                    return 0;
                case 2:
                    adp.LoU = aVar3.UbS.zi();
                    AppMethodBeat.o(125719);
                    return 0;
                case 3:
                    adp.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(125719);
                    return 0;
                case 4:
                    adp.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(125719);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cnb cnb = new cnb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnb.populateBuilderWithField(aVar4, cnb, a.getNextFieldNumber(aVar4))) {
                        }
                        adp.LoV.add(cnb);
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 6:
                    adp.LoW = aVar3.UbS.zi();
                    AppMethodBeat.o(125719);
                    return 0;
                case 7:
                    adp.LoX = aVar3.UbS.readString();
                    AppMethodBeat.o(125719);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cli cli = new cli();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cli.populateBuilderWithField(aVar5, cli, a.getNextFieldNumber(aVar5))) {
                        }
                        adp.LoY = cli;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bcj bcj = new bcj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bcj.populateBuilderWithField(aVar6, bcj, a.getNextFieldNumber(aVar6))) {
                        }
                        adp.dME = bcj;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bcl bcl = new bcl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bcl.populateBuilderWithField(aVar7, bcl, a.getNextFieldNumber(aVar7))) {
                        }
                        adp.LoZ = bcl;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        jo joVar = new jo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = joVar.populateBuilderWithField(aVar8, joVar, a.getNextFieldNumber(aVar8))) {
                        }
                        adp.Lpa = joVar;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bcf bcf = new bcf();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bcf.populateBuilderWithField(aVar9, bcf, a.getNextFieldNumber(aVar9))) {
                        }
                        adp.Lpb = bcf;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        axf axf = new axf();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = axf.populateBuilderWithField(aVar10, axf, a.getNextFieldNumber(aVar10))) {
                        }
                        adp.Lpc = axf;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        col col = new col();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = col.populateBuilderWithField(aVar11, col, a.getNextFieldNumber(aVar11))) {
                        }
                        adp.Lpd = col;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 15:
                    adp.izD = aVar3.UbS.zi();
                    AppMethodBeat.o(125719);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        bcl bcl2 = new bcl();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = bcl2.populateBuilderWithField(aVar12, bcl2, a.getNextFieldNumber(aVar12))) {
                        }
                        adp.Lpe = bcl2;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        css css = new css();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = css.populateBuilderWithField(aVar13, css, a.getNextFieldNumber(aVar13))) {
                        }
                        adp.jfy = css;
                    }
                    AppMethodBeat.o(125719);
                    return 0;
                default:
                    AppMethodBeat.o(125719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125719);
            return -1;
        }
    }
}

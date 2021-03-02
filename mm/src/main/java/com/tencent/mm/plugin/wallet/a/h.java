package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class h extends a {
    public double HEA;
    public int HEB;
    public String HEC;
    public String HED;
    public a HEE;
    public LinkedList<g> HEF = new LinkedList<>();
    public b HEG;
    public double HEq;
    public double HEr;
    public double HEs;
    public String HEt;
    public LinkedList<t> HEu = new LinkedList<>();
    public i HEv;
    public int HEw;
    public String HEx;
    public String HEy;
    public double HEz;

    public h() {
        AppMethodBeat.i(91292);
        AppMethodBeat.o(91292);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91293);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, this.HEq);
            aVar.e(2, this.HEr);
            aVar.e(3, this.HEs);
            if (this.HEt != null) {
                aVar.e(4, this.HEt);
            }
            aVar.e(5, 8, this.HEu);
            if (this.HEv != null) {
                aVar.ni(6, this.HEv.computeSize());
                this.HEv.writeFields(aVar);
            }
            aVar.aM(7, this.HEw);
            if (this.HEx != null) {
                aVar.e(8, this.HEx);
            }
            if (this.HEy != null) {
                aVar.e(9, this.HEy);
            }
            aVar.e(10, this.HEz);
            aVar.e(11, this.HEA);
            aVar.aM(12, this.HEB);
            if (this.HEC != null) {
                aVar.e(13, this.HEC);
            }
            if (this.HED != null) {
                aVar.e(14, this.HED);
            }
            if (this.HEE != null) {
                aVar.ni(15, this.HEE.computeSize());
                this.HEE.writeFields(aVar);
            }
            aVar.e(16, 8, this.HEF);
            if (this.HEG != null) {
                aVar.ni(17, this.HEG.computeSize());
                this.HEG.writeFields(aVar);
            }
            AppMethodBeat.o(91293);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 8 + 0 + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.fS(3) + 8;
            if (this.HEt != null) {
                fS += g.a.a.b.b.a.f(4, this.HEt);
            }
            int c2 = fS + g.a.a.a.c(5, 8, this.HEu);
            if (this.HEv != null) {
                c2 += g.a.a.a.nh(6, this.HEv.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.HEw);
            if (this.HEx != null) {
                bu += g.a.a.b.b.a.f(8, this.HEx);
            }
            if (this.HEy != null) {
                bu += g.a.a.b.b.a.f(9, this.HEy);
            }
            int fS2 = bu + g.a.a.b.b.a.fS(10) + 8 + g.a.a.b.b.a.fS(11) + 8 + g.a.a.b.b.a.bu(12, this.HEB);
            if (this.HEC != null) {
                fS2 += g.a.a.b.b.a.f(13, this.HEC);
            }
            if (this.HED != null) {
                fS2 += g.a.a.b.b.a.f(14, this.HED);
            }
            if (this.HEE != null) {
                fS2 += g.a.a.a.nh(15, this.HEE.computeSize());
            }
            int c3 = fS2 + g.a.a.a.c(16, 8, this.HEF);
            if (this.HEG != null) {
                c3 += g.a.a.a.nh(17, this.HEG.computeSize());
            }
            AppMethodBeat.o(91293);
            return c3;
        } else if (i2 == 2) {
            this.HEu.clear();
            this.HEF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91293);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hVar.HEq = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91293);
                    return 0;
                case 2:
                    hVar.HEr = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91293);
                    return 0;
                case 3:
                    hVar.HEs = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91293);
                    return 0;
                case 4:
                    hVar.HEt = aVar3.UbS.readString();
                    AppMethodBeat.o(91293);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        t tVar = new t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.HEu.add(tVar);
                    }
                    AppMethodBeat.o(91293);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        i iVar = new i();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iVar.populateBuilderWithField(aVar5, iVar, a.getNextFieldNumber(aVar5))) {
                        }
                        hVar.HEv = iVar;
                    }
                    AppMethodBeat.o(91293);
                    return 0;
                case 7:
                    hVar.HEw = aVar3.UbS.zi();
                    AppMethodBeat.o(91293);
                    return 0;
                case 8:
                    hVar.HEx = aVar3.UbS.readString();
                    AppMethodBeat.o(91293);
                    return 0;
                case 9:
                    hVar.HEy = aVar3.UbS.readString();
                    AppMethodBeat.o(91293);
                    return 0;
                case 10:
                    hVar.HEz = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91293);
                    return 0;
                case 11:
                    hVar.HEA = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91293);
                    return 0;
                case 12:
                    hVar.HEB = aVar3.UbS.zi();
                    AppMethodBeat.o(91293);
                    return 0;
                case 13:
                    hVar.HEC = aVar3.UbS.readString();
                    AppMethodBeat.o(91293);
                    return 0;
                case 14:
                    hVar.HED = aVar3.UbS.readString();
                    AppMethodBeat.o(91293);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar6 = new a();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aVar6.populateBuilderWithField(aVar7, aVar6, a.getNextFieldNumber(aVar7))) {
                        }
                        hVar.HEE = aVar6;
                    }
                    AppMethodBeat.o(91293);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        g gVar = new g();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = gVar.populateBuilderWithField(aVar8, gVar, a.getNextFieldNumber(aVar8))) {
                        }
                        hVar.HEF.add(gVar);
                    }
                    AppMethodBeat.o(91293);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        b bVar = new b();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bVar.populateBuilderWithField(aVar9, bVar, a.getNextFieldNumber(aVar9))) {
                        }
                        hVar.HEG = bVar;
                    }
                    AppMethodBeat.o(91293);
                    return 0;
                default:
                    AppMethodBeat.o(91293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91293);
            return -1;
        }
    }
}

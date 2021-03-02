package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public String AOl;
    public LinkedList<d> AZK = new LinkedList<>();
    public int AZL;
    public int AZM;
    public int AZN;
    public LinkedList<String> AZO = new LinkedList<>();
    public LinkedList<String> AZP = new LinkedList<>();
    public LinkedList<b> AZQ = new LinkedList<>();
    public LinkedList<String> AZR = new LinkedList<>();
    public int AZS;
    public int AZT;
    public LinkedList<m> AZU = new LinkedList<>();
    public LinkedList<a> AZV = new LinkedList<>();
    public k AZW;
    public String detail;
    public String iAq;
    public String name;
    public int version;

    public c() {
        AppMethodBeat.i(91267);
        AppMethodBeat.o(91267);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91268);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.e(2, 8, this.AZK);
            aVar.aM(3, this.AZL);
            aVar.aM(4, this.AZM);
            aVar.aM(5, this.AZN);
            aVar.e(6, 1, this.AZO);
            if (this.iAq != null) {
                aVar.e(7, this.iAq);
            }
            if (this.detail != null) {
                aVar.e(8, this.detail);
            }
            aVar.e(9, 1, this.AZP);
            aVar.e(10, 8, this.AZQ);
            aVar.e(11, 1, this.AZR);
            aVar.aM(12, this.AZS);
            aVar.aM(13, this.AZT);
            aVar.e(14, 8, this.AZU);
            aVar.aM(15, this.version);
            aVar.e(16, 8, this.AZV);
            if (this.AOl != null) {
                aVar.e(17, this.AOl);
            }
            if (this.AZW != null) {
                aVar.ni(18, this.AZW.computeSize());
                this.AZW.writeFields(aVar);
            }
            AppMethodBeat.o(91268);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.a.c(2, 8, this.AZK) + g.a.a.b.b.a.bu(3, this.AZL) + g.a.a.b.b.a.bu(4, this.AZM) + g.a.a.b.b.a.bu(5, this.AZN) + g.a.a.a.c(6, 1, this.AZO);
            if (this.iAq != null) {
                f2 += g.a.a.b.b.a.f(7, this.iAq);
            }
            if (this.detail != null) {
                f2 += g.a.a.b.b.a.f(8, this.detail);
            }
            int c2 = f2 + g.a.a.a.c(9, 1, this.AZP) + g.a.a.a.c(10, 8, this.AZQ) + g.a.a.a.c(11, 1, this.AZR) + g.a.a.b.b.a.bu(12, this.AZS) + g.a.a.b.b.a.bu(13, this.AZT) + g.a.a.a.c(14, 8, this.AZU) + g.a.a.b.b.a.bu(15, this.version) + g.a.a.a.c(16, 8, this.AZV);
            if (this.AOl != null) {
                c2 += g.a.a.b.b.a.f(17, this.AOl);
            }
            if (this.AZW != null) {
                c2 += g.a.a.a.nh(18, this.AZW.computeSize());
            }
            AppMethodBeat.o(91268);
            return c2;
        } else if (i2 == 2) {
            this.AZK.clear();
            this.AZO.clear();
            this.AZP.clear();
            this.AZQ.clear();
            this.AZR.clear();
            this.AZU.clear();
            this.AZV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91268);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91268);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.AZK.add(dVar);
                    }
                    AppMethodBeat.o(91268);
                    return 0;
                case 3:
                    cVar.AZL = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 4:
                    cVar.AZM = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 5:
                    cVar.AZN = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 6:
                    cVar.AZO.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91268);
                    return 0;
                case 7:
                    cVar.iAq = aVar3.UbS.readString();
                    AppMethodBeat.o(91268);
                    return 0;
                case 8:
                    cVar.detail = aVar3.UbS.readString();
                    AppMethodBeat.o(91268);
                    return 0;
                case 9:
                    cVar.AZP.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91268);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bVar.populateBuilderWithField(aVar5, bVar, a.getNextFieldNumber(aVar5))) {
                        }
                        cVar.AZQ.add(bVar);
                    }
                    AppMethodBeat.o(91268);
                    return 0;
                case 11:
                    cVar.AZR.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91268);
                    return 0;
                case 12:
                    cVar.AZS = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 13:
                    cVar.AZT = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        m mVar = new m();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = mVar.populateBuilderWithField(aVar6, mVar, a.getNextFieldNumber(aVar6))) {
                        }
                        cVar.AZU.add(mVar);
                    }
                    AppMethodBeat.o(91268);
                    return 0;
                case 15:
                    cVar.version = aVar3.UbS.zi();
                    AppMethodBeat.o(91268);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        a aVar7 = new a();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aVar7.populateBuilderWithField(aVar8, aVar7, a.getNextFieldNumber(aVar8))) {
                        }
                        cVar.AZV.add(aVar7);
                    }
                    AppMethodBeat.o(91268);
                    return 0;
                case 17:
                    cVar.AOl = aVar3.UbS.readString();
                    AppMethodBeat.o(91268);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        k kVar = new k();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = kVar.populateBuilderWithField(aVar9, kVar, a.getNextFieldNumber(aVar9))) {
                        }
                        cVar.AZW = kVar;
                    }
                    AppMethodBeat.o(91268);
                    return 0;
                default:
                    AppMethodBeat.o(91268);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91268);
            return -1;
        }
    }
}

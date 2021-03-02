package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public int dYn;
    public d gWY;
    public k gXT;
    public LinkedList<f> jgK = new LinkedList<>();
    public int jgL;
    public int jgM;
    public int jgN;
    public String jgO;
    public int jgP;
    public LinkedList<o> jgQ = new LinkedList<>();
    public String name;
    public int type;
    public w uBT;

    public e() {
        AppMethodBeat.i(150794);
        AppMethodBeat.o(150794);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150795);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.jgK);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.aM(3, this.jgL);
            aVar.aM(4, this.dYn);
            aVar.aM(5, this.jgM);
            aVar.aM(6, this.jgN);
            if (this.jgO != null) {
                aVar.e(7, this.jgO);
            }
            aVar.aM(8, this.jgP);
            if (this.gXT != null) {
                aVar.ni(9, this.gXT.computeSize());
                this.gXT.writeFields(aVar);
            }
            aVar.e(10, 8, this.jgQ);
            aVar.aM(11, this.type);
            if (this.gWY != null) {
                aVar.ni(12, this.gWY.computeSize());
                this.gWY.writeFields(aVar);
            }
            if (this.uBT != null) {
                aVar.ni(13, this.uBT.computeSize());
                this.uBT.writeFields(aVar);
            }
            AppMethodBeat.o(150795);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.jgK) + 0;
            if (this.name != null) {
                c2 += g.a.a.b.b.a.f(2, this.name);
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.jgL) + g.a.a.b.b.a.bu(4, this.dYn) + g.a.a.b.b.a.bu(5, this.jgM) + g.a.a.b.b.a.bu(6, this.jgN);
            if (this.jgO != null) {
                bu += g.a.a.b.b.a.f(7, this.jgO);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.jgP);
            if (this.gXT != null) {
                bu2 += g.a.a.a.nh(9, this.gXT.computeSize());
            }
            int c3 = bu2 + g.a.a.a.c(10, 8, this.jgQ) + g.a.a.b.b.a.bu(11, this.type);
            if (this.gWY != null) {
                c3 += g.a.a.a.nh(12, this.gWY.computeSize());
            }
            if (this.uBT != null) {
                c3 += g.a.a.a.nh(13, this.uBT.computeSize());
            }
            AppMethodBeat.o(150795);
            return c3;
        } else if (i2 == 2) {
            this.jgK.clear();
            this.jgQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150795);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        f fVar = new f();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.jgK.add(fVar);
                    }
                    AppMethodBeat.o(150795);
                    return 0;
                case 2:
                    eVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(150795);
                    return 0;
                case 3:
                    eVar.jgL = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 4:
                    eVar.dYn = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 5:
                    eVar.jgM = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 6:
                    eVar.jgN = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 7:
                    eVar.jgO = aVar3.UbS.readString();
                    AppMethodBeat.o(150795);
                    return 0;
                case 8:
                    eVar.jgP = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        k kVar = new k();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = kVar.populateBuilderWithField(aVar5, kVar, a.getNextFieldNumber(aVar5))) {
                        }
                        eVar.gXT = kVar;
                    }
                    AppMethodBeat.o(150795);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        o oVar = new o();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = oVar.populateBuilderWithField(aVar6, oVar, a.getNextFieldNumber(aVar6))) {
                        }
                        eVar.jgQ.add(oVar);
                    }
                    AppMethodBeat.o(150795);
                    return 0;
                case 11:
                    eVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(150795);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        d dVar = new d();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dVar.populateBuilderWithField(aVar7, dVar, a.getNextFieldNumber(aVar7))) {
                        }
                        eVar.gWY = dVar;
                    }
                    AppMethodBeat.o(150795);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        w wVar = new w();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = wVar.populateBuilderWithField(aVar8, wVar, a.getNextFieldNumber(aVar8))) {
                        }
                        eVar.uBT = wVar;
                    }
                    AppMethodBeat.o(150795);
                    return 0;
                default:
                    AppMethodBeat.o(150795);
                    return -1;
            }
        } else {
            AppMethodBeat.o(150795);
            return -1;
        }
    }
}

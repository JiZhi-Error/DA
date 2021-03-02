package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dyy extends a {
    public int APg;
    public dr LWZ;
    public String Lca;
    public akg MYA;
    public LinkedList<dki> MYB = new LinkedList<>();
    public int MYC;
    public LinkedList<dev> MYz = new LinkedList<>();

    public dyy() {
        AppMethodBeat.i(91694);
        AppMethodBeat.o(91694);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91695);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.APg);
            aVar.e(2, 8, this.MYz);
            if (this.MYA != null) {
                aVar.ni(3, this.MYA.computeSize());
                this.MYA.writeFields(aVar);
            }
            if (this.LWZ != null) {
                aVar.ni(4, this.LWZ.computeSize());
                this.LWZ.writeFields(aVar);
            }
            aVar.e(5, 8, this.MYB);
            aVar.aM(6, this.MYC);
            if (this.Lca != null) {
                aVar.e(7, this.Lca);
            }
            AppMethodBeat.o(91695);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.APg) + 0 + g.a.a.a.c(2, 8, this.MYz);
            if (this.MYA != null) {
                bu += g.a.a.a.nh(3, this.MYA.computeSize());
            }
            if (this.LWZ != null) {
                bu += g.a.a.a.nh(4, this.LWZ.computeSize());
            }
            int c2 = bu + g.a.a.a.c(5, 8, this.MYB) + g.a.a.b.b.a.bu(6, this.MYC);
            if (this.Lca != null) {
                c2 += g.a.a.b.b.a.f(7, this.Lca);
            }
            AppMethodBeat.o(91695);
            return c2;
        } else if (i2 == 2) {
            this.MYz.clear();
            this.MYB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91695);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyy dyy = (dyy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dyy.APg = aVar3.UbS.zi();
                    AppMethodBeat.o(91695);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dev dev = new dev();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dev.populateBuilderWithField(aVar4, dev, a.getNextFieldNumber(aVar4))) {
                        }
                        dyy.MYz.add(dev);
                    }
                    AppMethodBeat.o(91695);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akg akg = new akg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akg.populateBuilderWithField(aVar5, akg, a.getNextFieldNumber(aVar5))) {
                        }
                        dyy.MYA = akg;
                    }
                    AppMethodBeat.o(91695);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dr drVar = new dr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = drVar.populateBuilderWithField(aVar6, drVar, a.getNextFieldNumber(aVar6))) {
                        }
                        dyy.LWZ = drVar;
                    }
                    AppMethodBeat.o(91695);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dki dki = new dki();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dki.populateBuilderWithField(aVar7, dki, a.getNextFieldNumber(aVar7))) {
                        }
                        dyy.MYB.add(dki);
                    }
                    AppMethodBeat.o(91695);
                    return 0;
                case 6:
                    dyy.MYC = aVar3.UbS.zi();
                    AppMethodBeat.o(91695);
                    return 0;
                case 7:
                    dyy.Lca = aVar3.UbS.readString();
                    AppMethodBeat.o(91695);
                    return 0;
                default:
                    AppMethodBeat.o(91695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91695);
            return -1;
        }
    }
}

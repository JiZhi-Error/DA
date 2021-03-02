package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class h extends a {
    public String IconUrl;
    public String pLn;
    public int xIY;
    public boolean xIZ;
    public String xIy;
    public int xJa;
    public cu xJb;
    public LinkedList<aa> xJc = new LinkedList<>();
    public String xJd;
    public LinkedList<u> xJe = new LinkedList<>();
    public int xJf;

    public h() {
        AppMethodBeat.i(256624);
        AppMethodBeat.o(256624);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256625);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xIY);
            if (this.pLn != null) {
                aVar.e(2, this.pLn);
            }
            aVar.cc(3, this.xIZ);
            aVar.aM(4, this.xJa);
            if (this.xJb != null) {
                aVar.ni(5, this.xJb.computeSize());
                this.xJb.writeFields(aVar);
            }
            if (this.xIy != null) {
                aVar.e(6, this.xIy);
            }
            aVar.e(7, 8, this.xJc);
            if (this.IconUrl != null) {
                aVar.e(8, this.IconUrl);
            }
            if (this.xJd != null) {
                aVar.e(9, this.xJd);
            }
            aVar.e(10, 8, this.xJe);
            aVar.aM(11, this.xJf);
            AppMethodBeat.o(256625);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xIY) + 0;
            if (this.pLn != null) {
                bu += g.a.a.b.b.a.f(2, this.pLn);
            }
            int fS = bu + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.xJa);
            if (this.xJb != null) {
                fS += g.a.a.a.nh(5, this.xJb.computeSize());
            }
            if (this.xIy != null) {
                fS += g.a.a.b.b.a.f(6, this.xIy);
            }
            int c2 = fS + g.a.a.a.c(7, 8, this.xJc);
            if (this.IconUrl != null) {
                c2 += g.a.a.b.b.a.f(8, this.IconUrl);
            }
            if (this.xJd != null) {
                c2 += g.a.a.b.b.a.f(9, this.xJd);
            }
            int c3 = c2 + g.a.a.a.c(10, 8, this.xJe) + g.a.a.b.b.a.bu(11, this.xJf);
            AppMethodBeat.o(256625);
            return c3;
        } else if (i2 == 2) {
            this.xJc.clear();
            this.xJe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256625);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hVar.xIY = aVar3.UbS.zi();
                    AppMethodBeat.o(256625);
                    return 0;
                case 2:
                    hVar.pLn = aVar3.UbS.readString();
                    AppMethodBeat.o(256625);
                    return 0;
                case 3:
                    hVar.xIZ = aVar3.UbS.yZ();
                    AppMethodBeat.o(256625);
                    return 0;
                case 4:
                    hVar.xJa = aVar3.UbS.zi();
                    AppMethodBeat.o(256625);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cu cuVar = new cu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cuVar.populateBuilderWithField(aVar4, cuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.xJb = cuVar;
                    }
                    AppMethodBeat.o(256625);
                    return 0;
                case 6:
                    hVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(256625);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aa aaVar = new aa();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aaVar.populateBuilderWithField(aVar5, aaVar, a.getNextFieldNumber(aVar5))) {
                        }
                        hVar.xJc.add(aaVar);
                    }
                    AppMethodBeat.o(256625);
                    return 0;
                case 8:
                    hVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(256625);
                    return 0;
                case 9:
                    hVar.xJd = aVar3.UbS.readString();
                    AppMethodBeat.o(256625);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        u uVar = new u();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = uVar.populateBuilderWithField(aVar6, uVar, a.getNextFieldNumber(aVar6))) {
                        }
                        hVar.xJe.add(uVar);
                    }
                    AppMethodBeat.o(256625);
                    return 0;
                case 11:
                    hVar.xJf = aVar3.UbS.zi();
                    AppMethodBeat.o(256625);
                    return 0;
                default:
                    AppMethodBeat.o(256625);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256625);
            return -1;
        }
    }
}

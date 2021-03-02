package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dsa extends a {
    public String KCM;
    public int MUE;
    public String MUF;
    public String MUG;
    public int MUH;
    public String Title;
    public String oUJ;
    public LinkedList<dsb> xuZ = new LinkedList<>();

    public dsa() {
        AppMethodBeat.i(187881);
        AppMethodBeat.o(187881);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187882);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.KCM != null) {
                aVar.e(2, this.KCM);
            }
            aVar.aM(3, this.MUE);
            if (this.oUJ != null) {
                aVar.e(4, this.oUJ);
            }
            if (this.MUF != null) {
                aVar.e(5, this.MUF);
            }
            if (this.MUG != null) {
                aVar.e(6, this.MUG);
            }
            aVar.aM(7, this.MUH);
            aVar.e(8, 8, this.xuZ);
            AppMethodBeat.o(187882);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.KCM != null) {
                f2 += g.a.a.b.b.a.f(2, this.KCM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MUE);
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(4, this.oUJ);
            }
            if (this.MUF != null) {
                bu += g.a.a.b.b.a.f(5, this.MUF);
            }
            if (this.MUG != null) {
                bu += g.a.a.b.b.a.f(6, this.MUG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MUH) + g.a.a.a.c(8, 8, this.xuZ);
            AppMethodBeat.o(187882);
            return bu2;
        } else if (i2 == 2) {
            this.xuZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187882);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsa dsa = (dsa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dsa.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(187882);
                    return 0;
                case 2:
                    dsa.KCM = aVar3.UbS.readString();
                    AppMethodBeat.o(187882);
                    return 0;
                case 3:
                    dsa.MUE = aVar3.UbS.zi();
                    AppMethodBeat.o(187882);
                    return 0;
                case 4:
                    dsa.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(187882);
                    return 0;
                case 5:
                    dsa.MUF = aVar3.UbS.readString();
                    AppMethodBeat.o(187882);
                    return 0;
                case 6:
                    dsa.MUG = aVar3.UbS.readString();
                    AppMethodBeat.o(187882);
                    return 0;
                case 7:
                    dsa.MUH = aVar3.UbS.zi();
                    AppMethodBeat.o(187882);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dsb dsb = new dsb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dsb.populateBuilderWithField(aVar4, dsb, a.getNextFieldNumber(aVar4))) {
                        }
                        dsa.xuZ.add(dsb);
                    }
                    AppMethodBeat.o(187882);
                    return 0;
                default:
                    AppMethodBeat.o(187882);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187882);
            return -1;
        }
    }
}

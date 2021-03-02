package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class r extends a {
    public String eag;
    public String eah;
    public String fQR;
    public LinkedList<v> iAd = new LinkedList<>();
    public int iAe;
    public String name;
    public int type;

    public r() {
        AppMethodBeat.i(116413);
        AppMethodBeat.o(116413);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116414);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.eag != null) {
                aVar.e(3, this.eag);
            }
            if (this.eah != null) {
                aVar.e(4, this.eah);
            }
            if (this.fQR != null) {
                aVar.e(5, this.fQR);
            }
            aVar.e(6, 8, this.iAd);
            aVar.aM(7, this.iAe);
            AppMethodBeat.o(116414);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.eag != null) {
                bu += g.a.a.b.b.a.f(3, this.eag);
            }
            if (this.eah != null) {
                bu += g.a.a.b.b.a.f(4, this.eah);
            }
            if (this.fQR != null) {
                bu += g.a.a.b.b.a.f(5, this.fQR);
            }
            int c2 = bu + g.a.a.a.c(6, 8, this.iAd) + g.a.a.b.b.a.bu(7, this.iAe);
            AppMethodBeat.o(116414);
            return c2;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116414);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(116414);
                    return 0;
                case 2:
                    rVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(116414);
                    return 0;
                case 3:
                    rVar.eag = aVar3.UbS.readString();
                    AppMethodBeat.o(116414);
                    return 0;
                case 4:
                    rVar.eah = aVar3.UbS.readString();
                    AppMethodBeat.o(116414);
                    return 0;
                case 5:
                    rVar.fQR = aVar3.UbS.readString();
                    AppMethodBeat.o(116414);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        v vVar = new v();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vVar.populateBuilderWithField(aVar4, vVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rVar.iAd.add(vVar);
                    }
                    AppMethodBeat.o(116414);
                    return 0;
                case 7:
                    rVar.iAe = aVar3.UbS.zi();
                    AppMethodBeat.o(116414);
                    return 0;
                default:
                    AppMethodBeat.o(116414);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116414);
            return -1;
        }
    }
}

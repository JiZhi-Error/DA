package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkr extends a {
    public int KUh;
    public String KUk;
    public String KWA;
    public LinkedList<String> KWr = new LinkedList<>();
    public String Luj;
    public String Luk;
    public LinkedList<dlb> MOG = new LinkedList<>();
    public int MOH;
    public String MOI;

    public dkr() {
        AppMethodBeat.i(212294);
        AppMethodBeat.o(212294);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212295);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWA != null) {
                aVar.e(1, this.KWA);
            }
            aVar.e(2, 8, this.MOG);
            aVar.aM(3, this.KUh);
            aVar.aM(4, this.MOH);
            if (this.KUk != null) {
                aVar.e(5, this.KUk);
            }
            aVar.e(6, 1, this.KWr);
            if (this.Luk != null) {
                aVar.e(7, this.Luk);
            }
            if (this.Luj != null) {
                aVar.e(8, this.Luj);
            }
            if (this.MOI != null) {
                aVar.e(9, this.MOI);
            }
            AppMethodBeat.o(212295);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KWA != null ? g.a.a.b.b.a.f(1, this.KWA) + 0 : 0) + g.a.a.a.c(2, 8, this.MOG) + g.a.a.b.b.a.bu(3, this.KUh) + g.a.a.b.b.a.bu(4, this.MOH);
            if (this.KUk != null) {
                f2 += g.a.a.b.b.a.f(5, this.KUk);
            }
            int c2 = f2 + g.a.a.a.c(6, 1, this.KWr);
            if (this.Luk != null) {
                c2 += g.a.a.b.b.a.f(7, this.Luk);
            }
            if (this.Luj != null) {
                c2 += g.a.a.b.b.a.f(8, this.Luj);
            }
            if (this.MOI != null) {
                c2 += g.a.a.b.b.a.f(9, this.MOI);
            }
            AppMethodBeat.o(212295);
            return c2;
        } else if (i2 == 2) {
            this.MOG.clear();
            this.KWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212295);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkr dkr = (dkr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dkr.KWA = aVar3.UbS.readString();
                    AppMethodBeat.o(212295);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlb dlb = new dlb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlb.populateBuilderWithField(aVar4, dlb, a.getNextFieldNumber(aVar4))) {
                        }
                        dkr.MOG.add(dlb);
                    }
                    AppMethodBeat.o(212295);
                    return 0;
                case 3:
                    dkr.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(212295);
                    return 0;
                case 4:
                    dkr.MOH = aVar3.UbS.zi();
                    AppMethodBeat.o(212295);
                    return 0;
                case 5:
                    dkr.KUk = aVar3.UbS.readString();
                    AppMethodBeat.o(212295);
                    return 0;
                case 6:
                    dkr.KWr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212295);
                    return 0;
                case 7:
                    dkr.Luk = aVar3.UbS.readString();
                    AppMethodBeat.o(212295);
                    return 0;
                case 8:
                    dkr.Luj = aVar3.UbS.readString();
                    AppMethodBeat.o(212295);
                    return 0;
                case 9:
                    dkr.MOI = aVar3.UbS.readString();
                    AppMethodBeat.o(212295);
                    return 0;
                default:
                    AppMethodBeat.o(212295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212295);
            return -1;
        }
    }
}

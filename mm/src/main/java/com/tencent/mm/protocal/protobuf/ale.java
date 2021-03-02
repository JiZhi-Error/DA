package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ale extends a {
    public int KHa;
    public LinkedList<pj> KUf = new LinkedList<>();
    public String KUk;
    public String KUo;
    public LinkedList<String> KWr = new LinkedList<>();
    public int KWs;
    public long KWz;
    public String Lug;
    public String Luh;
    public String Lui;
    public String Luj;
    public String Luk;

    public ale() {
        AppMethodBeat.i(212273);
        AppMethodBeat.o(212273);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212274);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lug != null) {
                aVar.e(1, this.Lug);
            }
            if (this.Luh != null) {
                aVar.e(2, this.Luh);
            }
            aVar.bb(3, this.KWz);
            aVar.e(4, 8, this.KUf);
            aVar.aM(5, this.KHa);
            if (this.Lui != null) {
                aVar.e(6, this.Lui);
            }
            if (this.KUk != null) {
                aVar.e(7, this.KUk);
            }
            if (this.KUo != null) {
                aVar.e(8, this.KUo);
            }
            aVar.e(9, 1, this.KWr);
            aVar.aM(10, this.KWs);
            if (this.Luj != null) {
                aVar.e(11, this.Luj);
            }
            if (this.Luk != null) {
                aVar.e(12, this.Luk);
            }
            AppMethodBeat.o(212274);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lug != null ? g.a.a.b.b.a.f(1, this.Lug) + 0 : 0;
            if (this.Luh != null) {
                f2 += g.a.a.b.b.a.f(2, this.Luh);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.KWz) + g.a.a.a.c(4, 8, this.KUf) + g.a.a.b.b.a.bu(5, this.KHa);
            if (this.Lui != null) {
                r += g.a.a.b.b.a.f(6, this.Lui);
            }
            if (this.KUk != null) {
                r += g.a.a.b.b.a.f(7, this.KUk);
            }
            if (this.KUo != null) {
                r += g.a.a.b.b.a.f(8, this.KUo);
            }
            int c2 = r + g.a.a.a.c(9, 1, this.KWr) + g.a.a.b.b.a.bu(10, this.KWs);
            if (this.Luj != null) {
                c2 += g.a.a.b.b.a.f(11, this.Luj);
            }
            if (this.Luk != null) {
                c2 += g.a.a.b.b.a.f(12, this.Luk);
            }
            AppMethodBeat.o(212274);
            return c2;
        } else if (i2 == 2) {
            this.KUf.clear();
            this.KWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212274);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ale ale = (ale) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ale.Lug = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 2:
                    ale.Luh = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 3:
                    ale.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(212274);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pj pjVar = new pj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pjVar.populateBuilderWithField(aVar4, pjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ale.KUf.add(pjVar);
                    }
                    AppMethodBeat.o(212274);
                    return 0;
                case 5:
                    ale.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(212274);
                    return 0;
                case 6:
                    ale.Lui = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 7:
                    ale.KUk = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 8:
                    ale.KUo = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 9:
                    ale.KWr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212274);
                    return 0;
                case 10:
                    ale.KWs = aVar3.UbS.zi();
                    AppMethodBeat.o(212274);
                    return 0;
                case 11:
                    ale.Luj = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                case 12:
                    ale.Luk = aVar3.UbS.readString();
                    AppMethodBeat.o(212274);
                    return 0;
                default:
                    AppMethodBeat.o(212274);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212274);
            return -1;
        }
    }
}

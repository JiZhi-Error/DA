package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aaj extends a {
    public int KOj;
    public int Llx;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String hih;
    public int oUA;
    public int rBx;
    public LinkedList<cfu> xKD = new LinkedList<>();

    public aaj() {
        AppMethodBeat.i(143965);
        AppMethodBeat.o(143965);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143966);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.rBx);
            if (this.hif != null) {
                aVar.e(7, this.hif);
            }
            aVar.aM(2, this.KOj);
            aVar.aM(3, this.Llx);
            aVar.e(4, 8, this.xKD);
            if (this.hid != null) {
                aVar.e(5, this.hid);
            }
            if (this.hie != null) {
                aVar.e(6, this.hie);
            }
            if (this.hig != null) {
                aVar.e(8, this.hig);
            }
            if (this.hih != null) {
                aVar.e(9, this.hih);
            }
            aVar.aM(10, this.oUA);
            AppMethodBeat.o(143966);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.rBx) + 0;
            if (this.hif != null) {
                bu += g.a.a.b.b.a.f(7, this.hif);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(2, this.KOj) + g.a.a.b.b.a.bu(3, this.Llx) + g.a.a.a.c(4, 8, this.xKD);
            if (this.hid != null) {
                bu2 += g.a.a.b.b.a.f(5, this.hid);
            }
            if (this.hie != null) {
                bu2 += g.a.a.b.b.a.f(6, this.hie);
            }
            if (this.hig != null) {
                bu2 += g.a.a.b.b.a.f(8, this.hig);
            }
            if (this.hih != null) {
                bu2 += g.a.a.b.b.a.f(9, this.hih);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.oUA);
            AppMethodBeat.o(143966);
            return bu3;
        } else if (i2 == 2) {
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143966);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aaj aaj = (aaj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aaj.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(143966);
                    return 0;
                case 2:
                    aaj.KOj = aVar3.UbS.zi();
                    AppMethodBeat.o(143966);
                    return 0;
                case 3:
                    aaj.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(143966);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfu cfu = new cfu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfu.populateBuilderWithField(aVar4, cfu, a.getNextFieldNumber(aVar4))) {
                        }
                        aaj.xKD.add(cfu);
                    }
                    AppMethodBeat.o(143966);
                    return 0;
                case 5:
                    aaj.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(143966);
                    return 0;
                case 6:
                    aaj.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(143966);
                    return 0;
                case 7:
                    aaj.hif = aVar3.UbS.readString();
                    AppMethodBeat.o(143966);
                    return 0;
                case 8:
                    aaj.hig = aVar3.UbS.readString();
                    AppMethodBeat.o(143966);
                    return 0;
                case 9:
                    aaj.hih = aVar3.UbS.readString();
                    AppMethodBeat.o(143966);
                    return 0;
                case 10:
                    aaj.oUA = aVar3.UbS.zi();
                    AppMethodBeat.o(143966);
                    return 0;
                default:
                    AppMethodBeat.o(143966);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143966);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ekt extends a {
    public int Height;
    public int Ltr;
    public String Nka;
    public String Nkb;
    public int Nkc;
    public int Nkd;
    public int Width;
    public int X;
    public int Y;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(120960);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.X);
            aVar.aM(2, this.Y);
            aVar.aM(3, this.Width);
            aVar.aM(4, this.Height);
            if (this.Nka != null) {
                aVar.e(5, this.Nka);
            }
            if (this.Nkb != null) {
                aVar.e(6, this.Nkb);
            }
            aVar.aM(7, this.Nkc);
            aVar.aM(8, this.Ltr);
            aVar.aM(9, this.Nkd);
            AppMethodBeat.o(120960);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.X) + 0 + g.a.a.b.b.a.bu(2, this.Y) + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height);
            if (this.Nka != null) {
                bu += g.a.a.b.b.a.f(5, this.Nka);
            }
            if (this.Nkb != null) {
                bu += g.a.a.b.b.a.f(6, this.Nkb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Nkc) + g.a.a.b.b.a.bu(8, this.Ltr) + g.a.a.b.b.a.bu(9, this.Nkd);
            AppMethodBeat.o(120960);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(120960);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekt ekt = (ekt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekt.X = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 2:
                    ekt.Y = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 3:
                    ekt.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 4:
                    ekt.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 5:
                    ekt.Nka = aVar3.UbS.readString();
                    AppMethodBeat.o(120960);
                    return 0;
                case 6:
                    ekt.Nkb = aVar3.UbS.readString();
                    AppMethodBeat.o(120960);
                    return 0;
                case 7:
                    ekt.Nkc = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 8:
                    ekt.Ltr = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                case 9:
                    ekt.Nkd = aVar3.UbS.zi();
                    AppMethodBeat.o(120960);
                    return 0;
                default:
                    AppMethodBeat.o(120960);
                    return -1;
            }
        } else {
            AppMethodBeat.o(120960);
            return -1;
        }
    }
}

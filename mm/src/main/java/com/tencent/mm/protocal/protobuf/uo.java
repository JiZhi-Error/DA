package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class uo extends a {
    public int DhD;
    public int Gaz;
    public String gTB;
    public String text;
    public int type;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113966);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.text != null) {
                aVar.e(2, this.text);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.aM(4, this.DhD);
            aVar.aM(5, this.Gaz);
            if (this.gTB != null) {
                aVar.e(6, this.gTB);
            }
            AppMethodBeat.o(113966);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.text != null) {
                bu += g.a.a.b.b.a.f(2, this.text);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(3, this.url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.DhD) + g.a.a.b.b.a.bu(5, this.Gaz);
            if (this.gTB != null) {
                bu2 += g.a.a.b.b.a.f(6, this.gTB);
            }
            AppMethodBeat.o(113966);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113966);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            uo uoVar = (uo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uoVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(113966);
                    return 0;
                case 2:
                    uoVar.text = aVar3.UbS.readString();
                    AppMethodBeat.o(113966);
                    return 0;
                case 3:
                    uoVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(113966);
                    return 0;
                case 4:
                    uoVar.DhD = aVar3.UbS.zi();
                    AppMethodBeat.o(113966);
                    return 0;
                case 5:
                    uoVar.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(113966);
                    return 0;
                case 6:
                    uoVar.gTB = aVar3.UbS.readString();
                    AppMethodBeat.o(113966);
                    return 0;
                default:
                    AppMethodBeat.o(113966);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113966);
            return -1;
        }
    }
}

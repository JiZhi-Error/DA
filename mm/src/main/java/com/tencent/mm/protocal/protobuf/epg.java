package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class epg extends a {
    public String HZV;
    public String HZW;
    public String HZX;
    public int NgM;
    public int gTx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200233);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.gTx);
            if (this.HZV != null) {
                aVar.e(2, this.HZV);
            }
            if (this.HZW != null) {
                aVar.e(3, this.HZW);
            }
            if (this.HZX != null) {
                aVar.e(4, this.HZX);
            }
            aVar.aM(5, this.NgM);
            AppMethodBeat.o(200233);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.gTx) + 0;
            if (this.HZV != null) {
                bu += g.a.a.b.b.a.f(2, this.HZV);
            }
            if (this.HZW != null) {
                bu += g.a.a.b.b.a.f(3, this.HZW);
            }
            if (this.HZX != null) {
                bu += g.a.a.b.b.a.f(4, this.HZX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.NgM);
            AppMethodBeat.o(200233);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200233);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epg epg = (epg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epg.gTx = aVar3.UbS.zi();
                    AppMethodBeat.o(200233);
                    return 0;
                case 2:
                    epg.HZV = aVar3.UbS.readString();
                    AppMethodBeat.o(200233);
                    return 0;
                case 3:
                    epg.HZW = aVar3.UbS.readString();
                    AppMethodBeat.o(200233);
                    return 0;
                case 4:
                    epg.HZX = aVar3.UbS.readString();
                    AppMethodBeat.o(200233);
                    return 0;
                case 5:
                    epg.NgM = aVar3.UbS.zi();
                    AppMethodBeat.o(200233);
                    return 0;
                default:
                    AppMethodBeat.o(200233);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200233);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fel extends a {
    public int KRN;
    public String MOt;
    public int Mzg;
    public String NzF;
    public int NzG;
    public boolean NzH = false;
    public boolean NzI = false;
    public String session_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117961);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KRN);
            aVar.aM(2, this.Mzg);
            if (this.session_id != null) {
                aVar.e(3, this.session_id);
            }
            if (this.NzF != null) {
                aVar.e(4, this.NzF);
            }
            if (this.MOt != null) {
                aVar.e(5, this.MOt);
            }
            aVar.aM(6, this.NzG);
            aVar.cc(7, this.NzH);
            aVar.cc(8, this.NzI);
            AppMethodBeat.o(117961);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KRN) + 0 + g.a.a.b.b.a.bu(2, this.Mzg);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(3, this.session_id);
            }
            if (this.NzF != null) {
                bu += g.a.a.b.b.a.f(4, this.NzF);
            }
            if (this.MOt != null) {
                bu += g.a.a.b.b.a.f(5, this.MOt);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.NzG) + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(117961);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117961);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fel fel = (fel) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fel.KRN = aVar3.UbS.zi();
                    AppMethodBeat.o(117961);
                    return 0;
                case 2:
                    fel.Mzg = aVar3.UbS.zi();
                    AppMethodBeat.o(117961);
                    return 0;
                case 3:
                    fel.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(117961);
                    return 0;
                case 4:
                    fel.NzF = aVar3.UbS.readString();
                    AppMethodBeat.o(117961);
                    return 0;
                case 5:
                    fel.MOt = aVar3.UbS.readString();
                    AppMethodBeat.o(117961);
                    return 0;
                case 6:
                    fel.NzG = aVar3.UbS.zi();
                    AppMethodBeat.o(117961);
                    return 0;
                case 7:
                    fel.NzH = aVar3.UbS.yZ();
                    AppMethodBeat.o(117961);
                    return 0;
                case 8:
                    fel.NzI = aVar3.UbS.yZ();
                    AppMethodBeat.o(117961);
                    return 0;
                default:
                    AppMethodBeat.o(117961);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117961);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cru extends a {
    public int Eso;
    public String MwQ;
    public String MwR;
    public int MwS;
    public boolean MwT;
    public String gCr;
    public String nickname;
    public String tag;
    public String title;
    public int xlQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208708);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.nickname != null) {
                aVar.e(1, this.nickname);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.MwQ != null) {
                aVar.e(3, this.MwQ);
            }
            aVar.aM(4, this.Eso);
            if (this.gCr != null) {
                aVar.e(5, this.gCr);
            }
            if (this.MwR != null) {
                aVar.e(6, this.MwR);
            }
            aVar.aM(7, this.MwS);
            aVar.cc(8, this.MwT);
            if (this.tag != null) {
                aVar.e(9, this.tag);
            }
            aVar.aM(10, this.xlQ);
            AppMethodBeat.o(208708);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.nickname != null ? g.a.a.b.b.a.f(1, this.nickname) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.MwQ != null) {
                f2 += g.a.a.b.b.a.f(3, this.MwQ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Eso);
            if (this.gCr != null) {
                bu += g.a.a.b.b.a.f(5, this.gCr);
            }
            if (this.MwR != null) {
                bu += g.a.a.b.b.a.f(6, this.MwR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MwS) + g.a.a.b.b.a.fS(8) + 1;
            if (this.tag != null) {
                bu2 += g.a.a.b.b.a.f(9, this.tag);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.xlQ);
            AppMethodBeat.o(208708);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208708);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cru cru = (cru) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cru.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 2:
                    cru.title = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 3:
                    cru.MwQ = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 4:
                    cru.Eso = aVar3.UbS.zi();
                    AppMethodBeat.o(208708);
                    return 0;
                case 5:
                    cru.gCr = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 6:
                    cru.MwR = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 7:
                    cru.MwS = aVar3.UbS.zi();
                    AppMethodBeat.o(208708);
                    return 0;
                case 8:
                    cru.MwT = aVar3.UbS.yZ();
                    AppMethodBeat.o(208708);
                    return 0;
                case 9:
                    cru.tag = aVar3.UbS.readString();
                    AppMethodBeat.o(208708);
                    return 0;
                case 10:
                    cru.xlQ = aVar3.UbS.zi();
                    AppMethodBeat.o(208708);
                    return 0;
                default:
                    AppMethodBeat.o(208708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208708);
            return -1;
        }
    }
}

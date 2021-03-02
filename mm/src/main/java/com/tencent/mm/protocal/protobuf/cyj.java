package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cyj extends a {
    public int KIl;
    public int MDi;
    public String dNI;
    public String nHd;
    public String nHe;
    public String nHi;
    public int position;
    public String request_id;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50096);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nHd != null) {
                aVar.e(2, this.nHd);
            }
            if (this.request_id != null) {
                aVar.e(3, this.request_id);
            }
            if (this.nHe != null) {
                aVar.e(4, this.nHe);
            }
            if (this.dNI != null) {
                aVar.e(5, this.dNI);
            }
            if (this.nHi != null) {
                aVar.e(6, this.nHi);
            }
            aVar.aM(7, this.position);
            aVar.aM(8, this.MDi);
            aVar.aM(9, this.KIl);
            AppMethodBeat.o(50096);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nHd != null) {
                f2 += g.a.a.b.b.a.f(2, this.nHd);
            }
            if (this.request_id != null) {
                f2 += g.a.a.b.b.a.f(3, this.request_id);
            }
            if (this.nHe != null) {
                f2 += g.a.a.b.b.a.f(4, this.nHe);
            }
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(5, this.dNI);
            }
            if (this.nHi != null) {
                f2 += g.a.a.b.b.a.f(6, this.nHi);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.position) + g.a.a.b.b.a.bu(8, this.MDi) + g.a.a.b.b.a.bu(9, this.KIl);
            AppMethodBeat.o(50096);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50096);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyj cyj = (cyj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 2:
                    cyj.nHd = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 3:
                    cyj.request_id = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 4:
                    cyj.nHe = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 5:
                    cyj.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 6:
                    cyj.nHi = aVar3.UbS.readString();
                    AppMethodBeat.o(50096);
                    return 0;
                case 7:
                    cyj.position = aVar3.UbS.zi();
                    AppMethodBeat.o(50096);
                    return 0;
                case 8:
                    cyj.MDi = aVar3.UbS.zi();
                    AppMethodBeat.o(50096);
                    return 0;
                case 9:
                    cyj.KIl = aVar3.UbS.zi();
                    AppMethodBeat.o(50096);
                    return 0;
                default:
                    AppMethodBeat.o(50096);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50096);
            return -1;
        }
    }
}

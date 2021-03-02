package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ekw extends a {
    public b Nkg;
    public String Nkh;
    public b Nki;
    public int uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82480);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nkg != null) {
                aVar.c(1, this.Nkg);
            }
            if (this.Nkh != null) {
                aVar.e(2, this.Nkh);
            }
            if (this.Nki != null) {
                aVar.c(3, this.Nki);
            }
            aVar.aM(4, this.uin);
            AppMethodBeat.o(82480);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.Nkg != null ? g.a.a.b.b.a.b(1, this.Nkg) + 0 : 0;
            if (this.Nkh != null) {
                b2 += g.a.a.b.b.a.f(2, this.Nkh);
            }
            if (this.Nki != null) {
                b2 += g.a.a.b.b.a.b(3, this.Nki);
            }
            int bu = b2 + g.a.a.b.b.a.bu(4, this.uin);
            AppMethodBeat.o(82480);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82480);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekw ekw = (ekw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekw.Nkg = aVar3.UbS.hPo();
                    AppMethodBeat.o(82480);
                    return 0;
                case 2:
                    ekw.Nkh = aVar3.UbS.readString();
                    AppMethodBeat.o(82480);
                    return 0;
                case 3:
                    ekw.Nki = aVar3.UbS.hPo();
                    AppMethodBeat.o(82480);
                    return 0;
                case 4:
                    ekw.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(82480);
                    return 0;
                default:
                    AppMethodBeat.o(82480);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82480);
            return -1;
        }
    }
}

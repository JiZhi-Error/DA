package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbq extends a {
    public long Brn;
    public String KIz;
    public int LWr;
    public long Mhx;
    public String UserName;
    public String jfM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194543);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Brn);
            aVar.bb(2, this.Mhx);
            if (this.jfM != null) {
                aVar.e(3, this.jfM);
            }
            aVar.aM(4, this.LWr);
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            if (this.KIz != null) {
                aVar.e(6, this.KIz);
            }
            AppMethodBeat.o(194543);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Brn) + 0 + g.a.a.b.b.a.r(2, this.Mhx);
            if (this.jfM != null) {
                r += g.a.a.b.b.a.f(3, this.jfM);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.LWr);
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(6, this.KIz);
            }
            AppMethodBeat.o(194543);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194543);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbq cbq = (cbq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbq.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(194543);
                    return 0;
                case 2:
                    cbq.Mhx = aVar3.UbS.zl();
                    AppMethodBeat.o(194543);
                    return 0;
                case 3:
                    cbq.jfM = aVar3.UbS.readString();
                    AppMethodBeat.o(194543);
                    return 0;
                case 4:
                    cbq.LWr = aVar3.UbS.zi();
                    AppMethodBeat.o(194543);
                    return 0;
                case 5:
                    cbq.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(194543);
                    return 0;
                case 6:
                    cbq.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(194543);
                    return 0;
                default:
                    AppMethodBeat.o(194543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194543);
            return -1;
        }
    }
}

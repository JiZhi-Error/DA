package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class fcn extends a {
    public int KWR;
    public int KXC;
    public long Nys;
    public boolean Nyt;
    public String Nyu;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123692);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aM(2, this.KWR);
            aVar.aM(3, this.KXC);
            aVar.bb(4, this.Nys);
            aVar.cc(5, this.Nyt);
            if (this.Nyu != null) {
                aVar.e(6, this.Nyu);
            }
            AppMethodBeat.o(123692);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KWR) + g.a.a.b.b.a.bu(3, this.KXC) + g.a.a.b.b.a.r(4, this.Nys) + g.a.a.b.b.a.fS(5) + 1;
            if (this.Nyu != null) {
                f2 += g.a.a.b.b.a.f(6, this.Nyu);
            }
            AppMethodBeat.o(123692);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123692);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcn fcn = (fcn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fcn.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123692);
                    return 0;
                case 2:
                    fcn.KWR = aVar3.UbS.zi();
                    AppMethodBeat.o(123692);
                    return 0;
                case 3:
                    fcn.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(123692);
                    return 0;
                case 4:
                    fcn.Nys = aVar3.UbS.zl();
                    AppMethodBeat.o(123692);
                    return 0;
                case 5:
                    fcn.Nyt = aVar3.UbS.yZ();
                    AppMethodBeat.o(123692);
                    return 0;
                case 6:
                    fcn.Nyu = aVar3.UbS.readString();
                    AppMethodBeat.o(123692);
                    return 0;
                default:
                    AppMethodBeat.o(123692);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123692);
            return -1;
        }
    }
}

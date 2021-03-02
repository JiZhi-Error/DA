package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ddc extends a {
    public String Cqk;
    public int action;
    public String dQx;
    public String url;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214316);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            aVar.aM(2, this.action);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            if (this.Cqk != null) {
                aVar.e(5, this.Cqk);
            }
            AppMethodBeat.o(214316);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.action);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(4, this.username);
            }
            if (this.Cqk != null) {
                f2 += g.a.a.b.b.a.f(5, this.Cqk);
            }
            AppMethodBeat.o(214316);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214316);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddc ddc = (ddc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddc.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(214316);
                    return 0;
                case 2:
                    ddc.action = aVar3.UbS.zi();
                    AppMethodBeat.o(214316);
                    return 0;
                case 3:
                    ddc.url = aVar3.UbS.readString();
                    AppMethodBeat.o(214316);
                    return 0;
                case 4:
                    ddc.username = aVar3.UbS.readString();
                    AppMethodBeat.o(214316);
                    return 0;
                case 5:
                    ddc.Cqk = aVar3.UbS.readString();
                    AppMethodBeat.o(214316);
                    return 0;
                default:
                    AppMethodBeat.o(214316);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214316);
            return -1;
        }
    }
}

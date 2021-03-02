package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bhd extends a {
    public String LQV;
    public String LQW;
    public b LQX;
    public String UserName;
    public int him;
    public String jfi;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223886);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xut != null) {
                aVar.e(1, this.xut);
            }
            if (this.LQV != null) {
                aVar.e(2, this.LQV);
            }
            if (this.LQW != null) {
                aVar.e(3, this.LQW);
            }
            aVar.aM(4, this.him);
            if (this.LQX != null) {
                aVar.c(5, this.LQX);
            }
            if (this.jfi != null) {
                aVar.e(6, this.jfi);
            }
            if (this.UserName != null) {
                aVar.e(7, this.UserName);
            }
            AppMethodBeat.o(223886);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xut != null ? g.a.a.b.b.a.f(1, this.xut) + 0 : 0;
            if (this.LQV != null) {
                f2 += g.a.a.b.b.a.f(2, this.LQV);
            }
            if (this.LQW != null) {
                f2 += g.a.a.b.b.a.f(3, this.LQW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.him);
            if (this.LQX != null) {
                bu += g.a.a.b.b.a.b(5, this.LQX);
            }
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(6, this.jfi);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(7, this.UserName);
            }
            AppMethodBeat.o(223886);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(223886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhd bhd = (bhd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhd.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(223886);
                    return 0;
                case 2:
                    bhd.LQV = aVar3.UbS.readString();
                    AppMethodBeat.o(223886);
                    return 0;
                case 3:
                    bhd.LQW = aVar3.UbS.readString();
                    AppMethodBeat.o(223886);
                    return 0;
                case 4:
                    bhd.him = aVar3.UbS.zi();
                    AppMethodBeat.o(223886);
                    return 0;
                case 5:
                    bhd.LQX = aVar3.UbS.hPo();
                    AppMethodBeat.o(223886);
                    return 0;
                case 6:
                    bhd.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(223886);
                    return 0;
                case 7:
                    bhd.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(223886);
                    return 0;
                default:
                    AppMethodBeat.o(223886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(223886);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ao extends a {
    public String Btb;
    public String md5;
    public String name;
    public int size;
    public long uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198633);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uin);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.aM(3, this.size);
            if (this.Btb != null) {
                aVar.e(4, this.Btb);
            }
            if (this.md5 != null) {
                aVar.e(5, this.md5);
            }
            AppMethodBeat.o(198633);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uin) + 0;
            if (this.name != null) {
                r += g.a.a.b.b.a.f(2, this.name);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.size);
            if (this.Btb != null) {
                bu += g.a.a.b.b.a.f(4, this.Btb);
            }
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(5, this.md5);
            }
            AppMethodBeat.o(198633);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198633);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ao aoVar = (ao) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoVar.uin = aVar3.UbS.zl();
                    AppMethodBeat.o(198633);
                    return 0;
                case 2:
                    aoVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(198633);
                    return 0;
                case 3:
                    aoVar.size = aVar3.UbS.zi();
                    AppMethodBeat.o(198633);
                    return 0;
                case 4:
                    aoVar.Btb = aVar3.UbS.readString();
                    AppMethodBeat.o(198633);
                    return 0;
                case 5:
                    aoVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(198633);
                    return 0;
                default:
                    AppMethodBeat.o(198633);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198633);
            return -1;
        }
    }
}

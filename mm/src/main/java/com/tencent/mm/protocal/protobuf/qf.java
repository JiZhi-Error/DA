package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qf extends a {
    public String KXd;
    public String KXe;
    public String KXf;
    public long KXg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212261);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXd != null) {
                aVar.e(1, this.KXd);
            }
            if (this.KXe != null) {
                aVar.e(2, this.KXe);
            }
            if (this.KXf != null) {
                aVar.e(3, this.KXf);
            }
            aVar.bb(4, this.KXg);
            AppMethodBeat.o(212261);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KXd != null ? g.a.a.b.b.a.f(1, this.KXd) + 0 : 0;
            if (this.KXe != null) {
                f2 += g.a.a.b.b.a.f(2, this.KXe);
            }
            if (this.KXf != null) {
                f2 += g.a.a.b.b.a.f(3, this.KXf);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.KXg);
            AppMethodBeat.o(212261);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212261);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qf qfVar = (qf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qfVar.KXd = aVar3.UbS.readString();
                    AppMethodBeat.o(212261);
                    return 0;
                case 2:
                    qfVar.KXe = aVar3.UbS.readString();
                    AppMethodBeat.o(212261);
                    return 0;
                case 3:
                    qfVar.KXf = aVar3.UbS.readString();
                    AppMethodBeat.o(212261);
                    return 0;
                case 4:
                    qfVar.KXg = aVar3.UbS.zl();
                    AppMethodBeat.o(212261);
                    return 0;
                default:
                    AppMethodBeat.o(212261);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212261);
            return -1;
        }
    }
}

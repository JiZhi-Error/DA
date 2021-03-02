package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class feg extends a {
    public String desc;
    public String qGB;
    public String title;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153334);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGB != null) {
                aVar.e(1, this.qGB);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            AppMethodBeat.o(153334);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.qGB != null ? g.a.a.b.b.a.f(1, this.qGB) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(4, this.username);
            }
            AppMethodBeat.o(153334);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153334);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            feg feg = (feg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    feg.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(153334);
                    return 0;
                case 2:
                    feg.title = aVar3.UbS.readString();
                    AppMethodBeat.o(153334);
                    return 0;
                case 3:
                    feg.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(153334);
                    return 0;
                case 4:
                    feg.username = aVar3.UbS.readString();
                    AppMethodBeat.o(153334);
                    return 0;
                default:
                    AppMethodBeat.o(153334);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153334);
            return -1;
        }
    }
}

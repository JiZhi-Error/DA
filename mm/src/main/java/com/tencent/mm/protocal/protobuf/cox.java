package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cox extends a {
    public String desc;
    public String iwv;
    public String path;
    public String title;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91539);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iwv != null) {
                aVar.e(1, this.iwv);
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
            if (this.path != null) {
                aVar.e(5, this.path);
            }
            AppMethodBeat.o(91539);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.iwv != null ? g.a.a.b.b.a.f(1, this.iwv) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(4, this.username);
            }
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(5, this.path);
            }
            AppMethodBeat.o(91539);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cox cox = (cox) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cox.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(91539);
                    return 0;
                case 2:
                    cox.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91539);
                    return 0;
                case 3:
                    cox.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(91539);
                    return 0;
                case 4:
                    cox.username = aVar3.UbS.readString();
                    AppMethodBeat.o(91539);
                    return 0;
                case 5:
                    cox.path = aVar3.UbS.readString();
                    AppMethodBeat.o(91539);
                    return 0;
                default:
                    AppMethodBeat.o(91539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91539);
            return -1;
        }
    }
}

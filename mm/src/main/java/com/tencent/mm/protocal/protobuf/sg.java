package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class sg extends a {
    public String icon;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32152);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.icon != null) {
                aVar.e(3, this.icon);
            }
            AppMethodBeat.o(32152);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(3, this.icon);
            }
            AppMethodBeat.o(32152);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32152);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sg sgVar = (sg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sgVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(32152);
                    return 0;
                case 2:
                    sgVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(32152);
                    return 0;
                case 3:
                    sgVar.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(32152);
                    return 0;
                default:
                    AppMethodBeat.o(32152);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32152);
            return -1;
        }
    }
}

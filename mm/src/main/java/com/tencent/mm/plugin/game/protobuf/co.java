package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class co extends a {
    public String IconUrl;
    public String Title;
    public String xIy;
    public String xMx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41801);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.xIy != null) {
                aVar.e(3, this.xIy);
            }
            if (this.xMx != null) {
                aVar.e(4, this.xMx);
            }
            AppMethodBeat.o(41801);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIy);
            }
            if (this.xMx != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMx);
            }
            AppMethodBeat.o(41801);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41801);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            co coVar = (co) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41801);
                    return 0;
                case 2:
                    coVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41801);
                    return 0;
                case 3:
                    coVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41801);
                    return 0;
                case 4:
                    coVar.xMx = aVar3.UbS.readString();
                    AppMethodBeat.o(41801);
                    return 0;
                default:
                    AppMethodBeat.o(41801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41801);
            return -1;
        }
    }
}

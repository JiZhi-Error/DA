package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ci extends a {
    public String Title;
    public String xIB;
    public String xKd;
    public String xMl;
    public String xMo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41795);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41795);
                throw bVar;
            }
            if (this.xMl != null) {
                aVar.e(1, this.xMl);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.xKd != null) {
                aVar.e(3, this.xKd);
            }
            if (this.xIB != null) {
                aVar.e(4, this.xIB);
            }
            if (this.xMo != null) {
                aVar.e(5, this.xMo);
            }
            AppMethodBeat.o(41795);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMl != null ? g.a.a.b.b.a.f(1, this.xMl) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.xKd != null) {
                f2 += g.a.a.b.b.a.f(3, this.xKd);
            }
            if (this.xIB != null) {
                f2 += g.a.a.b.b.a.f(4, this.xIB);
            }
            if (this.xMo != null) {
                f2 += g.a.a.b.b.a.f(5, this.xMo);
            }
            AppMethodBeat.o(41795);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41795);
                throw bVar2;
            }
            AppMethodBeat.o(41795);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ci ciVar = (ci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciVar.xMl = aVar3.UbS.readString();
                    AppMethodBeat.o(41795);
                    return 0;
                case 2:
                    ciVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41795);
                    return 0;
                case 3:
                    ciVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(41795);
                    return 0;
                case 4:
                    ciVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41795);
                    return 0;
                case 5:
                    ciVar.xMo = aVar3.UbS.readString();
                    AppMethodBeat.o(41795);
                    return 0;
                default:
                    AppMethodBeat.o(41795);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41795);
            return -1;
        }
    }
}

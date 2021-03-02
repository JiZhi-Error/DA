package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cf extends a {
    public String Title;
    public String xIB;
    public String xKd;
    public String xMl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41791);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMl == null) {
                b bVar = new b("Not all required fields were included: LogoURL");
                AppMethodBeat.o(41791);
                throw bVar;
            } else if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41791);
                throw bVar2;
            } else if (this.xKd == null) {
                b bVar3 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41791);
                throw bVar3;
            } else if (this.xIB == null) {
                b bVar4 = new b("Not all required fields were included: WebURL");
                AppMethodBeat.o(41791);
                throw bVar4;
            } else {
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
                AppMethodBeat.o(41791);
                return 0;
            }
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
            AppMethodBeat.o(41791);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xMl == null) {
                b bVar5 = new b("Not all required fields were included: LogoURL");
                AppMethodBeat.o(41791);
                throw bVar5;
            } else if (this.Title == null) {
                b bVar6 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41791);
                throw bVar6;
            } else if (this.xKd == null) {
                b bVar7 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41791);
                throw bVar7;
            } else if (this.xIB == null) {
                b bVar8 = new b("Not all required fields were included: WebURL");
                AppMethodBeat.o(41791);
                throw bVar8;
            } else {
                AppMethodBeat.o(41791);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfVar.xMl = aVar3.UbS.readString();
                    AppMethodBeat.o(41791);
                    return 0;
                case 2:
                    cfVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41791);
                    return 0;
                case 3:
                    cfVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(41791);
                    return 0;
                case 4:
                    cfVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41791);
                    return 0;
                default:
                    AppMethodBeat.o(41791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41791);
            return -1;
        }
    }
}

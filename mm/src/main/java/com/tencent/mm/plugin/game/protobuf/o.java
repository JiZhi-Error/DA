package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class o extends a {
    public String Desc;
    public String IconUrl;
    public String Title;
    public String xIy;
    public String xJt;
    public int xJv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41715);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.IconUrl == null) {
                b bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(41715);
                throw bVar;
            } else if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41715);
                throw bVar2;
            } else if (this.xIy == null) {
                b bVar3 = new b("Not all required fields were included: JumpUrl");
                AppMethodBeat.o(41715);
                throw bVar3;
            } else {
                if (this.IconUrl != null) {
                    aVar.e(1, this.IconUrl);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(3, this.Desc);
                }
                if (this.xIy != null) {
                    aVar.e(4, this.xIy);
                }
                aVar.aM(5, this.xJv);
                if (this.xJt != null) {
                    aVar.e(6, this.xJt);
                }
                AppMethodBeat.o(41715);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.IconUrl != null ? g.a.a.b.b.a.f(1, this.IconUrl) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(4, this.xIy);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.xJv);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(6, this.xJt);
            }
            AppMethodBeat.o(41715);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.IconUrl == null) {
                b bVar4 = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(41715);
                throw bVar4;
            } else if (this.Title == null) {
                b bVar5 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41715);
                throw bVar5;
            } else if (this.xIy == null) {
                b bVar6 = new b("Not all required fields were included: JumpUrl");
                AppMethodBeat.o(41715);
                throw bVar6;
            } else {
                AppMethodBeat.o(41715);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41715);
                    return 0;
                case 2:
                    oVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41715);
                    return 0;
                case 3:
                    oVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41715);
                    return 0;
                case 4:
                    oVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41715);
                    return 0;
                case 5:
                    oVar.xJv = aVar3.UbS.zi();
                    AppMethodBeat.o(41715);
                    return 0;
                case 6:
                    oVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41715);
                    return 0;
                default:
                    AppMethodBeat.o(41715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41715);
            return -1;
        }
    }
}

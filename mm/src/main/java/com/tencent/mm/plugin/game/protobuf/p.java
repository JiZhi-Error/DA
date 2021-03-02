package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class p extends a {
    public String Url;
    public String xJA;
    public String xJB;
    public String xJz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41716);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJz == null) {
                b bVar = new b("Not all required fields were included: Message");
                AppMethodBeat.o(41716);
                throw bVar;
            } else if (this.xJA == null) {
                b bVar2 = new b("Not all required fields were included: GotoBtn");
                AppMethodBeat.o(41716);
                throw bVar2;
            } else if (this.xJB == null) {
                b bVar3 = new b("Not all required fields were included: CancelBtn");
                AppMethodBeat.o(41716);
                throw bVar3;
            } else if (this.Url == null) {
                b bVar4 = new b("Not all required fields were included: Url");
                AppMethodBeat.o(41716);
                throw bVar4;
            } else {
                if (this.xJz != null) {
                    aVar.e(1, this.xJz);
                }
                if (this.xJA != null) {
                    aVar.e(2, this.xJA);
                }
                if (this.xJB != null) {
                    aVar.e(3, this.xJB);
                }
                if (this.Url != null) {
                    aVar.e(4, this.Url);
                }
                AppMethodBeat.o(41716);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.xJz != null ? g.a.a.b.b.a.f(1, this.xJz) + 0 : 0;
            if (this.xJA != null) {
                f2 += g.a.a.b.b.a.f(2, this.xJA);
            }
            if (this.xJB != null) {
                f2 += g.a.a.b.b.a.f(3, this.xJB);
            }
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(4, this.Url);
            }
            AppMethodBeat.o(41716);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xJz == null) {
                b bVar5 = new b("Not all required fields were included: Message");
                AppMethodBeat.o(41716);
                throw bVar5;
            } else if (this.xJA == null) {
                b bVar6 = new b("Not all required fields were included: GotoBtn");
                AppMethodBeat.o(41716);
                throw bVar6;
            } else if (this.xJB == null) {
                b bVar7 = new b("Not all required fields were included: CancelBtn");
                AppMethodBeat.o(41716);
                throw bVar7;
            } else if (this.Url == null) {
                b bVar8 = new b("Not all required fields were included: Url");
                AppMethodBeat.o(41716);
                throw bVar8;
            } else {
                AppMethodBeat.o(41716);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.xJz = aVar3.UbS.readString();
                    AppMethodBeat.o(41716);
                    return 0;
                case 2:
                    pVar.xJA = aVar3.UbS.readString();
                    AppMethodBeat.o(41716);
                    return 0;
                case 3:
                    pVar.xJB = aVar3.UbS.readString();
                    AppMethodBeat.o(41716);
                    return 0;
                case 4:
                    pVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(41716);
                    return 0;
                default:
                    AppMethodBeat.o(41716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41716);
            return -1;
        }
    }
}

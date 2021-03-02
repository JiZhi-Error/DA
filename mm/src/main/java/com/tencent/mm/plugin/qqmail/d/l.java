package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public class l extends a {
    public int Bry;
    public int bNi;
    public String name;
    public String pinyin;
    public String yFq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122694);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name == null) {
                b bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(122694);
                throw bVar;
            } else if (this.yFq == null) {
                b bVar2 = new b("Not all required fields were included: addr");
                AppMethodBeat.o(122694);
                throw bVar2;
            } else {
                aVar.aM(1, this.bNi);
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.yFq != null) {
                    aVar.e(3, this.yFq);
                }
                aVar.aM(4, this.Bry);
                if (this.pinyin != null) {
                    aVar.e(5, this.pinyin);
                }
                AppMethodBeat.o(122694);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.bNi) + 0;
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.yFq != null) {
                bu += g.a.a.b.b.a.f(3, this.yFq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Bry);
            if (this.pinyin != null) {
                bu2 += g.a.a.b.b.a.f(5, this.pinyin);
            }
            AppMethodBeat.o(122694);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.name == null) {
                b bVar3 = new b("Not all required fields were included: name");
                AppMethodBeat.o(122694);
                throw bVar3;
            } else if (this.yFq == null) {
                b bVar4 = new b("Not all required fields were included: addr");
                AppMethodBeat.o(122694);
                throw bVar4;
            } else {
                AppMethodBeat.o(122694);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.bNi = aVar3.UbS.zi();
                    AppMethodBeat.o(122694);
                    return 0;
                case 2:
                    lVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(122694);
                    return 0;
                case 3:
                    lVar.yFq = aVar3.UbS.readString();
                    AppMethodBeat.o(122694);
                    return 0;
                case 4:
                    lVar.Bry = aVar3.UbS.zi();
                    AppMethodBeat.o(122694);
                    return 0;
                case 5:
                    lVar.pinyin = aVar3.UbS.readString();
                    AppMethodBeat.o(122694);
                    return 0;
                default:
                    AppMethodBeat.o(122694);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122694);
            return -1;
        }
    }
}

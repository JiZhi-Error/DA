package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class g extends a {
    public String Md5;
    public String Url;
    public int oTW;
    public int oUv;
    public int xuA;
    public long xui;
    public String xuz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204104);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xuz != null) {
                aVar.e(1, this.xuz);
            }
            if (this.Md5 != null) {
                aVar.e(2, this.Md5);
            }
            aVar.aM(3, this.xuA);
            aVar.aM(4, this.oTW);
            aVar.aM(5, this.oUv);
            if (this.Url != null) {
                aVar.e(6, this.Url);
            }
            aVar.bb(7, this.xui);
            AppMethodBeat.o(204104);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xuz != null ? g.a.a.b.b.a.f(1, this.xuz) + 0 : 0;
            if (this.Md5 != null) {
                f2 += g.a.a.b.b.a.f(2, this.Md5);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.xuA) + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.oUv);
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(6, this.Url);
            }
            int r = bu + g.a.a.b.b.a.r(7, this.xui);
            AppMethodBeat.o(204104);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(204104);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.xuz = aVar3.UbS.readString();
                    AppMethodBeat.o(204104);
                    return 0;
                case 2:
                    gVar.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(204104);
                    return 0;
                case 3:
                    gVar.xuA = aVar3.UbS.zi();
                    AppMethodBeat.o(204104);
                    return 0;
                case 4:
                    gVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(204104);
                    return 0;
                case 5:
                    gVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(204104);
                    return 0;
                case 6:
                    gVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(204104);
                    return 0;
                case 7:
                    gVar.xui = aVar3.UbS.zl();
                    AppMethodBeat.o(204104);
                    return 0;
                default:
                    AppMethodBeat.o(204104);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204104);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class c extends a {
    public String Md5;
    public String jfi;
    public String xuc;
    public long xug;
    public boolean xuh;
    public long xui;
    public String xuj;
    public String xuk;
    public String xul;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204098);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.xug);
            aVar.cc(2, this.xuh);
            if (this.xuc != null) {
                aVar.e(3, this.xuc);
            }
            aVar.bb(4, this.xui);
            if (this.xuj != null) {
                aVar.e(5, this.xuj);
            }
            if (this.Md5 != null) {
                aVar.e(6, this.Md5);
            }
            if (this.jfi != null) {
                aVar.e(7, this.jfi);
            }
            if (this.xuk != null) {
                aVar.e(8, this.xuk);
            }
            if (this.xul != null) {
                aVar.e(9, this.xul);
            }
            AppMethodBeat.o(204098);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.xug) + 0 + g.a.a.b.b.a.fS(2) + 1;
            if (this.xuc != null) {
                r += g.a.a.b.b.a.f(3, this.xuc);
            }
            int r2 = r + g.a.a.b.b.a.r(4, this.xui);
            if (this.xuj != null) {
                r2 += g.a.a.b.b.a.f(5, this.xuj);
            }
            if (this.Md5 != null) {
                r2 += g.a.a.b.b.a.f(6, this.Md5);
            }
            if (this.jfi != null) {
                r2 += g.a.a.b.b.a.f(7, this.jfi);
            }
            if (this.xuk != null) {
                r2 += g.a.a.b.b.a.f(8, this.xuk);
            }
            if (this.xul != null) {
                r2 += g.a.a.b.b.a.f(9, this.xul);
            }
            AppMethodBeat.o(204098);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(204098);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.xug = aVar3.UbS.zl();
                    AppMethodBeat.o(204098);
                    return 0;
                case 2:
                    cVar.xuh = aVar3.UbS.yZ();
                    AppMethodBeat.o(204098);
                    return 0;
                case 3:
                    cVar.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                case 4:
                    cVar.xui = aVar3.UbS.zl();
                    AppMethodBeat.o(204098);
                    return 0;
                case 5:
                    cVar.xuj = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                case 6:
                    cVar.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                case 7:
                    cVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                case 8:
                    cVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                case 9:
                    cVar.xul = aVar3.UbS.readString();
                    AppMethodBeat.o(204098);
                    return 0;
                default:
                    AppMethodBeat.o(204098);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204098);
            return -1;
        }
    }
}

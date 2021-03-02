package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dyi extends a {
    public long MXW;
    public int actionType;
    public String dQx;
    public String icon;
    public String id;
    public String oqZ;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152995);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            aVar.bb(3, this.MXW);
            aVar.aM(4, this.actionType);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.oqZ != null) {
                aVar.e(7, this.oqZ);
            }
            if (this.icon != null) {
                aVar.e(8, this.icon);
            }
            AppMethodBeat.o(152995);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.MXW) + g.a.a.b.b.a.bu(4, this.actionType);
            if (this.url != null) {
                r += g.a.a.b.b.a.f(5, this.url);
            }
            if (this.title != null) {
                r += g.a.a.b.b.a.f(6, this.title);
            }
            if (this.oqZ != null) {
                r += g.a.a.b.b.a.f(7, this.oqZ);
            }
            if (this.icon != null) {
                r += g.a.a.b.b.a.f(8, this.icon);
            }
            AppMethodBeat.o(152995);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152995);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyi dyi = (dyi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyi.id = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                case 2:
                    dyi.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                case 3:
                    dyi.MXW = aVar3.UbS.zl();
                    AppMethodBeat.o(152995);
                    return 0;
                case 4:
                    dyi.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(152995);
                    return 0;
                case 5:
                    dyi.url = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                case 6:
                    dyi.title = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                case 7:
                    dyi.oqZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                case 8:
                    dyi.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(152995);
                    return 0;
                default:
                    AppMethodBeat.o(152995);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152995);
            return -1;
        }
    }
}

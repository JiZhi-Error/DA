package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dxl extends a {
    public String KHk;
    public String MD5;
    public String Title;
    public String URL;
    public String xMK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32451);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.URL != null) {
                aVar.e(1, this.URL);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.KHk != null) {
                aVar.e(3, this.KHk);
            }
            if (this.xMK != null) {
                aVar.e(4, this.xMK);
            }
            if (this.MD5 != null) {
                aVar.e(5, this.MD5);
            }
            AppMethodBeat.o(32451);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.URL != null ? g.a.a.b.b.a.f(1, this.URL) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(3, this.KHk);
            }
            if (this.xMK != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMK);
            }
            if (this.MD5 != null) {
                f2 += g.a.a.b.b.a.f(5, this.MD5);
            }
            AppMethodBeat.o(32451);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32451);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxl dxl = (dxl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dxl.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(32451);
                    return 0;
                case 2:
                    dxl.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32451);
                    return 0;
                case 3:
                    dxl.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(32451);
                    return 0;
                case 4:
                    dxl.xMK = aVar3.UbS.readString();
                    AppMethodBeat.o(32451);
                    return 0;
                case 5:
                    dxl.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32451);
                    return 0;
                default:
                    AppMethodBeat.o(32451);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32451);
            return -1;
        }
    }
}

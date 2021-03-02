package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dsv extends a {
    public int MUW;
    public int MUX;
    public String MUh;
    public String ThumbUrl;
    public String UserName;
    public String hik;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187886);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.MUh != null) {
                aVar.e(2, this.MUh);
            }
            if (this.ThumbUrl != null) {
                aVar.e(3, this.ThumbUrl);
            }
            if (this.hik != null) {
                aVar.e(4, this.hik);
            }
            aVar.aM(5, this.MUW);
            aVar.aM(6, this.MUX);
            AppMethodBeat.o(187886);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.MUh != null) {
                f2 += g.a.a.b.b.a.f(2, this.MUh);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.hik != null) {
                f2 += g.a.a.b.b.a.f(4, this.hik);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MUW) + g.a.a.b.b.a.bu(6, this.MUX);
            AppMethodBeat.o(187886);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsv dsv = (dsv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsv.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(187886);
                    return 0;
                case 2:
                    dsv.MUh = aVar3.UbS.readString();
                    AppMethodBeat.o(187886);
                    return 0;
                case 3:
                    dsv.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(187886);
                    return 0;
                case 4:
                    dsv.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(187886);
                    return 0;
                case 5:
                    dsv.MUW = aVar3.UbS.zi();
                    AppMethodBeat.o(187886);
                    return 0;
                case 6:
                    dsv.MUX = aVar3.UbS.zi();
                    AppMethodBeat.o(187886);
                    return 0;
                default:
                    AppMethodBeat.o(187886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187886);
            return -1;
        }
    }
}

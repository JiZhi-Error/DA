package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eio extends a {
    public String NhJ;
    public String NhK;
    public String appId;
    public String desc;
    public String ecK;
    public String title;
    public String uNR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153000);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.ecK != null) {
                aVar.e(3, this.ecK);
            }
            if (this.NhJ != null) {
                aVar.e(4, this.NhJ);
            }
            if (this.NhK != null) {
                aVar.e(5, this.NhK);
            }
            if (this.appId != null) {
                aVar.e(6, this.appId);
            }
            if (this.uNR != null) {
                aVar.e(7, this.uNR);
            }
            AppMethodBeat.o(153000);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.ecK != null) {
                f2 += g.a.a.b.b.a.f(3, this.ecK);
            }
            if (this.NhJ != null) {
                f2 += g.a.a.b.b.a.f(4, this.NhJ);
            }
            if (this.NhK != null) {
                f2 += g.a.a.b.b.a.f(5, this.NhK);
            }
            if (this.appId != null) {
                f2 += g.a.a.b.b.a.f(6, this.appId);
            }
            if (this.uNR != null) {
                f2 += g.a.a.b.b.a.f(7, this.uNR);
            }
            AppMethodBeat.o(153000);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153000);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eio eio = (eio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eio.title = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 2:
                    eio.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 3:
                    eio.ecK = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 4:
                    eio.NhJ = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 5:
                    eio.NhK = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 6:
                    eio.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                case 7:
                    eio.uNR = aVar3.UbS.readString();
                    AppMethodBeat.o(153000);
                    return 0;
                default:
                    AppMethodBeat.o(153000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153000);
            return -1;
        }
    }
}

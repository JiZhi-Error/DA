package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dfy extends a {
    public boolean LXH;
    public int MKJ;
    public String dPS;
    public String md5;
    public String url;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123639);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.LXH);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.md5 != null) {
                aVar.e(3, this.md5);
            }
            aVar.aM(4, this.version);
            aVar.aM(5, this.MKJ);
            if (this.dPS != null) {
                aVar.e(6, this.dPS);
            }
            AppMethodBeat.o(123639);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.url != null) {
                fS += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.md5 != null) {
                fS += g.a.a.b.b.a.f(3, this.md5);
            }
            int bu = fS + g.a.a.b.b.a.bu(4, this.version) + g.a.a.b.b.a.bu(5, this.MKJ);
            if (this.dPS != null) {
                bu += g.a.a.b.b.a.f(6, this.dPS);
            }
            AppMethodBeat.o(123639);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123639);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfy dfy = (dfy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dfy.LXH = aVar3.UbS.yZ();
                    AppMethodBeat.o(123639);
                    return 0;
                case 2:
                    dfy.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123639);
                    return 0;
                case 3:
                    dfy.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(123639);
                    return 0;
                case 4:
                    dfy.version = aVar3.UbS.zi();
                    AppMethodBeat.o(123639);
                    return 0;
                case 5:
                    dfy.MKJ = aVar3.UbS.zi();
                    AppMethodBeat.o(123639);
                    return 0;
                case 6:
                    dfy.dPS = aVar3.UbS.readString();
                    AppMethodBeat.o(123639);
                    return 0;
                default:
                    AppMethodBeat.o(123639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123639);
            return -1;
        }
    }
}

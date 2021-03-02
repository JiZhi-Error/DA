package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cok extends a {
    public int LLv;
    public String coverUrl;
    public float height;
    public String thumbUrl;
    public String url;
    public float width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196097);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.thumbUrl != null) {
                aVar.e(2, this.thumbUrl);
            }
            aVar.E(3, this.width);
            aVar.E(4, this.height);
            if (this.coverUrl != null) {
                aVar.e(5, this.coverUrl);
            }
            aVar.aM(6, this.LLv);
            AppMethodBeat.o(196097);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.thumbUrl);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            if (this.coverUrl != null) {
                fS += g.a.a.b.b.a.f(5, this.coverUrl);
            }
            int bu = fS + g.a.a.b.b.a.bu(6, this.LLv);
            AppMethodBeat.o(196097);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196097);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cok cok = (cok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cok.url = aVar3.UbS.readString();
                    AppMethodBeat.o(196097);
                    return 0;
                case 2:
                    cok.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(196097);
                    return 0;
                case 3:
                    cok.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(196097);
                    return 0;
                case 4:
                    cok.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(196097);
                    return 0;
                case 5:
                    cok.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(196097);
                    return 0;
                case 6:
                    cok.LLv = aVar3.UbS.zi();
                    AppMethodBeat.o(196097);
                    return 0;
                default:
                    AppMethodBeat.o(196097);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196097);
            return -1;
        }
    }
}

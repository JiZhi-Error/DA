package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bch extends a {
    public int LLv;
    public float height;
    public int mediaType;
    public String thumbUrl;
    public String url;
    public float width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(164045);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.mediaType);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.thumbUrl != null) {
                aVar.e(3, this.thumbUrl);
            }
            aVar.E(4, this.width);
            aVar.E(5, this.height);
            aVar.aM(6, this.LLv);
            AppMethodBeat.o(164045);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.mediaType) + 0;
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.thumbUrl != null) {
                bu += g.a.a.b.b.a.f(3, this.thumbUrl);
            }
            int fS = bu + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.bu(6, this.LLv);
            AppMethodBeat.o(164045);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(164045);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bch bch = (bch) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bch.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(164045);
                    return 0;
                case 2:
                    bch.url = aVar3.UbS.readString();
                    AppMethodBeat.o(164045);
                    return 0;
                case 3:
                    bch.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(164045);
                    return 0;
                case 4:
                    bch.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(164045);
                    return 0;
                case 5:
                    bch.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(164045);
                    return 0;
                case 6:
                    bch.LLv = aVar3.UbS.zi();
                    AppMethodBeat.o(164045);
                    return 0;
                default:
                    AppMethodBeat.o(164045);
                    return -1;
            }
        } else {
            AppMethodBeat.o(164045);
            return -1;
        }
    }
}

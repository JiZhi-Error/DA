package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cta extends a {
    public String seq;
    public String token;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222857);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.seq != null) {
                aVar.e(1, this.seq);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.token != null) {
                aVar.e(3, this.token);
            }
            AppMethodBeat.o(222857);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.seq != null ? g.a.a.b.b.a.f(1, this.seq) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.token != null) {
                f2 += g.a.a.b.b.a.f(3, this.token);
            }
            AppMethodBeat.o(222857);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222857);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cta cta = (cta) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cta.seq = aVar3.UbS.readString();
                    AppMethodBeat.o(222857);
                    return 0;
                case 2:
                    cta.url = aVar3.UbS.readString();
                    AppMethodBeat.o(222857);
                    return 0;
                case 3:
                    cta.token = aVar3.UbS.readString();
                    AppMethodBeat.o(222857);
                    return 0;
                default:
                    AppMethodBeat.o(222857);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222857);
            return -1;
        }
    }
}
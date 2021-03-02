package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cci extends a {
    public String Mim;
    public String Title;
    public String Url;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32328);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.Mim != null) {
                aVar.e(3, this.Mim);
            }
            if (this.xMq != null) {
                aVar.e(4, this.xMq);
            }
            AppMethodBeat.o(32328);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Url != null ? g.a.a.b.b.a.f(1, this.Url) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.Mim != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mim);
            }
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMq);
            }
            AppMethodBeat.o(32328);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32328);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cci cci = (cci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cci.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(32328);
                    return 0;
                case 2:
                    cci.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32328);
                    return 0;
                case 3:
                    cci.Mim = aVar3.UbS.readString();
                    AppMethodBeat.o(32328);
                    return 0;
                case 4:
                    cci.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(32328);
                    return 0;
                default:
                    AppMethodBeat.o(32328);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32328);
            return -1;
        }
    }
}

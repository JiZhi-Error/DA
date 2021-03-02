package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czq extends a {
    public String BrH;
    public long MEU;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72541);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BrH != null) {
                aVar.e(1, this.BrH);
            }
            aVar.bb(2, this.MEU);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            AppMethodBeat.o(72541);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.BrH != null ? g.a.a.b.b.a.f(1, this.BrH) + 0 : 0) + g.a.a.b.b.a.r(2, this.MEU);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            AppMethodBeat.o(72541);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72541);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czq czq = (czq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czq.BrH = aVar3.UbS.readString();
                    AppMethodBeat.o(72541);
                    return 0;
                case 2:
                    czq.MEU = aVar3.UbS.zl();
                    AppMethodBeat.o(72541);
                    return 0;
                case 3:
                    czq.url = aVar3.UbS.readString();
                    AppMethodBeat.o(72541);
                    return 0;
                default:
                    AppMethodBeat.o(72541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72541);
            return -1;
        }
    }
}

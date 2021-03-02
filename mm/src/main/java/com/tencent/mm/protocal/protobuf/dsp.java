package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dsp extends a {
    public String KZj;
    public String MUS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117919);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZj != null) {
                aVar.e(1, this.KZj);
            }
            if (this.MUS != null) {
                aVar.e(2, this.MUS);
            }
            AppMethodBeat.o(117919);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KZj != null ? g.a.a.b.b.a.f(1, this.KZj) + 0 : 0;
            if (this.MUS != null) {
                f2 += g.a.a.b.b.a.f(2, this.MUS);
            }
            AppMethodBeat.o(117919);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117919);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsp dsp = (dsp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsp.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117919);
                    return 0;
                case 2:
                    dsp.MUS = aVar3.UbS.readString();
                    AppMethodBeat.o(117919);
                    return 0;
                default:
                    AppMethodBeat.o(117919);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117919);
            return -1;
        }
    }
}

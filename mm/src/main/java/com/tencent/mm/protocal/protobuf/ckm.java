package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ckm extends a {
    public String lyrics;
    public long startTime;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140930);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.lyrics == null) {
                b bVar = new b("Not all required fields were included: lyrics");
                AppMethodBeat.o(140930);
                throw bVar;
            }
            if (this.lyrics != null) {
                aVar.e(1, this.lyrics);
            }
            aVar.bb(2, this.startTime);
            AppMethodBeat.o(140930);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.lyrics != null ? g.a.a.b.b.a.f(1, this.lyrics) + 0 : 0) + g.a.a.b.b.a.r(2, this.startTime);
            AppMethodBeat.o(140930);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.lyrics == null) {
                b bVar2 = new b("Not all required fields were included: lyrics");
                AppMethodBeat.o(140930);
                throw bVar2;
            }
            AppMethodBeat.o(140930);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckm ckm = (ckm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckm.lyrics = aVar3.UbS.readString();
                    AppMethodBeat.o(140930);
                    return 0;
                case 2:
                    ckm.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(140930);
                    return 0;
                default:
                    AppMethodBeat.o(140930);
                    return -1;
            }
        } else {
            AppMethodBeat.o(140930);
            return -1;
        }
    }
}

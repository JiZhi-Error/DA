package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ehv extends a {
    public LinkedList<String> duo = new LinkedList<>();
    public int ibS;
    public String title;
    public String url;

    public ehv() {
        AppMethodBeat.i(188571);
        AppMethodBeat.o(188571);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127284);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ibS);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.e(4, 1, this.duo);
            AppMethodBeat.o(127284);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ibS) + 0;
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(3, this.url);
            }
            int c2 = bu + g.a.a.a.c(4, 1, this.duo);
            AppMethodBeat.o(127284);
            return c2;
        } else if (i2 == 2) {
            this.duo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127284);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehv ehv = (ehv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ehv.ibS = aVar3.UbS.zi();
                    AppMethodBeat.o(127284);
                    return 0;
                case 2:
                    ehv.title = aVar3.UbS.readString();
                    AppMethodBeat.o(127284);
                    return 0;
                case 3:
                    ehv.url = aVar3.UbS.readString();
                    AppMethodBeat.o(127284);
                    return 0;
                case 4:
                    ehv.duo.add(aVar3.UbS.readString());
                    AppMethodBeat.o(127284);
                    return 0;
                default:
                    AppMethodBeat.o(127284);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127284);
            return -1;
        }
    }
}

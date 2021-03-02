package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class awr extends a {
    public String LHr;
    public String LHs;
    public String content;
    public String title;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209542);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.LHr != null) {
                aVar.e(2, this.LHr);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            if (this.LHs != null) {
                aVar.e(5, this.LHs);
            }
            AppMethodBeat.o(209542);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.LHr != null) {
                bu += g.a.a.b.b.a.f(2, this.LHr);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.content != null) {
                bu += g.a.a.b.b.a.f(4, this.content);
            }
            if (this.LHs != null) {
                bu += g.a.a.b.b.a.f(5, this.LHs);
            }
            AppMethodBeat.o(209542);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209542);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awr awr = (awr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awr.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209542);
                    return 0;
                case 2:
                    awr.LHr = aVar3.UbS.readString();
                    AppMethodBeat.o(209542);
                    return 0;
                case 3:
                    awr.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209542);
                    return 0;
                case 4:
                    awr.content = aVar3.UbS.readString();
                    AppMethodBeat.o(209542);
                    return 0;
                case 5:
                    awr.LHs = aVar3.UbS.readString();
                    AppMethodBeat.o(209542);
                    return 0;
                default:
                    AppMethodBeat.o(209542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209542);
            return -1;
        }
    }
}

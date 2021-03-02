package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class azp extends a {
    public String LJu;
    public String content;
    public String link;
    public int subType;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169020);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            aVar.aM(3, this.subType);
            if (this.link != null) {
                aVar.e(4, this.link);
            }
            if (this.LJu != null) {
                aVar.e(5, this.LJu);
            }
            AppMethodBeat.o(169020);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(2, this.content);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.subType);
            if (this.link != null) {
                bu += g.a.a.b.b.a.f(4, this.link);
            }
            if (this.LJu != null) {
                bu += g.a.a.b.b.a.f(5, this.LJu);
            }
            AppMethodBeat.o(169020);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169020);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azp azp = (azp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azp.title = aVar3.UbS.readString();
                    AppMethodBeat.o(169020);
                    return 0;
                case 2:
                    azp.content = aVar3.UbS.readString();
                    AppMethodBeat.o(169020);
                    return 0;
                case 3:
                    azp.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(169020);
                    return 0;
                case 4:
                    azp.link = aVar3.UbS.readString();
                    AppMethodBeat.o(169020);
                    return 0;
                case 5:
                    azp.LJu = aVar3.UbS.readString();
                    AppMethodBeat.o(169020);
                    return 0;
                default:
                    AppMethodBeat.o(169020);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169020);
            return -1;
        }
    }
}

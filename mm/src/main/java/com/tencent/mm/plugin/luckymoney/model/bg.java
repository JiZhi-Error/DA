package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bg extends a {
    public String content;
    public int gGn;
    public String iconUrl;
    public String name;
    public String type;
    public int yXT;
    public int yXU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91259);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.gGn);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.aM(5, this.yXT);
            if (this.iconUrl != null) {
                aVar.e(6, this.iconUrl);
            }
            aVar.aM(7, this.yXU);
            AppMethodBeat.o(91259);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.gGn) + 0;
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.type != null) {
                bu += g.a.a.b.b.a.f(3, this.type);
            }
            if (this.content != null) {
                bu += g.a.a.b.b.a.f(4, this.content);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.yXT);
            if (this.iconUrl != null) {
                bu2 += g.a.a.b.b.a.f(6, this.iconUrl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.yXU);
            AppMethodBeat.o(91259);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91259);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgVar.gGn = aVar3.UbS.zi();
                    AppMethodBeat.o(91259);
                    return 0;
                case 2:
                    bgVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91259);
                    return 0;
                case 3:
                    bgVar.type = aVar3.UbS.readString();
                    AppMethodBeat.o(91259);
                    return 0;
                case 4:
                    bgVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(91259);
                    return 0;
                case 5:
                    bgVar.yXT = aVar3.UbS.zi();
                    AppMethodBeat.o(91259);
                    return 0;
                case 6:
                    bgVar.iconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(91259);
                    return 0;
                case 7:
                    bgVar.yXU = aVar3.UbS.zi();
                    AppMethodBeat.o(91259);
                    return 0;
                default:
                    AppMethodBeat.o(91259);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91259);
            return -1;
        }
    }
}

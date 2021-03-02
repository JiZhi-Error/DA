package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctg extends a {
    public String KZR;
    public int Myf;
    public int Myg;
    public String desc;
    public String icon;
    public String title;
    public String yUB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91555);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.yUB != null) {
                aVar.e(3, this.yUB);
            }
            aVar.aM(4, this.Myf);
            aVar.aM(5, this.Myg);
            if (this.KZR != null) {
                aVar.e(6, this.KZR);
            }
            if (this.icon != null) {
                aVar.e(7, this.icon);
            }
            AppMethodBeat.o(91555);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.yUB != null) {
                f2 += g.a.a.b.b.a.f(3, this.yUB);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Myf) + g.a.a.b.b.a.bu(5, this.Myg);
            if (this.KZR != null) {
                bu += g.a.a.b.b.a.f(6, this.KZR);
            }
            if (this.icon != null) {
                bu += g.a.a.b.b.a.f(7, this.icon);
            }
            AppMethodBeat.o(91555);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91555);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctg ctg = (ctg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctg.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91555);
                    return 0;
                case 2:
                    ctg.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(91555);
                    return 0;
                case 3:
                    ctg.yUB = aVar3.UbS.readString();
                    AppMethodBeat.o(91555);
                    return 0;
                case 4:
                    ctg.Myf = aVar3.UbS.zi();
                    AppMethodBeat.o(91555);
                    return 0;
                case 5:
                    ctg.Myg = aVar3.UbS.zi();
                    AppMethodBeat.o(91555);
                    return 0;
                case 6:
                    ctg.KZR = aVar3.UbS.readString();
                    AppMethodBeat.o(91555);
                    return 0;
                case 7:
                    ctg.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(91555);
                    return 0;
                default:
                    AppMethodBeat.o(91555);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91555);
            return -1;
        }
    }
}

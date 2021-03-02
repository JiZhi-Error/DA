package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class arm extends a {
    public long LCZ;
    public String dNI;
    public String icon;
    public String link;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209394);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.icon != null) {
                aVar.e(2, this.icon);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.link != null) {
                aVar.e(4, this.link);
            }
            aVar.bb(5, this.LCZ);
            AppMethodBeat.o(209394);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(2, this.icon);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.link != null) {
                f2 += g.a.a.b.b.a.f(4, this.link);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.LCZ);
            AppMethodBeat.o(209394);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209394);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arm arm = (arm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arm.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(209394);
                    return 0;
                case 2:
                    arm.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(209394);
                    return 0;
                case 3:
                    arm.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209394);
                    return 0;
                case 4:
                    arm.link = aVar3.UbS.readString();
                    AppMethodBeat.o(209394);
                    return 0;
                case 5:
                    arm.LCZ = aVar3.UbS.zl();
                    AppMethodBeat.o(209394);
                    return 0;
                default:
                    AppMethodBeat.o(209394);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209394);
            return -1;
        }
    }
}

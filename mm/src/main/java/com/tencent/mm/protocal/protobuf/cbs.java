package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbs extends a {
    public String CiX;
    public String KZa;
    public String MhA;
    public String MhB;
    public String MhC;
    public String Mhy;
    public long Mhz;
    public int state;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72500);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZa != null) {
                aVar.e(1, this.KZa);
            }
            aVar.aM(2, this.state);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.Mhy != null) {
                aVar.e(4, this.Mhy);
            }
            aVar.bb(5, this.Mhz);
            if (this.MhA != null) {
                aVar.e(6, this.MhA);
            }
            if (this.CiX != null) {
                aVar.e(7, this.CiX);
            }
            if (this.MhB != null) {
                aVar.e(8, this.MhB);
            }
            if (this.MhC != null) {
                aVar.e(9, this.MhC);
            }
            AppMethodBeat.o(72500);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KZa != null ? g.a.a.b.b.a.f(1, this.KZa) + 0 : 0) + g.a.a.b.b.a.bu(2, this.state);
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.Mhy != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mhy);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.Mhz);
            if (this.MhA != null) {
                r += g.a.a.b.b.a.f(6, this.MhA);
            }
            if (this.CiX != null) {
                r += g.a.a.b.b.a.f(7, this.CiX);
            }
            if (this.MhB != null) {
                r += g.a.a.b.b.a.f(8, this.MhB);
            }
            if (this.MhC != null) {
                r += g.a.a.b.b.a.f(9, this.MhC);
            }
            AppMethodBeat.o(72500);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72500);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbs cbs = (cbs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbs.KZa = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 2:
                    cbs.state = aVar3.UbS.zi();
                    AppMethodBeat.o(72500);
                    return 0;
                case 3:
                    cbs.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 4:
                    cbs.Mhy = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 5:
                    cbs.Mhz = aVar3.UbS.zl();
                    AppMethodBeat.o(72500);
                    return 0;
                case 6:
                    cbs.MhA = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 7:
                    cbs.CiX = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 8:
                    cbs.MhB = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                case 9:
                    cbs.MhC = aVar3.UbS.readString();
                    AppMethodBeat.o(72500);
                    return 0;
                default:
                    AppMethodBeat.o(72500);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72500);
            return -1;
        }
    }
}

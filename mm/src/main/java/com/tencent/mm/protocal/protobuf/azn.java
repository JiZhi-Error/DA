package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class azn extends a {
    public String LJn;
    public String LJo;
    public String LJp;
    public String LJq;
    public int LJr;
    public String LJs;
    public String LJt;
    public String appName;
    public String kog;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169017);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LJn != null) {
                aVar.e(1, this.LJn);
            }
            if (this.LJo != null) {
                aVar.e(2, this.LJo);
            }
            if (this.LJp != null) {
                aVar.e(3, this.LJp);
            }
            if (this.appName != null) {
                aVar.e(4, this.appName);
            }
            if (this.LJq != null) {
                aVar.e(5, this.LJq);
            }
            if (this.kog != null) {
                aVar.e(6, this.kog);
            }
            aVar.aM(7, this.LJr);
            if (this.LJs != null) {
                aVar.e(8, this.LJs);
            }
            if (this.LJt != null) {
                aVar.e(9, this.LJt);
            }
            AppMethodBeat.o(169017);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LJn != null ? g.a.a.b.b.a.f(1, this.LJn) + 0 : 0;
            if (this.LJo != null) {
                f2 += g.a.a.b.b.a.f(2, this.LJo);
            }
            if (this.LJp != null) {
                f2 += g.a.a.b.b.a.f(3, this.LJp);
            }
            if (this.appName != null) {
                f2 += g.a.a.b.b.a.f(4, this.appName);
            }
            if (this.LJq != null) {
                f2 += g.a.a.b.b.a.f(5, this.LJq);
            }
            if (this.kog != null) {
                f2 += g.a.a.b.b.a.f(6, this.kog);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.LJr);
            if (this.LJs != null) {
                bu += g.a.a.b.b.a.f(8, this.LJs);
            }
            if (this.LJt != null) {
                bu += g.a.a.b.b.a.f(9, this.LJt);
            }
            AppMethodBeat.o(169017);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169017);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azn azn = (azn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azn.LJn = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 2:
                    azn.LJo = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 3:
                    azn.LJp = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 4:
                    azn.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 5:
                    azn.LJq = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 6:
                    azn.kog = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 7:
                    azn.LJr = aVar3.UbS.zi();
                    AppMethodBeat.o(169017);
                    return 0;
                case 8:
                    azn.LJs = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                case 9:
                    azn.LJt = aVar3.UbS.readString();
                    AppMethodBeat.o(169017);
                    return 0;
                default:
                    AppMethodBeat.o(169017);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169017);
            return -1;
        }
    }
}

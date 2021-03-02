package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dn extends a {
    public String Label;
    public String UserName;
    public int xNc;
    public long xNd;
    public boolean xNe;
    public int xNf;
    public String xNg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41828);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(41828);
                throw bVar;
            }
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.aM(2, this.xNc);
            aVar.bb(3, this.xNd);
            if (this.Label != null) {
                aVar.e(4, this.Label);
            }
            aVar.cc(5, this.xNe);
            aVar.aM(6, this.xNf);
            if (this.xNg != null) {
                aVar.e(7, this.xNg);
            }
            AppMethodBeat.o(41828);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xNc) + g.a.a.b.b.a.r(3, this.xNd);
            if (this.Label != null) {
                f2 += g.a.a.b.b.a.f(4, this.Label);
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.xNf);
            if (this.xNg != null) {
                fS += g.a.a.b.b.a.f(7, this.xNg);
            }
            AppMethodBeat.o(41828);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                b bVar2 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(41828);
                throw bVar2;
            }
            AppMethodBeat.o(41828);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dn dnVar = (dn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(41828);
                    return 0;
                case 2:
                    dnVar.xNc = aVar3.UbS.zi();
                    AppMethodBeat.o(41828);
                    return 0;
                case 3:
                    dnVar.xNd = aVar3.UbS.zl();
                    AppMethodBeat.o(41828);
                    return 0;
                case 4:
                    dnVar.Label = aVar3.UbS.readString();
                    AppMethodBeat.o(41828);
                    return 0;
                case 5:
                    dnVar.xNe = aVar3.UbS.yZ();
                    AppMethodBeat.o(41828);
                    return 0;
                case 6:
                    dnVar.xNf = aVar3.UbS.zi();
                    AppMethodBeat.o(41828);
                    return 0;
                case 7:
                    dnVar.xNg = aVar3.UbS.readString();
                    AppMethodBeat.o(41828);
                    return 0;
                default:
                    AppMethodBeat.o(41828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41828);
            return -1;
        }
    }
}

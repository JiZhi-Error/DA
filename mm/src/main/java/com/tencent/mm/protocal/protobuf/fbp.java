package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbp extends a {
    public String IconUrl;
    public int KSa;
    public String MEq;
    public String NxL;
    public String UserName;
    public String hik;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117957);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEq != null) {
                aVar.e(1, this.MEq);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            if (this.hik != null) {
                aVar.e(4, this.hik);
            }
            aVar.aM(5, this.KSa);
            if (this.NxL != null) {
                aVar.e(6, this.NxL);
            }
            if (this.IconUrl != null) {
                aVar.e(7, this.IconUrl);
            }
            AppMethodBeat.o(117957);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MEq != null ? g.a.a.b.b.a.f(1, this.MEq) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.hik != null) {
                f2 += g.a.a.b.b.a.f(4, this.hik);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KSa);
            if (this.NxL != null) {
                bu += g.a.a.b.b.a.f(6, this.NxL);
            }
            if (this.IconUrl != null) {
                bu += g.a.a.b.b.a.f(7, this.IconUrl);
            }
            AppMethodBeat.o(117957);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117957);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbp fbp = (fbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbp.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                case 2:
                    fbp.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                case 3:
                    fbp.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                case 4:
                    fbp.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                case 5:
                    fbp.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(117957);
                    return 0;
                case 6:
                    fbp.NxL = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                case 7:
                    fbp.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(117957);
                    return 0;
                default:
                    AppMethodBeat.o(117957);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117957);
            return -1;
        }
    }
}

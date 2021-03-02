package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eyb extends a {
    public String KLO;
    public String Nvj;
    public String Nvk;
    public String Nvl;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String oTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116822);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLO != null) {
                aVar.e(1, this.KLO);
            }
            if (this.hie != null) {
                aVar.e(2, this.hie);
            }
            if (this.hid != null) {
                aVar.e(3, this.hid);
            }
            if (this.oTI != null) {
                aVar.e(4, this.oTI);
            }
            if (this.Nvj != null) {
                aVar.e(5, this.Nvj);
            }
            if (this.hif != null) {
                aVar.e(6, this.hif);
            }
            if (this.hig != null) {
                aVar.e(7, this.hig);
            }
            if (this.Nvk != null) {
                aVar.e(8, this.Nvk);
            }
            if (this.Nvl != null) {
                aVar.e(9, this.Nvl);
            }
            AppMethodBeat.o(116822);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KLO != null ? g.a.a.b.b.a.f(1, this.KLO) + 0 : 0;
            if (this.hie != null) {
                f2 += g.a.a.b.b.a.f(2, this.hie);
            }
            if (this.hid != null) {
                f2 += g.a.a.b.b.a.f(3, this.hid);
            }
            if (this.oTI != null) {
                f2 += g.a.a.b.b.a.f(4, this.oTI);
            }
            if (this.Nvj != null) {
                f2 += g.a.a.b.b.a.f(5, this.Nvj);
            }
            if (this.hif != null) {
                f2 += g.a.a.b.b.a.f(6, this.hif);
            }
            if (this.hig != null) {
                f2 += g.a.a.b.b.a.f(7, this.hig);
            }
            if (this.Nvk != null) {
                f2 += g.a.a.b.b.a.f(8, this.Nvk);
            }
            if (this.Nvl != null) {
                f2 += g.a.a.b.b.a.f(9, this.Nvl);
            }
            AppMethodBeat.o(116822);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116822);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyb eyb = (eyb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyb.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 2:
                    eyb.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 3:
                    eyb.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 4:
                    eyb.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 5:
                    eyb.Nvj = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 6:
                    eyb.hif = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 7:
                    eyb.hig = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 8:
                    eyb.Nvk = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                case 9:
                    eyb.Nvl = aVar3.UbS.readString();
                    AppMethodBeat.o(116822);
                    return 0;
                default:
                    AppMethodBeat.o(116822);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116822);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bws extends a {
    public int KCD;
    public String LRh;
    public int Mcw;
    public String Mcx;
    public String Mcy;
    public int Ret;
    public String Title;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152608);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            if (this.LRh != null) {
                aVar.e(2, this.LRh);
            }
            aVar.aM(3, this.KCD);
            aVar.aM(4, this.Mcw);
            if (this.Title != null) {
                aVar.e(5, this.Title);
            }
            if (this.UserName != null) {
                aVar.e(6, this.UserName);
            }
            if (this.Mcx != null) {
                aVar.e(7, this.Mcx);
            }
            if (this.Mcy != null) {
                aVar.e(8, this.Mcy);
            }
            AppMethodBeat.o(152608);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.LRh != null) {
                bu += g.a.a.b.b.a.f(2, this.LRh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KCD) + g.a.a.b.b.a.bu(4, this.Mcw);
            if (this.Title != null) {
                bu2 += g.a.a.b.b.a.f(5, this.Title);
            }
            if (this.UserName != null) {
                bu2 += g.a.a.b.b.a.f(6, this.UserName);
            }
            if (this.Mcx != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Mcx);
            }
            if (this.Mcy != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Mcy);
            }
            AppMethodBeat.o(152608);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152608);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bws bws = (bws) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bws.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(152608);
                    return 0;
                case 2:
                    bws.LRh = aVar3.UbS.readString();
                    AppMethodBeat.o(152608);
                    return 0;
                case 3:
                    bws.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(152608);
                    return 0;
                case 4:
                    bws.Mcw = aVar3.UbS.zi();
                    AppMethodBeat.o(152608);
                    return 0;
                case 5:
                    bws.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(152608);
                    return 0;
                case 6:
                    bws.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152608);
                    return 0;
                case 7:
                    bws.Mcx = aVar3.UbS.readString();
                    AppMethodBeat.o(152608);
                    return 0;
                case 8:
                    bws.Mcy = aVar3.UbS.readString();
                    AppMethodBeat.o(152608);
                    return 0;
                default:
                    AppMethodBeat.o(152608);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152608);
            return -1;
        }
    }
}

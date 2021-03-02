package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ewk extends a {
    public String Desc;
    public int KHa;
    public String MJz;
    public String Nuh;
    public String ProductID;
    public String Title;
    public String xJH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32508);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.MJz != null) {
                aVar.e(2, this.MJz);
            }
            if (this.xJH != null) {
                aVar.e(3, this.xJH);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.Nuh != null) {
                aVar.e(5, this.Nuh);
            }
            aVar.aM(6, this.KHa);
            if (this.ProductID != null) {
                aVar.e(7, this.ProductID);
            }
            AppMethodBeat.o(32508);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.MJz != null) {
                f2 += g.a.a.b.b.a.f(2, this.MJz);
            }
            if (this.xJH != null) {
                f2 += g.a.a.b.b.a.f(3, this.xJH);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.Nuh != null) {
                f2 += g.a.a.b.b.a.f(5, this.Nuh);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.KHa);
            if (this.ProductID != null) {
                bu += g.a.a.b.b.a.f(7, this.ProductID);
            }
            AppMethodBeat.o(32508);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32508);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewk ewk = (ewk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewk.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                case 2:
                    ewk.MJz = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                case 3:
                    ewk.xJH = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                case 4:
                    ewk.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                case 5:
                    ewk.Nuh = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                case 6:
                    ewk.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(32508);
                    return 0;
                case 7:
                    ewk.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(32508);
                    return 0;
                default:
                    AppMethodBeat.o(32508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32508);
            return -1;
        }
    }
}

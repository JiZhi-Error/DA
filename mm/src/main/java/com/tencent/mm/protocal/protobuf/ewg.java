package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ewg extends a {
    public String MJz;
    public int NtY;
    public String NtZ;
    public String Nua;
    public String Nub;
    public String Nuc;
    public String Nud;
    public String ProductID;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32504);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            aVar.aM(3, this.NtY);
            if (this.NtZ != null) {
                aVar.e(4, this.NtZ);
            }
            if (this.MJz != null) {
                aVar.e(5, this.MJz);
            }
            if (this.Nua != null) {
                aVar.e(6, this.Nua);
            }
            if (this.Nub != null) {
                aVar.e(7, this.Nub);
            }
            if (this.Nuc != null) {
                aVar.e(8, this.Nuc);
            }
            if (this.Nud != null) {
                aVar.e(9, this.Nud);
            }
            AppMethodBeat.o(32504);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.ProductID != null) {
                f2 += g.a.a.b.b.a.f(2, this.ProductID);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.NtY);
            if (this.NtZ != null) {
                bu += g.a.a.b.b.a.f(4, this.NtZ);
            }
            if (this.MJz != null) {
                bu += g.a.a.b.b.a.f(5, this.MJz);
            }
            if (this.Nua != null) {
                bu += g.a.a.b.b.a.f(6, this.Nua);
            }
            if (this.Nub != null) {
                bu += g.a.a.b.b.a.f(7, this.Nub);
            }
            if (this.Nuc != null) {
                bu += g.a.a.b.b.a.f(8, this.Nuc);
            }
            if (this.Nud != null) {
                bu += g.a.a.b.b.a.f(9, this.Nud);
            }
            AppMethodBeat.o(32504);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32504);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewg ewg = (ewg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewg.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 2:
                    ewg.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 3:
                    ewg.NtY = aVar3.UbS.zi();
                    AppMethodBeat.o(32504);
                    return 0;
                case 4:
                    ewg.NtZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 5:
                    ewg.MJz = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 6:
                    ewg.Nua = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 7:
                    ewg.Nub = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 8:
                    ewg.Nuc = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                case 9:
                    ewg.Nud = aVar3.UbS.readString();
                    AppMethodBeat.o(32504);
                    return 0;
                default:
                    AppMethodBeat.o(32504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32504);
            return -1;
        }
    }
}

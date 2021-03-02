package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ekl extends a {
    public String CiX;
    public String Cjt;
    public String Cju;
    public String Cjv;
    public String Cjw;
    public String dDj;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72612);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Cjt != null) {
                aVar.e(1, this.Cjt);
            }
            if (this.Cju != null) {
                aVar.e(2, this.Cju);
            }
            if (this.CiX != null) {
                aVar.e(3, this.CiX);
            }
            if (this.ynT != null) {
                aVar.e(4, this.ynT);
            }
            if (this.dDj != null) {
                aVar.e(5, this.dDj);
            }
            if (this.Cjv != null) {
                aVar.e(6, this.Cjv);
            }
            if (this.Cjw != null) {
                aVar.e(7, this.Cjw);
            }
            AppMethodBeat.o(72612);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Cjt != null ? g.a.a.b.b.a.f(1, this.Cjt) + 0 : 0;
            if (this.Cju != null) {
                f2 += g.a.a.b.b.a.f(2, this.Cju);
            }
            if (this.CiX != null) {
                f2 += g.a.a.b.b.a.f(3, this.CiX);
            }
            if (this.ynT != null) {
                f2 += g.a.a.b.b.a.f(4, this.ynT);
            }
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(5, this.dDj);
            }
            if (this.Cjv != null) {
                f2 += g.a.a.b.b.a.f(6, this.Cjv);
            }
            if (this.Cjw != null) {
                f2 += g.a.a.b.b.a.f(7, this.Cjw);
            }
            AppMethodBeat.o(72612);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72612);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekl ekl = (ekl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekl.Cjt = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 2:
                    ekl.Cju = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 3:
                    ekl.CiX = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 4:
                    ekl.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 5:
                    ekl.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 6:
                    ekl.Cjv = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                case 7:
                    ekl.Cjw = aVar3.UbS.readString();
                    AppMethodBeat.o(72612);
                    return 0;
                default:
                    AppMethodBeat.o(72612);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72612);
            return -1;
        }
    }
}

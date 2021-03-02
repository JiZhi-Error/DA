package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ecf extends a {
    public String Ncr;
    public String Ncs;
    public int Nct;
    public String Ncu;
    public String Ncv;
    public String appId;
    public String appName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(232382);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            if (this.Ncr != null) {
                aVar.e(3, this.Ncr);
            }
            if (this.Ncs != null) {
                aVar.e(4, this.Ncs);
            }
            aVar.aM(5, this.Nct);
            if (this.Ncu != null) {
                aVar.e(6, this.Ncu);
            }
            if (this.Ncv != null) {
                aVar.e(7, this.Ncv);
            }
            AppMethodBeat.o(232382);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.appName != null) {
                f2 += g.a.a.b.b.a.f(2, this.appName);
            }
            if (this.Ncr != null) {
                f2 += g.a.a.b.b.a.f(3, this.Ncr);
            }
            if (this.Ncs != null) {
                f2 += g.a.a.b.b.a.f(4, this.Ncs);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Nct);
            if (this.Ncu != null) {
                bu += g.a.a.b.b.a.f(6, this.Ncu);
            }
            if (this.Ncv != null) {
                bu += g.a.a.b.b.a.f(7, this.Ncv);
            }
            AppMethodBeat.o(232382);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(232382);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecf ecf = (ecf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecf.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                case 2:
                    ecf.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                case 3:
                    ecf.Ncr = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                case 4:
                    ecf.Ncs = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                case 5:
                    ecf.Nct = aVar3.UbS.zi();
                    AppMethodBeat.o(232382);
                    return 0;
                case 6:
                    ecf.Ncu = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                case 7:
                    ecf.Ncv = aVar3.UbS.readString();
                    AppMethodBeat.o(232382);
                    return 0;
                default:
                    AppMethodBeat.o(232382);
                    return -1;
            }
        } else {
            AppMethodBeat.o(232382);
            return -1;
        }
    }
}

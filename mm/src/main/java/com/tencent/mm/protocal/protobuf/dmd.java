package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dmd extends a {
    public String MPH;
    public String MPI;
    public String MPJ;
    public String Mvm;
    public String oUJ;
    public String rBH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134253);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUJ != null) {
                aVar.e(1, this.oUJ);
            }
            if (this.MPH != null) {
                aVar.e(2, this.MPH);
            }
            if (this.Mvm != null) {
                aVar.e(3, this.Mvm);
            }
            if (this.MPI != null) {
                aVar.e(4, this.MPI);
            }
            if (this.rBH != null) {
                aVar.e(5, this.rBH);
            }
            if (this.MPJ != null) {
                aVar.e(6, this.MPJ);
            }
            AppMethodBeat.o(134253);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.oUJ != null ? g.a.a.b.b.a.f(1, this.oUJ) + 0 : 0;
            if (this.MPH != null) {
                f2 += g.a.a.b.b.a.f(2, this.MPH);
            }
            if (this.Mvm != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mvm);
            }
            if (this.MPI != null) {
                f2 += g.a.a.b.b.a.f(4, this.MPI);
            }
            if (this.rBH != null) {
                f2 += g.a.a.b.b.a.f(5, this.rBH);
            }
            if (this.MPJ != null) {
                f2 += g.a.a.b.b.a.f(6, this.MPJ);
            }
            AppMethodBeat.o(134253);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(134253);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmd dmd = (dmd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dmd.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                case 2:
                    dmd.MPH = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                case 3:
                    dmd.Mvm = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                case 4:
                    dmd.MPI = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                case 5:
                    dmd.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                case 6:
                    dmd.MPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(134253);
                    return 0;
                default:
                    AppMethodBeat.o(134253);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134253);
            return -1;
        }
    }
}

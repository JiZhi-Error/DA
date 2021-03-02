package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dbj extends a {
    public String Lli;
    public boolean MGs;
    public boolean MGt;
    public String bxK;
    public String dSf;
    public String nzu;
    public String nzv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123634);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dSf != null) {
                aVar.e(1, this.dSf);
            }
            if (this.Lli != null) {
                aVar.e(2, this.Lli);
            }
            aVar.cc(3, this.MGs);
            aVar.cc(4, this.MGt);
            if (this.nzu != null) {
                aVar.e(5, this.nzu);
            }
            if (this.bxK != null) {
                aVar.e(6, this.bxK);
            }
            if (this.nzv != null) {
                aVar.e(7, this.nzv);
            }
            AppMethodBeat.o(123634);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dSf != null ? g.a.a.b.b.a.f(1, this.dSf) + 0 : 0;
            if (this.Lli != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lli);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1;
            if (this.nzu != null) {
                fS += g.a.a.b.b.a.f(5, this.nzu);
            }
            if (this.bxK != null) {
                fS += g.a.a.b.b.a.f(6, this.bxK);
            }
            if (this.nzv != null) {
                fS += g.a.a.b.b.a.f(7, this.nzv);
            }
            AppMethodBeat.o(123634);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbj dbj = (dbj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbj.dSf = aVar3.UbS.readString();
                    AppMethodBeat.o(123634);
                    return 0;
                case 2:
                    dbj.Lli = aVar3.UbS.readString();
                    AppMethodBeat.o(123634);
                    return 0;
                case 3:
                    dbj.MGs = aVar3.UbS.yZ();
                    AppMethodBeat.o(123634);
                    return 0;
                case 4:
                    dbj.MGt = aVar3.UbS.yZ();
                    AppMethodBeat.o(123634);
                    return 0;
                case 5:
                    dbj.nzu = aVar3.UbS.readString();
                    AppMethodBeat.o(123634);
                    return 0;
                case 6:
                    dbj.bxK = aVar3.UbS.readString();
                    AppMethodBeat.o(123634);
                    return 0;
                case 7:
                    dbj.nzv = aVar3.UbS.readString();
                    AppMethodBeat.o(123634);
                    return 0;
                default:
                    AppMethodBeat.o(123634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123634);
            return -1;
        }
    }
}

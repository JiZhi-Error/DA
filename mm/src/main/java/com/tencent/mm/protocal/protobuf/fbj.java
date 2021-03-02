package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class fbj extends a {
    public String Md5;
    public int NxA;
    public int NxB;
    public String xuc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110860);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                b bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(110860);
                throw bVar;
            } else if (this.xuc == null) {
                b bVar2 = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(110860);
                throw bVar2;
            } else {
                if (this.Md5 != null) {
                    aVar.e(1, this.Md5);
                }
                if (this.xuc != null) {
                    aVar.e(2, this.xuc);
                }
                aVar.aM(3, this.NxA);
                aVar.aM(4, this.NxB);
                AppMethodBeat.o(110860);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0;
            if (this.xuc != null) {
                f2 += g.a.a.b.b.a.f(2, this.xuc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.NxA) + g.a.a.b.b.a.bu(4, this.NxB);
            AppMethodBeat.o(110860);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Md5 == null) {
                b bVar3 = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(110860);
                throw bVar3;
            } else if (this.xuc == null) {
                b bVar4 = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(110860);
                throw bVar4;
            } else {
                AppMethodBeat.o(110860);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbj fbj = (fbj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbj.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(110860);
                    return 0;
                case 2:
                    fbj.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(110860);
                    return 0;
                case 3:
                    fbj.NxA = aVar3.UbS.zi();
                    AppMethodBeat.o(110860);
                    return 0;
                case 4:
                    fbj.NxB = aVar3.UbS.zi();
                    AppMethodBeat.o(110860);
                    return 0;
                default:
                    AppMethodBeat.o(110860);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110860);
            return -1;
        }
    }
}

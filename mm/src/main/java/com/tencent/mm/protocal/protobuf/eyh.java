package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyh extends a {
    public String UserName;
    public String oUJ;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32517);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(32517);
                throw bVar;
            } else if (this.oUJ == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(32517);
                throw bVar2;
            } else {
                if (this.UserName != null) {
                    aVar.e(1, this.UserName);
                }
                if (this.oUJ != null) {
                    aVar.e(2, this.oUJ);
                }
                aVar.aM(3, this.oUv);
                AppMethodBeat.o(32517);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oUv);
            AppMethodBeat.o(32517);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                b bVar3 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(32517);
                throw bVar3;
            } else if (this.oUJ == null) {
                b bVar4 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(32517);
                throw bVar4;
            } else {
                AppMethodBeat.o(32517);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyh eyh = (eyh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyh.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32517);
                    return 0;
                case 2:
                    eyh.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32517);
                    return 0;
                case 3:
                    eyh.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32517);
                    return 0;
                default:
                    AppMethodBeat.o(32517);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32517);
            return -1;
        }
    }
}

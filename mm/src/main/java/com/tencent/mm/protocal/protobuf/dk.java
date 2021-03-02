package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dk extends a {
    public long KHA;
    public String KHz;
    public String jGZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152487);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jGZ == null) {
                b bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152487);
                throw bVar;
            } else if (this.KHz == null) {
                b bVar2 = new b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.o(152487);
                throw bVar2;
            } else {
                if (this.jGZ != null) {
                    aVar.e(1, this.jGZ);
                }
                if (this.KHz != null) {
                    aVar.e(2, this.KHz);
                }
                aVar.bb(3, this.KHA);
                AppMethodBeat.o(152487);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.jGZ != null ? g.a.a.b.b.a.f(1, this.jGZ) + 0 : 0;
            if (this.KHz != null) {
                f2 += g.a.a.b.b.a.f(2, this.KHz);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.KHA);
            AppMethodBeat.o(152487);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jGZ == null) {
                b bVar3 = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(152487);
                throw bVar3;
            } else if (this.KHz == null) {
                b bVar4 = new b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.o(152487);
                throw bVar4;
            } else {
                AppMethodBeat.o(152487);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dk dkVar = (dk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkVar.jGZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152487);
                    return 0;
                case 2:
                    dkVar.KHz = aVar3.UbS.readString();
                    AppMethodBeat.o(152487);
                    return 0;
                case 3:
                    dkVar.KHA = aVar3.UbS.zl();
                    AppMethodBeat.o(152487);
                    return 0;
                default:
                    AppMethodBeat.o(152487);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152487);
            return -1;
        }
    }
}

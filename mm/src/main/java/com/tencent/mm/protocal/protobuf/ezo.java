package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ezo extends a {
    public String KTg;
    public String MRZ;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32558);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                b bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32558);
                throw bVar;
            } else if (this.KTg == null) {
                b bVar2 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(32558);
                throw bVar2;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                if (this.KTg != null) {
                    aVar.e(2, this.KTg);
                }
                aVar.aM(3, this.Scene);
                AppMethodBeat.o(32558);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0;
            if (this.KTg != null) {
                f2 += g.a.a.b.b.a.f(2, this.KTg);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(32558);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                b bVar3 = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32558);
                throw bVar3;
            } else if (this.KTg == null) {
                b bVar4 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(32558);
                throw bVar4;
            } else {
                AppMethodBeat.o(32558);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezo ezo = (ezo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezo.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32558);
                    return 0;
                case 2:
                    ezo.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(32558);
                    return 0;
                case 3:
                    ezo.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32558);
                    return 0;
                default:
                    AppMethodBeat.o(32558);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32558);
            return -1;
        }
    }
}
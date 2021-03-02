package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ezm extends a {
    public String KZu;
    public String MD5;
    public String MRZ;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32556);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                b bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32556);
                throw bVar;
            } else if (this.MD5 == null) {
                b bVar2 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32556);
                throw bVar2;
            } else if (this.KZu == null) {
                b bVar3 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32556);
                throw bVar3;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                if (this.MD5 != null) {
                    aVar.e(2, this.MD5);
                }
                if (this.KZu != null) {
                    aVar.e(3, this.KZu);
                }
                aVar.aM(4, this.Scene);
                AppMethodBeat.o(32556);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0;
            if (this.MD5 != null) {
                f2 += g.a.a.b.b.a.f(2, this.MD5);
            }
            if (this.KZu != null) {
                f2 += g.a.a.b.b.a.f(3, this.KZu);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Scene);
            AppMethodBeat.o(32556);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                b bVar4 = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32556);
                throw bVar4;
            } else if (this.MD5 == null) {
                b bVar5 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32556);
                throw bVar5;
            } else if (this.KZu == null) {
                b bVar6 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32556);
                throw bVar6;
            } else {
                AppMethodBeat.o(32556);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezm ezm = (ezm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezm.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32556);
                    return 0;
                case 2:
                    ezm.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32556);
                    return 0;
                case 3:
                    ezm.KZu = aVar3.UbS.readString();
                    AppMethodBeat.o(32556);
                    return 0;
                case 4:
                    ezm.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32556);
                    return 0;
                default:
                    AppMethodBeat.o(32556);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32556);
            return -1;
        }
    }
}

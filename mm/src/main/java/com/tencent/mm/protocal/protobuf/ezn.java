package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ezn extends a {
    public String KTg;
    public String KZu;
    public String MD5;
    public String MRZ;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32557);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                b bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32557);
                throw bVar;
            } else if (this.KTg == null) {
                b bVar2 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(32557);
                throw bVar2;
            } else if (this.MD5 == null) {
                b bVar3 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32557);
                throw bVar3;
            } else if (this.KZu == null) {
                b bVar4 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32557);
                throw bVar4;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                if (this.KTg != null) {
                    aVar.e(2, this.KTg);
                }
                if (this.MD5 != null) {
                    aVar.e(3, this.MD5);
                }
                if (this.KZu != null) {
                    aVar.e(4, this.KZu);
                }
                aVar.aM(5, this.Scene);
                AppMethodBeat.o(32557);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0;
            if (this.KTg != null) {
                f2 += g.a.a.b.b.a.f(2, this.KTg);
            }
            if (this.MD5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.MD5);
            }
            if (this.KZu != null) {
                f2 += g.a.a.b.b.a.f(4, this.KZu);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Scene);
            AppMethodBeat.o(32557);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                b bVar5 = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32557);
                throw bVar5;
            } else if (this.KTg == null) {
                b bVar6 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(32557);
                throw bVar6;
            } else if (this.MD5 == null) {
                b bVar7 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(32557);
                throw bVar7;
            } else if (this.KZu == null) {
                b bVar8 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32557);
                throw bVar8;
            } else {
                AppMethodBeat.o(32557);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezn ezn = (ezn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezn.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32557);
                    return 0;
                case 2:
                    ezn.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(32557);
                    return 0;
                case 3:
                    ezn.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32557);
                    return 0;
                case 4:
                    ezn.KZu = aVar3.UbS.readString();
                    AppMethodBeat.o(32557);
                    return 0;
                case 5:
                    ezn.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32557);
                    return 0;
                default:
                    AppMethodBeat.o(32557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32557);
            return -1;
        }
    }
}

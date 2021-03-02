package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class rv extends a {
    public String IconUrl;
    public String KZl;
    public String KZm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117844);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.IconUrl == null) {
                b bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(117844);
                throw bVar;
            }
            if (this.IconUrl != null) {
                aVar.e(1, this.IconUrl);
            }
            if (this.KZl != null) {
                aVar.e(2, this.KZl);
            }
            if (this.KZm != null) {
                aVar.e(3, this.KZm);
            }
            AppMethodBeat.o(117844);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.IconUrl != null ? g.a.a.b.b.a.f(1, this.IconUrl) + 0 : 0;
            if (this.KZl != null) {
                f2 += g.a.a.b.b.a.f(2, this.KZl);
            }
            if (this.KZm != null) {
                f2 += g.a.a.b.b.a.f(3, this.KZm);
            }
            AppMethodBeat.o(117844);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.IconUrl == null) {
                b bVar2 = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(117844);
                throw bVar2;
            }
            AppMethodBeat.o(117844);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rv rvVar = (rv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rvVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(117844);
                    return 0;
                case 2:
                    rvVar.KZl = aVar3.UbS.readString();
                    AppMethodBeat.o(117844);
                    return 0;
                case 3:
                    rvVar.KZm = aVar3.UbS.readString();
                    AppMethodBeat.o(117844);
                    return 0;
                default:
                    AppMethodBeat.o(117844);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117844);
            return -1;
        }
    }
}

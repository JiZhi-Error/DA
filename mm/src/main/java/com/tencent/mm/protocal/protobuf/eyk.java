package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyk extends a {
    public String KZu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32520);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZu == null) {
                b bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32520);
                throw bVar;
            }
            if (this.KZu != null) {
                aVar.e(1, this.KZu);
            }
            AppMethodBeat.o(32520);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KZu != null ? g.a.a.b.b.a.f(1, this.KZu) + 0 : 0;
            AppMethodBeat.o(32520);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KZu == null) {
                b bVar2 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(32520);
                throw bVar2;
            }
            AppMethodBeat.o(32520);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyk eyk = (eyk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyk.KZu = aVar3.UbS.readString();
                    AppMethodBeat.o(32520);
                    return 0;
                default:
                    AppMethodBeat.o(32520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32520);
            return -1;
        }
    }
}

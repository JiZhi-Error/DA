package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class crl extends a {
    public String content;
    public String lang;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117534);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.lang == null) {
                b bVar = new b("Not all required fields were included: lang");
                AppMethodBeat.o(117534);
                throw bVar;
            } else if (this.content == null) {
                b bVar2 = new b("Not all required fields were included: content");
                AppMethodBeat.o(117534);
                throw bVar2;
            } else {
                if (this.lang != null) {
                    aVar.e(1, this.lang);
                }
                if (this.content != null) {
                    aVar.e(2, this.content);
                }
                AppMethodBeat.o(117534);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.lang != null ? g.a.a.b.b.a.f(1, this.lang) + 0 : 0;
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(2, this.content);
            }
            AppMethodBeat.o(117534);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.lang == null) {
                b bVar3 = new b("Not all required fields were included: lang");
                AppMethodBeat.o(117534);
                throw bVar3;
            } else if (this.content == null) {
                b bVar4 = new b("Not all required fields were included: content");
                AppMethodBeat.o(117534);
                throw bVar4;
            } else {
                AppMethodBeat.o(117534);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crl crl = (crl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crl.lang = aVar3.UbS.readString();
                    AppMethodBeat.o(117534);
                    return 0;
                case 2:
                    crl.content = aVar3.UbS.readString();
                    AppMethodBeat.o(117534);
                    return 0;
                default:
                    AppMethodBeat.o(117534);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117534);
            return -1;
        }
    }
}

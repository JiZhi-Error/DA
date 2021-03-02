package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class anu extends a {
    public String Lzu;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153271);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title == null) {
                b bVar = new b("Not all required fields were included: title");
                AppMethodBeat.o(153271);
                throw bVar;
            } else if (this.Lzu == null) {
                b bVar2 = new b("Not all required fields were included: jumpurl_prefix");
                AppMethodBeat.o(153271);
                throw bVar2;
            } else {
                if (this.title != null) {
                    aVar.e(1, this.title);
                }
                if (this.Lzu != null) {
                    aVar.e(2, this.Lzu);
                }
                AppMethodBeat.o(153271);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.Lzu != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lzu);
            }
            AppMethodBeat.o(153271);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.title == null) {
                b bVar3 = new b("Not all required fields were included: title");
                AppMethodBeat.o(153271);
                throw bVar3;
            } else if (this.Lzu == null) {
                b bVar4 = new b("Not all required fields were included: jumpurl_prefix");
                AppMethodBeat.o(153271);
                throw bVar4;
            } else {
                AppMethodBeat.o(153271);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anu anu = (anu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anu.title = aVar3.UbS.readString();
                    AppMethodBeat.o(153271);
                    return 0;
                case 2:
                    anu.Lzu = aVar3.UbS.readString();
                    AppMethodBeat.o(153271);
                    return 0;
                default:
                    AppMethodBeat.o(153271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153271);
            return -1;
        }
    }
}

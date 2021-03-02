package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class es extends a {
    public String KIi;
    public String KIj;
    public String content;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50079);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.content == null) {
                b bVar = new b("Not all required fields were included: content");
                AppMethodBeat.o(50079);
                throw bVar;
            }
            if (this.content != null) {
                aVar.e(1, this.content);
            }
            if (this.KIi != null) {
                aVar.e(2, this.KIi);
            }
            if (this.KIj != null) {
                aVar.e(3, this.KIj);
            }
            AppMethodBeat.o(50079);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.content != null ? g.a.a.b.b.a.f(1, this.content) + 0 : 0;
            if (this.KIi != null) {
                f2 += g.a.a.b.b.a.f(2, this.KIi);
            }
            if (this.KIj != null) {
                f2 += g.a.a.b.b.a.f(3, this.KIj);
            }
            AppMethodBeat.o(50079);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.content == null) {
                b bVar2 = new b("Not all required fields were included: content");
                AppMethodBeat.o(50079);
                throw bVar2;
            }
            AppMethodBeat.o(50079);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            es esVar = (es) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    esVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(50079);
                    return 0;
                case 2:
                    esVar.KIi = aVar3.UbS.readString();
                    AppMethodBeat.o(50079);
                    return 0;
                case 3:
                    esVar.KIj = aVar3.UbS.readString();
                    AppMethodBeat.o(50079);
                    return 0;
                default:
                    AppMethodBeat.o(50079);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50079);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class agy extends a {
    public LinkedList<String> LqB = new LinkedList<>();
    public String LqC;
    public String desc;
    public String detail;
    public String title;
    public String url;

    public agy() {
        AppMethodBeat.i(113994);
        AppMethodBeat.o(113994);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113995);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.e(4, 1, this.LqB);
            if (this.detail != null) {
                aVar.e(5, this.detail);
            }
            if (this.LqC != null) {
                aVar.e(6, this.LqC);
            }
            AppMethodBeat.o(113995);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            int c2 = f2 + g.a.a.a.c(4, 1, this.LqB);
            if (this.detail != null) {
                c2 += g.a.a.b.b.a.f(5, this.detail);
            }
            if (this.LqC != null) {
                c2 += g.a.a.b.b.a.f(6, this.LqC);
            }
            AppMethodBeat.o(113995);
            return c2;
        } else if (i2 == 2) {
            this.LqB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113995);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            agy agy = (agy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agy.title = aVar3.UbS.readString();
                    AppMethodBeat.o(113995);
                    return 0;
                case 2:
                    agy.url = aVar3.UbS.readString();
                    AppMethodBeat.o(113995);
                    return 0;
                case 3:
                    agy.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(113995);
                    return 0;
                case 4:
                    agy.LqB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(113995);
                    return 0;
                case 5:
                    agy.detail = aVar3.UbS.readString();
                    AppMethodBeat.o(113995);
                    return 0;
                case 6:
                    agy.LqC = aVar3.UbS.readString();
                    AppMethodBeat.o(113995);
                    return 0;
                default:
                    AppMethodBeat.o(113995);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113995);
            return -1;
        }
    }
}

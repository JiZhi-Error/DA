package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ye extends a {
    public boolean Lje;
    public String desc;
    public String result;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186344);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.result != null) {
                aVar.e(3, this.result);
            }
            aVar.cc(4, this.Lje);
            AppMethodBeat.o(186344);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.result != null) {
                f2 += g.a.a.b.b.a.f(3, this.result);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(186344);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186344);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ye yeVar = (ye) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yeVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(186344);
                    return 0;
                case 2:
                    yeVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(186344);
                    return 0;
                case 3:
                    yeVar.result = aVar3.UbS.readString();
                    AppMethodBeat.o(186344);
                    return 0;
                case 4:
                    yeVar.Lje = aVar3.UbS.yZ();
                    AppMethodBeat.o(186344);
                    return 0;
                default:
                    AppMethodBeat.o(186344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186344);
            return -1;
        }
    }
}

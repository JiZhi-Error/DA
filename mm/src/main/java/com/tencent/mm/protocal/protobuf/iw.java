package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class iw extends a {
    public String HLy;
    public String Hwr;
    public String Hws;
    public String title;
    public int uSc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91354);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.aM(2, this.uSc);
            if (this.HLy != null) {
                aVar.e(3, this.HLy);
            }
            if (this.Hwr != null) {
                aVar.e(4, this.Hwr);
            }
            if (this.Hws != null) {
                aVar.e(5, this.Hws);
            }
            AppMethodBeat.o(91354);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0) + g.a.a.b.b.a.bu(2, this.uSc);
            if (this.HLy != null) {
                f2 += g.a.a.b.b.a.f(3, this.HLy);
            }
            if (this.Hwr != null) {
                f2 += g.a.a.b.b.a.f(4, this.Hwr);
            }
            if (this.Hws != null) {
                f2 += g.a.a.b.b.a.f(5, this.Hws);
            }
            AppMethodBeat.o(91354);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91354);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            iw iwVar = (iw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iwVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91354);
                    return 0;
                case 2:
                    iwVar.uSc = aVar3.UbS.zi();
                    AppMethodBeat.o(91354);
                    return 0;
                case 3:
                    iwVar.HLy = aVar3.UbS.readString();
                    AppMethodBeat.o(91354);
                    return 0;
                case 4:
                    iwVar.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(91354);
                    return 0;
                case 5:
                    iwVar.Hws = aVar3.UbS.readString();
                    AppMethodBeat.o(91354);
                    return 0;
                default:
                    AppMethodBeat.o(91354);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91354);
            return -1;
        }
    }
}
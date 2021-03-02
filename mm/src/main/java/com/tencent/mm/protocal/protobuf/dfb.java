package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dfb extends a {
    public String LGp;
    public int MKc;
    public String dQx;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104374);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.LGp != null) {
                aVar.e(3, this.LGp);
            }
            aVar.aM(4, this.MKc);
            AppMethodBeat.o(104374);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.LGp != null) {
                f2 += g.a.a.b.b.a.f(3, this.LGp);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MKc);
            AppMethodBeat.o(104374);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104374);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfb dfb = (dfb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dfb.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(104374);
                    return 0;
                case 2:
                    dfb.url = aVar3.UbS.readString();
                    AppMethodBeat.o(104374);
                    return 0;
                case 3:
                    dfb.LGp = aVar3.UbS.readString();
                    AppMethodBeat.o(104374);
                    return 0;
                case 4:
                    dfb.MKc = aVar3.UbS.zi();
                    AppMethodBeat.o(104374);
                    return 0;
                default:
                    AppMethodBeat.o(104374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104374);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class crb extends a {
    public String MbW;
    public String Meq;
    public String Mer;
    public String dPS;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123628);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MbW != null) {
                aVar.e(1, this.MbW);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.dPS != null) {
                aVar.e(3, this.dPS);
            }
            if (this.Meq != null) {
                aVar.e(4, this.Meq);
            }
            if (this.Mer != null) {
                aVar.e(5, this.Mer);
            }
            AppMethodBeat.o(123628);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MbW != null ? g.a.a.b.b.a.f(1, this.MbW) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.dPS != null) {
                f2 += g.a.a.b.b.a.f(3, this.dPS);
            }
            if (this.Meq != null) {
                f2 += g.a.a.b.b.a.f(4, this.Meq);
            }
            if (this.Mer != null) {
                f2 += g.a.a.b.b.a.f(5, this.Mer);
            }
            AppMethodBeat.o(123628);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123628);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crb crb = (crb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crb.MbW = aVar3.UbS.readString();
                    AppMethodBeat.o(123628);
                    return 0;
                case 2:
                    crb.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123628);
                    return 0;
                case 3:
                    crb.dPS = aVar3.UbS.readString();
                    AppMethodBeat.o(123628);
                    return 0;
                case 4:
                    crb.Meq = aVar3.UbS.readString();
                    AppMethodBeat.o(123628);
                    return 0;
                case 5:
                    crb.Mer = aVar3.UbS.readString();
                    AppMethodBeat.o(123628);
                    return 0;
                default:
                    AppMethodBeat.o(123628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123628);
            return -1;
        }
    }
}

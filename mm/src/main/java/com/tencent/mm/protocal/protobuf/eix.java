package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eix extends a {
    public long NiK;
    public long NiL;
    public long Niv;
    public String mediaId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153014);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.mediaId != null) {
                aVar.e(1, this.mediaId);
            }
            aVar.bb(2, this.NiK);
            aVar.bb(3, this.NiL);
            aVar.bb(4, this.Niv);
            AppMethodBeat.o(153014);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.mediaId != null ? g.a.a.b.b.a.f(1, this.mediaId) + 0 : 0) + g.a.a.b.b.a.r(2, this.NiK) + g.a.a.b.b.a.r(3, this.NiL) + g.a.a.b.b.a.r(4, this.Niv);
            AppMethodBeat.o(153014);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153014);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eix eix = (eix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eix.mediaId = aVar3.UbS.readString();
                    AppMethodBeat.o(153014);
                    return 0;
                case 2:
                    eix.NiK = aVar3.UbS.zl();
                    AppMethodBeat.o(153014);
                    return 0;
                case 3:
                    eix.NiL = aVar3.UbS.zl();
                    AppMethodBeat.o(153014);
                    return 0;
                case 4:
                    eix.Niv = aVar3.UbS.zl();
                    AppMethodBeat.o(153014);
                    return 0;
                default:
                    AppMethodBeat.o(153014);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153014);
            return -1;
        }
    }
}

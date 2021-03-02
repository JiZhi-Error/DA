package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dqh extends a {
    public boolean UJy;
    public String businessType;
    public String dNI;
    public String extInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209813);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.businessType != null) {
                aVar.e(1, this.businessType);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.extInfo != null) {
                aVar.e(3, this.extInfo);
            }
            aVar.cc(4, this.UJy);
            AppMethodBeat.o(209813);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.businessType != null ? g.a.a.b.b.a.f(1, this.businessType) + 0 : 0;
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.extInfo != null) {
                f2 += g.a.a.b.b.a.f(3, this.extInfo);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(209813);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209813);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqh dqh = (dqh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqh.businessType = aVar3.UbS.readString();
                    AppMethodBeat.o(209813);
                    return 0;
                case 2:
                    dqh.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(209813);
                    return 0;
                case 3:
                    dqh.extInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(209813);
                    return 0;
                case 4:
                    dqh.UJy = aVar3.UbS.yZ();
                    AppMethodBeat.o(209813);
                    return 0;
                default:
                    AppMethodBeat.o(209813);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209813);
            return -1;
        }
    }
}

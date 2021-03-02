package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cni extends a {
    public long MtO;
    public String content;
    public int extFlag;
    public int iXu;
    public long id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209734);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            aVar.bb(3, this.MtO);
            aVar.aM(4, this.iXu);
            aVar.aM(5, this.extFlag);
            AppMethodBeat.o(209734);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0;
            if (this.content != null) {
                r += g.a.a.b.b.a.f(2, this.content);
            }
            int r2 = r + g.a.a.b.b.a.r(3, this.MtO) + g.a.a.b.b.a.bu(4, this.iXu) + g.a.a.b.b.a.bu(5, this.extFlag);
            AppMethodBeat.o(209734);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209734);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cni cni = (cni) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cni.id = aVar3.UbS.zl();
                    AppMethodBeat.o(209734);
                    return 0;
                case 2:
                    cni.content = aVar3.UbS.readString();
                    AppMethodBeat.o(209734);
                    return 0;
                case 3:
                    cni.MtO = aVar3.UbS.zl();
                    AppMethodBeat.o(209734);
                    return 0;
                case 4:
                    cni.iXu = aVar3.UbS.zi();
                    AppMethodBeat.o(209734);
                    return 0;
                case 5:
                    cni.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209734);
                    return 0;
                default:
                    AppMethodBeat.o(209734);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209734);
            return -1;
        }
    }
}

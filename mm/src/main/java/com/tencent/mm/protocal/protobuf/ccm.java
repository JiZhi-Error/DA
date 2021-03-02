package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ccm extends a {
    public double jiP;
    public int major;
    public int minor;
    public String uuid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82426);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.uuid != null) {
                aVar.e(1, this.uuid);
            }
            aVar.aM(2, this.major);
            aVar.aM(3, this.minor);
            aVar.e(4, this.jiP);
            AppMethodBeat.o(82426);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.uuid != null ? g.a.a.b.b.a.f(1, this.uuid) + 0 : 0) + g.a.a.b.b.a.bu(2, this.major) + g.a.a.b.b.a.bu(3, this.minor) + g.a.a.b.b.a.fS(4) + 8;
            AppMethodBeat.o(82426);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82426);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccm ccm = (ccm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccm.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(82426);
                    return 0;
                case 2:
                    ccm.major = aVar3.UbS.zi();
                    AppMethodBeat.o(82426);
                    return 0;
                case 3:
                    ccm.minor = aVar3.UbS.zi();
                    AppMethodBeat.o(82426);
                    return 0;
                case 4:
                    ccm.jiP = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(82426);
                    return 0;
                default:
                    AppMethodBeat.o(82426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82426);
            return -1;
        }
    }
}

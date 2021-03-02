package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eub extends a {
    public int HiN;
    public String Ngz;
    public int Nrv;
    public int gap;
    public int port;
    public int timeout;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115896);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ngz != null) {
                aVar.e(1, this.Ngz);
            }
            aVar.aM(2, this.port);
            aVar.aM(3, this.HiN);
            aVar.aM(4, this.gap);
            aVar.aM(5, this.timeout);
            aVar.aM(6, this.Nrv);
            AppMethodBeat.o(115896);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Ngz != null ? g.a.a.b.b.a.f(1, this.Ngz) + 0 : 0) + g.a.a.b.b.a.bu(2, this.port) + g.a.a.b.b.a.bu(3, this.HiN) + g.a.a.b.b.a.bu(4, this.gap) + g.a.a.b.b.a.bu(5, this.timeout) + g.a.a.b.b.a.bu(6, this.Nrv);
            AppMethodBeat.o(115896);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115896);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eub eub = (eub) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eub.Ngz = aVar3.UbS.readString();
                    AppMethodBeat.o(115896);
                    return 0;
                case 2:
                    eub.port = aVar3.UbS.zi();
                    AppMethodBeat.o(115896);
                    return 0;
                case 3:
                    eub.HiN = aVar3.UbS.zi();
                    AppMethodBeat.o(115896);
                    return 0;
                case 4:
                    eub.gap = aVar3.UbS.zi();
                    AppMethodBeat.o(115896);
                    return 0;
                case 5:
                    eub.timeout = aVar3.UbS.zi();
                    AppMethodBeat.o(115896);
                    return 0;
                case 6:
                    eub.Nrv = aVar3.UbS.zi();
                    AppMethodBeat.o(115896);
                    return 0;
                default:
                    AppMethodBeat.o(115896);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115896);
            return -1;
        }
    }
}

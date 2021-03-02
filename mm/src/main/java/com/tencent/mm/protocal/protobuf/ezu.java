package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezu extends a {
    public b KKz;
    public int KUy;
    public String MRZ;
    public boolean NvT;
    public boolean NvU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32564);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32564);
                throw bVar;
            }
            if (this.MRZ != null) {
                aVar.e(1, this.MRZ);
            }
            aVar.aM(2, this.KUy);
            if (this.KKz != null) {
                aVar.c(3, this.KKz);
            }
            aVar.cc(4, this.NvT);
            aVar.cc(5, this.NvU);
            AppMethodBeat.o(32564);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KUy);
            if (this.KKz != null) {
                f2 += g.a.a.b.b.a.b(3, this.KKz);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(32564);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32564);
                throw bVar2;
            }
            AppMethodBeat.o(32564);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezu ezu = (ezu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezu.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32564);
                    return 0;
                case 2:
                    ezu.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(32564);
                    return 0;
                case 3:
                    ezu.KKz = aVar3.UbS.hPo();
                    AppMethodBeat.o(32564);
                    return 0;
                case 4:
                    ezu.NvT = aVar3.UbS.yZ();
                    AppMethodBeat.o(32564);
                    return 0;
                case 5:
                    ezu.NvU = aVar3.UbS.yZ();
                    AppMethodBeat.o(32564);
                    return 0;
                default:
                    AppMethodBeat.o(32564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32564);
            return -1;
        }
    }
}

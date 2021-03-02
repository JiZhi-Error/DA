package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezp extends a {
    public b KKz;
    public String MRZ;
    public long NvN;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32559);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32559);
                throw bVar;
            } else if (this.KKz == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32559);
                throw bVar2;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                aVar.bb(2, this.NvN);
                if (this.KKz != null) {
                    aVar.c(3, this.KKz);
                }
                aVar.aM(4, this.Scene);
                AppMethodBeat.o(32559);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0) + g.a.a.b.b.a.r(2, this.NvN);
            if (this.KKz != null) {
                f2 += g.a.a.b.b.a.b(3, this.KKz);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Scene);
            AppMethodBeat.o(32559);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32559);
                throw bVar3;
            } else if (this.KKz == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32559);
                throw bVar4;
            } else {
                AppMethodBeat.o(32559);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezp ezp = (ezp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezp.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32559);
                    return 0;
                case 2:
                    ezp.NvN = aVar3.UbS.zl();
                    AppMethodBeat.o(32559);
                    return 0;
                case 3:
                    ezp.KKz = aVar3.UbS.hPo();
                    AppMethodBeat.o(32559);
                    return 0;
                case 4:
                    ezp.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32559);
                    return 0;
                default:
                    AppMethodBeat.o(32559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32559);
            return -1;
        }
    }
}

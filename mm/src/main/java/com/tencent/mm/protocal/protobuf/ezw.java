package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezw extends a {
    public String MRZ;
    public b Nvo;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32566);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32566);
                throw bVar;
            } else if (this.oUJ == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(32566);
                throw bVar2;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                if (this.oUJ != null) {
                    aVar.e(2, this.oUJ);
                }
                if (this.Nvo != null) {
                    aVar.c(3, this.Nvo);
                }
                AppMethodBeat.o(32566);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.Nvo != null) {
                f2 += g.a.a.b.b.a.b(3, this.Nvo);
            }
            AppMethodBeat.o(32566);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32566);
                throw bVar3;
            } else if (this.oUJ == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(32566);
                throw bVar4;
            } else {
                AppMethodBeat.o(32566);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezw ezw = (ezw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezw.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32566);
                    return 0;
                case 2:
                    ezw.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32566);
                    return 0;
                case 3:
                    ezw.Nvo = aVar3.UbS.hPo();
                    AppMethodBeat.o(32566);
                    return 0;
                default:
                    AppMethodBeat.o(32566);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32566);
            return -1;
        }
    }
}

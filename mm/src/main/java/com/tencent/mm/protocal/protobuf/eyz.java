package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class eyz extends a {
    public long KMc;
    public long KMm;
    public String MRZ;
    public String Nickname;
    public boolean NvA;
    public b NvB;
    public String iAc;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32539);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nickname == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Nickname");
                AppMethodBeat.o(32539);
                throw bVar;
            } else if (this.iAc == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32539);
                throw bVar2;
            } else if (this.MRZ == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32539);
                throw bVar3;
            } else {
                aVar.bb(1, this.KMm);
                if (this.Nickname != null) {
                    aVar.e(2, this.Nickname);
                }
                if (this.iAc != null) {
                    aVar.e(3, this.iAc);
                }
                aVar.aM(4, this.xKb);
                if (this.MRZ != null) {
                    aVar.e(5, this.MRZ);
                }
                aVar.bb(6, this.KMc);
                aVar.cc(7, this.NvA);
                if (this.NvB != null) {
                    aVar.c(8, this.NvB);
                }
                AppMethodBeat.o(32539);
                return 0;
            }
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KMm) + 0;
            if (this.Nickname != null) {
                r += g.a.a.b.b.a.f(2, this.Nickname);
            }
            if (this.iAc != null) {
                r += g.a.a.b.b.a.f(3, this.iAc);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.xKb);
            if (this.MRZ != null) {
                bu += g.a.a.b.b.a.f(5, this.MRZ);
            }
            int r2 = bu + g.a.a.b.b.a.r(6, this.KMc) + g.a.a.b.b.a.fS(7) + 1;
            if (this.NvB != null) {
                r2 += g.a.a.b.b.a.b(8, this.NvB);
            }
            AppMethodBeat.o(32539);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nickname == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: Nickname");
                AppMethodBeat.o(32539);
                throw bVar4;
            } else if (this.iAc == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32539);
                throw bVar5;
            } else if (this.MRZ == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32539);
                throw bVar6;
            } else {
                AppMethodBeat.o(32539);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyz eyz = (eyz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyz.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(32539);
                    return 0;
                case 2:
                    eyz.Nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(32539);
                    return 0;
                case 3:
                    eyz.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32539);
                    return 0;
                case 4:
                    eyz.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(32539);
                    return 0;
                case 5:
                    eyz.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32539);
                    return 0;
                case 6:
                    eyz.KMc = aVar3.UbS.zl();
                    AppMethodBeat.o(32539);
                    return 0;
                case 7:
                    eyz.NvA = aVar3.UbS.yZ();
                    AppMethodBeat.o(32539);
                    return 0;
                case 8:
                    eyz.NvB = aVar3.UbS.hPo();
                    AppMethodBeat.o(32539);
                    return 0;
                default:
                    AppMethodBeat.o(32539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32539);
            return -1;
        }
    }
}

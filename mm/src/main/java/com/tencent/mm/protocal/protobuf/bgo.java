package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bgo extends a {
    public int KSa;
    public int LQr;
    public String LQs;
    public String LQt;
    public String jfi;
    public b oTm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50086);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: AppId");
                AppMethodBeat.o(50086);
                throw bVar;
            } else if (this.oTm == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(50086);
                throw bVar2;
            } else if (this.LQt == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: EventInfo");
                AppMethodBeat.o(50086);
                throw bVar3;
            } else {
                if (this.jfi != null) {
                    aVar.e(1, this.jfi);
                }
                aVar.aM(2, this.KSa);
                aVar.aM(3, this.LQr);
                if (this.oTm != null) {
                    aVar.c(4, this.oTm);
                }
                if (this.LQs != null) {
                    aVar.e(5, this.LQs);
                }
                if (this.LQt != null) {
                    aVar.e(6, this.LQt);
                }
                AppMethodBeat.o(50086);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KSa) + g.a.a.b.b.a.bu(3, this.LQr);
            if (this.oTm != null) {
                f2 += g.a.a.b.b.a.b(4, this.oTm);
            }
            if (this.LQs != null) {
                f2 += g.a.a.b.b.a.f(5, this.LQs);
            }
            if (this.LQt != null) {
                f2 += g.a.a.b.b.a.f(6, this.LQt);
            }
            AppMethodBeat.o(50086);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: AppId");
                AppMethodBeat.o(50086);
                throw bVar4;
            } else if (this.oTm == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(50086);
                throw bVar5;
            } else if (this.LQt == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: EventInfo");
                AppMethodBeat.o(50086);
                throw bVar6;
            } else {
                AppMethodBeat.o(50086);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgo bgo = (bgo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgo.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(50086);
                    return 0;
                case 2:
                    bgo.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(50086);
                    return 0;
                case 3:
                    bgo.LQr = aVar3.UbS.zi();
                    AppMethodBeat.o(50086);
                    return 0;
                case 4:
                    bgo.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(50086);
                    return 0;
                case 5:
                    bgo.LQs = aVar3.UbS.readString();
                    AppMethodBeat.o(50086);
                    return 0;
                case 6:
                    bgo.LQt = aVar3.UbS.readString();
                    AppMethodBeat.o(50086);
                    return 0;
                default:
                    AppMethodBeat.o(50086);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50086);
            return -1;
        }
    }
}

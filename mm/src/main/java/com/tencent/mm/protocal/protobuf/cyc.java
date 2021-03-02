package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cyc extends a {
    public String HXc;
    public String MDb;
    public String app_id;
    public String qcK;
    public String qcM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72540);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.app_id != null) {
                aVar.e(1, this.app_id);
            }
            if (this.HXc != null) {
                aVar.e(2, this.HXc);
            }
            if (this.qcM != null) {
                aVar.e(3, this.qcM);
            }
            if (this.qcK != null) {
                aVar.e(4, this.qcK);
            }
            if (this.MDb != null) {
                aVar.e(5, this.MDb);
            }
            AppMethodBeat.o(72540);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.app_id != null ? g.a.a.b.b.a.f(1, this.app_id) + 0 : 0;
            if (this.HXc != null) {
                f2 += g.a.a.b.b.a.f(2, this.HXc);
            }
            if (this.qcM != null) {
                f2 += g.a.a.b.b.a.f(3, this.qcM);
            }
            if (this.qcK != null) {
                f2 += g.a.a.b.b.a.f(4, this.qcK);
            }
            if (this.MDb != null) {
                f2 += g.a.a.b.b.a.f(5, this.MDb);
            }
            AppMethodBeat.o(72540);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72540);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyc cyc = (cyc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyc.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(72540);
                    return 0;
                case 2:
                    cyc.HXc = aVar3.UbS.readString();
                    AppMethodBeat.o(72540);
                    return 0;
                case 3:
                    cyc.qcM = aVar3.UbS.readString();
                    AppMethodBeat.o(72540);
                    return 0;
                case 4:
                    cyc.qcK = aVar3.UbS.readString();
                    AppMethodBeat.o(72540);
                    return 0;
                case 5:
                    cyc.MDb = aVar3.UbS.readString();
                    AppMethodBeat.o(72540);
                    return 0;
                default:
                    AppMethodBeat.o(72540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72540);
            return -1;
        }
    }
}

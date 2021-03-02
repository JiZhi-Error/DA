package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ffq extends a {
    public String LYB;
    public int Vio;
    public String app_id;
    public String path;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259320);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Vio);
            if (this.app_id != null) {
                aVar.e(2, this.app_id);
            }
            if (this.path != null) {
                aVar.e(3, this.path);
            }
            if (this.LYB != null) {
                aVar.e(4, this.LYB);
            }
            AppMethodBeat.o(259320);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Vio) + 0;
            if (this.app_id != null) {
                bu += g.a.a.b.b.a.f(2, this.app_id);
            }
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(3, this.path);
            }
            if (this.LYB != null) {
                bu += g.a.a.b.b.a.f(4, this.LYB);
            }
            AppMethodBeat.o(259320);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259320);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffq ffq = (ffq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffq.Vio = aVar3.UbS.zi();
                    AppMethodBeat.o(259320);
                    return 0;
                case 2:
                    ffq.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(259320);
                    return 0;
                case 3:
                    ffq.path = aVar3.UbS.readString();
                    AppMethodBeat.o(259320);
                    return 0;
                case 4:
                    ffq.LYB = aVar3.UbS.readString();
                    AppMethodBeat.o(259320);
                    return 0;
                default:
                    AppMethodBeat.o(259320);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259320);
            return -1;
        }
    }
}

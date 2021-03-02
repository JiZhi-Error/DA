package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dbu extends a {
    public String BrH;
    public String dQx;
    public long eht;
    public int state;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91619);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BrH != null) {
                aVar.e(1, this.BrH);
            }
            aVar.bb(2, this.eht);
            aVar.aM(3, this.state);
            if (this.dQx != null) {
                aVar.e(4, this.dQx);
            }
            AppMethodBeat.o(91619);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.BrH != null ? g.a.a.b.b.a.f(1, this.BrH) + 0 : 0) + g.a.a.b.b.a.r(2, this.eht) + g.a.a.b.b.a.bu(3, this.state);
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(4, this.dQx);
            }
            AppMethodBeat.o(91619);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91619);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbu dbu = (dbu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbu.BrH = aVar3.UbS.readString();
                    AppMethodBeat.o(91619);
                    return 0;
                case 2:
                    dbu.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91619);
                    return 0;
                case 3:
                    dbu.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91619);
                    return 0;
                case 4:
                    dbu.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91619);
                    return 0;
                default:
                    AppMethodBeat.o(91619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91619);
            return -1;
        }
    }
}

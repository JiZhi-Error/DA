package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ckf extends a {
    public int MpC;
    public String devicename;
    public String devicetype;
    public String uuid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155438);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.uuid != null) {
                aVar.e(1, this.uuid);
            }
            if (this.devicename != null) {
                aVar.e(2, this.devicename);
            }
            if (this.devicetype != null) {
                aVar.e(3, this.devicetype);
            }
            aVar.aM(4, this.MpC);
            AppMethodBeat.o(155438);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.uuid != null ? g.a.a.b.b.a.f(1, this.uuid) + 0 : 0;
            if (this.devicename != null) {
                f2 += g.a.a.b.b.a.f(2, this.devicename);
            }
            if (this.devicetype != null) {
                f2 += g.a.a.b.b.a.f(3, this.devicetype);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MpC);
            AppMethodBeat.o(155438);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155438);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckf ckf = (ckf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckf.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(155438);
                    return 0;
                case 2:
                    ckf.devicename = aVar3.UbS.readString();
                    AppMethodBeat.o(155438);
                    return 0;
                case 3:
                    ckf.devicetype = aVar3.UbS.readString();
                    AppMethodBeat.o(155438);
                    return 0;
                case 4:
                    ckf.MpC = aVar3.UbS.zi();
                    AppMethodBeat.o(155438);
                    return 0;
                default:
                    AppMethodBeat.o(155438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155438);
            return -1;
        }
    }
}

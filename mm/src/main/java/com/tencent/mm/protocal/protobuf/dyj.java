package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dyj extends a {
    public String MXX;
    public String MXY;
    public String MXZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32455);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MXX != null) {
                aVar.e(1, this.MXX);
            }
            if (this.MXY != null) {
                aVar.e(2, this.MXY);
            }
            if (this.MXZ != null) {
                aVar.e(3, this.MXZ);
            }
            AppMethodBeat.o(32455);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MXX != null ? g.a.a.b.b.a.f(1, this.MXX) + 0 : 0;
            if (this.MXY != null) {
                f2 += g.a.a.b.b.a.f(2, this.MXY);
            }
            if (this.MXZ != null) {
                f2 += g.a.a.b.b.a.f(3, this.MXZ);
            }
            AppMethodBeat.o(32455);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32455);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyj dyj = (dyj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyj.MXX = aVar3.UbS.readString();
                    AppMethodBeat.o(32455);
                    return 0;
                case 2:
                    dyj.MXY = aVar3.UbS.readString();
                    AppMethodBeat.o(32455);
                    return 0;
                case 3:
                    dyj.MXZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32455);
                    return 0;
                default:
                    AppMethodBeat.o(32455);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32455);
            return -1;
        }
    }
}

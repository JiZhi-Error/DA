package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cov extends a {
    public String MuV;
    public String MuW;
    public String MuX;
    public String MuY;
    public String MuZ;
    public String pf;
    public String session_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214315);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MuV != null) {
                aVar.e(1, this.MuV);
            }
            if (this.MuW != null) {
                aVar.e(2, this.MuW);
            }
            if (this.MuX != null) {
                aVar.e(3, this.MuX);
            }
            if (this.session_id != null) {
                aVar.e(4, this.session_id);
            }
            if (this.MuY != null) {
                aVar.e(5, this.MuY);
            }
            if (this.pf != null) {
                aVar.e(6, this.pf);
            }
            if (this.MuZ != null) {
                aVar.e(7, this.MuZ);
            }
            AppMethodBeat.o(214315);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MuV != null ? g.a.a.b.b.a.f(1, this.MuV) + 0 : 0;
            if (this.MuW != null) {
                f2 += g.a.a.b.b.a.f(2, this.MuW);
            }
            if (this.MuX != null) {
                f2 += g.a.a.b.b.a.f(3, this.MuX);
            }
            if (this.session_id != null) {
                f2 += g.a.a.b.b.a.f(4, this.session_id);
            }
            if (this.MuY != null) {
                f2 += g.a.a.b.b.a.f(5, this.MuY);
            }
            if (this.pf != null) {
                f2 += g.a.a.b.b.a.f(6, this.pf);
            }
            if (this.MuZ != null) {
                f2 += g.a.a.b.b.a.f(7, this.MuZ);
            }
            AppMethodBeat.o(214315);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214315);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cov cov = (cov) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cov.MuV = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 2:
                    cov.MuW = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 3:
                    cov.MuX = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 4:
                    cov.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 5:
                    cov.MuY = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 6:
                    cov.pf = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                case 7:
                    cov.MuZ = aVar3.UbS.readString();
                    AppMethodBeat.o(214315);
                    return 0;
                default:
                    AppMethodBeat.o(214315);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214315);
            return -1;
        }
    }
}

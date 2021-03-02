package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cap extends a {
    public int MfK;
    public b MfL;
    public b MfM;
    public b MfN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115844);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MfL == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: SPSBuf");
                AppMethodBeat.o(115844);
                throw bVar;
            } else if (this.MfM == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: PPSBuf");
                AppMethodBeat.o(115844);
                throw bVar2;
            } else {
                aVar.aM(1, this.MfK);
                if (this.MfL != null) {
                    aVar.c(2, this.MfL);
                }
                if (this.MfM != null) {
                    aVar.c(3, this.MfM);
                }
                if (this.MfN != null) {
                    aVar.c(4, this.MfN);
                }
                AppMethodBeat.o(115844);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MfK) + 0;
            if (this.MfL != null) {
                bu += g.a.a.b.b.a.b(2, this.MfL);
            }
            if (this.MfM != null) {
                bu += g.a.a.b.b.a.b(3, this.MfM);
            }
            if (this.MfN != null) {
                bu += g.a.a.b.b.a.b(4, this.MfN);
            }
            AppMethodBeat.o(115844);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MfL == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: SPSBuf");
                AppMethodBeat.o(115844);
                throw bVar3;
            } else if (this.MfM == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: PPSBuf");
                AppMethodBeat.o(115844);
                throw bVar4;
            } else {
                AppMethodBeat.o(115844);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cap cap = (cap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cap.MfK = aVar3.UbS.zi();
                    AppMethodBeat.o(115844);
                    return 0;
                case 2:
                    cap.MfL = aVar3.UbS.hPo();
                    AppMethodBeat.o(115844);
                    return 0;
                case 3:
                    cap.MfM = aVar3.UbS.hPo();
                    AppMethodBeat.o(115844);
                    return 0;
                case 4:
                    cap.MfN = aVar3.UbS.hPo();
                    AppMethodBeat.o(115844);
                    return 0;
                default:
                    AppMethodBeat.o(115844);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115844);
            return -1;
        }
    }
}

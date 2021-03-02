package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bzv extends a {
    public String KPA;
    public String LRO;
    public String Mft;
    public String Mfu;
    public int Ret;
    public String UserName;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155421);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KPA != null) {
                aVar.e(1, this.KPA);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.Mft != null) {
                aVar.e(3, this.Mft);
            }
            if (this.Mfu != null) {
                aVar.e(4, this.Mfu);
            }
            aVar.aM(5, this.Ret);
            if (this.oUJ != null) {
                aVar.e(6, this.oUJ);
            }
            if (this.LRO != null) {
                aVar.e(7, this.LRO);
            }
            AppMethodBeat.o(155421);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KPA != null ? g.a.a.b.b.a.f(1, this.KPA) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.Mft != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mft);
            }
            if (this.Mfu != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mfu);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Ret);
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(6, this.oUJ);
            }
            if (this.LRO != null) {
                bu += g.a.a.b.b.a.f(7, this.LRO);
            }
            AppMethodBeat.o(155421);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155421);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzv bzv = (bzv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzv.KPA = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                case 2:
                    bzv.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                case 3:
                    bzv.Mft = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                case 4:
                    bzv.Mfu = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                case 5:
                    bzv.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(155421);
                    return 0;
                case 6:
                    bzv.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                case 7:
                    bzv.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(155421);
                    return 0;
                default:
                    AppMethodBeat.o(155421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155421);
            return -1;
        }
    }
}

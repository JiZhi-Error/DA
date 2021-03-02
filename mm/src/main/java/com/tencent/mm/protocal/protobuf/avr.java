package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class avr extends a {
    public String LGp;
    public String dQx;
    public String jumpUrl;
    public String title;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209511);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.jumpUrl != null) {
                aVar.e(4, this.jumpUrl);
            }
            if (this.LGp != null) {
                aVar.e(5, this.LGp);
            }
            AppMethodBeat.o(209511);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.jumpUrl != null) {
                bu += g.a.a.b.b.a.f(4, this.jumpUrl);
            }
            if (this.LGp != null) {
                bu += g.a.a.b.b.a.f(5, this.LGp);
            }
            AppMethodBeat.o(209511);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209511);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avr avr = (avr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avr.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209511);
                    return 0;
                case 2:
                    avr.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(209511);
                    return 0;
                case 3:
                    avr.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209511);
                    return 0;
                case 4:
                    avr.jumpUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209511);
                    return 0;
                case 5:
                    avr.LGp = aVar3.UbS.readString();
                    AppMethodBeat.o(209511);
                    return 0;
                default:
                    AppMethodBeat.o(209511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209511);
            return -1;
        }
    }
}

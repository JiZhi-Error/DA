package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class jm extends a {
    public String KOb;
    public String KOc;
    public String imei;
    public String kxx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116465);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.imei != null) {
                aVar.e(1, this.imei);
            }
            if (this.KOb != null) {
                aVar.e(2, this.KOb);
            }
            if (this.kxx != null) {
                aVar.e(3, this.kxx);
            }
            if (this.KOc != null) {
                aVar.e(4, this.KOc);
            }
            AppMethodBeat.o(116465);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.imei != null ? g.a.a.b.b.a.f(1, this.imei) + 0 : 0;
            if (this.KOb != null) {
                f2 += g.a.a.b.b.a.f(2, this.KOb);
            }
            if (this.kxx != null) {
                f2 += g.a.a.b.b.a.f(3, this.kxx);
            }
            if (this.KOc != null) {
                f2 += g.a.a.b.b.a.f(4, this.KOc);
            }
            AppMethodBeat.o(116465);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116465);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jm jmVar = (jm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jmVar.imei = aVar3.UbS.readString();
                    AppMethodBeat.o(116465);
                    return 0;
                case 2:
                    jmVar.KOb = aVar3.UbS.readString();
                    AppMethodBeat.o(116465);
                    return 0;
                case 3:
                    jmVar.kxx = aVar3.UbS.readString();
                    AppMethodBeat.o(116465);
                    return 0;
                case 4:
                    jmVar.KOc = aVar3.UbS.readString();
                    AppMethodBeat.o(116465);
                    return 0;
                default:
                    AppMethodBeat.o(116465);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116465);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bby extends a {
    public String LLa;
    public b LLb;
    public String LLc;
    public int actionType;
    public String appId;
    public String link;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209669);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LLa != null) {
                aVar.e(1, this.LLa);
            }
            aVar.aM(2, this.actionType);
            if (this.link != null) {
                aVar.e(3, this.link);
            }
            if (this.appId != null) {
                aVar.e(4, this.appId);
            }
            if (this.LLb != null) {
                aVar.c(5, this.LLb);
            }
            if (this.LLc != null) {
                aVar.e(6, this.LLc);
            }
            AppMethodBeat.o(209669);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LLa != null ? g.a.a.b.b.a.f(1, this.LLa) + 0 : 0) + g.a.a.b.b.a.bu(2, this.actionType);
            if (this.link != null) {
                f2 += g.a.a.b.b.a.f(3, this.link);
            }
            if (this.appId != null) {
                f2 += g.a.a.b.b.a.f(4, this.appId);
            }
            if (this.LLb != null) {
                f2 += g.a.a.b.b.a.b(5, this.LLb);
            }
            if (this.LLc != null) {
                f2 += g.a.a.b.b.a.f(6, this.LLc);
            }
            AppMethodBeat.o(209669);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209669);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bby bby = (bby) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bby.LLa = aVar3.UbS.readString();
                    AppMethodBeat.o(209669);
                    return 0;
                case 2:
                    bby.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(209669);
                    return 0;
                case 3:
                    bby.link = aVar3.UbS.readString();
                    AppMethodBeat.o(209669);
                    return 0;
                case 4:
                    bby.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(209669);
                    return 0;
                case 5:
                    bby.LLb = aVar3.UbS.hPo();
                    AppMethodBeat.o(209669);
                    return 0;
                case 6:
                    bby.LLc = aVar3.UbS.readString();
                    AppMethodBeat.o(209669);
                    return 0;
                default:
                    AppMethodBeat.o(209669);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209669);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cor extends a {
    public String MuQ;
    public String MuR;
    public String MuS;
    public int MuT;
    public String dQx;
    public int type;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91538);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx == null) {
                b bVar = new b("Not all required fields were included: wording");
                AppMethodBeat.o(91538);
                throw bVar;
            }
            aVar.aM(1, this.type);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.MuQ != null) {
                aVar.e(4, this.MuQ);
            }
            if (this.MuR != null) {
                aVar.e(5, this.MuR);
            }
            if (this.MuS != null) {
                aVar.e(6, this.MuS);
            }
            aVar.aM(7, this.MuT);
            AppMethodBeat.o(91538);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.MuQ != null) {
                bu += g.a.a.b.b.a.f(4, this.MuQ);
            }
            if (this.MuR != null) {
                bu += g.a.a.b.b.a.f(5, this.MuR);
            }
            if (this.MuS != null) {
                bu += g.a.a.b.b.a.f(6, this.MuS);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MuT);
            AppMethodBeat.o(91538);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dQx == null) {
                b bVar2 = new b("Not all required fields were included: wording");
                AppMethodBeat.o(91538);
                throw bVar2;
            }
            AppMethodBeat.o(91538);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cor cor = (cor) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cor.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91538);
                    return 0;
                case 2:
                    cor.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91538);
                    return 0;
                case 3:
                    cor.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91538);
                    return 0;
                case 4:
                    cor.MuQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91538);
                    return 0;
                case 5:
                    cor.MuR = aVar3.UbS.readString();
                    AppMethodBeat.o(91538);
                    return 0;
                case 6:
                    cor.MuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91538);
                    return 0;
                case 7:
                    cor.MuT = aVar3.UbS.zi();
                    AppMethodBeat.o(91538);
                    return 0;
                default:
                    AppMethodBeat.o(91538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91538);
            return -1;
        }
    }
}

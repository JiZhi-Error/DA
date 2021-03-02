package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eq extends a {
    public String IconUrl;
    public String UserName;
    public String jfi;
    public String xJt;
    public String xMq;
    public int xNR;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41847);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(41847);
                throw bVar;
            }
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.xMq != null) {
                aVar.e(2, this.xMq);
            }
            if (this.IconUrl != null) {
                aVar.e(3, this.IconUrl);
            }
            if (this.UserName != null) {
                aVar.e(4, this.UserName);
            }
            if (this.xut != null) {
                aVar.e(5, this.xut);
            }
            aVar.aM(6, this.xNR);
            if (this.xJt != null) {
                aVar.e(7, this.xJt);
            }
            AppMethodBeat.o(41847);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(2, this.xMq);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.IconUrl);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(4, this.UserName);
            }
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(5, this.xut);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.xNR);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(7, this.xJt);
            }
            AppMethodBeat.o(41847);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar2 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(41847);
                throw bVar2;
            }
            AppMethodBeat.o(41847);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eq eqVar = (eq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                case 2:
                    eqVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                case 3:
                    eqVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                case 4:
                    eqVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                case 5:
                    eqVar.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                case 6:
                    eqVar.xNR = aVar3.UbS.zi();
                    AppMethodBeat.o(41847);
                    return 0;
                case 7:
                    eqVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41847);
                    return 0;
                default:
                    AppMethodBeat.o(41847);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41847);
            return -1;
        }
    }
}

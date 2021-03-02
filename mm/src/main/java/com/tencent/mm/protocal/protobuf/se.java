package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class se extends a {
    public int KXC;
    public String KZQ;
    public String dNI;
    public String nickname;
    public String username;
    public int version;
    public String yPH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56244);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.yPH != null) {
                aVar.e(3, this.yPH);
            }
            if (this.nickname != null) {
                aVar.e(4, this.nickname);
            }
            aVar.aM(5, this.KXC);
            if (this.KZQ != null) {
                aVar.e(6, this.KZQ);
            }
            aVar.aM(7, this.version);
            AppMethodBeat.o(56244);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.yPH != null) {
                f2 += g.a.a.b.b.a.f(3, this.yPH);
            }
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(4, this.nickname);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KXC);
            if (this.KZQ != null) {
                bu += g.a.a.b.b.a.f(6, this.KZQ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.version);
            AppMethodBeat.o(56244);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(56244);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            se seVar = (se) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    seVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(56244);
                    return 0;
                case 2:
                    seVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(56244);
                    return 0;
                case 3:
                    seVar.yPH = aVar3.UbS.readString();
                    AppMethodBeat.o(56244);
                    return 0;
                case 4:
                    seVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(56244);
                    return 0;
                case 5:
                    seVar.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(56244);
                    return 0;
                case 6:
                    seVar.KZQ = aVar3.UbS.readString();
                    AppMethodBeat.o(56244);
                    return 0;
                case 7:
                    seVar.version = aVar3.UbS.zi();
                    AppMethodBeat.o(56244);
                    return 0;
                default:
                    AppMethodBeat.o(56244);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56244);
            return -1;
        }
    }
}

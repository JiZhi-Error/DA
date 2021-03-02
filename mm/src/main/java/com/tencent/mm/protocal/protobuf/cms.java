package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cms extends a {
    public int KXC;
    public String Mse;
    public String Msf;
    public LinkedList<String> Msg = new LinkedList<>();
    public String dNI;
    public String desc;
    public String nickname;
    public String qGB;
    public float score;

    public cms() {
        AppMethodBeat.i(227878);
        AppMethodBeat.o(227878);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(227879);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.qGB != null) {
                aVar.e(2, this.qGB);
            }
            if (this.Mse != null) {
                aVar.e(3, this.Mse);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            aVar.e(5, 1, this.Msg);
            aVar.E(6, this.score);
            if (this.Msf != null) {
                aVar.e(7, this.Msf);
            }
            aVar.aM(8, this.KXC);
            if (this.nickname != null) {
                aVar.e(9, this.nickname);
            }
            AppMethodBeat.o(227879);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.qGB != null) {
                f2 += g.a.a.b.b.a.f(2, this.qGB);
            }
            if (this.Mse != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mse);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.desc);
            }
            int c2 = f2 + g.a.a.a.c(5, 1, this.Msg) + g.a.a.b.b.a.fS(6) + 4;
            if (this.Msf != null) {
                c2 += g.a.a.b.b.a.f(7, this.Msf);
            }
            int bu = c2 + g.a.a.b.b.a.bu(8, this.KXC);
            if (this.nickname != null) {
                bu += g.a.a.b.b.a.f(9, this.nickname);
            }
            AppMethodBeat.o(227879);
            return bu;
        } else if (i2 == 2) {
            this.Msg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(227879);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cms cms = (cms) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cms.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                case 2:
                    cms.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                case 3:
                    cms.Mse = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                case 4:
                    cms.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                case 5:
                    cms.Msg.add(aVar3.UbS.readString());
                    AppMethodBeat.o(227879);
                    return 0;
                case 6:
                    cms.score = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(227879);
                    return 0;
                case 7:
                    cms.Msf = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                case 8:
                    cms.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(227879);
                    return 0;
                case 9:
                    cms.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(227879);
                    return 0;
                default:
                    AppMethodBeat.o(227879);
                    return -1;
            }
        } else {
            AppMethodBeat.o(227879);
            return -1;
        }
    }
}

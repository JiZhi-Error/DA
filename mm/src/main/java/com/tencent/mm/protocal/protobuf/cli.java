package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cli extends a {
    public String coverUrl;
    public String desc;
    public int duration;
    public int iAb = -1;
    public int iwd;
    public int iwe = 0;
    public int iwf;
    public int iwg;
    public String vid;
    public int videoHeight;
    public int videoWidth;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125740);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.iAb);
            aVar.aM(2, this.iwe);
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.aM(4, this.videoWidth);
            aVar.aM(5, this.videoHeight);
            aVar.aM(6, this.iwd);
            aVar.aM(7, this.duration);
            if (this.vid != null) {
                aVar.e(8, this.vid);
            }
            aVar.aM(9, this.iwg);
            if (this.coverUrl != null) {
                aVar.e(10, this.coverUrl);
            }
            aVar.aM(11, this.iwf);
            AppMethodBeat.o(125740);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.iAb) + 0 + g.a.a.b.b.a.bu(2, this.iwe);
            if (this.desc != null) {
                bu += g.a.a.b.b.a.f(3, this.desc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.videoWidth) + g.a.a.b.b.a.bu(5, this.videoHeight) + g.a.a.b.b.a.bu(6, this.iwd) + g.a.a.b.b.a.bu(7, this.duration);
            if (this.vid != null) {
                bu2 += g.a.a.b.b.a.f(8, this.vid);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.iwg);
            if (this.coverUrl != null) {
                bu3 += g.a.a.b.b.a.f(10, this.coverUrl);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.iwf);
            AppMethodBeat.o(125740);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125740);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cli cli = (cli) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cli.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 2:
                    cli.iwe = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 3:
                    cli.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(125740);
                    return 0;
                case 4:
                    cli.videoWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 5:
                    cli.videoHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 6:
                    cli.iwd = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 7:
                    cli.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 8:
                    cli.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(125740);
                    return 0;
                case 9:
                    cli.iwg = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                case 10:
                    cli.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(125740);
                    return 0;
                case 11:
                    cli.iwf = aVar3.UbS.zi();
                    AppMethodBeat.o(125740);
                    return 0;
                default:
                    AppMethodBeat.o(125740);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125740);
            return -1;
        }
    }
}

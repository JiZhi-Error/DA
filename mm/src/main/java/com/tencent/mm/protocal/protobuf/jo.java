package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class jo extends a {
    public String KOe;
    public String KOf;
    public String dHc;
    public String ehQ;
    public String ehR;
    public int height;
    public String iAg;
    public String iAh;
    public String iAo;
    public String title;
    public String url;
    public int videoDuration;
    public String videoUrl;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43083);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KOe != null) {
                aVar.e(1, this.KOe);
            }
            if (this.videoUrl != null) {
                aVar.e(2, this.videoUrl);
            }
            if (this.KOf != null) {
                aVar.e(3, this.KOf);
            }
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            if (this.iAo != null) {
                aVar.e(5, this.iAo);
            }
            aVar.aM(6, this.videoDuration);
            aVar.aM(7, this.width);
            aVar.aM(8, this.height);
            if (this.url != null) {
                aVar.e(9, this.url);
            }
            if (this.dHc != null) {
                aVar.e(10, this.dHc);
            }
            if (this.iAg != null) {
                aVar.e(11, this.iAg);
            }
            if (this.iAh != null) {
                aVar.e(12, this.iAh);
            }
            if (this.ehR != null) {
                aVar.e(13, this.ehR);
            }
            if (this.ehQ != null) {
                aVar.e(14, this.ehQ);
            }
            AppMethodBeat.o(43083);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KOe != null ? g.a.a.b.b.a.f(1, this.KOe) + 0 : 0;
            if (this.videoUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.videoUrl);
            }
            if (this.KOf != null) {
                f2 += g.a.a.b.b.a.f(3, this.KOf);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(4, this.title);
            }
            if (this.iAo != null) {
                f2 += g.a.a.b.b.a.f(5, this.iAo);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.videoDuration) + g.a.a.b.b.a.bu(7, this.width) + g.a.a.b.b.a.bu(8, this.height);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(9, this.url);
            }
            if (this.dHc != null) {
                bu += g.a.a.b.b.a.f(10, this.dHc);
            }
            if (this.iAg != null) {
                bu += g.a.a.b.b.a.f(11, this.iAg);
            }
            if (this.iAh != null) {
                bu += g.a.a.b.b.a.f(12, this.iAh);
            }
            if (this.ehR != null) {
                bu += g.a.a.b.b.a.f(13, this.ehR);
            }
            if (this.ehQ != null) {
                bu += g.a.a.b.b.a.f(14, this.ehQ);
            }
            AppMethodBeat.o(43083);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43083);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jo joVar = (jo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    joVar.KOe = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 2:
                    joVar.videoUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 3:
                    joVar.KOf = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 4:
                    joVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 5:
                    joVar.iAo = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 6:
                    joVar.videoDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(43083);
                    return 0;
                case 7:
                    joVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(43083);
                    return 0;
                case 8:
                    joVar.height = aVar3.UbS.zi();
                    AppMethodBeat.o(43083);
                    return 0;
                case 9:
                    joVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 10:
                    joVar.dHc = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 11:
                    joVar.iAg = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 12:
                    joVar.iAh = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 13:
                    joVar.ehR = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                case 14:
                    joVar.ehQ = aVar3.UbS.readString();
                    AppMethodBeat.o(43083);
                    return 0;
                default:
                    AppMethodBeat.o(43083);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43083);
            return -1;
        }
    }
}

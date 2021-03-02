package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azg extends a {
    public int LBx;
    public int LBy;
    public int LBz;
    public int LCj;
    public int LCk;
    public app LCl;
    public int LIY;
    public int LIZ;
    public int LJa;
    public int LJb;
    public int LJc;
    public int LJd;
    public String country;
    public String coverImgUrl;
    public int fuA;
    public String fuJ;
    public String fuK;
    public String iAR;
    public String nickname;
    public String signature;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169015);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.nickname != null) {
                aVar.e(1, this.nickname);
            }
            if (this.signature != null) {
                aVar.e(2, this.signature);
            }
            if (this.coverImgUrl != null) {
                aVar.e(3, this.coverImgUrl);
            }
            if (this.iAR != null) {
                aVar.e(4, this.iAR);
            }
            if (this.country != null) {
                aVar.e(5, this.country);
            }
            if (this.fuJ != null) {
                aVar.e(6, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(7, this.fuK);
            }
            aVar.aM(8, this.fuA);
            aVar.aM(9, this.LBx);
            aVar.aM(10, this.LBy);
            aVar.aM(11, this.LBz);
            aVar.aM(12, this.LCj);
            aVar.aM(13, this.LCk);
            aVar.aM(14, this.LIY);
            aVar.aM(15, this.LIZ);
            aVar.aM(16, this.LJa);
            aVar.aM(17, this.LJb);
            if (this.LCl != null) {
                aVar.ni(18, this.LCl.computeSize());
                this.LCl.writeFields(aVar);
            }
            aVar.aM(19, this.LJc);
            aVar.aM(20, this.LJd);
            AppMethodBeat.o(169015);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.nickname != null ? g.a.a.b.b.a.f(1, this.nickname) + 0 : 0;
            if (this.signature != null) {
                f2 += g.a.a.b.b.a.f(2, this.signature);
            }
            if (this.coverImgUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.coverImgUrl);
            }
            if (this.iAR != null) {
                f2 += g.a.a.b.b.a.f(4, this.iAR);
            }
            if (this.country != null) {
                f2 += g.a.a.b.b.a.f(5, this.country);
            }
            if (this.fuJ != null) {
                f2 += g.a.a.b.b.a.f(6, this.fuJ);
            }
            if (this.fuK != null) {
                f2 += g.a.a.b.b.a.f(7, this.fuK);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.fuA) + g.a.a.b.b.a.bu(9, this.LBx) + g.a.a.b.b.a.bu(10, this.LBy) + g.a.a.b.b.a.bu(11, this.LBz) + g.a.a.b.b.a.bu(12, this.LCj) + g.a.a.b.b.a.bu(13, this.LCk) + g.a.a.b.b.a.bu(14, this.LIY) + g.a.a.b.b.a.bu(15, this.LIZ) + g.a.a.b.b.a.bu(16, this.LJa) + g.a.a.b.b.a.bu(17, this.LJb);
            if (this.LCl != null) {
                bu += g.a.a.a.nh(18, this.LCl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(19, this.LJc) + g.a.a.b.b.a.bu(20, this.LJd);
            AppMethodBeat.o(169015);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169015);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azg azg = (azg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azg.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 2:
                    azg.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 3:
                    azg.coverImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 4:
                    azg.iAR = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 5:
                    azg.country = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 6:
                    azg.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 7:
                    azg.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(169015);
                    return 0;
                case 8:
                    azg.fuA = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 9:
                    azg.LBx = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 10:
                    azg.LBy = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 11:
                    azg.LBz = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 12:
                    azg.LCj = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 13:
                    azg.LCk = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 14:
                    azg.LIY = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 15:
                    azg.LIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 16:
                    azg.LJa = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 17:
                    azg.LJb = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        app app = new app();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = app.populateBuilderWithField(aVar4, app, a.getNextFieldNumber(aVar4))) {
                        }
                        azg.LCl = app;
                    }
                    AppMethodBeat.o(169015);
                    return 0;
                case 19:
                    azg.LJc = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                case 20:
                    azg.LJd = aVar3.UbS.zi();
                    AppMethodBeat.o(169015);
                    return 0;
                default:
                    AppMethodBeat.o(169015);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169015);
            return -1;
        }
    }
}

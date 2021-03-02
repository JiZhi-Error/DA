package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dev extends a {
    public String LZy;
    public int MJO;
    public LinkedList<cfw> MJP = new LinkedList<>();
    public int MJQ;
    public String MJR;
    public String MJS;
    public int MJT;
    public String MJU;
    public int MJV;
    public LinkedList<ahl> MJW = new LinkedList<>();
    public String Name;
    public String PriceType;
    public int Scene;
    public String ThumbUrl;
    public int oTz;
    public int oUv;

    public dev() {
        AppMethodBeat.i(91633);
        AppMethodBeat.o(91633);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91634);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MJO);
            aVar.e(2, 8, this.MJP);
            aVar.aM(3, this.oTz);
            aVar.aM(4, this.MJQ);
            if (this.PriceType != null) {
                aVar.e(5, this.PriceType);
            }
            if (this.LZy != null) {
                aVar.e(6, this.LZy);
            }
            if (this.MJR != null) {
                aVar.e(7, this.MJR);
            }
            if (this.MJS != null) {
                aVar.e(8, this.MJS);
            }
            aVar.aM(9, this.oUv);
            if (this.Name != null) {
                aVar.e(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                aVar.e(11, this.ThumbUrl);
            }
            aVar.aM(12, this.MJT);
            aVar.aM(13, this.Scene);
            if (this.MJU != null) {
                aVar.e(14, this.MJU);
            }
            aVar.aM(15, this.MJV);
            aVar.e(16, 8, this.MJW);
            AppMethodBeat.o(91634);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MJO) + 0 + g.a.a.a.c(2, 8, this.MJP) + g.a.a.b.b.a.bu(3, this.oTz) + g.a.a.b.b.a.bu(4, this.MJQ);
            if (this.PriceType != null) {
                bu += g.a.a.b.b.a.f(5, this.PriceType);
            }
            if (this.LZy != null) {
                bu += g.a.a.b.b.a.f(6, this.LZy);
            }
            if (this.MJR != null) {
                bu += g.a.a.b.b.a.f(7, this.MJR);
            }
            if (this.MJS != null) {
                bu += g.a.a.b.b.a.f(8, this.MJS);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.oUv);
            if (this.Name != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                bu2 += g.a.a.b.b.a.f(11, this.ThumbUrl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.MJT) + g.a.a.b.b.a.bu(13, this.Scene);
            if (this.MJU != null) {
                bu3 += g.a.a.b.b.a.f(14, this.MJU);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.MJV) + g.a.a.a.c(16, 8, this.MJW);
            AppMethodBeat.o(91634);
            return bu4;
        } else if (i2 == 2) {
            this.MJP.clear();
            this.MJW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dev dev = (dev) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dev.MJO = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfw cfw = new cfw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfw.populateBuilderWithField(aVar4, cfw, a.getNextFieldNumber(aVar4))) {
                        }
                        dev.MJP.add(cfw);
                    }
                    AppMethodBeat.o(91634);
                    return 0;
                case 3:
                    dev.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 4:
                    dev.MJQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 5:
                    dev.PriceType = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 6:
                    dev.LZy = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 7:
                    dev.MJR = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 8:
                    dev.MJS = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 9:
                    dev.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 10:
                    dev.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 11:
                    dev.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 12:
                    dev.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 13:
                    dev.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 14:
                    dev.MJU = aVar3.UbS.readString();
                    AppMethodBeat.o(91634);
                    return 0;
                case 15:
                    dev.MJV = aVar3.UbS.zi();
                    AppMethodBeat.o(91634);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahl ahl = new ahl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahl.populateBuilderWithField(aVar5, ahl, a.getNextFieldNumber(aVar5))) {
                        }
                        dev.MJW.add(ahl);
                    }
                    AppMethodBeat.o(91634);
                    return 0;
                default:
                    AppMethodBeat.o(91634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91634);
            return -1;
        }
    }
}

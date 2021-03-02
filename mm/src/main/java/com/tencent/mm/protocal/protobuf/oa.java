package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class oa extends a {
    public LinkedList<ob> KTC = new LinkedList<>();
    public int KTD;
    public String KTm;
    public int KTn;
    public String KTr;
    public String KTu;
    public String gTH;
    public String pWm;
    public int ver;

    public oa() {
        AppMethodBeat.i(212231);
        AppMethodBeat.o(212231);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124425);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTu != null) {
                aVar.e(1, this.KTu);
            }
            if (this.pWm != null) {
                aVar.e(2, this.pWm);
            }
            aVar.aM(3, this.ver);
            if (this.KTm != null) {
                aVar.e(4, this.KTm);
            }
            if (this.gTH != null) {
                aVar.e(5, this.gTH);
            }
            aVar.aM(6, this.KTn);
            if (this.KTr != null) {
                aVar.e(7, this.KTr);
            }
            aVar.e(8, 8, this.KTC);
            aVar.aM(9, this.KTD);
            AppMethodBeat.o(124425);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KTu != null ? g.a.a.b.b.a.f(1, this.KTu) + 0 : 0;
            if (this.pWm != null) {
                f2 += g.a.a.b.b.a.f(2, this.pWm);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.ver);
            if (this.KTm != null) {
                bu += g.a.a.b.b.a.f(4, this.KTm);
            }
            if (this.gTH != null) {
                bu += g.a.a.b.b.a.f(5, this.gTH);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KTn);
            if (this.KTr != null) {
                bu2 += g.a.a.b.b.a.f(7, this.KTr);
            }
            int c2 = bu2 + g.a.a.a.c(8, 8, this.KTC) + g.a.a.b.b.a.bu(9, this.KTD);
            AppMethodBeat.o(124425);
            return c2;
        } else if (i2 == 2) {
            this.KTC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124425);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            oa oaVar = (oa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oaVar.KTu = aVar3.UbS.readString();
                    AppMethodBeat.o(124425);
                    return 0;
                case 2:
                    oaVar.pWm = aVar3.UbS.readString();
                    AppMethodBeat.o(124425);
                    return 0;
                case 3:
                    oaVar.ver = aVar3.UbS.zi();
                    AppMethodBeat.o(124425);
                    return 0;
                case 4:
                    oaVar.KTm = aVar3.UbS.readString();
                    AppMethodBeat.o(124425);
                    return 0;
                case 5:
                    oaVar.gTH = aVar3.UbS.readString();
                    AppMethodBeat.o(124425);
                    return 0;
                case 6:
                    oaVar.KTn = aVar3.UbS.zi();
                    AppMethodBeat.o(124425);
                    return 0;
                case 7:
                    oaVar.KTr = aVar3.UbS.readString();
                    AppMethodBeat.o(124425);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ob obVar = new ob();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = obVar.populateBuilderWithField(aVar4, obVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oaVar.KTC.add(obVar);
                    }
                    AppMethodBeat.o(124425);
                    return 0;
                case 9:
                    oaVar.KTD = aVar3.UbS.zi();
                    AppMethodBeat.o(124425);
                    return 0;
                default:
                    AppMethodBeat.o(124425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124425);
            return -1;
        }
    }
}

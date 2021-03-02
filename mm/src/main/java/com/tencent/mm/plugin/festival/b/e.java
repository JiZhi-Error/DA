package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class e extends a {
    public int UAC;
    public String UAD;
    public String UAE;
    public String UAF;
    public int UAG;
    public int UAH;
    public String UAI;
    public String UAJ;
    public int UAK;
    public int UAL;
    public String UAM;
    public String UAN;
    public String UAO;
    public int UAP;
    public int height;
    public String object_nonce_id;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261970);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(3, this.UAC);
            aVar.aM(4, this.width);
            aVar.aM(5, this.height);
            if (this.UAD != null) {
                aVar.e(6, this.UAD);
            }
            if (this.UAE != null) {
                aVar.e(7, this.UAE);
            }
            if (this.UAF != null) {
                aVar.e(8, this.UAF);
            }
            if (this.object_nonce_id != null) {
                aVar.e(9, this.object_nonce_id);
            }
            aVar.aM(10, this.UAG);
            aVar.aM(11, this.UAH);
            if (this.UAI != null) {
                aVar.e(12, this.UAI);
            }
            if (this.UAJ != null) {
                aVar.e(13, this.UAJ);
            }
            aVar.aM(14, this.UAK);
            aVar.aM(15, this.UAL);
            if (this.UAM != null) {
                aVar.e(16, this.UAM);
            }
            if (this.UAN != null) {
                aVar.e(17, this.UAN);
            }
            if (this.UAO != null) {
                aVar.e(18, this.UAO);
            }
            aVar.aM(19, this.UAP);
            AppMethodBeat.o(261970);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(3, this.UAC) + 0 + g.a.a.b.b.a.bu(4, this.width) + g.a.a.b.b.a.bu(5, this.height);
            if (this.UAD != null) {
                bu += g.a.a.b.b.a.f(6, this.UAD);
            }
            if (this.UAE != null) {
                bu += g.a.a.b.b.a.f(7, this.UAE);
            }
            if (this.UAF != null) {
                bu += g.a.a.b.b.a.f(8, this.UAF);
            }
            if (this.object_nonce_id != null) {
                bu += g.a.a.b.b.a.f(9, this.object_nonce_id);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.UAG) + g.a.a.b.b.a.bu(11, this.UAH);
            if (this.UAI != null) {
                bu2 += g.a.a.b.b.a.f(12, this.UAI);
            }
            if (this.UAJ != null) {
                bu2 += g.a.a.b.b.a.f(13, this.UAJ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.UAK) + g.a.a.b.b.a.bu(15, this.UAL);
            if (this.UAM != null) {
                bu3 += g.a.a.b.b.a.f(16, this.UAM);
            }
            if (this.UAN != null) {
                bu3 += g.a.a.b.b.a.f(17, this.UAN);
            }
            if (this.UAO != null) {
                bu3 += g.a.a.b.b.a.f(18, this.UAO);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(19, this.UAP);
            AppMethodBeat.o(261970);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261970);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 3:
                    eVar.UAC = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 4:
                    eVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 5:
                    eVar.height = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 6:
                    eVar.UAD = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 7:
                    eVar.UAE = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 8:
                    eVar.UAF = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 9:
                    eVar.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 10:
                    eVar.UAG = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 11:
                    eVar.UAH = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 12:
                    eVar.UAI = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 13:
                    eVar.UAJ = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 14:
                    eVar.UAK = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 15:
                    eVar.UAL = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                case 16:
                    eVar.UAM = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 17:
                    eVar.UAN = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 18:
                    eVar.UAO = aVar3.UbS.readString();
                    AppMethodBeat.o(261970);
                    return 0;
                case 19:
                    eVar.UAP = aVar3.UbS.zi();
                    AppMethodBeat.o(261970);
                    return 0;
                default:
                    AppMethodBeat.o(261970);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261970);
            return -1;
        }
    }
}

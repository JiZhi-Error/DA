package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class edt extends a {
    public String Id;
    public int Mcw;
    public int MsA;
    public int MsK;
    public long MsL;
    public String MsM;
    public int MsN;
    public String MsO;
    public String MsP;
    public int MsQ;
    public String MsR;
    public String MsS;
    public String Msz;
    public float Ned;
    public String Url;
    public int ecf;
    public String md5;
    public int oUv;
    public int subType;
    public String taskId;
    public String viB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118454);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            aVar.aM(2, this.oUv);
            if (this.Url != null) {
                aVar.e(3, this.Url);
            }
            aVar.aM(4, this.Mcw);
            if (this.Msz != null) {
                aVar.e(5, this.Msz);
            }
            aVar.aM(6, this.MsA);
            aVar.aM(7, this.subType);
            if (this.md5 != null) {
                aVar.e(8, this.md5);
            }
            if (this.MsS != null) {
                aVar.e(9, this.MsS);
            }
            aVar.aM(10, this.ecf);
            aVar.aM(11, this.MsK);
            aVar.bb(12, this.MsL);
            if (this.MsM != null) {
                aVar.e(13, this.MsM);
            }
            if (this.viB != null) {
                aVar.e(14, this.viB);
            }
            aVar.aM(15, this.MsN);
            if (this.MsO != null) {
                aVar.e(16, this.MsO);
            }
            if (this.MsP != null) {
                aVar.e(17, this.MsP);
            }
            aVar.aM(18, this.MsQ);
            if (this.MsR != null) {
                aVar.e(19, this.MsR);
            }
            aVar.E(20, this.Ned);
            if (this.taskId != null) {
                aVar.e(21, this.taskId);
            }
            AppMethodBeat.o(118454);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(3, this.Url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Mcw);
            if (this.Msz != null) {
                bu += g.a.a.b.b.a.f(5, this.Msz);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.MsA) + g.a.a.b.b.a.bu(7, this.subType);
            if (this.md5 != null) {
                bu2 += g.a.a.b.b.a.f(8, this.md5);
            }
            if (this.MsS != null) {
                bu2 += g.a.a.b.b.a.f(9, this.MsS);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.ecf) + g.a.a.b.b.a.bu(11, this.MsK) + g.a.a.b.b.a.r(12, this.MsL);
            if (this.MsM != null) {
                bu3 += g.a.a.b.b.a.f(13, this.MsM);
            }
            if (this.viB != null) {
                bu3 += g.a.a.b.b.a.f(14, this.viB);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.MsN);
            if (this.MsO != null) {
                bu4 += g.a.a.b.b.a.f(16, this.MsO);
            }
            if (this.MsP != null) {
                bu4 += g.a.a.b.b.a.f(17, this.MsP);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(18, this.MsQ);
            if (this.MsR != null) {
                bu5 += g.a.a.b.b.a.f(19, this.MsR);
            }
            int fS = bu5 + g.a.a.b.b.a.fS(20) + 4;
            if (this.taskId != null) {
                fS += g.a.a.b.b.a.f(21, this.taskId);
            }
            AppMethodBeat.o(118454);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118454);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edt edt = (edt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edt.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 2:
                    edt.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 3:
                    edt.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 4:
                    edt.Mcw = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 5:
                    edt.Msz = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 6:
                    edt.MsA = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 7:
                    edt.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 8:
                    edt.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 9:
                    edt.MsS = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 10:
                    edt.ecf = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 11:
                    edt.MsK = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 12:
                    edt.MsL = aVar3.UbS.zl();
                    AppMethodBeat.o(118454);
                    return 0;
                case 13:
                    edt.MsM = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 14:
                    edt.viB = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 15:
                    edt.MsN = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 16:
                    edt.MsO = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 17:
                    edt.MsP = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 18:
                    edt.MsQ = aVar3.UbS.zi();
                    AppMethodBeat.o(118454);
                    return 0;
                case 19:
                    edt.MsR = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                case 20:
                    edt.Ned = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(118454);
                    return 0;
                case 21:
                    edt.taskId = aVar3.UbS.readString();
                    AppMethodBeat.o(118454);
                    return 0;
                default:
                    AppMethodBeat.o(118454);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118454);
            return -1;
        }
    }
}

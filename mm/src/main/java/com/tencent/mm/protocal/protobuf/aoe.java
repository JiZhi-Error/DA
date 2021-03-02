package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aoe extends a {
    public int LAa;
    public String LAb;
    public int LAc;
    public String LAd;
    public long LAe;
    public String LAf;
    public String LAg;
    public long LAh;
    public boolean LzL;
    public long LzM;
    public String LzN;
    public String LzO;
    public long LzP;
    public boolean LzQ;
    public String LzR;
    public String LzS;
    public String LzT;
    public int LzU;
    public String LzV;
    public String LzW;
    public String LzX;
    public String LzY;
    public String LzZ;
    public String appId;
    public String filePath;
    public String gCr;
    public boolean lwF;
    public String processName;
    public int qoX;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208702);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.LzL);
            if (this.filePath != null) {
                aVar.e(2, this.filePath);
            }
            if (this.gCr != null) {
                aVar.e(3, this.gCr);
            }
            if (this.appId != null) {
                aVar.e(4, this.appId);
            }
            if (this.processName != null) {
                aVar.e(5, this.processName);
            }
            aVar.aM(6, this.qoX);
            aVar.cc(7, this.lwF);
            aVar.bb(8, this.LzM);
            if (this.LzN != null) {
                aVar.e(9, this.LzN);
            }
            if (this.LzO != null) {
                aVar.e(10, this.LzO);
            }
            aVar.bb(11, this.LzP);
            aVar.cc(12, this.LzQ);
            aVar.aM(13, this.scene);
            if (this.LzR != null) {
                aVar.e(14, this.LzR);
            }
            if (this.LzS != null) {
                aVar.e(15, this.LzS);
            }
            if (this.LzT != null) {
                aVar.e(16, this.LzT);
            }
            aVar.aM(17, this.LzU);
            if (this.LzV != null) {
                aVar.e(18, this.LzV);
            }
            if (this.LzW != null) {
                aVar.e(19, this.LzW);
            }
            if (this.LzX != null) {
                aVar.e(20, this.LzX);
            }
            if (this.LzY != null) {
                aVar.e(21, this.LzY);
            }
            if (this.LzZ != null) {
                aVar.e(22, this.LzZ);
            }
            aVar.aM(23, this.LAa);
            if (this.LAb != null) {
                aVar.e(24, this.LAb);
            }
            aVar.aM(25, this.LAc);
            if (this.LAd != null) {
                aVar.e(26, this.LAd);
            }
            aVar.bb(27, this.LAe);
            if (this.LAf != null) {
                aVar.e(28, this.LAf);
            }
            if (this.LAg != null) {
                aVar.e(29, this.LAg);
            }
            aVar.bb(30, this.LAh);
            AppMethodBeat.o(208702);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.filePath != null) {
                fS += g.a.a.b.b.a.f(2, this.filePath);
            }
            if (this.gCr != null) {
                fS += g.a.a.b.b.a.f(3, this.gCr);
            }
            if (this.appId != null) {
                fS += g.a.a.b.b.a.f(4, this.appId);
            }
            if (this.processName != null) {
                fS += g.a.a.b.b.a.f(5, this.processName);
            }
            int bu = fS + g.a.a.b.b.a.bu(6, this.qoX) + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.r(8, this.LzM);
            if (this.LzN != null) {
                bu += g.a.a.b.b.a.f(9, this.LzN);
            }
            if (this.LzO != null) {
                bu += g.a.a.b.b.a.f(10, this.LzO);
            }
            int r = bu + g.a.a.b.b.a.r(11, this.LzP) + g.a.a.b.b.a.fS(12) + 1 + g.a.a.b.b.a.bu(13, this.scene);
            if (this.LzR != null) {
                r += g.a.a.b.b.a.f(14, this.LzR);
            }
            if (this.LzS != null) {
                r += g.a.a.b.b.a.f(15, this.LzS);
            }
            if (this.LzT != null) {
                r += g.a.a.b.b.a.f(16, this.LzT);
            }
            int bu2 = r + g.a.a.b.b.a.bu(17, this.LzU);
            if (this.LzV != null) {
                bu2 += g.a.a.b.b.a.f(18, this.LzV);
            }
            if (this.LzW != null) {
                bu2 += g.a.a.b.b.a.f(19, this.LzW);
            }
            if (this.LzX != null) {
                bu2 += g.a.a.b.b.a.f(20, this.LzX);
            }
            if (this.LzY != null) {
                bu2 += g.a.a.b.b.a.f(21, this.LzY);
            }
            if (this.LzZ != null) {
                bu2 += g.a.a.b.b.a.f(22, this.LzZ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(23, this.LAa);
            if (this.LAb != null) {
                bu3 += g.a.a.b.b.a.f(24, this.LAb);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(25, this.LAc);
            if (this.LAd != null) {
                bu4 += g.a.a.b.b.a.f(26, this.LAd);
            }
            int r2 = bu4 + g.a.a.b.b.a.r(27, this.LAe);
            if (this.LAf != null) {
                r2 += g.a.a.b.b.a.f(28, this.LAf);
            }
            if (this.LAg != null) {
                r2 += g.a.a.b.b.a.f(29, this.LAg);
            }
            int r3 = r2 + g.a.a.b.b.a.r(30, this.LAh);
            AppMethodBeat.o(208702);
            return r3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208702);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aoe aoe = (aoe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoe.LzL = aVar3.UbS.yZ();
                    AppMethodBeat.o(208702);
                    return 0;
                case 2:
                    aoe.filePath = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 3:
                    aoe.gCr = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 4:
                    aoe.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 5:
                    aoe.processName = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 6:
                    aoe.qoX = aVar3.UbS.zi();
                    AppMethodBeat.o(208702);
                    return 0;
                case 7:
                    aoe.lwF = aVar3.UbS.yZ();
                    AppMethodBeat.o(208702);
                    return 0;
                case 8:
                    aoe.LzM = aVar3.UbS.zl();
                    AppMethodBeat.o(208702);
                    return 0;
                case 9:
                    aoe.LzN = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 10:
                    aoe.LzO = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 11:
                    aoe.LzP = aVar3.UbS.zl();
                    AppMethodBeat.o(208702);
                    return 0;
                case 12:
                    aoe.LzQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(208702);
                    return 0;
                case 13:
                    aoe.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(208702);
                    return 0;
                case 14:
                    aoe.LzR = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 15:
                    aoe.LzS = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 16:
                    aoe.LzT = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 17:
                    aoe.LzU = aVar3.UbS.zi();
                    AppMethodBeat.o(208702);
                    return 0;
                case 18:
                    aoe.LzV = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 19:
                    aoe.LzW = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 20:
                    aoe.LzX = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 21:
                    aoe.LzY = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 22:
                    aoe.LzZ = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 23:
                    aoe.LAa = aVar3.UbS.zi();
                    AppMethodBeat.o(208702);
                    return 0;
                case 24:
                    aoe.LAb = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 25:
                    aoe.LAc = aVar3.UbS.zi();
                    AppMethodBeat.o(208702);
                    return 0;
                case 26:
                    aoe.LAd = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 27:
                    aoe.LAe = aVar3.UbS.zl();
                    AppMethodBeat.o(208702);
                    return 0;
                case 28:
                    aoe.LAf = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 29:
                    aoe.LAg = aVar3.UbS.readString();
                    AppMethodBeat.o(208702);
                    return 0;
                case 30:
                    aoe.LAh = aVar3.UbS.zl();
                    AppMethodBeat.o(208702);
                    return 0;
                default:
                    AppMethodBeat.o(208702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208702);
            return -1;
        }
    }
}

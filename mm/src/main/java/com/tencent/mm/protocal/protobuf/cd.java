package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cd extends dop {
    public String Dsg;
    public String DvI;
    public String KFD;
    public String KFE;
    public String KFF;
    public String KFG;
    public String KFH;
    public String KFI;
    public String KFL;
    public long KFM;
    public int KFO;
    public String KFQ;
    public int KFR;
    public b KFS;
    public b KFT;
    public int KFW;
    public int KFX;
    public int KGj;
    public cc KGk;
    public cf KGl;
    public int KGm;
    public long KGn;
    public long KGo;
    public float KGp;
    public float KGq;
    public float KGr;
    public int KGs;
    public long KGt;
    public long KGu;
    public int KGv;
    public String bssid;
    public String imei;
    public int scene;
    public int source;
    public String ssid;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125699);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.DvI != null) {
                aVar.e(2, this.DvI);
            }
            aVar.aM(3, this.scene);
            aVar.aM(4, this.type);
            aVar.aM(5, this.KGj);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.bb(8, this.KFM);
            if (this.KGk != null) {
                aVar.ni(9, this.KGk.computeSize());
                this.KGk.writeFields(aVar);
            }
            if (this.KGl != null) {
                aVar.ni(10, this.KGl.computeSize());
                this.KGl.writeFields(aVar);
            }
            aVar.aM(11, this.KFO);
            if (this.KFL != null) {
                aVar.e(12, this.KFL);
            }
            aVar.aM(13, this.source);
            if (this.KFQ != null) {
                aVar.e(14, this.KFQ);
            }
            aVar.aM(15, this.KGm);
            aVar.bb(16, this.KGn);
            aVar.bb(17, this.KGo);
            aVar.aM(18, this.KFR);
            if (this.KFS != null) {
                aVar.c(19, this.KFS);
            }
            if (this.KFT != null) {
                aVar.c(20, this.KFT);
            }
            if (this.Dsg != null) {
                aVar.e(21, this.Dsg);
            }
            if (this.KFH != null) {
                aVar.e(22, this.KFH);
            }
            if (this.KFI != null) {
                aVar.e(23, this.KFI);
            }
            aVar.E(24, this.KGp);
            aVar.E(25, this.KGq);
            aVar.E(26, this.KGr);
            aVar.aM(27, this.KGs);
            aVar.bb(28, this.KGt);
            aVar.bb(29, this.KGu);
            aVar.aM(30, this.KFW);
            aVar.aM(31, this.KFX);
            aVar.aM(32, this.KGv);
            if (this.imei != null) {
                aVar.e(33, this.imei);
            }
            if (this.KFD != null) {
                aVar.e(34, this.KFD);
            }
            if (this.KFE != null) {
                aVar.e(35, this.KFE);
            }
            if (this.KFF != null) {
                aVar.e(36, this.KFF);
            }
            if (this.KFG != null) {
                aVar.e(37, this.KFG);
            }
            AppMethodBeat.o(125699);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.DvI != null) {
                nh += g.a.a.b.b.a.f(2, this.DvI);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.type) + g.a.a.b.b.a.bu(5, this.KGj);
            if (this.ssid != null) {
                bu += g.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                bu += g.a.a.b.b.a.f(7, this.bssid);
            }
            int r = bu + g.a.a.b.b.a.r(8, this.KFM);
            if (this.KGk != null) {
                r += g.a.a.a.nh(9, this.KGk.computeSize());
            }
            if (this.KGl != null) {
                r += g.a.a.a.nh(10, this.KGl.computeSize());
            }
            int bu2 = r + g.a.a.b.b.a.bu(11, this.KFO);
            if (this.KFL != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KFL);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.source);
            if (this.KFQ != null) {
                bu3 += g.a.a.b.b.a.f(14, this.KFQ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.KGm) + g.a.a.b.b.a.r(16, this.KGn) + g.a.a.b.b.a.r(17, this.KGo) + g.a.a.b.b.a.bu(18, this.KFR);
            if (this.KFS != null) {
                bu4 += g.a.a.b.b.a.b(19, this.KFS);
            }
            if (this.KFT != null) {
                bu4 += g.a.a.b.b.a.b(20, this.KFT);
            }
            if (this.Dsg != null) {
                bu4 += g.a.a.b.b.a.f(21, this.Dsg);
            }
            if (this.KFH != null) {
                bu4 += g.a.a.b.b.a.f(22, this.KFH);
            }
            if (this.KFI != null) {
                bu4 += g.a.a.b.b.a.f(23, this.KFI);
            }
            int fS = bu4 + g.a.a.b.b.a.fS(24) + 4 + g.a.a.b.b.a.fS(25) + 4 + g.a.a.b.b.a.fS(26) + 4 + g.a.a.b.b.a.bu(27, this.KGs) + g.a.a.b.b.a.r(28, this.KGt) + g.a.a.b.b.a.r(29, this.KGu) + g.a.a.b.b.a.bu(30, this.KFW) + g.a.a.b.b.a.bu(31, this.KFX) + g.a.a.b.b.a.bu(32, this.KGv);
            if (this.imei != null) {
                fS += g.a.a.b.b.a.f(33, this.imei);
            }
            if (this.KFD != null) {
                fS += g.a.a.b.b.a.f(34, this.KFD);
            }
            if (this.KFE != null) {
                fS += g.a.a.b.b.a.f(35, this.KFE);
            }
            if (this.KFF != null) {
                fS += g.a.a.b.b.a.f(36, this.KFF);
            }
            if (this.KFG != null) {
                fS += g.a.a.b.b.a.f(37, this.KFG);
            }
            AppMethodBeat.o(125699);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125699);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        cdVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125699);
                    return 0;
                case 2:
                    cdVar.DvI = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 3:
                    cdVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 4:
                    cdVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 5:
                    cdVar.KGj = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 6:
                    cdVar.ssid = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 7:
                    cdVar.bssid = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 8:
                    cdVar.KFM = aVar3.UbS.zl();
                    AppMethodBeat.o(125699);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cc ccVar = new cc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccVar.populateBuilderWithField(aVar5, ccVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        cdVar.KGk = ccVar;
                    }
                    AppMethodBeat.o(125699);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cf cfVar = new cf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cfVar.populateBuilderWithField(aVar6, cfVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        cdVar.KGl = cfVar;
                    }
                    AppMethodBeat.o(125699);
                    return 0;
                case 11:
                    cdVar.KFO = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 12:
                    cdVar.KFL = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 13:
                    cdVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 14:
                    cdVar.KFQ = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 15:
                    cdVar.KGm = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 16:
                    cdVar.KGn = aVar3.UbS.zl();
                    AppMethodBeat.o(125699);
                    return 0;
                case 17:
                    cdVar.KGo = aVar3.UbS.zl();
                    AppMethodBeat.o(125699);
                    return 0;
                case 18:
                    cdVar.KFR = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 19:
                    cdVar.KFS = aVar3.UbS.hPo();
                    AppMethodBeat.o(125699);
                    return 0;
                case 20:
                    cdVar.KFT = aVar3.UbS.hPo();
                    AppMethodBeat.o(125699);
                    return 0;
                case 21:
                    cdVar.Dsg = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 22:
                    cdVar.KFH = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 23:
                    cdVar.KFI = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 24:
                    cdVar.KGp = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125699);
                    return 0;
                case 25:
                    cdVar.KGq = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125699);
                    return 0;
                case 26:
                    cdVar.KGr = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125699);
                    return 0;
                case 27:
                    cdVar.KGs = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 28:
                    cdVar.KGt = aVar3.UbS.zl();
                    AppMethodBeat.o(125699);
                    return 0;
                case 29:
                    cdVar.KGu = aVar3.UbS.zl();
                    AppMethodBeat.o(125699);
                    return 0;
                case 30:
                    cdVar.KFW = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 31:
                    cdVar.KFX = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 32:
                    cdVar.KGv = aVar3.UbS.zi();
                    AppMethodBeat.o(125699);
                    return 0;
                case 33:
                    cdVar.imei = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 34:
                    cdVar.KFD = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 35:
                    cdVar.KFE = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 36:
                    cdVar.KFF = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                case 37:
                    cdVar.KFG = aVar3.UbS.readString();
                    AppMethodBeat.o(125699);
                    return 0;
                default:
                    AppMethodBeat.o(125699);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125699);
            return -1;
        }
    }
}

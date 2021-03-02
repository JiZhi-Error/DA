package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bv extends dop {
    public String Dsg;
    public String DvI;
    public String KFD;
    public String KFE;
    public String KFF;
    public String KFG;
    public String KFH;
    public String KFI;
    public int KFK;
    public String KFL;
    public long KFM;
    public ck KFN;
    public int KFO;
    public int KFP;
    public String KFQ;
    public int KFR;
    public b KFS;
    public b KFT;
    public long KFU;
    public int KFV;
    public int KFW;
    public int KFX;
    public String bssid;
    public String imei;
    public int scene;
    public int source;
    public String ssid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125693);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.DvI != null) {
                aVar.e(2, this.DvI);
            }
            aVar.aM(3, this.KFK);
            if (this.KFL != null) {
                aVar.e(4, this.KFL);
            }
            aVar.aM(5, this.scene);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.bb(8, this.KFM);
            if (this.KFN != null) {
                aVar.ni(9, this.KFN.computeSize());
                this.KFN.writeFields(aVar);
            }
            aVar.aM(10, this.KFO);
            aVar.aM(11, this.KFP);
            aVar.aM(12, this.source);
            if (this.KFQ != null) {
                aVar.e(13, this.KFQ);
            }
            aVar.aM(14, this.KFR);
            if (this.KFS != null) {
                aVar.c(15, this.KFS);
            }
            if (this.KFT != null) {
                aVar.c(16, this.KFT);
            }
            aVar.bb(17, this.KFU);
            if (this.Dsg != null) {
                aVar.e(18, this.Dsg);
            }
            if (this.KFH != null) {
                aVar.e(19, this.KFH);
            }
            if (this.KFI != null) {
                aVar.e(20, this.KFI);
            }
            aVar.aM(21, this.KFV);
            aVar.aM(22, this.KFW);
            aVar.aM(23, this.KFX);
            if (this.imei != null) {
                aVar.e(24, this.imei);
            }
            if (this.KFD != null) {
                aVar.e(25, this.KFD);
            }
            if (this.KFE != null) {
                aVar.e(26, this.KFE);
            }
            if (this.KFF != null) {
                aVar.e(27, this.KFF);
            }
            if (this.KFG != null) {
                aVar.e(28, this.KFG);
            }
            AppMethodBeat.o(125693);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.DvI != null) {
                nh += g.a.a.b.b.a.f(2, this.DvI);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KFK);
            if (this.KFL != null) {
                bu += g.a.a.b.b.a.f(4, this.KFL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.scene);
            if (this.ssid != null) {
                bu2 += g.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                bu2 += g.a.a.b.b.a.f(7, this.bssid);
            }
            int r = bu2 + g.a.a.b.b.a.r(8, this.KFM);
            if (this.KFN != null) {
                r += g.a.a.a.nh(9, this.KFN.computeSize());
            }
            int bu3 = r + g.a.a.b.b.a.bu(10, this.KFO) + g.a.a.b.b.a.bu(11, this.KFP) + g.a.a.b.b.a.bu(12, this.source);
            if (this.KFQ != null) {
                bu3 += g.a.a.b.b.a.f(13, this.KFQ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.KFR);
            if (this.KFS != null) {
                bu4 += g.a.a.b.b.a.b(15, this.KFS);
            }
            if (this.KFT != null) {
                bu4 += g.a.a.b.b.a.b(16, this.KFT);
            }
            int r2 = bu4 + g.a.a.b.b.a.r(17, this.KFU);
            if (this.Dsg != null) {
                r2 += g.a.a.b.b.a.f(18, this.Dsg);
            }
            if (this.KFH != null) {
                r2 += g.a.a.b.b.a.f(19, this.KFH);
            }
            if (this.KFI != null) {
                r2 += g.a.a.b.b.a.f(20, this.KFI);
            }
            int bu5 = r2 + g.a.a.b.b.a.bu(21, this.KFV) + g.a.a.b.b.a.bu(22, this.KFW) + g.a.a.b.b.a.bu(23, this.KFX);
            if (this.imei != null) {
                bu5 += g.a.a.b.b.a.f(24, this.imei);
            }
            if (this.KFD != null) {
                bu5 += g.a.a.b.b.a.f(25, this.KFD);
            }
            if (this.KFE != null) {
                bu5 += g.a.a.b.b.a.f(26, this.KFE);
            }
            if (this.KFF != null) {
                bu5 += g.a.a.b.b.a.f(27, this.KFF);
            }
            if (this.KFG != null) {
                bu5 += g.a.a.b.b.a.f(28, this.KFG);
            }
            AppMethodBeat.o(125693);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125693);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bv bvVar = (bv) objArr[1];
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
                        bvVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125693);
                    return 0;
                case 2:
                    bvVar.DvI = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 3:
                    bvVar.KFK = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 4:
                    bvVar.KFL = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 5:
                    bvVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 6:
                    bvVar.ssid = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 7:
                    bvVar.bssid = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 8:
                    bvVar.KFM = aVar3.UbS.zl();
                    AppMethodBeat.o(125693);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ck ckVar = new ck();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ckVar.populateBuilderWithField(aVar5, ckVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bvVar.KFN = ckVar;
                    }
                    AppMethodBeat.o(125693);
                    return 0;
                case 10:
                    bvVar.KFO = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 11:
                    bvVar.KFP = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 12:
                    bvVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 13:
                    bvVar.KFQ = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 14:
                    bvVar.KFR = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 15:
                    bvVar.KFS = aVar3.UbS.hPo();
                    AppMethodBeat.o(125693);
                    return 0;
                case 16:
                    bvVar.KFT = aVar3.UbS.hPo();
                    AppMethodBeat.o(125693);
                    return 0;
                case 17:
                    bvVar.KFU = aVar3.UbS.zl();
                    AppMethodBeat.o(125693);
                    return 0;
                case 18:
                    bvVar.Dsg = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 19:
                    bvVar.KFH = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 20:
                    bvVar.KFI = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 21:
                    bvVar.KFV = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 22:
                    bvVar.KFW = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 23:
                    bvVar.KFX = aVar3.UbS.zi();
                    AppMethodBeat.o(125693);
                    return 0;
                case 24:
                    bvVar.imei = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 25:
                    bvVar.KFD = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 26:
                    bvVar.KFE = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 27:
                    bvVar.KFF = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                case 28:
                    bvVar.KFG = aVar3.UbS.readString();
                    AppMethodBeat.o(125693);
                    return 0;
                default:
                    AppMethodBeat.o(125693);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125693);
            return -1;
        }
    }
}

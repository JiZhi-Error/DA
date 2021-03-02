package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class rh extends dop {
    public int Coi;
    public String CpD;
    public String CpE;
    public String CpG;
    public int CpI;
    public String CpJ;
    public String CpK;
    public String Cpg;
    public String FhU;
    public anr KHP;
    public int KHQ;
    public String KHW;
    public String KYa;
    public String KYg;
    public String KYh;
    public String KYi;
    public int KYj;
    public boolean KYk;
    public boolean KYl;
    public String KYm;
    public int KYn;
    public String KYo;
    public int KYp;
    public int KYq;
    public String KYr;
    public String KYs;
    public int channel;
    public String hFF;
    public String jTz;
    public String nickname;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91374);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KYg == null) {
                b bVar = new b("Not all required fields were included: qrcode_id");
                AppMethodBeat.o(91374);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.CpJ != null) {
                aVar.e(2, this.CpJ);
            }
            if (this.KYg != null) {
                aVar.e(3, this.KYg);
            }
            aVar.aM(4, this.scene);
            if (this.KYh != null) {
                aVar.e(5, this.KYh);
            }
            if (this.CpD != null) {
                aVar.e(6, this.CpD);
            }
            aVar.aM(7, this.KHQ);
            aVar.aM(8, this.channel);
            if (this.CpK != null) {
                aVar.e(9, this.CpK);
            }
            if (this.CpE != null) {
                aVar.e(10, this.CpE);
            }
            if (this.KYi != null) {
                aVar.e(11, this.KYi);
            }
            aVar.aM(12, this.KYj);
            aVar.aM(13, this.CpI);
            if (this.jTz != null) {
                aVar.e(14, this.jTz);
            }
            if (this.KHP != null) {
                aVar.ni(15, this.KHP.computeSize());
                this.KHP.writeFields(aVar);
            }
            if (this.KYa != null) {
                aVar.e(16, this.KYa);
            }
            aVar.aM(17, this.Coi);
            aVar.cc(18, this.KYk);
            aVar.cc(19, this.KYl);
            if (this.FhU != null) {
                aVar.e(20, this.FhU);
            }
            if (this.hFF != null) {
                aVar.e(21, this.hFF);
            }
            if (this.KYm != null) {
                aVar.e(22, this.KYm);
            }
            if (this.CpG != null) {
                aVar.e(23, this.CpG);
            }
            if (this.nickname != null) {
                aVar.e(24, this.nickname);
            }
            if (this.Cpg != null) {
                aVar.e(25, this.Cpg);
            }
            aVar.aM(26, this.KYn);
            if (this.KYo != null) {
                aVar.e(27, this.KYo);
            }
            aVar.aM(28, this.KYp);
            aVar.aM(29, this.KYq);
            if (this.KHW != null) {
                aVar.e(30, this.KHW);
            }
            if (this.KYr != null) {
                aVar.e(31, this.KYr);
            }
            if (this.KYs != null) {
                aVar.e(32, this.KYs);
            }
            AppMethodBeat.o(91374);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.CpJ != null) {
                nh += g.a.a.b.b.a.f(2, this.CpJ);
            }
            if (this.KYg != null) {
                nh += g.a.a.b.b.a.f(3, this.KYg);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene);
            if (this.KYh != null) {
                bu += g.a.a.b.b.a.f(5, this.KYh);
            }
            if (this.CpD != null) {
                bu += g.a.a.b.b.a.f(6, this.CpD);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KHQ) + g.a.a.b.b.a.bu(8, this.channel);
            if (this.CpK != null) {
                bu2 += g.a.a.b.b.a.f(9, this.CpK);
            }
            if (this.CpE != null) {
                bu2 += g.a.a.b.b.a.f(10, this.CpE);
            }
            if (this.KYi != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KYi);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.KYj) + g.a.a.b.b.a.bu(13, this.CpI);
            if (this.jTz != null) {
                bu3 += g.a.a.b.b.a.f(14, this.jTz);
            }
            if (this.KHP != null) {
                bu3 += g.a.a.a.nh(15, this.KHP.computeSize());
            }
            if (this.KYa != null) {
                bu3 += g.a.a.b.b.a.f(16, this.KYa);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(17, this.Coi) + g.a.a.b.b.a.fS(18) + 1 + g.a.a.b.b.a.fS(19) + 1;
            if (this.FhU != null) {
                bu4 += g.a.a.b.b.a.f(20, this.FhU);
            }
            if (this.hFF != null) {
                bu4 += g.a.a.b.b.a.f(21, this.hFF);
            }
            if (this.KYm != null) {
                bu4 += g.a.a.b.b.a.f(22, this.KYm);
            }
            if (this.CpG != null) {
                bu4 += g.a.a.b.b.a.f(23, this.CpG);
            }
            if (this.nickname != null) {
                bu4 += g.a.a.b.b.a.f(24, this.nickname);
            }
            if (this.Cpg != null) {
                bu4 += g.a.a.b.b.a.f(25, this.Cpg);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(26, this.KYn);
            if (this.KYo != null) {
                bu5 += g.a.a.b.b.a.f(27, this.KYo);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(28, this.KYp) + g.a.a.b.b.a.bu(29, this.KYq);
            if (this.KHW != null) {
                bu6 += g.a.a.b.b.a.f(30, this.KHW);
            }
            if (this.KYr != null) {
                bu6 += g.a.a.b.b.a.f(31, this.KYr);
            }
            if (this.KYs != null) {
                bu6 += g.a.a.b.b.a.f(32, this.KYs);
            }
            AppMethodBeat.o(91374);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KYg == null) {
                b bVar2 = new b("Not all required fields were included: qrcode_id");
                AppMethodBeat.o(91374);
                throw bVar2;
            }
            AppMethodBeat.o(91374);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rh rhVar = (rh) objArr[1];
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
                        rhVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91374);
                    return 0;
                case 2:
                    rhVar.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 3:
                    rhVar.KYg = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 4:
                    rhVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 5:
                    rhVar.KYh = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 6:
                    rhVar.CpD = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 7:
                    rhVar.KHQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 8:
                    rhVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 9:
                    rhVar.CpK = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 10:
                    rhVar.CpE = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 11:
                    rhVar.KYi = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 12:
                    rhVar.KYj = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 13:
                    rhVar.CpI = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 14:
                    rhVar.jTz = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        anr anr = new anr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = anr.populateBuilderWithField(aVar5, anr, dop.getNextFieldNumber(aVar5))) {
                        }
                        rhVar.KHP = anr;
                    }
                    AppMethodBeat.o(91374);
                    return 0;
                case 16:
                    rhVar.KYa = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 17:
                    rhVar.Coi = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 18:
                    rhVar.KYk = aVar3.UbS.yZ();
                    AppMethodBeat.o(91374);
                    return 0;
                case 19:
                    rhVar.KYl = aVar3.UbS.yZ();
                    AppMethodBeat.o(91374);
                    return 0;
                case 20:
                    rhVar.FhU = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 21:
                    rhVar.hFF = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 22:
                    rhVar.KYm = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 23:
                    rhVar.CpG = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 24:
                    rhVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 25:
                    rhVar.Cpg = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 26:
                    rhVar.KYn = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 27:
                    rhVar.KYo = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 28:
                    rhVar.KYp = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 29:
                    rhVar.KYq = aVar3.UbS.zi();
                    AppMethodBeat.o(91374);
                    return 0;
                case 30:
                    rhVar.KHW = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 31:
                    rhVar.KYr = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                case 32:
                    rhVar.KYs = aVar3.UbS.readString();
                    AppMethodBeat.o(91374);
                    return 0;
                default:
                    AppMethodBeat.o(91374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91374);
            return -1;
        }
    }
}

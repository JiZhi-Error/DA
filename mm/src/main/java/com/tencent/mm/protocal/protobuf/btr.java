package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btr extends dpc {
    public boolean HPI;
    public String HSu;
    public String HSv;
    public LinkedList<djv> MaA = new LinkedList<>();
    public boolean MaB;
    public ebx MaC;
    public String Maf;
    public String Mag;
    public String Mah;
    public String Mai;
    public String Maj;
    public boolean Mak;
    public String Mal;
    public long Mam;
    public boolean Man;
    public boolean Mao;
    public boolean Map;
    public String Maq;
    public String Mar;
    public String Mas;
    public String Mat;
    public boolean Mau;
    public LinkedList<String> Mav = new LinkedList<>();
    public cfm Maw;
    public boolean Max;
    public boolean May;
    public boolean Maz;
    public int dDN;
    public String qwn;

    public btr() {
        AppMethodBeat.i(91509);
        AppMethodBeat.o(91509);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91510);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91510);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            if (this.Maf != null) {
                aVar.e(4, this.Maf);
            }
            if (this.Mag != null) {
                aVar.e(5, this.Mag);
            }
            if (this.Mah != null) {
                aVar.e(6, this.Mah);
            }
            if (this.Mai != null) {
                aVar.e(7, this.Mai);
            }
            if (this.Maj != null) {
                aVar.e(8, this.Maj);
            }
            aVar.cc(9, this.Mak);
            if (this.Mal != null) {
                aVar.e(10, this.Mal);
            }
            aVar.bb(11, this.Mam);
            aVar.cc(12, this.Man);
            aVar.cc(13, this.Mao);
            aVar.cc(14, this.Map);
            if (this.Maq != null) {
                aVar.e(15, this.Maq);
            }
            if (this.Mar != null) {
                aVar.e(16, this.Mar);
            }
            if (this.Mas != null) {
                aVar.e(17, this.Mas);
            }
            if (this.Mat != null) {
                aVar.e(18, this.Mat);
            }
            aVar.cc(19, this.Mau);
            aVar.e(20, 1, this.Mav);
            aVar.cc(21, this.HPI);
            if (this.Maw != null) {
                aVar.ni(22, this.Maw.computeSize());
                this.Maw.writeFields(aVar);
            }
            aVar.cc(23, this.Max);
            aVar.cc(26, this.May);
            aVar.cc(27, this.Maz);
            aVar.e(28, 8, this.MaA);
            if (this.HSu != null) {
                aVar.e(29, this.HSu);
            }
            if (this.HSv != null) {
                aVar.e(30, this.HSv);
            }
            aVar.cc(31, this.MaB);
            if (this.MaC != null) {
                aVar.ni(32, this.MaC.computeSize());
                this.MaC.writeFields(aVar);
            }
            AppMethodBeat.o(91510);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.Maf != null) {
                nh += g.a.a.b.b.a.f(4, this.Maf);
            }
            if (this.Mag != null) {
                nh += g.a.a.b.b.a.f(5, this.Mag);
            }
            if (this.Mah != null) {
                nh += g.a.a.b.b.a.f(6, this.Mah);
            }
            if (this.Mai != null) {
                nh += g.a.a.b.b.a.f(7, this.Mai);
            }
            if (this.Maj != null) {
                nh += g.a.a.b.b.a.f(8, this.Maj);
            }
            int fS = nh + g.a.a.b.b.a.fS(9) + 1;
            if (this.Mal != null) {
                fS += g.a.a.b.b.a.f(10, this.Mal);
            }
            int r = fS + g.a.a.b.b.a.r(11, this.Mam) + g.a.a.b.b.a.fS(12) + 1 + g.a.a.b.b.a.fS(13) + 1 + g.a.a.b.b.a.fS(14) + 1;
            if (this.Maq != null) {
                r += g.a.a.b.b.a.f(15, this.Maq);
            }
            if (this.Mar != null) {
                r += g.a.a.b.b.a.f(16, this.Mar);
            }
            if (this.Mas != null) {
                r += g.a.a.b.b.a.f(17, this.Mas);
            }
            if (this.Mat != null) {
                r += g.a.a.b.b.a.f(18, this.Mat);
            }
            int fS2 = r + g.a.a.b.b.a.fS(19) + 1 + g.a.a.a.c(20, 1, this.Mav) + g.a.a.b.b.a.fS(21) + 1;
            if (this.Maw != null) {
                fS2 += g.a.a.a.nh(22, this.Maw.computeSize());
            }
            int fS3 = fS2 + g.a.a.b.b.a.fS(23) + 1 + g.a.a.b.b.a.fS(26) + 1 + g.a.a.b.b.a.fS(27) + 1 + g.a.a.a.c(28, 8, this.MaA);
            if (this.HSu != null) {
                fS3 += g.a.a.b.b.a.f(29, this.HSu);
            }
            if (this.HSv != null) {
                fS3 += g.a.a.b.b.a.f(30, this.HSv);
            }
            int fS4 = fS3 + g.a.a.b.b.a.fS(31) + 1;
            if (this.MaC != null) {
                fS4 += g.a.a.a.nh(32, this.MaC.computeSize());
            }
            AppMethodBeat.o(91510);
            return fS4;
        } else if (i2 == 2) {
            this.Mav.clear();
            this.MaA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91510);
                throw bVar2;
            }
            AppMethodBeat.o(91510);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btr btr = (btr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        btr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91510);
                    return 0;
                case 2:
                    btr.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91510);
                    return 0;
                case 3:
                    btr.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 4:
                    btr.Maf = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 5:
                    btr.Mag = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 6:
                    btr.Mah = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 7:
                    btr.Mai = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 8:
                    btr.Maj = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 9:
                    btr.Mak = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 10:
                    btr.Mal = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 11:
                    btr.Mam = aVar3.UbS.zl();
                    AppMethodBeat.o(91510);
                    return 0;
                case 12:
                    btr.Man = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 13:
                    btr.Mao = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 14:
                    btr.Map = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 15:
                    btr.Maq = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 16:
                    btr.Mar = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 17:
                    btr.Mas = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 18:
                    btr.Mat = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 19:
                    btr.Mau = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 20:
                    btr.Mav.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91510);
                    return 0;
                case 21:
                    btr.HPI = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfm cfm = new cfm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfm.populateBuilderWithField(aVar5, cfm, dpc.getNextFieldNumber(aVar5))) {
                        }
                        btr.Maw = cfm;
                    }
                    AppMethodBeat.o(91510);
                    return 0;
                case 23:
                    btr.Max = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 24:
                case 25:
                default:
                    AppMethodBeat.o(91510);
                    return -1;
                case 26:
                    btr.May = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 27:
                    btr.Maz = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        djv djv = new djv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = djv.populateBuilderWithField(aVar6, djv, dpc.getNextFieldNumber(aVar6))) {
                        }
                        btr.MaA.add(djv);
                    }
                    AppMethodBeat.o(91510);
                    return 0;
                case 29:
                    btr.HSu = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 30:
                    btr.HSv = aVar3.UbS.readString();
                    AppMethodBeat.o(91510);
                    return 0;
                case 31:
                    btr.MaB = aVar3.UbS.yZ();
                    AppMethodBeat.o(91510);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ebx ebx = new ebx();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ebx.populateBuilderWithField(aVar7, ebx, dpc.getNextFieldNumber(aVar7))) {
                        }
                        btr.MaC = ebx;
                    }
                    AppMethodBeat.o(91510);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91510);
            return -1;
        }
    }
}

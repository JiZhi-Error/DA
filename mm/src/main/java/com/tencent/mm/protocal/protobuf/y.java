package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class y extends dpc {
    public String KBA;
    public String KBB;
    public a KBE;
    public String KBM;
    public String KBQ;
    public long KBR;
    public int KBS;
    public long KBT;
    public int KBU;
    public int KBV;
    public int KBW;
    public int KBX;
    public long KBY;
    public long KBZ;
    public String KBs;
    public LinkedList<w> KBx = new LinkedList<>();
    public long KCa;
    public int KCb;
    public String KCc;
    public int KCd;
    public long KCe;
    public String KCf;
    public int dDN = 268513600;
    public String qwn = "请求不成功，请稍候再试";
    public int role;
    public int state;
    public String title;
    public int type;

    public y() {
        AppMethodBeat.i(91334);
        AppMethodBeat.o(91334);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91335);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91335);
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
            if (this.KBs != null) {
                aVar.e(4, this.KBs);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            aVar.aM(6, this.type);
            if (this.KBQ != null) {
                aVar.e(7, this.KBQ);
            }
            aVar.bb(8, this.KBR);
            aVar.aM(9, this.KBS);
            aVar.bb(10, this.KBT);
            aVar.aM(11, this.KBU);
            aVar.aM(12, this.state);
            aVar.aM(13, this.KBV);
            aVar.aM(14, this.KBW);
            aVar.aM(15, this.role);
            aVar.aM(16, this.KBX);
            aVar.bb(17, this.KBY);
            aVar.bb(18, this.KBZ);
            aVar.bb(19, this.KCa);
            aVar.aM(20, this.KCb);
            if (this.KBM != null) {
                aVar.e(21, this.KBM);
            }
            aVar.e(22, 8, this.KBx);
            if (this.KCc != null) {
                aVar.e(23, this.KCc);
            }
            aVar.aM(24, this.KCd);
            aVar.bb(25, this.KCe);
            if (this.KBA != null) {
                aVar.e(26, this.KBA);
            }
            if (this.KBB != null) {
                aVar.e(27, this.KBB);
            }
            if (this.KBE != null) {
                aVar.ni(28, this.KBE.computeSize());
                this.KBE.writeFields(aVar);
            }
            if (this.KCf != null) {
                aVar.e(29, this.KCf);
            }
            AppMethodBeat.o(91335);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.KBs != null) {
                nh += g.a.a.b.b.a.f(4, this.KBs);
            }
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(5, this.title);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.type);
            if (this.KBQ != null) {
                bu += g.a.a.b.b.a.f(7, this.KBQ);
            }
            int r = bu + g.a.a.b.b.a.r(8, this.KBR) + g.a.a.b.b.a.bu(9, this.KBS) + g.a.a.b.b.a.r(10, this.KBT) + g.a.a.b.b.a.bu(11, this.KBU) + g.a.a.b.b.a.bu(12, this.state) + g.a.a.b.b.a.bu(13, this.KBV) + g.a.a.b.b.a.bu(14, this.KBW) + g.a.a.b.b.a.bu(15, this.role) + g.a.a.b.b.a.bu(16, this.KBX) + g.a.a.b.b.a.r(17, this.KBY) + g.a.a.b.b.a.r(18, this.KBZ) + g.a.a.b.b.a.r(19, this.KCa) + g.a.a.b.b.a.bu(20, this.KCb);
            if (this.KBM != null) {
                r += g.a.a.b.b.a.f(21, this.KBM);
            }
            int c2 = r + g.a.a.a.c(22, 8, this.KBx);
            if (this.KCc != null) {
                c2 += g.a.a.b.b.a.f(23, this.KCc);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(24, this.KCd) + g.a.a.b.b.a.r(25, this.KCe);
            if (this.KBA != null) {
                bu2 += g.a.a.b.b.a.f(26, this.KBA);
            }
            if (this.KBB != null) {
                bu2 += g.a.a.b.b.a.f(27, this.KBB);
            }
            if (this.KBE != null) {
                bu2 += g.a.a.a.nh(28, this.KBE.computeSize());
            }
            if (this.KCf != null) {
                bu2 += g.a.a.b.b.a.f(29, this.KCf);
            }
            AppMethodBeat.o(91335);
            return bu2;
        } else if (i2 == 2) {
            this.KBx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91335);
                throw bVar2;
            }
            AppMethodBeat.o(91335);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
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
                        yVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91335);
                    return 0;
                case 2:
                    yVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 3:
                    yVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 4:
                    yVar.KBs = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 5:
                    yVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 6:
                    yVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 7:
                    yVar.KBQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 8:
                    yVar.KBR = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 9:
                    yVar.KBS = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 10:
                    yVar.KBT = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 11:
                    yVar.KBU = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 12:
                    yVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 13:
                    yVar.KBV = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 14:
                    yVar.KBW = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 15:
                    yVar.role = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 16:
                    yVar.KBX = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 17:
                    yVar.KBY = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 18:
                    yVar.KBZ = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 19:
                    yVar.KCa = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 20:
                    yVar.KCb = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 21:
                    yVar.KBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        w wVar = new w();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = wVar.populateBuilderWithField(aVar5, wVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        yVar.KBx.add(wVar);
                    }
                    AppMethodBeat.o(91335);
                    return 0;
                case 23:
                    yVar.KCc = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 24:
                    yVar.KCd = aVar3.UbS.zi();
                    AppMethodBeat.o(91335);
                    return 0;
                case 25:
                    yVar.KCe = aVar3.UbS.zl();
                    AppMethodBeat.o(91335);
                    return 0;
                case 26:
                    yVar.KBA = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 27:
                    yVar.KBB = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar6 = new a();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aVar6.populateBuilderWithField(aVar7, aVar6, dpc.getNextFieldNumber(aVar7))) {
                        }
                        yVar.KBE = aVar6;
                    }
                    AppMethodBeat.o(91335);
                    return 0;
                case 29:
                    yVar.KCf = aVar3.UbS.readString();
                    AppMethodBeat.o(91335);
                    return 0;
                default:
                    AppMethodBeat.o(91335);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91335);
            return -1;
        }
    }
}

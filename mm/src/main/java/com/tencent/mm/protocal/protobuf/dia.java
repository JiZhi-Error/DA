package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dia extends dpc {
    public LinkedList<l> KBx = new LinkedList<>();
    public dvf MMH;
    public n MMI;
    public int dDN = 268513600;
    public long eht;
    public String jTB;
    public String jTD;
    public String jTz;
    public String qwn = "请求不成功，请稍候再试";
    public String remark;

    public dia() {
        AppMethodBeat.i(91649);
        AppMethodBeat.o(91649);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91650);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91650);
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
            aVar.bb(4, this.eht);
            if (this.jTz != null) {
                aVar.e(5, this.jTz);
            }
            aVar.e(6, 8, this.KBx);
            if (this.jTB != null) {
                aVar.e(7, this.jTB);
            }
            if (this.remark != null) {
                aVar.e(8, this.remark);
            }
            if (this.MMH != null) {
                aVar.ni(9, this.MMH.computeSize());
                this.MMH.writeFields(aVar);
            }
            if (this.jTD != null) {
                aVar.e(10, this.jTD);
            }
            if (this.MMI != null) {
                aVar.ni(11, this.MMI.computeSize());
                this.MMI.writeFields(aVar);
            }
            AppMethodBeat.o(91650);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.eht);
            if (this.jTz != null) {
                r += g.a.a.b.b.a.f(5, this.jTz);
            }
            int c2 = r + g.a.a.a.c(6, 8, this.KBx);
            if (this.jTB != null) {
                c2 += g.a.a.b.b.a.f(7, this.jTB);
            }
            if (this.remark != null) {
                c2 += g.a.a.b.b.a.f(8, this.remark);
            }
            if (this.MMH != null) {
                c2 += g.a.a.a.nh(9, this.MMH.computeSize());
            }
            if (this.jTD != null) {
                c2 += g.a.a.b.b.a.f(10, this.jTD);
            }
            if (this.MMI != null) {
                c2 += g.a.a.a.nh(11, this.MMI.computeSize());
            }
            AppMethodBeat.o(91650);
            return c2;
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
                AppMethodBeat.o(91650);
                throw bVar2;
            }
            AppMethodBeat.o(91650);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dia dia = (dia) objArr[1];
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
                        dia.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91650);
                    return 0;
                case 2:
                    dia.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91650);
                    return 0;
                case 3:
                    dia.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91650);
                    return 0;
                case 4:
                    dia.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91650);
                    return 0;
                case 5:
                    dia.jTz = aVar3.UbS.readString();
                    AppMethodBeat.o(91650);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        l lVar = new l();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = lVar.populateBuilderWithField(aVar5, lVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dia.KBx.add(lVar);
                    }
                    AppMethodBeat.o(91650);
                    return 0;
                case 7:
                    dia.jTB = aVar3.UbS.readString();
                    AppMethodBeat.o(91650);
                    return 0;
                case 8:
                    dia.remark = aVar3.UbS.readString();
                    AppMethodBeat.o(91650);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dvf dvf = new dvf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dvf.populateBuilderWithField(aVar6, dvf, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dia.MMH = dvf;
                    }
                    AppMethodBeat.o(91650);
                    return 0;
                case 10:
                    dia.jTD = aVar3.UbS.readString();
                    AppMethodBeat.o(91650);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        n nVar = new n();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = nVar.populateBuilderWithField(aVar7, nVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dia.MMI = nVar;
                    }
                    AppMethodBeat.o(91650);
                    return 0;
                default:
                    AppMethodBeat.o(91650);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91650);
            return -1;
        }
    }
}

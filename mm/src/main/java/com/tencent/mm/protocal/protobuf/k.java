package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class k extends dpc {
    public ab KBD;
    public a KBE;
    public String KBs;
    public String KBu;
    public int dDN = 268513600;
    public String qwn = "请求不成功，请稍候再试";

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91320);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91320);
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
            if (this.KBu != null) {
                aVar.e(6, this.KBu);
            }
            if (this.KBD != null) {
                aVar.ni(7, this.KBD.computeSize());
                this.KBD.writeFields(aVar);
            }
            if (this.KBE != null) {
                aVar.ni(8, this.KBE.computeSize());
                this.KBE.writeFields(aVar);
            }
            AppMethodBeat.o(91320);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.KBs != null) {
                nh += g.a.a.b.b.a.f(4, this.KBs);
            }
            if (this.KBu != null) {
                nh += g.a.a.b.b.a.f(6, this.KBu);
            }
            if (this.KBD != null) {
                nh += g.a.a.a.nh(7, this.KBD.computeSize());
            }
            if (this.KBE != null) {
                nh += g.a.a.a.nh(8, this.KBE.computeSize());
            }
            AppMethodBeat.o(91320);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91320);
                throw bVar2;
            }
            AppMethodBeat.o(91320);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
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
                        kVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91320);
                    return 0;
                case 2:
                    kVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91320);
                    return 0;
                case 3:
                    kVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91320);
                    return 0;
                case 4:
                    kVar.KBs = aVar3.UbS.readString();
                    AppMethodBeat.o(91320);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(91320);
                    return -1;
                case 6:
                    kVar.KBu = aVar3.UbS.readString();
                    AppMethodBeat.o(91320);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ab abVar = new ab();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abVar.populateBuilderWithField(aVar5, abVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        kVar.KBD = abVar;
                    }
                    AppMethodBeat.o(91320);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar6 = new a();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aVar6.populateBuilderWithField(aVar7, aVar6, dpc.getNextFieldNumber(aVar7))) {
                        }
                        kVar.KBE = aVar6;
                    }
                    AppMethodBeat.o(91320);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91320);
            return -1;
        }
    }
}

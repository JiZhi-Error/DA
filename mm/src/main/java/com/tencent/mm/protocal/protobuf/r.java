package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class r extends dpc {
    public String Cpg;
    public a KBE;
    public String KBM;
    public String KBu;
    public int dDN = 268513600;
    public String dXf;
    public String qwn = "请求不成功，请稍候再试";
    public String wFL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91327);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91327);
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
            if (this.wFL != null) {
                aVar.e(4, this.wFL);
            }
            if (this.dXf != null) {
                aVar.e(5, this.dXf);
            }
            if (this.Cpg != null) {
                aVar.e(7, this.Cpg);
            }
            if (this.KBu != null) {
                aVar.e(8, this.KBu);
            }
            if (this.KBE != null) {
                aVar.ni(9, this.KBE.computeSize());
                this.KBE.writeFields(aVar);
            }
            if (this.KBM != null) {
                aVar.e(10, this.KBM);
            }
            AppMethodBeat.o(91327);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.wFL != null) {
                nh += g.a.a.b.b.a.f(4, this.wFL);
            }
            if (this.dXf != null) {
                nh += g.a.a.b.b.a.f(5, this.dXf);
            }
            if (this.Cpg != null) {
                nh += g.a.a.b.b.a.f(7, this.Cpg);
            }
            if (this.KBu != null) {
                nh += g.a.a.b.b.a.f(8, this.KBu);
            }
            if (this.KBE != null) {
                nh += g.a.a.a.nh(9, this.KBE.computeSize());
            }
            if (this.KBM != null) {
                nh += g.a.a.b.b.a.f(10, this.KBM);
            }
            AppMethodBeat.o(91327);
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
                AppMethodBeat.o(91327);
                throw bVar2;
            }
            AppMethodBeat.o(91327);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
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
                        rVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91327);
                    return 0;
                case 2:
                    rVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91327);
                    return 0;
                case 3:
                    rVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
                case 4:
                    rVar.wFL = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
                case 5:
                    rVar.dXf = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(91327);
                    return -1;
                case 7:
                    rVar.Cpg = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
                case 8:
                    rVar.KBu = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar5 = new a();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aVar5.populateBuilderWithField(aVar6, aVar5, dpc.getNextFieldNumber(aVar6))) {
                        }
                        rVar.KBE = aVar5;
                    }
                    AppMethodBeat.o(91327);
                    return 0;
                case 10:
                    rVar.KBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91327);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91327);
            return -1;
        }
    }
}
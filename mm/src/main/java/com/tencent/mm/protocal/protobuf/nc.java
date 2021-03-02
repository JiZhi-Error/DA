package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class nc extends dpc {
    public int KND;
    public int KRL;
    public String KRM;
    public long KRi;
    public int KRs;
    public String KRv;
    public GoodsObject KRw;
    public String dNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212230);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212230);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KRs);
            if (this.dNQ != null) {
                aVar.e(7, this.dNQ);
            }
            if (this.KRv != null) {
                aVar.e(8, this.KRv);
            }
            if (this.KRw != null) {
                aVar.ni(9, this.KRw.computeSize());
                this.KRw.writeFields(aVar);
            }
            aVar.bb(11, this.KRi);
            aVar.aM(14, this.KRL);
            aVar.aM(15, this.KND);
            if (this.KRM != null) {
                aVar.e(21, this.KRM);
            }
            AppMethodBeat.o(212230);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KRs);
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(7, this.dNQ);
            }
            if (this.KRv != null) {
                nh += g.a.a.b.b.a.f(8, this.KRv);
            }
            if (this.KRw != null) {
                nh += g.a.a.a.nh(9, this.KRw.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(11, this.KRi) + g.a.a.b.b.a.bu(14, this.KRL) + g.a.a.b.b.a.bu(15, this.KND);
            if (this.KRM != null) {
                r += g.a.a.b.b.a.f(21, this.KRM);
            }
            AppMethodBeat.o(212230);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212230);
                throw bVar2;
            }
            AppMethodBeat.o(212230);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nc ncVar = (nc) objArr[1];
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
                        ncVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(212230);
                    return 0;
                case 2:
                    ncVar.KRs = aVar3.UbS.zi();
                    AppMethodBeat.o(212230);
                    return 0;
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 12:
                case 13:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                default:
                    AppMethodBeat.o(212230);
                    return -1;
                case 7:
                    ncVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(212230);
                    return 0;
                case 8:
                    ncVar.KRv = aVar3.UbS.readString();
                    AppMethodBeat.o(212230);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GoodsObject goodsObject = new GoodsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = goodsObject.populateBuilderWithField(aVar5, goodsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ncVar.KRw = goodsObject;
                    }
                    AppMethodBeat.o(212230);
                    return 0;
                case 11:
                    ncVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(212230);
                    return 0;
                case 14:
                    ncVar.KRL = aVar3.UbS.zi();
                    AppMethodBeat.o(212230);
                    return 0;
                case 15:
                    ncVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(212230);
                    return 0;
                case 21:
                    ncVar.KRM = aVar3.UbS.readString();
                    AppMethodBeat.o(212230);
                    return 0;
            }
        } else {
            AppMethodBeat.o(212230);
            return -1;
        }
    }
}

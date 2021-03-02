package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mw extends dpc {
    public int KRA;
    public int KRg;
    public int KRh;
    public long KRi;
    public int KRs;
    public String KRt;
    public String KRu;
    public String KRv;
    public GoodsObject KRw;
    public boolean KRx = false;
    public int KRy;
    public boolean KRz;
    public String dNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124395);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124395);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KRs);
            if (this.KRt != null) {
                aVar.e(3, this.KRt);
            }
            if (this.KRu != null) {
                aVar.e(4, this.KRu);
            }
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
            aVar.aM(10, this.KRg);
            aVar.bb(11, this.KRi);
            aVar.aM(12, this.KRh);
            aVar.cc(13, this.KRx);
            aVar.aM(16, this.KRy);
            aVar.cc(17, this.KRz);
            aVar.aM(50, this.KRA);
            AppMethodBeat.o(124395);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KRs);
            if (this.KRt != null) {
                nh += g.a.a.b.b.a.f(3, this.KRt);
            }
            if (this.KRu != null) {
                nh += g.a.a.b.b.a.f(4, this.KRu);
            }
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(7, this.dNQ);
            }
            if (this.KRv != null) {
                nh += g.a.a.b.b.a.f(8, this.KRv);
            }
            if (this.KRw != null) {
                nh += g.a.a.a.nh(9, this.KRw.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.KRg) + g.a.a.b.b.a.r(11, this.KRi) + g.a.a.b.b.a.bu(12, this.KRh) + g.a.a.b.b.a.fS(13) + 1 + g.a.a.b.b.a.bu(16, this.KRy) + g.a.a.b.b.a.fS(17) + 1 + g.a.a.b.b.a.bu(50, this.KRA);
            AppMethodBeat.o(124395);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124395);
                throw bVar2;
            }
            AppMethodBeat.o(124395);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mw mwVar = (mw) objArr[1];
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
                        mwVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124395);
                    return 0;
                case 2:
                    mwVar.KRs = aVar3.UbS.zi();
                    AppMethodBeat.o(124395);
                    return 0;
                case 3:
                    mwVar.KRt = aVar3.UbS.readString();
                    AppMethodBeat.o(124395);
                    return 0;
                case 4:
                    mwVar.KRu = aVar3.UbS.readString();
                    AppMethodBeat.o(124395);
                    return 0;
                case 7:
                    mwVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(124395);
                    return 0;
                case 8:
                    mwVar.KRv = aVar3.UbS.readString();
                    AppMethodBeat.o(124395);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GoodsObject goodsObject = new GoodsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = goodsObject.populateBuilderWithField(aVar5, goodsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        mwVar.KRw = goodsObject;
                    }
                    AppMethodBeat.o(124395);
                    return 0;
                case 10:
                    mwVar.KRg = aVar3.UbS.zi();
                    AppMethodBeat.o(124395);
                    return 0;
                case 11:
                    mwVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(124395);
                    return 0;
                case 12:
                    mwVar.KRh = aVar3.UbS.zi();
                    AppMethodBeat.o(124395);
                    return 0;
                case 13:
                    mwVar.KRx = aVar3.UbS.yZ();
                    AppMethodBeat.o(124395);
                    return 0;
                case 16:
                    mwVar.KRy = aVar3.UbS.zi();
                    AppMethodBeat.o(124395);
                    return 0;
                case 17:
                    mwVar.KRz = aVar3.UbS.yZ();
                    AppMethodBeat.o(124395);
                    return 0;
                case 50:
                    mwVar.KRA = aVar3.UbS.zi();
                    AppMethodBeat.o(124395);
                    return 0;
                default:
                    AppMethodBeat.o(124395);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124395);
            return -1;
        }
    }
}

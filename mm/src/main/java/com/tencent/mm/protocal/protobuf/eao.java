package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eao extends dpc {
    public SnsObject MYH;
    public String Mtk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125807);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125807);
                throw bVar;
            } else if (this.MYH == null) {
                b bVar2 = new b("Not all required fields were included: SnsObject");
                AppMethodBeat.o(125807);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.MYH != null) {
                    aVar.ni(2, this.MYH.computeSize());
                    this.MYH.writeFields(aVar);
                }
                if (this.Mtk != null) {
                    aVar.e(3, this.Mtk);
                }
                AppMethodBeat.o(125807);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MYH != null) {
                nh += g.a.a.a.nh(2, this.MYH.computeSize());
            }
            if (this.Mtk != null) {
                nh += g.a.a.b.b.a.f(3, this.Mtk);
            }
            AppMethodBeat.o(125807);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125807);
                throw bVar3;
            } else if (this.MYH == null) {
                b bVar4 = new b("Not all required fields were included: SnsObject");
                AppMethodBeat.o(125807);
                throw bVar4;
            } else {
                AppMethodBeat.o(125807);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eao eao = (eao) objArr[1];
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
                        eao.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125807);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SnsObject snsObject = new SnsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = snsObject.populateBuilderWithField(aVar5, snsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        eao.MYH = snsObject;
                    }
                    AppMethodBeat.o(125807);
                    return 0;
                case 3:
                    eao.Mtk = aVar3.UbS.readString();
                    AppMethodBeat.o(125807);
                    return 0;
                default:
                    AppMethodBeat.o(125807);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125807);
            return -1;
        }
    }
}
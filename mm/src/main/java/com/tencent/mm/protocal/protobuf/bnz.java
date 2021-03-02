package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnz extends dpc {
    public int BsF;
    public int BsG;
    public SKBuiltinBuffer_t BsI;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152571);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152571);
                throw bVar;
            } else if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152571);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.UserName != null) {
                    aVar.e(2, this.UserName);
                }
                aVar.aM(3, this.BsF);
                aVar.aM(4, this.BsG);
                if (this.BsI != null) {
                    aVar.ni(5, this.BsI.computeSize());
                    this.BsI.writeFields(aVar);
                }
                AppMethodBeat.o(152571);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.BsG);
            if (this.BsI != null) {
                bu += g.a.a.a.nh(5, this.BsI.computeSize());
            }
            AppMethodBeat.o(152571);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152571);
                throw bVar3;
            } else if (this.BsI == null) {
                b bVar4 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152571);
                throw bVar4;
            } else {
                AppMethodBeat.o(152571);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnz bnz = (bnz) objArr[1];
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
                        bnz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152571);
                    return 0;
                case 2:
                    bnz.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152571);
                    return 0;
                case 3:
                    bnz.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152571);
                    return 0;
                case 4:
                    bnz.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152571);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bnz.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152571);
                    return 0;
                default:
                    AppMethodBeat.o(152571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152571);
            return -1;
        }
    }
}

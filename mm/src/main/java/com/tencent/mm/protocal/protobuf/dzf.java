package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dzf extends dpc {
    public eaq MOf;
    public SKBuiltinBuffer_t MYJ;
    public dzd MYM;
    public SKBuiltinBuffer_t MYN;
    public ds MYO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125767);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125767);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MYM != null) {
                aVar.ni(2, this.MYM.computeSize());
                this.MYM.writeFields(aVar);
            }
            if (this.MYJ != null) {
                aVar.ni(3, this.MYJ.computeSize());
                this.MYJ.writeFields(aVar);
            }
            if (this.MOf != null) {
                aVar.ni(4, this.MOf.computeSize());
                this.MOf.writeFields(aVar);
            }
            if (this.MYN != null) {
                aVar.ni(5, this.MYN.computeSize());
                this.MYN.writeFields(aVar);
            }
            if (this.MYO != null) {
                aVar.ni(6, this.MYO.computeSize());
                this.MYO.writeFields(aVar);
            }
            AppMethodBeat.o(125767);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MYM != null) {
                nh += g.a.a.a.nh(2, this.MYM.computeSize());
            }
            if (this.MYJ != null) {
                nh += g.a.a.a.nh(3, this.MYJ.computeSize());
            }
            if (this.MOf != null) {
                nh += g.a.a.a.nh(4, this.MOf.computeSize());
            }
            if (this.MYN != null) {
                nh += g.a.a.a.nh(5, this.MYN.computeSize());
            }
            if (this.MYO != null) {
                nh += g.a.a.a.nh(6, this.MYO.computeSize());
            }
            AppMethodBeat.o(125767);
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
                AppMethodBeat.o(125767);
                throw bVar2;
            }
            AppMethodBeat.o(125767);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzf dzf = (dzf) objArr[1];
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
                        dzf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzd dzd = new dzd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzd.populateBuilderWithField(aVar5, dzd, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dzf.MYM = dzd;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dzf.MYJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eaq eaq = new eaq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eaq.populateBuilderWithField(aVar7, eaq, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dzf.MOf = eaq;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar8, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dzf.MYN = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ds dsVar = new ds();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dsVar.populateBuilderWithField(aVar9, dsVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        dzf.MYO = dsVar;
                    }
                    AppMethodBeat.o(125767);
                    return 0;
                default:
                    AppMethodBeat.o(125767);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125767);
            return -1;
        }
    }
}

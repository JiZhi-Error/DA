package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cwq extends dpc {
    public SKBuiltinBuffer_t MBy;
    public abo MBz;
    public int tUC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152656);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152656);
                throw bVar;
            } else if (this.MBz == null) {
                b bVar2 = new b("Not all required fields were included: cmd_list");
                AppMethodBeat.o(152656);
                throw bVar2;
            } else if (this.MBy == null) {
                b bVar3 = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(152656);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.MBz != null) {
                    aVar.ni(2, this.MBz.computeSize());
                    this.MBz.writeFields(aVar);
                }
                aVar.aM(3, this.tUC);
                if (this.MBy != null) {
                    aVar.ni(4, this.MBy.computeSize());
                    this.MBy.writeFields(aVar);
                }
                AppMethodBeat.o(152656);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MBz != null) {
                nh += g.a.a.a.nh(2, this.MBz.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.tUC);
            if (this.MBy != null) {
                bu += g.a.a.a.nh(4, this.MBy.computeSize());
            }
            AppMethodBeat.o(152656);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152656);
                throw bVar4;
            } else if (this.MBz == null) {
                b bVar5 = new b("Not all required fields were included: cmd_list");
                AppMethodBeat.o(152656);
                throw bVar5;
            } else if (this.MBy == null) {
                b bVar6 = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(152656);
                throw bVar6;
            } else {
                AppMethodBeat.o(152656);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cwq cwq = (cwq) objArr[1];
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
                        cwq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152656);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abo.populateBuilderWithField(aVar5, abo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cwq.MBz = abo;
                    }
                    AppMethodBeat.o(152656);
                    return 0;
                case 3:
                    cwq.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(152656);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cwq.MBy = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152656);
                    return 0;
                default:
                    AppMethodBeat.o(152656);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152656);
            return -1;
        }
    }
}

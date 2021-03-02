package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bmg extends dpc {
    public SKBuiltinBuffer_t LUY;
    public LinkedList<ait> LVc = new LinkedList<>();
    public LinkedList<aiw> LVd = new LinkedList<>();

    public bmg() {
        AppMethodBeat.i(104785);
        AppMethodBeat.o(104785);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104786);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104786);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LVc);
            if (this.LUY != null) {
                aVar.ni(3, this.LUY.computeSize());
                this.LUY.writeFields(aVar);
            }
            aVar.e(4, 8, this.LVd);
            AppMethodBeat.o(104786);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LVc);
            if (this.LUY != null) {
                nh += g.a.a.a.nh(3, this.LUY.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LVd);
            AppMethodBeat.o(104786);
            return c2;
        } else if (i2 == 2) {
            this.LVc.clear();
            this.LVd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104786);
                throw bVar2;
            }
            AppMethodBeat.o(104786);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmg bmg = (bmg) objArr[1];
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
                        bmg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104786);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ait ait = new ait();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ait.populateBuilderWithField(aVar5, ait, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bmg.LVc.add(ait);
                    }
                    AppMethodBeat.o(104786);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bmg.LUY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104786);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aiw aiw = new aiw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aiw.populateBuilderWithField(aVar7, aiw, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bmg.LVd.add(aiw);
                    }
                    AppMethodBeat.o(104786);
                    return 0;
                default:
                    AppMethodBeat.o(104786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104786);
            return -1;
        }
    }
}

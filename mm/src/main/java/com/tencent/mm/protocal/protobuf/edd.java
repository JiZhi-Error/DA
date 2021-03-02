package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class edd extends dpc {
    public SKBuiltinBuffer_t Ndv;
    public int Ndw;
    public LinkedList<edb> Ndx = new LinkedList<>();
    public int Ndy;

    public edd() {
        AppMethodBeat.i(118436);
        AppMethodBeat.o(118436);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118437);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118437);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Ndw);
            aVar.e(3, 8, this.Ndx);
            aVar.aM(4, this.Ndy);
            if (this.Ndv != null) {
                aVar.ni(5, this.Ndv.computeSize());
                this.Ndv.writeFields(aVar);
            }
            AppMethodBeat.o(118437);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Ndw) + g.a.a.a.c(3, 8, this.Ndx) + g.a.a.b.b.a.bu(4, this.Ndy);
            if (this.Ndv != null) {
                nh += g.a.a.a.nh(5, this.Ndv.computeSize());
            }
            AppMethodBeat.o(118437);
            return nh;
        } else if (i2 == 2) {
            this.Ndx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(118437);
                throw bVar2;
            }
            AppMethodBeat.o(118437);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edd edd = (edd) objArr[1];
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
                        edd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(118437);
                    return 0;
                case 2:
                    edd.Ndw = aVar3.UbS.zi();
                    AppMethodBeat.o(118437);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edb edb = new edb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edb.populateBuilderWithField(aVar5, edb, dpc.getNextFieldNumber(aVar5))) {
                        }
                        edd.Ndx.add(edb);
                    }
                    AppMethodBeat.o(118437);
                    return 0;
                case 4:
                    edd.Ndy = aVar3.UbS.zi();
                    AppMethodBeat.o(118437);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        edd.Ndv = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(118437);
                    return 0;
                default:
                    AppMethodBeat.o(118437);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118437);
            return -1;
        }
    }
}

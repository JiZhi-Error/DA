package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfp extends dpc {
    public LinkedList<dfe> KMD = new LinkedList<>();
    public int LsZ;
    public long Lta;
    public LinkedList<dfe> MKt = new LinkedList<>();

    public dfp() {
        AppMethodBeat.i(32384);
        AppMethodBeat.o(32384);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32385);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32385);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.e(4, 8, this.KMD);
            aVar.e(5, 8, this.MKt);
            AppMethodBeat.o(32385);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.a.c(4, 8, this.KMD) + g.a.a.a.c(5, 8, this.MKt);
            AppMethodBeat.o(32385);
            return nh;
        } else if (i2 == 2) {
            this.KMD.clear();
            this.MKt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32385);
                throw bVar2;
            }
            AppMethodBeat.o(32385);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfp dfp = (dfp) objArr[1];
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
                        dfp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32385);
                    return 0;
                case 2:
                    dfp.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32385);
                    return 0;
                case 3:
                    dfp.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32385);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dfe dfe = new dfe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dfe.populateBuilderWithField(aVar5, dfe, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dfp.KMD.add(dfe);
                    }
                    AppMethodBeat.o(32385);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dfe dfe2 = new dfe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dfe2.populateBuilderWithField(aVar6, dfe2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dfp.MKt.add(dfe2);
                    }
                    AppMethodBeat.o(32385);
                    return 0;
                default:
                    AppMethodBeat.o(32385);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32385);
            return -1;
        }
    }
}

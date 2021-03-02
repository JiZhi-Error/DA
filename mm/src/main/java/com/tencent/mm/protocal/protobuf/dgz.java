package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dgz extends dpc {
    public String HTZ;
    public ddb KPx;
    public String MLv;
    public LinkedList<je> MLw = new LinkedList<>();
    public int pTZ;
    public String pUa;

    public dgz() {
        AppMethodBeat.i(72553);
        AppMethodBeat.o(72553);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72554);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72554);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            if (this.MLv != null) {
                aVar.e(4, this.MLv);
            }
            aVar.e(5, 8, this.MLw);
            if (this.KPx != null) {
                aVar.ni(6, this.KPx.computeSize());
                this.KPx.writeFields(aVar);
            }
            if (this.HTZ != null) {
                aVar.e(7, this.HTZ);
            }
            AppMethodBeat.o(72554);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MLv != null) {
                nh += g.a.a.b.b.a.f(4, this.MLv);
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.MLw);
            if (this.KPx != null) {
                c2 += g.a.a.a.nh(6, this.KPx.computeSize());
            }
            if (this.HTZ != null) {
                c2 += g.a.a.b.b.a.f(7, this.HTZ);
            }
            AppMethodBeat.o(72554);
            return c2;
        } else if (i2 == 2) {
            this.MLw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72554);
                throw bVar2;
            }
            AppMethodBeat.o(72554);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgz dgz = (dgz) objArr[1];
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
                        dgz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72554);
                    return 0;
                case 2:
                    dgz.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72554);
                    return 0;
                case 3:
                    dgz.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72554);
                    return 0;
                case 4:
                    dgz.MLv = aVar3.UbS.readString();
                    AppMethodBeat.o(72554);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        je jeVar = new je();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jeVar.populateBuilderWithField(aVar5, jeVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dgz.MLw.add(jeVar);
                    }
                    AppMethodBeat.o(72554);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ddb ddb = new ddb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ddb.populateBuilderWithField(aVar6, ddb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dgz.KPx = ddb;
                    }
                    AppMethodBeat.o(72554);
                    return 0;
                case 7:
                    dgz.HTZ = aVar3.UbS.readString();
                    AppMethodBeat.o(72554);
                    return 0;
                default:
                    AppMethodBeat.o(72554);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72554);
            return -1;
        }
    }
}

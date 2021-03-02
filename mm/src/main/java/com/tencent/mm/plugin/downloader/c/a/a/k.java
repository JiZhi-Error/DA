package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class k extends dpc {
    public int pTZ;
    public d qFW;
    public int qGa;
    public String qGb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153053);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153053);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.qFW != null) {
                aVar.ni(2, this.qFW.computeSize());
                this.qFW.writeFields(aVar);
            }
            aVar.aM(3, this.pTZ);
            aVar.aM(4, this.qGa);
            if (this.qGb != null) {
                aVar.e(5, this.qGb);
            }
            AppMethodBeat.o(153053);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.qFW != null) {
                nh += g.a.a.a.nh(2, this.qFW.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.pTZ) + g.a.a.b.b.a.bu(4, this.qGa);
            if (this.qGb != null) {
                bu += g.a.a.b.b.a.f(5, this.qGb);
            }
            AppMethodBeat.o(153053);
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
                AppMethodBeat.o(153053);
                throw bVar2;
            }
            AppMethodBeat.o(153053);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
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
                        kVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(153053);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        d dVar = new d();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dVar.populateBuilderWithField(aVar5, dVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        kVar.qFW = dVar;
                    }
                    AppMethodBeat.o(153053);
                    return 0;
                case 3:
                    kVar.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(153053);
                    return 0;
                case 4:
                    kVar.qGa = aVar3.UbS.zi();
                    AppMethodBeat.o(153053);
                    return 0;
                case 5:
                    kVar.qGb = aVar3.UbS.readString();
                    AppMethodBeat.o(153053);
                    return 0;
                default:
                    AppMethodBeat.o(153053);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153053);
            return -1;
        }
    }
}

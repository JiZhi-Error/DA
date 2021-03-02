package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dri extends dpc {
    public String KJw;

    /* renamed from: MTT  reason: collision with root package name */
    public String f1528MTT;
    public String MTV;
    public String MTW;
    public b MTX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82472);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82472);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KJw != null) {
                aVar.e(3, this.KJw);
            }
            if (this.f1528MTT != null) {
                aVar.e(4, this.f1528MTT);
            }
            if (this.MTV != null) {
                aVar.e(5, this.MTV);
            }
            if (this.MTW != null) {
                aVar.e(6, this.MTW);
            }
            if (this.MTX != null) {
                aVar.c(7, this.MTX);
            }
            AppMethodBeat.o(82472);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KJw != null) {
                nh += g.a.a.b.b.a.f(3, this.KJw);
            }
            if (this.f1528MTT != null) {
                nh += g.a.a.b.b.a.f(4, this.f1528MTT);
            }
            if (this.MTV != null) {
                nh += g.a.a.b.b.a.f(5, this.MTV);
            }
            if (this.MTW != null) {
                nh += g.a.a.b.b.a.f(6, this.MTW);
            }
            if (this.MTX != null) {
                nh += g.a.a.b.b.a.b(7, this.MTX);
            }
            AppMethodBeat.o(82472);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82472);
                throw bVar2;
            }
            AppMethodBeat.o(82472);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dri dri = (dri) objArr[1];
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
                        dri.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82472);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(82472);
                    return -1;
                case 3:
                    dri.KJw = aVar3.UbS.readString();
                    AppMethodBeat.o(82472);
                    return 0;
                case 4:
                    dri.f1528MTT = aVar3.UbS.readString();
                    AppMethodBeat.o(82472);
                    return 0;
                case 5:
                    dri.MTV = aVar3.UbS.readString();
                    AppMethodBeat.o(82472);
                    return 0;
                case 6:
                    dri.MTW = aVar3.UbS.readString();
                    AppMethodBeat.o(82472);
                    return 0;
                case 7:
                    dri.MTX = aVar3.UbS.hPo();
                    AppMethodBeat.o(82472);
                    return 0;
            }
        } else {
            AppMethodBeat.o(82472);
            return -1;
        }
    }
}

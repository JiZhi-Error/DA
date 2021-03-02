package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class djm extends dpc {
    public int MNG;
    public int MNH;
    public String MNI;
    public djj MNs;
    public String rJH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32404);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MNs == null) {
                b bVar = new b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.o(32404);
                throw bVar;
            } else if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32404);
                throw bVar2;
            } else {
                if (this.MNs != null) {
                    aVar.ni(1, this.MNs.computeSize());
                    this.MNs.writeFields(aVar);
                }
                aVar.aM(2, this.MNG);
                if (this.BaseResponse != null) {
                    aVar.ni(3, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.rJH != null) {
                    aVar.e(4, this.rJH);
                }
                aVar.aM(5, this.MNH);
                if (this.MNI != null) {
                    aVar.e(6, this.MNI);
                }
                AppMethodBeat.o(32404);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.MNs != null ? g.a.a.a.nh(1, this.MNs.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MNG);
            if (this.BaseResponse != null) {
                nh += g.a.a.a.nh(3, this.BaseResponse.computeSize());
            }
            if (this.rJH != null) {
                nh += g.a.a.b.b.a.f(4, this.rJH);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MNH);
            if (this.MNI != null) {
                bu += g.a.a.b.b.a.f(6, this.MNI);
            }
            AppMethodBeat.o(32404);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MNs == null) {
                b bVar3 = new b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.o(32404);
                throw bVar3;
            } else if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32404);
                throw bVar4;
            } else {
                AppMethodBeat.o(32404);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djm djm = (djm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        djj djj = new djj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = djj.populateBuilderWithField(aVar4, djj, dpc.getNextFieldNumber(aVar4))) {
                        }
                        djm.MNs = djj;
                    }
                    AppMethodBeat.o(32404);
                    return 0;
                case 2:
                    djm.MNG = aVar3.UbS.zi();
                    AppMethodBeat.o(32404);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = baseResponse.populateBuilderWithField(aVar5, baseResponse, dpc.getNextFieldNumber(aVar5))) {
                        }
                        djm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32404);
                    return 0;
                case 4:
                    djm.rJH = aVar3.UbS.readString();
                    AppMethodBeat.o(32404);
                    return 0;
                case 5:
                    djm.MNH = aVar3.UbS.zi();
                    AppMethodBeat.o(32404);
                    return 0;
                case 6:
                    djm.MNI = aVar3.UbS.readString();
                    AppMethodBeat.o(32404);
                    return 0;
                default:
                    AppMethodBeat.o(32404);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32404);
            return -1;
        }
    }
}

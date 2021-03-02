package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ett extends dpc {
    public int CreateTime;
    public int LsZ;
    public long Lta;
    public int NqJ;
    public String NqS;
    public LinkedList<euv> NqT = new LinkedList<>();
    public int gsq;

    public ett() {
        AppMethodBeat.i(115879);
        AppMethodBeat.o(115879);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115880);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115880);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.CreateTime);
            aVar.aM(6, this.gsq);
            aVar.e(7, 8, this.NqT);
            if (this.NqS != null) {
                aVar.e(8, this.NqS);
            }
            aVar.aM(9, this.NqJ);
            AppMethodBeat.o(115880);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(6, this.gsq) + g.a.a.a.c(7, 8, this.NqT);
            if (this.NqS != null) {
                nh += g.a.a.b.b.a.f(8, this.NqS);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.NqJ);
            AppMethodBeat.o(115880);
            return bu;
        } else if (i2 == 2) {
            this.NqT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115880);
                throw bVar2;
            }
            AppMethodBeat.o(115880);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ett ett = (ett) objArr[1];
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
                        ett.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115880);
                    return 0;
                case 2:
                    ett.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115880);
                    return 0;
                case 3:
                    ett.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115880);
                    return 0;
                case 4:
                    ett.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(115880);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(115880);
                    return -1;
                case 6:
                    ett.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(115880);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        euv euv = new euv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = euv.populateBuilderWithField(aVar5, euv, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ett.NqT.add(euv);
                    }
                    AppMethodBeat.o(115880);
                    return 0;
                case 8:
                    ett.NqS = aVar3.UbS.readString();
                    AppMethodBeat.o(115880);
                    return 0;
                case 9:
                    ett.NqJ = aVar3.UbS.zi();
                    AppMethodBeat.o(115880);
                    return 0;
            }
        } else {
            AppMethodBeat.o(115880);
            return -1;
        }
    }
}

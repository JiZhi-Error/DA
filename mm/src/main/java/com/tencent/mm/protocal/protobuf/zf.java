package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class zf extends dpc {
    public String HQm;
    public String KxE;
    public dal Lkx;
    public boolean Lky;
    public int rBL;
    public String rBM;
    public String scene;
    public String session_id;
    public String token;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91417);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91417);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.rBL);
            if (this.rBM != null) {
                aVar.e(3, this.rBM);
            }
            if (this.token != null) {
                aVar.e(4, this.token);
            }
            if (this.Lkx != null) {
                aVar.ni(5, this.Lkx.computeSize());
                this.Lkx.writeFields(aVar);
            }
            if (this.KxE != null) {
                aVar.e(6, this.KxE);
            }
            aVar.cc(7, this.Lky);
            if (this.HQm != null) {
                aVar.e(8, this.HQm);
            }
            if (this.session_id != null) {
                aVar.e(9, this.session_id);
            }
            if (this.scene != null) {
                aVar.e(10, this.scene);
            }
            AppMethodBeat.o(91417);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBL);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            if (this.token != null) {
                nh += g.a.a.b.b.a.f(4, this.token);
            }
            if (this.Lkx != null) {
                nh += g.a.a.a.nh(5, this.Lkx.computeSize());
            }
            if (this.KxE != null) {
                nh += g.a.a.b.b.a.f(6, this.KxE);
            }
            int fS = nh + g.a.a.b.b.a.fS(7) + 1;
            if (this.HQm != null) {
                fS += g.a.a.b.b.a.f(8, this.HQm);
            }
            if (this.session_id != null) {
                fS += g.a.a.b.b.a.f(9, this.session_id);
            }
            if (this.scene != null) {
                fS += g.a.a.b.b.a.f(10, this.scene);
            }
            AppMethodBeat.o(91417);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91417);
                throw bVar2;
            }
            AppMethodBeat.o(91417);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zf zfVar = (zf) objArr[1];
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
                        zfVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91417);
                    return 0;
                case 2:
                    zfVar.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(91417);
                    return 0;
                case 3:
                    zfVar.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                case 4:
                    zfVar.token = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dal dal = new dal();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dal.populateBuilderWithField(aVar5, dal, dpc.getNextFieldNumber(aVar5))) {
                        }
                        zfVar.Lkx = dal;
                    }
                    AppMethodBeat.o(91417);
                    return 0;
                case 6:
                    zfVar.KxE = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                case 7:
                    zfVar.Lky = aVar3.UbS.yZ();
                    AppMethodBeat.o(91417);
                    return 0;
                case 8:
                    zfVar.HQm = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                case 9:
                    zfVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                case 10:
                    zfVar.scene = aVar3.UbS.readString();
                    AppMethodBeat.o(91417);
                    return 0;
                default:
                    AppMethodBeat.o(91417);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91417);
            return -1;
        }
    }
}

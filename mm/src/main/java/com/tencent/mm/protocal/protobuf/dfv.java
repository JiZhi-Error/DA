package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfv extends dpc {
    public int LsZ;
    public long Lta;
    public int MKD;
    public int MKF;
    public int MKG;
    public int rBL;
    public String rBM;
    public int ypM;
    public String ypN;
    public int yqb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32391);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32391);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(3, this.LsZ);
            aVar.bb(4, this.Lta);
            aVar.aM(5, this.MKF);
            aVar.aM(6, this.MKD);
            aVar.aM(7, this.yqb);
            aVar.aM(8, this.MKG);
            aVar.aM(9, this.rBL);
            if (this.rBM != null) {
                aVar.e(10, this.rBM);
            }
            aVar.aM(11, this.ypM);
            if (this.ypN != null) {
                aVar.e(12, this.ypN);
            }
            AppMethodBeat.o(32391);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta) + g.a.a.b.b.a.bu(5, this.MKF) + g.a.a.b.b.a.bu(6, this.MKD) + g.a.a.b.b.a.bu(7, this.yqb) + g.a.a.b.b.a.bu(8, this.MKG) + g.a.a.b.b.a.bu(9, this.rBL);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(10, this.rBM);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.ypM);
            if (this.ypN != null) {
                bu += g.a.a.b.b.a.f(12, this.ypN);
            }
            AppMethodBeat.o(32391);
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
                AppMethodBeat.o(32391);
                throw bVar2;
            }
            AppMethodBeat.o(32391);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfv dfv = (dfv) objArr[1];
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
                        dfv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32391);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(32391);
                    return -1;
                case 3:
                    dfv.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 4:
                    dfv.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32391);
                    return 0;
                case 5:
                    dfv.MKF = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 6:
                    dfv.MKD = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 7:
                    dfv.yqb = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 8:
                    dfv.MKG = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 9:
                    dfv.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 10:
                    dfv.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(32391);
                    return 0;
                case 11:
                    dfv.ypM = aVar3.UbS.zi();
                    AppMethodBeat.o(32391);
                    return 0;
                case 12:
                    dfv.ypN = aVar3.UbS.readString();
                    AppMethodBeat.o(32391);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32391);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dab extends dpc {
    public String LQv;
    public String LQw;
    public String MFk;
    public int rBL;
    public String rBM;
    public String xIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91584);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91584);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LQv != null) {
                aVar.e(2, this.LQv);
            }
            if (this.xIy != null) {
                aVar.e(3, this.xIy);
            }
            if (this.LQw != null) {
                aVar.e(4, this.LQw);
            }
            aVar.aM(5, this.rBL);
            if (this.rBM != null) {
                aVar.e(6, this.rBM);
            }
            if (this.MFk != null) {
                aVar.e(7, this.MFk);
            }
            AppMethodBeat.o(91584);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LQv != null) {
                nh += g.a.a.b.b.a.f(2, this.LQv);
            }
            if (this.xIy != null) {
                nh += g.a.a.b.b.a.f(3, this.xIy);
            }
            if (this.LQw != null) {
                nh += g.a.a.b.b.a.f(4, this.LQw);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.rBL);
            if (this.rBM != null) {
                bu += g.a.a.b.b.a.f(6, this.rBM);
            }
            if (this.MFk != null) {
                bu += g.a.a.b.b.a.f(7, this.MFk);
            }
            AppMethodBeat.o(91584);
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
                AppMethodBeat.o(91584);
                throw bVar2;
            }
            AppMethodBeat.o(91584);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dab dab = (dab) objArr[1];
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
                        dab.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91584);
                    return 0;
                case 2:
                    dab.LQv = aVar3.UbS.readString();
                    AppMethodBeat.o(91584);
                    return 0;
                case 3:
                    dab.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(91584);
                    return 0;
                case 4:
                    dab.LQw = aVar3.UbS.readString();
                    AppMethodBeat.o(91584);
                    return 0;
                case 5:
                    dab.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(91584);
                    return 0;
                case 6:
                    dab.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91584);
                    return 0;
                case 7:
                    dab.MFk = aVar3.UbS.readString();
                    AppMethodBeat.o(91584);
                    return 0;
                default:
                    AppMethodBeat.o(91584);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91584);
            return -1;
        }
    }
}
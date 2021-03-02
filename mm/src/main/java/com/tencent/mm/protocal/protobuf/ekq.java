package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekq extends dpc {
    public String KJw;
    public String MFi;
    public String MOB;
    public int MeU;
    public String NjQ;
    public String NjR;
    public dxw NjS;
    public String NjT;
    public b NjU;
    public int dIZ;
    public String dJa;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152714);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152714);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dIZ);
            if (this.dJa != null) {
                aVar.e(3, this.dJa);
            }
            if (this.NjQ != null) {
                aVar.e(4, this.NjQ);
            }
            if (this.NjR != null) {
                aVar.e(5, this.NjR);
            }
            if (this.NjS != null) {
                aVar.ni(6, this.NjS.computeSize());
                this.NjS.writeFields(aVar);
            }
            aVar.aM(7, this.version);
            if (this.NjT != null) {
                aVar.e(8, this.NjT);
            }
            aVar.aM(9, this.MeU);
            if (this.MFi != null) {
                aVar.e(10, this.MFi);
            }
            if (this.MOB != null) {
                aVar.e(11, this.MOB);
            }
            if (this.KJw != null) {
                aVar.e(12, this.KJw);
            }
            if (this.NjU != null) {
                aVar.c(13, this.NjU);
            }
            AppMethodBeat.o(152714);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dIZ);
            if (this.dJa != null) {
                nh += g.a.a.b.b.a.f(3, this.dJa);
            }
            if (this.NjQ != null) {
                nh += g.a.a.b.b.a.f(4, this.NjQ);
            }
            if (this.NjR != null) {
                nh += g.a.a.b.b.a.f(5, this.NjR);
            }
            if (this.NjS != null) {
                nh += g.a.a.a.nh(6, this.NjS.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.version);
            if (this.NjT != null) {
                bu += g.a.a.b.b.a.f(8, this.NjT);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MeU);
            if (this.MFi != null) {
                bu2 += g.a.a.b.b.a.f(10, this.MFi);
            }
            if (this.MOB != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MOB);
            }
            if (this.KJw != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KJw);
            }
            if (this.NjU != null) {
                bu2 += g.a.a.b.b.a.b(13, this.NjU);
            }
            AppMethodBeat.o(152714);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152714);
                throw bVar2;
            }
            AppMethodBeat.o(152714);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekq ekq = (ekq) objArr[1];
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
                        ekq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152714);
                    return 0;
                case 2:
                    ekq.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152714);
                    return 0;
                case 3:
                    ekq.dJa = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 4:
                    ekq.NjQ = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 5:
                    ekq.NjR = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dxw dxw = new dxw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dxw.populateBuilderWithField(aVar5, dxw, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ekq.NjS = dxw;
                    }
                    AppMethodBeat.o(152714);
                    return 0;
                case 7:
                    ekq.version = aVar3.UbS.zi();
                    AppMethodBeat.o(152714);
                    return 0;
                case 8:
                    ekq.NjT = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 9:
                    ekq.MeU = aVar3.UbS.zi();
                    AppMethodBeat.o(152714);
                    return 0;
                case 10:
                    ekq.MFi = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 11:
                    ekq.MOB = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 12:
                    ekq.KJw = aVar3.UbS.readString();
                    AppMethodBeat.o(152714);
                    return 0;
                case 13:
                    ekq.NjU = aVar3.UbS.hPo();
                    AppMethodBeat.o(152714);
                    return 0;
                default:
                    AppMethodBeat.o(152714);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152714);
            return -1;
        }
    }
}

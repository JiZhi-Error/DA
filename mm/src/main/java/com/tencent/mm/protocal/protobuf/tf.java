package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class tf extends dpc {
    public long Brn;
    public int CreateTime;
    public String KHq;
    public String KMl;
    public String LbJ;
    public int LbO;
    public String Lby;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152512);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152512);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Lby != null) {
                aVar.e(3, this.Lby);
            }
            if (this.xNH != null) {
                aVar.e(4, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(5, this.xNG);
            }
            aVar.aM(9, this.CreateTime);
            aVar.bb(10, this.Brn);
            if (this.LbJ != null) {
                aVar.e(11, this.LbJ);
            }
            if (this.KMl != null) {
                aVar.e(12, this.KMl);
            }
            if (this.KHq != null) {
                aVar.e(13, this.KHq);
            }
            aVar.aM(14, this.LbO);
            AppMethodBeat.o(152512);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Lby != null) {
                nh += g.a.a.b.b.a.f(3, this.Lby);
            }
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(4, this.xNH);
            }
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(5, this.xNG);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.CreateTime) + g.a.a.b.b.a.r(10, this.Brn);
            if (this.LbJ != null) {
                bu += g.a.a.b.b.a.f(11, this.LbJ);
            }
            if (this.KMl != null) {
                bu += g.a.a.b.b.a.f(12, this.KMl);
            }
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(13, this.KHq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.LbO);
            AppMethodBeat.o(152512);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152512);
                throw bVar2;
            }
            AppMethodBeat.o(152512);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tf tfVar = (tf) objArr[1];
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
                        tfVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152512);
                    return 0;
                case 2:
                case 6:
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(152512);
                    return -1;
                case 3:
                    tfVar.Lby = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 4:
                    tfVar.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 5:
                    tfVar.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 9:
                    tfVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(152512);
                    return 0;
                case 10:
                    tfVar.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(152512);
                    return 0;
                case 11:
                    tfVar.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 12:
                    tfVar.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 13:
                    tfVar.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(152512);
                    return 0;
                case 14:
                    tfVar.LbO = aVar3.UbS.zi();
                    AppMethodBeat.o(152512);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152512);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yp extends dpc {
    public long LjE;
    public long LjF;
    public String LjG;
    public String LjH;
    public int pTZ;
    public String pUa;
    public String qGB;
    public String yPK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72458);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72458);
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
            aVar.bb(4, this.LjE);
            aVar.bb(5, this.LjF);
            if (this.LjG != null) {
                aVar.e(6, this.LjG);
            }
            if (this.LjH != null) {
                aVar.e(7, this.LjH);
            }
            if (this.yPK != null) {
                aVar.e(8, this.yPK);
            }
            if (this.qGB != null) {
                aVar.e(9, this.qGB);
            }
            AppMethodBeat.o(72458);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.LjE) + g.a.a.b.b.a.r(5, this.LjF);
            if (this.LjG != null) {
                r += g.a.a.b.b.a.f(6, this.LjG);
            }
            if (this.LjH != null) {
                r += g.a.a.b.b.a.f(7, this.LjH);
            }
            if (this.yPK != null) {
                r += g.a.a.b.b.a.f(8, this.yPK);
            }
            if (this.qGB != null) {
                r += g.a.a.b.b.a.f(9, this.qGB);
            }
            AppMethodBeat.o(72458);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72458);
                throw bVar2;
            }
            AppMethodBeat.o(72458);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yp ypVar = (yp) objArr[1];
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
                        ypVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72458);
                    return 0;
                case 2:
                    ypVar.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72458);
                    return 0;
                case 3:
                    ypVar.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72458);
                    return 0;
                case 4:
                    ypVar.LjE = aVar3.UbS.zl();
                    AppMethodBeat.o(72458);
                    return 0;
                case 5:
                    ypVar.LjF = aVar3.UbS.zl();
                    AppMethodBeat.o(72458);
                    return 0;
                case 6:
                    ypVar.LjG = aVar3.UbS.readString();
                    AppMethodBeat.o(72458);
                    return 0;
                case 7:
                    ypVar.LjH = aVar3.UbS.readString();
                    AppMethodBeat.o(72458);
                    return 0;
                case 8:
                    ypVar.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(72458);
                    return 0;
                case 9:
                    ypVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(72458);
                    return 0;
                default:
                    AppMethodBeat.o(72458);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72458);
            return -1;
        }
    }
}

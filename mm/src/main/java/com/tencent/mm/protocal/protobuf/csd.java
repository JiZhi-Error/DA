package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class csd extends dpc {
    public String LIh;
    public String LIi;
    public String Mxl;
    public String Mxm;
    public String Mxn;
    public long Vka;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256717);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LIh != null) {
                aVar.e(2, this.LIh);
            }
            if (this.Mxl != null) {
                aVar.e(3, this.Mxl);
            }
            if (this.Mxm != null) {
                aVar.e(4, this.Mxm);
            }
            if (this.LIi != null) {
                aVar.e(5, this.LIi);
            }
            if (this.Mxn != null) {
                aVar.e(6, this.Mxn);
            }
            aVar.bb(7, this.Vka);
            AppMethodBeat.o(256717);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LIh != null) {
                nh += g.a.a.b.b.a.f(2, this.LIh);
            }
            if (this.Mxl != null) {
                nh += g.a.a.b.b.a.f(3, this.Mxl);
            }
            if (this.Mxm != null) {
                nh += g.a.a.b.b.a.f(4, this.Mxm);
            }
            if (this.LIi != null) {
                nh += g.a.a.b.b.a.f(5, this.LIi);
            }
            if (this.Mxn != null) {
                nh += g.a.a.b.b.a.f(6, this.Mxn);
            }
            int r = nh + g.a.a.b.b.a.r(7, this.Vka);
            AppMethodBeat.o(256717);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256717);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csd csd = (csd) objArr[1];
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
                        csd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(256717);
                    return 0;
                case 2:
                    csd.LIh = aVar3.UbS.readString();
                    AppMethodBeat.o(256717);
                    return 0;
                case 3:
                    csd.Mxl = aVar3.UbS.readString();
                    AppMethodBeat.o(256717);
                    return 0;
                case 4:
                    csd.Mxm = aVar3.UbS.readString();
                    AppMethodBeat.o(256717);
                    return 0;
                case 5:
                    csd.LIi = aVar3.UbS.readString();
                    AppMethodBeat.o(256717);
                    return 0;
                case 6:
                    csd.Mxn = aVar3.UbS.readString();
                    AppMethodBeat.o(256717);
                    return 0;
                case 7:
                    csd.Vka = aVar3.UbS.zl();
                    AppMethodBeat.o(256717);
                    return 0;
                default:
                    AppMethodBeat.o(256717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256717);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dyu extends dpc {
    public String MYh;
    public String MYi;
    public String MYj;
    public int MYt;
    public int MYu;
    public int MYv;
    public b MYw;
    public String Mbb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117928);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MYh != null) {
                aVar.e(2, this.MYh);
            }
            aVar.aM(3, this.MYt);
            aVar.aM(4, this.MYu);
            if (this.MYi != null) {
                aVar.e(5, this.MYi);
            }
            if (this.MYj != null) {
                aVar.e(6, this.MYj);
            }
            aVar.aM(7, this.MYv);
            if (this.Mbb != null) {
                aVar.e(8, this.Mbb);
            }
            if (this.MYw != null) {
                aVar.c(9, this.MYw);
            }
            AppMethodBeat.o(117928);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MYh != null) {
                nh += g.a.a.b.b.a.f(2, this.MYh);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MYt) + g.a.a.b.b.a.bu(4, this.MYu);
            if (this.MYi != null) {
                bu += g.a.a.b.b.a.f(5, this.MYi);
            }
            if (this.MYj != null) {
                bu += g.a.a.b.b.a.f(6, this.MYj);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MYv);
            if (this.Mbb != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Mbb);
            }
            if (this.MYw != null) {
                bu2 += g.a.a.b.b.a.b(9, this.MYw);
            }
            AppMethodBeat.o(117928);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117928);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyu dyu = (dyu) objArr[1];
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
                        dyu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117928);
                    return 0;
                case 2:
                    dyu.MYh = aVar3.UbS.readString();
                    AppMethodBeat.o(117928);
                    return 0;
                case 3:
                    dyu.MYt = aVar3.UbS.zi();
                    AppMethodBeat.o(117928);
                    return 0;
                case 4:
                    dyu.MYu = aVar3.UbS.zi();
                    AppMethodBeat.o(117928);
                    return 0;
                case 5:
                    dyu.MYi = aVar3.UbS.readString();
                    AppMethodBeat.o(117928);
                    return 0;
                case 6:
                    dyu.MYj = aVar3.UbS.readString();
                    AppMethodBeat.o(117928);
                    return 0;
                case 7:
                    dyu.MYv = aVar3.UbS.zi();
                    AppMethodBeat.o(117928);
                    return 0;
                case 8:
                    dyu.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117928);
                    return 0;
                case 9:
                    dyu.MYw = aVar3.UbS.hPo();
                    AppMethodBeat.o(117928);
                    return 0;
                default:
                    AppMethodBeat.o(117928);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117928);
            return -1;
        }
    }
}

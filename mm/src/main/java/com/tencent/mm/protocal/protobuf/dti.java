package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dti extends dpc {
    public int Brl;
    public long Brn;
    public int CreateTime;
    public String KIz;
    public String LbJ;
    public int LbO;
    public String jfi;
    public int oUv;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32427);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32427);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.xNH != null) {
                aVar.e(3, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(4, this.xNG);
            }
            aVar.aM(5, this.Brl);
            if (this.KIz != null) {
                aVar.e(6, this.KIz);
            }
            aVar.aM(7, this.CreateTime);
            aVar.aM(8, this.oUv);
            aVar.bb(9, this.Brn);
            if (this.LbJ != null) {
                aVar.e(10, this.LbJ);
            }
            aVar.aM(12, this.LbO);
            AppMethodBeat.o(32427);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(3, this.xNH);
            }
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(4, this.xNG);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Brl);
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(6, this.KIz);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.CreateTime) + g.a.a.b.b.a.bu(8, this.oUv) + g.a.a.b.b.a.r(9, this.Brn);
            if (this.LbJ != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LbJ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.LbO);
            AppMethodBeat.o(32427);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32427);
                throw bVar2;
            }
            AppMethodBeat.o(32427);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dti dti = (dti) objArr[1];
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
                        dti.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32427);
                    return 0;
                case 2:
                    dti.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(32427);
                    return 0;
                case 3:
                    dti.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32427);
                    return 0;
                case 4:
                    dti.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32427);
                    return 0;
                case 5:
                    dti.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(32427);
                    return 0;
                case 6:
                    dti.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(32427);
                    return 0;
                case 7:
                    dti.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(32427);
                    return 0;
                case 8:
                    dti.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32427);
                    return 0;
                case 9:
                    dti.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(32427);
                    return 0;
                case 10:
                    dti.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32427);
                    return 0;
                case 11:
                default:
                    AppMethodBeat.o(32427);
                    return -1;
                case 12:
                    dti.LbO = aVar3.UbS.zi();
                    AppMethodBeat.o(32427);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32427);
            return -1;
        }
    }
}

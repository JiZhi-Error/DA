package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cvp extends dpc {
    public String KPw;
    public ddb KPx;
    public cxc KPy;
    public String MAO;
    public String MAW;
    public cdf MAY;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72531);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72531);
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
            if (this.MAO != null) {
                aVar.e(4, this.MAO);
            }
            if (this.KPw != null) {
                aVar.e(5, this.KPw);
            }
            if (this.MAW != null) {
                aVar.e(6, this.MAW);
            }
            if (this.KPx != null) {
                aVar.ni(7, this.KPx.computeSize());
                this.KPx.writeFields(aVar);
            }
            if (this.KPy != null) {
                aVar.ni(8, this.KPy.computeSize());
                this.KPy.writeFields(aVar);
            }
            if (this.MAY != null) {
                aVar.ni(9, this.MAY.computeSize());
                this.MAY.writeFields(aVar);
            }
            AppMethodBeat.o(72531);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MAO != null) {
                nh += g.a.a.b.b.a.f(4, this.MAO);
            }
            if (this.KPw != null) {
                nh += g.a.a.b.b.a.f(5, this.KPw);
            }
            if (this.MAW != null) {
                nh += g.a.a.b.b.a.f(6, this.MAW);
            }
            if (this.KPx != null) {
                nh += g.a.a.a.nh(7, this.KPx.computeSize());
            }
            if (this.KPy != null) {
                nh += g.a.a.a.nh(8, this.KPy.computeSize());
            }
            if (this.MAY != null) {
                nh += g.a.a.a.nh(9, this.MAY.computeSize());
            }
            AppMethodBeat.o(72531);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72531);
                throw bVar2;
            }
            AppMethodBeat.o(72531);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvp cvp = (cvp) objArr[1];
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
                        cvp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72531);
                    return 0;
                case 2:
                    cvp.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72531);
                    return 0;
                case 3:
                    cvp.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72531);
                    return 0;
                case 4:
                    cvp.MAO = aVar3.UbS.readString();
                    AppMethodBeat.o(72531);
                    return 0;
                case 5:
                    cvp.KPw = aVar3.UbS.readString();
                    AppMethodBeat.o(72531);
                    return 0;
                case 6:
                    cvp.MAW = aVar3.UbS.readString();
                    AppMethodBeat.o(72531);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ddb ddb = new ddb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ddb.populateBuilderWithField(aVar5, ddb, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cvp.KPx = ddb;
                    }
                    AppMethodBeat.o(72531);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cxc cxc = new cxc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cxc.populateBuilderWithField(aVar6, cxc, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cvp.KPy = cxc;
                    }
                    AppMethodBeat.o(72531);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cdf cdf = new cdf();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cdf.populateBuilderWithField(aVar7, cdf, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cvp.MAY = cdf;
                    }
                    AppMethodBeat.o(72531);
                    return 0;
                default:
                    AppMethodBeat.o(72531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72531);
            return -1;
        }
    }
}

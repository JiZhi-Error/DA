package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class cet extends dpc {
    public String KCL;
    public String KCy;
    public String KFs;
    public LinkedList<drb> LRN = new LinkedList<>();
    public cdz Mkb;
    public String Mkl;
    public String Mkm;
    public String Mkn;
    public int Mko;
    public String keb;
    public String xMq;

    public cet() {
        AppMethodBeat.i(123616);
        AppMethodBeat.o(123616);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123617);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123617);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mkb != null) {
                aVar.ni(2, this.Mkb.computeSize());
                this.Mkb.writeFields(aVar);
            }
            if (this.Mkm != null) {
                aVar.e(3, this.Mkm);
            }
            aVar.e(4, 8, this.LRN);
            if (this.xMq != null) {
                aVar.e(5, this.xMq);
            }
            if (this.KFs != null) {
                aVar.e(6, this.KFs);
            }
            if (this.KCL != null) {
                aVar.e(7, this.KCL);
            }
            if (this.KCy != null) {
                aVar.e(8, this.KCy);
            }
            if (this.Mkn != null) {
                aVar.e(9, this.Mkn);
            }
            aVar.aM(10, this.Mko);
            if (this.Mkl != null) {
                aVar.e(11, this.Mkl);
            }
            if (this.keb != null) {
                aVar.e(12, this.keb);
            }
            AppMethodBeat.o(123617);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mkb != null) {
                nh += g.a.a.a.nh(2, this.Mkb.computeSize());
            }
            if (this.Mkm != null) {
                nh += g.a.a.b.b.a.f(3, this.Mkm);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LRN);
            if (this.xMq != null) {
                c2 += g.a.a.b.b.a.f(5, this.xMq);
            }
            if (this.KFs != null) {
                c2 += g.a.a.b.b.a.f(6, this.KFs);
            }
            if (this.KCL != null) {
                c2 += g.a.a.b.b.a.f(7, this.KCL);
            }
            if (this.KCy != null) {
                c2 += g.a.a.b.b.a.f(8, this.KCy);
            }
            if (this.Mkn != null) {
                c2 += g.a.a.b.b.a.f(9, this.Mkn);
            }
            int bu = c2 + g.a.a.b.b.a.bu(10, this.Mko);
            if (this.Mkl != null) {
                bu += g.a.a.b.b.a.f(11, this.Mkl);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(12, this.keb);
            }
            AppMethodBeat.o(123617);
            return bu;
        } else if (i2 == 2) {
            this.LRN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123617);
                throw bVar2;
            }
            AppMethodBeat.o(123617);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cet cet = (cet) objArr[1];
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
                        cet.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123617);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdz cdz = new cdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdz.populateBuilderWithField(aVar5, cdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cet.Mkb = cdz;
                    }
                    AppMethodBeat.o(123617);
                    return 0;
                case 3:
                    cet.Mkm = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        drb drb = new drb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = drb.populateBuilderWithField(aVar6, drb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cet.LRN.add(drb);
                    }
                    AppMethodBeat.o(123617);
                    return 0;
                case 5:
                    cet.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 6:
                    cet.KFs = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 7:
                    cet.KCL = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 8:
                    cet.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 9:
                    cet.Mkn = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 10:
                    cet.Mko = aVar3.UbS.zi();
                    AppMethodBeat.o(123617);
                    return 0;
                case 11:
                    cet.Mkl = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                case 12:
                    cet.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(123617);
                    return 0;
                default:
                    AppMethodBeat.o(123617);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123617);
            return -1;
        }
    }
}

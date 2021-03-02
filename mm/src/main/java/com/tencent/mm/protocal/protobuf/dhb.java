package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhb extends dpc {
    public String ANo;
    public ti MLA;
    public String MLB;
    public String MLC;
    public ejh MLD;
    public String MLy;
    public String MLz;
    public String dDj;
    public String iwv;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72556);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72556);
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
            if (this.MLy != null) {
                aVar.e(4, this.MLy);
            }
            if (this.iwv != null) {
                aVar.e(5, this.iwv);
            }
            if (this.MLz != null) {
                aVar.e(6, this.MLz);
            }
            if (this.MLA != null) {
                aVar.ni(7, this.MLA.computeSize());
                this.MLA.writeFields(aVar);
            }
            if (this.MLB != null) {
                aVar.e(8, this.MLB);
            }
            if (this.ANo != null) {
                aVar.e(9, this.ANo);
            }
            if (this.dDj != null) {
                aVar.e(10, this.dDj);
            }
            if (this.MLC != null) {
                aVar.e(11, this.MLC);
            }
            if (this.MLD != null) {
                aVar.ni(12, this.MLD.computeSize());
                this.MLD.writeFields(aVar);
            }
            AppMethodBeat.o(72556);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MLy != null) {
                nh += g.a.a.b.b.a.f(4, this.MLy);
            }
            if (this.iwv != null) {
                nh += g.a.a.b.b.a.f(5, this.iwv);
            }
            if (this.MLz != null) {
                nh += g.a.a.b.b.a.f(6, this.MLz);
            }
            if (this.MLA != null) {
                nh += g.a.a.a.nh(7, this.MLA.computeSize());
            }
            if (this.MLB != null) {
                nh += g.a.a.b.b.a.f(8, this.MLB);
            }
            if (this.ANo != null) {
                nh += g.a.a.b.b.a.f(9, this.ANo);
            }
            if (this.dDj != null) {
                nh += g.a.a.b.b.a.f(10, this.dDj);
            }
            if (this.MLC != null) {
                nh += g.a.a.b.b.a.f(11, this.MLC);
            }
            if (this.MLD != null) {
                nh += g.a.a.a.nh(12, this.MLD.computeSize());
            }
            AppMethodBeat.o(72556);
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
                AppMethodBeat.o(72556);
                throw bVar2;
            }
            AppMethodBeat.o(72556);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhb dhb = (dhb) objArr[1];
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
                        dhb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72556);
                    return 0;
                case 2:
                    dhb.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72556);
                    return 0;
                case 3:
                    dhb.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 4:
                    dhb.MLy = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 5:
                    dhb.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 6:
                    dhb.MLz = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ti tiVar = new ti();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tiVar.populateBuilderWithField(aVar5, tiVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhb.MLA = tiVar;
                    }
                    AppMethodBeat.o(72556);
                    return 0;
                case 8:
                    dhb.MLB = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 9:
                    dhb.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 10:
                    dhb.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 11:
                    dhb.MLC = aVar3.UbS.readString();
                    AppMethodBeat.o(72556);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ejh ejh = new ejh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ejh.populateBuilderWithField(aVar6, ejh, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhb.MLD = ejh;
                    }
                    AppMethodBeat.o(72556);
                    return 0;
                default:
                    AppMethodBeat.o(72556);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72556);
            return -1;
        }
    }
}

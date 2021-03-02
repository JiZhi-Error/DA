package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class euj extends dpc {
    public int LsZ;
    public long Lta;
    public int MKr;
    public LinkedList<esq> NqB = new LinkedList<>();
    public eud NsA;
    public int Nst;
    public LinkedList<esq> Nsu = new LinkedList<>();
    public int Nsv;
    public LinkedList<esq> Nsw = new LinkedList<>();
    public int Nsx;
    public int Nsy;
    public int Nsz;

    public euj() {
        AppMethodBeat.i(115907);
        AppMethodBeat.o(115907);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115908);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115908);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.aM(3, this.Nst);
            aVar.e(4, 8, this.Nsu);
            aVar.aM(5, this.Nsv);
            aVar.e(6, 8, this.Nsw);
            aVar.bb(7, this.Lta);
            aVar.aM(8, this.MKr);
            aVar.aM(9, this.Nsx);
            aVar.e(10, 8, this.NqB);
            aVar.aM(11, this.Nsy);
            aVar.aM(12, this.Nsz);
            if (this.NsA != null) {
                aVar.ni(13, this.NsA.computeSize());
                this.NsA.writeFields(aVar);
            }
            AppMethodBeat.o(115908);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.bu(3, this.Nst) + g.a.a.a.c(4, 8, this.Nsu) + g.a.a.b.b.a.bu(5, this.Nsv) + g.a.a.a.c(6, 8, this.Nsw) + g.a.a.b.b.a.r(7, this.Lta) + g.a.a.b.b.a.bu(8, this.MKr) + g.a.a.b.b.a.bu(9, this.Nsx) + g.a.a.a.c(10, 8, this.NqB) + g.a.a.b.b.a.bu(11, this.Nsy) + g.a.a.b.b.a.bu(12, this.Nsz);
            if (this.NsA != null) {
                nh += g.a.a.a.nh(13, this.NsA.computeSize());
            }
            AppMethodBeat.o(115908);
            return nh;
        } else if (i2 == 2) {
            this.Nsu.clear();
            this.Nsw.clear();
            this.NqB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115908);
                throw bVar2;
            }
            AppMethodBeat.o(115908);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euj euj = (euj) objArr[1];
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
                        euj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115908);
                    return 0;
                case 2:
                    euj.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 3:
                    euj.Nst = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esq.populateBuilderWithField(aVar5, esq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        euj.Nsu.add(esq);
                    }
                    AppMethodBeat.o(115908);
                    return 0;
                case 5:
                    euj.Nsv = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        esq esq2 = new esq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = esq2.populateBuilderWithField(aVar6, esq2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        euj.Nsw.add(esq2);
                    }
                    AppMethodBeat.o(115908);
                    return 0;
                case 7:
                    euj.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115908);
                    return 0;
                case 8:
                    euj.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 9:
                    euj.Nsx = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        esq esq3 = new esq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = esq3.populateBuilderWithField(aVar7, esq3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        euj.NqB.add(esq3);
                    }
                    AppMethodBeat.o(115908);
                    return 0;
                case 11:
                    euj.Nsy = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 12:
                    euj.Nsz = aVar3.UbS.zi();
                    AppMethodBeat.o(115908);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eud eud = new eud();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eud.populateBuilderWithField(aVar8, eud, dpc.getNextFieldNumber(aVar8))) {
                        }
                        euj.NsA = eud;
                    }
                    AppMethodBeat.o(115908);
                    return 0;
                default:
                    AppMethodBeat.o(115908);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115908);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ese extends dop {
    public SKBuiltinBuffer_t BsI;
    public int KKA;
    public int KKD;
    public int KZk;
    public String Nln;
    public int Nlo;
    public int Nlp;
    public int Nps;
    public int Npt;
    public LinkedList<dqi> Npu = new LinkedList<>();
    public LinkedList<SKBuiltinBuffer_t> Npv = new LinkedList<>();
    public String UserName;
    public int jeU;

    public ese() {
        AppMethodBeat.i(148663);
        AppMethodBeat.o(148663);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148664);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148664);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.BsI != null) {
                aVar.ni(3, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            aVar.aM(4, this.KZk);
            if (this.Nln != null) {
                aVar.e(5, this.Nln);
            }
            aVar.aM(6, this.jeU);
            aVar.aM(7, this.Nlo);
            aVar.aM(8, this.KKD);
            aVar.aM(9, this.Nlp);
            aVar.aM(10, this.KKA);
            aVar.aM(11, this.Nps);
            aVar.aM(12, this.Npt);
            aVar.e(13, 8, this.Npu);
            aVar.e(14, 8, this.Npv);
            AppMethodBeat.o(148664);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.BsI != null) {
                nh += g.a.a.a.nh(3, this.BsI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KZk);
            if (this.Nln != null) {
                bu += g.a.a.b.b.a.f(5, this.Nln);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.jeU) + g.a.a.b.b.a.bu(7, this.Nlo) + g.a.a.b.b.a.bu(8, this.KKD) + g.a.a.b.b.a.bu(9, this.Nlp) + g.a.a.b.b.a.bu(10, this.KKA) + g.a.a.b.b.a.bu(11, this.Nps) + g.a.a.b.b.a.bu(12, this.Npt) + g.a.a.a.c(13, 8, this.Npu) + g.a.a.a.c(14, 8, this.Npv);
            AppMethodBeat.o(148664);
            return bu2;
        } else if (i2 == 2) {
            this.Npu.clear();
            this.Npv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148664);
                throw bVar2;
            }
            AppMethodBeat.o(148664);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ese ese = (ese) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ese.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148664);
                    return 0;
                case 2:
                    ese.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(148664);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ese.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148664);
                    return 0;
                case 4:
                    ese.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 5:
                    ese.Nln = aVar3.UbS.readString();
                    AppMethodBeat.o(148664);
                    return 0;
                case 6:
                    ese.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 7:
                    ese.Nlo = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 8:
                    ese.KKD = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 9:
                    ese.Nlp = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 10:
                    ese.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 11:
                    ese.Nps = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 12:
                    ese.Npt = aVar3.UbS.zi();
                    AppMethodBeat.o(148664);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        ese.Npu.add(dqi);
                    }
                    AppMethodBeat.o(148664);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar7))) {
                        }
                        ese.Npv.add(sKBuiltinBuffer_t2);
                    }
                    AppMethodBeat.o(148664);
                    return 0;
                default:
                    AppMethodBeat.o(148664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148664);
            return -1;
        }
    }
}

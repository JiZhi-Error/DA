package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bza extends dpc {
    public String KNV;
    public String KYV;
    public fcd Ljo;
    public String MeA;
    public String MeB;
    public int MeC;
    public String MeD;
    public int MeE;
    public int MeF;
    public csy MeG;
    public String Mev;
    public int Mew;
    public String Mex;
    public LinkedList<csy> Mey = new LinkedList<>();
    public int Mez;
    public String dQx;
    public int oKX;

    public bza() {
        AppMethodBeat.i(123591);
        AppMethodBeat.o(123591);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123592);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123592);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Ljo != null) {
                aVar.ni(2, this.Ljo.computeSize());
                this.Ljo.writeFields(aVar);
            }
            if (this.Mev != null) {
                aVar.e(3, this.Mev);
            }
            aVar.aM(4, this.Mew);
            aVar.aM(5, this.oKX);
            if (this.Mex != null) {
                aVar.e(6, this.Mex);
            }
            aVar.e(7, 8, this.Mey);
            aVar.aM(8, this.Mez);
            if (this.MeA != null) {
                aVar.e(9, this.MeA);
            }
            if (this.MeB != null) {
                aVar.e(10, this.MeB);
            }
            aVar.aM(11, this.MeC);
            if (this.dQx != null) {
                aVar.e(12, this.dQx);
            }
            if (this.KNV != null) {
                aVar.e(13, this.KNV);
            }
            if (this.KYV != null) {
                aVar.e(14, this.KYV);
            }
            if (this.MeD != null) {
                aVar.e(15, this.MeD);
            }
            aVar.aM(16, this.MeE);
            aVar.aM(17, this.MeF);
            if (this.MeG != null) {
                aVar.ni(18, this.MeG.computeSize());
                this.MeG.writeFields(aVar);
            }
            AppMethodBeat.o(123592);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Ljo != null) {
                nh += g.a.a.a.nh(2, this.Ljo.computeSize());
            }
            if (this.Mev != null) {
                nh += g.a.a.b.b.a.f(3, this.Mev);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Mew) + g.a.a.b.b.a.bu(5, this.oKX);
            if (this.Mex != null) {
                bu += g.a.a.b.b.a.f(6, this.Mex);
            }
            int c2 = bu + g.a.a.a.c(7, 8, this.Mey) + g.a.a.b.b.a.bu(8, this.Mez);
            if (this.MeA != null) {
                c2 += g.a.a.b.b.a.f(9, this.MeA);
            }
            if (this.MeB != null) {
                c2 += g.a.a.b.b.a.f(10, this.MeB);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(11, this.MeC);
            if (this.dQx != null) {
                bu2 += g.a.a.b.b.a.f(12, this.dQx);
            }
            if (this.KNV != null) {
                bu2 += g.a.a.b.b.a.f(13, this.KNV);
            }
            if (this.KYV != null) {
                bu2 += g.a.a.b.b.a.f(14, this.KYV);
            }
            if (this.MeD != null) {
                bu2 += g.a.a.b.b.a.f(15, this.MeD);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.MeE) + g.a.a.b.b.a.bu(17, this.MeF);
            if (this.MeG != null) {
                bu3 += g.a.a.a.nh(18, this.MeG.computeSize());
            }
            AppMethodBeat.o(123592);
            return bu3;
        } else if (i2 == 2) {
            this.Mey.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123592);
                throw bVar2;
            }
            AppMethodBeat.o(123592);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bza bza = (bza) objArr[1];
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
                        bza.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123592);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcd fcd = new fcd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcd.populateBuilderWithField(aVar5, fcd, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bza.Ljo = fcd;
                    }
                    AppMethodBeat.o(123592);
                    return 0;
                case 3:
                    bza.Mev = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 4:
                    bza.Mew = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 5:
                    bza.oKX = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 6:
                    bza.Mex = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        csy csy = new csy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = csy.populateBuilderWithField(aVar6, csy, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bza.Mey.add(csy);
                    }
                    AppMethodBeat.o(123592);
                    return 0;
                case 8:
                    bza.Mez = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 9:
                    bza.MeA = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 10:
                    bza.MeB = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 11:
                    bza.MeC = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 12:
                    bza.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 13:
                    bza.KNV = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 14:
                    bza.KYV = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 15:
                    bza.MeD = aVar3.UbS.readString();
                    AppMethodBeat.o(123592);
                    return 0;
                case 16:
                    bza.MeE = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 17:
                    bza.MeF = aVar3.UbS.zi();
                    AppMethodBeat.o(123592);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        csy csy2 = new csy();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = csy2.populateBuilderWithField(aVar7, csy2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bza.MeG = csy2;
                    }
                    AppMethodBeat.o(123592);
                    return 0;
                default:
                    AppMethodBeat.o(123592);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123592);
            return -1;
        }
    }
}

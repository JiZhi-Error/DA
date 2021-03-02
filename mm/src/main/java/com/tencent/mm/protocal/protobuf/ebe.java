package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebe extends dpc {
    public LinkedList<SnsObject> KOH = new LinkedList<>();
    public SKBuiltinBuffer_t MYJ;
    public String MZg;
    public int MZk;
    public eat MZl;
    public int MvM;
    public int NaG;
    public int NaH;
    public LinkedList<ds> NaI = new LinkedList<>();
    public int NaJ;
    public LinkedList<dkg> NaK = new LinkedList<>();
    public int NaL;
    public LinkedList<aez> NaM = new LinkedList<>();
    public int NaO;
    public LinkedList<Long> NaP = new LinkedList<>();
    public LinkedList<Integer> NaQ = new LinkedList<>();
    public SKBuiltinBuffer_t NaR;
    public int xuw;

    public ebe() {
        AppMethodBeat.i(125828);
        AppMethodBeat.o(125828);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125829);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125829);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            aVar.aM(3, this.MvM);
            aVar.e(4, 8, this.KOH);
            aVar.aM(5, this.NaG);
            aVar.aM(6, this.MZk);
            aVar.aM(7, this.xuw);
            if (this.MZl != null) {
                aVar.ni(8, this.MZl.computeSize());
                this.MZl.writeFields(aVar);
            }
            aVar.aM(9, this.NaH);
            aVar.e(10, 8, this.NaI);
            if (this.MYJ != null) {
                aVar.ni(11, this.MYJ.computeSize());
                this.MYJ.writeFields(aVar);
            }
            aVar.aM(12, this.NaJ);
            aVar.e(13, 8, this.NaK);
            aVar.aM(14, this.NaL);
            aVar.e(15, 8, this.NaM);
            aVar.aM(16, this.NaO);
            aVar.f(17, 3, this.NaP);
            aVar.f(18, 2, this.NaQ);
            if (this.NaR != null) {
                aVar.ni(19, this.NaR.computeSize());
                this.NaR.writeFields(aVar);
            }
            AppMethodBeat.o(125829);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.NaG) + g.a.a.b.b.a.bu(6, this.MZk) + g.a.a.b.b.a.bu(7, this.xuw);
            if (this.MZl != null) {
                bu += g.a.a.a.nh(8, this.MZl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.NaH) + g.a.a.a.c(10, 8, this.NaI);
            if (this.MYJ != null) {
                bu2 += g.a.a.a.nh(11, this.MYJ.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.NaJ) + g.a.a.a.c(13, 8, this.NaK) + g.a.a.b.b.a.bu(14, this.NaL) + g.a.a.a.c(15, 8, this.NaM) + g.a.a.b.b.a.bu(16, this.NaO) + g.a.a.a.d(17, 3, this.NaP) + g.a.a.a.d(18, 2, this.NaQ);
            if (this.NaR != null) {
                bu3 += g.a.a.a.nh(19, this.NaR.computeSize());
            }
            AppMethodBeat.o(125829);
            return bu3;
        } else if (i2 == 2) {
            this.KOH.clear();
            this.NaI.clear();
            this.NaK.clear();
            this.NaM.clear();
            this.NaP.clear();
            this.NaQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125829);
                throw bVar2;
            }
            AppMethodBeat.o(125829);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebe ebe = (ebe) objArr[1];
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
                        ebe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 2:
                    ebe.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(125829);
                    return 0;
                case 3:
                    ebe.MvM = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SnsObject snsObject = new SnsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = snsObject.populateBuilderWithField(aVar5, snsObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ebe.KOH.add(snsObject);
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 5:
                    ebe.NaG = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 6:
                    ebe.MZk = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 7:
                    ebe.xuw = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eat eat = new eat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eat.populateBuilderWithField(aVar6, eat, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ebe.MZl = eat;
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 9:
                    ebe.NaH = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ds dsVar = new ds();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dsVar.populateBuilderWithField(aVar7, dsVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ebe.NaI.add(dsVar);
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ebe.MYJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 12:
                    ebe.NaJ = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dkg dkg = new dkg();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dkg.populateBuilderWithField(aVar9, dkg, dpc.getNextFieldNumber(aVar9))) {
                        }
                        ebe.NaK.add(dkg);
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 14:
                    ebe.NaL = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        aez aez = new aez();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = aez.populateBuilderWithField(aVar10, aez, dpc.getNextFieldNumber(aVar10))) {
                        }
                        ebe.NaM.add(aez);
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                case 16:
                    ebe.NaO = aVar3.UbS.zi();
                    AppMethodBeat.o(125829);
                    return 0;
                case 17:
                    ebe.NaP = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPn();
                    AppMethodBeat.o(125829);
                    return 0;
                case 18:
                    ebe.NaQ = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(125829);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar11, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar11))) {
                        }
                        ebe.NaR = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125829);
                    return 0;
                default:
                    AppMethodBeat.o(125829);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125829);
            return -1;
        }
    }
}

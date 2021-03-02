package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bzf extends dpc {
    public fcd Ljo;
    public int MeE;
    public LinkedList<fdl> MeR = new LinkedList<>();
    public fdl MeS;
    public String MeT;
    public int MeU;
    public String MeV;
    public String MeW;
    public String MeX;
    public String MeY;

    public bzf() {
        AppMethodBeat.i(123594);
        AppMethodBeat.o(123594);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123595);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123595);
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
            aVar.e(3, 8, this.MeR);
            if (this.MeS != null) {
                aVar.ni(4, this.MeS.computeSize());
                this.MeS.writeFields(aVar);
            }
            if (this.MeT != null) {
                aVar.e(5, this.MeT);
            }
            aVar.aM(6, this.MeU);
            if (this.MeV != null) {
                aVar.e(7, this.MeV);
            }
            if (this.MeW != null) {
                aVar.e(8, this.MeW);
            }
            if (this.MeX != null) {
                aVar.e(9, this.MeX);
            }
            if (this.MeY != null) {
                aVar.e(10, this.MeY);
            }
            aVar.aM(11, this.MeE);
            AppMethodBeat.o(123595);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Ljo != null) {
                nh += g.a.a.a.nh(2, this.Ljo.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.MeR);
            if (this.MeS != null) {
                c2 += g.a.a.a.nh(4, this.MeS.computeSize());
            }
            if (this.MeT != null) {
                c2 += g.a.a.b.b.a.f(5, this.MeT);
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.MeU);
            if (this.MeV != null) {
                bu += g.a.a.b.b.a.f(7, this.MeV);
            }
            if (this.MeW != null) {
                bu += g.a.a.b.b.a.f(8, this.MeW);
            }
            if (this.MeX != null) {
                bu += g.a.a.b.b.a.f(9, this.MeX);
            }
            if (this.MeY != null) {
                bu += g.a.a.b.b.a.f(10, this.MeY);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.MeE);
            AppMethodBeat.o(123595);
            return bu2;
        } else if (i2 == 2) {
            this.MeR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123595);
                throw bVar2;
            }
            AppMethodBeat.o(123595);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzf bzf = (bzf) objArr[1];
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
                        bzf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123595);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcd fcd = new fcd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcd.populateBuilderWithField(aVar5, fcd, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bzf.Ljo = fcd;
                    }
                    AppMethodBeat.o(123595);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fdl fdl = new fdl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fdl.populateBuilderWithField(aVar6, fdl, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bzf.MeR.add(fdl);
                    }
                    AppMethodBeat.o(123595);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdl fdl2 = new fdl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdl2.populateBuilderWithField(aVar7, fdl2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bzf.MeS = fdl2;
                    }
                    AppMethodBeat.o(123595);
                    return 0;
                case 5:
                    bzf.MeT = aVar3.UbS.readString();
                    AppMethodBeat.o(123595);
                    return 0;
                case 6:
                    bzf.MeU = aVar3.UbS.zi();
                    AppMethodBeat.o(123595);
                    return 0;
                case 7:
                    bzf.MeV = aVar3.UbS.readString();
                    AppMethodBeat.o(123595);
                    return 0;
                case 8:
                    bzf.MeW = aVar3.UbS.readString();
                    AppMethodBeat.o(123595);
                    return 0;
                case 9:
                    bzf.MeX = aVar3.UbS.readString();
                    AppMethodBeat.o(123595);
                    return 0;
                case 10:
                    bzf.MeY = aVar3.UbS.readString();
                    AppMethodBeat.o(123595);
                    return 0;
                case 11:
                    bzf.MeE = aVar3.UbS.zi();
                    AppMethodBeat.o(123595);
                    return 0;
                default:
                    AppMethodBeat.o(123595);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123595);
            return -1;
        }
    }
}

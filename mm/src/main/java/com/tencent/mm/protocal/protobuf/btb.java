package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btb extends dpc {
    public dux LZD;
    public fdd LZE;
    public fdv LZF;
    public anu LZG;
    public fdf LZH;
    public fef LZI;
    public feh LZJ;
    public String LZK;
    public String LZL;
    public LinkedList<feh> LZM = new LinkedList<>();

    public btb() {
        AppMethodBeat.i(194401);
        AppMethodBeat.o(194401);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153276);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153276);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LZD != null) {
                aVar.ni(2, this.LZD.computeSize());
                this.LZD.writeFields(aVar);
            }
            if (this.LZE != null) {
                aVar.ni(3, this.LZE.computeSize());
                this.LZE.writeFields(aVar);
            }
            if (this.LZF != null) {
                aVar.ni(4, this.LZF.computeSize());
                this.LZF.writeFields(aVar);
            }
            if (this.LZG != null) {
                aVar.ni(5, this.LZG.computeSize());
                this.LZG.writeFields(aVar);
            }
            if (this.LZH != null) {
                aVar.ni(6, this.LZH.computeSize());
                this.LZH.writeFields(aVar);
            }
            if (this.LZI != null) {
                aVar.ni(7, this.LZI.computeSize());
                this.LZI.writeFields(aVar);
            }
            if (this.LZJ != null) {
                aVar.ni(8, this.LZJ.computeSize());
                this.LZJ.writeFields(aVar);
            }
            if (this.LZK != null) {
                aVar.e(10, this.LZK);
            }
            if (this.LZL != null) {
                aVar.e(11, this.LZL);
            }
            aVar.e(12, 8, this.LZM);
            AppMethodBeat.o(153276);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LZD != null) {
                nh += g.a.a.a.nh(2, this.LZD.computeSize());
            }
            if (this.LZE != null) {
                nh += g.a.a.a.nh(3, this.LZE.computeSize());
            }
            if (this.LZF != null) {
                nh += g.a.a.a.nh(4, this.LZF.computeSize());
            }
            if (this.LZG != null) {
                nh += g.a.a.a.nh(5, this.LZG.computeSize());
            }
            if (this.LZH != null) {
                nh += g.a.a.a.nh(6, this.LZH.computeSize());
            }
            if (this.LZI != null) {
                nh += g.a.a.a.nh(7, this.LZI.computeSize());
            }
            if (this.LZJ != null) {
                nh += g.a.a.a.nh(8, this.LZJ.computeSize());
            }
            if (this.LZK != null) {
                nh += g.a.a.b.b.a.f(10, this.LZK);
            }
            if (this.LZL != null) {
                nh += g.a.a.b.b.a.f(11, this.LZL);
            }
            int c2 = nh + g.a.a.a.c(12, 8, this.LZM);
            AppMethodBeat.o(153276);
            return c2;
        } else if (i2 == 2) {
            this.LZM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153276);
                throw bVar2;
            }
            AppMethodBeat.o(153276);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btb btb = (btb) objArr[1];
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
                        btb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dux dux = new dux();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dux.populateBuilderWithField(aVar5, dux, dpc.getNextFieldNumber(aVar5))) {
                        }
                        btb.LZD = dux;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fdd fdd = new fdd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fdd.populateBuilderWithField(aVar6, fdd, dpc.getNextFieldNumber(aVar6))) {
                        }
                        btb.LZE = fdd;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdv fdv = new fdv();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdv.populateBuilderWithField(aVar7, fdv, dpc.getNextFieldNumber(aVar7))) {
                        }
                        btb.LZF = fdv;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        anu anu = new anu();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = anu.populateBuilderWithField(aVar8, anu, dpc.getNextFieldNumber(aVar8))) {
                        }
                        btb.LZG = anu;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        fdf fdf = new fdf();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fdf.populateBuilderWithField(aVar9, fdf, dpc.getNextFieldNumber(aVar9))) {
                        }
                        btb.LZH = fdf;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        fef fef = new fef();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = fef.populateBuilderWithField(aVar10, fef, dpc.getNextFieldNumber(aVar10))) {
                        }
                        btb.LZI = fef;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        feh feh = new feh();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = feh.populateBuilderWithField(aVar11, feh, dpc.getNextFieldNumber(aVar11))) {
                        }
                        btb.LZJ = feh;
                    }
                    AppMethodBeat.o(153276);
                    return 0;
                case 9:
                default:
                    AppMethodBeat.o(153276);
                    return -1;
                case 10:
                    btb.LZK = aVar3.UbS.readString();
                    AppMethodBeat.o(153276);
                    return 0;
                case 11:
                    btb.LZL = aVar3.UbS.readString();
                    AppMethodBeat.o(153276);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        feh feh2 = new feh();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = feh2.populateBuilderWithField(aVar12, feh2, dpc.getNextFieldNumber(aVar12))) {
                        }
                        btb.LZM.add(feh2);
                    }
                    AppMethodBeat.o(153276);
                    return 0;
            }
        } else {
            AppMethodBeat.o(153276);
            return -1;
        }
    }
}

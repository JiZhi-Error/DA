package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bdf extends dpc {
    public LinkedList<FinderContact> LDz = new LinkedList<>();
    public LinkedList<FinderContact> LKE = new LinkedList<>();
    public SKBuiltinBuffer_t LMX;
    public abo LNc;
    public int LNd;
    public apb LNe;
    public int continueFlag;
    public LinkedList<apf> sKS = new LinkedList<>();

    public bdf() {
        AppMethodBeat.i(169062);
        AppMethodBeat.o(169062);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169063);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LNc != null) {
                aVar.ni(2, this.LNc.computeSize());
                this.LNc.writeFields(aVar);
            }
            aVar.aM(3, this.continueFlag);
            if (this.LMX != null) {
                aVar.ni(4, this.LMX.computeSize());
                this.LMX.writeFields(aVar);
            }
            aVar.e(5, 8, this.LDz);
            aVar.e(6, 8, this.LKE);
            aVar.e(7, 8, this.sKS);
            aVar.aM(8, this.LNd);
            if (this.LNe != null) {
                aVar.ni(9, this.LNe.computeSize());
                this.LNe.writeFields(aVar);
            }
            AppMethodBeat.o(169063);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LNc != null) {
                nh += g.a.a.a.nh(2, this.LNc.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.continueFlag);
            if (this.LMX != null) {
                bu += g.a.a.a.nh(4, this.LMX.computeSize());
            }
            int c2 = bu + g.a.a.a.c(5, 8, this.LDz) + g.a.a.a.c(6, 8, this.LKE) + g.a.a.a.c(7, 8, this.sKS) + g.a.a.b.b.a.bu(8, this.LNd);
            if (this.LNe != null) {
                c2 += g.a.a.a.nh(9, this.LNe.computeSize());
            }
            AppMethodBeat.o(169063);
            return c2;
        } else if (i2 == 2) {
            this.LDz.clear();
            this.LKE.clear();
            this.sKS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169063);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdf bdf = (bdf) objArr[1];
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
                        bdf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abo.populateBuilderWithField(aVar5, abo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bdf.LNc = abo;
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 3:
                    bdf.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169063);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bdf.LMX = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderContact.populateBuilderWithField(aVar7, finderContact, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bdf.LDz.add(finderContact);
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderContact finderContact2 = new FinderContact();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderContact2.populateBuilderWithField(aVar8, finderContact2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bdf.LKE.add(finderContact2);
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        apf apf = new apf();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = apf.populateBuilderWithField(aVar9, apf, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bdf.sKS.add(apf);
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                case 8:
                    bdf.LNd = aVar3.UbS.zi();
                    AppMethodBeat.o(169063);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        apb apb = new apb();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = apb.populateBuilderWithField(aVar10, apb, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bdf.LNe = apb;
                    }
                    AppMethodBeat.o(169063);
                    return 0;
                default:
                    AppMethodBeat.o(169063);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169063);
            return -1;
        }
    }
}

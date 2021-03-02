package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class bda extends dpc {
    public b LCV;
    public awu LDS;
    public String LME;
    public String LMF;
    public int LMG;
    public int LMH;
    public int LMI;
    public apt LMJ;
    public int LMK;
    public bdt LML;
    public apa LMM;
    public String LMN;
    public bcy LMO;
    public String Lme;
    public b lastBuffer;
    public LinkedList<FinderObject> liveObjects = new LinkedList<>();
    public LinkedList<FinderObject> object = new LinkedList<>();
    public baw preloadInfo;
    public int tUB;
    public bcx tUH;
    public bcc tvs;

    public bda() {
        AppMethodBeat.i(169057);
        AppMethodBeat.o(169057);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169058);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169058);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            if (this.LME != null) {
                aVar.e(4, this.LME);
            }
            if (this.LMF != null) {
                aVar.e(5, this.LMF);
            }
            aVar.aM(6, this.tUB);
            aVar.aM(7, this.LMG);
            aVar.aM(8, this.LMH);
            aVar.aM(9, this.LMI);
            if (this.preloadInfo != null) {
                aVar.ni(10, this.preloadInfo.computeSize());
                this.preloadInfo.writeFields(aVar);
            }
            if (this.LMJ != null) {
                aVar.ni(11, this.LMJ.computeSize());
                this.LMJ.writeFields(aVar);
            }
            aVar.aM(12, this.LMK);
            aVar.e(13, 8, this.liveObjects);
            if (this.LML != null) {
                aVar.ni(14, this.LML.computeSize());
                this.LML.writeFields(aVar);
            }
            if (this.LMM != null) {
                aVar.ni(15, this.LMM.computeSize());
                this.LMM.writeFields(aVar);
            }
            if (this.LMN != null) {
                aVar.e(16, this.LMN);
            }
            if (this.tvs != null) {
                aVar.ni(17, this.tvs.computeSize());
                this.tvs.writeFields(aVar);
            }
            if (this.LMO != null) {
                aVar.ni(18, this.LMO.computeSize());
                this.LMO.writeFields(aVar);
            }
            if (this.tUH != null) {
                aVar.ni(19, this.tUH.computeSize());
                this.tUH.writeFields(aVar);
            }
            if (this.Lme != null) {
                aVar.e(20, this.Lme);
            }
            if (this.LDS != null) {
                aVar.ni(21, this.LDS.computeSize());
                this.LDS.writeFields(aVar);
            }
            if (this.LCV != null) {
                aVar.c(22, this.LCV);
            }
            AppMethodBeat.o(169058);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            if (this.LME != null) {
                nh += g.a.a.b.b.a.f(4, this.LME);
            }
            if (this.LMF != null) {
                nh += g.a.a.b.b.a.f(5, this.LMF);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.tUB) + g.a.a.b.b.a.bu(7, this.LMG) + g.a.a.b.b.a.bu(8, this.LMH) + g.a.a.b.b.a.bu(9, this.LMI);
            if (this.preloadInfo != null) {
                bu += g.a.a.a.nh(10, this.preloadInfo.computeSize());
            }
            if (this.LMJ != null) {
                bu += g.a.a.a.nh(11, this.LMJ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.LMK) + g.a.a.a.c(13, 8, this.liveObjects);
            if (this.LML != null) {
                bu2 += g.a.a.a.nh(14, this.LML.computeSize());
            }
            if (this.LMM != null) {
                bu2 += g.a.a.a.nh(15, this.LMM.computeSize());
            }
            if (this.LMN != null) {
                bu2 += g.a.a.b.b.a.f(16, this.LMN);
            }
            if (this.tvs != null) {
                bu2 += g.a.a.a.nh(17, this.tvs.computeSize());
            }
            if (this.LMO != null) {
                bu2 += g.a.a.a.nh(18, this.LMO.computeSize());
            }
            if (this.tUH != null) {
                bu2 += g.a.a.a.nh(19, this.tUH.computeSize());
            }
            if (this.Lme != null) {
                bu2 += g.a.a.b.b.a.f(20, this.Lme);
            }
            if (this.LDS != null) {
                bu2 += g.a.a.a.nh(21, this.LDS.computeSize());
            }
            if (this.LCV != null) {
                bu2 += g.a.a.b.b.a.b(22, this.LCV);
            }
            AppMethodBeat.o(169058);
            return bu2;
        } else if (i2 == 2) {
            this.object.clear();
            this.liveObjects.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169058);
                throw bVar2;
            }
            AppMethodBeat.o(169058);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bda bda = (bda) objArr[1];
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
                        bda.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bda.object.add(finderObject);
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 3:
                    bda.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169058);
                    return 0;
                case 4:
                    bda.LME = aVar3.UbS.readString();
                    AppMethodBeat.o(169058);
                    return 0;
                case 5:
                    bda.LMF = aVar3.UbS.readString();
                    AppMethodBeat.o(169058);
                    return 0;
                case 6:
                    bda.tUB = aVar3.UbS.zi();
                    AppMethodBeat.o(169058);
                    return 0;
                case 7:
                    bda.LMG = aVar3.UbS.zi();
                    AppMethodBeat.o(169058);
                    return 0;
                case 8:
                    bda.LMH = aVar3.UbS.zi();
                    AppMethodBeat.o(169058);
                    return 0;
                case 9:
                    bda.LMI = aVar3.UbS.zi();
                    AppMethodBeat.o(169058);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = baw.populateBuilderWithField(aVar6, baw, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bda.preloadInfo = baw;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        apt apt = new apt();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = apt.populateBuilderWithField(aVar7, apt, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bda.LMJ = apt;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 12:
                    bda.LMK = aVar3.UbS.zi();
                    AppMethodBeat.o(169058);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderObject2.populateBuilderWithField(aVar8, finderObject2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bda.liveObjects.add(finderObject2);
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bdt bdt = new bdt();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bdt.populateBuilderWithField(aVar9, bdt, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bda.LML = bdt;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        apa apa = new apa();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = apa.populateBuilderWithField(aVar10, apa, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bda.LMM = apa;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 16:
                    bda.LMN = aVar3.UbS.readString();
                    AppMethodBeat.o(169058);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bcc bcc = new bcc();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bcc.populateBuilderWithField(aVar11, bcc, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bda.tvs = bcc;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        bcy bcy = new bcy();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = bcy.populateBuilderWithField(aVar12, bcy, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bda.LMO = bcy;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        bcx bcx = new bcx();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = bcx.populateBuilderWithField(aVar13, bcx, dpc.getNextFieldNumber(aVar13))) {
                        }
                        bda.tUH = bcx;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 20:
                    bda.Lme = aVar3.UbS.readString();
                    AppMethodBeat.o(169058);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        awu awu = new awu();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = awu.populateBuilderWithField(aVar14, awu, dpc.getNextFieldNumber(aVar14))) {
                        }
                        bda.LDS = awu;
                    }
                    AppMethodBeat.o(169058);
                    return 0;
                case 22:
                    bda.LCV = aVar3.UbS.hPo();
                    AppMethodBeat.o(169058);
                    return 0;
                default:
                    AppMethodBeat.o(169058);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169058);
            return -1;
        }
    }
}

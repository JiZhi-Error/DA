package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ft extends dpc {
    public fe KJA;
    public eqw KJB;
    public String KJC;
    public cmb KJD;
    public fp KJE;
    public LinkedList<String> KJF = new LinkedList<>();
    public eb KJG;
    public LinkedList<ckn> KJH = new LinkedList<>();
    public String KJI;
    public LinkedList<gh> KJu = new LinkedList<>();
    public int KJv;
    public String KJw;
    public int KJx;
    public int KJy;
    public int KJz;
    public String url;
    public String vid;

    public ft() {
        AppMethodBeat.i(103195);
        AppMethodBeat.o(103195);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103196);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(103196);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.KJu);
            aVar.aM(3, this.KJv);
            if (this.KJw != null) {
                aVar.e(4, this.KJw);
            }
            aVar.aM(5, this.KJx);
            aVar.aM(6, this.KJy);
            aVar.aM(7, this.KJz);
            if (this.KJA != null) {
                aVar.ni(8, this.KJA.computeSize());
                this.KJA.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(9, this.url);
            }
            if (this.vid != null) {
                aVar.e(10, this.vid);
            }
            if (this.KJB != null) {
                aVar.ni(11, this.KJB.computeSize());
                this.KJB.writeFields(aVar);
            }
            if (this.KJC != null) {
                aVar.e(12, this.KJC);
            }
            if (this.KJD != null) {
                aVar.ni(13, this.KJD.computeSize());
                this.KJD.writeFields(aVar);
            }
            if (this.KJE != null) {
                aVar.ni(14, this.KJE.computeSize());
                this.KJE.writeFields(aVar);
            }
            aVar.e(15, 1, this.KJF);
            if (this.KJG != null) {
                aVar.ni(16, this.KJG.computeSize());
                this.KJG.writeFields(aVar);
            }
            aVar.e(17, 8, this.KJH);
            if (this.KJI != null) {
                aVar.e(18, this.KJI);
            }
            AppMethodBeat.o(103196);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KJu) + g.a.a.b.b.a.bu(3, this.KJv);
            if (this.KJw != null) {
                nh += g.a.a.b.b.a.f(4, this.KJw);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KJx) + g.a.a.b.b.a.bu(6, this.KJy) + g.a.a.b.b.a.bu(7, this.KJz);
            if (this.KJA != null) {
                bu += g.a.a.a.nh(8, this.KJA.computeSize());
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(9, this.url);
            }
            if (this.vid != null) {
                bu += g.a.a.b.b.a.f(10, this.vid);
            }
            if (this.KJB != null) {
                bu += g.a.a.a.nh(11, this.KJB.computeSize());
            }
            if (this.KJC != null) {
                bu += g.a.a.b.b.a.f(12, this.KJC);
            }
            if (this.KJD != null) {
                bu += g.a.a.a.nh(13, this.KJD.computeSize());
            }
            if (this.KJE != null) {
                bu += g.a.a.a.nh(14, this.KJE.computeSize());
            }
            int c2 = bu + g.a.a.a.c(15, 1, this.KJF);
            if (this.KJG != null) {
                c2 += g.a.a.a.nh(16, this.KJG.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(17, 8, this.KJH);
            if (this.KJI != null) {
                c3 += g.a.a.b.b.a.f(18, this.KJI);
            }
            AppMethodBeat.o(103196);
            return c3;
        } else if (i2 == 2) {
            this.KJu.clear();
            this.KJF.clear();
            this.KJH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(103196);
                throw bVar2;
            }
            AppMethodBeat.o(103196);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ft ftVar = (ft) objArr[1];
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
                        ftVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gh ghVar = new gh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ghVar.populateBuilderWithField(aVar5, ghVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ftVar.KJu.add(ghVar);
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 3:
                    ftVar.KJv = aVar3.UbS.zi();
                    AppMethodBeat.o(103196);
                    return 0;
                case 4:
                    ftVar.KJw = aVar3.UbS.readString();
                    AppMethodBeat.o(103196);
                    return 0;
                case 5:
                    ftVar.KJx = aVar3.UbS.zi();
                    AppMethodBeat.o(103196);
                    return 0;
                case 6:
                    ftVar.KJy = aVar3.UbS.zi();
                    AppMethodBeat.o(103196);
                    return 0;
                case 7:
                    ftVar.KJz = aVar3.UbS.zi();
                    AppMethodBeat.o(103196);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fe feVar = new fe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = feVar.populateBuilderWithField(aVar6, feVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ftVar.KJA = feVar;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 9:
                    ftVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103196);
                    return 0;
                case 10:
                    ftVar.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(103196);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eqw eqw = new eqw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eqw.populateBuilderWithField(aVar7, eqw, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ftVar.KJB = eqw;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 12:
                    ftVar.KJC = aVar3.UbS.readString();
                    AppMethodBeat.o(103196);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cmb cmb = new cmb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cmb.populateBuilderWithField(aVar8, cmb, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ftVar.KJD = cmb;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        fp fpVar = new fp();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fpVar.populateBuilderWithField(aVar9, fpVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        ftVar.KJE = fpVar;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 15:
                    ftVar.KJF.add(aVar3.UbS.readString());
                    AppMethodBeat.o(103196);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        eb ebVar = new eb();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ebVar.populateBuilderWithField(aVar10, ebVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        ftVar.KJG = ebVar;
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ckn ckn = new ckn();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = ckn.populateBuilderWithField(aVar11, ckn, dpc.getNextFieldNumber(aVar11))) {
                        }
                        ftVar.KJH.add(ckn);
                    }
                    AppMethodBeat.o(103196);
                    return 0;
                case 18:
                    ftVar.KJI = aVar3.UbS.readString();
                    AppMethodBeat.o(103196);
                    return 0;
                default:
                    AppMethodBeat.o(103196);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103196);
            return -1;
        }
    }
}

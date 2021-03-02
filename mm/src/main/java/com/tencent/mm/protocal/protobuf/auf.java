package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class auf extends dpc {
    public LinkedList<axl> LDJ = new LinkedList<>();
    public avn LDQ;
    public b LDx;
    public awn LES;
    public axo LET;
    public aug LEU;
    public LinkedList<aus> LEV = new LinkedList<>();
    public int LEW;
    public int LEX;
    public long LEY;
    public String LEZ;
    public bel ViI;
    public String ViJ;
    public fge ViK;
    public fhq ViL;
    public LinkedList<String> Viw = new LinkedList<>();
    public cjb hIv;
    public awe liveInfo;
    public axt location;
    public axg uEm;

    public auf() {
        AppMethodBeat.i(209469);
        AppMethodBeat.o(209469);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209470);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LDx != null) {
                aVar.c(2, this.LDx);
            }
            if (this.hIv != null) {
                aVar.ni(3, this.hIv.computeSize());
                this.hIv.writeFields(aVar);
            }
            if (this.liveInfo != null) {
                aVar.ni(4, this.liveInfo.computeSize());
                this.liveInfo.writeFields(aVar);
            }
            if (this.LES != null) {
                aVar.ni(5, this.LES.computeSize());
                this.LES.writeFields(aVar);
            }
            if (this.LET != null) {
                aVar.ni(6, this.LET.computeSize());
                this.LET.writeFields(aVar);
            }
            if (this.uEm != null) {
                aVar.ni(7, this.uEm.computeSize());
                this.uEm.writeFields(aVar);
            }
            if (this.LDQ != null) {
                aVar.ni(8, this.LDQ.computeSize());
                this.LDQ.writeFields(aVar);
            }
            if (this.LEU != null) {
                aVar.ni(9, this.LEU.computeSize());
                this.LEU.writeFields(aVar);
            }
            aVar.e(10, 8, this.LDJ);
            aVar.e(11, 8, this.LEV);
            aVar.aM(12, this.LEW);
            aVar.aM(13, this.LEX);
            aVar.bb(14, this.LEY);
            if (this.LEZ != null) {
                aVar.e(15, this.LEZ);
            }
            if (this.location != null) {
                aVar.ni(16, this.location.computeSize());
                this.location.writeFields(aVar);
            }
            if (this.ViI != null) {
                aVar.ni(17, this.ViI.computeSize());
                this.ViI.writeFields(aVar);
            }
            if (this.ViJ != null) {
                aVar.e(18, this.ViJ);
            }
            aVar.e(19, 1, this.Viw);
            if (this.ViK != null) {
                aVar.ni(20, this.ViK.computeSize());
                this.ViK.writeFields(aVar);
            }
            if (this.ViL != null) {
                aVar.ni(21, this.ViL.computeSize());
                this.ViL.writeFields(aVar);
            }
            AppMethodBeat.o(209470);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LDx != null) {
                nh += g.a.a.b.b.a.b(2, this.LDx);
            }
            if (this.hIv != null) {
                nh += g.a.a.a.nh(3, this.hIv.computeSize());
            }
            if (this.liveInfo != null) {
                nh += g.a.a.a.nh(4, this.liveInfo.computeSize());
            }
            if (this.LES != null) {
                nh += g.a.a.a.nh(5, this.LES.computeSize());
            }
            if (this.LET != null) {
                nh += g.a.a.a.nh(6, this.LET.computeSize());
            }
            if (this.uEm != null) {
                nh += g.a.a.a.nh(7, this.uEm.computeSize());
            }
            if (this.LDQ != null) {
                nh += g.a.a.a.nh(8, this.LDQ.computeSize());
            }
            if (this.LEU != null) {
                nh += g.a.a.a.nh(9, this.LEU.computeSize());
            }
            int c2 = nh + g.a.a.a.c(10, 8, this.LDJ) + g.a.a.a.c(11, 8, this.LEV) + g.a.a.b.b.a.bu(12, this.LEW) + g.a.a.b.b.a.bu(13, this.LEX) + g.a.a.b.b.a.r(14, this.LEY);
            if (this.LEZ != null) {
                c2 += g.a.a.b.b.a.f(15, this.LEZ);
            }
            if (this.location != null) {
                c2 += g.a.a.a.nh(16, this.location.computeSize());
            }
            if (this.ViI != null) {
                c2 += g.a.a.a.nh(17, this.ViI.computeSize());
            }
            if (this.ViJ != null) {
                c2 += g.a.a.b.b.a.f(18, this.ViJ);
            }
            int c3 = c2 + g.a.a.a.c(19, 1, this.Viw);
            if (this.ViK != null) {
                c3 += g.a.a.a.nh(20, this.ViK.computeSize());
            }
            if (this.ViL != null) {
                c3 += g.a.a.a.nh(21, this.ViL.computeSize());
            }
            AppMethodBeat.o(209470);
            return c3;
        } else if (i2 == 2) {
            this.LDJ.clear();
            this.LEV.clear();
            this.Viw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209470);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auf auf = (auf) objArr[1];
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
                        auf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 2:
                    auf.LDx = aVar3.UbS.hPo();
                    AppMethodBeat.o(209470);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjb cjb = new cjb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjb.populateBuilderWithField(aVar5, cjb, dpc.getNextFieldNumber(aVar5))) {
                        }
                        auf.hIv = cjb;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awe awe = new awe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awe.populateBuilderWithField(aVar6, awe, dpc.getNextFieldNumber(aVar6))) {
                        }
                        auf.liveInfo = awe;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        awn awn = new awn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = awn.populateBuilderWithField(aVar7, awn, dpc.getNextFieldNumber(aVar7))) {
                        }
                        auf.LES = awn;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        axo axo = new axo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = axo.populateBuilderWithField(aVar8, axo, dpc.getNextFieldNumber(aVar8))) {
                        }
                        auf.LET = axo;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        axg axg = new axg();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = axg.populateBuilderWithField(aVar9, axg, dpc.getNextFieldNumber(aVar9))) {
                        }
                        auf.uEm = axg;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = avn.populateBuilderWithField(aVar10, avn, dpc.getNextFieldNumber(aVar10))) {
                        }
                        auf.LDQ = avn;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        aug aug = new aug();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = aug.populateBuilderWithField(aVar11, aug, dpc.getNextFieldNumber(aVar11))) {
                        }
                        auf.LEU = aug;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        axl axl = new axl();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = axl.populateBuilderWithField(aVar12, axl, dpc.getNextFieldNumber(aVar12))) {
                        }
                        auf.LDJ.add(axl);
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        aus aus = new aus();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = aus.populateBuilderWithField(aVar13, aus, dpc.getNextFieldNumber(aVar13))) {
                        }
                        auf.LEV.add(aus);
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 12:
                    auf.LEW = aVar3.UbS.zi();
                    AppMethodBeat.o(209470);
                    return 0;
                case 13:
                    auf.LEX = aVar3.UbS.zi();
                    AppMethodBeat.o(209470);
                    return 0;
                case 14:
                    auf.LEY = aVar3.UbS.zl();
                    AppMethodBeat.o(209470);
                    return 0;
                case 15:
                    auf.LEZ = aVar3.UbS.readString();
                    AppMethodBeat.o(209470);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        axt axt = new axt();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = axt.populateBuilderWithField(aVar14, axt, dpc.getNextFieldNumber(aVar14))) {
                        }
                        auf.location = axt;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        bel bel = new bel();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = bel.populateBuilderWithField(aVar15, bel, dpc.getNextFieldNumber(aVar15))) {
                        }
                        auf.ViI = bel;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 18:
                    auf.ViJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209470);
                    return 0;
                case 19:
                    auf.Viw.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209470);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        fge fge = new fge();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = fge.populateBuilderWithField(aVar16, fge, dpc.getNextFieldNumber(aVar16))) {
                        }
                        auf.ViK = fge;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        fhq fhq = new fhq();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = fhq.populateBuilderWithField(aVar17, fhq, dpc.getNextFieldNumber(aVar17))) {
                        }
                        auf.ViL = fhq;
                    }
                    AppMethodBeat.o(209470);
                    return 0;
                default:
                    AppMethodBeat.o(209470);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209470);
            return -1;
        }
    }
}

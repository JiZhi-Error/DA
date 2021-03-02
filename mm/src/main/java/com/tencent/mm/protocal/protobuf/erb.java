package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class erb extends a {
    public ccy KZS;
    public si KZV;
    public ehf Lov;
    public deq MCc;
    public bj MTm;
    public dpq MYf;
    public adv NoA;
    public jj NoB;
    public cin NoC;
    public cae NoD;
    public cxq NoE;
    public cdt NoF;
    public cdv NoG;
    public egf NoH;
    public adh NoI;
    public sj NoJ;
    public erg NoK;
    public efu Nov;
    public dyr Now;
    public crm Nox;
    public cte Noy;
    public uq Noz;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91724);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.Lov != null) {
                aVar.ni(2, this.Lov.computeSize());
                this.Lov.writeFields(aVar);
            }
            if (this.MYf != null) {
                aVar.ni(3, this.MYf.computeSize());
                this.MYf.writeFields(aVar);
            }
            if (this.Nov != null) {
                aVar.ni(4, this.Nov.computeSize());
                this.Nov.writeFields(aVar);
            }
            if (this.Now != null) {
                aVar.ni(5, this.Now.computeSize());
                this.Now.writeFields(aVar);
            }
            if (this.Nox != null) {
                aVar.ni(6, this.Nox.computeSize());
                this.Nox.writeFields(aVar);
            }
            if (this.Noy != null) {
                aVar.ni(7, this.Noy.computeSize());
                this.Noy.writeFields(aVar);
            }
            if (this.Noz != null) {
                aVar.ni(8, this.Noz.computeSize());
                this.Noz.writeFields(aVar);
            }
            if (this.NoA != null) {
                aVar.ni(9, this.NoA.computeSize());
                this.NoA.writeFields(aVar);
            }
            if (this.NoB != null) {
                aVar.ni(10, this.NoB.computeSize());
                this.NoB.writeFields(aVar);
            }
            if (this.KZV != null) {
                aVar.ni(11, this.KZV.computeSize());
                this.KZV.writeFields(aVar);
            }
            if (this.KZS != null) {
                aVar.ni(12, this.KZS.computeSize());
                this.KZS.writeFields(aVar);
            }
            if (this.NoC != null) {
                aVar.ni(13, this.NoC.computeSize());
                this.NoC.writeFields(aVar);
            }
            if (this.NoD != null) {
                aVar.ni(14, this.NoD.computeSize());
                this.NoD.writeFields(aVar);
            }
            if (this.MCc != null) {
                aVar.ni(15, this.MCc.computeSize());
                this.MCc.writeFields(aVar);
            }
            if (this.NoE != null) {
                aVar.ni(16, this.NoE.computeSize());
                this.NoE.writeFields(aVar);
            }
            if (this.NoF != null) {
                aVar.ni(17, this.NoF.computeSize());
                this.NoF.writeFields(aVar);
            }
            if (this.NoG != null) {
                aVar.ni(18, this.NoG.computeSize());
                this.NoG.writeFields(aVar);
            }
            if (this.NoH != null) {
                aVar.ni(19, this.NoH.computeSize());
                this.NoH.writeFields(aVar);
            }
            if (this.NoI != null) {
                aVar.ni(20, this.NoI.computeSize());
                this.NoI.writeFields(aVar);
            }
            if (this.NoJ != null) {
                aVar.ni(21, this.NoJ.computeSize());
                this.NoJ.writeFields(aVar);
            }
            if (this.MTm != null) {
                aVar.ni(22, this.MTm.computeSize());
                this.MTm.writeFields(aVar);
            }
            if (this.NoK != null) {
                aVar.ni(23, this.NoK.computeSize());
                this.NoK.writeFields(aVar);
            }
            AppMethodBeat.o(91724);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.Lov != null) {
                bu += g.a.a.a.nh(2, this.Lov.computeSize());
            }
            if (this.MYf != null) {
                bu += g.a.a.a.nh(3, this.MYf.computeSize());
            }
            if (this.Nov != null) {
                bu += g.a.a.a.nh(4, this.Nov.computeSize());
            }
            if (this.Now != null) {
                bu += g.a.a.a.nh(5, this.Now.computeSize());
            }
            if (this.Nox != null) {
                bu += g.a.a.a.nh(6, this.Nox.computeSize());
            }
            if (this.Noy != null) {
                bu += g.a.a.a.nh(7, this.Noy.computeSize());
            }
            if (this.Noz != null) {
                bu += g.a.a.a.nh(8, this.Noz.computeSize());
            }
            if (this.NoA != null) {
                bu += g.a.a.a.nh(9, this.NoA.computeSize());
            }
            if (this.NoB != null) {
                bu += g.a.a.a.nh(10, this.NoB.computeSize());
            }
            if (this.KZV != null) {
                bu += g.a.a.a.nh(11, this.KZV.computeSize());
            }
            if (this.KZS != null) {
                bu += g.a.a.a.nh(12, this.KZS.computeSize());
            }
            if (this.NoC != null) {
                bu += g.a.a.a.nh(13, this.NoC.computeSize());
            }
            if (this.NoD != null) {
                bu += g.a.a.a.nh(14, this.NoD.computeSize());
            }
            if (this.MCc != null) {
                bu += g.a.a.a.nh(15, this.MCc.computeSize());
            }
            if (this.NoE != null) {
                bu += g.a.a.a.nh(16, this.NoE.computeSize());
            }
            if (this.NoF != null) {
                bu += g.a.a.a.nh(17, this.NoF.computeSize());
            }
            if (this.NoG != null) {
                bu += g.a.a.a.nh(18, this.NoG.computeSize());
            }
            if (this.NoH != null) {
                bu += g.a.a.a.nh(19, this.NoH.computeSize());
            }
            if (this.NoI != null) {
                bu += g.a.a.a.nh(20, this.NoI.computeSize());
            }
            if (this.NoJ != null) {
                bu += g.a.a.a.nh(21, this.NoJ.computeSize());
            }
            if (this.MTm != null) {
                bu += g.a.a.a.nh(22, this.MTm.computeSize());
            }
            if (this.NoK != null) {
                bu += g.a.a.a.nh(23, this.NoK.computeSize());
            }
            AppMethodBeat.o(91724);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91724);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erb erb = (erb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    erb.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91724);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        erb.Lov = ehf;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpq dpq = new dpq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpq.populateBuilderWithField(aVar5, dpq, a.getNextFieldNumber(aVar5))) {
                        }
                        erb.MYf = dpq;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        efu efu = new efu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = efu.populateBuilderWithField(aVar6, efu, a.getNextFieldNumber(aVar6))) {
                        }
                        erb.Nov = efu;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dyr dyr = new dyr();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dyr.populateBuilderWithField(aVar7, dyr, a.getNextFieldNumber(aVar7))) {
                        }
                        erb.Now = dyr;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        crm crm = new crm();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = crm.populateBuilderWithField(aVar8, crm, a.getNextFieldNumber(aVar8))) {
                        }
                        erb.Nox = crm;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cte cte = new cte();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cte.populateBuilderWithField(aVar9, cte, a.getNextFieldNumber(aVar9))) {
                        }
                        erb.Noy = cte;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        uq uqVar = new uq();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = uqVar.populateBuilderWithField(aVar10, uqVar, a.getNextFieldNumber(aVar10))) {
                        }
                        erb.Noz = uqVar;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        adv adv = new adv();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = adv.populateBuilderWithField(aVar11, adv, a.getNextFieldNumber(aVar11))) {
                        }
                        erb.NoA = adv;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        jj jjVar = new jj();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = jjVar.populateBuilderWithField(aVar12, jjVar, a.getNextFieldNumber(aVar12))) {
                        }
                        erb.NoB = jjVar;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        si siVar = new si();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = siVar.populateBuilderWithField(aVar13, siVar, a.getNextFieldNumber(aVar13))) {
                        }
                        erb.KZV = siVar;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = ccy.populateBuilderWithField(aVar14, ccy, a.getNextFieldNumber(aVar14))) {
                        }
                        erb.KZS = ccy;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        cin cin = new cin();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = cin.populateBuilderWithField(aVar15, cin, a.getNextFieldNumber(aVar15))) {
                        }
                        erb.NoC = cin;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        cae cae = new cae();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = cae.populateBuilderWithField(aVar16, cae, a.getNextFieldNumber(aVar16))) {
                        }
                        erb.NoD = cae;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        deq deq = new deq();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = deq.populateBuilderWithField(aVar17, deq, a.getNextFieldNumber(aVar17))) {
                        }
                        erb.MCc = deq;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        cxq cxq = new cxq();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = cxq.populateBuilderWithField(aVar18, cxq, a.getNextFieldNumber(aVar18))) {
                        }
                        erb.NoE = cxq;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        cdt cdt = new cdt();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = cdt.populateBuilderWithField(aVar19, cdt, a.getNextFieldNumber(aVar19))) {
                        }
                        erb.NoF = cdt;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh17 = aVar3.awh(intValue);
                    int size17 = awh17.size();
                    for (int i19 = 0; i19 < size17; i19++) {
                        cdv cdv = new cdv();
                        g.a.a.a.a aVar20 = new g.a.a.a.a(awh17.get(i19), unknownTagHandler);
                        for (boolean z17 = true; z17; z17 = cdv.populateBuilderWithField(aVar20, cdv, a.getNextFieldNumber(aVar20))) {
                        }
                        erb.NoG = cdv;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh18 = aVar3.awh(intValue);
                    int size18 = awh18.size();
                    for (int i20 = 0; i20 < size18; i20++) {
                        egf egf = new egf();
                        g.a.a.a.a aVar21 = new g.a.a.a.a(awh18.get(i20), unknownTagHandler);
                        for (boolean z18 = true; z18; z18 = egf.populateBuilderWithField(aVar21, egf, a.getNextFieldNumber(aVar21))) {
                        }
                        erb.NoH = egf;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh19 = aVar3.awh(intValue);
                    int size19 = awh19.size();
                    for (int i21 = 0; i21 < size19; i21++) {
                        adh adh = new adh();
                        g.a.a.a.a aVar22 = new g.a.a.a.a(awh19.get(i21), unknownTagHandler);
                        for (boolean z19 = true; z19; z19 = adh.populateBuilderWithField(aVar22, adh, a.getNextFieldNumber(aVar22))) {
                        }
                        erb.NoI = adh;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh20 = aVar3.awh(intValue);
                    int size20 = awh20.size();
                    for (int i22 = 0; i22 < size20; i22++) {
                        sj sjVar = new sj();
                        g.a.a.a.a aVar23 = new g.a.a.a.a(awh20.get(i22), unknownTagHandler);
                        for (boolean z20 = true; z20; z20 = sjVar.populateBuilderWithField(aVar23, sjVar, a.getNextFieldNumber(aVar23))) {
                        }
                        erb.NoJ = sjVar;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh21 = aVar3.awh(intValue);
                    int size21 = awh21.size();
                    for (int i23 = 0; i23 < size21; i23++) {
                        bj bjVar = new bj();
                        g.a.a.a.a aVar24 = new g.a.a.a.a(awh21.get(i23), unknownTagHandler);
                        for (boolean z21 = true; z21; z21 = bjVar.populateBuilderWithField(aVar24, bjVar, a.getNextFieldNumber(aVar24))) {
                        }
                        erb.MTm = bjVar;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh22 = aVar3.awh(intValue);
                    int size22 = awh22.size();
                    for (int i24 = 0; i24 < size22; i24++) {
                        erg erg = new erg();
                        g.a.a.a.a aVar25 = new g.a.a.a.a(awh22.get(i24), unknownTagHandler);
                        for (boolean z22 = true; z22; z22 = erg.populateBuilderWithField(aVar25, erg, a.getNextFieldNumber(aVar25))) {
                        }
                        erb.NoK = erg;
                    }
                    AppMethodBeat.o(91724);
                    return 0;
                default:
                    AppMethodBeat.o(91724);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91724);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ean extends dop {
    public LinkedList<dqi> BlackList = new LinkedList<>();
    public int BlackListCount;
    public int GroupCount;
    public LinkedList<dqi> GroupUser = new LinkedList<>();
    public int GroupUserCount;
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t KLQ;
    public ekv MID;
    public int MZR;
    public int MZS;
    public int MZT;
    public eal MZU;
    public SKBuiltinBuffer_t MZV;
    public String MZW;
    public tt MZX;
    public int MZY;
    public LinkedList<cmz> MZZ = new LinkedList<>();
    public int MsV;
    public LinkedList<dzw> Mtb = new LinkedList<>();
    public eam Mtg;
    public dzk Naa;
    public cwz Nab;
    public SKBuiltinBuffer_t ObjectDesc;
    public long ReferId;
    public ear SnsRedEnvelops;
    public LinkedList<dqi> WithUserList = new LinkedList<>();
    public int WithUserListCount;
    public String izX;

    public ean() {
        AppMethodBeat.i(125805);
        AppMethodBeat.o(125805);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125806);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.ObjectDesc == null) {
                b bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(125806);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ObjectDesc != null) {
                aVar.ni(2, this.ObjectDesc.computeSize());
                this.ObjectDesc.writeFields(aVar);
            }
            aVar.aM(3, this.WithUserListCount);
            aVar.e(4, 8, this.WithUserList);
            aVar.aM(5, this.MZR);
            aVar.aM(6, this.MsV);
            if (this.izX != null) {
                aVar.e(7, this.izX);
            }
            aVar.aM(8, this.MZS);
            aVar.aM(9, this.GroupCount);
            aVar.e(10, 8, this.Mtb);
            aVar.aM(11, this.MZT);
            aVar.bb(12, this.ReferId);
            aVar.aM(13, this.BlackListCount);
            aVar.e(14, 8, this.BlackList);
            if (this.MID != null) {
                aVar.ni(15, this.MID.computeSize());
                this.MID.writeFields(aVar);
            }
            aVar.aM(16, this.GroupUserCount);
            aVar.e(17, 8, this.GroupUser);
            if (this.MZU != null) {
                aVar.ni(18, this.MZU.computeSize());
                this.MZU.writeFields(aVar);
            }
            if (this.Mtg != null) {
                aVar.ni(19, this.Mtg.computeSize());
                this.Mtg.writeFields(aVar);
            }
            if (this.SnsRedEnvelops != null) {
                aVar.ni(20, this.SnsRedEnvelops.computeSize());
                this.SnsRedEnvelops.writeFields(aVar);
            }
            if (this.MZV != null) {
                aVar.ni(21, this.MZV.computeSize());
                this.MZV.writeFields(aVar);
            }
            if (this.MZW != null) {
                aVar.e(22, this.MZW);
            }
            if (this.MZX != null) {
                aVar.ni(23, this.MZX.computeSize());
                this.MZX.writeFields(aVar);
            }
            aVar.aM(24, this.MZY);
            aVar.e(25, 8, this.MZZ);
            if (this.Naa != null) {
                aVar.ni(26, this.Naa.computeSize());
                this.Naa.writeFields(aVar);
            }
            if (this.KLP != null) {
                aVar.ni(27, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            if (this.KLQ != null) {
                aVar.ni(28, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            if (this.Nab != null) {
                aVar.ni(29, this.Nab.computeSize());
                this.Nab.writeFields(aVar);
            }
            AppMethodBeat.o(125806);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.ObjectDesc != null) {
                nh += g.a.a.a.nh(2, this.ObjectDesc.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.WithUserListCount) + g.a.a.a.c(4, 8, this.WithUserList) + g.a.a.b.b.a.bu(5, this.MZR) + g.a.a.b.b.a.bu(6, this.MsV);
            if (this.izX != null) {
                bu += g.a.a.b.b.a.f(7, this.izX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MZS) + g.a.a.b.b.a.bu(9, this.GroupCount) + g.a.a.a.c(10, 8, this.Mtb) + g.a.a.b.b.a.bu(11, this.MZT) + g.a.a.b.b.a.r(12, this.ReferId) + g.a.a.b.b.a.bu(13, this.BlackListCount) + g.a.a.a.c(14, 8, this.BlackList);
            if (this.MID != null) {
                bu2 += g.a.a.a.nh(15, this.MID.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.GroupUserCount) + g.a.a.a.c(17, 8, this.GroupUser);
            if (this.MZU != null) {
                bu3 += g.a.a.a.nh(18, this.MZU.computeSize());
            }
            if (this.Mtg != null) {
                bu3 += g.a.a.a.nh(19, this.Mtg.computeSize());
            }
            if (this.SnsRedEnvelops != null) {
                bu3 += g.a.a.a.nh(20, this.SnsRedEnvelops.computeSize());
            }
            if (this.MZV != null) {
                bu3 += g.a.a.a.nh(21, this.MZV.computeSize());
            }
            if (this.MZW != null) {
                bu3 += g.a.a.b.b.a.f(22, this.MZW);
            }
            if (this.MZX != null) {
                bu3 += g.a.a.a.nh(23, this.MZX.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(24, this.MZY) + g.a.a.a.c(25, 8, this.MZZ);
            if (this.Naa != null) {
                bu4 += g.a.a.a.nh(26, this.Naa.computeSize());
            }
            if (this.KLP != null) {
                bu4 += g.a.a.a.nh(27, this.KLP.computeSize());
            }
            if (this.KLQ != null) {
                bu4 += g.a.a.a.nh(28, this.KLQ.computeSize());
            }
            if (this.Nab != null) {
                bu4 += g.a.a.a.nh(29, this.Nab.computeSize());
            }
            AppMethodBeat.o(125806);
            return bu4;
        } else if (i2 == 2) {
            this.WithUserList.clear();
            this.Mtb.clear();
            this.BlackList.clear();
            this.GroupUser.clear();
            this.MZZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ObjectDesc == null) {
                b bVar2 = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(125806);
                throw bVar2;
            }
            AppMethodBeat.o(125806);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ean ean = (ean) objArr[1];
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
                        ean.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ean.ObjectDesc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 3:
                    ean.WithUserListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        ean.WithUserList.add(dqi);
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 5:
                    ean.MZR = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 6:
                    ean.MsV = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 7:
                    ean.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125806);
                    return 0;
                case 8:
                    ean.MZS = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 9:
                    ean.GroupCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dzw dzw = new dzw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dzw.populateBuilderWithField(aVar7, dzw, dop.getNextFieldNumber(aVar7))) {
                        }
                        ean.Mtb.add(dzw);
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 11:
                    ean.MZT = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 12:
                    ean.ReferId = aVar3.UbS.zl();
                    AppMethodBeat.o(125806);
                    return 0;
                case 13:
                    ean.BlackListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi2.populateBuilderWithField(aVar8, dqi2, dop.getNextFieldNumber(aVar8))) {
                        }
                        ean.BlackList.add(dqi2);
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ekv ekv = new ekv();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ekv.populateBuilderWithField(aVar9, ekv, dop.getNextFieldNumber(aVar9))) {
                        }
                        ean.MID = ekv;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 16:
                    ean.GroupUserCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi3.populateBuilderWithField(aVar10, dqi3, dop.getNextFieldNumber(aVar10))) {
                        }
                        ean.GroupUser.add(dqi3);
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        eal eal = new eal();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = eal.populateBuilderWithField(aVar11, eal, dop.getNextFieldNumber(aVar11))) {
                        }
                        ean.MZU = eal;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        eam eam = new eam();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = eam.populateBuilderWithField(aVar12, eam, dop.getNextFieldNumber(aVar12))) {
                        }
                        ean.Mtg = eam;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        ear ear = new ear();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = ear.populateBuilderWithField(aVar13, ear, dop.getNextFieldNumber(aVar13))) {
                        }
                        ean.SnsRedEnvelops = ear;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar14, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar14))) {
                        }
                        ean.MZV = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 22:
                    ean.MZW = aVar3.UbS.readString();
                    AppMethodBeat.o(125806);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        tt ttVar = new tt();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = ttVar.populateBuilderWithField(aVar15, ttVar, dop.getNextFieldNumber(aVar15))) {
                        }
                        ean.MZX = ttVar;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 24:
                    ean.MZY = aVar3.UbS.zi();
                    AppMethodBeat.o(125806);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        cmz cmz = new cmz();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = cmz.populateBuilderWithField(aVar16, cmz, dop.getNextFieldNumber(aVar16))) {
                        }
                        ean.MZZ.add(cmz);
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        dzk dzk = new dzk();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = dzk.populateBuilderWithField(aVar17, dzk, dop.getNextFieldNumber(aVar17))) {
                        }
                        ean.Naa = dzk;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar18, sKBuiltinBuffer_t3, dop.getNextFieldNumber(aVar18))) {
                        }
                        ean.KLP = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar19, sKBuiltinBuffer_t4, dop.getNextFieldNumber(aVar19))) {
                        }
                        ean.KLQ = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                case 29:
                    LinkedList<byte[]> awh17 = aVar3.awh(intValue);
                    int size17 = awh17.size();
                    for (int i19 = 0; i19 < size17; i19++) {
                        cwz cwz = new cwz();
                        g.a.a.a.a aVar20 = new g.a.a.a.a(awh17.get(i19), unknownTagHandler);
                        for (boolean z17 = true; z17; z17 = cwz.populateBuilderWithField(aVar20, cwz, dop.getNextFieldNumber(aVar20))) {
                        }
                        ean.Nab = cwz;
                    }
                    AppMethodBeat.o(125806);
                    return 0;
                default:
                    AppMethodBeat.o(125806);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125806);
            return -1;
        }
    }
}

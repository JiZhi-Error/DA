package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ayk extends a {
    public String LBr;
    public long LCX;
    public int LEa;
    public String LIB;
    public String LIC;
    public azp LID;
    public ayn LIE;
    public ayn LIF;
    public ayl LIG;
    public LinkedList<FinderContact> LIH = new LinkedList<>();
    public int LII;
    public int LIJ;
    public long LIK;
    public String LIL;
    public int cSx;
    public long commentId;
    public String description;
    public int extFlag;
    public String fQY;
    public long hFK;
    public String headUrl;
    public int iXu;
    public long id;
    public int mediaType;
    public String nickName;
    public String objectNonceId;
    public int objectType;
    public String replyNickname;
    public String thumbUrl;
    public String username;

    public ayk() {
        AppMethodBeat.i(209591);
        AppMethodBeat.o(209591);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169009);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.headUrl != null) {
                aVar.e(1, this.headUrl);
            }
            if (this.nickName != null) {
                aVar.e(2, this.nickName);
            }
            aVar.aM(3, this.LEa);
            if (this.LIB != null) {
                aVar.e(4, this.LIB);
            }
            aVar.aM(5, this.iXu);
            if (this.thumbUrl != null) {
                aVar.e(6, this.thumbUrl);
            }
            aVar.bb(7, this.id);
            aVar.bb(8, this.hFK);
            aVar.bb(9, this.commentId);
            aVar.aM(10, this.cSx);
            aVar.aM(11, this.extFlag);
            if (this.LIC != null) {
                aVar.e(12, this.LIC);
            }
            if (this.LID != null) {
                aVar.ni(13, this.LID.computeSize());
                this.LID.writeFields(aVar);
            }
            aVar.aM(14, this.mediaType);
            if (this.description != null) {
                aVar.e(15, this.description);
            }
            if (this.replyNickname != null) {
                aVar.e(16, this.replyNickname);
            }
            if (this.LBr != null) {
                aVar.e(17, this.LBr);
            }
            if (this.objectNonceId != null) {
                aVar.e(18, this.objectNonceId);
            }
            if (this.username != null) {
                aVar.e(19, this.username);
            }
            if (this.LIE != null) {
                aVar.ni(20, this.LIE.computeSize());
                this.LIE.writeFields(aVar);
            }
            if (this.LIF != null) {
                aVar.ni(21, this.LIF.computeSize());
                this.LIF.writeFields(aVar);
            }
            if (this.LIG != null) {
                aVar.ni(22, this.LIG.computeSize());
                this.LIG.writeFields(aVar);
            }
            aVar.e(23, 8, this.LIH);
            aVar.aM(24, this.LII);
            aVar.aM(25, this.LIJ);
            if (this.fQY != null) {
                aVar.e(26, this.fQY);
            }
            aVar.bb(27, this.LCX);
            aVar.aM(28, this.objectType);
            aVar.bb(29, this.LIK);
            if (this.LIL != null) {
                aVar.e(30, this.LIL);
            }
            AppMethodBeat.o(169009);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.headUrl != null ? g.a.a.b.b.a.f(1, this.headUrl) + 0 : 0;
            if (this.nickName != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.LEa);
            if (this.LIB != null) {
                bu += g.a.a.b.b.a.f(4, this.LIB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.iXu);
            if (this.thumbUrl != null) {
                bu2 += g.a.a.b.b.a.f(6, this.thumbUrl);
            }
            int r = bu2 + g.a.a.b.b.a.r(7, this.id) + g.a.a.b.b.a.r(8, this.hFK) + g.a.a.b.b.a.r(9, this.commentId) + g.a.a.b.b.a.bu(10, this.cSx) + g.a.a.b.b.a.bu(11, this.extFlag);
            if (this.LIC != null) {
                r += g.a.a.b.b.a.f(12, this.LIC);
            }
            if (this.LID != null) {
                r += g.a.a.a.nh(13, this.LID.computeSize());
            }
            int bu3 = r + g.a.a.b.b.a.bu(14, this.mediaType);
            if (this.description != null) {
                bu3 += g.a.a.b.b.a.f(15, this.description);
            }
            if (this.replyNickname != null) {
                bu3 += g.a.a.b.b.a.f(16, this.replyNickname);
            }
            if (this.LBr != null) {
                bu3 += g.a.a.b.b.a.f(17, this.LBr);
            }
            if (this.objectNonceId != null) {
                bu3 += g.a.a.b.b.a.f(18, this.objectNonceId);
            }
            if (this.username != null) {
                bu3 += g.a.a.b.b.a.f(19, this.username);
            }
            if (this.LIE != null) {
                bu3 += g.a.a.a.nh(20, this.LIE.computeSize());
            }
            if (this.LIF != null) {
                bu3 += g.a.a.a.nh(21, this.LIF.computeSize());
            }
            if (this.LIG != null) {
                bu3 += g.a.a.a.nh(22, this.LIG.computeSize());
            }
            int c2 = bu3 + g.a.a.a.c(23, 8, this.LIH) + g.a.a.b.b.a.bu(24, this.LII) + g.a.a.b.b.a.bu(25, this.LIJ);
            if (this.fQY != null) {
                c2 += g.a.a.b.b.a.f(26, this.fQY);
            }
            int r2 = c2 + g.a.a.b.b.a.r(27, this.LCX) + g.a.a.b.b.a.bu(28, this.objectType) + g.a.a.b.b.a.r(29, this.LIK);
            if (this.LIL != null) {
                r2 += g.a.a.b.b.a.f(30, this.LIL);
            }
            AppMethodBeat.o(169009);
            return r2;
        } else if (i2 == 2) {
            this.LIH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169009);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayk ayk = (ayk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayk.headUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 2:
                    ayk.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 3:
                    ayk.LEa = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 4:
                    ayk.LIB = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 5:
                    ayk.iXu = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 6:
                    ayk.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 7:
                    ayk.id = aVar3.UbS.zl();
                    AppMethodBeat.o(169009);
                    return 0;
                case 8:
                    ayk.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(169009);
                    return 0;
                case 9:
                    ayk.commentId = aVar3.UbS.zl();
                    AppMethodBeat.o(169009);
                    return 0;
                case 10:
                    ayk.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 11:
                    ayk.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 12:
                    ayk.LIC = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        azp azp = new azp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = azp.populateBuilderWithField(aVar4, azp, a.getNextFieldNumber(aVar4))) {
                        }
                        ayk.LID = azp;
                    }
                    AppMethodBeat.o(169009);
                    return 0;
                case 14:
                    ayk.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 15:
                    ayk.description = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 16:
                    ayk.replyNickname = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 17:
                    ayk.LBr = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 18:
                    ayk.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 19:
                    ayk.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ayn ayn = new ayn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ayn.populateBuilderWithField(aVar5, ayn, a.getNextFieldNumber(aVar5))) {
                        }
                        ayk.LIE = ayn;
                    }
                    AppMethodBeat.o(169009);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ayn ayn2 = new ayn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ayn2.populateBuilderWithField(aVar6, ayn2, a.getNextFieldNumber(aVar6))) {
                        }
                        ayk.LIF = ayn2;
                    }
                    AppMethodBeat.o(169009);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ayl ayl = new ayl();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ayl.populateBuilderWithField(aVar7, ayl, a.getNextFieldNumber(aVar7))) {
                        }
                        ayk.LIG = ayl;
                    }
                    AppMethodBeat.o(169009);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderContact.populateBuilderWithField(aVar8, finderContact, a.getNextFieldNumber(aVar8))) {
                        }
                        ayk.LIH.add(finderContact);
                    }
                    AppMethodBeat.o(169009);
                    return 0;
                case 24:
                    ayk.LII = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 25:
                    ayk.LIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 26:
                    ayk.fQY = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                case 27:
                    ayk.LCX = aVar3.UbS.zl();
                    AppMethodBeat.o(169009);
                    return 0;
                case 28:
                    ayk.objectType = aVar3.UbS.zi();
                    AppMethodBeat.o(169009);
                    return 0;
                case 29:
                    ayk.LIK = aVar3.UbS.zl();
                    AppMethodBeat.o(169009);
                    return 0;
                case 30:
                    ayk.LIL = aVar3.UbS.readString();
                    AppMethodBeat.o(169009);
                    return 0;
                default:
                    AppMethodBeat.o(169009);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169009);
            return -1;
        }
    }
}

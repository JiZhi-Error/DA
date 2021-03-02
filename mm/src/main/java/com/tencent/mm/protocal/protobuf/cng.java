package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cng extends a {
    public String LOd;
    public cnl MtG;
    public int MtH;
    public cns MtI;
    public String MtJ;
    public int MtK;
    public int MtL;
    public String MtM;
    public int commentCount;
    public String debugMessage;
    public int favCount;
    public int favFlag;
    public int forwardCount;
    public int friendLikeCount;
    public int iXu;
    public long id;
    public boolean jiQ;
    public int likeCount;
    public int likeFlag;
    public int permissionFlag;
    public int privateFlag;
    public int readCount;
    public String sessionBuffer;
    public int status;
    public int urlValidDuration;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209732);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            aVar.aM(2, this.iXu);
            if (this.MtG != null) {
                aVar.ni(3, this.MtG.computeSize());
                this.MtG.writeFields(aVar);
            }
            aVar.aM(4, this.forwardCount);
            aVar.aM(5, this.likeCount);
            aVar.aM(6, this.commentCount);
            aVar.aM(7, this.favCount);
            aVar.aM(8, this.friendLikeCount);
            aVar.aM(9, this.MtH);
            if (this.LOd != null) {
                aVar.e(10, this.LOd);
            }
            aVar.cc(11, this.jiQ);
            aVar.aM(12, this.readCount);
            if (this.sessionBuffer != null) {
                aVar.e(13, this.sessionBuffer);
            }
            aVar.aM(14, this.favFlag);
            aVar.aM(15, this.urlValidDuration);
            aVar.aM(16, this.privateFlag);
            if (this.debugMessage != null) {
                aVar.e(17, this.debugMessage);
            }
            aVar.aM(18, this.permissionFlag);
            if (this.MtI != null) {
                aVar.ni(19, this.MtI.computeSize());
                this.MtI.writeFields(aVar);
            }
            aVar.aM(20, this.status);
            if (this.MtJ != null) {
                aVar.e(21, this.MtJ);
            }
            aVar.aM(22, this.MtK);
            aVar.aM(23, this.likeFlag);
            aVar.aM(24, this.MtL);
            if (this.MtM != null) {
                aVar.e(25, this.MtM);
            }
            AppMethodBeat.o(209732);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.iXu);
            if (this.MtG != null) {
                r += g.a.a.a.nh(3, this.MtG.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.forwardCount) + g.a.a.b.b.a.bu(5, this.likeCount) + g.a.a.b.b.a.bu(6, this.commentCount) + g.a.a.b.b.a.bu(7, this.favCount) + g.a.a.b.b.a.bu(8, this.friendLikeCount) + g.a.a.b.b.a.bu(9, this.MtH);
            if (this.LOd != null) {
                bu += g.a.a.b.b.a.f(10, this.LOd);
            }
            int fS = bu + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.bu(12, this.readCount);
            if (this.sessionBuffer != null) {
                fS += g.a.a.b.b.a.f(13, this.sessionBuffer);
            }
            int bu2 = fS + g.a.a.b.b.a.bu(14, this.favFlag) + g.a.a.b.b.a.bu(15, this.urlValidDuration) + g.a.a.b.b.a.bu(16, this.privateFlag);
            if (this.debugMessage != null) {
                bu2 += g.a.a.b.b.a.f(17, this.debugMessage);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(18, this.permissionFlag);
            if (this.MtI != null) {
                bu3 += g.a.a.a.nh(19, this.MtI.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(20, this.status);
            if (this.MtJ != null) {
                bu4 += g.a.a.b.b.a.f(21, this.MtJ);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(22, this.MtK) + g.a.a.b.b.a.bu(23, this.likeFlag) + g.a.a.b.b.a.bu(24, this.MtL);
            if (this.MtM != null) {
                bu5 += g.a.a.b.b.a.f(25, this.MtM);
            }
            AppMethodBeat.o(209732);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209732);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cng cng = (cng) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cng.id = aVar3.UbS.zl();
                    AppMethodBeat.o(209732);
                    return 0;
                case 2:
                    cng.iXu = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cnl cnl = new cnl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnl.populateBuilderWithField(aVar4, cnl, a.getNextFieldNumber(aVar4))) {
                        }
                        cng.MtG = cnl;
                    }
                    AppMethodBeat.o(209732);
                    return 0;
                case 4:
                    cng.forwardCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 5:
                    cng.likeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 6:
                    cng.commentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 7:
                    cng.favCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 8:
                    cng.friendLikeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 9:
                    cng.MtH = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 10:
                    cng.LOd = aVar3.UbS.readString();
                    AppMethodBeat.o(209732);
                    return 0;
                case 11:
                    cng.jiQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(209732);
                    return 0;
                case 12:
                    cng.readCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 13:
                    cng.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209732);
                    return 0;
                case 14:
                    cng.favFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 15:
                    cng.urlValidDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 16:
                    cng.privateFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 17:
                    cng.debugMessage = aVar3.UbS.readString();
                    AppMethodBeat.o(209732);
                    return 0;
                case 18:
                    cng.permissionFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cns cns = new cns();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cns.populateBuilderWithField(aVar5, cns, a.getNextFieldNumber(aVar5))) {
                        }
                        cng.MtI = cns;
                    }
                    AppMethodBeat.o(209732);
                    return 0;
                case 20:
                    cng.status = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 21:
                    cng.MtJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209732);
                    return 0;
                case 22:
                    cng.MtK = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 23:
                    cng.likeFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 24:
                    cng.MtL = aVar3.UbS.zi();
                    AppMethodBeat.o(209732);
                    return 0;
                case 25:
                    cng.MtM = aVar3.UbS.readString();
                    AppMethodBeat.o(209732);
                    return 0;
                default:
                    AppMethodBeat.o(209732);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209732);
            return -1;
        }
    }
}

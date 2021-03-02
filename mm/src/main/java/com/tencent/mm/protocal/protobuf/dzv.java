package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dzv extends a {
    public int CHZ = -1;
    public int EOS = 0;
    public LinkedList<anw> MZr = new LinkedList<>();
    public long MZs = 0;
    public double MZt = 0.0d;
    public double MZu = 0.0d;
    public int commentCount;
    public boolean ddZ = false;
    public long endTime = -1;
    public String feedId;
    public int height = -1;
    public boolean isAd = false;
    public int likeCount;
    public int mEY = -1;
    public String nickName;
    public long startTime = -1;
    public int udM = -1;
    public String userName;
    public int virtualKeyHeight = 0;
    public int vp = 0;
    public int y = -1;

    public dzv() {
        AppMethodBeat.i(122546);
        AppMethodBeat.o(122546);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122547);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.feedId != null) {
                aVar.e(1, this.feedId);
            }
            aVar.aM(2, this.y);
            aVar.aM(3, this.height);
            aVar.aM(4, this.mEY);
            aVar.aM(5, this.virtualKeyHeight);
            aVar.aM(6, this.CHZ);
            aVar.aM(7, this.udM);
            aVar.aM(8, this.vp);
            aVar.aM(9, this.EOS);
            aVar.cc(10, this.ddZ);
            aVar.bb(11, this.startTime);
            aVar.bb(12, this.endTime);
            aVar.e(13, 8, this.MZr);
            aVar.bb(14, this.MZs);
            aVar.e(15, this.MZt);
            aVar.e(16, this.MZu);
            aVar.aM(17, this.commentCount);
            aVar.aM(18, this.likeCount);
            if (this.userName != null) {
                aVar.e(19, this.userName);
            }
            aVar.cc(20, this.isAd);
            if (this.nickName != null) {
                aVar.e(21, this.nickName);
            }
            AppMethodBeat.o(122547);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.feedId != null ? g.a.a.b.b.a.f(1, this.feedId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.y) + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.mEY) + g.a.a.b.b.a.bu(5, this.virtualKeyHeight) + g.a.a.b.b.a.bu(6, this.CHZ) + g.a.a.b.b.a.bu(7, this.udM) + g.a.a.b.b.a.bu(8, this.vp) + g.a.a.b.b.a.bu(9, this.EOS) + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.r(11, this.startTime) + g.a.a.b.b.a.r(12, this.endTime) + g.a.a.a.c(13, 8, this.MZr) + g.a.a.b.b.a.r(14, this.MZs) + g.a.a.b.b.a.fS(15) + 8 + g.a.a.b.b.a.fS(16) + 8 + g.a.a.b.b.a.bu(17, this.commentCount) + g.a.a.b.b.a.bu(18, this.likeCount);
            if (this.userName != null) {
                f2 += g.a.a.b.b.a.f(19, this.userName);
            }
            int fS = f2 + g.a.a.b.b.a.fS(20) + 1;
            if (this.nickName != null) {
                fS += g.a.a.b.b.a.f(21, this.nickName);
            }
            AppMethodBeat.o(122547);
            return fS;
        } else if (i2 == 2) {
            this.MZr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122547);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzv dzv = (dzv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzv.feedId = aVar3.UbS.readString();
                    AppMethodBeat.o(122547);
                    return 0;
                case 2:
                    dzv.y = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 3:
                    dzv.height = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 4:
                    dzv.mEY = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 5:
                    dzv.virtualKeyHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 6:
                    dzv.CHZ = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 7:
                    dzv.udM = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 8:
                    dzv.vp = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 9:
                    dzv.EOS = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 10:
                    dzv.ddZ = aVar3.UbS.yZ();
                    AppMethodBeat.o(122547);
                    return 0;
                case 11:
                    dzv.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122547);
                    return 0;
                case 12:
                    dzv.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122547);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anw anw = new anw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anw.populateBuilderWithField(aVar4, anw, a.getNextFieldNumber(aVar4))) {
                        }
                        dzv.MZr.add(anw);
                    }
                    AppMethodBeat.o(122547);
                    return 0;
                case 14:
                    dzv.MZs = aVar3.UbS.zl();
                    AppMethodBeat.o(122547);
                    return 0;
                case 15:
                    dzv.MZt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(122547);
                    return 0;
                case 16:
                    dzv.MZu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(122547);
                    return 0;
                case 17:
                    dzv.commentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 18:
                    dzv.likeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(122547);
                    return 0;
                case 19:
                    dzv.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(122547);
                    return 0;
                case 20:
                    dzv.isAd = aVar3.UbS.yZ();
                    AppMethodBeat.o(122547);
                    return 0;
                case 21:
                    dzv.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(122547);
                    return 0;
                default:
                    AppMethodBeat.o(122547);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122547);
            return -1;
        }
    }
}

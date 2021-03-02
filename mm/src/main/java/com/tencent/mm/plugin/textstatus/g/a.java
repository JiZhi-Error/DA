package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class a extends com.tencent.mm.bw.a {
    public String FZB;
    public String Gae;
    public boolean Gaf;
    public int Gag;
    public String Gah;
    public String Gai;
    public String Gaj;
    public LinkedList<r> Gak = new LinkedList<>();
    public long VdK;
    public int VdL;
    public int VdM;
    public int VdN;
    public int VdO;
    public String VdP;
    public String brandName;
    public String desc;
    public long enterTime;
    public String fileUrl;
    public String fuN;
    public String iFo;
    public String jhb;
    public int mediaType;
    public String sessionId;
    public String thumbUrl;

    public a() {
        AppMethodBeat.i(222817);
        AppMethodBeat.o(222817);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222818);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Gae != null) {
                aVar.e(1, this.Gae);
            }
            if (this.FZB != null) {
                aVar.e(2, this.FZB);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.e(4, this.thumbUrl);
            }
            if (this.fileUrl != null) {
                aVar.e(5, this.fileUrl);
            }
            if (this.jhb != null) {
                aVar.e(6, this.jhb);
            }
            if (this.brandName != null) {
                aVar.e(7, this.brandName);
            }
            aVar.cc(8, this.Gaf);
            aVar.aM(9, this.mediaType);
            aVar.aM(10, this.Gag);
            if (this.Gah != null) {
                aVar.e(11, this.Gah);
            }
            if (this.Gai != null) {
                aVar.e(12, this.Gai);
            }
            if (this.fuN != null) {
                aVar.e(13, this.fuN);
            }
            if (this.iFo != null) {
                aVar.e(14, this.iFo);
            }
            if (this.Gaj != null) {
                aVar.e(15, this.Gaj);
            }
            aVar.e(16, 8, this.Gak);
            if (this.sessionId != null) {
                aVar.e(17, this.sessionId);
            }
            aVar.bb(18, this.VdK);
            aVar.bb(19, this.enterTime);
            aVar.aM(20, this.VdL);
            aVar.aM(21, this.VdM);
            aVar.aM(22, this.VdN);
            aVar.aM(23, this.VdO);
            if (this.VdP != null) {
                aVar.e(24, this.VdP);
            }
            AppMethodBeat.o(222818);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Gae != null ? g.a.a.b.b.a.f(1, this.Gae) + 0 : 0;
            if (this.FZB != null) {
                f2 += g.a.a.b.b.a.f(2, this.FZB);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            if (this.thumbUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.thumbUrl);
            }
            if (this.fileUrl != null) {
                f2 += g.a.a.b.b.a.f(5, this.fileUrl);
            }
            if (this.jhb != null) {
                f2 += g.a.a.b.b.a.f(6, this.jhb);
            }
            if (this.brandName != null) {
                f2 += g.a.a.b.b.a.f(7, this.brandName);
            }
            int fS = f2 + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.bu(9, this.mediaType) + g.a.a.b.b.a.bu(10, this.Gag);
            if (this.Gah != null) {
                fS += g.a.a.b.b.a.f(11, this.Gah);
            }
            if (this.Gai != null) {
                fS += g.a.a.b.b.a.f(12, this.Gai);
            }
            if (this.fuN != null) {
                fS += g.a.a.b.b.a.f(13, this.fuN);
            }
            if (this.iFo != null) {
                fS += g.a.a.b.b.a.f(14, this.iFo);
            }
            if (this.Gaj != null) {
                fS += g.a.a.b.b.a.f(15, this.Gaj);
            }
            int c2 = fS + g.a.a.a.c(16, 8, this.Gak);
            if (this.sessionId != null) {
                c2 += g.a.a.b.b.a.f(17, this.sessionId);
            }
            int r = c2 + g.a.a.b.b.a.r(18, this.VdK) + g.a.a.b.b.a.r(19, this.enterTime) + g.a.a.b.b.a.bu(20, this.VdL) + g.a.a.b.b.a.bu(21, this.VdM) + g.a.a.b.b.a.bu(22, this.VdN) + g.a.a.b.b.a.bu(23, this.VdO);
            if (this.VdP != null) {
                r += g.a.a.b.b.a.f(24, this.VdP);
            }
            AppMethodBeat.o(222818);
            return r;
        } else if (i2 == 2) {
            this.Gak.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222818);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.Gae = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 2:
                    aVar4.FZB = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 3:
                    aVar4.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 4:
                    aVar4.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 5:
                    aVar4.fileUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 6:
                    aVar4.jhb = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 7:
                    aVar4.brandName = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 8:
                    aVar4.Gaf = aVar3.UbS.yZ();
                    AppMethodBeat.o(222818);
                    return 0;
                case 9:
                    aVar4.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 10:
                    aVar4.Gag = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 11:
                    aVar4.Gah = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 12:
                    aVar4.Gai = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 13:
                    aVar4.fuN = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 14:
                    aVar4.iFo = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 15:
                    aVar4.Gaj = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        r rVar = new r();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = rVar.populateBuilderWithField(aVar5, rVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.Gak.add(rVar);
                    }
                    AppMethodBeat.o(222818);
                    return 0;
                case 17:
                    aVar4.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                case 18:
                    aVar4.VdK = aVar3.UbS.zl();
                    AppMethodBeat.o(222818);
                    return 0;
                case 19:
                    aVar4.enterTime = aVar3.UbS.zl();
                    AppMethodBeat.o(222818);
                    return 0;
                case 20:
                    aVar4.VdL = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 21:
                    aVar4.VdM = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 22:
                    aVar4.VdN = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 23:
                    aVar4.VdO = aVar3.UbS.zi();
                    AppMethodBeat.o(222818);
                    return 0;
                case 24:
                    aVar4.VdP = aVar3.UbS.readString();
                    AppMethodBeat.o(222818);
                    return 0;
                default:
                    AppMethodBeat.o(222818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222818);
            return -1;
        }
    }
}

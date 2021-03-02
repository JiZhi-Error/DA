package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cnb extends a {
    public String Desc;
    public int ERX;
    public String EpK;
    public String Id;
    public int Mcw;
    public int MsA;
    public cnd MsB;
    public String MsC;
    public int MsD;
    public int MsE;
    public String MsF;
    public String MsG;
    public String MsH;
    public String MsI;
    public String MsJ;
    public int MsK;
    public long MsL;
    public String MsM;
    public int MsN;
    public String MsO;
    public String MsP;
    public int MsQ;
    public String MsR;
    public String MsS;
    public float MsT;
    public String Msz;
    public int Privated;
    public String Title;
    public String Url;
    public int ecf;
    public boolean isAd;
    public String md5;
    public int mediaType;
    public int oUv;
    public String songAlbumUrl;
    public String songLyric;
    public int subType;
    public String viB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125743);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            aVar.aM(2, this.oUv);
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            aVar.aM(5, this.Mcw);
            if (this.Msz != null) {
                aVar.e(6, this.Msz);
            }
            aVar.aM(7, this.MsA);
            aVar.aM(8, this.Privated);
            if (this.Title != null) {
                aVar.e(9, this.Title);
            }
            if (this.MsB != null) {
                aVar.ni(10, this.MsB.computeSize());
                this.MsB.writeFields(aVar);
            }
            if (this.MsC != null) {
                aVar.e(11, this.MsC);
            }
            aVar.aM(12, this.MsD);
            aVar.aM(13, this.ecf);
            aVar.aM(14, this.MsE);
            if (this.EpK != null) {
                aVar.e(15, this.EpK);
            }
            aVar.aM(16, this.subType);
            if (this.md5 != null) {
                aVar.e(17, this.md5);
            }
            if (this.MsF != null) {
                aVar.e(18, this.MsF);
            }
            if (this.MsG != null) {
                aVar.e(19, this.MsG);
            }
            if (this.MsH != null) {
                aVar.e(20, this.MsH);
            }
            aVar.aM(21, this.ERX);
            if (this.MsI != null) {
                aVar.e(22, this.MsI);
            }
            if (this.MsJ != null) {
                aVar.e(23, this.MsJ);
            }
            aVar.aM(24, this.MsK);
            aVar.bb(25, this.MsL);
            if (this.MsM != null) {
                aVar.e(26, this.MsM);
            }
            if (this.viB != null) {
                aVar.e(27, this.viB);
            }
            aVar.aM(28, this.MsN);
            if (this.MsO != null) {
                aVar.e(29, this.MsO);
            }
            if (this.MsP != null) {
                aVar.e(30, this.MsP);
            }
            aVar.aM(31, this.MsQ);
            if (this.MsR != null) {
                aVar.e(32, this.MsR);
            }
            if (this.MsS != null) {
                aVar.e(33, this.MsS);
            }
            aVar.cc(34, this.isAd);
            if (this.songAlbumUrl != null) {
                aVar.e(35, this.songAlbumUrl);
            }
            if (this.songLyric != null) {
                aVar.e(36, this.songLyric);
            }
            aVar.E(37, this.MsT);
            aVar.aM(38, this.mediaType);
            AppMethodBeat.o(125743);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(4, this.Url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Mcw);
            if (this.Msz != null) {
                bu += g.a.a.b.b.a.f(6, this.Msz);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MsA) + g.a.a.b.b.a.bu(8, this.Privated);
            if (this.Title != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Title);
            }
            if (this.MsB != null) {
                bu2 += g.a.a.a.nh(10, this.MsB.computeSize());
            }
            if (this.MsC != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MsC);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.MsD) + g.a.a.b.b.a.bu(13, this.ecf) + g.a.a.b.b.a.bu(14, this.MsE);
            if (this.EpK != null) {
                bu3 += g.a.a.b.b.a.f(15, this.EpK);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(16, this.subType);
            if (this.md5 != null) {
                bu4 += g.a.a.b.b.a.f(17, this.md5);
            }
            if (this.MsF != null) {
                bu4 += g.a.a.b.b.a.f(18, this.MsF);
            }
            if (this.MsG != null) {
                bu4 += g.a.a.b.b.a.f(19, this.MsG);
            }
            if (this.MsH != null) {
                bu4 += g.a.a.b.b.a.f(20, this.MsH);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(21, this.ERX);
            if (this.MsI != null) {
                bu5 += g.a.a.b.b.a.f(22, this.MsI);
            }
            if (this.MsJ != null) {
                bu5 += g.a.a.b.b.a.f(23, this.MsJ);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(24, this.MsK) + g.a.a.b.b.a.r(25, this.MsL);
            if (this.MsM != null) {
                bu6 += g.a.a.b.b.a.f(26, this.MsM);
            }
            if (this.viB != null) {
                bu6 += g.a.a.b.b.a.f(27, this.viB);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(28, this.MsN);
            if (this.MsO != null) {
                bu7 += g.a.a.b.b.a.f(29, this.MsO);
            }
            if (this.MsP != null) {
                bu7 += g.a.a.b.b.a.f(30, this.MsP);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(31, this.MsQ);
            if (this.MsR != null) {
                bu8 += g.a.a.b.b.a.f(32, this.MsR);
            }
            if (this.MsS != null) {
                bu8 += g.a.a.b.b.a.f(33, this.MsS);
            }
            int fS = bu8 + g.a.a.b.b.a.fS(34) + 1;
            if (this.songAlbumUrl != null) {
                fS += g.a.a.b.b.a.f(35, this.songAlbumUrl);
            }
            if (this.songLyric != null) {
                fS += g.a.a.b.b.a.f(36, this.songLyric);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(37) + 4 + g.a.a.b.b.a.bu(38, this.mediaType);
            AppMethodBeat.o(125743);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125743);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnb cnb = (cnb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnb.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 2:
                    cnb.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 3:
                    cnb.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 4:
                    cnb.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 5:
                    cnb.Mcw = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 6:
                    cnb.Msz = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 7:
                    cnb.MsA = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 8:
                    cnb.Privated = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 9:
                    cnb.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cnd cnd = new cnd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cnd.populateBuilderWithField(aVar4, cnd, a.getNextFieldNumber(aVar4))) {
                        }
                        cnb.MsB = cnd;
                    }
                    AppMethodBeat.o(125743);
                    return 0;
                case 11:
                    cnb.MsC = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 12:
                    cnb.MsD = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 13:
                    cnb.ecf = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 14:
                    cnb.MsE = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 15:
                    cnb.EpK = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 16:
                    cnb.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 17:
                    cnb.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 18:
                    cnb.MsF = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 19:
                    cnb.MsG = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 20:
                    cnb.MsH = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 21:
                    cnb.ERX = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 22:
                    cnb.MsI = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 23:
                    cnb.MsJ = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 24:
                    cnb.MsK = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 25:
                    cnb.MsL = aVar3.UbS.zl();
                    AppMethodBeat.o(125743);
                    return 0;
                case 26:
                    cnb.MsM = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 27:
                    cnb.viB = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 28:
                    cnb.MsN = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 29:
                    cnb.MsO = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 30:
                    cnb.MsP = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 31:
                    cnb.MsQ = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                case 32:
                    cnb.MsR = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 33:
                    cnb.MsS = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 34:
                    cnb.isAd = aVar3.UbS.yZ();
                    AppMethodBeat.o(125743);
                    return 0;
                case 35:
                    cnb.songAlbumUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 36:
                    cnb.songLyric = aVar3.UbS.readString();
                    AppMethodBeat.o(125743);
                    return 0;
                case 37:
                    cnb.MsT = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125743);
                    return 0;
                case 38:
                    cnb.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(125743);
                    return 0;
                default:
                    AppMethodBeat.o(125743);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125743);
            return -1;
        }
    }
}

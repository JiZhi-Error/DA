package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class g extends a {
    public String Desc;
    public String Name;
    public int Version;
    public String hik;
    public int oTW;
    public String xIB;
    public String xIG;
    public String xIJ;
    public String xIK;
    public int xIL;
    public w xIM;
    public int xIN;
    public boolean xIO;
    public LinkedList<String> xIP = new LinkedList<>();
    public boolean xIQ;
    public boolean xIR;
    public boolean xIS;
    public boolean xIT;
    public cv xIU;
    public int xIV;
    public cj xIW;
    public LinkedList<String> xIX = new LinkedList<>();
    public String xuk;

    public g() {
        AppMethodBeat.i(41710);
        AppMethodBeat.o(41710);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41711);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik == null) {
                b bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(41711);
                throw bVar;
            } else if (this.xIJ == null) {
                b bVar2 = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41711);
                throw bVar2;
            } else {
                if (this.hik != null) {
                    aVar.e(1, this.hik);
                }
                if (this.xIJ != null) {
                    aVar.e(2, this.xIJ);
                }
                if (this.Name != null) {
                    aVar.e(3, this.Name);
                }
                if (this.Desc != null) {
                    aVar.e(4, this.Desc);
                }
                if (this.xIK != null) {
                    aVar.e(5, this.xIK);
                }
                if (this.xIB != null) {
                    aVar.e(6, this.xIB);
                }
                if (this.xuk != null) {
                    aVar.e(7, this.xuk);
                }
                aVar.aM(8, this.xIL);
                if (this.xIM != null) {
                    aVar.ni(9, this.xIM.computeSize());
                    this.xIM.writeFields(aVar);
                }
                aVar.aM(10, this.oTW);
                aVar.aM(11, this.xIN);
                if (this.xIG != null) {
                    aVar.e(12, this.xIG);
                }
                aVar.cc(13, this.xIO);
                aVar.e(14, 1, this.xIP);
                aVar.cc(15, this.xIQ);
                aVar.aM(16, this.Version);
                aVar.cc(17, this.xIR);
                aVar.cc(18, this.xIS);
                aVar.cc(19, this.xIT);
                if (this.xIU != null) {
                    aVar.ni(20, this.xIU.computeSize());
                    this.xIU.writeFields(aVar);
                }
                aVar.aM(21, this.xIV);
                if (this.xIW != null) {
                    aVar.ni(22, this.xIW.computeSize());
                    this.xIW.writeFields(aVar);
                }
                aVar.e(23, 1, this.xIX);
                AppMethodBeat.o(41711);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0;
            if (this.xIJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIJ);
            }
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(3, this.Name);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.xIK != null) {
                f2 += g.a.a.b.b.a.f(5, this.xIK);
            }
            if (this.xIB != null) {
                f2 += g.a.a.b.b.a.f(6, this.xIB);
            }
            if (this.xuk != null) {
                f2 += g.a.a.b.b.a.f(7, this.xuk);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.xIL);
            if (this.xIM != null) {
                bu += g.a.a.a.nh(9, this.xIM.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.oTW) + g.a.a.b.b.a.bu(11, this.xIN);
            if (this.xIG != null) {
                bu2 += g.a.a.b.b.a.f(12, this.xIG);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(13) + 1 + g.a.a.a.c(14, 1, this.xIP) + g.a.a.b.b.a.fS(15) + 1 + g.a.a.b.b.a.bu(16, this.Version) + g.a.a.b.b.a.fS(17) + 1 + g.a.a.b.b.a.fS(18) + 1 + g.a.a.b.b.a.fS(19) + 1;
            if (this.xIU != null) {
                fS += g.a.a.a.nh(20, this.xIU.computeSize());
            }
            int bu3 = fS + g.a.a.b.b.a.bu(21, this.xIV);
            if (this.xIW != null) {
                bu3 += g.a.a.a.nh(22, this.xIW.computeSize());
            }
            int c2 = bu3 + g.a.a.a.c(23, 1, this.xIX);
            AppMethodBeat.o(41711);
            return c2;
        } else if (i2 == 2) {
            this.xIP.clear();
            this.xIX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.hik == null) {
                b bVar3 = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(41711);
                throw bVar3;
            } else if (this.xIJ == null) {
                b bVar4 = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41711);
                throw bVar4;
            } else {
                AppMethodBeat.o(41711);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 2:
                    gVar.xIJ = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 3:
                    gVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 4:
                    gVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 5:
                    gVar.xIK = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 6:
                    gVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 7:
                    gVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 8:
                    gVar.xIL = aVar3.UbS.zi();
                    AppMethodBeat.o(41711);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        w wVar = new w();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = wVar.populateBuilderWithField(aVar4, wVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.xIM = wVar;
                    }
                    AppMethodBeat.o(41711);
                    return 0;
                case 10:
                    gVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(41711);
                    return 0;
                case 11:
                    gVar.xIN = aVar3.UbS.zi();
                    AppMethodBeat.o(41711);
                    return 0;
                case 12:
                    gVar.xIG = aVar3.UbS.readString();
                    AppMethodBeat.o(41711);
                    return 0;
                case 13:
                    gVar.xIO = aVar3.UbS.yZ();
                    AppMethodBeat.o(41711);
                    return 0;
                case 14:
                    gVar.xIP.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41711);
                    return 0;
                case 15:
                    gVar.xIQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(41711);
                    return 0;
                case 16:
                    gVar.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(41711);
                    return 0;
                case 17:
                    gVar.xIR = aVar3.UbS.yZ();
                    AppMethodBeat.o(41711);
                    return 0;
                case 18:
                    gVar.xIS = aVar3.UbS.yZ();
                    AppMethodBeat.o(41711);
                    return 0;
                case 19:
                    gVar.xIT = aVar3.UbS.yZ();
                    AppMethodBeat.o(41711);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cv cvVar = new cv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cvVar.populateBuilderWithField(aVar5, cvVar, a.getNextFieldNumber(aVar5))) {
                        }
                        gVar.xIU = cvVar;
                    }
                    AppMethodBeat.o(41711);
                    return 0;
                case 21:
                    gVar.xIV = aVar3.UbS.zi();
                    AppMethodBeat.o(41711);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cj cjVar = new cj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cjVar.populateBuilderWithField(aVar6, cjVar, a.getNextFieldNumber(aVar6))) {
                        }
                        gVar.xIW = cjVar;
                    }
                    AppMethodBeat.o(41711);
                    return 0;
                case 23:
                    gVar.xIX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41711);
                    return 0;
                default:
                    AppMethodBeat.o(41711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41711);
            return -1;
        }
    }
}

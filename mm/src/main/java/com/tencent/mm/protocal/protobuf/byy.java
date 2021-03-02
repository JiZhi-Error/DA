package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class byy extends dop {
    public acc KOF;
    public int KXD;
    public String MbW;
    public int MbZ;
    public String Mef;
    public int Meg;
    public boolean Meh = false;
    public cyd Mei;
    public String Mej;
    public LinkedList<crc> Mek = new LinkedList<>();
    public int Mel;
    public boolean Mem;
    public boolean Men;
    public String dNI;
    public String path;
    public int scene;
    public int type;
    public String username;

    public byy() {
        AppMethodBeat.i(123586);
        AppMethodBeat.o(123586);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123587);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.type);
            if (this.dNI != null) {
                aVar.e(3, this.dNI);
            }
            aVar.aM(4, this.KXD);
            if (this.Mef != null) {
                aVar.e(5, this.Mef);
            }
            aVar.aM(6, this.MbZ);
            aVar.aM(7, this.Meg);
            if (this.MbW != null) {
                aVar.e(8, this.MbW);
            }
            aVar.cc(9, this.Meh);
            if (this.Mei != null) {
                aVar.ni(10, this.Mei.computeSize());
                this.Mei.writeFields(aVar);
            }
            if (this.Mej != null) {
                aVar.e(11, this.Mej);
            }
            aVar.e(12, 8, this.Mek);
            aVar.aM(13, this.Mel);
            if (this.username != null) {
                aVar.e(14, this.username);
            }
            if (this.path != null) {
                aVar.e(15, this.path);
            }
            aVar.cc(16, this.Mem);
            aVar.cc(17, this.Men);
            aVar.aM(18, this.scene);
            if (this.KOF != null) {
                aVar.ni(19, this.KOF.computeSize());
                this.KOF.writeFields(aVar);
            }
            AppMethodBeat.o(123587);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KXD);
            if (this.Mef != null) {
                bu += g.a.a.b.b.a.f(5, this.Mef);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.MbZ) + g.a.a.b.b.a.bu(7, this.Meg);
            if (this.MbW != null) {
                bu2 += g.a.a.b.b.a.f(8, this.MbW);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(9) + 1;
            if (this.Mei != null) {
                fS += g.a.a.a.nh(10, this.Mei.computeSize());
            }
            if (this.Mej != null) {
                fS += g.a.a.b.b.a.f(11, this.Mej);
            }
            int c2 = fS + g.a.a.a.c(12, 8, this.Mek) + g.a.a.b.b.a.bu(13, this.Mel);
            if (this.username != null) {
                c2 += g.a.a.b.b.a.f(14, this.username);
            }
            if (this.path != null) {
                c2 += g.a.a.b.b.a.f(15, this.path);
            }
            int fS2 = c2 + g.a.a.b.b.a.fS(16) + 1 + g.a.a.b.b.a.fS(17) + 1 + g.a.a.b.b.a.bu(18, this.scene);
            if (this.KOF != null) {
                fS2 += g.a.a.a.nh(19, this.KOF.computeSize());
            }
            AppMethodBeat.o(123587);
            return fS2;
        } else if (i2 == 2) {
            this.Mek.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123587);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            byy byy = (byy) objArr[1];
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
                        byy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123587);
                    return 0;
                case 2:
                    byy.type = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 3:
                    byy.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 4:
                    byy.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 5:
                    byy.Mef = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 6:
                    byy.MbZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 7:
                    byy.Meg = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 8:
                    byy.MbW = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 9:
                    byy.Meh = aVar3.UbS.yZ();
                    AppMethodBeat.o(123587);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyd cyd = new cyd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyd.populateBuilderWithField(aVar5, cyd, dop.getNextFieldNumber(aVar5))) {
                        }
                        byy.Mei = cyd;
                    }
                    AppMethodBeat.o(123587);
                    return 0;
                case 11:
                    byy.Mej = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        crc crc = new crc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = crc.populateBuilderWithField(aVar6, crc, dop.getNextFieldNumber(aVar6))) {
                        }
                        byy.Mek.add(crc);
                    }
                    AppMethodBeat.o(123587);
                    return 0;
                case 13:
                    byy.Mel = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 14:
                    byy.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 15:
                    byy.path = aVar3.UbS.readString();
                    AppMethodBeat.o(123587);
                    return 0;
                case 16:
                    byy.Mem = aVar3.UbS.yZ();
                    AppMethodBeat.o(123587);
                    return 0;
                case 17:
                    byy.Men = aVar3.UbS.yZ();
                    AppMethodBeat.o(123587);
                    return 0;
                case 18:
                    byy.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123587);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        acc acc = new acc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = acc.populateBuilderWithField(aVar7, acc, dop.getNextFieldNumber(aVar7))) {
                        }
                        byy.KOF = acc;
                    }
                    AppMethodBeat.o(123587);
                    return 0;
                default:
                    AppMethodBeat.o(123587);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123587);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class clp extends a {
    public int MqO;
    public float MqS;
    public float MqT;
    public String MqU;
    public LinkedList<String> MqV = new LinkedList<>();
    public String MqW;
    public LinkedList<String> MqX = new LinkedList<>();
    public LinkedList<clq> MqY = new LinkedList<>();
    public LinkedList<cln> MqZ = new LinkedList<>();
    public int Mra = 1;
    public int dNP;
    public int duration;
    public String iAz;
    public String jTB;

    public clp() {
        AppMethodBeat.i(169924);
        AppMethodBeat.o(169924);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169925);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MqU == null) {
                b bVar = new b("Not all required fields were included: music_url");
                AppMethodBeat.o(169925);
                throw bVar;
            }
            aVar.aM(1, this.MqO);
            aVar.E(2, this.MqS);
            aVar.E(3, this.MqT);
            if (this.MqU != null) {
                aVar.e(4, this.MqU);
            }
            aVar.e(5, 1, this.MqV);
            if (this.MqW != null) {
                aVar.e(6, this.MqW);
            }
            aVar.e(7, 1, this.MqX);
            aVar.e(8, 8, this.MqY);
            if (this.jTB != null) {
                aVar.e(9, this.jTB);
            }
            if (this.iAz != null) {
                aVar.e(10, this.iAz);
            }
            aVar.e(11, 8, this.MqZ);
            aVar.aM(12, this.dNP);
            aVar.aM(13, this.duration);
            aVar.aM(14, this.Mra);
            AppMethodBeat.o(169925);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MqO) + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4;
            if (this.MqU != null) {
                bu += g.a.a.b.b.a.f(4, this.MqU);
            }
            int c2 = bu + g.a.a.a.c(5, 1, this.MqV);
            if (this.MqW != null) {
                c2 += g.a.a.b.b.a.f(6, this.MqW);
            }
            int c3 = c2 + g.a.a.a.c(7, 1, this.MqX) + g.a.a.a.c(8, 8, this.MqY);
            if (this.jTB != null) {
                c3 += g.a.a.b.b.a.f(9, this.jTB);
            }
            if (this.iAz != null) {
                c3 += g.a.a.b.b.a.f(10, this.iAz);
            }
            int c4 = c3 + g.a.a.a.c(11, 8, this.MqZ) + g.a.a.b.b.a.bu(12, this.dNP) + g.a.a.b.b.a.bu(13, this.duration) + g.a.a.b.b.a.bu(14, this.Mra);
            AppMethodBeat.o(169925);
            return c4;
        } else if (i2 == 2) {
            this.MqV.clear();
            this.MqX.clear();
            this.MqY.clear();
            this.MqZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MqU == null) {
                b bVar2 = new b("Not all required fields were included: music_url");
                AppMethodBeat.o(169925);
                throw bVar2;
            }
            AppMethodBeat.o(169925);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clp clp = (clp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    clp.MqO = aVar3.UbS.zi();
                    AppMethodBeat.o(169925);
                    return 0;
                case 2:
                    clp.MqS = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169925);
                    return 0;
                case 3:
                    clp.MqT = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169925);
                    return 0;
                case 4:
                    clp.MqU = aVar3.UbS.readString();
                    AppMethodBeat.o(169925);
                    return 0;
                case 5:
                    clp.MqV.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169925);
                    return 0;
                case 6:
                    clp.MqW = aVar3.UbS.readString();
                    AppMethodBeat.o(169925);
                    return 0;
                case 7:
                    clp.MqX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169925);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        clq clq = new clq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = clq.populateBuilderWithField(aVar4, clq, a.getNextFieldNumber(aVar4))) {
                        }
                        clp.MqY.add(clq);
                    }
                    AppMethodBeat.o(169925);
                    return 0;
                case 9:
                    clp.jTB = aVar3.UbS.readString();
                    AppMethodBeat.o(169925);
                    return 0;
                case 10:
                    clp.iAz = aVar3.UbS.readString();
                    AppMethodBeat.o(169925);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cln cln = new cln();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cln.populateBuilderWithField(aVar5, cln, a.getNextFieldNumber(aVar5))) {
                        }
                        clp.MqZ.add(cln);
                    }
                    AppMethodBeat.o(169925);
                    return 0;
                case 12:
                    clp.dNP = aVar3.UbS.zi();
                    AppMethodBeat.o(169925);
                    return 0;
                case 13:
                    clp.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(169925);
                    return 0;
                case 14:
                    clp.Mra = aVar3.UbS.zi();
                    AppMethodBeat.o(169925);
                    return 0;
                default:
                    AppMethodBeat.o(169925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169925);
            return -1;
        }
    }
}

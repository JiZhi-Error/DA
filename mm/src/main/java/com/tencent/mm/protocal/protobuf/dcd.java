package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcd extends a {
    public dcm MGO;
    public dcp MGP;
    public String MGQ;
    public LinkedList<dcg> MGR = new LinkedList<>();
    public float MGS;
    public String MGT;
    public String MGU;
    public LinkedList<dcb> MGV = new LinkedList<>();
    public String MmX;
    public String Name;
    public String UID;
    public String kdZ;
    public String kea;
    public String keh;
    public int xub;

    public dcd() {
        AppMethodBeat.i(209776);
        AppMethodBeat.o(209776);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209777);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UID != null) {
                aVar.e(1, this.UID);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.MGO != null) {
                aVar.ni(3, this.MGO.computeSize());
                this.MGO.writeFields(aVar);
            }
            if (this.MGP != null) {
                aVar.ni(4, this.MGP.computeSize());
                this.MGP.writeFields(aVar);
            }
            if (this.MmX != null) {
                aVar.e(5, this.MmX);
            }
            if (this.MGQ != null) {
                aVar.e(6, this.MGQ);
            }
            aVar.e(7, 8, this.MGR);
            aVar.E(8, this.MGS);
            if (this.kdZ != null) {
                aVar.e(9, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(10, this.kea);
            }
            if (this.MGT != null) {
                aVar.e(11, this.MGT);
            }
            if (this.MGU != null) {
                aVar.e(12, this.MGU);
            }
            aVar.aM(13, this.xub);
            if (this.keh != null) {
                aVar.e(14, this.keh);
            }
            aVar.e(15, 8, this.MGV);
            AppMethodBeat.o(209777);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UID != null ? g.a.a.b.b.a.f(1, this.UID) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.MGO != null) {
                f2 += g.a.a.a.nh(3, this.MGO.computeSize());
            }
            if (this.MGP != null) {
                f2 += g.a.a.a.nh(4, this.MGP.computeSize());
            }
            if (this.MmX != null) {
                f2 += g.a.a.b.b.a.f(5, this.MmX);
            }
            if (this.MGQ != null) {
                f2 += g.a.a.b.b.a.f(6, this.MGQ);
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.MGR) + g.a.a.b.b.a.fS(8) + 4;
            if (this.kdZ != null) {
                c2 += g.a.a.b.b.a.f(9, this.kdZ);
            }
            if (this.kea != null) {
                c2 += g.a.a.b.b.a.f(10, this.kea);
            }
            if (this.MGT != null) {
                c2 += g.a.a.b.b.a.f(11, this.MGT);
            }
            if (this.MGU != null) {
                c2 += g.a.a.b.b.a.f(12, this.MGU);
            }
            int bu = c2 + g.a.a.b.b.a.bu(13, this.xub);
            if (this.keh != null) {
                bu += g.a.a.b.b.a.f(14, this.keh);
            }
            int c3 = bu + g.a.a.a.c(15, 8, this.MGV);
            AppMethodBeat.o(209777);
            return c3;
        } else if (i2 == 2) {
            this.MGR.clear();
            this.MGV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209777);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcd dcd = (dcd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dcd.UID = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 2:
                    dcd.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dcm dcm = new dcm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dcm.populateBuilderWithField(aVar4, dcm, a.getNextFieldNumber(aVar4))) {
                        }
                        dcd.MGO = dcm;
                    }
                    AppMethodBeat.o(209777);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dcp dcp = new dcp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dcp.populateBuilderWithField(aVar5, dcp, a.getNextFieldNumber(aVar5))) {
                        }
                        dcd.MGP = dcp;
                    }
                    AppMethodBeat.o(209777);
                    return 0;
                case 5:
                    dcd.MmX = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 6:
                    dcd.MGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dcg dcg = new dcg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dcg.populateBuilderWithField(aVar6, dcg, a.getNextFieldNumber(aVar6))) {
                        }
                        dcd.MGR.add(dcg);
                    }
                    AppMethodBeat.o(209777);
                    return 0;
                case 8:
                    dcd.MGS = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209777);
                    return 0;
                case 9:
                    dcd.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 10:
                    dcd.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 11:
                    dcd.MGT = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 12:
                    dcd.MGU = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 13:
                    dcd.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(209777);
                    return 0;
                case 14:
                    dcd.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(209777);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dcb dcb = new dcb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dcb.populateBuilderWithField(aVar7, dcb, a.getNextFieldNumber(aVar7))) {
                        }
                        dcd.MGV.add(dcb);
                    }
                    AppMethodBeat.o(209777);
                    return 0;
                default:
                    AppMethodBeat.o(209777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209777);
            return -1;
        }
    }
}

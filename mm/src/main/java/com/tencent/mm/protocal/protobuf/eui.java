package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eui extends dop {
    public int LsZ;
    public long Lta;
    public int MKr;
    public int NpP;
    public LinkedList<csu> NpQ = new LinkedList<>();
    public int Nsn;
    public int Nso;
    public LinkedList<eul> Nsp = new LinkedList<>();
    public int Nsq;
    public int Nsr;
    public int Nss;

    public eui() {
        AppMethodBeat.i(115905);
        AppMethodBeat.o(115905);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115906);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.MKr);
            aVar.aM(5, this.Nsn);
            aVar.aM(6, this.Nso);
            aVar.e(7, 8, this.Nsp);
            aVar.aM(8, this.Nsq);
            aVar.aM(9, this.NpP);
            aVar.e(10, 8, this.NpQ);
            aVar.aM(11, this.Nsr);
            aVar.aM(12, this.Nss);
            AppMethodBeat.o(115906);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.b.b.a.bu(5, this.Nsn) + g.a.a.b.b.a.bu(6, this.Nso) + g.a.a.a.c(7, 8, this.Nsp) + g.a.a.b.b.a.bu(8, this.Nsq) + g.a.a.b.b.a.bu(9, this.NpP) + g.a.a.a.c(10, 8, this.NpQ) + g.a.a.b.b.a.bu(11, this.Nsr) + g.a.a.b.b.a.bu(12, this.Nss);
            AppMethodBeat.o(115906);
            return nh;
        } else if (i2 == 2) {
            this.Nsp.clear();
            this.NpQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115906);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eui eui = (eui) objArr[1];
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
                        eui.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115906);
                    return 0;
                case 2:
                    eui.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 3:
                    eui.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115906);
                    return 0;
                case 4:
                    eui.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 5:
                    eui.Nsn = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 6:
                    eui.Nso = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eul eul = new eul();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eul.populateBuilderWithField(aVar5, eul, dop.getNextFieldNumber(aVar5))) {
                        }
                        eui.Nsp.add(eul);
                    }
                    AppMethodBeat.o(115906);
                    return 0;
                case 8:
                    eui.Nsq = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 9:
                    eui.NpP = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        csu csu = new csu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = csu.populateBuilderWithField(aVar6, csu, dop.getNextFieldNumber(aVar6))) {
                        }
                        eui.NpQ.add(csu);
                    }
                    AppMethodBeat.o(115906);
                    return 0;
                case 11:
                    eui.Nsr = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                case 12:
                    eui.Nss = aVar3.UbS.zi();
                    AppMethodBeat.o(115906);
                    return 0;
                default:
                    AppMethodBeat.o(115906);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115906);
            return -1;
        }
    }
}

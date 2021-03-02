package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eib extends a {
    public String KUA;
    public String LQx;
    public int Lla;
    public int MSm;
    public String Md5;
    public LinkedList<eia> Nhn = new LinkedList<>();
    public boolean Nho;
    public LinkedList<eid> Nhp = new LinkedList<>();
    public String Nhq;
    public int Version;
    public int oUv;

    public eib() {
        AppMethodBeat.i(6438);
        AppMethodBeat.o(6438);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6439);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            aVar.aM(2, this.Version);
            if (this.KUA != null) {
                aVar.e(3, this.KUA);
            }
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            aVar.aM(5, this.Lla);
            aVar.aM(6, this.MSm);
            aVar.e(7, 8, this.Nhn);
            aVar.cc(8, this.Nho);
            if (this.LQx != null) {
                aVar.e(9, this.LQx);
            }
            aVar.e(10, 8, this.Nhp);
            if (this.Nhq != null) {
                aVar.e(11, this.Nhq);
            }
            AppMethodBeat.o(6439);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.b.b.a.bu(2, this.Version);
            if (this.KUA != null) {
                bu += g.a.a.b.b.a.f(3, this.KUA);
            }
            if (this.Md5 != null) {
                bu += g.a.a.b.b.a.f(4, this.Md5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Lla) + g.a.a.b.b.a.bu(6, this.MSm) + g.a.a.a.c(7, 8, this.Nhn) + g.a.a.b.b.a.fS(8) + 1;
            if (this.LQx != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LQx);
            }
            int c2 = bu2 + g.a.a.a.c(10, 8, this.Nhp);
            if (this.Nhq != null) {
                c2 += g.a.a.b.b.a.f(11, this.Nhq);
            }
            AppMethodBeat.o(6439);
            return c2;
        } else if (i2 == 2) {
            this.Nhn.clear();
            this.Nhp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6439);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eib eib = (eib) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eib.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(6439);
                    return 0;
                case 2:
                    eib.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(6439);
                    return 0;
                case 3:
                    eib.KUA = aVar3.UbS.readString();
                    AppMethodBeat.o(6439);
                    return 0;
                case 4:
                    eib.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(6439);
                    return 0;
                case 5:
                    eib.Lla = aVar3.UbS.zi();
                    AppMethodBeat.o(6439);
                    return 0;
                case 6:
                    eib.MSm = aVar3.UbS.zi();
                    AppMethodBeat.o(6439);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eia eia = new eia();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eia.populateBuilderWithField(aVar4, eia, a.getNextFieldNumber(aVar4))) {
                        }
                        eib.Nhn.add(eia);
                    }
                    AppMethodBeat.o(6439);
                    return 0;
                case 8:
                    eib.Nho = aVar3.UbS.yZ();
                    AppMethodBeat.o(6439);
                    return 0;
                case 9:
                    eib.LQx = aVar3.UbS.readString();
                    AppMethodBeat.o(6439);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eid eid = new eid();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eid.populateBuilderWithField(aVar5, eid, a.getNextFieldNumber(aVar5))) {
                        }
                        eib.Nhp.add(eid);
                    }
                    AppMethodBeat.o(6439);
                    return 0;
                case 11:
                    eib.Nhq = aVar3.UbS.readString();
                    AppMethodBeat.o(6439);
                    return 0;
                default:
                    AppMethodBeat.o(6439);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6439);
            return -1;
        }
    }
}

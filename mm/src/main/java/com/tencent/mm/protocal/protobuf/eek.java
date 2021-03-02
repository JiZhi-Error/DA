package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eek extends a {
    public int CreateTime;
    public String Id;
    public dlg NeA;
    public edk NeB;
    public String NeC;
    public int NeD;
    public int NeE;
    public String UserName;
    public long timeStamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118475);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            aVar.aM(3, this.CreateTime);
            if (this.NeA != null) {
                aVar.ni(4, this.NeA.computeSize());
                this.NeA.writeFields(aVar);
            }
            if (this.NeB != null) {
                aVar.ni(5, this.NeB.computeSize());
                this.NeB.writeFields(aVar);
            }
            aVar.bb(6, this.timeStamp);
            if (this.NeC != null) {
                aVar.e(7, this.NeC);
            }
            aVar.aM(8, this.NeD);
            aVar.aM(9, this.NeE);
            AppMethodBeat.o(118475);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.CreateTime);
            if (this.NeA != null) {
                bu += g.a.a.a.nh(4, this.NeA.computeSize());
            }
            if (this.NeB != null) {
                bu += g.a.a.a.nh(5, this.NeB.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.timeStamp);
            if (this.NeC != null) {
                r += g.a.a.b.b.a.f(7, this.NeC);
            }
            int bu2 = r + g.a.a.b.b.a.bu(8, this.NeD) + g.a.a.b.b.a.bu(9, this.NeE);
            AppMethodBeat.o(118475);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eek eek = (eek) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eek.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(118475);
                    return 0;
                case 2:
                    eek.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(118475);
                    return 0;
                case 3:
                    eek.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(118475);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlg dlg = new dlg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlg.populateBuilderWithField(aVar4, dlg, a.getNextFieldNumber(aVar4))) {
                        }
                        eek.NeA = dlg;
                    }
                    AppMethodBeat.o(118475);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edk edk = new edk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edk.populateBuilderWithField(aVar5, edk, a.getNextFieldNumber(aVar5))) {
                        }
                        eek.NeB = edk;
                    }
                    AppMethodBeat.o(118475);
                    return 0;
                case 6:
                    eek.timeStamp = aVar3.UbS.zl();
                    AppMethodBeat.o(118475);
                    return 0;
                case 7:
                    eek.NeC = aVar3.UbS.readString();
                    AppMethodBeat.o(118475);
                    return 0;
                case 8:
                    eek.NeD = aVar3.UbS.zi();
                    AppMethodBeat.o(118475);
                    return 0;
                case 9:
                    eek.NeE = aVar3.UbS.zi();
                    AppMethodBeat.o(118475);
                    return 0;
                default:
                    AppMethodBeat.o(118475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118475);
            return -1;
        }
    }
}

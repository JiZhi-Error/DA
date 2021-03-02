package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class zs extends dop {
    public LinkedList<Integer> LkY = new LinkedList<>();
    public LinkedList<zr> LkZ = new LinkedList<>();
    public int Scene;
    public String pLm;

    public zs() {
        AppMethodBeat.i(6403);
        AppMethodBeat.o(6403);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6404);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 2, this.LkY);
            aVar.aM(3, this.Scene);
            if (this.pLm != null) {
                aVar.e(4, this.pLm);
            }
            aVar.e(5, 8, this.LkZ);
            AppMethodBeat.o(6404);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 2, this.LkY) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.pLm != null) {
                nh += g.a.a.b.b.a.f(4, this.pLm);
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.LkZ);
            AppMethodBeat.o(6404);
            return c2;
        } else if (i2 == 2) {
            this.LkY.clear();
            this.LkZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6404);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zs zsVar = (zs) objArr[1];
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
                        zsVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(6404);
                    return 0;
                case 2:
                    zsVar.LkY.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(6404);
                    return 0;
                case 3:
                    zsVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(6404);
                    return 0;
                case 4:
                    zsVar.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(6404);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        zr zrVar = new zr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = zrVar.populateBuilderWithField(aVar5, zrVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        zsVar.LkZ.add(zrVar);
                    }
                    AppMethodBeat.o(6404);
                    return 0;
                default:
                    AppMethodBeat.o(6404);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6404);
            return -1;
        }
    }
}

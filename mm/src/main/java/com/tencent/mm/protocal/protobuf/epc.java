package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class epc extends a {
    public erh NmX;
    public int previewHeight;
    public int previewWidth;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110915);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NmX == null) {
                b bVar = new b("Not all required fields were included: materialResp");
                AppMethodBeat.o(110915);
                throw bVar;
            }
            if (this.NmX != null) {
                aVar.ni(1, this.NmX.computeSize());
                this.NmX.writeFields(aVar);
            }
            aVar.aM(2, this.previewWidth);
            aVar.aM(3, this.previewHeight);
            AppMethodBeat.o(110915);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NmX != null ? g.a.a.a.nh(1, this.NmX.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.previewWidth) + g.a.a.b.b.a.bu(3, this.previewHeight);
            AppMethodBeat.o(110915);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NmX == null) {
                b bVar2 = new b("Not all required fields were included: materialResp");
                AppMethodBeat.o(110915);
                throw bVar2;
            }
            AppMethodBeat.o(110915);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epc epc = (epc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erh erh = new erh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erh.populateBuilderWithField(aVar4, erh, a.getNextFieldNumber(aVar4))) {
                        }
                        epc.NmX = erh;
                    }
                    AppMethodBeat.o(110915);
                    return 0;
                case 2:
                    epc.previewWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(110915);
                    return 0;
                case 3:
                    epc.previewHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(110915);
                    return 0;
                default:
                    AppMethodBeat.o(110915);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110915);
            return -1;
        }
    }
}

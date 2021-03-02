package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ox extends dop {
    public LinkedList<ow> KVH = new LinkedList<>();
    public int KVI;
    public int KVJ;
    public int KVK;
    public int scene;

    public ox() {
        AppMethodBeat.i(124438);
        AppMethodBeat.o(124438);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124439);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KVH);
            aVar.aM(3, this.scene);
            aVar.aM(4, this.KVI);
            aVar.aM(7, this.KVJ);
            aVar.aM(8, this.KVK);
            AppMethodBeat.o(124439);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KVH) + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.KVI) + g.a.a.b.b.a.bu(7, this.KVJ) + g.a.a.b.b.a.bu(8, this.KVK);
            AppMethodBeat.o(124439);
            return nh;
        } else if (i2 == 2) {
            this.KVH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124439);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ox oxVar = (ox) objArr[1];
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
                        oxVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124439);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ow owVar = new ow();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = owVar.populateBuilderWithField(aVar5, owVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        oxVar.KVH.add(owVar);
                    }
                    AppMethodBeat.o(124439);
                    return 0;
                case 3:
                    oxVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124439);
                    return 0;
                case 4:
                    oxVar.KVI = aVar3.UbS.zi();
                    AppMethodBeat.o(124439);
                    return 0;
                case 5:
                case 6:
                default:
                    AppMethodBeat.o(124439);
                    return -1;
                case 7:
                    oxVar.KVJ = aVar3.UbS.zi();
                    AppMethodBeat.o(124439);
                    return 0;
                case 8:
                    oxVar.KVK = aVar3.UbS.zi();
                    AppMethodBeat.o(124439);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124439);
            return -1;
        }
    }
}

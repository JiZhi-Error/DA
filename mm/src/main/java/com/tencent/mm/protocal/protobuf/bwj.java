package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwj extends dop {
    public String KFZ;
    public String LYB;
    public String extInfo;
    public int scene;
    public String uxInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192783);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.uxInfo != null) {
                aVar.e(2, this.uxInfo);
            }
            aVar.aM(3, this.scene);
            if (this.KFZ != null) {
                aVar.e(4, this.KFZ);
            }
            if (this.LYB != null) {
                aVar.e(5, this.LYB);
            }
            if (this.extInfo != null) {
                aVar.e(6, this.extInfo);
            }
            AppMethodBeat.o(192783);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.uxInfo != null) {
                nh += g.a.a.b.b.a.f(2, this.uxInfo);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.scene);
            if (this.KFZ != null) {
                bu += g.a.a.b.b.a.f(4, this.KFZ);
            }
            if (this.LYB != null) {
                bu += g.a.a.b.b.a.f(5, this.LYB);
            }
            if (this.extInfo != null) {
                bu += g.a.a.b.b.a.f(6, this.extInfo);
            }
            AppMethodBeat.o(192783);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192783);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwj bwj = (bwj) objArr[1];
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
                        bwj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(192783);
                    return 0;
                case 2:
                    bwj.uxInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(192783);
                    return 0;
                case 3:
                    bwj.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(192783);
                    return 0;
                case 4:
                    bwj.KFZ = aVar3.UbS.readString();
                    AppMethodBeat.o(192783);
                    return 0;
                case 5:
                    bwj.LYB = aVar3.UbS.readString();
                    AppMethodBeat.o(192783);
                    return 0;
                case 6:
                    bwj.extInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(192783);
                    return 0;
                default:
                    AppMethodBeat.o(192783);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192783);
            return -1;
        }
    }
}

package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class g extends dop {
    public String appId;
    public String gTp;
    public String gTq;
    public String uxInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194679);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            if (this.gTp != null) {
                aVar.e(3, this.gTp);
            }
            if (this.uxInfo != null) {
                aVar.e(4, this.uxInfo);
            }
            if (this.gTq != null) {
                aVar.e(5, this.gTq);
            }
            AppMethodBeat.o(194679);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.appId != null) {
                nh += g.a.a.b.b.a.f(2, this.appId);
            }
            if (this.gTp != null) {
                nh += g.a.a.b.b.a.f(3, this.gTp);
            }
            if (this.uxInfo != null) {
                nh += g.a.a.b.b.a.f(4, this.uxInfo);
            }
            if (this.gTq != null) {
                nh += g.a.a.b.b.a.f(5, this.gTq);
            }
            AppMethodBeat.o(194679);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194679);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
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
                        gVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(194679);
                    return 0;
                case 2:
                    gVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(194679);
                    return 0;
                case 3:
                    gVar.gTp = aVar3.UbS.readString();
                    AppMethodBeat.o(194679);
                    return 0;
                case 4:
                    gVar.uxInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(194679);
                    return 0;
                case 5:
                    gVar.gTq = aVar3.UbS.readString();
                    AppMethodBeat.o(194679);
                    return 0;
                default:
                    AppMethodBeat.o(194679);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194679);
            return -1;
        }
    }
}

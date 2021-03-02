package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class avt extends dop {
    public aov LAI;
    public long hFK;
    public long liveId;
    public int scene;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209513);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LAI != null) {
                aVar.ni(2, this.LAI.computeSize());
                this.LAI.writeFields(aVar);
            }
            aVar.bb(3, this.liveId);
            aVar.bb(4, this.hFK);
            if (this.username != null) {
                aVar.e(5, this.username);
            }
            aVar.aM(6, this.scene);
            AppMethodBeat.o(209513);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LAI != null) {
                nh += g.a.a.a.nh(2, this.LAI.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK);
            if (this.username != null) {
                r += g.a.a.b.b.a.f(5, this.username);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.scene);
            AppMethodBeat.o(209513);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209513);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avt avt = (avt) objArr[1];
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
                        avt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209513);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        avt.LAI = aov;
                    }
                    AppMethodBeat.o(209513);
                    return 0;
                case 3:
                    avt.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209513);
                    return 0;
                case 4:
                    avt.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209513);
                    return 0;
                case 5:
                    avt.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209513);
                    return 0;
                case 6:
                    avt.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209513);
                    return 0;
                default:
                    AppMethodBeat.o(209513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209513);
            return -1;
        }
    }
}

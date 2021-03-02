package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class exs extends dop {
    public int IEj;
    public double NuX;
    public double NuY;
    public String NuZ;
    public LinkedList<epb> Nva = new LinkedList<>();
    public int scene;
    public String sessionId;

    public exs() {
        AppMethodBeat.i(121112);
        AppMethodBeat.o(121112);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(121113);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, this.NuX);
            aVar.e(3, this.NuY);
            if (this.NuZ != null) {
                aVar.e(4, this.NuZ);
            }
            aVar.aM(5, this.IEj);
            if (this.sessionId != null) {
                aVar.e(6, this.sessionId);
            }
            aVar.aM(7, this.scene);
            aVar.e(8, 8, this.Nva);
            AppMethodBeat.o(121113);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.fS(3) + 8;
            if (this.NuZ != null) {
                nh += g.a.a.b.b.a.f(4, this.NuZ);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.IEj);
            if (this.sessionId != null) {
                bu += g.a.a.b.b.a.f(6, this.sessionId);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.a.c(8, 8, this.Nva);
            AppMethodBeat.o(121113);
            return bu2;
        } else if (i2 == 2) {
            this.Nva.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(121113);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exs exs = (exs) objArr[1];
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
                        exs.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(121113);
                    return 0;
                case 2:
                    exs.NuX = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(121113);
                    return 0;
                case 3:
                    exs.NuY = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(121113);
                    return 0;
                case 4:
                    exs.NuZ = aVar3.UbS.readString();
                    AppMethodBeat.o(121113);
                    return 0;
                case 5:
                    exs.IEj = aVar3.UbS.zi();
                    AppMethodBeat.o(121113);
                    return 0;
                case 6:
                    exs.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(121113);
                    return 0;
                case 7:
                    exs.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(121113);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        epb epb = new epb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = epb.populateBuilderWithField(aVar5, epb, dop.getNextFieldNumber(aVar5))) {
                        }
                        exs.Nva.add(epb);
                    }
                    AppMethodBeat.o(121113);
                    return 0;
                default:
                    AppMethodBeat.o(121113);
                    return -1;
            }
        } else {
            AppMethodBeat.o(121113);
            return -1;
        }
    }
}

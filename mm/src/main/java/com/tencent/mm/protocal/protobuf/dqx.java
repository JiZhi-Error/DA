package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dqx extends dop {
    public ddi MTE;
    public float MTF;
    public float MTG;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152679);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MTE == null) {
                b bVar = new b("Not all required fields were included: UserPos");
                AppMethodBeat.o(152679);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MTE != null) {
                aVar.ni(2, this.MTE.computeSize());
                this.MTE.writeFields(aVar);
            }
            aVar.aM(3, this.Scene);
            aVar.E(4, this.MTF);
            aVar.E(5, this.MTG);
            AppMethodBeat.o(152679);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MTE != null) {
                nh += g.a.a.a.nh(2, this.MTE.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Scene) + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4;
            AppMethodBeat.o(152679);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MTE == null) {
                b bVar2 = new b("Not all required fields were included: UserPos");
                AppMethodBeat.o(152679);
                throw bVar2;
            }
            AppMethodBeat.o(152679);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqx dqx = (dqx) objArr[1];
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
                        dqx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152679);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ddi ddi = new ddi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ddi.populateBuilderWithField(aVar5, ddi, dop.getNextFieldNumber(aVar5))) {
                        }
                        dqx.MTE = ddi;
                    }
                    AppMethodBeat.o(152679);
                    return 0;
                case 3:
                    dqx.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152679);
                    return 0;
                case 4:
                    dqx.MTF = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152679);
                    return 0;
                case 5:
                    dqx.MTG = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152679);
                    return 0;
                default:
                    AppMethodBeat.o(152679);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152679);
            return -1;
        }
    }
}

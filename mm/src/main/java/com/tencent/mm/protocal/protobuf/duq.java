package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class duq extends dop {
    public chk LpL;
    public int MVW;
    public int Scene;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152692);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LpL == null) {
                b bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(152692);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LpL != null) {
                aVar.ni(2, this.LpL.computeSize());
                this.LpL.writeFields(aVar);
            }
            aVar.aM(3, this.MVW);
            aVar.aM(4, this.Scene);
            if (this.iAc != null) {
                aVar.e(5, this.iAc);
            }
            AppMethodBeat.o(152692);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LpL != null) {
                nh += g.a.a.a.nh(2, this.LpL.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MVW) + g.a.a.b.b.a.bu(4, this.Scene);
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(5, this.iAc);
            }
            AppMethodBeat.o(152692);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LpL == null) {
                b bVar2 = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(152692);
                throw bVar2;
            }
            AppMethodBeat.o(152692);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duq duq = (duq) objArr[1];
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
                        duq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152692);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        chk chk = new chk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = chk.populateBuilderWithField(aVar5, chk, dop.getNextFieldNumber(aVar5))) {
                        }
                        duq.LpL = chk;
                    }
                    AppMethodBeat.o(152692);
                    return 0;
                case 3:
                    duq.MVW = aVar3.UbS.zi();
                    AppMethodBeat.o(152692);
                    return 0;
                case 4:
                    duq.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152692);
                    return 0;
                case 5:
                    duq.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(152692);
                    return 0;
                default:
                    AppMethodBeat.o(152692);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152692);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class el extends dop {
    public String KBt;
    public String KIf;
    public int KIg;
    public String dNI;
    public String dOe;
    public String qcM;
    public String signature;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194533);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.KBt != null) {
                aVar.e(3, this.KBt);
            }
            if (this.qcM != null) {
                aVar.e(4, this.qcM);
            }
            if (this.signature != null) {
                aVar.e(5, this.signature);
            }
            if (this.dOe != null) {
                aVar.e(6, this.dOe);
            }
            if (this.KIf != null) {
                aVar.e(7, this.KIf);
            }
            aVar.aM(8, this.KIg);
            AppMethodBeat.o(194533);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.KBt != null) {
                nh += g.a.a.b.b.a.f(3, this.KBt);
            }
            if (this.qcM != null) {
                nh += g.a.a.b.b.a.f(4, this.qcM);
            }
            if (this.signature != null) {
                nh += g.a.a.b.b.a.f(5, this.signature);
            }
            if (this.dOe != null) {
                nh += g.a.a.b.b.a.f(6, this.dOe);
            }
            if (this.KIf != null) {
                nh += g.a.a.b.b.a.f(7, this.KIf);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KIg);
            AppMethodBeat.o(194533);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194533);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            el elVar = (el) objArr[1];
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
                        elVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(194533);
                    return 0;
                case 2:
                    elVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 3:
                    elVar.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 4:
                    elVar.qcM = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 5:
                    elVar.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 6:
                    elVar.dOe = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 7:
                    elVar.KIf = aVar3.UbS.readString();
                    AppMethodBeat.o(194533);
                    return 0;
                case 8:
                    elVar.KIg = aVar3.UbS.zi();
                    AppMethodBeat.o(194533);
                    return 0;
                default:
                    AppMethodBeat.o(194533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194533);
            return -1;
        }
    }
}

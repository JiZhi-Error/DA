package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class s extends dop {
    public String CpP;
    public long KBK;
    public String KBM;
    public String KBs;
    public String KBt;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91328);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KBs != null) {
                aVar.e(2, this.KBs);
            }
            aVar.bb(3, this.KBK);
            aVar.aM(4, this.scene);
            if (this.KBt != null) {
                aVar.e(5, this.KBt);
            }
            if (this.KBM != null) {
                aVar.e(6, this.KBM);
            }
            if (this.CpP != null) {
                aVar.e(7, this.CpP);
            }
            AppMethodBeat.o(91328);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KBs != null) {
                nh += g.a.a.b.b.a.f(2, this.KBs);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.KBK) + g.a.a.b.b.a.bu(4, this.scene);
            if (this.KBt != null) {
                r += g.a.a.b.b.a.f(5, this.KBt);
            }
            if (this.KBM != null) {
                r += g.a.a.b.b.a.f(6, this.KBM);
            }
            if (this.CpP != null) {
                r += g.a.a.b.b.a.f(7, this.CpP);
            }
            AppMethodBeat.o(91328);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91328);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
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
                        sVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91328);
                    return 0;
                case 2:
                    sVar.KBs = aVar3.UbS.readString();
                    AppMethodBeat.o(91328);
                    return 0;
                case 3:
                    sVar.KBK = aVar3.UbS.zl();
                    AppMethodBeat.o(91328);
                    return 0;
                case 4:
                    sVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91328);
                    return 0;
                case 5:
                    sVar.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(91328);
                    return 0;
                case 6:
                    sVar.KBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91328);
                    return 0;
                case 7:
                    sVar.CpP = aVar3.UbS.readString();
                    AppMethodBeat.o(91328);
                    return 0;
                default:
                    AppMethodBeat.o(91328);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91328);
            return -1;
        }
    }
}

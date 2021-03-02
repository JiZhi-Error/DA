package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btk extends dop {
    public String DYM;
    public String Mab;
    public String Mac;
    public String Mad;
    public String dRy;
    public String gTk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192777);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dRy != null) {
                aVar.e(2, this.dRy);
            }
            if (this.DYM != null) {
                aVar.e(3, this.DYM);
            }
            if (this.Mab != null) {
                aVar.e(4, this.Mab);
            }
            if (this.gTk != null) {
                aVar.e(5, this.gTk);
            }
            if (this.Mac != null) {
                aVar.e(6, this.Mac);
            }
            if (this.Mad != null) {
                aVar.e(7, this.Mad);
            }
            AppMethodBeat.o(192777);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dRy != null) {
                nh += g.a.a.b.b.a.f(2, this.dRy);
            }
            if (this.DYM != null) {
                nh += g.a.a.b.b.a.f(3, this.DYM);
            }
            if (this.Mab != null) {
                nh += g.a.a.b.b.a.f(4, this.Mab);
            }
            if (this.gTk != null) {
                nh += g.a.a.b.b.a.f(5, this.gTk);
            }
            if (this.Mac != null) {
                nh += g.a.a.b.b.a.f(6, this.Mac);
            }
            if (this.Mad != null) {
                nh += g.a.a.b.b.a.f(7, this.Mad);
            }
            AppMethodBeat.o(192777);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192777);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btk btk = (btk) objArr[1];
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
                        btk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(192777);
                    return 0;
                case 2:
                    btk.dRy = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                case 3:
                    btk.DYM = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                case 4:
                    btk.Mab = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                case 5:
                    btk.gTk = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                case 6:
                    btk.Mac = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                case 7:
                    btk.Mad = aVar3.UbS.readString();
                    AppMethodBeat.o(192777);
                    return 0;
                default:
                    AppMethodBeat.o(192777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192777);
            return -1;
        }
    }
}

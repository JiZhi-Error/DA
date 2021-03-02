package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eng extends dop {
    public String Lsm;
    public String Lsn;
    public String Lso;
    public String MD5;
    public boolean Nld;
    public LinkedList<String> Nle = new LinkedList<>();
    public String Nlf;
    public boolean Nli;
    public int Scene;

    public eng() {
        AppMethodBeat.i(104842);
        AppMethodBeat.o(104842);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104843);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MD5 != null) {
                aVar.e(2, this.MD5);
            }
            aVar.cc(3, this.Nli);
            aVar.cc(4, this.Nld);
            aVar.e(5, 1, this.Nle);
            if (this.Lsm != null) {
                aVar.e(6, this.Lsm);
            }
            if (this.Nlf != null) {
                aVar.e(7, this.Nlf);
            }
            if (this.Lso != null) {
                aVar.e(8, this.Lso);
            }
            if (this.Lsn != null) {
                aVar.e(9, this.Lsn);
            }
            aVar.aM(10, this.Scene);
            AppMethodBeat.o(104843);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MD5 != null) {
                nh += g.a.a.b.b.a.f(2, this.MD5);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.a.c(5, 1, this.Nle);
            if (this.Lsm != null) {
                fS += g.a.a.b.b.a.f(6, this.Lsm);
            }
            if (this.Nlf != null) {
                fS += g.a.a.b.b.a.f(7, this.Nlf);
            }
            if (this.Lso != null) {
                fS += g.a.a.b.b.a.f(8, this.Lso);
            }
            if (this.Lsn != null) {
                fS += g.a.a.b.b.a.f(9, this.Lsn);
            }
            int bu = fS + g.a.a.b.b.a.bu(10, this.Scene);
            AppMethodBeat.o(104843);
            return bu;
        } else if (i2 == 2) {
            this.Nle.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104843);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eng eng = (eng) objArr[1];
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
                        eng.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104843);
                    return 0;
                case 2:
                    eng.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104843);
                    return 0;
                case 3:
                    eng.Nli = aVar3.UbS.yZ();
                    AppMethodBeat.o(104843);
                    return 0;
                case 4:
                    eng.Nld = aVar3.UbS.yZ();
                    AppMethodBeat.o(104843);
                    return 0;
                case 5:
                    eng.Nle.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104843);
                    return 0;
                case 6:
                    eng.Lsm = aVar3.UbS.readString();
                    AppMethodBeat.o(104843);
                    return 0;
                case 7:
                    eng.Nlf = aVar3.UbS.readString();
                    AppMethodBeat.o(104843);
                    return 0;
                case 8:
                    eng.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104843);
                    return 0;
                case 9:
                    eng.Lsn = aVar3.UbS.readString();
                    AppMethodBeat.o(104843);
                    return 0;
                case 10:
                    eng.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104843);
                    return 0;
                default:
                    AppMethodBeat.o(104843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104843);
            return -1;
        }
    }
}

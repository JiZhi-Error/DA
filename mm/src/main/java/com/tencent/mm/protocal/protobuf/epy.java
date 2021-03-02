package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class epy extends dop {
    public String IaW;
    public String KLH;
    public LinkedList<Integer> MNJ = new LinkedList<>();
    public String MVO;
    public String MVP;
    public String MVR;
    public String dDj;
    public String dHx;
    public String dNI;

    public epy() {
        AppMethodBeat.i(123675);
        AppMethodBeat.o(123675);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123676);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.e(3, 2, this.MNJ);
            if (this.MVO != null) {
                aVar.e(4, this.MVO);
            }
            if (this.KLH != null) {
                aVar.e(5, this.KLH);
            }
            if (this.dHx != null) {
                aVar.e(6, this.dHx);
            }
            if (this.IaW != null) {
                aVar.e(7, this.IaW);
            }
            if (this.MVR != null) {
                aVar.e(8, this.MVR);
            }
            if (this.dDj != null) {
                aVar.e(9, this.dDj);
            }
            if (this.MVP != null) {
                aVar.e(10, this.MVP);
            }
            AppMethodBeat.o(123676);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(3, 2, this.MNJ);
            if (this.MVO != null) {
                c2 += g.a.a.b.b.a.f(4, this.MVO);
            }
            if (this.KLH != null) {
                c2 += g.a.a.b.b.a.f(5, this.KLH);
            }
            if (this.dHx != null) {
                c2 += g.a.a.b.b.a.f(6, this.dHx);
            }
            if (this.IaW != null) {
                c2 += g.a.a.b.b.a.f(7, this.IaW);
            }
            if (this.MVR != null) {
                c2 += g.a.a.b.b.a.f(8, this.MVR);
            }
            if (this.dDj != null) {
                c2 += g.a.a.b.b.a.f(9, this.dDj);
            }
            if (this.MVP != null) {
                c2 += g.a.a.b.b.a.f(10, this.MVP);
            }
            AppMethodBeat.o(123676);
            return c2;
        } else if (i2 == 2) {
            this.MNJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123676);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epy epy = (epy) objArr[1];
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
                        epy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123676);
                    return 0;
                case 2:
                    epy.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 3:
                    epy.MNJ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(123676);
                    return 0;
                case 4:
                    epy.MVO = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 5:
                    epy.KLH = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 6:
                    epy.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 7:
                    epy.IaW = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 8:
                    epy.MVR = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 9:
                    epy.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                case 10:
                    epy.MVP = aVar3.UbS.readString();
                    AppMethodBeat.o(123676);
                    return 0;
                default:
                    AppMethodBeat.o(123676);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123676);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yx extends dop {
    public String LaE;
    public int LjY;
    public String fileid;
    public String md5;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(9588);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.fileid == null) {
                b bVar = new b("Not all required fields were included: fileid");
                AppMethodBeat.o(9588);
                throw bVar;
            } else if (this.md5 == null) {
                b bVar2 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(9588);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.fileid != null) {
                    aVar.e(2, this.fileid);
                }
                if (this.md5 != null) {
                    aVar.e(3, this.md5);
                }
                if (this.LaE != null) {
                    aVar.e(4, this.LaE);
                }
                aVar.aM(5, this.LjY);
                AppMethodBeat.o(9588);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.fileid != null) {
                nh += g.a.a.b.b.a.f(2, this.fileid);
            }
            if (this.md5 != null) {
                nh += g.a.a.b.b.a.f(3, this.md5);
            }
            if (this.LaE != null) {
                nh += g.a.a.b.b.a.f(4, this.LaE);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LjY);
            AppMethodBeat.o(9588);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.fileid == null) {
                b bVar3 = new b("Not all required fields were included: fileid");
                AppMethodBeat.o(9588);
                throw bVar3;
            } else if (this.md5 == null) {
                b bVar4 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(9588);
                throw bVar4;
            } else {
                AppMethodBeat.o(9588);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yx yxVar = (yx) objArr[1];
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
                        yxVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(9588);
                    return 0;
                case 2:
                    yxVar.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(9588);
                    return 0;
                case 3:
                    yxVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(9588);
                    return 0;
                case 4:
                    yxVar.LaE = aVar3.UbS.readString();
                    AppMethodBeat.o(9588);
                    return 0;
                case 5:
                    yxVar.LjY = aVar3.UbS.zi();
                    AppMethodBeat.o(9588);
                    return 0;
                default:
                    AppMethodBeat.o(9588);
                    return -1;
            }
        } else {
            AppMethodBeat.o(9588);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class jf extends a {
    public LinkedList<dlw> KNM = new LinkedList<>();
    public dys KNN;
    public String KNw;

    public jf() {
        AppMethodBeat.i(91357);
        AppMethodBeat.o(91357);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91358);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNw != null) {
                aVar.e(1, this.KNw);
            }
            aVar.e(2, 8, this.KNM);
            if (this.KNN != null) {
                aVar.ni(3, this.KNN.computeSize());
                this.KNN.writeFields(aVar);
            }
            AppMethodBeat.o(91358);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KNw != null ? g.a.a.b.b.a.f(1, this.KNw) + 0 : 0) + g.a.a.a.c(2, 8, this.KNM);
            if (this.KNN != null) {
                f2 += g.a.a.a.nh(3, this.KNN.computeSize());
            }
            AppMethodBeat.o(91358);
            return f2;
        } else if (i2 == 2) {
            this.KNM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91358);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jf jfVar = (jf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jfVar.KNw = aVar3.UbS.readString();
                    AppMethodBeat.o(91358);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlw dlw = new dlw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlw.populateBuilderWithField(aVar4, dlw, a.getNextFieldNumber(aVar4))) {
                        }
                        jfVar.KNM.add(dlw);
                    }
                    AppMethodBeat.o(91358);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dys dys = new dys();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dys.populateBuilderWithField(aVar5, dys, a.getNextFieldNumber(aVar5))) {
                        }
                        jfVar.KNN = dys;
                    }
                    AppMethodBeat.o(91358);
                    return 0;
                default:
                    AppMethodBeat.o(91358);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91358);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class clj extends dop {
    public int Ler;
    public long MqG;
    public long MqH;
    public long MqI;
    public int offset;
    public String query;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169915);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.MqG);
            aVar.bb(3, this.MqH);
            if (this.query != null) {
                aVar.e(4, this.query);
            }
            aVar.aM(5, this.offset);
            aVar.aM(6, this.Ler);
            aVar.bb(7, this.MqI);
            AppMethodBeat.o(169915);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.MqG) + g.a.a.b.b.a.r(3, this.MqH);
            if (this.query != null) {
                nh += g.a.a.b.b.a.f(4, this.query);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.offset) + g.a.a.b.b.a.bu(6, this.Ler) + g.a.a.b.b.a.r(7, this.MqI);
            AppMethodBeat.o(169915);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169915);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clj clj = (clj) objArr[1];
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
                        clj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169915);
                    return 0;
                case 2:
                    clj.MqG = aVar3.UbS.zl();
                    AppMethodBeat.o(169915);
                    return 0;
                case 3:
                    clj.MqH = aVar3.UbS.zl();
                    AppMethodBeat.o(169915);
                    return 0;
                case 4:
                    clj.query = aVar3.UbS.readString();
                    AppMethodBeat.o(169915);
                    return 0;
                case 5:
                    clj.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(169915);
                    return 0;
                case 6:
                    clj.Ler = aVar3.UbS.zi();
                    AppMethodBeat.o(169915);
                    return 0;
                case 7:
                    clj.MqI = aVar3.UbS.zl();
                    AppMethodBeat.o(169915);
                    return 0;
                default:
                    AppMethodBeat.o(169915);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169915);
            return -1;
        }
    }
}

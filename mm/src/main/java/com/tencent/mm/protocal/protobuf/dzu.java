package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dzu extends a {
    public String Desc;
    public int Height;
    public SKBuiltinBuffer_t MZq;
    public String Md5;
    public int Width;
    public int oUq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125784);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            if (this.MZq != null) {
                aVar.ni(2, this.MZq.computeSize());
                this.MZq.writeFields(aVar);
            }
            aVar.aM(3, this.Width);
            aVar.aM(4, this.Height);
            aVar.aM(5, this.oUq);
            if (this.Desc != null) {
                aVar.e(6, this.Desc);
            }
            AppMethodBeat.o(125784);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0;
            if (this.MZq != null) {
                f2 += g.a.a.a.nh(2, this.MZq.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height) + g.a.a.b.b.a.bu(5, this.oUq);
            if (this.Desc != null) {
                bu += g.a.a.b.b.a.f(6, this.Desc);
            }
            AppMethodBeat.o(125784);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125784);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzu dzu = (dzu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzu.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(125784);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dzu.MZq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125784);
                    return 0;
                case 3:
                    dzu.Width = aVar3.UbS.zi();
                    AppMethodBeat.o(125784);
                    return 0;
                case 4:
                    dzu.Height = aVar3.UbS.zi();
                    AppMethodBeat.o(125784);
                    return 0;
                case 5:
                    dzu.oUq = aVar3.UbS.zi();
                    AppMethodBeat.o(125784);
                    return 0;
                case 6:
                    dzu.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(125784);
                    return 0;
                default:
                    AppMethodBeat.o(125784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125784);
            return -1;
        }
    }
}

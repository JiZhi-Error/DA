package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bgn extends a {
    public String LQp;
    public String LQq;
    public String LzG;
    public String jfi;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200178);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.xut != null) {
                aVar.e(2, this.xut);
            }
            if (this.LzG != null) {
                aVar.e(3, this.LzG);
            }
            if (this.LQp != null) {
                aVar.e(4, this.LQp);
            }
            if (this.LQq != null) {
                aVar.e(5, this.LQq);
            }
            AppMethodBeat.o(200178);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(2, this.xut);
            }
            if (this.LzG != null) {
                f2 += g.a.a.b.b.a.f(3, this.LzG);
            }
            if (this.LQp != null) {
                f2 += g.a.a.b.b.a.f(4, this.LQp);
            }
            if (this.LQq != null) {
                f2 += g.a.a.b.b.a.f(5, this.LQq);
            }
            AppMethodBeat.o(200178);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200178);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgn bgn = (bgn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgn.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(200178);
                    return 0;
                case 2:
                    bgn.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(200178);
                    return 0;
                case 3:
                    bgn.LzG = aVar3.UbS.readString();
                    AppMethodBeat.o(200178);
                    return 0;
                case 4:
                    bgn.LQp = aVar3.UbS.readString();
                    AppMethodBeat.o(200178);
                    return 0;
                case 5:
                    bgn.LQq = aVar3.UbS.readString();
                    AppMethodBeat.o(200178);
                    return 0;
                default:
                    AppMethodBeat.o(200178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200178);
            return -1;
        }
    }
}

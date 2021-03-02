package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class GoodsObject extends a {
    public float center_x;
    public float center_y;
    public int maxx;
    public int maxy;
    public int minx;
    public int miny;
    public float obj_h;
    public float obj_w;
    public float relative_maxx;
    public float relative_maxy;
    public float relative_minx;
    public float relative_miny;
    public float score;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124513);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.relative_minx);
            aVar.E(2, this.relative_miny);
            aVar.E(3, this.relative_maxx);
            aVar.E(4, this.relative_maxy);
            aVar.E(5, this.score);
            aVar.aM(11, this.minx);
            aVar.aM(12, this.miny);
            aVar.aM(13, this.maxx);
            aVar.aM(14, this.maxy);
            aVar.E(21, this.center_x);
            aVar.E(22, this.center_y);
            aVar.E(23, this.obj_w);
            aVar.E(24, this.obj_h);
            AppMethodBeat.o(124513);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.bu(11, this.minx) + g.a.a.b.b.a.bu(12, this.miny) + g.a.a.b.b.a.bu(13, this.maxx) + g.a.a.b.b.a.bu(14, this.maxy) + g.a.a.b.b.a.fS(21) + 4 + g.a.a.b.b.a.fS(22) + 4 + g.a.a.b.b.a.fS(23) + 4 + g.a.a.b.b.a.fS(24) + 4;
            AppMethodBeat.o(124513);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124513);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            GoodsObject goodsObject = (GoodsObject) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    goodsObject.relative_minx = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 2:
                    goodsObject.relative_miny = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 3:
                    goodsObject.relative_maxx = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 4:
                    goodsObject.relative_maxy = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 5:
                    goodsObject.score = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                default:
                    AppMethodBeat.o(124513);
                    return -1;
                case 11:
                    goodsObject.minx = aVar3.UbS.zi();
                    AppMethodBeat.o(124513);
                    return 0;
                case 12:
                    goodsObject.miny = aVar3.UbS.zi();
                    AppMethodBeat.o(124513);
                    return 0;
                case 13:
                    goodsObject.maxx = aVar3.UbS.zi();
                    AppMethodBeat.o(124513);
                    return 0;
                case 14:
                    goodsObject.maxy = aVar3.UbS.zi();
                    AppMethodBeat.o(124513);
                    return 0;
                case 21:
                    goodsObject.center_x = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 22:
                    goodsObject.center_y = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 23:
                    goodsObject.obj_w = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
                case 24:
                    goodsObject.obj_h = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(124513);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124513);
            return -1;
        }
    }
}

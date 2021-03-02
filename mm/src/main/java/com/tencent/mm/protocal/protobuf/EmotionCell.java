package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class EmotionCell extends a {
    public String CellTitle;
    public String IconUrl;
    public int Position;
    public int ReqType;
    public String TagUrl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104772);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.CellTitle != null) {
                aVar.e(1, this.CellTitle);
            }
            aVar.aM(2, this.ReqType);
            aVar.aM(3, this.Position);
            if (this.IconUrl != null) {
                aVar.e(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                aVar.e(5, this.TagUrl);
            }
            AppMethodBeat.o(104772);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.CellTitle != null ? g.a.a.b.b.a.f(1, this.CellTitle) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ReqType) + g.a.a.b.b.a.bu(3, this.Position);
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                f2 += g.a.a.b.b.a.f(5, this.TagUrl);
            }
            AppMethodBeat.o(104772);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104772);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            EmotionCell emotionCell = (EmotionCell) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionCell.CellTitle = aVar3.UbS.readString();
                    AppMethodBeat.o(104772);
                    return 0;
                case 2:
                    emotionCell.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(104772);
                    return 0;
                case 3:
                    emotionCell.Position = aVar3.UbS.zi();
                    AppMethodBeat.o(104772);
                    return 0;
                case 4:
                    emotionCell.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104772);
                    return 0;
                case 5:
                    emotionCell.TagUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104772);
                    return 0;
                default:
                    AppMethodBeat.o(104772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104772);
            return -1;
        }
    }
}

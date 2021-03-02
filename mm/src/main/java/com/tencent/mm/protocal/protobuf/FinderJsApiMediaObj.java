package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderJsApiMediaObj extends a {
    public String mediaPath;
    public int mediaType;
    public FinderJsApiMediaThumbInfo thumbInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169000);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.mediaPath != null) {
                aVar.e(1, this.mediaPath);
            }
            aVar.aM(2, this.mediaType);
            if (this.thumbInfo != null) {
                aVar.ni(3, this.thumbInfo.computeSize());
                this.thumbInfo.writeFields(aVar);
            }
            AppMethodBeat.o(169000);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.mediaPath != null ? g.a.a.b.b.a.f(1, this.mediaPath) + 0 : 0) + g.a.a.b.b.a.bu(2, this.mediaType);
            if (this.thumbInfo != null) {
                f2 += g.a.a.a.nh(3, this.thumbInfo.computeSize());
            }
            AppMethodBeat.o(169000);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169000);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderJsApiMediaObj finderJsApiMediaObj = (FinderJsApiMediaObj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderJsApiMediaObj.mediaPath = aVar3.UbS.readString();
                    AppMethodBeat.o(169000);
                    return 0;
                case 2:
                    finderJsApiMediaObj.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169000);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderJsApiMediaThumbInfo finderJsApiMediaThumbInfo = new FinderJsApiMediaThumbInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderJsApiMediaThumbInfo.populateBuilderWithField(aVar4, finderJsApiMediaThumbInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        finderJsApiMediaObj.thumbInfo = finderJsApiMediaThumbInfo;
                    }
                    AppMethodBeat.o(169000);
                    return 0;
                default:
                    AppMethodBeat.o(169000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169000);
            return -1;
        }
    }
}

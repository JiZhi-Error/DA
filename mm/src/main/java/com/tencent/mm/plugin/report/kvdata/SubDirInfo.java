package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class SubDirInfo extends a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151539);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.tag_);
            aVar.bb(2, this.totalSize_);
            aVar.bb(3, this.dirCount_);
            aVar.bb(4, this.fileCount_);
            aVar.bb(5, this.fileLenInvalidCount);
            AppMethodBeat.o(151539);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.tag_) + 0 + g.a.a.b.b.a.r(2, this.totalSize_) + g.a.a.b.b.a.r(3, this.dirCount_) + g.a.a.b.b.a.r(4, this.fileCount_) + g.a.a.b.b.a.r(5, this.fileLenInvalidCount);
            AppMethodBeat.o(151539);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    subDirInfo.tag_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151539);
                    return 0;
                case 2:
                    subDirInfo.totalSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151539);
                    return 0;
                case 3:
                    subDirInfo.dirCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151539);
                    return 0;
                case 4:
                    subDirInfo.fileCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151539);
                    return 0;
                case 5:
                    subDirInfo.fileLenInvalidCount = aVar3.UbS.zl();
                    AppMethodBeat.o(151539);
                    return 0;
                default:
                    AppMethodBeat.o(151539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151539);
            return -1;
        }
    }
}

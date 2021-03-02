package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class WeChatSDInfo extends a {
    public int depth_;
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount_;
    public LinkedList<SubDirInfo> subDirList_ = new LinkedList<>();
    public int subDirResultsSize_;
    public long tempAccDirCount_;
    public int tempAccDirResultsSize_;
    public long tempAccFileCount_;
    public long tempAccFileLenInvalidCount_;
    public long tempAccTotalSize_;
    public long totalSize_;
    public long totalTime_;

    public WeChatSDInfo() {
        AppMethodBeat.i(151542);
        AppMethodBeat.o(151542);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151543);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.totalSize_);
            aVar.bb(2, this.dirCount_);
            aVar.bb(3, this.fileCount_);
            aVar.bb(4, this.fileLenInvalidCount_);
            aVar.aM(5, this.subDirResultsSize_);
            aVar.bb(6, this.totalTime_);
            aVar.aM(7, this.depth_);
            aVar.bb(8, this.tempAccTotalSize_);
            aVar.aM(9, this.tempAccDirResultsSize_);
            aVar.bb(10, this.tempAccDirCount_);
            aVar.bb(11, this.tempAccFileCount_);
            aVar.bb(12, this.tempAccFileLenInvalidCount_);
            aVar.e(13, 8, this.subDirList_);
            AppMethodBeat.o(151543);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.totalSize_) + 0 + g.a.a.b.b.a.r(2, this.dirCount_) + g.a.a.b.b.a.r(3, this.fileCount_) + g.a.a.b.b.a.r(4, this.fileLenInvalidCount_) + g.a.a.b.b.a.bu(5, this.subDirResultsSize_) + g.a.a.b.b.a.r(6, this.totalTime_) + g.a.a.b.b.a.bu(7, this.depth_) + g.a.a.b.b.a.r(8, this.tempAccTotalSize_) + g.a.a.b.b.a.bu(9, this.tempAccDirResultsSize_) + g.a.a.b.b.a.r(10, this.tempAccDirCount_) + g.a.a.b.b.a.r(11, this.tempAccFileCount_) + g.a.a.b.b.a.r(12, this.tempAccFileLenInvalidCount_) + g.a.a.a.c(13, 8, this.subDirList_);
            AppMethodBeat.o(151543);
            return r;
        } else if (i2 == 2) {
            this.subDirList_.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151543);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    weChatSDInfo.totalSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 2:
                    weChatSDInfo.dirCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 3:
                    weChatSDInfo.fileCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 4:
                    weChatSDInfo.fileLenInvalidCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 5:
                    weChatSDInfo.subDirResultsSize_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151543);
                    return 0;
                case 6:
                    weChatSDInfo.totalTime_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 7:
                    weChatSDInfo.depth_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151543);
                    return 0;
                case 8:
                    weChatSDInfo.tempAccTotalSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 9:
                    weChatSDInfo.tempAccDirResultsSize_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151543);
                    return 0;
                case 10:
                    weChatSDInfo.tempAccDirCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 11:
                    weChatSDInfo.tempAccFileCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 12:
                    weChatSDInfo.tempAccFileLenInvalidCount_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151543);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SubDirInfo subDirInfo = new SubDirInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = subDirInfo.populateBuilderWithField(aVar4, subDirInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        weChatSDInfo.subDirList_.add(subDirInfo);
                    }
                    AppMethodBeat.o(151543);
                    return 0;
                default:
                    AppMethodBeat.o(151543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151543);
            return -1;
        }
    }
}

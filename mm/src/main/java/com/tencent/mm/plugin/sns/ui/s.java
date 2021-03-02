package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class s {
    public TimeLineObject EpO;
    public boolean EpP;
    public String dHp;
    public int ixW = 0;

    public s(TimeLineObject timeLineObject, String str) {
        this.EpO = timeLineObject;
        this.dHp = str;
    }

    public s(TimeLineObject timeLineObject, String str, boolean z) {
        this.EpO = timeLineObject;
        this.dHp = str;
        this.EpP = z;
    }
}

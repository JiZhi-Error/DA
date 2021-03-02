package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class b {
    public TimeLineObject DqS;
    public boolean DzT;
    public ViewGroup mContainer;
    public String mTag;

    public b(String str) {
        AppMethodBeat.i(202321);
        this.mTag = TextUtils.isEmpty(str) ? "OnlineVideoChecker" : str;
        AppMethodBeat.o(202321);
    }
}

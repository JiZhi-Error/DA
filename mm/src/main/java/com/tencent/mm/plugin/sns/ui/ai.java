package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;

public final class ai {
    public TimeLineObject EpO;
    public WeakReference<View> EsG;
    public String dHp;

    public ai(TimeLineObject timeLineObject, View view, String str) {
        AppMethodBeat.i(203310);
        this.EpO = timeLineObject;
        this.EsG = new WeakReference<>(view);
        this.dHp = str;
        AppMethodBeat.o(203310);
    }
}

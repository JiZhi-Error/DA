package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public TimeLineObject DzU;
    public cnb DzV;
    private final String mTag;
    public ViewGroup okL;
    public String rzs;

    public c(String str) {
        AppMethodBeat.i(202322);
        this.mTag = TextUtils.isEmpty(str) ? "OnlineVideoLayoutBuilder" : str;
        AppMethodBeat.o(202322);
    }

    public final void layout() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(202323);
        try {
            if (this.DzV == null) {
                Log.e(this.mTag, "OnlineVideoLayoutBuilder: the media object is null");
                z = false;
            }
            if (this.DzU == null) {
                Log.e(this.mTag, "OnlineVideoLayoutBuilder: the time line object is null");
                z = false;
            }
            if (this.okL == null) {
                Log.e(this.mTag, "OnlineVideoLayoutBuilder: the video container is null");
                z = false;
            }
            if (TextUtils.isEmpty(this.rzs)) {
                Log.e(this.mTag, "OnlineVideoLayoutBuilder: the sns local id is empty");
            } else {
                z2 = z;
            }
            if (z2) {
                cnb cnb = this.DzV;
                TimeLineObject timeLineObject = this.DzU;
                ViewGroup viewGroup = this.okL;
                String str = this.rzs;
                String str2 = timeLineObject.Id;
                boolean aRu = d.fkS().aRu(str2);
                SnsTimelineVideoView aRx = d.fkS().aRx(str2);
                if (m.G(viewGroup)) {
                    View childAt = viewGroup.getChildAt(0);
                    if ((childAt instanceof SnsTimelineVideoView) && !Util.isEqual(str2, ((SnsTimelineVideoView) childAt).FcZ)) {
                        Log.w(this.mTag, "the obj id is not equal, remove child!!!!");
                        m.F(viewGroup);
                    }
                }
                if (aRx == null) {
                    Log.w(this.mTag, "the item is  null!!!!");
                } else {
                    aRx.a(cnb, str, timeLineObject.CreateTime);
                }
                if (aRx != null && !m.G(viewGroup)) {
                    Log.w(this.mTag, "the videoView is not null, the container is empty");
                    m.fc(aRx);
                    m.u(aRx, -1, -1);
                    m.u(aRx, true);
                    aRx.setVideoScaleType(i.e.COVER);
                    m.a(viewGroup, aRx, 0);
                    AppMethodBeat.o(202323);
                    return;
                } else if (aRu && m.G(viewGroup) && !d.fkS().aRv(str2)) {
                    Log.w(this.mTag, "the container is not empty, the state is invalid");
                    m.F(viewGroup);
                }
            }
            AppMethodBeat.o(202323);
        } catch (Throwable th) {
            AppMethodBeat.o(202323);
        }
    }
}

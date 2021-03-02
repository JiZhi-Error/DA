package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    public SnsInfo DqO;
    public cnb DzV;
    public k DzW;
    public String Dzk;
    public ViewGroup mContainer;
    private final String mTag;
    public String rzs;

    public d(String str) {
        AppMethodBeat.i(202324);
        this.mTag = TextUtils.isEmpty(str) ? "OnlineVideoPlayBuilder" : str;
        AppMethodBeat.o(202324);
    }

    public final void a(int i2, SnsTimelineVideoView.b bVar) {
        boolean z = false;
        AppMethodBeat.i(202325);
        boolean z2 = true;
        if (this.DqO == null) {
            Log.e(this.mTag, "OnlinePlayerHelper:the sns info is null");
            z2 = false;
        }
        if (this.DzV == null) {
            Log.e(this.mTag, "OnlinePlayerHelper:the media object is null");
            z2 = false;
        }
        if (this.mContainer == null) {
            Log.e(this.mTag, "OnlinePlayerHelper:the container is null");
            z2 = false;
        }
        if (TextUtils.isEmpty(this.Dzk)) {
            Log.e(this.mTag, "OnlinePlayerHelper:the time line id is empty");
            z2 = false;
        }
        if (TextUtils.isEmpty(this.rzs)) {
            Log.e(this.mTag, "OnlinePlayerHelper:the sns local id is empty");
            z2 = false;
        }
        if (this.DzW == null) {
            Log.e(this.mTag, "OnlinePlayerHelper:the snsAdStatistic is null");
        } else {
            z = z2;
        }
        if (z) {
            a(this.DqO, this.DzV, this.Dzk, this.mContainer, this.rzs, this.DzW, bVar, i2);
        }
        AppMethodBeat.o(202325);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.sns.storage.SnsInfo r11, com.tencent.mm.protocal.protobuf.cnb r12, java.lang.String r13, android.view.ViewGroup r14, java.lang.String r15, com.tencent.mm.plugin.sns.ad.g.k r16, com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b r17, int r18) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.timeline.video.online.d.a(com.tencent.mm.plugin.sns.storage.SnsInfo, com.tencent.mm.protocal.protobuf.cnb, java.lang.String, android.view.ViewGroup, java.lang.String, com.tencent.mm.plugin.sns.ad.g.k, com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView$b, int):void");
    }
}

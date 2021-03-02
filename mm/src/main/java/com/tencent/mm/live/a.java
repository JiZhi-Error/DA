package com.tencent.mm.live;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.live.b.c.c;

public interface a extends d {

    /* renamed from: com.tencent.mm.live.a$a  reason: collision with other inner class name */
    public interface AbstractC0368a {
        void c(long j2, int i2);
    }

    long curLiveId();

    void forceStopCurLive(Context context);

    c getLiveTipsBarStorage();

    String getLivingRoomId();

    boolean isAnchorLiving();

    boolean isVisitorLiving();

    com.tencent.mm.live.api.a liveEntranceJumper();

    void refreshLiveStatus(long j2, String str, AbstractC0368a aVar);
}

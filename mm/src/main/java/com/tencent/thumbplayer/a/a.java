package com.tencent.thumbplayer.a;

import com.tencent.thumbplayer.a.a.b;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPVideoInfo;
import java.util.Map;

public interface a extends b {
    void a(e eVar);

    void a(e eVar, int i2, long j2);

    void a(e eVar, Map<String, String> map);

    void a(TPVideoInfo tPVideoInfo);

    int getCurrentPlayClipNo();

    int getCurrentState();

    int getPlayerType();

    b hmK();

    boolean isPlaying();

    void setOnPlayerStateChangeListener(c.h hVar);

    void setVideoInfo(TPVideoInfo tPVideoInfo);
}

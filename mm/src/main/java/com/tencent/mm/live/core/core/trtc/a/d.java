package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCStatistics;

public interface d {
    void a(TRTCCloudDef.TRTCQuality tRTCQuality);

    void onConnectOtherRoom(String str, int i2, String str2);

    void onDisConnectOtherRoom(int i2, String str);

    void onEnterRoom(long j2);

    void onError(int i2, String str, Bundle bundle);

    void onExitRoom(int i2);

    void onFirstVideoFrame(String str, int i2, int i3, int i4);

    void onRemoteUserLeaveRoom(String str, int i2);

    void onStatistics(TRTCStatistics tRTCStatistics);

    void onUserAudioAvailable(String str, boolean z);

    void onUserSubStreamAvailable(String str, boolean z);

    void onUserVideoAvailable(String str, boolean z);

    void onWarning(int i2, String str, Bundle bundle);
}

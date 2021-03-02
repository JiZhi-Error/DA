package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b extends TRTCCloudListener {
    private static final String TAG = b.class.getName();
    private WeakReference<d> hAW;

    static {
        AppMethodBeat.i(196262);
        AppMethodBeat.o(196262);
    }

    public b(d dVar) {
        AppMethodBeat.i(196244);
        this.hAW = new WeakReference<>(dVar);
        AppMethodBeat.o(196244);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j2) {
        AppMethodBeat.i(196245);
        Log.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(j2)));
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onEnterRoom(j2);
        }
        AppMethodBeat.o(196245);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i2) {
        AppMethodBeat.i(196246);
        Log.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(i2)));
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onExitRoom(i2);
        }
        AppMethodBeat.o(196246);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i2, String str, Bundle bundle) {
        AppMethodBeat.i(196247);
        Log.i(TAG, "onError: errCode = " + i2 + " errMsg = " + str);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onError(i2, str, bundle);
        }
        AppMethodBeat.o(196247);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i2, String str, Bundle bundle) {
        AppMethodBeat.i(261572);
        Log.i(TAG, "onWarning: %d, warningMsg: %s", Integer.valueOf(i2), str);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onWarning(i2, str, bundle);
        }
        AppMethodBeat.o(261572);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String str) {
        AppMethodBeat.i(196248);
        Log.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(str)));
        AppMethodBeat.o(196248);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String str, int i2) {
        AppMethodBeat.i(196249);
        Log.i(TAG, "onRemoteUserLeaveRoom: userId = " + str + " reason = " + i2);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onRemoteUserLeaveRoom(str, i2);
        }
        AppMethodBeat.o(196249);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z) {
        AppMethodBeat.i(196250);
        Log.i(TAG, "onUserVideoAvailable: userId = " + str + " available = " + z);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onUserVideoAvailable(str, z);
        }
        AppMethodBeat.o(196250);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserSubStreamAvailable(String str, boolean z) {
        AppMethodBeat.i(196251);
        Log.i(TAG, "onUserSubStreamAvailable: userId = " + str + " available = " + z);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onUserSubStreamAvailable(str, z);
        }
        AppMethodBeat.o(196251);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z) {
        AppMethodBeat.i(196252);
        Log.i(TAG, "onUserAudioAvailable: userId = " + str + " available = " + z);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onUserAudioAvailable(str, z);
        }
        AppMethodBeat.o(196252);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(196253);
        Log.i(TAG, "onFirstVideoFrame: userId = " + str + " streamType = " + i2 + " width = " + i3 + " height = " + i4);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onFirstVideoFrame(str, i2, i3, i4);
        }
        AppMethodBeat.o(196253);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i2) {
        AppMethodBeat.i(196254);
        this.hAW.get();
        AppMethodBeat.o(196254);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
        AppMethodBeat.i(196255);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onStatistics(tRTCStatistics);
        }
        AppMethodBeat.o(196255);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(String str, int i2, String str2) {
        AppMethodBeat.i(196256);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onConnectOtherRoom(str, i2, str2);
        }
        AppMethodBeat.o(196256);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onDisConnectOtherRoom(int i2, String str) {
        AppMethodBeat.i(196257);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.onDisConnectOtherRoom(i2, str);
        }
        AppMethodBeat.o(196257);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
        AppMethodBeat.i(196258);
        d dVar = this.hAW.get();
        if (dVar != null) {
            dVar.a(tRTCQuality);
        }
        AppMethodBeat.o(196258);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioEffectFinished(int i2, int i3) {
        AppMethodBeat.i(196259);
        this.hAW.get();
        AppMethodBeat.o(196259);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvCustomCmdMsg(String str, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(196260);
        this.hAW.get();
        AppMethodBeat.o(196260);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        AppMethodBeat.i(196261);
        this.hAW.get();
        AppMethodBeat.o(196261);
    }
}

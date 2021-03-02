package com.tencent.mm.live.core.core.trtc.a;

import android.os.Environment;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static final String hAX = (Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac");
    private TRTCCloud hAY;
    private boolean hAZ = true;
    private int hBa = 0;
    private int hBb;
    private int hBc = 0;
    private a hBd;
    private int mAppScene;
    private int mBeautyLevel = 5;
    private int mRuddyLevel = 2;
    private TRTCCloudDef.TRTCParams mTRTCParams;
    private int mWhiteningLevel = 3;

    public interface a {
        void ex(boolean z);
    }

    static {
        AppMethodBeat.i(196277);
        AppMethodBeat.o(196277);
    }

    public c() {
    }

    public c(TRTCCloud tRTCCloud, TRTCCloudDef.TRTCParams tRTCParams) {
        AppMethodBeat.i(196263);
        this.hAY = tRTCCloud;
        this.mTRTCParams = tRTCParams;
        this.mAppScene = 1;
        this.hBb = tRTCParams == null ? 21 : this.mTRTCParams.role;
        AppMethodBeat.o(196263);
    }

    public final void a(a aVar) {
        this.hBd = aVar;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(196264);
        this.hAY.setListener(new b(dVar));
        AppMethodBeat.o(196264);
    }

    public final void aDK() {
        AppMethodBeat.i(196267);
        aDL();
        aDM();
        aDN();
        AppMethodBeat.o(196267);
    }

    public final void exitRoom() {
        AppMethodBeat.i(196271);
        if (this.hAY != null) {
            this.hAY.exitRoom();
        }
        AppMethodBeat.o(196271);
    }

    private void setSystemVolumeType(int i2) {
        AppMethodBeat.i(196272);
        this.hAY.setSystemVolumeType(i2);
        AppMethodBeat.o(196272);
    }

    public final int aDO() {
        int i2 = 20;
        AppMethodBeat.i(196273);
        if (this.hBb == 20) {
            i2 = 21;
        }
        if (this.hAY != null) {
            this.hAY.switchRole(i2);
        }
        this.hBb = i2;
        int i3 = this.hBb;
        AppMethodBeat.o(196273);
        return i3;
    }

    public final int aDP() {
        return this.hBb;
    }

    public final void startLocalAudio() {
        AppMethodBeat.i(196274);
        this.hAY.startLocalAudio();
        AppMethodBeat.o(196274);
    }

    public final void stopLocalAudio() {
        AppMethodBeat.i(196275);
        this.hAY.stopLocalAudio();
        AppMethodBeat.o(196275);
    }

    public final void bG(String str, String str2, String str3) {
        AppMethodBeat.i(261573);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("roomId", Long.parseLong(str));
            jSONObject.put("userId", str2);
            jSONObject.put("sign", str3);
            this.hAY.ConnectOtherRoom(jSONObject.toString());
            AppMethodBeat.o(261573);
        } catch (Exception e2) {
            AppMethodBeat.o(261573);
        }
    }

    public final void bpZ() {
        AppMethodBeat.i(261574);
        this.hAY.DisconnectOtherRoom();
        AppMethodBeat.o(261574);
    }

    public final void ey(boolean z) {
        AppMethodBeat.i(196276);
        this.hAY.enableAudioEarMonitoring(z);
        AppMethodBeat.o(196276);
    }

    public final void aDI() {
        AppMethodBeat.i(196265);
        com.tencent.mm.live.core.core.trtc.a.a.a aDE = a.C0385a.hAV.aDE();
        d aDD = a.C0385a.hAV.aDD();
        this.hAY.enableCustomVideoCapture(true);
        this.hAY.setDefaultStreamRecvMode(true, true);
        if (aDD.hBx) {
            this.hAY.setLocalViewFillMode(0);
        } else {
            this.hAY.setLocalViewFillMode(1);
        }
        this.hAY.setLocalViewRotation(aDD.hBF);
        if (aDE.hBk) {
            this.hAY.setAudioRoute(0);
        } else {
            this.hAY.setAudioRoute(1);
        }
        if (aDD.hBD) {
            this.hAY.setGSensorMode(2);
        } else {
            this.hAY.setGSensorMode(0);
        }
        setSystemVolumeType(aDE.hBf);
        this.hAY.setVideoEncoderMirror(aDD.cIw);
        this.hAY.setLocalViewMirror(aDD.hBy);
        aDK();
        AppMethodBeat.o(196265);
    }

    public final void aDJ() {
        int i2 = 0;
        AppMethodBeat.i(196266);
        this.hAY.setAudioQuality(a.C0385a.hAV.aDE().hBo);
        setSystemVolumeType(a.C0385a.hAV.aDE().hBf);
        boolean z = a.C0385a.hAV.aDE().hBl;
        if (z) {
            this.hAY.enableAudioVolumeEvaluation(300);
        } else {
            this.hAY.enableAudioVolumeEvaluation(0);
        }
        if (this.hBd != null) {
            this.hBd.ex(z);
        }
        boolean z2 = a.C0385a.hAV.aDD().uKs;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ProviderConstants.API_PATH, "enableHevcEncode");
            JSONObject jSONObject2 = new JSONObject();
            if (z2) {
                i2 = 1;
            }
            jSONObject2.put("enable", i2);
            jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject2);
            this.hAY.callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e2) {
        }
        this.hAY.enterRoom(this.mTRTCParams, this.mAppScene);
        AppMethodBeat.o(196266);
    }

    private void aDL() {
        AppMethodBeat.i(196268);
        d aDD = a.C0385a.hAV.aDD();
        TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        tRTCVideoEncParam.videoResolution = aDD.hBu;
        tRTCVideoEncParam.videoFps = aDD.hBv;
        tRTCVideoEncParam.videoBitrate = aDD.mVideoBitrate;
        tRTCVideoEncParam.minVideoBitrate = aDD.mMinVideoBitrate;
        if (aDD.uKs) {
            tRTCVideoEncParam.videoResolution = aDD.uEA;
            tRTCVideoEncParam.videoFps = aDD.uHx;
            tRTCVideoEncParam.videoBitrate = aDD.uHy;
            tRTCVideoEncParam.minVideoBitrate = aDD.uHL;
        }
        tRTCVideoEncParam.videoResolutionMode = aDD.hBw ? 1 : 0;
        this.hAY.setVideoEncoderParam(tRTCVideoEncParam);
        AppMethodBeat.o(196268);
    }

    private void aDM() {
        AppMethodBeat.i(196269);
        d aDD = a.C0385a.hAV.aDD();
        TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
        tRTCNetworkQosParam.controlMode = aDD.mQosMode;
        tRTCNetworkQosParam.preference = aDD.mQosPreference;
        this.hAY.setNetworkQosParam(tRTCNetworkQosParam);
        AppMethodBeat.o(196269);
    }

    private void aDN() {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(196270);
        d aDD = a.C0385a.hAV.aDD();
        TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        tRTCVideoEncParam.videoResolution = 100;
        tRTCVideoEncParam.videoFps = aDD.hBv;
        tRTCVideoEncParam.videoBitrate = 100;
        if (aDD.hBw) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        tRTCVideoEncParam.videoResolutionMode = i2;
        this.hAY.enableEncSmallVideoStream(aDD.hBB, tRTCVideoEncParam);
        TRTCCloud tRTCCloud = this.hAY;
        if (!aDD.hBC) {
            i3 = 0;
        }
        tRTCCloud.setPriorRemoteVideoStreamType(i3);
        AppMethodBeat.o(196270);
    }
}

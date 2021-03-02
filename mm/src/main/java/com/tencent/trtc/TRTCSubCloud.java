package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.a.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCCloudHevcUtil;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;

public class TRTCSubCloud extends TRTCCloudImpl {
    private static final String TAG = TRTCSubCloud.class.getName();
    protected WeakReference<TRTCCloudImpl> mMainCloud = null;
    private a mVolumeLevelCalTask = null;

    static /* synthetic */ void access$1300(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222760);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222760);
    }

    static /* synthetic */ void access$1500(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222761);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222761);
    }

    static /* synthetic */ void access$1700(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222762);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222762);
    }

    static /* synthetic */ void access$1800(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222763);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222763);
    }

    static /* synthetic */ void access$1900(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222764);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222764);
    }

    static /* synthetic */ void access$200(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222758);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222758);
    }

    static /* synthetic */ void access$2000(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222765);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222765);
    }

    static /* synthetic */ void access$2100(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222766);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222766);
    }

    static /* synthetic */ void access$2200(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222767);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222767);
    }

    static /* synthetic */ long access$2700(TRTCSubCloud tRTCSubCloud, int i2, int i3, int i4) {
        AppMethodBeat.i(222768);
        long nativeCreateContext = tRTCSubCloud.nativeCreateContext(i2, i3, i4);
        AppMethodBeat.o(222768);
        return nativeCreateContext;
    }

    static /* synthetic */ void access$2800(TRTCSubCloud tRTCSubCloud, int i2) {
        AppMethodBeat.i(222769);
        tRTCSubCloud.updateAppScene(i2);
        AppMethodBeat.o(222769);
    }

    static /* synthetic */ int access$3100(TRTCSubCloud tRTCSubCloud, long j2, int i2) {
        AppMethodBeat.i(222770);
        int nativeSetPriorRemoteVideoStreamType = tRTCSubCloud.nativeSetPriorRemoteVideoStreamType(j2, i2);
        AppMethodBeat.o(222770);
        return nativeSetPriorRemoteVideoStreamType;
    }

    static /* synthetic */ void access$3500(TRTCSubCloud tRTCSubCloud, long j2, int i2, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(222771);
        tRTCSubCloud.nativeInit(j2, i2, str, str2, bArr);
        AppMethodBeat.o(222771);
    }

    static /* synthetic */ int access$3900(TRTCSubCloud tRTCSubCloud, long j2, long j3, String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, String str4, String str5, int i7, String str6, String str7, int i8) {
        AppMethodBeat.i(259984);
        int nativeEnterRoom = tRTCSubCloud.nativeEnterRoom(j2, j3, str, str2, str3, i2, i3, i4, i5, i6, str4, str5, i7, str6, str7, i8);
        AppMethodBeat.o(259984);
        return nativeEnterRoom;
    }

    static /* synthetic */ void access$400(TRTCSubCloud tRTCSubCloud, long j2) {
        AppMethodBeat.i(222759);
        tRTCSubCloud.nativeDestroyContext(j2);
        AppMethodBeat.o(222759);
    }

    static /* synthetic */ void access$4200(TRTCSubCloud tRTCSubCloud) {
        AppMethodBeat.i(222773);
        tRTCSubCloud.startCollectStatus();
        AppMethodBeat.o(222773);
    }

    static /* synthetic */ void access$5100(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222774);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222774);
    }

    static /* synthetic */ void access$5200(TRTCSubCloud tRTCSubCloud, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(222775);
        tRTCSubCloud.stopRemoteRender(userInfo);
        AppMethodBeat.o(222775);
    }

    static /* synthetic */ void access$5400(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222776);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222776);
    }

    static /* synthetic */ void access$5500(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222777);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222777);
    }

    static /* synthetic */ void access$5600(TRTCSubCloud tRTCSubCloud, Runnable runnable) {
        AppMethodBeat.i(222778);
        tRTCSubCloud.runOnListenerThread(runnable);
        AppMethodBeat.o(222778);
    }

    static /* synthetic */ void access$5700(TRTCSubCloud tRTCSubCloud, Runnable runnable) {
        AppMethodBeat.i(222779);
        tRTCSubCloud.runOnListenerThread(runnable);
        AppMethodBeat.o(222779);
    }

    static /* synthetic */ void access$5900(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222780);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222780);
    }

    static /* synthetic */ void access$6100(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222781);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222781);
    }

    static /* synthetic */ void access$6400(TRTCSubCloud tRTCSubCloud, Runnable runnable) {
        AppMethodBeat.i(222782);
        tRTCSubCloud.runOnListenerThread(runnable);
        AppMethodBeat.o(222782);
    }

    static /* synthetic */ void access$6900(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222783);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222783);
    }

    static /* synthetic */ void access$7000(TRTCSubCloud tRTCSubCloud, JSONObject jSONObject) {
        AppMethodBeat.i(222784);
        tRTCSubCloud.setSEIPayloadType(jSONObject);
        AppMethodBeat.o(222784);
    }

    static /* synthetic */ void access$7100(TRTCSubCloud tRTCSubCloud, JSONObject jSONObject) {
        AppMethodBeat.i(222785);
        tRTCSubCloud.muteRemoteAudioInSpeaker(jSONObject);
        AppMethodBeat.o(222785);
    }

    static /* synthetic */ void access$7200(TRTCSubCloud tRTCSubCloud, JSONObject jSONObject) {
        AppMethodBeat.i(222786);
        tRTCSubCloud.setPerformanceMode(jSONObject);
        AppMethodBeat.o(222786);
    }

    static /* synthetic */ void access$7300(TRTCSubCloud tRTCSubCloud, JSONObject jSONObject, String str) {
        AppMethodBeat.i(222787);
        tRTCSubCloud.sendJsonCmd(jSONObject, str);
        AppMethodBeat.o(222787);
    }

    static /* synthetic */ void access$7400(TRTCSubCloud tRTCSubCloud, JSONObject jSONObject) {
        AppMethodBeat.i(222788);
        tRTCSubCloud.updatePrivateMapKey(jSONObject);
        AppMethodBeat.o(222788);
    }

    static /* synthetic */ void access$7500(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222789);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222789);
    }

    static /* synthetic */ void access$7600(TRTCSubCloud tRTCSubCloud, String str) {
        AppMethodBeat.i(222790);
        tRTCSubCloud.apiLog(str);
        AppMethodBeat.o(222790);
    }

    static {
        AppMethodBeat.i(222791);
        AppMethodBeat.o(222791);
    }

    public TRTCSubCloud(Context context, WeakReference<TRTCCloudImpl> weakReference, Handler handler) {
        super(context, handler);
        this.mRoomInfo.muteLocalAudio = true;
        this.mRoomInfo.muteLocalVideo = true;
        this.mMainCloud = weakReference;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void destroy() {
        AppMethodBeat.i(222711);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(222697);
                synchronized (TRTCSubCloud.this.mNativeLock) {
                    try {
                        if (TRTCSubCloud.this.mNativeRtcContext != 0) {
                            TRTCSubCloud.access$200(TRTCSubCloud.this, "destroy context");
                            TRTCSubCloud.access$400(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext);
                        }
                        TRTCSubCloud.this.mNativeRtcContext = 0;
                    } catch (Throwable th) {
                        AppMethodBeat.o(222697);
                        throw th;
                    }
                }
                TRTCSubCloud.this.mTRTCListener = null;
                TRTCSubCloud.this.mAudioFrameListener = null;
                TRTCSubCloud.this.mCurrentPublishClouds.clear();
                TRTCSubCloud.this.mSubClouds.clear();
                AppMethodBeat.o(222697);
            }
        });
        AppMethodBeat.o(222711);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, java.lang.Object
    public void finalize() {
        AppMethodBeat.i(222712);
        this.mSDKHandler = null;
        super.finalize();
        AppMethodBeat.o(222712);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setListener(TRTCCloudListener tRTCCloudListener) {
        AppMethodBeat.i(222713);
        super.setListener(tRTCCloudListener);
        AppMethodBeat.o(222713);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setListenerHandler(Handler handler) {
        AppMethodBeat.i(222714);
        super.setListenerHandler(handler);
        AppMethodBeat.o(222714);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, final int i2) {
        String str;
        String str2;
        AppMethodBeat.i(222715);
        if (tRTCParams == null) {
            apiLog("enter room, param nil!");
            onEnterRoom(TXLiteAVCode.ERR_ENTER_ROOM_PARAM_NULL, "enter room param null");
            AppMethodBeat.o(222715);
            return;
        }
        final TRTCCloudDef.TRTCParams tRTCParams2 = new TRTCCloudDef.TRTCParams(tRTCParams);
        if (tRTCParams2.sdkAppId == 0 || TextUtils.isEmpty(tRTCParams2.userId) || TextUtils.isEmpty(tRTCParams2.userSig)) {
            apiLog("enterRoom param invalid:".concat(String.valueOf(tRTCParams2)));
            if (tRTCParams2.sdkAppId == 0) {
                onEnterRoom(TXLiteAVCode.ERR_SDK_APPID_INVALID, "enter room sdkAppId invalid.");
            }
            if (TextUtils.isEmpty(tRTCParams2.userSig)) {
                onEnterRoom(TXLiteAVCode.ERR_USER_SIG_INVALID, "enter room userSig invalid.");
            }
            if (TextUtils.isEmpty(tRTCParams2.userId)) {
                onEnterRoom(TXLiteAVCode.ERR_USER_ID_INVALID, "enter room userId invalid.");
            }
            AppMethodBeat.o(222715);
            return;
        }
        final long j2 = ((long) tRTCParams2.roomId) & Util.MAX_32BIT_VALUE;
        if (j2 == 0) {
            apiLog("enter room, room id " + j2 + " error");
            onEnterRoom(TXLiteAVCode.ERR_ROOM_ID_INVALID, "room id invalid.");
            AppMethodBeat.o(222715);
            return;
        }
        final String str3 = "";
        final String str4 = tRTCParams2.businessInfo;
        if (tRTCParams2.roomId == -1 && !TextUtils.isEmpty(tRTCParams2.businessInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(tRTCParams2.businessInfo);
                str = jSONObject.optString("strGroupId");
                jSONObject.remove("strGroupId");
                jSONObject.remove("Role");
                str2 = "";
                if (jSONObject.length() != 0) {
                    str2 = jSONObject.toString();
                }
            } catch (Exception e2) {
                apiLog("enter room, room id error, busInfo " + tRTCParams2.businessInfo);
                str = "";
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                onEnterRoom(TXLiteAVCode.ERR_ROOM_ID_INVALID, "room id invalid.");
                AppMethodBeat.o(222715);
                return;
            }
            str4 = str2;
            str3 = str;
        }
        final int i3 = tRTCParams2.role;
        final long currentTimeMillis = System.currentTimeMillis();
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass2 */

            public final void run() {
                int i2;
                AppMethodBeat.i(222710);
                if (TRTCSubCloud.this.mRoomState != 0) {
                    if ((TextUtils.isEmpty(str3) || !str3.equalsIgnoreCase(TRTCSubCloud.this.mRoomInfo.strRoomId)) && TRTCSubCloud.this.mRoomInfo.roomId != j2) {
                        TRTCSubCloud.access$1500(TRTCSubCloud.this, String.format("enter another room[%d] when in room[%d], exit the old room!!!", Long.valueOf(j2), Long.valueOf(TRTCSubCloud.this.mRoomInfo.roomId)));
                        TRTCSubCloud.this.mIsExitOldRoom = true;
                        TRTCSubCloud.this.exitRoom();
                    } else {
                        TRTCSubCloud.access$1300(TRTCSubCloud.this, String.format("enter the same room[%d] again, ignore!!!", Long.valueOf(j2)));
                        AppMethodBeat.o(222710);
                        return;
                    }
                }
                TRTCSubCloud.access$1700(TRTCSubCloud.this, "========================================================================================================");
                TRTCSubCloud.access$1800(TRTCSubCloud.this, "========================================================================================================");
                TRTCSubCloud.access$1900(TRTCSubCloud.this, String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", TXCCommonUtil.getSDKVersionStr(), f.c(), f.d()));
                TRTCSubCloud.access$2000(TRTCSubCloud.this, "========================================================================================================");
                TRTCSubCloud.access$2100(TRTCSubCloud.this, "========================================================================================================");
                TRTCSubCloud.access$2200(TRTCSubCloud.this, String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d", Long.valueOf(j2), str3, tRTCParams2.userId, Integer.valueOf(tRTCParams2.sdkAppId), Integer.valueOf(i2)));
                String str = "enterRoom self:" + TRTCSubCloud.this.hashCode() + ", roomId:" + (tRTCParams2.roomId == -1 ? str3 : Integer.valueOf(tRTCParams2.roomId));
                int i3 = i2;
                String str2 = "VideoCall";
                switch (i2) {
                    case 0:
                        str2 = "VideoCall";
                        i2 = i3;
                        break;
                    case 1:
                        str2 = "Live";
                        i2 = i3;
                        break;
                    case 2:
                        str2 = "AudioCall";
                        i2 = 0;
                        break;
                    case 3:
                        str2 = "VoiceChatRoom";
                        i2 = 1;
                        break;
                    default:
                        TXCLog.w(TRTCSubCloud.TAG, "enter room scene:%u error! default to VideoCall! " + i2 + " self:" + TRTCSubCloud.this.hashCode());
                        i2 = 0;
                        break;
                }
                Object[] objArr = new Object[4];
                objArr[0] = str4;
                objArr[1] = str2;
                objArr[2] = i3 == 20 ? "Anchor" : "Audience";
                objArr[3] = tRTCParams2.streamId;
                Monitor.a(1, str, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", objArr), 0);
                TXCEventRecorderProxy.a("18446744073709551615", 5001, j2, -1, "", 0);
                TRTCSubCloud.this.mRoomState = 1;
                if (TRTCSubCloud.this.mNativeRtcContext == 0) {
                    int[] sDKVersion = TXCCommonUtil.getSDKVersion();
                    TRTCSubCloud.this.mNativeRtcContext = TRTCSubCloud.access$2700(TRTCSubCloud.this, sDKVersion.length > 0 ? sDKVersion[0] : 0, sDKVersion.length >= 2 ? sDKVersion[1] : 0, sDKVersion.length >= 3 ? sDKVersion[2] : 0);
                }
                TRTCSubCloud.access$2800(TRTCSubCloud.this, i2);
                TRTCSubCloud.access$3100(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, TRTCSubCloud.this.mPriorStreamType);
                TRTCSubCloud.access$3500(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, tRTCParams2.sdkAppId, tRTCParams2.userId, tRTCParams2.userSig, TRTCSubCloud.this.mRoomInfo.getToken(TRTCSubCloud.this.mContext));
                String str3 = tRTCParams2.privateMapKey != null ? tRTCParams2.privateMapKey : "";
                String str4 = str3 != null ? str3 : "";
                TRTCSubCloud.access$3900(TRTCSubCloud.this, TRTCSubCloud.this.mNativeRtcContext, j2, str4 != null ? str4 : "", str3, str4, i3, 255, 0, i2, TRTCSubCloud.this.mPerformanceMode, f.c(), f.d(), TRTCSubCloud.this.mRecvMode, tRTCParams2.userDefineRecordId != null ? tRTCParams2.userDefineRecordId : "", tRTCParams2.streamId != null ? tRTCParams2.streamId : "", TRTCCloudHevcUtil.getEnterRoomCodecSupportValue());
                TRTCSubCloud.this.mCurrentRole = i3;
                TRTCSubCloud.this.mTargetRole = i3;
                TRTCSubCloud.access$4200(TRTCSubCloud.this);
                TRTCSubCloud.this.mLastStateTimeMs = 0;
                TRTCSubCloud.this.mRoomInfo.init(j2, tRTCParams2.userId);
                TRTCSubCloud.this.mRoomInfo.strRoomId = str4;
                TRTCSubCloud.this.mRoomInfo.sdkAppId = tRTCParams2.sdkAppId;
                TRTCSubCloud.this.mRoomInfo.userSig = tRTCParams2.userSig;
                TRTCSubCloud.this.mRoomInfo.privateMapKey = str3;
                TRTCSubCloud.this.mRoomInfo.enterTime = currentTimeMillis;
                AppMethodBeat.o(222710);
            }
        });
        AppMethodBeat.o(222715);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        AppMethodBeat.i(222716);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(222701);
                String str = "exitRoom " + TRTCSubCloud.this.mRoomInfo.getRoomId() + ", " + TRTCSubCloud.this.hashCode();
                TRTCSubCloud.access$5100(TRTCSubCloud.this, str);
                Monitor.a(1, str, "", 0);
                TRTCSubCloud.this.exitRoomInternal(true, "call from api");
                AppMethodBeat.o(222701);
            }
        });
        AppMethodBeat.o(222716);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void exitRoomInternal(boolean z, String str) {
        AppMethodBeat.i(222717);
        apiLog("exitRoomInternal reqExit: " + z + ", reason: " + str + ", mRoomState: " + this.mRoomState);
        if (this.mRoomState == 0) {
            apiLog("exitRoom ignore when no in room");
            AppMethodBeat.o(222717);
            return;
        }
        this.mRoomState = 0;
        stopCollectStatus();
        this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass4 */

            @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
            public final void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                AppMethodBeat.i(222706);
                TRTCSubCloud.access$5200(TRTCSubCloud.this, userInfo);
                TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(userInfo.tinyID));
                if (userInfo.mainRender.render != null) {
                    userInfo.mainRender.render.setVideoFrameListener(null, b.UNKNOWN);
                }
                if (userInfo.subRender.render != null) {
                    userInfo.subRender.render.setVideoFrameListener(null, b.UNKNOWN);
                }
                AppMethodBeat.o(222706);
            }
        });
        if (z) {
            nativeExitRoom(this.mNativeRtcContext);
        }
        this.mRoomInfo.clear();
        this.mRenderListenerMap.clear();
        AppMethodBeat.o(222717);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void switchRole(int i2) {
        AppMethodBeat.i(222718);
        super.switchRole(i2);
        AppMethodBeat.o(222718);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void ConnectOtherRoom(String str) {
        AppMethodBeat.i(222719);
        super.ConnectOtherRoom(str);
        AppMethodBeat.o(222719);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void DisconnectOtherRoom() {
        AppMethodBeat.i(222720);
        super.DisconnectOtherRoom();
        AppMethodBeat.o(222720);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setDefaultStreamRecvMode(boolean z, boolean z2) {
        AppMethodBeat.i(222721);
        super.setDefaultStreamRecvMode(z, z2);
        AppMethodBeat.o(222721);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startLocalPreview(boolean z, TXCloudVideoView tXCloudVideoView) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopLocalPreview() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(222722);
        super.startRemoteView(str, tXCloudVideoView);
        AppMethodBeat.o(222722);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopRemoteView(String str) {
        AppMethodBeat.i(222723);
        super.stopRemoteView(str);
        AppMethodBeat.o(222723);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(222724);
        super.startRemoteSubStreamView(str, tXCloudVideoView);
        AppMethodBeat.o(222724);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopRemoteSubStreamView(String str) {
        AppMethodBeat.i(222725);
        super.stopRemoteSubStreamView(str);
        AppMethodBeat.o(222725);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setRemoteSubStreamViewFillMode(String str, int i2) {
        AppMethodBeat.i(222726);
        super.setRemoteSubStreamViewFillMode(str, i2);
        AppMethodBeat.o(222726);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setRemoteSubStreamViewRotation(String str, int i2) {
        AppMethodBeat.i(222727);
        super.setRemoteSubStreamViewRotation(str, i2);
        AppMethodBeat.o(222727);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopAllRemoteView() {
        AppMethodBeat.i(222728);
        super.stopAllRemoteView();
        AppMethodBeat.o(222728);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void snapshotVideo(final String str, final int i2, final TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        AppMethodBeat.i(222729);
        apiLog(String.format("snapshotVideo user:%s streamType:%d", str, Integer.valueOf(i2)));
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(222707);
                if (str != null) {
                    TRTCRoomInfo.UserInfo user = TRTCSubCloud.this.mRoomInfo.getUser(str);
                    e eVar = null;
                    if (i2 == 2) {
                        if (!(user == null || user.mainRender == null || user.mainRender.render == null)) {
                            TRTCSubCloud.access$5400(TRTCSubCloud.this, "snapshotRemoteSubStreamView->userId: " + str);
                            eVar = user.subRender.render.getVideoRender();
                        }
                    } else if (!(user == null || user.mainRender == null || user.mainRender.render == null)) {
                        TRTCSubCloud.access$5500(TRTCSubCloud.this, "snapshotRemoteView->userId: " + str);
                        eVar = user.mainRender.render.getVideoRender();
                    }
                    if (eVar != null) {
                        eVar.a(new o() {
                            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.liteav.basic.c.o
                            public final void onTakePhotoComplete(final Bitmap bitmap) {
                                AppMethodBeat.i(222700);
                                TRTCSubCloud.access$5600(TRTCSubCloud.this, new Runnable() {
                                    /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(222698);
                                        if (tRTCSnapshotListener != null) {
                                            tRTCSnapshotListener.onSnapshotComplete(bitmap);
                                        }
                                        AppMethodBeat.o(222698);
                                    }
                                });
                                AppMethodBeat.o(222700);
                            }
                        });
                        AppMethodBeat.o(222707);
                        return;
                    }
                    TRTCSubCloud.access$5700(TRTCSubCloud.this, new Runnable() {
                        /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass5.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(222695);
                            if (tRTCSnapshotListener != null) {
                                tRTCSnapshotListener.onSnapshotComplete(null);
                            }
                            AppMethodBeat.o(222695);
                        }
                    });
                }
                AppMethodBeat.o(222707);
            }
        });
        AppMethodBeat.o(222729);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteLocalVideo(final boolean z) {
        AppMethodBeat.i(222730);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(222696);
                TRTCSubCloud.access$5900(TRTCSubCloud.this, "muteLocalVideo " + z + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
                Monitor.a(1, String.format("muteLocalVideo mute:%b", Boolean.valueOf(z)) + " self:" + TRTCSubCloud.this.hashCode(), "", 0);
                TRTCCloudImpl tRTCCloudImpl = TRTCSubCloud.this.mMainCloud.get();
                if (tRTCCloudImpl != null) {
                    tRTCCloudImpl.muteLocalVideo(z, TRTCSubCloud.this);
                }
                AppMethodBeat.o(222696);
            }
        });
        AppMethodBeat.o(222730);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteRemoteVideoStream(String str, boolean z) {
        AppMethodBeat.i(222731);
        super.muteRemoteVideoStream(str, z);
        AppMethodBeat.o(222731);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteAllRemoteVideoStreams(boolean z) {
        AppMethodBeat.i(222732);
        super.muteAllRemoteVideoStreams(z);
        AppMethodBeat.o(222732);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setLocalViewFillMode(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setRemoteViewFillMode(String str, int i2) {
        AppMethodBeat.i(222733);
        super.setRemoteViewFillMode(str, i2);
        AppMethodBeat.o(222733);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setLocalViewRotation(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setRemoteViewRotation(String str, int i2) {
        AppMethodBeat.i(222734);
        super.setRemoteViewRotation(str, i2);
        AppMethodBeat.o(222734);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setVideoEncoderRotation(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setGSensorMode(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int enableEncSmallVideoStream(boolean z, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        return -1;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int setPriorRemoteVideoStreamType(int i2) {
        AppMethodBeat.i(222735);
        int priorRemoteVideoStreamType = super.setPriorRemoteVideoStreamType(i2);
        AppMethodBeat.o(222735);
        return priorRemoteVideoStreamType;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setLocalViewMirror(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setVideoEncoderMirror(boolean z) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startLocalAudio() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopLocalAudio() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int setRemoteVideoStreamType(String str, int i2) {
        AppMethodBeat.i(222736);
        int remoteVideoStreamType = super.setRemoteVideoStreamType(str, i2);
        AppMethodBeat.o(222736);
        return remoteVideoStreamType;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAudioRoute(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteLocalAudio(final boolean z) {
        AppMethodBeat.i(222737);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(222686);
                TRTCSubCloud.access$6100(TRTCSubCloud.this, "muteLocalAudio " + z + ", roomId=" + TRTCSubCloud.this.mRoomInfo.getRoomId());
                Monitor.a(1, String.format("muteLocalAudio mute:%b", Boolean.valueOf(z)) + " self:" + TRTCSubCloud.this.hashCode(), "", 0);
                TRTCCloudImpl tRTCCloudImpl = TRTCSubCloud.this.mMainCloud.get();
                if (tRTCCloudImpl != null) {
                    tRTCCloudImpl.muteLocalAudio(z, TRTCSubCloud.this);
                }
                AppMethodBeat.o(222686);
            }
        });
        AppMethodBeat.o(222737);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteRemoteAudio(String str, boolean z) {
        AppMethodBeat.i(222738);
        super.muteRemoteAudio(str, z);
        AppMethodBeat.o(222738);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void muteAllRemoteAudio(boolean z) {
        AppMethodBeat.i(222739);
        super.muteAllRemoteAudio(z);
        AppMethodBeat.o(222739);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setRemoteAudioVolume(String str, int i2) {
        AppMethodBeat.i(222740);
        super.setRemoteAudioVolume(str, i2);
        AppMethodBeat.o(222740);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAudioCaptureVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int getAudioCaptureVolume() {
        return 0;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAudioPlayoutVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int getAudioPlayoutVolume() {
        return 0;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setSystemVolumeType(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enableAudioEarMonitoring(boolean z) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TRTCSubCloud> f2963a;

        a(TRTCSubCloud tRTCSubCloud) {
            AppMethodBeat.i(222703);
            this.f2963a = new WeakReference<>(tRTCSubCloud);
            AppMethodBeat.o(222703);
        }

        public final void run() {
            AppMethodBeat.i(222704);
            TRTCSubCloud tRTCSubCloud = null;
            if (this.f2963a != null) {
                tRTCSubCloud = this.f2963a.get();
            }
            if (tRTCSubCloud != null) {
                final ArrayList arrayList = new ArrayList();
                tRTCSubCloud.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.trtc.TRTCSubCloud.a.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public final void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222708);
                        int remotePlayoutVolumeLevel = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(userInfo.tinyID));
                        if (remotePlayoutVolumeLevel > 0) {
                            TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                            tRTCVolumeInfo.userId = userInfo.userID;
                            tRTCVolumeInfo.volume = remotePlayoutVolumeLevel;
                            arrayList.add(tRTCVolumeInfo);
                        }
                        AppMethodBeat.o(222708);
                    }
                });
                final TRTCCloudListener tRTCCloudListener = tRTCSubCloud.mTRTCListener;
                TRTCSubCloud.access$6400(tRTCSubCloud, new Runnable() {
                    /* class com.tencent.trtc.TRTCSubCloud.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(222685);
                        if (tRTCCloudListener != null) {
                            tRTCCloudListener.onUserVoiceVolume(arrayList, 0);
                        }
                        AppMethodBeat.o(222685);
                    }
                });
                if (tRTCSubCloud.mAudioVolumeEvalInterval > 0) {
                    tRTCSubCloud.mSDKHandler.postDelayed(tRTCSubCloud.mVolumeLevelCalTask, (long) tRTCSubCloud.mAudioVolumeEvalInterval);
                }
            }
            AppMethodBeat.o(222704);
        }
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void startVolumeLevelCal(boolean z) {
        AppMethodBeat.i(222741);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(z, this.mAudioVolumeEvalInterval);
        if (!z) {
            this.mVolumeLevelCalTask = null;
            this.mAudioVolumeEvalInterval = 0;
        } else if (this.mVolumeLevelCalTask == null) {
            this.mVolumeLevelCalTask = new a(this);
            this.mSDKHandler.postDelayed(this.mVolumeLevelCalTask, (long) this.mAudioVolumeEvalInterval);
            AppMethodBeat.o(222741);
            return;
        }
        AppMethodBeat.o(222741);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enableAudioVolumeEvaluation(int i2) {
        AppMethodBeat.i(222742);
        super.enableAudioVolumeEvaluation(i2);
        AppMethodBeat.o(222742);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        return -1;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopAudioRecording() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void switchCamera() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setZoom(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean enableTorch(boolean z) {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean isCameraFocusPositionInPreviewSupported() {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFocusPosition(int i2, int i3) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean isCameraAutoFocusFaceModeSupported() {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public TXBeautyManager getBeautyManager() {
        return null;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setBeautyStyle(int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFilter(Bitmap bitmap) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFilterConcentration(float f2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void selectMotionTmpl(String str) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setMotionMute(boolean z) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean setGreenScreenFile(String str) {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setEyeScaleLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFaceSlimLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFaceVLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setFaceShortLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setChinLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setNoseSlimLevel(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setWatermark(Bitmap bitmap, int i2, float f2, float f3, float f4) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enableCustomVideoCapture(boolean z) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void callExperimentalAPI(final String str) {
        AppMethodBeat.i(222743);
        if (str != null) {
            apiLog("callExperimentalAPI  " + str + ", roomid = " + (this.mRoomInfo.roomId != -1 ? Long.valueOf(this.mRoomInfo.roomId) : this.mRoomInfo.strRoomId));
            Monitor.a(1, String.format("callExperimentalAPI:%s", str) + " self:" + hashCode(), "", 0);
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.TRTCSubCloud.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(222702);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has(ProviderConstants.API_PATH)) {
                        TRTCSubCloud.access$6900(TRTCSubCloud.this, "callExperimentalAPI[lack api or illegal type]: " + str);
                        AppMethodBeat.o(222702);
                        return;
                    }
                    String string = jSONObject.getString(ProviderConstants.API_PATH);
                    JSONObject jSONObject2 = null;
                    if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                        jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                    }
                    if (string.equals("setSEIPayloadType")) {
                        TRTCSubCloud.access$7000(TRTCSubCloud.this, jSONObject2);
                        AppMethodBeat.o(222702);
                        return;
                    }
                    if (!string.equals("setLocalAudioMuteMode") && !string.equals("setVideoEncodeParamEx") && !string.equals("setAudioSampleRate")) {
                        if (string.equals("muteRemoteAudioInSpeaker")) {
                            TRTCSubCloud.access$7100(TRTCSubCloud.this, jSONObject2);
                            AppMethodBeat.o(222702);
                            return;
                        } else if (!string.equals("enableAudioAGC") && !string.equals("enableAudioAEC") && !string.equals("enableAudioANS")) {
                            if (string.equals("setPerformanceMode")) {
                                TRTCSubCloud.access$7200(TRTCSubCloud.this, jSONObject2);
                                AppMethodBeat.o(222702);
                                return;
                            } else if (!string.equals("setCustomRenderMode") && !string.equals("setMediaCodecConfig")) {
                                if (string.equals("sendJsonCMD")) {
                                    TRTCSubCloud.access$7300(TRTCSubCloud.this, jSONObject2, str);
                                    AppMethodBeat.o(222702);
                                    return;
                                } else if (string.equals("updatePrivateMapKey")) {
                                    TRTCSubCloud.access$7400(TRTCSubCloud.this, jSONObject2);
                                    AppMethodBeat.o(222702);
                                    return;
                                } else {
                                    TRTCSubCloud.access$7500(TRTCSubCloud.this, "callExperimentalAPI[illegal api]: ".concat(String.valueOf(string)));
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(222702);
                } catch (Exception e2) {
                    TRTCSubCloud.access$7600(TRTCSubCloud.this, "callExperimentalAPI[failed]: " + str);
                    AppMethodBeat.o(222702);
                }
            }
        });
        AppMethodBeat.o(222743);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int setLocalVideoRenderListener(int i2, int i3, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return -1;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int setRemoteVideoRenderListener(String str, int i2, int i3, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        AppMethodBeat.i(222744);
        int remoteVideoRenderListener = super.setRemoteVideoRenderListener(str, i2, i3, tRTCVideoRenderListener);
        AppMethodBeat.o(222744);
        return remoteVideoRenderListener;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enableCustomAudioCapture(boolean z) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void playBGM(String str, TRTCCloud.BGMNotify bGMNotify) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopBGM() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void pauseBGM() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void resumeBGM() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int getBGMDuration(String str) {
        return 0;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public int setBGMPosition(int i2) {
        return 0;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setMicVolumeOnMixing(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setBGMVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setBGMPlayoutVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setBGMPublishVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setReverbType(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean setVoiceChangerType(int i2) {
        return false;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAudioEffectVolume(int i2, int i3) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopAudioEffect(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopAllAudioEffects() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAllAudioEffectsVolume(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void pauseAudioEffect(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void resumeAudioEffect(int i2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void showDebugView(int i2) {
        AppMethodBeat.i(222745);
        super.showDebugView(i2);
        AppMethodBeat.o(222745);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setDebugViewMargin(String str, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
        AppMethodBeat.i(222746);
        super.setDebugViewMargin(str, tRTCViewMargin);
        AppMethodBeat.o(222746);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startSpeedTest(int i2, String str, String str2) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopSpeedTest() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        AppMethodBeat.i(222747);
        super.startPublishCDNStream(tRTCPublishCDNParam);
        AppMethodBeat.o(222747);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopPublishing() {
        AppMethodBeat.i(222748);
        super.stopPublishing();
        AppMethodBeat.o(222748);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void stopPublishCDNStream() {
        AppMethodBeat.i(222749);
        super.stopPublishCDNStream();
        AppMethodBeat.o(222749);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startPublishing(String str, int i2) {
        AppMethodBeat.i(222750);
        super.startPublishing(str, i2);
        AppMethodBeat.o(222750);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        AppMethodBeat.i(222751);
        super.setMixTranscodingConfig(tRTCTranscodingConfig);
        AppMethodBeat.o(222751);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean sendCustomCmdMsg(int i2, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(222752);
        boolean sendCustomCmdMsg = super.sendCustomCmdMsg(i2, bArr, z, z2);
        AppMethodBeat.o(222752);
        return sendCustomCmdMsg;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public boolean sendSEIMsg(byte[] bArr, int i2) {
        AppMethodBeat.i(222753);
        boolean sendSEIMsg = super.sendSEIMsg(bArr, i2);
        AppMethodBeat.o(222753);
        return sendSEIMsg;
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void onAudioQosChanged(int i2, int i3, int i4) {
        AppMethodBeat.i(222754);
        TRTCCloudImpl tRTCCloudImpl = this.mMainCloud.get();
        if (tRTCCloudImpl != null) {
            tRTCCloudImpl.onAudioQosChanged(this, i2, i3, i4);
        }
        AppMethodBeat.o(222754);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void onVideoQosChanged(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(259983);
        TRTCCloudImpl tRTCCloudImpl = this.mMainCloud.get();
        if (tRTCCloudImpl != null) {
            tRTCCloudImpl.onVideoQosChanged(this, i2, i3, i4, i5, i6, i7, i8, i9);
        }
        AppMethodBeat.o(259983);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void onIdrFpsChanged(int i2) {
        AppMethodBeat.i(222756);
        TRTCCloudImpl tRTCCloudImpl = this.mMainCloud.get();
        if (tRTCCloudImpl != null) {
            tRTCCloudImpl.onIdrFpsChanged(this, i2);
        }
        AppMethodBeat.o(222756);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void onVideoConfigChanged(int i2, boolean z) {
        AppMethodBeat.i(222757);
        TRTCCloudImpl tRTCCloudImpl = this.mMainCloud.get();
        if (tRTCCloudImpl != null) {
            tRTCCloudImpl.onVideoConfigChanged(this, i2, z);
        }
        AppMethodBeat.o(222757);
    }

    /* access modifiers changed from: protected */
    public void collectCustomCaptureFps() {
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public TRTCCloud createSubCloud() {
        return null;
    }
}

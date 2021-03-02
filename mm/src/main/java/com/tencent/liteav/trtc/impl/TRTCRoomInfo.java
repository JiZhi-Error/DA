package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.g;
import com.tencent.liteav.renderer.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

public class TRTCRoomInfo {
    public static final int NETWORK_STATUS_OFFLINE = 1;
    public static final int NETWORK_STATUS_ONLINE = 3;
    public static final int NETWORK_STATUS_RECONNECTING = 2;
    public static final int STATE_AUDIO = 8;
    public static final int STATE_BIG_VIDEO = 1;
    public static final int STATE_MUTE_AUDIO = 64;
    public static final int STATE_MUTE_MAIN_VIDEO = 16;
    public static final int STATE_MUTE_SUB_VIDEO = 32;
    public static final int STATE_SMALL_VIDEO = 2;
    public static final int STATE_SUB_VIDEO = 4;
    private static final String TAG = "TRTCRoomInfo";
    private static final String TOKEN = "TRTC.0x0.Token";
    private static final String TRTC_INFO = "TRTC.Info";
    public g.a bigEncSize = new g.a();
    public TRTCCloud.TRTCViewMargin debugMargin = new TRTCCloud.TRTCViewMargin(0.0f, 0.0f, 0.1f, 0.0f);
    public JSONArray decProperties = null;
    public boolean enableCustomPreprocessor = false;
    public boolean enableRestartDecoder = false;
    public long enterTime;
    private int exitRoomCode = 0;
    private boolean hasExitedRoom = false;
    public int localBufferType;
    public TRTCCloudListener.TRTCVideoRenderListener localListener;
    public int localPixelFormat;
    public int localRenderRotation = 0;
    public TXCloudVideoView localView = null;
    private boolean micHasStartd = false;
    public boolean muteLocalAudio = false;
    public boolean muteLocalVideo = false;
    public boolean muteRemoteAudio = false;
    public boolean muteRemoteVideo = false;
    public int networkStatus = 1;
    public String privateMapKey;
    private HashMap<Long, Integer> recvFirstIFrameCntList = new HashMap<>();
    public long roomId;
    public int sdkAppId;
    public g.a smallEncSize = new g.a();
    public String strRoomId;
    public String tinyId;
    public byte[] token = null;
    public String userId = "";
    private HashMap<String, UserInfo> userList = new HashMap<>();
    public String userSig;

    public interface UserAction {
        void accept(String str, UserInfo userInfo);
    }

    public TRTCRoomInfo() {
        AppMethodBeat.i(15731);
        AppMethodBeat.o(15731);
    }

    public static class RenderInfo implements SurfaceHolder.Callback {
        public boolean muteAudio = false;
        public boolean muteVideo = false;
        public TXCRenderAndDec render = null;
        public long tinyID;
        public TXCloudVideoView view = null;

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(15664);
            TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceCreated " + surfaceHolder.getSurface() + ", " + this.tinyID + ", " + this.render);
            if (surfaceHolder.getSurface().isValid()) {
                e videoRender = this.render != null ? this.render.getVideoRender() : null;
                if (videoRender != null) {
                    videoRender.a(surfaceHolder.getSurface());
                }
            }
            AppMethodBeat.o(15664);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            AppMethodBeat.i(15665);
            TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceChanged " + surfaceHolder.getSurface() + " width " + i3 + ", height " + i4 + ", " + this.tinyID + ", " + this.render);
            e videoRender = this.render != null ? this.render.getVideoRender() : null;
            if (videoRender != null) {
                videoRender.c(i3, i4);
            }
            AppMethodBeat.o(15665);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            e eVar;
            AppMethodBeat.i(15666);
            TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceDestroyed " + surfaceHolder.getSurface() + ", " + this.tinyID + ", " + this.render);
            if (this.render != null) {
                eVar = this.render.getVideoRender();
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.a((Surface) null);
            }
            AppMethodBeat.o(15666);
        }

        public void stop() {
            AppMethodBeat.i(15667);
            try {
                if (!(this.view == null || this.view.getSurfaceView() == null || this.view.getSurfaceView().getHolder() == null)) {
                    this.view.getSurfaceView().getHolder().removeCallback(this);
                }
                AppMethodBeat.o(15667);
            } catch (Exception e2) {
                TXCLog.e(TRTCRoomInfo.TAG, "remove callback failed.", e2);
                AppMethodBeat.o(15667);
            }
        }
    }

    public static class UserInfo {
        public TRTCCloud.TRTCViewMargin debugMargin = new TRTCCloud.TRTCViewMargin(0.0f, 0.0f, 0.1f, 0.0f);
        public RenderInfo mainRender = new RenderInfo();
        public boolean muteAudioInSpeaker = false;
        public int streamState;
        public int streamType = 2;
        public RenderInfo subRender = new RenderInfo();
        public int terminalType;
        public long tinyID;
        public String userID;

        public UserInfo(long j2, String str, int i2, int i3) {
            AppMethodBeat.i(15718);
            this.tinyID = j2;
            this.userID = str;
            this.terminalType = i2;
            this.streamState = i3;
            this.mainRender.tinyID = j2;
            this.subRender.tinyID = j2;
            AppMethodBeat.o(15718);
        }
    }

    public void init(long j2, String str) {
        this.roomId = j2;
        this.userId = str;
    }

    public synchronized void clear() {
        AppMethodBeat.i(15732);
        this.roomId = 0;
        this.userId = "";
        this.enterTime = 0;
        this.tinyId = "";
        this.muteLocalVideo = false;
        this.muteLocalAudio = false;
        this.muteRemoteVideo = false;
        this.muteRemoteAudio = false;
        this.userList.clear();
        this.recvFirstIFrameCntList.clear();
        this.networkStatus = 1;
        this.decProperties = null;
        this.enableRestartDecoder = false;
        this.enableCustomPreprocessor = false;
        this.localListener = null;
        AppMethodBeat.o(15732);
    }

    public String getStrRoomId() {
        AppMethodBeat.i(15733);
        if (TextUtils.isEmpty(this.strRoomId)) {
            String valueOf = String.valueOf(this.roomId);
            AppMethodBeat.o(15733);
            return valueOf;
        }
        String str = this.strRoomId;
        AppMethodBeat.o(15733);
        return str;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int i2) {
        this.roomId = (long) i2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getTinyId() {
        return this.tinyId;
    }

    public void setTinyId(String str) {
        this.tinyId = str;
    }

    private String byteArrayToHexStr(byte[] bArr) {
        AppMethodBeat.i(15734);
        if (bArr == null) {
            AppMethodBeat.o(15734);
            return null;
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            cArr[i2 * 2] = charArray[i3 >>> 4];
            cArr[(i2 * 2) + 1] = charArray[i3 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(15734);
        return str;
    }

    private byte[] hexStrToByteArray(String str) {
        AppMethodBeat.i(15735);
        if (str == null) {
            AppMethodBeat.o(15735);
            return null;
        } else if (str.length() == 0) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(15735);
            return bArr;
        } else {
            byte[] bArr2 = new byte[(str.length() / 2)];
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr2[i2] = (byte) Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16);
            }
            AppMethodBeat.o(15735);
            return bArr2;
        }
    }

    public void setToken(Context context, byte[] bArr) {
        AppMethodBeat.i(15736);
        this.token = bArr;
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(TRTC_INFO, 0).edit();
            if (this.token != null) {
                edit.putString(TOKEN, byteArrayToHexStr(this.token));
            } else {
                edit.clear();
            }
            edit.commit();
            AppMethodBeat.o(15736);
        } catch (Exception e2) {
            TXCLog.e(TAG, "set token failed.", e2);
            AppMethodBeat.o(15736);
        }
    }

    public byte[] getToken(Context context) {
        AppMethodBeat.i(15737);
        try {
            if (this.token == null) {
                this.token = hexStrToByteArray(context.getSharedPreferences(TRTC_INFO, 0).getString(TOKEN, ""));
            }
        } catch (Exception e2) {
            TXCLog.e(TAG, "get token failed.", e2);
        }
        byte[] bArr = this.token;
        AppMethodBeat.o(15737);
        return bArr;
    }

    public long getRoomElapsed() {
        AppMethodBeat.i(15738);
        long currentTimeMillis = System.currentTimeMillis() - this.enterTime;
        AppMethodBeat.o(15738);
        return currentTimeMillis;
    }

    public synchronized void addUserInfo(String str, UserInfo userInfo) {
        AppMethodBeat.i(15739);
        this.userList.put(str, userInfo);
        AppMethodBeat.o(15739);
    }

    public synchronized void removeRenderInfo(String str) {
        AppMethodBeat.i(15740);
        this.recvFirstIFrameCntList.remove(Long.valueOf(this.userList.get(str).tinyID));
        this.userList.remove(str);
        AppMethodBeat.o(15740);
    }

    public synchronized UserInfo getUser(String str) {
        UserInfo userInfo;
        AppMethodBeat.i(15741);
        userInfo = this.userList.get(str);
        AppMethodBeat.o(15741);
        return userInfo;
    }

    public synchronized String getUserIdByTinyId(long j2) {
        String str;
        AppMethodBeat.i(15742);
        Iterator<Map.Entry<String, UserInfo>> it = this.userList.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                AppMethodBeat.o(15742);
                break;
            }
            UserInfo value = it.next().getValue();
            if (value != null && value.tinyID == j2) {
                str = value.userID;
                AppMethodBeat.o(15742);
                break;
            }
        }
        return str;
    }

    public void forEachUser(UserAction userAction) {
        AppMethodBeat.i(15743);
        HashMap hashMap = new HashMap(this.userList.size());
        synchronized (this) {
            try {
                hashMap.putAll(this.userList);
            } finally {
                AppMethodBeat.o(15743);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!(userAction == null || entry.getValue() == null)) {
                userAction.accept((String) entry.getKey(), (UserInfo) entry.getValue());
            }
        }
    }

    public synchronized void clearUserList() {
        AppMethodBeat.i(15744);
        this.userList.clear();
        this.recvFirstIFrameCntList.clear();
        AppMethodBeat.o(15744);
    }

    public synchronized int recvFirstIFrame(long j2) {
        int intValue;
        AppMethodBeat.i(15745);
        Integer num = this.recvFirstIFrameCntList.get(Long.valueOf(j2));
        this.recvFirstIFrameCntList.put(Long.valueOf(j2), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
        if (num == null) {
            AppMethodBeat.o(15745);
            intValue = 1;
        } else {
            intValue = num.intValue() + 1;
            AppMethodBeat.o(15745);
        }
        return intValue;
    }

    public synchronized boolean hasRecvFirstIFrame(long j2) {
        boolean z;
        AppMethodBeat.i(15746);
        Integer num = this.recvFirstIFrameCntList.get(Long.valueOf(j2));
        if (num == null || num.intValue() <= 0) {
            z = false;
            AppMethodBeat.o(15746);
        } else {
            z = true;
            AppMethodBeat.o(15746);
        }
        return z;
    }

    public void micStart(boolean z) {
        this.micHasStartd = z;
    }

    public synchronized boolean isMicStard() {
        return this.micHasStartd;
    }

    public synchronized void setRoomExit(boolean z, int i2) {
        this.hasExitedRoom = z;
        this.exitRoomCode = i2;
    }

    public synchronized boolean isRoomExit() {
        return this.hasExitedRoom;
    }

    public synchronized int getRoomExitCode() {
        return this.exitRoomCode;
    }

    public static boolean isMuteMainVideo(int i2) {
        return (i2 & 16) != 0;
    }

    public static boolean isMuteSubVideo(int i2) {
        return (i2 & 32) != 0;
    }

    public static boolean isMuteAudio(int i2) {
        return (i2 & 64) != 0;
    }

    public static boolean hasMainVideo(int i2) {
        return (i2 & 1) != 0;
    }

    public static boolean hasSmallVideo(int i2) {
        return (i2 & 2) != 0;
    }

    public static boolean hasSubVideo(int i2) {
        return (i2 & 4) != 0;
    }

    public static boolean hasAudio(int i2) {
        return (i2 & 8) != 0;
    }
}

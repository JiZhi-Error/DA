package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader {
    public int connectRetryInterval = 3;
    public int connectRetryLimit = 3;
    public int connectRetryTimes = 0;
    protected Context mApplicationContext = null;
    protected boolean mEnableMessage = false;
    protected boolean mEnableMetaData = false;
    protected String mFlvSessionKey = "";
    protected Map<String, String> mHeaders;
    protected boolean mIsRunning = false;
    protected f mListener = null;
    protected b mNotifyListener = null;
    protected String mOriginUrl = "";
    protected a mRestartListener = null;
    protected String mUserID = "";

    public interface a {
        void onOldStreamStop();

        void onRestartDownloader();
    }

    public abstract void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3, boolean z4);

    public abstract void stopDownload();

    public TXIStreamDownloader(Context context) {
        this.mApplicationContext = context;
    }

    public void setListener(f fVar) {
        this.mListener = fVar;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setNotifyListener(b bVar) {
        this.mNotifyListener = bVar;
    }

    public void setRestartListener(a aVar) {
        this.mRestartListener = aVar;
    }

    public void sendNotifyEvent(int i2) {
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i2, null);
        }
    }

    public void sendNotifyEvent(int i2, String str) {
        if (this.mNotifyListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            this.mNotifyListener.onNotifyEvent(i2, bundle);
        }
    }

    public void onRecvVideoData(byte[] bArr, int i2, long j2, long j3, int i3) {
        if (this.mListener != null) {
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.nalType = i2;
            tXSNALPacket.dts = j2;
            tXSNALPacket.pts = j3;
            tXSNALPacket.codecId = i3;
            this.mListener.onPullNAL(tXSNALPacket);
        }
    }

    public void onRecvAudioData(byte[] bArr, int i2, int i3, int i4) {
        if (this.mListener != null) {
            com.tencent.liteav.basic.structs.a aVar = new com.tencent.liteav.basic.structs.a();
            aVar.f425f = bArr;
            aVar.f424e = (long) i2;
            if (i3 == 10) {
                if (i4 == 1) {
                    aVar.f423d = 2;
                } else {
                    aVar.f423d = 3;
                }
                if (aVar.f423d == 2) {
                    aVar.f422c = 16;
                }
            }
            if (i3 == 2) {
                aVar.f423d = 5;
            }
            aVar.f427h = i3;
            aVar.f426g = i4;
            this.mListener.onPullAudio(aVar);
        }
    }

    public void onRecvSEIData(byte[] bArr) {
        if (bArr != null && bArr.length > 0 && this.mNotifyListener != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(TXLiveConstants.EVT_GET_MSG, bArr);
            this.mNotifyListener.onNotifyEvent(2012, bundle);
        }
    }

    public void onRecvMetaData(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0 && this.mNotifyListener != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("EVT_GET_METADATA", hashMap);
            this.mNotifyListener.onNotifyEvent(2028, bundle);
        }
    }

    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        return null;
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public String getCurrentStreamUrl() {
        return null;
    }

    public String getRealStreamUrl() {
        return null;
    }

    public boolean isQuicChannel() {
        return false;
    }

    public int getConnectCountQuic() {
        return 0;
    }

    public int getConnectCountTcp() {
        return 0;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public void PushVideoFrame(byte[] bArr, int i2, long j2, long j3, int i3) {
    }

    public void PushAudioFrame(byte[] bArr, int i2, long j2, int i3) {
    }

    public long getCurrentTS() {
        return 0;
    }

    public long getLastIFrameTS() {
        return 0;
    }

    public void requestKeyFrame(String str) {
    }

    public void setFlvSessionKey(String str) {
        this.mFlvSessionKey = str;
    }

    public String getFlvSessionKey() {
        return this.mFlvSessionKey;
    }
}

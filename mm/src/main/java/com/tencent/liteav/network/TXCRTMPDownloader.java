package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public class TXCRTMPDownloader extends TXIStreamDownloader {
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final String TAG;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private a mCurrentThread;
    private boolean mEnableNearestIP;
    private Handler mHandler;
    private boolean mHasTcpPlayUrl;
    private boolean mIsPlayRtmpAccStream;
    private int mLastNetworkType;
    private String mPlayUrl;
    private boolean mQuicChannel;
    private Object mRTMPThreadLock;
    private String mServerIp;
    private HandlerThread mThread;
    private Vector<e> mVecPlayUrls;

    private native TXCStreamDownloader.DownloadStats nativeGetStats(long j2);

    private native long nativeInitRtmpHandler(String str, String str2, String str3, boolean z, boolean z2, boolean z3);

    private native void nativeRequestKeyFrame(long j2, String str);

    private native void nativeStart(long j2);

    private native void nativeStop(long j2);

    private native void nativeUninitRtmpHandler(long j2);

    static /* synthetic */ long access$000(TXCRTMPDownloader tXCRTMPDownloader, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(15481);
        long nativeInitRtmpHandler = tXCRTMPDownloader.nativeInitRtmpHandler(str, str2, str3, z, z2, z3);
        AppMethodBeat.o(15481);
        return nativeInitRtmpHandler;
    }

    static /* synthetic */ void access$100(TXCRTMPDownloader tXCRTMPDownloader, long j2) {
        AppMethodBeat.i(15482);
        tXCRTMPDownloader.nativeStart(j2);
        AppMethodBeat.o(15482);
    }

    static /* synthetic */ void access$200(TXCRTMPDownloader tXCRTMPDownloader, long j2) {
        AppMethodBeat.i(15483);
        tXCRTMPDownloader.nativeUninitRtmpHandler(j2);
        AppMethodBeat.o(15483);
    }

    static /* synthetic */ void access$300(TXCRTMPDownloader tXCRTMPDownloader, long j2) {
        AppMethodBeat.i(15484);
        tXCRTMPDownloader.nativeStop(j2);
        AppMethodBeat.o(15484);
    }

    static /* synthetic */ TXCStreamDownloader.DownloadStats access$400(TXCRTMPDownloader tXCRTMPDownloader, long j2) {
        AppMethodBeat.i(15485);
        TXCStreamDownloader.DownloadStats nativeGetStats = tXCRTMPDownloader.nativeGetStats(j2);
        AppMethodBeat.o(15485);
        return nativeGetStats;
    }

    static /* synthetic */ void access$500(TXCRTMPDownloader tXCRTMPDownloader, long j2, String str) {
        AppMethodBeat.i(15486);
        tXCRTMPDownloader.nativeRequestKeyFrame(j2, str);
        AppMethodBeat.o(15486);
    }

    static /* synthetic */ void access$600(TXCRTMPDownloader tXCRTMPDownloader, boolean z) {
        AppMethodBeat.i(15487);
        tXCRTMPDownloader.internalReconnect(z);
        AppMethodBeat.o(15487);
    }

    static /* synthetic */ void access$700(TXCRTMPDownloader tXCRTMPDownloader) {
        AppMethodBeat.i(15488);
        tXCRTMPDownloader.startInternal();
        AppMethodBeat.o(15488);
    }

    public TXCRTMPDownloader(Context context) {
        super(context);
        AppMethodBeat.i(15470);
        this.TAG = "network.TXCRTMPDownloader";
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        this.mPlayUrl = "";
        this.mQuicChannel = false;
        this.mServerIp = "";
        this.mCurrentThread = null;
        this.mRTMPThreadLock = null;
        this.mThread = null;
        this.mHandler = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mLastNetworkType = 0;
        this.mRTMPThreadLock = new Object();
        AppMethodBeat.o(15470);
    }

    /* access modifiers changed from: package-private */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private long f861b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f862c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f863d;

        a(String str, boolean z) {
            super("RTMPDownLoad");
            this.f862c = str;
            this.f863d = z;
        }

        public void run() {
            AppMethodBeat.i(15409);
            synchronized (this) {
                try {
                    this.f861b = TXCRTMPDownloader.access$000(TXCRTMPDownloader.this, TXCRTMPDownloader.this.mUserID, TXCRTMPDownloader.this.mOriginUrl, this.f862c, this.f863d, TXCRTMPDownloader.this.mEnableMessage, TXCRTMPDownloader.this.mEnableMetaData);
                } finally {
                    AppMethodBeat.o(15409);
                }
            }
            TXCRTMPDownloader.access$100(TXCRTMPDownloader.this, this.f861b);
            synchronized (this) {
                try {
                    TXCRTMPDownloader.access$200(TXCRTMPDownloader.this, this.f861b);
                    this.f861b = 0;
                } finally {
                    AppMethodBeat.o(15409);
                }
            }
        }

        public void a() {
            AppMethodBeat.i(15410);
            synchronized (this) {
                try {
                    if (this.f861b != 0) {
                        TXCRTMPDownloader.access$300(TXCRTMPDownloader.this, this.f861b);
                    }
                } finally {
                    AppMethodBeat.o(15410);
                }
            }
        }

        public TXCStreamDownloader.DownloadStats b() {
            AppMethodBeat.i(15411);
            TXCStreamDownloader.DownloadStats downloadStats = null;
            synchronized (this) {
                try {
                    if (this.f861b != 0) {
                        downloadStats = TXCRTMPDownloader.access$400(TXCRTMPDownloader.this, this.f861b);
                    }
                } finally {
                    AppMethodBeat.o(15411);
                }
            }
            return downloadStats;
        }

        public void a(String str) {
            AppMethodBeat.i(15412);
            synchronized (this) {
                try {
                    if (this.f861b != 0) {
                        TXCRTMPDownloader.access$500(TXCRTMPDownloader.this, this.f861b, str);
                    }
                } finally {
                    AppMethodBeat.o(15412);
                }
            }
        }
    }

    private void startInternal() {
        AppMethodBeat.i(15471);
        if (this.mQuicChannel) {
            this.mConnectCountQuic++;
        } else {
            this.mConnectCountTcp++;
        }
        synchronized (this.mRTMPThreadLock) {
            try {
                this.mCurrentThread = new a(this.mPlayUrl, this.mQuicChannel);
                this.mCurrentThread.start();
            } finally {
                AppMethodBeat.o(15471);
            }
        }
    }

    private void postReconnectMsg() {
        AppMethodBeat.i(15472);
        Message message = new Message();
        message.what = 101;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.o(15472);
    }

    private void reconnect(final boolean z) {
        AppMethodBeat.i(15473);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a();
                    this.mCurrentThread = null;
                }
            } finally {
                AppMethodBeat.o(15473);
            }
        }
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.liteav.network.TXCRTMPDownloader.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(15455);
                    TXCRTMPDownloader.access$600(TXCRTMPDownloader.this, z);
                    AppMethodBeat.o(15455);
                }
            }, (long) (this.connectRetryInterval * 1000));
        }
    }

    private void internalReconnect(boolean z) {
        boolean z2;
        AppMethodBeat.i(15474);
        if (!this.mIsRunning) {
            AppMethodBeat.o(15474);
        } else if (!this.mIsPlayRtmpAccStream || this.mLastNetworkType == f.e(this.mApplicationContext)) {
            boolean z3 = this.mQuicChannel;
            if (this.mIsPlayRtmpAccStream) {
                if (!this.mEnableNearestIP) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (z3) {
                    z2 = true;
                }
                if (z2 && this.mVecPlayUrls != null && !this.mVecPlayUrls.isEmpty()) {
                    e eVar = this.mVecPlayUrls.get(0);
                    this.mVecPlayUrls.remove(0);
                    this.mPlayUrl = eVar.f951a;
                    this.mQuicChannel = eVar.f952b;
                }
            }
            if (z3 && this.mHasTcpPlayUrl) {
                sendNotifyEvent(2103);
                startInternal();
                AppMethodBeat.o(15474);
            } else if (this.connectRetryTimes < this.connectRetryLimit) {
                this.connectRetryTimes++;
                TXCLog.i("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
                sendNotifyEvent(2103);
                startInternal();
                AppMethodBeat.o(15474);
            } else {
                TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
                sendNotifyEvent(-2301);
                AppMethodBeat.o(15474);
            }
        } else {
            this.mLastNetworkType = f.e(this.mApplicationContext);
            if (this.mRestartListener != null) {
                this.mRestartListener.onRestartDownloader();
            }
            AppMethodBeat.o(15474);
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void sendNotifyEvent(int i2, String str) {
        AppMethodBeat.i(15475);
        if (str.isEmpty()) {
            sendNotifyEvent(i2);
            AppMethodBeat.o(15475);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i2, bundle);
        }
        AppMethodBeat.o(15475);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void sendNotifyEvent(int i2) {
        boolean z = true;
        AppMethodBeat.i(15476);
        if (i2 == 0 || i2 == 1) {
            if (i2 != 1) {
                z = false;
            }
            reconnect(z);
            AppMethodBeat.o(15476);
            return;
        }
        super.sendNotifyEvent(i2);
        AppMethodBeat.o(15476);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(15477);
        if (this.mIsRunning) {
            AppMethodBeat.o(15477);
        } else if (vector == null || vector.isEmpty()) {
            AppMethodBeat.o(15477);
        } else {
            this.mEnableMessage = z3;
            this.mEnableMetaData = z4;
            this.mIsPlayRtmpAccStream = z;
            this.mEnableNearestIP = z2;
            this.mVecPlayUrls = vector;
            this.mHasTcpPlayUrl = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.mVecPlayUrls.size()) {
                    break;
                } else if (!this.mVecPlayUrls.elementAt(i2).f952b) {
                    this.mHasTcpPlayUrl = true;
                    break;
                } else {
                    i2++;
                }
            }
            e eVar = this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = eVar.f951a;
            this.mQuicChannel = eVar.f952b;
            this.mIsRunning = true;
            TXCLog.i("network.TXCRTMPDownloader", "start pull with url:" + this.mPlayUrl + " quic:" + (this.mQuicChannel ? "yes" : "no"));
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            this.connectRetryTimes = 0;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("RTMP_PULL");
                this.mThread.start();
            }
            this.mHandler = new Handler(this.mThread.getLooper()) {
                /* class com.tencent.liteav.network.TXCRTMPDownloader.AnonymousClass2 */

                public void handleMessage(Message message) {
                    AppMethodBeat.i(15386);
                    if (message.what == 101) {
                        TXCRTMPDownloader.access$700(TXCRTMPDownloader.this);
                    }
                    AppMethodBeat.o(15386);
                }
            };
            startInternal();
            AppMethodBeat.o(15477);
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void stopDownload() {
        AppMethodBeat.i(15478);
        if (!this.mIsRunning) {
            AppMethodBeat.o(15478);
            return;
        }
        this.mIsRunning = false;
        this.mVecPlayUrls.removeAllElements();
        this.mVecPlayUrls = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        TXCLog.i("network.TXCRTMPDownloader", "stop pull");
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a();
                    this.mCurrentThread = null;
                }
            } finally {
                AppMethodBeat.o(15478);
            }
        }
        if (this.mThread != null) {
            this.mThread.quit();
            this.mThread = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        TXCStreamDownloader.DownloadStats downloadStats;
        AppMethodBeat.i(15479);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    downloadStats = this.mCurrentThread.b();
                } else {
                    downloadStats = null;
                    AppMethodBeat.o(15479);
                }
            } finally {
                AppMethodBeat.o(15479);
            }
        }
        return downloadStats;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public String getCurrentStreamUrl() {
        return this.mPlayUrl;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public boolean isQuicChannel() {
        return this.mQuicChannel;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public int getConnectCountQuic() {
        return this.mConnectCountQuic;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public int getConnectCountTcp() {
        return this.mConnectCountTcp;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void requestKeyFrame(String str) {
        AppMethodBeat.i(15480);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a(str);
                }
            } finally {
                AppMethodBeat.o(15480);
            }
        }
    }
}

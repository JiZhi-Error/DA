package com.hilive.mediasdk;

import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;

public class MediaSdk {
    private static final String TAG = "[hilive][java]";
    private long mContext = 0;
    private boolean mInited = false;

    public interface MediaCallbacker {
        void onResult(byte[] bArr);
    }

    private native boolean nativeAddAudio(long j2, int i2, byte[] bArr, int i3, int i4, int i5, long j3);

    private native boolean nativeAddVideo(long j2, int i2, byte[] bArr, int i3, int i4, int i5, boolean z, boolean z2, long j3);

    private native long nativeCreate();

    private native boolean nativeGetFrame(long j2, int i2, boolean z, byte[] bArr, SdkInfo.FrameInfo frameInfo);

    private native void nativeRelease(long j2);

    private native boolean nativeRequest(long j2, int i2, byte[] bArr, MediaCallbacker mediaCallbacker);

    private native boolean nativeSetConfig(long j2, int i2, int i3);

    public void finalize() {
        AppMethodBeat.i(73615);
        uint();
        AppMethodBeat.o(73615);
    }

    public synchronized boolean isInited() {
        return this.mInited;
    }

    public synchronized boolean init() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(238006);
            try {
                LogDelegate.i(TAG, "init sdk", new Object[0]);
                LoadDelegate.loadLibraries();
                if (!this.mInited) {
                    this.mContext = nativeCreate();
                    this.mInited = this.mContext != 0;
                }
                LogDelegate.i(TAG, "init sdk, sdk:" + this.mContext, new Object[0]);
                z = this.mInited;
                AppMethodBeat.o(238006);
            } catch (Exception e2) {
                LogDelegate.e(TAG, "init failed, Exception error:" + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(238006);
                return z;
            } catch (UnsatisfiedLinkError e3) {
                LogDelegate.e(TAG, "init failed, UnsatisfiedLinkError error:" + e3.getMessage(), new Object[0]);
                AppMethodBeat.o(238006);
                return z;
            }
        }
        return z;
    }

    public synchronized boolean setConfig(int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(238007);
            try {
                if (this.mInited) {
                    z = nativeSetConfig(this.mContext, i2, i3);
                    AppMethodBeat.o(238007);
                }
            } catch (Exception e2) {
                LogDelegate.e(TAG, "getSdkVersion failed, error:" + e2.getMessage(), new Object[0]);
            } catch (UnsatisfiedLinkError e3) {
                LogDelegate.e(TAG, "getSdkVersion failed, error:" + e3.getMessage(), new Object[0]);
            }
            AppMethodBeat.o(238007);
        }
        return z;
    }

    public synchronized void test(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177250);
        LogDelegate.i(TAG, APMidasPayAPI.ENV_TEST, new Object[0]);
        request(100, bArr, mediaCallbacker);
        AppMethodBeat.o(177250);
    }

    public synchronized void remux(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177251);
        LogDelegate.i(TAG, "remux", new Object[0]);
        request(102, bArr, mediaCallbacker);
        AppMethodBeat.o(177251);
    }

    public synchronized void analysis(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177252);
        LogDelegate.i(TAG, "analysis", new Object[0]);
        request(101, bArr, mediaCallbacker);
        AppMethodBeat.o(177252);
    }

    public synchronized void editorCreate(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177260);
        LogDelegate.i(TAG, "editorCreate", new Object[0]);
        request(200, bArr, mediaCallbacker);
        AppMethodBeat.o(177260);
    }

    public synchronized void editorGetTrack(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177261);
        LogDelegate.i(TAG, "editorGetTrack", new Object[0]);
        request(201, bArr, mediaCallbacker);
        AppMethodBeat.o(177261);
    }

    public synchronized void editorAddTrack(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238008);
        LogDelegate.i(TAG, "editorAddTrack", new Object[0]);
        request(202, bArr, mediaCallbacker);
        AppMethodBeat.o(238008);
    }

    public synchronized void editorUpdateTrack(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177263);
        LogDelegate.i(TAG, "editorUpdateTrack", new Object[0]);
        request(203, bArr, mediaCallbacker);
        AppMethodBeat.o(177263);
    }

    public synchronized void editorDelTrack(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238009);
        LogDelegate.i(TAG, "editorDelTrack", new Object[0]);
        request(204, bArr, mediaCallbacker);
        AppMethodBeat.o(238009);
    }

    public synchronized void editorExport(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177265);
        LogDelegate.i(TAG, "editorExport", new Object[0]);
        request(205, bArr, mediaCallbacker);
        AppMethodBeat.o(177265);
    }

    public synchronized void editorRemove(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177266);
        LogDelegate.i(TAG, "editorRemove", new Object[0]);
        request(206, bArr, mediaCallbacker);
        AppMethodBeat.o(177266);
    }

    public synchronized void readerCreate(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238010);
        LogDelegate.i(TAG, "readerCreate", new Object[0]);
        request(400, bArr, mediaCallbacker);
        AppMethodBeat.o(238010);
    }

    public synchronized void readerStart(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238011);
        LogDelegate.i(TAG, "readerStart", new Object[0]);
        request(401, bArr, mediaCallbacker);
        AppMethodBeat.o(238011);
    }

    public synchronized boolean readerGetAudio(int i2, byte[] bArr, SdkInfo.FrameInfo frameInfo) {
        boolean frame;
        AppMethodBeat.i(238012);
        frame = getFrame(i2, false, bArr, frameInfo);
        AppMethodBeat.o(238012);
        return frame;
    }

    public synchronized boolean readerGetVideo(int i2, byte[] bArr, SdkInfo.FrameInfo frameInfo) {
        boolean frame;
        AppMethodBeat.i(238013);
        frame = getFrame(i2, true, bArr, frameInfo);
        AppMethodBeat.o(238013);
        return frame;
    }

    public synchronized void readerSeek(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238014);
        LogDelegate.i(TAG, "readerSeek", new Object[0]);
        request(402, bArr, mediaCallbacker);
        AppMethodBeat.o(238014);
    }

    public synchronized void readerStop(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238015);
        LogDelegate.i(TAG, "readerStop", new Object[0]);
        request(404, bArr, mediaCallbacker);
        AppMethodBeat.o(238015);
    }

    public synchronized void readerRemove(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238016);
        LogDelegate.i(TAG, "readerRemove", new Object[0]);
        request(405, bArr, mediaCallbacker);
        AppMethodBeat.o(238016);
    }

    public synchronized void writerCreate(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238017);
        LogDelegate.i(TAG, "writerCreate", new Object[0]);
        request(300, bArr, mediaCallbacker);
        AppMethodBeat.o(238017);
    }

    public synchronized void writerStart(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238018);
        LogDelegate.i(TAG, "writerStart", new Object[0]);
        request(301, bArr, mediaCallbacker);
        AppMethodBeat.o(238018);
    }

    public synchronized boolean writerAudio(int i2, byte[] bArr, int i3, int i4, int i5, long j2) {
        boolean addAudio;
        AppMethodBeat.i(238019);
        addAudio = addAudio(i2, bArr, i3, i4, i5, j2);
        AppMethodBeat.o(238019);
        return addAudio;
    }

    public synchronized boolean writerVideo(int i2, byte[] bArr, int i3, int i4, int i5, boolean z, boolean z2, long j2) {
        boolean addVideo;
        AppMethodBeat.i(238020);
        addVideo = addVideo(i2, bArr, i3, i4, i5, z, z2, j2);
        AppMethodBeat.o(238020);
        return addVideo;
    }

    public synchronized void writerUpdate(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238021);
        LogDelegate.i(TAG, "writerUpdate", new Object[0]);
        request(302, bArr, mediaCallbacker);
        AppMethodBeat.o(238021);
    }

    public synchronized void writerStop(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238022);
        LogDelegate.i(TAG, "writerStop", new Object[0]);
        request(303, bArr, mediaCallbacker);
        AppMethodBeat.o(238022);
    }

    public synchronized void writerRemove(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238023);
        LogDelegate.i(TAG, "writerRemove", new Object[0]);
        request(304, bArr, mediaCallbacker);
        AppMethodBeat.o(238023);
    }

    public synchronized void loaderCreate(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238024);
        LogDelegate.i(TAG, "loaderCreate", new Object[0]);
        request(500, bArr, mediaCallbacker);
        AppMethodBeat.o(238024);
    }

    public synchronized void loaderStart(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238025);
        LogDelegate.i(TAG, "loaderStart", new Object[0]);
        request(501, bArr, mediaCallbacker);
        AppMethodBeat.o(238025);
    }

    public synchronized void loaderStop(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238026);
        LogDelegate.i(TAG, "loaderStop", new Object[0]);
        request(502, bArr, mediaCallbacker);
        AppMethodBeat.o(238026);
    }

    public synchronized void loaderRemove(byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(238027);
        LogDelegate.i(TAG, "loaderRemove", new Object[0]);
        request(503, bArr, mediaCallbacker);
        AppMethodBeat.o(238027);
    }

    public synchronized void uint() {
        AppMethodBeat.i(73627);
        LogDelegate.i(TAG, "uint start", new Object[0]);
        try {
            this.mInited = false;
            nativeRelease(this.mContext);
            this.mContext = 0;
        } catch (Exception e2) {
            LogDelegate.e(TAG, "release, Exception error:" + e2.getMessage(), new Object[0]);
        } catch (UnsatisfiedLinkError e3) {
            LogDelegate.e(TAG, "release, UnsatisfiedLinkError error:" + e3.getMessage(), new Object[0]);
        }
        LogDelegate.i(TAG, "uint end", new Object[0]);
        AppMethodBeat.o(73627);
    }

    private void request(int i2, byte[] bArr, MediaCallbacker mediaCallbacker) {
        AppMethodBeat.i(177274);
        try {
            LogDelegate.i(TAG, "request, evtType:" + i2 + " bytes:" + bArr.length, new Object[0]);
            if (!this.mInited) {
                LogDelegate.e(TAG, "request sdk not ready", new Object[0]);
                AppMethodBeat.o(177274);
            } else if (!nativeRequest(this.mContext, i2, bArr, mediaCallbacker)) {
                LogDelegate.e(TAG, "request invoke failed", new Object[0]);
                AppMethodBeat.o(177274);
            } else {
                AppMethodBeat.o(177274);
            }
        } catch (Exception e2) {
            LogDelegate.e(TAG, "request, error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(177274);
        } catch (UnsatisfiedLinkError e3) {
            LogDelegate.e(TAG, "request, error:" + e3.getMessage(), new Object[0]);
            AppMethodBeat.o(177274);
        }
    }

    private boolean addVideo(int i2, byte[] bArr, int i3, int i4, int i5, boolean z, boolean z2, long j2) {
        AppMethodBeat.i(177275);
        try {
            boolean nativeAddVideo = nativeAddVideo(this.mContext, i2, bArr, i3, i4, i5, z, z2, j2);
            AppMethodBeat.o(177275);
            return nativeAddVideo;
        } catch (Exception e2) {
            LogDelegate.e(TAG, "getFrame, error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(177275);
            return false;
        } catch (UnsatisfiedLinkError e3) {
            LogDelegate.e(TAG, "getFrame, error:" + e3.getMessage(), new Object[0]);
            AppMethodBeat.o(177275);
            return false;
        }
    }

    private boolean addAudio(int i2, byte[] bArr, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(177276);
        try {
            boolean nativeAddAudio = nativeAddAudio(this.mContext, i2, bArr, i3, i4, i5, j2);
            AppMethodBeat.o(177276);
            return nativeAddAudio;
        } catch (Exception e2) {
            LogDelegate.e(TAG, "getFrame, error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(177276);
            return false;
        } catch (UnsatisfiedLinkError e3) {
            LogDelegate.e(TAG, "getFrame, error:" + e3.getMessage(), new Object[0]);
            AppMethodBeat.o(177276);
            return false;
        }
    }

    private boolean getFrame(int i2, boolean z, byte[] bArr, SdkInfo.FrameInfo frameInfo) {
        boolean z2 = false;
        AppMethodBeat.i(177277);
        try {
            z2 = nativeGetFrame(this.mContext, i2, z, bArr, frameInfo);
            AppMethodBeat.o(177277);
        } catch (Exception e2) {
            LogDelegate.e(TAG, "getFrame, error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(177277);
        } catch (UnsatisfiedLinkError e3) {
            LogDelegate.e(TAG, "getFrame, error:" + e3.getMessage(), new Object[0]);
            AppMethodBeat.o(177277);
        }
        return z2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void Loging(int i2, byte[] bArr) {
        AppMethodBeat.i(238028);
        try {
            String str = new String(bArr);
            switch (i2) {
                case 1:
                    LogDelegate.e(TAG, str, new Object[0]);
                    AppMethodBeat.o(238028);
                    return;
                case 2:
                    LogDelegate.w(TAG, str, new Object[0]);
                    AppMethodBeat.o(238028);
                    return;
                case 3:
                    LogDelegate.i(TAG, str, new Object[0]);
                    AppMethodBeat.o(238028);
                    return;
                case 4:
                case 5:
                    LogDelegate.d(TAG, str, new Object[0]);
                    break;
            }
            AppMethodBeat.o(238028);
        } catch (Exception e2) {
            AppMethodBeat.o(238028);
        }
    }
}

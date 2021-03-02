package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.liteav.videodecoder.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCRenderAndDec extends com.tencent.liteav.basic.module.a implements com.tencent.liteav.basic.b.b, a.AbstractC0159a, f, g {
    public static final String TAG = "TXCRenderAndDec";
    private h mConfig = null;
    private Context mContext = null;
    private a mDecListener = null;
    private boolean mEnableDecoderChange = false;
    private boolean mEnableLimitHWDecCache = false;
    private boolean mEnableRestartDecoder = false;
    private boolean mFirstRender = false;
    private long mFrameDecErrCnt = 0;
    private boolean mIsRendering = false;
    private long mLastRenderCalculateTS = 0;
    private long mLastRenderFrameCount = 0;
    private long mLastReqKeyFrameTS = 0;
    private WeakReference<com.tencent.liteav.basic.b.b> mNotifyListener;
    private boolean mRealTime = false;
    private WeakReference<b> mRenderAndDecDelegate;
    private long mRenderFrameCount = 0;
    private int mRenderMode = 0;
    private int mRenderRotation = 0;
    private int mStreamType = 0;
    private TXCVideoDecoder mVideoDecoder = null;
    private h mVideoFrameFilter = null;
    private com.tencent.liteav.basic.a.b mVideoFrameFormat = com.tencent.liteav.basic.a.b.UNKNOWN;
    private o mVideoFrameListener;
    private e mVideoRender = null;

    public interface a {
        void a(SurfaceTexture surfaceTexture);
    }

    public interface b {
        void onRequestKeyFrame(String str, int i2);
    }

    public TXCRenderAndDec(Context context) {
        AppMethodBeat.i(16065);
        this.mContext = context;
        c.a().a(this.mContext);
        AppMethodBeat.o(16065);
    }

    public void setVideoRender(e eVar) {
        AppMethodBeat.i(16066);
        TXCLog.i(TAG, "set video render " + eVar + " id " + getID() + ", " + this.mStreamType);
        this.mVideoRender = eVar;
        if (this.mVideoRender == null) {
            AppMethodBeat.o(16066);
            return;
        }
        this.mVideoRender.setID(getID());
        this.mVideoRender.a(this.mStreamType);
        this.mVideoRender.a((com.tencent.liteav.basic.b.b) this);
        this.mVideoRender.c(this.mRenderMode);
        this.mVideoRender.d(this.mRenderRotation);
        if (this.mVideoFrameListener != null && (this.mVideoRender instanceof com.tencent.liteav.renderer.a)) {
            ((com.tencent.liteav.renderer.a) this.mVideoRender).b((a.AbstractC0159a) this);
        }
        if (this.mConfig != null) {
            this.mVideoRender.b(this.mConfig.f793d);
        }
        AppMethodBeat.o(16066);
    }

    public void setNotifyListener(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221780);
        this.mNotifyListener = new WeakReference<>(bVar);
        AppMethodBeat.o(221780);
    }

    public void setRenderAndDecDelegate(b bVar) {
        AppMethodBeat.i(16068);
        this.mRenderAndDecDelegate = new WeakReference<>(bVar);
        AppMethodBeat.o(16068);
    }

    public void setVideoFrameListener(o oVar, com.tencent.liteav.basic.a.b bVar) {
        AppMethodBeat.i(221781);
        this.mVideoFrameListener = oVar;
        this.mVideoFrameFormat = bVar;
        TXCLog.i(TAG, "setVideoFrameListener->enter listener: " + oVar + ", format: " + bVar);
        if (this.mVideoRender != null && (this.mVideoRender instanceof com.tencent.liteav.renderer.a)) {
            if (oVar == null) {
                TXCLog.i(TAG, "setCustomRenderListener-> clean listener.");
                ((com.tencent.liteav.renderer.a) this.mVideoRender).b((a.AbstractC0159a) null);
                AppMethodBeat.o(221781);
                return;
            }
            TXCLog.i(TAG, "setCustomRenderListener-> set listener.");
            ((com.tencent.liteav.renderer.a) this.mVideoRender).b((a.AbstractC0159a) this);
        }
        AppMethodBeat.o(221781);
    }

    public void setConfig(h hVar) {
        AppMethodBeat.i(221782);
        this.mConfig = hVar;
        if (this.mVideoRender != null) {
            this.mVideoRender.b(this.mConfig.f793d);
        }
        AppMethodBeat.o(221782);
    }

    public h getConfig() {
        return this.mConfig;
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(16071);
        super.setID(str);
        if (this.mVideoRender != null) {
            this.mVideoRender.setID(getID());
        }
        if (this.mVideoDecoder != null) {
            this.mVideoDecoder.setUserId(str);
        }
        AppMethodBeat.o(16071);
    }

    public void setDecListener(a aVar) {
        this.mDecListener = aVar;
    }

    public void enableDecoderChange(boolean z) {
        this.mEnableDecoderChange = z;
    }

    public void enableRestartDecoder(boolean z) {
        this.mEnableRestartDecoder = z;
    }

    public void start(boolean z) {
        AppMethodBeat.i(16072);
        TXCLog.i(TAG, "start render dec " + getID() + ", " + this.mStreamType);
        this.mRealTime = z;
        this.mFrameDecErrCnt = 0;
        this.mLastReqKeyFrameTS = 0;
        if (this.mVideoRender != null) {
            this.mVideoRender.a((f) this);
            this.mVideoRender.f();
            this.mVideoRender.setID(getID());
        }
        this.mVideoDecoder = new TXCVideoDecoder();
        this.mVideoDecoder.setUserId(getID());
        this.mVideoDecoder.setStreamType(this.mStreamType);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
        this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
        this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
        startDecode();
        this.mIsRendering = true;
        AppMethodBeat.o(16072);
    }

    public void startVideo() {
        AppMethodBeat.i(16073);
        stopVideo();
        this.mRealTime = true;
        this.mFrameDecErrCnt = 0;
        this.mLastReqKeyFrameTS = 0;
        if (this.mVideoRender != null) {
            this.mVideoRender.a((f) this);
            this.mVideoRender.f();
            this.mVideoRender.setID(getID());
        }
        TXCLog.i(TAG, "start video dec " + getID() + ", " + this.mStreamType);
        this.mVideoDecoder = new TXCVideoDecoder();
        this.mVideoDecoder.setUserId(getID());
        this.mVideoDecoder.setStreamType(this.mStreamType);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
        this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
        this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
        startDecode();
        this.mIsRendering = true;
        AppMethodBeat.o(16073);
    }

    public void stopVideo() {
        AppMethodBeat.i(16074);
        this.mIsRendering = false;
        if (this.mVideoDecoder != null) {
            TXCLog.i(TAG, "stop video dec " + getID() + ", " + this.mStreamType);
            this.mVideoDecoder.setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            this.mVideoDecoder.stop();
        }
        if (this.mVideoRender != null) {
            this.mVideoRender.a(false);
            this.mVideoRender.a((f) null);
        }
        AppMethodBeat.o(16074);
    }

    public void stop() {
        AppMethodBeat.i(16075);
        TXCLog.i(TAG, "stop video render dec " + getID() + ", " + this.mStreamType);
        this.mIsRendering = false;
        this.mRealTime = false;
        if (this.mVideoDecoder != null) {
            this.mVideoDecoder.setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            this.mVideoDecoder.stop();
        }
        if (this.mVideoRender != null) {
            this.mVideoRender.a(true);
            this.mVideoRender.a((f) null);
        }
        AppMethodBeat.o(16075);
    }

    public void muteVideo(boolean z) {
        AppMethodBeat.i(182282);
        if (!z && this.mVideoRender != null) {
            this.mVideoRender.m();
        }
        AppMethodBeat.o(182282);
    }

    public boolean isRendering() {
        return this.mIsRendering;
    }

    public void decVideo(TXSNALPacket tXSNALPacket) {
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(16076);
        this.mRenderMode = i2;
        if (this.mVideoRender != null) {
            this.mVideoRender.c(i2);
        }
        AppMethodBeat.o(16076);
    }

    public void setRenderRotation(int i2) {
        AppMethodBeat.i(16077);
        TXCLog.i(TAG, "vrotation setRenderRotation ".concat(String.valueOf(i2)));
        this.mRenderRotation = i2;
        if (this.mVideoRender != null) {
            this.mVideoRender.d(i2);
        }
        AppMethodBeat.o(16077);
    }

    public void setBlockInterval(int i2) {
        AppMethodBeat.i(16078);
        if (this.mVideoRender != null) {
            this.mVideoRender.e(i2);
        }
        AppMethodBeat.o(16078);
    }

    public long getVideoCacheDuration() {
        AppMethodBeat.i(16079);
        long intValue = (long) getIntValue(6010, 2);
        AppMethodBeat.o(16079);
        return intValue;
    }

    public long getVideoCacheFrameCount() {
        AppMethodBeat.i(16080);
        long intValue = (long) getIntValue(6011, 2);
        AppMethodBeat.o(16080);
        return intValue;
    }

    public int getVideoDecCacheFrameCount() {
        AppMethodBeat.i(16081);
        int intValue = getIntValue(6012, 2);
        AppMethodBeat.o(16081);
        return intValue;
    }

    public long getAVPlayInterval() {
        AppMethodBeat.i(16082);
        long longValue = getLongValue(6013, 2);
        AppMethodBeat.o(16082);
        return longValue;
    }

    public long getAVNetRecvInterval() {
        AppMethodBeat.i(16083);
        long longValue = getLongValue(6014, 2);
        AppMethodBeat.o(16083);
        return longValue;
    }

    public int getVideoGop() {
        AppMethodBeat.i(16084);
        int intValue = getIntValue(7120);
        AppMethodBeat.o(16084);
        return intValue;
    }

    public void updateLoadInfo() {
        AppMethodBeat.i(16085);
        if (this.mVideoDecoder != null) {
            setStatusValue(5002, this.mStreamType, Long.valueOf(this.mVideoDecoder.isHardwareDecode() ? 1 : 0));
        }
        if (this.mVideoRender != null) {
            this.mVideoRender.n();
            AppMethodBeat.o(16085);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.mLastRenderCalculateTS;
        if (j2 >= 1000) {
            double d2 = (((double) (this.mRenderFrameCount - this.mLastRenderFrameCount)) * 1000.0d) / ((double) j2);
            this.mLastRenderFrameCount = this.mRenderFrameCount;
            this.mLastRenderCalculateTS = currentTimeMillis;
            setStatusValue(6002, this.mStreamType, Double.valueOf(d2));
        }
        AppMethodBeat.o(16085);
    }

    public e getVideoRender() {
        return this.mVideoRender;
    }

    public void setStreamType(int i2) {
        AppMethodBeat.i(16086);
        this.mStreamType = i2;
        if (this.mVideoRender != null) {
            this.mVideoRender.a(this.mStreamType);
        }
        if (this.mVideoDecoder != null) {
            this.mVideoDecoder.setStreamType(this.mStreamType);
        }
        AppMethodBeat.o(16086);
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    public void enableLimitDecCache(boolean z) {
        AppMethodBeat.i(221783);
        this.mEnableLimitHWDecCache = z;
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.enableLimitDecCache(z);
        }
        AppMethodBeat.o(221783);
    }

    private void startDecode(SurfaceTexture surfaceTexture) {
        boolean z = true;
        AppMethodBeat.i(16087);
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.stop();
            tXCVideoDecoder.enableHWDec(this.mConfig.f797h);
            tXCVideoDecoder.config(this.mConfig.r);
            TXCLog.i(TAG, "trtc_ start decode " + surfaceTexture + ", hw: " + this.mConfig.f797h + ", id " + getID() + "_" + this.mStreamType);
            if (surfaceTexture != null) {
                if (this.mRealTime) {
                    z = false;
                }
                tXCVideoDecoder.setup(surfaceTexture, (ByteBuffer) null, (ByteBuffer) null, z);
                tXCVideoDecoder.setUserId(getID());
                tXCVideoDecoder.start();
                AppMethodBeat.o(16087);
                return;
            } else if (!this.mConfig.f797h) {
                if (this.mRealTime) {
                    z = false;
                }
                tXCVideoDecoder.setup((Surface) null, (ByteBuffer) null, (ByteBuffer) null, z);
                tXCVideoDecoder.setUserId(getID());
                tXCVideoDecoder.start();
            }
        }
        AppMethodBeat.o(16087);
    }

    private void startDecode() {
        AppMethodBeat.i(16088);
        startDecode(this.mVideoRender != null ? this.mVideoRender.a() : null);
        AppMethodBeat.o(16088);
    }

    private void notifyEvent(int i2, String str) {
        AppMethodBeat.i(16089);
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", getID());
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        bundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
        com.tencent.liteav.basic.util.f.a(this.mNotifyListener, i2, bundle);
        AppMethodBeat.o(16089);
    }

    public void restartDecoder() {
        AppMethodBeat.i(16091);
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null && tXCVideoDecoder.isHevc()) {
            tXCVideoDecoder.restart(true);
        }
        AppMethodBeat.o(16091);
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(16092);
        if (i2 == 2106) {
            this.mConfig.f797h = false;
            TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
            if (tXCVideoDecoder != null) {
                tXCVideoDecoder.restart(this.mConfig.f797h);
            }
        } else if (i2 == -2304) {
            if (com.tencent.liteav.basic.a.a()) {
                this.mConfig.f797h = false;
                TXCVideoDecoder tXCVideoDecoder2 = this.mVideoDecoder;
                if (tXCVideoDecoder2 != null) {
                    tXCVideoDecoder2.restart(false);
                }
                AppMethodBeat.o(16092);
                return;
            }
        } else if (i2 == 2020) {
            TXCLog.e(TAG, "decoding too many frame(>40) without output! request key frame now.");
            requestKeyFrame();
            AppMethodBeat.o(16092);
            return;
        }
        bundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
        com.tencent.liteav.basic.util.f.a(this.mNotifyListener, i2, bundle);
        AppMethodBeat.o(16092);
    }

    @Override // com.tencent.liteav.renderer.f
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16093);
        TXCLog.w(TAG, "play decode when surface texture create hw " + this.mConfig.f797h);
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.setup(surfaceTexture, (ByteBuffer) null, (ByteBuffer) null, !this.mRealTime);
        }
        if (this.mConfig.f797h) {
            startDecode(surfaceTexture);
        }
        AppMethodBeat.o(16093);
    }

    @Override // com.tencent.liteav.renderer.f
    public void onSurfaceTextureDestroy(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16094);
        try {
            TXCLog.w(TAG, "play:stop decode when surface texture release");
            if (this.mConfig.f797h && this.mVideoDecoder != null) {
                this.mVideoDecoder.stop();
            }
            if (this.mVideoFrameFilter != null) {
                this.mVideoFrameFilter.d();
                this.mVideoFrameFilter = null;
            }
            if (this.mDecListener != null) {
                this.mDecListener.a(surfaceTexture);
            }
            AppMethodBeat.o(16094);
        } catch (Exception e2) {
            TXCLog.e(TAG, "onSurfaceTextureDestroy failed.", e2);
            AppMethodBeat.o(16094);
        }
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i2, int i3, long j2, long j3, int i4) {
        TXSVideoFrame tXSVideoFrame2;
        AppMethodBeat.i(16095);
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3) {
            i4 = 360 - (i4 * 90);
        }
        o oVar = this.mVideoFrameListener;
        if (!(oVar == null || tXSVideoFrame == null || (this.mVideoFrameFormat != com.tencent.liteav.basic.a.b.I420 && this.mVideoFrameFormat != com.tencent.liteav.basic.a.b.NV21))) {
            if (this.mVideoRender != null) {
                tXSVideoFrame2 = tXSVideoFrame.clone();
            } else {
                tXSVideoFrame2 = tXSVideoFrame;
            }
            tXSVideoFrame2.rotation = (this.mRenderRotation + i4) % v2helper.VOIP_ENC_HEIGHT_LV1;
            if (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.NV21) {
                tXSVideoFrame2.loadNV21BufferFromI420Buffer();
            }
            oVar.onRenderVideoFrame(getID(), this.mStreamType, tXSVideoFrame2);
        }
        if (!this.mFirstRender) {
            this.mFirstRender = true;
            TXCEventRecorderProxy.a(getID(), 5007, -1, -1, "", this.mStreamType);
            if (this.mVideoRender == null) {
                TXCKeyPointReportProxy.a(getID(), 40022, 0, this.mStreamType);
            }
            if (this.mVideoDecoder != null) {
                TXCKeyPointReportProxy.a(getID(), 40029, this.mVideoDecoder.GetDecodeFirstFrameTS(), this.mStreamType);
            }
        }
        if (this.mVideoRender != null) {
            this.mVideoRender.a(tXSVideoFrame, i2, i3, i4);
            AppMethodBeat.o(16095);
        } else if (this.mLastRenderCalculateTS == 0) {
            this.mLastRenderCalculateTS = System.currentTimeMillis();
            this.mLastRenderFrameCount = 0;
            this.mRenderFrameCount = 0;
            AppMethodBeat.o(16095);
        } else {
            this.mRenderFrameCount++;
            AppMethodBeat.o(16095);
        }
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onVideoSizeChange(int i2, int i3) {
        AppMethodBeat.i(16096);
        if (this.mVideoRender != null) {
            this.mVideoRender.b(i2, i3);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Resolution changed to" + i2 + "x" + i3);
        bundle.putInt("EVT_PARAM1", i2);
        bundle.putInt("EVT_PARAM2", i3);
        bundle.putString("EVT_USERID", getID());
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(2009, bundle);
        setStatusValue(5003, this.mStreamType, Integer.valueOf((i2 << 16) | i3));
        TXCEventRecorderProxy.a(getID(), WearableStatusCodes.DATA_ITEM_TOO_LARGE, (long) i2, (long) i3, "", this.mStreamType);
        TXCKeyPointReportProxy.a(getID(), 40002, (long) i2, this.mStreamType);
        TXCKeyPointReportProxy.a(getID(), 40003, (long) i3, this.mStreamType);
        AppMethodBeat.o(16096);
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecoderChange(String str, boolean z) {
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecodeFailed(int i2) {
        AppMethodBeat.i(16097);
        TXCLog.e(TAG, "video decode failed ".concat(String.valueOf(i2)));
        if (i2 == -2) {
            TXCLog.w(TAG, "use hevc softdecoder but not set hevc softdecoder to sdk! " + com.tencent.liteav.basic.a.a());
            if (!com.tencent.liteav.basic.a.a()) {
                TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
                if (tXCVideoDecoder != null && tXCVideoDecoder.isHevc()) {
                    this.mConfig.f797h = true;
                    tXCVideoDecoder.restart(true);
                }
                AppMethodBeat.o(16097);
                return;
            }
        } else if (i2 == -1 || (com.tencent.liteav.basic.a.a() && i2 == -3)) {
            requestKeyFrame();
            int i3 = this.mStreamType;
            long j2 = this.mFrameDecErrCnt + 1;
            this.mFrameDecErrCnt = j2;
            setStatusValue(17014, i3, Long.valueOf(j2));
        }
        AppMethodBeat.o(16097);
    }

    @Override // com.tencent.liteav.renderer.a.AbstractC0159a
    public void onTextureProcess(int i2, int i3, int i4, final int i5) {
        AppMethodBeat.i(16098);
        o oVar = this.mVideoFrameListener;
        if (oVar != null) {
            if (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.TEXTURE_2D) {
                TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                tXSVideoFrame.width = i3;
                tXSVideoFrame.height = i4;
                tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
                tXSVideoFrame.rotation = (this.mRenderRotation + i5) % v2helper.VOIP_ENC_HEIGHT_LV1;
                tXSVideoFrame.textureId = i2;
                if (this.mVideoRender instanceof com.tencent.liteav.renderer.a) {
                    tXSVideoFrame.eglContext = ((com.tencent.liteav.renderer.a) this.mVideoRender).b();
                }
                oVar.onRenderVideoFrame(getID(), this.mStreamType, tXSVideoFrame);
                AppMethodBeat.o(16098);
                return;
            }
            TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
            if (tXCVideoDecoder == null || tXCVideoDecoder.isHardwareDecode()) {
                if (this.mVideoFrameFilter == null) {
                    if (this.mVideoFrameFormat == com.tencent.liteav.basic.a.b.NV21) {
                        this.mVideoFrameFilter = new o(3);
                    } else {
                        this.mVideoFrameFilter = new o(1);
                    }
                    this.mVideoFrameFilter.a(true);
                    if (this.mVideoFrameFilter.a()) {
                        this.mVideoFrameFilter.a(i3, i4);
                        this.mVideoFrameFilter.a(new h.a() {
                            /* class com.tencent.liteav.TXCRenderAndDec.AnonymousClass1 */

                            @Override // com.tencent.liteav.basic.c.h.a
                            public void a(int i2) {
                                AppMethodBeat.i(15553);
                                h hVar = TXCRenderAndDec.this.mVideoFrameFilter;
                                o oVar = TXCRenderAndDec.this.mVideoFrameListener;
                                if (!(hVar == null || oVar == null)) {
                                    TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                                    tXSVideoFrame.width = hVar.n();
                                    tXSVideoFrame.height = hVar.o();
                                    tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
                                    tXSVideoFrame.rotation = (i5 + TXCRenderAndDec.this.mRenderRotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
                                    oVar.onRenderVideoFrame(TXCRenderAndDec.this.getID(), TXCRenderAndDec.this.mStreamType, tXSVideoFrame);
                                }
                                AppMethodBeat.o(15553);
                            }
                        });
                    } else {
                        TXCLog.i(TAG, "throwVideoFrame->release mVideoFrameFilter");
                        this.mVideoFrameFilter = null;
                    }
                }
                if (this.mVideoFrameFilter != null) {
                    GLES20.glViewport(0, 0, i3, i4);
                    this.mVideoFrameFilter.a(i3, i4);
                    this.mVideoFrameFilter.b(i2);
                }
            } else {
                AppMethodBeat.o(16098);
                return;
            }
        }
        AppMethodBeat.o(16098);
    }

    private void requestKeyFrame() {
        b bVar;
        AppMethodBeat.i(16099);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick > this.mLastReqKeyFrameTS + 3000) {
            this.mLastReqKeyFrameTS = timeTick;
            TXCLog.e(TAG, "requestKeyFrame: " + getID());
            if (!(this.mRenderAndDecDelegate == null || (bVar = this.mRenderAndDecDelegate.get()) == null)) {
                bVar.onRequestKeyFrame(getID(), this.mStreamType);
            }
        }
        AppMethodBeat.o(16099);
    }
}

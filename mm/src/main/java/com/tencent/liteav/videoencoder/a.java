package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class a extends d {
    private Surface A;
    private boolean B;
    private boolean C;
    private boolean D;
    private ByteBuffer[] E;
    private byte[] F;
    private volatile long G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private int U;
    private long V;
    private int W;
    private int X;
    private int Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private int f1238a;
    private ArrayList<Long> aa;
    private int ab;
    private long ac;
    private int ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private long ah;
    private Runnable ai;

    /* renamed from: b  reason: collision with root package name */
    private long f1239b;

    /* renamed from: c  reason: collision with root package name */
    private double f1240c;

    /* renamed from: d  reason: collision with root package name */
    private long f1241d;

    /* renamed from: e  reason: collision with root package name */
    private long f1242e;

    /* renamed from: f  reason: collision with root package name */
    private int f1243f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1244g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1245h;

    /* renamed from: i  reason: collision with root package name */
    private long f1246i;

    /* renamed from: j  reason: collision with root package name */
    private long f1247j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private long o;
    private boolean p;
    private long q;
    private long r;
    private MediaCodec s;
    private String t;
    private g u;
    private Runnable v;
    private Runnable w;
    private Runnable x;
    private ArrayDeque<Long> y;
    private Object z;

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(14888);
        aVar.e();
        AppMethodBeat.o(14888);
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(14890);
        aVar.d(i2);
        AppMethodBeat.o(14890);
    }

    static /* synthetic */ void a(a aVar, long j2) {
        AppMethodBeat.i(14892);
        aVar.a(j2);
        AppMethodBeat.o(14892);
    }

    static /* synthetic */ boolean a(a aVar, TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.i(14889);
        boolean a2 = aVar.a(tXSVideoEncoderParam);
        AppMethodBeat.o(14889);
        return a2;
    }

    static /* synthetic */ void b(a aVar, int i2) {
        AppMethodBeat.i(14891);
        aVar.c(i2);
        AppMethodBeat.o(14891);
    }

    static /* synthetic */ int c(a aVar, int i2) {
        AppMethodBeat.i(14893);
        int a2 = aVar.a(i2);
        AppMethodBeat.o(14893);
        return a2;
    }

    static /* synthetic */ int d(a aVar) {
        int i2 = aVar.S;
        aVar.S = i2 + 1;
        return i2;
    }

    static /* synthetic */ void d(a aVar, int i2) {
        AppMethodBeat.i(14894);
        aVar.b(i2);
        AppMethodBeat.o(14894);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(14895);
        aVar.b();
        AppMethodBeat.o(14895);
    }

    static /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(14896);
        aVar.d();
        AppMethodBeat.o(14896);
    }

    static /* synthetic */ boolean h(a aVar) {
        AppMethodBeat.i(14897);
        boolean c2 = aVar.c();
        AppMethodBeat.o(14897);
        return c2;
    }

    public a() {
        AppMethodBeat.i(14859);
        this.f1238a = 0;
        this.f1239b = 0;
        this.f1240c = 0.0d;
        this.f1241d = 0;
        this.f1242e = 0;
        this.f1243f = 0;
        this.f1244g = false;
        this.f1245h = true;
        this.f1246i = 0;
        this.f1247j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.o = 0;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = "video/avc";
        this.u = null;
        this.v = new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass10 */

            public void run() {
                AppMethodBeat.i(14784);
                a.a(a.this);
                AppMethodBeat.o(14784);
            }
        };
        this.w = new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass11 */

            public void run() {
                AppMethodBeat.i(14850);
                a.d(a.this, 10);
                AppMethodBeat.o(14850);
            }
        };
        this.x = new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(14789);
                a.d(a.this, 1);
                AppMethodBeat.o(14789);
            }
        };
        this.y = new ArrayDeque<>(10);
        this.A = null;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = -1;
        this.Z = false;
        this.ab = 0;
        this.ac = 0;
        this.ad = 3;
        this.ae = 0;
        this.af = false;
        this.ag = true;
        this.ah = 0;
        this.ai = new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(14822);
                a.this.ah = System.currentTimeMillis();
                a.f(a.this);
                a.g(a.this);
                a.h(a.this);
                AppMethodBeat.o(14822);
            }
        };
        this.u = new g("HWVideoEncoder");
        AppMethodBeat.o(14859);
    }

    @Override // com.tencent.liteav.videoencoder.d
    public int start(final TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.i(14860);
        super.start(tXSVideoEncoderParam);
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 18) {
            z2 = false;
        } else {
            this.u.b(new Runnable() {
                /* class com.tencent.liteav.videoencoder.a.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(14785);
                    String str = "unknown";
                    String str2 = "unknown";
                    switch (tXSVideoEncoderParam.encoderMode) {
                        case 1:
                            str = "CBR";
                            break;
                        case 2:
                            str = "VBR";
                            break;
                        case 3:
                            str = "CQ";
                            break;
                    }
                    switch (tXSVideoEncoderParam.encoderProfile) {
                        case 1:
                            str2 = "Baseline";
                            break;
                        case 2:
                            str2 = "Main";
                            break;
                        case 3:
                            str2 = "High";
                            break;
                    }
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(a.this.hashCode());
                    objArr[1] = Integer.valueOf(tXSVideoEncoderParam.width);
                    objArr[2] = Integer.valueOf(tXSVideoEncoderParam.height);
                    objArr[3] = Integer.valueOf(tXSVideoEncoderParam.fps);
                    objArr[4] = Integer.valueOf(tXSVideoEncoderParam.bitrate);
                    objArr[5] = Integer.valueOf(tXSVideoEncoderParam.gop);
                    objArr[6] = str;
                    objArr[7] = str2;
                    objArr[8] = tXSVideoEncoderParam.bMultiRef ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                    objArr[9] = Integer.valueOf(tXSVideoEncoderParam.streamType);
                    objArr[10] = tXSVideoEncoderParam.isHEVCEncoderEnabled ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                    String format = String.format("VideoEncoder[%d]: Start [type:hardware][resolution:%d*%d][fps:%d][bitrate:%dkbps][gop:%d][rateControl:%s][profile:%s][rps:%s][streamType:%d][enable hevc:%s]", objArr);
                    Monitor.a(2, format, "", 0);
                    TXCLog.i("TXCHWVideoEncoder", "start:".concat(String.valueOf(format)));
                    if (a.this.mInit) {
                        a.a(a.this);
                    }
                    if (a.a(a.this, tXSVideoEncoderParam)) {
                        Monitor.a(2, String.format("VideoEncoder[%d]: Start successfully, streamType:%d", Integer.valueOf(a.this.hashCode()), Integer.valueOf(tXSVideoEncoderParam.streamType)), "streamType: 2-big, 3-small, 7-sub", 0);
                        AppMethodBeat.o(14785);
                        return;
                    }
                    a.this.callDelegate(10000004);
                    AppMethodBeat.o(14785);
                }
            });
        }
        if (z2) {
            AppMethodBeat.o(14860);
            return 0;
        }
        AppMethodBeat.o(14860);
        return 10000004;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void stop() {
        AppMethodBeat.i(14861);
        this.C = true;
        this.u.b(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(14857);
                if (a.this.mInit) {
                    Monitor.a(2, String.format("VideoEncoder[%d]: Stop, streamType:%d", Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.mStreamType)), "streamType: 2-big, 3-small, 7-sub", 0);
                    a.a(a.this);
                }
                AppMethodBeat.o(14857);
            }
        });
        AppMethodBeat.o(14861);
    }

    @Override // com.tencent.liteav.videoencoder.d
    public boolean isHevcEncoder() {
        return this.R;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setFPS(final int i2) {
        AppMethodBeat.i(14862);
        this.u.b(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass5 */

            public void run() {
                AppMethodBeat.i(14787);
                a.a(a.this, i2);
                AppMethodBeat.o(14787);
            }
        });
        AppMethodBeat.o(14862);
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setBitrate(final int i2) {
        AppMethodBeat.i(14863);
        this.f1238a = i2;
        this.u.b(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass6 */

            public void run() {
                AppMethodBeat.i(14851);
                a.b(a.this, i2);
                AppMethodBeat.o(14851);
            }
        });
        AppMethodBeat.o(14863);
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setBitrateFromQos(final int i2, int i3) {
        AppMethodBeat.i(14864);
        this.f1238a = i2;
        this.u.b(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(14858);
                a.b(a.this, i2);
                AppMethodBeat.o(14858);
            }
        });
        AppMethodBeat.o(14864);
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setEncodeIdrFpsFromQos(int i2) {
    }

    @Override // com.tencent.liteav.videoencoder.d
    public double getRealFPS() {
        return this.f1240c;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long getRealBitrate() {
        return this.f1239b;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public int getEncodeCost() {
        return this.ab;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrame(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14865);
        if (this.C) {
            AppMethodBeat.o(14865);
            return 10000004;
        }
        GLES20.glFinish();
        this.U++;
        this.G = j2;
        this.Y = i2;
        this.mInputWidth = i3;
        this.mInputHeight = i4;
        if (this.O) {
            f();
        }
        if (!this.P || this.Z) {
            this.X++;
            this.u.b(this.w);
            this.Z = false;
        }
        if (this.S > this.T + 30) {
            TXCLog.e("TXCHWVideoEncoder", String.format("hw encoder error when render[%d] pop[%d]", Integer.valueOf(this.S), Integer.valueOf(this.T)));
            if (this.mListener != null) {
                this.mListener.l(this.mStreamType);
                if (this.R) {
                    Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: mRendIdx= %d,mPopIdx= %d , switch to 264 hardware encoder. %s", Integer.valueOf(this.S), Integer.valueOf(this.T), TXCCommonUtil.getDeviceInfo()), "", 0);
                }
            }
        }
        if (this.V + 5000 < System.currentTimeMillis()) {
            this.V = System.currentTimeMillis();
            if (this.W != 0 && this.W == this.S) {
                TXCLog.i("TXCHWVideoEncoder", String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", Integer.valueOf(this.U), Integer.valueOf(this.X), Integer.valueOf(this.S), Integer.valueOf(this.T)));
                if (this.mListener != null) {
                    this.mListener.l(this.mStreamType);
                    if (this.R) {
                        Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: timecheck , switch to 264 hardware encoder. %s", TXCCommonUtil.getDeviceInfo()), "", 0);
                    }
                }
            }
            this.W = this.S;
        }
        AppMethodBeat.o(14865);
        return 0;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrameAsync(final int i2, int i3, int i4, final long j2) {
        AppMethodBeat.i(14866);
        if (this.C) {
            AppMethodBeat.o(14866);
            return 10000004;
        }
        GLES20.glFinish();
        if (this.O) {
            f();
        }
        this.u.a().post(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass8 */

            public void run() {
                int i2;
                int c2;
                AppMethodBeat.i(14820);
                if (a.this.B || a.this.z == null) {
                    AppMethodBeat.o(14820);
                    return;
                }
                int i3 = i2;
                long j2 = j2;
                a.a(a.this, j2);
                int i4 = (720 - a.this.mRotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
                int i5 = (i4 == 90 || i4 == 270) ? a.this.mOutputHeight : a.this.mOutputWidth;
                if (i4 == 90 || i4 == 270) {
                    i2 = a.this.mOutputWidth;
                } else {
                    i2 = a.this.mOutputHeight;
                }
                a.this.mEncodeFilter.a(a.this.mInputWidth, a.this.mInputHeight, i4, null, ((float) i5) / ((float) i2), a.this.mEnableXMirror, true);
                a.this.mEncodeFilter.a(i3);
                if (a.this.z instanceof c) {
                    ((c) a.this.z).a(TimeUtil.SECOND_TO_US * j2);
                    ((c) a.this.z).d();
                }
                if (a.this.z instanceof b) {
                    ((b) a.this.z).a();
                }
                if (a.this.mListener != null) {
                    a.this.mListener.m(a.this.mStreamType);
                }
                do {
                    c2 = a.c(a.this, 1);
                } while (c2 > 0);
                if (c2 == -1 || c2 == -2) {
                    if (c2 == -1) {
                        a.this.callDelegate(10000005);
                    }
                    a.this.B = true;
                    a.a(a.this);
                    AppMethodBeat.o(14820);
                    return;
                }
                a.d(a.this);
                AppMethodBeat.o(14820);
            }
        });
        AppMethodBeat.o(14866);
        return 0;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrameSync(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14867);
        if (this.C) {
            AppMethodBeat.o(14867);
            return 10000004;
        }
        GLES20.glFinish();
        this.G = j2;
        this.Y = i2;
        if (this.O) {
            f();
        }
        this.u.a(this.x);
        AppMethodBeat.o(14867);
        return 0;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void signalEOSAndFlush() {
        AppMethodBeat.i(14868);
        if (this.C) {
            AppMethodBeat.o(14868);
            return;
        }
        this.u.a(new Runnable() {
            /* class com.tencent.liteav.videoencoder.a.AnonymousClass9 */

            public void run() {
                AppMethodBeat.i(14788);
                if (a.this.s == null) {
                    AppMethodBeat.o(14788);
                    return;
                }
                try {
                    a.this.s.signalEndOfInputStream();
                } catch (Exception e2) {
                    TXCLog.e("TXCHWVideoEncoder", "signalEndOfInputStream failed.", e2);
                }
                do {
                } while (a.c(a.this, 10) >= 0);
                a.a(a.this);
                AppMethodBeat.o(14788);
            }
        });
        AppMethodBeat.o(14868);
    }

    @TargetApi(16)
    private MediaFormat a(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(14869);
        if (i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0) {
            AppMethodBeat.o(14869);
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.t, i2, i3);
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i4 * 1024);
        createVideoFormat.setInteger("frame-rate", i5);
        createVideoFormat.setInteger("color-format", EncoderWriter.OUTPUT_VIDEO_COLOR_FORMAT);
        createVideoFormat.setInteger("i-frame-interval", i6);
        AppMethodBeat.o(14869);
        return createVideoFormat;
    }

    @TargetApi(16)
    private MediaFormat a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        AppMethodBeat.i(14870);
        MediaFormat a2 = a(i2, i3, i4, i5, i6);
        if (a2 == null) {
            AppMethodBeat.o(14870);
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodecInfo a3 = a(this.t);
            if (a3 == null) {
                AppMethodBeat.o(14870);
                return a2;
            }
            MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(this.t);
            MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            if (z2) {
                a2.setInteger("bitrate-mode", i7);
            } else if (encoderCapabilities.isBitrateModeSupported(i7)) {
                a2.setInteger("bitrate-mode", i7);
            } else if (this.O) {
                if (encoderCapabilities.isBitrateModeSupported(1)) {
                    a2.setInteger("bitrate-mode", 1);
                } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                    a2.setInteger("bitrate-mode", 2);
                }
            } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                a2.setInteger("bitrate-mode", 2);
            }
            a2.setInteger("complexity", encoderCapabilities.getComplexityRange().clamp(5).intValue());
            int i9 = 0;
            if (Build.VERSION.SDK_INT >= 23) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                    if (codecProfileLevel.profile <= i8 && codecProfileLevel.profile > i9) {
                        i9 = codecProfileLevel.profile;
                        a2.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        a2.setInteger("level", codecProfileLevel.level);
                    }
                }
            }
        }
        AppMethodBeat.o(14870);
        return a2;
    }

    @TargetApi(16)
    private static MediaCodecInfo a(String str) {
        AppMethodBeat.i(14871);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(14871);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(14871);
        return null;
    }

    private void a(long j2) {
        AppMethodBeat.i(14872);
        this.y.add(Long.valueOf(j2));
        AppMethodBeat.o(14872);
    }

    private long a() {
        AppMethodBeat.i(182430);
        Long poll = this.y.poll();
        if (poll == null) {
            AppMethodBeat.o(182430);
            return 0;
        }
        long longValue = poll.longValue();
        AppMethodBeat.o(182430);
        return longValue;
    }

    private boolean a(Surface surface, int i2, int i3) {
        AppMethodBeat.i(14874);
        if (surface == null) {
            AppMethodBeat.o(14874);
            return false;
        }
        TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode createGL: " + this.mGLContextExternal);
        if (this.mGLContextExternal == null || !(this.mGLContextExternal instanceof EGLContext)) {
            this.z = b.a(null, (javax.microedition.khronos.egl.EGLContext) this.mGLContextExternal, surface, i2, i3);
        } else {
            this.z = c.a(null, (EGLContext) this.mGLContextExternal, surface, i2, i3);
        }
        if (this.z == null) {
            AppMethodBeat.o(14874);
            return false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.mEncodeFilter = new h();
        this.mEncodeFilter.a(l.f344e, l.a(k.NORMAL, false, false));
        if (!this.mEncodeFilter.a()) {
            this.mEncodeFilter = null;
            AppMethodBeat.o(14874);
            return false;
        }
        GLES20.glViewport(0, 0, i2, i3);
        AppMethodBeat.o(14874);
        return true;
    }

    private void b() {
        AppMethodBeat.i(182431);
        TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode destroyGL");
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.d();
            this.mEncodeFilter = null;
        }
        if (this.z instanceof b) {
            ((b) this.z).c();
            this.z = null;
        }
        if (this.z instanceof c) {
            ((c) this.z).c();
            this.z = null;
        }
        AppMethodBeat.o(182431);
    }

    @TargetApi(18)
    private boolean a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.i(14876);
        this.C = false;
        this.B = false;
        this.f1239b = 0;
        this.f1240c = 0.0d;
        this.f1241d = 0;
        this.f1242e = 0;
        this.f1243f = 0;
        this.f1246i = 0;
        this.f1247j = tXSVideoEncoderParam.baseGopIndex;
        this.k = 0;
        this.l = tXSVideoEncoderParam.baseFrameIndex;
        this.m = 0;
        this.q = 0;
        this.r = 0;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.J = -1;
        this.mOutputWidth = tXSVideoEncoderParam.width;
        this.mOutputHeight = tXSVideoEncoderParam.height;
        this.K = tXSVideoEncoderParam.gop;
        this.L = tXSVideoEncoderParam.fps;
        TXCLog.i("TXCHWVideoEncoder", "init with fps " + this.L);
        this.O = tXSVideoEncoderParam.fullIFrame;
        this.n = tXSVideoEncoderParam.syncOutput;
        this.D = tXSVideoEncoderParam.enableEGL14;
        this.Q = tXSVideoEncoderParam.forceSetBitrateMode;
        this.y.clear();
        this.P = tXSVideoEncoderParam.bLimitFps;
        if (tXSVideoEncoderParam == null || tXSVideoEncoderParam.width == 0 || tXSVideoEncoderParam.height == 0 || tXSVideoEncoderParam.fps == 0 || tXSVideoEncoderParam.gop == 0) {
            this.B = true;
            AppMethodBeat.o(14876);
            return false;
        }
        this.R = tXSVideoEncoderParam.isHEVCEncoderEnabled;
        this.f1244g = tXSVideoEncoderParam.annexb;
        this.f1245h = tXSVideoEncoderParam.appendSpsPps;
        if (this.f1238a == 0) {
            this.f1238a = (int) (Math.sqrt((((double) (tXSVideoEncoderParam.width * tXSVideoEncoderParam.width)) * 1.0d) + ((double) (tXSVideoEncoderParam.height * tXSVideoEncoderParam.height))) * 1.2d);
        }
        this.f1246i = (long) this.f1238a;
        this.f1243f = tXSVideoEncoderParam.fps;
        int i2 = 2;
        switch (tXSVideoEncoderParam.encoderMode) {
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 0;
                break;
        }
        if (com.tencent.liteav.basic.d.c.a().d() == 1) {
            tXSVideoEncoderParam.encoderProfile = 1;
        }
        this.M = i2;
        this.N = 1;
        if (this.R && Build.VERSION.SDK_INT >= 21) {
            this.N = 1;
        }
        if (!c()) {
            AppMethodBeat.o(14876);
            return false;
        }
        this.mInit = true;
        if (this.P) {
            this.Y = -1;
            this.u.b(this.w);
        }
        this.aa = new ArrayList<>();
        this.ab = 0;
        AppMethodBeat.o(14876);
        return true;
    }

    private int a(int i2) {
        byte[] bArr;
        int i3;
        byte[] bArr2;
        long j2;
        int i4;
        long j3;
        AppMethodBeat.i(14877);
        if (this.s == null) {
            AppMethodBeat.o(14877);
            return -1;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int dequeueOutputBuffer = this.s.dequeueOutputBuffer(bufferInfo, (long) (i2 * 1000));
            if (dequeueOutputBuffer == -1) {
                AppMethodBeat.o(14877);
                return 0;
            } else if (dequeueOutputBuffer == -3) {
                this.E = this.s.getOutputBuffers();
                AppMethodBeat.o(14877);
                return 1;
            } else if (dequeueOutputBuffer == -2) {
                callDelegate(this.s.getOutputFormat());
                AppMethodBeat.o(14877);
                return 1;
            } else if (dequeueOutputBuffer < 0) {
                AppMethodBeat.o(14877);
                return -1;
            } else {
                long timeTick = TXCTimeUtil.getTimeTick();
                ByteBuffer byteBuffer = this.E[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    i4 = -1;
                } else {
                    byte[] bArr3 = new byte[bufferInfo.size];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    byteBuffer.get(bArr3, 0, bufferInfo.size);
                    int length = bArr3.length;
                    if (bufferInfo.size > 5 && bArr3[0] == 0 && bArr3[1] == 0 && bArr3[2] == 0 && bArr3[3] == 0 && bArr3[4] == 0 && bArr3[5] == 0) {
                        int i5 = 3;
                        while (true) {
                            if (i5 < length - 4) {
                                if (bArr3[i5] == 0 && bArr3[i5 + 1] == 0 && bArr3[i5 + 2] == 0 && bArr3[i5 + 3] == 1) {
                                    length -= i5;
                                    break;
                                }
                                i5++;
                            } else {
                                i5 = 0;
                                break;
                            }
                        }
                        byte[] bArr4 = new byte[length];
                        System.arraycopy(bArr3, i5, bArr4, 0, length);
                        bArr = bArr4;
                    } else {
                        bArr = bArr3;
                    }
                    if (bufferInfo.size == 0) {
                        if ((bufferInfo.flags & 4) != 0) {
                            if (this.mListener != null) {
                                this.mListener.a(null, 0);
                            }
                            i4 = -2;
                        } else {
                            i4 = -1;
                        }
                    } else if ((bufferInfo.flags & 2) == 2) {
                        if (this.f1244g) {
                            this.F = (byte[]) bArr.clone();
                        } else {
                            this.F = a((byte[]) bArr.clone());
                        }
                        i4 = 1;
                    } else {
                        if ((bufferInfo.flags & 1) == 1) {
                            this.J = -1;
                            if (this.f1244g) {
                                byte[] bArr5 = new byte[(this.F.length + bArr.length)];
                                System.arraycopy(this.F, 0, bArr5, 0, this.F.length);
                                System.arraycopy(bArr, 0, bArr5, this.F.length, bArr.length);
                                i3 = 0;
                                bArr2 = bArr5;
                            } else {
                                byte[] a2 = a(bArr);
                                byte[] bArr6 = new byte[(this.F.length + a2.length)];
                                System.arraycopy(this.F, 0, bArr6, 0, this.F.length);
                                System.arraycopy(a2, 0, bArr6, this.F.length, a2.length);
                                i3 = 0;
                                bArr2 = bArr6;
                            }
                        } else if (!this.f1244g) {
                            i3 = 1;
                            bArr2 = a(bArr);
                        } else {
                            i3 = 1;
                            bArr2 = bArr;
                        }
                        if (!this.O) {
                            int i6 = this.J + 1;
                            this.J = i6;
                            if (i6 == this.f1243f * this.K) {
                                f();
                            }
                        }
                        long a3 = a();
                        long j4 = bufferInfo.presentationTimeUs / 1000;
                        if (j4 < this.o && !this.p) {
                            this.p = true;
                            String str = "[Encoder] pts error, maybe have b frames. profile:" + this.N + " device:" + TXCCommonUtil.getDeviceInfo() + " last pts:" + this.o + " current pts:" + j4;
                            if (this.R) {
                                str = str + " hevc";
                            }
                            TXCLog.e("TXCHWVideoEncoder", str);
                            Monitor.a(2, str, "", 0);
                            if (this.R) {
                                com.tencent.liteav.basic.d.c.a().b(false);
                                callDelegate(10000006);
                                TXCLog.i("TXCHWVideoEncoder", "[Encoder] hevc Got BFrame ,post ErrorCode_EncodeGotBFrame callback.");
                            } else {
                                if (this.N != 1) {
                                    this.N = 1;
                                    TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline when recv b frame.");
                                }
                                com.tencent.liteav.basic.d.c.a().a(false);
                                TXCLog.i("TXCHWVideoEncoder", "[Encoder] post restart encoder task.");
                                if (this.u != null) {
                                    this.u.b(this.ai);
                                }
                            }
                        }
                        this.o = j4;
                        if (this.I == 0) {
                            this.I = a3;
                        }
                        if (this.H == 0) {
                            this.H = j4;
                        }
                        long j5 = j4 + (this.I - this.H);
                        if (a3 <= this.m) {
                            j2 = this.m + 1;
                        } else {
                            j2 = a3;
                        }
                        if (j2 > j5) {
                            j2 = j5;
                        }
                        this.m = j2;
                        long timeTick2 = TXCTimeUtil.getTimeTick();
                        if (i3 == 0) {
                            if (timeTick2 > this.f1241d + 1000) {
                                this.f1239b = (long) (((((double) this.q) * 8000.0d) / ((double) (timeTick2 - this.f1241d))) / 1024.0d);
                                this.q = 0;
                                this.f1241d = timeTick2;
                                g();
                            }
                            this.f1247j++;
                            if (this.f1247j % 256 == 0) {
                                this.f1247j++;
                            }
                            this.k = 0;
                        } else {
                            this.k++;
                        }
                        this.q += (long) bArr2.length;
                        if (timeTick2 > this.f1242e + 2000) {
                            this.f1240c = (((double) this.r) * 1000.0d) / ((double) (timeTick2 - this.f1242e));
                            this.r = 0;
                            this.f1242e = timeTick2;
                            long j6 = 0;
                            Iterator<Long> it = this.aa.iterator();
                            while (it.hasNext()) {
                                Long next = it.next();
                                if (next.longValue() > j6) {
                                    j3 = next.longValue();
                                } else {
                                    j3 = j6;
                                }
                                j6 = j3;
                            }
                            this.aa.clear();
                            this.ab = (int) (3 * j6);
                        }
                        this.r++;
                        byteBuffer.position(bufferInfo.offset);
                        this.l++;
                        if (this.mListener != null) {
                            this.mListener.a(2, this.f1247j, this.k);
                        }
                        if (this.p) {
                            TXCLog.w("TXCHWVideoEncoder", "[Encoder] drop all frame when find b frame.");
                        } else {
                            TXSNALPacket tXSNALPacket = new TXSNALPacket();
                            if (this.f1245h) {
                                tXSNALPacket.nalData = bArr2;
                            } else {
                                tXSNALPacket.nalData = bArr3;
                            }
                            tXSNALPacket.nalType = i3;
                            tXSNALPacket.gopIndex = this.f1247j;
                            tXSNALPacket.gopFrameIndex = this.k;
                            tXSNALPacket.frameIndex = this.l;
                            tXSNALPacket.refFremeIndex = i3 == 0 ? this.k : this.k - 1;
                            tXSNALPacket.pts = j5;
                            tXSNALPacket.dts = j5;
                            tXSNALPacket.buffer = byteBuffer != null ? byteBuffer.asReadOnlyBuffer() : null;
                            tXSNALPacket.codecId = this.R ? 1 : 0;
                            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                            tXSNALPacket.info = bufferInfo2;
                            callDelegate(tXSNALPacket, 0);
                        }
                        this.T++;
                        if ((bufferInfo.flags & 4) != 0) {
                            if (this.mListener != null) {
                                this.mListener.a(null, 0);
                            }
                            i4 = -2;
                        } else {
                            i4 = 1;
                        }
                        this.aa.add(Long.valueOf(TXCTimeUtil.getTimeTick() - timeTick));
                    }
                }
                try {
                    if (this.s != null) {
                        this.s.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                } catch (IllegalStateException e2) {
                    TXCLog.e("TXCHWVideoEncoder", "releaseOutputBuffer failed." + e2.getMessage());
                }
                AppMethodBeat.o(14877);
                return i4;
            }
        } catch (IllegalStateException e3) {
            TXCLog.e("TXCHWVideoEncoder", "dequeueOutputBuffer failed." + e3.getMessage());
            AppMethodBeat.o(14877);
            return -1;
        }
    }

    private byte[] a(byte[] bArr) {
        AppMethodBeat.i(14878);
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                int i5 = i2 + 3;
                i2 = i5;
                i3 = i5;
            } else if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                int i6 = i2 + 4;
                i2 = i6;
                i3 = i6;
            }
            if (i2 != length - 4 || (bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1)) {
                i2++;
            }
        }
        i2 = length;
        int a2 = a(i2, i3, bArr2, bArr, i4);
        byte[] bArr3 = new byte[a2];
        System.arraycopy(bArr2, 0, bArr3, 0, a2);
        AppMethodBeat.o(14878);
        return bArr3;
    }

    private int a(int i2, int i3, byte[] bArr, byte[] bArr2, int i4) {
        AppMethodBeat.i(14879);
        if (i3 > 0 && i2 > i3) {
            int i5 = i2 - i3;
            try {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
                wrap.asIntBuffer().put(i5);
                wrap.order(ByteOrder.BIG_ENDIAN);
                System.arraycopy(wrap.array(), 0, bArr, i4, 4);
                System.arraycopy(bArr2, i3, bArr, i4 + 4, i5);
                i4 += i5 + 4;
            } catch (Exception e2) {
                TXCLog.e("TXCHWVideoEncoder", "setNalData exception");
            }
        }
        AppMethodBeat.o(14879);
        return i4;
    }

    @TargetApi(18)
    private void b(int i2) {
        int a2;
        AppMethodBeat.i(14880);
        if (this.B || this.z == null) {
            AppMethodBeat.o(14880);
            return;
        }
        int i3 = this.Y;
        if (this.P) {
            this.Y = -1;
            if (i3 == -1) {
                this.Z = true;
                AppMethodBeat.o(14880);
                return;
            }
            this.X++;
            this.u.a(this.w, (long) (1000 / this.L));
        }
        a(this.G);
        int i4 = (720 - this.mRotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, ((float) ((i4 == 90 || i4 == 270) ? this.mOutputHeight : this.mOutputWidth)) / ((float) ((i4 == 90 || i4 == 270) ? this.mOutputWidth : this.mOutputHeight)), this.mEnableXMirror, true);
        this.mEncodeFilter.a(i3);
        if (this.z instanceof c) {
            ((c) this.z).a(this.G * TimeUtil.SECOND_TO_US);
            ((c) this.z).d();
        }
        if (this.z instanceof b) {
            ((b) this.z).a();
        }
        do {
            a2 = a(i2);
        } while (a2 > 0);
        if (a2 == -1 || a2 == -2) {
            if (a2 == -1) {
                callDelegate(10000005);
            }
            this.B = true;
            e();
            AppMethodBeat.o(14880);
            return;
        }
        this.S++;
        AppMethodBeat.o(14880);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014e A[SYNTHETIC, Splitter:B:59:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015e A[Catch:{ Exception -> 0x0168 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.a.c():boolean");
    }

    private void d() {
        AppMethodBeat.i(182433);
        if (this.s == null) {
            AppMethodBeat.o(182433);
            return;
        }
        try {
            this.s.stop();
            try {
                this.s.release();
                if (this.A != null) {
                    this.A.release();
                }
                this.A = null;
            } catch (Exception e2) {
                TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", e2);
            }
        } catch (IllegalStateException e3) {
            TXCLog.e("TXCHWVideoEncoder", "stop encoder failed.", e3);
            try {
                this.s.release();
                if (this.A != null) {
                    this.A.release();
                }
                this.A = null;
            } catch (Exception e4) {
                TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", e4);
            }
        } catch (Throwable th) {
            try {
                this.s.release();
                if (this.A != null) {
                    this.A.release();
                }
                this.A = null;
            } catch (Exception e5) {
                TXCLog.e("TXCHWVideoEncoder", "release encoder failed.", e5);
            }
            AppMethodBeat.o(182433);
            throw th;
        }
        this.s = null;
        AppMethodBeat.o(182433);
    }

    private void e() {
        AppMethodBeat.i(14882);
        if (!this.mInit) {
            AppMethodBeat.o(14882);
            return;
        }
        this.B = true;
        this.C = true;
        b();
        d();
        this.Y = -1;
        this.f1239b = 0;
        this.f1240c = 0.0d;
        this.f1241d = 0;
        this.f1242e = 0;
        this.f1243f = 0;
        this.f1246i = 0;
        this.f1247j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.q = 0;
        this.r = 0;
        this.mGLContextExternal = null;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mInit = false;
        this.mListener = null;
        this.y.clear();
        this.aa.clear();
        this.ab = 0;
        AppMethodBeat.o(14882);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r11) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.a.c(int):void");
    }

    private void f() {
        AppMethodBeat.i(14883);
        if (Build.VERSION.SDK_INT >= 19 && this.s != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.s.setParameters(bundle);
        }
        AppMethodBeat.o(14883);
    }

    private void d(int i2) {
        AppMethodBeat.i(14886);
        if (!this.mInit) {
            AppMethodBeat.o(14886);
        } else if (i2 == 0 || this.L == i2) {
            AppMethodBeat.o(14886);
        } else if (Build.VERSION.SDK_INT < 18) {
            AppMethodBeat.o(14886);
        } else {
            TXCLog.i("TXCHWVideoEncoder", "set fps " + i2 + ", restart encoder.");
            b();
            d();
            this.L = i2;
            c();
            AppMethodBeat.o(14886);
        }
    }

    private void g() {
        long j2 = 100;
        int i2 = 5;
        AppMethodBeat.i(14885);
        if (this.ac > 0) {
            int i3 = this.L - ((int) this.f1240c);
            int i4 = this.L / 2;
            if (i4 >= 5) {
                i2 = i4;
            }
            if (i3 <= i2 && System.currentTimeMillis() - this.ac > ((long) (((3 - this.ad) + 1) * 2000))) {
                long j3 = ((long) this.ae) - this.f1239b;
                long j4 = this.f1246i / 2;
                if (j4 >= 100) {
                    j2 = j4;
                }
                if (j3 > j2) {
                    this.af = true;
                    String str = "real bitrate is too much lower than target bitrate![targetBr:" + this.ae + "] [realBr:" + this.f1239b + "]. restart encoder. [module:" + Build.MODEL + "] [Hardware:" + Build.HARDWARE + "] [osVersion:" + Build.VERSION.RELEASE + "]";
                    TXCLog.e("TXCHWVideoEncoder", str);
                    Monitor.a(3, str, "", 0);
                    if (this.u != null) {
                        this.u.b(this.ai);
                    }
                    this.ac = 0;
                    AppMethodBeat.o(14885);
                    return;
                }
                this.ad--;
                if (this.ad <= 0) {
                    this.ac = 0;
                }
            }
        }
        AppMethodBeat.o(14885);
    }
}

package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.c;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.c.g;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPGeneralError;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class b implements com.tencent.thumbplayer.a.a.b {
    com.tencent.thumbplayer.f.a RVN;
    private TPNativePlayer RYa;
    private TPNativePlayerInitConfig RYb;
    a RYc;
    com.tencent.thumbplayer.a.e RYd;
    private com.tencent.thumbplayer.a.a.a RYe;
    TPSubtitleData RYf = new TPSubtitleData();
    private ITPNativePlayerMessageCallback RYg = new ITPNativePlayerMessageCallback() {
        /* class com.tencent.thumbplayer.a.a.b.b.AnonymousClass1 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public final void onASyncCallResult(int i2, long j2, int i3, int i4) {
            AppMethodBeat.i(188916);
            b.this.RVN.info("onASyncCallResult, callType:" + i2 + ", opaque:" + j2 + ", errorType:" + i3 + ", errorCode:" + i4);
            C2200b bVar = new C2200b();
            bVar.RYm = i2;
            bVar.RVK = j2;
            bVar.dGe = i3;
            bVar.errorCode = i4;
            Message.obtain(b.this.RYc, 1, bVar).sendToTarget();
            AppMethodBeat.o(188916);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public final void onInfoLong(int i2, long j2, long j3) {
            AppMethodBeat.i(188917);
            b.this.RVN.info("onInfoLong, infoType:" + i2 + ", lParam1:" + j2 + ", lParam2:" + j3);
            d dVar = new d();
            dVar.infoType = i2;
            dVar.lParam1 = j2;
            dVar.RYn = j3;
            Message.obtain(b.this.RYc, 2, dVar).sendToTarget();
            AppMethodBeat.o(188917);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public final void onInfoObject(int i2, Object obj) {
            AppMethodBeat.i(188918);
            b.this.RVN.info("onInfoObject, infoType:" + i2 + ", objParam:" + obj);
            e eVar = new e();
            eVar.infoType = i2;
            eVar.RYo = obj;
            Message.obtain(b.this.RYc, 3, eVar).sendToTarget();
            AppMethodBeat.o(188918);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(188919);
            b.this.RVN.info("onError, msgType:" + i2 + ", errorCode:" + i3);
            c cVar = new c();
            cVar.msgType = i2;
            cVar.errorCode = i3;
            Message.obtain(b.this.RYc, 4, cVar).sendToTarget();
            AppMethodBeat.o(188919);
        }
    };
    private ITPNativePlayerAudioFrameCallback RYh = new ITPNativePlayerAudioFrameCallback() {
        /* class com.tencent.thumbplayer.a.a.b.b.AnonymousClass2 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback
        public final void onAudioFrame(TPAudioFrame tPAudioFrame, int i2) {
            AppMethodBeat.i(188920);
            b.this.RYd.a(c.a(tPAudioFrame));
            AppMethodBeat.o(188920);
        }
    };
    private ITPNativePlayerVideoFrameCallback RYi = new ITPNativePlayerVideoFrameCallback() {
        /* class com.tencent.thumbplayer.a.a.b.b.AnonymousClass3 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback
        public final void onVideoFrame(TPVideoFrame tPVideoFrame, int i2) {
            AppMethodBeat.i(188921);
            b.this.RYd.a(c.a(tPVideoFrame));
            AppMethodBeat.o(188921);
        }
    };
    private ITPNativePlayerSubtitleFrameCallback RYj = new ITPNativePlayerSubtitleFrameCallback() {
        /* class com.tencent.thumbplayer.a.a.b.b.AnonymousClass4 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback
        public final void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame, int i2) {
            AppMethodBeat.i(188922);
            b.this.RYd.a(c.a(tPSubtitleFrame));
            AppMethodBeat.o(188922);
        }
    };
    private ITPNativePlayerPostProcessFrameCallback RYk = new ITPNativePlayerPostProcessFrameCallback() {
        /* class com.tencent.thumbplayer.a.a.b.b.AnonymousClass5 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback
        public final TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame tPPostProcessFrame, int i2) {
            AppMethodBeat.i(188923);
            TPPostProcessFrameBuffer a2 = c.a(tPPostProcessFrame);
            a2.eventFlag = i2;
            if (tPPostProcessFrame.mediaType == 0) {
                TPPostProcessFrame c2 = c.c(b.this.RYd.a(a2));
                AppMethodBeat.o(188923);
                return c2;
            } else if (tPPostProcessFrame.mediaType == 1) {
                TPPostProcessFrame c3 = c.c(b.this.RYd.b(a2));
                AppMethodBeat.o(188923);
                return c3;
            } else {
                AppMethodBeat.o(188923);
                return null;
            }
        }
    };

    /* renamed from: com.tencent.thumbplayer.a.a.b.b$b  reason: collision with other inner class name */
    public static class C2200b {
        long RVK;
        @TPCommonEnum.NativeMsgInfo
        int RYm;
        int dGe;
        int errorCode;
    }

    public static class c {
        int errorCode;
        int msgType;
    }

    public static class d {
        long RYn;
        int infoType;
        long lParam1;
    }

    public static class e {
        Object RYo;
        int infoType;
    }

    public b(Context context, com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188926);
        this.RVN = new com.tencent.thumbplayer.f.a(bVar, "TPThumbPlayer");
        this.RYa = new TPNativePlayer(context);
        this.RYa.setMessageCallback(this.RYg);
        this.RYa.setAudioFrameCallback(this.RYh);
        this.RYa.setVideoFrameCallback(this.RYi);
        this.RYa.setSubtitleFrameCallback(this.RYj);
        this.RYa.setPostProcessFrameCallback(this.RYk);
        this.RYb = new TPNativePlayerInitConfig();
        this.RYd = new com.tencent.thumbplayer.a.e(this.RVN.RVM.tag);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.RYc = new a(myLooper, this);
            AppMethodBeat.o(188926);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.RYc = new a(mainLooper, this);
            AppMethodBeat.o(188926);
            return;
        }
        this.RYc = null;
        AppMethodBeat.o(188926);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void updateLoggerContext(com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188927);
        this.RVN.a(new com.tencent.thumbplayer.f.b(bVar, "TPThumbPlayer"));
        if (bVar != null) {
            this.RYd.bqx(this.RVN.RVM.tag);
        }
        AppMethodBeat.o(188927);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        long j2;
        boolean z = true;
        AppMethodBeat.i(188928);
        this.RVN.info("setPlayerOptionalParam:".concat(String.valueOf(tPOptionalParam)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188928);
        } else if (tPOptionalParam.getParamType() == 1) {
            if (tPOptionalParam.getKey() < 500) {
                int key = tPOptionalParam.getKey();
                TPOptionalParam.OptionalParamBoolean paramBoolean = tPOptionalParam.getParamBoolean();
                c.a are = com.tencent.thumbplayer.a.b.b.b.are(key);
                if (are == null) {
                    this.RVN.error("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(key)));
                    AppMethodBeat.o(188928);
                    return;
                }
                switch (are.RYp) {
                    case 3:
                        this.RYb.setBool(are.RYq, paramBoolean.value);
                        AppMethodBeat.o(188928);
                        return;
                    default:
                        this.RVN.error("optionID type:" + are.RYp + " is not implement");
                        AppMethodBeat.o(188928);
                        return;
                }
            } else {
                int key2 = tPOptionalParam.getKey();
                TPOptionalParam.OptionalParamBoolean paramBoolean2 = tPOptionalParam.getParamBoolean();
                c.a arf = com.tencent.thumbplayer.a.b.b.b.arf(key2);
                if (arf == null) {
                    this.RVN.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(key2)));
                    AppMethodBeat.o(188928);
                    return;
                }
                switch (arf.RYp) {
                    case 3:
                        TPNativePlayer tPNativePlayer = this.RYa;
                        int i2 = arf.RYq;
                        if (paramBoolean2.value) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        tPNativePlayer.setOptionLong(i2, j2, 0);
                        AppMethodBeat.o(188928);
                        return;
                    default:
                        this.RVN.error("optionID type:" + arf.RYp + " is not implement");
                        AppMethodBeat.o(188928);
                        return;
                }
            }
        } else if (tPOptionalParam.getParamType() != 2) {
            if (tPOptionalParam.getParamType() == 6) {
                if (tPOptionalParam.getKey() < 500) {
                    int key3 = tPOptionalParam.getKey();
                    TPOptionalParam.OptionalParamFloat paramFloat = tPOptionalParam.getParamFloat();
                    c.a are2 = com.tencent.thumbplayer.a.b.b.b.are(key3);
                    if (are2 == null) {
                        this.RVN.error("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(key3)));
                        AppMethodBeat.o(188928);
                        return;
                    } else if (7 != are2.RYp) {
                        this.RVN.error("optionID:" + are2.RYq + " is not float");
                        AppMethodBeat.o(188928);
                        return;
                    } else {
                        this.RYb.setFloat(are2.RYq, paramFloat.value);
                        AppMethodBeat.o(188928);
                        return;
                    }
                }
            } else if (tPOptionalParam.getParamType() == 3) {
                if (tPOptionalParam.getKey() < 500) {
                    tPOptionalParam.getKey();
                    tPOptionalParam.getParamString();
                    this.RVN.error("init string param type is not implement coz native init config no string setting");
                    AppMethodBeat.o(188928);
                    return;
                }
                int key4 = tPOptionalParam.getKey();
                TPOptionalParam.OptionalParamString paramString = tPOptionalParam.getParamString();
                c.a arf2 = com.tencent.thumbplayer.a.b.b.b.arf(key4);
                if (arf2 == null) {
                    this.RVN.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(key4)));
                    AppMethodBeat.o(188928);
                    return;
                }
                switch (arf2.RYp) {
                    case 2:
                        this.RYa.setOptionObject(arf2.RYq, paramString.value);
                        AppMethodBeat.o(188928);
                        return;
                    default:
                        this.RVN.error("optionID type:" + arf2.RYp + " is not implement");
                        AppMethodBeat.o(188928);
                        return;
                }
            } else if (tPOptionalParam.getParamType() == 4) {
                if (tPOptionalParam.getKey() < 500) {
                    a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueInt());
                    AppMethodBeat.o(188928);
                    return;
                }
            } else if (tPOptionalParam.getParamType() != 5) {
                this.RVN.warn("optionalParam param type is unknown, return");
                AppMethodBeat.o(188928);
                return;
            } else if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueString());
                AppMethodBeat.o(188928);
                return;
            }
            AppMethodBeat.o(188928);
        } else if (tPOptionalParam.getKey() < 500) {
            int key5 = tPOptionalParam.getKey();
            TPOptionalParam.OptionalParamLong paramLong = tPOptionalParam.getParamLong();
            c.a are3 = com.tencent.thumbplayer.a.b.b.b.are(key5);
            if (are3 == null) {
                this.RVN.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(key5)));
                AppMethodBeat.o(188928);
                return;
            }
            switch (are3.RYp) {
                case 1:
                    this.RYb.setLong(are3.RYq, paramLong.value);
                    AppMethodBeat.o(188928);
                    return;
                case 2:
                default:
                    this.RVN.error("optionID type:" + are3.RYp + " is not implement");
                    AppMethodBeat.o(188928);
                    return;
                case 3:
                    TPNativePlayerInitConfig tPNativePlayerInitConfig = this.RYb;
                    int i3 = are3.RYq;
                    if (paramLong.value <= 0) {
                        z = false;
                    }
                    tPNativePlayerInitConfig.setBool(i3, z);
                    AppMethodBeat.o(188928);
                    return;
                case 4:
                    this.RYb.setInt(are3.RYq, (int) paramLong.value);
                    AppMethodBeat.o(188928);
                    return;
            }
        } else {
            int key6 = tPOptionalParam.getKey();
            TPOptionalParam.OptionalParamLong paramLong2 = tPOptionalParam.getParamLong();
            c.a arf3 = com.tencent.thumbplayer.a.b.b.b.arf(key6);
            if (arf3 == null) {
                this.RVN.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(key6)));
                AppMethodBeat.o(188928);
                return;
            }
            switch (arf3.RYp) {
                case 1:
                case 3:
                case 4:
                    this.RYa.setOptionLong(arf3.RYq, paramLong2.value, paramLong2.param1);
                    AppMethodBeat.o(188928);
                    return;
                case 2:
                default:
                    this.RVN.error("optionID type:" + arf3.RYp + " is not implement");
                    AppMethodBeat.o(188928);
                    return;
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i2, TPOptionalParam.OptionalParamQueueInt optionalParamQueueInt) {
        AppMethodBeat.i(188929);
        c.a are = com.tencent.thumbplayer.a.b.b.b.are(i2);
        if (are == null) {
            this.RVN.error("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(188929);
        } else if (optionalParamQueueInt.queueValue == null || optionalParamQueueInt.queueValue.length == 0) {
            this.RVN.error("queueint params is empty in".concat(String.valueOf(i2)));
            AppMethodBeat.o(188929);
        } else {
            switch (are.RYp) {
                case 5:
                    for (int i3 = 0; i3 < optionalParamQueueInt.queueValue.length; i3++) {
                        this.RYb.addQueueInt(are.RYq, optionalParamQueueInt.queueValue[i3]);
                    }
                    AppMethodBeat.o(188929);
                    return;
                default:
                    this.RVN.error("optionID type:" + are.RYp + " is not implement");
                    AppMethodBeat.o(188929);
                    return;
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i2, TPOptionalParam.OptionalParamQueueString optionalParamQueueString) {
        AppMethodBeat.i(188930);
        c.a are = com.tencent.thumbplayer.a.b.b.b.are(i2);
        if (are == null) {
            this.RVN.error("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(188930);
        } else if (optionalParamQueueString.queueValue == null || optionalParamQueueString.queueValue.length == 0) {
            this.RVN.error("queue String params is empty in".concat(String.valueOf(i2)));
            AppMethodBeat.o(188930);
        } else {
            switch (are.RYp) {
                case 6:
                    for (int i3 = 0; i3 < optionalParamQueueString.queueValue.length; i3++) {
                        this.RYb.addQueueString(are.RYq, optionalParamQueueString.queueValue[i3]);
                    }
                    AppMethodBeat.o(188930);
                    return;
                default:
                    this.RVN.error("optionID type:" + are.RYp + " is not implement");
                    AppMethodBeat.o(188930);
                    return;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.f fVar) {
        AppMethodBeat.i(188931);
        this.RYd.a(fVar);
        AppMethodBeat.o(188931);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.AbstractC2201c cVar) {
        AppMethodBeat.i(188932);
        this.RYd.a(cVar);
        AppMethodBeat.o(188932);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.e eVar) {
        AppMethodBeat.i(188933);
        this.RYd.a(eVar);
        AppMethodBeat.o(188933);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.d dVar) {
        AppMethodBeat.i(188934);
        this.RYd.a(dVar);
        AppMethodBeat.o(188934);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.g gVar) {
        AppMethodBeat.i(188935);
        this.RYd.a(gVar);
        AppMethodBeat.o(188935);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.m mVar) {
        AppMethodBeat.i(188936);
        this.RYd.a(mVar);
        AppMethodBeat.o(188936);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.i iVar) {
        AppMethodBeat.i(188937);
        this.RYd.a(iVar);
        AppMethodBeat.o(188937);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.j jVar) {
        AppMethodBeat.i(188938);
        this.RYd.a(jVar);
        AppMethodBeat.o(188938);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.k kVar) {
        AppMethodBeat.i(188939);
        this.RYd.a(kVar);
        AppMethodBeat.o(188939);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.a aVar) {
        AppMethodBeat.i(188940);
        this.RYd.b(aVar);
        AppMethodBeat.o(188940);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.l lVar) {
        AppMethodBeat.i(188941);
        this.RYd.b(lVar);
        AppMethodBeat.o(188941);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.b bVar) {
        AppMethodBeat.i(188942);
        this.RYd.b(bVar);
        AppMethodBeat.o(188942);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(188943);
        this.RVN.info("setSurface, surface is null ? : " + (surface == null));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188943);
        } else if (this.RYa.setVideoSurface(surface) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("setSurface failed!!");
            AppMethodBeat.o(188943);
            throw illegalStateException;
        } else {
            AppMethodBeat.o(188943);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(188944);
        this.RVN.info("SurfaceHolder, surfaceHolder is null ? : " + (surfaceHolder == null));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188944);
        } else if (surfaceHolder == null || surfaceHolder.getSurface() != null) {
            if (this.RYa.setVideoSurface(surfaceHolder == null ? null : surfaceHolder.getSurface()) != 0) {
                IllegalStateException illegalStateException = new IllegalStateException("setSurface failed!!");
                AppMethodBeat.o(188944);
                throw illegalStateException;
            }
            AppMethodBeat.o(188944);
        } else {
            this.RVN.error("SurfaceHolder，err.");
            AppMethodBeat.o(188944);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(188945);
        this.RVN.info("setDataSource: ".concat(String.valueOf(str)));
        hnc();
        if (this.RYa.setDataSource(str, map) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("setDataSource url and header failed!!");
            AppMethodBeat.o(188945);
            throw illegalStateException;
        }
        this.RYe = new com.tencent.thumbplayer.b.d(str);
        AppMethodBeat.o(188945);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188946);
        this.RVN.info("setDataSource: ".concat(String.valueOf(parcelFileDescriptor)));
        hnc();
        if (this.RYa.setDataSource(parcelFileDescriptor.getFd()) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("setDataSource url pfd failed!!");
            AppMethodBeat.o(188946);
            throw illegalStateException;
        }
        this.RYe = new com.tencent.thumbplayer.b.d(parcelFileDescriptor.getFd());
        AppMethodBeat.o(188946);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(188947);
        this.RVN.info("setDataSource: ".concat(String.valueOf(iTPMediaAsset)));
        hnc();
        if (iTPMediaAsset == null) {
            IllegalStateException illegalStateException = new IllegalStateException("media asset is null!");
            AppMethodBeat.o(188947);
            throw illegalStateException;
        } else if ((iTPMediaAsset instanceof com.tencent.thumbplayer.c.b) || (iTPMediaAsset instanceof com.tencent.thumbplayer.c.d) || (iTPMediaAsset instanceof com.tencent.thumbplayer.c.e) || (iTPMediaAsset instanceof g)) {
            String url = iTPMediaAsset.getUrl();
            if (this.RYa.setDataSource(url) != 0) {
                IllegalStateException illegalStateException2 = new IllegalStateException("setDataSource mediaAsset failed!!");
                AppMethodBeat.o(188947);
                throw illegalStateException2;
            }
            this.RYe = new com.tencent.thumbplayer.b.d(url);
            AppMethodBeat.o(188947);
        } else {
            IllegalStateException illegalStateException3 = new IllegalStateException("media asset is illegal source!");
            AppMethodBeat.o(188947);
            throw illegalStateException3;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void addSubtitleSource(String str, String str2, String str3) {
        AppMethodBeat.i(188948);
        this.RVN.info("addSubtitleSource");
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188948);
            return;
        }
        this.RYa.addSubtitleTrackSource(str, str3);
        AppMethodBeat.o(188948);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void g(String str, String str2, List<TPOptionalParam> list) {
        AppMethodBeat.i(188949);
        this.RVN.info("addAudioTrackSource");
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188949);
            return;
        }
        TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
        tPAudioTrackInfo.audioTrackUrl = str;
        com.tencent.thumbplayer.a.e eVar = this.RYd;
        if (eVar != null) {
            eVar.a(1012, 0, 0, tPAudioTrackInfo);
        }
        this.RYa.addAudioTrackSource(tPAudioTrackInfo.proxyUrl, str2);
        AppMethodBeat.o(188949);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectTrack(int i2, long j2) {
        AppMethodBeat.i(188950);
        this.RVN.info("selectTrack");
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188950);
            return;
        }
        this.RYa.selectTrackAsync(i2, j2);
        AppMethodBeat.o(188950);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void deselectTrack(int i2, long j2) {
        AppMethodBeat.i(188951);
        this.RVN.info("selectTrack");
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188951);
            return;
        }
        this.RYa.deselectTrackAsync(i2, j2);
        AppMethodBeat.o(188951);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepare() {
        AppMethodBeat.i(188952);
        this.RVN.info("prepare");
        hnc();
        this.RYa.setInitConfig(this.RYb);
        if (this.RYa.prepare() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("prepare failed!!");
            AppMethodBeat.o(188952);
            throw illegalStateException;
        }
        AppMethodBeat.o(188952);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepareAsync() {
        AppMethodBeat.i(188953);
        this.RVN.info("prepareAsync");
        hnc();
        this.RYa.setInitConfig(this.RYb);
        if (this.RYa.prepareAsync() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("prepareAsync failed!!");
            AppMethodBeat.o(188953);
            throw illegalStateException;
        }
        AppMethodBeat.o(188953);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void start() {
        AppMethodBeat.i(188954);
        this.RVN.info("start");
        hnc();
        if (this.RYa.start() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("start failed!!");
            AppMethodBeat.o(188954);
            throw illegalStateException;
        }
        AppMethodBeat.o(188954);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void pause() {
        AppMethodBeat.i(188955);
        this.RVN.info("pause");
        hnc();
        if (this.RYa.pause() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("pause failed!!");
            AppMethodBeat.o(188955);
            throw illegalStateException;
        }
        AppMethodBeat.o(188955);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void stop() {
        AppMethodBeat.i(188956);
        this.RVN.info("stop");
        hnc();
        this.RVN.info("stop before");
        int stop = this.RYa.stop();
        this.RVN.info("stop after");
        if (stop != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("stop failed!!");
            AppMethodBeat.o(188956);
            throw illegalStateException;
        }
        AppMethodBeat.o(188956);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void reset() {
        AppMethodBeat.i(188957);
        this.RVN.info("reset");
        if (this.RYa == null) {
            this.RVN.warn("reset, player has released.");
            AppMethodBeat.o(188957);
            return;
        }
        this.RVN.info("reset before");
        this.RYa.reset();
        this.RVN.info("reset after");
        AppMethodBeat.o(188957);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void release() {
        AppMethodBeat.i(188958);
        this.RVN.info("release");
        if (this.RYa != null) {
            this.RYa.release();
            this.RYa = null;
        }
        if (this.RYe != null) {
            this.RYe.release();
            this.RYe = null;
        }
        AppMethodBeat.o(188958);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2) {
        AppMethodBeat.i(188959);
        this.RVN.info("seekTo:".concat(String.valueOf(i2)));
        hnc();
        if (this.RYa.seekToAsync(i2, 1, 0) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("seek to position:" + i2 + " failed!!");
            AppMethodBeat.o(188959);
            throw illegalStateException;
        }
        AppMethodBeat.o(188959);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2, @TPCommonEnum.TPSeekMode int i3) {
        AppMethodBeat.i(188960);
        this.RVN.info("seekTo:" + i2 + " mode:" + i3);
        hnc();
        if (this.RYa.seekToAsync(i2, com.tencent.thumbplayer.a.b.b.b.ara(i3), 0) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("seek to position:" + i2 + " failed!!");
            AppMethodBeat.o(188960);
            throw illegalStateException;
        }
        AppMethodBeat.o(188960);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void L(String str, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
        AppMethodBeat.i(188961);
        this.RVN.info("switchDefinition url:" + str + " opaque:" + j2);
        hnc();
        if (this.RYa.switchDefinitionAsync(str, com.tencent.thumbplayer.a.b.b.b.arb(i2), j2) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("switchDefinition in invalid state");
            AppMethodBeat.o(188961);
            throw illegalStateException;
        }
        this.RYe = new com.tencent.thumbplayer.b.d(str);
        AppMethodBeat.o(188961);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
        AppMethodBeat.i(188962);
        this.RVN.info("switchDefinition mediaAsset:" + iTPMediaAsset + " opaque:" + j2);
        hnc();
        if (iTPMediaAsset != null) {
            if (this.RYa.switchDefinitionAsync(iTPMediaAsset.getUrl(), com.tencent.thumbplayer.a.b.b.b.arb(i2), j2) != 0) {
                IllegalStateException illegalStateException = new IllegalStateException("switchDefinition in invalid state");
                AppMethodBeat.o(188962);
                throw illegalStateException;
            }
            this.RYe = new com.tencent.thumbplayer.b.d(iTPMediaAsset.getUrl());
        }
        AppMethodBeat.o(188962);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setOutputMute(boolean z) {
        AppMethodBeat.i(188963);
        this.RVN.info("setOutputMute:".concat(String.valueOf(z)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188963);
            return;
        }
        this.RYa.setAudioMute(z);
        AppMethodBeat.o(188963);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioGainRatio(float f2) {
        AppMethodBeat.i(188964);
        this.RVN.info("setAudioGainRatio:".concat(String.valueOf(f2)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188964);
            return;
        }
        this.RYa.setAudioVolume(f2);
        AppMethodBeat.o(188964);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioNormalizeVolumeParams(String str) {
        AppMethodBeat.i(188965);
        this.RVN.info("setAudioNormalizeVolumeParams:".concat(String.valueOf(str)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188965);
            return;
        }
        this.RYa.setAudioNormalizeVolumeParams(str);
        AppMethodBeat.o(188965);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlaySpeedRatio(float f2) {
        AppMethodBeat.i(188966);
        this.RVN.info("setPlaySpeedRatio:".concat(String.valueOf(f2)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188966);
            return;
        }
        this.RYa.setPlaybackRate(f2);
        AppMethodBeat.o(188966);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z) {
        AppMethodBeat.i(188967);
        this.RVN.info("setLoopback:".concat(String.valueOf(z)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188967);
            return;
        }
        this.RYa.setLoopback(z, 0, -1);
        AppMethodBeat.o(188967);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(188968);
        this.RVN.info("setLoopback:" + z + " loopStartPositionMs:" + j2 + " loopEndPositionMs:" + j3);
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188968);
        } else if (this.RYa.setLoopback(z, j2, j3) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("set loopback failed!!");
            AppMethodBeat.o(188968);
            throw illegalStateException;
        } else {
            AppMethodBeat.o(188968);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPropertyLong(int i2) {
        AppMethodBeat.i(188969);
        this.RVN.info("getPropertyLong:".concat(String.valueOf(i2)));
        hnc();
        int ari = com.tencent.thumbplayer.a.b.b.b.ari(i2);
        if (ari < 0) {
            this.RVN.warn("paramId not found, return -1");
            AppMethodBeat.o(188969);
            return -1;
        }
        long propertyLong = this.RYa.getPropertyLong(ari);
        AppMethodBeat.o(188969);
        return propertyLong;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final String getPropertyString(int i2) {
        AppMethodBeat.i(188970);
        this.RVN.info("getPropertyString:".concat(String.valueOf(i2)));
        hnc();
        try {
            int ari = com.tencent.thumbplayer.a.b.b.b.ari(i2);
            if (ari < 0) {
                this.RVN.warn("getPropertyString, convertToNativePropertyId(" + i2 + "), return" + ari);
                AppMethodBeat.o(188970);
                return "";
            }
            String propertyString = this.RYa.getPropertyString(ari);
            AppMethodBeat.o(188970);
            return propertyString;
        } catch (IllegalArgumentException e2) {
            this.RVN.warn("paramId not found, return");
            AppMethodBeat.o(188970);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getDurationMs() {
        AppMethodBeat.i(188971);
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188971);
            return 0;
        }
        long durationMs = this.RYa.getDurationMs();
        AppMethodBeat.o(188971);
        return durationMs;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getCurrentPositionMs() {
        AppMethodBeat.i(188972);
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188972);
            return 0;
        }
        long currentPositionMs = this.RYa.getCurrentPositionMs();
        AppMethodBeat.o(188972);
        return currentPositionMs;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPlayableDurationMs() {
        AppMethodBeat.i(188973);
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188973);
            return 0;
        }
        long bufferedDurationMs = this.RYa.getBufferedDurationMs() + this.RYa.getCurrentPositionMs();
        AppMethodBeat.o(188973);
        return bufferedDurationMs;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoWidth() {
        AppMethodBeat.i(188974);
        this.RVN.info("getVideoWidth");
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188974);
            return 0;
        }
        int videoWidth = this.RYa.getVideoWidth();
        AppMethodBeat.o(188974);
        return videoWidth;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoHeight() {
        AppMethodBeat.i(188975);
        this.RVN.info("getVideoHeight");
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188975);
            return 0;
        }
        int videoHeight = this.RYa.getVideoHeight();
        AppMethodBeat.o(188975);
        return videoHeight;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPTrackInfo[] getTrackInfo() {
        AppMethodBeat.i(188976);
        this.RVN.info("getTrackInfo");
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188976);
            return null;
        }
        TPMediaTrackInfo[] trackInfo = this.RYa.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            AppMethodBeat.o(188976);
            return null;
        }
        TPTrackInfo[] tPTrackInfoArr = new TPTrackInfo[trackInfo.length];
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            TPMediaTrackInfo tPMediaTrackInfo = trackInfo[i2];
            TPTrackInfo tPTrackInfo = new TPTrackInfo();
            tPTrackInfo.name = tPMediaTrackInfo.trackName;
            tPTrackInfo.trackType = tPMediaTrackInfo.trackType;
            tPTrackInfo.isExclusive = tPMediaTrackInfo.isExclusive;
            tPTrackInfo.isSelected = tPMediaTrackInfo.isSelected;
            tPTrackInfo.isInternal = tPMediaTrackInfo.isInternal;
            tPTrackInfoArr[i2] = tPTrackInfo;
        }
        AppMethodBeat.o(188976);
        return tPTrackInfoArr;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectProgram(int i2, long j2) {
        AppMethodBeat.i(188977);
        this.RVN.info("selectProgram, programIndex:".concat(String.valueOf(i2)));
        if (this.RYa == null) {
            this.RVN.warn("player has released, return");
            AppMethodBeat.o(188977);
            return;
        }
        this.RYa.selectProgramAsync(i2, j2);
        AppMethodBeat.o(188977);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPProgramInfo[] getProgramInfo() {
        TPProgramInfo tPProgramInfo;
        AppMethodBeat.i(188978);
        this.RVN.info("getProgramInfo");
        if (this.RYa == null) {
            this.RVN.info("player has released, return 0");
            AppMethodBeat.o(188978);
            return null;
        }
        TPNativePlayerProgramInfo[] programInfo = this.RYa.getProgramInfo();
        if (programInfo == null || programInfo.length <= 0) {
            AppMethodBeat.o(188978);
            return null;
        }
        TPProgramInfo[] tPProgramInfoArr = new TPProgramInfo[programInfo.length];
        for (int i2 = 0; i2 < programInfo.length; i2++) {
            TPNativePlayerProgramInfo tPNativePlayerProgramInfo = programInfo[i2];
            if (tPNativePlayerProgramInfo != null) {
                tPProgramInfo = new TPProgramInfo();
                tPProgramInfo.name = tPNativePlayerProgramInfo.name;
                tPProgramInfo.bandwidth = tPNativePlayerProgramInfo.bandwidth;
                tPProgramInfo.resolution = tPNativePlayerProgramInfo.resolution;
            } else {
                tPProgramInfo = null;
            }
            tPProgramInfoArr[i2] = tPProgramInfo;
        }
        AppMethodBeat.o(188978);
        return tPProgramInfoArr;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(188979);
        this.RVN.info("captureVideo, params".concat(String.valueOf(tPCaptureParams)));
        if (this.RYe != null) {
            TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
            tPImageGeneratorParams.width = tPCaptureParams.width;
            tPImageGeneratorParams.height = tPCaptureParams.height;
            tPImageGeneratorParams.format = tPCaptureParams.format;
            tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
            tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
            this.RYe.a(getCurrentPositionMs(), tPImageGeneratorParams, tPCaptureCallBack);
            AppMethodBeat.o(188979);
            return;
        }
        tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
        AppMethodBeat.o(188979);
    }

    private void hnc() {
        AppMethodBeat.i(188980);
        if (this.RYa == null) {
            IllegalStateException illegalStateException = new IllegalStateException("player has release");
            AppMethodBeat.o(188980);
            throw illegalStateException;
        }
        AppMethodBeat.o(188980);
    }

    class a extends Handler {
        private WeakReference<b> phi;

        public a(Looper looper, b bVar) {
            super(looper);
            AppMethodBeat.i(188924);
            this.phi = new WeakReference<>(bVar);
            AppMethodBeat.o(188924);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(188925);
            if (this.phi.get() == null) {
                b.this.RVN.error("mWeakRef is null");
                AppMethodBeat.o(188925);
                return;
            }
            switch (message.what) {
                case 1:
                    C2200b bVar = (C2200b) message.obj;
                    switch (bVar.RYm) {
                        case 1:
                            b.this.RYd.tf();
                            AppMethodBeat.o(188925);
                            return;
                        case 2:
                            b.this.RYd.cJH();
                            AppMethodBeat.o(188925);
                            return;
                        default:
                            b.this.RYd.a(com.tencent.thumbplayer.a.b.b.b.ard(bVar.RYm), (long) bVar.dGe, (long) bVar.errorCode, Long.valueOf(bVar.RVK));
                            AppMethodBeat.o(188925);
                            return;
                    }
                case 2:
                    d dVar = (d) message.obj;
                    switch (dVar.infoType) {
                        case 154:
                            b.this.RYd.onCompletion();
                            AppMethodBeat.o(188925);
                            return;
                        case 250:
                            b bVar2 = b.this;
                            bVar2.RYd.aI(dVar.lParam1, dVar.RYn);
                            AppMethodBeat.o(188925);
                            return;
                        default:
                            b bVar3 = b.this;
                            int i2 = dVar.infoType;
                            int ard = com.tencent.thumbplayer.a.b.b.b.ard(i2);
                            if (ard < 0) {
                                bVar3.RVN.warn("msgType:" + i2 + ", cannot convert to thumbPlayer Info");
                                AppMethodBeat.o(188925);
                                return;
                            }
                            long j2 = dVar.lParam1;
                            long j3 = dVar.RYn;
                            switch (ard) {
                                case 203:
                                case 204:
                                    j2 = (long) c.aqZ((int) dVar.lParam1);
                                    break;
                            }
                            bVar3.RYd.a(ard, j2, j3, (Object) null);
                            AppMethodBeat.o(188925);
                            return;
                    }
                case 3:
                    e eVar = (e) message.obj;
                    switch (eVar.infoType) {
                        case 502:
                            if (eVar.RYo instanceof String) {
                                b.this.RYf.subtitleData = (String) eVar.RYo;
                                b.this.RYd.a(b.this.RYf);
                                AppMethodBeat.o(188925);
                                return;
                            }
                            break;
                        default:
                            b bVar4 = b.this;
                            int i3 = eVar.infoType;
                            int ard2 = com.tencent.thumbplayer.a.b.b.b.ard(i3);
                            if (ard2 >= 0) {
                                Object obj = eVar.RYo;
                                switch (ard2) {
                                    case 500:
                                        if (eVar.RYo != null) {
                                            obj = c.a((ITPNativePlayerMessageCallback.VideoCropInfo) eVar.RYo);
                                            break;
                                        }
                                        break;
                                    case 502:
                                        if (eVar.RYo != null) {
                                            obj = c.a((ITPNativePlayerMessageCallback.MediaCodecInfo) eVar.RYo);
                                            break;
                                        }
                                        break;
                                }
                                bVar4.RYd.a(ard2, 0, 0, obj);
                                break;
                            } else {
                                bVar4.RVN.warn("msgType:" + i3 + ", cannot convert to thumbPlayer Info");
                                AppMethodBeat.o(188925);
                                return;
                            }
                    }
                    AppMethodBeat.o(188925);
                    return;
                case 4:
                    c cVar = (c) message.obj;
                    int i4 = cVar.msgType;
                    b.this.RYd.a(com.tencent.thumbplayer.a.b.b.b.arc(i4), cVar.errorCode, 0, 0);
                    AppMethodBeat.o(188925);
                    return;
                default:
                    b.this.RVN.warn("message :" + message.what + "  not recognition");
                    AppMethodBeat.o(188925);
                    return;
            }
        }
    }
}

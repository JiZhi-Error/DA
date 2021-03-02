package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u0001:\u0001UB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u0010.\u001a\u0004\u0018\u00010\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u00100\u001a\u0004\u0018\u00010\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u00101\u001a\u0004\u0018\u00010\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u00102\u001a\u0004\u0018\u00010\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u00103\u001a\u0004\u0018\u00010\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0-H\u0002J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0018H\u0002J\u0018\u00107\u001a\u0002082\u0006\u0010\f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0011H\u0002J\u0010\u0010?\u001a\u0002082\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u0002082\u0006\u0010\f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0011H\u0002J8\u0010D\u001a\u00020\u001e2\u0006\u0010C\u001a\u0002082\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u00109\u001a\u00020\u00112\u0006\u0010J\u001a\u00020(H\u0002J\u0016\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u0018H\u0002J\"\u0010O\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u00109\u001a\u00020\u00112\u0006\u0010R\u001a\u00020IH\u0002J\u000e\u0010S\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010T\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u00109\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015Ra\u0010\u0016\u001aI\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "foregroundRemuxFinishCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "", "getForegroundRemuxFinishCallback", "()Lkotlin/jvm/functions/Function3;", "setForegroundRemuxFinishCallback", "(Lkotlin/jvm/functions/Function3;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ab implements t {
    public static final a BRV = new a((byte) 0);
    private com.tencent.mm.plugin.recordvideo.ui.a BRP;
    private com.tencent.mm.media.widget.camerarecordview.b.b BRQ;
    private com.tencent.mm.plugin.recordvideo.b.f BRR;
    f.b BRS = new f.b((byte) 0);
    public q<? super String, ? super String, ? super Boolean, x> BRT;
    private int BRU;
    Context context;
    private boolean enable = true;
    private int[] vRR = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private RecordConfigProvider wdm;

    static {
        AppMethodBeat.i(75676);
        AppMethodBeat.o(75676);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final b BRW = new b();

        static {
            AppMethodBeat.i(75647);
            AppMethodBeat.o(75647);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements m<Boolean, String, x> {
        final /* synthetic */ ab BRX;
        final /* synthetic */ AudioCacheInfo BRY;
        final /* synthetic */ kotlin.g.a.a ihE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ab abVar, AudioCacheInfo audioCacheInfo, kotlin.g.a.a aVar) {
            super(2);
            this.BRX = abVar;
            this.BRY = audioCacheInfo;
            this.ihE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(75649);
            boolean booleanValue = bool.booleanValue();
            Log.i("MicroMsg.RemuxPlugin", "cacheAudio callback success ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                this.BRY.aXa = true;
                this.ihE.invoke();
                com.tencent.mm.plugin.recordvideo.ui.a aVar = this.BRX.BRP;
                if (aVar != null) {
                    AnonymousClass1 r0 = AnonymousClass1.BRZ;
                    p.h(r0, "onCancel");
                    aVar.BYB = r0;
                }
            } else {
                com.tencent.f.h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.recordvideo.plugin.ab.c.AnonymousClass2 */
                    final /* synthetic */ c BSa;

                    {
                        this.BSa = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(237352);
                        u.makeText(this.BSa.BRX.context, (int) R.string.hj2, 0).show();
                        AppMethodBeat.o(237352);
                    }
                });
                ab.e(this.BRX);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75649);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final e BSe = new e();

        static {
            AppMethodBeat.i(75651);
            AppMethodBeat.o(75651);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public ab(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(75675);
        this.context = context2;
        AppMethodBeat.o(75675);
    }

    public static final /* synthetic */ VideoMixer a(ab abVar, com.tencent.mm.plugin.recordvideo.b.f fVar, f.b bVar) {
        AppMethodBeat.i(75678);
        VideoMixer a2 = abVar.a(fVar, bVar);
        AppMethodBeat.o(75678);
        return a2;
    }

    public static final /* synthetic */ void a(ab abVar, VideoMixer videoMixer, com.tencent.mm.plugin.recordvideo.b.f fVar, f.b bVar) {
        AppMethodBeat.i(75679);
        abVar.a(videoMixer, fVar, bVar);
        AppMethodBeat.o(75679);
    }

    public static final /* synthetic */ void a(ab abVar, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(75683);
        abVar.b(captureVideoNormalModel);
        AppMethodBeat.o(75683);
    }

    public static final /* synthetic */ void aLs(String str) {
        AppMethodBeat.i(75681);
        aLr(str);
        AppMethodBeat.o(75681);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237353);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237353);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar, RecordConfigProvider recordConfigProvider) {
        String str;
        AppMethodBeat.i(75665);
        p.h(bVar, "info");
        p.h(recordConfigProvider, "configProvider");
        this.BRQ = bVar;
        this.wdm = recordConfigProvider;
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(bVar.iqf));
        if (bVar.iqf) {
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CAPUTRE_VIDEO_PATH_STRING", bVar.aQq());
            com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            if (bVar.aQp()) {
                str = bVar.iqe;
            } else {
                str = bVar.iqi;
            }
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CAPUTRE_THUMB_PATH_STRING", str);
        }
        AppMethodBeat.o(75665);
    }

    public final void a(com.tencent.mm.plugin.recordvideo.b.f fVar) {
        ab X;
        ab Y;
        ab Z;
        AppMethodBeat.i(75666);
        p.h(fVar, "editConfig");
        Log.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
        ab W = W(new h(this));
        if (W != null) {
            W.BRR = fVar;
            W.BRS = fVar.a(W.wdm, W.BRQ);
            Log.i("MicroMsg.RemuxPlugin", "configProvider : " + W.wdm);
            Log.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(fVar)));
            Log.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + W.BRQ);
            Log.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + W.BRS + ' ');
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(W.BRS.BNu));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNX();
            if (W.BRS.BNu) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNW();
            }
            if (!(W == null || (X = W.X(i.BSn)) == null)) {
                com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.d(X.BRQ);
                if (!(X == null || (Y = X.Y(j.BSo)) == null || (Z = Y.Z(k.BSp)) == null)) {
                    Z.aa(l.BSq);
                    AppMethodBeat.o(75666);
                    return;
                }
            }
        }
        AppMethodBeat.o(75666);
    }

    private final ab W(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(163435);
        if (this.wdm == null || !this.enable) {
            aVar.invoke();
            AppMethodBeat.o(163435);
            return null;
        }
        this.enable = false;
        AppMethodBeat.o(163435);
        return this;
    }

    private final ab X(kotlin.g.a.a<x> aVar) {
        com.tencent.mm.media.widget.camerarecordview.b.b bVar;
        RecordConfigProvider recordConfigProvider;
        RecordConfigProvider recordConfigProvider2;
        RecordConfigProvider recordConfigProvider3;
        VideoTransPara videoTransPara;
        VideoTransPara videoTransPara2;
        VideoTransPara videoTransPara3;
        RecordConfigProvider recordConfigProvider4;
        VideoTransPara videoTransPara4;
        VideoTransPara videoTransPara5;
        AppMethodBeat.i(163436);
        if (!this.BRS.BNu && (bVar = this.BRQ) != null && bVar.aQo()) {
            RecordConfigProvider recordConfigProvider5 = this.wdm;
            if (!(((recordConfigProvider5 == null || (videoTransPara5 = recordConfigProvider5.BOm) == null || videoTransPara5.iTg != 1) && ((recordConfigProvider4 = this.wdm) == null || (videoTransPara4 = recordConfigProvider4.BOm) == null || videoTransPara4.iTg != 2)) || (((recordConfigProvider = this.wdm) == null || (videoTransPara3 = recordConfigProvider.BOm) == null || videoTransPara3.iTq != 1) && (((recordConfigProvider2 = this.wdm) == null || (videoTransPara2 = recordConfigProvider2.BOm) == null || videoTransPara2.iTq != 2) && ((recordConfigProvider3 = this.wdm) == null || (videoTransPara = recordConfigProvider3.BOm) == null || videoTransPara.iTq != 4))))) {
                com.tencent.mm.plugin.recordvideo.b.f fVar = this.BRR;
                if (fVar == null) {
                    p.hyc();
                }
                VideoMixer a2 = a(fVar, this.BRS);
                AdaptiveAdjustBitrate adaptiveAdjustBitrate = a2.BKJ;
                if (adaptiveAdjustBitrate != null) {
                    adaptiveAdjustBitrate.BNq = 3000;
                }
                int eJe = a2.eJe();
                Log.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(eJe)));
                if (eJe == 0) {
                    aVar.invoke();
                    com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                    com.tencent.mm.plugin.recordvideo.d.g.VO(1);
                    com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                    com.tencent.mm.plugin.recordvideo.d.g.VN(1);
                    AppMethodBeat.o(163436);
                    return this;
                }
                int[] iArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                StringBuilder sb = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BRQ;
                if (bVar2 == null) {
                    p.hyc();
                }
                Log.i("MicroMsg.RemuxPlugin", sb.append(bVar2.iqh).toString());
                com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = this.BRQ;
                if (bVar3 == null) {
                    p.hyc();
                }
                SightVideoJNI.addReportMetadata(bVar3.iqh, iArr, 1, 0);
                com.tencent.mm.plugin.recordvideo.d.g gVar3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.VN(0);
            }
            com.tencent.mm.plugin.recordvideo.d.g gVar4 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
            com.tencent.mm.plugin.recordvideo.d.g.VO(0);
            RecordConfigProvider recordConfigProvider6 = this.wdm;
            if (recordConfigProvider6 != null) {
                StringBuilder sb2 = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar4 = this.BRQ;
                if (bVar4 == null) {
                    p.hyc();
                }
                StringBuilder append = sb2.append(bVar4.iqh).append(", daemonVideoSize = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar5 = this.BRQ;
                if (bVar5 == null) {
                    p.hyc();
                }
                StringBuilder append2 = append.append(s.boW(bVar5.iqh)).append(", \nsourceVideoPath = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar6 = this.BRQ;
                if (bVar6 == null) {
                    p.hyc();
                }
                StringBuilder append3 = append2.append(bVar6.iqd).append(", captureSize = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar7 = this.BRQ;
                if (bVar7 == null) {
                    p.hyc();
                }
                Log.i("MicroMsg.RemuxPlugin", append3.append(s.boW(bVar7.iqd)).append(", \noutputSize = ").append(recordConfigProvider6.BOA).append(", outputSize = ").append(s.boW(recordConfigProvider6.BOA)).toString());
                com.tencent.mm.media.widget.camerarecordview.b.b bVar8 = this.BRQ;
                if (bVar8 == null) {
                    p.hyc();
                }
                s.nw(bVar8.iqh, recordConfigProvider6.BOA);
                com.tencent.mm.media.widget.camerarecordview.b.b bVar9 = this.BRQ;
                if (bVar9 == null) {
                    p.hyc();
                }
                s.nw(bVar9.iqi, recordConfigProvider6.thumbPath);
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.d(this.BRQ);
                com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.f(recordConfigProvider6);
                Log.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.BRQ);
                StringBuilder sb3 = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar10 = this.BRQ;
                if (bVar10 == null) {
                    p.hyc();
                }
                StringBuilder append4 = sb3.append(bVar10.iqh).append(", daemonVideoSize = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar11 = this.BRQ;
                if (bVar11 == null) {
                    p.hyc();
                }
                StringBuilder append5 = append4.append(s.boW(bVar11.iqh)).append(", \nsourceVideoPath = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar12 = this.BRQ;
                if (bVar12 == null) {
                    p.hyc();
                }
                StringBuilder append6 = append5.append(bVar12.iqd).append(", captureSize = ");
                com.tencent.mm.media.widget.camerarecordview.b.b bVar13 = this.BRQ;
                if (bVar13 == null) {
                    p.hyc();
                }
                Log.i("MicroMsg.RemuxPlugin", append6.append(s.boW(bVar13.iqd)).append(", \noutputSize = ").append(recordConfigProvider6.BOA).append(", outputSize = ").append(s.boW(recordConfigProvider6.BOA)).toString());
                String str = recordConfigProvider6.BOA;
                p.g(str, "this.outputVideoPath");
                String str2 = recordConfigProvider6.thumbPath;
                p.g(str2, "this.thumbPath");
                jC(str, str2);
                String str3 = recordConfigProvider6.BOA;
                p.g(str3, "this.outputVideoPath");
                aLr(str3);
                Boolean bool = Boolean.TRUE;
                String str4 = recordConfigProvider6.BOA;
                String str5 = recordConfigProvider6.thumbPath;
                com.tencent.mm.media.widget.camerarecordview.b.b bVar14 = this.BRQ;
                if (bVar14 == null) {
                    p.hyc();
                }
                int i2 = bVar14.iqk;
                com.tencent.mm.media.widget.camerarecordview.b.b bVar15 = this.BRQ;
                if (bVar15 == null) {
                    p.hyc();
                }
                Long valueOf = Long.valueOf((long) (i2 - bVar15.iqj));
                Boolean bool2 = Boolean.FALSE;
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                b(new CaptureDataManager.CaptureVideoNormalModel(bool, str4, str5, valueOf, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
                com.tencent.mm.plugin.recordvideo.d.g gVar5 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.ax(1, 1);
                AppMethodBeat.o(163436);
                return null;
            }
        }
        aVar.invoke();
        AppMethodBeat.o(163436);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (com.tencent.mm.media.b.b.aLP() != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tencent.mm.plugin.recordvideo.plugin.ab Y(kotlin.g.a.a<kotlin.x> r11) {
        /*
        // Method dump skipped, instructions count: 385
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.ab.Y(kotlin.g.a.a):com.tencent.mm.plugin.recordvideo.plugin.ab");
    }

    private final ab Z(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(163438);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null || !p.j(recordConfigProvider.BOt, Boolean.TRUE)) {
            aVar.invoke();
            AppMethodBeat.o(163438);
            return this;
        }
        com.tencent.mm.plugin.recordvideo.b.f fVar = this.BRR;
        if (fVar == null) {
            p.hyc();
        }
        VideoMixer a2 = a(fVar, this.BRS);
        com.tencent.mm.plugin.recordvideo.d.f fVar2 = com.tencent.mm.plugin.recordvideo.d.f.BXU;
        com.tencent.mm.plugin.recordvideo.d.f.to(true);
        com.tencent.mm.plugin.recordvideo.b.f fVar3 = this.BRR;
        if (fVar3 == null) {
            p.hyc();
        }
        a(a2, fVar3, this.BRS);
        AppMethodBeat.o(163438);
        return null;
    }

    private final ab aa(kotlin.g.a.a<x> aVar) {
        boolean z;
        AppMethodBeat.i(163439);
        com.tencent.mm.plugin.recordvideo.d.f fVar = com.tencent.mm.plugin.recordvideo.d.f.BXU;
        com.tencent.mm.plugin.recordvideo.d.f.to(false);
        com.tencent.mm.plugin.recordvideo.b.f fVar2 = this.BRR;
        if (fVar2 == null) {
            p.hyc();
        }
        VideoMixer a2 = a(fVar2, this.BRS);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider != null) {
            z.f fVar3 = new z.f();
            fVar3.SYG = (T) new ald();
            T t = fVar3.SYG;
            com.tencent.mm.plugin.recordvideo.b.f fVar4 = this.BRR;
            if (fVar4 == null) {
                p.hyc();
            }
            int i2 = fVar4.BNq;
            com.tencent.mm.plugin.recordvideo.b.f fVar5 = this.BRR;
            if (fVar5 == null) {
                p.hyc();
            }
            t.duration = (long) (i2 - fVar5.BNp);
            fVar3.SYG.Luc = new LinkedList<>(kotlin.a.e.W(this.vRR));
            T t2 = fVar3.SYG;
            VideoTransPara videoTransPara = recordConfigProvider.BOm;
            Integer valueOf = videoTransPara != null ? Integer.valueOf(videoTransPara.iTg) : null;
            if (valueOf == null) {
                p.hyc();
            }
            t2.iTg = valueOf.intValue();
            T t3 = fVar3.SYG;
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BRQ;
            if (bVar != null) {
                z = bVar.iqf;
            } else {
                z = false;
            }
            t3.Lud = z;
            fVar3.SYG.Gvu = this.BRS.BNu;
            fVar3.SYG.BOx = recordConfigProvider.BOx;
            fVar3.SYG.BOy = recordConfigProvider.BOy;
            fVar3.SYG.BOz = recordConfigProvider.BOz;
            fVar3.SYG.BOA = recordConfigProvider.BOA;
            fVar3.SYG.Lue = recordConfigProvider.thumbPath;
            fVar3.SYG.BLF = a2.BKP.iiC;
            fVar3.SYG.Luf = 0;
            com.tencent.mm.plugin.recordvideo.b.f fVar6 = this.BRR;
            if (fVar6 == null) {
                p.hyc();
            }
            a(fVar6.wgG, new d(recordConfigProvider, fVar3, this, a2));
            com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
            com.tencent.mm.plugin.recordvideo.d.g.VP(0);
            AppMethodBeat.o(163439);
            return null;
        }
        aVar.invoke();
        AppMethodBeat.o(163439);
        return this;
    }

    private static void aLr(String str) {
        AppMethodBeat.i(75667);
        long currentTicks = Util.currentTicks();
        SightVideoJNI.optimizeMP4VFS(str);
        Log.d("MicroMsg.RemuxPlugin", "time cost: " + Util.ticksToNow(currentTicks));
        AppMethodBeat.o(75667);
    }

    private final VideoMixer a(com.tencent.mm.plugin.recordvideo.b.f fVar, f.b bVar) {
        float a2;
        VideoTransPara videoTransPara;
        AppMethodBeat.i(75668);
        VideoMixer b2 = b(fVar);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null || recordConfigProvider.scene != 2) {
            RecordConfigProvider recordConfigProvider2 = this.wdm;
            a2 = recordConfigProvider2 != null ? recordConfigProvider2.scene == 1 ? ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_generate_multiple_kbps, 1.0f) : 1.0f : 1.0f;
        } else {
            a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_generate_multiple_kbps, 1.0f);
        }
        Log.i("MicroMsg.RemuxPlugin", "final kbps: " + a2 + "  " + (((float) bVar.videoBitrate) * a2));
        VideoMixer.a(b2, bVar.targetWidth, bVar.targetHeight, (int) (a2 * ((float) bVar.videoBitrate)), bVar.audioBitrate, bVar.audioSampleRate, bVar.audioChannelCount, bVar.frameRate, bVar.ihS);
        RecordConfigProvider recordConfigProvider3 = this.wdm;
        if (recordConfigProvider3 != null) {
            videoTransPara = recordConfigProvider3.BOm;
        } else {
            videoTransPara = null;
        }
        if (videoTransPara == null) {
            p.hyc();
        }
        b2.a(videoTransPara, fVar.BNq, fVar.BNp);
        AppMethodBeat.o(75668);
        return b2;
    }

    private final void a(VideoMixer videoMixer, com.tencent.mm.plugin.recordvideo.b.f fVar, f.b bVar) {
        AppMethodBeat.i(75669);
        if (this.BRP == null) {
            com.tencent.mm.plugin.recordvideo.ui.a aVar = new com.tencent.mm.plugin.recordvideo.ui.a();
            aVar.b(this.context, e.BSe);
            this.BRP = aVar;
        }
        com.tencent.mm.plugin.recordvideo.background.f fVar2 = com.tencent.mm.plugin.recordvideo.background.f.BKw;
        com.tencent.mm.plugin.recordvideo.background.f.V(new f(this, bVar, videoMixer, fVar));
        AppMethodBeat.o(75669);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ ald BKB;
        final /* synthetic */ ab BRX;
        final /* synthetic */ f.b BSf;
        final /* synthetic */ VideoMixer BSg;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.b.f BSk;
        final /* synthetic */ long BSl;

        g(ab abVar, VideoMixer videoMixer, f.b bVar, com.tencent.mm.plugin.recordvideo.b.f fVar, ald ald, long j2, int i2) {
            this.BRX = abVar;
            this.BSg = videoMixer;
            this.BSf = bVar;
            this.BSk = fVar;
            this.BKB = ald;
            this.BSl = j2;
            this.$scene = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x039e  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x03d5  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x045a  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x046b  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x0483  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x036a  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0373  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 1579
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.ab.g.run():void");
        }
    }

    private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f fVar) {
        String str;
        String str2;
        boolean z;
        int i2;
        VideoTransPara videoTransPara;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(75670);
        long currentTimeMillis = System.currentTimeMillis();
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null || (str = recordConfigProvider.BOA) == null) {
            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            str = com.tencent.mm.plugin.recordvideo.e.c.aLL(String.valueOf(currentTimeMillis));
        }
        RecordConfigProvider recordConfigProvider2 = this.wdm;
        if (recordConfigProvider2 == null || (str2 = recordConfigProvider2.thumbPath) == null) {
            com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            str2 = com.tencent.mm.plugin.recordvideo.e.c.aLM(String.valueOf(currentTimeMillis));
        }
        RecordConfigProvider recordConfigProvider3 = this.wdm;
        int i5 = recordConfigProvider3 != null ? recordConfigProvider3.scene : 0;
        boolean z4 = false;
        if (i5 == 2 || i5 == 11) {
            boolean z5 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_video_edit_remux_encoder_usex264, 0) == 1;
            int i6 = ae.gKA.gJo;
            z4 = i6 != -1 ? i6 == 1 : z5;
            Log.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + z5 + ", deviceUseX264Encode:" + i6);
        } else if (i5 == 1) {
            boolean z6 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_video_edit_remux_encoder_usex264, 0) == 1;
            int i7 = ae.gKA.gJn;
            z4 = i7 != -1 ? i7 == 1 : z6;
            Log.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + z6 + ", deviceUseX264Encode:" + i7);
        }
        if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
            z4 = true;
        }
        Log.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(z4)));
        com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.ts(z4);
        com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.tt(com.tencent.mm.plugin.sight.base.b.eVr());
        boolean z7 = false;
        if (i5 == 2 || i5 == 1) {
            switch (i5) {
                case 1:
                    i3 = ae.gKA.gJy;
                    break;
                case 2:
                    i3 = ae.gKA.gJz;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            switch (i5) {
                case 1:
                    i4 = ae.gKA.gJw;
                    break;
                case 2:
                    i4 = ae.gKA.gJx;
                    break;
                default:
                    i4 = -1;
                    break;
            }
            switch (i5) {
                case 1:
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remux_c2c_sw_hevc_encode_enable, 0) != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case 2:
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remux_sns_sw_hevc_encode_enable, 0) != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                default:
                    z2 = false;
                    break;
            }
            switch (i5) {
                case 1:
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remux_c2c_hw_hevc_encode_enable, 0) != 1) {
                        z3 = false;
                        break;
                    } else {
                        z3 = true;
                        break;
                    }
                case 2:
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remux_sns_hw_hevc_encode_enable, 0) != 1) {
                        z3 = false;
                        break;
                    } else {
                        z3 = true;
                        break;
                    }
                default:
                    z3 = false;
                    break;
            }
            Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, deviceSwEnableHevc:" + i3 + ", deviceHwEnableHevc:" + i4 + ", exptSwEnableHevc:" + z2 + ", exptHwEnableHevc:" + z3);
            boolean z8 = false;
            boolean z9 = false;
            if (z2 || i3 != -1) {
                if (i3 == 1) {
                    z8 = true;
                } else {
                    z8 = (!z2 || i3 != 2) ? z2 : false;
                }
            }
            if (z3 || i4 != -1) {
                if (i4 == 1) {
                    z9 = true;
                } else {
                    z9 = (!z3 || i4 != 2) ? z3 : false;
                }
            }
            boolean z10 = false;
            if (z4) {
                z10 = z8;
            } else if (z8) {
                z4 = true;
                z10 = true;
            } else if (z9) {
                z10 = true;
            }
            Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + z9 + ", swEnableHevc:" + z8 + ", enableHevc:" + z10 + ", useSoftEncode:" + z4);
            z7 = z10;
            z = z4;
        } else {
            z = z4;
        }
        com.tencent.mm.plugin.recordvideo.b.c c2 = c(fVar);
        if (i5 == 3 && !s.YS(c2.BMT)) {
            com.tencent.mm.plugin.recordvideo.d.e eVar = com.tencent.mm.plugin.recordvideo.d.e.BXT;
            com.tencent.mm.plugin.recordvideo.d.e.tn(c2.iqf);
        }
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList = fVar.BNn;
        float[] fArr = fVar.BKV;
        float[] fArr2 = fVar.BKW;
        RecordConfigProvider recordConfigProvider4 = this.wdm;
        if (recordConfigProvider4 == null || (videoTransPara = recordConfigProvider4.BOm) == null) {
            i2 = 0;
        } else {
            i2 = videoTransPara.iTf;
        }
        String str3 = fVar.BLa;
        if (str3 == null) {
            str3 = "";
        }
        VideoMixer videoMixer = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(c2, arrayList, fArr, fArr2, str, str2, 0, z, z7, i2, str3, 64));
        AppMethodBeat.o(75670);
        return videoMixer;
    }

    private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f fVar) {
        String str;
        String str2;
        int i2;
        boolean z = true;
        AppMethodBeat.i(75671);
        com.tencent.mm.plugin.recordvideo.b.c cVar = new com.tencent.mm.plugin.recordvideo.b.c();
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BRQ;
        if (bVar == null || (str = bVar.iqd) == null) {
            str = "";
        }
        cVar.aLo(str);
        com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BRQ;
        if (bVar2 == null || (str2 = bVar2.iqe) == null) {
            str2 = "";
        }
        cVar.aLp(str2);
        cVar.uPh = fVar.wgG;
        if (fVar.BNc) {
            if (cVar.uPh == null) {
                i2 = 0;
            } else {
                i2 = 2;
            }
        } else if (cVar.uPh == null) {
            i2 = 1;
        } else {
            i2 = 3;
        }
        cVar.BMY = i2;
        com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = this.BRQ;
        if (bVar3 != null) {
            z = bVar3.iqf;
        }
        cVar.iqf = z;
        cVar.ihS = SightVideoJNI.getMp4RotateVFS(cVar.BMT);
        cVar.BMV = (long) fVar.BNp;
        cVar.BMW = (long) fVar.BNq;
        cVar.aI(fVar.BNr);
        Log.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(cVar)));
        AppMethodBeat.o(75671);
        return cVar;
    }

    private final void b(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(75672);
        MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
        CaptureDataManager.BOb.a(this.context, captureVideoNormalModel);
        AppMethodBeat.o(75672);
    }

    private final void jC(String str, String str2) {
        int i2;
        VideoTransPara videoTransPara;
        AppMethodBeat.i(75673);
        if (s.YS(str2)) {
            s.deleteFile(str2);
        }
        Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
        if (PF != null) {
            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            RecordConfigProvider recordConfigProvider = this.wdm;
            if (recordConfigProvider == null || (videoTransPara = recordConfigProvider.BOm) == null) {
                i2 = 0;
            } else {
                i2 = videoTransPara.iTf;
            }
            BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.recordvideo.e.c.j(PF, i2), 60, Bitmap.CompressFormat.JPEG, str2, true);
        }
        AppMethodBeat.o(75673);
    }

    private final void a(f.b bVar) {
        int i2;
        int i3;
        String str;
        AppMethodBeat.i(75674);
        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOh();
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.RemuxPlugin", "start forceRemux");
        RecordConfigProvider recordConfigProvider = this.wdm;
        String I = p.I(recordConfigProvider != null ? recordConfigProvider.BOA : null, "_tmp");
        RecordConfigProvider recordConfigProvider2 = this.wdm;
        if (recordConfigProvider2 == null) {
            p.hyc();
        }
        if (recordConfigProvider2.BOm.iTh == 2) {
            Object[] objArr = new Object[2];
            RecordConfigProvider recordConfigProvider3 = this.wdm;
            if (recordConfigProvider3 == null) {
                p.hyc();
            }
            objArr[0] = Integer.valueOf(recordConfigProvider3.BOm.idF);
            RecordConfigProvider recordConfigProvider4 = this.wdm;
            if (recordConfigProvider4 == null) {
                p.hyc();
            }
            objArr[1] = Integer.valueOf(recordConfigProvider4.BOm.idG);
            Log.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", objArr);
            RecordConfigProvider recordConfigProvider5 = this.wdm;
            if (recordConfigProvider5 == null) {
                p.hyc();
            }
            i2 = recordConfigProvider5.BOm.idF;
            RecordConfigProvider recordConfigProvider6 = this.wdm;
            if (recordConfigProvider6 == null) {
                p.hyc();
            }
            i3 = recordConfigProvider6.BOm.idG;
        } else {
            i2 = 0;
            i3 = 51;
        }
        RecordConfigProvider recordConfigProvider7 = this.wdm;
        if (recordConfigProvider7 != null) {
            str = recordConfigProvider7.BOA;
        } else {
            str = null;
        }
        int i4 = bVar.targetWidth;
        int i5 = bVar.targetHeight;
        int i6 = bVar.videoBitrate;
        RecordConfigProvider recordConfigProvider8 = this.wdm;
        if (recordConfigProvider8 == null) {
            p.hyc();
        }
        int i7 = recordConfigProvider8.BOm.iSV;
        RecordConfigProvider recordConfigProvider9 = this.wdm;
        if (recordConfigProvider9 == null) {
            p.hyc();
        }
        int remuxingVFS = SightVideoJNI.remuxingVFS(str, I, i4, i5, i6, i7, 8, recordConfigProvider9.BOm.iSU, 25.0f, (float) bVar.frameRate, null, 0, false, i2, i3);
        RecordConfigProvider recordConfigProvider10 = this.wdm;
        s.nw(I, recordConfigProvider10 != null ? recordConfigProvider10.BOA : null);
        s.deleteFile(I);
        long ticksToNow = Util.ticksToNow(currentTicks);
        Log.i("MicroMsg.RemuxPlugin", "minQP :" + i2 + "  maxQP :" + i3 + "  duration:" + remuxingVFS + " cost:" + ticksToNow);
        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.zM(ticksToNow);
        AppMethodBeat.o(75674);
    }

    private final void a(AudioCacheInfo audioCacheInfo, kotlin.g.a.a<x> aVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(163440);
        StringBuilder sb = new StringBuilder("checkAudioCache audio:");
        if (audioCacheInfo != null) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder append = sb.append(z).append(", cache:");
        if (audioCacheInfo != null) {
            z2 = audioCacheInfo.aXa;
        }
        Log.i("MicroMsg.RemuxPlugin", append.append(z2).toString());
        com.tencent.mm.plugin.recordvideo.ui.a aVar2 = new com.tencent.mm.plugin.recordvideo.ui.a();
        aVar2.b(this.context, b.BRW);
        this.BRP = aVar2;
        if (audioCacheInfo == null || audioCacheInfo.aXa) {
            Log.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
            aVar.invoke();
            AppMethodBeat.o(163440);
            return;
        }
        Log.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
        i.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
        com.tencent.mm.plugin.recordvideo.model.audio.i.eKl().a(this.context, audioCacheInfo, new c(this, audioCacheInfo, aVar));
        AppMethodBeat.o(163440);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab BRX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ab abVar) {
            super(0);
            this.BRX = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75656);
            Log.e("MicroMsg.RemuxPlugin", "notice: configProvider is null  " + this.BRX.enable + "  " + this.BRX.wdm + ' ');
            x xVar = x.SXb;
            AppMethodBeat.o(75656);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final i BSn = new i();

        static {
            AppMethodBeat.i(75658);
            AppMethodBeat.o(75658);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75657);
            Log.i("MicroMsg.RemuxPlugin", "not use DaemonVideo");
            x xVar = x.SXb;
            AppMethodBeat.o(75657);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final j BSo = new j();

        static {
            AppMethodBeat.i(75660);
            AppMethodBeat.o(75660);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75659);
            Log.i("MicroMsg.RemuxPlugin", "not use checkNoNeedRemuxVideo");
            x xVar = x.SXb;
            AppMethodBeat.o(75659);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final k BSp = new k();

        static {
            AppMethodBeat.i(75662);
            AppMethodBeat.o(75662);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75661);
            Log.i("MicroMsg.RemuxPlugin", "not use checkForegroundRemux");
            x xVar = x.SXb;
            AppMethodBeat.o(75661);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final l BSq = new l();

        static {
            AppMethodBeat.i(75664);
            AppMethodBeat.o(75664);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75663);
            Log.i("MicroMsg.RemuxPlugin", "not use checkBackgroundRemux");
            x xVar = x.SXb;
            AppMethodBeat.o(75663);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab BRX;
        final /* synthetic */ RecordConfigProvider BSb;
        final /* synthetic */ z.f BSc;
        final /* synthetic */ VideoMixer BSd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RecordConfigProvider recordConfigProvider, z.f fVar, ab abVar, VideoMixer videoMixer) {
            super(0);
            this.BSb = recordConfigProvider;
            this.BSc = fVar;
            this.BRX = abVar;
            this.BSd = videoMixer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(75650);
            ab abVar = this.BRX;
            VideoMixer videoMixer = this.BSd;
            com.tencent.mm.plugin.recordvideo.b.f fVar = this.BRX.BRR;
            if (fVar == null) {
                p.hyc();
            }
            ab.a(abVar, videoMixer, fVar, this.BSc.SYG, this.BSb.BOF, this.BRX.BRS, this.BSb.scene);
            x xVar = x.SXb;
            AppMethodBeat.o(75650);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab BRX;
        final /* synthetic */ f.b BSf;
        final /* synthetic */ VideoMixer BSg;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.b.f BSh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ab abVar, f.b bVar, VideoMixer videoMixer, com.tencent.mm.plugin.recordvideo.b.f fVar) {
            super(0);
            this.BRX = abVar;
            this.BSf = bVar;
            this.BSg = videoMixer;
            this.BSh = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            VideoTransPara videoTransPara;
            AppMethodBeat.i(75653);
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
            com.tencent.mm.plugin.recordvideo.d.g.Ie(SystemClock.elapsedRealtime());
            final z.d dVar = new z.d();
            dVar.SYE = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "RemuxPlugin");
            Log.i("MicroMsg.RemuxPlugin", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(dVar.SYE));
            float f2 = 1.0f;
            RecordConfigProvider recordConfigProvider = this.BRX.wdm;
            if (recordConfigProvider == null || recordConfigProvider.scene != 2) {
                RecordConfigProvider recordConfigProvider2 = this.BRX.wdm;
                if (recordConfigProvider2 != null && recordConfigProvider2.scene == 1) {
                    f2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_generate_multiple_kbps, 1.0f);
                }
            } else {
                f2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_generate_multiple_kbps, 1.0f);
            }
            Log.i("MicroMsg.RemuxPlugin", "final kbps: " + f2 + "  " + (f2 * ((float) this.BSf.videoBitrate)));
            this.BSg.a(this.BSf.targetWidth, this.BSf.targetHeight, this.BSf.videoBitrate, this.BSf.audioBitrate, this.BSf.audioSampleRate, this.BSf.audioChannelCount, this.BSf.frameRate, this.BSf.ihS, this.BSf.idF, this.BSf.idG);
            VideoMixer videoMixer = this.BSg;
            RecordConfigProvider recordConfigProvider3 = this.BRX.wdm;
            if (recordConfigProvider3 != null) {
                videoTransPara = recordConfigProvider3.BOm;
            } else {
                videoTransPara = null;
            }
            if (videoTransPara == null) {
                p.hyc();
            }
            videoMixer.a(videoTransPara, this.BSh.BNq, this.BSh.BNp);
            RecordConfigProvider recordConfigProvider4 = this.BRX.wdm;
            if (recordConfigProvider4 != null && recordConfigProvider4.BOp == 3) {
                this.BSg.BKK = true;
            }
            this.BSg.e(new r<String, String, Boolean, Integer, x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.ab.f.AnonymousClass1 */
                final /* synthetic */ f BSi;

                {
                    this.BSi = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.r
                public final /* synthetic */ x invoke(String str, String str2, Boolean bool, Integer num) {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    boolean z4 = true;
                    AppMethodBeat.i(75652);
                    String str3 = str;
                    String str4 = str2;
                    boolean booleanValue = bool.booleanValue();
                    num.intValue();
                    p.h(str3, "mixVideoPath");
                    p.h(str4, "mixThumbPath");
                    Log.i("MicroMsg.RemuxPlugin", "mixVideoPath: " + str3 + " ,mixThumbPath: " + str4 + " ,ret: " + booleanValue);
                    q<? super String, ? super String, ? super Boolean, x> qVar = this.BSi.BRX.BRT;
                    if (qVar != null) {
                        qVar.d(str3, str4, Boolean.valueOf(booleanValue));
                    }
                    com.tencent.mm.plugin.recordvideo.background.f fVar = com.tencent.mm.plugin.recordvideo.background.f.BKw;
                    com.tencent.mm.plugin.recordvideo.background.f.eIY();
                    boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remux_fail_use_x264, true);
                    if (booleanValue || !a2) {
                        if (TextUtils.isEmpty(str3)) {
                            com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                            com.tencent.mm.plugin.recordvideo.d.g.VP(1003);
                            Context context = this.BSi.BRX.context;
                            if (context == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(75652);
                                throw tVar;
                            }
                            ((Activity) context).setResult(1003);
                            Context context2 = this.BSi.BRX.context;
                            if (context2 == null) {
                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(75652);
                                throw tVar2;
                            }
                            ((Activity) context2).finish();
                        } else {
                            com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                            d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(str3);
                            Log.i("MicroMsg.RemuxPlugin", "videoInfo : ".concat(String.valueOf(aLQ)));
                            RecordConfigProvider recordConfigProvider = this.BSi.BRX.wdm;
                            if (recordConfigProvider != null && recordConfigProvider.scene == 2) {
                                ab.a(this.BSi.BRX, aLQ, this.BSi.BSf, s.boW(str3));
                                com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                                com.tencent.mm.plugin.recordvideo.d.g.eLf();
                            }
                            if (dVar.SYE != 0) {
                                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, dVar.SYE);
                                Log.i("MicroMsg.RemuxPlugin", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(dVar.SYE));
                                dVar.SYE = 0;
                            }
                            ab.aLs(str3);
                            ab.e(this.BSi.BRX);
                            ab.a(this.BSi.BRX, aLQ, this.BSi.BSf);
                            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                            RecordConfigProvider recordConfigProvider2 = this.BSi.BRX.wdm;
                            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BSi.BRX.BRQ;
                            if (bVar != null) {
                                z = bVar.iqf;
                            } else {
                                z = false;
                            }
                            com.tencent.mm.plugin.recordvideo.e.c.a(recordConfigProvider2, z, this.BSi.BSf.BNu);
                            if (this.BSi.BSf.iTh > 0) {
                                SightVideoJNI.addReportMetadata(str3, this.BSi.BRX.vRR, 0, this.BSi.BSf.iTh);
                            }
                            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_REMUX_VIDEO_COST_MS_INT", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            com.tencent.mm.plugin.recordvideo.d.g gVar3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                            com.tencent.mm.plugin.recordvideo.d.g.If(SystemClock.elapsedRealtime());
                            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSi.BRX.BRQ;
                            if (bVar2 != null) {
                                CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                                p.g(captureDataManager, "CaptureDataManager.INSTANCE");
                                captureDataManager.getExtData().putBoolean("key_is_capture_video", bVar2.iqf);
                                CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                                p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
                                Bundle extData = captureDataManager2.getExtData();
                                ArrayList<String> arrayList = bVar2.iqm;
                                if (arrayList == null || arrayList.isEmpty()) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                extData.putBoolean("key_is_photo_video", z3);
                                ArrayList<String> arrayList2 = bVar2.iqm;
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    z4 = false;
                                }
                                if (!z4) {
                                    CaptureDataManager captureDataManager3 = CaptureDataManager.BOb;
                                    p.g(captureDataManager3, "CaptureDataManager.INSTANCE");
                                    captureDataManager3.getExtData().putStringArrayList("key_src_list", bVar2.iqm);
                                } else {
                                    ArrayList<String> arrayList3 = new ArrayList<>();
                                    arrayList3.add(bVar2.iqd);
                                    CaptureDataManager captureDataManager4 = CaptureDataManager.BOb;
                                    p.g(captureDataManager4, "CaptureDataManager.INSTANCE");
                                    captureDataManager4.getExtData().putStringArrayList("key_src_list", arrayList3);
                                }
                            }
                            com.tencent.mm.plugin.recordvideo.d.g gVar4 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                            com.tencent.mm.plugin.recordvideo.d.g.aLA(str3);
                            com.tencent.mm.plugin.recordvideo.d.g gVar5 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                            com.tencent.mm.plugin.recordvideo.d.g.VP(0);
                            ab abVar = this.BSi.BRX;
                            Boolean valueOf = Boolean.valueOf(booleanValue);
                            Long valueOf2 = Long.valueOf((long) (this.BSi.BSh.BNq - this.BSi.BSh.BNp));
                            Boolean bool2 = Boolean.FALSE;
                            com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                            ab.a(abVar, new CaptureDataManager.CaptureVideoNormalModel(valueOf, str3, str4, valueOf2, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
                        }
                    } else if (this.BSi.BRX.BRU > 0 || !MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
                        com.tencent.mm.plugin.recordvideo.d.g gVar6 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                        com.tencent.mm.plugin.recordvideo.d.g.VP(1002);
                        Context context3 = this.BSi.BRX.context;
                        if (context3 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(75652);
                            throw tVar3;
                        }
                        ((Activity) context3).setResult(1002);
                        Context context4 = this.BSi.BRX.context;
                        if (context4 == null) {
                            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(75652);
                            throw tVar4;
                        }
                        ((Activity) context4).finish();
                    } else {
                        this.BSi.BRX.BRU++;
                        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOa();
                        Log.i("MicroMsg.RemuxPlugin", "markReserveEncoder");
                        ab.a(this.BSi.BRX, ab.a(this.BSi.BRX, this.BSi.BSh, this.BSi.BRX.BRS), this.BSi.BSh, this.BSi.BSf);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(75652);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(75653);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(ab abVar, VideoMixer videoMixer, com.tencent.mm.plugin.recordvideo.b.f fVar, ald ald, long j2, f.b bVar, int i2) {
        AppMethodBeat.i(75677);
        Log.i("MicroMsg.RemuxPlugin", "mix in background");
        com.tencent.f.h.RTc.aX(new g(abVar, videoMixer, bVar, fVar, ald, j2, i2));
        AppMethodBeat.o(75677);
    }

    public static final /* synthetic */ void a(ab abVar, d.a aVar, f.b bVar, long j2) {
        float f2;
        boolean z;
        AppMethodBeat.i(75680);
        Log.i("MicroMsg.RemuxPlugin", "fileSize : " + (((((float) j2) * 1.0f) / 1024.0f) / 1024.0f) + " M fileLength: " + j2 + " Byte   duration:" + (aVar != null ? Integer.valueOf(aVar.duration) : null));
        if (aVar != null) {
            boolean z2 = ae.gKA.gIZ == 1;
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af, "service(IConfigService::class.java)");
            boolean z3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) af).aqJ().getValue("MMSightCheckSendVideoBitrate"), 0) == 1;
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af2, "service(IConfigService::class.java)");
            float f3 = Util.getFloat(((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
            float a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_secondcompress_abaratio, 2.0f);
            if (bVar == null) {
                f2 = f3;
            } else if (bVar.iTh == 2) {
                f2 = a2;
            } else {
                f2 = f3;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(z3);
            objArr[2] = Float.valueOf(f2);
            objArr[3] = Integer.valueOf(aVar.videoBitrate);
            RecordConfigProvider recordConfigProvider = abVar.wdm;
            if (recordConfigProvider == null) {
                p.hyc();
            }
            objArr[4] = Integer.valueOf(recordConfigProvider.BOm.videoBitrate);
            Log.i("MicroMsg.RemuxPlugin", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s, actualBR %s, targetBR: %s", objArr);
            if (z2 || z3) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.Ciq == 0) {
                if (z) {
                    float f4 = (float) aVar.videoBitrate;
                    RecordConfigProvider recordConfigProvider2 = abVar.wdm;
                    if (recordConfigProvider2 == null) {
                        p.hyc();
                    }
                    if (f4 >= f2 * ((float) recordConfigProvider2.BOm.videoBitrate)) {
                        abVar.a(bVar);
                        AppMethodBeat.o(75680);
                        return;
                    }
                }
            } else if (aVar.Ciq > 0 && z) {
                float f5 = (float) aVar.videoBitrate;
                RecordConfigProvider recordConfigProvider3 = abVar.wdm;
                if (recordConfigProvider3 == null) {
                    p.hyc();
                }
                if (f5 >= ((float) recordConfigProvider3.BOm.videoBitrate) * a2) {
                    abVar.a(bVar);
                }
            }
            AppMethodBeat.o(75680);
            return;
        }
        AppMethodBeat.o(75680);
    }

    public static final /* synthetic */ void e(ab abVar) {
        boolean z;
        AppMethodBeat.i(237354);
        if (abVar.context instanceof Activity) {
            Context context2 = abVar.context;
            if (context2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(237354);
                throw tVar;
            } else if (!((Activity) context2).isFinishing()) {
                Context context3 = abVar.context;
                if (context3 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(237354);
                    throw tVar2;
                } else if (!((Activity) context3).isDestroyed()) {
                    com.tencent.mm.plugin.recordvideo.ui.a aVar = abVar.BRP;
                    if (aVar != null) {
                        com.tencent.mm.ui.base.q qVar = aVar.qVq;
                        if (qVar != null) {
                            z = qVar.isShowing();
                        } else {
                            z = false;
                        }
                        if (z) {
                            com.tencent.mm.plugin.recordvideo.ui.a aVar2 = abVar.BRP;
                            if (aVar2 != null) {
                                com.tencent.mm.ui.base.q qVar2 = aVar2.qVq;
                                if (qVar2 != null) {
                                    qVar2.dismiss();
                                }
                                aVar2.qVq = null;
                            }
                            abVar.BRP = null;
                        }
                    } else {
                        AppMethodBeat.o(237354);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(237354);
    }

    public static final /* synthetic */ void a(ab abVar, d.a aVar, f.b bVar) {
        AppMethodBeat.i(75682);
        if (aVar != null) {
            if (bVar.iTh > 0) {
                double d2 = (double) aVar.videoBitrate;
                RecordConfigProvider recordConfigProvider = abVar.wdm;
                if (recordConfigProvider == null) {
                    p.hyc();
                }
                if (d2 >= ((double) recordConfigProvider.BOm.videoBitrate) * 1.1d) {
                    RecordConfigProvider recordConfigProvider2 = abVar.wdm;
                    if (recordConfigProvider2 == null) {
                        p.hyc();
                    }
                    if (recordConfigProvider2.BOm.videoBitrate > 0) {
                        int[] iArr = abVar.vRR;
                        int i2 = aVar.videoBitrate;
                        RecordConfigProvider recordConfigProvider3 = abVar.wdm;
                        if (recordConfigProvider3 == null) {
                            p.hyc();
                        }
                        int i3 = (i2 - recordConfigProvider3.BOm.videoBitrate) * 100;
                        RecordConfigProvider recordConfigProvider4 = abVar.wdm;
                        if (recordConfigProvider4 == null) {
                            p.hyc();
                        }
                        iArr[3] = i3 / recordConfigProvider4.BOm.videoBitrate;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.iTh);
            objArr[1] = Integer.valueOf(aVar.videoBitrate);
            RecordConfigProvider recordConfigProvider5 = abVar.wdm;
            if (recordConfigProvider5 == null) {
                p.hyc();
            }
            objArr[2] = Integer.valueOf(recordConfigProvider5.BOm.videoBitrate);
            objArr[3] = Integer.valueOf(abVar.vRR[3]);
            Log.i("MicroMsg.RemuxPlugin", "steve: qpswitch:%d , actualBR : %d, targetBR: %d, tuneRatio:[%d]", objArr);
            AppMethodBeat.o(75682);
            return;
        }
        AppMethodBeat.o(75682);
    }
}

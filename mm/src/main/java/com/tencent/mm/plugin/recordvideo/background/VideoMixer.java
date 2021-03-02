package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.b.j;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.io.InputStream;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 _2\u00020\u0001:\u0002_`B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020<H\u0002J\u0018\u0010>\u001a\u00020?2\u0006\u00107\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0002J \u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020?H\u0002J \u0010E\u001a\u00020.2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020?H\u0002J\u0016\u0010F\u001a\u00020.2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020.0HH\u0002J\u0018\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\fH\u0002J\u0016\u0010L\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020NJ\n\u0010O\u001a\u0004\u0018\u00010'H\u0002J\u0006\u0010\u0007\u001a\u00020\fJ\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020.H\u0002J\u000e\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020'J\u001e\u0010\t\u001a\u00020.2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\fJ\u0006\u0010Y\u001a\u00020.JZ\u0010Z\u001a\u00020.2\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\b\b\u0002\u00103\u001a\u00020\f2\b\b\u0002\u00102\u001a\u00020\fJl\u0010]\u001a\u00020.2b\u0010^\u001a^\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010&H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000Rj\u0010%\u001a^\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "videoMixData", "Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "(Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blurBgProvider", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "forceResolution", "", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "onFinish", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "getVideoMixData", "()Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", AssetExtension.SCENE_THUMBNAIL, "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"})
public final class VideoMixer implements com.tencent.mm.plugin.recordvideo.background.c.c {
    public static final a BKQ = new a((byte) 0);
    private r<? super String, ? super String, ? super Boolean, ? super Integer, x> BKE;
    private long BKF = -1;
    private com.tencent.mm.plugin.recordvideo.ui.editor.b.a BKG;
    public com.tencent.mm.plugin.recordvideo.ui.editor.b.g BKH;
    private com.tencent.mm.plugin.recordvideo.b.c BKI = this.BKP.BKI;
    public AdaptiveAdjustBitrate BKJ;
    public boolean BKK;
    private final int BKL;
    private final int BKM;
    private final int BKN;
    private HandlerThread BKO;
    public final com.tencent.mm.plugin.recordvideo.background.a.a BKP;
    private int audioBitrate;
    private int audioChannelCount;
    private int audioSampleRate;
    public int ihS;
    public final kotlin.g.a.b<Long, Bitmap> ihf;
    private int iiE;
    private int iiF;
    public final kotlin.g.a.b<Long, Bitmap> iif;
    private final int tvw;
    private int[] vRR;
    private int videoBitrate;
    private int videoFrameRate;
    private int videoHeight;
    private int videoWidth;

    static {
        AppMethodBeat.i(75262);
        AppMethodBeat.o(75262);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Long, Bitmap> {
        final /* synthetic */ VideoMixer BKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VideoMixer videoMixer) {
            super(1);
            this.BKR = videoMixer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Bitmap invoke(Long l) {
            Long l2;
            AppMethodBeat.i(75242);
            long longValue = l.longValue();
            Log.i("MicroMsg.Media.VideoMixer", "get bitmap ".concat(String.valueOf(longValue)));
            while (longValue / 1000 > this.BKR.BKF) {
                com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu = VideoMixer.d(this.BKR).cJu();
                StringBuilder sb = new StringBuilder("get frame ");
                if (cJu != null) {
                    l2 = Long.valueOf(cJu.CgA);
                } else {
                    l2 = null;
                }
                Log.i("MicroMsg.Media.VideoMixer", sb.append(l2).append(" blendBitmapProvider: ").append(longValue).toString());
                if (cJu == null || cJu.CgA <= 0) {
                    break;
                }
                this.BKR.BKF += cJu.CgA;
                this.BKR.BKG = cJu;
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.b.a aVar = this.BKR.BKG;
            if (aVar != null) {
                Bitmap bitmap = aVar.bitmap;
                AppMethodBeat.o(75242);
                return bitmap;
            }
            AppMethodBeat.o(75242);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Long, Bitmap> {
        final /* synthetic */ VideoMixer BKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(VideoMixer videoMixer) {
            super(1);
            this.BKR = videoMixer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Bitmap invoke(Long l) {
            com.tencent.mm.plugin.recordvideo.ui.editor.b.a aVar;
            AppMethodBeat.i(75243);
            l.longValue();
            com.tencent.mm.plugin.recordvideo.ui.editor.b.g d2 = VideoMixer.d(this.BKR);
            if (!d2.eMw() || d2.ikc == null) {
                aVar = null;
            } else {
                Bitmap bitmap = d2.ikc;
                if (bitmap == null) {
                    p.hyc();
                }
                aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(bitmap, 0);
            }
            if (aVar != null) {
                Bitmap bitmap2 = aVar.bitmap;
                AppMethodBeat.o(75243);
                return bitmap2;
            }
            AppMethodBeat.o(75243);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    public static final class d extends q implements m<Boolean, String, x> {
        final /* synthetic */ kotlin.g.a.a ihE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(kotlin.g.a.a aVar) {
            super(2);
            this.ihE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(75244);
            if (bool.booleanValue()) {
                this.ihE.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75244);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ VideoMixer BKR;
        final /* synthetic */ boolean BKS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(VideoMixer videoMixer, boolean z) {
            super(1);
            this.BKR = videoMixer;
            this.BKS = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(75245);
            String str2 = str;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                Log.e("MicroMsg.Media.VideoMixer", "remux failed, ret path is null");
                r rVar = this.BKR.BKE;
                if (rVar != null) {
                    rVar.invoke("", "", Boolean.FALSE, -1);
                }
            } else {
                this.BKR.BKP.aLn(str2);
                VideoMixer.d(this.BKR).destroy();
                try {
                    com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                    d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(this.BKR.BKP.BKX);
                    if (aLQ != null) {
                        com.tencent.mm.plugin.recordvideo.d.f fVar = com.tencent.mm.plugin.recordvideo.d.f.BXU;
                        com.tencent.mm.plugin.recordvideo.d.f.j(this.BKR.BKI.iqf, aLQ.videoBitrate, aLQ.fps);
                    }
                } catch (Exception e2) {
                }
                String f2 = VideoMixer.f(this.BKR);
                if (Util.isNullOrNil(f2)) {
                    Log.i("MicroMsg.Media.VideoMixer", "mix create thumb failed");
                    r rVar2 = this.BKR.BKE;
                    if (rVar2 != null) {
                        rVar2.invoke(this.BKR.BKP.BKX, "", Boolean.FALSE, -1);
                    }
                } else {
                    Log.i("MicroMsg.Media.VideoMixer", "mix create thumb succ");
                    r rVar3 = this.BKR.BKE;
                    if (rVar3 != null) {
                        String str4 = this.BKR.BKP.BKX;
                        if (f2 == null) {
                            p.hyc();
                        }
                        rVar3.invoke(str4, f2, Boolean.TRUE, -1);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75245);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ VideoMixer BKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(VideoMixer videoMixer) {
            super(1);
            this.BKR = videoMixer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AdaptiveAdjustBitrate adaptiveAdjustBitrate;
            AdaptiveAdjustBitrate adaptiveAdjustBitrate2;
            AdaptiveAdjustBitrate adaptiveAdjustBitrate3;
            AdaptiveAdjustBitrate adaptiveAdjustBitrate4;
            AppMethodBeat.i(75246);
            String str2 = str;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                Log.e("MicroMsg.Media.VideoMixer", "remux failed, ret path is null");
                r rVar = this.BKR.BKE;
                if (rVar != null) {
                    rVar.invoke("", "", Boolean.FALSE, -1);
                }
            } else {
                com.tencent.mm.plugin.recordvideo.background.a.a aVar = this.BKR.BKP;
                if (str2 == null) {
                    p.hyc();
                }
                aVar.aLn(str2);
                VideoMixer.d(this.BKR).destroy();
                AdaptiveAdjustBitrate adaptiveAdjustBitrate5 = this.BKR.BKJ;
                if (((adaptiveAdjustBitrate5 != null && adaptiveAdjustBitrate5.iTg == 1) || ((adaptiveAdjustBitrate4 = this.BKR.BKJ) != null && adaptiveAdjustBitrate4.iTg == 2)) && (((adaptiveAdjustBitrate = this.BKR.BKJ) != null && adaptiveAdjustBitrate.iTq == 1) || (((adaptiveAdjustBitrate2 = this.BKR.BKJ) != null && adaptiveAdjustBitrate2.iTq == 2) || ((adaptiveAdjustBitrate3 = this.BKR.BKJ) != null && adaptiveAdjustBitrate3.iTq == 4)))) {
                    String str4 = this.BKR.BKP.BKX;
                    int[] iArr = this.BKR.vRR;
                    AdaptiveAdjustBitrate adaptiveAdjustBitrate6 = this.BKR.BKJ;
                    Integer valueOf = adaptiveAdjustBitrate6 != null ? Integer.valueOf(adaptiveAdjustBitrate6.iTg) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    SightVideoJNI.addReportMetadata(str4, iArr, valueOf.intValue(), 0);
                }
                try {
                    com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                    d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(this.BKR.BKP.BKX);
                    if (aLQ != null) {
                        com.tencent.mm.plugin.recordvideo.d.f fVar = com.tencent.mm.plugin.recordvideo.d.f.BXU;
                        com.tencent.mm.plugin.recordvideo.d.f.j(this.BKR.BKI.iqf, aLQ.videoBitrate, aLQ.fps);
                    }
                } catch (Exception e2) {
                }
                String f2 = VideoMixer.f(this.BKR);
                if (Util.isNullOrNil(f2)) {
                    Log.i("MicroMsg.Media.VideoMixer", "mix create thumb failed");
                    r rVar2 = this.BKR.BKE;
                    if (rVar2 != null) {
                        rVar2.invoke(this.BKR.BKP.BKX, "", Boolean.FALSE, -1);
                    }
                } else {
                    Log.i("MicroMsg.Media.VideoMixer", "mix create thumb succ");
                    r rVar3 = this.BKR.BKE;
                    if (rVar3 != null) {
                        String str5 = this.BKR.BKP.BKX;
                        if (f2 == null) {
                            p.hyc();
                        }
                        rVar3.invoke(str5, f2, Boolean.TRUE, -1);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75246);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "invoke"})
    public static final class g extends q implements r<String, String, Boolean, Integer, x> {
        final /* synthetic */ VideoMixer BKR;
        final /* synthetic */ r BKT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(VideoMixer videoMixer, r rVar) {
            super(4);
            this.BKR = videoMixer;
            this.BKT = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, String str2, Boolean bool, Integer num) {
            AppMethodBeat.i(182837);
            String str3 = str;
            String str4 = str2;
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            p.h(str3, "mixVideo");
            p.h(str4, "mixThumb");
            r rVar = this.BKT;
            if (rVar != null) {
                rVar.invoke(str3, str4, Boolean.valueOf(booleanValue), Integer.valueOf(intValue));
            }
            HandlerThread handlerThread = this.BKR.BKO;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            Log.i("MicroMsg.Media.VideoMixer", "[onFinish] quit mixThread=" + this.BKR.BKO);
            x xVar = x.SXb;
            AppMethodBeat.o(182837);
            return xVar;
        }
    }

    public VideoMixer(com.tencent.mm.plugin.recordvideo.background.a.a aVar) {
        p.h(aVar, "videoMixData");
        AppMethodBeat.i(237246);
        this.BKP = aVar;
        int[] iArr = new int[34];
        for (int i2 = 0; i2 < 34; i2++) {
            iArr[i2] = 0;
        }
        this.vRR = iArr;
        this.BKL = 1;
        this.BKM = 2;
        this.BKN = 3;
        this.tvw = 4;
        Log.i("MicroMsg.Media.VideoMixer", "create VideoMixer, " + this.BKP);
        this.ihf = new b(this);
        this.iif = new c(this);
        AppMethodBeat.o(237246);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.ui.editor.b.g d(VideoMixer videoMixer) {
        AppMethodBeat.i(237247);
        com.tencent.mm.plugin.recordvideo.ui.editor.b.g gVar = videoMixer.BKH;
        if (gVar == null) {
            p.btv("frameRetriever");
        }
        AppMethodBeat.o(237247);
        return gVar;
    }

    public static final /* synthetic */ String f(VideoMixer videoMixer) {
        AppMethodBeat.i(75265);
        String eJd = videoMixer.eJd();
        AppMethodBeat.o(75265);
        return eJd;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.c.c
    public final void e(r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar) {
        AppMethodBeat.i(75249);
        Log.i("MicroMsg.Media.VideoMixer", "Start mixer " + Util.getStack());
        this.BKE = new g(this, rVar);
        h hVar = new h(this);
        if (this.BKP.BKI.uPh != null) {
            AudioCacheInfo audioCacheInfo = this.BKP.BKI.uPh;
            if (audioCacheInfo == null) {
                p.hyc();
            }
            if (!audioCacheInfo.aXa) {
                i.a aVar = i.BPL;
                i iVar = i.BPK;
                AudioCacheInfo audioCacheInfo2 = this.BKP.BKI.uPh;
                if (audioCacheInfo2 == null) {
                    p.hyc();
                }
                iVar.a(audioCacheInfo2, new d(hVar));
                AppMethodBeat.o(75249);
                return;
            }
        }
        hVar.invoke();
        AppMethodBeat.o(75249);
    }

    private final String eJd() {
        Bitmap bitmap;
        int width;
        int i2;
        boolean z = true;
        AppMethodBeat.i(75250);
        Bitmap ba = com.tencent.mm.plugin.mmsight.d.ba(this.BKP.BKX, 200000);
        if (ba != null) {
            try {
                Log.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + s.boZ(this.BKP.BKY) + "  thumb size:" + this.BKP.BKZ);
                s.deleteDir(this.BKP.BKY);
                int i3 = this.BKP.BKZ;
                if (i3 <= 0 || Math.min(ba.getWidth(), ba.getHeight()) <= i3) {
                    bitmap = ba;
                } else {
                    if (ba.getWidth() < ba.getHeight()) {
                        i2 = (int) ((((float) (ba.getHeight() * i3)) * 1.0f) / ((float) ba.getWidth()));
                        width = i3;
                    } else {
                        width = (int) ((((float) (ba.getWidth() * i3)) * 1.0f) / ((float) ba.getHeight()));
                        i2 = i3;
                    }
                    bitmap = Bitmap.createScaledBitmap(ba, width, i2, true);
                    p.g(bitmap, "Bitmap.createScaledBitma…idth, outputHeight, true)");
                }
                BitmapUtil.saveBitmapToImage(bitmap, 60, Bitmap.CompressFormat.JPEG, this.BKP.BKY, true);
            } catch (IOException e2) {
                com.tencent.mm.plugin.recordvideo.d.f fVar = com.tencent.mm.plugin.recordvideo.d.f.BXU;
                com.tencent.mm.plugin.recordvideo.d.f.eLe();
            }
        } else {
            com.tencent.mm.plugin.recordvideo.d.f fVar2 = com.tencent.mm.plugin.recordvideo.d.f.BXU;
            com.tencent.mm.plugin.recordvideo.d.f.eLe();
        }
        StringBuilder append = new StringBuilder(" mixVideoPath : ").append(this.BKP.BKX).append(" mixThumbPath:").append(this.BKP.BKY).append("   thumb-bitmap is null:");
        if (ba != null) {
            z = false;
        }
        Log.i("MicroMsg.Media.VideoMixer", append.append(z).toString());
        if (ba == null) {
            AppMethodBeat.o(75250);
            return null;
        }
        String str = this.BKP.BKY;
        AppMethodBeat.o(75250);
        return str;
    }

    public static int aLm(String str) {
        int i2;
        android.support.e.a aVar;
        Throwable th;
        Integer num = null;
        Throwable th2 = null;
        AppMethodBeat.i(75251);
        p.h(str, "path");
        try {
            InputStream openRead = s.openRead(str);
            if (openRead != null) {
                InputStream inputStream = openRead;
                try {
                    android.support.e.a aVar2 = new android.support.e.a(inputStream);
                    x xVar = x.SXb;
                    kotlin.f.b.a(inputStream, null);
                    aVar = aVar2;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    kotlin.f.b.a(inputStream, th2);
                    AppMethodBeat.o(75251);
                    throw th;
                }
            } else {
                aVar = null;
            }
            if (aVar != null) {
                num = Integer.valueOf(aVar.l(android.support.e.a.TAG_ORIENTATION));
            }
            if (num != null && num.intValue() == 6) {
                i2 = 90;
                AppMethodBeat.o(75251);
                return i2;
            } else if (num != null && num.intValue() == 3) {
                i2 = TXLiveConstants.RENDER_ROTATION_180;
                AppMethodBeat.o(75251);
                return i2;
            } else {
                i2 = num == null ? 0 : num.intValue() == 8 ? 270 : 0;
                AppMethodBeat.o(75251);
                return i2;
            }
        } catch (IOException e2) {
            i2 = 0;
        }
    }

    public static /* synthetic */ Bitmap a(Bitmap bitmap, Bitmap bitmap2, float f2, float f3, int i2) {
        AppMethodBeat.i(75252);
        if ((i2 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f3 = 0.0f;
        }
        new Canvas(bitmap2).drawBitmap(bitmap, f2, f3, (Paint) null);
        AppMethodBeat.o(75252);
        return bitmap2;
    }

    public final void a(VideoTransPara videoTransPara, int i2, int i3) {
        AppMethodBeat.i(75253);
        p.h(videoTransPara, "videoParam");
        if (this.BKJ == null) {
            this.BKJ = new AdaptiveAdjustBitrate();
        }
        Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] ceilingVideoBR:[%d]", Integer.valueOf(videoTransPara.iTq), Integer.valueOf(videoTransPara.iTg), Integer.valueOf(videoTransPara.iTk));
        AdaptiveAdjustBitrate adaptiveAdjustBitrate = this.BKJ;
        if (adaptiveAdjustBitrate != null) {
            adaptiveAdjustBitrate.targetHeight = this.videoHeight;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate2 = this.BKJ;
        if (adaptiveAdjustBitrate2 != null) {
            adaptiveAdjustBitrate2.targetWidth = this.videoWidth;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate3 = this.BKJ;
        if (adaptiveAdjustBitrate3 != null) {
            adaptiveAdjustBitrate3.DlY = this.videoBitrate;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate4 = this.BKJ;
        if (adaptiveAdjustBitrate4 != null) {
            adaptiveAdjustBitrate4.BNp = i3;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate5 = this.BKJ;
        if (adaptiveAdjustBitrate5 != null) {
            adaptiveAdjustBitrate5.BNq = i2;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate6 = this.BKJ;
        if (adaptiveAdjustBitrate6 != null) {
            adaptiveAdjustBitrate6.iTq = videoTransPara.iTq;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate7 = this.BKJ;
        if (adaptiveAdjustBitrate7 != null) {
            adaptiveAdjustBitrate7.iTg = videoTransPara.iTg;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate8 = this.BKJ;
        if (adaptiveAdjustBitrate8 != null) {
            adaptiveAdjustBitrate8.iTh = videoTransPara.iTh;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate9 = this.BKJ;
        if (adaptiveAdjustBitrate9 != null) {
            adaptiveAdjustBitrate9.iTi = videoTransPara.iTi;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate10 = this.BKJ;
        if (adaptiveAdjustBitrate10 != null) {
            adaptiveAdjustBitrate10.iTj = videoTransPara.iTj;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate11 = this.BKJ;
        if (adaptiveAdjustBitrate11 != null) {
            adaptiveAdjustBitrate11.iTk = videoTransPara.iTk;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate12 = this.BKJ;
        if (adaptiveAdjustBitrate12 != null) {
            adaptiveAdjustBitrate12.iTl = videoTransPara.iTl;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate13 = this.BKJ;
        if (adaptiveAdjustBitrate13 != null) {
            adaptiveAdjustBitrate13.iTn = videoTransPara.iTn;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate14 = this.BKJ;
        if (adaptiveAdjustBitrate14 != null) {
            adaptiveAdjustBitrate14.DlZ = videoTransPara.iTm;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate15 = this.BKJ;
        if (adaptiveAdjustBitrate15 != null) {
            adaptiveAdjustBitrate15.iTo = videoTransPara.iTo;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate16 = this.BKJ;
        if (adaptiveAdjustBitrate16 != null) {
            adaptiveAdjustBitrate16.idF = videoTransPara.idF;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate17 = this.BKJ;
        if (adaptiveAdjustBitrate17 != null) {
            adaptiveAdjustBitrate17.idG = videoTransPara.idG;
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate18 = this.BKJ;
        if (adaptiveAdjustBitrate18 != null) {
            adaptiveAdjustBitrate18.iTp = videoTransPara.iTp;
            AppMethodBeat.o(75253);
            return;
        }
        AppMethodBeat.o(75253);
    }

    public final int eJe() {
        int i2;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate2;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate3;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate4;
        AppMethodBeat.i(75254);
        Log.i("MicroMsg.Media.VideoMixer", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:" + this.BKK, Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth));
        Object[] objArr = new Object[3];
        AdaptiveAdjustBitrate adaptiveAdjustBitrate5 = this.BKJ;
        objArr[0] = adaptiveAdjustBitrate5 != null ? Integer.valueOf(adaptiveAdjustBitrate5.iTq) : null;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate6 = this.BKJ;
        objArr[1] = adaptiveAdjustBitrate6 != null ? Integer.valueOf(adaptiveAdjustBitrate6.iTg) : null;
        AdaptiveAdjustBitrate adaptiveAdjustBitrate7 = this.BKJ;
        objArr[2] = adaptiveAdjustBitrate7 != null ? Integer.valueOf(adaptiveAdjustBitrate7.iTh) : null;
        Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", objArr);
        AdaptiveAdjustBitrate adaptiveAdjustBitrate8 = this.BKJ;
        if (((adaptiveAdjustBitrate8 == null || adaptiveAdjustBitrate8.iTg != 1) && ((adaptiveAdjustBitrate4 = this.BKJ) == null || adaptiveAdjustBitrate4.iTg != 2)) || (((adaptiveAdjustBitrate = this.BKJ) == null || adaptiveAdjustBitrate.iTq != this.BKM) && (((adaptiveAdjustBitrate2 = this.BKJ) == null || adaptiveAdjustBitrate2.iTq != this.BKL) && ((adaptiveAdjustBitrate3 = this.BKJ) == null || adaptiveAdjustBitrate3.iTq != this.tvw)))) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(this.videoBitrate);
            AdaptiveAdjustBitrate adaptiveAdjustBitrate9 = this.BKJ;
            objArr2[1] = adaptiveAdjustBitrate9 != null ? Integer.valueOf(adaptiveAdjustBitrate9.iTp) : null;
            Log.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", objArr2);
            i2 = 1;
        } else {
            String str = this.BKI.BMT;
            int i3 = this.videoHeight;
            int i4 = this.videoWidth;
            int i5 = this.videoFrameRate;
            int i6 = this.videoBitrate;
            AdaptiveAdjustBitrate adaptiveAdjustBitrate10 = this.BKJ;
            Integer valueOf = adaptiveAdjustBitrate10 != null ? Integer.valueOf(adaptiveAdjustBitrate10.BNq) : null;
            if (valueOf == null) {
                p.hyc();
            }
            int intValue = valueOf.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate11 = this.BKJ;
            if (adaptiveAdjustBitrate11 != null) {
                num = Integer.valueOf(adaptiveAdjustBitrate11.BNp);
            } else {
                num = null;
            }
            if (num == null) {
                p.hyc();
            }
            float intValue2 = (float) ((intValue - num.intValue()) / 1000);
            AdaptiveAdjustBitrate adaptiveAdjustBitrate12 = this.BKJ;
            if (adaptiveAdjustBitrate12 != null) {
                num2 = Integer.valueOf(adaptiveAdjustBitrate12.BNp);
            } else {
                num2 = null;
            }
            if (num2 == null) {
                p.hyc();
            }
            float intValue3 = (float) (num2.intValue() / 1000);
            AdaptiveAdjustBitrate adaptiveAdjustBitrate13 = this.BKJ;
            if (adaptiveAdjustBitrate13 != null) {
                num3 = Integer.valueOf(adaptiveAdjustBitrate13.iTq);
            } else {
                num3 = null;
            }
            if (num3 == null) {
                p.hyc();
            }
            int intValue4 = num3.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate14 = this.BKJ;
            if (adaptiveAdjustBitrate14 != null) {
                num4 = Integer.valueOf(adaptiveAdjustBitrate14.iTi);
            } else {
                num4 = null;
            }
            if (num4 == null) {
                p.hyc();
            }
            int intValue5 = num4.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate15 = this.BKJ;
            if (adaptiveAdjustBitrate15 != null) {
                num5 = Integer.valueOf(adaptiveAdjustBitrate15.iTj);
            } else {
                num5 = null;
            }
            if (num5 == null) {
                p.hyc();
            }
            int intValue6 = num5.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate16 = this.BKJ;
            if (adaptiveAdjustBitrate16 != null) {
                num6 = Integer.valueOf(adaptiveAdjustBitrate16.iTk);
            } else {
                num6 = null;
            }
            if (num6 == null) {
                p.hyc();
            }
            int intValue7 = num6.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate17 = this.BKJ;
            if (adaptiveAdjustBitrate17 != null) {
                num7 = Integer.valueOf(adaptiveAdjustBitrate17.iTl);
            } else {
                num7 = null;
            }
            if (num7 == null) {
                p.hyc();
            }
            int intValue8 = num7.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate18 = this.BKJ;
            if (adaptiveAdjustBitrate18 != null) {
                num8 = Integer.valueOf(adaptiveAdjustBitrate18.DlZ);
            } else {
                num8 = null;
            }
            if (num8 == null) {
                p.hyc();
            }
            int intValue9 = num8.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate19 = this.BKJ;
            if (adaptiveAdjustBitrate19 != null) {
                num9 = Integer.valueOf(adaptiveAdjustBitrate19.iTn);
            } else {
                num9 = null;
            }
            if (num9 == null) {
                p.hyc();
            }
            int intValue10 = num9.intValue();
            AdaptiveAdjustBitrate adaptiveAdjustBitrate20 = this.BKJ;
            if (adaptiveAdjustBitrate20 != null) {
                num10 = Integer.valueOf(adaptiveAdjustBitrate20.iTo);
            } else {
                num10 = null;
            }
            if (num10 == null) {
                p.hyc();
            }
            int[] a2 = AdaptiveAdjustBitrate.a(str, i3, i4, i5, i6, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, intValue8, intValue9, intValue10, num10.intValue(), false);
            p.g(a2, "AdaptiveAdjustBitrate.Ge…s?.maxVideoSize!!, false)");
            this.vRR = a2;
            if (this.vRR != null) {
                this.videoBitrate = this.vRR[0] * 1000;
            }
            if (this.vRR != null && this.vRR[5] > 0 && !this.BKK) {
                this.videoWidth = this.vRR[1];
                this.videoHeight = this.vRR[2];
            }
            Log.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight));
            o.bhk();
            com.tencent.mm.an.e.s(this.vRR);
            if (this.vRR[3] > 0 || this.vRR[4] > 0 || this.vRR[5] > 0) {
                i2 = 0;
            }
            i2 = 1;
        }
        AppMethodBeat.o(75254);
        return i2;
    }

    public static /* synthetic */ void a(VideoMixer videoMixer, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(75256);
        videoMixer.a(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
        AppMethodBeat.o(75256);
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        AppMethodBeat.i(75255);
        this.videoWidth = i2;
        this.videoHeight = i3;
        this.videoBitrate = i4;
        this.audioBitrate = i5;
        this.audioSampleRate = i6;
        this.audioChannelCount = i7;
        this.videoFrameRate = i8;
        this.ihS = i9;
        this.iiE = i10;
        this.iiF = i11;
        if (this.BKJ == null) {
            this.BKJ = new AdaptiveAdjustBitrate();
        }
        AdaptiveAdjustBitrate adaptiveAdjustBitrate = this.BKJ;
        if (adaptiveAdjustBitrate != null) {
            adaptiveAdjustBitrate.eVq();
            AppMethodBeat.o(75255);
            return;
        }
        AppMethodBeat.o(75255);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000b¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
    public static final class MixConfig implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        public int audioBitrate;
        public int audioChannelCount;
        public int audioSampleRate;
        public int ihS;
        public int videoBitrate;
        public int videoFrameRate;
        public int videoHeight;
        public int videoWidth;

        static {
            AppMethodBeat.i(75241);
            AppMethodBeat.o(75241);
        }

        public MixConfig() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public MixConfig(Parcel parcel) {
            this();
            p.h(parcel, "parcel");
            AppMethodBeat.i(75240);
            this.videoWidth = parcel.readInt();
            this.videoHeight = parcel.readInt();
            this.videoBitrate = parcel.readInt();
            this.audioBitrate = parcel.readInt();
            this.audioSampleRate = parcel.readInt();
            this.audioChannelCount = parcel.readInt();
            this.videoFrameRate = parcel.readInt();
            this.ihS = parcel.readInt();
            AppMethodBeat.o(75240);
        }

        public final String toString() {
            AppMethodBeat.i(75238);
            String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.ihS;
            AppMethodBeat.o(75238);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(75239);
            p.h(parcel, "parcel");
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.videoBitrate);
            parcel.writeInt(this.audioBitrate);
            parcel.writeInt(this.audioSampleRate);
            parcel.writeInt(this.audioChannelCount);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.ihS);
            AppMethodBeat.o(75239);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "plugin-recordvideo_release"})
        public static final class a implements Parcelable.Creator<MixConfig> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MixConfig createFromParcel(Parcel parcel) {
                AppMethodBeat.i(75237);
                p.h(parcel, "parcel");
                MixConfig mixConfig = new MixConfig(parcel);
                AppMethodBeat.o(75237);
                return mixConfig;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MixConfig[] newArray(int i2) {
                return new MixConfig[i2];
            }
        }
    }

    public final MixConfig eJf() {
        AppMethodBeat.i(75257);
        MixConfig mixConfig = new MixConfig();
        mixConfig.videoWidth = this.videoWidth;
        mixConfig.videoHeight = this.videoHeight;
        mixConfig.videoBitrate = this.videoBitrate;
        mixConfig.audioBitrate = this.audioBitrate;
        mixConfig.audioSampleRate = this.audioSampleRate;
        mixConfig.audioChannelCount = this.audioChannelCount;
        mixConfig.videoFrameRate = this.videoFrameRate;
        mixConfig.ihS = this.ihS;
        AppMethodBeat.o(75257);
        return mixConfig;
    }

    public static Point hS(int i2, int i3) {
        AppMethodBeat.i(75258);
        Point point = new Point(i2 * 1, i3 * 1);
        AppMethodBeat.o(75258);
        return point;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ VideoMixer BKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(VideoMixer videoMixer) {
            super(0);
            this.BKR = videoMixer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(182840);
            this.BKR.BKO = com.tencent.mm.ac.d.a("VideoMixer", false, (kotlin.g.a.a) new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.background.VideoMixer.h.AnonymousClass1 */
                final /* synthetic */ h BKU;

                {
                    this.BKU = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(182838);
                    x eJg = eJg();
                    AppMethodBeat.o(182838);
                    return eJg;
                }

                private x eJg() {
                    x xVar;
                    AppMethodBeat.i(182839);
                    Log.i("MicroMsg.Media.VideoMixer", "[start] mixThread=" + this.BKU.BKR.BKO);
                    try {
                        this.BKU.BKR.eJe();
                        VideoMixer.b(this.BKU.BKR);
                        xVar = x.SXb;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Media.VideoMixer", e2, "error on startVideoMixer", new Object[0]);
                        r rVar = this.BKU.BKR.BKE;
                        xVar = rVar != null ? (x) rVar.invoke(this.BKU.BKR.BKP.BKX, this.BKU.BKR.BKP.BKY, Boolean.FALSE, -1) : null;
                    }
                    AppMethodBeat.o(182839);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(182840);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(VideoMixer videoMixer) {
        com.tencent.mm.plugin.recordvideo.ui.editor.b.g gVar;
        long j2;
        long j3;
        String str;
        boolean z;
        com.tencent.mm.plugin.recordvideo.background.b.e fVar;
        String str2;
        AppMethodBeat.i(75263);
        com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
        d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(videoMixer.BKP.BKI.BMT);
        Point hS = hS(videoMixer.videoWidth, videoMixer.videoHeight);
        if (videoMixer.BKP.BKI.iqf || aLQ == null || aLQ.Cio) {
            gVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(videoMixer.BKP.BKV, videoMixer.BKP.BKW, videoMixer.BKP.rpx, hS.x, hS.y, 0, 0, videoMixer.ihS, true, videoMixer.BKP.BLa));
        } else {
            gVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(videoMixer.BKP.BKV, videoMixer.BKP.BKW, videoMixer.BKP.rpx, hS.x, hS.y, aLQ.width, aLQ.height, videoMixer.ihS, true, videoMixer.BKP.BLa));
        }
        videoMixer.BKH = gVar;
        com.tencent.mm.plugin.recordvideo.ui.editor.b.g gVar2 = videoMixer.BKH;
        if (gVar2 == null) {
            p.btv("frameRetriever");
        }
        gVar2.start();
        Log.i("MicroMsg.Media.VideoMixer", videoMixer.BKP.BKI.BMT + ' ' + videoMixer.videoWidth + ' ' + videoMixer.videoHeight + ' ' + videoMixer.videoFrameRate);
        com.tencent.mm.plugin.recordvideo.background.a.a aVar = videoMixer.BKP;
        if (aVar.BKI.BMV >= 0) {
            j2 = aVar.BKI.BMV;
        } else {
            j2 = 0;
        }
        com.tencent.mm.plugin.recordvideo.background.a.a aVar2 = videoMixer.BKP;
        if (aVar2.BKI.BMW >= 0) {
            j3 = aVar2.BKI.BMW;
        } else {
            j3 = 0;
        }
        try {
            if (videoMixer.BKI.BMZ.size() > 0) {
                boolean isEnable = j.isEnable();
                AudioCacheInfo audioCacheInfo = videoMixer.BKI.uPh;
                if (audioCacheInfo != null) {
                    str2 = audioCacheInfo.cachePath;
                } else {
                    str2 = null;
                }
                fVar = new com.tencent.mm.plugin.recordvideo.background.b.e(str2, videoMixer.BKI.BMZ, videoMixer.BKI.BMY, videoMixer.BKP.BKX, videoMixer.videoWidth, videoMixer.videoHeight, videoMixer.videoBitrate, videoMixer.audioBitrate, videoMixer.audioSampleRate, videoMixer.videoFrameRate, j2, j3, isEnable, new e(videoMixer, isEnable));
            } else {
                Log.i("MicroMsg.Media.VideoMixer", "steve: hardcoder qp:" + videoMixer.iiE + ", " + videoMixer.iiF);
                Bitmap invoke = videoMixer.iif.invoke(0L);
                AudioCacheInfo audioCacheInfo2 = videoMixer.BKI.uPh;
                if (audioCacheInfo2 != null) {
                    str = audioCacheInfo2.cachePath;
                } else {
                    str = null;
                }
                String str3 = videoMixer.BKI.BMT;
                int i2 = videoMixer.BKI.BMY;
                String str4 = videoMixer.BKP.BKX;
                int i3 = videoMixer.videoWidth;
                int i4 = videoMixer.videoHeight;
                int i5 = videoMixer.videoWidth;
                int i6 = videoMixer.videoHeight;
                int i7 = videoMixer.videoBitrate;
                int i8 = videoMixer.audioBitrate;
                int i9 = videoMixer.audioSampleRate;
                int i10 = videoMixer.audioChannelCount;
                int i11 = videoMixer.videoFrameRate;
                boolean z2 = videoMixer.BKP.iiC;
                boolean z3 = videoMixer.BKP.iiD;
                int i12 = videoMixer.iiE;
                int i13 = videoMixer.iiF;
                if (invoke != null) {
                    z = true;
                } else {
                    z = false;
                }
                fVar = new com.tencent.mm.media.i.f(str, str3, i2, str4, i3, i4, i5, i6, i7, i8, i9, i10, i11, j2, j3, z2, z3, i12, i13, z, 0, new f(videoMixer), 6291456);
            }
            fVar.k(videoMixer.ihf);
            fVar.l(videoMixer.iif);
            fVar.aMG();
            Log.i("MicroMsg.Media.VideoMixer", "remuxer 0");
            AppMethodBeat.o(75263);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Media.VideoMixer", e2, "remux error", new Object[0]);
            r<? super String, ? super String, ? super Boolean, ? super Integer, x> rVar = videoMixer.BKE;
            if (rVar != null) {
                rVar.invoke(videoMixer.BKP.BKX, "", Boolean.FALSE, -1);
                AppMethodBeat.o(75263);
                return;
            }
            AppMethodBeat.o(75263);
        }
    }
}

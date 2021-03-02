package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u000256B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ6\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u000eJ\b\u0010$\u001a\u00020\u000fH\u0002J \u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\u0011J\u0016\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201Jc\u00102\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2K\u0010\r\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00110\u000eJc\u00104\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2K\u0010\r\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00110\u000eR*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000Rh\u0010\u0012\u001a\\\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00110\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class a {
    public static final C1858a GFX = new C1858a((byte) 0);
    public b GFS = new b();
    public com.tencent.mm.plugin.vlog.remux.d GFT;
    private final af GFU = new af();
    public final r<String, String, Boolean, Integer, x> GFV = new c(this);
    public final ah GFW;
    private final Context context;
    public final RecordConfigProvider wdm;
    public q<? super Boolean, ? super Integer, ? super b, x> xlr;

    static {
        AppMethodBeat.i(111149);
        AppMethodBeat.o(111149);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "invoke"})
    static final class c extends kotlin.g.b.q implements r<String, String, Boolean, Integer, x> {
        final /* synthetic */ a GFY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(4);
            this.GFY = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, String str2, Boolean bool, Integer num) {
            AppMethodBeat.i(111143);
            String str3 = str;
            String str4 = str2;
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            p.h(str3, "mixVideo");
            p.h(str4, "mixThumb");
            Log.i("MicroMsg.VLogGenerateManager", "onMuxEnd success:" + booleanValue + "  errorCode:" + intValue);
            q qVar = this.GFY.xlr;
            if (qVar != null) {
                qVar.d(Boolean.valueOf(booleanValue), Integer.valueOf(intValue), new b(str3, str4));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111143);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements r<String, String, Boolean, Integer, x> {
        final /* synthetic */ a GFY;
        final /* synthetic */ int GFZ;
        final /* synthetic */ int GGa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2, int i3) {
            super(4);
            this.GFY = aVar;
            this.GFZ = i2;
            this.GGa = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, String str2, Boolean bool, Integer num) {
            AppMethodBeat.i(111145);
            String str3 = str2;
            boolean booleanValue = bool.booleanValue();
            num.intValue();
            p.h(str, "<anonymous parameter 0>");
            p.h(str3, "thumbPath");
            Log.i("MicroMsg.VLogGenerateManager", "getThumbBitmap ret:" + booleanValue + "  thumbPath:" + str3);
            final ald ald = new ald();
            ald.BOA = this.GFY.GFU.rpE;
            ald.Lue = str3;
            ald.Luf = 1;
            ald.hDa = this.GFY.wdm.scene;
            final VideoMixer.MixConfig mixConfig = new VideoMixer.MixConfig();
            mixConfig.audioBitrate = this.GFY.GFU.audioBitrate;
            mixConfig.videoWidth = this.GFY.GFU.targetWidth;
            mixConfig.videoHeight = this.GFY.GFU.targetHeight;
            mixConfig.videoBitrate = this.GFY.GFU.videoBitrate;
            mixConfig.audioSampleRate = this.GFY.GFU.audioSampleRate;
            mixConfig.audioChannelCount = this.GFY.GFU.audioChannelCount;
            mixConfig.videoFrameRate = this.GFY.GFU.frameRate;
            mixConfig.ihS = 0;
            final aio aio = new aio();
            aio.startTime = 0;
            aio.endTime = (long) this.GFY.GFU.GzL;
            aio.idq = this.GFY.GFU.GzM;
            aio.thumbPath = str3;
            aio.musicUrl = this.GFY.GFW.GzR;
            aio.aXa = false;
            aio.LrU = (int) this.GFY.GFW.BKV[0];
            aio.LrW = (int) this.GFY.GFW.BKV[1];
            aio.LrV = (int) this.GFY.GFW.BKV[2];
            aio.LrX = (int) this.GFY.GFW.BKV[3];
            for (T t : this.GFY.GFW.BNo) {
                jn jnVar = new jn();
                jnVar.dataType = t.Cex.value;
                jnVar.KOd = z.aC(t.eMk().toByteArray());
                aio.Lna.add(jnVar);
            }
            aio.iqf = false;
            aio.LrT = "";
            aio.videoPath = "";
            final epc epc = new epc();
            epc.previewWidth = this.GFZ;
            epc.previewHeight = this.GGa;
            epc.NmX = this.GFY.GFW.GzS;
            if (TextUtils.isEmpty(this.GFY.GFW.GzR)) {
                aio.Lsd = com.tencent.mm.bw.b.cD(epc.toByteArray());
                a.a(this.GFY, aio, mixConfig, ald);
                this.GFY.GFV.invoke("", "", Boolean.FALSE, 4);
            } else {
                this.GFY.GFS.d(this.GFY.GFW.GzR, new m<Boolean, String, x>(this) {
                    /* class com.tencent.mm.plugin.vlog.ui.manager.a.d.AnonymousClass1 */
                    final /* synthetic */ d GGb;

                    {
                        this.GGb = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Boolean bool, String str) {
                        AppMethodBeat.i(111144);
                        String str2 = str;
                        if (!bool.booleanValue()) {
                            Log.i("MicroMsg.VLogGenerateManager", "download music fail :".concat(String.valueOf(str2)));
                            this.GGb.GFY.GFV.invoke("", "", Boolean.FALSE, 1);
                        } else {
                            epc.NmX.NoU.MxH = str2;
                            aio.iiv = str2;
                            aio.aXa = true;
                            aio.Lsd = com.tencent.mm.bw.b.cD(epc.toByteArray());
                            a.a(this.GGb.GFY, aio, mixConfig, ald);
                            this.GGb.GFY.GFV.invoke("", "", Boolean.FALSE, 4);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(111144);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111145);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements m<Boolean, String, x> {
        final /* synthetic */ a GFY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar) {
            super(2);
            this.GFY = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            AppMethodBeat.i(111146);
            String str2 = str;
            if (!bool.booleanValue()) {
                Log.i("MicroMsg.VLogGenerateManager", "download music fail :".concat(String.valueOf(str2)));
                this.GFY.GFV.invoke("", "", Boolean.FALSE, 1);
            } else {
                this.GFY.GFT.aUg(str2);
                this.GFY.GFT.e(this.GFY.GFV);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111146);
            return xVar;
        }
    }

    public a(Context context2, ah ahVar, RecordConfigProvider recordConfigProvider, boolean z, AudioCacheInfo audioCacheInfo) {
        int QH;
        int i2;
        p.h(ahVar, "model");
        p.h(recordConfigProvider, "configProvider");
        AppMethodBeat.i(111148);
        this.context = context2;
        this.GFW = ahVar;
        this.wdm = recordConfigProvider;
        int QH2 = com.tencent.mm.plugin.mmsight.d.QH(this.wdm.BOm.width);
        Point az = ao.az(MMApplicationContext.getContext());
        int i3 = az.y;
        int i4 = az.x;
        if (this.wdm.scene == 11) {
            QH = com.tencent.mm.plugin.mmsight.d.QH(this.wdm.BOm.height);
        } else {
            QH = com.tencent.mm.plugin.mmsight.d.QH((i3 * QH2) / i4);
        }
        Log.i("MicroMsg.VLogGenerateManager", "targetWidth:" + QH2 + " targetHeight:" + QH + ", videoParam:" + this.wdm.BOm);
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.e(this.wdm);
        Log.i("MicroMsg.VLogGenerateManager", "output path:" + this.wdm.BOA);
        if (z) {
            if (audioCacheInfo == null) {
                i2 = 0;
            } else {
                i2 = 2;
            }
        } else if (audioCacheInfo == null) {
            i2 = 1;
        } else {
            i2 = 3;
        }
        Log.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i2 + ", muteOrigin:" + z + ", audioInfo:" + audioCacheInfo);
        af afVar = this.GFU;
        afVar.GzL = getVideoDurationMs();
        afVar.GzM = i2;
        String str = this.wdm.BOA;
        p.g(str, "configProvider.outputVideoPath");
        afVar.aUb(str);
        afVar.targetWidth = QH2;
        afVar.targetHeight = QH;
        afVar.videoBitrate = this.wdm.BOm.videoBitrate;
        afVar.audioBitrate = this.wdm.BOm.audioBitrate;
        afVar.frameRate = this.wdm.BOm.fps;
        afVar.audioSampleRate = this.wdm.BOm.audioSampleRate;
        afVar.audioChannelCount = this.wdm.BOm.audioChannelCount;
        Log.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.GFU);
        this.GFT = new com.tencent.mm.plugin.vlog.remux.d(this.GFW, this.GFU);
        AppMethodBeat.o(111148);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.manager.a$a  reason: collision with other inner class name */
    public static final class C1858a {
        private C1858a() {
        }

        public /* synthetic */ C1858a(byte b2) {
            this();
        }
    }

    private final int getVideoDurationMs() {
        long j2;
        AppMethodBeat.i(111147);
        long j3 = 0;
        for (T t : this.GFW.GzQ) {
            if (t.endTime > j3) {
                j2 = t.endTime;
            } else {
                j2 = j3;
            }
            j3 = j2;
        }
        Log.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(j3)));
        int i2 = (int) j3;
        AppMethodBeat.o(111147);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-vlog_release"})
    public static final class b {
        public String thumbPath;
        public String videoPath;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.thumbPath, r4.thumbPath) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 111142(0x1b226, float:1.55743E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.ui.manager.a.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.vlog.ui.manager.a$b r4 = (com.tencent.mm.plugin.vlog.ui.manager.a.b) r4
                java.lang.String r0 = r3.videoPath
                java.lang.String r1 = r4.videoPath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.thumbPath
                java.lang.String r1 = r4.thumbPath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.manager.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(111141);
            String str = this.videoPath;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.thumbPath;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(111141);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(111140);
            String str = "VLogOutputInfo(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ")";
            AppMethodBeat.o(111140);
            return str;
        }

        public b(String str, String str2) {
            p.h(str, "videoPath");
            p.h(str2, "thumbPath");
            AppMethodBeat.i(111139);
            this.videoPath = str;
            this.thumbPath = str2;
            AppMethodBeat.o(111139);
        }
    }

    public static final /* synthetic */ void a(a aVar, aio aio, VideoMixer.MixConfig mixConfig, ald ald) {
        AppMethodBeat.i(111150);
        CaptureDataManager captureDataManager = CaptureDataManager.BOb;
        p.g(captureDataManager, "CaptureDataManager.INSTANCE");
        captureDataManager.getExtData().putBoolean("key_bg_generate", true);
        CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
        p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
        captureDataManager2.getExtData().putByteArray("key_bg_generate_extra_config", ald.toByteArray());
        CaptureDataManager captureDataManager3 = CaptureDataManager.BOb;
        p.g(captureDataManager3, "CaptureDataManager.INSTANCE");
        captureDataManager3.getExtData().putParcelable("key_bg_generate_mix_config", mixConfig);
        CaptureDataManager captureDataManager4 = CaptureDataManager.BOb;
        p.g(captureDataManager4, "CaptureDataManager.INSTANCE");
        captureDataManager4.getExtData().putByteArray("key_bg_generate_pb", aio.toByteArray());
        CaptureDataManager.BOb.a(aVar.context, new CaptureDataManager.CaptureVideoNormalModel(Boolean.FALSE, "", "", 0L, Boolean.FALSE, null));
        AppMethodBeat.o(111150);
    }
}

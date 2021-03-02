package com.tencent.mm.plugin.story.c.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.plugin.story.proxy.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c extends b<a> {
    public static final c FkZ = new c();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(118594);
        AppMethodBeat.o(118594);
    }

    private c() {
    }

    public static final /* synthetic */ int aRI(String str) {
        AppMethodBeat.i(118595);
        int aRH = aRH(str);
        AppMethodBeat.o(118595);
        return aRH;
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        float f2;
        AppMethodBeat.i(118592);
        a aVar = (a) aLQ();
        c.a aVar2 = com.tencent.mm.plugin.story.proxy.c.Ftv;
        com.tencent.mm.plugin.story.proxy.c unused = com.tencent.mm.plugin.story.proxy.c.Ftu;
        VideoTransPara videoPara = com.tencent.mm.plugin.story.proxy.c.getVideoPara();
        p.h(videoPara, "<set-?>");
        aVar.BOm = videoPara;
        VideoTransPara videoTransPara = ((a) aLQ()).BOm;
        ((a) aLQ()).targetWidth = videoTransPara.width;
        f.a aVar3 = f.ilG;
        ((a) aLQ()).targetHeight = f.a.ro(videoTransPara.width);
        if (((a) aLQ()).targetHeight % 16 != 0) {
            ((a) aLQ()).targetHeight = d.QH(((a) aLQ()).targetHeight);
        }
        if (((a) aLQ()).targetWidth % 16 != 0) {
            ((a) aLQ()).targetWidth = d.QH(((a) aLQ()).targetWidth);
        }
        ((a) aLQ()).BOm.width = ((a) aLQ()).targetWidth;
        ((a) aLQ()).BOm.height = ((a) aLQ()).targetHeight;
        ((a) aLQ()).videoBitrate = videoTransPara.videoBitrate;
        ((a) aLQ()).audioBitrate = videoTransPara.audioBitrate;
        ((a) aLQ()).frameRate = videoTransPara.fps;
        ((a) aLQ()).iiH = videoTransPara.iiH;
        ((a) aLQ()).duration = videoTransPara.duration;
        ((a) aLQ()).iSV = videoTransPara.iSV;
        ((a) aLQ()).iSU = videoTransPara.iSU;
        ((a) aLQ()).isDefault = videoTransPara.isDefault;
        ((a) aLQ()).iTf = videoTransPara.iTf;
        ((a) aLQ()).audioSampleRate = videoTransPara.audioSampleRate;
        a aVar4 = (a) aLQ();
        p.h("StoryCheckSendVideoBitrateLimit", "key");
        if (MMApplicationContext.isMMProcess()) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
            f2 = Util.getFloat(((com.tencent.mm.plugin.zero.b.a) af).aqJ().getValue("StoryCheckSendVideoBitrateLimit"), 1.3f);
        } else {
            f2 = Util.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3f);
        }
        aVar4.Fla = f2;
        if (ae.gKB.gIP != -1) {
            ((a) aLQ()).gIP = ae.gKB.gIP;
        }
        if (WeChatEnvironment.hasDebugger()) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ((a) aLQ()).gIP = aAh.azQ().getInt(ar.a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, 2);
        }
        Log.i(TAG, "loadConfigFromVideoParam: " + ((a) aLQ()));
        AppMethodBeat.o(118592);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0013HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020@HÖ\u0001J\u000e\u0010U\u001a\u00020V2\u0006\u0010?\u001a\u00020@R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
    public static final class a {
        public static final C1745a Flb = new C1745a((byte) 0);
        public VideoTransPara BOm;
        float Fla;
        int audioBitrate;
        int audioSampleRate;
        public int duration;
        public int frameRate;
        int gIP;
        int iSU;
        int iSV;
        int iTf;
        public int ihS;
        int iiH;
        boolean isDefault;
        public int targetHeight;
        public int targetWidth;
        public int videoBitrate;

        static {
            AppMethodBeat.i(118587);
            AppMethodBeat.o(118587);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006a, code lost:
            if (java.lang.Float.compare(r3.Fla, r4.Fla) == 0) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
            // Method dump skipped, instructions count: 118
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.c.a.c.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(118589);
            int i2 = ((((((((((((((((((this.targetWidth * 31) + this.targetHeight) * 31) + this.videoBitrate) * 31) + this.audioBitrate) * 31) + this.frameRate) * 31) + this.ihS) * 31) + this.duration) * 31) + this.iiH) * 31) + this.iSU) * 31) + this.iSV) * 31;
            boolean z = this.isDefault;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int floatToIntBits = ((((((((i3 + i2) * 31) + this.iTf) * 31) + this.audioSampleRate) * 31) + this.gIP) * 31) + Float.floatToIntBits(this.Fla);
            AppMethodBeat.o(118589);
            return floatToIntBits;
        }

        public final String toString() {
            AppMethodBeat.i(118588);
            String str = "EncodeConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", duration=" + this.duration + ", iFrame=" + this.iiH + ", profileIndex=" + this.iSU + ", presetIndex=" + this.iSV + ", isDefault=" + this.isDefault + ", thumbSize=" + this.iTf + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.gIP + ", exceedVideoBitrateTolerance=" + this.Fla + ")";
            AppMethodBeat.o(118588);
            return str;
        }

        private a() {
            AppMethodBeat.i(118586);
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.videoBitrate = 0;
            this.audioBitrate = 0;
            this.frameRate = 0;
            this.ihS = 0;
            this.duration = 0;
            this.iiH = 0;
            this.iSU = 0;
            this.iSV = 0;
            this.isDefault = false;
            this.iTf = 0;
            this.audioSampleRate = 0;
            this.gIP = 2;
            this.Fla = 1.3f;
            this.BOm = new VideoTransPara();
            AppMethodBeat.o(118586);
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.c.a.c$a$a  reason: collision with other inner class name */
        public static final class C1745a {
            private C1745a() {
            }

            public /* synthetic */ C1745a(byte b2) {
                this();
            }
        }

        public final boolean aRJ(String str) {
            int i2;
            AppMethodBeat.i(118585);
            p.h(str, "path");
            if (Log.getLogLevel() >= 0) {
                com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
                if (com.tencent.mm.plugin.recordvideo.b.e.eJu()) {
                    AppMethodBeat.o(118585);
                    return true;
                }
            }
            com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str);
            if (aNx != null) {
                i2 = aNx.videoBitrate;
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                try {
                    com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                    dVar.setDataSource(str);
                    i2 = Util.getInt(dVar.extractMetadata(20), 0);
                    dVar.release();
                } catch (Exception e2) {
                }
            }
            Log.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + str + ", bitrate:" + i2 + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.Fla);
            if (((float) i2) > ((float) this.videoBitrate) * this.Fla) {
                AppMethodBeat.o(118585);
                return true;
            }
            AppMethodBeat.o(118585);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int aRH(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.c.a.c.aRH(java.lang.String):int");
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(118591);
        a aVar = new a((byte) 0);
        AppMethodBeat.o(118591);
        return aVar;
    }
}

package com.tencent.mm.plugin.vlog.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u0019J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u0019J\u001a\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020$J\u001c\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u0004H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\u000e\u0010(\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019XD¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c`\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "AV_PIX_FMT_YUV420P", "", "AV_PIX_FMT_YUV420P10BE", "AV_PIX_FMT_YUV420P10LE", "AV_PIX_FMT_YUV420P12BE", "AV_PIX_FMT_YUV420P12LE", "AV_PIX_FMT_YUV420P14BE", "AV_PIX_FMT_YUV420P14LE", "AV_PIX_FMT_YUV420P16BE", "AV_PIX_FMT_YUV420P16LE", "AV_PIX_FMT_YUV420P9BE", "AV_PIX_FMT_YUV420P9LE", "AV_PIX_FMT_YUVA420P", "AV_PIX_FMT_YUVA420P10BE", "AV_PIX_FMT_YUVA420P10LE", "AV_PIX_FMT_YUVA420P16BE", "AV_PIX_FMT_YUVA420P16LE", "AV_PIX_FMT_YUVA420P9BE", "AV_PIX_FMT_YUVA420P9LE", "AV_PIX_FMT_YUVJ420P", "MalformedAudioSampleRateThreshold", "TAG", "", "videoInfoCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "Lkotlin/collections/HashMap;", "getAudioInfoByMediaExtractor", "path", "getVideoFrameRate", "", k.NAME, "fromCache", "", "getVideoInfoByMediaExtractor", "pixelFormat", "getVideoInfoBySightJNI", "isH265Video", "isYuv420pFormat", "videoFormat", "VideoInfo", "plugin-vlog_release"})
public final class MultiMediaVideoChecker {
    private static final HashMap<String, a> GyX = new HashMap<>();
    public static final MultiMediaVideoChecker GyY = new MultiMediaVideoChecker();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(190628);
        AppMethodBeat.o(190628);
    }

    private MultiMediaVideoChecker() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "isH265", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "pixelFormat", "(IIFJIIZIIII)V", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getBitrate", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getPixelFormat", "getRotate", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-vlog_release"})
    public static final class a {
        public final int audioBitrate;
        final int audioChannelCount;
        public final int audioSampleRate;
        public final int bitrate;
        public final float cKu;
        public final int dYT;
        public final long duration;
        public final int height;
        public final int pixelFormat;
        public final int width;
        public final boolean zzJ;

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            if (r5.pixelFormat == r6.pixelFormat) goto L_0x0056;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 190621(0x2e89d, float:2.67117E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0056
                boolean r0 = r6 instanceof com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a
                if (r0 == 0) goto L_0x005b
                com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker$a r6 = (com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a) r6
                int r0 = r5.width
                int r1 = r6.width
                if (r0 != r1) goto L_0x005b
                int r0 = r5.height
                int r1 = r6.height
                if (r0 != r1) goto L_0x005b
                float r0 = r5.cKu
                float r1 = r6.cKu
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x005b
                long r0 = r5.duration
                long r2 = r6.duration
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x005b
                int r0 = r5.bitrate
                int r1 = r6.bitrate
                if (r0 != r1) goto L_0x005b
                int r0 = r5.dYT
                int r1 = r6.dYT
                if (r0 != r1) goto L_0x005b
                boolean r0 = r5.zzJ
                boolean r1 = r6.zzJ
                if (r0 != r1) goto L_0x005b
                int r0 = r5.audioBitrate
                int r1 = r6.audioBitrate
                if (r0 != r1) goto L_0x005b
                int r0 = r5.audioChannelCount
                int r1 = r6.audioChannelCount
                if (r0 != r1) goto L_0x005b
                int r0 = r5.audioSampleRate
                int r1 = r6.audioSampleRate
                if (r0 != r1) goto L_0x005b
                int r0 = r5.pixelFormat
                int r1 = r6.pixelFormat
                if (r0 != r1) goto L_0x005b
            L_0x0056:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x005a:
                return r0
            L_0x005b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x005a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(190620);
            long j2 = this.duration;
            int floatToIntBits = ((((((((((this.width * 31) + this.height) * 31) + Float.floatToIntBits(this.cKu)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.bitrate) * 31) + this.dYT) * 31;
            boolean z = this.zzJ;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = ((((((((i2 + floatToIntBits) * 31) + this.audioBitrate) * 31) + this.audioChannelCount) * 31) + this.audioSampleRate) * 31) + this.pixelFormat;
            AppMethodBeat.o(190620);
            return i5;
        }

        public final String toString() {
            AppMethodBeat.i(190619);
            String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.cKu + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.dYT + ", isH265=" + this.zzJ + ", audioBitrate=" + this.audioBitrate + ", audioChannelCount=" + this.audioChannelCount + ", audioSampleRate=" + this.audioSampleRate + ", pixelFormat=" + this.pixelFormat + ")";
            AppMethodBeat.o(190619);
            return str;
        }

        public a(int i2, int i3, float f2, long j2, int i4, int i5, boolean z, int i6, int i7, int i8, int i9) {
            this.width = i2;
            this.height = i3;
            this.cKu = f2;
            this.duration = j2;
            this.bitrate = i4;
            this.dYT = i5;
            this.zzJ = z;
            this.audioBitrate = i6;
            this.audioChannelCount = i7;
            this.audioSampleRate = i8;
            this.pixelFormat = i9;
        }

        public /* synthetic */ a(long j2, int i2, int i3, int i4) {
            this(0, 0, 0.0f, j2, 0, 0, true, i2, i3, i4, -1);
        }
    }

    public final a aTV(String str) {
        AppMethodBeat.i(190622);
        p.h(str, "path");
        a cA = cA(str, false);
        AppMethodBeat.o(190622);
        return cA;
    }

    public final a cA(String str, boolean z) {
        int i2;
        a aVar;
        int i3;
        AppMethodBeat.i(190623);
        p.h(str, "path");
        if (!s.YS(str)) {
            Log.i(TAG, "file not exist: ".concat(String.valueOf(str)));
            AppMethodBeat.o(190623);
            return null;
        } else if (!z || GyX.get(str) == null) {
            long currentTicks = Util.currentTicks();
            a videoInfoBySightJNI = getVideoInfoBySightJNI(str);
            if (videoInfoBySightJNI != null) {
                i2 = videoInfoBySightJNI.audioSampleRate;
            } else {
                i2 = 0;
            }
            if (i2 <= 1000) {
                Log.i(TAG, "error audio sample rate:".concat(String.valueOf(videoInfoBySightJNI)));
                if (videoInfoBySightJNI != null) {
                    i3 = videoInfoBySightJNI.pixelFormat;
                } else {
                    i3 = -1;
                }
                aVar = fS(str, i3);
            } else {
                aVar = videoInfoBySightJNI;
            }
            Log.i(TAG, "getVideoInfo cost:" + Util.ticksToNow(currentTicks) + ", info:" + aVar);
            if (aVar != null) {
                GyX.put(str, aVar);
            }
            AppMethodBeat.o(190623);
            return aVar;
        } else {
            a aVar2 = GyX.get(str);
            AppMethodBeat.o(190623);
            return aVar2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a aTW(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.aTW(java.lang.String):com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a fS(java.lang.String r14, int r15) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.fS(java.lang.String, int):com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker$a");
    }

    private final a getVideoInfoBySightJNI(String str) {
        AppMethodBeat.i(190626);
        try {
            com.tencent.mm.plugin.sight.base.a cc = e.cc(str, true);
            if (cc != null) {
                a aVar = new a(cc.width, cc.height, (float) cc.frameRate, (long) cc.videoDuration, cc.videoBitrate, SightVideoJNI.getMp4RotateVFS(str), false, cc.audioBitrate, cc.audioChannel, cc.audioSampleRate, cc.pixelFormat);
                AppMethodBeat.o(190626);
                return aVar;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(190626);
        return null;
    }

    public static boolean acy(int i2) {
        AppMethodBeat.i(190627);
        if (j.listOf((Object[]) new Integer[]{0, 12, 35, 54, 55, 69, 70, 71, 72, 72, 95, 96, 101, 102, 107, 108, 129, 130, 133, Integer.valueOf((int) g.CTRL_INDEX)}).contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(190627);
            return true;
        }
        AppMethodBeat.o(190627);
        return false;
    }
}

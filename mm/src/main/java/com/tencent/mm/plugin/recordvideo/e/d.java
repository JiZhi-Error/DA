package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", k.NAME, "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"})
public final class d {
    public static final d Cin = new d();

    static {
        AppMethodBeat.i(76222);
        AppMethodBeat.o(76222);
    }

    private d() {
    }

    public static void h(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(76220);
        p.h(recordConfigProvider, "configProvider");
        if (recordConfigProvider.BOm == null) {
            switch (recordConfigProvider.scene) {
                case 2:
                    e baZ = e.baZ();
                    p.g(baZ, "SubCoreVideoControl.getCore()");
                    recordConfigProvider.BOm = baZ.bbc();
                    break;
            }
            Log.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + recordConfigProvider.BOm);
        }
        AppMethodBeat.o(76220);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "", "width", "", "height", FFmpegMetadataRetriever.METADATA_KEY_DURATION, FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "videoBitrate", "fps", "matchScreenRatio", "", "useABA", "bitrateAdaptiveUp", "useMinMaxQP", "(IIIIIIZIII)V", "getBitrateAdaptiveUp", "()I", "getDuration", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getUseABA", "getUseMinMaxQP", "getVideoBitrate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-recordvideo_release"})
    public static final class a {
        public final boolean Cio;
        private final int Cip;
        public final int Ciq;
        private final int Cir;
        public final int dYT;
        public final int duration;
        public final int fps;
        public final int height;
        public final int videoBitrate;
        public final int width;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.width == aVar.width && this.height == aVar.height && this.duration == aVar.duration && this.dYT == aVar.dYT && this.videoBitrate == aVar.videoBitrate && this.fps == aVar.fps && this.Cio == aVar.Cio && this.Cip == aVar.Cip && this.Ciq == aVar.Ciq && this.Cir == aVar.Cir)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = ((((((((((this.width * 31) + this.height) * 31) + this.duration) * 31) + this.dYT) * 31) + this.videoBitrate) * 31) + this.fps) * 31;
            boolean z = this.Cio;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return ((((((i3 + i2) * 31) + this.Cip) * 31) + this.Ciq) * 31) + this.Cir;
        }

        public final String toString() {
            AppMethodBeat.i(76219);
            String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.dYT + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.Cio + ", useABA=" + this.Cip + ", bitrateAdaptiveUp=" + this.Ciq + ", useMinMaxQP=" + this.Cir + ")";
            AppMethodBeat.o(76219);
            return str;
        }

        public a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8, int i9, int i10) {
            this.width = i2;
            this.height = i3;
            this.duration = i4;
            this.dYT = i5;
            this.videoBitrate = i6;
            this.fps = i7;
            this.Cio = z;
            this.Cip = i8;
            this.Ciq = i9;
            this.Cir = i10;
        }
    }

    public static a aLQ(String str) {
        boolean z = true;
        AppMethodBeat.i(76221);
        p.h(str, "path");
        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str);
        if (aNx == null) {
            AppMethodBeat.o(76221);
            return null;
        }
        if (aNx.height <= 0 || aNx.width <= 0) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                aNx.width = Util.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                aNx.height = Util.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                aNx.videoBitrate = Util.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
            }
        }
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str);
        Point az = ao.az(MMApplicationContext.getContext());
        boolean z2 = mp4RotateVFS == 270 || mp4RotateVFS == 90;
        if (((double) Math.abs((((float) (z2 ? aNx.height : aNx.width)) / ((float) (z2 ? aNx.width : aNx.height))) - (((float) az.x) / ((float) az.y)))) > 0.01d) {
            z = false;
        }
        a aVar = new a(aNx.width, aNx.height, aNx.videoDuration, mp4RotateVFS, aNx.videoBitrate, aNx.frameRate, z, aNx.Cip, aNx.Ciq, aNx.Cir);
        AppMethodBeat.o(76221);
        return aVar;
    }
}

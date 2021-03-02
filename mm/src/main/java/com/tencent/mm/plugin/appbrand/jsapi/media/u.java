package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "size", "width", "", "height", "(JJII)V", "getDuration", "()J", "getHeight", "()I", "getSize", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "Companion", "plugin-appbrand-integration_release"})
public final class u {
    public static final a meK = new a((byte) 0);
    final long duration;
    final int height;
    final long size;
    final int width;

    static {
        AppMethodBeat.i(50581);
        AppMethodBeat.o(50581);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof u) {
                u uVar = (u) obj;
                if (!(this.duration == uVar.duration && this.size == uVar.size && this.width == uVar.width && this.height == uVar.height)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.duration;
        long j3 = this.size;
        return (((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        AppMethodBeat.i(50582);
        String str = "VideoMetaData(duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ")";
        AppMethodBeat.o(50582);
        return str;
    }

    public u(long j2, long j3, int i2, int i3) {
        this.duration = j2;
        this.size = j3;
        this.width = i2;
        this.height = i3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData$Companion;", "", "()V", "TAG", "", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "path", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static u aaq(String str) {
            int i2;
            int i3;
            AppMethodBeat.i(50580);
            p.h(str, "path");
            if (!s.YS(str)) {
                AppMethodBeat.o(50580);
                return null;
            }
            try {
                d dVar = new d();
                dVar.setDataSource(str);
                int i4 = Util.getInt(dVar.extractMetadata(24), 0);
                if (i4 == 90 || i4 == 270) {
                    i3 = Util.getInt(dVar.extractMetadata(19), 0);
                    i2 = Util.getInt(dVar.extractMetadata(18), 0);
                } else {
                    i3 = Util.getInt(dVar.extractMetadata(18), 0);
                    i2 = Util.getInt(dVar.extractMetadata(19), 0);
                }
                long j2 = Util.getLong(dVar.extractMetadata(9), 0);
                dVar.release();
                u uVar = new u(j2, s.boW(str), i3, i2);
                AppMethodBeat.o(50580);
                return uVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoMetaData", "MetaDataRetriever failed, e = ".concat(String.valueOf(e2)));
                AppMethodBeat.o(50580);
                return null;
            }
        }
    }
}

package com.tencent.mm.videocomposition;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/videocomposition/VideoClipInfo;", "", "width", "", "height", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "durationMs", "(IIII)V", "getDurationMs", "()I", "getHeight", "getRotate", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "video_composition_release"})
public final class m {
    private final int dYT;
    final int height;
    private final int jkS;
    final int width;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            if (!(this.width == mVar.width)) {
                return false;
            }
            if (!(this.height == mVar.height)) {
                return false;
            }
            if (!(this.dYT == mVar.dYT)) {
                return false;
            }
            if (!(this.jkS == mVar.jkS)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.dYT) * 31) + this.jkS;
    }

    public final String toString() {
        AppMethodBeat.i(216764);
        String str = "VideoClipInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.dYT + ", durationMs=" + this.jkS + ")";
        AppMethodBeat.o(216764);
        return str;
    }

    public m(int i2, int i3, int i4, int i5) {
        this.width = i2;
        this.height = i3;
        this.dYT = i4;
        this.jkS = i5;
    }
}

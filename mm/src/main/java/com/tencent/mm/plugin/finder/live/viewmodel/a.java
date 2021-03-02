package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "audienceNum", "likeCount", "newFans", "wecoinHot", "", "(IIIIJ)V", "getAudienceNum", "()I", "setAudienceNum", "(I)V", "getDuration", "setDuration", "getLikeCount", "setLikeCount", "getNewFans", "setNewFans", "getWecoinHot", "()J", "setWecoinHot", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class a {
    public int duration;
    public int likeCount;
    public int uCk;
    public int uCl;
    public long uCm;

    public a() {
        this(0, 0, 0, 0, 31);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!(this.duration == aVar.duration && this.uCk == aVar.uCk && this.likeCount == aVar.likeCount && this.uCl == aVar.uCl && this.uCm == aVar.uCm)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.uCm;
        return (((((((this.duration * 31) + this.uCk) * 31) + this.likeCount) * 31) + this.uCl) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, int i3, int i4, int i5, int i6) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 0 : i3, (i6 & 4) != 0 ? 0 : i4, (i6 & 8) == 0 ? i5 : 0, 0L);
        AppMethodBeat.i(247869);
        AppMethodBeat.o(247869);
    }

    public a(int i2, int i3, int i4, int i5, long j2) {
        this.duration = i2;
        this.uCk = i3;
        this.likeCount = i4;
        this.uCl = i5;
        this.uCm = j2;
    }

    public final String toString() {
        AppMethodBeat.i(247868);
        String str = "AnchorFinishInfo:duration:" + this.duration + ",audienceNum:" + this.uCk + ",likeCount:" + this.likeCount + ",newFans:" + this.uCl;
        AppMethodBeat.o(247868);
        return str;
    }
}

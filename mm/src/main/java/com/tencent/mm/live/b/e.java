package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/model/CloseLiveInfo;", "", "liveId", "", "(J)V", "getLiveId", "()J", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-logic_release"})
public final class e {
    public final long liveId;

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof e) && this.liveId == ((e) obj).liveId);
    }

    public final int hashCode() {
        long j2 = this.liveId;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public final String toString() {
        AppMethodBeat.i(207560);
        String str = "CloseLiveInfo(liveId=" + this.liveId + ")";
        AppMethodBeat.o(207560);
        return str;
    }

    public e(long j2) {
        this.liveId = j2;
    }
}

package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "", "liveId", "", "enable", "", "(JZ)V", "getEnable", "()Z", "getLiveId", "()J", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-logic_release"})
public final class d {
    public final boolean enable;
    public final long liveId;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (!(this.liveId == dVar.liveId && this.enable == dVar.enable)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.liveId;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        boolean z = this.enable;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i3 + i2;
    }

    public final String toString() {
        AppMethodBeat.i(207559);
        String str = "CloseApplyLiveMicInfo(liveId=" + this.liveId + ", enable=" + this.enable + ")";
        AppMethodBeat.o(207559);
        return str;
    }

    public d(long j2, boolean z) {
        this.liveId = j2;
        this.enable = z;
    }
}

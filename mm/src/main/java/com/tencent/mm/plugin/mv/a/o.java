package com.tencent.mm.plugin.mv.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0013\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001a\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u0004¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/StatRecord;", "", FirebaseAnalytics.b.INDEX, "", "(I)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "getIndex", "()I", "setIndex", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "retryPlayTimes", "getRetryPlayTimes", "setRetryPlayTimes", "vidPlayLen", "getVidPlayLen", "setVidPlayLen", "component1", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-mv_release"})
public final class o {
    public int UZx;
    int index;
    public boolean isAutoPlay = true;
    long loa = cl.aWA();
    public int vfX;
    public int vfY;
    public long vgi;

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof o) && this.index == ((o) obj).index);
    }

    public final int hashCode() {
        return this.index;
    }

    public final String toString() {
        AppMethodBeat.i(259192);
        String str = "StatRecord(index=" + this.index + ")";
        AppMethodBeat.o(259192);
        return str;
    }

    public o(int i2) {
        AppMethodBeat.i(259191);
        this.index = i2;
        AppMethodBeat.o(259191);
    }
}

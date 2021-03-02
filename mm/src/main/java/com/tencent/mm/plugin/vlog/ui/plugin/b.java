package com.tencent.mm.plugin.vlog.ui.plugin;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "", "()V", "trackStates", "", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "restore", "restoreTrackTime", "", "TrackState", "plugin-vlog_release"})
public final class b {
    private Map<Integer, a> GGx = new LinkedHashMap();

    public b() {
        AppMethodBeat.i(191174);
        AppMethodBeat.o(191174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "", "transOrder", "", "trackStartTimeMs", "", "trackEndTimeMs", "(IJJ)V", "getTrackEndTimeMs", "()J", "getTrackStartTimeMs", "getTransOrder", "()I", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-vlog_release"})
    public static final class a {
        final long GGA;
        final int GGy;
        final long GGz;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.GGy == aVar.GGy && this.GGz == aVar.GGz && this.GGA == aVar.GGA)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.GGz;
            long j3 = this.GGA;
            return (((this.GGy * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(191171);
            String str = "TrackState(transOrder=" + this.GGy + ", trackStartTimeMs=" + this.GGz + ", trackEndTimeMs=" + this.GGA + ")";
            AppMethodBeat.o(191171);
            return str;
        }

        public a(int i2, long j2, long j3) {
            this.GGy = i2;
            this.GGz = j2;
            this.GGA = j3;
        }
    }

    public final ac c(ac acVar) {
        AppMethodBeat.i(191172);
        p.h(acVar, "composition");
        this.GGx.clear();
        for (T t : acVar.Gzn) {
            this.GGx.put(Integer.valueOf(t.id), new a(t.Gzy, t.GzA.GGz, t.GzA.GGA));
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            com.tencent.mm.plugin.vlog.model.local.a.a(t, 0);
        }
        AppMethodBeat.o(191172);
        return acVar;
    }

    public final ac c(ac acVar, boolean z) {
        AppMethodBeat.i(191173);
        p.h(acVar, "composition");
        for (T t : acVar.Gzn) {
            a aVar = this.GGx.get(Integer.valueOf(t.id));
            if (aVar != null) {
                if (z) {
                    t.KQ(aVar.GGz);
                    t.KR(aVar.GGA);
                }
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                com.tencent.mm.plugin.vlog.model.local.a.a(t, aVar.GGy);
            }
        }
        AppMethodBeat.o(191173);
        return acVar;
    }
}

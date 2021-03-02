package com.tencent.mm.plugin.finder.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "tabType", "", "store", "progress", AppMeasurement.Param.TIMESTAMP, "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM extends UIComponentPlugin<PluginFinder> {
    public static final b wva = new b((byte) 0);
    private a wuZ;

    static {
        AppMethodBeat.i(255405);
        AppMethodBeat.o(255405);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void ah(String str, int i2, int i3) {
        AppMethodBeat.i(255402);
        p.h(str, "mediaId");
        Log.i("Finder.VideoStateCacheVM", "[store] mediaId=" + str + " progress=" + i2 + " timestamp=" + i3);
        a aVar = new a(str);
        aVar.progress = i2;
        aVar.wvb = (double) i3;
        this.wuZ = aVar;
        AppMethodBeat.o(255402);
    }

    public final void clear() {
        AppMethodBeat.i(255403);
        Log.i("Finder.VideoStateCacheVM", "[clear]");
        this.wuZ = null;
        AppMethodBeat.o(255403);
    }

    public final a dR(String str, int i2) {
        String str2;
        AppMethodBeat.i(255404);
        p.h(str, "mediaId");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        if (!((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).JN(i2)) {
            a aVar2 = this.wuZ;
            if (aVar2 != null) {
                str2 = aVar2.mediaId;
            } else {
                str2 = null;
            }
            if (p.j(str2, str)) {
                a aVar3 = this.wuZ;
                AppMethodBeat.o(255404);
                return aVar3;
            }
        }
        AppMethodBeat.o(255404);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", AppMeasurement.Param.TIMESTAMP, "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class a {
        final String mediaId;
        public int progress;
        double wvb;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(255401);
            if (this == obj || ((obj instanceof a) && p.j(this.mediaId, ((a) obj).mediaId))) {
                AppMethodBeat.o(255401);
                return true;
            }
            AppMethodBeat.o(255401);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(255400);
            String str = this.mediaId;
            if (str != null) {
                int hashCode = str.hashCode();
                AppMethodBeat.o(255400);
                return hashCode;
            }
            AppMethodBeat.o(255400);
            return 0;
        }

        public final String toString() {
            AppMethodBeat.i(255399);
            String str = "Cache(mediaId=" + this.mediaId + ")";
            AppMethodBeat.o(255399);
            return str;
        }

        public a(String str) {
            p.h(str, "mediaId");
            AppMethodBeat.i(255398);
            this.mediaId = str;
            AppMethodBeat.o(255398);
        }
    }
}

package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apa;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\nH\u0014J\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM extends ViewModel {
    public static final b wuS = new b((byte) 0);
    public final ConcurrentHashMap<Integer, a> wtV = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(255388);
        AppMethodBeat.o(255388);
    }

    public FinderTagCacheVM() {
        AppMethodBeat.i(255387);
        AppMethodBeat.o(255387);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.arch.lifecycle.ViewModel
    public final void onCleared() {
        AppMethodBeat.i(255386);
        super.onCleared();
        this.wtV.clear();
        AppMethodBeat.o(255386);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a {
        private final int dLS = 4;
        public apa wuT = new apa();
        public int wuU = -1;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof a) && this.dLS == ((a) obj).dLS);
        }

        public final int hashCode() {
            return this.dLS;
        }

        public final String toString() {
            AppMethodBeat.i(255385);
            String str = "Cache(tabType=" + this.dLS + ")";
            AppMethodBeat.o(255385);
            return str;
        }

        public a() {
            AppMethodBeat.i(255384);
            AppMethodBeat.o(255384);
        }
    }
}

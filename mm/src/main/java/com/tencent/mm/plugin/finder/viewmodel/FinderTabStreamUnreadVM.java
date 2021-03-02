package com.tencent.mm.plugin.finder.viewmodel;

import android.util.LongSparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "followCollector", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "friendCollector", "machineCollector", "collectDeprecatedFeeds", "", "tabType", "", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectReadFeeds", "commentScene", "readList", "isGlobalRead", "", "feedId", "", "isRead", "Companion", "TabStreamCollector", "plugin-finder_release"})
public final class FinderTabStreamUnreadVM extends UIComponentPlugin<PluginFinder> {
    public static final a wuN = new a((byte) 0);
    public final b wuK = new b(1);
    public final b wuL = new b(3);
    public final b wuM = new b(4);

    static {
        AppMethodBeat.i(255383);
        AppMethodBeat.o(255383);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderTabStreamUnreadVM() {
        AppMethodBeat.i(255382);
        AppMethodBeat.o(255382);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void o(int i2, List<? extends bo> list) {
        AppMethodBeat.i(255381);
        if (list == null) {
            AppMethodBeat.o(255381);
            return;
        }
        StringBuilder append = new StringBuilder("[collectReadFeeds] commentScene=").append(i2).append(" readList=").append(list.size()).append(" first=");
        bo boVar = (bo) j.kt(list);
        Log.i("Finder.TabStreamUnreadVM", append.append(d.zs(boVar != null ? boVar.lT() : 0)).toString());
        switch (i2) {
            case 17:
                this.wuL.eI(list).aWm();
                AppMethodBeat.o(255381);
                return;
            case 18:
                this.wuK.eI(list).aWm();
                AppMethodBeat.o(255381);
                return;
            case 19:
                this.wuM.eI(list).aWm();
                break;
        }
        AppMethodBeat.o(255381);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector;", "", "tabType", "", "(I)V", "deprecatedCollection", "Landroid/util/LongSparseArray;", "", "lock", "getLock", "()Ljava/lang/Object;", "readCollection", "checkReport", "", "collectDeprecated", "deprecatedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "collectRead", "readList", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "isRead", "feedId", "", "printSparseArray", "list", "toString", "plugin-finder_release"})
    public static final class b {
        final int dLS;
        private final Object lock = new Object();
        final LongSparseArray<String> wuO = new LongSparseArray<>();
        private final LongSparseArray<String> wuP = new LongSparseArray<>();

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof b) && this.dLS == ((b) obj).dLS);
        }

        public final int hashCode() {
            return this.dLS;
        }

        public final String toString() {
            AppMethodBeat.i(255380);
            String str = "TabStreamCollector(tabType=" + this.dLS + ")";
            AppMethodBeat.o(255380);
            return str;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "feedId", "", "<anonymous parameter 1>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$1"})
        public static final class a extends q implements m<Long, String, Boolean> {
            final /* synthetic */ LinkedList vGy;
            final /* synthetic */ b wuQ;
            final /* synthetic */ bbn wuR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, LinkedList linkedList, bbn bbn) {
                super(2);
                this.wuQ = bVar;
                this.vGy = linkedList;
                this.wuR = bbn;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ Boolean invoke(Long l, String str) {
                boolean z;
                AppMethodBeat.i(255374);
                long longValue = l.longValue();
                p.h(str, "<anonymous parameter 1>");
                if (this.wuQ.wuO.indexOfKey(longValue) < 0) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(255374);
                return valueOf;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "k", "", "v", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM$TabStreamCollector$checkReport$1$2"})
        /* renamed from: com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM$b$b  reason: collision with other inner class name */
        public static final class C1350b extends q implements m<Long, String, x> {
            final /* synthetic */ LinkedList vGy;
            final /* synthetic */ b wuQ;
            final /* synthetic */ bbn wuR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1350b(b bVar, LinkedList linkedList, bbn bbn) {
                super(2);
                this.wuQ = bVar;
                this.vGy = linkedList;
                this.wuR = bbn;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, String str) {
                AppMethodBeat.i(255375);
                long longValue = l.longValue();
                String str2 = str;
                p.h(str2, "v");
                LinkedList linkedList = this.vGy;
                bdv bdv = new bdv();
                bdv.hFK = longValue;
                bdv.objectNonceId = str2;
                bdv.dLS = this.wuQ.dLS;
                k kVar = k.vfA;
                bdv.sessionBuffer = k.G(bdv.hFK, this.wuR.tCE);
                linkedList.add(bdv);
                x xVar = x.SXb;
                AppMethodBeat.o(255375);
                return xVar;
            }
        }

        public b(int i2) {
            AppMethodBeat.i(255379);
            this.dLS = i2;
            AppMethodBeat.o(255379);
        }

        public final boolean Gz(long j2) {
            AppMethodBeat.i(255376);
            if (this.wuO.indexOfKey(j2) >= 0) {
                AppMethodBeat.o(255376);
                return true;
            }
            AppMethodBeat.o(255376);
            return false;
        }

        public final b eI(List<? extends bo> list) {
            AppMethodBeat.i(255377);
            p.h(list, "readList");
            synchronized (this.lock) {
                try {
                    for (T t : list) {
                        if (this.wuO.indexOfKey(t.lT()) < 0) {
                            this.wuO.append(t.lT(), t instanceof BaseFinderFeed ? t.feedObject.getObjectNonceId() : "");
                        }
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(255377);
                }
            }
            return this;
        }

        public final void aWm() {
            AppMethodBeat.i(255378);
            LinkedList linkedList = new LinkedList();
            bbn bbn = new bbn();
            k kVar = k.vfA;
            bbn.tCE = k.Kw(this.dLS);
            synchronized (this.lock) {
                try {
                    d.b(d.a(this.wuP, new a(this, linkedList, bbn)), new C1350b(this, linkedList, bbn));
                    if (this.wuP.size() > 0) {
                        this.wuP.clear();
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(255378);
                }
            }
            if (!linkedList.isEmpty()) {
                StringBuilder append = new StringBuilder("[checkReport] tabType=").append(this.dLS).append(", begin to report unread... ");
                LinkedList<bdv> linkedList2 = linkedList;
                ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
                for (bdv bdv : linkedList2) {
                    arrayList.add(d.zs(bdv.hFK));
                }
                Log.i("Finder.TabStreamUnreadVM", append.append(arrayList).toString());
                new com.tencent.mm.plugin.finder.cgi.a(linkedList, bbn).aYI();
            }
        }
    }
}

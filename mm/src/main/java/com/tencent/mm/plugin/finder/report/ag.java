package com.tencent.mm.plugin.finder.report;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class ag extends e<a> {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", FirebaseAnalytics.b.INDEX, "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"})
    public interface a {
        void a(long j2, cjl cjl, String str, int i2, LinkedList<cjl> linkedList, BaseFinderFeed baseFinderFeed, boolean z);
    }

    public ag(com.tencent.mm.plugin.finder.event.base.c cVar) {
        super(cVar);
        AppMethodBeat.i(166715);
        AppMethodBeat.o(166715);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", FirebaseAnalytics.b.INDEX, "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"})
    public static final class c implements a {
        final /* synthetic */ ag viK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(ag agVar) {
            this.viK = agVar;
        }

        @Override // com.tencent.mm.plugin.finder.report.ag.a
        public final void a(long j2, cjl cjl, String str, int i2, LinkedList<cjl> linkedList, BaseFinderFeed baseFinderFeed, boolean z) {
            AppMethodBeat.i(250867);
            p.h(cjl, "media");
            p.h(str, "objectNonceId");
            p.h(linkedList, "mediaList");
            p.h(baseFinderFeed, "feed");
            this.viK.c(new b(j2, cjl, str, i2, linkedList, baseFinderFeed, z));
            AppMethodBeat.o(250867);
        }
    }

    public final a doV() {
        AppMethodBeat.i(166714);
        c cVar = new c(this);
        AppMethodBeat.o(166714);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\u000fHÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", FirebaseAnalytics.b.INDEX, "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "()Z", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "plugin-finder_release"})
    public static final class b extends com.tencent.mm.plugin.finder.event.base.b {
        final long feedId;
        final int index;
        private final LinkedList<cjl> mediaList;
        private final String objectNonceId;
        final cjl tHM;
        private final BaseFinderFeed tNO;
        final boolean viJ;

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
            if (r5.viJ == r6.viJ) goto L_0x004a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 166712(0x28b38, float:2.33613E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x004a
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.report.ag.b
                if (r0 == 0) goto L_0x004f
                com.tencent.mm.plugin.finder.report.ag$b r6 = (com.tencent.mm.plugin.finder.report.ag.b) r6
                long r0 = r5.feedId
                long r2 = r6.feedId
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x004f
                com.tencent.mm.protocal.protobuf.cjl r0 = r5.tHM
                com.tencent.mm.protocal.protobuf.cjl r1 = r6.tHM
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004f
                java.lang.String r0 = r5.objectNonceId
                java.lang.String r1 = r6.objectNonceId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004f
                int r0 = r5.index
                int r1 = r6.index
                if (r0 != r1) goto L_0x004f
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.cjl> r0 = r5.mediaList
                java.util.LinkedList<com.tencent.mm.protocal.protobuf.cjl> r1 = r6.mediaList
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004f
                com.tencent.mm.plugin.finder.model.BaseFinderFeed r0 = r5.tNO
                com.tencent.mm.plugin.finder.model.BaseFinderFeed r1 = r6.tNO
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004f
                boolean r0 = r5.viJ
                boolean r1 = r6.viJ
                if (r0 != r1) goto L_0x004f
            L_0x004a:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x004e:
                return r0
            L_0x004f:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x004e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.ag.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(166711);
            long j2 = this.feedId;
            int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            cjl cjl = this.tHM;
            int hashCode = ((cjl != null ? cjl.hashCode() : 0) + i3) * 31;
            String str = this.objectNonceId;
            int hashCode2 = ((((str != null ? str.hashCode() : 0) + hashCode) * 31) + this.index) * 31;
            LinkedList<cjl> linkedList = this.mediaList;
            int hashCode3 = ((linkedList != null ? linkedList.hashCode() : 0) + hashCode2) * 31;
            BaseFinderFeed baseFinderFeed = this.tNO;
            if (baseFinderFeed != null) {
                i2 = baseFinderFeed.hashCode();
            }
            int i4 = (hashCode3 + i2) * 31;
            boolean z = this.viJ;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = i5 + i4;
            AppMethodBeat.o(166711);
            return i8;
        }

        public final String toString() {
            AppMethodBeat.i(166710);
            String str = "PageChangeEvent(feedId=" + this.feedId + ", media=" + this.tHM + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.tNO + ", isAuto=" + this.viJ + ")";
            AppMethodBeat.o(166710);
            return str;
        }

        public b(long j2, cjl cjl, String str, int i2, LinkedList<cjl> linkedList, BaseFinderFeed baseFinderFeed, boolean z) {
            p.h(cjl, "media");
            p.h(str, "objectNonceId");
            p.h(linkedList, "mediaList");
            p.h(baseFinderFeed, "feed");
            AppMethodBeat.i(250866);
            this.feedId = j2;
            this.tHM = cjl;
            this.objectNonceId = str;
            this.index = i2;
            this.mediaList = linkedList;
            this.tNO = baseFinderFeed;
            this.viJ = z;
            AppMethodBeat.o(250866);
        }
    }
}

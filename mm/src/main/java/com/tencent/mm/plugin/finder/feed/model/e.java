package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache;", "", "()V", "CACHE_VAILD_DURATTION", "", "TAG", "", "userName2NoticeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "add", "", "userName", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "clear", "getNotice", "noticeInfoCacheItem", "plugin-finder_release"})
public final class e {
    private static final String TAG = TAG;
    private static final int tUW = tUW;
    private static final ConcurrentHashMap<String, a> tUX = new ConcurrentHashMap<>();
    public static final e tUY = new e();

    static {
        AppMethodBeat.i(244586);
        AppMethodBeat.o(244586);
    }

    private e() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0013J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "timeStamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;J)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "isVaild", "toString", "", "plugin-finder_release"})
    public static final class a {
        awt tUZ;
        private long timeStamp;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (r5.timeStamp == r6.timeStamp) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 244582(0x3bb66, float:3.42732E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0020
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.feed.model.e.a
                if (r0 == 0) goto L_0x0025
                com.tencent.mm.plugin.finder.feed.model.e$a r6 = (com.tencent.mm.plugin.finder.feed.model.e.a) r6
                com.tencent.mm.protocal.protobuf.awt r0 = r5.tUZ
                com.tencent.mm.protocal.protobuf.awt r1 = r6.tUZ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0025
                long r0 = r5.timeStamp
                long r2 = r6.timeStamp
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0024:
                return r0
            L_0x0025:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.e.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(244581);
            awt awt = this.tUZ;
            int hashCode = awt != null ? awt.hashCode() : 0;
            long j2 = this.timeStamp;
            int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
            AppMethodBeat.o(244581);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(244580);
            String str = "noticeInfoCacheItem(info=" + this.tUZ + ", timeStamp=" + this.timeStamp + ")";
            AppMethodBeat.o(244580);
            return str;
        }

        public /* synthetic */ a(awt awt) {
            this(awt, System.currentTimeMillis());
            AppMethodBeat.i(244579);
            AppMethodBeat.o(244579);
        }

        private a(awt awt, long j2) {
            p.h(awt, "info");
            AppMethodBeat.i(244578);
            this.tUZ = awt;
            this.timeStamp = j2;
            AppMethodBeat.o(244578);
        }

        public final boolean ddy() {
            AppMethodBeat.i(244577);
            long currentTimeMillis = System.currentTimeMillis() - this.timeStamp;
            e eVar = e.tUY;
            if (currentTimeMillis < ((long) e.tUW)) {
                AppMethodBeat.o(244577);
                return true;
            }
            AppMethodBeat.o(244577);
            return false;
        }
    }

    public static void a(String str, awt awt) {
        a aVar;
        AppMethodBeat.i(244583);
        p.h(str, "userName");
        p.h(awt, "info");
        synchronized (tUX) {
            try {
                Log.i(TAG, "[add] userName:".concat(String.valueOf(str)));
                if (!tUX.containsKey(str) || ((aVar = tUX.get(str)) != null && !aVar.ddy())) {
                    tUX.put(str, new a(awt));
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(244583);
            }
        }
    }

    public static awt ato(String str) {
        awt awt;
        AppMethodBeat.i(244584);
        p.h(str, "userName");
        synchronized (tUX) {
            try {
                a aVar = tUX.get(str);
                if (aVar == null) {
                    awt = null;
                } else if (!aVar.ddy()) {
                    tUX.remove(str);
                    awt = null;
                } else {
                    awt = aVar.tUZ;
                }
            } finally {
                AppMethodBeat.o(244584);
            }
        }
        return awt;
    }

    public static void clear() {
        AppMethodBeat.i(244585);
        synchronized (tUX) {
            try {
                tUX.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(244585);
            }
        }
    }
}

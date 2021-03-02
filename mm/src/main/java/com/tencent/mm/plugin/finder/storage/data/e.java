package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class e {
    private static final Map<Long, FinderItem> tsn = Collections.synchronizedMap(new HashMap());
    private static final Map<Long, FinderObject> vFU = Collections.synchronizedMap(new HashMap());
    private static final HashMap<Integer, LongSparseArray<FinderObject>> vFV = new HashMap<>();
    private static final HashMap<Integer, LongSparseArray<a.C1285a>> vFW = new HashMap<>();
    public static final a vFX = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u001c\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u001c\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\tJ\u0016\u0010'\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\tJ\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000RN\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000RN\u0010\u000b\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\f0\f \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\f0\f\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000R6\u0010\r\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010`\u0012X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "cacheMegaVideoItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedCaches", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "Lkotlin/collections/HashMap;", "historyItems", "clean", "", "collectFeed", "commentScene", "feeds", "", "collectHistoryFeed", "tabType", "collectMegaVideoFeed", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getById", "id", "getFeedRecTime", "getMegaVideoById", "isHistoryFeed", "", "remove", "svrId", "removeMegaVideo", "update", "finder", "updateMegaVideo", "item", "FeedData", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "", "feed", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "recTime", "", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;J)V", "getFeed", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getRecTime", "()J", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.storage.data.e$a$a  reason: collision with other inner class name */
        public static final class C1285a {
            private final com.tencent.mm.bw.a vFY;
            final long vFZ;

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
                if (r5.vFZ == r6.vFZ) goto L_0x0020;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r6) {
                /*
                    r5 = this;
                    r4 = 251971(0x3d843, float:3.53087E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    if (r5 == r6) goto L_0x0020
                    boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.storage.data.e.a.C1285a
                    if (r0 == 0) goto L_0x0025
                    com.tencent.mm.plugin.finder.storage.data.e$a$a r6 = (com.tencent.mm.plugin.finder.storage.data.e.a.C1285a) r6
                    com.tencent.mm.bw.a r0 = r5.vFY
                    com.tencent.mm.bw.a r1 = r6.vFY
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0025
                    long r0 = r5.vFZ
                    long r2 = r6.vFZ
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
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.data.e.a.C1285a.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                AppMethodBeat.i(251970);
                com.tencent.mm.bw.a aVar = this.vFY;
                int hashCode = aVar != null ? aVar.hashCode() : 0;
                long j2 = this.vFZ;
                int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
                AppMethodBeat.o(251970);
                return i2;
            }

            public final String toString() {
                AppMethodBeat.i(251969);
                String str = "FeedData(feed=" + this.vFY + ", recTime=" + this.vFZ + ")";
                AppMethodBeat.o(251969);
                return str;
            }

            public /* synthetic */ C1285a(com.tencent.mm.bw.a aVar) {
                this(aVar, cl.aWA());
                AppMethodBeat.i(251968);
                AppMethodBeat.o(251968);
            }

            private C1285a(com.tencent.mm.bw.a aVar, long j2) {
                p.h(aVar, "feed");
                AppMethodBeat.i(251967);
                this.vFY = aVar;
                this.vFZ = j2;
                AppMethodBeat.o(251967);
            }
        }

        public static FinderItem Fy(long j2) {
            AppMethodBeat.i(167045);
            FinderItem finderItem = (FinderItem) e.tsn.get(Long.valueOf(j2));
            AppMethodBeat.o(167045);
            return finderItem;
        }

        public static FinderObject FD(long j2) {
            AppMethodBeat.i(251972);
            FinderObject finderObject = (FinderObject) e.vFU.get(Long.valueOf(j2));
            AppMethodBeat.o(251972);
            return finderObject;
        }

        public static boolean n(FinderItem finderItem) {
            AppMethodBeat.i(167046);
            p.h(finderItem, "finder");
            Map map = e.tsn;
            p.g(map, "cacheItems");
            map.put(Long.valueOf(finderItem.field_id), finderItem);
            AppMethodBeat.o(167046);
            return true;
        }

        public static void j(FinderObject finderObject) {
            LinkedList<aop> linkedList;
            aop aop;
            bei bei;
            cng cng;
            AppMethodBeat.i(251973);
            p.h(finderObject, "item");
            aoq aoq = finderObject.attachmentList;
            Long valueOf = (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null) ? null : Long.valueOf(cng.id);
            if (valueOf != null) {
                valueOf.longValue();
                Map map = e.vFU;
                p.g(map, "cacheMegaVideoItems");
                map.put(valueOf, finderObject);
                AppMethodBeat.o(251973);
                return;
            }
            AppMethodBeat.o(251973);
        }

        public static boolean BX(long j2) {
            AppMethodBeat.i(251974);
            if (e.tsn.remove(Long.valueOf(j2)) != null) {
                AppMethodBeat.o(251974);
                return true;
            }
            AppMethodBeat.o(251974);
            return false;
        }

        public static boolean FE(long j2) {
            AppMethodBeat.i(251975);
            if (e.vFU.remove(Long.valueOf(j2)) != null) {
                AppMethodBeat.o(251975);
                return true;
            }
            AppMethodBeat.o(251975);
            return false;
        }

        public static void k(int i2, List<? extends FinderObject> list) {
            LongSparseArray longSparseArray;
            AppMethodBeat.i(251976);
            p.h(list, "feeds");
            synchronized (e.vFW) {
                try {
                    LongSparseArray longSparseArray2 = (LongSparseArray) e.vFW.get(Integer.valueOf(i2));
                    if (longSparseArray2 == null) {
                        a aVar = e.vFX;
                        longSparseArray = new LongSparseArray();
                        e.vFW.put(Integer.valueOf(i2), longSparseArray);
                    } else {
                        longSparseArray = longSparseArray2;
                    }
                    p.g(longSparseArray, "feedCaches[commentScene]…  cache\n                }");
                    for (T t : list) {
                        longSparseArray.append(t.id, new C1285a(t));
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(251976);
                }
            }
        }

        public static void l(int i2, List<? extends cng> list) {
            LongSparseArray longSparseArray;
            AppMethodBeat.i(251977);
            p.h(list, "feeds");
            synchronized (e.vFW) {
                try {
                    LongSparseArray longSparseArray2 = (LongSparseArray) e.vFW.get(Integer.valueOf(i2));
                    if (longSparseArray2 == null) {
                        a aVar = e.vFX;
                        longSparseArray = new LongSparseArray();
                        e.vFW.put(Integer.valueOf(i2), longSparseArray);
                    } else {
                        longSparseArray = longSparseArray2;
                    }
                    p.g(longSparseArray, "feedCaches[commentScene]…  cache\n                }");
                    for (T t : list) {
                        longSparseArray.append(t.id, new C1285a(t));
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(251977);
                }
            }
        }

        public static long ak(int i2, long j2) {
            long j3;
            AppMethodBeat.i(251978);
            synchronized (e.vFW) {
                try {
                    LongSparseArray longSparseArray = (LongSparseArray) e.vFW.get(Integer.valueOf(i2));
                    if (longSparseArray == null) {
                        a aVar = e.vFX;
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        e.vFW.put(Integer.valueOf(i2), longSparseArray2);
                        longSparseArray = longSparseArray2;
                    }
                    p.g(longSparseArray, "feedCaches[commentScene]…  cache\n                }");
                    if (longSparseArray.indexOfKey(j2) >= 0) {
                        C1285a aVar2 = (C1285a) longSparseArray.get(j2);
                        if (aVar2 != null) {
                            j3 = aVar2.vFZ;
                        } else {
                            j3 = 0;
                        }
                        return j3;
                    }
                    AppMethodBeat.o(251978);
                    return 0;
                } finally {
                    AppMethodBeat.o(251978);
                }
            }
        }

        public static void m(int i2, List<? extends FinderObject> list) {
            LongSparseArray longSparseArray;
            AppMethodBeat.i(251979);
            p.h(list, "feeds");
            synchronized (e.vFV) {
                try {
                    LongSparseArray longSparseArray2 = (LongSparseArray) e.vFV.get(Integer.valueOf(i2));
                    if (longSparseArray2 == null) {
                        a aVar = e.vFX;
                        longSparseArray = new LongSparseArray();
                        e.vFV.put(Integer.valueOf(i2), longSparseArray);
                    } else {
                        longSparseArray = longSparseArray2;
                    }
                    p.g(longSparseArray, "historyItems[tabType] ?:…  cache\n                }");
                    for (T t : list) {
                        longSparseArray.append(t.id, t);
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(251979);
                }
            }
        }

        public static boolean al(int i2, long j2) {
            boolean z;
            AppMethodBeat.i(251980);
            synchronized (e.vFV) {
                try {
                    LongSparseArray longSparseArray = (LongSparseArray) e.vFV.get(Integer.valueOf(i2));
                    if (longSparseArray == null) {
                        a aVar = e.vFX;
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        e.vFV.put(Integer.valueOf(i2), longSparseArray2);
                        longSparseArray = longSparseArray2;
                    }
                    p.g(longSparseArray, "historyItems[tabType] ?:…  cache\n                }");
                    z = longSparseArray.indexOfKey(j2) >= 0;
                } finally {
                    AppMethodBeat.o(251980);
                }
            }
            return z;
        }
    }

    static {
        AppMethodBeat.i(167047);
        AppMethodBeat.o(167047);
    }
}

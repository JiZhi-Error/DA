package com.tencent.mm.plugin.finder.view;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.o;

public final class e {
    private static final ConcurrentHashMap<Long, o<a.C1338a, a.b>> wkw = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, a.c> wkx = new ConcurrentHashMap<>();
    public static final a wky = new a((byte) 0);
    private CommentDrawerContract.CloseDrawerCallback tMR;
    public FinderCommentDrawer tNb;
    private boolean tZA;
    private long tZB;
    private int tZC;
    private MMFragmentActivity wkt;
    private final a.C1338a wku;
    private a.b wkv;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* renamed from: com.tencent.mm.plugin.finder.view.e$a$a */
        public static final class C1338a {
            public final int scene;
            public final boolean tAj;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof C1338a) {
                        C1338a aVar = (C1338a) obj;
                        if (!(this.scene == aVar.scene && this.tAj == aVar.tAj)) {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                int i2 = this.scene * 31;
                boolean z = this.tAj;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i3 + i2;
            }

            public final String toString() {
                AppMethodBeat.i(254710);
                String str = "DrawerCreateData(scene=" + this.scene + ", safeMode=" + this.tAj + ")";
                AppMethodBeat.o(254710);
                return str;
            }

            public C1338a(int i2, boolean z) {
                this.scene = i2;
                this.tAj = z;
            }
        }

        public static final class b {
            public final FinderItem tMO;
            public final boolean tMV;
            public final boolean tMW;
            public final long tuj;
            public final an wkA;
            public final boolean wkz;

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
                if (kotlin.g.b.p.j(r5.wkA, r6.wkA) != false) goto L_0x003c;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r6) {
                /*
                    r5 = this;
                    r4 = 254714(0x3e2fa, float:3.5693E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    if (r5 == r6) goto L_0x003c
                    boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.view.e.a.b
                    if (r0 == 0) goto L_0x0041
                    com.tencent.mm.plugin.finder.view.e$a$b r6 = (com.tencent.mm.plugin.finder.view.e.a.b) r6
                    com.tencent.mm.plugin.finder.storage.FinderItem r0 = r5.tMO
                    com.tencent.mm.plugin.finder.storage.FinderItem r1 = r6.tMO
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0041
                    boolean r0 = r5.tMV
                    boolean r1 = r6.tMV
                    if (r0 != r1) goto L_0x0041
                    long r0 = r5.tuj
                    long r2 = r6.tuj
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 != 0) goto L_0x0041
                    boolean r0 = r5.tMW
                    boolean r1 = r6.tMW
                    if (r0 != r1) goto L_0x0041
                    boolean r0 = r5.wkz
                    boolean r1 = r6.wkz
                    if (r0 != r1) goto L_0x0041
                    com.tencent.mm.plugin.finder.storage.an r0 = r5.wkA
                    com.tencent.mm.plugin.finder.storage.an r1 = r6.wkA
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0041
                L_0x003c:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                L_0x0040:
                    return r0
                L_0x0041:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    goto L_0x0040
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.e.a.b.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                int i3 = 1;
                AppMethodBeat.i(254713);
                FinderItem finderItem = this.tMO;
                int hashCode = (finderItem != null ? finderItem.hashCode() : 0) * 31;
                boolean z = this.tMV;
                if (z) {
                    z = true;
                }
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                int i6 = z ? 1 : 0;
                long j2 = this.tuj;
                int i7 = (((i4 + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
                boolean z2 = this.tMW;
                if (z2) {
                    z2 = true;
                }
                int i8 = z2 ? 1 : 0;
                int i9 = z2 ? 1 : 0;
                int i10 = z2 ? 1 : 0;
                int i11 = (i8 + i7) * 31;
                boolean z3 = this.wkz;
                if (!z3) {
                    i3 = z3 ? 1 : 0;
                }
                int i12 = (i11 + i3) * 31;
                an anVar = this.wkA;
                if (anVar != null) {
                    i2 = anVar.hashCode();
                }
                int i13 = i12 + i2;
                AppMethodBeat.o(254713);
                return i13;
            }

            public final String toString() {
                AppMethodBeat.i(254712);
                String str = "DrawerOpenData(feedObj=" + this.tMO + ", isSingleMode=" + this.tMV + ", refCommentId=" + this.tuj + ", blinkRefComment=" + this.tMW + ", showFooter=" + this.wkz + ", replyCommentObj=" + this.wkA + ")";
                AppMethodBeat.o(254712);
                return str;
            }

            public b(FinderItem finderItem, boolean z, long j2, boolean z2, boolean z3, an anVar) {
                p.h(finderItem, "feedObj");
                AppMethodBeat.i(254711);
                this.tMO = finderItem;
                this.tMV = z;
                this.tuj = j2;
                this.tMW = z2;
                this.wkz = z3;
                this.wkA = anVar;
                AppMethodBeat.o(254711);
            }
        }

        public static final class c {
            final int commentCount;
            final List<s> qzs;

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
                if (kotlin.g.b.p.j(r3.qzs, r4.qzs) != false) goto L_0x001e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 254718(0x3e2fe, float:3.56936E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x001e
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.view.e.a.c
                    if (r0 == 0) goto L_0x0023
                    com.tencent.mm.plugin.finder.view.e$a$c r4 = (com.tencent.mm.plugin.finder.view.e.a.c) r4
                    int r0 = r3.commentCount
                    int r1 = r4.commentCount
                    if (r0 != r1) goto L_0x0023
                    java.util.List<com.tencent.mm.plugin.finder.model.s> r0 = r3.qzs
                    java.util.List<com.tencent.mm.plugin.finder.model.s> r1 = r4.qzs
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0023
                L_0x001e:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0022:
                    return r0
                L_0x0023:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0022
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.e.a.c.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                AppMethodBeat.i(254717);
                int i2 = this.commentCount * 31;
                List<s> list = this.qzs;
                int hashCode = (list != null ? list.hashCode() : 0) + i2;
                AppMethodBeat.o(254717);
                return hashCode;
            }

            public final String toString() {
                AppMethodBeat.i(254716);
                String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.qzs + ")";
                AppMethodBeat.o(254716);
                return str;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.finder.model.s> */
            /* JADX WARN: Multi-variable type inference failed */
            public c(int i2, List<? extends s> list) {
                p.h(list, "data");
                AppMethodBeat.i(254715);
                this.commentCount = i2;
                this.qzs = list;
                AppMethodBeat.o(254715);
            }
        }

        public static /* synthetic */ e a(MMFragmentActivity mMFragmentActivity, View view, int i2, boolean z, int i3, int i4) {
            AppMethodBeat.i(254720);
            if ((i4 & 8) != 0) {
                z = false;
            }
            if ((i4 & 16) != 0) {
                i3 = 58;
            }
            e a2 = a(mMFragmentActivity, view, i2, z, i3);
            AppMethodBeat.o(254720);
            return a2;
        }

        public static e a(MMFragmentActivity mMFragmentActivity, View view, int i2, boolean z, int i3) {
            AppMethodBeat.i(254719);
            p.h(mMFragmentActivity, "context");
            p.h(view, "parent");
            mMFragmentActivity.getWindow().setSoftInputMode(50);
            e eVar = new e(i2, z, (byte) 0);
            eVar.wkt = mMFragmentActivity;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsr().value().intValue() == 1) {
                eVar.tNb = null;
            } else {
                FinderCommentDrawer.b bVar = FinderCommentDrawer.wkG;
                eVar.tNb = FinderCommentDrawer.b.a(mMFragmentActivity, view, i2, null, z, false, i3, 8);
            }
            AppMethodBeat.o(254719);
            return eVar;
        }

        public static /* synthetic */ e b(long j2, int i2, MMFragmentActivity mMFragmentActivity, int i3) {
            AppMethodBeat.i(254722);
            e a2 = a(j2, i2, mMFragmentActivity, i3);
            AppMethodBeat.o(254722);
            return a2;
        }

        private static e a(long j2, int i2, MMFragmentActivity mMFragmentActivity, int i3) {
            AppMethodBeat.i(254721);
            p.h(mMFragmentActivity, "context");
            e eVar = new e(i3, false, (byte) 0);
            eVar.tZB = j2;
            eVar.tZC = i2;
            eVar.wkt = mMFragmentActivity;
            eVar.tNb = null;
            eVar.tZA = true;
            AppMethodBeat.o(254721);
            return eVar;
        }

        public static c at(Intent intent) {
            AppMethodBeat.i(254723);
            p.h(intent, "intent");
            c cVar = (c) e.wkx.remove(Long.valueOf(intent.getLongExtra("COMMENT_RESULT_KEY", 0)));
            AppMethodBeat.o(254723);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(254732);
        AppMethodBeat.o(254732);
    }

    public e() {
        this.wku = null;
    }

    public /* synthetic */ e(int i2, boolean z, byte b2) {
        this(i2, z);
    }

    private e(int i2, boolean z) {
        AppMethodBeat.i(254731);
        this.wku = new a.C1338a(i2, z);
        AppMethodBeat.o(254731);
    }

    public static /* synthetic */ void a(e eVar, FinderItem finderItem, long j2, boolean z, boolean z2, boolean z3, CommentDrawerContract.CloseDrawerCallback closeDrawerCallback, int i2) {
        long j3;
        boolean z4;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(254725);
        if ((i2 & 4) != 0) {
            j3 = 0;
        } else {
            j3 = j2;
        }
        if ((i2 & 8) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i2 & 16) != 0) {
            z5 = true;
        } else {
            z5 = z2;
        }
        if ((i2 & 64) != 0) {
            z6 = false;
        } else {
            z6 = z3;
        }
        eVar.a(finderItem, false, j3, z4, z5, null, z6, 0, (i2 & 256) != 0 ? null : closeDrawerCallback);
        AppMethodBeat.o(254725);
    }

    public final void a(FinderItem finderItem, boolean z, long j2, boolean z2, boolean z3, an anVar, boolean z4, int i2, CommentDrawerContract.CloseDrawerCallback closeDrawerCallback) {
        AppMethodBeat.i(254724);
        p.h(finderItem, "feedObj");
        this.tMR = closeDrawerCallback;
        c cVar = c.vCb;
        if (c.dsr().value().intValue() == 1) {
            y yVar = y.vXH;
            a.C1338a aVar = this.wku;
            MMFragmentActivity mMFragmentActivity = this.wkt;
            if (!(aVar == null || mMFragmentActivity == null)) {
                this.wkv = new a.b(finderItem, z, j2, z2, z3, anVar);
                long currentTimeMillis = System.currentTimeMillis();
                ConcurrentHashMap<Long, o<a.C1338a, a.b>> concurrentHashMap = wkw;
                Long valueOf = Long.valueOf(currentTimeMillis);
                a.b bVar = this.wkv;
                if (bVar == null) {
                    p.btv("drawerOpenData");
                }
                concurrentHashMap.put(valueOf, new o<>(aVar, bVar));
                Intent intent = new Intent();
                intent.putExtra("COMMENT_REQUEST_KEY", currentTimeMillis);
                intent.putExtra("FROM_MSG", this.tZA);
                intent.putExtra("MENTION_ID", this.tZB);
                intent.putExtra("MENTION_CREATE_TIME", this.tZC);
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(mMFragmentActivity, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.a(mMFragmentActivity, intent);
                AppMethodBeat.o(254724);
                return;
            }
        } else {
            FinderCommentDrawer finderCommentDrawer = this.tNb;
            if (finderCommentDrawer != null) {
                finderCommentDrawer.setOnCloseDrawerCallback(closeDrawerCallback);
            }
            FinderCommentDrawer finderCommentDrawer2 = this.tNb;
            if (finderCommentDrawer2 != null) {
                FinderCommentDrawer.a(finderCommentDrawer2, finderItem, z, j2, z2, z3, anVar, z4, i2, 64);
                AppMethodBeat.o(254724);
                return;
            }
        }
        AppMethodBeat.o(254724);
    }

    public final void dGr() {
        AppMethodBeat.i(254726);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer != null) {
            finderCommentDrawer.dGr();
            AppMethodBeat.o(254726);
            return;
        }
        AppMethodBeat.o(254726);
    }

    public final boolean dGs() {
        AppMethodBeat.i(254727);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer != null) {
            boolean dGs = finderCommentDrawer.dGs();
            AppMethodBeat.o(254727);
            return dGs;
        }
        AppMethodBeat.o(254727);
        return false;
    }

    public final void onUIResume() {
        AppMethodBeat.i(254728);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer != null) {
            finderCommentDrawer.dGv();
            AppMethodBeat.o(254728);
            return;
        }
        AppMethodBeat.o(254728);
    }

    public final void onDetach() {
        AppMethodBeat.i(254729);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer != null) {
            finderCommentDrawer.dHu();
            AppMethodBeat.o(254729);
            return;
        }
        AppMethodBeat.o(254729);
    }

    public final void d(int i2, Intent intent) {
        a.c at;
        AppMethodBeat.i(254730);
        c cVar = c.vCb;
        if (c.dsr().value().intValue() != 1 || i2 != 500 || intent == null || (at = a.at(intent)) == null) {
            AppMethodBeat.o(254730);
            return;
        }
        CommentDrawerContract.CloseDrawerCallback closeDrawerCallback = this.tMR;
        if (closeDrawerCallback != null) {
            closeDrawerCallback.g(at.commentCount, at.qzs);
            AppMethodBeat.o(254730);
            return;
        }
        AppMethodBeat.o(254730);
    }
}

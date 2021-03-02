package com.tencent.mm.plugin.finder.upload.action;

import android.database.Cursor;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

public final class j {
    public static final String TAG = TAG;
    private static final j vUv = new j();
    public static final a vUw = new a((byte) 0);
    private com.tencent.mm.loader.g.d<k> vRJ = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new g(1, (byte) 0), 1, "finder_action_like_post_quene"));
    private final Runnable vRK;
    private final ConcurrentLinkedQueue<e> vTW;
    private final ConcurrentHashMap<Long, i> vTX;
    private final ConcurrentHashMap<Long, i> vTY;
    private final ConcurrentHashMap<Long, ConcurrentHashMap<c, l>> vUt;
    public final HashMap<Long, u> vUu;

    public interface b {
    }

    public static final class e extends q implements kotlin.g.a.b<FinderCommentInfo, Boolean> {
        public static final e vUy = new e();

        static {
            AppMethodBeat.i(253220);
            AppMethodBeat.o(253220);
        }

        e() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(FinderCommentInfo finderCommentInfo) {
            AppMethodBeat.i(253219);
            FinderCommentInfo finderCommentInfo2 = finderCommentInfo;
            p.h(finderCommentInfo2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(p.j(finderCommentInfo2.username, z.aTY()));
            AppMethodBeat.o(253219);
            return valueOf;
        }
    }

    public j() {
        AppMethodBeat.i(167822);
        dBs();
        this.vTW = new ConcurrentLinkedQueue<>();
        this.vTX = new ConcurrentHashMap<>();
        this.vTY = new ConcurrentHashMap<>();
        this.vUt = new ConcurrentHashMap<>();
        this.vUu = new HashMap<>();
        this.vRK = new f(this);
        AppMethodBeat.o(167822);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167823);
        AppMethodBeat.o(167823);
    }

    public static final class c {
        private final long id;
        private final int scene;

        public c(long j2, int i2) {
            this.id = j2;
            this.scene = i2;
        }

        public final boolean equals(Object obj) {
            Object obj2;
            if (!(obj instanceof c)) {
                obj2 = null;
            } else {
                obj2 = obj;
            }
            c cVar = (c) obj2;
            if (cVar == null) {
                return false;
            }
            if (cVar.id == this.id && cVar.scene == this.scene) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(167809);
            int hashCode = new StringBuilder().append(this.id).append('_').append(this.scene).toString().hashCode();
            AppMethodBeat.o(167809);
            return hashCode;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f implements Runnable {
        final /* synthetic */ j vUx;

        f(j jVar) {
            this.vUx = jVar;
        }

        public final void run() {
            AppMethodBeat.i(167811);
            this.vUx.dAP();
            AppMethodBeat.o(167811);
        }
    }

    public final o<Boolean, Boolean> m(FinderObject finderObject) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(253221);
        p.h(finderObject, "feed");
        if (finderObject.id == 0) {
            if (finderObject.likeFlag != 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (finderObject.likeFlag != 2) {
                z2 = false;
            }
            o<Boolean, Boolean> oVar = new o<>(valueOf, Boolean.valueOf(z2));
            AppMethodBeat.o(253221);
            return oVar;
        }
        boolean z3 = finderObject.likeFlag != 0;
        if (finderObject.likeFlag != 2) {
            z2 = false;
        }
        i iVar = this.vTX.get(Long.valueOf(finderObject.id));
        if (iVar != null) {
            z3 = iVar.vUr;
            z2 = iVar.vUk;
        }
        if (BuildInfo.DEBUG) {
            String str = TAG;
            StringBuilder append = new StringBuilder("isLike test ").append(finderObject.id).append(" isLike:");
            i iVar2 = this.vTX.get(Long.valueOf(finderObject.id));
            Log.i(str, append.append(iVar2 != null ? Boolean.valueOf(iVar2.vUr) : null).append(" likeFlag:").append(finderObject.likeFlag).append(" result:").append(z3).toString());
        }
        o<Boolean, Boolean> oVar2 = new o<>(Boolean.valueOf(z3), Boolean.valueOf(z2));
        AppMethodBeat.o(253221);
        return oVar2;
    }

    public final int n(FinderObject finderObject) {
        boolean z;
        AppMethodBeat.i(167813);
        p.h(finderObject, "feed");
        if (finderObject.id == 0) {
            int i2 = finderObject.likeCount;
            AppMethodBeat.o(167813);
            return i2;
        }
        boolean z2 = finderObject.likeFlag != 0;
        i iVar = this.vTX.get(Long.valueOf(finderObject.id));
        if (iVar != null) {
            z = iVar.vUr;
        } else {
            z = z2;
        }
        if (z2 && true != z) {
            int i3 = finderObject.likeCount - 1;
            AppMethodBeat.o(167813);
            return i3;
        } else if (z2 || !z) {
            int i4 = finderObject.likeCount;
            AppMethodBeat.o(167813);
            return i4;
        } else {
            int i5 = finderObject.likeCount + 1;
            AppMethodBeat.o(167813);
            return i5;
        }
    }

    public final int o(FinderObject finderObject) {
        boolean z = true;
        AppMethodBeat.i(253222);
        p.h(finderObject, "feed");
        if (finderObject.id == 0) {
            int i2 = finderObject.friendLikeCount;
            AppMethodBeat.o(253222);
            return i2;
        }
        boolean z2 = finderObject.likeFlag == 1;
        i iVar = this.vTX.get(Long.valueOf(finderObject.id));
        if (iVar == null) {
            z = z2;
        } else if (!iVar.vUr || iVar.vUk) {
            z = false;
        }
        if (z2 && z2 != z) {
            int i3 = finderObject.friendLikeCount - 1;
            AppMethodBeat.o(253222);
            return i3;
        } else if (z2 || z2 == z) {
            int i4 = finderObject.friendLikeCount;
            AppMethodBeat.o(253222);
            return i4;
        } else {
            int i5 = finderObject.friendLikeCount + 1;
            AppMethodBeat.o(253222);
            return i5;
        }
    }

    public final LinkedList<FinderCommentInfo> p(FinderObject finderObject) {
        boolean z = true;
        AppMethodBeat.i(253223);
        p.h(finderObject, "feed");
        if (finderObject.id == 0) {
            LinkedList<FinderCommentInfo> linkedList = finderObject.likeList;
            p.g(linkedList, "feed.likeList");
            AppMethodBeat.o(253223);
            return linkedList;
        }
        boolean z2 = finderObject.likeFlag == 1;
        i iVar = this.vTX.get(Long.valueOf(finderObject.id));
        if (iVar == null) {
            z = z2;
        } else if (!iVar.vUr || iVar.vUk) {
            z = false;
        }
        if (z2 && z2 != z) {
            LinkedList<FinderCommentInfo> linkedList2 = finderObject.likeList;
            p.g(linkedList2, "feed.likeList");
            LinkedList<FinderCommentInfo> aH = aH(linkedList2);
            AppMethodBeat.o(253223);
            return aH;
        } else if (z2 || z2 == z) {
            LinkedList<FinderCommentInfo> linkedList3 = finderObject.likeList;
            p.g(linkedList3, "feed.likeList");
            AppMethodBeat.o(253223);
            return linkedList3;
        } else {
            LinkedList<FinderCommentInfo> linkedList4 = finderObject.likeList;
            p.g(linkedList4, "feed.likeList");
            LinkedList<FinderCommentInfo> aF = aF(linkedList4);
            AppMethodBeat.o(253223);
            return aF;
        }
    }

    private static LinkedList<FinderCommentInfo> aF(LinkedList<FinderCommentInfo> linkedList) {
        AppMethodBeat.i(253224);
        LinkedList<FinderCommentInfo> linkedList2 = new LinkedList<>();
        linkedList2.addAll(linkedList);
        aG(linkedList2);
        AppMethodBeat.o(253224);
        return linkedList2;
    }

    public static void aG(LinkedList<FinderCommentInfo> linkedList) {
        T t;
        AppMethodBeat.i(253225);
        p.h(linkedList, "newList");
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.username, z.aTY())) {
                t = next;
                break;
            }
        }
        if (t == null) {
            FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
            finderCommentInfo.username = z.aTY();
            finderCommentInfo.nickname = z.aUa();
            finderCommentInfo.headUrl = "";
            linkedList.add(0, finderCommentInfo);
        }
        AppMethodBeat.o(253225);
    }

    private static LinkedList<FinderCommentInfo> aH(LinkedList<FinderCommentInfo> linkedList) {
        AppMethodBeat.i(253226);
        LinkedList<FinderCommentInfo> linkedList2 = new LinkedList<>();
        linkedList2.addAll(linkedList);
        aI(linkedList2);
        AppMethodBeat.o(253226);
        return linkedList2;
    }

    public static void aI(LinkedList<FinderCommentInfo> linkedList) {
        AppMethodBeat.i(253227);
        p.h(linkedList, "newList");
        com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) e.vUy);
        AppMethodBeat.o(253227);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r12, com.tencent.mm.plugin.finder.storage.an r14, int r15) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.action.j.a(long, com.tencent.mm.plugin.finder.storage.an, int):boolean");
    }

    public final int b(long j2, an anVar, int i2) {
        boolean z;
        l lVar;
        l lVar2;
        AppMethodBeat.i(167815);
        p.h(anVar, "commentObj");
        if (j2 == 0) {
            int i3 = anVar.dyb().likeCount;
            AppMethodBeat.o(167815);
            return i3;
        }
        boolean z2 = anVar.dyb().likeFlag == 1;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsP().value().intValue() != 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drT() == 1) {
                ConcurrentHashMap<c, l> concurrentHashMap = this.vUt.get(Long.valueOf(j2));
                if (concurrentHashMap == null || (lVar2 = concurrentHashMap.get(new c(anVar.dyb().commentId, 1))) == null) {
                    z = z2;
                } else {
                    z = lVar2.vUr;
                }
                if (!z2 && z2 != z) {
                    int i4 = anVar.dyb().likeCount - 1;
                    AppMethodBeat.o(167815);
                    return i4;
                } else if (!z2 || z2 == z) {
                    int i5 = anVar.dyb().likeCount;
                    AppMethodBeat.o(167815);
                    return i5;
                } else {
                    int i6 = anVar.dyb().likeCount + 1;
                    AppMethodBeat.o(167815);
                    return i6;
                }
            }
        }
        ConcurrentHashMap<c, l> concurrentHashMap2 = this.vUt.get(Long.valueOf(j2));
        if (concurrentHashMap2 == null || (lVar = concurrentHashMap2.get(new c(anVar.dyb().commentId, i2))) == null) {
            z = z2;
        } else {
            z = lVar.vUr;
        }
        if (!z2) {
        }
        if (!z2) {
        }
        int i52 = anVar.dyb().likeCount;
        AppMethodBeat.o(167815);
        return i52;
    }

    public final void a(i iVar) {
        boolean z;
        AppMethodBeat.i(167816);
        p.h(iVar, NativeProtocol.WEB_DIALOG_ACTION);
        i iVar2 = this.vTX.get(Long.valueOf(iVar.feedId));
        if (iVar2 != null) {
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("removeLikeCache ").append(iVar).append(" result ");
                if (iVar.vUi >= iVar2.vUi) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(str, append.append(z).toString());
            }
            if (iVar.vUi >= iVar2.vUi) {
                this.vTX.remove(Long.valueOf(iVar.feedId));
            }
            AppMethodBeat.o(167816);
            return;
        }
        AppMethodBeat.o(167816);
    }

    public final void b(i iVar) {
        boolean z;
        AppMethodBeat.i(253228);
        p.h(iVar, NativeProtocol.WEB_DIALOG_ACTION);
        i iVar2 = this.vTY.get(Long.valueOf(iVar.feedId));
        if (iVar2 != null) {
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("removeLikeCache ").append(iVar).append(" result ");
                if (iVar.vUi >= iVar2.vUi) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(str, append.append(z).toString());
            }
            if (iVar.vUi >= iVar2.vUi) {
                this.vTY.remove(Long.valueOf(iVar.feedId));
            }
            AppMethodBeat.o(253228);
            return;
        }
        AppMethodBeat.o(253228);
    }

    public final void a(l lVar) {
        boolean z;
        AppMethodBeat.i(167817);
        p.h(lVar, NativeProtocol.WEB_DIALOG_ACTION);
        ConcurrentHashMap<c, l> concurrentHashMap = this.vUt.get(Long.valueOf(lVar.feedId));
        if (concurrentHashMap != null) {
            c cVar = new c(lVar.vUB.dyb().commentId, lVar.scene);
            l lVar2 = concurrentHashMap.get(cVar);
            if (lVar2 != null) {
                if (BuildInfo.DEBUG) {
                    String str = TAG;
                    StringBuilder append = new StringBuilder("removeLikeCommentCache ").append(lVar).append(" result ");
                    if (lVar.vUi >= lVar2.vUi) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.i(str, append.append(z).toString());
                }
                if (lVar.vUi >= lVar2.vUi) {
                    concurrentHashMap.remove(cVar);
                }
                AppMethodBeat.o(167817);
                return;
            }
            AppMethodBeat.o(167817);
            return;
        }
        AppMethodBeat.o(167817);
    }

    public final void dAP() {
        AppMethodBeat.i(167818);
        while (this.vTW.size() > 0) {
            e poll = this.vTW.poll();
            boolean isValid = poll.isValid();
            Log.i(TAG, "tryNext isValid:" + isValid + " action:" + poll + " size:" + this.vTW.size());
            if (isValid) {
                p.g(poll, NativeProtocol.WEB_DIALOG_ACTION);
                a(poll);
                AppMethodBeat.o(167818);
                return;
            }
        }
        AppMethodBeat.o(167818);
    }

    public static /* synthetic */ void a(j jVar, FinderItem finderItem, boolean z, boolean z2, int i2, bbn bbn) {
        AppMethodBeat.i(253229);
        p.h(finderItem, "feed");
        p.h(bbn, "contextObj");
        Log.i(TAG, "dolike " + finderItem.getUserName() + ' ' + z + "， isLongVideo = false");
        long j2 = finderItem.field_id;
        String objectNonceId = finderItem.getObjectNonceId();
        p.g(objectNonceId, "if (isLongVideo) feed.me…\" else feed.objectNonceId");
        i iVar = new i(finderItem, j2, objectNonceId, z, z2, i2, bbn);
        jVar.vTX.put(Long.valueOf(j2), iVar);
        jVar.a((e) iVar);
        AppMethodBeat.o(253229);
    }

    public static /* synthetic */ void a(j jVar, long j2, String str, an anVar, boolean z, int i2, bbn bbn, boolean z2) {
        ConcurrentHashMap<c, l> concurrentHashMap;
        AppMethodBeat.i(253230);
        p.h(str, "objectNonceId");
        p.h(anVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        p.h(bbn, "contextObj");
        Log.i(TAG, "doLikeComment " + j2 + " comment:" + anVar + " like:" + z + " scene " + i2);
        l lVar = new l(j2, str, anVar, z, i2, bbn, z2);
        ConcurrentHashMap<Long, ConcurrentHashMap<c, l>> concurrentHashMap2 = jVar.vUt;
        Long valueOf = Long.valueOf(j2);
        ConcurrentHashMap<c, l> concurrentHashMap3 = concurrentHashMap2.get(valueOf);
        if (concurrentHashMap3 == null) {
            ConcurrentHashMap<c, l> concurrentHashMap4 = new ConcurrentHashMap<>();
            concurrentHashMap = concurrentHashMap2.putIfAbsent(valueOf, concurrentHashMap4);
            if (concurrentHashMap == null) {
                concurrentHashMap = concurrentHashMap4;
            }
        } else {
            concurrentHashMap = concurrentHashMap3;
        }
        ConcurrentHashMap<c, l> concurrentHashMap5 = concurrentHashMap;
        p.g(concurrentHashMap5, "commentMap");
        concurrentHashMap5.put(new c(anVar.dyb().commentId, i2), lVar);
        jVar.a((e) lVar);
        AppMethodBeat.o(253230);
    }

    public static final class d implements com.tencent.mm.loader.g.f<k> {
        final /* synthetic */ e vUc;
        final /* synthetic */ j vUx;

        d(j jVar, e eVar) {
            this.vUx = jVar;
            this.vUc = eVar;
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(k kVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(167810);
            k kVar2 = kVar;
            p.h(kVar2, "task");
            p.h(jVar, "status");
            a aVar = j.vUw;
            Log.i(j.TAG, "task callback ".concat(String.valueOf(jVar)));
            if (jVar == com.tencent.mm.loader.g.j.OK) {
                j.a(this.vUx, this.vUc);
                this.vUx.dAP();
                AppMethodBeat.o(167810);
                return;
            }
            if (kVar2.vUd) {
                this.vUx.vTW.add(kVar2.vUe);
            }
            MMHandlerThread.removeRunnable(this.vUx.vRK);
            Runnable runnable = this.vUx.vRK;
            a.C1302a aVar2 = a.vTR;
            MMHandlerThread.postToMainThreadDelayed(runnable, a.qnq);
            AppMethodBeat.o(167810);
        }
    }

    private final void a(e eVar) {
        AppMethodBeat.i(167821);
        this.vRJ.a(new k(eVar), new d(this, eVar));
        AppMethodBeat.o(167821);
    }

    public final o<Boolean, Boolean> Ga(long j2) {
        AppMethodBeat.i(253231);
        boolean containsKey = this.vUu.containsKey(Long.valueOf(j2));
        u uVar = this.vUu.get(Long.valueOf(j2));
        boolean z = uVar != null ? uVar.field_isPrivate : false;
        Log.i(TAG, "isLocalFeedLike " + j2 + ", " + containsKey);
        o<Boolean, Boolean> oVar = new o<>(Boolean.valueOf(containsKey), Boolean.valueOf(z));
        AppMethodBeat.o(253231);
        return oVar;
    }

    public final synchronized void a(long j2, bbn bbn, boolean z, boolean z2, boolean z3) {
        u uVar;
        AppMethodBeat.i(253232);
        p.h(bbn, "contextObj");
        Log.i(TAG, "likeLocalFeed " + j2 + ", isLike " + z + ", isPrivate:" + z3 + ", likeAction 1, contains:" + this.vUu.containsKey(Long.valueOf(j2)));
        if (z) {
            if (!this.vUu.containsKey(Long.valueOf(j2)) || (uVar = this.vUu.get(Long.valueOf(j2))) == null || uVar.field_isPrivate != z3) {
                u uVar2 = new u();
                uVar2.field_localId = j2;
                uVar2.field_contextObj = bbn;
                uVar2.field_likeAction = 1;
                uVar2.field_scene = 2;
                uVar2.field_showTips = z2;
                uVar2.field_isPrivate = z3;
                this.vUu.put(Long.valueOf(j2), uVar2);
                ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLocalLikeFeedStorage().a(uVar2);
            }
        } else if (this.vUu.containsKey(Long.valueOf(j2))) {
            this.vUu.remove(Long.valueOf(j2));
            v localLikeFeedStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLocalLikeFeedStorage();
            Log.i(v.TAG, "remove " + j2 + ", ret:" + localLikeFeedStorage.db.delete(localLikeFeedStorage.getTableName(), "localId=?", new String[]{String.valueOf(j2)}));
        }
        Log.i(TAG, "likeLocalFeed end. " + j2 + ", isLike " + z + ", isPrivate:" + z3 + ", likeAction 1");
        AppMethodBeat.o(253232);
    }

    private final void dBs() {
        AppMethodBeat.i(253233);
        try {
            v localLikeFeedStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLocalLikeFeedStorage();
            ArrayList<u> arrayList = new ArrayList();
            Cursor rawQuery = localLikeFeedStorage.db.rawQuery("select * from FinderLocalOperation", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    u uVar = new u();
                    uVar.convertFrom(rawQuery);
                    arrayList.add(uVar);
                }
                rawQuery.close();
            }
            Log.i(v.TAG, "getAllData size:" + arrayList.size());
            for (u uVar2 : arrayList) {
                this.vUu.put(Long.valueOf(uVar2.field_localId), uVar2);
            }
            AppMethodBeat.o(253233);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "restoreLocalLikeFeed", new Object[0]);
            AppMethodBeat.o(253233);
        }
    }

    public static final /* synthetic */ void a(j jVar, e eVar) {
        ArrayList<e> arrayList;
        T t;
        T t2;
        AppMethodBeat.i(167824);
        if (eVar instanceof i) {
            ArrayList arrayList2 = new ArrayList();
            for (T t3 : jVar.vTW) {
                T t4 = t3;
                if (!(t4 instanceof i)) {
                    t2 = null;
                } else {
                    t2 = t4;
                }
                T t5 = t2;
                if (t5 != null && t5.feedId == t4.feedId && eVar.vUi > t4.vUi) {
                    arrayList2.add(t3);
                }
            }
            arrayList = arrayList2;
        } else if (eVar instanceof l) {
            ArrayList arrayList3 = new ArrayList();
            for (T t6 : jVar.vTW) {
                T t7 = t6;
                if (!(t7 instanceof l)) {
                    t = null;
                } else {
                    t = t7;
                }
                T t8 = t;
                if (t8 != null && t8.feedId == t7.feedId && t8.vUB.dyb().commentId == t7.vUB.dyb().commentId && eVar.vUi > t7.vUi) {
                    arrayList3.add(t6);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            for (e eVar2 : arrayList) {
                Log.i(TAG, "drop action now action " + eVar + ' ' + eVar2);
                jVar.vTW.remove(eVar2);
            }
            AppMethodBeat.o(167824);
            return;
        }
        AppMethodBeat.o(167824);
    }
}

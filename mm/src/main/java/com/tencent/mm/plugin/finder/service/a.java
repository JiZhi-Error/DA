package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.fetcher.a;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020!H\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016J\u001e\u0010)\u001a\u00020!2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-2\u0006\u0010*\u001a\u00020.H\u0016J,\u0010/\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010/\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001c\u00104\u001a\u0002052\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u000106H\u0016J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u00109\u001a\u0004\u0018\u0001082\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010:\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u000108H\u0002J\u0012\u0010<\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u000108H\u0002J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010?\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002RN\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "cacheContactItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "Lkotlin/Lazy;", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", ch.COL_USERNAME, "isCheckAvatar", "", "clearFollowStateCache", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "getFinderMsgStrangerContact", "commentId", "", "objectId", "sessionId", "getFollowState", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetFollowStateCallback;", "getLocalFinderContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderMsgStrangerContact", "isContactExpired", "contact", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"})
public final class a implements com.tencent.mm.plugin.i.a.m {
    public static final C1274a vvD = new C1274a((byte) 0);
    private final kotlin.f twR = kotlin.g.ah(n.vvM);
    private final kotlin.f tyR = kotlin.g.ah(m.vvL);
    private final Map<String, com.tencent.mm.plugin.finder.api.g> vvA = Collections.synchronizedMap(new HashMap());
    public final bv.a vvB = new d(this);
    private final ConcurrentHashMap<String, Object> vvC = new ConcurrentHashMap<>();
    private final kotlin.f vvz = kotlin.g.ah(e.vvF);

    static {
        AppMethodBeat.i(251439);
        AppMethodBeat.o(251439);
    }

    private final ab dqd() {
        AppMethodBeat.i(251422);
        ab abVar = (ab) this.twR.getValue();
        AppMethodBeat.o(251422);
        return abVar;
    }

    private final com.tencent.mm.plugin.finder.cgi.fetcher.a dqe() {
        AppMethodBeat.i(251423);
        com.tencent.mm.plugin.finder.cgi.fetcher.a aVar = (com.tencent.mm.plugin.finder.cgi.fetcher.a) this.vvz.getValue();
        AppMethodBeat.o(251423);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ String vdJ;
        final /* synthetic */ a vvE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str) {
            super(1);
            this.vvE = aVar;
            this.vdJ = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            AppMethodBeat.i(251405);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            this.vvE.vvC.remove(this.vdJ);
            Log.i("Finder.ContactService", "[checkContactExpired#result] talker=" + this.vdJ + " nick=" + ahVar2.getNickname());
            x xVar = x.SXb;
            AppMethodBeat.o(251405);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ String vdJ;
        final /* synthetic */ a vvE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str) {
            super(1);
            this.vvE = aVar;
            this.vdJ = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            AppMethodBeat.i(251406);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            Log.i("Finder.ContactService", "[checkContactExpired#result] talker=" + this.vdJ + " nick=" + ahVar2.getNickname());
            this.vvE.vvC.remove(this.vdJ);
            x xVar = x.SXb;
            AppMethodBeat.o(251406);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<List<? extends ah>, x> {
        final /* synthetic */ m.b vvG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(m.b bVar) {
            super(1);
            this.vvG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.i.a.m$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends ah> list) {
            AppMethodBeat.i(251411);
            List<? extends ah> list2 = list;
            p.h(list2, LocaleUtil.ITALIAN);
            this.vvG.er(list2);
            x xVar = x.SXb;
            AppMethodBeat.o(251411);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ m.b vvG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(m.b bVar) {
            super(1);
            this.vvG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            AppMethodBeat.i(251412);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            this.vvG.er(kotlin.a.j.listOf(ahVar2));
            x xVar = x.SXb;
            AppMethodBeat.o(251412);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ m.a vvH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(m.a aVar) {
            super(1);
            this.vvH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            AppMethodBeat.i(251415);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] completed! result=" + ahVar2.getUsername() + '=' + ahVar2.getNickname());
            m.a aVar = this.vvH;
            if (aVar != null) {
                aVar.c(ahVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(251415);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    static final class k extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ m.a vvH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(m.a aVar) {
            super(1);
            this.vvH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            AppMethodBeat.i(251416);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] completed! result=" + ahVar2.getUsername() + '=' + ahVar2.getNickname());
            m.a aVar = this.vvH;
            if (aVar != null) {
                aVar.c(ahVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(251416);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    static final class l extends q implements kotlin.g.a.b<ah, x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ a vvE;
        final /* synthetic */ z.d vvJ;
        final /* synthetic */ m.c vvK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar, z.d dVar, String str, m.c cVar) {
            super(1);
            this.vvE = aVar;
            this.vvJ = dVar;
            this.hLl = str;
            this.vvK = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ah ahVar) {
            int i2;
            AppMethodBeat.i(251417);
            ah ahVar2 = ahVar;
            p.h(ahVar2, LocaleUtil.ITALIAN);
            Log.i("Finder.ContactService", "[getFollowState] user:".concat(String.valueOf(ahVar2)));
            z.d dVar = this.vvJ;
            if (!((com.tencent.mm.plugin.finder.api.g) ahVar2).tsw) {
                i2 = -1;
            } else {
                int i3 = ((com.tencent.mm.plugin.finder.api.g) ahVar2).field_follow_Flag;
                g.a aVar = com.tencent.mm.plugin.finder.api.g.tsD;
                if (i3 == com.tencent.mm.plugin.finder.api.g.tsB) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
            }
            dVar.SYE = i2;
            if (((com.tencent.mm.plugin.finder.api.g) ahVar2).tsw) {
                Map map = this.vvE.vvA;
                p.g(map, "cacheContactItems");
                map.put(this.hLl, ahVar2);
            }
            m.c cVar = this.vvK;
            if (cVar != null) {
                cVar.yL(this.vvJ.SYE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(251417);
            return xVar;
        }
    }

    public a() {
        AppMethodBeat.i(251438);
        AppMethodBeat.o(251438);
    }

    public static final /* synthetic */ ab c(a aVar) {
        AppMethodBeat.i(251440);
        ab dqd = aVar.dqd();
        AppMethodBeat.o(251440);
        return dqd;
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final /* synthetic */ void a(String str, Boolean bool) {
        AppMethodBeat.i(251435);
        bs(str, bool.booleanValue());
        AppMethodBeat.o(251435);
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final /* synthetic */ void a(String str, Long l2, Long l3, m.a aVar) {
        String str2;
        boolean z;
        AppMethodBeat.i(251426);
        long longValue = l2.longValue();
        long longValue2 = l3.longValue();
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            Log.e("Finder.ContactService", "username is null.");
            aVar.c(new com.tencent.mm.plugin.finder.api.g());
            AppMethodBeat.o(251426);
        } else if (longValue == 0) {
            Log.e("Finder.ContactService", "commentId is null.");
            aVar.c(new com.tencent.mm.plugin.finder.api.g());
            AppMethodBeat.o(251426);
        } else if (longValue2 == 0) {
            Log.e("Finder.ContactService", "objectId is null.");
            aVar.c(new com.tencent.mm.plugin.finder.api.g());
            AppMethodBeat.o(251426);
        } else {
            com.tencent.mm.plugin.finder.api.g asG = dqd().asG(str);
            if (asG != null) {
                if (asG.getNickname().length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && !a(asG)) {
                    Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + asG.getUsername() + '=' + asG.getNickname());
                    aVar.c(asG);
                    AppMethodBeat.o(251426);
                    return;
                }
            }
            if (!b(asG) || a(asG)) {
                com.tencent.mm.plugin.finder.cgi.fetcher.a dqe = dqe();
                apo apo = new apo();
                apo.LBw = str;
                apo.commentId = longValue;
                apo.hFK = longValue2;
                k kVar = new k(aVar);
                p.h(apo, "req");
                p.h(kVar, "call");
                String str4 = apo.LBw;
                ConcurrentHashMap<String, Object> concurrentHashMap = dqe.twQ;
                if (concurrentHashMap == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                    AppMethodBeat.o(251426);
                    throw tVar;
                } else if (!concurrentHashMap.containsKey(str4)) {
                    ConcurrentHashMap<String, Object> concurrentHashMap2 = dqe.twQ;
                    if (str4 == null) {
                        str2 = "";
                    } else {
                        str2 = str4;
                    }
                    concurrentHashMap2.put(str2, dqe);
                    List listOf = kotlin.a.j.listOf(apo);
                    a.d dVar = new a.d(dqe, str4, kVar);
                    p.h(listOf, "reqList");
                    p.h(dVar, "call");
                    LinkedList linkedList = new LinkedList();
                    ae.a aVar2 = ae.tue;
                    p.h(listOf, "usernameList");
                    ae aeVar = new ae();
                    d.a aVar3 = new d.a();
                    art art = new art();
                    am amVar = am.tuw;
                    art.LAI = am.cXY();
                    art.LDk = 3;
                    art.LAt = com.tencent.mm.model.z.aUg();
                    art.LDn.addAll(listOf);
                    aVar3.c(art);
                    aru aru = new aru();
                    aru.setBaseResponse(new BaseResponse());
                    aru.getBaseResponse().ErrMsg = new dqi();
                    aVar3.d(aru);
                    aVar3.MB("/cgi-bin/micromsg-bin/findergetcontactlist");
                    aVar3.sG(3953);
                    aeVar.c(aVar3.aXF());
                    aeVar.aYI().j(new a.g(dqe, linkedList, listOf, dVar));
                    AppMethodBeat.o(251426);
                } else {
                    Log.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
                    AppMethodBeat.o(251426);
                }
            } else {
                Log.e("Finder.ContactService", "[getFinderContact] isContactRetryLimited contact=" + (asG != null ? asG.getUsername() : null));
                aVar.c(asG != null ? asG : new com.tencent.mm.plugin.finder.api.g(str));
                AppMethodBeat.o(251426);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_CONTACT_EXPIRED_TIME", "", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.service.a$a  reason: collision with other inner class name */
    public static final class C1274a {
        private C1274a() {
        }

        public /* synthetic */ C1274a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
    static final class i implements m.b {
        final /* synthetic */ List kPr;
        final /* synthetic */ m.b vvI;

        i(List list, m.b bVar) {
            this.kPr = list;
            this.vvI = bVar;
        }

        @Override // com.tencent.mm.plugin.i.a.m.b
        public final void er(List<ah> list) {
            AppMethodBeat.i(251414);
            StringBuilder append = new StringBuilder("[getContact] completed! usernameList=").append(this.kPr).append(" result=");
            p.g(list, "result");
            List<ah> list2 = list;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
            for (T t : list2) {
                StringBuilder sb = new StringBuilder();
                p.g(t, LocaleUtil.ITALIAN);
                arrayList.add(sb.append(t.getUsername()).append('=').append(t.getNickname()).toString());
            }
            Log.i("Finder.ContactService", append.append(arrayList).toString());
            this.vvI.er(list);
            AppMethodBeat.o(251414);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
    static final class h implements m.b {
        final /* synthetic */ m.a vvH;

        h(m.a aVar) {
            this.vvH = aVar;
        }

        @Override // com.tencent.mm.plugin.i.a.m.b
        public final void er(List<ah> list) {
            AppMethodBeat.i(251413);
            m.a aVar = this.vvH;
            p.g(list, "contact");
            aVar.c((ah) kotlin.a.j.kt(list));
            AppMethodBeat.o(251413);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final void a(String str, m.a aVar) {
        boolean z = false;
        AppMethodBeat.i(251424);
        p.h(str, ch.COL_USERNAME);
        p.h(aVar, "callback");
        List<String> v = kotlin.a.j.v((Collection) kotlin.a.j.listOf(str));
        h hVar = new h(aVar);
        p.h(v, "usernameList");
        p.h(hVar, "callback");
        Log.i("Finder.ContactService", "[getContact] begin... usernameList=".concat(String.valueOf(v)));
        i iVar = new i(v, hVar);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (T t : v) {
            if (t.length() == 0) {
                Log.e("Finder.ContactService", "username is null.");
                linkedList.add(new com.tencent.mm.plugin.finder.api.g());
            } else {
                c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(t);
                if (asG != null) {
                    if (!(asG.getNickname().length() == 0) && !a(asG)) {
                        linkedList.add(asG);
                    }
                }
                if (!b(asG) || a(asG)) {
                    Log.i("Finder.ContactService", new StringBuilder("contact is null[").append(asG == null).append("]. username=").append((String) t).toString());
                    linkedList2.add(t);
                } else {
                    Log.e("Finder.ContactService", "[getFinderContact] isContactRetryLimited contact=" + (asG != null ? asG.getUsername() : null));
                    linkedList.add(new com.tencent.mm.plugin.finder.api.g(t));
                }
            }
        }
        if (!linkedList2.isEmpty()) {
            z = true;
        }
        if (!z) {
            iVar.er(linkedList);
            AppMethodBeat.o(251424);
        } else if (linkedList2.size() > 1) {
            dqe().b(v, new f(iVar));
            AppMethodBeat.o(251424);
        } else {
            com.tencent.mm.plugin.finder.cgi.fetcher.a dqe = dqe();
            Object first = linkedList2.getFirst();
            p.g(first, "reqList.first");
            dqe.h((String) first, new g(iVar));
            AppMethodBeat.o(251424);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final void a(String str, String str2, m.a aVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(251425);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            Log.e("Finder.ContactService", "username is null.");
            aVar.c(new com.tencent.mm.plugin.finder.api.g());
            AppMethodBeat.o(251425);
            return;
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("Finder.ContactService", "sessionId is null.");
            aVar.c(new com.tencent.mm.plugin.finder.api.g());
            AppMethodBeat.o(251425);
            return;
        }
        com.tencent.mm.plugin.finder.api.g asG = dqd().asG(str);
        if (asG != null) {
            if (asG.getNickname().length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !a(asG)) {
                Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + asG.getUsername() + '=' + asG.getNickname());
                aVar.c(asG);
                AppMethodBeat.o(251425);
                return;
            }
        }
        if (!b(asG) || a(asG)) {
            com.tencent.mm.plugin.finder.cgi.fetcher.a dqe = dqe();
            aps aps = new aps();
            aps.LBC = str;
            aps.session_id = str2;
            dqe.a(aps, new j(aVar));
            AppMethodBeat.o(251425);
            return;
        }
        Log.e("Finder.ContactService", "[getFinderContact] isContactRetryLimited contact=" + (asG != null ? asG.getUsername() : null));
        aVar.c(asG != null ? asG : new com.tencent.mm.plugin.finder.api.g(str));
        AppMethodBeat.o(251425);
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final ah ava(String str) {
        AppMethodBeat.i(251427);
        if (str != null) {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
            AppMethodBeat.o(251427);
            return asG;
        }
        AppMethodBeat.o(251427);
        return null;
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final ah avb(String str) {
        AppMethodBeat.i(251428);
        if (str != null) {
            com.tencent.mm.plugin.finder.api.g asG = dqd().asG(str);
            if (asG != null) {
                Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + asG.getUsername() + '=' + asG.getNickname());
            } else {
                Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] get contact return null. ".concat(String.valueOf(str)));
            }
            com.tencent.mm.plugin.finder.api.g gVar = asG;
            AppMethodBeat.o(251428);
            return gVar;
        }
        AppMethodBeat.o(251428);
        return null;
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final void l(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(251429);
        if (iOnStorageChange != null) {
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().remove(iOnStorageChange);
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage().remove(iOnStorageChange);
            AppMethodBeat.o(251429);
            return;
        }
        AppMethodBeat.o(251429);
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final void dqf() {
        AppMethodBeat.i(251431);
        Log.i("Finder.ContactService", "[clearFollowStateCache]");
        this.vvA.clear();
        AppMethodBeat.o(251431);
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final int a(String str, m.c cVar) {
        int i2;
        AppMethodBeat.i(251432);
        Log.i("Finder.ContactService", "[getFollowState] username:".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(251432);
            return 3;
        }
        z.d dVar = new z.d();
        dVar.SYE = 1;
        com.tencent.mm.plugin.finder.api.g gVar = this.vvA.get(str);
        if (gVar != null) {
            Log.i("Finder.ContactService", "[getFollowState] cache user:".concat(String.valueOf(gVar)));
            int i3 = gVar.field_follow_Flag;
            g.a aVar = com.tencent.mm.plugin.finder.api.g.tsD;
            if (i3 == com.tencent.mm.plugin.finder.api.g.tsB) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            dVar.SYE = i2;
            int i4 = dVar.SYE;
            AppMethodBeat.o(251432);
            return i4;
        }
        dqe().h(str, new l(this, dVar, str, cVar));
        int i5 = dVar.SYE;
        AppMethodBeat.o(251432);
        return i5;
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final void m(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(251433);
        if (iOnStorageChange != null) {
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().add(iOnStorageChange);
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage().add(iOnStorageChange);
            AppMethodBeat.o(251433);
            return;
        }
        AppMethodBeat.o(251433);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", ch.COL_USERNAME, "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"})
    public static final class d implements bv.a {
        final /* synthetic */ a vvE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.vvE = aVar;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            boolean z2;
            AppMethodBeat.i(251407);
            if (asVar == null) {
                AppMethodBeat.o(251407);
                return -1;
            }
            String username = asVar.getUsername();
            String str = username;
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(251407);
                return -1;
            }
            if (as.avl(username)) {
                username = ((aa) com.tencent.mm.kernel.g.af(aa.class)).avi(username);
            }
            if (asVar.getFromType() == 2 || as.bjs(username) || as.bjt(username)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(251407);
                return -1;
            }
            AppMethodBeat.o(251407);
            return 1;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            boolean z;
            String str2;
            boolean z2;
            as f2;
            as asVar;
            String str3;
            boolean z3;
            AppMethodBeat.i(251408);
            String str4 = str;
            if (str4 == null || str4.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(251408);
                return null;
            }
            if (as.avl(str)) {
                str2 = ((aa) com.tencent.mm.kernel.g.af(aa.class)).avi(str);
            } else {
                str2 = str;
            }
            if (as.bjs(str2) || as.bjt(str2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(251408);
                return null;
            }
            if (as.bjt(str2)) {
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str2);
                f2 = asG != null ? com.tencent.mm.plugin.finder.api.g.f(asG) : null;
            } else {
                ab c2 = a.c(this.vvE);
                p.g(str2, "talker");
                com.tencent.mm.plugin.finder.api.g asG2 = c2.asG(str2);
                f2 = asG2 != null ? com.tencent.mm.plugin.finder.api.g.f(asG2) : null;
            }
            if (f2 != null) {
                String nickname = f2.getNickname();
                if (nickname == null || nickname.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    asVar = f2;
                    asVar.setUsername(str);
                    AppMethodBeat.o(251408);
                    return asVar;
                }
            }
            StringBuilder sb = new StringBuilder("[get] contact is null or nickname is empty. nickname=");
            if (f2 != null) {
                str3 = f2.getNickname();
            } else {
                str3 = null;
            }
            StringBuilder append = sb.append(str3).append(" talker=");
            p.g(str2, "talker");
            Log.e("Finder.ContactService", append.append(a.avd(str2)).toString());
            this.vvE.bs(str2, false);
            asVar = new as(str);
            asVar.setUsername(str);
            AppMethodBeat.o(251408);
            return asVar;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (a(r6) != false) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bs(java.lang.String r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 323
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.service.a.bs(java.lang.String, boolean):void");
    }

    private static boolean a(ah ahVar) {
        AppMethodBeat.i(251436);
        long cXI = ahVar != null ? ahVar.cXI() : 0;
        boolean z = System.currentTimeMillis() - cXI >= Util.MILLSECONDS_OF_DAY;
        if (z) {
            Log.i("Finder.ContactService", "[isContactExpired] current=" + Util.formatUnixTime(System.currentTimeMillis() / 1000) + " time=" + Util.formatUnixTime(cXI / 1000));
        }
        AppMethodBeat.o(251436);
        return z;
    }

    private static boolean b(ah ahVar) {
        AppMethodBeat.i(251437);
        if ((ahVar != null ? ahVar.getRetryCount() : 0) >= 3) {
            AppMethodBeat.o(251437);
            return true;
        }
        AppMethodBeat.o(251437);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
    static final class m extends q implements kotlin.g.a.a<ag> {
        public static final m vvL = new m();

        static {
            AppMethodBeat.i(251419);
            AppMethodBeat.o(251419);
        }

        m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ag invoke() {
            AppMethodBeat.i(251418);
            ag sessionInfoStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage();
            AppMethodBeat.o(251418);
            return sessionInfoStorage;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
    static final class n extends q implements kotlin.g.a.a<ab> {
        public static final n vvM = new n();

        static {
            AppMethodBeat.i(251421);
            AppMethodBeat.o(251421);
        }

        n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(251420);
            ab msgStrangerContactStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage();
            AppMethodBeat.o(251420);
            return msgStrangerContactStorage;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a> {
        public static final e vvF = new e();

        static {
            AppMethodBeat.i(251410);
            AppMethodBeat.o(251410);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.cgi.fetcher.a invoke() {
            AppMethodBeat.i(251409);
            com.tencent.mm.plugin.finder.cgi.fetcher.a aVar = new com.tencent.mm.plugin.finder.cgi.fetcher.a();
            AppMethodBeat.o(251409);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.m
    public final boolean avc(String str) {
        AppMethodBeat.i(251430);
        if (((ag) this.tyR.getValue()).avz(str).field_rejectMsg == 1) {
            AppMethodBeat.o(251430);
            return true;
        }
        AppMethodBeat.o(251430);
        return false;
    }

    public static final /* synthetic */ String avd(String str) {
        AppMethodBeat.i(251441);
        String str2 = str.subSequence(0, 12) + "..." + str.subSequence(str.length() - 24, str.length());
        AppMethodBeat.o(251441);
        return str2;
    }
}

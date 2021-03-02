package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"})
public final class c implements af.b {
    public static final a vvO = new a((byte) 0);
    private final f tyR = g.ah(C1276c.vvU);

    static {
        AppMethodBeat.i(251461);
        AppMethodBeat.o(251461);
    }

    public c() {
        AppMethodBeat.i(251460);
        AppMethodBeat.o(251460);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", ch.COL_USERNAME, "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"})
    public static final class b implements ay.b {
        b() {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void j(String str, int i2, String str2) {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void aVg() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.String */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.model.ay.b
        public final void a(String str, String str2, ay.b.a aVar) {
            String str3;
            AppMethodBeat.i(251455);
            if (str != 0) {
                z.f fVar = new z.f();
                fVar.SYG = str;
                if (as.avl(str)) {
                    T t = (T) ((aa) com.tencent.mm.kernel.g.af(aa.class)).avi(str);
                    p.g(t, "MMKernel.service(IFinder…TalkerFromLocal(username)");
                    fVar.SYG = t;
                    str3 = str;
                } else {
                    String avj = ((aa) com.tencent.mm.kernel.g.af(aa.class)).avj(str);
                    p.g(avj, "MMKernel.service(IFinder…sionIdFromLocal(username)");
                    str3 = avj;
                }
                Log.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + str3 + " talker=" + ((String) fVar.SYG));
                if (as.bjt(fVar.SYG)) {
                    ((m) com.tencent.mm.kernel.g.af(m.class)).a(fVar.SYG, new a(str, fVar, aVar));
                    AppMethodBeat.o(251455);
                    return;
                }
                if (as.bjs(fVar.SYG)) {
                    ((m) com.tencent.mm.kernel.g.af(m.class)).a(fVar.SYG, str3, new C1275b(str, fVar, aVar));
                }
                AppMethodBeat.o(251455);
                return;
            }
            AppMethodBeat.o(251455);
        }

        @Override // com.tencent.mm.model.ay.b
        public final void JZ(String str) {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void Ka(String str) {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void aL(String str, String str2) {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
        static final class a implements m.a {
            final /* synthetic */ String hLl;
            final /* synthetic */ z.f vvP;
            final /* synthetic */ ay.b.a vvQ;

            a(String str, z.f fVar, ay.b.a aVar) {
                this.hLl = str;
                this.vvP = fVar;
                this.vvQ = aVar;
            }

            @Override // com.tencent.mm.plugin.i.a.m.a
            public final void c(final ah ahVar) {
                AppMethodBeat.i(251452);
                d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.service.c.b.a.AnonymousClass1 */
                    final /* synthetic */ a vvR;

                    {
                        this.vvR = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(251451);
                        ah ahVar = ahVar;
                        boolean isValid = ahVar != null ? ahVar.isValid() : false;
                        Log.i("Finder.GetContactInterceptor", "[getFinderContact] callback! succ=" + isValid + ", username=" + this.vvR.hLl + " talker=" + ((String) this.vvR.vvP.SYG));
                        ay.b.a aVar = this.vvR.vvQ;
                        if (aVar != null) {
                            aVar.p(this.vvR.hLl, isValid);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(251451);
                        return xVar;
                    }
                });
                AppMethodBeat.o(251452);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
        /* renamed from: com.tencent.mm.plugin.finder.service.c$b$b  reason: collision with other inner class name */
        static final class C1275b implements m.a {
            final /* synthetic */ String hLl;
            final /* synthetic */ z.f vvP;
            final /* synthetic */ ay.b.a vvQ;

            C1275b(String str, z.f fVar, ay.b.a aVar) {
                this.hLl = str;
                this.vvP = fVar;
                this.vvQ = aVar;
            }

            @Override // com.tencent.mm.plugin.i.a.m.a
            public final void c(final ah ahVar) {
                AppMethodBeat.i(251454);
                d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.service.c.b.C1275b.AnonymousClass1 */
                    final /* synthetic */ C1275b vvT;

                    {
                        this.vvT = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(251453);
                        ah ahVar = ahVar;
                        boolean isValid = ahVar != null ? ahVar.isValid() : false;
                        Log.i("Finder.GetContactInterceptor", "[getFinderStrangerContact] callback! succ=" + isValid + ", username=" + this.vvT.hLl + " talker=" + ((String) this.vvT.vvP.SYG));
                        ay.b.a aVar = this.vvT.vvQ;
                        if (aVar != null) {
                            aVar.p(this.vvT.hLl, isValid);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(251453);
                        return xVar;
                    }
                });
                AppMethodBeat.o(251454);
            }
        }
    }

    @Override // com.tencent.mm.model.af.b
    public final ay.b aVi() {
        AppMethodBeat.i(251458);
        b bVar = new b();
        AppMethodBeat.o(251458);
        return bVar;
    }

    @Override // com.tencent.mm.model.af.b
    public final boolean aj(String str, int i2) {
        boolean z;
        AppMethodBeat.i(251459);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(251459);
            return false;
        } else if (i2 == 2 || as.bjt(str) || as.avl(str) || as.bjs(str)) {
            AppMethodBeat.o(251459);
            return true;
        } else {
            AppMethodBeat.o(251459);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.service.c$c  reason: collision with other inner class name */
    static final class C1276c extends q implements kotlin.g.a.a<ag> {
        public static final C1276c vvU = new C1276c();

        static {
            AppMethodBeat.i(251457);
            AppMethodBeat.o(251457);
        }

        C1276c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ag invoke() {
            AppMethodBeat.i(251456);
            ag sessionInfoStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage();
            AppMethodBeat.o(251456);
            return sessionInfoStorage;
        }
    }
}

package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"})
public final class d implements af.b {
    public static final a ybS = new a((byte) 0);

    static {
        AppMethodBeat.i(241334);
        AppMethodBeat.o(241334);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", ch.COL_USERNAME, "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"})
    public static final class b implements ay.b {
        b() {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void j(String str, int i2, String str2) {
        }

        @Override // com.tencent.mm.model.ay.b
        public final void aVg() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.model.ay.b
        public final void a(String str, String str2, ay.b.a aVar) {
            AppMethodBeat.i(241331);
            if (str != 0) {
                z.f fVar = new z.f();
                fVar.SYG = str;
                if (as.bju(str)) {
                    T t = (T) ((f) g.af(f.class)).avi(str);
                    p.g(t, "MMKernel.service(IGameLi…TalkerFromLocal(username)");
                    fVar.SYG = t;
                }
                Log.i("GameLife.GetContactInterceptor", "[getContact] username=" + str + " talker=" + ((String) fVar.SYG));
                if (as.bjv(fVar.SYG)) {
                    ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a((String) fVar.SYG, (b.c) new a(str, fVar, aVar));
                    AppMethodBeat.o(241331);
                    return;
                }
                ay.b aVo = ay.a.aVo();
                if (aVo instanceof af) {
                    ((af) aVo).aVf().a(str, "", new C1416b(fVar, aVar));
                }
                AppMethodBeat.o(241331);
                return;
            }
            AppMethodBeat.o(241331);
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

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
        static final class a implements b.c {
            final /* synthetic */ String hLl;
            final /* synthetic */ z.f vvP;
            final /* synthetic */ ay.b.a vvQ;

            a(String str, z.f fVar, ay.b.a aVar) {
                this.hLl = str;
                this.vvP = fVar;
                this.vvQ = aVar;
            }

            @Override // com.tencent.mm.plugin.gamelife.a.b.c
            public final void aj(final Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
                AppMethodBeat.i(241329);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.gamelife.d.d.b.a.AnonymousClass1 */
                    final /* synthetic */ a ybT;

                    {
                        this.ybT = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(241328);
                        com.tencent.mm.plugin.gamelife.a.a aVar = (com.tencent.mm.plugin.gamelife.a.a) j.f(map.values());
                        boolean isValid = aVar != null ? aVar.isValid() : false;
                        Log.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + isValid + ", username=" + this.ybT.hLl + " talker=" + ((String) this.ybT.vvP.SYG));
                        ay.b.a aVar2 = this.ybT.vvQ;
                        if (aVar2 != null) {
                            aVar2.p(this.ybT.hLl, isValid);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(241328);
                        return xVar;
                    }
                });
                AppMethodBeat.o(241329);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
        /* renamed from: com.tencent.mm.plugin.gamelife.d.d$b$b  reason: collision with other inner class name */
        static final class C1416b implements ay.b.a {
            final /* synthetic */ z.f vvP;
            final /* synthetic */ ay.b.a vvQ;

            C1416b(z.f fVar, ay.b.a aVar) {
                this.vvP = fVar;
                this.vvQ = aVar;
            }

            @Override // com.tencent.mm.model.ay.b.a
            public final void p(String str, boolean z) {
                AppMethodBeat.i(241330);
                Log.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + z + ", username=" + str + " talker=" + ((String) this.vvP.SYG));
                ay.b.a aVar = this.vvQ;
                if (aVar != null) {
                    aVar.p(str, z);
                    AppMethodBeat.o(241330);
                    return;
                }
                AppMethodBeat.o(241330);
            }
        }
    }

    @Override // com.tencent.mm.model.af.b
    public final ay.b aVi() {
        AppMethodBeat.i(241332);
        b bVar = new b();
        AppMethodBeat.o(241332);
        return bVar;
    }

    @Override // com.tencent.mm.model.af.b
    public final boolean aj(String str, int i2) {
        boolean z;
        AppMethodBeat.i(241333);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(241333);
            return false;
        } else if (as.bjv(str) || as.bju(str)) {
            AppMethodBeat.o(241333);
            return true;
        } else {
            AppMethodBeat.o(241333);
            return false;
        }
    }
}

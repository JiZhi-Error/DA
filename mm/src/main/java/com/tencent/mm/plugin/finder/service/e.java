package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J:\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016JÀ\u0001\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020#2b\u0010$\u001a^\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\n0%J\u0012\u0010,\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010-\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0016J \u00100\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\b\u0010$\u001a\u0004\u0018\u000104H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "context", "Landroid/content/Context;", "scene", "", ch.COL_USERNAME, "", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "getSessionIdByFansId", "fansId", "getSessionIdByLottery", "lotteryId", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "isFromLiveLottery", "", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"})
public final class e implements aa {
    public static final a vvW = new a((byte) 0);
    private final kotlin.f tyR = kotlin.g.ah(g.vwc);

    static {
        AppMethodBeat.i(251484);
        AppMethodBeat.o(251484);
    }

    private final ag getSessionInfoStorage() {
        AppMethodBeat.i(251471);
        ag agVar = (ag) this.tyR.getValue();
        AppMethodBeat.o(251471);
        return agVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
    static final class b extends q implements r<String, Integer, Integer, String, x> {
        final /* synthetic */ aa.a vvX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa.a aVar) {
            super(4);
            this.vvX = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, Integer num, Integer num2, String str2) {
            AppMethodBeat.i(251464);
            String str3 = str;
            p.h(str3, "sessionIdServer");
            this.vvX.j(str3, num.intValue(), num2.intValue(), str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251464);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
    static final class c extends q implements r<String, Integer, Integer, String, x> {
        final /* synthetic */ aa.a vvX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aa.a aVar) {
            super(4);
            this.vvX = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, Integer num, Integer num2, String str2) {
            AppMethodBeat.i(251465);
            String str3 = str;
            p.h(str3, "sessionIdServer");
            this.vvX.j(str3, num.intValue(), num2.intValue(), str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251465);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
    static final class d extends q implements r<String, Integer, Integer, String, x> {
        final /* synthetic */ aa.a vvX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aa.a aVar) {
            super(4);
            this.vvX = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, Integer num, Integer num2, String str2) {
            AppMethodBeat.i(251466);
            String str3 = str;
            p.h(str3, "sessionIdServer");
            this.vvX.j(str3, num.intValue(), num2.intValue(), str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251466);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.service.e$e  reason: collision with other inner class name */
    static final class C1277e extends q implements r<String, Integer, Integer, String, x> {
        final /* synthetic */ aa.a vvX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1277e(aa.a aVar) {
            super(4);
            this.vvX = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(String str, Integer num, Integer num2, String str2) {
            AppMethodBeat.i(251467);
            String str3 = str;
            p.h(str3, "sessionIdServer");
            this.vvX.j(str3, num.intValue(), num2.intValue(), str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251467);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ r nyK;
        final /* synthetic */ long txv;
        final /* synthetic */ e vvY;
        final /* synthetic */ String vvZ;
        final /* synthetic */ long vwa;
        final /* synthetic */ ag.b vwb;

        f(e eVar, String str, String str2, long j2, long j3, ag.b bVar, r rVar) {
            this.vvY = eVar;
            this.hLl = str;
            this.vvZ = str2;
            this.txv = j2;
            this.vwa = j3;
            this.vwb = bVar;
            this.nyK = rVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            String str2;
            int i2;
            boolean z;
            String str3;
            com.tencent.mm.bw.b bVar;
            boolean z2 = true;
            AppMethodBeat.i(251468);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                azj azj = ((ati) aVar.iLC).LEk;
                if (azj == null || (str = azj.sessionId) == null) {
                    str = "";
                }
                baf baf = new baf();
                azj azj2 = ((ati) aVar.iLC).LEk;
                if (azj2 == null || (bVar = azj2.LJg) == null || baf.parseFrom(bVar.toByteArray()) == null) {
                    Log.e("Finder.SessionInfoService", "extInfo is null! ");
                    x xVar = x.SXb;
                }
                int i3 = (baf.action & 1) > 0 ? 1 : 0;
                azj azj3 = ((ati) aVar.iLC).LEk;
                if (azj3 == null || (str2 = azj3.dkV) == null) {
                    str2 = "";
                }
                if ((baf.action & 4) > 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                Log.i("Finder.SessionInfoService", "[getSessionId] " + this.hLl + ',' + this.vvZ + ',' + this.txv + '#' + this.vwa + " => " + str + " enableAction=" + i3 + " from server. username is equal?" + p.j(str2, this.hLl));
                if (str.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (str2.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        e.a(this.vvY).a(str, str2, 2, i3, this.vwb, i2, 0);
                    }
                }
                r rVar = this.nyK;
                azj azj4 = ((ati) aVar.iLC).LEk;
                if (azj4 == null || (str3 = azj4.sessionId) == null) {
                    str3 = "";
                }
                rVar.invoke(str3, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
            } else {
                this.nyK.invoke("", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(251468);
            return xVar2;
        }
    }

    public e() {
        AppMethodBeat.i(251483);
        AppMethodBeat.o(251483);
    }

    public static final /* synthetic */ ag a(e eVar) {
        AppMethodBeat.i(251485);
        ag sessionInfoStorage = eVar.getSessionInfoStorage();
        AppMethodBeat.o(251485);
        return sessionInfoStorage;
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final /* synthetic */ void a(Context context, int i2, String str, String str2, Long l, aa.a aVar) {
        AppMethodBeat.i(251475);
        long longValue = l.longValue();
        p.h(context, "context");
        p.h(str2, "lotteryId");
        p.h(aVar, "callable");
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            aVar.j("", 0, 0, "");
            Log.e("Finder.SessionInfoService", "[getSessionId] username=" + str + " is invalid, just return.");
            AppMethodBeat.o(251475);
            return;
        }
        String avj = avj(str);
        String str4 = avj;
        if (str4 == null || str4.length() == 0) {
            a(this, context, i2, str, null, longValue, 0, true, str2, null, new C1277e(aVar), 296);
            AppMethodBeat.o(251475);
            return;
        }
        aVar.j(avj, 0, 0, "");
        AppMethodBeat.o(251475);
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final /* synthetic */ void a(Context context, String str, String str2, Long l, Long l2, aa.a aVar) {
        AppMethodBeat.i(251473);
        long longValue = l.longValue();
        long longValue2 = l2.longValue();
        p.h(context, "context");
        p.h(str2, ch.COL_USERNAME);
        p.h(aVar, "callable");
        if (longValue == 0 || longValue2 == 0) {
            aVar.j("", 0, 0, "");
            Log.e("Finder.SessionInfoService", "[getSessionId] username=" + str2 + " objectId=" + longValue + " or commentId=" + longValue2 + " is invalid, just return.");
            AppMethodBeat.o(251473);
            return;
        }
        String str3 = getSessionInfoStorage().avz(str).field_sessionId;
        String str4 = str3;
        if (str4 == null || str4.length() == 0) {
            a(this, context, 1, str2, null, longValue, longValue2, false, null, null, new c(aVar), 456);
            AppMethodBeat.o(251473);
            return;
        }
        aVar.j(str3, 0, 0, "");
        AppMethodBeat.o(251473);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final void a(Context context, int i2, String str, aa.a aVar) {
        AppMethodBeat.i(261365);
        p.h(context, "context");
        p.h(aVar, "callable");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            aVar.j("", 0, 0, "");
            Log.e("Finder.SessionInfoService", "[getSessionId] username=" + str + " is invalid, just return.");
            AppMethodBeat.o(261365);
            return;
        }
        String avj = avj(str);
        String str3 = avj;
        if (str3 == null || str3.length() == 0) {
            a(this, context, i2, str, null, 0, 0, false, null, null, new b(aVar), 504);
            AppMethodBeat.o(261365);
            return;
        }
        aVar.j(avj, 0, 0, "");
        AppMethodBeat.o(261365);
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final void a(Context context, String str, String str2, aa.a aVar) {
        AppMethodBeat.i(251474);
        p.h(context, "context");
        p.h(aVar, "callable");
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            aVar.j("", 0, 0, "");
            Log.e("Finder.SessionInfoService", "[getSessionId] fansId=" + str2 + " is invalid, just return.");
            AppMethodBeat.o(251474);
            return;
        }
        String str4 = getSessionInfoStorage().avz(str).field_sessionId;
        String str5 = str4;
        if (str5 == null || str5.length() == 0) {
            a(this, context, 1, "", str2, 0, 0, false, null, null, new d(aVar), m.CTRL_INDEX);
            AppMethodBeat.o(251474);
            return;
        }
        aVar.j(str4, 0, 0, "");
        AppMethodBeat.o(251474);
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final String avi(String str) {
        AppMethodBeat.i(251476);
        String avB = getSessionInfoStorage().avB(str);
        AppMethodBeat.o(251476);
        return avB;
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final String avj(String str) {
        AppMethodBeat.i(251477);
        String avA = getSessionInfoStorage().avA(str);
        AppMethodBeat.o(251477);
        return avA;
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final String avk(String str) {
        AppMethodBeat.i(251478);
        if (as.bjt(getSessionInfoStorage().avB(str))) {
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            AppMethodBeat.o(251478);
            return aTY;
        }
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        AppMethodBeat.o(251478);
        return aUg;
    }

    private static /* synthetic */ void a(e eVar, Context context, int i2, String str, String str2, long j2, long j3, boolean z, String str3, ag.b bVar, r rVar, int i3) {
        String str4;
        long j4;
        long j5;
        boolean z2;
        String str5;
        AppMethodBeat.i(251480);
        if ((i3 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 16) != 0) {
            j4 = 0;
        } else {
            j4 = j2;
        }
        if ((i3 & 32) != 0) {
            j5 = 0;
        } else {
            j5 = j3;
        }
        if ((i3 & 64) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i3 & 128) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        eVar.a(context, i2, str, str4, j4, j5, z2, str5, (i3 & 256) != 0 ? ag.b.GET_SESSION_ID : bVar, rVar);
        AppMethodBeat.o(251480);
    }

    private void a(Context context, int i2, String str, String str2, long j2, long j3, boolean z, String str3, ag.b bVar, r<? super String, ? super Integer, ? super Integer, ? super String, x> rVar) {
        an anVar;
        AppMethodBeat.i(251479);
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        p.h(str3, "lotteryId");
        p.h(bVar, "source");
        p.h(rVar, "callback");
        if (str2 != null) {
            anVar = new ai(str2).c(context, null, 1500);
        } else if (j2 != 0 && j3 != 0) {
            anVar = new ai(i2, str, j2, j3).c(context, null, 1500);
        } else if (z) {
            anVar = new ai(i2, str, str3, j2).c(context, null, 1500);
        } else {
            anVar = new ai(i2, str).c(context, null, 1500);
        }
        anVar.aYI().j(new f(this, str, str2, j2, j3, bVar, rVar));
        AppMethodBeat.o(251479);
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final void a(LinkedList<azi> linkedList, aa.b bVar) {
        AppMethodBeat.i(251481);
        p.h(linkedList, "reqItems");
        f fVar = f.vwe;
        p.h(linkedList, "reqItems");
        f.vwd = bVar;
        com.tencent.mm.kernel.g.azz().a(6218, fVar);
        com.tencent.mm.kernel.g.azz().b(new cg(linkedList));
        AppMethodBeat.o(251481);
    }

    @Override // com.tencent.mm.plugin.i.a.aa
    public final boolean avl(String str) {
        AppMethodBeat.i(251482);
        if (str != null) {
            boolean nm = n.nm(str, "@findermsg");
            AppMethodBeat.o(251482);
            return nm;
        }
        AppMethodBeat.o(251482);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ag> {
        public static final g vwc = new g();

        static {
            AppMethodBeat.i(251470);
            AppMethodBeat.o(251470);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ag invoke() {
            AppMethodBeat.i(251469);
            ag sessionInfoStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage();
            AppMethodBeat.o(251469);
            return sessionInfoStorage;
        }
    }
}

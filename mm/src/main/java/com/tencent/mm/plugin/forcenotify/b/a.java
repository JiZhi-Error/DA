package com.tencent.mm.plugin.forcenotify.b;

import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0012\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\"H&J0\u0010'\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J$\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205H&J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020%H&J\u0014\u00108\u001a\u0004\u0018\u0001052\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "dealWithLiveForcePush", "dealWithMsgForcePush", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", ch.COL_USERNAME, "", "onReceiveLiveForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "parseLiveForcePushItem", "xml", "release", "start", "plugin-force-notify_release"})
public abstract class a implements com.tencent.mm.plugin.forcenotify.a.b, MStorageEx.IOnStorageChange {
    final String TAG = "MicroMsg.ForceNotifyService";
    private long wLC;
    private final kotlin.f wLD = kotlin.g.ah(b.wLL);
    private final MMHandler wLE = new MMHandler(Looper.getMainLooper());
    private final ConcurrentLinkedQueue<String> wLF = new ConcurrentLinkedQueue<>();
    private final c wLG = new c(this);

    private final MMHandler dMn() {
        return (MMHandler) this.wLD.getValue();
    }

    public abstract void a(com.tencent.mm.plugin.forcenotify.c.d dVar);

    public abstract void a(com.tencent.mm.plugin.forcenotify.c.d dVar, boolean z);

    public abstract void a(com.tencent.mm.plugin.forcenotify.c.g gVar);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* bridge */ /* synthetic */ void a(de deVar) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* synthetic */ void b(de deVar) {
        de deVar2 = deVar;
        p.h(deVar2, "addMsg");
        dMn().post(new RunnableC1364a(this, deVar2));
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        if (!(obj instanceof String)) {
            return;
        }
        if (i2 == 5 || i2 == 4) {
            String str = ((String) obj) + "@wxcontact";
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(Util.nullAs((String) obj, ""));
            if (Kn != null) {
                if (!Kn.arv() || Kn.ary()) {
                    com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.wLU;
                    boolean axF = com.tencent.mm.plugin.forcenotify.d.a.axF(Kn.getUsername() + "@wxcontact");
                    Log.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", obj, Boolean.valueOf(axF));
                    if (!axF) {
                        return;
                    }
                    if (Kn.ary()) {
                        aS(str, 9);
                    } else {
                        aS(str, 7);
                    }
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
    public static final class c extends IListener<mi> {
        final /* synthetic */ a wLH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.wLH = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mi miVar) {
            AppMethodBeat.i(149149);
            mi miVar2 = miVar;
            p.h(miVar2, "event");
            Log.i(this.wLH.TAG, "[callback] event:%s", miVar2);
            new com.tencent.mm.plugin.forcenotify.c.c().aYI();
            AppMethodBeat.o(149149);
            return true;
        }
    }

    public void start() {
        ab.a(5, this);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().a("NewXmlAddForcePush", this);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah2).getSysCmdMsgExtension().a("NewXmlDelForcePush", this);
        this.wLG.alive();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().add(this);
        dMn().post(f.wLN);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        public static final f wLN = new f();

        static {
            AppMethodBeat.i(149153);
            AppMethodBeat.o(149153);
        }

        f() {
        }

        public final void run() {
            AppMethodBeat.i(149152);
            com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.wLU;
            com.tencent.mm.plugin.forcenotify.d.a.dMt();
            AppMethodBeat.o(149152);
        }
    }

    public void release() {
        this.wLG.dead();
        ab.a(this);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().b("NewXmlAddForcePush", this);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah2).getSysCmdMsgExtension().b("NewXmlDelForcePush", this);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().remove(this);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.b.a$a  reason: collision with other inner class name */
    static final class RunnableC1364a implements Runnable {
        final /* synthetic */ a wLH;
        final /* synthetic */ de wLI;

        RunnableC1364a(a aVar, de deVar) {
            this.wLH = aVar;
            this.wLI = deVar;
        }

        public final void run() {
            AppMethodBeat.i(149146);
            if (a.a(this.wLH)) {
                com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.wLU;
                com.tencent.mm.plugin.forcenotify.d.a.dMt();
            }
            a.a(this.wLH, this.wLI);
            a.b(this.wLH, this.wLI);
            AppMethodBeat.o(149146);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$dealWithMsgForcePush$1$1"})
    public static final class h implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.d UVU;
        final /* synthetic */ a wLH;

        h(com.tencent.mm.plugin.forcenotify.c.d dVar, a aVar) {
            this.UVU = dVar;
            this.wLH = aVar;
        }

        public final void run() {
            AppMethodBeat.i(261742);
            this.wLH.a(this.UVU);
            AppMethodBeat.o(261742);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$dealWithLiveForcePush$1$1"})
    public static final class g implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.g UVS;
        final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.g UVT;
        final /* synthetic */ a wLH;

        g(com.tencent.mm.plugin.forcenotify.c.g gVar, a aVar, com.tencent.mm.plugin.forcenotify.c.g gVar2) {
            this.UVS = gVar;
            this.wLH = aVar;
            this.UVT = gVar2;
        }

        public final void run() {
            AppMethodBeat.i(261741);
            this.wLH.a(this.UVS);
            AppMethodBeat.o(261741);
        }
    }

    private static com.tencent.mm.plugin.forcenotify.c.g byg(String str) {
        String str2;
        Map<String, String> parseXml = XmlParser.parseXml(str, "general_string", null);
        if (parseXml == null || (str2 = parseXml.get(".general_string")) == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str2).getString("force_push_info"));
            String string = jSONObject.getString("forcePushId");
            String string2 = jSONObject.getString("userIcon");
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(Constants.EXTINFO));
            String optString = jSONObject2.optString("auth_icon_url", "");
            String optString2 = jSONObject2.optString("nickname", "");
            p.g(string, "forcePushId");
            p.g(string2, "userIcon");
            p.g(optString2, "nickname");
            String string3 = MMApplicationContext.getContext().getString(R.string.jd4);
            p.g(string3, "MMApplicationContext.get…notify_start_finder_live)");
            return new com.tencent.mm.plugin.forcenotify.c.g(string, string2, optString2, string3, optString);
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f2, code lost:
        if (kotlin.n.n.nm(r0, "@finderlive") != false) goto L_0x00f4;
     */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewXmlReceived(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, com.tencent.mm.ak.h.a r13) {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.forcenotify.b.a.onNewXmlReceived(java.lang.String, java.util.Map, com.tencent.mm.ak.h$a):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ a wLH;
        final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.d wLM;

        d(a aVar, com.tencent.mm.plugin.forcenotify.c.d dVar) {
            this.wLH = aVar;
            this.wLM = dVar;
        }

        public final void run() {
            AppMethodBeat.i(149150);
            this.wLH.a(this.wLM, false);
            AppMethodBeat.o(149150);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ a wLH;
        final /* synthetic */ com.tencent.mm.plugin.forcenotify.c.d wLM;

        e(a aVar, com.tencent.mm.plugin.forcenotify.c.d dVar) {
            this.wLH = aVar;
            this.wLM = dVar;
        }

        public final void run() {
            AppMethodBeat.i(149151);
            this.wLH.a(this.wLM, true);
            AppMethodBeat.o(149151);
        }
    }

    private static String axD(String str) {
        return ".sysmsg".concat(String.valueOf(str));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MMHandler> {
        public static final b wLL = new b();

        static {
            AppMethodBeat.i(185651);
            AppMethodBeat.o(185651);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(185650);
            HandlerThread bqr = com.tencent.f.c.d.bqr("ForceNotifyService");
            bqr.start();
            p.g(bqr, "thread");
            MMHandler mMHandler = new MMHandler(bqr.getLooper());
            AppMethodBeat.o(185650);
            return mMHandler;
        }
    }

    public static final /* synthetic */ boolean a(a aVar) {
        boolean z = cl.aWz() - aVar.wLC > 1800000;
        if (z) {
            aVar.wLC = cl.aWz();
        }
        return z;
    }

    public static final /* synthetic */ void a(a aVar, de deVar) {
        String str = null;
        Map<String, String> parseXml = XmlParser.parseXml(deVar.KHq, "ForcePushId", null);
        if (parseXml != null) {
            str = parseXml.get(".ForcePushId");
        }
        if (str != null) {
            Log.i(aVar.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", deVar.KHq, deVar.KHl, str);
            String a2 = z.a(deVar.KHl);
            if (!(!p.j(com.tencent.mm.model.z.aTY(), a2)) || aVar.wLF.contains(a2)) {
                Log.w(aVar.TAG, "ERROR! no show! notifyList=" + aVar.wLF);
            } else if (aVar.axC(str)) {
                Log.i(aVar.TAG, "fromUser=" + a2 + " isNeedNotify=true");
                com.tencent.mm.plugin.forcenotify.d.a aVar2 = com.tencent.mm.plugin.forcenotify.d.a.wLU;
                com.tencent.mm.plugin.forcenotify.c.d byi = com.tencent.mm.plugin.forcenotify.d.a.byi(str);
                if (byi != null) {
                    aVar.wLE.post(new h(byi, aVar));
                }
            } else {
                Log.w(aVar.TAG, "ERROR! no show!");
            }
        }
    }

    public static final /* synthetic */ void b(a aVar, de deVar) {
        com.tencent.mm.plugin.forcenotify.c.g byg = byg(z.a(deVar.KHn));
        if (byg != null) {
            String str = byg.wMn;
            Log.i(aVar.TAG, "receive msg! livePushId:%s", str);
            if (aVar.axC(str)) {
                aVar.wLE.post(new g(byg, aVar, byg));
            } else {
                Log.w(aVar.TAG, "ERROR! no show!");
            }
        } else {
            Log.w(aVar.TAG, "ERROR! no show!");
        }
    }
}

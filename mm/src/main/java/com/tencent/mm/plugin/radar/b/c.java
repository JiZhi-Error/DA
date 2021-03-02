package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012*\u0002\u000e\u0014\u0018\u0000 ?2\u00020\u0001:\u0005>?@ABB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u0010\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J4\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\"\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00103\u001a\u00020\u001cH\u0002J,\u00105\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0018\u00106\u001a\u00020)2\u0006\u00103\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0006\u0010:\u001a\u00020)J\u001a\u0010;\u001a\u00020)2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020-H\u0002J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", ch.COL_USERNAME, "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c implements MStorageEx.IOnStorageChange {
    public static final b Byk = new b((byte) 0);
    public static final String TAG = TAG;
    private final LinkedList<String> Byf = new LinkedList<>();
    public final HashMap<String, String> Byg = new HashMap<>();
    public final i Byh = new i(this);
    public final g Byi = new g(this);
    final AbstractC1620c Byj;
    final Context context;
    private final MMHandler handler = new MMHandler();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", ch.COL_USERNAME, "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$c  reason: collision with other inner class name */
    public interface AbstractC1620c {
        void a(boolean z, String str, String str2, long j2);

        void a(boolean z, boolean z2, String str, String str2, long j2);

        void ag(as asVar);

        void ah(as asVar);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public interface d {
        void a(boolean z, boolean z2, String str, String str2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
    public enum e {
        Stranger,
        Verifying,
        Added,
        NeedVerify;

        static {
            AppMethodBeat.i(138517);
            AppMethodBeat.o(138517);
        }

        public static e valueOf(String str) {
            AppMethodBeat.i(138519);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(138519);
            return eVar;
        }
    }

    public c(AbstractC1620c cVar, Context context2) {
        p.h(cVar, "delegate");
        p.h(context2, "context");
        AppMethodBeat.i(138535);
        this.Byj = cVar;
        this.context = context2;
        AppMethodBeat.o(138535);
    }

    public static final /* synthetic */ void a(c cVar, as asVar) {
        AppMethodBeat.i(138541);
        cVar.ae(asVar);
        AppMethodBeat.o(138541);
    }

    public static final /* synthetic */ void c(c cVar, as asVar) {
        AppMethodBeat.i(138544);
        cVar.ag(asVar);
        AppMethodBeat.o(138544);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
    public static final class i extends IListener<qh> {
        final /* synthetic */ c Byo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(c cVar) {
            this.Byo = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qh qhVar) {
            AppMethodBeat.i(138524);
            qh qhVar2 = qhVar;
            p.h(qhVar2, "event");
            String str = qhVar2.dWE.dWG;
            as a2 = c.a(ca.d.bkD(str));
            c.a(this.Byo, a2);
            c cVar = this.Byo;
            p.g(str, "msgContent");
            c.a(cVar, a2, str);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "service(IMessengerStorage::class.java)");
            bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
            if (!aSN.bjN(a2.ajB())) {
                aSN.ao(a2);
            }
            Log.d(c.TAG, "receive verify mssage %s, encypt %s", a2.getUsername(), a2.ajB());
            c.b(this.Byo, a2);
            AppMethodBeat.o(138524);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
    public static final class g implements cj.a {
        final /* synthetic */ c Byo;
        private final String Byv = ".sysmsg.addcontact.type";
        private final String Byw = ".sysmsg.addcontact.username";
        private final String Byx = ".sysmsg.addcontact.encryptusername";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(c cVar) {
            this.Byo = cVar;
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            boolean z;
            AppMethodBeat.i(138521);
            p.h(aVar, "addMsgInfo");
            String a2 = z.a(aVar.heO.KHn);
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                AppMethodBeat.o(138521);
                return;
            }
            if (p.j(parseXml.get(this.Byv), "1")) {
                String str = parseXml.get(this.Byw);
                String str2 = parseXml.get(this.Byx);
                String str3 = str;
                if (str3 == null || n.aL(str3)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String str4 = str2;
                    if (!(str4 == null || n.aL(str4))) {
                        as asVar = new as();
                        asVar.setUsername(str);
                        asVar.BK(str2);
                        c.c(this.Byo, asVar);
                        Log.d(c.TAG, "receive contact added system message useranme %s, encypt %s", asVar.getUsername(), asVar.ajB());
                    }
                }
                Log.e(c.TAG, "error! server return incorrect content! : %s", a2);
                AppMethodBeat.o(138521);
                return;
            }
            AppMethodBeat.o(138521);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
            AppMethodBeat.i(138522);
            kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
            AppMethodBeat.o(138522);
            throw nVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public static final class f implements d {
        final /* synthetic */ c Byo;
        final /* synthetic */ long Byu;
        final /* synthetic */ String hLl;

        f(c cVar, String str, long j2) {
            this.Byo = cVar;
            this.hLl = str;
            this.Byu = j2;
        }

        @Override // com.tencent.mm.plugin.radar.b.c.d
        public final void a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.i(138520);
            if (z) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
                p.g(Kn, "contact");
                if (Kn.arH() > 0) {
                    ab.B(Kn);
                }
                c.fg(str, 1);
                if (kotlin.a.j.a((Iterable) this.Byo.Byf, (Object) str)) {
                    LinkedList linkedList = this.Byo.Byf;
                    if (linkedList == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        AppMethodBeat.o(138520);
                        throw tVar;
                    }
                    af.eV(linkedList).remove(str);
                }
                Log.d(c.TAG, "addContact %s return ok", this.hLl);
            } else if (z2) {
                if (str != null && !this.Byo.Byf.contains(str)) {
                    this.Byo.Byf.add(str);
                }
                c.fg(str, 2);
                Log.d(c.TAG, "addContact has sent verify to %s", this.hLl);
            } else {
                Log.d(c.TAG, "addContact return not ok, user canceled or error");
            }
            c.a(this.Byo, z, z2, str2, str, this.Byu);
            AppMethodBeat.o(138520);
        }
    }

    public final long aKM(String str) {
        AppMethodBeat.i(138529);
        p.h(str, ch.COL_USERNAME);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(new f(this, str, currentTimeMillis));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(48);
        Assert.assertTrue(str != null && str.length() > 0);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.Bym = linkedList;
        aVar.mRa = str;
        if (str != null) {
            aVar.Byl.add(str);
        }
        new aa(c.this.context, null).z(aVar.Byl, linkedList);
        AppMethodBeat.o(138529);
        return currentTimeMillis;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public static final class m implements d {
        final /* synthetic */ c Byo;
        final /* synthetic */ long Byu;
        final /* synthetic */ String kWI;

        public m(c cVar, String str, long j2) {
            this.Byo = cVar;
            this.kWI = str;
            this.Byu = j2;
        }

        @Override // com.tencent.mm.plugin.radar.b.c.d
        public final void a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            AppMethodBeat.i(138528);
            if (z) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
                if (Kn == null || Kn.arH() == 0) {
                    as a2 = c.a(ca.d.bkD(this.kWI));
                    com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af2, "service(IMessengerStorage::class.java)");
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().ap(a2)) {
                        Log.e(c.TAG, "canAddContact fail, insert fail");
                        z = false;
                    }
                    com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af3, "service(IMessengerStorage::class.java)");
                    Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af3).aSN().Kn(a2.getUsername());
                }
                Log.d(c.TAG, "verifyContact return ok");
                ab.B(Kn);
                c.fg(str, 1);
                z3 = z;
            } else {
                Log.d(c.TAG, "verifyContact return not ok");
                z3 = z;
            }
            c.a(this.Byo, z3, str2, str, this.Byu);
            AppMethodBeat.o(138528);
        }
    }

    public final e aKN(String str) {
        e eVar;
        AppMethodBeat.i(138530);
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn == null || Kn.arH() == 0) {
            if (this.Byf.contains(str)) {
                eVar = e.Verifying;
            } else {
                eVar = e.Stranger;
            }
        } else if (Kn.arv()) {
            eVar = e.Added;
        } else if (this.Byg.containsKey(str)) {
            eVar = e.NeedVerify;
        } else if (this.Byf.contains(str)) {
            eVar = e.Verifying;
        } else {
            eVar = e.Stranger;
        }
        Log.d(TAG, "query username(%s) status %s", str, eVar);
        AppMethodBeat.o(138530);
        return eVar;
    }

    private final void ae(as asVar) {
        AppMethodBeat.i(138531);
        if (this.Byf.contains(asVar.getUsername())) {
            this.Byf.remove(asVar.getUsername());
        }
        if (this.Byf.contains(asVar.ajB())) {
            this.Byf.remove(asVar.ajB());
        }
        AppMethodBeat.o(138531);
    }

    private final void af(as asVar) {
        AppMethodBeat.i(138532);
        this.Byg.remove(asVar.getUsername());
        this.Byg.remove(asVar.ajB());
        AppMethodBeat.o(138532);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(138533);
        p.h(mStorageEx, "stg");
        Log.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
        if (obj == null || !(obj instanceof String)) {
            Log.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(138533);
            return;
        }
        String str = (String) obj;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn != null && Kn.arv()) {
            Log.d(TAG, "ContactStg onNotifyChange %s", str);
            ag(Kn);
        }
        AppMethodBeat.o(138533);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ c Byo;
        final /* synthetic */ as Byz;

        k(c cVar, as asVar) {
            this.Byo = cVar;
            this.Byz = asVar;
        }

        public final void run() {
            AppMethodBeat.i(138526);
            this.Byo.Byj.ah(this.Byz);
            AppMethodBeat.o(138526);
        }
    }

    private final void ag(as asVar) {
        AppMethodBeat.i(138534);
        ae(asVar);
        af(asVar);
        this.handler.post(new j(this, asVar));
        AppMethodBeat.o(138534);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ c Byo;
        final /* synthetic */ as Byz;

        j(c cVar, as asVar) {
            this.Byo = cVar;
            this.Byz = asVar;
        }

        public final void run() {
            AppMethodBeat.i(138525);
            this.Byo.Byj.ag(this.Byz);
            AppMethodBeat.o(138525);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ String $errMsg;
        final /* synthetic */ c Byo;
        final /* synthetic */ long Byu;
        final /* synthetic */ boolean Byy;
        final /* synthetic */ String hLl;
        final /* synthetic */ boolean ycQ;

        h(c cVar, boolean z, boolean z2, String str, String str2, long j2) {
            this.Byo = cVar;
            this.ycQ = z;
            this.Byy = z2;
            this.$errMsg = str;
            this.hLl = str2;
            this.Byu = j2;
        }

        public final void run() {
            AppMethodBeat.i(138523);
            this.Byo.Byj.a(this.ycQ, this.Byy, this.$errMsg, this.hLl, this.Byu);
            AppMethodBeat.o(138523);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ String $errMsg;
        final /* synthetic */ c Byo;
        final /* synthetic */ long Byu;
        final /* synthetic */ String hLl;
        final /* synthetic */ boolean ycQ;

        l(c cVar, boolean z, String str, String str2, long j2) {
            this.Byo = cVar;
            this.ycQ = z;
            this.$errMsg = str;
            this.hLl = str2;
            this.Byu = j2;
        }

        public final void run() {
            AppMethodBeat.i(138527);
            this.Byo.Byj.a(this.ycQ, this.$errMsg, this.hLl, this.Byu);
            AppMethodBeat.o(138527);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J,\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J \u0010\u001c\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", ch.COL_USERNAME, "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
    public final class a implements com.tencent.mm.ak.i {
        final LinkedList<String> Byl = new LinkedList<>();
        LinkedList<Integer> Bym;
        private final d Byn;
        String mRa;

        public a(d dVar) {
            AppMethodBeat.i(138516);
            this.Byn = dVar;
            AppMethodBeat.o(138516);
        }

        public final void onStart() {
            AppMethodBeat.i(138513);
            com.tencent.mm.kernel.g.azz().a(30, this);
            AppMethodBeat.o(138513);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(138515);
            p.h(qVar, "scene");
            Log.d(c.TAG, "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
            if (qVar.getType() != 30) {
                Log.w(c.TAG, "not expected scene,  type = " + qVar.getType());
                AppMethodBeat.o(138515);
                return;
            }
            if (((com.tencent.mm.pluginsdk.model.p) qVar).gmE() == 2) {
                if (i2 == 0 && i3 == 0) {
                    b(false, true, this.mRa, "");
                    AppMethodBeat.o(138515);
                    return;
                }
                if (i2 == 4 && i3 == -34) {
                    str = c.this.context.getString(R.string.ddu);
                } else if (i2 == 4 && i3 == -94) {
                    str = c.this.context.getString(R.string.ddx);
                } else if (i2 != 4 || (!(i3 == -24 || i3 == -101) || str == null)) {
                    str = c.this.context.getString(R.string.gkm);
                }
                p.g(str, "when {\n                 …il)\n                    }");
            } else if (i2 == 0 && i3 == 0) {
                b(true, false, this.mRa, "");
                AppMethodBeat.o(138515);
                return;
            } else if (i3 == -44) {
                new aa(c.this.context, null).z(this.Byl, this.Bym);
                AppMethodBeat.o(138515);
                return;
            } else if (i3 == -87) {
                b(false, false, this.mRa, c.this.context.getString(R.string.b_d));
                AppMethodBeat.o(138515);
                return;
            } else if (i3 == -24 && !Util.isNullOrNil(str)) {
                String str2 = this.mRa;
                if (str == null) {
                    str = "";
                }
                b(false, false, str2, str);
                AppMethodBeat.o(138515);
                return;
            } else if (i2 == 4 && i3 == -22) {
                str = c.this.context.getString(R.string.dv);
            } else {
                str = c.this.context.getString(R.string.du);
            }
            b(false, false, this.mRa, str);
            AppMethodBeat.o(138515);
        }

        private final void b(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.i(138514);
            com.tencent.mm.kernel.g.azz().b(30, this);
            d dVar = this.Byn;
            if (dVar != null) {
                dVar.a(z, z2, str, str2);
                AppMethodBeat.o(138514);
                return;
            }
            AppMethodBeat.o(138514);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138536);
        AppMethodBeat.o(138536);
    }

    public static final /* synthetic */ void fg(String str, int i2) {
        AppMethodBeat.i(138537);
        go goVar = new go();
        goVar.dKw.dKy = 0;
        goVar.dKw.talker = str;
        goVar.dKw.state = i2;
        EventCenter.instance.publish(goVar);
        AppMethodBeat.o(138537);
    }

    public static final /* synthetic */ boolean a(c cVar, boolean z, boolean z2, String str, String str2, long j2) {
        AppMethodBeat.i(138538);
        boolean post = cVar.handler.post(new h(cVar, z, z2, str, str2, j2));
        AppMethodBeat.o(138538);
        return post;
    }

    public static final /* synthetic */ as a(ca.d dVar) {
        AppMethodBeat.i(138539);
        as asVar = new as();
        if (dVar != null) {
            asVar.setUsername(dVar.gDY());
            asVar.BK(dVar.gEd());
            asVar.BC(dVar.ajx());
            asVar.setNickname(dVar.getNickname());
            asVar.BF(dVar.ajz());
            asVar.BG(dVar.ajA());
            asVar.nj(dVar.ajE());
            asVar.BV(dVar.getSignature());
            asVar.BW(dVar.getProvince());
            asVar.BX(dVar.getCity());
        } else {
            Log.e(TAG, "verify is null! must be parsed error before!");
        }
        AppMethodBeat.o(138539);
        return asVar;
    }

    public static final /* synthetic */ boolean a(c cVar, boolean z, String str, String str2, long j2) {
        AppMethodBeat.i(138540);
        boolean post = cVar.handler.post(new l(cVar, z, str, str2, j2));
        AppMethodBeat.o(138540);
        return post;
    }

    public static final /* synthetic */ void a(c cVar, as asVar, String str) {
        AppMethodBeat.i(138542);
        cVar.Byg.put(asVar.getUsername(), str);
        cVar.Byg.put(asVar.ajB(), str);
        AppMethodBeat.o(138542);
    }

    public static final /* synthetic */ boolean b(c cVar, as asVar) {
        AppMethodBeat.i(138543);
        boolean post = cVar.handler.post(new k(cVar, asVar));
        AppMethodBeat.o(138543);
        return post;
    }
}

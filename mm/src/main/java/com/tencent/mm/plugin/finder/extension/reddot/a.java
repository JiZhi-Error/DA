package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1111a tJi = new C1111a((byte) 0);
    public final MMHandler handler;
    public String tJg = "";
    private final f tJh;

    static {
        AppMethodBeat.i(243490);
        AppMethodBeat.o(243490);
    }

    public a(f fVar) {
        p.h(fVar, "manager");
        AppMethodBeat.i(243489);
        this.tJh = fVar;
        MMHandler mMHandler = new MMHandler("FinderMsgRedDotHandler", new c(this));
        mMHandler.setLogging(false);
        this.handler = mMHandler;
        AppMethodBeat.o(243489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.extension.reddot.a$a  reason: collision with other inner class name */
    public static final class C1111a {
        private C1111a() {
        }

        public /* synthetic */ C1111a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class c implements MMHandler.Callback {
        final /* synthetic */ a tJj;

        c(a aVar) {
            this.tJj = aVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(243485);
            Log.i("Finder.MsgRedDotHandler", "[Callback] What=" + message.what);
            switch (message.what) {
                case 1:
                    if (a.dav()) {
                        a.b(this.tJj);
                        break;
                    }
                    break;
                case 2:
                    if (a.dav()) {
                        a.d(this.tJj);
                        break;
                    }
                    break;
                case 3:
                    if (a.dav()) {
                        a.e(this.tJj);
                        break;
                    }
                    break;
                case 4:
                    if (a.dav()) {
                        a.c(this.tJj);
                        break;
                    }
                    break;
                case 6:
                    if (a.dav()) {
                        a.f(this.tJj);
                        break;
                    }
                    break;
                case 7:
                    a.g(this.tJj);
                    break;
                case 8:
                    a.h(this.tJj);
                    break;
                case 9:
                    a.i(this.tJj);
                    break;
            }
            AppMethodBeat.o(243485);
            return true;
        }
    }

    public final void das() {
        AppMethodBeat.i(243486);
        this.handler.removeMessages(8);
        this.handler.sendEmptyMessage(8);
        AppMethodBeat.o(243486);
    }

    public final void dat() {
        AppMethodBeat.i(243487);
        this.handler.removeMessages(7);
        this.handler.sendEmptyMessage(7);
        AppMethodBeat.o(243487);
    }

    public final void dau() {
        AppMethodBeat.i(243488);
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(1);
        AppMethodBeat.o(243488);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a tJj;

        public b(a aVar) {
            this.tJj = aVar;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(243484);
            long currentTimeMillis = System.currentTimeMillis();
            int gk = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(2, 2);
            int gk2 = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(2, 1);
            k asX = this.tJj.tJh.asX("finder_private_msg_entrance");
            if (asX != null && asX.field_ctrInfo.type == 1007) {
                if (gk2 <= 0) {
                    h.INSTANCE.a(20492, 2L, 1L, Long.valueOf(currentTimeMillis));
                    h.INSTANCE.n(1473, 2, 1);
                }
                i2 = 1;
            } else if (asX == null || asX.field_ctrInfo.type != 1006) {
                i2 = 0;
            } else {
                bdo atl = asX.atl("finder_private_msg_entrance");
                if (atl != null) {
                    i2 = atl.count;
                } else {
                    i2 = 0;
                }
                if (i2 != gk) {
                    h.INSTANCE.a(20492, 1L, 1L, Long.valueOf(currentTimeMillis));
                    h.INSTANCE.n(1473, 1, 1);
                }
            }
            Log.i("Finder.MsgRedDotHandler", "[checkMsgRedDot] token=" + currentTimeMillis + " cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms, [normalUnReadCount:redDotCount]=[" + gk + ':' + i2 + "] greetUnReadCount=" + gk2 + " ctrlType=[" + (asX != null ? Integer.valueOf(asX.field_ctrInfo.type) : null) + ']');
            AppMethodBeat.o(243484);
        }
    }

    public static final /* synthetic */ boolean dav() {
        AppMethodBeat.i(243491);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtG().value().intValue() > 0) {
            AppMethodBeat.o(243491);
            return true;
        }
        AppMethodBeat.o(243491);
        return false;
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(243492);
        int gk = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(2, 2);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
        Log.i("Finder.MsgRedDotHandler", "[addFinderMessageRedDot] unReadCount=".concat(String.valueOf(gk)));
        if (gk + i2 > 0) {
            bbi bbi = new bbi();
            bbi.LKM = String.valueOf(cl.aWA());
            bbi.priority = 10010000;
            bbi.type = 1006;
            bdo bdo = new bdo();
            bdo.xGz = 3;
            bdo.title = MMApplicationContext.getContext().getString(R.string.d1c);
            bdo.path = "FinderEntrance";
            bdo.LNm = 1;
            bbi.GaM.add(bdo);
            bdo bdo2 = new bdo();
            bdo2.xGz = 1;
            bdo2.LNm = 1;
            bdo2.path = "TLPersonalCenter";
            bbi.GaM.add(bdo2);
            bdo bdo3 = new bdo();
            bdo3.xGz = 2;
            bdo3.LNm = 2;
            bdo3.path = "finder_private_msg_entrance";
            bdo3.count = gk + i2;
            bbi.GaM.add(bdo3);
            bdo bdo4 = new bdo();
            bdo4.xGz = 2;
            bdo4.LNm = 1;
            bdo4.path = "FinderMessageConversation";
            bdo4.Bvg = "finder_private_msg_entrance";
            bbi.GaM.add(bdo4);
            aVar.tJh.a(bbi, "addFinderMessageRedDot");
            AppMethodBeat.o(243492);
            return;
        }
        aVar.tJh.Iy(1006);
        AppMethodBeat.o(243492);
    }

    public static final /* synthetic */ void c(a aVar) {
        k kVar;
        AppMethodBeat.i(243493);
        k asX = aVar.tJh.asX("finder_private_msg_entrance");
        if (asX != null) {
            if (asX.field_ctrInfo.type == 1006) {
                kVar = asX;
            } else {
                kVar = null;
            }
            if (kVar != null) {
                bdo atl = kVar.atl("finder_private_msg_entrance");
                if (atl != null) {
                    int gk = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(2, 2);
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
                    atl.count = gk + i2;
                    Log.i("Finder.MsgRedDotHandler", "[updateFinderMessageRedDot] unReadCount=".concat(String.valueOf(gk)));
                    if (gk + i2 > 0) {
                        bbi bbi = new bbi();
                        String str = asX.field_tipsId;
                        if (str == null) {
                            str = "";
                        }
                        bbi.LKM = str;
                        bbi.priority = 10010000;
                        bbi.type = 1006;
                        bbi.GaM.addAll(kVar.field_ctrInfo.GaM);
                        aVar.tJh.a(bbi, "updateFinderMessageRedDot");
                        AppMethodBeat.o(243493);
                        return;
                    }
                    aVar.tJh.Iy(1006);
                    AppMethodBeat.o(243493);
                    return;
                }
                AppMethodBeat.o(243493);
                return;
            }
        }
        AppMethodBeat.o(243493);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(243494);
        Log.i("Finder.MsgRedDotHandler", "[addFinderHelloMessageRedDot]");
        bbi bbi = new bbi();
        bbi.LKM = String.valueOf(cl.aWA());
        bbi.priority = 40000;
        bbi.type = 1007;
        bdo bdo = new bdo();
        bdo.xGz = 1;
        bdo.LNm = 1;
        bdo.path = "TLPersonalCenter";
        bbi.GaM.add(bdo);
        bdo bdo2 = new bdo();
        bdo2.xGz = 1;
        bdo2.LNm = 1;
        bdo2.path = "finder_private_msg_entrance";
        bbi.GaM.add(bdo2);
        aVar.tJh.a(bbi, "addFinderHelloMessageRedDot");
        AppMethodBeat.o(243494);
    }

    public static final /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(243495);
        int gk = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(1, 2);
        Log.i("Finder.MsgRedDotHandler", "[addWxMessageRedDot] unReadCount=".concat(String.valueOf(gk)));
        if (gk > 0) {
            bbi bbi = new bbi();
            bbi.LKM = String.valueOf(cl.aWA());
            bbi.priority = 10010000;
            bbi.type = 1008;
            bdo bdo = new bdo();
            bdo.xGz = 3;
            bdo.title = MMApplicationContext.getContext().getString(R.string.d1c);
            bdo.LNm = 1;
            bdo.path = "FinderEntrance";
            bbi.GaM.add(bdo);
            bdo bdo2 = new bdo();
            bdo2.xGz = 1;
            bdo2.LNm = 1;
            bdo2.path = "TLPersonalCenter";
            bbi.GaM.add(bdo2);
            bdo bdo3 = new bdo();
            bdo3.xGz = 2;
            bdo3.LNm = 2;
            bdo3.path = "finder_wx_private_msg_entrance";
            bdo3.count = gk;
            bbi.GaM.add(bdo3);
            bdo bdo4 = new bdo();
            bdo4.xGz = 2;
            bdo4.LNm = 1;
            bdo4.path = "FinderWXMessageConversation";
            bdo4.Bvg = "finder_wx_private_msg_entrance";
            bbi.GaM.add(bdo4);
            bdo bdo5 = new bdo();
            bdo5.xGz = 5;
            bdo5.qGB = aVar.tJg;
            bdo5.LNm = 1;
            bdo5.path = "TLWxPrivateMsgBubble";
            bbi.GaM.add(bdo5);
            aVar.tJh.a(bbi, "addFinderWxMessageRedDot");
            AppMethodBeat.o(243495);
            return;
        }
        aVar.tJh.Iy(1008);
        AppMethodBeat.o(243495);
    }

    public static final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(243496);
        k asX = aVar.tJh.asX("finder_wx_private_msg_entrance");
        if (asX != null) {
            bdo atl = asX.atl("finder_wx_private_msg_entrance");
            if (atl != null) {
                atl.count = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().gk(1, 2);
            }
            bdo atl2 = asX.atl("TLWxPrivateMsgBubble");
            if (atl2 != null) {
                String str = aVar.tJg;
                if (!(str == null || str.length() == 0)) {
                    atl2.qGB = aVar.tJg;
                }
            }
            bbi bbi = new bbi();
            String str2 = asX.field_tipsId;
            if (str2 == null) {
                str2 = "";
            }
            bbi.LKM = str2;
            bbi.priority = 10010000;
            bbi.type = 1008;
            bbi.GaM.addAll(asX.field_ctrInfo.GaM);
            aVar.tJh.a(bbi, "updateWxMessageRedDot");
            AppMethodBeat.o(243496);
            return;
        }
        AppMethodBeat.o(243496);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(243497);
        aVar.tJh.e("TLPersonalCenter", new int[]{1007, 1006, 1008});
        aVar.tJh.e("FinderEntrance", new int[]{1007, 1006, 1008});
        aVar.tJh.asV("finder_private_msg_entrance");
        AppMethodBeat.o(243497);
    }

    public static final /* synthetic */ void h(a aVar) {
        AppMethodBeat.i(243498);
        aVar.tJh.e("TLPersonalCenter", new int[]{1007, 1006, 1008});
        aVar.tJh.e("FinderEntrance", new int[]{1007, 1006, 1008});
        aVar.tJh.asV("finder_wx_private_msg_entrance");
        AppMethodBeat.o(243498);
    }

    public static final /* synthetic */ void i(a aVar) {
        AppMethodBeat.i(243499);
        aVar.tJh.asV("TLWxPrivateMsgBubble");
        aVar.tJg = "";
        AppMethodBeat.o(243499);
    }
}

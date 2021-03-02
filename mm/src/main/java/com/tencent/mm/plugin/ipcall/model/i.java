package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.d.a;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public final class i implements bd {
    private static i ypc = null;
    private static HashMap<Integer, h.b> ypu;
    private e hTl;
    private g ypd = new g();
    private a ype = new a();
    private b ypf = new b();
    public com.tencent.mm.plugin.ipcall.model.c.b ypg;
    private f yph = new f();
    private c ypi = new c();
    private d ypj;
    private l ypk;
    private j ypl;
    private com.tencent.mm.plugin.ipcall.model.h.h ypm;
    private com.tencent.mm.plugin.voip.video.c ypn;
    private Context ypo;
    private long ypp;
    private IListener ypq = new IListener<bn>() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass1 */

        {
            AppMethodBeat.i(161382);
            this.__eventId = bn.class.getName().hashCode();
            AppMethodBeat.o(161382);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bn bnVar) {
            AppMethodBeat.i(25382);
            Log.d("MicroMsg.SubCoreIPCall", "change language");
            com.tencent.mm.plugin.ipcall.a.a.ebL();
            AppMethodBeat.o(25382);
            return false;
        }
    };
    private IListener ypr = new IListener<bl>() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass4 */

        {
            AppMethodBeat.i(161383);
            this.__eventId = bl.class.getName().hashCode();
            AppMethodBeat.o(161383);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bl blVar) {
            AppMethodBeat.i(25385);
            bl blVar2 = blVar;
            if (blVar2 instanceof bl) {
                blVar2.dEG.isStarted = i.eaw().eal();
            }
            AppMethodBeat.o(25385);
            return false;
        }
    };
    private IListener yps = new IListener<ws>() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass5 */

        {
            AppMethodBeat.i(161384);
            this.__eventId = ws.class.getName().hashCode();
            AppMethodBeat.o(161384);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ws wsVar) {
            AppMethodBeat.i(25386);
            ws wsVar2 = wsVar;
            if (wsVar2 instanceof ws) {
                Intent intent = new Intent(MMApplicationContext.getContext(), IPCallDialUI.class);
                intent.setFlags(268435456);
                intent.putExtra("IPCallTalkUI_contactId", wsVar2.ede.edf);
                intent.putExtra("IPCallTalkUI_countryCode", wsVar2.ede.edg);
                intent.putExtra("IPCallTalkUI_nickname", wsVar2.ede.nickName);
                intent.putExtra("IPCallTalkUI_phoneNumber", wsVar2.ede.ebd);
                Context context = MMApplicationContext.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/model/SubCoreIPCall$3", "callback", "(Lcom/tencent/mm/autogen/events/StartIPCallEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ipcall/model/SubCoreIPCall$3", "callback", "(Lcom/tencent/mm/autogen/events/StartIPCallEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(25386);
            return false;
        }
    };
    private IListener ypt = new IListener<kv>() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass6 */

        {
            AppMethodBeat.i(161385);
            this.__eventId = kv.class.getName().hashCode();
            AppMethodBeat.o(161385);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kv kvVar) {
            AppMethodBeat.i(25387);
            kv kvVar2 = kvVar;
            if (kvVar2 instanceof kv) {
                if (kvVar2.dPV.dPY && i.this.ypp == kvVar2.dPV.dPX && i.this.ypo != null) {
                    i.this.ypo = null;
                    i.this.ypp = 0;
                }
                if (!kvVar2.dPV.dPY) {
                    if (kvVar2.dPV.dPX == 0) {
                        i.this.ypo = null;
                        i.this.ypp = 0;
                    } else {
                        i.this.ypo = kvVar2.dPV.dPW;
                        i.this.ypp = kvVar2.dPV.dPX;
                    }
                }
            }
            AppMethodBeat.o(25387);
            return false;
        }
    };
    private cj.a ypv = new cj.a() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass11 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            int i2;
            AppMethodBeat.i(25388);
            Log.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
            String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
                AppMethodBeat.o(25388);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
                AppMethodBeat.o(25388);
                return;
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                int i3 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", Integer.valueOf(i3));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i3));
                i2 = i3;
            } else {
                i2 = -1;
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                int i4 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.AcctRD"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", Integer.valueOf(i4));
                if (i4 != 0) {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 2, 0, 0, Integer.valueOf(i2), -1, -1);
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.TabRD")) {
                int i5 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.TabRD"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", Integer.valueOf(i5));
                if (i5 != 0) {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 1, 0, 0, -1, -1, -1);
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                }
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                int i6 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.RechargeRD"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", Integer.valueOf(i6));
                if (i6 != 0) {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 3, 0, 0, -1, -1, -1);
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                String str = parseXml.get(".sysmsg.WeChatOut.RechargeWording");
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", str);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_RECHARGE_STRING, str);
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
                String str2 = parseXml.get(".sysmsg.WeChatOut.PackagePurchaseWording");
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", str2);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, str2);
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                String str3 = parseXml.get(".sysmsg.WeChatOut.AccountWording");
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", str3);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, str3);
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                int i7 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", Integer.valueOf(i7));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(i7));
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.TabWording")) {
                String str4 = parseXml.get(".sysmsg.WeChatOut.TabWording");
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", str4);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, str4);
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                String str5 = parseXml.get(".sysmsg.WeChatOut.AccountActivityWording");
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", str5);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, str5);
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                int i8 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", Integer.valueOf(i8));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(i8));
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                int i9 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", Integer.valueOf(i9));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(i9));
            }
            if (parseXml.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                int i10 = Util.getInt(parseXml.get(".sysmsg.WeChatOut.TabRedDotType"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", Integer.valueOf(i10));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 0, 0, 0, -1, -1, Integer.valueOf(i10));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT, Integer.valueOf(i10));
            }
            int indexOf = a2.indexOf("<ActivityInfo>");
            int indexOf2 = a2.indexOf("</ActivityInfo>");
            if (indexOf > 0 && indexOf2 > 0 && indexOf2 > indexOf) {
                String substring = a2.substring(indexOf, indexOf2 + 15);
                Log.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", substring);
                com.tencent.mm.plugin.ipcall.model.h.a aBT = com.tencent.mm.plugin.ipcall.model.h.a.aBT(substring);
                if (aBT != null && Util.isNullOrNil(aBT.Title) && Util.isNullOrNil(aBT.Desc)) {
                    Log.i("MicroMsg.SubCoreIPCall", "clear activity");
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_ACTIVITY_STRING, "");
                } else if (aBT != null) {
                    if (!Util.isNullOrNil(aBT.ImgUrl)) {
                        q.bcQ().a(aBT.ImgUrl, null);
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.TRUE);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_ACTIVITY_STRING, substring);
                }
            }
            EventCenter.instance.publish(new kw());
            EventCenter.instance.publish(new yi());
            AppMethodBeat.o(25388);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a ypw = new cj.a() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            int i2;
            AppMethodBeat.i(25383);
            Log.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            de deVar = aVar.heO;
            String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                AppMethodBeat.o(25383);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                AppMethodBeat.o(25383);
                return;
            }
            com.tencent.mm.plugin.ipcall.model.h.h eaB = i.eaB();
            long j2 = (long) deVar.Brl;
            if (parseXml != null) {
                g gVar = new g();
                gVar.field_svrId = j2;
                gVar.field_title = parseXml.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = parseXml.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i3 = Util.getInt(parseXml.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i3;
                gVar.field_pushTime = Util.getLong(parseXml.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = parseXml.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                Log.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new StringBuilder().append(gVar.field_svrId).toString(), gVar.field_title, gVar.field_content, new StringBuilder().append(gVar.field_msgType).toString(), new StringBuilder().append(gVar.field_pushTime).toString(), gVar.field_descUrl);
                eaB.insert(gVar);
                i2 = i3;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i2));
            }
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 4, 0, 0, -1, Integer.valueOf(i2), -1);
            AppMethodBeat.o(25383);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a ypx = new cj.a() {
        /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass3 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(25384);
            Log.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
            String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
                AppMethodBeat.o(25384);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
                AppMethodBeat.o(25384);
                return;
            }
            if (parseXml.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
                int i2 = Util.getInt(parseXml.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
                Log.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", Integer.valueOf(i2));
                if (i2 > 0) {
                    bg.azz().a(new com.tencent.mm.plugin.ipcall.model.e.g(2), 0);
                }
            }
            AppMethodBeat.o(25384);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    static {
        AppMethodBeat.i(25405);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        ypu = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        ypu.put(Integer.valueOf("IPCallRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return l.SQL_CREATE;
            }
        });
        ypu.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        ypu.put(Integer.valueOf("IPCallMsg".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ipcall.model.i.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.ipcall.model.h.h.SQL_CREATE;
            }
        });
        AppMethodBeat.o(25405);
    }

    public i() {
        AppMethodBeat.i(25389);
        AppMethodBeat.o(25389);
    }

    public static i eaq() {
        AppMethodBeat.i(25390);
        if (ypc == null) {
            ypc = new i();
            bg.aVz().a("plugin.ipcall", ypc);
        }
        i iVar = ypc;
        AppMethodBeat.o(25390);
        return iVar;
    }

    public final void ear() {
        AppMethodBeat.i(231721);
        this.ypg = new com.tencent.mm.plugin.ipcall.model.c.b();
        AppMethodBeat.o(231721);
    }

    public static g eas() {
        AppMethodBeat.i(25391);
        g gVar = eaq().ypd;
        AppMethodBeat.o(25391);
        return gVar;
    }

    public static a eat() {
        AppMethodBeat.i(25392);
        a aVar = eaq().ype;
        AppMethodBeat.o(25392);
        return aVar;
    }

    public static b eau() {
        AppMethodBeat.i(25393);
        b bVar = eaq().ypf;
        AppMethodBeat.o(25393);
        return bVar;
    }

    public static com.tencent.mm.plugin.ipcall.model.c.b eav() {
        AppMethodBeat.i(25394);
        com.tencent.mm.plugin.ipcall.model.c.b bVar = eaq().ypg;
        AppMethodBeat.o(25394);
        return bVar;
    }

    public static f eaw() {
        AppMethodBeat.i(25395);
        f fVar = eaq().yph;
        AppMethodBeat.o(25395);
        return fVar;
    }

    public static c eax() {
        AppMethodBeat.i(25396);
        c cVar = eaq().ypi;
        AppMethodBeat.o(25396);
        return cVar;
    }

    public static d eay() {
        AppMethodBeat.i(25397);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eaq().ypj == null) {
            i eaq = eaq();
            bg.aVF();
            eaq.ypj = new d(com.tencent.mm.model.c.getDataDB());
        }
        d dVar = eaq().ypj;
        AppMethodBeat.o(25397);
        return dVar;
    }

    public static l eaz() {
        AppMethodBeat.i(25398);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eaq().ypk == null) {
            i eaq = eaq();
            bg.aVF();
            eaq.ypk = new l(com.tencent.mm.model.c.getDataDB());
        }
        l lVar = eaq().ypk;
        AppMethodBeat.o(25398);
        return lVar;
    }

    public static j eaA() {
        AppMethodBeat.i(25399);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eaq().ypl == null) {
            i eaq = eaq();
            bg.aVF();
            eaq.ypl = new j(com.tencent.mm.model.c.getDataDB());
        }
        j jVar = eaq().ypl;
        AppMethodBeat.o(25399);
        return jVar;
    }

    public static com.tencent.mm.plugin.ipcall.model.h.h eaB() {
        AppMethodBeat.i(25400);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eaq().ypm == null) {
            i eaq = eaq();
            bg.aVF();
            eaq.ypm = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
        }
        com.tencent.mm.plugin.ipcall.model.h.h hVar = eaq().ypm;
        AppMethodBeat.o(25400);
        return hVar;
    }

    public static e eaC() {
        AppMethodBeat.i(25401);
        if (eaq().hTl == null) {
            eaq().hTl = new e(MMApplicationContext.getContext());
        }
        e eVar = eaq().hTl;
        AppMethodBeat.o(25401);
        return eVar;
    }

    public static com.tencent.mm.plugin.voip.video.c eaD() {
        AppMethodBeat.i(25402);
        if (eaq().ypn == null) {
            eaq().ypn = new com.tencent.mm.plugin.voip.video.c(MMApplicationContext.getContext());
        }
        com.tencent.mm.plugin.voip.video.c cVar = eaq().ypn;
        AppMethodBeat.o(25402);
        return cVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return ypu;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(25403);
        g gVar = this.ypd;
        gVar.yoO.init();
        gVar.yoP.init();
        gVar.yoQ.init();
        gVar.yoR.init();
        gVar.yoS.init();
        gVar.yoT.init();
        gVar.yoU.init();
        gVar.yoV.init();
        gVar.yoO.a(gVar);
        gVar.yoQ.a(gVar);
        gVar.yoR.a(gVar);
        gVar.yoT.a(gVar);
        gVar.yoV.a(gVar);
        gVar.yoP.ypF = gVar;
        gVar.yoS.ypF = gVar;
        bg.a(gVar.yoZ);
        b.init();
        EventCenter.instance.addListener(d.eah().yoB);
        EventCenter.instance.addListener(e.eak().kiA);
        bg.getSysCmdMsgExtension().a("WeChatOut", this.ypv, true);
        bg.getSysCmdMsgExtension().a("WeChatOutMsg", this.ypw, true);
        bg.getSysCmdMsgExtension().a("WCONotify", this.ypx, true);
        EventCenter.instance.addListener(this.ypq);
        EventCenter.instance.addListener(this.ypr);
        EventCenter.instance.addListener(this.yps);
        EventCenter.instance.addListener(this.ypt);
        AppMethodBeat.o(25403);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(25404);
        if (this.yph.eal()) {
            this.ypi.gP(0, 0);
        }
        g gVar = this.ypd;
        gVar.yoO.destroy();
        gVar.yoP.destroy();
        gVar.yoQ.destroy();
        gVar.yoR.destroy();
        gVar.yoS.destroy();
        gVar.yoU.destroy();
        bg.b(gVar.yoZ);
        b.release();
        d eah = d.eah();
        bg.azz().b(JsApiGetBackgroundAudioState.CTRL_INDEX, eah);
        bg.azz().b(160, eah);
        EventCenter.instance.removeListener(eah.yoB);
        EventCenter.instance.removeListener(e.eak().kiA);
        bg.getSysCmdMsgExtension().b("WeChatOut", this.ypv, true);
        bg.getSysCmdMsgExtension().b("WeChatOutMsg", this.ypw, true);
        bg.getSysCmdMsgExtension().b("WCONotify", this.ypx, true);
        EventCenter.instance.removeListener(this.ypq);
        EventCenter.instance.removeListener(this.ypr);
        EventCenter.instance.removeListener(this.yps);
        EventCenter.instance.removeListener(this.ypt);
        AppMethodBeat.o(25404);
    }
}

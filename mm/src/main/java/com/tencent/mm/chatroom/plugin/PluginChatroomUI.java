package com.tencent.mm.chatroom.plugin;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.chatroom.c.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Iterator;

public class PluginChatroomUI extends f implements a, a, c {
    private static HashMap<Integer, h.b> baseDBFactories;
    private com.tencent.mm.chatroom.e.c gsO = new com.tencent.mm.chatroom.e.c();
    private b gsP = new b();
    private IListener<nt> gsQ = new IListener<nt>() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass5 */

        {
            AppMethodBeat.i(182119);
            this.__eventId = nt.class.getName().hashCode();
            AppMethodBeat.o(182119);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nt ntVar) {
            az azVar;
            AppMethodBeat.i(182120);
            nt ntVar2 = ntVar;
            if (ntVar2 != null && ntVar2.dTT.op == 0) {
                Log.i("MicroMsg.roomTodo.PluginChatroomUI", "NotifyGroupTodoEvent %s", ntVar2.dTT.dOe, ntVar2.dTT.dTU, Integer.valueOf(ntVar2.dTT.op));
                if (ab.Ix(ntVar2.dTT.dOe)) {
                    az bjY = ((l) g.af(l.class)).aST().bjY(ntVar2.dTT.dOe);
                    if (bjY == null) {
                        azVar = new az(ntVar2.dTT.dOe);
                        azVar.yA(System.currentTimeMillis());
                        ((l) g.af(l.class)).aST().e(azVar);
                    } else {
                        azVar = bjY;
                    }
                    azVar.nC(1);
                    azVar.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 1, System.currentTimeMillis()));
                    ((l) g.af(l.class)).aST().a(azVar, azVar.field_username, false);
                }
            }
            AppMethodBeat.o(182120);
            return false;
        }
    };
    private IListener gsR = new IListener<jj>() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass6 */

        {
            AppMethodBeat.i(182121);
            this.__eventId = jj.class.getName().hashCode();
            AppMethodBeat.o(182121);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jj jjVar) {
            AppMethodBeat.i(182122);
            jj jjVar2 = jjVar;
            if ((jjVar2 instanceof jj) && !Util.isNullOrNil(jjVar2.dOd.dOe)) {
                com.tencent.mm.roomsdk.a.b.bhF(jjVar2.dOd.dOe).Dt(jjVar2.dOd.dOe).aJu();
                Log.i("MicroMsg.PluginChatroomUI", "getChatRoomInfoDetailListener roomname:%s", jjVar2.dOd.dOe);
            }
            AppMethodBeat.o(182122);
            return false;
        }
    };
    private IListener gsS = new IListener<sx>() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass7 */

        {
            AppMethodBeat.i(182123);
            this.__eventId = sx.class.getName().hashCode();
            AppMethodBeat.o(182123);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sx sxVar) {
            AppMethodBeat.i(182124);
            sx sxVar2 = sxVar;
            if (sxVar2 instanceof sx) {
                Log.i("MicroMsg.roomTodo.PluginChatroomUI", "RevokeNativeMsgEvent recall result:%s", y.yQ(sxVar2.dZt.msgId));
            }
            AppMethodBeat.o(182124);
            return false;
        }
    };
    private IListener gsT = new IListener<sw>() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass8 */

        {
            AppMethodBeat.i(185968);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(185968);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(185969);
            sw swVar2 = swVar;
            if (swVar2 instanceof sw) {
                Log.i("MicroMsg.roomTodo.PluginChatroomUI", "RevokeMsgEvent recall result:%s", y.yQ(swVar2.dZp.msgId));
            }
            AppMethodBeat.o(185969);
            return false;
        }
    };
    private IListener gsU = new IListener<nv>() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass9 */

        {
            AppMethodBeat.i(194045);
            this.__eventId = nv.class.getName().hashCode();
            AppMethodBeat.o(194045);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nv nvVar) {
            AppMethodBeat.i(194046);
            nv nvVar2 = nvVar;
            if ((nvVar2 instanceof nv) && nvVar2.dTW.dTX != null) {
                e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(nvVar2.dTW.dTX.field_talker);
                if (DE == null) {
                    Log.d("MicroMsg.roomtools.PluginChatroomUI", "NotifyGroupToolsResetEvent(%s) groupTools is null", nvVar2.dTW.dTX.field_talker);
                } else if (DE.field_queryState == 0) {
                    Log.d("MicroMsg.roomtools.PluginChatroomUI", "NotifyGroupToolsResetEvent(%s) groupTools is COL_STATE_NEED_QUERY", nvVar2.dTW.dTX.field_talker);
                } else {
                    DE.field_queryState = 0;
                    Log.i("MicroMsg.roomtools.PluginChatroomUI", "NotifyGroupToolsResetEvent(%s) result:%s", nvVar2.dTW.dTX.field_talker, Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(DE, new String[0])));
                }
            }
            AppMethodBeat.o(194046);
            return false;
        }
    };
    private i.a gsV = new i.a() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, i.c cVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(194047);
            if (iVar == null || cVar == null) {
                AppMethodBeat.o(194047);
                return;
            }
            if ("delete".equals(cVar.zqn) && cVar.hIs != null) {
                Iterator<ca> it = cVar.hIs.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (aa.i(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(cVar.talker);
                    if (DE == null || DE.field_queryState == 0) {
                        z2 = false;
                    } else {
                        DE.field_queryState = 0;
                        z2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(DE, new String[0]);
                    }
                    Object[] objArr = new Object[3];
                    objArr[0] = Util.nullAs(cVar.talker, "");
                    objArr[1] = DE == null ? BuildConfig.COMMAND : "not_null";
                    objArr[2] = Boolean.valueOf(z2);
                    Log.i("MicroMsg.roomtools.PluginChatroomUI", "onNotifyChange roomName:%s groupTools:%s result:%s", objArr);
                    AppMethodBeat.o(194047);
                    return;
                }
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "no need reset");
            }
            AppMethodBeat.o(194047);
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.g gsW = new com.tencent.mm.plugin.messenger.foundation.a.g() {
        /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(ca caVar, i.c cVar, boolean[] zArr) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
            AppMethodBeat.i(194044);
            if (z) {
                Log.i("MicroMsg.PluginChatroomUI", "new conversation %s", azVar.field_username);
                v.Ik(azVar.field_username);
            }
            AppMethodBeat.o(194044);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
        }
    };
    private d gsX = null;
    private c.a gsY = null;
    private com.tencent.mm.chatroom.storage.f gsZ = null;
    private com.tencent.mm.chatroom.c.b gta = null;
    private com.tencent.mm.chatroom.storage.b gtb = null;

    public PluginChatroomUI() {
        AppMethodBeat.i(182125);
        AppMethodBeat.o(182125);
    }

    static {
        AppMethodBeat.i(182131);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("GROUPTOODO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("GROUPTOOLS_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.chatroom.storage.f.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("GROUPBNINDAPP_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.chatroom.plugin.PluginChatroomUI.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.chatroom.storage.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(182131);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "ui-chatroom";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(12506);
        Log.i("MicroMsg.PluginChatroomUI", "[execute]");
        pin(b.amg());
        if (gVar.aBb()) {
            g.b(t.class, new com.tencent.mm.chatroom.b.b());
            g.b(u.class, new com.tencent.mm.chatroom.b.c());
        }
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp") || gVar.FZ(":appbrand")) {
            g.b(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.chatroom.b.a());
        }
        AppMethodBeat.o(12506);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(182126);
        Log.d("MicroMsg.PluginChatroomUI", "onAccountInitialized");
        ((l) g.af(l.class)).eiy().a(this.gsV, Looper.getMainLooper());
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("roomtoolstips", this.gsO);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("IMUnionRoom2AssociateRoom", this.gsP);
        this.gsQ.alive();
        this.gsR.alive();
        this.gsS.alive();
        this.gsT.alive();
        this.gsU.alive();
        ((l) g.af(l.class)).aSN().add(getGroupToolsStorage());
        ((l) g.af(l.class)).aST().add(getGroupToolsStorage());
        this.gta = new com.tencent.mm.chatroom.c.b();
        ((l) g.af(l.class)).aST().a(this.gsW);
        AppMethodBeat.o(182126);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(182127);
        Log.d("MicroMsg.PluginChatroomUI", "onAccountRelease");
        ((l) g.af(l.class)).eiy().a(this.gsV);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("roomtoolstips", this.gsO);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("IMUnionRoom2AssociateRoom", this.gsP);
        this.gsQ.dead();
        this.gsR.dead();
        this.gsS.dead();
        this.gsT.dead();
        this.gsU.dead();
        ((l) g.af(l.class)).aSN().remove(getGroupToolsStorage());
        ((l) g.af(l.class)).aST().remove(getGroupToolsStorage());
        ((l) g.af(l.class)).aST().b(this.gsW);
        AppMethodBeat.o(182127);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    public d getGroupTodoStorage() {
        AppMethodBeat.i(182128);
        g.aAf().azk();
        if (this.gsX == null) {
            g.aAi();
            this.gsX = new d(g.aAh().hqK);
        }
        d dVar = this.gsX;
        AppMethodBeat.o(182128);
        return dVar;
    }

    public c.a getRoomTodoMsgService() {
        AppMethodBeat.i(182129);
        g.aAf().azk();
        if (this.gsY == null) {
            this.gsY = new c.a();
        }
        c.a aVar = this.gsY;
        AppMethodBeat.o(182129);
        return aVar;
    }

    public com.tencent.mm.chatroom.storage.f getGroupToolsStorage() {
        AppMethodBeat.i(182130);
        g.aAf().azk();
        if (this.gsZ == null) {
            g.aAi();
            this.gsZ = new com.tencent.mm.chatroom.storage.f(g.aAh().hqK);
        }
        com.tencent.mm.chatroom.storage.f fVar = this.gsZ;
        AppMethodBeat.o(182130);
        return fVar;
    }

    public com.tencent.mm.chatroom.c.b getOpenImMigrateService() {
        AppMethodBeat.i(194048);
        g.aAf().azk();
        com.tencent.mm.chatroom.c.b bVar = this.gta;
        AppMethodBeat.o(194048);
        return bVar;
    }

    public com.tencent.mm.chatroom.storage.b getGroupBindAppStorage() {
        AppMethodBeat.i(194049);
        g.aAf().azk();
        if (this.gtb == null) {
            g.aAi();
            this.gtb = new com.tencent.mm.chatroom.storage.b(g.aAh().hqK);
        }
        com.tencent.mm.chatroom.storage.b bVar = this.gtb;
        AppMethodBeat.o(194049);
        return bVar;
    }

    @Override // com.tencent.mm.chatroom.plugin.a
    public void handleGroupToolByReceiverAppMsg(ca caVar) {
        AppMethodBeat.i(185971);
        if (aa.ame() && ab.Ix(caVar.field_talker)) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) content is null", caVar.field_talker);
                AppMethodBeat.o(185971);
                return;
            }
            com.tencent.mm.chatroom.storage.e Dz = aa.Dz(caVar.field_talker);
            if (Dz == null) {
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is null", caVar.field_talker);
                AppMethodBeat.o(185971);
                return;
            } else if (Dz.field_queryState == 0) {
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg(room:%s) groupTools is COL_STATE_NEED_QUERY", caVar.field_talker);
                AppMethodBeat.o(185971);
                return;
            } else {
                GroupToolItem groupToolItem = null;
                if (com.tencent.mm.modelappbrand.a.b(HD) || com.tencent.mm.modelappbrand.a.c(HD)) {
                    groupToolItem = aa.g(caVar);
                }
                if (aa.h(caVar)) {
                    groupToolItem = new GroupToolItem("roomaa@app.origin", "", caVar.field_createTime);
                }
                if (groupToolItem != null) {
                    Dz.a(groupToolItem);
                    Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleGroupToolByReceiverAppMsg room:%s result:%s", caVar.field_talker, Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(Dz, new String[0])));
                }
            }
        }
        AppMethodBeat.o(185971);
    }

    public void handleChatroomBackup(String str) {
        AppMethodBeat.i(185972);
        if (aa.ame() && ab.Ix(str)) {
            Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup talker:%s", str);
            com.tencent.mm.chatroom.storage.e Dz = aa.Dz(str);
            if (Dz == null) {
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is null");
                AppMethodBeat.o(185972);
                return;
            } else if (Dz.field_queryState == 0) {
                Log.d("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup groupTools is COL_STATE_NEED_QUERY");
                AppMethodBeat.o(185972);
                return;
            } else {
                Dz.field_queryState = 0;
                Log.i("MicroMsg.roomtools.PluginChatroomUI", "handleChatroomBackup result:%s", Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(Dz, new String[0])));
            }
        }
        AppMethodBeat.o(185972);
    }

    @Override // com.tencent.mm.chatroom.plugin.a
    public void handleGroupTodoByReceiverAppMsg(ca caVar) {
        String str;
        AppMethodBeat.i(184788);
        if (ab.Ix(caVar.field_talker)) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.d("MicroMsg.roomTodo.PluginChatroomUI", "content is null");
                AppMethodBeat.o(184788);
                return;
            }
            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
            if (Util.isNullOrNil(aVar.ivd)) {
                str = "related_msgid_" + caVar.field_msgSvrId;
            } else {
                str = aVar.ivd;
            }
            if (((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(caVar.field_talker, str) == null) {
                Log.d("MicroMsg.roomTodo.PluginChatroomUI", "groupTodo is null");
                AppMethodBeat.o(184788);
                return;
            }
            ca Hb = ((l) g.af(l.class)).eiy().Hb(caVar.field_msgId);
            Hb.CK(str);
            ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
            Log.d("MicroMsg.roomTodo.PluginChatroomUI", "update msgSvrid:%s msgId:%s", Long.valueOf(caVar.field_msgSvrId), Long.valueOf(Hb.field_msgId));
        }
        AppMethodBeat.o(184788);
    }
}

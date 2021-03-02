package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.chatroom.c.c;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.ui.RoomCardUI;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.util.e;

public final class y {
    private static Boolean gsx = null;

    public interface a {
        void amc();

        void amd();
    }

    public static boolean ama() {
        AppMethodBeat.i(182099);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            AppMethodBeat.o(182099);
            return true;
        } else if (gsx != null) {
            boolean booleanValue = gsx.booleanValue();
            AppMethodBeat.o(182099);
            return booleanValue;
        } else {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_group_todo_switch, 1);
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "getRoomTodoSwt() swt:%s", Integer.valueOf(a2));
            if (a2 == 1) {
                gsx = Boolean.TRUE;
            } else {
                gsx = Boolean.FALSE;
            }
            boolean booleanValue2 = gsx.booleanValue();
            AppMethodBeat.o(182099);
            return booleanValue2;
        }
    }

    public static Pair<Boolean, String> a(ca caVar, k.b bVar) {
        String str;
        String str2;
        WxaAttributes Xk;
        AppMethodBeat.i(184782);
        if (caVar == null) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
            Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
            AppMethodBeat.o(184782);
            return pair;
        } else if (bVar == null) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
            Pair<Boolean, String> pair2 = new Pair<>(Boolean.FALSE, "");
            AppMethodBeat.o(184782);
            return pair2;
        } else {
            long j2 = caVar.field_createTime;
            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
            if (Util.isNullOrNil(aVar.ivd)) {
                str = "related_msgid_" + caVar.field_msgSvrId;
            } else {
                str = aVar.ivd;
            }
            c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(caVar.field_talker, str);
            if (ai != null) {
                Log.e("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl %s(%s) exist", str, Integer.valueOf(ai.field_state));
                if (ai.field_state == 2) {
                    Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoAppBrandImpl delete %s", Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(ai)));
                } else {
                    Pair<Boolean, String> pair3 = new Pair<>(Boolean.TRUE, ai.field_todoid);
                    AppMethodBeat.o(184782);
                    return pair3;
                }
            }
            c cVar = new c();
            cVar.field_todoid = str;
            cVar.field_roomname = caVar.field_talker;
            cVar.field_username = bVar.izi;
            cVar.field_path = bVar.izh;
            cVar.field_createtime = j2;
            cVar.field_updatetime = j2;
            cVar.field_custominfo = "";
            String str3 = bVar.title;
            if (!Util.isNullOrNil(str3) || (Xk = ((q) g.af(q.class)).Xk(bVar.izi)) == null || Util.isNullOrNil(Xk.field_nickname)) {
                str2 = str3;
            } else {
                str2 = Xk.field_nickname;
            }
            cVar.field_title = str2;
            cVar.field_creator = e.cT(caVar);
            cVar.field_manager = z.aTY();
            cVar.field_nreply = 0;
            cVar.field_related_msgids = new StringBuilder().append(caVar.field_msgSvrId).toString();
            cVar.field_shareKey = bVar.izo;
            cVar.field_shareName = caVar.field_talker;
            boolean f2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().f(cVar);
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "addTodoBySendSuccess todoId:%s result:%s", cVar.field_todoid, Boolean.valueOf(f2));
            if (f2) {
                ca aJ = ((l) g.af(l.class)).eiy().aJ(caVar.field_talker, caVar.field_msgSvrId);
                aJ.CK(cVar.field_todoid);
                ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
                nt ntVar = new nt();
                ntVar.dTT.op = 0;
                ntVar.dTT.dTU = cVar.field_todoid;
                ntVar.dTT.dOe = caVar.field_talker;
                EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
            }
            Pair<Boolean, String> pair4 = new Pair<>(Boolean.valueOf(f2), cVar.field_todoid);
            AppMethodBeat.o(184782);
            return pair4;
        }
    }

    public static Pair<Boolean, String> c(ca caVar) {
        String str;
        WxaAttributes Xk;
        AppMethodBeat.i(182100);
        if (caVar == null) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
            Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
            AppMethodBeat.o(182100);
            return pair;
        } else if (caVar.gDV()) {
            dqb dqb = new dqb();
            dqb.MSY = "related_msgid_" + caVar.field_msgSvrId;
            dqb.Username = "roomannouncement@app.origin";
            dqb.xut = "";
            dqb.rBX = cl.aWB();
            dqb.Title = MMApplicationContext.getContext().getString(R.string.ave);
            dqb.MSX = e.cT(caVar);
            dqb.MTa = caVar.field_msgSvrId;
            dqb.MTb = z.aTY();
            ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
            c.a.a(caVar.field_talker, 0, dqb);
            Pair<Boolean, String> pair2 = new Pair<>(Boolean.TRUE, dqb.MSY);
            AppMethodBeat.o(182100);
            return pair2;
        } else {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
                Pair<Boolean, String> pair3 = new Pair<>(Boolean.FALSE, "");
                AppMethodBeat.o(182100);
                return pair3;
            }
            dqb dqb2 = new dqb();
            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
            if (aVar == null || Util.isNullOrNil(aVar.ivd)) {
                dqb2.MSY = "related_msgid_" + caVar.field_msgSvrId;
            } else {
                dqb2.MSY = aVar.ivd;
            }
            dqb2.Username = HD.izi;
            dqb2.xut = HD.izh;
            dqb2.rBX = cl.aWB();
            String str2 = HD.title;
            if (!Util.isNullOrNil(str2) || (Xk = ((q) g.af(q.class)).Xk(HD.izi)) == null || Util.isNullOrNil(Xk.field_nickname)) {
                str = str2;
            } else {
                str = Xk.field_nickname;
            }
            dqb2.Title = str;
            dqb2.MSX = e.cT(caVar);
            dqb2.MTa = caVar.field_msgSvrId;
            dqb2.MTb = z.aTY();
            dqb2.MTc = HD.izo;
            dqb2.MTd = caVar.field_talker;
            ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
            c.a.a(caVar.field_talker, 0, dqb2);
            Pair<Boolean, String> pair4 = new Pair<>(Boolean.TRUE, dqb2.MSY);
            AppMethodBeat.o(182100);
            return pair4;
        }
    }

    public static String d(ca caVar) {
        AppMethodBeat.i(194033);
        if (caVar == null) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "msginfo is null");
            AppMethodBeat.o(194033);
            return "";
        } else if (caVar.gDV()) {
            String str = "related_msgid_" + caVar.field_msgSvrId;
            AppMethodBeat.o(194033);
            return str;
        } else {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.e("MicroMsg.roomTodo.RoomTodoHelp", "content is null");
                AppMethodBeat.o(194033);
                return "";
            }
            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
            if (aVar == null || Util.isNullOrNil(aVar.ivd)) {
                String str2 = "related_msgid_" + caVar.field_msgSvrId;
                AppMethodBeat.o(194033);
                return str2;
            }
            String str3 = aVar.ivd;
            AppMethodBeat.o(194033);
            return str3;
        }
    }

    public static Pair<Boolean, String> e(ca caVar) {
        dqb dqb;
        AppMethodBeat.i(182101);
        com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(caVar.field_talker, caVar.fRe);
        if (ai != null) {
            for (Long l : ai.gts) {
                ca aJ = ((l) g.af(l.class)).eiy().aJ(caVar.field_talker, l.longValue());
                aJ.CK("");
                ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
            }
            nt ntVar = new nt();
            ntVar.dTT.op = 1;
            ntVar.dTT.dTU = caVar.fRe;
            ntVar.dTT.dOe = caVar.field_talker;
            EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s result:%s", caVar.fRe, Boolean.valueOf(c(ai)));
            dqb = d(ai);
        } else {
            ca aJ2 = ((l) g.af(l.class)).eiy().aJ(caVar.field_talker, caVar.field_msgSvrId);
            aJ2.CK("");
            ((l) g.af(l.class)).eiy().a(aJ2.field_msgId, aJ2);
            dqb dqb2 = new dqb();
            dqb2.MSY = caVar.fRe;
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                dqb2.Username = "";
                dqb2.xut = "";
                dqb2.Title = "";
            } else {
                dqb2.Username = HD.izi;
                dqb2.xut = HD.izh;
                dqb2.Title = HD.title;
            }
            dqb2.rBX = (int) (caVar.field_createTime / 10000);
            dqb2.MSX = e.cT(caVar);
            dqb2.MTa = caVar.field_msgSvrId;
            dqb2.MTb = "";
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByClickMsg todoId:%s", caVar.fRe);
            dqb = dqb2;
        }
        ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
        c.a.a(caVar.field_talker, 1, dqb);
        Pair<Boolean, String> pair = new Pair<>(Boolean.TRUE, caVar.fRe);
        AppMethodBeat.o(182101);
        return pair;
    }

    public static Pair<Boolean, String> a(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(182102);
        com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(cVar.field_roomname, cVar.field_todoid);
        if (ai == null) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu stoTodo no exist");
            Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, cVar.field_todoid);
            AppMethodBeat.o(182102);
            return pair;
        }
        for (Long l : ai.gts) {
            ca aJ = ((l) g.af(l.class)).eiy().aJ(cVar.field_roomname, l.longValue());
            aJ.CK("");
            ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
        }
        ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
        c.a.a(cVar.field_roomname, 1, d(ai));
        boolean c2 = c(ai);
        Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByTodoBarMenu todoId:%s result:%s", cVar.field_todoid, Boolean.valueOf(c2));
        Pair<Boolean, String> pair2 = new Pair<>(Boolean.valueOf(c2), cVar.field_todoid);
        AppMethodBeat.o(182102);
        return pair2;
    }

    public static Pair<Boolean, String> yQ(long j2) {
        boolean g2;
        AppMethodBeat.i(182103);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Util.isNullOrNil(Hb.fRe)) {
            Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
            AppMethodBeat.o(182103);
            return pair;
        }
        com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(Hb.field_talker, Hb.fRe);
        if (ai == null) {
            Pair<Boolean, String> pair2 = new Pair<>(Boolean.FALSE, Hb.fRe);
            AppMethodBeat.o(182103);
            return pair2;
        }
        if (ai.yS(Hb.field_msgSvrId)) {
            g2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(ai);
            nt ntVar = new nt();
            ntVar.dTT.op = 1;
            ntVar.dTT.dOe = ai.field_roomname;
            ntVar.dTT.dTU = ai.field_todoid;
            if (g2) {
                EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
            }
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg delete result:%s", Boolean.valueOf(g2));
        } else {
            g2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(ai);
            Log.i("MicroMsg.roomTodo.RoomTodoHelp", "recallTodoByRevokeMsg updateGroupTodo result:%s", Boolean.valueOf(g2));
        }
        if (g2) {
            Hb.CK("");
            ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
        }
        Pair<Boolean, String> pair3 = new Pair<>(Boolean.TRUE, Hb.fRe);
        AppMethodBeat.o(182103);
        return pair3;
    }

    public static boolean b(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(182104);
        cVar.field_state = 1;
        cVar.field_updatetime = cl.aWz();
        boolean g2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(cVar);
        AppMethodBeat.o(182104);
        return g2;
    }

    public static boolean c(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(194034);
        cVar.field_state = 2;
        cVar.field_updatetime = cl.aWz();
        boolean g2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(cVar);
        AppMethodBeat.o(194034);
        return g2;
    }

    public static String a(dqb dqb) {
        AppMethodBeat.i(182105);
        if (dqb == null) {
            AppMethodBeat.o(182105);
            return "";
        }
        String str = "RoomToolsTodo{TodoId='" + dqb.MSY + '\'' + ", Username='" + dqb.Username + '\'' + ", Path='" + dqb.xut + '\'' + ", Time=" + dqb.rBX + ", CustomInfo=" + dqb.MSZ + ", Title='" + Util.secPrint(dqb.Title) + '\'' + ", Creator='" + dqb.MSX + '\'' + ", RelatedMsgId=" + dqb.MTa + ", Manager='" + dqb.MTb + '\'' + '}';
        AppMethodBeat.o(182105);
        return str;
    }

    public static dqb d(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(182106);
        dqb dqb = new dqb();
        dqb.MSY = cVar.field_todoid;
        dqb.Username = cVar.field_username;
        dqb.xut = cVar.field_path;
        dqb.rBX = (int) (cVar.field_createtime / 1000);
        dqb.Title = cVar.field_title;
        dqb.MSX = cVar.field_creator;
        dqb.MTa = cVar.amk();
        dqb.MTb = cVar.field_manager;
        dqb.MSZ = com.tencent.mm.bw.b.bfZ(cVar.field_custominfo);
        dqb.MTc = cVar.field_shareKey;
        dqb.MTd = cVar.field_shareName;
        AppMethodBeat.o(182106);
        return dqb;
    }

    public static void f(Context context, String str, boolean z) {
        AppMethodBeat.i(182107);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.roomTodo.RoomTodoHelp", "gotoRoomCard roomname is null");
            AppMethodBeat.o(182107);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, RoomCardUI.class);
        intent.putExtra("RoomInfo_Id", str);
        intent.putExtra("room_notice", v.Ig(str));
        intent.putExtra("room_notice_publish_time", v.Ij(str));
        intent.putExtra("room_notice_editor", v.Ii(str));
        ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
        if (Kd != null) {
            intent.putExtra("Is_RoomOwner", Kd.field_roomowner.equals(z.aTY()));
            intent.putExtra("Is_RoomManager", Kd.bjf(z.aTY()));
        }
        if (z) {
            intent.setFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/chatroom/model/RoomTodoHelp", "gotoRoomCard", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(182107);
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final boolean z, final int i2, final int i3, final int i4, final a aVar) {
        AppMethodBeat.i(194035);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 1, true);
        if (z) {
            eVar.j(context.getString(R.string.avd), 17, com.tencent.mm.cb.a.fromDPToPix(context, 14));
        } else {
            eVar.j(context.getString(R.string.avc), 17, com.tencent.mm.cb.a.fromDPToPix(context, 14));
        }
        eVar.QOp = true;
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.chatroom.d.y.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(182097);
                if (z) {
                    mVar.d(0, context.getString(R.string.avb));
                    AppMethodBeat.o(182097);
                    return;
                }
                mVar.a(0, context.getResources().getColor(R.color.Red), context.getString(R.string.ava));
                AppMethodBeat.o(182097);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.chatroom.d.y.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                int i3 = 1;
                AppMethodBeat.i(182098);
                if (menuItem.getItemId() == 0 && aVar != null) {
                    if (z) {
                        aVar.amc();
                    } else {
                        aVar.amd();
                    }
                    if (i2 == 2) {
                        String str = str;
                        int i4 = i3;
                        if (!z) {
                            i3 = 2;
                        }
                        z.a(str, 2, i4, i3, i4, str2, str3);
                        AppMethodBeat.o(182098);
                        return;
                    } else if (i2 == 1) {
                        z.a(str, i3, 3, 2, str2, str3);
                    }
                }
                AppMethodBeat.o(182098);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.chatroom.d.y.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                int i2 = 2;
                AppMethodBeat.i(184781);
                if (i2 == 2) {
                    String str = str;
                    int i3 = i3;
                    if (z) {
                        i2 = 1;
                    }
                    z.a(str, 1, i3, i2, i4, str2, str3);
                }
                if (i2 == 1) {
                    z.a(str, i3, 3, 1, str2, str3);
                }
                AppMethodBeat.o(184781);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(194035);
    }

    public static boolean e(com.tencent.mm.chatroom.storage.c cVar) {
        if (cVar == null || cVar.field_state == 2) {
            return false;
        }
        return true;
    }

    public static String f(ca caVar) {
        AppMethodBeat.i(194036);
        if (caVar == null) {
            AppMethodBeat.o(194036);
            return "";
        } else if (caVar.gDV()) {
            AppMethodBeat.o(194036);
            return "roomannouncement@app.origin";
        } else {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo content is null");
                AppMethodBeat.o(194036);
                return "";
            } else if (((com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class)) == null) {
                Log.e("MicroMsg.roomTodo.RoomTodoHelp", "getAppUsernameFromMsginfo appContentAppBrandPiece is null");
                AppMethodBeat.o(194036);
                return "";
            } else {
                String str = HD.izi;
                AppMethodBeat.o(194036);
                return str;
            }
        }
    }
}

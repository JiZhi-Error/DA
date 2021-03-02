package com.tencent.mm.chatroom.e;

import android.os.Looper;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements p {
    public static final Pattern gsK = Pattern.compile("\\$\\{(.+)\\}");

    static {
        AppMethodBeat.i(182116);
        AppMethodBeat.o(182116);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        com.tencent.mm.chatroom.storage.c cVar;
        boolean z4;
        AppMethodBeat.i(182113);
        Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml subType:%s", Util.nullAs(str, ""));
        if (Util.nullAsNil(str).equals("roomtoolstips")) {
            if (!y.ama()) {
                AppMethodBeat.o(182113);
                return null;
            } else if (map != null) {
                try {
                    if (map.containsKey(".sysmsg.todo.todoid")) {
                        de deVar = aVar.heO;
                        String trim = Util.nullAsNil(map.get(".sysmsg.todo.template")).trim();
                        String trim2 = Util.nullAsNil(map.get(".sysmsg.todo.todoid")).trim();
                        int i2 = Util.getInt(map.get(".sysmsg.todo.op"), 0);
                        String a2 = z.a(deVar.KHl);
                        String nullAsNil = Util.nullAsNil(map.get(".sysmsg.todo.scene"));
                        String nullAsNil2 = Util.nullAsNil(map.get(".sysmsg.todo.creator"));
                        String nullAsNil3 = Util.nullAsNil(map.get(".sysmsg.todo.oper"));
                        String nullAsNil4 = Util.nullAsNil(map.get(".sysmsg.todo.username"));
                        long j2 = 1000 * Util.getLong(map.get(".sysmsg.todo.time"), 0);
                        long j3 = Util.getLong(map.get(".sysmsg.todo.related_msgid"), 0);
                        String nullAsNil5 = Util.nullAsNil(map.get(".sysmsg.todo.sharekey"));
                        String nullAsNil6 = Util.nullAsNil(map.get(".sysmsg.todo.sharename"));
                        com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(a2, trim2);
                        boolean z5 = ai != null;
                        boolean e2 = y.e(ai);
                        Object[] objArr = new Object[13];
                        objArr[0] = nullAsNil;
                        objArr[1] = a2;
                        objArr[2] = trim2;
                        objArr[3] = nullAsNil4;
                        objArr[4] = nullAsNil2;
                        objArr[5] = nullAsNil3;
                        objArr[6] = Integer.valueOf(i2);
                        objArr[7] = Long.valueOf(j3);
                        objArr[8] = Util.secPrint(trim);
                        objArr[9] = Boolean.valueOf(z5);
                        objArr[10] = Integer.valueOf(ai != null ? ai.field_state : 0);
                        objArr[11] = nullAsNil5;
                        objArr[12] = nullAsNil6;
                        Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "scene:%s fromUser:%s todoId:%s appUsername:%s creator:%s operator:%s op:%s related_msgid:%s template:%s exist:%s state:%s shareKey:%s shareName:%s", objArr);
                        if (ai != null && ai.aml()) {
                            g.aAi();
                            as Kn = ((l) g.af(l.class)).aSN().Kn(a2);
                            if (Kn != null && Kn.fve == 0) {
                                ca aJ = ((l) g.af(l.class)).eiy().aJ(a2, Long.parseLong(ai.field_related_msgids));
                                if (!Util.isNullOrNil(ai.field_related_msgids) && ai.field_related_msgids.contains(new StringBuilder().append(aJ.field_msgSvrId).toString())) {
                                    Log.w("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no handle clear roomCard");
                                    AppMethodBeat.o(182113);
                                    return null;
                                }
                            }
                        }
                        if (!Util.isEqual(nullAsNil, "altertodo_set") || ai == null || !ai.aml() || j2 <= ai.field_createtime) {
                            z = e2;
                            z2 = z5;
                        } else {
                            boolean h2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().h(ai);
                            ca aJ2 = ((l) g.af(l.class)).eiy().aJ(a2, ai.amk());
                            aJ2.CK("");
                            ((l) g.af(l.class)).eiy().a(aJ2.field_msgId, aJ2);
                            Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "ORIGIN_USERNAME_CHAT_INFO delete result:%s", Boolean.valueOf(h2));
                            nt ntVar = new nt();
                            ntVar.dTT.dTU = ai.field_todoid;
                            ntVar.dTT.dOe = a2;
                            ntVar.dTT.op = 1;
                            EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
                            ai = null;
                            z = false;
                            z2 = false;
                        }
                        if (Util.isEqual(nullAsNil, "sendtodo") || Util.isEqual(nullAsNil, "altertodo_set") || Util.isEqual(nullAsNil, "altertodo_revert") || (Util.isEqual(nullAsNil, "replytodo") && z)) {
                            if (ai == null) {
                                com.tencent.mm.chatroom.storage.c cVar2 = new com.tencent.mm.chatroom.storage.c();
                                cVar2.field_todoid = trim2;
                                cVar2.field_roomname = a2;
                                cVar2.field_createtime = j2;
                                cVar2.field_updatetime = Util.getLong(map.get(".sysmsg.todo.time"), 0) * 1000;
                                cVar2.field_username = Util.nullAsNil(map.get(".sysmsg.todo.username"));
                                cVar2.field_path = Util.nullAsNil(map.get(".sysmsg.todo.path"));
                                cVar2.field_custominfo = Util.nullAsNil(map.get(".sysmsg.todo.custominfo"));
                                cVar2.field_title = Util.nullAsNil(map.get(".sysmsg.todo.title"));
                                cVar2.field_creator = nullAsNil2;
                                cVar2.field_shareKey = nullAsNil5;
                                cVar2.field_shareName = nullAsNil6;
                                cVar = cVar2;
                            } else {
                                ai.field_updatetime = Util.getLong(map.get(".sysmsg.todo.time"), 0) * 1000;
                                cVar = ai;
                            }
                            cVar.field_manager = Util.nullAsNil(map.get(".sysmsg.todo.manager"));
                            cVar.field_nreply = Util.getInt(map.get(".sysmsg.todo.nreply"), 0);
                            nt ntVar2 = new nt();
                            if (Util.isEqual(nullAsNil, "replytodo") || (i2 == 0 && z)) {
                                ntVar2.dTT.op = 2;
                            } else {
                                ntVar2.dTT.op = i2;
                            }
                            ntVar2.dTT.dOe = a2;
                            ntVar2.dTT.dTU = trim2;
                            if (i2 == 0) {
                                if (cVar.field_state == 2) {
                                    cVar.field_state = 0;
                                }
                                if (z2) {
                                    cVar.yR(j3);
                                    boolean g2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().g(cVar);
                                    for (Long l : cVar.gts) {
                                        ca aJ3 = ((l) g.af(l.class)).eiy().aJ(a2, l.longValue());
                                        if (!Util.isEqual(aJ3.fRe, cVar.field_todoid)) {
                                            aJ3.CK(trim2);
                                            ((l) g.af(l.class)).eiy().a(aJ3.field_msgId, aJ3);
                                            Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", l, Long.valueOf(aJ3.field_msgId));
                                        }
                                    }
                                    z4 = g2;
                                } else {
                                    cVar.field_related_msgids = String.valueOf(j3);
                                    boolean f2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().f(cVar);
                                    ca aJ4 = ((l) g.af(l.class)).eiy().aJ(a2, j3);
                                    aJ4.CK(trim2);
                                    ((l) g.af(l.class)).eiy().a(aJ4.field_msgId, aJ4);
                                    Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", Long.valueOf(j3), Long.valueOf(aJ4.field_msgId));
                                    z4 = f2;
                                }
                                if (z4) {
                                    EventCenter.instance.asyncPublish(ntVar2, Looper.getMainLooper());
                                }
                                Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insertOrUpdateTodo result:%s", Boolean.valueOf(z4));
                            } else if (z2) {
                                boolean c2 = y.c(cVar);
                                Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "delete result:%s", Boolean.valueOf(c2));
                                if (c2) {
                                    EventCenter.instance.asyncPublish(ntVar2, Looper.getMainLooper());
                                }
                                for (Long l2 : cVar.gts) {
                                    ca aJ5 = ((l) g.af(l.class)).eiy().aJ(a2, l2.longValue());
                                    aJ5.CK("");
                                    ((l) g.af(l.class)).eiy().a(aJ5.field_msgId, aJ5);
                                    Log.d("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "update msgSvrid:%s msgId:%s", l2, Long.valueOf(aJ5.field_msgId));
                                }
                            }
                        }
                        if (!Util.isNullOrNil(trim)) {
                            boolean z6 = false;
                            if (Util.isEqual(nullAsNil, "altertodo_set") && Util.isEqual(nullAsNil2, com.tencent.mm.model.z.aTY()) && Util.isEqual(nullAsNil3, com.tencent.mm.model.z.aTY())) {
                                z6 = true;
                            }
                            if (Util.isEqual(nullAsNil, "replytodo") || Util.isEqual(nullAsNil, "altertodo_revert")) {
                                boolean isEqual = Util.isEqual(nullAsNil2, com.tencent.mm.model.z.aTY());
                                boolean JN = ab.JN(a2);
                                if (!Util.isEqual(nullAsNil3, com.tencent.mm.model.z.aTY()) && !isEqual && !JN && !z) {
                                    z6 = true;
                                }
                            }
                            ca aJ6 = ((l) g.af(l.class)).eiy().aJ(a2, j3);
                            if ((aJ6.fqJ & 4) == 4 || aJ6.getType() == 10000) {
                                z3 = true;
                            } else {
                                z3 = z6;
                            }
                            if (!z3) {
                                if (Util.isEqual(nullAsNil, "altertodo_revert") && Util.isEqual(nullAsNil3, com.tencent.mm.model.z.aTY())) {
                                    str2 = MMApplicationContext.getContext().getString(R.string.avg);
                                } else if (!Util.isEqual(nullAsNil, "replytodo") || !Util.isEqual(nullAsNil3, com.tencent.mm.model.z.aTY())) {
                                    Matcher matcher = gsK.matcher(trim);
                                    if (matcher.find()) {
                                        String group = matcher.group(0);
                                        if (!Util.isNullOrNil(group) && group.length() > 3) {
                                            str2 = trim.replace(group, ag(a2, group.substring(2, group.length() - 1)));
                                        }
                                    }
                                    str2 = trim;
                                } else if (Util.isEqual(nullAsNil2, com.tencent.mm.model.z.aTY())) {
                                    str2 = MMApplicationContext.getContext().getString(R.string.avi);
                                } else {
                                    str2 = MMApplicationContext.getContext().getString(R.string.avh, ag(a2, nullAsNil2));
                                }
                                ca caVar = new ca();
                                caVar.nv(0);
                                caVar.Cy(a2);
                                caVar.setStatus(3);
                                caVar.setContent(str2);
                                caVar.setCreateTime(bp.C(a2, System.currentTimeMillis() / 1000));
                                caVar.setType(10000);
                                caVar.setFlag(caVar.field_flag | 8);
                                Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "insert template msgId:%s", Long.valueOf(bp.x(caVar)));
                            }
                        }
                    } else {
                        Log.i("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "no contains todoid");
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.roomTodo.RoomToolsTipsNewXmlConsumer", "consumeNewXml Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        AppMethodBeat.o(182113);
        return null;
    }

    private static CharSequence ag(String str, String str2) {
        String ah;
        AppMethodBeat.i(182114);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
        if (!Util.isNullOrNil(Kn.field_conRemark)) {
            ah = Kn.field_conRemark;
        } else {
            ah = ah(str, Kn.field_username);
        }
        if (Util.isNullOrNil(ah)) {
            ah = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(ah)) {
            ah = Kn.arI();
        }
        if (Util.isNullOrNil(ah)) {
            ah = Kn.field_username;
        }
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), ah);
        AppMethodBeat.o(182114);
        return c2;
    }

    private static String ah(String str, String str2) {
        AppMethodBeat.i(182115);
        ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(182115);
            return null;
        }
        String displayName = Kd.getDisplayName(str2);
        AppMethodBeat.o(182115);
        return displayName;
    }
}

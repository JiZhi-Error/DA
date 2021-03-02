package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.e;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements h, e.a {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        String trim;
        Map<String, String> parseXml;
        LinkedList linkedList;
        int i2 = 0;
        AppMethodBeat.i(30181);
        de deVar = aVar.heO;
        if (deVar != null && deVar.xKb == 51) {
            Log.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", Integer.valueOf(deVar.xKb), 51);
            String a2 = z.a(deVar.KHm);
            if (!Util.isNullOrNil(a2) && (parseXml = XmlParser.parseXml((trim = z.a(deVar.KHn).trim()), "msg", null)) != null) {
                int i3 = Util.getInt(parseXml.get(".msg.op.$id"), 0);
                Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", Integer.valueOf(i3));
                if (i3 == 1 || i3 == 2 || i3 == 5) {
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(a2)));
                    bg.aVF();
                    c.aSQ().aEu(a2);
                    a.jRt.cancelNotification(a2);
                    if (ab.IX(a2)) {
                        bg.aVF();
                        c.azQ().set(143618, (Object) 0);
                        d.bgN().gCQ();
                    } else {
                        Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                        bg.aVF();
                        c.aST().bka(a2);
                        if (ab.Eq(a2)) {
                            bg.aVF();
                            az bjY = c.aST().bjY(a2);
                            if (bjY != null && bjY.field_unReadCount > 0 && bjY.field_UnDeliverCount > 0) {
                                Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", a2, Integer.valueOf(bjY.field_UnDeliverCount), Integer.valueOf(bjY.field_unReadCount));
                                a.jRu.gr(a2);
                                bjY.nt(0);
                                bg.aVF();
                                c.aST().a(bjY, a2);
                            }
                        }
                    }
                } else if (i3 == 13) {
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(a2)));
                    bg.aVF();
                    c.aST().bkc(a2);
                } else if (i3 == 3) {
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", Integer.valueOf(i3));
                    long currentTimeMillis = System.currentTimeMillis();
                    bg.aVF();
                    List<String> gCw = c.aST().gCw();
                    StringBuilder sb = new StringBuilder();
                    int i4 = 0;
                    while (i4 < gCw.size()) {
                        sb.append(i4 > 0 ? "," : "");
                        sb.append(gCw.get(i4));
                        i4++;
                    }
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", Integer.valueOf(gCw.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    HashMap<String, az> JQ = ac.JQ(ab.iCF);
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", JQ.keySet(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    int size = JQ.size();
                    if (size > 0) {
                        LinkedList linkedList2 = new LinkedList();
                        for (String str : JQ.keySet()) {
                            az azVar = JQ.get(str);
                            if (azVar != null) {
                                ecu ecu = new ecu();
                                ecu.UserName = str;
                                ecu.Ndg = (int) azVar.field_conversationTime;
                                linkedList2.add(ecu);
                            }
                        }
                        linkedList = linkedList2;
                    } else {
                        linkedList = null;
                    }
                    bg.azz().a(new com.tencent.mm.modelsimple.ab(sb.toString(), 4, size, linkedList), 0);
                } else if (i3 == 6) {
                    Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i3), trim);
                } else if (i3 == 7) {
                    Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i3), trim);
                    bg.aVF();
                    Log.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", Integer.valueOf(c.aSK()), Integer.valueOf(o.bff()));
                    String trim2 = Util.nullAsNil(parseXml.get(".msg.op.name")).trim();
                    String trim3 = Util.nullAsNil(parseXml.get(".msg.op.arg")).trim();
                    if ("WeixinStatus".equals(trim2)) {
                        bg.aVF();
                        if (c.aSK() == o.bff() && o.jjJ != null && o.jjJ.trim().length() > 0) {
                            Intent intent = new Intent(MMApplicationContext.getContext(), WebWXLogoutUI.class);
                            intent.setFlags(603979776);
                            intent.addFlags(268435456);
                            intent.putExtra("intent.key.online_version", o.bff());
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    } else if ("MomentsUnreadMsgStatus".equals(trim2)) {
                        wy wyVar = new wy();
                        wyVar.edp.dJY = 7;
                        wyVar.edp.edq = trim2;
                        wyVar.edp.edr = (long) Util.getInt(trim3, 0);
                        Log.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", Integer.valueOf(wyVar.edp.dJY), wyVar.edp.edq, Long.valueOf(wyVar.edp.edr));
                        EventCenter.instance.publish(wyVar);
                    } else if ("EnterpriseChatStatus".equals(trim2)) {
                        ag.bav();
                        i.h(i3, trim2, trim3);
                    }
                } else if (i3 == 8) {
                    Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i3), trim);
                    String trim4 = Util.nullAsNil(parseXml.get(".msg.op.name")).trim();
                    String trim5 = Util.nullAsNil(parseXml.get(".msg.op.arg")).trim();
                    if ("EnterpriseChatStatus".equals(trim4)) {
                        ag.bav();
                        i.h(i3, trim4, trim5);
                    } else {
                        wy wyVar2 = new wy();
                        wyVar2.edp.dJY = 8;
                        EventCenter.instance.publish(wyVar2);
                    }
                } else if (i3 == 9) {
                    Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i3), trim);
                    String trim6 = Util.nullAsNil(parseXml.get(".msg.op.name")).trim();
                    String trim7 = Util.nullAsNil(parseXml.get(".msg.op.arg")).trim();
                    if ("MomentsTimelineStatus".equals(trim6)) {
                        String[] split = trim7.split(",");
                        if (split.length == 2) {
                            wy wyVar3 = new wy();
                            wyVar3.edp.dJY = 9;
                            wyVar3.edp.edq = trim6;
                            wyVar3.edp.edr = (long) Util.getInt(split[1], 0);
                            wyVar3.edp.eds = split[0];
                            EventCenter.instance.publish(wyVar3);
                        }
                    } else if ("EnterpriseChatStatus".equals(trim6)) {
                        ag.bav();
                        i.h(i3, trim6, trim7);
                    }
                } else if (i3 == 11) {
                    String trim8 = Util.nullAsNil(parseXml.get(".msg.op.name")).trim();
                    String trim9 = Util.nullAsNil(parseXml.get(".msg.op.arg")).trim();
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, op:SENDCOMMAND, funcName:".concat(String.valueOf(trim8)));
                    if ("DownloadFile".equals(trim8)) {
                        Map<String, String> parseXml2 = XmlParser.parseXml(trim9, "downloadList", null);
                        if (parseXml2 != null) {
                            while (true) {
                                try {
                                    String str2 = ".downloadList.downloadItem" + (i2 == 0 ? "" : Integer.valueOf(i2));
                                    i2++;
                                    String str3 = str2 + ".msgsvrid";
                                    String str4 = parseXml2.get(str2 + ".username");
                                    if (Util.isNullOrNil(str4)) {
                                        break;
                                    }
                                    long j2 = Util.getLong(parseXml2.get(str3), -1);
                                    if (j2 == -1) {
                                        break;
                                    }
                                    bg.aVF();
                                    ca aJ = c.aSQ().aJ(str4, j2);
                                    if (aJ.field_msgSvrId == 0) {
                                        Log.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(j2));
                                    } else {
                                        g.gjb().gjd().Mh(aJ.field_msgId);
                                    }
                                } catch (Throwable th) {
                                    Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] DownloadFile fail: " + th.getLocalizedMessage());
                                }
                            }
                        }
                    } else if ("HandOff".equals(trim8)) {
                        switch (Util.getInt(parseXml.get(".msg.op.arg.handofflist.$opcode"), 0)) {
                            case 5:
                                try {
                                    String trim10 = parseXml.get(".msg.op.arg.handofflist.handoff.$from").trim();
                                    long j3 = Util.getLong(parseXml.get(".msg.op.arg.handofflist.handoff.id").trim(), 0);
                                    String trim11 = parseXml.get(".msg.op.arg.handofflist.handoff.$id").trim();
                                    bg.aVF();
                                    com.tencent.mm.pluginsdk.model.app.c Mp = ao.cgO().Mp(c.aSQ().aJ(trim10, j3).field_msgId);
                                    if (Mp == null) {
                                        HandOff aBy = ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBy(trim11);
                                        if (aBy instanceof HandOffFile) {
                                            Mp = ak.a((HandOffFile) aBy);
                                        }
                                    }
                                    if (Mp == null) {
                                        ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(trim11, trim9);
                                        break;
                                    } else if (((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(trim11, Mp)) {
                                        bg.azz().a(new ak(trim11, Mp), 0);
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + th2.getLocalizedMessage());
                                    break;
                                }
                                break;
                            case 6:
                                Log.i("MicroMsg.StatusNotifyMsgExtension", "receive handoff GET_ALL_LIST request, call alllist");
                                ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYk();
                                break;
                            case 7:
                            case 8:
                            default:
                                Matcher matcher = Pattern.compile("<arg>([\\s\\S]+)</arg>").matcher(trim);
                                if (matcher.find() && matcher.groupCount() > 0) {
                                    ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).processRequest(matcher.group(1));
                                    break;
                                }
                            case 9:
                                try {
                                    ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBA(parseXml.get(".msg.op.arg.handofflist.handoff.md5").trim());
                                    break;
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + e2.getLocalizedMessage());
                                    break;
                                }
                        }
                    } else {
                        Log.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + trim8 + " , ignore");
                    }
                } else if (i3 == 12) {
                    Log.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(trim)), Integer.valueOf(i3));
                    try {
                        if (parseXml.get(".msg.op.arg") != null) {
                            String obj = new JSONObject(parseXml.get(".msg.op.arg")).get("deviceName").toString();
                            if (o.bfe()) {
                                Intent intent2 = new Intent(MMApplicationContext.getContext(), WebWXPopupUnlockUI.class);
                                intent2.setFlags(872415232);
                                intent2.putExtra("deviceName", obj);
                                Context context2 = MMApplicationContext.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                        } else {
                            Log.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                        }
                    } catch (JSONException e3) {
                        Log.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e3.getMessage());
                    }
                } else {
                    Log.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", Integer.valueOf(i3));
                }
            }
        }
        AppMethodBeat.o(30181);
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
        AppMethodBeat.i(30182);
        Log.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(30182);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
    }
}

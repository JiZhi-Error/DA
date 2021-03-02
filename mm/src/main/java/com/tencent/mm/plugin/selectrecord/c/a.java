package com.tencent.mm.plugin.selectrecord.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
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

public final class a implements p {
    public static final Pattern gsK = Pattern.compile("\\$\\{(.+)\\}");

    static {
        AppMethodBeat.i(187922);
        AppMethodBeat.o(187922);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        boolean z;
        String str2;
        String displayName;
        AppMethodBeat.i(187921);
        Log.d("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml subType:%s", Util.nullAs(str, ""));
        if (Util.nullAsNil(str).equals("revokehistoryinjoinroommsg") && map != null) {
            try {
                if (map.containsKey(".sysmsg.revokehistoryinjoinroommsg.historyid")) {
                    String trim = Util.nullAsNil(map.get(".sysmsg.revokehistoryinjoinroommsg.historyid")).trim();
                    String trim2 = Util.nullAsNil(map.get(".sysmsg.revokehistoryinjoinroommsg.roomname")).trim();
                    String trim3 = Util.nullAsNil(map.get(".sysmsg.revokehistoryinjoinroommsg.template")).trim();
                    String trim4 = Util.nullAsNil(map.get(".sysmsg.revokehistoryinjoinroommsg.inviterusername")).trim();
                    int i2 = Util.getInt(map.get(".sysmsg.revokehistoryinjoinroommsg.oper"), 0);
                    if (i2 == 1 || (i2 == 2 && !Util.isEqual(trim4, z.aTY()))) {
                        ca aNb = ((PluginSelectRecord) g.ah(PluginSelectRecord.class)).getSelectRecordStorage().aNb(trim);
                        aNb.nc(aNb.fqJ | 4096);
                        ((l) g.af(l.class)).eiy().a(aNb.field_msgId, aNb);
                        sv svVar = new sv();
                        svVar.dZo.msgId = aNb.field_msgId;
                        EventCenter.instance.asyncPublish(svVar, Looper.myLooper());
                        z = true;
                    } else {
                        z = false;
                    }
                    Matcher matcher = gsK.matcher(trim3);
                    if (matcher.find()) {
                        String group = matcher.group(0);
                        if (!Util.isNullOrNil(group) && group.length() > 3) {
                            String substring = group.substring(2, group.length() - 1);
                            g.aAi();
                            as Kn = ((l) g.af(l.class)).aSN().Kn(substring);
                            if (!Util.isNullOrNil(Kn.field_conRemark)) {
                                displayName = Kn.field_conRemark;
                            } else {
                                String str3 = Kn.field_username;
                                ah Kd = ((c) g.af(c.class)).aSX().Kd(trim2);
                                if (Kd == null) {
                                    displayName = null;
                                } else {
                                    displayName = Kd.getDisplayName(str3);
                                }
                            }
                            if (Util.isNullOrNil(displayName)) {
                                displayName = Kn.field_conRemark;
                            }
                            if (Util.isNullOrNil(displayName)) {
                                displayName = Kn.arI();
                            }
                            if (Util.isNullOrNil(displayName)) {
                                displayName = Kn.field_username;
                            }
                            str2 = trim3.replace(group, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), displayName));
                            ca caVar = new ca();
                            caVar.nv(0);
                            caVar.Cy(trim2);
                            caVar.setStatus(3);
                            caVar.setContent(str2);
                            caVar.setCreateTime(bp.C(trim2, System.currentTimeMillis() / 1000));
                            caVar.setType(10000);
                            caVar.setFlag(caVar.field_flag | 8);
                            Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", trim2, Integer.valueOf(i2), trim, Long.valueOf(bp.x(caVar)), trim4, Boolean.valueOf(z));
                        }
                    }
                    str2 = trim3;
                    ca caVar2 = new ca();
                    caVar2.nv(0);
                    caVar2.Cy(trim2);
                    caVar2.setStatus(3);
                    caVar2.setContent(str2);
                    caVar2.setCreateTime(bp.C(trim2, System.currentTimeMillis() / 1000));
                    caVar2.setType(10000);
                    caVar2.setFlag(caVar2.field_flag | 8);
                    Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", trim2, Integer.valueOf(i2), trim, Long.valueOf(bp.x(caVar2)), trim4, Boolean.valueOf(z));
                } else {
                    Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "no contains historyid");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(187921);
        return null;
    }
}

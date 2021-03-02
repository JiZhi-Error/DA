package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.Map;

public final class b implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(194042);
        if (Util.nullAsNil(str).equals("IMUnionRoom2AssociateRoom")) {
            Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", Util.nullAs(str, ""));
            if (!y.ama()) {
                AppMethodBeat.o(194042);
                return null;
            } else if (map != null) {
                try {
                    final String trim = Util.nullAsNil(map.get(".sysmsg.associateroomname")).trim();
                    final String trim2 = Util.nullAsNil(map.get(".sysmsg.imunionroomname")).trim();
                    Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml %s %s", Util.nullAs(trim2, ""), Util.nullAs(trim, ""));
                    if (ab.Ix(trim) && !Util.isNullOrNil(trim2)) {
                        ah Kd = ((c) g.af(c.class)).aSX().Kd(trim);
                        if (Kd == null) {
                            ay.a.iDq.a(trim, null, new ay.b.a() {
                                /* class com.tencent.mm.chatroom.e.b.AnonymousClass1 */

                                @Override // com.tencent.mm.model.ay.b.a
                                public final void p(String str, boolean z) {
                                    AppMethodBeat.i(194041);
                                    Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", Util.nullAs(str, ""), Boolean.valueOf(z));
                                    if (z) {
                                        b.a(((c) g.af(c.class)).aSX().Kd(trim), trim, trim2);
                                    }
                                    AppMethodBeat.o(194041);
                                }
                            });
                        } else {
                            a(Kd, trim, trim2);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(194042);
        return null;
    }

    static void a(ah ahVar, String str, String str2) {
        Object valueOf;
        Object valueOf2;
        boolean z;
        AppMethodBeat.i(194043);
        if (ahVar != null) {
            try {
                if (Util.isNullOrNil(ahVar.field_associateOpenIMRoomName)) {
                    ah Kd = ((c) g.af(c.class)).aSX().Kd(str2);
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    if (ahVar == null) {
                        valueOf = BuildConfig.COMMAND;
                    } else {
                        valueOf = Boolean.valueOf(ahVar.gBC());
                    }
                    objArr[1] = valueOf;
                    objArr[2] = str2;
                    if (Kd == null) {
                        valueOf2 = BuildConfig.COMMAND;
                    } else {
                        valueOf2 = Boolean.valueOf(Kd.gBC());
                    }
                    objArr[3] = valueOf2;
                    Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", objArr);
                    if (Kd == null || Kd.gBC()) {
                        z = false;
                    } else {
                        Kd.field_openIMRoomMigrateStatus = 2;
                        Kd.field_associateOpenIMRoomName = str;
                        ((c) g.af(c.class)).aSX().replace(Kd);
                        z = true;
                    }
                    if (z) {
                        ahVar.field_openIMRoomMigrateStatus = 1;
                    } else {
                        ahVar.field_openIMRoomMigrateStatus = 3;
                    }
                    ahVar.field_associateOpenIMRoomName = str2;
                    ((c) g.af(c.class)).aSX().replace(ahVar);
                    if (z) {
                        ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().ae(str, str2);
                    }
                    AppMethodBeat.o(194043);
                    return;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(194043);
                return;
            }
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = ahVar == null ? BuildConfig.COMMAND : Util.nullAs(ahVar.field_associateOpenIMRoomName, "");
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", objArr2);
        AppMethodBeat.o(194043);
    }
}

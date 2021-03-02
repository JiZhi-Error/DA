package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public final class aa {
    private static Boolean gsG = null;

    public static boolean ame() {
        AppMethodBeat.i(182109);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            AppMethodBeat.o(182109);
            return true;
        } else if (gsG != null) {
            boolean booleanValue = gsG.booleanValue();
            AppMethodBeat.o(182109);
            return booleanValue;
        } else {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_group_tools_switch, 1);
            Log.i("MicroMsg.roomtools.RoomToolsHelp", "getRoomToolsSwt() swt:%s", Integer.valueOf(a2));
            if (a2 == 1) {
                gsG = Boolean.TRUE;
            } else {
                gsG = Boolean.FALSE;
            }
            boolean booleanValue2 = gsG.booleanValue();
            AppMethodBeat.o(182109);
            return booleanValue2;
        }
    }

    public static boolean h(ca caVar) {
        AppMethodBeat.i(182111);
        if (caVar == null) {
            AppMethodBeat.o(182111);
            return false;
        }
        if (caVar.getType() == 436207665) {
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null && "1001".equals(bVar.iyq)) {
                AppMethodBeat.o(182111);
                return true;
            }
        }
        AppMethodBeat.o(182111);
        return false;
    }

    public static void a(String str, bkz bkz) {
        boolean z;
        e eVar;
        boolean a2;
        AppMethodBeat.i(182112);
        if (!ame()) {
            AppMethodBeat.o(182112);
        } else if (bkz == null) {
            AppMethodBeat.o(182112);
        } else {
            e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(str);
            if (DE == null) {
                e eVar2 = new e();
                eVar2.field_chatroomname = str;
                eVar2.field_queryState = 0;
                z = false;
                eVar = eVar2;
            } else {
                z = true;
                eVar = DE;
            }
            dpu dpu = bkz.LTS;
            if (dpu == null || dpu.MSU.size() == 0) {
                eVar.field_stickToollist = "";
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < dpu.MSU.size(); i2++) {
                    dqc dqc = dpu.MSU.get(i2);
                    if (dqc != null) {
                        arrayList.add(new GroupToolItem(Util.nullAs(dqc.Username, ""), Util.nullAs(dqc.xut, "")));
                    }
                }
                eVar.field_stickToollist = e.W(arrayList);
            }
            if (z) {
                a2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar, new String[0]);
            } else {
                a2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar);
            }
            Log.i("MicroMsg.roomtools.RoomToolsHelp", "updateStickToolsByGetChatRoomInfoDetail roomName:%s result:%s", str, Boolean.valueOf(a2));
            AppMethodBeat.o(182112);
        }
    }

    public static boolean i(ca caVar) {
        AppMethodBeat.i(185965);
        if (caVar == null) {
            AppMethodBeat.o(185965);
            return false;
        } else if (!ab.Ix(caVar.field_talker)) {
            AppMethodBeat.o(185965);
            return false;
        } else if (!ame()) {
            AppMethodBeat.o(185965);
            return false;
        } else {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD == null) {
                Log.d("MicroMsg.roomtools.RoomToolsHelp", "content is null");
                AppMethodBeat.o(185965);
                return false;
            } else if (a.b(HD) || a.c(HD) || "1001".equals(HD.iyq)) {
                AppMethodBeat.o(185965);
                return true;
            } else {
                AppMethodBeat.o(185965);
                return false;
            }
        }
    }

    public static void Dy(String str) {
        boolean z;
        AppMethodBeat.i(185966);
        if (ame() && ab.Ix(str)) {
            e eVar = null;
            if (!Util.isNullOrNil(str)) {
                e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(str);
                if (DE == null || DE.field_queryState == 0) {
                    eVar = DE;
                    z = false;
                } else {
                    DE.field_queryState = 0;
                    z = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(DE, new String[0]);
                    eVar = DE;
                }
            } else {
                z = false;
            }
            Object[] objArr = new Object[3];
            objArr[0] = Util.nullAs(str, "");
            objArr[1] = eVar == null ? BuildConfig.COMMAND : "not_null";
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.roomtools.RoomToolsHelp", "resetGroupToolsByTalker roomName:%s groupTools:%s result:%s", objArr);
        }
        AppMethodBeat.o(185966);
    }

    public static void amf() {
        AppMethodBeat.i(185967);
        Log.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
        List<e> amp = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().amp();
        if (amp != null) {
            for (e eVar : amp) {
                eVar.field_queryState = 0;
                ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar, new String[0]);
            }
        }
        AppMethodBeat.o(185967);
    }

    public static e Dz(String str) {
        AppMethodBeat.i(194040);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(194040);
            return null;
        }
        e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(str);
        if (DE != null) {
            AppMethodBeat.o(194040);
            return DE;
        }
        e eVar = new e();
        eVar.field_chatroomname = str;
        if (((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar)) {
            e DE2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(str);
            AppMethodBeat.o(194040);
            return DE2;
        }
        AppMethodBeat.o(194040);
        return null;
    }

    public static GroupToolItem g(ca caVar) {
        AppMethodBeat.i(182110);
        try {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD != null) {
                GroupToolItem groupToolItem = new GroupToolItem();
                groupToolItem.username = Util.nullAs(HD.izi, "");
                groupToolItem.path = Util.nullAs(HD.izh, "");
                groupToolItem.crj = caVar.field_createTime;
                AppMethodBeat.o(182110);
                return groupToolItem;
            }
            AppMethodBeat.o(182110);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.roomtools.RoomToolsHelp", "getGroupToolItemFromMsg Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(182110);
            return null;
        }
    }
}

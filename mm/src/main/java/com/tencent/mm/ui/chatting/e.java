package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.smtt.sdk.TbsListener;

public final class e {

    public interface c {
        boolean a(String str, Context context, MMFragment mMFragment, String str2);
    }

    public static boolean a(String str, Context context, MMFragment mMFragment, String str2) {
        AppMethodBeat.i(34306);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(34306);
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else if (b.bmu(str)) {
            cVar = new b();
        } else if (d.bmu(str)) {
            cVar = new d();
        }
        if (cVar == null || !cVar.a(str, context, mMFragment, str2)) {
            AppMethodBeat.o(34306);
            return false;
        }
        AppMethodBeat.o(34306);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements c {
        a() {
        }

        @Override // com.tencent.mm.ui.chatting.e.c
        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(34301);
            if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
                Intent intent = new Intent();
                intent.putExtra("key_type", 0);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                AppMethodBeat.o(34301);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_type", 1);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent2);
                AppMethodBeat.o(34301);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
                Intent intent3 = new Intent();
                intent3.putExtra("key_type", 1);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent3);
                AppMethodBeat.o(34301);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
                Intent intent4 = new Intent();
                intent4.putExtra("key_type", 2);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent4);
                AppMethodBeat.o(34301);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
                Intent intent5 = new Intent();
                intent5.putExtra("key_native_url", str);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent5);
                AppMethodBeat.o(34301);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                Intent intent6 = new Intent();
                intent6.putExtra("key_way", 5);
                intent6.putExtra("key_native_url", str);
                intent6.putExtra("key_static_from_scene", 1);
                com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent6);
                AppMethodBeat.o(34301);
                return true;
            } else {
                AppMethodBeat.o(34301);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements c {
        b() {
        }

        public static boolean bmu(String str) {
            AppMethodBeat.i(34302);
            if (str == null || (!str.startsWith("weixin://openNativeUrl/myDeviceList") && !str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                AppMethodBeat.o(34302);
                return false;
            }
            AppMethodBeat.o(34302);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.e.c
        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(34303);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(34303);
                return false;
            } else if (str.startsWith("weixin://openNativeUrl/myDeviceList")) {
                Intent intent = new Intent();
                intent.putExtra("device_brand_name", str2);
                com.tencent.mm.br.c.b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
                AppMethodBeat.o(34303);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/bindMyDevice")) {
                AppMethodBeat.o(34303);
                return false;
            } else {
                AppMethodBeat.o(34303);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements c {
        d() {
        }

        public static boolean bmu(String str) {
            AppMethodBeat.i(34304);
            if (str == null || (!str.startsWith("weixin://wesport/recommend") && !str.startsWith("weixin://openNativeUrl/rankMyHomepage") && !str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                AppMethodBeat.o(34304);
                return false;
            }
            AppMethodBeat.o(34304);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.e.c
        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(34305);
            if (Util.isNullOrNil(str)) {
                Log.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
                AppMethodBeat.o(34305);
                return false;
            } else if (str.startsWith("weixin://wesport/recommend") && mMFragment != null) {
                Intent intent = new Intent(context, SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", str2);
                intent.putExtra("Select_block_List", str2);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                mMFragment.startActivityForResult(intent, TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                AppMethodBeat.o(34305);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
                String aTY = z.aTY();
                if (Util.isNullOrNil(aTY)) {
                    Log.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                    AppMethodBeat.o(34305);
                    return false;
                }
                Intent intent2 = new Intent();
                intent2.putExtra(ch.COL_USERNAME, aTY);
                com.tencent.mm.br.c.b(context, "exdevice", ".ui.ExdeviceProfileUI", intent2);
                Log.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
                AppMethodBeat.o(34305);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankSetting")) {
                com.tencent.mm.br.c.V(context, "exdevice", ".ui.ExdeviceSettingUI");
                AppMethodBeat.o(34305);
                return true;
            } else {
                AppMethodBeat.o(34305);
                return false;
            }
        }
    }
}

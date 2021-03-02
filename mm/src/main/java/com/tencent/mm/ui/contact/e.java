package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class e {
    public static void s(Intent intent, String str) {
        AppMethodBeat.i(37729);
        intent.putExtra("Contact_User", str);
        AppMethodBeat.o(37729);
    }

    public static void a(Intent intent, String str) {
        AppMethodBeat.i(37730);
        if (intent == null || str == null || str.length() == 0) {
            Log.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            AppMethodBeat.o(37730);
            return;
        }
        as Tg = a.getQQListStg().Tg(str);
        if (Tg != null) {
            intent.putExtra("Contact_Uin", Tg.kfN);
            intent.putExtra("Contact_QQNick", Tg.getDisplayName());
        }
        com.tencent.mm.plugin.account.friend.a.a SR = a.getAddrUploadStg().SR(str);
        if (SR != null) {
            intent.putExtra("Contact_Mobile_MD5", SR.getMd5());
        }
        AppMethodBeat.o(37730);
    }

    public static void a(Context context, ca.a aVar) {
        AppMethodBeat.i(37731);
        a(context, aVar, false, false, null);
        AppMethodBeat.o(37731);
    }

    public static void a(Context context, ca.a aVar, boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.i(37732);
        if (context == null || aVar == null) {
            AppMethodBeat.o(37732);
            return;
        }
        com.tencent.mm.storage.as asVar = new com.tencent.mm.storage.as();
        asVar.setUsername(aVar.dkU);
        asVar.setNickname(aVar.getDisplayName());
        asVar.BF(aVar.kfQ);
        asVar.BG(aVar.kfR);
        a(context, asVar, aVar, z, z2, bundle, aVar.kcp);
        AppMethodBeat.o(37732);
    }

    public static void a(Context context, com.tencent.mm.storage.as asVar, ca.a aVar) {
        AppMethodBeat.i(37733);
        a(context, asVar, aVar, false, false, null, aVar.kcp);
        AppMethodBeat.o(37733);
    }

    public static void a(Context context, com.tencent.mm.storage.as asVar, ca.a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        AppMethodBeat.i(37734);
        if (asVar == null || aVar == null) {
            AppMethodBeat.o(37734);
        } else if (asVar.field_username == null || asVar.field_username.length() <= 0) {
            AppMethodBeat.o(37734);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", asVar.field_username);
            intent.putExtra("Contact_Alias", asVar.ajx());
            intent.putExtra("Contact_Nick", asVar.arI());
            intent.putExtra("Contact_QuanPin", asVar.ajA());
            intent.putExtra("Contact_PyInitial", asVar.ajz());
            intent.putExtra("Contact_Sex", aVar.fuA);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.signature);
            intent.putExtra("Contact_Uin", aVar.Bge);
            intent.putExtra("Contact_Mobile_MD5", aVar.OqK);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.OqL);
            intent.putExtra("Contact_QQNick", aVar.gDZ());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(37734);
        }
    }
}

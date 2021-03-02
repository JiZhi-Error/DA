package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.e;

public final class a implements q {
    @Override // com.tencent.mm.pluginsdk.q
    public final boolean a(Context context, String str, boolean z) {
        AppMethodBeat.i(19655);
        boolean a2 = a(context, str, z, (u) null);
        AppMethodBeat.o(19655);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.q
    public final boolean a(Context context, String str, boolean z, u uVar) {
        AppMethodBeat.i(19656);
        if (context == null) {
            Log.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            AppMethodBeat.o(19656);
            return false;
        } else if (str.startsWith("http")) {
            u(context, str);
            AppMethodBeat.o(19656);
            return true;
        } else if (!b(context, str, z, uVar)) {
            Log.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            AppMethodBeat.o(19656);
            return false;
        } else {
            AppMethodBeat.o(19656);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.q
    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        AppMethodBeat.i(19657);
        boolean a2 = a(context, str, z, null, bundle);
        AppMethodBeat.o(19657);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.q
    public final boolean b(Context context, String str, boolean z, u uVar) {
        AppMethodBeat.i(19658);
        boolean a2 = a(context, str, z, uVar, null);
        AppMethodBeat.o(19658);
        return a2;
    }

    private boolean a(Context context, String str, boolean z, u uVar, Bundle bundle) {
        AppMethodBeat.i(19659);
        if (context == null) {
            Log.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            AppMethodBeat.o(19659);
            return false;
        } else if (str == null) {
            Log.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            AppMethodBeat.o(19659);
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            boolean b2 = b(context, str, new Object[0]);
            AppMethodBeat.o(19659);
            return b2;
        } else {
            boolean b3 = e.Xo().b(context, str, z, uVar, bundle);
            AppMethodBeat.o(19659);
            return b3;
        }
    }

    private static void u(Context context, String str) {
        AppMethodBeat.i(19660);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19660);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e2.getMessage());
            AppMethodBeat.o(19660);
        }
    }

    @Override // com.tencent.mm.pluginsdk.q
    public final boolean b(Context context, String str, Object... objArr) {
        int i2;
        String str2;
        String str3;
        AppMethodBeat.i(19661);
        if (str == null) {
            Log.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            AppMethodBeat.o(19661);
            return false;
        } else if (context == null) {
            Log.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            AppMethodBeat.o(19661);
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            String replace = str.replace("weixin://openSpecificView/", "");
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent.setClass(context, LauncherUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (replace.equalsIgnoreCase("newfriend")) {
                c.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                c.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                c.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent.setClass(context, LauncherUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (replace.equalsIgnoreCase("timeline")) {
                c.b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                c.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                c.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                c.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.ay(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) {
                c.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                c.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.kp(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                if (bundle != null) {
                    str3 = bundle.getString("url");
                } else {
                    str3 = "";
                }
                intent.putExtra("k_expose_url", str3);
                intent.putExtra("k_username", z.aTY());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 34));
                c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                if (bundle != null) {
                    str2 = bundle.getString(Constants.EXTINFO);
                } else {
                    str2 = "";
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", str2);
                c.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                Log.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
                kl klVar = new kl();
                klVar.dPA.context = context;
                EventCenter.instance.publish(klVar);
            } else if (replace.equalsIgnoreCase("uploadlog")) {
                String aTY = z.aTY();
                if (Util.isNullOrNil(aTY)) {
                    aTY = "weixin";
                }
                if (bundle != null) {
                    try {
                        i2 = Util.getInt(bundle.getString(Constants.EXTINFO), 0);
                    } catch (Exception e2) {
                    }
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Boolean.valueOf(!bg.aAc() && !bg.azj());
                    objArr2[1] = Integer.valueOf(i2);
                    Log.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", objArr2);
                    Intent intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                    intent3.putExtra("key_user", aTY);
                    intent3.putExtra("key_time", i2);
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                i2 = 0;
                Object[] objArr22 = new Object[2];
                objArr22[0] = Boolean.valueOf(!bg.aAc() && !bg.azj());
                objArr22[1] = Integer.valueOf(i2);
                Log.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", objArr22);
                Intent intent32 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent32.putExtra("key_user", aTY);
                intent32.putExtra("key_time", i2);
                com.tencent.mm.hellhoundlib.b.a bl32 = new com.tencent.mm.hellhoundlib.b.a().bl(intent32);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl32.axQ(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl32.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                AppMethodBeat.o(19661);
                return false;
            }
            AppMethodBeat.o(19661);
            return true;
        }
    }
}

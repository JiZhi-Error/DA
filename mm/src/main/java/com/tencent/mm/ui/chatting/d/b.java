package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cf;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.at;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@a(gRF = com.tencent.mm.ui.chatting.d.b.b.class)
public class b extends a implements com.tencent.mm.ui.chatting.d.b.b {
    private com.tencent.mm.plugin.wallet.a CqM = null;
    private at PmF = null;
    private final MStorage.IOnStorageChange PmG = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(35069);
            Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
            ((k) b.this.dom.bh(k.class)).gOw();
            AppMethodBeat.o(35069);
        }
    };
    private final MStorage.IOnStorageChange PmH = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.b.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(35070);
            Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
            ((k) b.this.dom.bh(k.class)).gOw();
            AppMethodBeat.o(35070);
        }
    };

    public b() {
        AppMethodBeat.i(35072);
        AppMethodBeat.o(35072);
    }

    private void gOL() {
        AppMethodBeat.i(35073);
        if (this.PmF != null) {
            at.b(this.PmF);
        }
        if (bg.aAc()) {
            ao.cgO().remove(this.PmG);
            ao.eAS().remove(this.PmH);
        }
        AppMethodBeat.o(35073);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.b
    public final void u(g gVar) {
        AppMethodBeat.i(35074);
        if (gVar == null) {
            Log.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", Util.getStack());
            AppMethodBeat.o(35074);
            return;
        }
        if (!(gVar == null || !g.JVR.equals(gVar.field_appId) || this.CqM == null)) {
            this.CqM.cG(2, this.dom.GUe.field_username);
        }
        if (gVar.gmR()) {
            if (gVar == null || !gVar.gmR()) {
                Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
                AppMethodBeat.o(35074);
            } else if (this.dom.GUe == null || Util.isNullOrNil(this.dom.GUe.field_username)) {
                Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
                AppMethodBeat.o(35074);
            } else {
                Log.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(gVar.fmZ), gVar.field_packageName, gVar.field_appId);
                if (gVar.fmZ == 2 && !Util.isNullOrNil(gVar.fmY)) {
                    v(gVar);
                    AppMethodBeat.o(35074);
                } else if (gVar.fmZ != 3) {
                    if (gVar.fmZ == 1) {
                        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", gVar.fmY);
                        q.a.JSZ.a((Context) this.dom.Pwc.getContext(), gVar.fmY, false, (u) new u() {
                            /* class com.tencent.mm.ui.chatting.d.b.AnonymousClass3 */

                            @Override // com.tencent.mm.pluginsdk.u
                            public final Object glZ() {
                                return b.this.dom.GUe.field_username;
                            }

                            @Override // com.tencent.mm.pluginsdk.u
                            public final Object gma() {
                                AppMethodBeat.i(35071);
                                com.tencent.mm.plugin.wallet.a aVar = b.this.CqM;
                                AppMethodBeat.o(35071);
                                return aVar;
                            }
                        });
                    }
                    AppMethodBeat.o(35074);
                } else if (Util.isNullOrNil(gVar.field_openId)) {
                    ao.eAU().add(gVar.field_appId);
                    Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
                    AppMethodBeat.o(35074);
                } else if (this.PmF == null || Util.isNullOrNil(gVar.field_packageName)) {
                    Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
                    v(gVar);
                    AppMethodBeat.o(35074);
                } else {
                    boolean nf = this.PmF.nf(gVar.field_packageName, gVar.field_openId);
                    Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", Boolean.valueOf(nf));
                    if (!nf) {
                        v(gVar);
                    }
                    AppMethodBeat.o(35074);
                }
            }
        } else if (gVar.field_status == 3) {
            Log.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + gVar.field_packageName);
            AppMethodBeat.o(35074);
        } else {
            if (!this.PmF.nf(gVar.field_packageName, gVar.field_openId) && gVar.field_status == 5) {
                Log.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", gVar.fmM);
                if (Util.isNullOrNil(gVar.fmM)) {
                    AppMethodBeat.o(35074);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", gVar.fmM);
                c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(35074);
        }
    }

    private void v(g gVar) {
        int i2;
        AppMethodBeat.i(35075);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            Log.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
            AppMethodBeat.o(35075);
        } else if (Util.isNullOrNil(gVar.fmY)) {
            Log.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
            AppMethodBeat.o(35075);
        } else {
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(this.dom.Pwc.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dom.Pwc.getContext());
            if (LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(loadApplicationLanguage) && Locale.getDefault() != null) {
                loadApplicationLanguage = Locale.getDefault().toString();
            }
            if (ab.Eq(this.dom.getTalkerUserName())) {
                bg.aVF();
                ah Kd = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
                if (Kd != null) {
                    i2 = Kd.bax().size();
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", gVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.dom.GUe.field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", gVar.fmY, Integer.valueOf(i2), loadApplicationLanguage));
                    c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(35075);
                }
            }
            i2 = 1;
            Intent intent2 = new Intent();
            Bundle bundle2 = new Bundle();
            bundle2.putString("jsapi_args_appid", gVar.field_appId);
            bundle2.putBoolean("isFromService", true);
            intent2.putExtra("forceHideShare", true);
            bundle2.putString("sendAppMsgToUserName", this.dom.GUe.field_username);
            intent2.putExtra("jsapiargs", bundle2);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", gVar.fmY, Integer.valueOf(i2), loadApplicationLanguage));
            c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.o(35075);
        }
    }

    private static String bs(Context context, String str) {
        String str2;
        AppMethodBeat.i(35078);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                str2 = next.activityInfo.name;
                AppMethodBeat.o(35078);
                return str2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e2, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(35078);
        return str2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.b
    public final void a(t tVar) {
        AppMethodBeat.i(35079);
        cf.aWl().f(38, 1);
        String str = tVar.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        o oVar = new o(str);
        wXMediaMessage.title = oVar.getName();
        wXMediaMessage.description = Util.getSizeKB(oVar.length());
        g gVar = new g();
        gVar.field_appId = "wx4310bbd51be7d979";
        ao.eAS().get(gVar, new String[0]);
        m.a(wXMediaMessage, gVar.field_appId, gVar.field_appName, this.dom.getTalkerUserName(), 2, (String) null);
        AppMethodBeat.o(35079);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(35080);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 210:
                if (i3 == -1) {
                    long longExtra = intent.getLongExtra("App_MsgId", 0);
                    bg.aVF();
                    a(com.tencent.mm.model.c.aSQ().Hb(longExtra), (al) null);
                }
                AppMethodBeat.o(35080);
                return;
            case TbsListener.ErrorCode.UNLZMA_FAIURE /*{ENCODED_INT: 222}*/:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("service_app_package_name");
                    String stringExtra2 = intent.getStringExtra("service_app_openid");
                    String stringExtra3 = intent.getStringExtra("service_app_appid");
                    Object[] objArr = new Object[4];
                    if (this.PmF != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = stringExtra;
                    objArr[2] = stringExtra3;
                    objArr[3] = stringExtra2;
                    Log.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", objArr);
                    if (!Util.isNullOrNil(stringExtra3)) {
                        if (this.PmF != null && !Util.isNullOrNil(stringExtra)) {
                            if (!Util.isNullOrNil(stringExtra2)) {
                                boolean nf = this.PmF.nf(stringExtra, stringExtra2);
                                Log.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", Boolean.valueOf(nf));
                                if (!nf) {
                                    v(h.o(stringExtra3, true, false));
                                    break;
                                }
                            } else {
                                ao.eAU().add(stringExtra3);
                                Log.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
                                AppMethodBeat.o(35080);
                                return;
                            }
                        } else {
                            v(h.o(stringExtra3, true, false));
                            AppMethodBeat.o(35080);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
                        AppMethodBeat.o(35080);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(35080);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35083);
        gOL();
        AppMethodBeat.o(35083);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35084);
        super.gOK();
        gOL();
        AppMethodBeat.o(35084);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.b
    public final void a(ca caVar, al alVar) {
        String str;
        k.b HD;
        g o;
        Uri uriForFile;
        AppMethodBeat.i(35076);
        String str2 = caVar.field_content;
        if (caVar.field_isSend == 0) {
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            int i2 = caVar.field_isSend;
            if (!((d) aVar.bh(d.class)).gOQ() && aVar.gRL() && str2 != null && i2 == 0) {
                str = bp.Kt(str2);
                HD = k.b.HD(str);
                o = h.o(HD.appId, true, false);
                if (o != null || !com.tencent.mm.pluginsdk.model.app.q.s(this.dom.Pwc.getContext(), o.field_packageName)) {
                    String R = com.tencent.mm.pluginsdk.model.app.q.R(this.dom.Pwc.getContext(), HD.appId, "message");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", R);
                    c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(35076);
                } else if (o.field_status == 3) {
                    Log.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + o.field_packageName);
                    AppMethodBeat.o(35076);
                    return;
                } else if (!com.tencent.mm.pluginsdk.model.app.q.b(this.dom.Pwc.getContext(), o)) {
                    Log.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", o.field_appName);
                    Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.dpi, h.a(this.dom.Pwc.getContext(), o, (String) null)), 1).show();
                    AppMethodBeat.o(35076);
                    return;
                } else if (a(caVar, o)) {
                    AppMethodBeat.o(35076);
                    return;
                } else {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = HD.extInfo;
                    if (HD.dCK != null && HD.dCK.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                        wXAppExtendObject.filePath = bdx == null ? null : bdx.field_fileFullPath;
                        if (s.YS(wXAppExtendObject.filePath) && (uriForFile = FileProviderHelper.getUriForFile(this.dom.Pwc.getContext(), new o(wXAppExtendObject.filePath))) != null) {
                            this.dom.Pwc.getContext().grantUriPermission(o.field_packageName, uriForFile, 1);
                            wXAppExtendObject.filePath = uriForFile.toString();
                        }
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = Build.SDK_INT;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = HD.title;
                    wXMediaMessage.description = HD.description;
                    wXMediaMessage.messageAction = HD.messageAction;
                    wXMediaMessage.messageExt = HD.messageExt;
                    wXMediaMessage.thumbData = s.aW(com.tencent.mm.av.q.bcR().Oz(caVar.field_imgPath), 0, -1);
                    new au(this.dom.Pwc.getContext()).a(o.field_packageName, wXMediaMessage, o.field_appId, o.field_openId, alVar);
                    AppMethodBeat.o(35076);
                    return;
                }
            }
        }
        str = str2;
        HD = k.b.HD(str);
        o = h.o(HD.appId, true, false);
        if (o != null) {
        }
        String R2 = com.tencent.mm.pluginsdk.model.app.q.R(this.dom.Pwc.getContext(), HD.appId, "message");
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", R2);
        c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
        AppMethodBeat.o(35076);
    }

    private boolean a(ca caVar, g gVar) {
        int i2;
        AppMethodBeat.i(35077);
        if (!caVar.field_talker.endsWith("@qqim") || !gVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            AppMethodBeat.o(35077);
            return false;
        }
        Log.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.setClassName(TbsConfig.APP_QQ, bs(this.dom.Pwc.getContext(), TbsConfig.APP_QQ));
        intent.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
        bg.aVF();
        Object obj = com.tencent.mm.model.c.azQ().get(9, (Object) null);
        if (obj == null || !(obj instanceof Integer)) {
            i2 = 0;
        } else {
            i2 = ((Integer) obj).intValue();
        }
        if (i2 != 0) {
            try {
                byte[] bytes = String.valueOf(i2).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    byte b2 = bytes2[i3];
                    if (i4 >= bytes.length) {
                        break;
                    }
                    bytes[i4] = (byte) (b2 ^ bytes[i4]);
                    i3++;
                    i4++;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e2, "", new Object[0]);
            }
        }
        try {
            BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } catch (Exception e3) {
        }
        AppMethodBeat.o(35077);
        return true;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35081);
        this.CqM = com.tencent.mm.plugin.wallet.a.fV(this.dom.GUe.field_username, 1);
        this.CqM.cG(1, this.dom.GUe.field_username);
        ao.cgO().add(this.PmG);
        ao.eAS().add(this.PmH);
        if (this.PmF == null) {
            this.PmF = new at(this.dom);
        }
        at.a(this.PmF);
        AppMethodBeat.o(35081);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35082);
        aq.clear();
        AppMethodBeat.o(35082);
    }
}

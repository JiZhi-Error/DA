package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashSet;
import java.util.Set;

public final class at implements ab {
    private static MStorageEvent<ab, Bundle> Plk = new MStorageEvent<ab, Bundle>() {
        /* class com.tencent.mm.ui.chatting.at.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(ab abVar, Bundle bundle) {
            AppMethodBeat.i(34963);
            abVar.bu(bundle);
            AppMethodBeat.o(34963);
        }
    };
    private MMFragment Pli;
    private final Set<String> Plj = new HashSet();
    private a dom;

    static {
        AppMethodBeat.i(34974);
        AppMethodBeat.o(34974);
    }

    public at(a aVar) {
        AppMethodBeat.i(34965);
        this.Pli = aVar.Pwc;
        this.dom = aVar;
        AppMethodBeat.o(34965);
    }

    public static void bv(Bundle bundle) {
        AppMethodBeat.i(34966);
        Plk.event(bundle);
        Plk.doNotify();
        AppMethodBeat.o(34966);
    }

    @Override // com.tencent.mm.ui.chatting.ab
    public final void bu(Bundle bundle) {
        d a2;
        d a3;
        d a4;
        d a5;
        d b2;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(34967);
        if (this.dom == null || !this.dom.cQp) {
            Log.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
            AppMethodBeat.o(34967);
            return;
        }
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp(bundle);
        WXMediaMessage wXMediaMessage = resp.message;
        if (this.Plj.size() == 0) {
            Activity context = this.Pli.getContext();
            HashSet hashSet = new HashSet();
            String string = context.getSharedPreferences(MMApplicationContext.getTmpPreferencePath(), 0).getString("transactions_array_key", null);
            if (string != null && string.length() > 0) {
                String[] split = string.split(";");
                for (String str : split) {
                    hashSet.add(str);
                }
            }
            this.Plj.addAll(hashSet);
        }
        if (!this.Plj.contains(resp.transaction)) {
            Log.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.o(34967);
            return;
        }
        this.Plj.remove(resp.transaction);
        b(this.Pli.getContext(), this.Plj);
        g gVar = new g();
        gVar.field_appId = queryParameter;
        Log.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(queryParameter)));
        if (!ao.eAS().get(gVar, new String[0])) {
            Log.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(queryParameter)));
            AppMethodBeat.o(34967);
            return;
        }
        int type = wXMediaMessage.getType();
        switch (type) {
            case 1:
                t controller = this.Pli.getController();
                String str2 = wXMediaMessage.description;
                t(gVar);
                z = o.a(controller, str2, false, a(wXMediaMessage, gVar)) != null;
                break;
            case 2:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                        t controller2 = this.Pli.getController();
                        String str3 = wXImageObject.imagePath;
                        t(gVar);
                        b2 = o.b(controller2, str3, false, a(wXMediaMessage, gVar));
                    } else {
                        t controller3 = this.Pli.getController();
                        byte[] bArr = wXImageObject.imageData;
                        t(gVar);
                        b2 = o.a(controller3, bArr, false, a(wXMediaMessage, gVar));
                    }
                } else {
                    t controller4 = this.Pli.getController();
                    byte[] bArr2 = wXMediaMessage.thumbData;
                    t(gVar);
                    b2 = o.a(controller4, bArr2, false, a(wXMediaMessage, gVar));
                }
                if (b2 == null) {
                    Log.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                } else {
                    z2 = true;
                }
                z = z2;
                break;
            case 3:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    t controller5 = this.Pli.getController();
                    String str4 = wXMediaMessage.title;
                    t(gVar);
                    a5 = o.a(controller5, (int) R.raw.app_attach_file_icon_music, str4, false, a(wXMediaMessage, gVar));
                } else {
                    t controller6 = this.Pli.getController();
                    String str5 = wXMediaMessage.title;
                    t(gVar);
                    a5 = o.a(controller6, str5, false, 2, a(wXMediaMessage, gVar));
                }
                if (a5 == null) {
                    z = false;
                    break;
                }
                break;
            case 4:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    t controller7 = this.Pli.getController();
                    String str6 = wXMediaMessage.title;
                    t(gVar);
                    a4 = o.a(controller7, (int) R.raw.app_attach_file_icon_video, str6, false, a(wXMediaMessage, gVar));
                } else {
                    t controller8 = this.Pli.getController();
                    String str7 = wXMediaMessage.title;
                    t(gVar);
                    a4 = o.a(controller8, str7, false, 1, a(wXMediaMessage, gVar));
                }
                if (a4 == null) {
                    z = false;
                    break;
                }
                break;
            case 5:
                t controller9 = this.Pli.getController();
                String str8 = wXMediaMessage.title;
                String str9 = wXMediaMessage.description;
                t(gVar);
                if (o.a(controller9, str8, str9, a(wXMediaMessage, gVar)) == null) {
                    z = false;
                    break;
                }
                break;
            case 6:
            default:
                Log.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(type)));
                z = false;
                break;
            case 7:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    t controller10 = this.Pli.getController();
                    String str10 = wXMediaMessage.title;
                    t(gVar);
                    a3 = o.a(controller10, (int) R.raw.app_attach_file_icon_webpage, str10, false, a(wXMediaMessage, gVar));
                } else {
                    t controller11 = this.Pli.getController();
                    String str11 = wXMediaMessage.title;
                    t(gVar);
                    a3 = o.a(controller11, str11, false, 0, a(wXMediaMessage, gVar));
                }
                if (a3 == null) {
                    z = false;
                    break;
                }
                break;
            case 8:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    t controller12 = this.Pli.getController();
                    String str12 = wXMediaMessage.title;
                    t(gVar);
                    a2 = o.a(controller12, (int) R.raw.app_attach_file_icon_webpage, str12, false, a(wXMediaMessage, gVar));
                } else {
                    t controller13 = this.Pli.getController();
                    byte[] bArr3 = wXMediaMessage.thumbData;
                    t(gVar);
                    a2 = o.a(controller13, bArr3, false, a(wXMediaMessage, gVar));
                }
                if (a2 == null) {
                    z = false;
                    break;
                }
                break;
        }
        if (!z) {
            Log.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        AppMethodBeat.o(34967);
    }

    public final boolean nf(String str, String str2) {
        AppMethodBeat.i(34968);
        Log.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        GetMessageFromWX.Req req = new GetMessageFromWX.Req();
        req.username = this.dom.getTalkerUserName();
        req.transaction = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.nowMilliSecond()).toString().getBytes());
        req.openId = str2;
        req.lang = LocaleUtil.loadApplicationLanguage(this.Pli.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.Pli.getContext());
        bg.aVF();
        req.country = (String) c.azQ().get(274436, (Object) null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        q.bo(bundle);
        q.bp(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.Pli.getContext(), args);
        this.Plj.add(req.transaction);
        b(this.Pli.getContext(), this.Plj);
        AppMethodBeat.o(34968);
        return send;
    }

    public static void a(at atVar) {
        AppMethodBeat.i(34969);
        Plk.add(atVar, (Looper) null);
        AppMethodBeat.o(34969);
    }

    public static void b(at atVar) {
        AppMethodBeat.i(34970);
        Plk.remove(atVar);
        atVar.Plj.clear();
        b(atVar.Pli.getContext(), null);
        AppMethodBeat.o(34970);
    }

    private String t(g gVar) {
        AppMethodBeat.i(34971);
        String string = this.Pli.getString(R.string.b9a, h.a(this.Pli.getContext(), gVar, (String) null));
        AppMethodBeat.o(34971);
        return string;
    }

    private y.a a(final WXMediaMessage wXMediaMessage, final g gVar) {
        AppMethodBeat.i(34972);
        AnonymousClass2 r0 = new y.a() {
            /* class com.tencent.mm.ui.chatting.at.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(34964);
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            Log.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            AppMethodBeat.o(34964);
                            return;
                        }
                        str2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(at.this.Pli.getContext(), wXMediaMessage, gVar.field_appId);
                        if (str2 == null) {
                            Log.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            AppMethodBeat.o(34964);
                            return;
                        }
                    }
                    cf.aWl().f(27, 1);
                    Log.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    m.a(wXMediaMessage, gVar.field_appId, gVar.field_appName, at.this.dom.getTalkerUserName(), 1, str2);
                }
                AppMethodBeat.o(34964);
            }
        };
        AppMethodBeat.o(34972);
        return r0;
    }

    @TargetApi(9)
    private static void b(Context context, Set<String> set) {
        AppMethodBeat.i(34973);
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : set) {
                sb.append(str2);
                sb.append(";");
            }
            str = sb.toString();
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(MMApplicationContext.getTmpPreferencePath(), 0).edit();
        edit.putString("transactions_array_key", str);
        if (Build.VERSION.SDK_INT > 8) {
            edit.apply();
            AppMethodBeat.o(34973);
            return;
        }
        edit.commit();
        AppMethodBeat.o(34973);
    }
}

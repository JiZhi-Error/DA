package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.share.o;
import com.tencent.mm.plugin.scanner.box.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003!\"#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bH\u0007J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareHelper;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "TAG", "", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "reportData", "Landroid/os/Bundle;", "shareData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "shareInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "clearShareData", "", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onShareToFriendResult", "pushThumbToCache", "imageUrl", "setReportData", "shareToFriend", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, o.NAME, "updateShareData", "updateShareToFriendData", "Lorg/json/JSONObject;", "MenuId", "RequestCode", "ShareAction", "plugin-scan_release"})
public final class n implements MMActivity.a {
    private static Bundle CDg;
    private static m.a CDh;
    private static final m CDi = new m();
    public static final n CDj = new n();

    static {
        AppMethodBeat.i(240299);
        AppMethodBeat.o(240299);
    }

    private n() {
    }

    public static final void av(Bundle bundle) {
        AppMethodBeat.i(240294);
        p.h(bundle, "data");
        CDg = bundle;
        AppMethodBeat.o(240294);
    }

    public static final void updateShareData(String str) {
        String str2;
        AppMethodBeat.i(240295);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            Log.e("MicroMsg.ScanBoxShareHelper", "updateShareData params is invalid");
            AppMethodBeat.o(240295);
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.ScanBoxShareHelper", "alvinluo updateShareData action: %d", Integer.valueOf(optInt));
        switch (optInt) {
            case 1:
                String optString = jSONObject.optString("url");
                if (optString == null) {
                    str2 = "";
                } else {
                    str2 = optString;
                }
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("desc");
                String optString4 = jSONObject.optString(MessengerShareContentUtility.IMAGE_URL);
                Log.i("MicroMsg.ScanBoxShareHelper", "shareToFriend, imageUrl: " + optString4 + ", desc: " + optString3 + ", title: " + optString2 + ", url: " + str2);
                m.a aVar = new m.a(r.bm(jSONObject), optString4);
                m mVar = CDi;
                p.h(str2, "key");
                mVar.CDe.put(str2, aVar);
                break;
        }
        AppMethodBeat.o(240295);
    }

    public static final void ePw() {
        AppMethodBeat.i(240296);
        CDi.CDe.clear();
        AppMethodBeat.o(240296);
    }

    public static final void bu(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        WXMediaMessage wXMediaMessage;
        WXMediaMessage wXMediaMessage2;
        WXMediaMessage wXMediaMessage3;
        WXMediaMessage wXMediaMessage4;
        AppMethodBeat.i(240297);
        p.h(context, "context");
        n nVar = CDj;
        try {
            String optString = new JSONObject(str).optString("url");
            m mVar = CDi;
            p.g(optString, "url");
            p.h(optString, "key");
            CDh = mVar.CDe.get(optString);
            StringBuilder sb = new StringBuilder("shareToFriend, imageUrl: ");
            m.a aVar = CDh;
            if (aVar != null) {
                str2 = aVar.imageUrl;
            } else {
                str2 = null;
            }
            StringBuilder append = sb.append(str2).append(", desc: ");
            m.a aVar2 = CDh;
            StringBuilder append2 = append.append((aVar2 == null || (wXMediaMessage4 = aVar2.CDf) == null) ? null : wXMediaMessage4.description).append(", title: ");
            m.a aVar3 = CDh;
            if (aVar3 == null || (wXMediaMessage3 = aVar3.CDf) == null) {
                str3 = null;
            } else {
                str3 = wXMediaMessage3.title;
            }
            Log.i("MicroMsg.ScanBoxShareHelper", append2.append(str3).append(", url: ").append(optString).toString());
            HashMap hashMap = new HashMap();
            m.a aVar4 = CDh;
            if (aVar4 == null || (str4 = aVar4.imageUrl) == null) {
                str4 = "";
            }
            hashMap.put("img_url", str4);
            m.a aVar5 = CDh;
            if (aVar5 == null || (wXMediaMessage2 = aVar5.CDf) == null || (str5 = wXMediaMessage2.description) == null) {
                str5 = "";
            }
            hashMap.put("desc", str5);
            m.a aVar6 = CDh;
            if (aVar6 == null || (wXMediaMessage = aVar6.CDf) == null || (str6 = wXMediaMessage.title) == null) {
                str6 = "";
            }
            hashMap.put("title", str6);
            hashMap.put("url", optString);
            Intent intent = new Intent();
            intent.putExtra("webview_params", hashMap);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 2);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Retr_Msg_Type", 2);
            if (context instanceof MMActivity) {
                m.a aVar7 = CDh;
                if (aVar7 == null || (str7 = aVar7.imageUrl) == null) {
                    str7 = "";
                }
                String str8 = str7;
                if (str8 == null || str8.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && kotlin.n.n.J(str7, "http", false)) {
                    q.bcQ().a(str7, null);
                }
                c.a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, nVar);
                AppMethodBeat.o(240297);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxShareHelper", e2, "shareToFriend exception", new Object[0]);
        }
        AppMethodBeat.o(240297);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a CDk = new a();

        static {
            AppMethodBeat.i(240293);
            AppMethodBeat.o(240293);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(240292);
            u.cG(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.yt));
            AppMethodBeat.o(240292);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        WXMediaMessage wXMediaMessage;
        String str;
        boolean z;
        String str2 = null;
        AppMethodBeat.i(240298);
        Log.i("MicroMsg.ScanBoxShareHelper", "onActivityResult requestCode: " + i2 + ", resultCode: " + i3 + ", data == null: " + (intent == null));
        switch (i2) {
            case 1:
                switch (i3) {
                    case 0:
                        Log.w("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult cancel");
                        s.aw(CDg);
                        AppMethodBeat.o(240298);
                        return;
                    case -1:
                        if (CDh != null) {
                            m.a aVar = CDh;
                            if (aVar != null) {
                                wXMediaMessage = aVar.CDf;
                            } else {
                                wXMediaMessage = null;
                            }
                            if (wXMediaMessage != null) {
                                if (intent != null) {
                                    str = intent.getStringExtra("Select_Conv_User");
                                } else {
                                    str = null;
                                }
                                String str3 = str;
                                if (str3 == null || str3.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    String stringExtra = intent.getStringExtra("custom_send_text");
                                    if (stringExtra == null) {
                                        stringExtra = "";
                                    }
                                    r rVar = r.CDy;
                                    m.a aVar2 = CDh;
                                    if (aVar2 == null) {
                                        p.hyc();
                                    }
                                    WXMediaMessage wXMediaMessage2 = aVar2.CDf;
                                    m.a aVar3 = CDh;
                                    if (aVar3 != null) {
                                        str2 = aVar3.imageUrl;
                                    }
                                    boolean b2 = r.b(wXMediaMessage2, str, str2, stringExtra);
                                    Log.i("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult sendOk: %b", Boolean.valueOf(b2));
                                    if (b2) {
                                        h.RTc.n(a.CDk, 200);
                                    }
                                    s.b(b2, ab.Eq(str), CDg);
                                    break;
                                } else {
                                    Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult fail, toUser is null");
                                    AppMethodBeat.o(240298);
                                    return;
                                }
                            }
                        }
                        Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult shareInfo invalid");
                        AppMethodBeat.o(240298);
                        return;
                }
        }
        AppMethodBeat.o(240298);
    }
}

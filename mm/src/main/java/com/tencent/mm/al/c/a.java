package com.tencent.mm.al.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a {
    public static void a(Activity activity, ewx ewx) {
        final String str;
        AppMethodBeat.i(212203);
        if (ewx == null) {
            AppMethodBeat.o(212203);
            return;
        }
        String str2 = ewx.KRv;
        if (Util.isNullOrNil(str2)) {
            str = null;
        } else {
            str = d.aSZ() + g.getMessageDigest(str2.getBytes());
        }
        if (str == null) {
            Log.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + ewx.KRv);
            AppMethodBeat.o(212203);
            return;
        }
        c.a aVar = new c.a();
        aVar.fullPath = str;
        aVar.jbf = true;
        aVar.jbd = true;
        Log.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", str);
        final WeakReference weakReference = new WeakReference(activity);
        q.bcV().a(ewx.KRv, aVar.bdv(), new com.tencent.mm.av.a.c.d() {
            /* class com.tencent.mm.al.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.av.a.c.d
            public final void a(boolean z, Object... objArr) {
                AppMethodBeat.i(212202);
                Log.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", str, Boolean.valueOf(z));
                if (z) {
                    Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                    Activity activity = (Activity) weakReference.get();
                    if (decodeFile == null) {
                        Log.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
                    }
                    if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                        Log.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
                        AppMethodBeat.o(212202);
                        return;
                    }
                    WXImageObject wXImageObject = new WXImageObject(decodeFile);
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXImageObject;
                    SendMessageToWX.Req req = new SendMessageToWX.Req();
                    req.transaction = a.NR("img");
                    req.message = wXMediaMessage;
                    req.scene = 0;
                    a.a(activity, req);
                }
                AppMethodBeat.o(212202);
            }
        });
        AppMethodBeat.o(212203);
    }

    public static void a(Activity activity, ewy ewy) {
        AppMethodBeat.i(212204);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = ewy.rCq;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = ewy.title;
        wXMediaMessage.description = ewy.description;
        try {
            wXMediaMessage.thumbData = Base64.decode(ewy.Nur.zy, 0);
        } catch (Throwable th) {
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = NR("webpage");
        req.message = wXMediaMessage;
        req.scene = 0;
        a(activity, req);
        AppMethodBeat.o(212204);
    }

    static void a(Activity activity, SendMessageToWX.Req req) {
        AppMethodBeat.i(212205);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, "com.tencent.wework");
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        intent.putExtra(ConstantsAPI.CONTENT, "weixin://sendreq?appid=wx4706a9fcbbca10f2");
        intent.putExtra("SendAppMessageWrapper_BlockInvalidToken", false);
        intent.putExtra("SendAppMessageWrapper_NoNeedStayInWeixin", true);
        try {
            a(activity, req, intent.getExtras(), "com.tencent.wework");
            activity.overridePendingTransition(R.anim.eq, R.anim.t);
            AppMethodBeat.o(212205);
        } catch (Throwable th) {
            AppMethodBeat.o(212205);
        }
    }

    private static void a(Activity activity, SendMessageToWX.Req req, Bundle bundle, String str) {
        AppMethodBeat.i(212206);
        Intent intent = new Intent(activity, Class.forName("com.tencent.mm.ui.transmit.SelectConversationUI"));
        intent.putExtra("Select_Conv_NextStep", new Intent(activity, Class.forName("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI")).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", req.scene));
        intent.putExtra("Select_App_Id", str);
        intent.putExtra("Select_Open_Id", req.openId);
        intent.putExtra("Select_Conv_Type", 3);
        if (req.message.getType() == 36 || req.message.getType() == 46) {
            intent.putExtra("mutil_select_is_ret", !((WXMiniProgramObject) req.message.mediaObject).withShareTicket);
        } else {
            intent.putExtra("mutil_select_is_ret", true);
        }
        if (req.message.getType() == 45) {
            intent.putExtra("Select_Send_Card", true);
        }
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.er);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.t);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(212206);
    }

    static String NR(String str) {
        AppMethodBeat.i(212207);
        String concat = "com.tencent.wework.".concat(String.valueOf(str));
        AppMethodBeat.o(212207);
        return concat;
    }
}

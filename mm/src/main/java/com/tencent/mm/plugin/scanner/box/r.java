package com.tencent.mm.plugin.scanner.box;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JV\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanSendAppMsgHelper;", "", "()V", "TAG", "", "convertToAppMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "data", "Lorg/json/JSONObject;", "doSendAppMessage", "", "appMsg", "app", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "appId", "toUser", "imageUrl", "srcUsername", "srcDisplayName", "appendText", "plugin-scan_release"})
public final class r {
    public static final r CDy = new r();

    static {
        AppMethodBeat.i(240337);
        AppMethodBeat.o(240337);
    }

    private r() {
    }

    public static final WXMediaMessage bm(JSONObject jSONObject) {
        AppMethodBeat.i(240335);
        p.h(jSONObject, "data");
        String optString = jSONObject.optString("url");
        if (optString == null) {
            optString = "";
        }
        if (optString.length() == 0) {
            Log.e("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg fail, url is null");
            AppMethodBeat.o(240335);
            return null;
        }
        Log.i("MicroMsg.ScanSendAppMsgHelper", "convertToAppMsg url: %s", optString);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = optString;
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.o(240335);
        return wXMediaMessage;
    }

    public static boolean b(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        String str4;
        AppMethodBeat.i(240336);
        if (wXMediaMessage == null) {
            Log.e("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage appMsg is null");
            AppMethodBeat.o(240336);
            return false;
        }
        q.bcQ();
        Bitmap EP = d.EP(str2);
        if (EP != null && !EP.isRecycled()) {
            Log.i("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage thumbImage is not null");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
        }
        if (wXMediaMessage.mediaObject instanceof WXWebpageObject) {
            WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            if (iMediaObject == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXWebpageObject");
                AppMethodBeat.o(240336);
                throw tVar;
            }
            str4 = ((WXWebpageObject) iMediaObject).webpageUrl;
        } else {
            str4 = "";
        }
        tt ttVar = new tt();
        ttVar.eaf.dCE = wXMediaMessage;
        ttVar.eaf.appId = null;
        ttVar.eaf.appName = "";
        ttVar.eaf.toUser = str;
        ttVar.eaf.dMG = 2;
        ttVar.eaf.eag = null;
        ttVar.eaf.eah = null;
        ttVar.eaf.eaj = str4;
        ttVar.eaf.eak = str4;
        ttVar.eaf.eal = null;
        boolean publish = EventCenter.instance.publish(ttVar);
        if (!Util.isNullOrNil(str3)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str;
            twVar.eaq.content = str3;
            twVar.eaq.type = ab.JG(str);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        Log.d("MicroMsg.ScanSendAppMsgHelper", "doSendAppMessage result %b", Boolean.valueOf(publish));
        AppMethodBeat.o(240336);
        return publish;
    }
}

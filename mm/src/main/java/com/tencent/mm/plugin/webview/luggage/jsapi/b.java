package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public class b extends bs<g> {
    static /* synthetic */ void b(Context context, String str, String str2, br.a aVar) {
        AppMethodBeat.i(78516);
        a(context, str, str2, aVar);
        AppMethodBeat.o(78516);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "addToEmoticon";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(com.tencent.luggage.d.b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78514);
        Log.i("MicroMsg.JsApiAddToEmotion", "invoke");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            Log.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
            aVar.i("null_data", null);
            AppMethodBeat.o(78514);
            return;
        }
        String optString = Zc.optString("base64DataString");
        final String optString2 = Zc.optString("thumbUrl");
        final String optString3 = Zc.optString("url");
        if (!Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (Util.isNullOrNil(decode)) {
                    aVar.i("fail", null);
                    AppMethodBeat.o(78514);
                    return;
                }
                String messageDigest = com.tencent.mm.b.g.getMessageDigest(decode);
                a aVar2 = a.hdT;
                String W = EmojiLogic.W(a.awt(), "", messageDigest);
                if (!s.YS(W) || !s.bhK(W).equalsIgnoreCase(messageDigest)) {
                    s.f(W, decode, decode.length);
                }
                a(context, messageDigest, optString2, aVar);
                AppMethodBeat.o(78514);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + e2.getMessage());
                aVar.i("fail", null);
                AppMethodBeat.o(78514);
            }
        } else if (!Util.isNullOrNil(optString3)) {
            Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", optString3);
            o oVar = new o(context.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(optString3.getBytes()));
            if (oVar.exists()) {
                String bhK = s.bhK(aa.z(oVar.mUri));
                a aVar3 = a.hdT;
                String W2 = EmojiLogic.W(a.awt(), "", bhK);
                if (!s.YS(W2)) {
                    s.nw(aa.z(oVar.her()), W2);
                }
                a(context, bhK, optString2, aVar);
                AppMethodBeat.o(78514);
                return;
            }
            c.a aVar4 = new c.a();
            aVar4.jbf = true;
            aVar4.fullPath = aa.z(oVar.her());
            aVar4.jbE = new Object[]{aa.z(oVar.her())};
            k.cGc().a(optString3, (ImageView) null, aVar4.bdv(), new com.tencent.mm.av.a.c.k() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.b.AnonymousClass1 */

                @Override // com.tencent.mm.av.a.c.k
                public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.i(78513);
                    Log.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString3)) {
                        o oVar = new o(objArr[0].toString());
                        if (oVar.exists()) {
                            String bhK = s.bhK(aa.z(oVar.mUri));
                            a aVar = a.hdT;
                            s.nw(aa.z(oVar.her()), EmojiLogic.W(a.awt(), "", bhK));
                            b.b(context, bhK, optString2, aVar);
                            AppMethodBeat.o(78513);
                            return;
                        }
                    }
                    aVar.i("fail", null);
                    AppMethodBeat.o(78513);
                }
            });
            AppMethodBeat.o(78514);
        } else {
            Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            aVar.i("base64DataString_and_url_is_null", null);
            AppMethodBeat.o(78514);
        }
    }

    private static void a(Context context, String str, String str2, br.a aVar) {
        AppMethodBeat.i(78515);
        a aVar2 = a.hdT;
        String W = EmojiLogic.W(a.awt(), "", str);
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(str);
        if (blk == null && s.YS(W)) {
            int i2 = ImgUtil.isGif(W) ? EmojiInfo.VkY : EmojiInfo.VkX;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = (int) s.boW(W);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            k.getEmojiStorageMgr().OpN.J(emojiInfo);
            blk = emojiInfo;
        }
        if (blk != null) {
            boolean a2 = k.cGf().a(context, blk, 18, z.aTY());
            Log.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", Boolean.valueOf(a2));
            if (a2) {
                aVar.i(null, null);
                AppMethodBeat.o(78515);
                return;
            }
            aVar.i("fail", null);
            AppMethodBeat.o(78515);
            return;
        }
        aVar.i("fail", null);
        AppMethodBeat.o(78515);
    }
}

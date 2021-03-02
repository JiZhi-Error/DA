package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public class bl extends bs<g> {
    static /* synthetic */ void a(bl blVar, Context context, String str, br.a aVar) {
        AppMethodBeat.i(78633);
        blVar.b(context, str, aVar);
        AppMethodBeat.o(78633);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "shareEmoticon";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78631);
        Log.i("MicroMsg.JsApiShareEmotion", "invoke");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            Log.e("MicroMsg.JsApiShareEmotion", "data is null");
            aVar.i("null_data", null);
            AppMethodBeat.o(78631);
            return;
        }
        String optString = Zc.optString("base64DataString");
        final String optString2 = Zc.optString("url");
        if (!Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (Util.isNullOrNil(decode)) {
                    aVar.i("fail", null);
                    AppMethodBeat.o(78631);
                    return;
                }
                String messageDigest = com.tencent.mm.b.g.getMessageDigest(decode);
                a aVar2 = a.hdT;
                String W = EmojiLogic.W(a.awt(), "", messageDigest);
                if (!s.YS(W) || !s.bhK(W).equalsIgnoreCase(messageDigest)) {
                    s.f(W, decode, decode.length);
                }
                b(context, messageDigest, aVar);
                AppMethodBeat.o(78631);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + e2.getMessage());
                aVar.i("base64_decode_fail", null);
                AppMethodBeat.o(78631);
            }
        } else {
            Log.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", optString2);
            o oVar = new o(context.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(optString2.getBytes()));
            if (oVar.exists()) {
                String bhK = s.bhK(aa.z(oVar.mUri));
                a aVar3 = a.hdT;
                String W2 = EmojiLogic.W(a.awt(), "", bhK);
                if (!s.YS(W2)) {
                    s.nw(aa.z(oVar.her()), W2);
                }
                b(context, bhK, aVar);
                AppMethodBeat.o(78631);
                return;
            }
            c.a aVar4 = new c.a();
            aVar4.jbf = true;
            aVar4.fullPath = aa.z(oVar.her());
            aVar4.jbE = new Object[]{aa.z(oVar.her())};
            k.cGc().a(optString2, (ImageView) null, aVar4.bdv(), new com.tencent.mm.av.a.c.k() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.bl.AnonymousClass1 */

                @Override // com.tencent.mm.av.a.c.k
                public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.i(78629);
                    Log.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString2)) {
                        o oVar = new o(objArr[0].toString());
                        if (oVar.exists()) {
                            String bhK = s.bhK(aa.z(oVar.mUri));
                            a aVar = a.hdT;
                            s.nw(aa.z(oVar.her()), EmojiLogic.W(a.awt(), "", bhK));
                            bl.a(bl.this, context, bhK, aVar);
                            AppMethodBeat.o(78629);
                            return;
                        }
                    }
                    aVar.i("fail", null);
                    AppMethodBeat.o(78629);
                }
            });
            AppMethodBeat.o(78631);
        }
    }

    private void b(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78632);
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        if (context instanceof MMActivity) {
            ((MMActivity) context).mmSetOnActivityResultCallback(new MMActivity.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.bl.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:17:0x00c3  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00e4  */
                @Override // com.tencent.mm.ui.MMActivity.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void d(int r12, int r13, android.content.Intent r14) {
                    /*
                    // Method dump skipped, instructions count: 304
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.bl.AnonymousClass2.d(int, int, android.content.Intent):void");
                }
            });
            com.tencent.mm.br.c.c(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & 65535);
        }
        AppMethodBeat.o(78632);
    }
}

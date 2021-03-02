package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

public final class j {
    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(108530);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i2);
        String JX = ad.JX("emoje_stroe");
        ad.aVe().G(JX, true).l("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", JX);
        c.c(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(108530);
    }

    public static void eY(Context context) {
        AppMethodBeat.i(108531);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        c.c(context, ".ui.transmit.SelectConversationUI", intent, 2002);
        AppMethodBeat.o(108531);
    }

    public static void a(final MMActivity mMActivity, final String str, final int i2, final int i3, final String str2, final String str3, final String str4, final String str5, final int i4, final String str6) {
        AppMethodBeat.i(108533);
        ((com.tencent.mm.pluginsdk.j) g.af(com.tencent.mm.pluginsdk.j.class)).b(mMActivity.getController(), str2, str4, str3, "", mMActivity.getString(R.string.yq), new y.a() {
            /* class com.tencent.mm.plugin.emoji.e.j.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(108529);
                if (z) {
                    String str2 = str;
                    int i3 = i2;
                    int i4 = i3;
                    String str3 = str2;
                    String str4 = str3;
                    String str5 = str4;
                    String str6 = str5;
                    int i5 = i4;
                    String str7 = str6;
                    Log.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.title = str3;
                    wXMediaMessage.description = str4;
                    WXEmojiPageSharedObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
                    wXEmojiPageSharedObject.type = i3;
                    wXEmojiPageSharedObject.tid = i4;
                    wXEmojiPageSharedObject.title = str3;
                    wXEmojiPageSharedObject.desc = str4;
                    wXEmojiPageSharedObject.iconUrl = str5;
                    wXEmojiPageSharedObject.secondUrl = str6;
                    wXEmojiPageSharedObject.pageType = i5;
                    wXEmojiPageSharedObject.url = str7;
                    wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
                    q.bcQ();
                    Bitmap EP = d.EP(str5);
                    if (EP != null && !EP.isRecycled()) {
                        Log.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    tt ttVar = new tt();
                    ttVar.eaf.dCE = wXMediaMessage;
                    ttVar.eaf.toUser = str2;
                    ttVar.eaf.dMG = 49;
                    ttVar.eaf.eag = str2;
                    ttVar.eaf.eah = "";
                    EventCenter.instance.publish(ttVar);
                    if (!TextUtils.isEmpty(str)) {
                        tw twVar = new tw();
                        twVar.eaq.dkV = str2;
                        twVar.eaq.content = str;
                        twVar.eaq.type = ab.JG(str2);
                        twVar.eaq.flags = 0;
                        EventCenter.instance.publish(twVar);
                    }
                    h.cD(mMActivity, mMActivity.getString(R.string.z0));
                    AppMethodBeat.o(108529);
                    return;
                }
                AppMethodBeat.o(108529);
            }
        });
        AppMethodBeat.o(108533);
    }
}

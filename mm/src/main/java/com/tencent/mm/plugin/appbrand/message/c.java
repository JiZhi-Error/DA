package com.tencent.mm.plugin.appbrand.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.b;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.ac.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

public class c implements l {
    @Override // com.tencent.mm.modelappbrand.l
    public final CharSequence a(String str, Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(47709);
        final b HM = b.HM(str);
        Context context = weakReference.get();
        if (context == null) {
            Log.w("MicroMsg.WxaSubscribeMsgService", "context is null");
            AppMethodBeat.o(47709);
            return null;
        }
        String str2 = HM.content;
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
            AppMethodBeat.o(47709);
            return null;
        }
        final String string = bundle.getString("conv_talker_username");
        final int i2 = bundle.getInt("scene");
        final long j2 = bundle.getLong("msg_sever_id");
        final String string2 = bundle.getString("send_msg_username");
        final SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new a() {
            /* class com.tencent.mm.plugin.appbrand.message.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                byte[] decode;
                AppMethodBeat.i(47706);
                Log.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", HM.content, HM.username, HM.path, string);
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i2);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j2));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1088;
                appBrandStatObject.dCw = "";
                appBrandStatObject.ecU = m.k(appBrandStatObject.scene, bundle);
                appBrandStatObject.ecV = m.l(appBrandStatObject.scene, bundle);
                String str = "";
                if (!(HM.path == null || HM.path.length() <= 0 || (decode = Base64.decode(HM.path, 2)) == null)) {
                    str = new String(decode);
                }
                ((r) g.af(r.class)).a(view.getContext(), HM.username, (String) null, HM.type, 0, str, appBrandStatObject);
                ((q) g.af(q.class)).a(HM.username, new q.a() {
                    /* class com.tencent.mm.plugin.appbrand.message.c.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.service.q.a
                    public final void b(WxaAttributes wxaAttributes) {
                        no.c cVar;
                        AppMethodBeat.i(47705);
                        com.tencent.mm.ag.a.c Lq = ((com.tencent.mm.modelappbrand.m) g.af(com.tencent.mm.modelappbrand.m.class)).Lq(HM.cyr);
                        no.d dVar = no.d.DEFAULT;
                        no.e eVar = no.e.DEFAULT;
                        if (Lq != null) {
                            if (Lq.field_msgState == 1) {
                                dVar = no.d.DONE;
                            } else if (Lq.field_msgState == 0) {
                                dVar = no.d.DOING;
                            }
                            if (Lq.field_btnState == 2) {
                                eVar = no.e.SUBSCRIBE;
                            } else if (Lq.field_btnState == 0 || Lq.field_btnState == 1) {
                                eVar = no.e.NOTSUBSCRIBE;
                            }
                        }
                        int i2 = wxaAttributes.bAn() == null ? 0 : wxaAttributes.bAn().serviceType;
                        no AM = new no().AJ(HM.appId).AK(HM.path).AL(HM.path).AM(string);
                        if (string.toLowerCase().endsWith("@chatroom")) {
                            cVar = no.c.YES;
                        } else {
                            cVar = no.c.NO;
                        }
                        AM.fhy = cVar;
                        AM.fhz = no.b.CLICKSTARTGAME;
                        AM.erW = 0;
                        no AN = AM.AN("");
                        AN.fhD = no.a.mX(i2 + 1000);
                        no ajq = AN.ajq();
                        ajq.fhB = dVar;
                        ajq.fhC = eVar;
                        ajq.bfK();
                        AppMethodBeat.o(47705);
                    }
                });
                AppMethodBeat.o(47706);
            }
        }, str2.indexOf(HM.title), str2.indexOf(HM.title) + HM.title.length(), 17);
        Log.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", Integer.valueOf(HM.iBe));
        if (HM.iBe == 1) {
            AppMethodBeat.o(47709);
            return spannableString;
        }
        WxaAttributes Xk = ((q) g.af(q.class)).Xk(HM.username);
        String str3 = Xk != null ? Xk.field_brandIconURL : "";
        Bitmap a2 = com.tencent.mm.modelappbrand.a.b.aXY().a(str3, (b.f) null);
        if (a2 == null) {
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                /* class com.tencent.mm.plugin.appbrand.message.c.AnonymousClass2 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(47707);
                    NeatTextView neatTextView = (NeatTextView) weakReference2.get();
                    Context context = (Context) weakReference.get();
                    if (!(context == null || neatTextView == null)) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
                        bitmapDrawable.setBounds(0, 0, o.zE(16), o.zE(16));
                        com.tencent.mm.plugin.appbrand.widget.h.b bVar = new com.tencent.mm.plugin.appbrand.widget.h.b(bitmapDrawable);
                        SpannableString spannableString = new SpannableString("@ ");
                        spannableString.setSpan(bVar, 0, 1, 33);
                        neatTextView.aw(TextUtils.concat(spannableString, spannableString));
                        neatTextView.invalidate();
                    }
                    AppMethodBeat.o(47707);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    AppMethodBeat.i(47708);
                    String simpleName = c.class.getSimpleName();
                    AppMethodBeat.o(47708);
                    return simpleName;
                }
            }, str3, (b.h) null);
            CharSequence concat = TextUtils.concat(a(context, HM.iBf, null), spannableString);
            AppMethodBeat.o(47709);
            return concat;
        }
        CharSequence concat2 = TextUtils.concat(a(context, HM.iBf, a2), spannableString);
        AppMethodBeat.o(47709);
        return concat2;
    }

    private static SpannableString a(Context context, int i2, Bitmap bitmap) {
        Drawable bitmapDrawable;
        AppMethodBeat.i(47710);
        if (bitmap == null) {
            bitmapDrawable = context.getResources().getDrawable(i2 == 1 ? R.raw.spannable_wxa_game_link_logo : R.raw.spannable_app_brand_link_logo);
        } else {
            bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        bitmapDrawable.setBounds(0, 0, o.zE(16), o.zE(16));
        com.tencent.mm.plugin.appbrand.widget.h.b bVar = new com.tencent.mm.plugin.appbrand.widget.h.b(bitmapDrawable);
        SpannableString spannableString = new SpannableString("@ ");
        spannableString.setSpan(bVar, 0, 1, 33);
        AppMethodBeat.o(47710);
        return spannableString;
    }
}

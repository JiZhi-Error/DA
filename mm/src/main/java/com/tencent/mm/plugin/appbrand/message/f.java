package com.tencent.mm.plugin.appbrand.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.h.b;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class f implements e.b {
    @Override // com.tencent.mm.plugin.messenger.a.e.b
    public final CharSequence a(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(227198);
        if (map == null || map.isEmpty()) {
            Log.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
            AppMethodBeat.o(227198);
            return null;
        }
        Context context = weakReference.get();
        if (context == null) {
            Log.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
            AppMethodBeat.o(227198);
            return null;
        }
        final String str2 = map.get(str + ".title");
        final String str3 = map.get(str + ".username");
        final int i2 = Util.getInt(map.get(str + ".type"), 0);
        int i3 = Util.getInt(map.get(str + ".wxaapp_type"), 0);
        final String str4 = map.get(str + ".path");
        boolean z = Util.getInt(map.get(new StringBuilder().append(str).append(".forbids").toString()), 0) == 1;
        final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
        final int i4 = bundle != null ? bundle.getInt("scene") : 0;
        final long j2 = bundle != null ? bundle.getLong("msg_sever_id") : 0;
        final String string2 = bundle != null ? bundle.getString("send_msg_username") : "";
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
            AppMethodBeat.o(227198);
            return null;
        }
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new a() {
            /* class com.tencent.mm.plugin.appbrand.message.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                byte[] decode;
                AppMethodBeat.i(47716);
                Log.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
                weakReference.get();
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i4);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j2));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1088;
                appBrandStatObject.dCw = "";
                appBrandStatObject.ecU = m.k(appBrandStatObject.scene, bundle);
                appBrandStatObject.ecV = m.l(appBrandStatObject.scene, bundle);
                String str = "";
                if (!(str4 == null || str4.length() <= 0 || (decode = Base64.decode(str4, 2)) == null)) {
                    str = new String(decode);
                }
                ((r) g.af(r.class)).a(view.getContext(), str3, (String) null, i2, 0, str, appBrandStatObject);
                ((e) g.af(e.class)).a("link_view_wxapp", map, bundle);
                AppMethodBeat.o(47716);
            }
        }, 0, str2.length(), 17);
        Log.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
        if (z || i3 == 2) {
            AppMethodBeat.o(227198);
            return spannableString;
        }
        int i5 = R.raw.spannable_app_brand_link_logo;
        switch (i3) {
            case 1:
                i5 = R.raw.spannable_wxa_game_link_logo;
                break;
        }
        Drawable drawable = context.getResources().getDrawable(i5);
        drawable.setBounds(0, 0, o.zE(16), o.zE(16));
        b bVar = new b(drawable);
        SpannableString spannableString2 = new SpannableString("@ ");
        spannableString2.setSpan(bVar, 0, 1, 33);
        CharSequence concat = TextUtils.concat(spannableString2, spannableString);
        AppMethodBeat.o(227198);
        return concat;
    }
}

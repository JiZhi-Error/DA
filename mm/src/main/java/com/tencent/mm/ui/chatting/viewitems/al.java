package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;

public final class al {
    public static void b(TextView textView, k.b bVar) {
        AppMethodBeat.i(169879);
        if (textView == null) {
            AppMethodBeat.o(169879);
        } else if (bVar == null) {
            Log.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
            textView.setText("");
            AppMethodBeat.o(169879);
        } else {
            e eVar = (e) bVar.as(e.class);
            if (eVar == null || eVar.iwf != 1) {
                textView.setText("");
                AppMethodBeat.o(169879);
                return;
            }
            textView.setText(Util.nullAsNil(textView.getContext().getString(R.string.f3t)));
            AppMethodBeat.o(169879);
        }
    }

    public static void a(final Context context, k.b bVar, ImageView imageView, final TextView textView) {
        i Mx;
        AppMethodBeat.i(37175);
        if (context == null || bVar == null || imageView == null || textView == null) {
            Log.i("MicroMsg.ChattingItemBizUtils", "param null");
            AppMethodBeat.o(37175);
            return;
        }
        if (Util.isNullOrNil(bVar.eag)) {
            Log.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
        }
        if (ab.IT(bVar.eag)) {
            a.b.d(imageView, bVar.eag);
        } else {
            a.b.d(imageView, " ");
            imageView.setImageResource(R.drawable.bar);
        }
        textView.setText(l.b(context, "", textView.getTextSize()));
        imageView.setVisibility(0);
        textView.setVisibility(0);
        String displayName = aa.getDisplayName(bVar.eag);
        String str = !Util.isNullOrNil(displayName) ? displayName : bVar.eag;
        imageView.setTag(bVar.eag);
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(bVar.eag);
        if (!Util.isNullOrNil(bVar.eag) && (Kn == null || ((int) Kn.gMZ) <= 0)) {
            imageView.setTag(bVar.eag);
            final WeakReference weakReference = new WeakReference(imageView);
            ay.a.iDq.a(bVar.eag, "", new ay.b.a() {
                /* class com.tencent.mm.ui.chatting.viewitems.al.AnonymousClass1 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(37172);
                    if (weakReference == null) {
                        AppMethodBeat.o(37172);
                        return;
                    }
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView == null) {
                        AppMethodBeat.o(37172);
                        return;
                    }
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                    String str2 = (String) imageView.getTag();
                    if (Kn == null || ((int) Kn.gMZ) <= 0 || !(imageView.getTag() instanceof String) || !ab.IT(str) || !Util.isEqual(str2, str)) {
                        textView.setText(l.b(context, context.getResources().getString(R.string.agp), textView.getTextSize()));
                        AppMethodBeat.o(37172);
                        return;
                    }
                    i Mx = p.aYB().Mx(str);
                    if (Mx == null || Util.isNullOrNil(Mx.aYu())) {
                        a.b.d(imageView, str);
                    } else {
                        d.a(imageView, Kn, Mx.aYu(), true);
                    }
                    textView.setText(l.b(context, aa.getDisplayName(str), textView.getTextSize()));
                    AppMethodBeat.o(37172);
                }
            });
            AppMethodBeat.o(37175);
        } else if (ab.IT(bVar.eag)) {
            if (!c.oR(Kn.field_type) && com.tencent.mm.aj.c.a(bVar.eag, false, -1, null) == null && (Mx = p.aYB().Mx(bVar.eag)) != null && !Util.isNullOrNil(Mx.aYu())) {
                d.a(imageView, Kn, Mx.aYu(), true);
            }
            textView.setText(l.b(context, str, textView.getTextSize()));
            AppMethodBeat.o(37175);
        } else {
            textView.setText(l.b(context, context.getResources().getString(R.string.agp), textView.getTextSize()));
            AppMethodBeat.o(37175);
        }
    }

    public static boolean a(k.b bVar, e eVar) {
        AppMethodBeat.i(233821);
        if (eVar == null || bVar == null) {
            AppMethodBeat.o(233821);
            return false;
        } else if (Util.isNullOrNil(bVar.eag)) {
            AppMethodBeat.o(233821);
            return false;
        } else if (!((b) g.af(b.class)).isMpUrl(bVar.url)) {
            AppMethodBeat.o(233821);
            return false;
        } else if (eVar.iwc >= 0) {
            AppMethodBeat.o(233821);
            return true;
        } else if (eVar.iwj == 1) {
            AppMethodBeat.o(233821);
            return true;
        } else {
            AppMethodBeat.o(233821);
            return false;
        }
    }
}

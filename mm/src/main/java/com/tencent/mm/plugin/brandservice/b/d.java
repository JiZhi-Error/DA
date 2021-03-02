package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.List;

public final class d {
    private static MMHandler iuH = new MMHandler(Looper.getMainLooper());

    public static class a {
        public ImageView gvv;
        public String iconUrl;
        public String username;
    }

    static {
        AppMethodBeat.i(5566);
        AppMethodBeat.o(5566);
    }

    public static c a(c cVar, aer aer) {
        if (aer != null) {
            cVar.field_brandFlag = aer.kem;
            cVar.field_brandIconURL = aer.kep;
            cVar.field_brandInfo = aer.keo;
            cVar.field_extInfo = aer.ken;
        }
        return cVar;
    }

    public static Spanned c(Context context, String str, List<String> list) {
        AppMethodBeat.i(5563);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(5563);
            return null;
        } else if (context == null || list == null) {
            SpannableString spannableString = new SpannableString(str);
            AppMethodBeat.o(5563);
            return spannableString;
        } else {
            f a2 = com.tencent.mm.plugin.fts.a.f.a(e.a(str, list));
            if (a2.wWu instanceof Spannable) {
                Spannable spannable = (Spannable) a2.wWu;
                AppMethodBeat.o(5563);
                return spannable;
            }
            SpannableString spannableString2 = new SpannableString(a2.wWu);
            AppMethodBeat.o(5563);
            return spannableString2;
        }
    }

    public static boolean c(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(5564);
        if (textView == null) {
            AppMethodBeat.o(5564);
            return false;
        } else if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(5564);
            return false;
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
            AppMethodBeat.o(5564);
            return true;
        }
    }

    public static void a(ImageView imageView, as asVar, String str, boolean z) {
        AppMethodBeat.i(5565);
        if (z || !com.tencent.mm.contact.c.oR(asVar.field_type)) {
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.bar;
            aVar.jbe = true;
            aVar.iaT = true;
            q.bcV().a(str, imageView, aVar.bdv());
            AppMethodBeat.o(5565);
            return;
        }
        a.b.d(imageView, asVar.field_username);
        AppMethodBeat.o(5565);
    }
}

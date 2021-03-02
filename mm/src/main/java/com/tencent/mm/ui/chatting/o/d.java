package com.tencent.mm.ui.chatting.o;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d extends b {
    public d(b.AbstractC1472b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "link_revoke_qrcode";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(233528);
        String str2 = map.get(str + ".title");
        final b.a aVar = new b.a();
        aVar.username = map.get(str + ".username");
        aVar.link = map.get(str + ".qrcode");
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new a() {
            /* class com.tencent.mm.ui.chatting.o.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                AppMethodBeat.i(233527);
                d dVar = d.this;
                b.a aVar = aVar;
                if (!(dVar.zqO == null || dVar.zqO.get() == null)) {
                    dVar.zqO.get().a(view, aVar);
                }
                ((e) g.af(e.class)).a("link_revoke_qrcode", map, bundle);
                AppMethodBeat.o(233527);
            }
        }, 0, str2.length(), 33);
        AppMethodBeat.o(233528);
        return spannableString;
    }
}

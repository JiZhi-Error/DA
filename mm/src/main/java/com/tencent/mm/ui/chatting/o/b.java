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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class b extends com.tencent.mm.plugin.messenger.d.b {
    public b(b.AbstractC1472b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "link_revoke";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(233520);
        String str2 = map.get(str + ".title");
        final LinkedList linkedList = new LinkedList();
        int i2 = 0;
        while (true) {
            String str3 = str + ".usernamelist.username";
            if (i2 != 0) {
                str3 = str3 + i2;
            }
            String str4 = map.get(str3);
            if (!Util.isNullOrNil(str4)) {
                linkedList.add(str4);
                i2++;
            } else {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new a() {
                    /* class com.tencent.mm.ui.chatting.o.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.messenger.a.a
                    public final void onClickImp(View view) {
                        AppMethodBeat.i(233519);
                        b.this.a(bundle.getLong("msg_id"), linkedList, 1);
                        ((e) g.af(e.class)).a("link_revoke", map, bundle);
                        AppMethodBeat.o(233519);
                    }
                }, 0, str2.length(), 33);
                AppMethodBeat.o(233520);
                return spannableString;
            }
        }
    }
}

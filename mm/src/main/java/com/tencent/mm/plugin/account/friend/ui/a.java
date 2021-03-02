package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class a implements View.OnClickListener {
    private Context context;
    private AbstractC0521a kgk;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC0521a {
        void Tj(String str);

        void ae(String str, boolean z);
    }

    public static class b {
        public int kgm;
        public int position;
        public String username;
    }

    public a(Context context2, AbstractC0521a aVar) {
        this.context = context2;
        this.kgk = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(131173);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        b bVar2 = (b) view.getTag();
        final String str = bVar2.username;
        int i2 = bVar2.kgm;
        final int i3 = bVar2.position;
        final as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Util.isNullOrNil(Kn.field_username)) {
            Kn.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new a.AbstractC2025a() {
            /* class com.tencent.mm.plugin.account.friend.ui.a.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
            public final void a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.i(131172);
                if (z) {
                    a.P(Kn);
                    a.this.kgk.Tj(str);
                    AppMethodBeat.o(131172);
                    return;
                }
                a.this.kgk.ae(str, z2);
                AppMethodBeat.o(131172);
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(Integer.valueOf(i2));
        aVar.h(str, linkedList);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(131173);
    }

    static /* synthetic */ void P(as asVar) {
        AppMethodBeat.i(131174);
        if (((int) asVar.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(asVar);
            if (!Util.isNullOrNil(asVar.field_username)) {
                asVar = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
            }
            AppMethodBeat.o(131174);
        }
        if (((int) asVar.gMZ) <= 0) {
            Log.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
            AppMethodBeat.o(131174);
            return;
        }
        ab.B(asVar);
        AppMethodBeat.o(131174);
    }
}

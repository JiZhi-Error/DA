package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.v;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.ba;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class bl implements ba.a {
    bl() {
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.ba.a
    public final void b(c.a aVar, int i2, a aVar2, ca caVar) {
        String str;
        int i3;
        Bundle bundle;
        AppMethodBeat.i(37550);
        String talkerUserName = aVar2.getTalkerUserName();
        ba.b bVar = (ba.b) aVar;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", talkerUserName);
        if (aVar2.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) {
            str = "scene";
            i3 = 10;
            bundle = bundle2;
        } else if (aVar2.gRM()) {
            str = "scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (ab.IT(talkerUserName)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i3);
        bundle2.putLong("msg_id", caVar.field_msgId);
        bundle2.putLong("msg_sever_id", caVar.field_msgSvrId);
        bundle2.putString("send_msg_username", caVar.field_talker);
        CharSequence a2 = ((l) g.af(l.class)).a(caVar.field_content, bundle2, new WeakReference<>(aVar2.Pwc.getContext()), new WeakReference<>(bVar.POM));
        if (a2 == null || a2.length() == 0) {
            bVar.convertView.setVisibility(8);
        } else {
            bVar.convertView.setVisibility(0);
            bVar.POM.aw(a2);
        }
        com.tencent.mm.bb.a Pp = v.bew().Pp(talkerUserName);
        bg.aVF();
        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(12311, (Object) -2)).intValue();
        if ((Pp == null || Pp.jgE == -2) && (Pp != null || intValue == -2)) {
            bVar.POM.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.FG_2));
            bVar.POM.setBackground(aVar2.Pwc.getContext().getResources().getDrawable(R.drawable.mr));
        } else {
            bVar.POM.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.jg));
            bVar.POM.setBackground(aVar2.Pwc.getContext().getResources().getDrawable(R.drawable.ms));
        }
        bVar.POM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.bl.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37549);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.ChattingItemWxaSubscribeSysImpl", "hy: textview clicked");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37549);
            }
        });
        bVar.POM.invalidate();
        AppMethodBeat.o(37550);
    }
}

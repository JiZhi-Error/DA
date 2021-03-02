package com.tencent.mm.chatroom.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.SeeRoomManagerUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a implements e.b {
    public com.tencent.mm.chatroom.e.a grL = new com.tencent.mm.chatroom.e.a();

    public a() {
        AppMethodBeat.i(12445);
        AppMethodBeat.o(12445);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e.b
    public final CharSequence a(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(194011);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = map.get(str + ".title");
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(194011);
            return "";
        }
        SpannableString c2 = l.c(MMApplicationContext.getContext(), str2);
        c2.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            /* class com.tencent.mm.chatroom.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                AppMethodBeat.i(12444);
                if (!(weakReference == null || weakReference.get() == null)) {
                    String string = bundle.getString("conv_talker_username");
                    Context context = (Context) weakReference.get();
                    Intent intent = new Intent(context, SeeRoomManagerUI.class);
                    intent.setFlags(32768);
                    intent.putExtra("RoomInfo_Id", string);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/chatroom/manager/ChatroomNewXmlMgr$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/chatroom/manager/ChatroomNewXmlMgr$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((e) g.af(e.class)).a("link_admin_explain", map, bundle);
                }
                AppMethodBeat.o(12444);
            }
        }, 0, str2.length(), 33);
        spannableStringBuilder.append((CharSequence) c2);
        AppMethodBeat.o(194011);
        return spannableStringBuilder;
    }
}

package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.o;

@a(gRF = o.class)
public class q extends a implements o {
    private String PoN;

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(233090);
        super.gIk();
        this.PoN = this.dom.Pwc.getStringExtra("key_notify_message_real_username");
        if (!gPo()) {
            AppMethodBeat.o(233090);
        } else {
            AppMethodBeat.o(233090);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.o
    public final void j(LinearLayout linearLayout) {
        AppMethodBeat.i(233091);
        if (!gPo()) {
            AppMethodBeat.o(233091);
        } else if (Util.isNullOrNil(this.PoN)) {
            Log.e("MicroMsg.ChattingServiceNotifyComponent", "username is null");
            AppMethodBeat.o(233091);
        } else {
            final boolean HF = as.HF(this.PoN);
            final Activity context = this.dom.Pwc.getContext();
            View findViewById = linearLayout.findViewById(R.id.axv);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gih);
            TextView textView = (TextView) linearLayout.findViewById(R.id.gk0);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.gkv);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.q.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233089);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (HF) {
                            q.a(q.this, context);
                        } else {
                            q.b(q.this, context);
                        }
                        h.INSTANCE.a(21825, 6, q.this.PoN, Long.valueOf(Util.nowSecond()), null, null, 0, 0, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233089);
                    }
                });
            }
            if (imageView != null) {
                a.b.d(imageView, this.PoN);
            }
            String str = "";
            if (textView != null) {
                if (HF) {
                    ae Xr = y.Xr(this.PoN);
                    if (Xr != null) {
                        str = Xr.nickname;
                    }
                } else {
                    str = aa.getDisplayName(this.PoN);
                }
                textView.setText(aa.getDisplayName(str));
            }
            if (textView2 != null) {
                textView2.setText(HF ? context.getString(R.string.a0f) : context.getString(R.string.dje));
            }
            AppMethodBeat.o(233091);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.o
    public final boolean gPG() {
        AppMethodBeat.i(233092);
        if (!gPo()) {
            AppMethodBeat.o(233092);
            return false;
        }
        ((com.tencent.mm.ui.chatting.d.b.aa) this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQs();
        AppMethodBeat.o(233092);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.o
    public final boolean gPH() {
        AppMethodBeat.i(233093);
        boolean gPo = gPo();
        AppMethodBeat.o(233093);
        return gPo;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.o
    public final String gPI() {
        return this.PoN;
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(233094);
        super.onActivityResult(i2, i3, intent);
        if (!gPo()) {
            AppMethodBeat.o(233094);
            return;
        }
        if (i2 == 100 && intent != null) {
            Log.i("MicroMsg.ChattingServiceNotifyComponent", "receive data from subscribe msg");
            SubscribeMsgSettingData subscribeMsgSettingData = (SubscribeMsgSettingData) intent.getParcelableExtra("key_biz_data");
            if (subscribeMsgSettingData != null) {
                c cVar = c.jDh;
                c.a(this.PoN, subscribeMsgSettingData, new aj(this.dom.Pwc.getContext(), this.PoN));
            }
        }
        AppMethodBeat.o(233094);
    }

    private boolean gPo() {
        AppMethodBeat.i(233095);
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(233095);
            return false;
        } else if (!ab.Jx(this.dom.getTalkerUserName()) || Util.isNullOrNil(this.PoN)) {
            AppMethodBeat.o(233095);
            return false;
        } else {
            AppMethodBeat.o(233095);
            return true;
        }
    }

    static /* synthetic */ void a(q qVar, Context context) {
        AppMethodBeat.i(233096);
        AppBrandProfileUI.a(context, qVar.PoN, 5, null, null, null);
        AppMethodBeat.o(233096);
    }

    static /* synthetic */ void b(q qVar, Context context) {
        AppMethodBeat.i(233097);
        Intent intent = new Intent();
        intent.setClass(context, ContactInfoUI.class);
        intent.putExtra("Contact_User", qVar.PoN);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent", "startContactUIActivity", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent", "startContactUIActivity", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(233097);
    }
}

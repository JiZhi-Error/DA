package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class z extends LinearLayout {
    private String PYe;
    private Context context;

    public z(Context context2, String str) {
        super(context2);
        AppMethodBeat.i(37933);
        this.context = context2;
        this.PYe = str;
        View inflate = View.inflate(getContext(), R.layout.bh4, this);
        View findViewById = findViewById(R.id.c45);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.z.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37931);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(view.getContext())) {
                    a.a(this, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37931);
                    return;
                }
                Context context = view.getContext();
                Intent intent = new Intent(context, OpenIMAddressUI.class);
                intent.addFlags(67108864);
                intent.putExtra("key_openim_acctype_id", z.this.PYe);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/ui/contact/OpenIMListViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37931);
            }
        });
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.z.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37932);
                if (z.this.context instanceof MMActivity) {
                    ((MMActivity) z.this.context).hideVKB();
                }
                AppMethodBeat.o(37932);
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.id.a5a);
        ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).b(this.PYe, "openim_acct_type_icon", a.EnumC0497a.TYPE_URL);
        if (this.PYe.equals("cloudim")) {
            ((ImageView) maskLayout.getContentView()).setImageResource(R.raw.avatar_wechat_frame);
        }
        ((TextView) findViewById(R.id.c46)).setText(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).b(this.PYe, "openim_acct_type_title", a.EnumC0497a.TYPE_WORDING));
        AppMethodBeat.o(37933);
    }
}

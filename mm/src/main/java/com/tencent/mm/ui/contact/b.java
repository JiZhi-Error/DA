package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View jxm = null;
    private View kgo = null;

    public enum a {
        Chatromm,
        ContactLabel,
        ContactIpCall,
        OnlyChat;

        public static a valueOf(String str) {
            AppMethodBeat.i(37652);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(37652);
            return aVar;
        }

        static {
            AppMethodBeat.i(37653);
            AppMethodBeat.o(37653);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public b(Context context2, final a aVar) {
        super(context2);
        AppMethodBeat.i(37654);
        this.context = context2;
        View.inflate(getContext(), R.layout.ch, this);
        this.jxm = findViewById(R.id.be3);
        this.kgo = this.jxm.findViewById(R.id.hv);
        ViewGroup.LayoutParams layoutParams = this.kgo.getLayoutParams();
        layoutParams.height = (int) (((float) com.tencent.mm.cb.a.aH(this.context, R.dimen.az)) * com.tencent.mm.cb.a.jj(this.context));
        this.kgo.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.kgo.findViewById(R.id.hx);
        this.jxm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37648);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (AnonymousClass3.PTo[aVar.ordinal()]) {
                    case 1:
                        Intent intent = new Intent();
                        intent.setClassName(b.this.context, "com.tencent.mm.ui.contact.ChatroomContactUI");
                        Context context = b.this.context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    case 2:
                        c.b(b.this.context, "label", ".ui.ContactLabelManagerUI", new Intent());
                        break;
                    case 3:
                        c.b(b.this.context, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        break;
                    case 4:
                        Intent intent2 = new Intent(b.this.context, OnlyChatContactMgrUI.class);
                        Context context2 = b.this.context;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context2.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    default:
                        Log.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", aVar);
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37648);
            }
        });
        this.kgo.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.b.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37649);
                if (b.this.context instanceof MMActivity) {
                    ((MMActivity) b.this.context).hideVKB();
                }
                AppMethodBeat.o(37649);
                return false;
            }
        });
        ImageView imageView = (ImageView) ((MaskLayout) this.kgo.findViewById(R.id.hw)).getContentView();
        switch (aVar) {
            case Chatromm:
                this.contentView.setText(R.string.e6);
                e.a(getContext(), imageView, (int) R.raw.default_chatroom);
                AppMethodBeat.o(37654);
                return;
            case ContactLabel:
                this.contentView.setText(R.string.e_);
                e.a(getContext(), imageView, (int) R.raw.default_contactlabel);
                AppMethodBeat.o(37654);
                return;
            case ContactIpCall:
                this.kgo.setBackgroundResource(R.drawable.qa);
                this.contentView.setText(R.string.e9);
                e.a(getContext(), imageView, (int) R.raw.default_ipcall);
                AppMethodBeat.o(37654);
                return;
            case OnlyChat:
                this.contentView.setText(R.string.ea);
                e.a(getContext(), imageView, (int) R.drawable.c46);
                break;
        }
        AppMethodBeat.o(37654);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.i(37655);
        this.jxm.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(37655);
    }
}

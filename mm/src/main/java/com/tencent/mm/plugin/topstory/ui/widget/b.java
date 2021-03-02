package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b extends i {
    private TextView DbK;
    private Set<any> GqI = new HashSet();
    private View GqJ;
    private View GqK;
    private TextView GqL;
    private FlowLayout GqM;
    private final any GqN = new any();
    private View contentView;

    public interface a {
        void onDismiss();

        void v(Set<any> set);
    }

    public b(final Context context, final eiw eiw, final a aVar) {
        super(context, R.style.zm);
        AppMethodBeat.i(126636);
        this.GqN.id = "101";
        this.GqN.dQx = context.getString(R.string.hpp);
        if (eiw.NiE != null) {
            Iterator<any> it = eiw.NiE.Nin.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                any next = it.next();
                if (next.LzD) {
                    this.GqN.id = next.id;
                    this.GqN.dQx = next.dQx;
                    eiw.NiE.Nin.remove(next);
                    break;
                }
            }
        }
        this.contentView = LayoutInflater.from(context).inflate(R.layout.c3p, (ViewGroup) null, false);
        this.GqJ = this.contentView.findViewById(R.id.cfd);
        this.GqK = this.contentView.findViewById(R.id.cfk);
        this.DbK = (TextView) this.contentView.findViewById(R.id.cfa);
        this.GqL = (TextView) this.contentView.findViewById(R.id.j01);
        this.GqL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126632);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (b.this.GqI.isEmpty()) {
                    b.this.GqI.add(b.this.GqN);
                }
                aVar.v(b.this.GqI);
                b.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126632);
            }
        });
        this.GqM = (FlowLayout) this.contentView.findViewById(R.id.cff);
        Iterator<any> it2 = eiw.NiE.Nin.iterator();
        while (it2.hasNext()) {
            final any next2 = it2.next();
            View inflate = LayoutInflater.from(context).inflate(R.layout.c3q, (ViewGroup) this.GqM, false);
            final TextView textView = (TextView) inflate.findViewById(R.id.cfh);
            textView.setText(next2.dQx);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.widget.b.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126633);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.GqI.contains(next2)) {
                        b.this.GqI.remove(next2);
                        textView.setTextColor(context.getResources().getColor(R.color.ac1));
                        textView.setBackgroundResource(R.drawable.b0g);
                    } else {
                        b.this.GqI.add(next2);
                        textView.setTextColor(context.getResources().getColor(R.color.ac0));
                        textView.setBackgroundResource(R.drawable.b0f);
                    }
                    if (b.this.GqI.isEmpty()) {
                        b.this.GqL.setText(b.this.GqN.dQx);
                    } else {
                        b.this.GqL.setText(context.getString(R.string.hpq));
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126633);
                }
            });
            this.GqM.addView(inflate);
        }
        this.DbK.setText(eiw.NiE.Nil);
        this.DbK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.b.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(126634);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", eiw.NiE.Nim);
                c.b(b.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126634);
            }
        });
        setContentView(this.contentView);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.b.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(126635);
                aVar.onDismiss();
                AppMethodBeat.o(126635);
            }
        });
        AppMethodBeat.o(126636);
    }

    public final void a(View view, boolean z, int i2, int i3) {
        AppMethodBeat.i(126637);
        super.show();
        int[] a2 = e.a(view.getContext(), view, this.contentView, z);
        if (z) {
            this.GqK.setVisibility(0);
            this.GqJ.setVisibility(8);
        } else {
            this.GqK.setVisibility(8);
            this.GqJ.setVisibility(0);
        }
        a2[0] = a2[0] + i2;
        a2[1] = a2[1] + i3;
        Window window = getWindow();
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.x = a2[0];
        attributes.y = a2[1];
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        AppMethodBeat.o(126637);
    }
}

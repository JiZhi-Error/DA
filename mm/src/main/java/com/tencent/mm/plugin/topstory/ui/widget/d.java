package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;

public final class d extends i {
    private View GqJ = this.contentView.findViewById(R.id.fk7);
    private View GqK = this.contentView.findViewById(R.id.fl4);
    private View GqW = this.contentView.findViewById(R.id.j02);
    private View GqX = this.contentView.findViewById(R.id.ce5);
    private View contentView;

    public interface a {
        void e(eiw eiw);

        void f(eiw eiw);

        void g(eiw eiw);

        void onDismiss();
    }

    public d(Context context, final eiw eiw, final a aVar) {
        super(context, R.style.zm);
        AppMethodBeat.i(126644);
        this.contentView = LayoutInflater.from(context).inflate(R.layout.c4c, (ViewGroup) null, false);
        this.GqW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126641);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.TopStory.MorePopupWindow", "onClick unlike");
                if (aVar != null) {
                    aVar.e(eiw);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126641);
            }
        });
        this.GqX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(126642);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.TopStory.MorePopupWindow", "onClick favorite");
                if (aVar != null) {
                    aVar.f(eiw);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126642);
            }
        });
        this.GqX.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.d.AnonymousClass3 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(164130);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                Log.i("MicroMsg.TopStory.MorePopupWindow", "onLongClick favorite");
                if (aVar != null) {
                    aVar.g(eiw);
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(164130);
                return false;
            }
        });
        setContentView(this.contentView);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.d.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(164131);
                if (aVar != null) {
                    aVar.onDismiss();
                }
                AppMethodBeat.o(164131);
            }
        });
        AppMethodBeat.o(126644);
    }

    public final void a(View view, boolean z, int i2, int i3) {
        AppMethodBeat.i(126645);
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
        AppMethodBeat.o(126645);
    }
}

package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.b;

public class DeleteTaskFooterView extends LinearLayout {
    private boolean Wd = true;
    private LinearLayout qLY;
    ImageView qLZ;
    LinearLayout qMa;
    TextView qMb;
    ImageView qMc;
    boolean qMd = false;
    private d.c qMe = new d.c() {
        /* class com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.c
        public final void la(boolean z) {
            AppMethodBeat.i(8978);
            DeleteTaskFooterView deleteTaskFooterView = DeleteTaskFooterView.this;
            if (z) {
                deleteTaskFooterView.qMa.setClickable(true);
                b.e(deleteTaskFooterView.qMc, "download_delete_enable");
                deleteTaskFooterView.qMb.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(R.color.Red));
                AppMethodBeat.o(8978);
                return;
            }
            deleteTaskFooterView.qMa.setClickable(false);
            b.e(deleteTaskFooterView.qMc, "download_delete_disable");
            deleteTaskFooterView.qMb.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(R.color.FG_4));
            AppMethodBeat.o(8978);
        }
    };

    public DeleteTaskFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8981);
        AppMethodBeat.o(8981);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(8982);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.z7, (ViewGroup) this, true);
        this.qLY = (LinearLayout) inflate.findViewById(R.id.azn);
        this.qLZ = (ImageView) inflate.findViewById(R.id.azm);
        this.qLY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(8979);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (DeleteTaskFooterView.this.qMd) {
                    DeleteTaskFooterView.this.qMd = false;
                    b.e(DeleteTaskFooterView.this.qLZ, "checkbox_cell_off");
                } else {
                    DeleteTaskFooterView.this.qMd = true;
                    b.e(DeleteTaskFooterView.this.qLZ, "checkbox_cell_on");
                }
                if (DeleteTaskFooterView.this.Wd) {
                    DeleteTaskFooterView.lc(DeleteTaskFooterView.this.qMd);
                }
                DeleteTaskFooterView.this.Wd = true;
                a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8979);
            }
        });
        this.qMa = (LinearLayout) inflate.findViewById(R.id.bmc);
        this.qMa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(8980);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                DeleteTaskFooterView.cCj();
                a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8980);
            }
        });
        this.qMa.setClickable(false);
        this.qMb = (TextView) inflate.findViewById(R.id.bm9);
        this.qMc = (ImageView) inflate.findViewById(R.id.bme);
        AppMethodBeat.o(8982);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(8983);
        super.onAttachedToWindow();
        d.a(this.qMe);
        AppMethodBeat.o(8983);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(8984);
        super.onDetachedFromWindow();
        d.b(this.qMe);
        AppMethodBeat.o(8984);
    }

    static /* synthetic */ void lc(boolean z) {
        AppMethodBeat.i(8985);
        d.kX(z);
        AppMethodBeat.o(8985);
    }

    static /* synthetic */ void cCj() {
        AppMethodBeat.i(8986);
        d.cBW();
        AppMethodBeat.o(8986);
    }
}

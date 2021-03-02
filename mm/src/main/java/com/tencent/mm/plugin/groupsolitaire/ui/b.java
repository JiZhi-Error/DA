package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;

public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private Button hPX = ((Button) this.lJI.findViewById(R.id.g3k));
    private Button hSq;
    private View lJI = View.inflate(this.mContext, R.layout.au0, null);
    private Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    android.support.design.widget.a yfL;
    CustomDatePicker yfP = ((CustomDatePicker) this.lJI.findViewById(R.id.bkl));
    a yfQ;

    public interface a<T> {
        void onResult(boolean z, int i2, int i3, int i4);
    }

    public b(Context context) {
        AppMethodBeat.i(110423);
        this.mContext = context;
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(110419);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, true, b.this.yfP.getYear(), b.this.yfP.getMonth(), b.this.yfP.getDayOfMonth());
                b.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110419);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(110420);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, false, 0, 0, 0);
                b.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110420);
            }
        });
        this.yfL = new android.support.design.widget.a(this.mContext);
        this.yfL.setContentView(this.lJI);
        this.yfL.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.b.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(110421);
                b.a(b.this, false, 0, 0, 0);
                b.this.hide();
                AppMethodBeat.o(110421);
            }
        });
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.b.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(110422);
                b.this.yfL = null;
                AppMethodBeat.o(110422);
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lJI.getLayoutParams();
        layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 318);
        this.lJI.setLayoutParams(layoutParams);
        this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        AppMethodBeat.o(110423);
    }

    public final void onGlobalLayout() {
    }

    public final void hide() {
        AppMethodBeat.i(110424);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(110424);
    }

    static /* synthetic */ void a(b bVar, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(110425);
        if (bVar.yfQ != null) {
            bVar.yfQ.onResult(z, i2, i3, i4);
        }
        AppMethodBeat.o(110425);
    }
}

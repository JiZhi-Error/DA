package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;
import com.tencent.wxmm.v2helper;
import java.util.Calendar;
import java.util.Locale;

public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private LinearLayout PTf = ((LinearLayout) this.lJI.findViewById(R.id.bkn));
    private Button QSR;
    private LinearLayout QSS = ((LinearLayout) this.lJI.findViewById(R.id.bkl));
    private CustomDatePickerNew QST = new CustomDatePickerNew(this.mContext);
    public a QSU;
    private Button hPX;
    private Button hSq;
    private View lJI = View.inflate(this.mContext, R.layout.yz, null);
    private Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    private android.support.design.widget.a yfL = new android.support.design.widget.a(this.mContext);

    public interface a<T> {
        void onResult(boolean z, int i2, int i3, int i4);
    }

    public b(Context context) {
        AppMethodBeat.i(159526);
        this.mContext = context;
        this.QSS.removeAllViews();
        this.QSS.setGravity(17);
        this.QSS.addView(this.QST.getView(), new LinearLayout.LayoutParams(-1, -1));
        this.hPX = (Button) this.lJI.findViewById(R.id.g3k);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(159522);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, true, b.this.QST.getYear(), b.this.QST.getMonth(), b.this.QST.getDayOfMonth());
                b.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159522);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(159523);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, false, 0, 0, 0);
                b.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159523);
            }
        });
        this.QSR = (Button) this.lJI.findViewById(R.id.af_);
        this.QSR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.b.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(198420);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, true, b.this.QST.getYear(), b.this.QST.getMonth(), b.this.QST.getDayOfMonth());
                b.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198420);
            }
        });
        this.yfL.setContentView(this.lJI);
        this.yfL.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.widget.picker.b.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(198421);
                b.a(b.this, false, 0, 0, 0);
                b.this.hide();
                AppMethodBeat.o(198421);
            }
        });
        this.mLJ = at.fromDPToPix(this.mContext, v2helper.EMethodSetPlayerPreCorrectCofOn);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.widget.picker.b.AnonymousClass5 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(198422);
                b.this.yfL = null;
                AppMethodBeat.o(198422);
            }
        });
        AppMethodBeat.o(159526);
    }

    public final void onGlobalLayout() {
    }

    public final void aX(int i2, int i3, int i4) {
        AppMethodBeat.i(159527);
        if (i2 < 0 || i3 < 0 || i4 < 0) {
            AppMethodBeat.o(159527);
            return;
        }
        if (this.QST != null) {
            this.QST.aW(i2, i3, i4);
        }
        AppMethodBeat.o(159527);
    }

    public final void bg(boolean z, boolean z2) {
        AppMethodBeat.i(159528);
        if (this.QST != null) {
            this.QST.bg(z, z2);
        }
        AppMethodBeat.o(159528);
    }

    public final void aY(int i2, int i3, int i4) {
        AppMethodBeat.i(159529);
        if (i2 < 0 || i3 < 0 || i4 < 0) {
            AppMethodBeat.o(159529);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i2, i3 - 1, i4);
        if (this.QST != null) {
            this.QST.setMinDate(Long.valueOf(instance.getTimeInMillis()));
        }
        AppMethodBeat.o(159529);
    }

    public final void aZ(int i2, int i3, int i4) {
        AppMethodBeat.i(159530);
        if (i2 < 0 || i3 < 0 || i4 < 0) {
            AppMethodBeat.o(159530);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i2, i3 - 1, i4);
        if (this.QST != null) {
            this.QST.setMaxDate(Long.valueOf(instance.getTimeInMillis()));
        }
        AppMethodBeat.o(159530);
    }

    public final void setLongTermYear(boolean z) {
        AppMethodBeat.i(198423);
        if (this.QST != null) {
            this.QST.setLongTermYear(z);
        }
        AppMethodBeat.o(198423);
    }

    public final void show() {
        AppMethodBeat.i(159531);
        if (this.yfL != null) {
            if (this.QST != null) {
                this.QST.onShow();
            }
            this.yfL.show();
        }
        AppMethodBeat.o(159531);
    }

    public final void hide() {
        AppMethodBeat.i(159532);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(159532);
    }

    public final String hcf() {
        AppMethodBeat.i(159533);
        String str = null;
        if (this.QST != null) {
            str = this.QST.currentValue();
        }
        AppMethodBeat.o(159533);
        return str;
    }

    static /* synthetic */ void a(b bVar, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(159534);
        if (bVar.QSU != null) {
            bVar.QSU.onResult(z, i2, i3, i4);
        }
        AppMethodBeat.o(159534);
    }
}

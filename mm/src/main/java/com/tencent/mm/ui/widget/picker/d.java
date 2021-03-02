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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.at;
import com.tencent.wxmm.v2helper;
import java.util.Locale;

public final class d implements ViewTreeObserver.OnGlobalLayoutListener {
    private LinearLayout QTk = ((LinearLayout) this.lJI.findViewById(R.id.imw));
    public CustomTimePickerNew QTl = new CustomTimePickerNew(this.mContext);
    public a QTm;
    private Button hPX;
    private Button hSq;
    private View lJI = View.inflate(this.mContext, R.layout.c35, null);
    private Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    public android.support.design.widget.a yfL = new android.support.design.widget.a(this.mContext);

    public interface a<T> {
        void a(boolean z, T t);
    }

    public d(Context context) {
        AppMethodBeat.i(159555);
        this.mContext = context;
        this.QTk.removeAllViews();
        this.QTk.setGravity(17);
        this.QTk.addView(this.QTl.getView(), new LinearLayout.LayoutParams(-1, -1));
        this.hPX = (Button) this.lJI.findViewById(R.id.g3k);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.d.AnonymousClass1 */

            public final void onClick(View view) {
                String format;
                AppMethodBeat.i(159552);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = d.this;
                if (d.this.QTl == null) {
                    format = null;
                } else {
                    CustomTimePickerNew customTimePickerNew = d.this.QTl;
                    customTimePickerNew.QSK.blg();
                    format = String.format(Locale.US, "%02d:%02d", Integer.valueOf(customTimePickerNew.currentHour), Integer.valueOf(customTimePickerNew.currentMinute));
                }
                d.a(dVar, true, format);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159552);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(159553);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.a(d.this, false, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159553);
            }
        });
        this.yfL.setContentView(this.lJI);
        this.mLJ = at.fromDPToPix(this.mContext, v2helper.EMethodSetPlayerPreCorrectCofOn);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.widget.picker.d.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(159554);
                d.this.yfL = null;
                AppMethodBeat.o(159554);
            }
        });
        AppMethodBeat.o(159555);
    }

    public final void onGlobalLayout() {
    }

    static /* synthetic */ void a(d dVar, boolean z, Object obj) {
        AppMethodBeat.i(159561);
        if (dVar.QTm != null) {
            dVar.QTm.a(z, obj);
        }
        AppMethodBeat.o(159561);
    }
}

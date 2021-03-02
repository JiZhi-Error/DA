package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.statusbar.c;

@SuppressLint({"ViewConstructor"})
public final class v extends LinearLayout implements c.a {
    public final d cBE;
    private int mStatusBarHeight;
    private final a[] nXO = new a[4];
    private final SparseArray<b> nXP = new SparseArray<>();
    private final SparseArray<b> nXQ = new SparseArray<>();

    public v(Context context, d dVar) {
        super(context);
        AppMethodBeat.i(147701);
        this.cBE = dVar;
        setClickable(false);
        int i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i2 * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        bXE();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 2);
        TextView textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(R.string.oy));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        bXF();
        c.bt((Activity) getContext()).a(this);
        AppMethodBeat.o(147701);
    }

    private void bXE() {
        AppMethodBeat.i(147702);
        if (getLayoutParams() != null && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.b.eu(getContext()) + this.mStatusBarHeight;
            requestLayout();
        }
        AppMethodBeat.o(147702);
    }

    private void bXF() {
        AppMethodBeat.i(147703);
        for (int i2 = 0; i2 < 4; i2++) {
            a aVar = new a(getContext());
            aVar.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.nwQ[i2]));
            this.nXO[i2] = aVar;
            addView(aVar);
        }
        AppMethodBeat.o(147703);
    }

    public final void aw(final int i2, final String str) {
        AppMethodBeat.i(147704);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.v.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(147692);
                v.a(v.this, i2, str);
                AppMethodBeat.o(147692);
            }
        });
        AppMethodBeat.o(147704);
    }

    public final void eL(final String str, final String str2) {
        AppMethodBeat.i(147705);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.v.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(147693);
                v.a(v.this, str, str2);
                AppMethodBeat.o(147693);
            }
        });
        AppMethodBeat.o(147705);
    }

    @Override // com.tencent.mm.ui.statusbar.c.a
    public final void yf(int i2) {
        AppMethodBeat.i(147706);
        this.mStatusBarHeight = i2;
        bXE();
        AppMethodBeat.o(147706);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"AppCompatCustomView"})
    public class a extends TextView {
        public a(Context context) {
            super(context);
            AppMethodBeat.i(147694);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
            layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(getContext().getResources().getColor(R.color.l4));
            AppMethodBeat.o(147694);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"AppCompatCustomView"})
    public class b extends TextView {
        private String mTitle;
        private String mValue;

        public b(Context context) {
            super(context);
            AppMethodBeat.i(147696);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(getContext().getResources().getColor(R.color.BW_100_Alpha_0_9));
            AppMethodBeat.o(147696);
        }

        private void update() {
            AppMethodBeat.i(147697);
            setText(String.format("%s: %s", this.mTitle, this.mValue));
            AppMethodBeat.o(147697);
        }

        static /* synthetic */ void a(b bVar, String str) {
            AppMethodBeat.i(147698);
            bVar.mValue = str;
            bVar.update();
            AppMethodBeat.o(147698);
        }

        static /* synthetic */ void b(b bVar, String str) {
            AppMethodBeat.i(147699);
            bVar.mTitle = str;
            bVar.update();
            AppMethodBeat.o(147699);
        }
    }

    static /* synthetic */ void a(v vVar, int i2, String str) {
        AppMethodBeat.i(147707);
        Integer num = com.tencent.mm.plugin.appbrand.performance.d.nwR.get(i2);
        if (num == null) {
            Log.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", Integer.valueOf(i2));
            AppMethodBeat.o(147707);
            return;
        }
        String string = vVar.getContext().getString(num.intValue());
        b bVar = vVar.nXQ.get(i2);
        if (bVar == null) {
            bVar = new b(vVar.getContext());
            b.b(bVar, string);
            int i3 = (i2 / 100) - 1;
            if (i3 >= 4) {
                Log.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
                bVar = null;
            } else {
                if (i3 == 3) {
                    vVar.addView(bVar);
                } else {
                    vVar.addView(bVar, vVar.indexOfChild(vVar.nXO[i3 + 1]));
                }
                vVar.nXQ.put(i2, bVar);
            }
        }
        if (bVar == null) {
            Log.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
            AppMethodBeat.o(147707);
            return;
        }
        b.a(bVar, str);
        AppMethodBeat.o(147707);
    }

    static /* synthetic */ void a(v vVar, String str, String str2) {
        AppMethodBeat.i(147708);
        b bVar = vVar.nXP.get(str.hashCode());
        if (bVar == null) {
            bVar = new b(vVar.getContext());
            b.b(bVar, str);
            vVar.addView(bVar);
            vVar.nXP.put(str.hashCode(), bVar);
        }
        b.a(bVar, str2);
        AppMethodBeat.o(147708);
    }
}

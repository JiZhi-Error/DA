package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ac;

public interface e extends ac {

    public interface b extends com.tencent.luggage.a.b {
        e ec(Context context);
    }

    boolean Af(int i2);

    boolean cbH();

    void cck();

    void ccl();

    View getPanelView();

    void onDestroy();

    void setOnTextOperationListener(f fVar);

    public static class a implements e {
        int crI;
        boolean mInLayout;
        private View mView;

        public a(Context context) {
            AppMethodBeat.i(136691);
            this.mView = new View(context) {
                /* class com.tencent.mm.plugin.appbrand.widget.input.panel.e.a.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(136688);
                    a.this.mInLayout = true;
                    super.onLayout(z, i2, i3, i4, i5);
                    a.this.mInLayout = false;
                    AppMethodBeat.o(136688);
                }

                /* access modifiers changed from: protected */
                public final void onMeasure(int i2, int i3) {
                    AppMethodBeat.i(136689);
                    if (a.this.crI > 0) {
                        i3 = View.MeasureSpec.makeMeasureSpec(a.this.crI, 1073741824);
                    }
                    super.onMeasure(i2, i3);
                    AppMethodBeat.o(136689);
                }
            };
            AppMethodBeat.o(136691);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final View getPanelView() {
            return this.mView;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final void setOnTextOperationListener(f fVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final void cck() {
            AppMethodBeat.i(136692);
            this.mView.setVisibility(0);
            AppMethodBeat.o(136692);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final void ccl() {
            AppMethodBeat.i(136693);
            this.mView.setVisibility(4);
            AppMethodBeat.o(136693);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final void onDestroy() {
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final boolean Af(int i2) {
            if (i2 <= 0 || this.crI == i2) {
                return false;
            }
            this.crI = i2;
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
        public final boolean cbH() {
            AppMethodBeat.i(136694);
            if (Build.VERSION.SDK_INT >= 18) {
                boolean isInLayout = this.mView.isInLayout();
                AppMethodBeat.o(136694);
                return isInLayout;
            }
            boolean z = this.mInLayout;
            AppMethodBeat.o(136694);
            return z;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.ac
        public final boolean cbD() {
            return true;
        }
    }
}

package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView extends ScrollView implements View.OnFocusChangeListener {
    private b Rvr;
    private a Rvs;

    public interface a {
        void onScrollChange(View view, int i2, int i3, int i4, int i5);
    }

    public interface b {
        void ym(boolean z);
    }

    public MMScrollView(Context context) {
        super(context);
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnSizeChangeListener(b bVar) {
        if (bVar != null) {
            this.Rvr = bVar;
        }
    }

    public void setOnScrollListener(a aVar) {
        this.Rvs = aVar;
    }

    public final void a(ViewGroup viewGroup, View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(72943);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.o(72943);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.i(72944);
        Log.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (!z) {
            AppMethodBeat.o(72944);
            return;
        }
        postDelayed(new Runnable() {
            /* class com.tencent.mm.wallet_core.ui.MMScrollView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(72942);
                MMScrollView.this.scrollTo(0, view.getTop() - com.tencent.mm.cb.a.fromDPToPix(MMScrollView.this.getContext(), 10));
                AppMethodBeat.o(72942);
            }
        }, 200);
        AppMethodBeat.o(72944);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(72945);
        if (!(this.Rvr == null || i3 == i5)) {
            this.Rvr.ym(i3 < i5);
        }
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(72945);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(72946);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.Rvs != null) {
            this.Rvs.onScrollChange(this, i2, i3, i4, i5);
        }
        AppMethodBeat.o(72946);
    }
}

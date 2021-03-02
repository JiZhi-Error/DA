package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMScrollView extends ScrollView implements View.OnFocusChangeListener {
    private a kuA;

    public interface a {
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnSizeChangeListener(a aVar) {
        if (aVar != null) {
            this.kuA = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ViewGroup viewGroup, View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(20953);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof AddrEditView) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.o(20953);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.i(20954);
        Log.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (!z) {
            AppMethodBeat.o(20954);
            return;
        }
        postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.address.ui.MMScrollView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(20952);
                MMScrollView.this.scrollTo(0, view.getTop() - com.tencent.mm.cb.a.fromDPToPix(MMScrollView.this.getContext(), 10));
                AppMethodBeat.o(20952);
            }
        }, 200);
        AppMethodBeat.o(20954);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(20955);
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(20955);
    }
}

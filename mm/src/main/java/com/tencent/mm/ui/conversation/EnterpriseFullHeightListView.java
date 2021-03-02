package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EnterpriseFullHeightListView extends ListView {
    public boolean Qfl = true;
    private View Qfm;
    private int kn = 0;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6 = 0;
        AppMethodBeat.i(38588);
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.Qfl) {
            AppMethodBeat.o(38588);
            return;
        }
        try {
            if (!this.Qfl) {
                int count = getAdapter().getCount();
                if (this.Qfm != null) {
                    count--;
                }
                for (int headerViewsCount = getHeaderViewsCount(); headerViewsCount < count; headerViewsCount++) {
                    if (this.kn <= 0) {
                        try {
                            View view = getAdapter().getView(headerViewsCount, null, this);
                            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                            this.kn = view.getMeasuredHeight();
                        } catch (Exception e2) {
                        }
                    }
                    i6 += this.kn;
                    if (i6 > i3) {
                        if (this.Qfm != null) {
                            removeFooterView(this.Qfm);
                            this.Qfm = null;
                        }
                        AppMethodBeat.o(38588);
                        return;
                    }
                }
                if (i6 < i3) {
                    if (this.Qfm == null) {
                        this.Qfm = new View(getContext());
                    }
                    removeFooterView(this.Qfm);
                    this.Qfm.setLayoutParams(new AbsListView.LayoutParams(-1, i3 - i6));
                    addFooterView(this.Qfm, null, false);
                }
            }
            AppMethodBeat.o(38588);
        } catch (Exception e3) {
            AppMethodBeat.o(38588);
        }
    }
}

package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FeedbackContentViewGroup extends ViewGroup {
    private List<a> DyH;
    private int DyI;

    public FeedbackContentViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedbackContentViewGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FeedbackContentViewGroup(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(202189);
        this.DyH = new LinkedList();
        try {
            this.DyI = com.tencent.mm.cb.a.fromDPToPix(getContext(), 12);
            AppMethodBeat.o(202189);
        } catch (Throwable th) {
            AppMethodBeat.o(202189);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        a aVar;
        int i4;
        AppMethodBeat.i(202190);
        super.onMeasure(i2, i3);
        try {
            measureChildren(i2, i3);
            int i5 = this.DyI;
            int childCount = getChildCount();
            int measuredWidth = getMeasuredWidth();
            this.DyH.clear();
            for (int i6 = 0; i6 < childCount; i6++) {
                List<a> list = this.DyH;
                a aVar2 = new a();
                aVar2.qXP = 0;
                aVar2.DyJ = measuredWidth;
                aVar2.DyK = false;
                list.add(aVar2);
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < childCount) {
                View childAt = getChildAt(i7);
                int min = Math.min(childAt.getMeasuredWidth(), measuredWidth);
                Iterator<a> it = this.DyH.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    aVar = it.next();
                    if (aVar != null && !aVar.DyK) {
                        if (aVar.DyJ >= min) {
                            break;
                        }
                        aVar.DyK = true;
                    }
                }
                if (aVar != null) {
                    aVar.qXP++;
                    aVar.DyJ -= min + i5;
                }
                if (i8 == 0) {
                    i4 = childAt.getMeasuredHeight();
                } else {
                    i4 = i8;
                }
                i7++;
                i8 = i4;
            }
            Iterator<a> it2 = this.DyH.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next == null || next.qXP == 0) {
                    it2.remove();
                }
            }
            int size = this.DyH.size();
            int i9 = size * i8;
            if (size > 1) {
                i9 += (size - 1) * i5;
            }
            setMeasuredDimension(measuredWidth, i9);
            AppMethodBeat.o(202190);
        } catch (Throwable th) {
            AppMethodBeat.o(202190);
        }
    }

    static class a {
        int DyJ;
        boolean DyK;
        int qXP;

        a() {
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(202191);
        try {
            List<a> list = this.DyH;
            int childCount = getChildCount();
            int i6 = 0;
            int i7 = this.DyI;
            int i8 = 0;
            int i9 = 0;
            for (a aVar : list) {
                int i10 = aVar.qXP;
                int i11 = 0;
                i9 = i9;
                for (int i12 = 0; i12 < i10 && i6 < childCount; i12++) {
                    View childAt = getChildAt(i6);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i9 = childAt.getMeasuredHeight();
                    childAt.layout(i11, i8, measuredWidth + i11, i9 + i8);
                    i6++;
                    i11 += measuredWidth + i7;
                }
                i8 += i9 + i7;
            }
            AppMethodBeat.o(202191);
        } catch (Throwable th) {
            AppMethodBeat.o(202191);
        }
    }
}

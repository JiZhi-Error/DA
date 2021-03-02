package com.tencent.mm.plugin.sns.ad.widget.stackup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StackUpLayout extends FrameLayout {
    private int DBJ = 0;
    private int DBx = 0;
    private int DBy = 0;

    public interface a {
        void av(View view, int i2);

        int getItemCount();

        View j(Context context, int i2, int i3);
    }

    public StackUpLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StackUpLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setStackUpWidthSize(int i2) {
        this.DBJ = i2;
    }

    public final void ir(int i2, int i3) {
        this.DBx = i2;
        this.DBy = i3;
    }

    public void setAdapter(a aVar) {
        AppMethodBeat.i(202493);
        try {
            setAdapterInternal(aVar);
            AppMethodBeat.o(202493);
        } catch (Throwable th) {
            AppMethodBeat.o(202493);
        }
    }

    private void setAdapterInternal(a aVar) {
        AppMethodBeat.i(202494);
        if (aVar == null || aVar.getItemCount() == 0) {
            setVisibility(8);
            AppMethodBeat.o(202494);
            return;
        }
        int childCount = getChildCount();
        int itemCount = aVar.getItemCount();
        int i2 = (this.DBx * itemCount) - ((itemCount - 1) * this.DBJ);
        if (i2 < this.DBx) {
            setVisibility(8);
            AppMethodBeat.o(202494);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(i2, -2));
        } else if (layoutParams.width != i2) {
            layoutParams.width = i2;
        }
        if (childCount < itemCount) {
            for (int i3 = itemCount - childCount; i3 > 0; i3--) {
                View j2 = aVar.j(getContext(), this.DBx, this.DBy);
                int childCount2 = getChildCount();
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.DBx, this.DBy);
                layoutParams2.leftMargin = (this.DBx * childCount2) - (childCount2 * this.DBJ);
                j2.setLayoutParams(layoutParams2);
                addView(j2);
            }
        } else if (childCount > itemCount) {
            while (childCount > itemCount) {
                removeViewAt(childCount - 1);
                childCount--;
            }
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            aVar.av(getChildAt(i4), i4);
        }
        AppMethodBeat.o(202494);
    }
}

package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        int intrinsicHeight;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i4 - i2;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i8 = 8388615 & gravity;
        switch (gravity & 112) {
            case 16:
                paddingTop = (((i5 - i3) - measuredHeight) / 2) + getPaddingTop();
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                paddingTop = ((getPaddingTop() + i5) - i3) - measuredHeight;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            intrinsicHeight = 0;
        } else {
            intrinsicHeight = dividerDrawable.getIntrinsicHeight();
        }
        int i9 = paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i8;
                }
                switch (d.getAbsoluteGravity(i11, u.Z(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i6 = layoutParams.leftMargin + paddingLeft;
                        break;
                }
                if (bY(i10)) {
                    i9 += intrinsicHeight;
                }
                int i12 = i9 + layoutParams.topMargin;
                childAt.layout(i6, i12, measuredWidth + i6, i12 + measuredHeight2);
                i9 = i12 + layoutParams.bottomMargin + measuredHeight2;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0115, code lost:
        r0 = 0;
     */
    @Override // android.support.v7.widget.LinearLayoutCompat
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 401
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AlertDialogLayout.onMeasure(int, int):void");
    }
}

package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public final class bd {
    private final TextView Xz;
    private final WindowManager.LayoutParams azI = new WindowManager.LayoutParams();
    private final Rect azJ = new Rect();
    private final int[] azK = new int[2];
    private final int[] azL = new int[2];
    private final View mContentView;
    private final Context mContext;

    bd(Context context) {
        this.mContext = context;
        this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.b8, (ViewGroup) null);
        this.Xz = (TextView) this.mContentView.findViewById(R.id.fdt);
        this.azI.setTitle(getClass().getSimpleName());
        this.azI.packageName = this.mContext.getPackageName();
        this.azI.type = 1002;
        this.azI.width = -2;
        this.azI.height = -2;
        this.azI.format = -3;
        this.azI.windowAnimations = R.style.k;
        this.azI.flags = 24;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.Xz.setText(charSequence);
        a(view, i2, i3, z, this.azI);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.azI);
    }

    /* access modifiers changed from: package-private */
    public final void hide() {
        if (isShowing()) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
        }
    }

    private boolean isShowing() {
        return this.mContentView.getParent() != null;
    }

    private void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.amq);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.amp);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.mContext.getResources().getDimensionPixelOffset(z ? R.dimen.amt : R.dimen.ams);
        View bQ = bQ(view);
        if (bQ != null) {
            bQ.getWindowVisibleDisplayFrame(this.azJ);
            if (this.azJ.left < 0 && this.azJ.top < 0) {
                Resources resources = this.mContext.getResources();
                int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i5 = resources.getDimensionPixelSize(identifier);
                } else {
                    i5 = 0;
                }
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                this.azJ.set(0, i5, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            bQ.getLocationOnScreen(this.azL);
            view.getLocationOnScreen(this.azK);
            int[] iArr = this.azK;
            iArr[0] = iArr[0] - this.azL[0];
            int[] iArr2 = this.azK;
            iArr2[1] = iArr2[1] - this.azL[1];
            layoutParams.x = (this.azK[0] + i2) - (bQ.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.mContentView.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = this.mContentView.getMeasuredHeight();
            int i6 = ((i4 + this.azK[1]) - dimensionPixelOffset3) - measuredHeight;
            int i7 = height + this.azK[1] + dimensionPixelOffset3;
            if (z) {
                if (i6 < 0) {
                    layoutParams.y = i7;
                    return;
                }
            } else if (measuredHeight + i7 <= this.azJ.height()) {
                layoutParams.y = i7;
                return;
            }
            layoutParams.y = i6;
        }
    }

    private static View bQ(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}

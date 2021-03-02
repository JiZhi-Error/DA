package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;

public class b extends Dialog {
    private BubbleLayout QPP;
    private View QPQ;
    private Rect QPR;
    private int QPS;
    private boolean QPT;
    private a QPU = a.TOP;
    private a[] QPV = new a[4];
    private a QPW;
    private boolean QPX = false;
    private int[] QPY = new int[2];
    private ViewTreeObserver.OnGlobalLayoutListener ajG;
    private Activity mActivity;
    private boolean mCancelable;
    private int mHeight;
    private int mMargin;
    private int mOffsetX;
    private int mOffsetY;
    private int mStatusBarHeight;
    private int mWidth;

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(143541);
        bVar.hbI();
        AppMethodBeat.o(143541);
    }

    public enum a {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;

        public static a valueOf(String str) {
            AppMethodBeat.i(143530);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(143530);
            return aVar;
        }

        static {
            AppMethodBeat.i(143531);
            AppMethodBeat.o(143531);
        }
    }

    public b(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(143532);
        setCancelable(true);
        this.mActivity = (Activity) context;
        Window window = getWindow();
        if (window == null) {
            AppMethodBeat.o(143532);
            return;
        }
        final WindowManager.LayoutParams attributes = window.getAttributes();
        final int i2 = c.getScreenWH(getContext())[0];
        this.mStatusBarHeight = au.getStatusBarHeight(getContext());
        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.happybubble.b.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143525);
                if (b.this.QPX) {
                    float f2 = attributes.x < 0 ? 0.0f : (float) attributes.x;
                    if (((float) view.getWidth()) + f2 > ((float) i2)) {
                        f2 = (float) (i2 - view.getWidth());
                    }
                    motionEvent.setLocation(f2 + motionEvent.getX(), ((float) attributes.y) + motionEvent.getY());
                    b.this.mActivity.getWindow().getDecorView().dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(143525);
                    return true;
                }
                AppMethodBeat.o(143525);
                return false;
            }
        });
        AppMethodBeat.o(143532);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(143533);
        if (this.QPX && i2 == 4 && keyEvent.getRepeatCount() == 0) {
            dismiss();
            this.mActivity.onBackPressed();
            this.mActivity = null;
            AppMethodBeat.o(143533);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(143533);
        return onKeyDown;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(143534);
        super.onCreate(bundle);
        if (this.QPP == null) {
            this.QPP = new BubbleLayout(getContext());
        }
        if (this.QPQ != null) {
            this.QPP.addView(this.QPQ);
        }
        setContentView(this.QPP);
        Window window = getWindow();
        if (window == null) {
            AppMethodBeat.o(143534);
            return;
        }
        if (this.QPT) {
            window.setSoftInputMode(18);
        }
        window.setLayout(-2, -2);
        hbG();
        hbH();
        this.QPP.measure(0, 0);
        hbI();
        this.ajG = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.widget.happybubble.b.AnonymousClass2 */
            int ovI;
            int ovJ;

            public final void onGlobalLayout() {
                AppMethodBeat.i(143526);
                if (this.ovI == b.this.QPP.getMeasuredWidth() && this.ovJ == b.this.QPP.getMeasuredHeight()) {
                    AppMethodBeat.o(143526);
                    return;
                }
                b.d(b.this);
                this.ovI = b.this.QPP.getMeasuredWidth();
                this.ovJ = b.this.QPP.getMeasuredHeight();
                AppMethodBeat.o(143526);
            }
        };
        this.QPP.getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
        this.QPP.setOnClickEdgeListener(new BubbleLayout.b() {
            /* class com.tencent.mm.ui.widget.happybubble.b.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.happybubble.BubbleLayout.b
            public final void hbK() {
                AppMethodBeat.i(143527);
                if (b.this.mCancelable) {
                    b.this.dismiss();
                }
                AppMethodBeat.o(143527);
            }
        });
        AppMethodBeat.o(143534);
    }

    private boolean hbF() {
        int i2 = 0;
        for (a aVar : this.QPV) {
            if (aVar != null) {
                i2++;
            }
        }
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    private void hbG() {
        AppMethodBeat.i(143535);
        if (this.QPR == null || (this.QPW == null && !hbF())) {
            AppMethodBeat.o(143535);
            return;
        }
        int[] iArr = {this.QPY[0], this.QPY[1], (c.getScreenWH(getContext())[0] - this.QPY[0]) - this.QPR.width(), (c.getScreenWH(getContext())[1] - this.QPY[1]) - this.QPR.height()};
        if (hbF()) {
            this.QPQ.measure(0, 0);
            a[] aVarArr = this.QPV;
            for (a aVar : aVarArr) {
                if (aVar == null) {
                    AppMethodBeat.o(143535);
                    return;
                }
                switch (aVar) {
                    case LEFT:
                        if (iArr[0] <= this.QPQ.getMeasuredWidth()) {
                            break;
                        } else {
                            this.QPU = a.LEFT;
                            AppMethodBeat.o(143535);
                            return;
                        }
                    case TOP:
                        if (iArr[1] <= this.QPQ.getMeasuredHeight()) {
                            break;
                        } else {
                            this.QPU = a.TOP;
                            AppMethodBeat.o(143535);
                            return;
                        }
                    case RIGHT:
                        if (iArr[2] <= this.QPQ.getMeasuredWidth()) {
                            break;
                        } else {
                            this.QPU = a.RIGHT;
                            AppMethodBeat.o(143535);
                            return;
                        }
                    case BOTTOM:
                        if (iArr[3] <= this.QPQ.getMeasuredHeight()) {
                            break;
                        } else {
                            this.QPU = a.BOTTOM;
                            AppMethodBeat.o(143535);
                            return;
                        }
                }
            }
            this.QPU = this.QPV[0];
            AppMethodBeat.o(143535);
            return;
        }
        if (this.QPW != null) {
            switch (this.QPW) {
                case UP_AND_DOWN:
                    this.QPU = iArr[1] > iArr[3] ? a.TOP : a.BOTTOM;
                    AppMethodBeat.o(143535);
                    return;
                case LEFT_AND_RIGHT:
                    this.QPU = iArr[0] > iArr[2] ? a.LEFT : a.RIGHT;
                    AppMethodBeat.o(143535);
                    return;
            }
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            int i4 = iArr[i2];
            if (i4 <= i3) {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        if (i3 == iArr[0]) {
            this.QPU = a.LEFT;
            AppMethodBeat.o(143535);
        } else if (i3 == iArr[1]) {
            this.QPU = a.TOP;
            AppMethodBeat.o(143535);
        } else if (i3 == iArr[2]) {
            this.QPU = a.RIGHT;
            AppMethodBeat.o(143535);
        } else {
            if (i3 == iArr[3]) {
                this.QPU = a.BOTTOM;
            }
            AppMethodBeat.o(143535);
        }
    }

    private void hbH() {
        AppMethodBeat.i(143536);
        switch (this.QPU) {
            case LEFT:
                this.QPP.setLook(BubbleLayout.a.RIGHT);
                break;
            case TOP:
                this.QPP.setLook(BubbleLayout.a.BOTTOM);
                break;
            case RIGHT:
                this.QPP.setLook(BubbleLayout.a.LEFT);
                break;
            case BOTTOM:
                this.QPP.setLook(BubbleLayout.a.TOP);
                break;
        }
        this.QPP.hbL();
        AppMethodBeat.o(143536);
    }

    public void dismiss() {
        AppMethodBeat.i(143537);
        if (this.QPT) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof TextView) {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
        if (this.QPP != null && Build.VERSION.SDK_INT >= 16) {
            this.QPP.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajG);
        }
        super.dismiss();
        AppMethodBeat.o(143537);
    }

    private void hbI() {
        AppMethodBeat.i(143538);
        if (this.QPR == null) {
            AppMethodBeat.o(143538);
            return;
        }
        Window window = getWindow();
        if (window == null) {
            AppMethodBeat.o(143538);
            return;
        }
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.mWidth != 0) {
            attributes.width = this.mWidth;
        }
        if (this.mHeight != 0) {
            attributes.height = this.mHeight;
        }
        if (this.mMargin != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.QPP.getLayoutParams();
            if (this.QPU == a.TOP || this.QPU == a.BOTTOM) {
                layoutParams.leftMargin = this.mMargin;
                layoutParams.rightMargin = this.mMargin;
            } else {
                layoutParams.topMargin = this.mMargin;
                layoutParams.bottomMargin = this.mMargin;
            }
            this.QPP.setLayoutParams(layoutParams);
        }
        switch (this.QPU) {
            case LEFT:
            case RIGHT:
                attributes.y = (((this.QPY[1] + this.mOffsetY) + (this.QPR.height() / 2)) - (this.QPP.getMeasuredHeight() / 2)) - this.mStatusBarHeight;
                if (this.mMargin != 0 && this.mHeight == -1) {
                    this.QPP.setLookPosition((((this.QPY[1] - this.mMargin) + (this.QPR.height() / 2)) - (this.QPP.getLookWidth() / 2)) - this.mStatusBarHeight);
                } else if (attributes.y <= 0) {
                    this.QPP.setLookPosition(((this.QPY[1] + (this.QPR.height() / 2)) - (this.QPP.getLookWidth() / 2)) - this.mStatusBarHeight);
                } else if (attributes.y + this.QPP.getMeasuredHeight() > c.getScreenWH(getContext())[1]) {
                    this.QPP.setLookPosition(((this.QPY[1] - (c.getScreenWH(getContext())[1] - this.QPP.getMeasuredHeight())) + (this.QPR.height() / 2)) - (this.QPP.getLookWidth() / 2));
                } else {
                    this.QPP.setLookPosition((((this.QPY[1] - attributes.y) + (this.QPR.height() / 2)) - (this.QPP.getLookWidth() / 2)) - this.mStatusBarHeight);
                }
                if (this.QPU != a.RIGHT) {
                    if (this.QPS != 0) {
                        this.mOffsetX = -this.QPS;
                    }
                    attributes.x = (this.QPY[0] - this.QPP.getMeasuredWidth()) + this.mOffsetX;
                    break;
                } else {
                    if (this.QPS != 0) {
                        this.mOffsetX = this.QPS;
                    }
                    attributes.x = this.QPY[0] + this.QPR.width() + this.mOffsetX;
                    break;
                }
                break;
            case TOP:
            case BOTTOM:
                attributes.x = ((this.QPY[0] + (this.QPR.width() / 2)) - (this.QPP.getMeasuredWidth() / 2)) + this.mOffsetX;
                if (this.mMargin != 0 && this.mWidth == -1) {
                    this.QPP.setLookPosition(((this.QPY[0] - this.mMargin) + (this.QPR.width() / 2)) - (this.QPP.getLookWidth() / 2));
                } else if (attributes.x <= 0) {
                    this.QPP.setLookPosition((this.QPY[0] + (this.QPR.width() / 2)) - (this.QPP.getLookWidth() / 2));
                } else if (attributes.x + this.QPP.getMeasuredWidth() > c.getScreenWH(getContext())[0]) {
                    this.QPP.setLookPosition(((this.QPY[0] - (c.getScreenWH(getContext())[0] - this.QPP.getMeasuredWidth())) + (this.QPR.width() / 2)) - (this.QPP.getLookWidth() / 2));
                } else {
                    this.QPP.setLookPosition(((this.QPY[0] - attributes.x) + (this.QPR.width() / 2)) - (this.QPP.getLookWidth() / 2));
                }
                if (this.QPU != a.BOTTOM) {
                    if (this.QPS != 0) {
                        this.mOffsetY = -this.QPS;
                    }
                    attributes.y = ((this.QPY[1] - this.QPP.getMeasuredHeight()) + this.mOffsetY) - this.mStatusBarHeight;
                    break;
                } else {
                    if (this.QPS != 0) {
                        this.mOffsetY = this.QPS;
                    }
                    attributes.y = ((this.QPY[1] + this.QPR.height()) + this.mOffsetY) - this.mStatusBarHeight;
                    break;
                }
        }
        this.QPP.invalidate();
        window.setAttributes(attributes);
        AppMethodBeat.o(143538);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(143539);
        Window window = getWindow();
        if (window == null) {
            AppMethodBeat.o(143539);
            return false;
        }
        View decorView = window.getDecorView();
        if (this.mCancelable && isShowing()) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x <= 0 || y <= 0 || x > decorView.getWidth() || y > decorView.getHeight()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                cancel();
                AppMethodBeat.o(143539);
                return true;
            }
        }
        AppMethodBeat.o(143539);
        return false;
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(143540);
        super.setCancelable(z);
        this.mCancelable = z;
        AppMethodBeat.o(143540);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.tencent.mm.ui.widget.happybubble.b */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends b> T hw(View view) {
        AppMethodBeat.i(206156);
        this.QPR = new Rect(0, 0, view.getWidth(), view.getHeight());
        view.getLocationOnScreen(this.QPY);
        hbJ();
        AppMethodBeat.o(206156);
        return this;
    }

    private void hbJ() {
        AppMethodBeat.i(206157);
        hbG();
        if (this.ajG != null) {
            hbH();
            hbI();
        }
        AppMethodBeat.o(206157);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.ui.widget.happybubble.b */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final <T extends b> T hx(View view) {
        this.QPQ = view;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.ui.widget.happybubble.b */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends b> T a(a... aVarArr) {
        this.QPV = aVarArr;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.ui.widget.happybubble.b */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends b> T a(BubbleLayout bubbleLayout) {
        this.QPP = bubbleLayout;
        return this;
    }
}

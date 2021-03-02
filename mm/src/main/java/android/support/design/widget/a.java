package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class a extends e {
    private BottomSheetBehavior.a oA;
    private BottomSheetBehavior<FrameLayout> ow;
    boolean ox;
    boolean oy;
    boolean oz;

    public a(Context context) {
        this(context, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r3 = 1
            if (r6 != 0) goto L_0x0017
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r1 = r5.getTheme()
            r2 = 2130968695(0x7f040077, float:1.754605E38)
            boolean r1 = r1.resolveAttribute(r2, r0, r3)
            if (r1 == 0) goto L_0x0029
            int r6 = r0.resourceId
        L_0x0017:
            r4.<init>(r5, r6)
            r4.ox = r3
            r4.oy = r3
            android.support.design.widget.a$4 r0 = new android.support.design.widget.a$4
            r0.<init>()
            r4.oA = r0
            r4.gR()
            return
        L_0x0029:
            r6 = 2131821482(0x7f1103aa, float:1.9275708E38)
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.a.<init>(android.content.Context, int):void");
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(a(i2, null, null));
    }

    @Override // android.support.v7.app.e
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // android.support.v7.app.e
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.ox != z) {
            this.ox = z;
            if (this.ow != null) {
                this.ow.ob = z;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.ow != null && this.ow.state == 5) {
            this.ow.setState(4);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.ox) {
            this.ox = true;
        }
        this.oy = z;
        this.oz = true;
    }

    private View a(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.z9, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.bg3);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.bn_);
        this.ow = BottomSheetBehavior.l(frameLayout2);
        this.ow.ok = this.oA;
        this.ow.ob = this.ox;
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.iua).setOnClickListener(new View.OnClickListener() {
            /* class android.support.design.widget.a.AnonymousClass1 */

            public final void onClick(View view) {
                if (a.this.ox && a.this.isShowing()) {
                    a aVar = a.this;
                    if (!aVar.oz) {
                        TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(new int[]{16843611});
                        aVar.oy = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        aVar.oz = true;
                    }
                    if (aVar.oy) {
                        a.this.cancel();
                    }
                }
            }
        });
        u.a(frameLayout2, new android.support.v4.view.a() {
            /* class android.support.design.widget.a.AnonymousClass2 */

            @Override // android.support.v4.view.a
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                if (a.this.ox) {
                    cVar.addAction(1048576);
                    cVar.setDismissable(true);
                    return;
                }
                cVar.setDismissable(false);
            }

            @Override // android.support.v4.view.a
            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 1048576 || !a.this.ox) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                a.this.cancel();
                return true;
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() {
            /* class android.support.design.widget.a.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }
}

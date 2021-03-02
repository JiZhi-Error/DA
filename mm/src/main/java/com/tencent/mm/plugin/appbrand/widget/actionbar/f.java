package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class f extends PopupWindow {
    private Context mContext = null;
    private View maskView;
    public FrameLayout omw;
    private WindowManager windowManager;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(49381);
        this.mContext = context;
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.omw = new FrameLayout(this.mContext);
        AppMethodBeat.o(49381);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.i(49382);
        IBinder windowToken = view.getWindowToken();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.token = windowToken;
        this.maskView = new View(this.mContext);
        this.maskView.setBackgroundColor(2130706432);
        this.maskView.setFitsSystemWindows(false);
        this.maskView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.f.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(49379);
                if (motionEvent.getAction() == 1) {
                    f.this.dismiss();
                    AppMethodBeat.o(49379);
                    return true;
                }
                AppMethodBeat.o(49379);
                return false;
            }
        });
        this.maskView.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.f.AnonymousClass2 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(49380);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 4) {
                    f.this.dismiss();
                    a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(49380);
                    return true;
                }
                a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(49380);
                return false;
            }
        });
        this.windowManager.addView(this.maskView, layoutParams);
        super.showAsDropDown(view);
        AppMethodBeat.o(49382);
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(49384);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.p0);
        layoutParams.rightMargin = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.oz);
        layoutParams.leftMargin = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.oz);
        this.omw.addView(view, layoutParams);
        super.setContentView(this.omw);
        AppMethodBeat.o(49384);
    }

    public final void dismiss() {
        AppMethodBeat.i(49383);
        if (this.maskView != null) {
            this.windowManager.removeViewImmediate(this.maskView);
            this.maskView = null;
        }
        super.dismiss();
        AppMethodBeat.o(49383);
    }
}

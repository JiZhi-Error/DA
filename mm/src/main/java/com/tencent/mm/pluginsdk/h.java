package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

public final class h {
    public static int im(Context context) {
        AppMethodBeat.i(141147);
        int i2 = 0;
        if (context instanceof MMActivity) {
            i2 = ((MMActivity) context).getTitleLocation();
        }
        if (i2 <= 0) {
            i2 = context.getResources().getDimensionPixelSize(R.dimen.b9);
        }
        AppMethodBeat.o(141147);
        return i2;
    }

    public static void aU(Activity activity) {
        AppMethodBeat.i(141148);
        if (Build.VERSION.SDK_INT >= 16) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).supportRequestWindowFeature(109);
                AppMethodBeat.o(141148);
                return;
            }
            activity.requestWindowFeature(9);
        }
        AppMethodBeat.o(141148);
    }

    public static void q(MMActivity mMActivity) {
        AppMethodBeat.i(141149);
        if (Build.VERSION.SDK_INT >= 16) {
            mMActivity.supportRequestWindowFeature(109);
        }
        AppMethodBeat.o(141149);
    }

    public static void r(MMActivity mMActivity) {
        AppMethodBeat.i(141150);
        final WeakReference weakReference = new WeakReference(mMActivity);
        if (Build.VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(141144);
                    MMActivity mMActivity = (MMActivity) weakReference.get();
                    if (mMActivity == null || mMActivity.isFinishing() || mMActivity.isDestroyed()) {
                        AppMethodBeat.o(141144);
                        return;
                    }
                    mMActivity.getWindow().getDecorView().setSystemUiVisibility(mMActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    int cy = a.cy(mMActivity);
                    Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", Integer.valueOf(cy), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix((Context) mMActivity, 2)));
                    mMActivity.getBodyView().setPadding(0, cy - com.tencent.mm.cb.a.fromDPToPix((Context) mMActivity, 2), 0, 0);
                    AppMethodBeat.o(141144);
                }
            });
        }
        AppMethodBeat.o(141150);
    }

    public static void a(final MMFragmentActivity mMFragmentActivity, final View view) {
        AppMethodBeat.i(141151);
        if (mMFragmentActivity == null) {
            AppMethodBeat.o(141151);
            return;
        }
        if (!(Build.VERSION.SDK_INT < 16 || mMFragmentActivity.getWindow() == null || mMFragmentActivity.getWindow().getDecorView() == null)) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(141145);
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    int cy = a.cy(mMFragmentActivity);
                    Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(cy));
                    if (view != null) {
                        view.setPadding(0, cy, 0, 0);
                    }
                    AppMethodBeat.o(141145);
                }
            });
        }
        AppMethodBeat.o(141151);
    }

    public static void a(final AppCompatActivity appCompatActivity, final View view) {
        AppMethodBeat.i(205085);
        if (appCompatActivity == null) {
            AppMethodBeat.o(205085);
            return;
        }
        if (!(Build.VERSION.SDK_INT < 16 || appCompatActivity.getWindow() == null || appCompatActivity.getWindow().getDecorView() == null)) {
            appCompatActivity.getWindow().getDecorView().post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.h.AnonymousClass3 */
                final /* synthetic */ int val$height = 0;

                public final void run() {
                    AppMethodBeat.i(141146);
                    appCompatActivity.getWindow().getDecorView().setSystemUiVisibility(appCompatActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(this.val$height));
                    if (view != null) {
                        view.setPadding(0, this.val$height, 0, 0);
                    }
                    AppMethodBeat.o(141146);
                }
            });
        }
        AppMethodBeat.o(205085);
    }

    public static int eu(Context context) {
        AppMethodBeat.i(141153);
        int i2 = 0;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.z, typedValue, true)) {
            i2 = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i2 <= 0) {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i2 = context.getResources().getDimensionPixelSize(R.dimen.b8);
            } else {
                i2 = context.getResources().getDimensionPixelSize(R.dimen.b9);
            }
        }
        AppMethodBeat.o(141153);
        return i2;
    }
}

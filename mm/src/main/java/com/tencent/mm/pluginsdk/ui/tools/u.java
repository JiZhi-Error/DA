package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class u {
    private static int KwG = -1;

    public static void a(final View view, VideoSightView videoSightView) {
        AppMethodBeat.i(116268);
        if (view == null || videoSightView == null) {
            Log.e("VideoSightHelper", "null view object " + view + "," + videoSightView);
            AppMethodBeat.o(116268);
            return;
        }
        if (view.getVisibility() == 0) {
            videoSightView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.u.AnonymousClass1 */

                public final void onLayoutChange(final View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AppMethodBeat.i(116267);
                    int i10 = i5 - i3;
                    int i11 = i9 - i7;
                    if (i10 > 0 && i11 != i10) {
                        view.post(new Runnable() {
                            /* class com.tencent.mm.pluginsdk.ui.tools.u.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                int i2;
                                AppMethodBeat.i(116266);
                                int height = (view.getResources().getDisplayMetrics().heightPixels - view.getHeight()) >>> 1;
                                int height2 = (int) ((((double) height) / 1.618d) - ((double) (view.getHeight() >>> 1)));
                                if (height2 >= 0) {
                                    if (u.KwG < 0) {
                                        int unused = u.KwG = BackwardSupportUtil.BitmapFactory.fromDPToPix(view.getContext(), 20.0f);
                                    }
                                    if (view.getHeight() + height2 + u.KwG > height) {
                                        i2 = height2 - (((view.getHeight() + height2) + u.KwG) - height);
                                    } else {
                                        i2 = height2;
                                    }
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                                    if (i2 > 0 && i2 != layoutParams.bottomMargin) {
                                        Log.i("VideoSightHelper", "setting tip marginBottom ".concat(String.valueOf(i2)));
                                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i2);
                                        view.setLayoutParams(layoutParams);
                                    }
                                }
                                AppMethodBeat.o(116266);
                            }
                        });
                    }
                    AppMethodBeat.o(116267);
                }
            });
        }
        AppMethodBeat.o(116268);
    }
}

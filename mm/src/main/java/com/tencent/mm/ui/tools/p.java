package com.tencent.mm.ui.tools;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public final class p {
    public static void a(Context context, ScrollView scrollView, View view, View view2, View view3, int i2) {
        AppMethodBeat.i(143218);
        a(context, scrollView, view, view2, view3, i2, 0.0f, false);
        AppMethodBeat.o(143218);
    }

    public static void a(Context context, ScrollView scrollView, View view, View view2, View view3, float f2) {
        AppMethodBeat.i(143219);
        a(context, scrollView, view, view2, view3, 24, f2, false);
        AppMethodBeat.o(143219);
    }

    public static void a(final Context context, final ScrollView scrollView, final View view, final View view2, final View view3, final int i2, final float f2, final boolean z) {
        AppMethodBeat.i(143220);
        if (scrollView == null) {
            AppMethodBeat.o(143220);
            return;
        }
        scrollView.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.p.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(143217);
                if (view == null || view3 == null) {
                    AppMethodBeat.o(143217);
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                int i2 = marginLayoutParams.topMargin;
                int fromDPToPix = a.fromDPToPix(context, i2);
                if (view.getMeasuredHeight() > 0 && view2 != null) {
                    int aD = (int) (((float) (ao.az(context).y - au.aD(context))) - f2);
                    Log.d("MicroMsg.ScrollViewHelper", "setViewToScrollViewBottom screenHeight:%s", Integer.valueOf(aD));
                    int[] iArr = new int[2];
                    if (view2.getTag(view2.getId()) == null) {
                        view2.getLocationOnScreen(iArr);
                        view2.setTag(view2.getId(), iArr);
                    } else {
                        iArr = (int[]) view2.getTag(view2.getId());
                    }
                    if (scrollView != null && aD >= iArr[1] + view2.getMeasuredHeight() + fromDPToPix + view3.getMeasuredHeight()) {
                        int ay = ((aD - au.ay(context)) - (z ? 0 : h.eu(context))) - view3.getMeasuredHeight();
                        if (Util.isEqual(i2, ay)) {
                            AppMethodBeat.o(143217);
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) scrollView.getChildAt(0);
                        if (Util.isEqual(view3.getTag(), "no_first")) {
                            ((ViewGroup) view3.getParent()).removeView(view3);
                            viewGroup.addView(view3);
                        } else {
                            scrollView.removeView(viewGroup);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                            RelativeLayout relativeLayout = new RelativeLayout(context);
                            relativeLayout.addView(viewGroup);
                            relativeLayout.setLayoutParams(layoutParams);
                            scrollView.addView(relativeLayout);
                            ((ViewGroup) view3.getParent()).removeView(view3);
                            relativeLayout.addView(view3);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        marginLayoutParams2.topMargin = ay;
                        marginLayoutParams2.bottomMargin = 0;
                        view3.setLayoutParams(marginLayoutParams2);
                        view3.setVisibility(0);
                        view3.setTag("no_first");
                        scrollView.requestLayout();
                        AppMethodBeat.o(143217);
                        return;
                    } else if (Util.isEqual(i2, fromDPToPix)) {
                        AppMethodBeat.o(143217);
                        return;
                    } else {
                        ((ViewGroup) view3.getParent()).removeView(view3);
                        ((ViewGroup) view2.getParent()).addView(view3);
                    }
                } else if (Util.isEqual(i2, fromDPToPix)) {
                    AppMethodBeat.o(143217);
                    return;
                }
                marginLayoutParams.topMargin = fromDPToPix;
                view3.setVisibility(0);
                view3.setLayoutParams(marginLayoutParams);
                view3.requestLayout();
                AppMethodBeat.o(143217);
            }
        });
        AppMethodBeat.o(143220);
    }

    public static void a(final Context context, final NestedScrollView nestedScrollView, final View view, final View view2, final View view3) {
        AppMethodBeat.i(205377);
        if (nestedScrollView == null) {
            AppMethodBeat.o(205377);
            return;
        }
        nestedScrollView.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.p.AnonymousClass2 */
            final /* synthetic */ int QvP = 48;
            final /* synthetic */ float QvR;
            final /* synthetic */ boolean QvT;

            {
                this.QvR = 0.0f;
                this.QvT = false;
            }

            public final void run() {
                AppMethodBeat.i(205376);
                if (view == null || view3 == null) {
                    AppMethodBeat.o(205376);
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                int i2 = marginLayoutParams.topMargin;
                int fromDPToPix = a.fromDPToPix(context, this.QvP);
                if (view.getMeasuredHeight() > 0 && view2 != null) {
                    int height = (int) (((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight()) - this.QvR);
                    Log.d("MicroMsg.ScrollViewHelper", "setViewToScrollViewBottom screenHeight:%s", Integer.valueOf(height));
                    int[] iArr = new int[2];
                    if (view2.getTag(view2.getId()) == null) {
                        view2.getLocationOnScreen(iArr);
                        view2.setTag(view2.getId(), iArr);
                    } else {
                        iArr = (int[]) view2.getTag(view2.getId());
                    }
                    if (nestedScrollView != null && height >= iArr[1] + view2.getMeasuredHeight() + fromDPToPix + view3.getMeasuredHeight()) {
                        int ay = ((height - au.ay(context)) - (this.QvT ? 0 : h.eu(context))) - view3.getMeasuredHeight();
                        if (Util.isEqual(i2, ay)) {
                            AppMethodBeat.o(205376);
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) nestedScrollView.getChildAt(0);
                        if (Util.isEqual(view3.getTag(), "no_first")) {
                            ((ViewGroup) view3.getParent()).removeView(view3);
                            viewGroup.addView(view3);
                        } else {
                            nestedScrollView.removeView(viewGroup);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                            RelativeLayout relativeLayout = new RelativeLayout(context);
                            relativeLayout.addView(viewGroup);
                            relativeLayout.setLayoutParams(layoutParams);
                            nestedScrollView.addView(relativeLayout);
                            ((ViewGroup) view3.getParent()).removeView(view3);
                            relativeLayout.addView(view3);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        marginLayoutParams2.topMargin = ay;
                        marginLayoutParams2.bottomMargin = 0;
                        view3.setLayoutParams(marginLayoutParams2);
                        view3.setVisibility(0);
                        view3.setTag("no_first");
                        nestedScrollView.requestLayout();
                        AppMethodBeat.o(205376);
                        return;
                    } else if (Util.isEqual(i2, fromDPToPix)) {
                        AppMethodBeat.o(205376);
                        return;
                    } else {
                        ViewParent parent = view3.getParent();
                        ((ViewGroup) view3.getParent()).removeView(view3);
                        ((ViewGroup) view2.getParent()).addView(view3);
                        if ((view2.getParent() instanceof LinearLayout) && (parent instanceof RelativeLayout)) {
                            marginLayoutParams = new LinearLayout.LayoutParams(marginLayoutParams);
                        }
                        marginLayoutParams.topMargin = fromDPToPix;
                    }
                } else if (Util.isEqual(i2, fromDPToPix)) {
                    AppMethodBeat.o(205376);
                    return;
                } else {
                    marginLayoutParams.topMargin = fromDPToPix;
                }
                view3.setVisibility(0);
                view3.setLayoutParams(marginLayoutParams);
                view3.requestLayout();
                AppMethodBeat.o(205376);
            }
        });
        AppMethodBeat.o(205377);
    }
}

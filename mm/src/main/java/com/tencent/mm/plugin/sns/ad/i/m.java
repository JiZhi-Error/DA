package com.tencent.mm.plugin.sns.ad.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class m {
    private static Typeface DAh = null;

    public static void u(View view, boolean z) {
        AppMethodBeat.i(202368);
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(202368);
    }

    public static void fa(View view) {
        AppMethodBeat.i(202369);
        if (view != null) {
            view.setVisibility(4);
        }
        AppMethodBeat.o(202369);
    }

    public static void u(View view, int i2, int i3) {
        AppMethodBeat.i(202370);
        if (view != null) {
            try {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    if (i2 != -1003) {
                        layoutParams.width = i2;
                    }
                    if (i3 != -1003) {
                        layoutParams.height = i3;
                    }
                } else {
                    if (i2 == -1003) {
                        i2 = 0;
                    }
                    if (i3 == -1003) {
                        i3 = 0;
                    }
                    layoutParams = new ViewGroup.LayoutParams(i2, i3);
                }
                view.setLayoutParams(layoutParams);
                AppMethodBeat.o(202370);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202370);
    }

    public static void F(ViewGroup viewGroup) {
        AppMethodBeat.i(202371);
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        AppMethodBeat.o(202371);
    }

    public static boolean G(ViewGroup viewGroup) {
        AppMethodBeat.i(202372);
        if (viewGroup == null) {
            AppMethodBeat.o(202372);
            return false;
        } else if (viewGroup.getChildCount() > 0) {
            AppMethodBeat.o(202372);
            return true;
        } else {
            AppMethodBeat.o(202372);
            return false;
        }
    }

    public static boolean fb(View view) {
        AppMethodBeat.i(202373);
        if (view == null) {
            AppMethodBeat.o(202373);
            return false;
        } else if (view.getParent() != null) {
            AppMethodBeat.o(202373);
            return true;
        } else {
            AppMethodBeat.o(202373);
            return false;
        }
    }

    public static void fc(View view) {
        AppMethodBeat.i(202374);
        if (view == null) {
            AppMethodBeat.o(202374);
            return;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            AppMethodBeat.o(202374);
        } catch (Throwable th) {
            AppMethodBeat.o(202374);
        }
    }

    public static void f(View view, String str) {
        AppMethodBeat.i(202375);
        try {
            int parseColor = Color.parseColor(str);
            if (view != null) {
                view.setBackgroundColor(parseColor);
            }
            AppMethodBeat.o(202375);
        } catch (Throwable th) {
            AppMethodBeat.o(202375);
        }
    }

    public static void u(TextView textView) {
        AppMethodBeat.i(202376);
        if (textView != null) {
            try {
                if (DAh == null) {
                    DAh = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), "fonts/WeChatSansStd-Medium.ttf");
                }
                if (!(DAh == null || textView.getTypeface() == DAh)) {
                    textView.setTypeface(DAh);
                }
                AppMethodBeat.o(202376);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202376);
    }

    public static void f(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(202377);
        if (textView != null) {
            try {
                if (TextUtils.isEmpty(charSequence)) {
                    textView.setText("");
                    AppMethodBeat.o(202377);
                    return;
                }
                textView.setText(charSequence);
            } catch (Throwable th) {
                AppMethodBeat.o(202377);
                return;
            }
        }
        AppMethodBeat.o(202377);
    }

    public static View e(Context context, ViewGroup viewGroup) {
        View view = null;
        AppMethodBeat.i(202378);
        if (context == null && viewGroup == null) {
            AppMethodBeat.o(202378);
        } else {
            if (context == null) {
                try {
                    context = viewGroup.getContext();
                } catch (Throwable th) {
                    AppMethodBeat.o(202378);
                }
            }
            view = LayoutInflater.from(context).inflate(R.layout.bu0, viewGroup, false);
            AppMethodBeat.o(202378);
        }
        return view;
    }

    public static void b(View view, float f2, float f3, int i2) {
        GradientDrawable gradientDrawable;
        AppMethodBeat.i(202379);
        if (view == null) {
            AppMethodBeat.o(202379);
            return;
        }
        try {
            Drawable background = view.getBackground();
            if (background instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) background;
                gradientDrawable.mutate();
            } else {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setAlpha((int) ((255.0f * f3) + 0.5f));
            gradientDrawable.setColor(i2);
            gradientDrawable.setCornerRadius(f2);
            view.setBackground(gradientDrawable);
            AppMethodBeat.o(202379);
        } catch (Throwable th) {
            Log.w("ViewUtils", "setRoundBackground error.");
            AppMethodBeat.o(202379);
        }
    }

    public static float f(TextView textView, String str) {
        AppMethodBeat.i(202380);
        if (TextUtils.isEmpty(str) || textView == null) {
            AppMethodBeat.o(202380);
            return 0.0f;
        }
        try {
            TextPaint paint = textView.getPaint();
            if (paint == null) {
                AppMethodBeat.o(202380);
                return 0.0f;
            }
            float measureText = paint.measureText(str);
            AppMethodBeat.o(202380);
            return measureText;
        } catch (Throwable th) {
            Log.w("ViewUtils", "acquireTextWidth error.");
            AppMethodBeat.o(202380);
            return 0.0f;
        }
    }

    public static void aw(View view, int i2) {
        AppMethodBeat.i(202381);
        if (view instanceof TextView) {
            ((TextView) view).setMaxWidth(i2);
            AppMethodBeat.o(202381);
            return;
        }
        Log.w("ViewUtils", "the view is not support set max width.");
        AppMethodBeat.o(202381);
    }

    public static boolean a(ViewGroup viewGroup, View view, int i2) {
        AppMethodBeat.i(202367);
        if (viewGroup == null || view == null) {
            try {
                AppMethodBeat.o(202367);
                return false;
            } catch (Throwable th) {
                Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
                AppMethodBeat.o(202367);
                return false;
            }
        } else if (i2 > viewGroup.getChildCount()) {
            AppMethodBeat.o(202367);
            return false;
        } else {
            ViewParent parent = view.getParent();
            if (parent == viewGroup) {
                AppMethodBeat.o(202367);
                return true;
            }
            if (parent == null) {
                viewGroup.addView(view, i2);
            } else {
                ((ViewGroup) parent).removeView(view);
                viewGroup.addView(view);
            }
            AppMethodBeat.o(202367);
            return true;
        }
    }
}

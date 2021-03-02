package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class b {
    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(159896);
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(159896);
        return i2;
    }

    public static int f(View view, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(159897);
        int aW = aW(view, i3);
        if (aO(view, i4)) {
            int aX = (int) aX(view, aW);
            if (i2 > aX - ((aX - ((int) aR(view, i4 - 1))) / 2)) {
                i4--;
            }
        }
        int aQ = aQ(view, i4);
        int aS = aS(view, aQ);
        int aT = aT(view, aQ);
        int i6 = (aT - aS) / 2;
        if ((aW != aQ + 1 || i3 - aT >= i6) && (aW != aQ - 1 || aS - i3 >= i6)) {
            aQ = aW;
        }
        int a2 = a(view, aQ, (float) i2);
        if (a2 < hB(view).length() - 1 && aO(view, a2 + 1)) {
            int aX2 = (int) aX(view, aQ);
            if (i2 > aX2 - ((aX2 - ((int) aR(view, a2))) / 2)) {
                i5 = a2 + 1;
                AppMethodBeat.o(159897);
                return i5;
            }
        }
        i5 = a2;
        AppMethodBeat.o(159897);
        return i5;
    }

    private static boolean aO(View view, int i2) {
        AppMethodBeat.i(159898);
        if (i2 <= 0 || aQ(view, i2) != aQ(view, i2 - 1) + 1) {
            AppMethodBeat.o(159898);
            return false;
        }
        AppMethodBeat.o(159898);
        return true;
    }

    public static CharSequence hB(View view) {
        AppMethodBeat.i(159899);
        if (view instanceof NeatTextView) {
            CharSequence hiT = ((NeatTextView) view).hiT();
            AppMethodBeat.o(159899);
            return hiT;
        } else if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            AppMethodBeat.o(159899);
            return text;
        } else {
            AppMethodBeat.o(159899);
            return "";
        }
    }

    public static TextPaint hC(View view) {
        AppMethodBeat.i(159901);
        if (view instanceof NeatTextView) {
            TextPaint paint = ((NeatTextView) view).getPaint();
            AppMethodBeat.o(159901);
            return paint;
        } else if (view instanceof TextView) {
            TextPaint paint2 = ((TextView) view).getPaint();
            AppMethodBeat.o(159901);
            return paint2;
        } else {
            AppMethodBeat.o(159901);
            return null;
        }
    }

    public static int aP(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159902);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int lineBaseline = layout2.getLineBaseline(i2);
                AppMethodBeat.o(159902);
                return lineBaseline;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int lineBaseline2 = layout.getLineBaseline(i2);
            AppMethodBeat.o(159902);
            return lineBaseline2;
        }
        AppMethodBeat.o(159902);
        return 0;
    }

    public static int aQ(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159903);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int lineForOffset = layout2.getLineForOffset(i2);
                AppMethodBeat.o(159903);
                return lineForOffset;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int lineForOffset2 = layout.getLineForOffset(i2);
            AppMethodBeat.o(159903);
            return lineForOffset2;
        }
        AppMethodBeat.o(159903);
        return 0;
    }

    public static float aR(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159904);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                float primaryHorizontal = layout2.getPrimaryHorizontal(i2);
                AppMethodBeat.o(159904);
                return primaryHorizontal;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            float primaryHorizontal2 = layout.getPrimaryHorizontal(i2);
            AppMethodBeat.o(159904);
            return primaryHorizontal2;
        }
        AppMethodBeat.o(159904);
        return 0.0f;
    }

    private static int a(View view, int i2, float f2) {
        Layout layout;
        AppMethodBeat.i(159905);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int offsetForHorizontal = layout2.getOffsetForHorizontal(i2, f2);
                AppMethodBeat.o(159905);
                return offsetForHorizontal;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int offsetForHorizontal2 = layout.getOffsetForHorizontal(i2, f2);
            AppMethodBeat.o(159905);
            return offsetForHorizontal2;
        }
        AppMethodBeat.o(159905);
        return 0;
    }

    public static int aS(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159906);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int lineTop = layout2.getLineTop(i2);
                AppMethodBeat.o(159906);
                return lineTop;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int lineTop2 = layout.getLineTop(i2);
            AppMethodBeat.o(159906);
            return lineTop2;
        }
        AppMethodBeat.o(159906);
        return 0;
    }

    private static int aT(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159907);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int lineBottom = layout2.getLineBottom(i2);
                AppMethodBeat.o(159907);
                return lineBottom;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int lineBottom2 = layout.getLineBottom(i2);
            AppMethodBeat.o(159907);
            return lineBottom2;
        }
        AppMethodBeat.o(159907);
        return 0;
    }

    public static float aU(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159908);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                float lineWidth = layout2.getLineWidth(i2);
                AppMethodBeat.o(159908);
                return lineWidth;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            float lineWidth2 = layout.getLineWidth(i2);
            AppMethodBeat.o(159908);
            return lineWidth2;
        }
        AppMethodBeat.o(159908);
        return 0.0f;
    }

    public static int aV(View view, int i2) {
        int i3;
        Layout layout;
        AppMethodBeat.i(159909);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                i3 = layout2.getLineStart(i2);
            }
            i3 = 0;
        } else {
            if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
                i3 = layout.getLineStart(i2);
            }
            i3 = 0;
        }
        if (i3 >= 0) {
            AppMethodBeat.o(159909);
            return i3;
        }
        AppMethodBeat.o(159909);
        return 0;
    }

    private static int aW(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159910);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                int lineForVertical = layout2.getLineForVertical(i2);
                AppMethodBeat.o(159910);
                return lineForVertical;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            int lineForVertical2 = layout.getLineForVertical(i2);
            AppMethodBeat.o(159910);
            return lineForVertical2;
        }
        AppMethodBeat.o(159910);
        return 0;
    }

    private static float aX(View view, int i2) {
        Layout layout;
        AppMethodBeat.i(159911);
        if (view instanceof NeatTextView) {
            a layout2 = ((NeatTextView) view).getLayout();
            if (layout2 != null) {
                float lineRight = layout2.getLineRight(i2);
                AppMethodBeat.o(159911);
                return lineRight;
            }
        } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            float lineRight2 = layout.getLineRight(i2);
            AppMethodBeat.o(159911);
            return lineRight2;
        }
        AppMethodBeat.o(159911);
        return 0.0f;
    }

    public static int hD(View view) {
        AppMethodBeat.i(198545);
        if (view instanceof NeatTextView) {
            int lineHeight = ((NeatTextView) view).getLineHeight();
            AppMethodBeat.o(198545);
            return lineHeight;
        } else if (view instanceof TextView) {
            int lineHeight2 = ((TextView) view).getLineHeight();
            AppMethodBeat.o(198545);
            return lineHeight2;
        } else {
            AppMethodBeat.o(198545);
            return 0;
        }
    }
}

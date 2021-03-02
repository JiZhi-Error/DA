package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.support.v4.d.c;
import android.support.v4.e.m;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class q {
    private static Field Wn;
    private static boolean Wo;
    private static Field Wp;
    private static boolean Wq;

    private static Field B(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e2) {
            new StringBuilder("Could not retrieve ").append(str).append(" field.");
            return field;
        }
    }

    private static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e2) {
            new StringBuilder("Could not retrieve value of ").append(field.getName()).append(" field.");
            return -1;
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable drawable5;
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = textView.getLayoutDirection() == 1;
            if (z) {
                drawable5 = drawable3;
            } else {
                drawable5 = drawable;
            }
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static int b(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!Wq) {
            Wp = B("mMaxMode");
            Wq = true;
        }
        if (Wp != null && a(Wp, textView) == 1) {
            if (!Wo) {
                Wn = B("mMaximum");
                Wo = true;
            }
            if (Wn != null) {
                return a(Wn, textView);
            }
        }
        return -1;
    }

    public static void d(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static Drawable[] c(TextView textView) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return textView.getCompoundDrawables();
        }
        if (textView.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static void d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(1);
        } else if (textView instanceof b) {
            ((b) textView).setAutoSizeTextTypeWithDefaults(1);
        }
    }

    public static ActionMode.Callback a(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }

    static class a implements ActionMode.Callback {
        private final ActionMode.Callback Wr;
        private final TextView Ws;
        private Class Wt;
        private Method Wu;
        private boolean Wv;
        private boolean Ww = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.Wr = callback;
            this.Ws = textView;
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.Wr.onCreateActionMode(actionMode, menu);
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Method declaredMethod;
            boolean z;
            Context context = this.Ws.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.Ww) {
                this.Ww = true;
                try {
                    this.Wt = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.Wu = this.Wt.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.Wv = true;
                } catch (ClassNotFoundException | NoSuchMethodException e2) {
                    this.Wt = null;
                    this.Wu = null;
                    this.Wv = false;
                }
            }
            try {
                if (!this.Wv || !this.Wt.isInstance(menu)) {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                } else {
                    declaredMethod = this.Wu;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(gn(), 0)) {
                        if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                            z = true;
                        } else {
                            z = resolveInfo.activityInfo.exported && (resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0);
                        }
                        if (z) {
                            arrayList.add(resolveInfo);
                        }
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i2);
                    MenuItem add = menu.add(0, 0, i2 + 100, resolveInfo2.loadLabel(packageManager));
                    TextView textView = this.Ws;
                    add.setIntent(gn().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled())).setClassName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            }
            return this.Wr.onPrepareActionMode(actionMode, menu);
        }

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.Wr.onActionItemClicked(actionMode, menuItem);
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
            this.Wr.onDestroyActionMode(actionMode);
        }

        private static Intent gn() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    public static void e(TextView textView, int i2) {
        int i3;
        m.aL(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 - (-i3), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void f(TextView textView, int i2) {
        int i3;
        m.aL(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void g(TextView textView, int i2) {
        m.aL(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static c.a e(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 28) {
            return new c.a(textView.getTextMetricsParams());
        }
        c.a.C0023a aVar = new c.a.C0023a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            aVar.On = textView.getBreakStrategy();
            aVar.Oo = textView.getHyphenationFrequency();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            } else if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
                if (textView.getLayoutDirection() != 1) {
                    z = false;
                }
                switch (textView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    default:
                        if (!z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        }
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                }
            } else {
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality == 1 || directionality == 2) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
            }
            aVar.Om = textDirectionHeuristic;
        }
        return new c.a(aVar.Ol, aVar.Om, aVar.On, aVar.Oo);
    }

    public static void a(TextView textView, c cVar) {
        PrecomputedText precomputedText;
        if (Build.VERSION.SDK_INT >= 28) {
            if (cVar.Oi instanceof PrecomputedText) {
                precomputedText = (PrecomputedText) cVar.Oi;
            } else {
                precomputedText = null;
            }
            textView.setText(precomputedText);
        } else if (!e(textView).equals(cVar.Oj)) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        } else {
            textView.setText(cVar);
        }
    }
}

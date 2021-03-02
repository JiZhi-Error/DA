package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.support.v7.view.d;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new android.support.v4.e.a();
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {16843375};
    private final Object[] mConstructorArgs = new Object[2];

    /* access modifiers changed from: package-private */
    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View createSeekBar;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = aw.ae(context2);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                createSeekBar = createTextView(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 1:
                createSeekBar = createImageView(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 2:
                createSeekBar = createButton(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 3:
                createSeekBar = createEditText(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 4:
                createSeekBar = createSpinner(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 5:
                createSeekBar = createImageButton(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 6:
                createSeekBar = createCheckBox(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 7:
                createSeekBar = createRadioButton(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case '\b':
                createSeekBar = createCheckedTextView(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case '\t':
                createSeekBar = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case '\n':
                createSeekBar = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case 11:
                createSeekBar = createRatingBar(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            case '\f':
                createSeekBar = createSeekBar(context2, attributeSet);
                verifyNotNull(createSeekBar, str);
                break;
            default:
                createSeekBar = createView(context2, str, attributeSet);
                break;
        }
        if (createSeekBar != null || context == context2) {
            view2 = createSeekBar;
        } else {
            view2 = createViewFromTag(context2, str, attributeSet);
        }
        if (view2 != null) {
            checkOnClickListener(view2, attributeSet);
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    private void verifyNotNull(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (int i2 = 0; i2 < sClassPrefixList.length; i2++) {
                    View createViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i2]);
                    if (createViewByPrefix != null) {
                        return createViewByPrefix;
                    }
                }
                this.mConstructorArgs[0] = null;
                this.mConstructorArgs[1] = null;
                return null;
            }
            View createViewByPrefix2 = createViewByPrefix(context, str, null);
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return createViewByPrefix2;
        } catch (Exception e2) {
            return null;
        } finally {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || u.aE(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) {
        Constructor<? extends View> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            } catch (Exception e2) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int i2;
        int i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.View, 0, 0);
        if (z) {
            i2 = obtainStyledAttributes.getResourceId(0, 0);
        } else {
            i2 = 0;
        }
        if (!z2 || i2 != 0) {
            i3 = i2;
        } else {
            i3 = obtainStyledAttributes.getResourceId(4, 0);
        }
        obtainStyledAttributes.recycle();
        if (i3 == 0) {
            return context;
        }
        if (!(context instanceof d) || ((d) context).adF != i3) {
            return new d(context, i3);
        }
        return context;
    }

    /* access modifiers changed from: package-private */
    public static class a implements View.OnClickListener {
        private final View ZI;
        private final String ZJ;
        private Method ZK;
        private Context ZL;

        public a(View view, String str) {
            this.ZI = view;
            this.ZJ = str;
        }

        public final void onClick(View view) {
            String str;
            Method method;
            if (this.ZK == null) {
                Context context = this.ZI.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.ZJ, View.class)) != null) {
                            this.ZK = method;
                            this.ZL = context;
                        }
                    } catch (NoSuchMethodException e2) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                }
                int id = this.ZI.getId();
                if (id == -1) {
                    str = "";
                } else {
                    str = " with id '" + this.ZI.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + this.ZJ + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.ZI.getClass() + str);
            }
            try {
                this.ZK.invoke(this.ZL, view);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }
}

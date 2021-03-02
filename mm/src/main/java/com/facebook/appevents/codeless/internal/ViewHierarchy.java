package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.j;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy {
    private static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
    private static final int BUTTON_BITMASK = 2;
    private static final int CHECKBOX_BITMASK = 15;
    private static final String CHILDREN_VIEW_KEY = "childviews";
    private static final String CLASS_NAME_KEY = "classname";
    private static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
    private static final int CLICKABLE_VIEW_BITMASK = 5;
    private static final String DESC_KEY = "description";
    private static final String DIMENSION_HEIGHT_KEY = "height";
    private static final String DIMENSION_KEY = "dimension";
    private static final String DIMENSION_LEFT_KEY = "left";
    private static final String DIMENSION_SCROLL_X_KEY = "scrollx";
    private static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
    private static final String DIMENSION_TOP_KEY = "top";
    private static final String DIMENSION_VISIBILITY_KEY = "visibility";
    private static final String DIMENSION_WIDTH_KEY = "width";
    private static final String GET_ACCESSIBILITY_METHOD = "getAccessibilityDelegate";
    private static final String HINT_KEY = "hint";
    private static final String ICON_BITMAP = "icon_image";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String ID_KEY = "id";
    private static final int IMAGEVIEW_BITMASK = 1;
    private static final int INPUT_BITMASK = 11;
    private static final int LABEL_BITMASK = 10;
    private static final int PICKER_BITMASK = 12;
    private static final int RADIO_GROUP_BITMASK = 14;
    private static final int RATINGBAR_BITMASK = 16;
    private static final int REACT_NATIVE_BUTTON_BITMASK = 6;
    private static final int SWITCH_BITMASK = 13;
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static final String TAG_KEY = "tag";
    private static final int TEXTVIEW_BITMASK = 0;
    private static final String TEXT_IS_BOLD = "is_bold";
    private static final String TEXT_IS_ITALIC = "is_italic";
    private static final String TEXT_KEY = "text";
    private static final String TEXT_SIZE = "font_size";
    private static final String TEXT_STYLE = "text_style";

    static {
        AppMethodBeat.i(17568);
        AppMethodBeat.o(17568);
    }

    public static ViewGroup getParentOfView(View view) {
        AppMethodBeat.i(17553);
        if (view == null) {
            AppMethodBeat.o(17553);
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            AppMethodBeat.o(17553);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        AppMethodBeat.o(17553);
        return viewGroup;
    }

    public static List<View> getChildrenOfView(View view) {
        AppMethodBeat.i(17554);
        ArrayList arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                arrayList.add(viewGroup.getChildAt(i2));
            }
        }
        AppMethodBeat.o(17554);
        return arrayList;
    }

    public static JSONObject setBasicInfoOfView(View view, JSONObject jSONObject) {
        AppMethodBeat.i(17555);
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put(TEXT_KEY, textOfView);
            } else {
                jSONObject.put(TEXT_KEY, "");
            }
            jSONObject.put(HINT_KEY, hintOfView);
            if (tag != null) {
                jSONObject.put(TAG_KEY, tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put("description", contentDescription.toString());
            }
            jSONObject.put(DIMENSION_KEY, getDimensionOfView(view));
        } catch (JSONException e2) {
            Utility.logd(TAG, e2);
        }
        AppMethodBeat.o(17555);
        return jSONObject;
    }

    public static JSONObject setAppearanceOfView(View view, JSONObject jSONObject, float f2) {
        TextView textView;
        Typeface typeface;
        AppMethodBeat.i(17556);
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put(TEXT_SIZE, (double) textView.getTextSize());
                jSONObject2.put(TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(TEXT_STYLE, jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f2 <= 44.0f && ((float) view.getWidth()) / f2 <= 44.0f) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (JSONException e2) {
            Utility.logd(TAG, e2);
        }
        AppMethodBeat.o(17556);
        return jSONObject;
    }

    public static JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        AppMethodBeat.i(17557);
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject basicInfoOfView = setBasicInfoOfView(view, jSONObject2);
            try {
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                for (int i2 = 0; i2 < childrenOfView.size(); i2++) {
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i2)));
                }
                basicInfoOfView.put(CHILDREN_VIEW_KEY, jSONArray);
                jSONObject = basicInfoOfView;
            } catch (JSONException e2) {
                jSONObject = basicInfoOfView;
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
        }
        AppMethodBeat.o(17557);
        return jSONObject;
    }

    private static int getClassTypeBitmask(View view) {
        AppMethodBeat.i(17558);
        int i2 = 0;
        if (view instanceof ImageView) {
            i2 = 2;
        }
        if (isClickableView(view)) {
            i2 |= 32;
        }
        if (isAdapterViewItem(view)) {
            i2 |= 512;
        }
        if (view instanceof TextView) {
            i2 = i2 | 1024 | 1;
            if (view instanceof Button) {
                i2 |= 4;
                if (view instanceof Switch) {
                    i2 |= 8192;
                } else if (view instanceof CheckBox) {
                    i2 |= 32768;
                }
            }
            if (view instanceof EditText) {
                i2 |= 2048;
            }
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            i2 |= 4096;
        } else if (view instanceof RatingBar) {
            i2 |= 65536;
        } else if (view instanceof RadioGroup) {
            i2 |= 16384;
        } else if ((view instanceof ViewGroup) && isRCTButton(view)) {
            i2 |= 64;
        }
        AppMethodBeat.o(17558);
        return i2;
    }

    public static boolean isClickableView(View view) {
        AppMethodBeat.i(17559);
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                AppMethodBeat.o(17559);
                return false;
            }
            View.OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (View.OnClickListener) declaredField2.get(obj);
            }
            if (onClickListener != null) {
                AppMethodBeat.o(17559);
                return true;
            }
            AppMethodBeat.o(17559);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.o(17559);
            return false;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        AppMethodBeat.i(17560);
        ViewParent parent = view.getParent();
        if (parent == null || (!(parent instanceof AdapterView) && !(parent instanceof j))) {
            AppMethodBeat.o(17560);
            return false;
        }
        AppMethodBeat.o(17560);
        return true;
    }

    public static String getTextOfView(View view) {
        String valueOf;
        AppMethodBeat.i(17561);
        if (view instanceof TextView) {
            valueOf = ((TextView) view).getText();
            if (view instanceof Switch) {
                valueOf = ((Switch) view).isChecked() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
        } else if (view instanceof Spinner) {
            Object selectedItem = ((Spinner) view).getSelectedItem();
            valueOf = selectedItem != null ? selectedItem.toString() : null;
        } else if (view instanceof DatePicker) {
            DatePicker datePicker = (DatePicker) view;
            valueOf = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
        } else if (view instanceof TimePicker) {
            TimePicker timePicker = (TimePicker) view;
            valueOf = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
        } else if (view instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) view;
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            int childCount = radioGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    valueOf = null;
                    break;
                }
                View childAt = radioGroup.getChildAt(i2);
                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                    valueOf = ((RadioButton) childAt).getText();
                    break;
                }
                i2++;
            }
        } else {
            valueOf = view instanceof RatingBar ? String.valueOf(((RatingBar) view).getRating()) : null;
        }
        if (valueOf == null) {
            AppMethodBeat.o(17561);
            return "";
        }
        String obj = valueOf.toString();
        AppMethodBeat.o(17561);
        return obj;
    }

    public static String getHintOfView(View view) {
        AppMethodBeat.i(17562);
        CharSequence charSequence = null;
        if (view instanceof TextView) {
            charSequence = ((TextView) view).getHint();
        } else if (view instanceof EditText) {
            charSequence = ((EditText) view).getHint();
        }
        if (charSequence == null) {
            AppMethodBeat.o(17562);
            return "";
        }
        String obj = charSequence.toString();
        AppMethodBeat.o(17562);
        return obj;
    }

    private static JSONObject getDimensionOfView(View view) {
        AppMethodBeat.i(17563);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put(DIMENSION_LEFT_KEY, view.getLeft());
            jSONObject.put(DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put(DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(17563);
        return jSONObject;
    }

    public static View.AccessibilityDelegate getExistingDelegate(View view) {
        AppMethodBeat.i(17564);
        try {
            View.AccessibilityDelegate accessibilityDelegate = (View.AccessibilityDelegate) view.getClass().getMethod(GET_ACCESSIBILITY_METHOD, new Class[0]).invoke(view, new Object[0]);
            AppMethodBeat.o(17564);
            return accessibilityDelegate;
        } catch (NoSuchMethodException e2) {
            AppMethodBeat.o(17564);
            return null;
        } catch (NullPointerException e3) {
            AppMethodBeat.o(17564);
            return null;
        } catch (SecurityException e4) {
            AppMethodBeat.o(17564);
            return null;
        } catch (IllegalAccessException e5) {
            AppMethodBeat.o(17564);
            return null;
        } catch (InvocationTargetException e6) {
            AppMethodBeat.o(17564);
            return null;
        }
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        View.OnTouchListener onTouchListener;
        AppMethodBeat.i(17565);
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                AppMethodBeat.o(17565);
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                onTouchListener = (View.OnTouchListener) declaredField2.get(obj);
            } else {
                onTouchListener = null;
            }
            AppMethodBeat.o(17565);
            return onTouchListener;
        } catch (NoSuchFieldException e2) {
            Utility.logd(TAG, e2);
            AppMethodBeat.o(17565);
            return null;
        } catch (ClassNotFoundException e3) {
            Utility.logd(TAG, e3);
            AppMethodBeat.o(17565);
            return null;
        } catch (IllegalAccessException e4) {
            Utility.logd(TAG, e4);
            AppMethodBeat.o(17565);
            return null;
        }
    }

    public static boolean isRCTButton(View view) {
        AppMethodBeat.i(17566);
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup") || getExistingDelegate(view) == null || ((ViewGroup) view).getChildCount() <= 0) {
            AppMethodBeat.o(17566);
            return false;
        }
        AppMethodBeat.o(17566);
        return true;
    }

    public static boolean isRCTTextView(View view) {
        AppMethodBeat.i(17567);
        boolean equals = view.getClass().getName().equals("com.facebook.react.views.view.ReactTextView");
        AppMethodBeat.o(17567);
        return equals;
    }
}

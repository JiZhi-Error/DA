package com.tencent.mm.accessibility;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewSearchTool {
    private static final String GET_DEFAULT_IMPL = "getDefault";
    private static final String GET_GLOBAL_INSTANCE = "getInstance";
    private static final String TAG = "ViewSearchTool";
    private static final String VIEWS_FIELD = "mViews";
    private static final String WINDOW_MANAGER_GLOBAL_CLAZZ = "android.view.WindowManagerGlobal";
    private static final String WINDOW_MANAGER_IMPL_CLAZZ = "android.view.WindowManagerImpl";
    private static final String WINDOW_PARAMS_FIELD = "mParams";

    public interface Matcher {
        boolean match(View view);
    }

    private List<View> findRoots() {
        List<View> list;
        AppMethodBeat.i(160021);
        String str = Build.VERSION.SDK_INT > 16 ? WINDOW_MANAGER_GLOBAL_CLAZZ : WINDOW_MANAGER_IMPL_CLAZZ;
        String str2 = Build.VERSION.SDK_INT > 16 ? GET_GLOBAL_INSTANCE : GET_DEFAULT_IMPL;
        Class<?> cls = Class.forName(str);
        Object invoke = cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField(VIEWS_FIELD);
        declaredField.setAccessible(true);
        cls.getDeclaredField(WINDOW_PARAMS_FIELD).setAccessible(true);
        if (Build.VERSION.SDK_INT < 19) {
            list = Arrays.asList((View[]) declaredField.get(invoke));
        } else {
            list = (List) declaredField.get(invoke);
        }
        if (list.size() == 0) {
            RuntimeException runtimeException = new RuntimeException("something wrong");
            AppMethodBeat.o(160021);
            throw runtimeException;
        }
        AppMethodBeat.o(160021);
        return list;
    }

    public List<View> findView(Matcher matcher) {
        AppMethodBeat.i(160022);
        for (View view : findRoots()) {
            List<View> filter = filter(view, matcher);
            if (filter != null && filter.size() > 0) {
                AppMethodBeat.o(160022);
                return filter;
            }
        }
        AppMethodBeat.o(160022);
        return null;
    }

    private List<View> filter(View view, Matcher matcher) {
        AppMethodBeat.i(160023);
        ArrayList<List> arrayList = new ArrayList();
        arrayList.add(0, Collections.singletonList(view));
        int i2 = 0;
        while (true) {
            ArrayList arrayList2 = new ArrayList();
            for (View view2 : (List) arrayList.get(i2)) {
                if (view2 instanceof ViewGroup) {
                    for (int i3 = 0; i3 < ((ViewGroup) view2).getChildCount(); i3++) {
                        arrayList2.add(((ViewGroup) view2).getChildAt(i3));
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            arrayList.add(arrayList2);
            i2++;
        }
        ArrayList arrayList3 = new ArrayList();
        for (List<View> list : arrayList) {
            for (View view3 : list) {
                if (matcher.match(view3)) {
                    arrayList3.add(view3);
                }
            }
        }
        AppMethodBeat.o(160023);
        return arrayList3;
    }

    @Deprecated
    public static String findText(View view) {
        AppMethodBeat.i(160024);
        if (view == null) {
            AppMethodBeat.o(160024);
            return null;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null && (((childAt instanceof ViewGroup) || (childAt instanceof TextView)) && (contentDescription = findText(childAt)) != null)) {
                        break;
                    }
                }
            } else if (view instanceof TextView) {
                contentDescription = ((TextView) view).getText();
            }
            if (contentDescription != null) {
                String charSequence = contentDescription.toString();
                AppMethodBeat.o(160024);
                return charSequence;
            }
            AppMethodBeat.o(160024);
            return null;
        }
        String charSequence2 = contentDescription.toString();
        AppMethodBeat.o(160024);
        return charSequence2;
    }

    @Deprecated
    public static String findViewDepth(View view, View view2, String str) {
        AppMethodBeat.i(160025);
        if (view == null || view2 == null) {
            AppMethodBeat.o(160025);
            return null;
        }
        if (str == null) {
            str = "";
        }
        if (view.equals(view2)) {
            if (str.startsWith("_")) {
                str = str.substring(1);
            }
            AppMethodBeat.o(160025);
            return str;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                String findViewDepth = findViewDepth(viewGroup.getChildAt(i2), view2, str + "_" + i2);
                if (findViewDepth != null && !findViewDepth.equals("")) {
                    if (findViewDepth.startsWith("_")) {
                        findViewDepth = findViewDepth.substring(1);
                    }
                    AppMethodBeat.o(160025);
                    return findViewDepth;
                }
            }
        }
        AppMethodBeat.o(160025);
        return null;
    }
}

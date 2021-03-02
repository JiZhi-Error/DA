package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaViewLayoutFactory implements LayoutInflater.Factory {
    private static YogaViewLayoutFactory sYogaViewLayoutFactory;

    public static YogaViewLayoutFactory getInstance() {
        AppMethodBeat.i(18259);
        if (sYogaViewLayoutFactory == null) {
            sYogaViewLayoutFactory = new YogaViewLayoutFactory();
        }
        YogaViewLayoutFactory yogaViewLayoutFactory = sYogaViewLayoutFactory;
        AppMethodBeat.o(18259);
        return yogaViewLayoutFactory;
    }

    YogaViewLayoutFactory() {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(18260);
        if (YogaLayout.class.getSimpleName().equals(str)) {
            YogaLayout yogaLayout = new YogaLayout(context, attributeSet);
            AppMethodBeat.o(18260);
            return yogaLayout;
        } else if (VirtualYogaLayout.class.getSimpleName().equals(str)) {
            VirtualYogaLayout virtualYogaLayout = new VirtualYogaLayout(context, attributeSet);
            AppMethodBeat.o(18260);
            return virtualYogaLayout;
        } else {
            AppMethodBeat.o(18260);
            return null;
        }
    }
}

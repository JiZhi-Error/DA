package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f {
    public static View d(RecyclerView recyclerView, int i2) {
        View view;
        AppMethodBeat.i(30622);
        if (recyclerView == null) {
            AppMethodBeat.o(30622);
            return null;
        }
        try {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                view = ((LinearLayoutManager) layoutManager).findViewByPosition(i2);
                AppMethodBeat.o(30622);
                return view;
            }
        } catch (Exception e2) {
        }
        view = null;
        AppMethodBeat.o(30622);
        return view;
    }

    public static c gh(View view) {
        c cVar;
        AppMethodBeat.i(30623);
        if (view == null) {
            AppMethodBeat.o(30623);
            return null;
        }
        WXRTEditText wXRTEditText = (WXRTEditText) view.findViewById(R.id.h9p);
        WXRTEditText wXRTEditText2 = (WXRTEditText) view.findViewById(R.id.aef);
        WXRTEditText wXRTEditText3 = (WXRTEditText) view.findViewById(R.id.aed);
        if (wXRTEditText != null) {
            cVar = new c(wXRTEditText);
        } else {
            cVar = (wXRTEditText2 == null || wXRTEditText3 == null) ? null : new c(wXRTEditText2, wXRTEditText3);
        }
        AppMethodBeat.o(30623);
        return cVar;
    }
}

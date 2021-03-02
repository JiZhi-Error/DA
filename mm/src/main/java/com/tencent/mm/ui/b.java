package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private int KmP;
    private boolean Oxj = false;
    private a Oxk;
    private View Oxl;
    private int Oxm;
    private ViewGroup.LayoutParams Oxn;
    private int Oxo;
    private Context mContext;

    public interface a {
        void bQ(boolean z);
    }

    public static void e(Activity activity, boolean z) {
        AppMethodBeat.i(141273);
        new b(activity, z);
        AppMethodBeat.o(141273);
    }

    public static void a(Activity activity, boolean z, View view, a aVar) {
        AppMethodBeat.i(141274);
        new b(activity, z, view, aVar);
        AppMethodBeat.o(141274);
    }

    private b(Activity activity, boolean z) {
        AppMethodBeat.i(141275);
        this.mContext = activity;
        this.Oxj = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (frameLayout == null) {
            AppMethodBeat.o(141275);
            return;
        }
        this.Oxl = frameLayout.getChildAt(0);
        this.Oxl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.b.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(141271);
                b.a(b.this);
                AppMethodBeat.o(141271);
            }
        });
        this.Oxn = this.Oxl.getLayoutParams();
        AppMethodBeat.o(141275);
    }

    private b(Activity activity, boolean z, View view, a aVar) {
        AppMethodBeat.i(141276);
        this.mContext = activity;
        this.Oxj = z;
        this.Oxl = view;
        this.Oxk = aVar;
        this.Oxl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.b.AnonymousClass2 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(141272);
                b.a(b.this);
                AppMethodBeat.o(141272);
            }
        });
        this.Oxn = this.Oxl.getLayoutParams();
        AppMethodBeat.o(141276);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.b r9) {
        /*
        // Method dump skipped, instructions count: 205
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.b.a(com.tencent.mm.ui.b):void");
    }
}

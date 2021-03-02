package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public final class a extends c {
    private static final int VIEW_ID = R.id.pz;

    public static a dj(View view) {
        AppMethodBeat.i(137966);
        a aVar = (a) view.getRootView().findViewById(VIEW_ID);
        AppMethodBeat.o(137966);
        return aVar;
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(137967);
        super.setId(VIEW_ID);
        setBackgroundResource(R.color.ac_);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(137965);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandBottomPicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandBottomPicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137965);
            }
        });
        AppMethodBeat.o(137967);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.picker.c
    public final void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(137968);
        if (isShown()) {
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i4 = 0;
            } else {
                i4 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i4 > 0) {
                eM(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                AppMethodBeat.o(137968);
                return;
            }
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(137968);
    }

    public final void setId(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.c
    public final void setHeader(String str) {
        AppMethodBeat.i(137969);
        super.setHeader(str);
        AppMethodBeat.o(137969);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.c
    public final void show() {
        AppMethodBeat.i(137970);
        super.show();
        AppMethodBeat.o(137970);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.c
    public final void hide() {
        AppMethodBeat.i(137971);
        super.hide();
        AppMethodBeat.o(137971);
    }
}

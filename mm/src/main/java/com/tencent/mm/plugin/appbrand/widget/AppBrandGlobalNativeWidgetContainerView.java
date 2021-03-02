package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView extends AbsoluteLayout implements as, bv, bz {
    private final AbsoluteLayout ojW = this;
    private final List<bv.a> ojX = new LinkedList();

    public AppBrandGlobalNativeWidgetContainerView(Context context) {
        super(context);
        AppMethodBeat.i(219596);
        AppMethodBeat.o(219596);
    }

    public AppBrandGlobalNativeWidgetContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(219597);
        AppMethodBeat.o(219597);
    }

    public AppBrandGlobalNativeWidgetContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(219598);
        AppMethodBeat.o(219598);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.as
    public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(219599);
        Log.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (this.ojW != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (this.ojW != null) {
                ViewGroup.LayoutParams layoutParams = this.ojW.getLayoutParams();
                if (layoutParams == null) {
                    this.ojW.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                } else if (!(width == layoutParams.width && height == layoutParams.height)) {
                    layoutParams.width = width;
                    layoutParams.height = height;
                    this.ojW.setLayoutParams(layoutParams);
                }
            }
            this.ojW.scrollTo(i2, i3);
        }
        for (bv.a aVar : this.ojX) {
            aVar.eu(i2, i3);
        }
        AppMethodBeat.o(219599);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bv
    public final void a(bv.a aVar) {
        AppMethodBeat.i(219600);
        if (aVar == null) {
            AppMethodBeat.o(219600);
        } else if (this.ojX.contains(aVar)) {
            AppMethodBeat.o(219600);
        } else {
            this.ojX.add(aVar);
            AppMethodBeat.o(219600);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bv
    public final void b(bv.a aVar) {
        AppMethodBeat.i(219601);
        if (aVar == null) {
            AppMethodBeat.o(219601);
            return;
        }
        this.ojX.remove(aVar);
        AppMethodBeat.o(219601);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(219602);
        draw(canvas);
        AppMethodBeat.o(219602);
        return true;
    }
}

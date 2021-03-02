package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bf;

public final class b extends FrameLayout implements bf {
    private AbstractC0174b cwJ = null;

    /* renamed from: com.tencent.luggage.game.page.b$b  reason: collision with other inner class name */
    public interface AbstractC0174b {
        void ca(View view);
    }

    public b(Context context) {
        super(context);
    }

    public final void setNativeWidgetAddedCallback(AbstractC0174b bVar) {
        this.cwJ = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final ViewGroup getContainer() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void setupWebViewTouchInterceptor(bb bbVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void a(bb bbVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void a(az azVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.aj.b
    public final void hK(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.as
    public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(130626);
        super.onViewAdded(view);
        if ((view instanceof CoverViewContainer) && !view.hasOnClickListeners()) {
            view.setOnTouchListener(new a((byte) 0));
        }
        if (this.cwJ != null) {
            this.cwJ.ca(view);
        }
        AppMethodBeat.o(130626);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ap
    public final void c(boolean z, int i2, int i3, int i4, int i5) {
    }

    static final class a implements View.OnTouchListener {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }
}

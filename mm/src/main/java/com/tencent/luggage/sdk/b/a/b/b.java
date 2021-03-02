package com.tencent.luggage.sdk.b.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mIsKeyboardShowing", "", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"})
public final class b implements i.b, i.c, i.d, u.c {
    public static final a cAm = new a((byte) 0);
    private final af cAj;
    private u cAk;
    private boolean cAl;
    private int crC;
    private final ac cwK;

    static {
        AppMethodBeat.i(147831);
        AppMethodBeat.o(147831);
    }

    private /* synthetic */ b(ac acVar, byte b2) {
        this(acVar);
    }

    private b(ac acVar) {
        AppMethodBeat.i(147830);
        this.cwK = acVar;
        this.cAj = new af();
        AppMethodBeat.o(147830);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
    public final void hF(int i2) {
        this.crC = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
    public final void bQ(boolean z) {
        AppMethodBeat.i(147826);
        this.cAl = z;
        af afVar = this.cAj;
        int i2 = z ? this.crC : 0;
        s NY = this.cwK.NY();
        p.g(NY, "mPageView.service");
        af.a(afVar, i2, NY, this.cwK);
        AppMethodBeat.o(147826);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
    public final int getHeight() {
        return this.crC;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public final void onDestroy() {
        AppMethodBeat.i(147827);
        u uVar = this.cAk;
        if (uVar != null) {
            uVar.b(this);
            AppMethodBeat.o(147827);
            return;
        }
        AppMethodBeat.o(147827);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
    public final void onBackground() {
        AppMethodBeat.i(147828);
        if (this.cAl && this.cwK.NY() != null) {
            af afVar = this.cAj;
            s NY = this.cwK.NY();
            p.g(NY, "mPageView.service");
            af.a(afVar, 0, NY, this.cwK);
        }
        u uVar = this.cAk;
        if (uVar != null) {
            uVar.b(this);
            AppMethodBeat.o(147828);
            return;
        }
        AppMethodBeat.o(147828);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
    public final void onForeground() {
        AppMethodBeat.i(147829);
        if (this.cwK.getContentView() == null) {
            AppMethodBeat.o(147829);
            return;
        }
        View contentView = this.cwK.getContentView();
        if (contentView == null) {
            p.hyc();
        }
        this.cAk = n.cY(contentView);
        u uVar = this.cAk;
        if (uVar != null) {
            uVar.a(this);
            AppMethodBeat.o(147829);
            return;
        }
        AppMethodBeat.o(147829);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter$Companion;", "", "()V", "install", "", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void a(ac acVar) {
        AppMethodBeat.i(147832);
        p.h(acVar, "pv");
        b bVar = new b(acVar, (byte) 0);
        acVar.a((i.d) bVar);
        acVar.a((i.b) bVar);
        acVar.a((i.c) bVar);
        AppMethodBeat.o(147832);
    }
}

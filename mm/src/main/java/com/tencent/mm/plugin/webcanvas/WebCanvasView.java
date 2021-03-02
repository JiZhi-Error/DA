package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.webcanvas.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canvasId", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "lastCanvasId", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "type", "data", "onAttachedToWindow", "onDestroy", "onPause", "onResume", "webview-sdk_release"})
public abstract class WebCanvasView extends FrameLayout implements f {
    private String IAQ;
    private final String TAG;
    private String lAN;

    public WebCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public abstract c getJsEngine();

    private /* synthetic */ WebCanvasView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        this.TAG = "MicroMsg.WebCanvasView:" + hashCode();
        this.lAN = "";
        this.IAQ = "none";
    }

    public final String getCanvasId() {
        return this.lAN;
    }

    /* access modifiers changed from: protected */
    public final void setCanvasId(String str) {
        p.h(str, "<set-?>");
        this.lAN = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Log.i(this.TAG, "onAttachedToWindow#" + this.lAN);
        Context context = getContext();
        if (!(context instanceof g)) {
            context = null;
        }
        g gVar = (g) context;
        if (gVar != null) {
            gVar.a(this);
        }
        super.onAttachedToWindow();
    }

    public final void bb(String str, String str2, String str3) {
        p.h(str, "canvasId");
        p.h(str2, "type");
        p.h(str3, "data");
        this.lAN = str;
        Log.i(this.TAG, "init:#".concat(String.valueOf(str)));
        c jsEngine = getJsEngine();
        Context context = getContext();
        p.g(context, "context");
        a a2 = jsEngine.a(str2, str, str3, context);
        WebCanvasView webCanvasView = this;
        p.h(webCanvasView, "view");
        ArrayList<View> arrayList = new ArrayList();
        int childCount = webCanvasView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            arrayList.add(webCanvasView.getChildAt(i2));
        }
        for (View view : arrayList) {
            if (!p.j(view, a2.MQ())) {
                webCanvasView.removeView(view);
            }
        }
        a2.fWl().cna().eQ(webCanvasView.getContext());
        n nVar = a2.IyU;
        if (nVar != null) {
            Context context2 = nVar.MQ().getContext();
            if (context2 == null) {
                throw new t("null cannot be cast to non-null type android.content.MutableContextWrapper");
            }
            MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context2;
            Log.i(a.TAG, "reuseCanvasView:#" + a2.lAN + ':' + nVar.IAR + '@' + nVar.biJ + " sameContext:" + p.j(mutableContextWrapper.getBaseContext(), webCanvasView.getContext()));
            if ((!p.j(mutableContextWrapper.getBaseContext(), webCanvasView.getContext())) || (!p.j(nVar.MQ().getParent(), webCanvasView))) {
                d.h(new a.h(nVar, mutableContextWrapper, a2, webCanvasView));
            } else {
                a2.e(nVar.MQ());
            }
        } else {
            n nVar2 = new n(a2, new MutableContextWrapper(webCanvasView.getContext()));
            webCanvasView.addView(nVar2.MQ());
            a2.e(nVar2.MQ());
            a2.IyU = nVar2;
            n nVar3 = a2.IyU;
            if (nVar3 != null) {
                nVar3.cYb();
            }
        }
    }

    @Override // com.tencent.mm.plugin.webcanvas.f
    public final void onDestroy() {
        if (!n.aL(this.lAN)) {
            c jsEngine = getJsEngine();
            String str = this.lAN;
            p.h(str, "canvasId");
            Log.i(jsEngine.TAG, "stop #".concat(String.valueOf(str)));
            c.a(jsEngine, "stop", str);
        }
        getJsEngine().clear();
        Log.i(this.TAG, "onDestroy");
    }

    @Override // com.tencent.mm.plugin.webcanvas.f
    public final void onPause() {
        if (!n.aL(this.lAN)) {
            getJsEngine().hd(this.lAN);
        }
    }

    @Override // com.tencent.mm.plugin.webcanvas.f
    public final void onResume() {
        if (!n.aL(this.lAN)) {
            getJsEngine().hc(this.lAN);
        }
    }
}

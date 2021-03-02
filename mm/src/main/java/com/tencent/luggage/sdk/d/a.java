package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0002[\\B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\"H\u0016J\n\u0010D\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010E\u001a\u000209H\u0016J\b\u0010F\u001a\u00020\u0018H\u0016J\u0015\u0010G\u001a\u00020H2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020NH\u0016J\u0015\u0010O\u001a\u00020H2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010P\u001a\u00020>2\u0006\u0010Q\u001a\u00020\u001aH\u0002J\b\u0010R\u001a\u00020HH\u0002J\b\u0010S\u001a\u00020HH\u0002J\u0010\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020\rH\u0016J\b\u0010V\u001a\u00020\"H\u0016J \u0010W\u001a\u00020H2\u0006\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\rH\u0002J\u0010\u0010W\u001a\u00020H2\u0006\u0010Z\u001a\u00020\rH\u0002R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u000e\u00101\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u00107R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, hxF = {"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "getScale", "getVDisplayMetrics", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"})
public abstract class a<C extends AppBrandInitConfigLU> implements f<C>, g {
    private final DisplayMetrics aJm = new DisplayMetrics();
    protected boolean cBF;
    private String cBG = "portrait";
    public View cBH;
    protected C cBI;
    private int cBJ;
    private int cBK;
    private int cBL;
    private int cBM;
    private int cBN;
    private int cBO;
    private int cBP;
    private int cBQ;
    private boolean cBR;
    private boolean cBS;
    private double cBT = -1.0d;
    private b cBU;
    private String cBV;
    private final AppBrandRuntime cBW;
    private final com.tencent.mm.plugin.appbrand.platform.window.e cBX;
    private final Context ctx;
    private int lastOrientation;
    private float scale = 1.0f;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "", "(Ljava/lang/String;I)V", "LANDSCAPE", "PORTRAIT", "luggage-wechat-full-sdk_release"})
    public enum b {
        LANDSCAPE,
        PORTRAIT;

        static {
            AppMethodBeat.i(230031);
            AppMethodBeat.o(230031);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(230033);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(230033);
            return bVar;
        }
    }

    public a(AppBrandRuntime appBrandRuntime, Context context, com.tencent.mm.plugin.appbrand.platform.window.e eVar) {
        p.h(appBrandRuntime, "rt");
        p.h(context, "ctx");
        p.h(eVar, "activityOrientationHandler");
        this.cBW = appBrandRuntime;
        this.ctx = context;
        this.cBX = eVar;
        Resources resources = this.ctx.getResources();
        p.g(resources, "ctx.resources");
        this.cBU = hR(resources.getConfiguration().orientation);
        Resources resources2 = this.ctx.getResources();
        p.g(resources2, "ctx.resources");
        this.lastOrientation = resources2.getConfiguration().orientation;
        Resources resources3 = this.ctx.getResources();
        p.g(resources3, "ctx.resources");
        this.cBO = resources3.getConfiguration().screenWidthDp;
        Resources resources4 = this.ctx.getResources();
        p.g(resources4, "ctx.resources");
        this.cBN = resources4.getConfiguration().screenHeightDp;
        OE();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JR\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016JZ\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.luggage.sdk.d.a$a  reason: collision with other inner class name */
    public static class View$OnLayoutChangeListenerC0184a implements View.OnLayoutChangeListener {
        private int cBY;

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(230030);
            this.cBY++;
            a(i2, i3, i4, i5, i6, i7, i8, i9, this.cBY);
            AppMethodBeat.o(230030);
        }

        public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        }
    }

    public final View getBgView() {
        View view = this.cBH;
        if (view == null) {
            p.btv("bgView");
        }
        return view;
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void a(C c2) {
        p.h(c2, "initConfig");
        com.tencent.mm.plugin.appbrand.widget.c brj = this.cBW.brj();
        p.g(brj, "rt.contentView");
        ViewParent parent = brj.getParent();
        if (parent == null) {
            throw new t("null cannot be cast to non-null type android.view.View");
        }
        this.cBH = (View) parent;
        this.cBI = c2;
        this.cBF = c2.cyv.cBF;
        a(true, false, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void b(C c2) {
        p.h(c2, "initConfig");
        this.cBI = c2;
        this.cBF = c2.cyv.cBF;
        if (OD()) {
            Resources resources = this.ctx.getResources();
            p.g(resources, "ctx.resources");
            Configuration configuration = resources.getConfiguration();
            p.g(configuration, "ctx.resources.configuration");
            onConfigurationChanged(configuration);
        }
        a(true, true, "onInitConfigUpdated");
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void a(com.tencent.mm.plugin.appbrand.config.b bVar) {
        a<C> aVar;
        p.h(bVar, "appConfig");
        this.cBG = "portrait";
        String str = bVar.bzF().lcB;
        if (str == null) {
            String str2 = bVar.bzH().cBG;
            if (str2 != null) {
                if (!(str2.length() == 0)) {
                    aVar = this;
                    aVar.cBG = str2;
                }
            }
            aVar = this;
            str2 = "portrait";
            aVar.cBG = str2;
        } else {
            this.cBG = str;
        }
        boolean z = bVar.cBF;
        boolean z2 = this.cBF;
        if (z2 != z) {
            this.cBF = z;
            a(true, false, "redundancy field check fail");
            Log.w("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", Boolean.valueOf(z2), Boolean.valueOf(z));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
    static final class c implements e.a {
        final /* synthetic */ a cCc;

        c(a aVar) {
            this.cCc = aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
        public final void a(e.b bVar, boolean z) {
            AppMethodBeat.i(230034);
            Log.i("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", Boolean.valueOf(z));
            if (this.cCc.cBI != null) {
                this.cCc.a(true, false, "requestDeviceOrientation done");
            }
            AppMethodBeat.o(230034);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public DisplayMetrics getVDisplayMetrics() {
        double d2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setTo(this.aJm);
        if (!this.cBR || this.cBT == -1.0d) {
            this.cBT = (((double) this.cBL) * 1.0d) / (((double) this.cBM) * 1.0d);
        }
        int i2 = this.cBL;
        int i3 = this.cBM;
        View view = this.cBH;
        if (view == null) {
            p.btv("bgView");
        }
        if (view.isLaidOut()) {
            View view2 = this.cBH;
            if (view2 == null) {
                p.btv("bgView");
            }
            int measuredWidth = view2.getMeasuredWidth();
            View view3 = this.cBH;
            if (view3 == null) {
                p.btv("bgView");
            }
            i2 = j.mZ(measuredWidth, view3.getMeasuredHeight());
            View view4 = this.cBH;
            if (view4 == null) {
                p.btv("bgView");
            }
            int measuredWidth2 = view4.getMeasuredWidth();
            View view5 = this.cBH;
            if (view5 == null) {
                p.btv("bgView");
            }
            i3 = j.na(measuredWidth2, view5.getMeasuredHeight());
            if (!this.cBR || this.cBT == -1.0d) {
                this.cBT = (((double) i2) * 1.0d) / (((double) i3) * 1.0d);
            }
        }
        if (this.cBT <= 1.3333333333333333d || this.cBT >= 2.6666666666666665d) {
            d2 = 1.7777777777777777d;
        } else {
            d2 = this.cBT;
        }
        displayMetrics.setTo(this.aJm);
        if (this.cBU != b.PORTRAIT) {
            d2 = 1.0d / d2;
        }
        Log.i("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", Double.valueOf(d2), Double.valueOf(this.cBT), Boolean.valueOf(this.cBR));
        float f2 = 1.0f;
        if (this.cBT >= 1.3333333333333333d && !this.cBR) {
            f2 = 0.75f;
        }
        if (!this.cBR || this.cBQ == 0 || this.cBP == 0) {
            if (this.cBU == b.PORTRAIT) {
                displayMetrics.heightPixels = (int) (((float) i2) * f2);
                displayMetrics.widthPixels = (int) (((double) displayMetrics.heightPixels) / d2);
            } else {
                displayMetrics.heightPixels = (int) (((float) i3) * f2);
                displayMetrics.widthPixels = (int) (((double) displayMetrics.heightPixels) / d2);
            }
            this.cBQ = displayMetrics.heightPixels;
            this.cBP = displayMetrics.widthPixels;
        } else {
            displayMetrics.heightPixels = this.cBQ;
            displayMetrics.widthPixels = this.cBP;
        }
        return displayMetrics;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public boolean OD() {
        return ai.et(MMApplicationContext.getContext());
    }

    private final void OE() {
        Point point = new Point();
        Object systemService = this.ctx.getSystemService("window");
        if (systemService == null) {
            throw new t("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (!ai.et(this.ctx) || !com.tencent.luggage.h.j.cDv.Pi()) {
            defaultDisplay.getSize(point);
            defaultDisplay.getMetrics(this.aJm);
        } else {
            defaultDisplay.getRealSize(point);
            defaultDisplay.getRealMetrics(this.aJm);
        }
        this.cBJ = point.x;
        this.cBK = point.y;
        this.cBL = Math.max(this.cBJ, this.cBK);
        this.cBM = Math.min(this.cBJ, this.cBK);
        Log.i("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", Integer.valueOf(this.cBJ), Integer.valueOf(this.cBK));
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z, boolean z2, String str) {
        if (OD()) {
            DisplayMetrics vDisplayMetrics = getVDisplayMetrics();
            Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", str, this.cBU, Integer.valueOf(vDisplayMetrics.widthPixels), Integer.valueOf(vDisplayMetrics.heightPixels));
            this.cBW.brO();
            View view = this.cBH;
            if (view == null) {
                p.btv("bgView");
            }
            if ((view.isLaidOut() || !z) && !z2) {
                View view2 = this.cBH;
                if (view2 == null) {
                    p.btv("bgView");
                }
                int measuredWidth = view2.getMeasuredWidth();
                View view3 = this.cBH;
                if (view3 == null) {
                    p.btv("bgView");
                }
                int measuredHeight = view3.getMeasuredHeight();
                Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: width [%d], height[%d]", str, Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                float f2 = (((float) measuredWidth) * 1.0f) / ((float) vDisplayMetrics.widthPixels);
                float f3 = (((float) measuredHeight) * 1.0f) / ((float) vDisplayMetrics.heightPixels);
                float min = Math.min(f2, f3);
                Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: scaleMin = [%f], scaleMax = [%f]", str, Float.valueOf(min), Float.valueOf(Math.max(f2, f3)));
                this.scale = min;
                WxaWindowLayoutParams wxaWindowLayoutParams = new WxaWindowLayoutParams(vDisplayMetrics.widthPixels, vDisplayMetrics.heightPixels);
                wxaWindowLayoutParams.gravity = 17;
                wxaWindowLayoutParams.setScale(this.scale);
                this.cBW.getWindowAndroid().a(wxaWindowLayoutParams, this.cBW);
                this.cBW.getWindowAndroid().a(android.support.v4.content.b.n(this.ctx, R.color.f3046d), this.cBW);
                return;
            }
            View view4 = this.cBH;
            if (view4 == null) {
                p.btv("bgView");
            }
            view4.post(new e(this));
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ a cCc;

        e(a aVar) {
            this.cCc = aVar;
        }

        public final void run() {
            AppMethodBeat.i(230036);
            this.cCc.a(false, false, "post");
            AppMethodBeat.o(230036);
        }
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
        if (this.lastOrientation != configuration.orientation && p.j(this.cBV, "auto") && OD() && !this.cBF) {
            this.cBU = hR(configuration.orientation);
        }
        if (!(this.lastOrientation == configuration.orientation && configuration.screenHeightDp == this.cBN && configuration.screenWidthDp == this.cBO)) {
            this.cBR = !(configuration.screenHeightDp == this.cBN && configuration.screenWidthDp == this.cBO) && this.lastOrientation == configuration.orientation;
            if (Build.VERSION.SDK_INT >= 24) {
                com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = this.cBW.getWindowAndroid();
                p.g(windowAndroid, "rt.windowAndroid");
                if (windowAndroid.isInMultiWindowMode() || this.cBS) {
                    this.cBR = false;
                }
                com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid2 = this.cBW.getWindowAndroid();
                p.g(windowAndroid2, "rt.windowAndroid");
                this.cBS = windowAndroid2.isInMultiWindowMode();
            }
            OE();
            if (this.cBR && !(configuration.screenHeightDp == this.cBN && configuration.screenWidthDp == this.cBO)) {
                OF();
            }
            View view = this.cBH;
            if (view == null) {
                p.btv("bgView");
            }
            view.addOnLayoutChangeListener(new d(this));
        }
        this.lastOrientation = configuration.orientation;
        this.cBN = configuration.screenHeightDp;
        this.cBO = configuration.screenWidthDp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, hxF = {"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"})
    public static final class d extends View$OnLayoutChangeListenerC0184a {
        final /* synthetic */ a cCc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.cCc = aVar;
        }

        @Override // com.tencent.luggage.sdk.d.a.View$OnLayoutChangeListenerC0184a
        public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            boolean z;
            AppMethodBeat.i(230035);
            if (i10 == 10) {
                this.cCc.getBgView().removeOnLayoutChangeListener(this);
                AppMethodBeat.o(230035);
                return;
            }
            if (i2 == i3 && i2 == i5 && i2 == i4) {
                z = true;
            } else {
                z = false;
            }
            if (i2 == i6 && i4 == i8 && i5 == i9 && i3 == i7 && !z) {
                Log.i("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
                AppMethodBeat.o(230035);
                return;
            }
            if (this.cCc.cBI != null) {
                this.cCc.a(true, false, "onConfigurationChanged");
            }
            this.cCc.getBgView().removeOnLayoutChangeListener(this);
            AppMethodBeat.o(230035);
        }
    }

    private static b hR(int i2) {
        switch (i2) {
            case 1:
                return b.PORTRAIT;
            case 2:
                return b.LANDSCAPE;
            default:
                Log.w("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", Integer.valueOf(i2));
                return b.PORTRAIT;
        }
    }

    private final void OF() {
        if (!TextUtils.isEmpty(this.cBV)) {
            Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", this.cBV);
            this.cBX.a(e.b.aeE(this.cBV), null);
            return;
        }
        e.b btm = this.cBX.btm();
        p.g(btm, "activityOrientationHandler.getCurrentOrientation()");
        Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", btm);
        this.cBX.a(btm, null);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler() {
        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = this.cBW.getWindowAndroid();
        p.g(windowAndroid, "rt.windowAndroid");
        return new com.tencent.mm.plugin.appbrand.platform.window.c.a.a(windowAndroid);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b bVar) {
        Activity activity;
        if (this.ctx instanceof Activity) {
            activity = (Activity) this.ctx;
        } else {
            activity = null;
        }
        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = this.cBW.getWindowAndroid();
        p.g(windowAndroid, "rt.windowAndroid");
        return new be(windowAndroid, bVar, activity);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public float getScale() {
        return this.scale;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OG() {
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public void setSoftOrientation(String str) {
        int requestedOrientation;
        ac pageView;
        com.tencent.mm.plugin.appbrand.platform.window.d dVar = null;
        p.h(str, "name");
        Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", str);
        if (str != null) {
            switch (str.hashCode()) {
                case 3005871:
                    if (str.equals("auto")) {
                        Resources resources = this.ctx.getResources();
                        p.g(resources, "ctx.resources");
                        this.cBU = hR(resources.getConfiguration().orientation);
                        break;
                    }
                    break;
                case 729267099:
                    if (str.equals("portrait")) {
                        this.cBU = b.PORTRAIT;
                        break;
                    }
                    break;
                case 1430647483:
                    if (str.equals("landscape")) {
                        this.cBU = b.LANDSCAPE;
                        break;
                    }
                    break;
            }
            w brh = this.cBW.brh();
            if (!(brh == null || (pageView = brh.getPageView()) == null)) {
                dVar = pageView.getFullscreenImpl();
            }
            if (dVar != null || !(dVar instanceof be) || !((be) dVar).kGg) {
                this.cBV = str;
                a(true, false, "set softOrientation");
                if ((!OD() || this.cBF) && (this.ctx instanceof Activity)) {
                    Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
                    requestedOrientation = ((Activity) this.ctx).getRequestedOrientation();
                    if (requestedOrientation != 14 && requestedOrientation != -1) {
                        this.cBX.a(e.b.UNSPECIFIED, new c(this));
                        return;
                    }
                }
                return;
            }
            return;
        }
        Log.w("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", str);
        try {
            w brh2 = this.cBW.brh();
            dVar = pageView.getFullscreenImpl();
        } catch (AssertionFailedError e2) {
        }
        if (dVar != null) {
        }
        this.cBV = str;
        a(true, false, "set softOrientation");
        if (!OD()) {
        }
        Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
        requestedOrientation = ((Activity) this.ctx).getRequestedOrientation();
        if (requestedOrientation != 14) {
        }
    }
}

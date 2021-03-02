package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 11}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "isEnable", "", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "dynamicbg_release"})
public final class a implements c {
    public static final C0314a gRf = new C0314a((byte) 0);
    private boolean ded = true;

    static {
        AppMethodBeat.i(103076);
        AppMethodBeat.o(103076);
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final boolean atB() {
        return this.ded;
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final void atC() {
        this.ded = false;
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final Point az(Context context) {
        AppMethodBeat.i(103074);
        p.h(context, "context");
        Point point = new Point();
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(103074);
            throw tVar;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    Object invoke = Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0]);
                    if (invoke == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(103074);
                        throw tVar2;
                    }
                    point.x = ((Integer) invoke).intValue();
                    Object invoke2 = method.invoke(defaultDisplay, new Object[0]);
                    if (invoke2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(103074);
                        throw tVar3;
                    }
                    point.y = ((Integer) invoke2).intValue();
                } catch (Exception e2) {
                }
            }
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(103074);
        return point;
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final void atD() {
        AppMethodBeat.i(103075);
        System.loadLibrary("dynamicBg");
        AppMethodBeat.o(103075);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atE() {
        return false;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atF() {
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atG() {
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atH() {
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atI() {
        return false;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atJ() {
        return false;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atK() {
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atL() {
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final float atM() {
        return 16.0f;
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl$Companion;", "", "()V", "TAG", "", "dynamicbg_release"})
    /* renamed from: com.tencent.mm.dynamicbackground.model.a$a  reason: collision with other inner class name */
    public static final class C0314a {
        private C0314a() {
        }

        public /* synthetic */ C0314a(byte b2) {
            this();
        }
    }
}

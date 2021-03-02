package com.tencent.mm.plugin.multitask.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040!2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/multitask/utils/MultiTaskUtil;", "", "()V", "POSITION_BUTTOM", "", "POSITION_CENTER", "POSITION_NONE", "POSITION_TOP", "TAG", "", "disableMultiTaskTypeInfos", "sCutOutHeight", "Ljava/lang/Integer;", "sHasCutout", "", "Ljava/lang/Boolean;", "checkPositionInView", "view", "Landroid/view/View;", "x", "y", "disableMultiTaskSnapMode", "type", "enableMultiTaskFullScreenMode", "getCutOutHeight", "context", "Landroid/content/Context;", "getMultiTaskSlideFractor", "", "getPositionInView", "getPositionInViewRect", "Landroid/graphics/Rect;", "getVisiablePositionInView", "Lkotlin/Pair;", "hasCutout", "runOnUI", "", "runnable", "Ljava/lang/Runnable;", "plugin-multitask_release"})
public final class c {
    private static String AgK;
    public static final c AgL = new c();
    private static Boolean oYE;
    private static Integer oYF;

    static {
        AppMethodBeat.i(200793);
        AppMethodBeat.o(200793);
    }

    private c() {
    }

    public static final boolean q(View view, int i2, int i3) {
        AppMethodBeat.i(200784);
        if (view == null) {
            AppMethodBeat.o(200784);
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        boolean contains = new Rect(i4, i5, view.getWidth() + i4, view.getHeight() + i5).contains(i2, i3);
        AppMethodBeat.o(200784);
        return contains;
    }

    public static String ey(View view) {
        AppMethodBeat.i(200785);
        if (view == null) {
            AppMethodBeat.o(200785);
            return "";
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        Rect rect = new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
        ae aeVar = ae.SYK;
        String format = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)}, 4));
        p.g(format, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(200785);
        return format;
    }

    public static o<String, Integer> ez(View view) {
        int i2;
        AppMethodBeat.i(200786);
        if (view == null) {
            o<String, Integer> oVar = new o<>("", 0);
            AppMethodBeat.o(200786);
            return oVar;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int height2 = (i4 + height) - rect.height();
        int i5 = i4 + height;
        if (rect.top == 0) {
            i5 = rect.height() + i4;
            if (height + i4 > i5) {
                i2 = 4;
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
            i4 = height2;
        }
        Rect rect2 = new Rect(rect.left + i3, i4, rect.left + i3 + width, i5);
        ae aeVar = ae.SYK;
        String format = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[]{Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom)}, 4));
        p.g(format, "java.lang.String.format(format, *args)");
        o<String, Integer> oVar2 = new o<>(format, Integer.valueOf(i2));
        AppMethodBeat.o(200786);
        return oVar2;
    }

    public static final Rect eA(View view) {
        AppMethodBeat.i(200787);
        if (view == null) {
            Rect rect = new Rect();
            AppMethodBeat.o(200787);
            return rect;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        Rect rect2 = new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
        AppMethodBeat.o(200787);
        return rect2;
    }

    public static final boolean eF(Context context) {
        AppMethodBeat.i(200788);
        if (oYE == null) {
            oYE = Boolean.valueOf(ao.aQ(context));
        }
        Boolean bool = oYE;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(200788);
            return booleanValue;
        }
        AppMethodBeat.o(200788);
        return false;
    }

    public static final int aP(Context context) {
        AppMethodBeat.i(200789);
        if (!ao.aQ(context)) {
            AppMethodBeat.o(200789);
            return 0;
        }
        if (oYF == null) {
            oYF = Integer.valueOf(aP(context));
        }
        Integer num = oYF;
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(200789);
            return intValue;
        }
        AppMethodBeat.o(200789);
        return 0;
    }

    public static boolean esD() {
        AppMethodBeat.i(200790);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(200790);
            return true;
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitask_fullscreen_mode, true);
        AppMethodBeat.o(200790);
        return a2;
    }

    public static float esE() {
        AppMethodBeat.i(200791);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(200791);
            return 1.0f;
        }
        float a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitask_slide_factor, 1.0f);
        AppMethodBeat.o(200791);
        return a2;
    }

    public static boolean Ss(int i2) {
        AppMethodBeat.i(200792);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            AppMethodBeat.o(200792);
            return false;
        }
        if (AgK == null) {
            try {
                AgK = ((b) g.af(b.class)).a(b.a.clicfg_multitask_disable_snapshot_mode, "");
                Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo: %s", AgK);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MultiTaskUtil", e2, "disableMultiTaskTypeInfo", new Object[0]);
            }
        }
        String str = AgK;
        if (str == null || !n.a((CharSequence) str, (CharSequence) String.valueOf(i2), false)) {
            AppMethodBeat.o(200792);
            return false;
        }
        Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo ture!!!");
        AppMethodBeat.o(200792);
        return true;
    }
}

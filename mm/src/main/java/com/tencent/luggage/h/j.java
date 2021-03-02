package com.tencent.luggage.h;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.Oppo;
import com.tencent.mm.sdk.vendor.Vivo;
import com.tencent.mm.ui.r;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, hxF = {"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "luggage-commons_release"})
public final class j implements k {
    private static k cDu;
    public static final j cDv = new j();

    static {
        AppMethodBeat.i(174639);
        AppMethodBeat.o(174639);
    }

    private j() {
    }

    public static void a(k kVar) {
        cDu = kVar;
    }

    @Override // com.tencent.luggage.h.k
    public final int hT(int i2) {
        AppMethodBeat.i(174635);
        k kVar = cDu;
        if (kVar != null) {
            int hT = kVar.hT(i2);
            AppMethodBeat.o(174635);
            return hT;
        }
        AppMethodBeat.o(174635);
        return i2;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean isDarkMode() {
        AppMethodBeat.i(174636);
        k kVar = cDu;
        if (kVar != null) {
            boolean isDarkMode = kVar.isDarkMode();
            AppMethodBeat.o(174636);
            return isDarkMode;
        }
        AppMethodBeat.o(174636);
        return false;
    }

    @Override // com.tencent.luggage.h.k
    public final int aP(Context context) {
        AppMethodBeat.i(174637);
        if (context == null) {
            AppMethodBeat.o(174637);
            return 0;
        }
        k kVar = cDu;
        if (kVar != null) {
            int aP = kVar.aP(context);
            AppMethodBeat.o(174637);
            return aP;
        }
        int intValue = ((Number) new a(context).invoke()).intValue();
        AppMethodBeat.o(174637);
        return intValue;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean aQ(Context context) {
        AppMethodBeat.i(174638);
        if (context == null) {
            AppMethodBeat.o(174638);
            return false;
        }
        k kVar = cDu;
        if (kVar != null) {
            boolean aQ = kVar.aQ(context);
            AppMethodBeat.o(174638);
            return aQ;
        }
        boolean booleanValue = ((Boolean) new b(context).invoke()).booleanValue();
        AppMethodBeat.o(174638);
        return booleanValue;
    }

    @Override // com.tencent.luggage.h.k
    public final int aR(Context context) {
        AppMethodBeat.i(182836);
        p.h(context, "context");
        k kVar = cDu;
        if (kVar != null) {
            int aR = kVar.aR(context);
            AppMethodBeat.o(182836);
            return aR;
        }
        int jK = r.jK(context);
        AppMethodBeat.o(182836);
        return jK;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pi() {
        AppMethodBeat.i(221360);
        k kVar = cDu;
        if (kVar != null) {
            boolean Pi = kVar.Pi();
            AppMethodBeat.o(221360);
            return Pi;
        }
        AppMethodBeat.o(221360);
        return false;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pj() {
        AppMethodBeat.i(221361);
        k kVar = cDu;
        if (kVar != null) {
            boolean Pj = kVar.Pj();
            AppMethodBeat.o(221361);
            return Pj;
        }
        AppMethodBeat.o(221361);
        return false;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pk() {
        AppMethodBeat.i(221362);
        k kVar = cDu;
        if (kVar != null) {
            boolean Pk = kVar.Pk();
            AppMethodBeat.o(221362);
            return Pk;
        }
        AppMethodBeat.o(221362);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(174633);
            Integer valueOf = Integer.valueOf(r.getStatusBarHeight(this.$context));
            AppMethodBeat.o(174633);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            int i2;
            Window window;
            View decorView;
            WindowInsets rootWindowInsets;
            DisplayCutout displayCutout;
            List<Rect> boundingRects;
            AppMethodBeat.i(174634);
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.$context;
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity = (Activity) context;
                if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null) {
                    i2 = 0;
                } else {
                    i2 = boundingRects.size();
                }
                z = i2 > 0;
            } else {
                z = Vivo.vivohasCutOut(this.$context) || Oppo.oppohasCutOut(this.$context) || Huawei.huaweihasCutOut(this.$context);
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(174634);
            return valueOf;
        }
    }
}

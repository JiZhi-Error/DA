package com.tencent.mm.plugin.festival.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import kotlin.g.b.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0011\u001a\u00020\u0012*\u00020\u00052#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\bJ0\u0010\u0018\u001a\u00020\u0012*\u00020\f2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\bJ\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001bJ\n\u0010\u001c\u001a\u00020\u001a*\u00020\u001bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e*\u00020\fH\u0002J\n\u0010\u001f\u001a\u00020\u0012*\u00020 J\u0014\u0010!\u001a\u00020\u0012*\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$R\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalViewUtilsKt;", "", "()V", "allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "children", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "doOnPreDraw", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "forEach", "getNavigationBarHeight", "", "Landroid/content/Context;", "getStatusBarHeight", "iterator", "", "safeRecycle", "Landroid/graphics/Bitmap;", "setTextWithEmojiSpanned", "Landroid/widget/TextView;", "text", "", "plugin-festival_release"})
public final class j {
    public static final j UGJ = new j();

    static {
        AppMethodBeat.i(263511);
        AppMethodBeat.o(263511);
    }

    private j() {
    }

    public static void aQ(Bitmap bitmap) {
        AppMethodBeat.i(263505);
        p.h(bitmap, "$this$safeRecycle");
        try {
            bitmap.recycle();
            AppMethodBeat.o(263505);
        } catch (Exception e2) {
            AppMethodBeat.o(263505);
        }
    }

    public static int aD(Context context) {
        AppMethodBeat.i(263506);
        p.h(context, "$this$getNavigationBarHeight");
        try {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(context);
            if (castActivityOrNull != null && Build.VERSION.SDK_INT >= 23) {
                Window window = castActivityOrNull.getWindow();
                p.g(window, "activity.window");
                View decorView = window.getDecorView();
                p.g(decorView, "activity.window.decorView");
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                p.g(rootWindowInsets, "activity.window.decorView.rootWindowInsets");
                int systemWindowInsetBottom = rootWindowInsets.getSystemWindowInsetBottom();
                AppMethodBeat.o(263506);
                return systemWindowInsetBottom;
            }
        } catch (Exception e2) {
        }
        int aD = au.aD(context);
        AppMethodBeat.o(263506);
        return aD;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(263507);
        p.h(context, "$this$getStatusBarHeight");
        try {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(context);
            if (castActivityOrNull != null && Build.VERSION.SDK_INT >= 23) {
                Window window = castActivityOrNull.getWindow();
                p.g(window, "activity.window");
                View decorView = window.getDecorView();
                p.g(decorView, "activity.window.decorView");
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                p.g(rootWindowInsets, "activity.window.decorView.rootWindowInsets");
                int systemWindowInsetTop = rootWindowInsets.getSystemWindowInsetTop();
                AppMethodBeat.o(263507);
                return systemWindowInsetTop;
            }
        } catch (Exception e2) {
        }
        int statusBarHeight = au.getStatusBarHeight(context);
        AppMethodBeat.o(263507);
        return statusBarHeight;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalViewUtilsKt$iterator$1", "", "Landroid/view/View;", FirebaseAnalytics.b.INDEX, "", "hasNext", "", "next", "remove", "", "plugin-festival_release"})
    public static final class b implements Iterator<View>, d {
        final /* synthetic */ ViewGroup UGL;
        private int index;

        b(ViewGroup viewGroup) {
            this.UGL = viewGroup;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(263502);
            if (this.index < this.UGL.getChildCount()) {
                AppMethodBeat.o(263502);
                return true;
            }
            AppMethodBeat.o(263502);
            return false;
        }

        public final void remove() {
            AppMethodBeat.i(263504);
            this.index--;
            this.UGL.removeViewAt(this.index);
            AppMethodBeat.o(263504);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ View next() {
            AppMethodBeat.i(263503);
            ViewGroup viewGroup = this.UGL;
            int i2 = this.index;
            this.index = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            if (childAt == null) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.o(263503);
                throw indexOutOfBoundsException;
            }
            AppMethodBeat.o(263503);
            return childAt;
        }
    }

    public static Iterator<View> J(ViewGroup viewGroup) {
        AppMethodBeat.i(263508);
        p.h(viewGroup, "$this$iterator");
        b bVar = new b(viewGroup);
        AppMethodBeat.o(263508);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalViewUtilsKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "iterator", "", "plugin-festival_release"})
    public static final class a implements h<View> {
        final /* synthetic */ ViewGroup UGK;

        a(ViewGroup viewGroup) {
            this.UGK = viewGroup;
        }

        @Override // kotlin.m.h
        public final Iterator<View> iterator() {
            AppMethodBeat.i(263501);
            j jVar = j.UGJ;
            Iterator<View> J = j.J(this.UGK);
            AppMethodBeat.o(263501);
            return J;
        }
    }

    public static h<View> K(ViewGroup viewGroup) {
        AppMethodBeat.i(263509);
        p.h(viewGroup, "$this$children");
        a aVar = new a(viewGroup);
        AppMethodBeat.o(263509);
        return aVar;
    }

    public static void g(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(263510);
        p.h(textView, "$this$setTextWithEmojiSpanned");
        if (charSequence == null || charSequence.length() == 0) {
            textView.setText(charSequence);
            AppMethodBeat.o(263510);
            return;
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.d(textView.getContext(), charSequence, kotlin.h.a.cR(textView.getTextSize())));
        AppMethodBeat.o(263510);
    }
}

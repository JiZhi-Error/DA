package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u0006J \u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100J\u000e\u00102\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0006J.\u00103\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0006J\u0018\u00105\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/bizui/util/BizViewUtils;", "", "()V", "TAG", "", "TITLE_SCENE_MP_CHAT", "", "TITLE_SCENE_MP_CHAT_COVER_TITLE", "TITLE_SCENE_MP_CHAT_ITEM", "TITLE_SCENE_PROFILE", "TITLE_SCENE_PROFILE_COVER_TITLE", "TITLE_SCENE_PROFILE_ITEM", "TITLE_SCENE_TIME_LINE", "TITLE_SCENE_TIME_LINE_COVER_TITLE", "TITLE_SCENE_TIME_LINE_ITEM", "optionSearchOpen", "", "getOptionSearchOpen", "()Z", "optionSearchOpen$delegate", "Lkotlin/Lazy;", "widthMap", "Ljava/util/HashMap;", "getWidthMap", "()Ljava/util/HashMap;", "setWidthMap", "(Ljava/util/HashMap;)V", "appendIcon", "", "tv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "", "drawable", "Landroid/graphics/drawable/Drawable;", "padding", "getDefaultTitleWidth", "scene", "context", "Landroid/content/Context;", "getGreenUnreadCountShape", "textSize", "getPaddingSpan", "Landroid/text/SpannableString;", "size", "getTitleWidth", "getViewTop", "root", "Landroid/view/View;", "target", "isCoverTitle", "setTitleEndWithPayIcon", "icon", "setTitleWidth", "width", "ui-biz_release"})
public final class a {
    private static HashMap<Integer, Integer> pfA = new HashMap<>();
    private static final f pfB = g.ah(C0857a.pfD);
    public static final a pfC = new a();

    public static boolean ckz() {
        AppMethodBeat.i(192283);
        boolean booleanValue = ((Boolean) pfB.getValue()).booleanValue();
        AppMethodBeat.o(192283);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(123735);
        AppMethodBeat.o(123735);
    }

    private a() {
    }

    public static int j(View view, View view2) {
        AppMethodBeat.i(123731);
        if (view == null || view2 == null || view == view2) {
            AppMethodBeat.o(123731);
            return 0;
        }
        int i2 = 0;
        while (view2 != view) {
            i2 += view2.getTop();
            Log.v("MicroMsg.BizViewUtils", "alvinluo getViewTop top: %d", Integer.valueOf(i2));
            if (!(view2.getParent() instanceof View)) {
                break;
            }
            ViewParent parent = view2.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(123731);
                throw tVar;
            }
            view2 = (View) parent;
        }
        AppMethodBeat.o(123731);
        return i2;
    }

    public static boolean CJ(int i2) {
        return i2 == 11 || i2 == 21 || i2 == 41;
    }

    public static void a(Context context, MMNeat7extView mMNeat7extView, int i2, CharSequence charSequence, int i3) {
        int i4;
        AppMethodBeat.i(123732);
        p.h(context, "context");
        p.h(mMNeat7extView, "tv");
        p.h(charSequence, "text");
        mMNeat7extView.aw(charSequence);
        if (mMNeat7extView.getWidth() > 0) {
            i4 = mMNeat7extView.getWidth();
        } else if (pfA.containsKey(Integer.valueOf(i3))) {
            Integer num = pfA.get(Integer.valueOf(i3));
            if (num == null) {
                p.hyc();
            }
            i4 = num.intValue();
        } else {
            pfA.put(Integer.valueOf(i3), 0);
            i4 = 0;
        }
        if (i4 <= 0) {
            ViewTreeObserver viewTreeObserver = mMNeat7extView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new b(mMNeat7extView, i3));
            }
            if (i3 == 0 || i3 == 11) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, 48);
            } else if (i3 == 1) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, (int) r.CTRL_INDEX);
            } else if (i3 == 2 || i3 == 21) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, 64);
            } else if (i3 == 3) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, (int) r.CTRL_INDEX);
            } else if (i3 == 4 || i3 == 41) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, 64);
            } else if (i3 == 5) {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, 144);
            } else {
                i4 = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.fromDPToPix(context, 64);
            }
        }
        Drawable drawable = context.getResources().getDrawable(i2);
        int textSize = (int) mMNeat7extView.getTextSize();
        p.g(drawable, "drawable");
        int intrinsicWidth = (drawable.getIntrinsicWidth() * textSize) / drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, textSize);
        mMNeat7extView.a(TextUtils.TruncateAt.END, ((float) intrinsicWidth) + ((float) com.tencent.mm.cb.a.fromDPToPix(context, 9)));
        com.tencent.neattextview.textview.layout.a mq = mMNeat7extView.mq(i4, Integer.MAX_VALUE);
        if (mq != null) {
            int ellipsisCount = mq.getEllipsisCount(mMNeat7extView.getMaxLines() - 1);
            if (ellipsisCount <= 0) {
                a(mMNeat7extView, charSequence, drawable);
                AppMethodBeat.o(123732);
                return;
            }
            a(mMNeat7extView, charSequence.subSequence(0, charSequence.length() - ellipsisCount).toString() + (char) 8230, drawable);
            AppMethodBeat.o(123732);
            return;
        }
        a(mMNeat7extView, charSequence, drawable);
        AppMethodBeat.o(123732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/bizui/util/BizViewUtils$setTitleEndWithPayIcon$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ui-biz_release"})
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ int $scene;
        final /* synthetic */ MMNeat7extView pfE;

        b(MMNeat7extView mMNeat7extView, int i2) {
            this.pfE = mMNeat7extView;
            this.$scene = i2;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(123730);
            ViewTreeObserver viewTreeObserver = this.pfE.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.pfE.post(new RunnableC0858a(this));
            AppMethodBeat.o(123730);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.bizui.a.a$b$a  reason: collision with other inner class name */
        static final class RunnableC0858a implements Runnable {
            final /* synthetic */ b pfF;

            RunnableC0858a(b bVar) {
                this.pfF = bVar;
            }

            public final void run() {
                AppMethodBeat.i(123729);
                a aVar = a.pfC;
                a.fa(this.pfF.$scene, this.pfF.pfE.getWidth());
                AppMethodBeat.o(123729);
            }
        }
    }

    private static void a(MMNeat7extView mMNeat7extView, CharSequence charSequence, Drawable drawable) {
        AppMethodBeat.i(123733);
        p.h(mMNeat7extView, "tv");
        p.h(charSequence, "text");
        p.h(drawable, "drawable");
        mMNeat7extView.a(TextUtils.TruncateAt.END, 0.0f);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        SpannableString spannableString = new SpannableString("@");
        spannableString.setSpan(aVar, 0, 1, 33);
        Context context = mMNeat7extView.getContext();
        p.g(context, "tv.context");
        mMNeat7extView.aw(TextUtils.concat(charSequence, Q(context, (int) mMNeat7extView.getTextSize()), spannableString));
        AppMethodBeat.o(123733);
    }

    private static SpannableString Q(Context context, int i2) {
        AppMethodBeat.i(123734);
        Drawable drawable = context.getResources().getDrawable(R.drawable.aij);
        drawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(context, 8), i2);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        SpannableString spannableString = new SpannableString("@");
        spannableString.setSpan(aVar, 0, 1, 33);
        AppMethodBeat.o(123734);
        return spannableString;
    }

    public static int R(Context context, int i2) {
        AppMethodBeat.i(192284);
        if (Float.compare(com.tencent.mm.cb.a.ez(context), com.tencent.mm.cb.a.iZ(context)) > 0) {
            if (i2 < 2) {
                AppMethodBeat.o(192284);
                return R.drawable.a74;
            }
            AppMethodBeat.o(192284);
            return R.drawable.gw;
        } else if (i2 < 2) {
            AppMethodBeat.o(192284);
            return R.drawable.gv;
        } else {
            AppMethodBeat.o(192284);
            return R.drawable.gu;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.bizui.a.a$a  reason: collision with other inner class name */
    static final class C0857a extends q implements kotlin.g.a.a<Boolean> {
        public static final C0857a pfD = new C0857a();

        static {
            AppMethodBeat.i(192282);
            AppMethodBeat.o(192282);
        }

        C0857a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(192281);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_option_search_open, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(192281);
            return valueOf;
        }
    }

    public static final /* synthetic */ void fa(int i2, int i3) {
        AppMethodBeat.i(123736);
        pfA.put(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(123736);
    }
}

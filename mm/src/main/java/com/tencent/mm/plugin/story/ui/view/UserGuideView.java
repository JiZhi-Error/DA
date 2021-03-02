package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initNewGuide", "initOldGuide", "plugin-story_release"})
public final class UserGuideView extends RelativeLayout {
    private kotlin.g.a.a<x> FEi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120311);
        if (e.Fln.fng()) {
            View.inflate(getContext(), R.layout.c0z, this);
            setOnClickListener(a.FEj);
            View findViewById = findViewById(R.id.icm);
            p.g(findViewById, "findViewById<View>(R.id.story_user_guide_btn)");
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(120311);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = at.fromDPToPix(getContext(), 64) + au.aD(getContext());
            findViewById(R.id.icm).setOnClickListener(new b(this));
            AppMethodBeat.o(120311);
            return;
        }
        View.inflate(getContext(), R.layout.c0y, this);
        setBackgroundColor(-13421773);
        View findViewById2 = findViewById(R.id.ico);
        p.g(findViewById2, "findViewById(R.id.story_user_guide_content_2)");
        String string = getContext().getString(R.string.hja);
        p.g(string, "context.getString(R.stri…ory_user_guide_content_2)");
        SpannableString spannableString = new SpannableString(string);
        Drawable drawable = getResources().getDrawable(R.raw.chatting_avatar_story_hint);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 10);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        spannableString.setSpan(new com.tencent.mm.ui.widget.a(drawable, 1), string.length() - 3, string.length() - 2, 17);
        ((TextView) findViewById2).setText(spannableString);
        setOnClickListener(c.FEl);
        findViewById(R.id.icn).setOnClickListener(new d(this));
        AppMethodBeat.o(120311);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UserGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120312);
        AppMethodBeat.o(120312);
    }

    public final kotlin.g.a.a<x> getClickListener() {
        return this.FEi;
    }

    public final void setClickListener(kotlin.g.a.a<x> aVar) {
        this.FEi = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c FEl = new c();

        static {
            AppMethodBeat.i(120309);
            AppMethodBeat.o(120309);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120308);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120308);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ UserGuideView FEk;

        d(UserGuideView userGuideView) {
            this.FEk = userGuideView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120310);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> clickListener = this.FEk.getClickListener();
            if (clickListener != null) {
                clickListener.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120310);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        public static final a FEj = new a();

        static {
            AppMethodBeat.i(120306);
            AppMethodBeat.o(120306);
        }

        a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120305);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120305);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ UserGuideView FEk;

        b(UserGuideView userGuideView) {
            this.FEk = userGuideView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120307);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> clickListener = this.FEk.getClickListener();
            if (clickListener != null) {
                clickListener.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120307);
        }
    }
}

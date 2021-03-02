package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\rH\u0003J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\rR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtnCallBack", "Lkotlin/Function0;", "", "getCloseBtnCallBack", "()Lkotlin/jvm/functions/Function0;", "setCloseBtnCallBack", "(Lkotlin/jvm/functions/Function0;)V", "prepareViews", "setCloseIconResId", "resId", "setTitle", "title", "", "showHelpIcon", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchHeadComponent extends RelativeLayout {
    public static final a yBe = new a((byte) 0);
    private HashMap _$_findViewCache;
    private kotlin.g.a.a<x> yBd;

    static {
        AppMethodBeat.i(256227);
        AppMethodBeat.o(256227);
    }

    private View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256228);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256228);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KidsWatchHeadComponent(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(256225);
        setNestedScrollingEnabled(true);
        View.inflate(context, R.layout.axi, this);
        TextView textView = (TextView) _$_findCachedViewById(R.id.ipp);
        p.g(textView, "titleTV");
        textView.setVisibility(4);
        WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.dp5);
        p.g(weImageView, "helpIcon");
        weImageView.setVisibility(4);
        WeImageView weImageView2 = (WeImageView) _$_findCachedViewById(R.id.b40);
        p.g(weImageView2, "closeBtn");
        weImageView2.setBackground(getContext().getDrawable(R.raw.icons_outlined_close));
        ((WeImageView) _$_findCachedViewById(R.id.b40)).setOnClickListener(new b(this));
        ((WeImageView) _$_findCachedViewById(R.id.dp5)).setOnClickListener(new c(this));
        AppMethodBeat.o(256225);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KidsWatchHeadComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(256226);
        AppMethodBeat.o(256226);
    }

    public final kotlin.g.a.a<x> getCloseBtnCallBack() {
        return this.yBd;
    }

    public final void setCloseBtnCallBack(kotlin.g.a.a<x> aVar) {
        this.yBd = aVar;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(256222);
        p.h(str, "title");
        TextView textView = (TextView) _$_findCachedViewById(R.id.ipp);
        p.g(textView, "titleTV");
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.ipp);
        p.g(textView2, "titleTV");
        textView2.setVisibility(0);
        AppMethodBeat.o(256222);
    }

    public final void setCloseIconResId(int i2) {
        AppMethodBeat.i(256223);
        WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.b40);
        p.g(weImageView, "closeBtn");
        weImageView.setBackground(getContext().getDrawable(i2));
        AppMethodBeat.o(256223);
    }

    public final void ebW() {
        AppMethodBeat.i(256224);
        WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.dp5);
        p.g(weImageView, "helpIcon");
        weImageView.setVisibility(0);
        AppMethodBeat.o(256224);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ KidsWatchHeadComponent yBf;

        b(KidsWatchHeadComponent kidsWatchHeadComponent) {
            this.yBf = kidsWatchHeadComponent;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256220);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("KidsWatchHeadComponent", "close clicked");
            kotlin.g.a.a<x> closeBtnCallBack = this.yBf.getCloseBtnCallBack();
            if (closeBtnCallBack != null) {
                closeBtnCallBack.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256220);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ KidsWatchHeadComponent yBf;

        c(KidsWatchHeadComponent kidsWatchHeadComponent) {
            this.yBf = kidsWatchHeadComponent;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256221);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("KidsWatchHeadComponent", "click help icon");
            com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
            Context context = this.yBf.getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.kidswatch.b.a.f(context, "wxaaff6b96fc2cd3c6", "pages/help/help.html", "1");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256221);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

package com.tencent.mm.plugin.finder.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0001]B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ2\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0014\b\u0002\u0010K\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020805J\u0010\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u000208H\u0002J\u0006\u0010P\u001a\u00020*J\b\u0010Q\u001a\u000208H\u0002J\u0010\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020TH\u0016J\u000e\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020*J\b\u0010W\u001a\u000208H\u0002J\u0018\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0014J\u0010\u0010[\u001a\u0002082\u0006\u0010+\u001a\u00020*H\u0002J\u0006\u0010\\\u001a\u00020*R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \r*\u0004\u0018\u00010\u001a0\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R$\u00101\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R7\u00104\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(+\u0012\u0004\u0012\u000208\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010C\u001a\u0004\u0018\u00010>2\b\u0010)\u001a\u0004\u0018\u00010>@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR$\u0010F\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t8F@FX\u000e¢\u0006\f\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "collapseTextViewRight", "", "getCollapseTextViewRight", "()F", "setCollapseTextViewRight", "(F)V", "collapseTextWidth", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "expanText", "getExpanText", "()I", "setExpanText", "(I)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "isTopicExpand", "setTopicExpand", "limitLine", "getLimitLine", "setLimitLine", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "realContent", "", "getRealContent", "()Ljava/lang/CharSequence;", "setRealContent", "(Ljava/lang/CharSequence;)V", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "_setText", "content", "callBack", "backToDefaultLogic", "source", "", "checkCollapseVisible", "checkCollapseVisibleSync", "checkIfAllRestTextTopic", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onClickFun", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshCollapseText", "tryExpand", "Companion", "plugin-finder_release"})
@SuppressLint({"ClickableViewAccessibility"})
public final class FinderCollapsibleTextView extends RelativeLayout {
    public static final a wkj = new a((byte) 0);
    private CharSequence text;
    private final kotlin.f wjY = kotlin.g.ah(new e(this));
    private final kotlin.f wjZ = kotlin.g.ah(new d(this));
    private float wka;
    private int wkb = R.string.chv;
    private View wkc;
    boolean wkd;
    boolean wke;
    private float wkf;
    private kotlin.g.a.b<? super Boolean, x> wkg;
    private int wkh;
    private CharSequence wki;

    static {
        AppMethodBeat.i(168229);
        AppMethodBeat.o(168229);
    }

    public final TextView getCollapseTextView() {
        AppMethodBeat.i(168231);
        TextView textView = (TextView) this.wjZ.getValue();
        AppMethodBeat.o(168231);
        return textView;
    }

    public final NeatTextView getContentTextView() {
        AppMethodBeat.i(168230);
        NeatTextView neatTextView = (NeatTextView) this.wjY.getValue();
        AppMethodBeat.o(168230);
        return neatTextView;
    }

    public static final /* synthetic */ void a(FinderCollapsibleTextView finderCollapsibleTextView, boolean z) {
        AppMethodBeat.i(254707);
        finderCollapsibleTextView.oU(z);
        AppMethodBeat.o(254707);
    }

    public static final /* synthetic */ void b(FinderCollapsibleTextView finderCollapsibleTextView) {
        AppMethodBeat.i(254706);
        finderCollapsibleTextView.dGo();
        AppMethodBeat.o(254706);
    }

    public static final /* synthetic */ void c(FinderCollapsibleTextView finderCollapsibleTextView) {
        AppMethodBeat.i(254708);
        finderCollapsibleTextView.dGn();
        AppMethodBeat.o(254708);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168241);
        aa.jQ(getContext()).inflate(R.layout.a9u, (ViewGroup) this, true);
        getContentTextView().setSpacingAdd((int) getResources().getDimension(R.dimen.bt));
        getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
        getCollapseTextView().setLineSpacing(getResources().getDimension(R.dimen.bt), 1.0f);
        getContentTextView().setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(getContentTextView(), new o()));
        oV(true);
        getCollapseTextView().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.AnonymousClass1 */
            final /* synthetic */ FinderCollapsibleTextView wkk;

            {
                this.wkk = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168223);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FinderCollapsibleTextView.c(this.wkk);
                k kVar = k.vfA;
                Context context = this.wkk.getContext();
                p.g(context, "context");
                k.a(context, false, 1, this.wkk.wke, this.wkk.wkd);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168223);
            }
        });
        this.wke = true;
        this.wkh = 3;
        AppMethodBeat.o(168241);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCollapsibleTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(168242);
        aa.jQ(getContext()).inflate(R.layout.a9u, (ViewGroup) this, true);
        getContentTextView().setSpacingAdd((int) getResources().getDimension(R.dimen.bt));
        getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
        getCollapseTextView().setLineSpacing(getResources().getDimension(R.dimen.bt), 1.0f);
        getContentTextView().setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(getContentTextView(), new o()));
        oV(true);
        getCollapseTextView().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.AnonymousClass1 */
            final /* synthetic */ FinderCollapsibleTextView wkk;

            {
                this.wkk = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168223);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FinderCollapsibleTextView.c(this.wkk);
                k kVar = k.vfA;
                Context context = this.wkk.getContext();
                p.g(context, "context");
                k.a(context, false, 1, this.wkk.wke, this.wkk.wkd);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168223);
            }
        });
        this.wke = true;
        this.wkh = 3;
        AppMethodBeat.o(168242);
    }

    public final float getCollapseTextViewRight() {
        return this.wka;
    }

    public final void setCollapseTextViewRight(float f2) {
        this.wka = f2;
    }

    public final int getExpanText() {
        return this.wkb;
    }

    public final void setExpanText(int i2) {
        this.wkb = i2;
    }

    public final View getExtraView() {
        return this.wkc;
    }

    public final void setExtraView(View view) {
        this.wkc = view;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(168232);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            getContentTextView().setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(168232);
        return dispatchTouchEvent;
    }

    public final void setTopicExpand(boolean z) {
        this.wkd = z;
    }

    private final void dGn() {
        AppMethodBeat.i(254699);
        setCollapse(!this.wke);
        if (!this.wke) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.dHS();
        }
        oU(this.wke);
        kotlin.g.a.b<? super Boolean, x> bVar = this.wkg;
        if (bVar != null) {
            bVar.invoke(Boolean.valueOf(this.wke));
            AppMethodBeat.o(254699);
            return;
        }
        AppMethodBeat.o(254699);
    }

    public final void setCollapse(boolean z) {
        AppMethodBeat.i(168233);
        this.wke = z;
        if (z) {
            NeatTextView contentTextView = getContentTextView();
            p.g(contentTextView, "contentTextView");
            if (contentTextView.getMaxLines() != this.wkh) {
                NeatTextView contentTextView2 = getContentTextView();
                p.g(contentTextView2, "contentTextView");
                contentTextView2.setMaxLines(this.wkh);
            }
            getCollapseTextView().setText(this.wkb);
            AppMethodBeat.o(168233);
            return;
        }
        NeatTextView contentTextView3 = getContentTextView();
        p.g(contentTextView3, "contentTextView");
        if (contentTextView3.getMaxLines() != Integer.MAX_VALUE) {
            NeatTextView contentTextView4 = getContentTextView();
            p.g(contentTextView4, "contentTextView");
            contentTextView4.setMaxLines(Integer.MAX_VALUE);
        }
        getCollapseTextView().setText(R.string.b60);
        AppMethodBeat.o(168233);
    }

    private final void oU(boolean z) {
        AppMethodBeat.i(254700);
        TextView collapseTextView = getCollapseTextView();
        p.g(collapseTextView, "collapseTextView");
        if (collapseTextView.getVisibility() != 0) {
            getContentTextView().aw(this.text);
            getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
            AppMethodBeat.o(254700);
        } else if (z) {
            TextView collapseTextView2 = getCollapseTextView();
            p.g(collapseTextView2, "collapseTextView");
            ViewGroup.LayoutParams layoutParams = collapseTextView2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(254700);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(11);
            layoutParams2.addRule(8, R.id.b5q);
            layoutParams2.removeRule(3);
            layoutParams2.removeRule(5);
            layoutParams2.setMarginEnd((int) this.wka);
            TextView collapseTextView3 = getCollapseTextView();
            p.g(collapseTextView3, "collapseTextView");
            collapseTextView3.setLayoutParams(layoutParams2);
            TextView collapseTextView4 = getCollapseTextView();
            NeatTextView contentTextView = getContentTextView();
            p.g(contentTextView, "contentTextView");
            collapseTextView4.setTextSize(0, contentTextView.getTextSize());
            StringBuilder sb = new StringBuilder("isSpecialText:");
            NeatTextView contentTextView2 = getContentTextView();
            p.g(contentTextView2, "contentTextView");
            Log.i("Finder.CollapsibleTextView", sb.append(contentTextView2.hiS()).toString());
            post(new h(this));
            AppMethodBeat.o(254700);
        } else {
            getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
            TextView collapseTextView5 = getCollapseTextView();
            p.g(collapseTextView5, "collapseTextView");
            ViewGroup.LayoutParams layoutParams3 = collapseTextView5.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(254700);
                throw tVar2;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.removeRule(11);
            layoutParams4.removeRule(8);
            layoutParams4.addRule(3, R.id.b5q);
            layoutParams4.addRule(5, R.id.b5q);
            layoutParams4.setMarginEnd(0);
            TextView collapseTextView6 = getCollapseTextView();
            p.g(collapseTextView6, "collapseTextView");
            collapseTextView6.setLayoutParams(layoutParams4);
            AppMethodBeat.o(254700);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        h(FinderCollapsibleTextView finderCollapsibleTextView) {
            this.wkk = finderCollapsibleTextView;
        }

        public final void run() {
            AppMethodBeat.i(254697);
            try {
                final z.d dVar = new z.d();
                NeatTextView contentTextView = this.wkk.getContentTextView();
                p.g(contentTextView, "contentTextView");
                kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
                dVar.SYE = contentTextView.getLayout().getOffsetForHorizontal(this.wkk.getLimitLine() - 1, kotlin.g.b.l.hxZ());
                NeatTextView contentTextView2 = this.wkk.getContentTextView();
                p.g(contentTextView2, "contentTextView");
                float primaryHorizontal = contentTextView2.getLayout().getPrimaryHorizontal(dVar.SYE);
                NeatTextView contentTextView3 = this.wkk.getContentTextView();
                p.g(contentTextView3, "contentTextView");
                final int width = contentTextView3.getWidth();
                if (this.wkk.wkf == 0.0f) {
                    FinderCollapsibleTextView finderCollapsibleTextView = this.wkk;
                    TextView collapseTextView = this.wkk.getCollapseTextView();
                    p.g(collapseTextView, "collapseTextView");
                    TextPaint paint = collapseTextView.getPaint();
                    Context context = this.wkk.getContext();
                    p.g(context, "context");
                    finderCollapsibleTextView.wkf = paint.measureText(context.getResources().getString(R.string.chv));
                }
                final float f2 = this.wkk.wkf + 3.0f;
                NeatTextView contentTextView4 = this.wkk.getContentTextView();
                p.g(contentTextView4, "contentTextView");
                if (!contentTextView4.hiS() || ((float) width) - primaryHorizontal > f2) {
                    if (primaryHorizontal + f2 > ((float) width)) {
                        this.wkk.getContentTextView().a(TextUtils.TruncateAt.END, f2);
                    } else {
                        NeatTextView contentTextView5 = this.wkk.getContentTextView();
                        p.g(contentTextView5, "contentTextView");
                        if (contentTextView5.getExtraEllipsizeWidth() <= 0.0f) {
                            this.wkk.getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
                        }
                    }
                    this.wkk.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.h.AnonymousClass1 */
                        final /* synthetic */ h wkp;

                        {
                            this.wkp = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(254696);
                            z.d dVar = dVar;
                            NeatTextView contentTextView = this.wkp.wkk.getContentTextView();
                            p.g(contentTextView, "contentTextView");
                            kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
                            dVar.SYE = contentTextView.getLayout().getOffsetForHorizontal(this.wkp.wkk.getLimitLine() - 1, kotlin.g.b.l.hxZ());
                            NeatTextView contentTextView2 = this.wkp.wkk.getContentTextView();
                            p.g(contentTextView2, "contentTextView");
                            float primaryHorizontal = contentTextView2.getLayout().getPrimaryHorizontal(dVar.SYE) + f2;
                            TextView collapseTextView = this.wkp.wkk.getCollapseTextView();
                            p.g(collapseTextView, "collapseTextView");
                            this.wkp.wkk.setCollapseTextViewRight(((float) width) - (primaryHorizontal + collapseTextView.getPaint().measureText("…")));
                            this.wkp.wkk.setCollapseTextViewRight(j.aI(0.0f, this.wkp.wkk.getCollapseTextViewRight()));
                            TextView collapseTextView2 = this.wkp.wkk.getCollapseTextView();
                            p.g(collapseTextView2, "collapseTextView");
                            ViewGroup.LayoutParams layoutParams = collapseTextView2.getLayoutParams();
                            if (layoutParams == null) {
                                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                AppMethodBeat.o(254696);
                                throw tVar;
                            }
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMarginEnd((int) this.wkp.wkk.getCollapseTextViewRight());
                            TextView collapseTextView3 = this.wkp.wkk.getCollapseTextView();
                            p.g(collapseTextView3, "collapseTextView");
                            collapseTextView3.setLayoutParams(layoutParams2);
                            FinderCollapsibleTextView.b(this.wkp.wkk);
                            AppMethodBeat.o(254696);
                        }
                    });
                    AppMethodBeat.o(254697);
                    return;
                }
                FinderCollapsibleTextView.a(this.wkk, "#1");
                AppMethodBeat.o(254697);
            } catch (Exception e2) {
                FinderCollapsibleTextView.a(this.wkk, "#2:Exception:" + e2.getMessage());
                AppMethodBeat.o(254697);
            }
        }
    }

    private final void dGo() {
        AppMethodBeat.i(254701);
        CharSequence charSequence = this.text;
        if (charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.o(254701);
            return;
        }
        CharSequence charSequence2 = this.text;
        if (charSequence2 != null) {
            post(new c(charSequence2, this));
            AppMethodBeat.o(254701);
            return;
        }
        AppMethodBeat.o(254701);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$checkIfAllRestTextTopic$1$1"})
    public static final class c implements Runnable {
        final /* synthetic */ FinderCollapsibleTextView wkk;
        final /* synthetic */ CharSequence wkn;

        c(CharSequence charSequence, FinderCollapsibleTextView finderCollapsibleTextView) {
            this.wkn = charSequence;
            this.wkk = finderCollapsibleTextView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0101  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 358
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.c.run():void");
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getOnCollapse() {
        return this.wkg;
    }

    public final void setOnCollapse(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.wkg = bVar;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(168234);
        super.onMeasure(i2, i3);
        if (dGp()) {
            super.onMeasure(i2, i3);
        }
        AppMethodBeat.o(168234);
    }

    public final void a(CharSequence charSequence, View view, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(254702);
        p.h(bVar, "callBack");
        setText(charSequence);
        if (view != null) {
            view.post(new b(this, view, charSequence, bVar));
            AppMethodBeat.o(254702);
            return;
        }
        AppMethodBeat.o(254702);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ kotlin.g.a.b tqd;
        final /* synthetic */ FinderCollapsibleTextView wkk;
        final /* synthetic */ View wkl;
        final /* synthetic */ CharSequence wkm;

        b(FinderCollapsibleTextView finderCollapsibleTextView, View view, CharSequence charSequence, kotlin.g.a.b bVar) {
            this.wkk = finderCollapsibleTextView;
            this.wkl = view;
            this.wkm = charSequence;
            this.tqd = bVar;
        }

        public final void run() {
            AppMethodBeat.i(254689);
            int width = this.wkl.getWidth();
            if (width > 0) {
                this.wkk.getContentTextView().setLineEndExtraWidths(new float[]{(float) width});
            }
            this.wkk.setText(this.wkm);
            kotlin.g.a.b bVar = this.tqd;
            NeatTextView contentTextView = this.wkk.getContentTextView();
            p.g(contentTextView, "contentTextView");
            bVar.invoke(Boolean.valueOf(contentTextView.hiS()));
            k kVar = k.vfA;
            Context context = this.wkk.getContext();
            p.g(context, "context");
            k.a(context, true, 0, this.wkk.wke, this.wkk.wkd);
            AppMethodBeat.o(254689);
        }
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(168236);
        this.text = charSequence;
        getContentTextView().aw(charSequence);
        post(new i(this));
        AppMethodBeat.o(168236);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        i(FinderCollapsibleTextView finderCollapsibleTextView) {
            this.wkk = finderCollapsibleTextView;
        }

        public final void run() {
            AppMethodBeat.i(254698);
            FinderCollapsibleTextView.a(this.wkk, this.wkk.wke);
            AppMethodBeat.o(254698);
        }
    }

    public final int getLimitLine() {
        return this.wkh;
    }

    public final void setLimitLine(int i2) {
        AppMethodBeat.i(254703);
        this.wkh = i2;
        NeatTextView contentTextView = getContentTextView();
        p.g(contentTextView, "contentTextView");
        if (contentTextView.getMaxLines() != i2) {
            NeatTextView contentTextView2 = getContentTextView();
            p.g(contentTextView2, "contentTextView");
            contentTextView2.setMaxLines(i2);
        }
        AppMethodBeat.o(254703);
    }

    public final CharSequence getRealContent() {
        return this.wki;
    }

    public final void setRealContent(CharSequence charSequence) {
        this.wki = charSequence;
    }

    public final int getTextColor() {
        AppMethodBeat.i(168237);
        NeatTextView contentTextView = getContentTextView();
        p.g(contentTextView, "contentTextView");
        int currentTextColor = contentTextView.getCurrentTextColor();
        AppMethodBeat.o(168237);
        return currentTextColor;
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(168238);
        getContentTextView().setTextColor(i2);
        AppMethodBeat.o(168238);
    }

    public final void oV(boolean z) {
        AppMethodBeat.i(168239);
        if (z) {
            getContentTextView().setOnLongClickListener(new f(this));
            getContentTextView().setOnClickListener(new g(this));
            getContentTextView().setBackgroundResource(R.color.ac_);
            NeatTextView contentTextView = getContentTextView();
            p.g(contentTextView, "contentTextView");
            contentTextView.setClickable(true);
            NeatTextView contentTextView2 = getContentTextView();
            p.g(contentTextView2, "contentTextView");
            contentTextView2.setLongClickable(true);
            AppMethodBeat.o(168239);
            return;
        }
        getContentTextView().setOnLongClickListener(null);
        getContentTextView().setOnClickListener(null);
        getContentTextView().setBackgroundResource(R.drawable.b0w);
        NeatTextView contentTextView3 = getContentTextView();
        p.g(contentTextView3, "contentTextView");
        contentTextView3.setClickable(false);
        NeatTextView contentTextView4 = getContentTextView();
        p.g(contentTextView4, "contentTextView");
        contentTextView4.setLongClickable(false);
        AppMethodBeat.o(168239);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class f implements View.OnLongClickListener {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        f(FinderCollapsibleTextView finderCollapsibleTextView) {
            this.wkk = finderCollapsibleTextView;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(168228);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            try {
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this.wkk.getContext());
                aVar.a(new o.g(this) {
                    /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.f.AnonymousClass1 */
                    final /* synthetic */ f wko;

                    {
                        this.wko = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(254691);
                        if (i2 == 0) {
                            ClipboardHelper.setText(this.wko.wkk.getContentTextView().hiT());
                        }
                        AppMethodBeat.o(254691);
                    }
                });
                aVar.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
                    /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.f.AnonymousClass2 */
                    final /* synthetic */ f wko;

                    {
                        this.wko = r1;
                    }

                    public final void onDismiss() {
                        AppMethodBeat.i(254692);
                        this.wko.wkk.getContentTextView().setBackgroundResource(R.color.ac_);
                        AppMethodBeat.o(254692);
                    }
                });
                this.wkk.getContentTextView().setBackgroundResource(R.color.x5);
                TouchableLayout.a aVar2 = TouchableLayout.Rni;
                int i2 = TouchableLayout.kuv;
                TouchableLayout.a aVar3 = TouchableLayout.Rni;
                aVar.a(this.wkk.getContentTextView(), new View.OnCreateContextMenuListener(this) {
                    /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.f.AnonymousClass3 */
                    final /* synthetic */ f wko;

                    {
                        this.wko = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(254693);
                        contextMenu.add(0, 0, 0, this.wko.wkk.getContext().getString(R.string.t_));
                        AppMethodBeat.o(254693);
                    }
                }, new o.g(this) {
                    /* class com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.f.AnonymousClass4 */
                    final /* synthetic */ f wko;

                    {
                        this.wko = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(254694);
                        if (i2 == 0) {
                            if (this.wko.wkk.getRealContent() == null) {
                                ClipboardHelper.setText(this.wko.wkk.getContentTextView().hiT());
                                AppMethodBeat.o(254694);
                                return;
                            }
                            ClipboardHelper.setText(this.wko.wkk.getRealContent());
                        }
                        AppMethodBeat.o(254694);
                    }
                }, i2, TouchableLayout.kuw);
            } catch (Exception e2) {
                Log.i("Finder.CollapsibleTextView", "[enableContentTextViewClick] errMsg:" + e2.getMessage());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(168228);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        g(FinderCollapsibleTextView finderCollapsibleTextView) {
            this.wkk = finderCollapsibleTextView;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(254695);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.neattextview.textview.view.NeatTextView");
                AppMethodBeat.o(254695);
                throw tVar;
            }
            try {
                i2 = ((NeatTextView) view).getLayout().getEllipsisCount(this.wkk.getLimitLine() - 1);
            } catch (ArrayIndexOutOfBoundsException e2) {
                i2 = -1;
            }
            if ((this.wkk.wke && i2 > 0) || !this.wkk.wke) {
                FinderCollapsibleTextView.c(this.wkk);
                k kVar = k.vfA;
                Context context = this.wkk.getContext();
                p.g(context, "context");
                k.a(context, false, 2, this.wkk.wke, this.wkk.wkd);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254695);
        }
    }

    private boolean dGp() {
        int i2;
        AppMethodBeat.i(168240);
        NeatTextView contentTextView = getContentTextView();
        p.g(contentTextView, "contentTextView");
        com.tencent.neattextview.textview.layout.a layout = contentTextView.getLayout();
        try {
            int i3 = this.wkh;
            p.g(layout, "layout");
            int na = j.na(i3, layout.hiG()) - 1;
            if (na >= 0) {
                i2 = layout.getOffsetForHorizontal(na, 10000.0f);
            } else {
                i2 = 0;
            }
        } catch (Exception e2) {
            if (BuildInfo.DEBUG) {
                Exception exc = e2;
                AppMethodBeat.o(168240);
                throw exc;
            }
            i2 = 0;
        }
        TextView collapseTextView = getCollapseTextView();
        p.g(collapseTextView, "collapseTextView");
        int visibility = collapseTextView.getVisibility();
        if (layout == null || i2 <= 0 || i2 >= getContentTextView().hiT().length()) {
            TextView collapseTextView2 = getCollapseTextView();
            p.g(collapseTextView2, "collapseTextView");
            collapseTextView2.setVisibility(8);
        } else {
            TextView collapseTextView3 = getCollapseTextView();
            p.g(collapseTextView3, "collapseTextView");
            collapseTextView3.setVisibility(0);
        }
        TextView collapseTextView4 = getCollapseTextView();
        p.g(collapseTextView4, "collapseTextView");
        if (visibility != collapseTextView4.getVisibility()) {
            AppMethodBeat.o(168240);
            return true;
        }
        AppMethodBeat.o(168240);
        return false;
    }

    public final boolean dGq() {
        int i2;
        AppMethodBeat.i(254704);
        try {
            NeatTextView contentTextView = getContentTextView();
            p.g(contentTextView, "contentTextView");
            i2 = contentTextView.getLayout().getEllipsisCount(this.wkh - 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            i2 = -1;
        }
        if (!this.wke || i2 <= 0) {
            AppMethodBeat.o(254704);
            return false;
        }
        dGn();
        AppMethodBeat.o(254704);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<NeatTextView> {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderCollapsibleTextView finderCollapsibleTextView) {
            super(0);
            this.wkk = finderCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ NeatTextView invoke() {
            AppMethodBeat.i(168225);
            NeatTextView neatTextView = (NeatTextView) this.wkk.findViewById(R.id.b5q);
            AppMethodBeat.o(168225);
            return neatTextView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderCollapsibleTextView wkk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderCollapsibleTextView finderCollapsibleTextView) {
            super(0);
            this.wkk = finderCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(168224);
            TextView textView = (TextView) this.wkk.findViewById(R.id.b5p);
            AppMethodBeat.o(168224);
            return textView;
        }
    }

    public static final /* synthetic */ void a(FinderCollapsibleTextView finderCollapsibleTextView, String str) {
        AppMethodBeat.i(254705);
        Log.i("Finder.CollapsibleTextView", "go to defaule logic,source:".concat(String.valueOf(str)));
        finderCollapsibleTextView.getContentTextView().a(TextUtils.TruncateAt.END, 0.0f);
        TextView collapseTextView = finderCollapsibleTextView.getCollapseTextView();
        p.g(collapseTextView, "collapseTextView");
        ViewGroup.LayoutParams layoutParams = collapseTextView.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(254705);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.removeRule(11);
        layoutParams2.removeRule(8);
        layoutParams2.addRule(3, R.id.b5q);
        layoutParams2.addRule(5, R.id.b5q);
        layoutParams2.setMarginEnd(0);
        TextView collapseTextView2 = finderCollapsibleTextView.getCollapseTextView();
        p.g(collapseTextView2, "collapseTextView");
        collapseTextView2.setLayoutParams(layoutParams2);
        finderCollapsibleTextView.dGo();
        AppMethodBeat.o(254705);
    }
}

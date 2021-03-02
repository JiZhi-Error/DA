package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J7\u0010%\u001a\u00020\u00172!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView extends RelativeLayout {
    private final String TAG = "Finder.FinderExtendReadingEditView";
    private final TextView UVs;
    private final View cBH;
    private final View hRd;
    private final TextView pJV;
    private final TextView titleTv;
    public kotlin.g.a.b<? super String, x> wlE;
    public kotlin.g.a.a<x> wlF;
    private final TextView wlG;
    public final MMEditText wlH;

    public static final /* synthetic */ kotlin.g.a.b c(FinderExtendReadingEditView finderExtendReadingEditView) {
        AppMethodBeat.i(168318);
        kotlin.g.a.b<? super String, x> bVar = finderExtendReadingEditView.wlE;
        if (bVar == null) {
            p.btv("onAddListener");
        }
        AppMethodBeat.o(168318);
        return bVar;
    }

    public FinderExtendReadingEditView(Context context) {
        super(context);
        AppMethodBeat.i(168315);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_k, (ViewGroup) null);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        View findViewById = inflate.findViewById(R.id.clj);
        p.g(findViewById, "view.findViewById(R.id.f…xtend_reading_edit_close)");
        this.hRd = findViewById;
        View findViewById2 = inflate.findViewById(R.id.clh);
        p.g(findViewById2, "view.findViewById(R.id.f…_extend_reading_edit_add)");
        this.wlG = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ir3);
        p.g(findViewById3, "view.findViewById(R.id.title_tv)");
        this.titleTv = (TextView) findViewById3;
        ao.a(this.titleTv.getPaint(), 0.8f);
        final View findViewById4 = findViewById(R.id.gt3);
        findViewById4.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass1 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void run() {
                AppMethodBeat.i(168307);
                View view = r2;
                Context context = this.wlI.getContext();
                p.g(context, "context");
                View view2 = r2;
                p.g(view2, "layout");
                int top = view2.getTop();
                Context context2 = this.wlI.getContext();
                p.g(context2, "context");
                View view3 = r2;
                p.g(view3, "layout");
                view.setPadding((int) context.getResources().getDimension(R.dimen.cb), top, (int) context2.getResources().getDimension(R.dimen.cb), view3.getBottom() + av.aD(this.wlI.getContext()));
                AppMethodBeat.o(168307);
            }
        });
        View findViewById5 = inflate.findViewById(R.id.clk);
        p.g(findViewById5, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
        this.wlH = (MMEditText) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.cll);
        p.g(findViewById6, "view.findViewById(R.id.f…extend_reading_edit_tips)");
        this.pJV = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.cli);
        p.g(findViewById7, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
        this.cBH = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.jvw);
        p.g(findViewById8, "view.findViewById(R.id.finder_extend_reading_tips)");
        this.UVs = (TextView) findViewById8;
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass2 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168308);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168308);
            }
        });
        this.cBH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass3 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168309);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168309);
            }
        });
        this.UVs.setText(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_redpacket_link_tips_wording, this.UVs.getContext().getString(R.string.cm3)));
        this.wlH.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass4 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wlI = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(168310);
                this.wlI.dGF();
                AppMethodBeat.o(168310);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        dGE();
        dGF();
        AppMethodBeat.o(168315);
    }

    public FinderExtendReadingEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168316);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_k, (ViewGroup) null);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        View findViewById = inflate.findViewById(R.id.clj);
        p.g(findViewById, "view.findViewById(R.id.f…xtend_reading_edit_close)");
        this.hRd = findViewById;
        View findViewById2 = inflate.findViewById(R.id.clh);
        p.g(findViewById2, "view.findViewById(R.id.f…_extend_reading_edit_add)");
        this.wlG = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ir3);
        p.g(findViewById3, "view.findViewById(R.id.title_tv)");
        this.titleTv = (TextView) findViewById3;
        ao.a(this.titleTv.getPaint(), 0.8f);
        final View findViewById4 = findViewById(R.id.gt3);
        findViewById4.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass1 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void run() {
                AppMethodBeat.i(168307);
                View view = r2;
                Context context = this.wlI.getContext();
                p.g(context, "context");
                View view2 = r2;
                p.g(view2, "layout");
                int top = view2.getTop();
                Context context2 = this.wlI.getContext();
                p.g(context2, "context");
                View view3 = r2;
                p.g(view3, "layout");
                view.setPadding((int) context.getResources().getDimension(R.dimen.cb), top, (int) context2.getResources().getDimension(R.dimen.cb), view3.getBottom() + av.aD(this.wlI.getContext()));
                AppMethodBeat.o(168307);
            }
        });
        View findViewById5 = inflate.findViewById(R.id.clk);
        p.g(findViewById5, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
        this.wlH = (MMEditText) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.cll);
        p.g(findViewById6, "view.findViewById(R.id.f…extend_reading_edit_tips)");
        this.pJV = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.cli);
        p.g(findViewById7, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
        this.cBH = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.jvw);
        p.g(findViewById8, "view.findViewById(R.id.finder_extend_reading_tips)");
        this.UVs = (TextView) findViewById8;
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass2 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168308);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168308);
            }
        });
        this.cBH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass3 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168309);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168309);
            }
        });
        this.UVs.setText(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_redpacket_link_tips_wording, this.UVs.getContext().getString(R.string.cm3)));
        this.wlH.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass4 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wlI = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(168310);
                this.wlI.dGF();
                AppMethodBeat.o(168310);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        dGE();
        dGF();
        AppMethodBeat.o(168316);
    }

    public FinderExtendReadingEditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168317);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_k, (ViewGroup) null);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        View findViewById = inflate.findViewById(R.id.clj);
        p.g(findViewById, "view.findViewById(R.id.f…xtend_reading_edit_close)");
        this.hRd = findViewById;
        View findViewById2 = inflate.findViewById(R.id.clh);
        p.g(findViewById2, "view.findViewById(R.id.f…_extend_reading_edit_add)");
        this.wlG = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ir3);
        p.g(findViewById3, "view.findViewById(R.id.title_tv)");
        this.titleTv = (TextView) findViewById3;
        ao.a(this.titleTv.getPaint(), 0.8f);
        final View findViewById4 = findViewById(R.id.gt3);
        findViewById4.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass1 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void run() {
                AppMethodBeat.i(168307);
                View view = findViewById4;
                Context context = this.wlI.getContext();
                p.g(context, "context");
                View view2 = findViewById4;
                p.g(view2, "layout");
                int top = view2.getTop();
                Context context2 = this.wlI.getContext();
                p.g(context2, "context");
                View view3 = findViewById4;
                p.g(view3, "layout");
                view.setPadding((int) context.getResources().getDimension(R.dimen.cb), top, (int) context2.getResources().getDimension(R.dimen.cb), view3.getBottom() + av.aD(this.wlI.getContext()));
                AppMethodBeat.o(168307);
            }
        });
        View findViewById5 = inflate.findViewById(R.id.clk);
        p.g(findViewById5, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
        this.wlH = (MMEditText) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.cll);
        p.g(findViewById6, "view.findViewById(R.id.f…extend_reading_edit_tips)");
        this.pJV = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.cli);
        p.g(findViewById7, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
        this.cBH = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.jvw);
        p.g(findViewById8, "view.findViewById(R.id.finder_extend_reading_tips)");
        this.UVs = (TextView) findViewById8;
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass2 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168308);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168308);
            }
        });
        this.cBH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass3 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            {
                this.wlI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168309);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a aVar = this.wlI.wlF;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168309);
            }
        });
        this.UVs.setText(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_redpacket_link_tips_wording, this.UVs.getContext().getString(R.string.cm3)));
        this.wlH.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView.AnonymousClass4 */
            final /* synthetic */ FinderExtendReadingEditView wlI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wlI = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(168310);
                this.wlI.dGF();
                AppMethodBeat.o(168310);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        dGE();
        dGF();
        AppMethodBeat.o(168317);
    }

    public final void dGE() {
        boolean z;
        AppMethodBeat.i(168313);
        y yVar = y.vXH;
        String dCC = y.dCC();
        if (!Util.isNullOrNil(dCC)) {
            p.h(dCC, "url");
            if (!Util.isNullOrNil(dCC)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (p.j(this.wlH.getText().toString(), dCC)) {
                    this.pJV.setVisibility(8);
                    AppMethodBeat.o(168313);
                    return;
                }
                this.pJV.setVisibility(0);
                this.pJV.setText(getContext().getString(R.string.cm4, dCC));
                this.pJV.setOnClickListener(new b(this, dCC));
                AppMethodBeat.o(168313);
                return;
            }
        }
        this.pJV.setVisibility(8);
        AppMethodBeat.o(168313);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FinderExtendReadingEditView wlI;
        final /* synthetic */ String wlK;

        b(FinderExtendReadingEditView finderExtendReadingEditView, String str) {
            this.wlI = finderExtendReadingEditView;
            this.wlK = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168312);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wlI.wlH.setText(this.wlK);
            this.wlI.pJV.setVisibility(8);
            this.wlI.wlH.setSelection(this.wlI.wlH.getText().length());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168312);
        }
    }

    public final void dGF() {
        AppMethodBeat.i(168314);
        String obj = this.wlH.getText().toString();
        if (!Util.isNullOrNil(obj)) {
            this.wlG.setOnClickListener(new a(this, obj));
            this.wlG.setTextColor(getResources().getColor(R.color.am));
            this.wlG.setBackgroundResource(R.drawable.xr);
            AppMethodBeat.o(168314);
            return;
        }
        this.wlG.setOnClickListener(null);
        this.wlG.setTextColor(getResources().getColor(R.color.pk));
        this.wlG.setBackgroundResource(R.drawable.xp);
        AppMethodBeat.o(168314);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ String mkH;
        final /* synthetic */ FinderExtendReadingEditView wlI;

        a(FinderExtendReadingEditView finderExtendReadingEditView, String str) {
            this.wlI = finderExtendReadingEditView;
            this.mkH = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168311);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderExtendReadingEditView.c(this.wlI).invoke(this.mkH);
            this.wlI.wlH.setText("");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168311);
        }
    }
}

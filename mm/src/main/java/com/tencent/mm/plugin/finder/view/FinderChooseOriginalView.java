package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView extends LinearLayout {
    private final String TAG = "Finder.FinderChooseOriginalView";
    private int cSx = 1;
    private TextView jBS;
    private b<? super Integer, x> wjV;

    public FinderChooseOriginalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254687);
        setOrientation(1);
        aa.jQ(getContext()).inflate(R.layout.a9t, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.g6x);
        p.g(findViewById, "findViewById(R.id.original_tip_tv)");
        this.jBS = (TextView) findViewById;
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderChooseOriginalView.AnonymousClass1 */
            final /* synthetic */ FinderChooseOriginalView wjW;

            {
                this.wjW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254684);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = new d(this.wjW.getContext());
                dVar.Ml(R.layout.ahz);
                TextView textView = (TextView) dVar.lJI.findViewById(R.id.g71);
                p.g(textView, "titleTv");
                ao.a(textView.getPaint(), 0.8f);
                View findViewById = dVar.lJI.findViewById(R.id.g72);
                View findViewById2 = dVar.lJI.findViewById(R.id.g70);
                if (this.wjW.getFlag() == 1) {
                    p.g(findViewById, "yesIv");
                    findViewById.setVisibility(0);
                    p.g(findViewById2, "noIv");
                    findViewById2.setVisibility(8);
                } else {
                    p.g(findViewById, "yesIv");
                    findViewById.setVisibility(8);
                    p.g(findViewById2, "noIv");
                    findViewById2.setVisibility(0);
                }
                com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
                int dBU = com.tencent.mm.plugin.finder.utils.p.dBU();
                View findViewById3 = dVar.lJI.findViewById(R.id.fzt);
                p.g(findViewById3, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
                ((TextView) findViewById3).setText(this.wjW.getContext().getString(R.string.d4x, String.valueOf(dBU)));
                if (dBU > 0) {
                    dVar.lJI.findViewById(R.id.g6s).setOnClickListener(new a(dVar, this));
                } else {
                    View findViewById4 = dVar.lJI.findViewById(R.id.g6s);
                    p.g(findViewById4, "rootView.findViewById<Vi…(R.id.original_no_layout)");
                    findViewById4.setClickable(false);
                    Context context = this.wjW.getContext();
                    p.g(context, "context");
                    ((TextView) dVar.lJI.findViewById(R.id.fzu)).setTextColor(context.getResources().getColor(R.color.BW_70));
                }
                dVar.lJI.findViewById(R.id.g73).setOnClickListener(new b(dVar, this));
                dVar.lJI.findViewById(R.id.g6z).setOnClickListener(new c(dVar, this));
                dVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254684);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                a(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254680);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.wjX.wjW.setOriginalFlag(2);
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254680);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$b */
            static final class b implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                b(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254681);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.wjX.wjW.setOriginalFlag(1);
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254681);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$c */
            static final class c implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                c(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254683);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final d dVar = new d(this.wjX.wjW.getContext());
                    dVar.Ml(R.layout.ahu);
                    dVar.lJI.findViewById(R.id.b45).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.finder.view.FinderChooseOriginalView.AnonymousClass1.c.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(254682);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            dVar.bMo();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(254682);
                        }
                    });
                    dVar.dGm();
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254683);
                }
            }
        });
        AppMethodBeat.o(254687);
    }

    public FinderChooseOriginalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(254688);
        setOrientation(1);
        aa.jQ(getContext()).inflate(R.layout.a9t, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.g6x);
        p.g(findViewById, "findViewById(R.id.original_tip_tv)");
        this.jBS = (TextView) findViewById;
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderChooseOriginalView.AnonymousClass1 */
            final /* synthetic */ FinderChooseOriginalView wjW;

            {
                this.wjW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254684);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = new d(this.wjW.getContext());
                dVar.Ml(R.layout.ahz);
                TextView textView = (TextView) dVar.lJI.findViewById(R.id.g71);
                p.g(textView, "titleTv");
                ao.a(textView.getPaint(), 0.8f);
                View findViewById = dVar.lJI.findViewById(R.id.g72);
                View findViewById2 = dVar.lJI.findViewById(R.id.g70);
                if (this.wjW.getFlag() == 1) {
                    p.g(findViewById, "yesIv");
                    findViewById.setVisibility(0);
                    p.g(findViewById2, "noIv");
                    findViewById2.setVisibility(8);
                } else {
                    p.g(findViewById, "yesIv");
                    findViewById.setVisibility(8);
                    p.g(findViewById2, "noIv");
                    findViewById2.setVisibility(0);
                }
                com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
                int dBU = com.tencent.mm.plugin.finder.utils.p.dBU();
                View findViewById3 = dVar.lJI.findViewById(R.id.fzt);
                p.g(findViewById3, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
                ((TextView) findViewById3).setText(this.wjW.getContext().getString(R.string.d4x, String.valueOf(dBU)));
                if (dBU > 0) {
                    dVar.lJI.findViewById(R.id.g6s).setOnClickListener(new a(dVar, this));
                } else {
                    View findViewById4 = dVar.lJI.findViewById(R.id.g6s);
                    p.g(findViewById4, "rootView.findViewById<Vi…(R.id.original_no_layout)");
                    findViewById4.setClickable(false);
                    Context context = this.wjW.getContext();
                    p.g(context, "context");
                    ((TextView) dVar.lJI.findViewById(R.id.fzu)).setTextColor(context.getResources().getColor(R.color.BW_70));
                }
                dVar.lJI.findViewById(R.id.g73).setOnClickListener(new b(dVar, this));
                dVar.lJI.findViewById(R.id.g6z).setOnClickListener(new c(dVar, this));
                dVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254684);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                a(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254680);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.wjX.wjW.setOriginalFlag(2);
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254680);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$b */
            static final class b implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                b(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254681);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.wjX.wjW.setOriginalFlag(1);
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254681);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
            /* renamed from: com.tencent.mm.plugin.finder.view.FinderChooseOriginalView$1$c */
            static final class c implements View.OnClickListener {
                final /* synthetic */ d tru;
                final /* synthetic */ AnonymousClass1 wjX;

                c(d dVar, AnonymousClass1 r2) {
                    this.tru = dVar;
                    this.wjX = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(254683);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final d dVar = new d(this.wjX.wjW.getContext());
                    dVar.Ml(R.layout.ahu);
                    dVar.lJI.findViewById(R.id.b45).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.finder.view.FinderChooseOriginalView.AnonymousClass1.c.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(254682);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            dVar.bMo();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(254682);
                        }
                    });
                    dVar.dGm();
                    this.tru.bMo();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254683);
                }
            }
        });
        AppMethodBeat.o(254688);
    }

    public final TextView getTipTv() {
        return this.jBS;
    }

    public final void setTipTv(TextView textView) {
        AppMethodBeat.i(254685);
        p.h(textView, "<set-?>");
        this.jBS = textView;
        AppMethodBeat.o(254685);
    }

    public final int getFlag() {
        return this.cSx;
    }

    public final void setFlag(int i2) {
        this.cSx = i2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final b<Integer, x> getOnFlagChangedListener() {
        return this.wjV;
    }

    public final void setOnFlagChangedListener(b<? super Integer, x> bVar) {
        this.wjV = bVar;
    }

    public final void setOriginalFlag(int i2) {
        AppMethodBeat.i(254686);
        this.cSx = i2;
        if (this.cSx == 1) {
            this.jBS.setText(R.string.d4n);
        } else if (this.cSx == 2) {
            this.jBS.setText(R.string.d3i);
        } else {
            this.jBS.setText("");
        }
        b<? super Integer, x> bVar = this.wjV;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(254686);
            return;
        }
        AppMethodBeat.o(254686);
    }
}

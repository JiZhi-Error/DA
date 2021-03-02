package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "backBtn", "Landroid/view/View;", "<set-?>", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "ftsEditText", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchIcon", "Landroid/widget/ImageView;", "searchViewListener", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "hideSearchIcon", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "setSearchViewListener", "Companion", "FTSImageSearchListener", "FTSSearchViewListener", "IFTSTagModel", "plugin-mv_release"})
public final class FTSSearchNoActionBarView extends LinearLayout {
    public static final a Awy = new a((byte) 0);
    private FTSEditTextView Awv;
    private ImageView Aww;
    private b Awx;
    private View uvi;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "", "onClickBackBtn", "", "view", "Landroid/view/View;", "onClickCancelBtn", "plugin-mv_release"})
    public interface b {
        void ewk();
    }

    static {
        AppMethodBeat.i(257401);
        AppMethodBeat.o(257401);
    }

    public final FTSEditTextView getFtsEditText() {
        return this.Awv;
    }

    public FTSSearchNoActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(257399);
        init();
        AppMethodBeat.o(257399);
    }

    public FTSSearchNoActionBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(257400);
        init();
        AppMethodBeat.o(257400);
    }

    private final void init() {
        AppMethodBeat.i(257398);
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(257398);
            throw tVar;
        }
        ((LayoutInflater) systemService).inflate(R.layout.anw, (ViewGroup) this, true);
        this.uvi = findViewById(R.id.aib);
        View view = this.uvi;
        if (view != null) {
            view.setOnClickListener(new c(this));
        }
        this.Aww = (ImageView) findViewById(R.id.he6);
        ImageView imageView = this.Aww;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        View findViewById = findViewById(R.id.db_);
        if (findViewById == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.search.FTSEditTextView");
            AppMethodBeat.o(257398);
            throw tVar2;
        }
        this.Awv = (FTSEditTextView) findViewById;
        AppMethodBeat.o(257398);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FTSSearchNoActionBarView Awz;

        c(FTSSearchNoActionBarView fTSSearchNoActionBarView) {
            this.Awz = fTSSearchNoActionBarView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257397);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Awz.Awx != null) {
                b bVar2 = this.Awz.Awx;
                if (bVar2 == null) {
                    p.hyc();
                }
                bVar2.ewk();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257397);
        }
    }

    public final void setSearchViewListener(b bVar) {
        this.Awx = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

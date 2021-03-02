package com.tencent.mm.ui.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/ui/search/WebSearchView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/view/View;", "getBackBtn", "()Landroid/view/View;", "setBackBtn", "(Landroid/view/View;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "ftsEditText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditText", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "searchIcon", "Landroid/widget/ImageView;", "getSearchIcon", "()Landroid/widget/ImageView;", "setSearchIcon", "(Landroid/widget/ImageView;)V", "searchViewListener", "Lcom/tencent/mm/ui/search/ISearchViewListener;", "initView", "", "setSearchViewListener", "libmmui_release"})
public final class WebSearchView extends LinearLayout {
    public FTSEditTextView Awv;
    public ImageView Aww;
    public View CYY;
    private b Qod;
    public View uvi;

    public final FTSEditTextView getFtsEditText() {
        AppMethodBeat.i(204848);
        FTSEditTextView fTSEditTextView = this.Awv;
        if (fTSEditTextView == null) {
            p.btv("ftsEditText");
        }
        AppMethodBeat.o(204848);
        return fTSEditTextView;
    }

    public final void setFtsEditText(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.i(204849);
        p.h(fTSEditTextView, "<set-?>");
        this.Awv = fTSEditTextView;
        AppMethodBeat.o(204849);
    }

    public final ImageView getSearchIcon() {
        AppMethodBeat.i(204850);
        ImageView imageView = this.Aww;
        if (imageView == null) {
            p.btv("searchIcon");
        }
        AppMethodBeat.o(204850);
        return imageView;
    }

    public final void setSearchIcon(ImageView imageView) {
        AppMethodBeat.i(204851);
        p.h(imageView, "<set-?>");
        this.Aww = imageView;
        AppMethodBeat.o(204851);
    }

    public final View getBackBtn() {
        AppMethodBeat.i(204852);
        View view = this.uvi;
        if (view == null) {
            p.btv("backBtn");
        }
        AppMethodBeat.o(204852);
        return view;
    }

    public final void setBackBtn(View view) {
        AppMethodBeat.i(204853);
        p.h(view, "<set-?>");
        this.uvi = view;
        AppMethodBeat.o(204853);
    }

    public final View getCancelBtn() {
        AppMethodBeat.i(204854);
        View view = this.CYY;
        if (view == null) {
            p.btv("cancelBtn");
        }
        AppMethodBeat.o(204854);
        return view;
    }

    public final void setCancelBtn(View view) {
        AppMethodBeat.i(204855);
        p.h(view, "<set-?>");
        this.CYY = view;
        AppMethodBeat.o(204855);
    }

    public WebSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(204858);
        initView();
        AppMethodBeat.o(204858);
    }

    public WebSearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(204859);
        initView();
        AppMethodBeat.o(204859);
    }

    private void initView() {
        AppMethodBeat.i(204856);
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(204856);
            throw tVar;
        }
        ((LayoutInflater) systemService).inflate(R.layout.cb9, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ax);
        p.g(findViewById, "findViewById(R.id.ab_back_btn)");
        this.uvi = findViewById;
        View view = this.uvi;
        if (view == null) {
            p.btv("backBtn");
        }
        view.setOnClickListener(new a(this));
        View findViewById2 = findViewById(R.id.aib);
        p.g(findViewById2, "findViewById(R.id.cancel_btn)");
        this.CYY = findViewById2;
        View view2 = this.CYY;
        if (view2 == null) {
            p.btv("cancelBtn");
        }
        view2.setOnClickListener(new b(this));
        View findViewById3 = findViewById(R.id.he6);
        p.g(findViewById3, "findViewById(R.id.search_icon)");
        this.Aww = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.db_);
        p.g(findViewById4, "findViewById(R.id.fts_edittext)");
        this.Awv = (FTSEditTextView) findViewById4;
        FTSEditTextView fTSEditTextView = this.Awv;
        if (fTSEditTextView == null) {
            p.btv("ftsEditText");
        }
        fTSEditTextView.gWY();
        AppMethodBeat.o(204856);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ WebSearchView Qoe;

        a(WebSearchView webSearchView) {
            this.Qoe = webSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(204846);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.Qoe.Qod;
            if (bVar2 != null) {
                p.g(view, "v");
                bVar2.onClickBackBtn(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(204846);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ WebSearchView Qoe;

        b(WebSearchView webSearchView) {
            this.Qoe = webSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(204847);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.Qoe.Qod;
            if (bVar2 != null) {
                p.g(view, "v");
                bVar2.onClickCancelBtn(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/WebSearchView$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(204847);
        }
    }

    public final void setSearchViewListener(b bVar) {
        AppMethodBeat.i(204857);
        p.h(bVar, "searchViewListener");
        this.Qod = bVar;
        AppMethodBeat.o(204857);
    }
}

package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.ui.tools.browser.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0004%&'(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u0012J\u0016\u0010!\u001a\u00020\u001a2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "closeButton", "Landroid/widget/ImageView;", "dialogTitle", "Landroid/widget/TextView;", "mBrowserChooseDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "mItemPadding", "moreButton", "attachDialog", "", "dialog", "configItemPadding", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "release", "setBrowserClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBrowserList", "dataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "BrowserItemAdapter", "BrowserItemDecoration", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserChooseDialogView extends RelativeLayout {
    public static final d JlZ = new d((byte) 0);
    private ImageView CPf;
    private ImageView CPh;
    private TextView JlU;
    private RecyclerView JlV;
    private a JlW;
    a JlX;
    private com.tencent.mm.plugin.webview.ui.tools.browser.listener.a JlY;
    private int omS;

    static {
        AppMethodBeat.i(210463);
        AppMethodBeat.o(210463);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$Companion;", "", "()V", "BROWSER_LIST_GRID_SPAN_COUNT", "", "TAG", "", "plugin-webview_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrowserChooseDialogView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(210460);
        AppMethodBeat.o(210460);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrowserChooseDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(210461);
        AppMethodBeat.o(210461);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrowserChooseDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int jn;
        DisplayMetrics displayMetrics;
        p.h(context, "context");
        AppMethodBeat.i(210462);
        setFitsSystemWindows(true);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ayi, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.adp);
        p.g(findViewById, "view.findViewById(R.id.browser_dialog_title)");
        this.JlU = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.adj);
        p.g(findViewById2, "view.findViewById(R.id.browser_dialog_close_btn)");
        this.CPf = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.adm);
        p.g(findViewById3, "view.findViewById(R.id.browser_dialog_more_btn)");
        this.CPh = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.ads);
        p.g(findViewById4, "view.findViewById(R.id.browser_list)");
        this.JlV = (RecyclerView) findViewById4;
        TextView textView = this.JlU;
        if (textView == null) {
            p.btv("dialogTitle");
        }
        ao.a(textView.getPaint(), 0.8f);
        ImageView imageView = this.CPf;
        if (imageView == null) {
            p.btv("closeButton");
        }
        imageView.setOnClickListener(new e(this, inflate));
        ImageView imageView2 = this.CPh;
        if (imageView2 == null) {
            p.btv("moreButton");
        }
        imageView2.setOnClickListener(new f(this, inflate));
        Resources resources = getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            jn = com.tencent.mm.cb.a.jn(getContext());
        } else {
            jn = displayMetrics.widthPixels;
        }
        this.omS = (jn - (getResources().getDimensionPixelSize(R.dimen.apb) * 4)) / 5;
        Log.i("MicroMsg.BrowserChooseDialogView", "alvinluo configItemPadding width: %d, mItemPadding: %s", Integer.valueOf(jn), Integer.valueOf(this.omS));
        this.JlW = new a(this, context);
        RecyclerView recyclerView = this.JlV;
        if (recyclerView == null) {
            p.btv("browserRecyclerView");
        }
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new GridLayoutManager(4));
        recyclerView.setAdapter(this.JlW);
        recyclerView.b(new b(context));
        recyclerView.setOverScrollMode(2);
        recyclerView.setVerticalFadingEdgeEnabled(false);
        recyclerView.setNestedScrollingEnabled(false);
        if (recyclerView instanceof MaxHeightRecyclerView) {
            ((MaxHeightRecyclerView) recyclerView).setMaxHeight((((int) ((((float) com.tencent.mm.cb.a.jo(context)) * 3.0f) / 4.0f)) - ((MaxHeightRecyclerView) recyclerView).getResources().getDimensionPixelSize(R.dimen.cr)) - ((MaxHeightRecyclerView) recyclerView).getResources().getDimensionPixelSize(R.dimen.cr));
        }
        RecyclerView recyclerView2 = this.JlV;
        if (recyclerView2 == null) {
            p.btv("browserRecyclerView");
        }
        ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.omS / 2;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.omS / 2;
            }
            AppMethodBeat.o(210462);
            return;
        }
        AppMethodBeat.o(210462);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ BrowserChooseDialogView Jma;
        final /* synthetic */ View hCI;

        e(BrowserChooseDialogView browserChooseDialogView, View view) {
            this.Jma = browserChooseDialogView;
            this.hCI = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210457);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.webview.ui.tools.browser.listener.a aVar = this.Jma.JlY;
            if (aVar != null) {
                aVar.a(this.Jma.JlX);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210457);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ BrowserChooseDialogView Jma;
        final /* synthetic */ View hCI;

        f(BrowserChooseDialogView browserChooseDialogView, View view) {
            this.Jma = browserChooseDialogView;
            this.hCI = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210458);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.webview.ui.tools.browser.listener.a aVar = this.Jma.JlY;
            if (aVar != null) {
                aVar.b(this.Jma.JlX);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210458);
        }
    }

    public final void setBrowserClickListener(com.tencent.mm.plugin.webview.ui.tools.browser.listener.a aVar) {
        this.JlY = aVar;
    }

    public final void setBrowserList(List<com.tencent.mm.plugin.webview.ui.tools.browser.f> list) {
        AppMethodBeat.i(210459);
        if (list == null) {
            AppMethodBeat.o(210459);
            return;
        }
        a aVar = this.JlW;
        if (aVar != null) {
            p.h(list, "dataList");
            aVar.mDataList.clear();
            aVar.mDataList.addAll(list);
            AppMethodBeat.o(210459);
            return;
        }
        AppMethodBeat.o(210459);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "plugin-webview_release"})
    public final class a extends RecyclerView.a<c> {
        final /* synthetic */ BrowserChooseDialogView Jma;
        private final Context context;
        final ArrayList<com.tencent.mm.plugin.webview.ui.tools.browser.f> mDataList = new ArrayList<>();

        public a(BrowserChooseDialogView browserChooseDialogView, Context context2) {
            p.h(context2, "context");
            this.Jma = browserChooseDialogView;
            AppMethodBeat.i(210453);
            this.context = context2;
            AppMethodBeat.o(210453);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(210450);
            p.h(viewGroup, "parent");
            View inflate = aa.jQ(this.context).inflate(R.layout.ayh, viewGroup, false);
            p.g(inflate, "view");
            c cVar = new c(inflate);
            AppMethodBeat.o(210450);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(c cVar, int i2) {
            AppMethodBeat.i(210452);
            c cVar2 = cVar;
            p.h(cVar2, "viewHolder");
            com.tencent.mm.plugin.webview.ui.tools.browser.f fVar = (com.tencent.mm.plugin.webview.ui.tools.browser.f) j.L(this.mDataList, i2);
            if (fVar == null) {
                AppMethodBeat.o(210452);
                return;
            }
            if (fVar.JlN == null) {
                new com.tencent.mm.plugin.webview.ui.tools.browser.e(this.context, fVar.title, new C1981a(this, fVar, i2)).execute(fVar.resolveInfo);
            }
            cVar2.Jmg.setImageDrawable(fVar.JlN);
            cVar2.Jmg.setOnClickListener(new b(this, fVar, i2));
            cVar2.Jmh.setText(fVar.title);
            cVar2.Jmh.setContentDescription(fVar.title);
            AppMethodBeat.o(210452);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(210451);
            int size = this.mDataList.size();
            AppMethodBeat.o(210451);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView$a$a  reason: collision with other inner class name */
        public static final class C1981a implements e.a {
            final /* synthetic */ a Jmb;
            final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.browser.f Jmc;
            final /* synthetic */ int gUj;

            C1981a(a aVar, com.tencent.mm.plugin.webview.ui.tools.browser.f fVar, int i2) {
                this.Jmb = aVar;
                this.Jmc = fVar;
                this.gUj = i2;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.browser.e.a
            public final void B(Drawable drawable) {
                AppMethodBeat.i(210448);
                this.Jmc.JlN = drawable;
                this.Jmb.ci(this.gUj);
                AppMethodBeat.o(210448);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ a Jmb;
            final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.browser.f Jmc;
            final /* synthetic */ int gUj;

            b(a aVar, com.tencent.mm.plugin.webview.ui.tools.browser.f fVar, int i2) {
                this.Jmb = aVar;
                this.Jmc = fVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.webview.ui.tools.browser.listener.a aVar;
                AppMethodBeat.i(210449);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(this.Jmc.resolveInfo == null || (aVar = this.Jmb.Jma.JlY) == null)) {
                    aVar.a(this.Jmb.Jma.JlX, this.gUj, this.Jmc);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(210449);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastRowBottomMaxPadding", "", "lastRowBottomPadding", "topPadding", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-webview_release"})
    static final class b extends RecyclerView.h {
        private final int Jmd;
        private final int Jme;
        private final int Jmf;

        public b(Context context) {
            p.h(context, "context");
            AppMethodBeat.i(210455);
            this.Jmd = context.getResources().getDimensionPixelSize(R.dimen.ce);
            this.Jme = context.getResources().getDimensionPixelSize(R.dimen.ce);
            this.Jmf = context.getResources().getDimensionPixelSize(R.dimen.cr);
            AppMethodBeat.o(210455);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(210454);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            rect.top = this.Jmd;
            int bw = RecyclerView.bw(view);
            RecyclerView.a adapter = recyclerView.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            if (bw / 4 == (itemCount - 1) / 4) {
                if (itemCount <= 4) {
                    rect.bottom = this.Jmf;
                    AppMethodBeat.o(210454);
                    return;
                }
                rect.bottom = this.Jme;
            }
            AppMethodBeat.o(210454);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserTitle", "Landroid/widget/TextView;", "getBrowserTitle", "()Landroid/widget/TextView;", "plugin-webview_release"})
    static final class c extends RecyclerView.v {
        final ImageView Jmg;
        final TextView Jmh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(210456);
            View findViewById = view.findViewById(R.id.adq);
            p.g(findViewById, "itemView.findViewById(R.id.browser_icon)");
            this.Jmg = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.adv);
            p.g(findViewById2, "itemView.findViewById(R.id.browser_title)");
            this.Jmh = (TextView) findViewById2;
            AppMethodBeat.o(210456);
        }
    }
}

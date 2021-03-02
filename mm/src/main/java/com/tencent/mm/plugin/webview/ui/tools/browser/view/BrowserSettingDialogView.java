package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.ui.tools.browser.e;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0003'()B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u001cJ\u0016\u0010!\u001a\u00020\u001c2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0010\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u0019J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "cancelButton", "Landroid/widget/TextView;", "confirmButton", "dialogTitle", "mBrowserDataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "mBrowserSettingDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mSelectedPosition", "attachDialog", "", "dialog", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initConfirmButton", "release", "setBrowserList", "dataList", "setBrowserSettingDialogClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedBrowser", FirebaseAnalytics.b.INDEX, "BrowserItemAdapter", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserSettingDialogView extends RelativeLayout {
    public static final d Jmr = new d((byte) 0);
    private TextView CPg;
    private int CaW;
    private TextView JlU;
    private RecyclerView JlV;
    a JlX;
    private TextView Jmn;
    private b Jmo;
    private com.tencent.mm.plugin.webview.ui.tools.browser.listener.c Jmp;
    private List<com.tencent.mm.plugin.webview.ui.tools.browser.f> Jmq;

    static {
        AppMethodBeat.i(210485);
        AppMethodBeat.o(210485);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrowserSettingDialogView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(210482);
        AppMethodBeat.o(210482);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrowserSettingDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(210483);
        AppMethodBeat.o(210483);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrowserSettingDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(210484);
        this.Jmq = new ArrayList();
        this.CaW = -1;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ayk, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.adp);
        p.g(findViewById, "view.findViewById(R.id.browser_dialog_title)");
        this.JlU = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ads);
        p.g(findViewById2, "view.findViewById(R.id.browser_list)");
        this.JlV = (RecyclerView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ado);
        p.g(findViewById3, "view.findViewById(R.id.b…r_dialog_setting_confirm)");
        this.Jmn = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.adn);
        p.g(findViewById4, "view.findViewById(R.id.b…er_dialog_setting_cancel)");
        this.CPg = (TextView) findViewById4;
        TextView textView = this.JlU;
        if (textView == null) {
            p.btv("dialogTitle");
        }
        ao.a(textView.getPaint(), 0.8f);
        this.Jmo = new b(this, context);
        RecyclerView recyclerView = this.JlV;
        if (recyclerView == null) {
            p.btv("browserRecyclerView");
        }
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        recyclerView.setAdapter(this.Jmo);
        recyclerView.setOverScrollMode(2);
        recyclerView.setVerticalFadingEdgeEnabled(false);
        recyclerView.setNestedScrollingEnabled(false);
        w wVar = new w(context, 1);
        wVar.setDrawable(new a(recyclerView.getResources().getColor(R.color.m9), recyclerView));
        recyclerView.b(wVar);
        if (recyclerView instanceof MaxHeightRecyclerView) {
            ((MaxHeightRecyclerView) recyclerView).setMaxHeight((((int) ((((float) com.tencent.mm.cb.a.jo(context)) * 3.0f) / 4.0f)) - ((MaxHeightRecyclerView) recyclerView).getResources().getDimensionPixelSize(R.dimen.cr)) - ((MaxHeightRecyclerView) recyclerView).getResources().getDimensionPixelSize(R.dimen.bz));
        }
        TextView textView2 = this.Jmn;
        if (textView2 == null) {
            p.btv("confirmButton");
        }
        textView2.setOnClickListener(new f(this));
        TextView textView3 = this.CPg;
        if (textView3 == null) {
            p.btv("cancelButton");
        }
        textView3.setOnClickListener(new e(this));
        AppMethodBeat.o(210484);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$1$1$1", "Landroid/graphics/drawable/ColorDrawable;", "getIntrinsicHeight", "", "plugin-webview_release"})
    public static final class a extends ColorDrawable {
        final /* synthetic */ RecyclerView Jms;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i2, RecyclerView recyclerView) {
            super(i2);
            this.Jms = recyclerView;
        }

        public final int getIntrinsicHeight() {
            return 1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ BrowserSettingDialogView Jmt;

        e(BrowserSettingDialogView browserSettingDialogView) {
            this.Jmt = browserSettingDialogView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210479);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.webview.ui.tools.browser.listener.c cVar = this.Jmt.Jmp;
            if (cVar != null) {
                cVar.d(this.Jmt.JlX);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210479);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ BrowserSettingDialogView Jmt;

        f(BrowserSettingDialogView browserSettingDialogView) {
            this.Jmt = browserSettingDialogView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210480);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.webview.ui.tools.browser.listener.c cVar = this.Jmt.Jmp;
            if (cVar != null) {
                cVar.c(this.Jmt.JlX);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210480);
        }
    }

    public final void setBrowserSettingDialogClickListener(com.tencent.mm.plugin.webview.ui.tools.browser.listener.c cVar) {
        this.Jmp = cVar;
    }

    public final void setBrowserList(List<com.tencent.mm.plugin.webview.ui.tools.browser.f> list) {
        AppMethodBeat.i(210481);
        if (list == null) {
            AppMethodBeat.o(210481);
            return;
        }
        this.Jmq.clear();
        this.Jmq.add(0, new com.tencent.mm.plugin.webview.ui.tools.browser.f(2));
        this.Jmq.addAll(list);
        b bVar = this.Jmo;
        if (bVar != null) {
            List<com.tencent.mm.plugin.webview.ui.tools.browser.f> list2 = this.Jmq;
            p.h(list2, "dataList");
            bVar.mDataList.clear();
            bVar.mDataList.addAll(list2);
            AppMethodBeat.o(210481);
            return;
        }
        AppMethodBeat.o(210481);
    }

    public final void setSelectedBrowser(int i2) {
        if (i2 < 0) {
            this.CaW = 0;
        } else {
            this.CaW = i2 + 1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "updateSelectedIcon", "plugin-webview_release"})
    final class b extends RecyclerView.a<c> {
        final /* synthetic */ BrowserSettingDialogView Jmt;
        private final Context context;
        final ArrayList<com.tencent.mm.plugin.webview.ui.tools.browser.f> mDataList = new ArrayList<>();

        public b(BrowserSettingDialogView browserSettingDialogView, Context context2) {
            p.h(context2, "context");
            this.Jmt = browserSettingDialogView;
            AppMethodBeat.i(210477);
            this.context = context2;
            AppMethodBeat.o(210477);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(210473);
            p.h(viewGroup, "parent");
            View inflate = aa.jQ(this.context).inflate(R.layout.ayj, viewGroup, false);
            p.g(inflate, "view");
            c cVar = new c(inflate);
            AppMethodBeat.o(210473);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(c cVar, int i2) {
            int i3;
            AppMethodBeat.i(210476);
            c cVar2 = cVar;
            p.h(cVar2, "viewHolder");
            com.tencent.mm.plugin.webview.ui.tools.browser.f fVar = (com.tencent.mm.plugin.webview.ui.tools.browser.f) j.L(this.mDataList, i2);
            if (fVar == null) {
                AppMethodBeat.o(210476);
                return;
            }
            cVar2.GJH.setOnClickListener(new a(this, cVar2));
            WeImageView weImageView = cVar2.Jmw;
            if (this.Jmt.CaW == i2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            weImageView.setVisibility(i3);
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 1) {
                cVar2.Jmx.setVisibility(8);
                if (fVar.JlN == null) {
                    new com.tencent.mm.plugin.webview.ui.tools.browser.e(this.context, fVar.title, new C1982b(this, fVar, i2)).execute(fVar.resolveInfo);
                }
                cVar2.Jmg.setImageDrawable(fVar.JlN);
                cVar2.Jmh.setText(fVar.title);
                cVar2.Jmh.setContentDescription(fVar.title);
                AppMethodBeat.o(210476);
                return;
            }
            if (itemViewType == 2) {
                cVar2.Jmx.setVisibility(0);
                cVar2.Jmg.setVisibility(8);
                cVar2.Jmh.setVisibility(8);
            }
            AppMethodBeat.o(210476);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(210474);
            int size = this.mDataList.size();
            AppMethodBeat.o(210474);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(210475);
            com.tencent.mm.plugin.webview.ui.tools.browser.f fVar = (com.tencent.mm.plugin.webview.ui.tools.browser.f) j.L(this.mDataList, i2);
            if (fVar != null) {
                int i3 = fVar.dUm;
                AppMethodBeat.o(210475);
                return i3;
            }
            AppMethodBeat.o(210475);
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b Jmu;
            final /* synthetic */ c Jmv;

            a(b bVar, c cVar) {
                this.Jmu = bVar;
                this.Jmv = cVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(210471);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Jmu.Jmt.CaW = this.Jmv.lR();
                com.tencent.mm.plugin.webview.ui.tools.browser.listener.c cVar = this.Jmu.Jmt.Jmp;
                if (cVar != null) {
                    cVar.a(this.Jmu.Jmt.JlX, this.Jmu.Jmt.CaW, (com.tencent.mm.plugin.webview.ui.tools.browser.f) j.L(this.Jmu.mDataList, this.Jmu.Jmt.CaW));
                }
                this.Jmu.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(210471);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView$b$b  reason: collision with other inner class name */
        public static final class C1982b implements e.a {
            final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.browser.f Jmc;
            final /* synthetic */ b Jmu;
            final /* synthetic */ int gUj;

            C1982b(b bVar, com.tencent.mm.plugin.webview.ui.tools.browser.f fVar, int i2) {
                this.Jmu = bVar;
                this.Jmc = fVar;
                this.gUj = i2;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.browser.e.a
            public final void B(Drawable drawable) {
                AppMethodBeat.i(210472);
                this.Jmc.JlN = drawable;
                this.Jmu.ci(this.gUj);
                AppMethodBeat.o(210472);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserNotSetting", "Landroid/widget/TextView;", "getBrowserNotSetting", "()Landroid/widget/TextView;", "browserSelectedIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBrowserSelectedIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "browserTitle", "getBrowserTitle", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "plugin-webview_release"})
    static final class c extends RecyclerView.v {
        final RelativeLayout GJH;
        final ImageView Jmg;
        final TextView Jmh;
        final WeImageView Jmw;
        final TextView Jmx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(210478);
            View findViewById = view.findViewById(R.id.adr);
            p.g(findViewById, "itemView.findViewById(R.id.browser_item_container)");
            this.GJH = (RelativeLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.adq);
            p.g(findViewById2, "itemView.findViewById(R.id.browser_icon)");
            this.Jmg = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.adv);
            p.g(findViewById3, "itemView.findViewById(R.id.browser_title)");
            this.Jmh = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.adu);
            p.g(findViewById4, "itemView.findViewById(R.id.browser_selected_icon)");
            this.Jmw = (WeImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.adt);
            p.g(findViewById5, "itemView.findViewById(R.id.browser_not_setting)");
            this.Jmx = (TextView) findViewById5;
            AppMethodBeat.o(210478);
        }
    }
}

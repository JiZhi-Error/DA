package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "searchSetHidden", "", "createRecyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "notifyItemInserted", "", "pos", "newItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "Lkotlin/collections/ArrayList;", "notifyItemRemoved", "setSearchHidden", "hidden", "titleName", "", "updateSearchView", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class c extends b {
    public static final a Vcl = new a((byte) 0);
    private boolean Vck;
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(263649);
        AppMethodBeat.o(263649);
    }

    public c(Context context, b.a aVar, int i2, char c2) {
        this(context, aVar, i2, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b, com.tencent.mm.plugin.taskbar.ui.section.weapp.b
    public final View ewN() {
        AppMethodBeat.i(263650);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.be3));
        if (view == null) {
            view = findViewById(R.id.be3);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.be3), view);
        }
        AppMethodBeat.o(263650);
        return view;
    }

    private /* synthetic */ c(Context context, b.a aVar, int i2, byte b2) {
        this(context, aVar, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(Context context, b.a aVar, int i2) {
        super(context, aVar, i2, null, 0);
        p.h(context, "context");
        p.h(aVar, "callback");
        AppMethodBeat.i(263648);
        AppMethodBeat.o(263648);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.b
    public final TaskBarSectionWeAppRecyclerView hXh() {
        AppMethodBeat.i(263642);
        TaskBarSectionMyWeAppRecyclerView taskBarSectionMyWeAppRecyclerView = new TaskBarSectionMyWeAppRecyclerView(getContext());
        AppMethodBeat.o(263642);
        return taskBarSectionMyWeAppRecyclerView;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b, com.tencent.mm.plugin.taskbar.ui.section.weapp.b
    public final String fvi() {
        AppMethodBeat.i(263643);
        String string = getContext().getString(R.string.s0);
        p.g(string, "context.getString(R.stri…p_brand_taskbar_my_weapp)");
        AppMethodBeat.o(263643);
        return string;
    }

    public final void setSearchHidden(boolean z) {
        AppMethodBeat.i(263644);
        this.Vck = z;
        hXi();
        AppMethodBeat.o(263644);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.b
    public final void hXi() {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(263645);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        if (((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af2, "MMKernel.service(\n      …nModeService::class.java)");
            if (((com.tencent.mm.plugin.teenmode.a.b) af2).fvp() != 1) {
                z = true;
                Log.i("MicroMsg.AppBrandDesktopSectionMyWeAppView", "updateSearchView " + z + ' ' + this.Vck);
                RelativeLayout searchView = getSearchView();
                p.g(searchView, "searchView");
                if (z || this.Vck) {
                    i2 = 8;
                }
                searchView.setVisibility(i2);
                AppMethodBeat.o(263645);
            }
        }
        z = false;
        Log.i("MicroMsg.AppBrandDesktopSectionMyWeAppView", "updateSearchView " + z + ' ' + this.Vck);
        RelativeLayout searchView2 = getSearchView();
        p.g(searchView2, "searchView");
        i2 = 8;
        searchView2.setVisibility(i2);
        AppMethodBeat.o(263645);
    }

    public final void bF(ArrayList<b.a> arrayList) {
        AppMethodBeat.i(263646);
        p.h(arrayList, "newItems");
        TaskBarSectionWeAppRecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView");
            AppMethodBeat.o(263646);
            throw tVar;
        }
        ((TaskBarSectionMyWeAppRecyclerView) recyclerView).bF(arrayList);
        AppMethodBeat.o(263646);
    }

    public final void bG(ArrayList<b.a> arrayList) {
        AppMethodBeat.i(263647);
        p.h(arrayList, "newItems");
        TaskBarSectionWeAppRecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView");
            AppMethodBeat.o(263647);
            throw tVar;
        }
        ((TaskBarSectionMyWeAppRecyclerView) recyclerView).bG(arrayList);
        AppMethodBeat.o(263647);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

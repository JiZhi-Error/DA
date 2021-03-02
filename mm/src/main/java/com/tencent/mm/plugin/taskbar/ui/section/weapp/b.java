package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u0000 .2\u00020\u0001:\u0002-.B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\rH\u0016J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J*\u0010\u001f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010!0! \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010!0!\u0018\u00010\"0 J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020$2\u0010\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\"J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007H\u0014J\b\u0010,\u001a\u00020$H\u0016R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "searchView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getSearchView", "()Landroid/widget/RelativeLayout;", "value", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "weAppCallback", "getWeAppCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "setWeAppCallback", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "createRecyclerView", "getShowCount", "getShowLines", "getShowList", "", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "", "notifyDataSetChanged", "", "setDataList", "list", "titleName", "", "tryCloseOnPause", "", "pos", "updateSearchView", "AppBrandItem", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public class b extends com.tencent.mm.plugin.taskbar.ui.section.b {
    public static final C1807b FWe = new C1807b((byte) 0);
    private final TaskBarSectionWeAppRecyclerView Vcu;
    private final RelativeLayout Vcv;
    private TaskBarSectionWeAppRecyclerView.b Vcw;
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(238564);
        AppMethodBeat.o(238564);
    }

    public b(Context context, b.a aVar, int i2, byte b2) {
        this(context, aVar, i2);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public View ewN() {
        AppMethodBeat.i(238565);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.be3));
        if (view == null) {
            view = findViewById(R.id.be3);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.be3), view);
        }
        AppMethodBeat.o(238565);
        return view;
    }

    private /* synthetic */ b(Context context, b.a aVar, int i2) {
        this(context, aVar, i2, null, 0);
        AppMethodBeat.i(238563);
        AppMethodBeat.o(238563);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, b.a aVar, int i2, AttributeSet attributeSet, int i3) {
        super(context, aVar, i2, null, 0);
        p.h(context, "context");
        p.h(aVar, "callback");
        AppMethodBeat.i(263655);
        this.Vcu = hXh();
        View findViewById = getRoot().findViewById(R.id.k24);
        ((RelativeLayout) findViewById).setOnClickListener(new c(this));
        this.Vcv = (RelativeLayout) findViewById;
        fS(this.Vcu);
        AppMethodBeat.o(263655);
    }

    /* access modifiers changed from: protected */
    public final TaskBarSectionWeAppRecyclerView getRecyclerView() {
        return this.Vcu;
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout getSearchView() {
        return this.Vcv;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$searchView$1$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ b Vcx;

        c(b bVar) {
            this.Vcx = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263651);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TaskBarSectionWeAppRecyclerView.b weAppCallback = this.Vcx.getWeAppCallback();
            if (weAppCallback != null) {
                weAppCallback.hWY();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263651);
        }
    }

    public final TaskBarSectionWeAppRecyclerView.b getWeAppCallback() {
        return this.Vcw;
    }

    public final void setWeAppCallback(TaskBarSectionWeAppRecyclerView.b bVar) {
        AppMethodBeat.i(263652);
        this.Vcw = bVar;
        this.Vcu.setWeAppCallback(bVar);
        AppMethodBeat.o(263652);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hXi() {
        /*
            r6 = this;
            r5 = 263653(0x405e5, float:3.69457E-40)
            r1 = 1
            r2 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.lang.Class<com.tencent.mm.plugin.teenmode.a.b> r0 = com.tencent.mm.plugin.teenmode.a.b.class
            com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
            java.lang.String r3 = "MMKernel.service(ITeenModeService::class.java)"
            kotlin.g.b.p.g(r0, r3)
            com.tencent.mm.plugin.teenmode.a.b r0 = (com.tencent.mm.plugin.teenmode.a.b) r0
            boolean r0 = r0.Vt()
            if (r0 == 0) goto L_0x0055
            java.lang.Class<com.tencent.mm.plugin.teenmode.a.b> r0 = com.tencent.mm.plugin.teenmode.a.b.class
            com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
            java.lang.String r3 = "MMKernel.service(\n      …nModeService::class.java)"
            kotlin.g.b.p.g(r0, r3)
            com.tencent.mm.plugin.teenmode.a.b r0 = (com.tencent.mm.plugin.teenmode.a.b) r0
            int r0 = r0.fvp()
            if (r0 == r1) goto L_0x0055
            r0 = r1
        L_0x0031:
            java.lang.String r1 = "MicroMsg.AppBrandDesktopSectionWeAppView"
            java.lang.String r3 = "disable by teenMode "
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r3 = r3.concat(r4)
            com.tencent.mm.sdk.platformtools.Log.i(r1, r3)
            android.widget.RelativeLayout r1 = r6.Vcv
            java.lang.String r3 = "searchView"
            kotlin.g.b.p.g(r1, r3)
            if (r0 == 0) goto L_0x004e
            r2 = 8
        L_0x004e:
            r1.setVisibility(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        L_0x0055:
            r0 = r2
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.taskbar.ui.section.weapp.b.hXi():void");
    }

    public TaskBarSectionWeAppRecyclerView hXh() {
        AppMethodBeat.i(263654);
        TaskBarSectionWeAppRecyclerView taskBarSectionWeAppRecyclerView = new TaskBarSectionWeAppRecyclerView(getContext());
        AppMethodBeat.o(263654);
        return taskBarSectionWeAppRecyclerView;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public String fvi() {
        AppMethodBeat.i(238557);
        String string = getContext().getString(R.string.s9);
        p.g(string, "context.getString(R.stri…nd_taskbar_section_weapp)");
        AppMethodBeat.o(238557);
        return string;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(238558);
        hXi();
        this.Vcu.cax();
        AppMethodBeat.o(238558);
    }

    public final int getShowCount() {
        AppMethodBeat.i(238559);
        int showCount = this.Vcu.getShowCount();
        AppMethodBeat.o(238559);
        return showCount;
    }

    public final List<a> getShowList() {
        AppMethodBeat.i(238560);
        List<a> showList = this.Vcu.getShowList();
        AppMethodBeat.o(238560);
        return showList;
    }

    public final int getShowLines() {
        AppMethodBeat.i(238561);
        int showLines = this.Vcu.getShowLines();
        AppMethodBeat.o(238561);
        return showLines;
    }

    public final void setDataList(List<a> list) {
        AppMethodBeat.i(238562);
        this.Vcu.setDataList(list);
        AppMethodBeat.o(238562);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "getInfo", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "isDuplicated", "", "item", "plugin-taskbar_release"})
    public static final class a {
        public final LocalUsageInfo ooj;
        int position;

        public a(LocalUsageInfo localUsageInfo) {
            p.h(localUsageInfo, "info");
            AppMethodBeat.i(238555);
            this.ooj = localUsageInfo;
            AppMethodBeat.o(238555);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final boolean abI(int i2) {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$Companion;", "", "()V", "TAG", "", "itemsDescription", "items", "", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "plugin-taskbar_release"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.weapp.b$b  reason: collision with other inner class name */
    public static final class C1807b {
        private C1807b() {
        }

        public /* synthetic */ C1807b(byte b2) {
            this();
        }
    }

    public static final String lb(List<a> list) {
        AppMethodBeat.i(263656);
        p.h(list, "items");
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().ooj.nickname + ',');
        }
        String sb2 = sb.toString();
        p.g(sb2, "result.toString()");
        AppMethodBeat.o(263656);
        return sb2;
    }
}

package com.tencent.mm.plugin.taskbar.ui.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 52\u00020\u0001:\u000245B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\"H&J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020,J\u0010\u00100\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0007H\u0014J\b\u00101\u001a\u000202H&J\u0010\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "containerView", "getContainerView", "()Landroid/widget/FrameLayout;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "getSectionType", "()I", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "setViewModel", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;)V", "addContentView", "", "view", "Landroid/view/View;", "canAddToMinimize", "", "pos", "configItemViewHolderOnBind", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getClickedTaskBarItem", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyDataSetChanged", "onViewAttachedToWindow", "multiTaskInfo", "removeItem", "titleName", "", "tryCloseOnPause", "Callback", "Companion", "plugin-taskbar_release"})
public abstract class b extends FrameLayout {
    public static final C1801b FVs = new C1801b((byte) 0);
    g FVo = g.FVK;
    private final FrameLayout FVp;
    protected final a FVq;
    public final int FVr;
    private HashMap _$_findViewCache;
    private final TextView hbb;
    private final ViewGroup hwr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "", "disableScroll", "", "disable", "", "getTaskBarContainerBottom", "", "isLandscape", "onItemClicked", "tryCloseOnPause", "onSectionHeightChange", "sectionType", "reportOnItemAppear", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "reportOnItemClicked", "pos", "plugin-taskbar_release"})
    public interface a {
        void a(MultiTaskInfo multiTaskInfo, int i2);

        void abE(int i2);

        void jd(boolean z);

        void n(MultiTaskInfo multiTaskInfo);

        void wo(boolean z);
    }

    public View ewN() {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.be3));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(R.id.be3);
        this._$_findViewCache.put(Integer.valueOf((int) R.id.be3), findViewById);
        return findViewById;
    }

    public abstract String fvi();

    public abstract void notifyDataSetChanged();

    /* access modifiers changed from: protected */
    public final a getCallback() {
        return this.FVq;
    }

    /* access modifiers changed from: protected */
    public final int getSectionType() {
        return this.FVr;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, a aVar, int i2, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i4;
        p.h(context, "context");
        p.h(aVar, "callback");
        this.FVq = aVar;
        this.FVr = i2;
        g.a aVar2 = g.FVL;
        switch (this.FVr) {
            case 1:
            case 2:
                i4 = R.layout.c1v;
                break;
            case 3:
                i4 = R.layout.cg6;
                break;
            default:
                i4 = R.layout.c1u;
                break;
        }
        View inflate = LayoutInflater.from(context).inflate(i4, (ViewGroup) this, false);
        if (inflate == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.hwr = (ViewGroup) inflate;
        View findViewById = this.hwr.findViewById(R.id.ipm);
        p.g(findViewById, "root.findViewById<TextView>(R.id.title)");
        this.hbb = (TextView) findViewById;
        this.hbb.setText(fvi());
        addView(this.hwr);
        View findViewById2 = this.hwr.findViewById(R.id.be3);
        p.g(findViewById2, "root.findViewById(R.id.container)");
        this.FVp = (FrameLayout) findViewById2;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getRoot() {
        return this.hwr;
    }

    /* access modifiers changed from: protected */
    public final TextView getTitle() {
        return this.hbb;
    }

    public final g getViewModel() {
        return this.FVo;
    }

    public final void setViewModel(g gVar) {
        p.h(gVar, "<set-?>");
        this.FVo = gVar;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getContainerView() {
        return this.FVp;
    }

    public final void fS(View view) {
        p.h(view, "view");
        ((FrameLayout) ewN()).addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public boolean axh(int i2) {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$1"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ b FVt;
        final /* synthetic */ RecyclerView.v vLD;

        public c(b bVar, RecyclerView.v vVar) {
            this.FVt = bVar;
            this.vLD = vVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(238494);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int lR = this.vLD.lR();
            if (lR < 0 || lR >= this.FVt.getViewModel().FVI.size()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(238494);
                return;
            }
            this.FVt.getCallback().jd(this.FVt.abI(lR));
            this.FVt.getCallback().a(this.FVt.getViewModel().FVI.get(lR), lR);
            ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyClickTaskBarItem$plugin_taskbar_release(this.FVt.FVo.FVI.get(lR));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(238494);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$2"})
    public static final class d implements View.OnLongClickListener {
        final /* synthetic */ b FVt;
        final /* synthetic */ RecyclerView.v vLD;

        public d(b bVar, RecyclerView.v vVar) {
            this.FVt = bVar;
            this.vLD = vVar;
        }

        public final boolean onLongClick(final View view) {
            AppMethodBeat.i(238498);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (com.tencent.mm.plugin.taskbar.ui.c.b.hq(this.FVt.getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(238498);
                return false;
            }
            final int lR = this.vLD.lR();
            if (lR < 0 || lR >= this.FVt.getViewModel().FVI.size()) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(238498);
                return false;
            }
            com.tencent.mm.ui.widget.b.a aVar = (com.tencent.mm.ui.widget.b.a) view.getTag(R.id.iih);
            final boolean z = ao.isMultiTaskMode() && this.FVt.axh(lR);
            final AnonymousClass1 r2 = new View.OnCreateContextMenuListener() {
                /* class com.tencent.mm.plugin.taskbar.ui.section.b.d.AnonymousClass1 */

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.i(238495);
                    if (z && contextMenu != null) {
                        contextMenu.add(0, 0, 0, R.string.rv);
                    }
                    if (contextMenu != null) {
                        contextMenu.add(0, 1, 0, R.string.s2);
                        AppMethodBeat.o(238495);
                        return;
                    }
                    AppMethodBeat.o(238495);
                }
            };
            final AnonymousClass2 r3 = new o.g(this) {
                /* class com.tencent.mm.plugin.taskbar.ui.section.b.d.AnonymousClass2 */
                final /* synthetic */ d FVu;

                {
                    this.FVu = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(238496);
                    if (!z) {
                        i2 = 1;
                    }
                    switch (i2) {
                        case 0:
                            String str = this.FVu.FVt.getViewModel().FVI.get(lR).field_id;
                            p.g(str, "viewModel.showDataList[pos].field_id");
                            ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).addToMultiTask(str);
                            u.cG(this.FVu.FVt.getContext(), com.tencent.mm.cb.a.aI(this.FVu.FVt.getContext(), R.string.j7p));
                            AppMethodBeat.o(238496);
                            return;
                        case 1:
                            this.FVu.FVt.removeItem(lR);
                            break;
                    }
                    AppMethodBeat.o(238496);
                }
            };
            if (aVar != null) {
                aVar.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
                    /* class com.tencent.mm.plugin.taskbar.ui.section.b.d.AnonymousClass3 */
                    final /* synthetic */ d FVu;

                    {
                        this.FVu = r1;
                    }

                    public final void onDismiss() {
                        AppMethodBeat.i(238497);
                        this.FVu.FVt.getCallback().wo(false);
                        AppMethodBeat.o(238497);
                    }
                });
                this.FVt.getCallback().wo(true);
                aVar.a(view, r2, r3, 0, 0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(238498);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void removeItem(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.b$b  reason: collision with other inner class name */
    public static final class C1801b {
        private C1801b() {
        }

        public /* synthetic */ C1801b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public boolean abI(int i2) {
        return false;
    }
}

package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.ui.d;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0010\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0004()*+B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0006\u0010\"\u001a\u00020 J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010$\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\bJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0014R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "layoutManager", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "type2ViewHelper", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "Lkotlin/collections/HashMap;", "canAddToMinimize", "", "pos", "initView", "", "notifyDataSetChanged", "notifyLiveStatusChanged", "removeItem", "reportViewAttachOnWindow", "titleName", "", "tryCloseOnPause", "Adapter", "BaseViewHolder", "Companion", "OtherRecyclerView", "plugin-taskbar_release"})
public final class a extends com.tencent.mm.plugin.taskbar.ui.section.b implements b.a {
    private static final int VbW = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.c5);
    public static final c VbX = new c((byte) 0);
    private static final int apv = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.ci);
    private final e Aer;
    private final d VbS;
    private final TaskBarSectionOtherView$layoutManager$1 VbT;
    public final C1803a VbU;
    private final HashMap<Integer, b> VbV;
    private HashMap _$_findViewCache;

    public a(Context context, b.a aVar, int i2, char c2) {
        this(context, aVar, i2, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final View ewN() {
        AppMethodBeat.i(263634);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.be3));
        if (view == null) {
            view = findViewById(R.id.be3);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.be3), view);
        }
        AppMethodBeat.o(263634);
        return view;
    }

    public static final /* synthetic */ void a(a aVar, RecyclerView.v vVar) {
        AppMethodBeat.i(263633);
        p.h(vVar, "viewHolder");
        Log.i("MicroMsg.TaskBarSectionBaseView", "configItemViewHolderOnBind %d %d", Integer.valueOf(vVar.lR()), Integer.valueOf(aVar.FVr));
        View view = vVar.aus;
        view.setTag(R.id.iih, new com.tencent.mm.ui.widget.b.a(aVar.getContext(), view));
        view.setOnClickListener(new b.c(aVar, vVar));
        view.setOnLongClickListener(new b.d(aVar, vVar));
        AppMethodBeat.o(263633);
    }

    private /* synthetic */ a(Context context, b.a aVar, int i2, byte b2) {
        this(context, aVar, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private a(Context context, b.a aVar, int i2) {
        super(context, aVar, i2, null, 0);
        p.h(context, "context");
        p.h(aVar, "callback");
        AppMethodBeat.i(263631);
        e.a aVar2 = new e.a();
        aVar2.hZJ = true;
        aVar2.hZI = true;
        this.Aer = aVar2.aJT();
        this.VbS = new d(this, context);
        this.VbT = new TaskBarSectionOtherView$layoutManager$1(context);
        this.VbU = new C1803a();
        this.VbV = ae.g(s.U(2, new com.tencent.mm.plugin.taskbar.ui.section.e.a(this)), s.U(6, new com.tencent.mm.plugin.taskbar.ui.section.c.a(this)), s.U(21, new com.tencent.mm.plugin.taskbar.ui.section.b.a(this)), s.U(3, new com.tencent.mm.plugin.taskbar.ui.section.a.a(this)), s.U(4, new com.tencent.mm.plugin.taskbar.ui.section.a.a(this)), s.U(22, new com.tencent.mm.plugin.taskbar.ui.section.d.a(this)));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(apv - (VbW / 2), 0, apv - (VbW / 2), 0);
        getContainerView().addView(this.VbS, layoutParams);
        this.VbS.setLayoutManager(this.VbT);
        this.VbS.setAdapter(this.VbU);
        this.VbS.setOverScrollMode(2);
        AppMethodBeat.o(263631);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Companion;", "", "()V", "GAP", "", "getGAP", "()I", "MARGIN", "getMARGIN", "TAG", "", "plugin-taskbar_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(263632);
        AppMethodBeat.o(263632);
    }

    /* access modifiers changed from: protected */
    public final e getThumbLoaderOption() {
        return this.Aer;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final String fvi() {
        AppMethodBeat.i(263625);
        d.a aVar = com.tencent.mm.plugin.taskbar.ui.d.FUM;
        int floor = (int) Math.floor(((double) d.a.hXd()) / 3600000.0d);
        kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
        String aI = com.tencent.mm.cb.a.aI(getContext(), floor > 1 ? R.string.j7q : R.string.j7r);
        p.g(aI, "ResourceHelper.getString…bar_section_other_single)");
        String format = String.format(aI, Arrays.copyOf(new Object[]{Integer.valueOf(floor)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(263625);
        return format;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(263626);
        getTitle().setText(fvi());
        this.VbU.notifyDataSetChanged();
        AppMethodBeat.o(263626);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b.a, com.tencent.mm.plugin.taskbar.ui.section.b
    public final void removeItem(int i2) {
        AppMethodBeat.i(263627);
        if (i2 < 0 || i2 >= getViewModel().FVI.size()) {
            Log.i("MicroMsg.TaskBarSectionOtherView", "remove item outOfBounds " + i2 + ' ' + getViewModel().FVI.size());
            AppMethodBeat.o(263627);
            return;
        }
        MultiTaskInfo remove = getViewModel().FVI.remove(i2);
        Log.i("MicroMsg.TaskBarSectionOtherView", "remove item " + i2 + ' ' + remove.erh().title + ' ' + remove.field_id);
        ((PluginTaskBar) g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(remove);
        ((com.tencent.mm.plugin.taskbar.d) g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(remove.field_id, true, 3);
        if (getViewModel().FVI.size() != 0) {
            this.VbU.ck(i2);
            this.VbU.e(0, this.VbU.getItemCount(), Boolean.TRUE);
        }
        getCallback().abE(getSectionType());
        AppMethodBeat.o(263627);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final boolean abI(int i2) {
        AppMethodBeat.i(263628);
        switch (getViewModel().FVI.get(i2).field_type) {
            case 2:
            case 4:
                AppMethodBeat.o(263628);
                return true;
            case 3:
            default:
                AppMethodBeat.o(263628);
                return false;
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final boolean axh(int i2) {
        AppMethodBeat.i(263629);
        switch (getViewModel().FVI.get(i2).field_type) {
            case 6:
            case 21:
                AppMethodBeat.o(263629);
                return false;
            default:
                AppMethodBeat.o(263629);
                return true;
        }
    }

    public final void axk(int i2) {
        AppMethodBeat.i(263630);
        MultiTaskInfo multiTaskInfo = getViewModel().FVI.get(i2);
        p.h(multiTaskInfo, "multiTaskInfo");
        this.FVq.n(multiTaskInfo);
        AppMethodBeat.o(263630);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "pos", "holder", "position", "payloads", "", "", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-taskbar_release"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.other.a$a  reason: collision with other inner class name */
    public final class C1803a extends RecyclerView.a<b> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1803a() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(263616);
            p.h(viewGroup, "p0");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cg5, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(p0.c…ar_other_item, p0, false)");
            b bVar = new b(inflate);
            AppMethodBeat.o(263616);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(263618);
            b bVar2 = bVar;
            p.h(bVar2, "viewHolder");
            long currentTimeMillis = System.currentTimeMillis();
            MultiTaskInfo multiTaskInfo = a.this.getViewModel().FVI.get(i2);
            a.a(a.this, bVar2);
            a.this.axk(i2);
            b bVar3 = (b) a.this.VbV.get(Integer.valueOf(multiTaskInfo.field_type));
            if (bVar3 != null) {
                bVar3.a(i2, bVar2, a.this.getViewModel());
            }
            Log.i("MicroMsg.TaskBarSectionOtherView", "onBindViewHolder end " + multiTaskInfo.field_type + ' ' + (System.currentTimeMillis() - currentTimeMillis) + ' ' + multiTaskInfo.erh().title);
            AppMethodBeat.o(263618);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2, List list) {
            AppMethodBeat.i(263617);
            b bVar2 = bVar;
            p.h(bVar2, "holder");
            p.h(list, "payloads");
            if (list.isEmpty()) {
                super.a(bVar2, i2, list);
            }
            AppMethodBeat.o(263617);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(263619);
            int size = a.this.getViewModel().FVI.size();
            AppMethodBeat.o(263619);
            return size;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0019\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00160\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00160\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "defaultImage", "getDefaultImage", "image", "getImage", "liveEndWidget", "getLiveEndWidget", "()Landroid/view/View;", "liveWidget", "getLiveWidget", "playBtn", "getPlayBtn", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "title", "getTitle", "plugin-taskbar_release"})
    public static final class b extends RecyclerView.v {
        public final ImageView EsM;
        public final ImageView VbZ;
        public final View Vca;
        public final View Vcb;
        final ImageView hTd;
        public final TextView hbb;
        public final ImageView image;
        final TextView orb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(263620);
            this.VbZ = (ImageView) view.findViewById(R.id.bld);
            this.image = (ImageView) view.findViewById(R.id.dup);
            this.hbb = (TextView) view.findViewById(R.id.ipm);
            this.orb = (TextView) view.findViewById(R.id.id1);
            this.hTd = (ImageView) view.findViewById(R.id.b46);
            this.Vca = view.findViewById(R.id.cra);
            this.Vcb = view.findViewById(R.id.cpw);
            this.EsM = (ImageView) view.findViewById(R.id.gcc);
            AppMethodBeat.o(263620);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;Landroid/content/Context;)V", "viewWidth", "", "onAttachedToWindow", "", "onMeasure", "widthSpec", "heightSpec", "setClipChild", "updateItemOffset", "width", "plugin-taskbar_release"})
    public final class d extends RecyclerView {
        final /* synthetic */ a VbY;
        private int gRD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, Context context) {
            super(context);
            p.h(context, "context");
            this.VbY = aVar;
            AppMethodBeat.i(263624);
            AppMethodBeat.o(263624);
        }

        @Override // android.support.v7.widget.RecyclerView
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(263622);
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() != this.gRD) {
                this.gRD = getMeasuredWidth();
                Context context = getContext();
                p.g(context, "context");
                while (getItemDecorationCount() > 0) {
                    kN();
                }
                b(new C1804a(context));
            }
            AppMethodBeat.o(263622);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView$updateItemOffset$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-taskbar_release"})
        /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.other.a$d$a  reason: collision with other inner class name */
        public static final class C1804a extends RecyclerView.h {
            final /* synthetic */ Context $context;

            C1804a(Context context) {
                this.$context = context;
            }

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(263621);
                p.h(rect, "outRect");
                p.h(view, "view");
                p.h(recyclerView, "parent");
                p.h(sVar, "state");
                super.a(rect, view, recyclerView, sVar);
                int bw = RecyclerView.bw(view);
                if (bw == -1) {
                    RecyclerView.v bi = recyclerView.bi(view);
                    p.g(bi, "parent.getChildViewHolder(view)");
                    bw = bi.lS();
                }
                c cVar = a.VbX;
                rect.left = a.VbW / 2;
                c cVar2 = a.VbX;
                rect.right = a.VbW / 2;
                if (bw / 3 > 0) {
                    rect.top = com.tencent.mm.cb.a.aH(this.$context, R.dimen.cc);
                } else {
                    rect.top = 0;
                }
                rect.bottom = 0;
                AppMethodBeat.o(263621);
            }
        }

        @Override // android.support.v7.widget.RecyclerView
        public final void onAttachedToWindow() {
            AppMethodBeat.i(263623);
            super.onAttachedToWindow();
            setClipChildren(false);
            View rootView = getRootView();
            ViewParent parent = getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(263623);
                throw tVar;
            }
            View view = (View) parent;
            while (view != rootView && (view instanceof ViewGroup)) {
                ((ViewGroup) view).setClipChildren(false);
                if (view instanceof RecyclerView) {
                    break;
                }
                ViewParent parent2 = view.getParent();
                if (parent2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(263623);
                    throw tVar2;
                }
                view = (View) parent2;
            }
            AppMethodBeat.o(263623);
        }
    }
}

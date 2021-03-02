package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI;
import com.tencent.mm.plugin.appbrand.widget.recent.f;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

public class TaskBarSectionWeAppRecyclerView extends RecyclerView implements PopupWindow.OnDismissListener {
    private int EbC = 0;
    private boolean FUp = false;
    private a FVS;
    protected b FVT;
    private int FVU = 0;
    protected RecyclerView.a adj = null;
    private int gRD = 0;
    private List<b.a> opg = new ArrayList();
    private List<b.a> oph = new ArrayList();
    private int opp = 1;
    protected boolean xTL = false;

    public interface b {
        void a(RecyclerView.v vVar, b.a aVar, boolean z);

        void a(b.a aVar, int i2);

        void a(b.a aVar, boolean z);

        void a(boolean z, int i2, LocalUsageInfo localUsageInfo);

        void b(b.a aVar, int i2);

        void fuV();

        void hWX();

        void hWY();
    }

    public TaskBarSectionWeAppRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(238372);
        init(context);
        AppMethodBeat.o(238372);
    }

    public TaskBarSectionWeAppRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(238373);
        init(context);
        AppMethodBeat.o(238373);
    }

    public TaskBarSectionWeAppRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(238374);
        init(context);
        AppMethodBeat.o(238374);
    }

    private void init(Context context) {
        AppMethodBeat.i(238375);
        setLayoutManager(new GridLayoutManager() {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean canScrollVertically() {
                return false;
            }
        });
        this.adj = new a();
        setAdapter(this.adj);
        this.FVS = new a();
        this.FVS.adj = this.adj;
        setItemAnimator(this.FVS);
        ar(context, com.tencent.mm.cb.a.jn(getContext()));
        AppMethodBeat.o(238375);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(238376);
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() != this.gRD) {
            this.gRD = getMeasuredWidth();
            ar(getContext(), this.gRD);
        }
        AppMethodBeat.o(238376);
    }

    private int getContentWidth() {
        AppMethodBeat.i(263707);
        int jn = com.tencent.mm.cb.a.jn(getContext());
        AppMethodBeat.o(263707);
        return jn;
    }

    private void ar(final Context context, int i2) {
        AppMethodBeat.i(238377);
        final float aH = (float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ci);
        float eA = ((((float) i2) - (f.eA(context) * 4.0f)) - (2.0f * aH)) / 3.0f;
        if (eA <= ((float) com.tencent.mm.cb.a.aH(context, R.dimen.bt))) {
            aH = (float) com.tencent.mm.cb.a.aG(context, R.dimen.ct);
            eA = ((((float) i2) - (f.eA(context) * 4.0f)) - (2.0f * aH)) / 3.0f;
        }
        float f2 = ((float) i2) / 4.0f;
        float eA2 = f.eA(context);
        final float f3 = (f2 - aH) - eA2;
        final float f4 = eA - f3;
        final float f5 = (f2 - f4) - eA2;
        final float f6 = eA - f5;
        final float f7 = (f2 - f6) - eA2;
        final float f8 = eA - f7;
        while (getItemDecorationCount() > 0) {
            kN();
        }
        a(new RecyclerView.h(aH) {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.AnonymousClass2 */
            final /* synthetic */ float Vcm;

            {
                this.Vcm = r3;
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(263701);
                super.a(rect, view, recyclerView, sVar);
                int bw = RecyclerView.bw(view);
                if (bw == -1) {
                    bw = recyclerView.bi(view).auu;
                }
                if (bw / 4 == 1) {
                    rect.top = com.tencent.mm.cb.a.aH(context, R.dimen.ct);
                } else {
                    rect.top = 0;
                }
                rect.bottom = 0;
                switch (bw % 4) {
                    case 0:
                        rect.left = (int) this.Vcm;
                        rect.right = (int) f3;
                        AppMethodBeat.o(263701);
                        return;
                    case 1:
                        rect.left = (int) f4;
                        rect.right = (int) f5;
                        AppMethodBeat.o(263701);
                        return;
                    case 2:
                        rect.left = (int) f6;
                        rect.right = (int) f7;
                        AppMethodBeat.o(263701);
                        return;
                    case 3:
                        rect.left = (int) f8;
                        rect.right = (int) aH;
                        break;
                }
                AppMethodBeat.o(263701);
            }
        });
        AppMethodBeat.o(238377);
    }

    public void setWeAppCallback(b bVar) {
        this.FVT = bVar;
    }

    public void setDataList(List<b.a> list) {
        AppMethodBeat.i(238378);
        this.FUp = false;
        this.opg = new ArrayList(list);
        this.oph.clear();
        fvm();
        this.xTL = this.opg.size() > 8;
        int min = Math.min(this.opg.size(), this.xTL ? 7 : 8);
        for (int i2 = 0; i2 < min; i2++) {
            this.oph.add(this.opg.get(i2));
        }
        AppMethodBeat.o(238378);
    }

    public int getShowLines() {
        return this.opp;
    }

    private void fvm() {
        AppMethodBeat.i(238379);
        this.opp = this.oph.size() > 3 ? 2 : 1;
        AppMethodBeat.o(238379);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(238380);
        super.onAttachedToWindow();
        setClipChildren(false);
        View rootView = getRootView();
        View view = (View) getParent();
        while (view != rootView && (view instanceof ViewGroup)) {
            ((ViewGroup) view).setClipChildren(false);
            if (view instanceof RecyclerView) {
                break;
            }
            view = (View) view.getParent();
        }
        AppMethodBeat.o(238380);
    }

    /* access modifiers changed from: protected */
    public void hXg() {
        AppMethodBeat.i(263708);
        if (this.FVT != null) {
            this.FVT.fuV();
        }
        AppMethodBeat.o(263708);
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.v vVar, b.a aVar) {
        AppMethodBeat.i(263709);
        if (this.FVT != null) {
            this.FVT.a(vVar, aVar, false);
        }
        AppMethodBeat.o(263709);
    }

    public boolean canScrollHorizontally(int i2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<com.tencent.mm.plugin.taskbar.ui.b> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.plugin.taskbar.ui.b bVar, int i2) {
            AppMethodBeat.i(238370);
            a(bVar, i2);
            AppMethodBeat.o(238370);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(com.tencent.mm.plugin.taskbar.ui.b bVar, int i2, List list) {
            AppMethodBeat.i(263706);
            com.tencent.mm.plugin.taskbar.ui.b bVar2 = bVar;
            if (list.size() == 0) {
                a(bVar2, i2);
            }
            AppMethodBeat.o(263706);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(263704);
            if (!TaskBarSectionWeAppRecyclerView.this.xTL || i2 != getItemCount() - 1) {
                AppMethodBeat.o(263704);
                return 1;
            }
            AppMethodBeat.o(263704);
            return 2;
        }

        private void a(final com.tencent.mm.plugin.taskbar.ui.b bVar, int i2) {
            AppMethodBeat.i(263705);
            if (bVar == null) {
                AppMethodBeat.o(263705);
                return;
            }
            int i3 = bVar.auw;
            int ey = (int) f.ey(TaskBarSectionWeAppRecyclerView.this.getContext());
            bVar.aus.getLayoutParams().width = com.tencent.mm.plugin.appbrand.widget.desktop.b.ev(TaskBarSectionWeAppRecyclerView.this.getContext());
            bVar.FTx.getLayoutParams().width = ey;
            bVar.FTx.getLayoutParams().height = ey;
            bVar.nnL.getLayoutParams().width = -1;
            bVar.nnL.getLayoutParams().height = -1;
            if (i3 == 2) {
                bVar.titleTv.setVisibility(4);
                bVar.ooB.setImageResource(R.drawable.rn);
                bVar.ooB.setAlpha(0.1f);
                bVar.nnL.getLayoutParams().width = (int) (((float) com.tencent.mm.cb.a.aH(TaskBarSectionWeAppRecyclerView.this.getContext(), R.dimen.k9)) * com.tencent.mm.cb.a.ez(TaskBarSectionWeAppRecyclerView.this.getContext()));
                bVar.nnL.getLayoutParams().height = (int) (((float) com.tencent.mm.cb.a.aH(TaskBarSectionWeAppRecyclerView.this.getContext(), R.dimen.k9)) * com.tencent.mm.cb.a.ez(TaskBarSectionWeAppRecyclerView.this.getContext()));
                bVar.nnL.setImageResource(R.raw.icons_filled_more);
                bVar.nnL.setColorFilter(new PorterDuffColorFilter(com.tencent.mm.cb.a.n(TaskBarSectionWeAppRecyclerView.this.getContext(), R.color.BW_100_Alpha_0_5), PorterDuff.Mode.SRC_ATOP));
                bVar.ooD.setVisibility(8);
                bVar.aus.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(238365);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        TaskBarSectionWeAppRecyclerView.this.hXg();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(238365);
                    }
                });
                bVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.a.AnonymousClass2 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(238366);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (com.tencent.mm.plugin.appbrand.ui.f.bWW()) {
                            Intent intent = new Intent(TaskBarSectionWeAppRecyclerView.this.getContext(), AppBrandDebugUI.class);
                            Context context = TaskBarSectionWeAppRecyclerView.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(238366);
                            return true;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(238366);
                        return false;
                    }
                });
                AppMethodBeat.o(263705);
                return;
            }
            bVar.nnL.setColorFilter((ColorFilter) null);
            bVar.aus.setVisibility(0);
            final b.a a2 = TaskBarSectionWeAppRecyclerView.a(TaskBarSectionWeAppRecyclerView.this, i2);
            bVar.FTy = a2;
            a2.position = i2;
            bVar.titleTv.setVisibility(0);
            if (!Util.isNullOrNil(a2.ooj.cyB)) {
                bVar.titleTv.setText(a2.ooj.cyB);
                bVar.titleTv.setVisibility(0);
            } else if (!Util.isNullOrNil(a2.ooj.nickname)) {
                bVar.titleTv.setText(a2.ooj.nickname);
                bVar.titleTv.setVisibility(0);
            } else if (!Util.isNullOrNil(a2.ooj.username)) {
                Log.w("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", a2.ooj.username, a2.ooj.appId);
                bVar.titleTv.setVisibility(0);
                bVar.titleTv.setText(a2.ooj.username);
            } else {
                bVar.titleTv.setVisibility(0);
                bVar.titleTv.setText("");
            }
            Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "ccf-log [onBindViewHolder] name=%s iconUrl=%s", a2.ooj.nickname, a2.ooj.kVZ);
            if (!Util.isNullOrNil(a2.ooj.kVZ)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(bVar.nnL, a2.ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
            } else {
                bVar.nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
            }
            bVar.ooD.setVisibility(8);
            bVar.ooF.setVisibility(8);
            if (!Util.isNullOrNil(e.vO(a2.ooj.iOo))) {
                bVar.ooD.setVisibility(0);
                bVar.ooD.setText(e.vO(a2.ooj.iOo));
            } else if (a2.ooj.kWc) {
                bVar.ooF.setVisibility(0);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.multitask.ui.bg.a.erA().gRT);
                bVar.ooF.setBackground(shapeDrawable);
                bVar.ooF.setImageResource(R.raw.app_brand_destop_view_third_party_running_flag);
            }
            bVar.aus.setTag(R.id.iih, new com.tencent.mm.ui.widget.b.a(TaskBarSectionWeAppRecyclerView.this.getContext(), bVar.aus));
            bVar.aus.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.a.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(238367);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (TaskBarSectionWeAppRecyclerView.this.FVT != null) {
                        if (!WeChatBrands.Business.Entries.HomeAppbrandDrawer.checkAvailable(view.getContext())) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(238367);
                            return;
                        }
                        TaskBarSectionWeAppRecyclerView taskBarSectionWeAppRecyclerView = TaskBarSectionWeAppRecyclerView.this;
                        com.tencent.mm.plugin.taskbar.ui.b bVar2 = bVar;
                        b.a aVar = a2;
                        bVar.lR();
                        taskBarSectionWeAppRecyclerView.a(bVar2, aVar);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(238367);
                }
            });
            bVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.a.AnonymousClass4 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(238368);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    TaskBarSectionWeAppRecyclerView.a(TaskBarSectionWeAppRecyclerView.this, view, bVar.lR());
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(238368);
                    return true;
                }
            });
            TaskBarSectionWeAppRecyclerView.this.a(bVar);
            AppMethodBeat.o(263705);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(238369);
            int size = (TaskBarSectionWeAppRecyclerView.this.xTL ? 1 : 0) + TaskBarSectionWeAppRecyclerView.this.oph.size();
            AppMethodBeat.o(238369);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ com.tencent.mm.plugin.taskbar.ui.b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(238371);
            com.tencent.mm.plugin.taskbar.ui.b bVar = new com.tencent.mm.plugin.taskbar.ui.b(aa.jQ(TaskBarSectionWeAppRecyclerView.this.getContext()).inflate(R.layout.gx, viewGroup, false));
            AppMethodBeat.o(238371);
            return bVar;
        }
    }

    /* access modifiers changed from: protected */
    public View.OnCreateContextMenuListener a(final LocalUsageInfo localUsageInfo, final ag agVar) {
        AppMethodBeat.i(263710);
        AnonymousClass3 r0 = new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.AnonymousClass3 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(263702);
                if (agVar != null && !TaskBarSectionWeAppRecyclerView.hXj()) {
                    contextMenu.add(0, 0, 0, agVar.bf(localUsageInfo.username, localUsageInfo.iOo) ? R.string.s3 : R.string.rw);
                }
                contextMenu.add(0, 1, 0, R.string.s2);
                AppMethodBeat.o(263702);
            }
        };
        AppMethodBeat.o(263710);
        return r0;
    }

    /* access modifiers changed from: protected */
    public o.g a(final LocalUsageInfo localUsageInfo, final ag agVar, final int i2) {
        AppMethodBeat.i(263711);
        AnonymousClass4 r0 = new o.g() {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(263703);
                if (TaskBarSectionWeAppRecyclerView.hXj()) {
                    i2 = 1;
                }
                switch (i2) {
                    case 0:
                        if (agVar == null) {
                            AppMethodBeat.o(263703);
                            return;
                        } else if (agVar.bf(localUsageInfo.username, localUsageInfo.iOo)) {
                            agVar.bh(localUsageInfo.username, localUsageInfo.iOo);
                            u.cG(TaskBarSectionWeAppRecyclerView.this.getContext(), com.tencent.mm.cb.a.aI(TaskBarSectionWeAppRecyclerView.this.getContext(), R.string.s4));
                            TaskBarSectionWeAppRecyclerView.this.FVT.a(false, i2, localUsageInfo);
                            AppMethodBeat.o(263703);
                            return;
                        } else {
                            int bg = agVar.bg(localUsageInfo.username, localUsageInfo.iOo);
                            if (bg == 0) {
                                u.cG(TaskBarSectionWeAppRecyclerView.this.getContext(), com.tencent.mm.cb.a.aI(TaskBarSectionWeAppRecyclerView.this.getContext(), R.string.f3156rx));
                                TaskBarSectionWeAppRecyclerView.this.FVT.a(true, i2, localUsageInfo);
                                AppMethodBeat.o(263703);
                                return;
                            } else if (bg == -2) {
                                d a2 = h.a(TaskBarSectionWeAppRecyclerView.this.getContext(), TaskBarSectionWeAppRecyclerView.this.getContext().getResources().getString(R.string.k4, Integer.valueOf(((ag) com.tencent.mm.kernel.g.af(ag.class)).bxH())), "", TaskBarSectionWeAppRecyclerView.this.getContext().getResources().getString(R.string.x_), (DialogInterface.OnClickListener) null);
                                if (a2 != null) {
                                    a2.Dh(true);
                                    a2.setCanceledOnTouchOutside(false);
                                    a2.show();
                                }
                                AppMethodBeat.o(263703);
                                return;
                            } else if (bg == -3) {
                                d a3 = h.a(TaskBarSectionWeAppRecyclerView.this.getContext(), TaskBarSectionWeAppRecyclerView.this.getContext().getResources().getString(R.string.i7), "", TaskBarSectionWeAppRecyclerView.this.getContext().getResources().getString(R.string.x_), (DialogInterface.OnClickListener) null);
                                if (a3 != null) {
                                    a3.Dh(true);
                                    a3.setCanceledOnTouchOutside(false);
                                    a3.show();
                                }
                                AppMethodBeat.o(263703);
                                return;
                            } else {
                                Toast.makeText(TaskBarSectionWeAppRecyclerView.this.getContext(), TaskBarSectionWeAppRecyclerView.this.getContext().getString(R.string.jk), 0).show();
                                AppMethodBeat.o(263703);
                                return;
                            }
                        }
                    case 1:
                        TaskBarSectionWeAppRecyclerView.this.removeItem(i2);
                        break;
                }
                AppMethodBeat.o(263703);
            }
        };
        AppMethodBeat.o(263711);
        return r0;
    }

    public void onDismiss() {
        this.FUp = false;
    }

    public final void cax() {
        AppMethodBeat.i(238381);
        getAdapter().atj.notifyChanged();
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(this, a2.axQ(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView", "notifyDataChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView", "notifyDataChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(238381);
    }

    /* access modifiers changed from: protected */
    public final void axl(int i2) {
        AppMethodBeat.i(263712);
        this.adj.ck(i2);
        if (this.opg.size() > 8) {
            this.adj.cj(6);
        } else if (this.opg.size() == 8) {
            this.adj.cj(6);
            this.adj.ci(7);
        }
        this.adj.e(0, this.adj.getItemCount(), Boolean.TRUE);
        AppMethodBeat.o(263712);
    }

    public final void removeItem(int i2) {
        AppMethodBeat.i(263713);
        this.oph.remove(i2);
        b.a remove = this.opg.remove(i2);
        if (this.opg.size() > this.oph.size()) {
            this.oph.add(this.opg.get(this.oph.size()));
        }
        axl(i2);
        a(i2, remove);
        fvm();
        AppMethodBeat.o(263713);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, b.a aVar) {
        AppMethodBeat.i(263714);
        this.FVT.a(aVar, i2);
        AppMethodBeat.o(263714);
    }

    public void a(com.tencent.mm.plugin.taskbar.ui.b bVar) {
        AppMethodBeat.i(238382);
        this.FVT.a(this.opg.get(bVar.lR()), false);
        AppMethodBeat.o(238382);
    }

    public List<b.a> getShowList() {
        return this.oph;
    }

    public List<b.a> getDataList() {
        return this.opg;
    }

    public int getShowCount() {
        AppMethodBeat.i(238383);
        int size = this.oph.size();
        AppMethodBeat.o(238383);
        return size;
    }

    static /* synthetic */ b.a a(TaskBarSectionWeAppRecyclerView taskBarSectionWeAppRecyclerView, int i2) {
        AppMethodBeat.i(263715);
        if (i2 >= taskBarSectionWeAppRecyclerView.oph.size()) {
            AppMethodBeat.o(263715);
            return null;
        }
        b.a aVar = taskBarSectionWeAppRecyclerView.oph.get(i2);
        AppMethodBeat.o(263715);
        return aVar;
    }

    static /* synthetic */ void a(TaskBarSectionWeAppRecyclerView taskBarSectionWeAppRecyclerView, View view, int i2) {
        AppMethodBeat.i(263716);
        com.tencent.mm.ui.widget.b.a aVar = (com.tencent.mm.ui.widget.b.a) view.getTag(R.id.iih);
        if (aVar == null || com.tencent.mm.plugin.taskbar.ui.c.b.hq(taskBarSectionWeAppRecyclerView.getContext())) {
            AppMethodBeat.o(263716);
            return;
        }
        taskBarSectionWeAppRecyclerView.FUp = true;
        com.tencent.mm.plugin.appbrand.widget.recent.b ccQ = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
        LocalUsageInfo localUsageInfo = taskBarSectionWeAppRecyclerView.opg.get(i2).ooj;
        View.OnCreateContextMenuListener a2 = taskBarSectionWeAppRecyclerView.a(localUsageInfo, ccQ);
        o.g a3 = taskBarSectionWeAppRecyclerView.a(localUsageInfo, ccQ, i2);
        aVar.QwU = taskBarSectionWeAppRecyclerView;
        aVar.a(view, a2, a3, 0, 0);
        AppMethodBeat.o(263716);
    }

    static /* synthetic */ boolean hXj() {
        AppMethodBeat.i(263717);
        if (!((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp() == 1) {
            AppMethodBeat.o(263717);
            return false;
        }
        AppMethodBeat.o(263717);
        return true;
    }
}

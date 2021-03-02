package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.recent.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView extends RecyclerView implements GestureDetector.OnGestureListener {
    private RecyclerView.a adj = null;
    private GestureDetector mDJ;
    private int omS = 0;
    private g onJ;
    private boolean ooU = false;
    List<AppBrandDesktopView.c> opg = new ArrayList();
    List<AppBrandDesktopView.c> oph = new ArrayList();
    private ArrayList<RecyclerView.v> opi = new ArrayList<>();
    private GridLayoutManager opj = null;
    private int opk = 0;
    private e opl;
    int opm = 10;
    boolean opn = true;
    private b opo;
    private int opp = 3;
    private int opq = 3;
    private boolean opr = false;

    public interface b {
        void a(RecyclerView.v vVar, AppBrandDesktopView.c cVar);
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49684);
        init(context);
        AppMethodBeat.o(49684);
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49685);
        init(context);
        AppMethodBeat.o(49685);
    }

    public void setItemPadding(int i2) {
        this.omS = i2;
    }

    public void setOnItemClickListener(b bVar) {
        this.opo = bVar;
    }

    public void setDataList(List<AppBrandDesktopView.c> list) {
        AppMethodBeat.i(49686);
        this.opg = list;
        this.oph.clear();
        zV(this.opg.size());
        int completelyCountPerPage = a.getCompletelyCountPerPage() * this.opp;
        int i2 = this.opg.size() == completelyCountPerPage ? completelyCountPerPage : completelyCountPerPage - 1;
        int i3 = 0;
        while (i3 < this.opg.size() && i3 < i2) {
            this.oph.add(this.opg.get(i3));
            i3++;
        }
        this.opn = true;
        Log.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", Integer.valueOf(this.opg.size()), Integer.valueOf(this.oph.size()), Integer.valueOf(completelyCountPerPage));
        AppMethodBeat.o(49686);
    }

    public int getMaxShowItemCountIncludeMore() {
        AppMethodBeat.i(49687);
        int completelyCountPerPage = this.opp * a.getCompletelyCountPerPage();
        AppMethodBeat.o(49687);
        return completelyCountPerPage;
    }

    public int getShowLines() {
        return this.opp;
    }

    /* access modifiers changed from: package-private */
    public final void zV(int i2) {
        AppMethodBeat.i(49688);
        int completelyCountPerPage = a.getCompletelyCountPerPage();
        int i3 = i2 / completelyCountPerPage;
        if (i2 % completelyCountPerPage != 0) {
            i3++;
        }
        this.opp = Math.min(this.opq, i3);
        Log.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", Integer.valueOf(i2), Integer.valueOf(completelyCountPerPage), Integer.valueOf(this.opp), Integer.valueOf(this.opq));
        AppMethodBeat.o(49688);
    }

    public void setReporter(g gVar) {
        this.onJ = gVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(49689);
        this.opj = new GridLayoutManager(a.getCompletelyCountPerPage(), 1);
        setLayoutManager(this.opj);
        this.adj = new a();
        setAdapter(this.adj);
        this.mDJ = new GestureDetector(context, this);
        this.opl = new e();
        this.opl.adj = this.adj;
        setItemAnimator(this.opl);
        this.opq = a.cal();
        this.opm = (this.opq * a.getCompletelyCountPerPage()) + 2;
        AppMethodBeat.o(49689);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49690);
        if (motionEvent.getAction() == 0) {
            this.ooU = false;
            a(motionEvent, true);
        } else if (motionEvent.getAction() != 2) {
            Iterator<RecyclerView.v> it = this.opi.iterator();
            while (it.hasNext()) {
                it.next().aus.setPressed(false);
            }
            this.opi.clear();
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (!this.ooU) {
            AppMethodBeat.o(49690);
            return true;
        }
        AppMethodBeat.o(49690);
        return false;
    }

    private void a(MotionEvent motionEvent, boolean z) {
        RecyclerView.v bu;
        AppMethodBeat.i(49691);
        if (z == this.opr) {
            AppMethodBeat.o(49691);
            return;
        }
        View o = o(motionEvent.getX(), motionEvent.getY());
        if (!(o == null || (bu = bu(o)) == null)) {
            bu.aus.setPressed(z);
            if (z) {
                Log.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
                this.opi.add(bu);
            } else {
                Log.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
                this.opi.remove(bu);
            }
        }
        this.opr = z;
        AppMethodBeat.o(49691);
    }

    public boolean canScrollHorizontally(int i2) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(49692);
        Log.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
        AppMethodBeat.o(49692);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        RecyclerView.v bu;
        AppMethodBeat.i(49693);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        View o = o(motionEvent.getX(), motionEvent.getY());
        if (!(o == null || (bu = bu(o)) == null)) {
            bu.aus.performClick();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(49693);
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(49694);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        this.ooU = true;
        a(motionEvent, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(49694);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<d> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar, final int i2) {
            AppMethodBeat.i(49682);
            final d dVar2 = dVar;
            if (dVar2 != null) {
                int i3 = dVar2.auw;
                int ey = (int) b.ey(RecentAppBrandView.this.getContext());
                dVar2.aus.setPadding(RecentAppBrandView.this.omS, com.tencent.mm.cb.a.fromDPToPix(RecentAppBrandView.this.getContext(), 8), RecentAppBrandView.this.omS, com.tencent.mm.cb.a.fromDPToPix(RecentAppBrandView.this.getContext(), 16));
                dVar2.ooC.getLayoutParams().width = ((int) (((float) (com.tencent.mm.cb.a.aH(RecentAppBrandView.this.getContext(), R.dimen.k5) * 2)) * b.ez(RecentAppBrandView.this.getContext()))) + ey;
                dVar2.nnL.getLayoutParams().width = ey;
                dVar2.nnL.getLayoutParams().height = ey;
                dVar2.ooB.getLayoutParams().width = ey;
                dVar2.ooB.getLayoutParams().height = ey;
                if (i3 == 5) {
                    dVar2.titleTv.setVisibility(4);
                    dVar2.nnL.setImageResource(R.raw.multitask_bar_more_btn);
                    dVar2.ooD.setVisibility(8);
                    AppMethodBeat.o(49682);
                    return;
                }
                if (RecentAppBrandView.this.opk == 0) {
                    View view = dVar2.aus;
                    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Log.i("MicroMsg.RecentAppBrandView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(view.getMeasuredHeight()), Integer.valueOf(view.getMeasuredWidth()));
                    RecentAppBrandView.this.opk = view.getMeasuredWidth();
                }
                dVar2.aus.setVisibility(0);
                final AppBrandDesktopView.c a2 = RecentAppBrandView.a(RecentAppBrandView.this, i2);
                a2.position = i2;
                dVar2.ooG = a2;
                if (a2.ooj != null) {
                    if (!Util.isNullOrNil(a2.ooj.cyB)) {
                        dVar2.titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(a2.ooj.cyB));
                        dVar2.titleTv.setVisibility(0);
                    } else if (!Util.isNullOrNil(a2.ooj.nickname)) {
                        dVar2.titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(a2.ooj.nickname));
                        dVar2.titleTv.setVisibility(0);
                    } else if (!Util.isNullOrNil(a2.ooj.username)) {
                        Log.w("MicroMsg.RecentAppBrandView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", a2.ooj.username, a2.ooj.appId);
                        dVar2.titleTv.setVisibility(0);
                        dVar2.titleTv.setText(a2.ooj.username);
                    } else {
                        dVar2.titleTv.setVisibility(0);
                        dVar2.titleTv.setText("");
                    }
                    dVar2.ooB.setVisibility(0);
                    Log.i("MicroMsg.RecentAppBrandView", "ccf-log [onBindViewHolder] name=%s iconUrl=%s", a2.ooj.nickname, a2.ooj.kVZ);
                    if (!Util.isNullOrNil(a2.ooj.kVZ)) {
                        dVar2.nnL.setTag(a2.ooj.kVZ);
                        com.tencent.mm.modelappbrand.a.b.aXY().a(dVar2.nnL, a2.ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB, null, new b.p() {
                            /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.a.AnonymousClass1 */

                            @Override // com.tencent.mm.modelappbrand.a.b.p
                            public final boolean e(ImageView imageView) {
                                AppMethodBeat.i(227777);
                                if (imageView == null || !(imageView.getTag() instanceof String)) {
                                    AppMethodBeat.o(227777);
                                    return true;
                                }
                                boolean equals = imageView.getTag().equals(a2.ooj.kVZ);
                                AppMethodBeat.o(227777);
                                return equals;
                            }
                        });
                    } else {
                        dVar2.nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
                    }
                    dVar2.ooD.setVisibility(8);
                    dVar2.ooF.setVisibility(8);
                    if (!Util.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.vO(a2.ooj.iOo))) {
                        dVar2.ooD.setVisibility(0);
                        dVar2.ooD.setText(com.tencent.mm.plugin.appbrand.appcache.e.vO(a2.ooj.iOo));
                    } else if (a2.ooj != null && a2.ooj.kWc) {
                        dVar2.ooF.setVisibility(0);
                        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                        shapeDrawable.getPaint().setColor(c.caE().gRT);
                        dVar2.ooF.setBackground(shapeDrawable);
                        dVar2.ooF.setImageResource(R.raw.app_brand_destop_view_third_party_running_flag);
                    }
                    dVar2.aus.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(227778);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (RecentAppBrandView.this.opo != null) {
                                if (!WeChatBrands.Business.Entries.HomeAppbrandDrawer.checkAvailable(view.getContext())) {
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(227778);
                                    return;
                                }
                                RecentAppBrandView.this.opo.a(dVar2, a2);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(227778);
                        }
                    });
                    AppMethodBeat.o(49682);
                    return;
                }
                com.tencent.mm.modelappbrand.a.b.aXY().a(dVar2.nnL, "", com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                dVar2.titleTv.setVisibility(0);
                dVar2.ooD.setVisibility(8);
                dVar2.titleTv.setText("");
            }
            AppMethodBeat.o(49682);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(49680);
            int i3 = RecentAppBrandView.a(RecentAppBrandView.this, i2).type;
            AppMethodBeat.o(49680);
            return i3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(49681);
            int size = RecentAppBrandView.this.oph.size();
            AppMethodBeat.o(49681);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(49683);
            d dVar = new d(aa.jQ(RecentAppBrandView.this.getContext()).inflate(R.layout.gx, viewGroup, false));
            AppMethodBeat.o(49683);
            return dVar;
        }
    }

    public final void cax() {
        AppMethodBeat.i(49695);
        if (ld()) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(49678);
                    if (RecentAppBrandView.this.getAdapter() != null) {
                        RecentAppBrandView.this.getAdapter().atj.notifyChanged();
                    }
                    AppMethodBeat.o(49678);
                }
            });
            AppMethodBeat.o(49695);
            return;
        }
        if (getAdapter() != null) {
            getAdapter().atj.notifyChanged();
        }
        AppMethodBeat.o(49695);
    }

    public List<AppBrandDesktopView.c> getShowList() {
        return this.oph;
    }

    public List<AppBrandDesktopView.c> getDataList() {
        return this.opg;
    }

    public int getShowCount() {
        AppMethodBeat.i(49696);
        int size = this.oph.size();
        AppMethodBeat.o(49696);
        return size;
    }

    public int getDataCount() {
        AppMethodBeat.i(49697);
        int size = this.opg.size();
        AppMethodBeat.o(49697);
        return size;
    }

    public final AppBrandDesktopView.c zW(int i2) {
        AppMethodBeat.i(49698);
        AppBrandDesktopView.c cVar = this.opg.get(i2);
        AppMethodBeat.o(49698);
        return cVar;
    }

    static /* synthetic */ AppBrandDesktopView.c a(RecentAppBrandView recentAppBrandView, int i2) {
        AppMethodBeat.i(49699);
        AppBrandDesktopView.c cVar = recentAppBrandView.oph.get(i2);
        AppMethodBeat.o(49699);
        return cVar;
    }
}

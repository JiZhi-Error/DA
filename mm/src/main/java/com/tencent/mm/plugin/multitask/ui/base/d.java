package com.tencent.mm.plugin.multitask.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00017B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010&\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020'H\u0002J\u000f\u00100\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020.H\u0016J\u0012\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "setActivity", "mPosition", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "pageContainer", "Landroid/widget/FrameLayout;", "getPageContainer", "()Landroid/widget/FrameLayout;", "setPageContainer", "(Landroid/widget/FrameLayout;)V", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getPageHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setPageHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "viewPager", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "getViewPager", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "setViewPager", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;)V", "addMultiTaskWrapper", "", "calcViewScreenLocation", "Landroid/graphics/RectF;", "view", "Landroid/view/View;", "createMultiTaskSnapView", "inHomePanel", "", "initListener", "isAttach", "()Ljava/lang/Boolean;", "setCanSlide", "enable", "setSwipeBackListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "ParentAdapter", "plugin-multitask_release"})
public final class d {
    public com.tencent.mm.plugin.multitask.a.a Aak;
    public MultiTaskViewPager Adq;
    public com.tencent.mm.plugin.multitask.b.b Adr;
    public FrameLayout Ads;
    public final String TAG = "MicroMsg.MultiTaskWrapper";
    public Activity activity;
    int mPosition;

    public d(Activity activity2) {
        this.activity = activity2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$addMultiTaskWrapper$1", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "plugin-multitask_release"})
    public static final class b extends FrameLayout {
        final /* synthetic */ d Adv;
        final /* synthetic */ View Adw;
        final /* synthetic */ z.f Adx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, View view, z.f fVar, Context context) {
            super(context);
            this.Adv = dVar;
            this.Adw = view;
            this.Adx = fVar;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            Float f2 = null;
            AppMethodBeat.i(200766);
            Float valueOf = motionEvent != null ? Float.valueOf(motionEvent.getRawX()) : null;
            if (motionEvent != null) {
                f2 = Float.valueOf(motionEvent.getRawY());
            }
            View view = this.Adw;
            p.h(view, "view");
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            RectF rectF = new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (view.getHeight() + iArr[1]));
            if (!(valueOf == null || f2 == null)) {
                if (rectF.contains(valueOf.floatValue(), f2.floatValue())) {
                    AppMethodBeat.o(200766);
                    return true;
                }
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(200766);
            return dispatchTouchEvent;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$initListener$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-multitask_release"})
    public static final class c implements ViewPager.OnPageChangeListener {
        final /* synthetic */ d Adv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(d dVar) {
            this.Adv = dVar;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            this.Adv.mPosition = i2;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            boolean z;
            AppMethodBeat.i(200768);
            if (i2 == 1 && this.Adv.mPosition == 0) {
                com.tencent.mm.plugin.multitask.b.b bVar = this.Adv.Adr;
                if (bVar != null) {
                    bVar.bPu();
                }
                h.RTc.aX(new a(this));
            }
            if (i2 == 0) {
                MultiTaskViewPager multiTaskViewPager = this.Adv.Adq;
                if (multiTaskViewPager == null || multiTaskViewPager.getCurrentItem() != 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    MultiTaskViewPager multiTaskViewPager2 = this.Adv.Adq;
                    if (multiTaskViewPager2 != null) {
                        multiTaskViewPager2.setCanSlide(false);
                    }
                    com.tencent.mm.plugin.multitask.b.b bVar2 = this.Adv.Adr;
                    if (bVar2 != null) {
                        bVar2.eqT();
                        AppMethodBeat.o(200768);
                        return;
                    }
                }
            }
            AppMethodBeat.o(200768);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c Ady;

            a(c cVar) {
                this.Ady = cVar;
            }

            public final void run() {
                AppMethodBeat.i(200767);
                try {
                    FrameLayout frameLayout = this.Ady.Adv.Ads;
                    if (frameLayout != null) {
                        com.tencent.mm.plugin.multitask.b.b bVar = this.Ady.Adv.Adr;
                        if (bVar != null) {
                            com.tencent.mm.plugin.multitask.b.b bVar2 = this.Ady.Adv.Adr;
                            bVar.ah(bVar2 != null ? bVar2.aj(com.tencent.mm.ui.n.a.a(this.Ady.Adv.Ads, (int) (((float) frameLayout.getWidth()) / 1.25f), (int) (((float) frameLayout.getHeight()) / 1.25f), Bitmap.Config.RGB_565)) : null);
                            AppMethodBeat.o(200767);
                            return;
                        }
                        AppMethodBeat.o(200767);
                        return;
                    }
                    AppMethodBeat.o(200767);
                } catch (Throwable th) {
                    Log.e("MicroMsg.MultiTaskPageAdapter", "snapshot bitmap failed", th);
                    AppMethodBeat.o(200767);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$ParentAdapter;", "Landroid/support/v4/view/PagerAdapter;", "multiTaskView", "Landroid/view/View;", "launcherView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;Landroid/view/View;Landroid/view/View;)V", "getLauncherView", "()Landroid/view/View;", "getMultiTaskView", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "obj", "plugin-multitask_release"})
    public final class a extends q {
        private final View Adt;
        private final View Adu;
        final /* synthetic */ d Adv;

        public a(d dVar, View view, View view2) {
            p.h(view, "multiTaskView");
            p.h(view2, "launcherView");
            this.Adv = dVar;
            AppMethodBeat.i(200765);
            this.Adt = view;
            this.Adu = view2;
            AppMethodBeat.o(200765);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view;
            AppMethodBeat.i(200762);
            p.h(viewGroup, "container");
            if (i2 == 0) {
                view = this.Adt;
            } else {
                view = this.Adu;
            }
            viewGroup.removeView(view);
            viewGroup.addView(view);
            AppMethodBeat.o(200762);
            return view;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(200763);
            p.h(viewGroup, "container");
            p.h(obj, "object");
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(200763);
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            AppMethodBeat.i(200764);
            p.h(view, "view");
            p.h(obj, "obj");
            boolean j2 = p.j(view, obj);
            AppMethodBeat.o(200764);
            return j2;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            return 2;
        }
    }
}

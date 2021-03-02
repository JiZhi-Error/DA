package com.tencent.mm.plugin.multitask.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper;
import com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager;
import com.tencent.mm.plugin.multitask.ui.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 U2\u00020\u0001:\u0001UB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u001dH\u0016J\u0012\u0010D\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020\u001dH\u0016J\b\u0010H\u001a\u00020@H\u0002J\u0018\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020BH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010L\u001a\u00020\u0015H\u0016J\b\u0010M\u001a\u00020@H\u0016J\b\u0010N\u001a\u00020@H\u0016J\u0010\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020\u0015H\u0016J\u0010\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020\u001dH\u0016J\u0010\u0010S\u001a\u00020@2\u0006\u0010R\u001a\u00020\u001dH\u0016J\u0012\u0010=\u001a\u00020@2\b\u0010T\u001a\u0004\u0018\u00010*H\u0016R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0013R(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u0001068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;)V", "<set-?>", "getActivity", "()Landroid/app/Activity;", "setActivity", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mMultiTaskType", "getMMultiTaskType", "setMMultiTaskType", "(I)V", "maskView", "getMaskView", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "multiTaskSwipeBackListener", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "getMultiTaskSwipeBackListener", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "setMultiTaskSwipeBackListener", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;)V", "multiTaskWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "getMultiTaskWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;", "setMultiTaskWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "swipeBackListener", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "getSwipeBackListener", "()Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "setSwipeBackListener", "(Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;)V", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "createSwipeBackListener", "finish", "withAnimation", "helper", "degree", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-multitask_release"})
public class b implements a {
    public static final a zZH = new a((byte) 0);
    private Activity activity;
    private CustomViewPager zZC;
    private d zZD;
    protected SwipeBackLayout.b zZE;
    protected a.AbstractC1499a zZF;
    private int zZG = -1;

    static {
        AppMethodBeat.i(200375);
        AppMethodBeat.o(200375);
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public b(Activity activity2) {
        AppMethodBeat.i(200373);
        setActivity(activity2);
        eqG();
        AppMethodBeat.o(200373);
    }

    public b(Activity activity2, CustomViewPager customViewPager) {
        AppMethodBeat.i(200374);
        setActivity(activity2);
        this.zZC = customViewPager;
        eqG();
        AppMethodBeat.o(200374);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0018"}, hxF = {"com/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter$createSwipeBackListener$1", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "canInterceptTouch", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "left", "top", "dx", "dy", "scrollPercent", "", "onViewReleased", "willSwipeBack", "shouldInterceptTouchEvent", "plugin-multitask_release"})
    public static final class c implements SwipeBackLayout.b {
        final /* synthetic */ b zZI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.zZI = bVar;
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final void bw(float f2) {
            a.AbstractC1499a aVar;
            AppMethodBeat.i(200352);
            if (this.zZI.zZF == null || (aVar = this.zZI.zZF) == null) {
                AppMethodBeat.o(200352);
                return;
            }
            aVar.aY(f2);
            AppMethodBeat.o(200352);
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final void n(MotionEvent motionEvent) {
            a.AbstractC1499a aVar;
            AppMethodBeat.i(200353);
            p.h(motionEvent, "ev");
            if (this.zZI.zZF == null || (aVar = this.zZI.zZF) == null) {
                AppMethodBeat.o(200353);
                return;
            }
            aVar.n(motionEvent);
            AppMethodBeat.o(200353);
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final int bS(boolean z) {
            a.AbstractC1499a aVar;
            AppMethodBeat.i(200354);
            if (this.zZI.zZF == null || (aVar = this.zZI.zZF) == null) {
                AppMethodBeat.o(200354);
                return 1;
            }
            int jJ = aVar.jJ(z);
            AppMethodBeat.o(200354);
            return jJ;
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final boolean eqH() {
            a.AbstractC1499a aVar;
            AppMethodBeat.i(200355);
            if (this.zZI.zZF == null || (aVar = this.zZI.zZF) == null) {
                AppMethodBeat.o(200355);
                return false;
            }
            boolean eqD = aVar.eqD();
            AppMethodBeat.o(200355);
            return eqD;
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final boolean j(MotionEvent motionEvent) {
            a.AbstractC1499a aVar;
            AppMethodBeat.i(200356);
            p.h(motionEvent, "ev");
            if (this.zZI.zZF == null || (aVar = this.zZI.zZF) == null) {
                AppMethodBeat.o(200356);
                return false;
            }
            boolean j2 = aVar.j(motionEvent);
            AppMethodBeat.o(200356);
            return j2;
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final int eqE() {
            AppMethodBeat.i(200357);
            a.AbstractC1499a aVar = this.zZI.zZF;
            if (aVar != null) {
                int eqE = aVar.eqE();
                AppMethodBeat.o(200357);
                return eqE;
            }
            AppMethodBeat.o(200357);
            return 0;
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final void RF(int i2) {
            AppMethodBeat.i(200358);
            a.AbstractC1499a aVar = this.zZI.zZF;
            if (aVar != null) {
                aVar.RF(i2);
                AppMethodBeat.o(200358);
                return;
            }
            AppMethodBeat.o(200358);
        }

        @Override // com.tencent.mm.ui.widget.SwipeBackLayout.b
        public final boolean eqF() {
            AppMethodBeat.i(200359);
            a.AbstractC1499a aVar = this.zZI.zZF;
            if (aVar != null) {
                boolean eqF = aVar.eqF();
                AppMethodBeat.o(200359);
                return eqF;
            }
            AppMethodBeat.o(200359);
            return false;
        }
    }

    private final void eqG() {
        AppMethodBeat.i(200360);
        this.zZE = new c(this);
        AppMethodBeat.o(200360);
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public Intent getIntent() {
        AppMethodBeat.i(200361);
        Activity activity2 = getActivity();
        if (activity2 != null) {
            Intent intent = activity2.getIntent();
            AppMethodBeat.o(200361);
            return intent;
        }
        AppMethodBeat.o(200361);
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public ViewGroup chG() {
        AppMethodBeat.i(200362);
        Activity activity2 = getActivity();
        if (activity2 == null) {
            AppMethodBeat.o(200362);
            return null;
        }
        Window window = activity2.getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        if (decorView == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(200362);
            throw tVar;
        }
        ViewGroup viewGroup = (ViewGroup) decorView;
        AppMethodBeat.o(200362);
        return viewGroup;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public View getContentView() {
        SwipeBackLayout swipeBackLayout;
        AppMethodBeat.i(200363);
        if (getActivity() instanceof MMActivity) {
            Activity activity2 = getActivity();
            if (activity2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(200363);
                throw tVar;
            } else if (((MMActivity) activity2).getSwipeBackLayout() != null) {
                Activity activity3 = getActivity();
                if (activity3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(200363);
                    throw tVar2;
                }
                swipeBackLayout = ((MMActivity) activity3).getSwipeBackLayout();
                SwipeBackLayout swipeBackLayout2 = swipeBackLayout;
                AppMethodBeat.o(200363);
                return swipeBackLayout2;
            }
        }
        if (getActivity() instanceof MMFragmentActivity) {
            Activity activity4 = getActivity();
            if (activity4 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(200363);
                throw tVar3;
            } else if (((MMFragmentActivity) activity4).getSwipeBackLayout() != null) {
                Activity activity5 = getActivity();
                if (activity5 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(200363);
                    throw tVar4;
                }
                swipeBackLayout = ((MMFragmentActivity) activity5).getSwipeBackLayout();
                SwipeBackLayout swipeBackLayout22 = swipeBackLayout;
                AppMethodBeat.o(200363);
                return swipeBackLayout22;
            }
        }
        swipeBackLayout = null;
        SwipeBackLayout swipeBackLayout222 = swipeBackLayout;
        AppMethodBeat.o(200363);
        return swipeBackLayout222;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public View getMaskView() {
        Window window;
        Window window2;
        AppMethodBeat.i(200364);
        if (getActivity() instanceof MMActivity) {
            Activity activity2 = getActivity();
            if (activity2 == null || (window2 = activity2.getWindow()) == null) {
                AppMethodBeat.o(200364);
                return null;
            }
            View decorView = window2.getDecorView();
            AppMethodBeat.o(200364);
            return decorView;
        } else if (!(getActivity() instanceof MMFragmentActivity) || this.zZC == null) {
            AppMethodBeat.o(200364);
            return null;
        } else {
            CustomViewPager customViewPager = this.zZC;
            if (customViewPager == null) {
                Activity activity3 = getActivity();
                if (activity3 == null || (window = activity3.getWindow()) == null) {
                    customViewPager = null;
                } else {
                    customViewPager = window.getDecorView();
                }
            }
            AppMethodBeat.o(200364);
            return customViewPager;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public Bitmap getBitmap() {
        AppMethodBeat.i(200365);
        com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
        if (com.tencent.mm.plugin.multitask.f.c.Ss(this.zZG)) {
            AppMethodBeat.o(200365);
            return null;
        }
        try {
            getActivity();
            View maskView = getMaskView();
            if (maskView != null) {
                Bitmap a2 = com.tencent.mm.ui.n.a.a(getMaskView(), (int) (((float) maskView.getWidth()) / 1.25f), (int) (((float) maskView.getHeight()) / 1.25f), Bitmap.Config.RGB_565);
                AppMethodBeat.o(200365);
                return a2;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.MultiTaskPageAdapter", "get bitmap failed", th);
        }
        AppMethodBeat.o(200365);
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public final Bitmap ag(Bitmap bitmap) {
        AppMethodBeat.i(200366);
        com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
        if (com.tencent.mm.plugin.multitask.f.c.Ss(this.zZG)) {
            AppMethodBeat.o(200366);
            return null;
        }
        if (bitmap != null) {
            try {
                float width = (float) bitmap.getWidth();
                float height = (float) bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
                AppMethodBeat.o(200366);
                return createBitmap;
            } catch (Throwable th) {
                Log.e("MicroMsg.MultiTaskPageAdapter", "get rotate bitmap failed", th);
            }
        }
        AppMethodBeat.o(200366);
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public int chH() {
        return -1;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public boolean bPp() {
        AppMethodBeat.i(200367);
        if (getActivity() instanceof MMActivity) {
            Activity activity2 = getActivity();
            if (activity2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(200367);
                throw tVar;
            } else if (((MMActivity) activity2).getSwipeBackLayout() != null) {
                AppMethodBeat.o(200367);
                return true;
            }
        }
        AppMethodBeat.o(200367);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public void a(boolean z, com.tencent.mm.plugin.multitask.b.b bVar) {
        MultiTaskInfo eqN;
        AppMethodBeat.i(200368);
        p.h(bVar, "helper");
        Log.i("MicroMsg.MultiTaskPageAdapter", "finish, withAnimation:%s", Boolean.valueOf(z));
        if (bVar.eqZ() && (eqN = bVar.eqN()) != null) {
            String str = eqN.field_id;
            p.g(str, "it.field_id");
            ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).sendMultiTaskEvent(0, str, eqN.field_type);
        }
        if (getActivity() instanceof MMActivity) {
            Intent intent = getIntent();
            if (intent != null) {
                if (z) {
                    intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.di);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
                } else {
                    intent.putExtra("MMActivity.OverrideExitAnimation", 0);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                }
            }
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                AppMethodBeat.o(200368);
                return;
            }
        }
        AppMethodBeat.o(200368);
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public final void RE(int i2) {
        this.zZG = i2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public void a(a.b bVar) {
        AppMethodBeat.i(200369);
        Log.i("MicroMsg.MultiTaskPageAdapter", "convertToTranslucent");
        com.tencent.mm.ui.base.b.a(getActivity(), new C1500b(this, new AtomicInteger(0), bVar));
        Log.i("MicroMsg.MultiTaskPageAdapter", "multiTask page convertActivityToTranslucent");
        AppMethodBeat.o(200369);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "drawComplete", "", "onComplete"})
    /* renamed from: com.tencent.mm.plugin.multitask.a.b$b  reason: collision with other inner class name */
    static final class C1500b implements b.AbstractC2081b {
        final /* synthetic */ AtomicInteger UYY;
        final /* synthetic */ b zZI;
        final /* synthetic */ a.b zZK;

        C1500b(b bVar, AtomicInteger atomicInteger, a.b bVar2) {
            this.zZI = bVar;
            this.UYY = atomicInteger;
            this.zZK = bVar2;
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(boolean z) {
            AppMethodBeat.i(200351);
            if (z || this.UYY.getAndIncrement() > 0) {
                a.b bVar = this.zZK;
                if (bVar != null) {
                    bVar.ei(z);
                    AppMethodBeat.o(200351);
                    return;
                }
                AppMethodBeat.o(200351);
                return;
            }
            com.tencent.mm.ui.base.b.a(this.zZI.getActivity(), new b.AbstractC2081b(this) {
                /* class com.tencent.mm.plugin.multitask.a.b.C1500b.AnonymousClass1 */
                final /* synthetic */ C1500b zZL;

                {
                    this.zZL = r1;
                }

                @Override // com.tencent.mm.ui.base.b.AbstractC2081b
                public final void ei(boolean z) {
                    AppMethodBeat.i(200350);
                    a.b bVar = this.zZL.zZK;
                    if (bVar != null) {
                        bVar.ei(z);
                        AppMethodBeat.o(200350);
                        return;
                    }
                    AppMethodBeat.o(200350);
                }
            });
            AppMethodBeat.o(200351);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public boolean bCI() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public boolean bPv() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public final void sj(boolean z) {
        AppMethodBeat.i(200370);
        d dVar = this.zZD;
        if (dVar != null) {
            MultiTaskViewPager multiTaskViewPager = dVar.Adq;
            if (multiTaskViewPager != null) {
                multiTaskViewPager.setCanSlide(z);
            }
            Log.i(dVar.TAG, "canSlide:%b", Boolean.valueOf(z));
            AppMethodBeat.o(200370);
            return;
        }
        AppMethodBeat.o(200370);
    }

    @Override // com.tencent.mm.plugin.multitask.a.a
    public final void a(com.tencent.mm.plugin.multitask.b.b bVar) {
        MultiTaskSnapViewWrapper multiTaskSnapViewWrapper;
        AppMethodBeat.i(200371);
        if (getActivity() instanceof MMFragmentActivity) {
            if (this.zZD == null) {
                this.zZD = new d(getActivity());
            }
            d dVar = this.zZD;
            if (dVar != null) {
                b bVar2 = this;
                z.f fVar = new z.f();
                fVar.SYG = (T) bVar2.getContentView();
                if (fVar.SYG == null || fVar.SYG.getParent() == null) {
                    Log.i(dVar.TAG, "addMultiTaskWrapper, contentView is null");
                    AppMethodBeat.o(200371);
                    return;
                }
                Bitmap eqV = bVar.eqV();
                if (eqV == null || eqV.isRecycled()) {
                    Log.i(dVar.TAG, "addMultiTaskWrapper, bitmap is null or recycle");
                    AppMethodBeat.o(200371);
                    return;
                } else if (fVar.SYG.getParent() == null) {
                    Log.i(dVar.TAG, "addMultiTaskWrapper, contentView parent is null");
                    AppMethodBeat.o(200371);
                    return;
                } else {
                    dVar.Adr = bVar;
                    dVar.Aak = bVar2;
                    ViewParent parent = fVar.SYG.getParent();
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(200371);
                        throw tVar;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(fVar.SYG);
                    viewGroup.removeView(fVar.SYG);
                    ViewGroup.LayoutParams layoutParams = fVar.SYG.getLayoutParams();
                    View view = new View(fVar.SYG.getContext());
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(at.fromDPToPix(dVar.activity, 15), -1);
                    layoutParams2.gravity = 5;
                    view.setLayoutParams(layoutParams2);
                    dVar.Ads = new d.b(dVar, view, fVar, fVar.SYG.getContext());
                    FrameLayout frameLayout = dVar.Ads;
                    if (frameLayout != null) {
                        frameLayout.addView(fVar.SYG);
                        frameLayout.addView(view);
                        MultiTaskViewPager multiTaskViewPager = new MultiTaskViewPager(dVar.activity);
                        multiTaskViewPager.setCanSlide(true);
                        Activity activity2 = dVar.activity;
                        if (activity2 != null) {
                            multiTaskSnapViewWrapper = new MultiTaskSnapViewWrapper(activity2);
                        } else {
                            multiTaskSnapViewWrapper = null;
                        }
                        if (multiTaskSnapViewWrapper != null) {
                            multiTaskSnapViewWrapper.setBackgroundColor(android.support.v4.content.b.n(multiTaskViewPager.getContext(), R.color.f3044b));
                        }
                        if (multiTaskSnapViewWrapper == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.base.IMultiTaskView");
                            AppMethodBeat.o(200371);
                            throw tVar2;
                        }
                        MultiTaskSnapViewWrapper multiTaskSnapViewWrapper2 = multiTaskSnapViewWrapper;
                        multiTaskSnapViewWrapper2.setBitmap(eqV);
                        multiTaskViewPager.setAdapter(new d.a(dVar, frameLayout, multiTaskSnapViewWrapper2.getView()));
                        multiTaskViewPager.addView(dVar.Ads);
                        com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
                        multiTaskViewPager.setPageMargin(com.tencent.mm.plugin.multitask.f.a.esC());
                        multiTaskViewPager.setPageMarginDrawable(R.color.a1l);
                        multiTaskViewPager.setCurrentItem(0, false);
                        dVar.Adq = multiTaskViewPager;
                        MultiTaskViewPager multiTaskViewPager2 = dVar.Adq;
                        if (multiTaskViewPager2 != null) {
                            multiTaskViewPager2.setCanOnlySlideBySide(true);
                        }
                        viewGroup.addView(dVar.Adq, indexOfChild, layoutParams);
                        MultiTaskViewPager multiTaskViewPager3 = dVar.Adq;
                        if (multiTaskViewPager3 != null) {
                            multiTaskViewPager3.setOnPageChangeListener(new d.c(dVar));
                            AppMethodBeat.o(200371);
                            return;
                        }
                        AppMethodBeat.o(200371);
                        return;
                    }
                    AppMethodBeat.o(200371);
                    return;
                }
            }
        }
        AppMethodBeat.o(200371);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r0 == null) goto L_0x004d;
     */
    @Override // com.tencent.mm.plugin.multitask.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.plugin.multitask.a.a.AbstractC1499a r4) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.a.b.a(com.tencent.mm.plugin.multitask.a.a$a):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

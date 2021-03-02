package com.tencent.mm.plugin.multitask.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002:;J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H&J\b\u0010'\u001a\u00020\u0017H&J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H&J\b\u0010+\u001a\u00020\u0017H&J\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020&H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u00020\u000fH&J\b\u00100\u001a\u00020$H&J\b\u00101\u001a\u00020$H&J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u000fH&J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0017H&J\u0010\u00106\u001a\u00020$2\u0006\u00105\u001a\u00020\u0017H&J\u0012\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u000109H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "addMultiTaskWrapper", "", "pageHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "canConvertToTranslucent", "convertToTranslucent", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "convertToTranslucentIfNeed", "finish", "withAnimation", "helper", "degree", "onCaptureBitmapBefore", "onCaptureBitmapCancel", "setMultiTaskType", "type", "setSwipeAheadEnable", "enable", "setSwipeBackEnable", "setSwipeBackListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "IMultiTaskSwipeBackListener", "TranslucentCallback", "plugin-multitask_release"})
public interface a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1499a {
        void RF(int i2);

        void aY(float f2);

        boolean eqD();

        int eqE();

        boolean eqF();

        boolean j(MotionEvent motionEvent);

        int jJ(boolean z);

        void n(MotionEvent motionEvent);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "", "onComplete", "", "done", "", "plugin-multitask_release"})
    public interface b {
        void ei(boolean z);
    }

    void RE(int i2);

    void a(AbstractC1499a aVar);

    void a(b bVar);

    void a(com.tencent.mm.plugin.multitask.b.b bVar);

    void a(boolean z, com.tencent.mm.plugin.multitask.b.b bVar);

    Bitmap ag(Bitmap bitmap);

    boolean bCI();

    boolean bPp();

    boolean bPv();

    ViewGroup chG();

    int chH();

    Activity getActivity();

    Bitmap getBitmap();

    View getContentView();

    Intent getIntent();

    View getMaskView();

    void sj(boolean z);
}

package com.tencent.mm.plugin.festival.finder;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.plugin.festival.ui.StarryNight;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract;", "", "Presenter", "ViewCallback", "plugin-festival_release"})
public interface k {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010,\u001a\u0004\u0018\u00010-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020/H&J\b\u00101\u001a\u00020/H&J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u000eH&J\u0018\u00104\u001a\u00020/2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000106H&J\u0012\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u000109H&J\u0018\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u0016H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$H&J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$H&J\u0018\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$H&J\u0010\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020$H&J\u0010\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020$H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0012\u0010\u001b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0018\u0010)\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\f¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$ViewCallback;", "clickRippleDuration", "", "getClickRippleDuration", "()J", "drawEffect", "", "getDrawEffect", "()I", "setDrawEffect", "(I)V", "isClickRippleEnabled", "", "()Z", "setClickRippleEnabled", "(Z)V", "isDraggable", "setDraggable", "isLaidOut", "lastTouchUpPointRaw", "Landroid/graphics/PointF;", "getLastTouchUpPointRaw", "()Landroid/graphics/PointF;", "srcHeight", "getSrcHeight", "srcWidth", "getSrcWidth", "vRect", "Landroid/graphics/RectF;", "getVRect", "()Landroid/graphics/RectF;", "vRectDefault", "getVRectDefault", "vScale", "", "getVScale", "()F", "vScaleDefault", "getVScaleDefault", "visibility", "getVisibility", "setVisibility", "captureForShare", "Landroid/graphics/Bitmap;", "pauseSensor", "", "requestFairyWandEffectDisappear", "resumeSensor", "setEnableFairyWand", "enable", "setOnFairyWandDrawEndListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "setScaleAndTranslate", "sat", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslate;", "sourceToViewPointF", "sp", "vp", "sourceToViewX", "sx", "sourceToViewY", "sy", "startFlashStar", "vx", "vy", "viewToSourceX", "viewToSourceY", "plugin-festival_release"})
    public interface a extends com.tencent.mm.plugin.finder.presenter.base.a<b> {
        void Ff(boolean z);

        void Fg(boolean z);

        float Y(float f2);

        float Z(float f2);

        void aN(float f2, float f3);

        int aZ(float f2);

        void ar(kotlin.g.a.a<Boolean> aVar);

        PointF c(PointF pointF, PointF pointF2);

        int cV(float f2);

        void dRg();

        void egF();

        boolean egf();

        void egv();

        Bitmap ewK();

        long getClickRippleDuration();

        PointF getLastTouchUpPointRaw();

        int getSrcHeight();

        int getSrcWidth();

        RectF getVRectDefault();

        float getVScaleDefault();

        void setDraggable(boolean z);

        void setScaleAndTranslate(StarryNight.m mVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$ViewCallback;", "", "plugin-festival_release"})
    public interface b {
    }
}

package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f extends com.tencent.mm.ui.m.a {
    public static final a FFA = new a((byte) 0);
    private static final String TAG = TAG;
    private int FEY;
    private int FFt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    private final int FFu = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    private float FFv;
    private float FFw;
    private boolean FFx;
    private final View FFy;
    private final StoryGalleryView.b FFz;
    private float deo;
    private float dep;
    private VelocityTracker ol;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(View view, StoryGalleryView.b bVar) {
        p.h(view, "galleryView");
        p.h(bVar, "galleryScaleListener");
        AppMethodBeat.i(120377);
        this.FFy = view;
        this.FFz = bVar;
        AppMethodBeat.o(120377);
    }

    static {
        AppMethodBeat.i(120378);
        AppMethodBeat.o(120378);
    }

    @Override // com.tencent.mm.ui.m.a
    public final boolean a(MotionEvent motionEvent, boolean z, int i2) {
        float f2;
        float height;
        boolean z2 = true;
        AppMethodBeat.i(120375);
        p.h(motionEvent, "event");
        if (this.ol == null) {
            this.ol = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.ol;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.deo = motionEvent.getRawX();
                this.dep = motionEvent.getRawY();
                break;
            case 1:
                if (this.FFx) {
                    VelocityTracker velocityTracker2 = this.ol;
                    if (velocityTracker2 != null) {
                        velocityTracker2.computeCurrentVelocity(1000);
                    }
                    VelocityTracker velocityTracker3 = this.ol;
                    float xVelocity = velocityTracker3 != null ? velocityTracker3.getXVelocity() : 0.0f;
                    VelocityTracker velocityTracker4 = this.ol;
                    if (velocityTracker4 != null) {
                        f2 = velocityTracker4.getYVelocity();
                    } else {
                        f2 = 0.0f;
                    }
                    if (this.FEY == 2) {
                        if (this.FFw <= ((float) this.FFu) && f2 <= 0.0f) {
                            z2 = false;
                        }
                    } else if (this.FFv <= ((float) (this.FFy.getWidth() / 2)) && xVelocity <= 50.0f) {
                        z2 = false;
                    }
                    if (z2) {
                        h hVar = h.FuH;
                        h.aaT(13);
                        this.FFz.aJl();
                    } else {
                        this.FFy.animate().translationY(0.0f).start();
                    }
                }
                this.FEY = 0;
                this.FFv = 0.0f;
                this.FFw = 0.0f;
                this.FFx = false;
                np();
                break;
            case 2:
                if (z) {
                    this.FEY = i2;
                    if ((i2 != 8 || this.deo >= ((float) this.FFt)) && i2 != 2) {
                        z2 = false;
                    }
                    this.FFx = z2;
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.FFv = rawX - this.deo;
                    this.FFw = rawY - this.dep;
                    if (this.FFx) {
                        this.FFy.animate().cancel();
                        if (this.FEY == 2) {
                            height = this.FFw;
                        } else {
                            height = (this.FFv * ((float) this.FFy.getHeight())) / ((float) this.FFy.getWidth());
                        }
                        if (height < 0.0f) {
                            height = 0.0f;
                        }
                        this.FFy.setTranslationY(height);
                        this.FFz.ca(0.8f - (height / ((float) this.FFy.getHeight())));
                        break;
                    }
                }
                break;
            case 3:
                this.FEY = 0;
                this.FFy.setTranslationY(0.0f);
                this.FFv = 0.0f;
                this.FFw = 0.0f;
                this.FFx = false;
                np();
                break;
        }
        boolean z3 = this.FFx;
        AppMethodBeat.o(120375);
        return z3;
    }

    private final void np() {
        AppMethodBeat.i(120376);
        VelocityTracker velocityTracker = this.ol;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        VelocityTracker velocityTracker2 = this.ol;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
        }
        this.ol = null;
        AppMethodBeat.o(120376);
    }

    @Override // com.tencent.mm.ui.m.a
    public final int fsk() {
        return 10;
    }
}

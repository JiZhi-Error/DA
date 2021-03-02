package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d extends com.tencent.mm.ui.m.a {
    public static final a FEZ = new a((byte) 0);
    private static final String TAG = TAG;
    private int EOU;
    private int FEY;
    StoryGalleryView FwM;
    private float deo;
    private float dep;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120351);
        AppMethodBeat.o(120351);
    }

    @Override // com.tencent.mm.ui.m.a
    public final boolean a(MotionEvent motionEvent, boolean z, int i2) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(120350);
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.deo = motionEvent.getX();
                this.dep = motionEvent.getY();
                break;
            case 1:
                if (this.EOU > 0 && this.FEY == 1) {
                    StoryGalleryView storyGalleryView = this.FwM;
                    if (!(storyGalleryView == null || (animate = storyGalleryView.animate()) == null || (translationY = animate.translationY(0.0f)) == null)) {
                        translationY.start();
                    }
                    this.FEY = 0;
                    Context context = MMApplicationContext.getContext();
                    Object systemService = context.getSystemService("vibrator");
                    if (!(systemService instanceof Vibrator)) {
                        systemService = null;
                    }
                    Vibrator vibrator = (Vibrator) systemService;
                    if (vibrator != null) {
                        vibrator.vibrate(10);
                    }
                    h.cA(context, context.getString(R.string.hhb));
                }
                this.EOU = 0;
                break;
            case 2:
                if (z) {
                    this.FEY = i2;
                    if (i2 != 1) {
                        z2 = false;
                    }
                    float y = motionEvent.getY() - this.dep;
                    if (y > 0.0f) {
                        z3 = z2;
                        break;
                    } else {
                        StoryGalleryView storyGalleryView2 = this.FwM;
                        if (storyGalleryView2 == null) {
                            z3 = z2;
                            break;
                        } else {
                            this.EOU = -((int) y);
                            storyGalleryView2.animate().cancel();
                            storyGalleryView2.setTranslationY(y / 2.0f);
                            z3 = z2;
                            break;
                        }
                    }
                }
                break;
            case 3:
                Log.i(TAG, "LogStory: touch cancel");
                this.FEY = 0;
                StoryGalleryView storyGalleryView3 = this.FwM;
                if (storyGalleryView3 != null) {
                    storyGalleryView3.setTranslationY(0.0f);
                }
                this.EOU = 0;
                break;
        }
        AppMethodBeat.o(120350);
        return z3;
    }

    @Override // com.tencent.mm.ui.m.a
    public final int fsk() {
        return 1;
    }
}

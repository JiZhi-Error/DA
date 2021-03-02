package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e {
    public static final a FFq = new a((byte) 0);
    private static final String TAG = TAG;
    boolean FFj;
    private final c FFk = new c(this);
    private final Runnable FFl;
    private View FFm;
    private final StoryGalleryView FFn;
    private final GalleryRecyclerView FFo;
    private final i FFp;

    public e(StoryGalleryView storyGalleryView, GalleryRecyclerView galleryRecyclerView, i iVar) {
        p.h(storyGalleryView, "gallery");
        p.h(galleryRecyclerView, "recyclerView");
        p.h(iVar, "pageScrollHelper");
        AppMethodBeat.i(120373);
        this.FFn = storyGalleryView;
        this.FFo = galleryRecyclerView;
        this.FFp = iVar;
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "storage()");
        if (aAh.azQ().getBoolean(ar.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, false)) {
            this.FFl = AnonymousClass1.FFr;
            this.FFp.f(this.FFo);
            AppMethodBeat.o(120373);
            return;
        }
        this.FFl = new Runnable(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.e.AnonymousClass2 */
            final /* synthetic */ e FFs;

            {
                this.FFs = r1;
            }

            public final void run() {
                AppMethodBeat.i(120368);
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.FFs.FFn.getContext(), 112);
                View inflate = LayoutInflater.from(this.FFs.FFn.getContext()).inflate(R.layout.c0v, (ViewGroup) this.FFs.FFn, false);
                this.FFs.FFm = inflate;
                View findViewById = inflate.findViewById(R.id.ick);
                p.g(findViewById, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
                ((ImageView) findViewById).setImageDrawable(com.tencent.mm.ui.ar.m(this.FFs.FFn.getContext(), R.raw.close_icon_nor, -1));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, fromDPToPix);
                layoutParams.addRule(12, 1);
                this.FFs.FFn.addView(inflate, layoutParams);
                p.g(inflate, "layout");
                inflate.setAlpha(0.0f);
                inflate.animate().alpha(1.0f).start();
                this.FFs.FFo.smoothScrollBy(0, fromDPToPix);
                this.FFs.FFj = true;
                AppMethodBeat.o(120368);
            }
        };
        MMHandlerThread.postToMainThreadDelayed(this.FFl, 5000);
        this.FFo.a(this.FFk);
        AppMethodBeat.o(120373);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120374);
        AppMethodBeat.o(120374);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ e FFs;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(222925);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(222925);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(e eVar) {
            this.FFs = eVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(120370);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            if (!this.FFs.FFj && i3 > 0) {
                Log.i(e.TAG, "onScrolled ".concat(String.valueOf(i3)));
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "storage()");
                aAh.azQ().set(ar.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
                this.FFs.fsn();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(120370);
        }
    }

    public final void fsn() {
        AppMethodBeat.i(120371);
        d.h(new b(this));
        AppMethodBeat.o(120371);
    }

    public final void destroy() {
        AppMethodBeat.i(120372);
        MMHandlerThread.removeRunnable(this.FFl);
        this.FFn.removeView(this.FFm);
        this.FFo.b(this.FFk);
        AppMethodBeat.o(120372);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e FFs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.FFs = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(120369);
            this.FFs.FFp.f(this.FFs.FFo);
            MMHandlerThread.removeRunnable(this.FFs.FFl);
            this.FFs.FFn.removeView(this.FFs.FFm);
            this.FFs.FFo.b(this.FFs.FFk);
            x xVar = x.SXb;
            AppMethodBeat.o(120369);
            return xVar;
        }
    }
}

package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.story.f.a;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c {
    private static a FlJ = null;
    public static final c FlK = new c();
    private static final String TAG = TAG;
    private static final LinkedList<WeakReference<StoryGalleryView>> gCs = new LinkedList<>();

    static {
        AppMethodBeat.i(118642);
        AppMethodBeat.o(118642);
    }

    private c() {
    }

    public static void a(StoryGalleryView storyGalleryView) {
        T t;
        a aVar;
        AppMethodBeat.i(118640);
        p.h(storyGalleryView, "ui");
        Log.i(TAG, "GalleryMgr register ".concat(String.valueOf(storyGalleryView)));
        Iterator<T> it = gCs.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(storyGalleryView, (StoryGalleryView) next.get())) {
                t = next;
                break;
            }
        }
        if (t == null) {
            gCs.add(new WeakReference<>(storyGalleryView));
        }
        if (gCs.size() <= 0 || (aVar = FlJ) == null) {
            AppMethodBeat.o(118640);
            return;
        }
        Log.i(aVar.TAG, "cancel");
        aVar.DGJ = false;
        AppMethodBeat.o(118640);
    }

    public static void b(StoryGalleryView storyGalleryView) {
        T t;
        AppMethodBeat.i(118641);
        p.h(storyGalleryView, "ui");
        Iterator<T> it = gCs.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(storyGalleryView, (StoryGalleryView) next.get())) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            gCs.remove(t2);
        }
        Log.i(TAG, "GalleryMgr unregister " + storyGalleryView + ' ' + gCs.size());
        if (gCs.size() <= 1) {
            a aVar = new a();
            FlJ = aVar;
            d.b("cleanCacheFiles", new a.b(aVar));
            AppMethodBeat.o(118641);
            return;
        }
        AppMethodBeat.o(118641);
    }
}

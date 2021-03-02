package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class p {
    private static final p xjv = b.dRu();
    public static final a xjw = new a((byte) 0);
    ArrayList<j> xjs;
    final ArrayList<GalleryItem.MediaItem> xjt;
    private c xju;

    public enum c {
        IDLE,
        UP,
        DOWN;

        static {
            AppMethodBeat.i(111791);
            AppMethodBeat.o(111791);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(111793);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(111793);
            return cVar;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private p() {
        AppMethodBeat.i(111797);
        this.xjs = new ArrayList<>();
        this.xjt = new ArrayList<>();
        this.xju = c.IDLE;
        AppMethodBeat.o(111797);
    }

    public /* synthetic */ p(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(111798);
        b bVar = b.xjy;
        AppMethodBeat.o(111798);
    }

    static final class b {
        private static final p xjx = new p((byte) 0);
        public static final b xjy = new b();

        static {
            AppMethodBeat.i(111790);
            AppMethodBeat.o(111790);
        }

        private b() {
        }

        public static p dRu() {
            return xjx;
        }
    }

    public final void a(j jVar) {
        AppMethodBeat.i(111794);
        kotlin.g.b.p.h(jVar, "preload");
        this.xjs.add(jVar);
        AppMethodBeat.o(111794);
    }

    public final void a(c cVar, int i2, int i3, int i4) {
        AppMethodBeat.i(111795);
        kotlin.g.b.p.h(cVar, "state");
        Log.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", cVar, this.xju, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.xju != cVar) {
            this.xju = cVar;
        }
        Iterator<j> it = this.xjs.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (c.IDLE == cVar && next.dRm()) {
                o(next.a(cVar, this.xju, i2, i3, i4));
            }
            if (!next.dRm()) {
                o(next.a(cVar, this.xju, i2, i3, i4));
            }
        }
        AppMethodBeat.o(111795);
    }

    private final void o(Set<Integer> set) {
        AppMethodBeat.i(111796);
        Log.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", Integer.valueOf(this.xjt.size()));
        for (Integer num : set) {
            int intValue = num.intValue();
            if (intValue < this.xjt.size()) {
                c dQJ = e.dQJ();
                GalleryItem.MediaItem mediaItem = this.xjt.get(intValue);
                kotlin.g.b.p.g(mediaItem, "mediaItems[item]");
                String aQn = mediaItem.aQn();
                GalleryItem.MediaItem mediaItem2 = this.xjt.get(intValue);
                kotlin.g.b.p.g(mediaItem2, "mediaItems[item]");
                int type = mediaItem2.getType();
                GalleryItem.MediaItem mediaItem3 = this.xjt.get(intValue);
                kotlin.g.b.p.g(mediaItem3, "mediaItems[item]");
                dQJ.b(aQn, type, mediaItem3.dRh(), this.xjt.get(intValue).xiZ, this.xjt.get(intValue).xja);
            }
        }
        AppMethodBeat.o(111796);
    }

    public final void eU(List<? extends GalleryItem.MediaItem> list) {
        AppMethodBeat.i(257767);
        kotlin.g.b.p.h(list, "mediaItems");
        Log.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", Integer.valueOf(list.size()));
        this.xjt.clear();
        this.xjt.addAll(list);
        AppMethodBeat.o(257767);
    }
}

package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.x;

public final class e {
    private static o wmZ;
    private static b xll = new b();
    private static a xlm = new a();
    private static GalleryItem.AlbumItem xln;
    private static String xlo;
    private static String xlp;
    public static final e xlq = new e();

    static {
        AppMethodBeat.i(164910);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = context.getResources().getString(R.string.dli);
        p.g(string, "MMApplicationContext.get…allery_all_pic_and_video)");
        xlo = string;
        String string2 = MMApplicationContext.getContext().getString(R.string.dlj);
        p.g(string2, "MMApplicationContext.get…string.gallery_all_video)");
        xlp = string2;
        AppMethodBeat.o(164910);
    }

    private e() {
    }

    public static void MC() {
        AppMethodBeat.i(164905);
        o oVar = new o();
        wmZ = oVar;
        oVar.setQueryType(3);
        o oVar2 = wmZ;
        if (oVar2 == null) {
            p.hyc();
        }
        oVar2.a(xll);
        o oVar3 = wmZ;
        if (oVar3 == null) {
            p.hyc();
        }
        oVar3.a(xlm);
        AppMethodBeat.o(164905);
    }

    public static /* synthetic */ void a(e eVar, q qVar) {
        AppMethodBeat.i(257777);
        a(System.currentTimeMillis(), new GalleryItem.AlbumItem(xlo, 0), qVar);
        AppMethodBeat.o(257777);
    }

    public static void a(long j2, GalleryItem.AlbumItem albumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> qVar) {
        boolean z = true;
        AppMethodBeat.i(164906);
        p.h(albumItem, "media");
        p.h(qVar, "callback");
        xll.xlr = qVar;
        xll.joR = j2;
        GalleryItem.AlbumItem albumItem2 = xln;
        if (albumItem2 != null && !(!p.j(albumItem2.albumName, albumItem.albumName))) {
            z = false;
        }
        Log.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + j2 + " isNeed=" + z);
        if (!z) {
            qVar.d(Boolean.FALSE, new LinkedList(), Long.valueOf(System.currentTimeMillis() - j2));
        } else if (p.j(albumItem.albumName, xlo)) {
            o oVar = wmZ;
            if (oVar != null) {
                oVar.D("", 3, j2);
            }
        } else if (p.j(albumItem.albumName, xlp)) {
            o oVar2 = wmZ;
            if (oVar2 != null) {
                oVar2.D("", 2, j2);
            }
        } else {
            o oVar3 = wmZ;
            if (oVar3 != null) {
                String str = albumItem.albumName;
                GalleryItem.MediaItem hVO = albumItem.hVO();
                p.g(hVO, "media.mediaItem");
                oVar3.D(str, hVO.getType(), j2);
            }
        }
        xln = albumItem;
        AppMethodBeat.o(164906);
    }

    public static void onRelease() {
        AppMethodBeat.i(164908);
        xln = null;
        o oVar = wmZ;
        if (oVar != null) {
            oVar.release();
            AppMethodBeat.o(164908);
            return;
        }
        AppMethodBeat.o(164908);
    }

    public static /* synthetic */ void g(m mVar) {
        AppMethodBeat.i(164909);
        long currentTimeMillis = System.currentTimeMillis();
        p.h(mVar, "callback");
        Log.i("MicroMsg.PickerDataLoader", "[onLoadFolder] ticket=".concat(String.valueOf(currentTimeMillis)));
        xlm.gWp = mVar;
        xlm.joR = currentTimeMillis;
        o oVar = wmZ;
        if (oVar != null) {
            oVar.dRr();
            AppMethodBeat.o(164909);
            return;
        }
        AppMethodBeat.o(164909);
    }

    public static final class b implements i.c {
        long joR = System.currentTimeMillis();
        q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> xlr;

        public b() {
            AppMethodBeat.i(164904);
            AppMethodBeat.o(164904);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
            if (r0 == null) goto L_0x002a;
         */
        @Override // com.tencent.mm.plugin.gallery.model.i.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem> r9, long r10, boolean r12) {
            /*
                r8 = this;
                r0 = 0
                r6 = 164903(0x28427, float:2.31078E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                long r2 = java.lang.System.currentTimeMillis()
                long r4 = r8.joR
                long r2 = r2 - r4
                long r4 = r8.joR
                int r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r1 != 0) goto L_0x0044
                r1 = 1
            L_0x0015:
                if (r1 == 0) goto L_0x0046
            L_0x0017:
                if (r9 == 0) goto L_0x002a
                kotlin.g.a.q<? super java.lang.Boolean, ? super java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem>, ? super java.lang.Long, kotlin.x> r1 = r8.xlr
                if (r1 == 0) goto L_0x0028
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                java.lang.Long r4 = java.lang.Long.valueOf(r2)
                r1.d(r0, r9, r4)
                kotlin.x r0 = kotlin.x.SXb
            L_0x0028:
                if (r0 != 0) goto L_0x0040
            L_0x002a:
                com.tencent.mm.plugin.gallery.picker.c.e$b r8 = (com.tencent.mm.plugin.gallery.picker.c.e.b) r8
                kotlin.g.a.q<? super java.lang.Boolean, ? super java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem>, ? super java.lang.Long, kotlin.x> r0 = r8.xlr
                if (r0 == 0) goto L_0x0040
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                java.util.LinkedList r4 = new java.util.LinkedList
                r4.<init>()
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                r0.d(r1, r4, r2)
                kotlin.x r0 = kotlin.x.SXb
            L_0x0040:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x0044:
                r1 = 0
                goto L_0x0015
            L_0x0046:
                r9 = r0
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.c.e.b.b(java.util.LinkedList, long, boolean):void");
        }
    }

    public static final class a implements i.a {
        m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, x> gWp;
        long joR = System.currentTimeMillis();

        public a() {
            AppMethodBeat.i(164902);
            AppMethodBeat.o(164902);
        }

        @Override // com.tencent.mm.plugin.gallery.model.i.a
        public final void aL(LinkedList<GalleryItem.AlbumItem> linkedList) {
            AppMethodBeat.i(164901);
            p.h(linkedList, "albumItems");
            long currentTimeMillis = System.currentTimeMillis() - this.joR;
            e eVar = e.xlq;
            String str = e.xlo;
            Iterator<T> it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 = it.next().dJl + i2;
            }
            GalleryItem.AlbumItem albumItem = new GalleryItem.AlbumItem(str, i2);
            GalleryItem.AlbumItem albumItem2 = (GalleryItem.AlbumItem) j.kt(linkedList);
            albumItem.c(albumItem2 != null ? albumItem2.hVO() : null);
            linkedList.add(0, albumItem);
            m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, x> mVar = this.gWp;
            if (mVar != null) {
                mVar.invoke(linkedList, Long.valueOf(currentTimeMillis));
                AppMethodBeat.o(164901);
                return;
            }
            AppMethodBeat.o(164901);
        }
    }
}

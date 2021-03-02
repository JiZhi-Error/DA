package com.tencent.mm.plugin.gallery.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public final class o {
    public int mcq = 3;
    HashSet<i.a> xjj = new HashSet<>();
    public HashSet<i.a> xjk = new HashSet<>();
    private HashSet<i.c> xjl = new HashSet<>();
    public HashSet<i.b> xjm = new HashSet<>();
    public i xjn;
    public int xjo = 1;

    public o() {
        AppMethodBeat.i(111350);
        AppMethodBeat.o(111350);
    }

    public final void setQueryType(int i2) {
        AppMethodBeat.i(111351);
        this.xjo = i2;
        dRo();
        AppMethodBeat.o(111351);
    }

    private void dRo() {
        AppMethodBeat.i(111352);
        Log.i("MicroMsg.MediaQueryService", "initQueryType: %d", Integer.valueOf(this.xjo));
        switch (this.xjo) {
            case 1:
                this.xjn = new k();
                AppMethodBeat.o(111352);
                return;
            case 2:
                this.xjn = new u();
                AppMethodBeat.o(111352);
                return;
            default:
                this.xjn = new a();
                AppMethodBeat.o(111352);
                return;
        }
    }

    public final void release() {
        AppMethodBeat.i(164768);
        if (this.xjj != null) {
            this.xjj.clear();
        }
        if (this.xjl != null) {
            this.xjl.clear();
        }
        if (this.xjm != null) {
            this.xjm.clear();
        }
        AppMethodBeat.o(164768);
    }

    public final void NG(int i2) {
        this.mcq = i2;
    }

    public final int dRp() {
        return this.mcq;
    }

    public final int dRq() {
        return this.xjo;
    }

    public final void a(i.c cVar) {
        AppMethodBeat.i(111353);
        this.xjl.add(cVar);
        AppMethodBeat.o(111353);
    }

    public final void b(i.c cVar) {
        AppMethodBeat.i(257731);
        this.xjl.remove(cVar);
        AppMethodBeat.o(257731);
    }

    public final void a(i.a aVar) {
        AppMethodBeat.i(111354);
        this.xjj.add(aVar);
        AppMethodBeat.o(111354);
    }

    public final void b(i.a aVar) {
        AppMethodBeat.i(111355);
        this.xjj.remove(aVar);
        AppMethodBeat.o(111355);
    }

    public final void c(i.a aVar) {
        AppMethodBeat.i(173739);
        this.xjk.remove(aVar);
        AppMethodBeat.o(173739);
    }

    public final void dRr() {
        AppMethodBeat.i(111356);
        Log.i("MicroMsg.MediaQueryService", "queryAlbums, %s.", this);
        if (this.xjn == null) {
            Log.f("MicroMsg.MediaQueryService", "media query not init, init again");
            dRo();
        }
        e.dQL().ar(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.model.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111345);
                Log.i("MicroMsg.MediaQueryService", "real run, %s.", this);
                LinkedList<GalleryItem.AlbumItem> dQr = o.this.xjn.dQr();
                o oVar = o.this;
                i.a[] aVarArr = new i.a[oVar.xjj.size()];
                oVar.xjj.toArray(aVarArr);
                for (i.a aVar : aVarArr) {
                    aVar.aL(dQr);
                }
                s dRv = s.dRv();
                ArrayList arrayList = new ArrayList();
                Cursor query = dRv.hwt.query(s.BASE_URI.buildUpon().appendEncodedPath("private").build(), s.dRw(), null, null, null);
                if (query != null) {
                    int columnIndex = query.getColumnIndex("categoryID");
                    int columnIndex2 = query.getColumnIndex("categoryName");
                    int columnIndex3 = query.getColumnIndex("albumID");
                    int columnIndex4 = query.getColumnIndex("albumName");
                    int columnIndex5 = query.getColumnIndex("albumCapacity");
                    int columnIndex6 = query.getColumnIndex("coverID");
                    int columnIndex7 = query.getColumnIndex("coverData");
                    int columnIndex8 = query.getColumnIndex("albumTag");
                    while (query.moveToNext()) {
                        s.a aVar2 = new s.a();
                        if (!(columnIndex == -1 || columnIndex2 == -1)) {
                            aVar2.hD(query.getString(columnIndex), query.getString(columnIndex2));
                        }
                        aVar2.xjJ = query.getString(columnIndex3);
                        aVar2.albumName = query.getString(columnIndex4);
                        aVar2.xjK = Util.safeParseInt(query.getString(columnIndex5));
                        aVar2.xjL = Util.safeParseLong(query.getString(columnIndex6));
                        aVar2.xjM = query.getString(columnIndex7);
                        if (columnIndex8 != -1) {
                            String string = query.getString(columnIndex8);
                            if (!Util.isNullOrNil(string)) {
                                aVar2.xjN = s.hC(string, aVar2.xjJ);
                            }
                        }
                        arrayList.add(aVar2);
                    }
                    query.close();
                }
                o.a(o.this, s.ap(arrayList));
                AppMethodBeat.o(111345);
            }

            public final String toString() {
                AppMethodBeat.i(111346);
                String str = super.toString() + "|queryAlbums";
                AppMethodBeat.o(111346);
                return str;
            }
        });
        AppMethodBeat.o(111356);
    }

    public final void ax(String str, long j2) {
        AppMethodBeat.i(111357);
        D(str, this.xjo, j2);
        AppMethodBeat.o(111357);
    }

    public final void dRs() {
        AppMethodBeat.i(173740);
        if (this.xjn != null) {
            this.xjn.dQx();
        }
        AppMethodBeat.o(173740);
    }

    public final void D(final String str, final int i2, final long j2) {
        AppMethodBeat.i(111358);
        if (this.xjn == null) {
            Log.e("MicroMsg.MediaQueryService", "media query not init, init again");
            dRo();
        }
        Log.i("MicroMsg.MediaQueryService", "queryMediaInAlbums, albumName: %s ticket: %d, stack: %s.", str, Long.valueOf(j2), Util.getStack().toString());
        this.xjn.dQx();
        e.dQL().as(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.model.o.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(111348);
                try {
                    Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
                    o.this.xjn.a(str, i2, new i.c() {
                        /* class com.tencent.mm.plugin.gallery.model.o.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.gallery.model.i.c
                        public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
                            AppMethodBeat.i(111347);
                            Log.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum callback, size: %d.", Integer.valueOf(linkedList.size()));
                            o.a(o.this, linkedList, j2, z);
                            AppMethodBeat.o(111347);
                        }
                    }, j2);
                    AppMethodBeat.o(111348);
                } catch (SecurityException e2) {
                    Log.printErrStackTrace("MicroMsg.MediaQueryService", e2, "", new Object[0]);
                    o.a(o.this, new LinkedList(), j2, false);
                    AppMethodBeat.o(111348);
                }
            }

            public final String toString() {
                AppMethodBeat.i(111349);
                String str = super.toString() + "|queryMediaInAlbums";
                AppMethodBeat.o(111349);
                return str;
            }
        });
        AppMethodBeat.o(111358);
    }

    static /* synthetic */ void a(o oVar, LinkedList linkedList) {
        AppMethodBeat.i(173741);
        i.a[] aVarArr = new i.a[oVar.xjk.size()];
        oVar.xjk.toArray(aVarArr);
        for (i.a aVar : aVarArr) {
            aVar.aL(linkedList);
        }
        AppMethodBeat.o(173741);
    }

    static /* synthetic */ void a(o oVar, LinkedList linkedList, long j2, boolean z) {
        AppMethodBeat.i(173742);
        i.b[] bVarArr = new i.b[oVar.xjm.size()];
        oVar.xjm.toArray(bVarArr);
        for (i.b bVar : bVarArr) {
            bVar.c(linkedList, j2);
        }
        i.c[] cVarArr = new i.c[oVar.xjl.size()];
        oVar.xjl.toArray(cVarArr);
        for (i.c cVar : cVarArr) {
            cVar.b(linkedList, j2, z);
        }
        AppMethodBeat.o(173742);
    }
}

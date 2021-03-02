package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends b implements Comparator<GalleryItem.MediaItem> {
    protected final ContentResolver bEK = MMApplicationContext.getContext().getContentResolver();
    private final k xhG = new k();
    private final u xhH = new u();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(GalleryItem.MediaItem mediaItem, GalleryItem.MediaItem mediaItem2) {
        AppMethodBeat.i(111234);
        int compare = Long.compare(mediaItem.xja, mediaItem2.xja);
        AppMethodBeat.o(111234);
        return compare;
    }

    public a() {
        AppMethodBeat.i(111230);
        AppMethodBeat.o(111230);
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String pw(boolean z) {
        AppMethodBeat.i(111231);
        if (z) {
            String str = b.xhL + " desc, bucket_display_name desc, _id desc";
            AppMethodBeat.o(111231);
            return str;
        }
        String str2 = b.xhK + " desc, bucket_display_name desc, _id desc";
        AppMethodBeat.o(111231);
        return str2;
    }

    @Override // com.tencent.mm.plugin.gallery.model.i
    public final LinkedList<GalleryItem.AlbumItem> dQr() {
        Cursor cursor;
        GalleryItem.AlbumItem albumItem;
        GalleryItem.AlbumItem albumItem2;
        Cursor cursor2 = null;
        AppMethodBeat.i(111232);
        if (d.dSB()) {
            LinkedList<GalleryItem.AlbumItem> dQs = dQs();
            AppMethodBeat.o(111232);
            return dQs;
        }
        HashMap hashMap = new HashMap();
        LinkedList<GalleryItem.AlbumItem> linkedList = new LinkedList<>();
        try {
            cursor = this.bEK.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.xhH.dQt(), this.xhH.dQu(), null, this.xhH.dQv());
        } catch (Exception e2) {
            Log.e("MicroMsg.AllMediaQuery", "query video album list failed : [%s]", e2.getMessage());
            cursor = null;
        }
        if (cursor == null) {
            Log.d("MicroMsg.AllMediaQuery", "no video folder now");
            albumItem2 = null;
        } else {
            if (cursor.moveToFirst()) {
                GalleryItem.MediaItem mediaItem = null;
                int i2 = 0;
                do {
                    GalleryItem.AlbumItem a2 = a(cursor, 2, "bucket_display_name");
                    if (a2 != null) {
                        if (!a2.UXf) {
                            i2 += a2.dJl;
                        }
                        hashMap.put(a2.UXb, a2);
                        if (mediaItem == null) {
                            mediaItem = a2.UXc;
                        }
                    }
                } while (cursor.moveToNext());
                GalleryItem.AlbumItem albumItem3 = new GalleryItem.AlbumItem(MMApplicationContext.getContext().getString(R.string.dlj), i2);
                albumItem3.UXe = true;
                albumItem3.UXc = mediaItem;
                albumItem = albumItem3;
            } else {
                albumItem = null;
            }
            cursor.close();
            albumItem2 = albumItem;
        }
        try {
            cursor2 = this.bEK.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.xhG.dQt(), this.xhG.dQu(), null, this.xhG.dQv());
        } catch (Exception e3) {
            Log.e("MicroMsg.AllMediaQuery", "query image album list failed : [%s]", e3.getMessage());
        }
        if (cursor2 == null) {
            Log.d("MicroMsg.AllMediaQuery", "no image folder now");
        } else {
            if (cursor2.moveToFirst()) {
                do {
                    GalleryItem.AlbumItem a3 = a(cursor2, 1, "bucket_display_name");
                    if (a3 != null) {
                        GalleryItem.AlbumItem albumItem4 = (GalleryItem.AlbumItem) hashMap.get(a3.UXb);
                        if (albumItem4 != null) {
                            a3.dJl = albumItem4.dJl + a3.dJl;
                            hashMap.remove(a3.UXb);
                        }
                        linkedList.add(a3);
                    }
                } while (cursor2.moveToNext());
            }
            cursor2.close();
        }
        if (!hashMap.isEmpty()) {
            linkedList.addAll(hashMap.values());
            Collections.sort(linkedList);
        }
        aK(linkedList);
        if (albumItem2 != null) {
            linkedList.add(1, albumItem2);
        }
        AppMethodBeat.o(111232);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x014d A[LOOP:0: B:24:0x009d->B:59:0x014d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c4 A[EDGE_INSN: B:61:0x00c4->B:33:0x00c4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem> dQs() {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.a.dQs():java.util.LinkedList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x030b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0310, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0315, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x031a, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x032a, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x032b, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x033a, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x033f, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0344, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0349, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x034d, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x034e, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0375, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x037a, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x037b, code lost:
        r5 = null;
        r6 = null;
        r7 = null;
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0381, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0382, code lost:
        r5 = null;
        r6 = null;
        r7 = r14;
        r8 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x032a A[ExcHandler: NullPointerException (e java.lang.NullPointerException), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x034d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0375 A[ExcHandler: NullPointerException (e java.lang.NullPointerException), Splitter:B:17:0x0088] */
    @Override // com.tencent.mm.plugin.gallery.model.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem> a(java.lang.String r23, int r24, com.tencent.mm.plugin.gallery.model.i.c r25, long r26) {
        /*
        // Method dump skipped, instructions count: 935
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.a.a(java.lang.String, int, com.tencent.mm.plugin.gallery.model.i$c, long):java.util.LinkedList");
    }
}

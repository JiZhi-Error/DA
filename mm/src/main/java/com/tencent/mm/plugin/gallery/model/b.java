package com.tencent.mm.plugin.gallery.model;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b implements i {
    public static String xhK = "date_modified";
    public static String xhL = "datetaken";
    volatile boolean ifz = false;
    protected int xhI = 100;
    protected String[] xhJ = {"camera", "screenshots", "download"};
    private boolean xhM = false;

    public String[] getProjection() {
        return new String[0];
    }

    public String bF(String str, boolean z) {
        return null;
    }

    public String pw(boolean z) {
        return null;
    }

    public String[] dQt() {
        return new String[0];
    }

    public String dQu() {
        return null;
    }

    public String b(String[] strArr, boolean z) {
        return null;
    }

    public String dQv() {
        return null;
    }

    protected static GalleryItem.MediaItem b(Cursor cursor, int i2) {
        if (cursor == null || cursor.isAfterLast() || cursor.isClosed()) {
            return null;
        }
        while (!cursor.isAfterLast()) {
            try {
                if (cursor.getColumnIndexOrThrow("_id") >= 0) {
                    long safeParseLong = Util.safeParseLong(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow(xhK));
                    String string3 = cursor.getString(cursor.getColumnIndexOrThrow(xhL));
                    GalleryItem.MediaItem ap = GalleryItem.MediaItem.ap(i2, safeParseLong);
                    ap.xiW = string;
                    a(string2, string3, i2, ap);
                    if (d.KyP) {
                        Log.v("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + safeParseLong + " " + string2 + " " + string3 + "] | " + ap.xja + " " + i2);
                    } else {
                        Log.d("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + safeParseLong + " " + string2 + " " + string3 + "] | " + ap.xja + " " + i2);
                    }
                    if (!Util.isNullOrNil(ap.xiW) || !Util.isNullOrNil(ap.sUB)) {
                        String string4 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                        if (Util.isNullOrNil(string4)) {
                            string4 = "";
                        }
                        ap.mMimeType = string4;
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("latitude");
                        if (cursor.getType(columnIndexOrThrow) != 0) {
                            double d2 = cursor.getDouble(columnIndexOrThrow);
                            if (a.n(d2)) {
                                ap.cik = d2;
                            }
                        }
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("longitude");
                        if (cursor.getType(columnIndexOrThrow2) == 0) {
                            return ap;
                        }
                        double d3 = cursor.getDouble(columnIndexOrThrow2);
                        if (!a.m(d3)) {
                            return ap;
                        }
                        ap.cil = d3;
                        return ap;
                    }
                    Log.w("MicroMsg.BaseMediaQuery", "thumb file and original file both not exist");
                    cursor.moveToNext();
                }
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.BaseMediaQuery", th, "", new Object[0]);
                return null;
            }
        }
        return null;
    }

    private static void a(String str, String str2, int i2, GalleryItem.MediaItem mediaItem) {
        boolean z;
        long j2;
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 == 1) {
            z = true;
        } else {
            z = false;
        }
        long a2 = a(str, currentTimeMillis, z, true);
        if (i2 != 1) {
            z2 = false;
        }
        long a3 = a(str2, currentTimeMillis, z2, false);
        if (a2 > 0) {
            j2 = a2;
        } else {
            j2 = a3;
        }
        mediaItem.xja = j2;
        mediaItem.xjb = a3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.lang.String r15, long r16, boolean r18, boolean r19) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.b.a(java.lang.String, long, boolean, boolean):long");
    }

    protected static GalleryItem.AlbumItem a(Cursor cursor, int i2, String str) {
        int i3;
        try {
            long safeParseLong = Util.safeParseLong(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(str));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow(xhK));
            String string4 = cursor.getString(cursor.getColumnIndexOrThrow(xhL));
            if (Util.isNullOrNil(string2)) {
                Log.e("MicroMsg.BaseMediaQuery", "null or nil album name, ignore this folder");
                return null;
            }
            if (com.tencent.mm.plugin.gallery.a.d.dSB()) {
                i3 = 0;
            } else {
                i3 = cursor.getInt(3);
                if (i3 == 0 || Util.isNullOrNil(string)) {
                    Log.e("MicroMsg.BaseMediaQuery", "query album failed, " + i3 + ", " + string);
                    return null;
                }
            }
            Log.i("MicroMsg.BaseMediaQuery", "%s(%s) path:%s", string2, Integer.valueOf(i3), string);
            if (Util.isNullOrNil(string)) {
                string = null;
            }
            GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(i2, safeParseLong, string, null, cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
            a(string3, string4, i2, a2);
            GalleryItem.AlbumItem albumItem = new GalleryItem.AlbumItem(string2, i3);
            albumItem.UXc = a2;
            albumItem.UXb = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
            if (!Util.isNullOrNil(albumItem.UXb)) {
                int safeParseInt = Util.safeParseInt(albumItem.UXb);
                if (com.tencent.mm.plugin.gallery.a.d.xsC == safeParseInt) {
                    albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dlg);
                } else if (com.tencent.mm.plugin.gallery.a.d.xsD == safeParseInt) {
                    albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dlb);
                } else if (com.tencent.mm.plugin.gallery.a.d.xsE == safeParseInt) {
                    albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dlc);
                } else if (com.tencent.mm.plugin.gallery.a.d.xsF.contains(Integer.valueOf(safeParseInt))) {
                    albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dld);
                } else if (com.tencent.mm.plugin.gallery.a.d.xsG.contains(Integer.valueOf(safeParseInt))) {
                    albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dle);
                }
                GalleryItem.a aVar = e.dQH().get(safeParseInt);
                if (aVar != null) {
                    if (aVar.key.toLowerCase().equals("WeChatWork")) {
                        albumItem.nickName = MMApplicationContext.getContext().getString(R.string.dlf);
                    } else {
                        albumItem.nickName = aVar.xiU;
                    }
                }
            }
            albumItem.xiP = 0;
            albumItem.UXf = com.tencent.mm.plugin.gallery.a.d.dSB();
            return albumItem;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.BaseMediaQuery", th, "#albumConvertFrom failed", new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.gallery.model.i
    public final void dQw() {
        this.xhM = true;
        this.xhI = 1000;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(i.c cVar, LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
        if (!this.xhM) {
            if (z) {
                this.xhI = 200;
            } else {
                this.xhI = 5000;
            }
        }
        if (cVar == null || linkedList.size() % this.xhI != 0) {
            return false;
        }
        Log.d("MicroMsg.BaseMediaQuery", "page notify, notifyCount: %d.", Integer.valueOf(this.xhI));
        cVar.b(linkedList, j2, z);
        return true;
    }

    @Override // com.tencent.mm.plugin.gallery.model.i
    public final void dQx() {
        this.ifz = true;
    }

    @Override // com.tencent.mm.plugin.gallery.model.i
    public final boolean isCancelled() {
        return this.ifz;
    }

    static void aK(LinkedList<GalleryItem.AlbumItem> linkedList) {
        GalleryItem.MediaItem mediaItem;
        GalleryItem.MediaItem mediaItem2 = null;
        Iterator<GalleryItem.AlbumItem> it = linkedList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            GalleryItem.AlbumItem next = it.next();
            if (!next.UXf) {
                i2 += next.dJl;
            }
            if (mediaItem2 == null) {
                mediaItem = next.UXc;
            } else {
                mediaItem = mediaItem2;
            }
            mediaItem2 = mediaItem;
        }
        GalleryItem.AlbumItem albumItem = new GalleryItem.AlbumItem("", i2);
        albumItem.UXd = true;
        if (mediaItem2 != null) {
            albumItem.UXc = mediaItem2;
        } else {
            albumItem.UXc = new GalleryItem.ImageMediaItem();
        }
        linkedList.add(0, albumItem);
    }
}

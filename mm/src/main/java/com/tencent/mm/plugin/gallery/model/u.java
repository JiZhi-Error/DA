package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class u extends b {
    protected final ContentResolver bEK = MMApplicationContext.getContext().getContentResolver();

    public u() {
        AppMethodBeat.i(111380);
        AppMethodBeat.o(111380);
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String[] getProjection() {
        return new String[]{"_id", "_data", b.xhL, b.xhK, "mime_type", "latitude", "longitude"};
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String bF(String str, boolean z) {
        String str2;
        AppMethodBeat.i(111381);
        StringBuilder append = new StringBuilder("bucket_display_name='").append(str).append("' AND ");
        if (z) {
            str2 = "(" + b.xhK + ">2147483647 OR " + b.xhK + "<=0 )";
        } else {
            str2 = b.xhK + "<=2147483647 AND " + b.xhK + ">0";
        }
        String sb = append.append(str2).toString();
        AppMethodBeat.o(111381);
        return sb;
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String b(String[] strArr, boolean z) {
        String str;
        AppMethodBeat.i(111382);
        if (z) {
            String str2 = "(" + b.xhK + ">2147483647 OR " + b.xhK + "<=0 ) AND (_size>10240";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                str2 = str2 + " or lower(_data) like '%" + strArr[i2] + "%'";
            }
            str = str2 + ")";
        } else {
            String str3 = b.xhK + "<=2147483647 AND " + b.xhK + ">0 AND (_size>10240";
            for (int i3 = 0; i3 < strArr.length; i3++) {
                str3 = str3 + " or lower(_data) like '%" + strArr[i3] + "%'";
            }
            str = str3 + ")";
        }
        Log.d("MicroMsg.ImageMediaQuery", "where %s", str);
        AppMethodBeat.o(111382);
        return str;
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String pw(boolean z) {
        AppMethodBeat.i(111383);
        if (z) {
            String str = b.xhL + " desc, bucket_display_name desc, _id desc";
            AppMethodBeat.o(111383);
            return str;
        }
        String str2 = b.xhK + " desc, bucket_display_name desc, _id desc";
        AppMethodBeat.o(111383);
        return str2;
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String[] dQt() {
        AppMethodBeat.i(111384);
        if (d.dSB()) {
            String[] strArr = {"_id", "_data", "bucket_display_name", b.xhL, b.xhK, "mime_type", "bucket_id"};
            AppMethodBeat.o(111384);
            return strArr;
        }
        String[] strArr2 = {"_id", "_data", "bucket_display_name", "count(*)", b.xhL, b.xhK, "mime_type", "max(" + b.xhK + ") as max_time", "bucket_id"};
        AppMethodBeat.o(111384);
        return strArr2;
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String dQu() {
        AppMethodBeat.i(257732);
        if (d.dSB()) {
            AppMethodBeat.o(257732);
            return null;
        }
        AppMethodBeat.o(257732);
        return "0==0) GROUP BY (bucket_display_name";
    }

    @Override // com.tencent.mm.plugin.gallery.model.b
    public final String dQv() {
        AppMethodBeat.i(257733);
        if (d.dSB()) {
            AppMethodBeat.o(257733);
            return "_id desc";
        }
        AppMethodBeat.o(257733);
        return "max_time desc, _id desc";
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    @Override // com.tencent.mm.plugin.gallery.model.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem> dQr() {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.u.dQr():java.util.LinkedList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013a  */
    @Override // com.tencent.mm.plugin.gallery.model.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.LinkedList<com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem> a(java.lang.String r17, int r18, com.tencent.mm.plugin.gallery.model.i.c r19, long r20) {
        /*
        // Method dump skipped, instructions count: 559
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.u.a(java.lang.String, int, com.tencent.mm.plugin.gallery.model.i$c, long):java.util.LinkedList");
    }
}

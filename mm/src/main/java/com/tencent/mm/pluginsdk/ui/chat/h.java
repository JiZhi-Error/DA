package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public final class h {
    private ContentResolver hwt = this.mContext.getContentResolver();
    protected Context mContext;

    public interface a {
        int getYFromBottom();

        boolean gqT();
    }

    protected h(Context context) {
        AppMethodBeat.i(31743);
        this.mContext = context;
        AppMethodBeat.o(31743);
    }

    private String bfa(String str) {
        String str2;
        AppMethodBeat.i(31744);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            AppMethodBeat.o(31744);
            return null;
        }
        try {
            Cursor query = this.hwt.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(str)));
                AppMethodBeat.o(31744);
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                str2 = null;
            }
            query.close();
            AppMethodBeat.o(31744);
            return str2;
        } catch (Exception e2) {
            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", e2.toString());
            AppMethodBeat.o(31744);
            return null;
        }
    }

    public final ArrayList<g> grw() {
        AppMethodBeat.i(31745);
        ArrayList<g> arrayList = new ArrayList<>();
        String[] strArr = {"_id", "_data", "date_added"};
        Cursor cursor = null;
        long nowMilliSecond = Util.nowMilliSecond() / 1000;
        try {
            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query excludeImageWithFeatureDate");
            Cursor query = this.hwt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "date_added <= ?", new String[]{String.valueOf(nowMilliSecond)}, "date_added desc limit 1");
            if (query == null) {
                AppMethodBeat.o(31745);
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String bfa = bfa(string);
                    if (Util.isNullOrNil(string2) || !s.YS(string2)) {
                        Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(b.aKV())) {
                        Log.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        g gVar = new g();
                        gVar.xjE = Util.getLong(string, 0);
                        gVar.Knf = Util.getLong(string3, 0);
                        if (!Util.isNullOrNil(bfa) && s.YS(bfa)) {
                            gVar.thumbPath = bfa;
                        }
                        if (!Util.isNullOrNil(string2) && s.YS(string2)) {
                            gVar.Kne = string2;
                        }
                        if (!Util.isNullOrNil(gVar.Kne) || !Util.isNullOrNil(gVar.Kne)) {
                            arrayList.add(gVar);
                        } else {
                            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            AppMethodBeat.o(31745);
            return arrayList;
        } catch (Exception e2) {
            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(31745);
            return null;
        }
    }
}

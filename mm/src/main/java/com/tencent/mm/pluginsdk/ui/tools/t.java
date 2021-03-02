package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class t {
    public Context context;
    public String filePath;
    public int fileType = 0;
    public Uri uri;

    public t(Context context2, Uri uri2) {
        String str;
        String str2 = null;
        AppMethodBeat.i(152425);
        this.context = context2;
        this.uri = uri2;
        if (uri2 == null) {
            Log.e("MicroMsg.UriFileHelper", "initFileTypeAndPath uri == null");
            AppMethodBeat.o(152425);
        } else if (this.context == null) {
            Log.e("MicroMsg.UriFileHelper", "initFileTypeAndPath context == null");
            AppMethodBeat.o(152425);
        } else {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String type = this.context.getContentResolver().getType(uri2);
            if (type == null || type.length() <= 0) {
                if (uri2.getPath() != null) {
                    o oVar = new o(uri2.getPath());
                    if (!oVar.exists()) {
                        Log.e("MicroMsg.UriFileHelper", "File is null");
                        this.fileType = 0;
                        AppMethodBeat.o(152425);
                        return;
                    }
                    this.filePath = aa.z(oVar.her());
                    int lastIndexOf = this.filePath.lastIndexOf(".");
                    if (lastIndexOf == -1 || lastIndexOf >= this.filePath.length() - 1) {
                        this.fileType = 1;
                        str = type;
                    } else {
                        str = singleton.getMimeTypeFromExtension(this.filePath.substring(lastIndexOf + 1));
                    }
                }
                str = type;
            } else {
                if (this.context == null) {
                    Log.e("MicroMsg.UriFileHelper", "getFilePath context == null");
                } else {
                    Cursor query = this.context.getContentResolver().query(uri2, null, null, null, null);
                    if (query == null) {
                        Log.e("MicroMsg.UriFileHelper", "getFilePath : fail, cursor is null");
                    } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                        query.close();
                        Log.e("MicroMsg.UriFileHelper", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                    } else {
                        int columnIndex = query.getColumnIndex("_data");
                        if (columnIndex == -1) {
                            query.close();
                            Log.e("MicroMsg.UriFileHelper", "getFilePath : columnIdx is -1, column with columnName = _data does not exist");
                        } else {
                            str2 = query.getString(columnIndex);
                            query.close();
                        }
                    }
                }
                this.filePath = str2;
                str = type;
            }
            if (str == null || this.filePath == null) {
                this.fileType = 0;
                AppMethodBeat.o(152425);
                return;
            }
            if (str.contains("image")) {
                this.fileType = 3;
            } else if (str.contains("video")) {
                this.fileType = 4;
            } else if (str.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                this.fileType = 5;
            } else if (str.contains("mm_item")) {
                this.fileType = 2;
            } else {
                this.fileType = 1;
            }
            Log.d("MicroMsg.UriFileHelper", "MimeType[%s], filePath = [%s], fileType = [%s], type = [%s], Uri[%s]", str, this.filePath, Integer.valueOf(this.fileType), str, uri2.toString());
            AppMethodBeat.o(152425);
        }
    }
}

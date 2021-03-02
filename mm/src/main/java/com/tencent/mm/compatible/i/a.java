package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {

    /* renamed from: com.tencent.mm.compatible.i.a$a  reason: collision with other inner class name */
    public static class C0304a {
        public Bitmap bitmap = null;
        public int duration = 0;
        public String filename = null;
    }

    @TargetApi(5)
    public static String i(Context context, Intent intent) {
        String str;
        Uri uri;
        String str2;
        Cursor cursor;
        String str3;
        AppMethodBeat.i(155916);
        if (intent == null || intent.getData() == null) {
            Log.e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.o(155916);
            return null;
        }
        long currentTicks = Util.currentTicks();
        String dataString = intent.getDataString();
        Log.i("MicroMsg.GetVideoMetadata", "get video file name, dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            Log.e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.o(155916);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (dataString.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            Cursor query = contentResolver.query(intent.getData(), null, null, null, null);
            str2 = null;
            cursor = query;
        } else {
            if (dataString.startsWith("content://")) {
                str = Util.getFilePath(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() == null || (uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM")) == null || Util.isNullOrNil(uri.getPath())) {
                    str = null;
                } else {
                    str = uri.getPath();
                }
                if (str == null) {
                    str = dataString.substring(7);
                }
            } else {
                str = null;
            }
            if (str != null) {
                if (str.startsWith("/storage/emulated/legacy")) {
                    str3 = g.getExternalStorageDirectory().getAbsolutePath() + str.substring(24);
                } else {
                    str3 = str.startsWith("/sdcard") ? g.getExternalStorageDirectory().getAbsolutePath() + str.substring(7) : str;
                }
                Cursor query2 = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(str3), null, null);
                str2 = str3;
                cursor = query2;
            } else {
                str2 = str;
                cursor = null;
            }
        }
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (str2 == null) {
                    str2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
            }
            cursor.close();
        }
        Log.i("MicroMsg.GetVideoMetadata", "get video filename:" + str2 + ", cost time: " + Util.ticksToNow(currentTicks));
        if (TextUtils.isEmpty(str2) || !new o(str2).exists()) {
            String g2 = g(context, intent.getData());
            AppMethodBeat.o(155916);
            return g2;
        }
        AppMethodBeat.o(155916);
        return str2;
    }

    @TargetApi(5)
    public static C0304a j(Context context, Intent intent) {
        Uri uri;
        Cursor cursor;
        AppMethodBeat.i(155917);
        if (intent == null || intent.getData() == null) {
            Log.e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.o(155917);
            return null;
        }
        long currentTicks = Util.currentTicks();
        String dataString = intent.getDataString();
        Log.i("MicroMsg.GetVideoMetadata", "dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            Log.e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.o(155917);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        C0304a aVar = new C0304a();
        if (dataString.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            cursor = contentResolver.query(intent.getData(), null, null, null, null);
        } else {
            if (dataString.startsWith("content://")) {
                aVar.filename = Util.getFilePath(context, intent.getData());
                if (TextUtils.isEmpty(aVar.filename)) {
                    aVar.filename = g(context, intent.getData());
                }
            } else if (dataString.startsWith("file://")) {
                if (!(intent.getExtras() == null || (uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM")) == null || Util.isNullOrNil(uri.getPath()))) {
                    aVar.filename = uri.getPath();
                }
                if (aVar.filename == null) {
                    aVar.filename = dataString.substring(7);
                }
            }
            if (aVar.filename != null) {
                if (aVar.filename.startsWith("/storage/emulated/legacy")) {
                    aVar.filename = g.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(24);
                } else if (aVar.filename.startsWith("/sdcard")) {
                    aVar.filename = g.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(7);
                }
                cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(aVar.filename), null, null);
            } else {
                cursor = null;
            }
        }
        int i2 = Integer.MAX_VALUE;
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                i2 = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                if (aVar.filename == null) {
                    aVar.filename = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
                aVar.duration = cursor.getInt(cursor.getColumnIndexOrThrow(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                if (aVar.duration == 0) {
                    MediaPlayer mediaPlayer = null;
                    try {
                        Log.i("MicroMsg.GetVideoMetadata", "get video duration through MediaPlayer");
                        k f2 = k.f(context, Uri.parse(aVar.filename));
                        aVar.duration = f2 != null ? f2.getDuration() : 0;
                        if (f2 != null) {
                            f2.release();
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e2, "get duration error, %s", aVar.filename);
                        if (0 != 0) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(155917);
                        throw th;
                    }
                }
                aVar.bitmap = null;
            }
            cursor.close();
        }
        if (i2 != Integer.MAX_VALUE) {
            try {
                aVar.bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, (long) i2, 1, null);
                Log.i("MicroMsg.GetVideoMetadata", "get video thumb from mediaId");
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e3, "", new Object[0]);
                aVar.bitmap = null;
            }
        }
        if (!Util.isNullOrNil(aVar.filename) && aVar.bitmap == null) {
            Log.i("MicroMsg.GetVideoMetadata", "createVideoThumbnail manual");
            aVar.bitmap = Ei(aVar.filename);
            if (aVar.bitmap == null || v(aVar.bitmap)) {
                aVar.bitmap = BitmapUtil.createVideoThumbnail(aVar.filename, 1);
            }
            if (aVar.bitmap == null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + aVar.bitmap)));
            }
        }
        Log.i("MicroMsg.GetVideoMetadata", "get video meta data cost time: %d meta[%s, %d]", Long.valueOf(Util.ticksToNow(currentTicks)), aVar.filename, Integer.valueOf(aVar.duration));
        if (aVar.filename != null) {
            AppMethodBeat.o(155917);
            return aVar;
        }
        AppMethodBeat.o(155917);
        return null;
    }

    private static Bitmap Ei(String str) {
        AppMethodBeat.i(155918);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            Log.e("MicroMsg.GetVideoMetadata", "getVideoThumb, %s not exist!!", str);
            AppMethodBeat.o(155918);
            return null;
        }
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.GetVideoMetadata", "getVideoThumb, %s", str);
        try {
            d dVar = new d();
            dVar.setDataSource(str);
            int i2 = Util.getInt(dVar.extractMetadata(18), -1);
            int i3 = Util.getInt(dVar.extractMetadata(19), -1);
            Bitmap frameAtTime = dVar.getFrameAtTime(0, 2);
            dVar.release();
            Log.i("MicroMsg.GetVideoMetadata", "getVideoThumb, width: %s, height: %s, cost:%s", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(Util.ticksToNow(currentTicks)));
            if (frameAtTime != null) {
                AppMethodBeat.o(155918);
                return frameAtTime;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e2, "get video thumb error! %s", e2.getMessage());
        }
        AppMethodBeat.o(155918);
        return null;
    }

    private static boolean v(Bitmap bitmap) {
        AppMethodBeat.i(155919);
        if (bitmap != null) {
            long currentTicks = Util.currentTicks();
            int[] iArr = new int[400];
            Bitmap.createScaledBitmap(bitmap, 20, 20, true).getPixels(iArr, 0, 20, 0, 0, 20, 20);
            long j2 = 0;
            for (int i2 = 0; i2 < 400; i2++) {
                j2 += (long) Color.blue(iArr[i2]);
            }
            long j3 = (long) (((float) j2) / 400.0f);
            Log.i("MicroMsg.GetVideoMetadata", "isBitmapDark, avg bitmap avgColor:%s, cost:%s", Long.valueOf(j3), Long.valueOf(Util.ticksToNow(currentTicks)));
            if (j3 <= 10) {
                AppMethodBeat.o(155919);
                return true;
            }
            AppMethodBeat.o(155919);
            return false;
        }
        AppMethodBeat.o(155919);
        return false;
    }

    private static String g(Context context, Uri uri) {
        InputStream inputStream;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(155920);
        if (uri == null) {
            AppMethodBeat.o(155920);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String type = contentResolver.getType(uri);
        Log.i("MicroMsg.GetVideoMetadata", "copyFileFromUri typeStr:".concat(String.valueOf(type)));
        if (TextUtils.isEmpty(type)) {
            AppMethodBeat.o(155920);
            return null;
        }
        String[] split = type.split(FilePathGenerator.ANDROID_DIR_SEP);
        String str = "." + split[1];
        String str2 = "share_file_" + uri.getHost().replaceAll("\\.", "_") + "_" + split[0] + "_" + uri.getPath().replaceAll(FilePathGenerator.ANDROID_DIR_SEP, "_");
        if (!str2.endsWith(str)) {
            str2 = str2 + str;
        }
        Log.i("MicroMsg.GetVideoMetadata", "copyFileFromUri path:".concat(String.valueOf(str2)));
        o oVar = new o(b.aLn(), str2);
        if (!oVar.heq().exists()) {
            oVar.heq().mkdirs();
        }
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            oVar.createNewFile();
            outputStream = s.ap(oVar);
            try {
                inputStream = contentResolver.openInputStream(uri);
                if (inputStream == null) {
                    Util.qualityClose(inputStream);
                    Util.qualityClose(outputStream);
                    AppMethodBeat.o(155920);
                    return null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            String z = aa.z(oVar.her());
                            Util.qualityClose(inputStream);
                            Util.qualityClose(outputStream);
                            AppMethodBeat.o(155920);
                            return z;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "copy fail", new Object[0]);
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(155920);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(155920);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "copy fail", new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(155920);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(155920);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            outputStream = null;
            Log.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "copy fail", new Object[0]);
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(155920);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            outputStream = null;
            Util.qualityClose(inputStream);
            Util.qualityClose(outputStream);
            AppMethodBeat.o(155920);
            throw th;
        }
    }
}

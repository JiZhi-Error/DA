package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedOutputStream;
import java.io.IOException;

public final class a {

    /* renamed from: com.tencent.mm.ui.tools.a$a  reason: collision with other inner class name */
    public interface AbstractC2129a {
        String aQX(String str);
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i2) {
        AppMethodBeat.i(143034);
        b(activity, intent, intent2, str, i2, null);
        AppMethodBeat.o(143034);
    }

    public static void b(final Activity activity, final Intent intent, final Intent intent2, final String str, final int i2, final AbstractC2129a aVar) {
        AppMethodBeat.i(143035);
        if (intent == null || intent.getData() == null) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            Log.e("MicroMsg.AsyncObtainImage", "param error, %b", objArr);
            AppMethodBeat.o(143035);
        } else if (!intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            String i3 = i(activity, intent, str);
            Log.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", i3);
            if (!Util.isNullOrNil(i3)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.aQX(i3));
                }
                intent2.putExtra("CropImage_ImgPath", i3);
                activity.startActivityForResult(intent2, i2);
            }
            AppMethodBeat.o(143035);
        } else {
            new AsyncTask<Integer, Integer, Integer>() {
                /* class com.tencent.mm.ui.tools.a.AnonymousClass2 */
                private ProgressDialog Qpg;
                private boolean Qph;
                private String filePath;
                private Uri uri;

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ Integer doInBackground(Integer[] numArr) {
                    AppMethodBeat.i(143033);
                    Integer gXy = gXy();
                    AppMethodBeat.o(143033);
                    return gXy;
                }

                /* access modifiers changed from: protected */
                public final void onPreExecute() {
                    AppMethodBeat.i(143030);
                    try {
                        this.uri = intent.getData();
                        this.Qph = false;
                        Activity activity = activity;
                        activity.getString(R.string.zb);
                        this.Qpg = h.a((Context) activity, activity.getString(R.string.vv), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.tools.a.AnonymousClass2.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(143029);
                                AnonymousClass2.this.Qph = true;
                                AppMethodBeat.o(143029);
                            }
                        });
                        AppMethodBeat.o(143030);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AsyncObtainImage", e2, "onPreExecute", new Object[0]);
                        AppMethodBeat.o(143030);
                    }
                }

                private Integer gXy() {
                    AppMethodBeat.i(143031);
                    try {
                        if (this.uri == null) {
                            AppMethodBeat.o(143031);
                            return null;
                        }
                        this.filePath = a.x(str, BitmapUtil.getBitmapNative(this.uri));
                        AppMethodBeat.o(143031);
                        return null;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AsyncObtainImage", e2, "doInBackground", new Object[0]);
                    }
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ void onPostExecute(Integer num) {
                    AppMethodBeat.i(143032);
                    if (this.Qph || Util.isNullOrNil(this.filePath)) {
                        Log.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (aVar != null) {
                            intent2.putExtra("CropImage_OutputPath", aVar.aQX(this.filePath));
                        }
                        intent2.putExtra("CropImage_ImgPath", this.filePath);
                        activity.startActivityForResult(intent2, i2);
                    }
                    this.Qpg.dismiss();
                    AppMethodBeat.o(143032);
                }
            }.execute(0);
            AppMethodBeat.o(143035);
        }
    }

    public static String i(Context context, Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.i(143036);
        if (context == null || intent == null || str == null) {
            Log.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
            AppMethodBeat.o(143036);
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                Log.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = x(str, BitmapUtil.getBitmapNative(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        Log.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:".concat(String.valueOf(str2)));
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AsyncObtainImage", e2, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!Util.isNullOrNil(path) && !new o(path).exists()) {
                    path = null;
                }
                Log.i("MicroMsg.AsyncObtainImage", "photo file from data, path:".concat(String.valueOf(path)));
                if (Util.isNullOrNil(path)) {
                    String host = intent.getData().getHost();
                    if (Util.isNullOrNil(host) || new o(host).exists()) {
                        str2 = host;
                    }
                    Log.i("MicroMsg.AsyncObtainImage", "photo file from data, host:".concat(String.valueOf(str2)));
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                Log.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
                AppMethodBeat.o(143036);
            } else {
                str2 = x(str, (Bitmap) intent.getExtras().get("data"));
                Log.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(143036);
        }
        return str2;
    }

    public static String x(String str, Bitmap bitmap) {
        AppMethodBeat.i(143037);
        try {
            String str2 = str + (g.getMessageDigest(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg");
            o oVar = new o(str2);
            if (!oVar.exists()) {
                oVar.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(s.ap(oVar));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            Log.i("MicroMsg.AsyncObtainImage", "photo image from data, path:".concat(String.valueOf(str2)));
            AppMethodBeat.o(143037);
            return str2;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.AsyncObtainImage", e2, "saveBmp Error.", new Object[0]);
            AppMethodBeat.o(143037);
            return null;
        }
    }
}

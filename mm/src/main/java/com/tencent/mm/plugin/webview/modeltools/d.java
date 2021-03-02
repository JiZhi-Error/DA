package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class d {
    private String Jau = null;
    private String Jav = null;
    private ValueCallback<Uri> Jaw = null;
    private ValueCallback<Uri[]> Jax = null;
    public Pair<Intent, Integer> Jay = null;

    public final boolean d(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(175744);
        if (this.Jay != null) {
            AppMethodBeat.o(175744);
            return true;
        } else if (i2 == 1) {
            b(activity, i3, intent);
            AppMethodBeat.o(175744);
            return true;
        } else {
            AppMethodBeat.o(175744);
            return false;
        }
    }

    private Uri a(Activity activity, int i2, Intent intent) {
        boolean z;
        boolean z2;
        Uri data;
        AppMethodBeat.i(175745);
        if (i2 != -1) {
            AppMethodBeat.o(175745);
            return null;
        }
        String str = null;
        if (intent != null) {
            Uri uri = null;
            if (intent.getData() == null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                }
                data = uri;
            } else {
                data = intent.getData();
            }
            if (((b) g.af(b.class)).a(b.a.clicfg_open_file_choose_new, 1) != 1 || data == null) {
                str = Util.getFilePath(activity, data);
                Log.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", str);
            } else {
                AppMethodBeat.o(175745);
                return data;
            }
        }
        if (!Util.isNullOrNil(str)) {
            String mimeTypeByFilePath = z.getMimeTypeByFilePath(str);
            Log.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", mimeTypeByFilePath);
            if (!Util.isNullOrNil(this.Jau)) {
                String[] split = this.Jau.split(",");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    String replace = split[i3].replace(" ", "");
                    if (Util.isNullOrNil(replace)) {
                        z2 = true;
                    } else {
                        if (!Util.isNullOrNil(mimeTypeByFilePath)) {
                            if (!replace.contains(FilePathGenerator.ANDROID_DIR_SEP) || !mimeTypeByFilePath.contains(FilePathGenerator.ANDROID_DIR_SEP)) {
                                z2 = replace.equals(mimeTypeByFilePath);
                            } else {
                                String[] split2 = replace.split(FilePathGenerator.ANDROID_DIR_SEP);
                                String[] split3 = mimeTypeByFilePath.split(FilePathGenerator.ANDROID_DIR_SEP);
                                if (Util.nullAsNil(split2[0]).equals(split3[0])) {
                                    z2 = Util.nullAsNil(split2[1]).equals("*") || Util.nullAsNil(split2[1]).equals(split3[1]);
                                }
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(175745);
                return null;
            } else if (intent.getData() == null) {
                Uri uriForFile = FileProviderHelper.getUriForFile(activity, new o(str));
                AppMethodBeat.o(175745);
                return uriForFile;
            } else {
                Uri data2 = intent.getData();
                AppMethodBeat.o(175745);
                return data2;
            }
        } else {
            o oVar = new o(ay.aYW(this.Jav));
            if (oVar.exists()) {
                Uri uriForFile2 = FileProviderHelper.getUriForFile(activity, oVar);
                AppMethodBeat.o(175745);
                return uriForFile2;
            }
            AppMethodBeat.o(175745);
            return null;
        }
    }

    public final void b(Activity activity, int i2, Intent intent) {
        AppMethodBeat.i(175747);
        if (this.Jaw == null && this.Jax == null) {
            Log.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
            AppMethodBeat.o(175747);
            return;
        }
        Uri a2 = a(activity, i2, intent);
        Log.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(a2)));
        v(a2);
        gdn();
        AppMethodBeat.o(175747);
    }

    public final void a(Activity activity, com.tencent.mm.plugin.webview.f.g gVar, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
        AppMethodBeat.i(211028);
        Log.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", gVar, valueCallback, valueCallback2, str, str2);
        gdn();
        if (gVar == null) {
            Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            v(null);
            AppMethodBeat.o(211028);
        } else if (!gVar.gdH().pP(56)) {
            Log.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            v(null);
            AppMethodBeat.o(211028);
        } else {
            this.Jaw = valueCallback;
            this.Jax = valueCallback2;
            this.Jav = new StringBuilder().append(System.currentTimeMillis()).toString();
            this.Jau = str;
            Intent bf = ay.bf(str, aZp(str2), this.Jav);
            if (!com.tencent.mm.pluginsdk.permission.b.n(activity, "android.permission.CAMERA")) {
                com.tencent.mm.pluginsdk.permission.b.b(activity, "android.permission.CAMERA", 119);
                this.Jay = Pair.create(bf, 1);
                Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
                AppMethodBeat.o(211028);
                return;
            }
            try {
                activity.startActivityForResult(bf, 1);
                AppMethodBeat.o(211028);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", e2);
                AppMethodBeat.o(211028);
            }
        }
    }

    private static String aZp(String str) {
        AppMethodBeat.i(79124);
        if ("user".equalsIgnoreCase(str) || "environment".equalsIgnoreCase(str)) {
            AppMethodBeat.o(79124);
            return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        }
        AppMethodBeat.o(79124);
        return str;
    }

    public final void gdn() {
        this.Jau = null;
        this.Jaw = null;
        this.Jax = null;
        this.Jav = null;
        this.Jay = null;
    }

    private void v(Uri uri) {
        AppMethodBeat.i(79125);
        if (this.Jaw != null) {
            this.Jaw.onReceiveValue(uri);
            AppMethodBeat.o(79125);
            return;
        }
        if (this.Jax != null) {
            if (uri == null) {
                this.Jax.onReceiveValue(null);
                AppMethodBeat.o(79125);
                return;
            }
            this.Jax.onReceiveValue(new Uri[]{uri});
        }
        AppMethodBeat.o(79125);
    }
}

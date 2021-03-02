package com.tencent.mm.av;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class r implements d.c {
    List<c> jaw = new LinkedList();
    c jax = null;
    boolean jay = false;

    public interface a {
        void a(String str, Bitmap bitmap, String str2);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public a jaA;
        public String md5;
        public String url;

        public c(String str, String str2, a aVar) {
            this.url = str;
            this.md5 = str2;
            this.jaA = aVar;
        }
    }

    public r() {
        AppMethodBeat.i(150764);
        AppMethodBeat.o(150764);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(150765);
        a(str, "", aVar);
        AppMethodBeat.o(150765);
    }

    public final void a(String str, String str2, a aVar) {
        AppMethodBeat.i(150766);
        if (Util.isNullOrNil(str) || aVar == null) {
            Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.o(150766);
        } else if (this.jax == null || !this.jax.url.equals(str) || this.jax.jaA != aVar) {
            for (c cVar : this.jaw) {
                if (cVar.url.equals(str) && cVar.jaA == aVar) {
                    Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    AppMethodBeat.o(150766);
                    return;
                }
            }
            this.jaw.add(new c(str, str2, aVar));
            bcX();
            AppMethodBeat.o(150766);
        } else {
            Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
            AppMethodBeat.o(150766);
        }
    }

    public final void b(String str, a aVar) {
        AppMethodBeat.i(150767);
        if (Util.isNullOrNil(str) || aVar == null) {
            Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.o(150767);
        } else if (this.jax == null || !this.jax.url.equals(str) || this.jax.jaA != aVar) {
            for (c cVar : this.jaw) {
                if (cVar.url.equals(str) && cVar.jaA == aVar) {
                    Log.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", str);
                    this.jaw.remove(cVar);
                    AppMethodBeat.o(150767);
                    return;
                }
            }
            AppMethodBeat.o(150767);
        } else {
            this.jay = true;
            Log.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", str);
            AppMethodBeat.o(150767);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bcX() {
        AppMethodBeat.i(150768);
        while (this.jax == null && this.jaw.size() != 0) {
            this.jax = this.jaw.get(0);
            this.jaw.remove(0);
            this.jay = false;
            q.bcQ();
            Bitmap EP = d.EP(this.jax.url);
            if (EP != null) {
                Log.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.jax.url);
                if (!this.jay) {
                    this.jax.jaA.a(this.jax.url, EP, ON(this.jax.url));
                }
                this.jax = null;
            } else {
                new AsyncTask<String, Integer, Bitmap>() {
                    /* class com.tencent.mm.av.r.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                    /* access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public final /* synthetic */ Bitmap doInBackground(String[] strArr) {
                        AppMethodBeat.i(150761);
                        String[] strArr2 = strArr;
                        if (strArr2.length <= 0) {
                            AppMethodBeat.o(150761);
                            return null;
                        }
                        String ON = r.ON(strArr2[0]);
                        if (!new o(ON).exists()) {
                            AppMethodBeat.o(150761);
                            return null;
                        }
                        Bitmap bitmapNative = BitmapUtil.getBitmapNative(ON);
                        AppMethodBeat.o(150761);
                        return bitmapNative;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
                        AppMethodBeat.i(150760);
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            Log.d("MicroMsg.UrlImageCacheService", "load from sdcard");
                            if (!r.this.jay) {
                                q.bcQ();
                                d.g(r.this.jax.url, bitmap2);
                                r.this.jax.jaA.a(r.this.jax.url, bitmap2, r.ON(r.this.jax.url));
                            }
                            r.this.jax = null;
                            r.this.bcX();
                            AppMethodBeat.o(150760);
                            return;
                        }
                        Log.i("MicroMsg.UrlImageCacheService", "try load from " + r.this.jax.url);
                        q.bcQ().a(r.this.jax.url, r.this);
                        AppMethodBeat.o(150760);
                    }
                }.execute(this.jax.url);
                AppMethodBeat.o(150768);
                return;
            }
        }
        Log.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
    }

    static String ON(String str) {
        AppMethodBeat.i(150769);
        try {
            String encode = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (Util.isNullOrNil(encode)) {
                Log.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(str)));
                AppMethodBeat.o(150769);
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(com.tencent.mm.loader.j.b.aKS());
            int length = encode.length();
            int i2 = 0;
            while (i2 < length) {
                sb.append('/');
                if (i2 + 20 < length) {
                    sb.append(encode.substring(i2, i2 + 20));
                    i2 += 20;
                } else {
                    sb.append(encode.substring(i2, length));
                    i2 = length;
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(150769);
            return sb2;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(str)));
            AppMethodBeat.o(150769);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public Bitmap bitmap;
        public String path;

        public b(String str, Bitmap bitmap2) {
            this.path = str;
            this.bitmap = bitmap2;
        }
    }

    @Override // com.tencent.mm.av.d.c
    public final void a(Bitmap bitmap, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(150770);
        if (bitmap == null) {
            Log.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.jax.url);
            this.jax = null;
            bcX();
            AppMethodBeat.o(150770);
            return;
        }
        Log.i("MicroMsg.UrlImageCacheService", "load from %s successed", this.jax.url);
        if (Util.isNullOrNil(this.jax.md5) || bArr == null) {
            z = true;
        } else {
            String messageDigest = g.getMessageDigest(bArr);
            if (!Util.isEqual(messageDigest, this.jax.md5)) {
                z = false;
            } else {
                z = true;
            }
            Log.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", this.jax.md5, messageDigest, Boolean.valueOf(z));
        }
        if (z) {
            String ON = ON(this.jax.url);
            new AsyncTask<b, Integer, Integer>() {
                /* class com.tencent.mm.av.r.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ Integer doInBackground(b[] bVarArr) {
                    AppMethodBeat.i(150763);
                    Integer a2 = a(bVarArr);
                    AppMethodBeat.o(150763);
                    return a2;
                }

                private static Integer a(b... bVarArr) {
                    AppMethodBeat.i(150762);
                    if (bVarArr.length == 0 || Util.isNullOrNil(bVarArr[0].path) || bVarArr[0].bitmap == null) {
                        Log.e("MicroMsg.UrlImageCacheService", "nothing to save");
                        AppMethodBeat.o(150762);
                    } else {
                        try {
                            BitmapUtil.saveBitmapToImage(bVarArr[0].bitmap, 100, Bitmap.CompressFormat.PNG, bVarArr[0].path, false);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e2.toString());
                        }
                        AppMethodBeat.o(150762);
                    }
                    return null;
                }
            }.execute(new b(ON, bitmap));
            if (!this.jay) {
                q.bcQ();
                d.g(this.jax.url, bitmap);
                this.jax.jaA.a(this.jax.url, bitmap, ON);
            }
        } else if (!this.jay) {
            this.jax.jaA.a(this.jax.url, null, "");
        }
        this.jax = null;
        bcX();
        AppMethodBeat.o(150770);
    }
}

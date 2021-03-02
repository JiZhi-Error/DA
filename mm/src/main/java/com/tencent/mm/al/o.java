package com.tencent.mm.al;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o {
    public static Bitmap Nw(String str) {
        boolean z = false;
        AppMethodBeat.i(124113);
        if (Util.isNullOrNil(str) || !g.aAh().isSDCardAvailable() || !g.aAf().azp()) {
            AppMethodBeat.o(124113);
            return null;
        }
        Bitmap Nx = ag.bas().Nx(str);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (Nx == null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        Log.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", objArr);
        AppMethodBeat.o(124113);
        return Nx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap bg(final java.lang.String r5, final java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.al.o.bg(java.lang.String, java.lang.String):android.graphics.Bitmap");
    }

    private static Bitmap aZW() {
        InputStream inputStream = null;
        AppMethodBeat.i(124115);
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapUtil.bindlowMemeryOption(options);
        try {
            inputStream = MMApplicationContext.getContext().getResources().openRawResource(R.drawable.bjp);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.BrandLogic", e2, "", new Object[0]);
                }
            }
            if (decodeStream != null) {
                decodeStream = BitmapUtil.getRoundedCornerBitmap(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
            }
            AppMethodBeat.o(124115);
            return decodeStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.BrandLogic", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(124115);
            throw th;
        }
    }

    static String bh(String str, String str2) {
        AppMethodBeat.i(124116);
        if (str == null || !g.aAf().azp()) {
            AppMethodBeat.o(124116);
            return null;
        }
        c MT = ag.bah().MT(str);
        if (MT.field_brandIconURL != null) {
            String str3 = MT.field_brandIconURL;
            AppMethodBeat.o(124116);
            return str3;
        }
        AppMethodBeat.o(124116);
        return str2;
    }

    public static final class a {
        List<Object> iOI = new ArrayList();
        Map<String, Integer> iOJ = new HashMap();
        Map<String, WeakReference<Bitmap>> iOK = new HashMap();
        QueueWorkerThread iOL = null;

        public a() {
            AppMethodBeat.i(124106);
            AppMethodBeat.o(124106);
        }

        public final void aZX() {
            AppMethodBeat.i(124107);
            this.iOI.clear();
            AppMethodBeat.o(124107);
        }

        /* access modifiers changed from: package-private */
        public final Bitmap Nx(String str) {
            Bitmap decodeFile;
            AppMethodBeat.i(124108);
            String format = String.format("%s%f", str, Float.valueOf(1.5f));
            if (this.iOK.containsKey(format)) {
                decodeFile = this.iOK.get(format).get();
                if (decodeFile == null || decodeFile.isRecycled()) {
                    decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(str, 1.5f);
                    this.iOK.remove(format);
                    this.iOK.put(format, new WeakReference<>(decodeFile));
                }
            } else {
                decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(str, 1.5f);
                this.iOK.put(format, new WeakReference<>(decodeFile));
            }
            AppMethodBeat.o(124108);
            return decodeFile;
        }

        public static String Ny(String str) {
            AppMethodBeat.i(124109);
            if (g.aAf().azp()) {
                String str2 = ((q) g.af(q.class)).aTh() + "/brand_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
                AppMethodBeat.o(124109);
                return str2;
            }
            AppMethodBeat.o(124109);
            return "";
        }

        /* access modifiers changed from: package-private */
        public final void f(String str, Bitmap bitmap) {
            AppMethodBeat.i(124110);
            Bitmap bitmap2 = this.iOK.containsKey(str) ? this.iOK.get(str).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 128, 128, true);
                    bitmap2 = BitmapUtil.getRoundedCornerBitmap(createScaledBitmap, true, (float) (createScaledBitmap.getWidth() >> 1));
                } catch (OutOfMemoryError e2) {
                    bitmap2 = bitmap;
                }
                this.iOK.remove(str);
                this.iOK.put(str, new WeakReference<>(bitmap2));
            }
            if (bitmap2 == bitmap) {
                AppMethodBeat.o(124110);
                return;
            }
            Log.i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            AppMethodBeat.o(124110);
        }
    }

    static class b implements QueueWorkerThread.ThreadObject {
        private final String brand;
        public byte[] iKr = null;
        private final String url;

        public b(String str, String str2) {
            this.brand = str;
            this.url = str2;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(124111);
            if (Util.isNullOrNil(this.brand) || Util.isNullOrNil(this.url)) {
                AppMethodBeat.o(124111);
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream w = d.w(this.url, 3000, 5000);
                if (w == null) {
                    AppMethodBeat.o(124111);
                    return false;
                }
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = w.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                w.close();
                this.iKr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (Util.isNullOrNil(this.iKr)) {
                    Log.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.brand);
                    AppMethodBeat.o(124111);
                    return false;
                }
                if (g.aAf().azp()) {
                    ay.a.iDr.dl(this.iKr.length, 0);
                    a bas = ag.bas();
                    String str = this.brand;
                    String str2 = this.url;
                    try {
                        Bitmap decodeByteArray = BitmapUtil.decodeByteArray(this.iKr);
                        BitmapUtil.saveBitmapToImage(decodeByteArray, 100, Bitmap.CompressFormat.PNG, a.Ny(str + str2), false);
                        bas.f(str, decodeByteArray);
                        Log.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        bas.iOJ.remove(str);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BrandLogic", "exception:%s", Util.stackTraceToString(e2));
                    }
                }
                AppMethodBeat.o(124111);
                return true;
            } catch (Exception e3) {
                Log.e("MicroMsg.BrandLogic", "exception:%s", Util.stackTraceToString(e3));
                Log.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.iKr = null;
                AppMethodBeat.o(124111);
                return false;
            }
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(124112);
            a bas = ag.bas();
            for (int i2 = 0; i2 < bas.iOI.size(); i2++) {
                try {
                    bas.iOI.get(i2);
                } catch (Exception e2) {
                    Log.e("MicroMsg.BrandLogic", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            AppMethodBeat.o(124112);
            return false;
        }
    }
}

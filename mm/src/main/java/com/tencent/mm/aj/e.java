package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.cache.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static a iKA = new a(iKv);
    private static int iKu = 100;
    private static int iKv = 100;
    static final Map<String, Integer> iKw;
    private MStorageEvent<a, String> iKx = new MStorageEvent<a, String>() {
        /* class com.tencent.mm.aj.e.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, String str) {
            AppMethodBeat.i(150237);
            aVar.Mr(str);
            AppMethodBeat.o(150237);
        }
    };
    private final List<WeakReference<a>> iKy = new ArrayList();
    private final a iKz = new a() {
        /* class com.tencent.mm.aj.e.AnonymousClass2 */

        @Override // com.tencent.mm.aj.e.a
        public final void Mr(String str) {
            AppMethodBeat.i(150238);
            Log.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(e.this.iKy.size()), Integer.valueOf(e.this.iKy.size()));
            ArrayList<a> arrayList = new ArrayList();
            synchronized (e.this.iKy) {
                try {
                    Iterator it = e.this.iKy.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null) {
                            a aVar = (a) weakReference.get();
                            if (aVar != null) {
                                arrayList.add(aVar);
                            } else {
                                it.remove();
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(150238);
                }
            }
            for (a aVar2 : arrayList) {
                aVar2.Mr(str);
            }
        }
    };

    public interface a {
        void Mr(String str);
    }

    static {
        AppMethodBeat.i(150268);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        iKw = concurrentHashMap;
        concurrentHashMap.put("voipapp", Integer.valueOf((int) R.raw.default_voip));
        iKw.put("qqmail", Integer.valueOf((int) R.raw.default_qqmail));
        iKw.put("fmessage", Integer.valueOf((int) R.raw.default_fmessage));
        iKw.put("floatbottle", Integer.valueOf((int) R.raw.default_bottle));
        iKw.put("lbsapp", Integer.valueOf((int) R.raw.default_nearby));
        iKw.put("shakeapp", Integer.valueOf((int) R.raw.default_shake));
        iKw.put("medianote", Integer.valueOf((int) R.raw.default_medianote));
        iKw.put("qqfriend", Integer.valueOf((int) R.raw.default_qqfriend));
        iKw.put("masssendapp", Integer.valueOf((int) R.raw.default_masssend));
        iKw.put("feedsapp", Integer.valueOf((int) R.raw.default_feedsapp));
        iKw.put("facebookapp", Integer.valueOf((int) R.raw.default_facebookapp));
        iKw.put("newsapp", Integer.valueOf((int) R.raw.default_readerapp));
        iKw.put("helper_entry", Integer.valueOf((int) R.raw.default_plugin_icon_contract));
        iKw.put("voicevoipapp", Integer.valueOf((int) R.raw.default_voicevoip));
        iKw.put("voiceinputapp", Integer.valueOf((int) R.raw.default_voiceinput));
        iKw.put("findersayhisessionholder", Integer.valueOf((int) R.drawable.icon_filled_nearby_finder));
        iKw.put("officialaccounts", Integer.valueOf((int) R.raw.default_brand_contact));
        iKw.put("service_officialaccounts", Integer.valueOf((int) R.raw.default_servicebrand_contact));
        iKw.put("linkedinplugin", Integer.valueOf((int) R.raw.default_linkedin));
        iKw.put("notifymessage", Integer.valueOf((int) R.raw.default_notify_message_contact));
        iKw.put("appbrandcustomerservicemsg", Integer.valueOf((int) R.raw.default_app_brand_service_msg));
        iKw.put("appbrand_notify_message", Integer.valueOf((int) R.raw.default_app_brand_notify_msg));
        iKw.put("downloaderapp", Integer.valueOf((int) R.raw.default_downloaderapp));
        AppMethodBeat.o(150268);
    }

    public static void a(Context context, ImageView imageView, int i2) {
        AppMethodBeat.i(150242);
        try {
            imageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i2), true, 1.0f));
            AppMethodBeat.o(150242);
        } catch (Exception e2) {
            Log.e("MicroMsg.AvatarStorage", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150242);
        }
    }

    public e() {
        AppMethodBeat.i(150243);
        reset();
        this.iKx.add(this.iKz, (Looper) null);
        AppMethodBeat.o(150243);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(150244);
        synchronized (this.iKy) {
            try {
                this.iKy.add(new WeakReference<>(aVar));
            } finally {
                AppMethodBeat.o(150244);
            }
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(150245);
        synchronized (this.iKy) {
            try {
                WeakReference<a> c2 = c(aVar);
                if (c2 != null) {
                    this.iKy.remove(c2);
                }
            } finally {
                AppMethodBeat.o(150245);
            }
        }
    }

    private WeakReference<a> c(a aVar) {
        a aVar2;
        AppMethodBeat.i(150246);
        synchronized (this.iKy) {
            for (int i2 = 0; i2 < this.iKy.size(); i2++) {
                try {
                    WeakReference<a> weakReference = this.iKy.get(i2);
                    if (!(weakReference == null || (aVar2 = weakReference.get()) == null || !aVar2.equals(aVar))) {
                        return weakReference;
                    }
                } finally {
                    AppMethodBeat.o(150246);
                }
            }
            AppMethodBeat.o(150246);
            return null;
        }
    }

    @Deprecated
    public final void d(a aVar) {
        AppMethodBeat.i(150247);
        this.iKx.add(aVar, Looper.getMainLooper());
        AppMethodBeat.o(150247);
    }

    @Deprecated
    public final void e(a aVar) {
        AppMethodBeat.i(150248);
        this.iKx.remove(aVar);
        AppMethodBeat.o(150248);
    }

    public static void reset() {
        AppMethodBeat.i(150249);
        if (iKA == null) {
            iKA = new a(iKv);
        }
        AppMethodBeat.o(150249);
    }

    public static Bitmap Mk(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(150250);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150250);
            return null;
        }
        a aVar = iKA;
        if (aVar.iJX != null) {
            bitmap = aVar.iJX.aT(str);
        } else {
            bitmap = (Bitmap) g.a.X("avatar_cache", str);
        }
        if (bitmap == null) {
            AppMethodBeat.o(150250);
            return null;
        } else if (bitmap.isRecycled()) {
            a aVar2 = iKA;
            if (aVar2.iJX != null) {
                aVar2.iJX.remove(str);
            } else {
                g.a.Y("avatar_cache", str);
            }
            AppMethodBeat.o(150250);
            return null;
        } else {
            AppMethodBeat.o(150250);
            return bitmap;
        }
    }

    public final void d(String str, Bitmap bitmap) {
        AppMethodBeat.i(150251);
        iKA.c(str, bitmap);
        com.tencent.mm.bx.a.a aVar = a.C0284a.NAL;
        if (aVar != null) {
            aVar.aer(str);
        }
        this.iKx.event(str);
        this.iKx.doNotify();
        Log.d("MicroMsg.AvatarStorage", "setToCache %s", str);
        AppMethodBeat.o(150251);
    }

    public final Bitmap cW(Context context) {
        AppMethodBeat.i(150252);
        context.getResources();
        Bitmap Mk = Mk("I_AM_NO_SDCARD_USER_NAME");
        if (!M(Mk) && Mk != null) {
            Log.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(Mk.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
            Mk = BitmapUtil.getRoundedCornerBitmap(Mk, true, 1.0f);
            d("I_AM_NO_SDCARD_USER_NAME", Mk);
        }
        AppMethodBeat.o(150252);
        return Mk;
    }

    public static class b {
        public static boolean Ms(String str) {
            AppMethodBeat.i(150239);
            Bitmap Mt = Mt(str);
            if (Mt == null || Mt.isRecycled()) {
                AppMethodBeat.o(150239);
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = s.dw(str, false);
                Mt.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                s.deleteFile(str + ".bm");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(150239);
                return true;
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.AvatarStorage", e3, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(150239);
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(150239);
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x014c A[SYNTHETIC, Splitter:B:33:0x014c] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0151 A[Catch:{ Exception -> 0x0176 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static android.graphics.Bitmap Mt(java.lang.String r12) {
            /*
            // Method dump skipped, instructions count: 386
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.e.b.Mt(java.lang.String):android.graphics.Bitmap");
        }

        static boolean remove(String str) {
            AppMethodBeat.i(150241);
            s.deleteFile(str + ".bm");
            s.deleteFile(str);
            AppMethodBeat.o(150241);
            return true;
        }
    }

    private static StringBuilder a(StringBuilder sb, String str, boolean z) {
        AppMethodBeat.i(150253);
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        sb.append(messageDigest.substring(0, 2)).append('/').append(messageDigest.substring(2, 4)).append('/').append("user_");
        if (z) {
            sb.append("hd_");
        }
        StringBuilder append = sb.append(messageDigest).append(".png");
        AppMethodBeat.o(150253);
        return append;
    }

    public static String L(String str, boolean z) {
        AppMethodBeat.i(150254);
        String sb = a(new StringBuilder(64).append("wcf://avatar/"), str, z).toString();
        s.boN(s.boZ(sb));
        AppMethodBeat.o(150254);
        return sb;
    }

    public static String Ml(String str) {
        AppMethodBeat.i(223533);
        String M = M(str, false);
        AppMethodBeat.o(223533);
        return M;
    }

    public static String M(String str, boolean z) {
        AppMethodBeat.i(150255);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150255);
            return null;
        }
        String sb = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.aAh().cachePath).append("avatar/"), str, z).toString();
        if (s.boN(s.boZ(sb))) {
            AppMethodBeat.o(150255);
            return sb;
        }
        AppMethodBeat.o(150255);
        return null;
    }

    public static boolean Mm(String str) {
        AppMethodBeat.i(150256);
        String L = L(str, false);
        if (s.YS(L) || s.YS(L + ".bm")) {
            AppMethodBeat.o(150256);
            return true;
        }
        AppMethodBeat.o(150256);
        return false;
    }

    public static boolean N(String str, boolean z) {
        AppMethodBeat.i(150257);
        String L = L(str, z);
        Log.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), L);
        boolean deleteFile = s.deleteFile(L);
        if (!z) {
            deleteFile |= b.remove(L);
        }
        AppMethodBeat.o(150257);
        return deleteFile;
    }

    public static Bitmap Mn(String str) {
        AppMethodBeat.i(150258);
        Bitmap Mq = Mq(L(str, false));
        AppMethodBeat.o(150258);
        return Mq;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[SYNTHETIC, Splitter:B:24:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[SYNTHETIC, Splitter:B:30:0x0085] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap g(java.lang.String r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.e.g(java.lang.String, byte[]):android.graphics.Bitmap");
    }

    public final boolean h(String str, byte[] bArr) {
        AppMethodBeat.i(150260);
        Bitmap g2 = g(str, bArr);
        if (!M(g2)) {
            AppMethodBeat.o(150260);
            return false;
        }
        d(str, g2);
        AppMethodBeat.o(150260);
        return true;
    }

    public final boolean bb(String str, String str2) {
        int i2;
        int i3;
        boolean z = false;
        AppMethodBeat.i(150261);
        try {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            int i4 = imageOptions.outWidth;
            int i5 = imageOptions.outHeight;
            if (i5 < i4) {
                i3 = (i4 * 156) / i5;
                i2 = 156;
            } else {
                i2 = (i5 * 156) / i4;
                i3 = 156;
            }
            Log.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2), 1);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize = 1;
            z = e(str2, BitmapUtil.decodeFile(str, options));
            AppMethodBeat.o(150261);
        } catch (Exception e2) {
            Log.e("MicroMsg.AvatarStorage", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150261);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb A[SYNTHETIC, Splitter:B:39:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8 A[SYNTHETIC, Splitter:B:45:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.String r9, android.graphics.Bitmap r10) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.e.e(java.lang.String, android.graphics.Bitmap):boolean");
    }

    public static Bitmap o(String str, int i2, int i3) {
        AppMethodBeat.i(150263);
        Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150263);
            return null;
        }
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(L(str, true), i2, i3);
        AppMethodBeat.o(150263);
        return bitmapNative;
    }

    public static Bitmap Mo(String str) {
        AppMethodBeat.i(150264);
        Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150264);
            return null;
        }
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(L(str, true), 1080, 1080);
        AppMethodBeat.o(150264);
        return bitmapNative;
    }

    public static Bitmap Mp(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(150265);
        int i2 = 0;
        if (iKw.containsKey(str)) {
            i2 = iKw.get(str).intValue();
        }
        if (i2 != 0) {
            p.aYA();
            bitmap = com.tencent.mm.compatible.f.a.decodeResource(p.getContext().getResources(), i2);
        } else {
            bitmap = null;
        }
        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, true, 1.0f, true);
        AppMethodBeat.o(150265);
        return roundedCornerBitmap;
    }

    private static boolean M(Bitmap bitmap) {
        AppMethodBeat.i(150266);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(150266);
            return false;
        }
        AppMethodBeat.o(150266);
        return true;
    }

    public static Bitmap Mq(String str) {
        Bitmap bitmap;
        int width;
        int height;
        AppMethodBeat.i(150267);
        if (s.YS(str)) {
            bitmap = BitmapUtil.decodeFile(str, null);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = b.Mt(str);
        }
        if (M(bitmap) && (width = bitmap.getWidth()) != (height = bitmap.getHeight())) {
            if (width > height) {
                bitmap = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
            } else {
                bitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
            }
        }
        if (M(bitmap)) {
            AppMethodBeat.o(150267);
            return bitmap;
        }
        AppMethodBeat.o(150267);
        return null;
    }
}

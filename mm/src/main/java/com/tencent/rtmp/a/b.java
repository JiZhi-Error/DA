package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapFactory.Options f1581a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f1582b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f1583c;

    /* renamed from: d  reason: collision with root package name */
    private List<c> f1584d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, BitmapRegionDecoder> f1585e;

    static /* synthetic */ InputStream a(b bVar, String str) {
        AppMethodBeat.i(13632);
        InputStream a2 = bVar.a(str);
        AppMethodBeat.o(13632);
        return a2;
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(13633);
        bVar.b();
        AppMethodBeat.o(13633);
    }

    public b() {
        AppMethodBeat.i(13624);
        this.f1581a = new BitmapFactory.Options();
        this.f1584d = new ArrayList();
        this.f1584d = Collections.synchronizedList(this.f1584d);
        this.f1585e = new HashMap();
        this.f1585e = Collections.synchronizedMap(this.f1585e);
        AppMethodBeat.o(13624);
    }

    @Override // com.tencent.rtmp.a.a
    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.i(13625);
        if (TextUtils.isEmpty(str)) {
            TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            AppMethodBeat.o(13625);
            return;
        }
        b();
        a();
        this.f1583c.post(new a(this, str));
        if (!(list == null || list.size() == 0)) {
            for (String str2 : list) {
                this.f1583c.post(new RunnableC2182b(this, str, str2));
            }
        }
        AppMethodBeat.o(13625);
    }

    @Override // com.tencent.rtmp.a.a
    public Bitmap getThumbnail(float f2) {
        AppMethodBeat.i(13626);
        if (this.f1584d.size() == 0) {
            AppMethodBeat.o(13626);
            return null;
        }
        c a2 = a(0, this.f1584d.size() - 1, f2);
        if (a2 == null) {
            AppMethodBeat.o(13626);
            return null;
        }
        BitmapRegionDecoder bitmapRegionDecoder = this.f1585e.get(a2.f1595d);
        if (bitmapRegionDecoder == null) {
            AppMethodBeat.o(13626);
            return null;
        }
        Rect rect = new Rect();
        rect.left = a2.f1596e;
        rect.top = a2.f1597f;
        rect.right = a2.f1596e + a2.f1598g;
        rect.bottom = a2.f1599h + a2.f1597f;
        Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, this.f1581a);
        AppMethodBeat.o(13626);
        return decodeRegion;
    }

    @Override // com.tencent.rtmp.a.a
    public void release() {
        AppMethodBeat.i(13627);
        b();
        if (!(this.f1582b == null || this.f1583c == null)) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f1582b.quitSafely();
            } else {
                this.f1582b.quit();
            }
            this.f1583c = null;
            this.f1582b = null;
        }
        AppMethodBeat.o(13627);
    }

    private c a(int i2, int i3, float f2) {
        AppMethodBeat.i(13628);
        while (true) {
            int i4 = ((i3 - i2) / 2) + i2;
            if (this.f1584d.get(i4).f1592a <= f2 && this.f1584d.get(i4).f1593b > f2) {
                c cVar = this.f1584d.get(i4);
                AppMethodBeat.o(13628);
                return cVar;
            } else if (i2 >= i3) {
                c cVar2 = this.f1584d.get(i2);
                AppMethodBeat.o(13628);
                return cVar2;
            } else if (f2 >= this.f1584d.get(i4).f1593b) {
                i2 = i4 + 1;
            } else if (f2 < this.f1584d.get(i4).f1592a) {
                i3 = i4 - 1;
            } else {
                AppMethodBeat.o(13628);
                return null;
            }
        }
    }

    private void a() {
        AppMethodBeat.i(13629);
        if (this.f1582b == null) {
            this.f1582b = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.f1582b.start();
            this.f1583c = new Handler(this.f1582b.getLooper());
        }
        AppMethodBeat.o(13629);
    }

    private void b() {
        AppMethodBeat.i(13630);
        if (this.f1583c != null) {
            TXCLog.i("TXImageSprite", " remove all tasks!");
            this.f1583c.removeCallbacksAndMessages(null);
            this.f1583c.post(new Runnable() {
                /* class com.tencent.rtmp.a.b.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(13623);
                    if (b.this.f1584d != null) {
                        b.this.f1584d.clear();
                    }
                    if (b.this.f1585e != null) {
                        for (BitmapRegionDecoder bitmapRegionDecoder : b.this.f1585e.values()) {
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                        }
                        b.this.f1585e.clear();
                    }
                    AppMethodBeat.o(13623);
                }
            });
        }
        AppMethodBeat.o(13630);
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f1587a;

        /* renamed from: b  reason: collision with root package name */
        private String f1588b;

        public a(b bVar, String str) {
            AppMethodBeat.i(13618);
            this.f1587a = new WeakReference<>(bVar);
            this.f1588b = str;
            AppMethodBeat.o(13618);
        }

        private float a(String str) {
            String str2;
            String str3;
            String str4;
            float f2 = 0.0f;
            AppMethodBeat.i(13619);
            String[] split = str.split(":");
            if (split.length == 3) {
                str4 = split[0];
                String str5 = split[1];
                str2 = split[2];
                str3 = str5;
            } else if (split.length == 2) {
                str3 = split[0];
                str2 = split[1];
                str4 = null;
            } else if (split.length == 1) {
                str2 = split[0];
                str3 = null;
                str4 = null;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (str4 != null) {
            }
            if (str3 != null) {
                f2 = 0.0f + (Float.valueOf(str3).floatValue() * 60.0f);
            }
            if (str2 != null) {
                f2 += Float.valueOf(str2).floatValue();
            }
            AppMethodBeat.o(13619);
            return f2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x0121 A[SYNTHETIC, Splitter:B:53:0x0121] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0133 A[SYNTHETIC, Splitter:B:61:0x0133] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x013a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 325
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.a.b.a.run():void");
        }
    }

    private InputStream a(String str) {
        AppMethodBeat.i(13631);
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.connect();
        openConnection.getInputStream();
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        InputStream inputStream = openConnection.getInputStream();
        AppMethodBeat.o(13631);
        return inputStream;
    }

    /* renamed from: com.tencent.rtmp.a.b$b  reason: collision with other inner class name */
    static class RunnableC2182b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f1589a;

        /* renamed from: b  reason: collision with root package name */
        private String f1590b;

        /* renamed from: c  reason: collision with root package name */
        private String f1591c;

        public RunnableC2182b(b bVar, String str, String str2) {
            AppMethodBeat.i(13621);
            this.f1589a = new WeakReference<>(bVar);
            this.f1590b = str;
            this.f1591c = str2;
            AppMethodBeat.o(13621);
        }

        public void run() {
            AppMethodBeat.i(13622);
            b bVar = this.f1589a.get();
            if (!(this.f1589a == null || bVar == null)) {
                InputStream inputStream = null;
                try {
                    InputStream a2 = b.a(bVar, this.f1591c);
                    int lastIndexOf = this.f1591c.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                    if (lastIndexOf != -1 && lastIndexOf + 1 < this.f1591c.length()) {
                        String substring = this.f1591c.substring(lastIndexOf + 1, this.f1591c.length());
                        if (bVar.f1585e != null) {
                            bVar.f1585e.put(substring, BitmapRegionDecoder.newInstance(a2, true));
                        }
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                            AppMethodBeat.o(13622);
                            return;
                        } catch (IOException e2) {
                            AppMethodBeat.o(13622);
                            return;
                        }
                    }
                } catch (IOException e3) {
                    TXCLog.e("TXImageSprite", "load bitmap from network failed.", e3);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                            AppMethodBeat.o(13622);
                            return;
                        } catch (IOException e4) {
                            AppMethodBeat.o(13622);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(13622);
                    throw th;
                }
            }
            AppMethodBeat.o(13622);
        }
    }
}

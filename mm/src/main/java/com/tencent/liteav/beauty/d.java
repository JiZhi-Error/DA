package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class d extends com.tencent.liteav.basic.module.a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected Context f598a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f599b = true;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f600c = false;

    /* renamed from: d  reason: collision with root package name */
    protected int f601d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f602e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f603f = 1;

    /* renamed from: g  reason: collision with root package name */
    protected com.tencent.liteav.basic.c.a f604g = null;

    /* renamed from: h  reason: collision with root package name */
    protected c f605h;

    /* renamed from: i  reason: collision with root package name */
    protected b f606i = new b();

    /* renamed from: j  reason: collision with root package name */
    protected c f607j = null;
    f k;
    private EnumC0157d l = EnumC0157d.MODE_THRESHOLD;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private Object p;
    private a q = new a(this);

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public g f634a = g.TXE_FILL_MODE_SCALL_ASPECT_FILL;

        /* renamed from: b  reason: collision with root package name */
        public boolean f635b = false;
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f636a;

        /* renamed from: b  reason: collision with root package name */
        public float f637b;

        /* renamed from: c  reason: collision with root package name */
        public float f638c;

        /* renamed from: d  reason: collision with root package name */
        public float f639d;
    }

    /* renamed from: com.tencent.liteav.beauty.d$d  reason: collision with other inner class name */
    public enum EnumC0157d {
        MODE_SAME_AS_OUTPUT,
        MODE_SAME_AS_INPUT,
        MODE_THRESHOLD;

        public static EnumC0157d valueOf(String str) {
            AppMethodBeat.i(221505);
            EnumC0157d dVar = (EnumC0157d) Enum.valueOf(EnumC0157d.class, str);
            AppMethodBeat.o(221505);
            return dVar;
        }

        static {
            AppMethodBeat.i(221506);
            AppMethodBeat.o(221506);
        }
    }

    @Override // com.tencent.liteav.beauty.e
    public int a(int i2, int i3, int i4) {
        boolean z = false;
        AppMethodBeat.i(221514);
        if (this.k != null) {
            com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
            bVar.f432e = i3;
            bVar.f433f = i4;
            bVar.f437j = 0;
            if (this.f607j != null) {
                z = this.f607j.f624e;
            }
            bVar.f436i = z;
            bVar.f428a = i2;
            int a2 = this.k.a(bVar);
            AppMethodBeat.o(221514);
            return a2;
        }
        AppMethodBeat.o(221514);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.e
    public void a(int i2, int i3, int i4, long j2) {
        boolean z = false;
        AppMethodBeat.i(221515);
        c();
        if (this.k != null) {
            com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
            bVar.f432e = i3;
            bVar.f433f = i4;
            bVar.f437j = 0;
            if (this.f607j != null) {
                z = this.f607j.f624e;
            }
            bVar.f436i = z;
            bVar.f428a = i2;
            this.k.a(bVar, j2);
        }
        AppMethodBeat.o(221515);
    }

    @Override // com.tencent.liteav.beauty.e
    public void a(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(221516);
        if (this.k != null) {
            this.k.b(bArr, i2, i3, i4, j2);
        }
        AppMethodBeat.o(221516);
    }

    private void c() {
        AppMethodBeat.i(221517);
        if (this.m != 0) {
            setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.m));
        }
        this.n++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.o + 2000) {
            setStatusValue(3003, Double.valueOf((((double) this.n) * 1000.0d) / ((double) (currentTimeMillis - this.o))));
            this.n = 0;
            this.o = currentTimeMillis;
        }
        AppMethodBeat.o(221517);
    }

    public enum g {
        TXE_FILL_MODE_SCALL_TO_FILL,
        TXE_FILL_MODE_SCALL_ASPECT_FILL;

        public static g valueOf(String str) {
            AppMethodBeat.i(221469);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(221469);
            return gVar;
        }

        static {
            AppMethodBeat.i(221470);
            AppMethodBeat.o(221470);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f620a;

        /* renamed from: b  reason: collision with root package name */
        public int f621b;

        /* renamed from: c  reason: collision with root package name */
        public int f622c;

        /* renamed from: d  reason: collision with root package name */
        public int f623d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f624e;

        /* renamed from: f  reason: collision with root package name */
        public int f625f;

        /* renamed from: g  reason: collision with root package name */
        public int f626g;

        /* renamed from: h  reason: collision with root package name */
        public int f627h;

        /* renamed from: i  reason: collision with root package name */
        public int f628i;

        /* renamed from: j  reason: collision with root package name */
        public com.tencent.liteav.basic.c.a f629j;

        private c() {
            this.f624e = false;
            this.f627h = 5;
            this.f628i = 0;
            this.f629j = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f610a;

        /* renamed from: b  reason: collision with root package name */
        int f611b;

        /* renamed from: c  reason: collision with root package name */
        int f612c;

        /* renamed from: d  reason: collision with root package name */
        int f613d;

        /* renamed from: e  reason: collision with root package name */
        int f614e;

        /* renamed from: f  reason: collision with root package name */
        int f615f;

        /* renamed from: g  reason: collision with root package name */
        int f616g;

        /* renamed from: h  reason: collision with root package name */
        int f617h;

        /* renamed from: i  reason: collision with root package name */
        boolean f618i;

        /* renamed from: j  reason: collision with root package name */
        boolean f619j;
        public int k = 5;
        public int l = 0;
        com.tencent.liteav.basic.c.a m = null;

        b() {
        }
    }

    public d(Context context, boolean z) {
        AppMethodBeat.i(221518);
        TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            TXCLog.i("TXCVideoPreprocessor", "opengl es version " + deviceConfigurationInfo.reqGlEsVersion);
            TXCLog.i("TXCVideoPreprocessor", "set GLContext ".concat(String.valueOf(z)));
            if (deviceConfigurationInfo.reqGlEsVersion > 131072) {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
                j.a(3);
            } else {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
                j.a(2);
            }
        } else {
            TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
        }
        this.f598a = context;
        this.f599b = z;
        this.f605h = new c(this.f598a, this.f599b);
        a.a().a(context);
        AppMethodBeat.o(221518);
    }

    public void a(float[] fArr) {
        AppMethodBeat.i(221519);
        if (this.f605h != null) {
            this.f605h.a(fArr);
        }
        AppMethodBeat.o(221519);
    }

    public void a(boolean z) {
        AppMethodBeat.i(221520);
        if (this.f605h != null) {
            this.f605h.a(z);
        }
        AppMethodBeat.o(221520);
    }

    public synchronized int a(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        int a2;
        AppMethodBeat.i(221521);
        a(i2, i3, z(i4), i5, i6);
        this.f605h.b(this.f606i);
        a2 = this.f605h.a(bArr, i5);
        AppMethodBeat.o(221521);
        return a2;
    }

    public synchronized int a(int i2, int i3, int i4, int i5, int i6, int i7, long j2) {
        int a2;
        AppMethodBeat.i(221522);
        a(i3, i4, z(i5), i6, i7);
        this.f605h.b(this.f606i);
        a2 = this.f605h.a(i2, i6, j2);
        AppMethodBeat.o(221522);
        return a2;
    }

    public synchronized int a(com.tencent.liteav.basic.structs.b bVar, int i2, int i3, long j2) {
        int a2;
        AppMethodBeat.i(221523);
        this.m = System.currentTimeMillis();
        a(bVar.l);
        a(bVar.f434g, bVar.f435h);
        b(bVar.f436i);
        a(bVar.f430c);
        a(bVar.f431d);
        if (bVar.m == null || bVar.f428a != -1) {
            a2 = a(bVar.f428a, bVar.f432e, bVar.f433f, bVar.f437j, i2, i3, j2);
            AppMethodBeat.o(221523);
        } else {
            a2 = a(bVar.m, bVar.f432e, bVar.f433f, bVar.f437j, i2, i3);
            AppMethodBeat.o(221523);
        }
        return a2;
    }

    public synchronized void a(EnumC0157d dVar) {
        AppMethodBeat.i(221524);
        this.l = dVar;
        TXCLog.i("TXCVideoPreprocessor", "set Process SDK performance ".concat(String.valueOf(dVar)));
        AppMethodBeat.o(221524);
    }

    public synchronized void a(com.tencent.liteav.basic.c.a aVar) {
        this.f604g = aVar;
    }

    public synchronized void a(int i2, int i3) {
        this.f601d = i2;
        this.f602e = i3;
    }

    public synchronized void a(Bitmap bitmap, float f2, float f3, float f4) {
        AppMethodBeat.i(221525);
        if (f2 < 0.0f || f3 < 0.0f || ((double) f4) < 0.0d) {
            TXCLog.e("TXCVideoPreprocessor", "WaterMark param is Error!");
            AppMethodBeat.o(221525);
        } else {
            if (this.f605h != null) {
                this.f605h.a(bitmap, f2, f3, f4);
            }
            AppMethodBeat.o(221525);
        }
    }

    public synchronized void b(boolean z) {
        this.f600c = z;
    }

    public synchronized void a(Object obj) {
        this.p = obj;
    }

    public synchronized Object a() {
        return this.p;
    }

    public synchronized void a(f fVar) {
        AppMethodBeat.i(221526);
        if (this.f605h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.o(221526);
        } else {
            this.k = fVar;
            if (fVar == null) {
                this.f605h.a((e) null);
                AppMethodBeat.o(221526);
            } else {
                this.f605h.a(this);
                AppMethodBeat.o(221526);
            }
        }
    }

    public synchronized void a(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221527);
        if (this.f605h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.o(221527);
        } else {
            this.f605h.a(bVar);
            AppMethodBeat.o(221527);
        }
    }

    private int z(int i2) {
        switch (i2) {
            case 1:
                return 90;
            case 2:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 3:
                return 270;
            default:
                return i2;
        }
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        AppMethodBeat.i(221528);
        if (this.f607j == null) {
            this.f607j = new c();
            this.n = 0;
            this.o = System.currentTimeMillis();
        }
        if (i2 != this.f607j.f621b || i3 != this.f607j.f622c || i4 != this.f607j.f623d || ((this.f601d > 0 && this.f601d != this.f607j.f625f) || ((this.f602e > 0 && this.f602e != this.f607j.f626g) || ((this.f604g != null && ((this.f604g.f222c > 0 && (this.f607j.f629j == null || this.f604g.f222c != this.f607j.f629j.f222c)) || ((this.f604g.f223d > 0 && (this.f607j.f629j == null || this.f604g.f223d != this.f607j.f629j.f223d)) || ((this.f604g.f220a >= 0 && (this.f607j.f629j == null || this.f604g.f220a != this.f607j.f629j.f220a)) || (this.f604g.f221b >= 0 && (this.f607j.f629j == null || this.f604g.f221b != this.f607j.f629j.f221b)))))) || this.f600c != this.f607j.f624e || this.f607j.f627h != i5)))) {
            TXCLog.i("TXCVideoPreprocessor", "Init sdk");
            TXCLog.i("TXCVideoPreprocessor", "Input widht " + i2 + " height " + i3);
            this.f607j.f621b = i2;
            this.f607j.f622c = i3;
            if (this.f604g == null || this.f604g.f220a < 0 || this.f604g.f221b < 0 || this.f604g.f222c <= 0 || this.f604g.f223d <= 0) {
                i7 = i3;
                i8 = i2;
            } else {
                TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
                int i10 = i2 - this.f604g.f220a > this.f604g.f222c ? this.f604g.f222c : i2 - this.f604g.f220a;
                if (i3 - this.f604g.f221b > this.f604g.f223d) {
                    i9 = this.f604g.f223d;
                } else {
                    i9 = i3 - this.f604g.f221b;
                }
                this.f604g.f222c = i10;
                this.f604g.f223d = i9;
                int i11 = this.f604g.f222c;
                i7 = this.f604g.f223d;
                i8 = i11;
            }
            this.f607j.f629j = this.f604g;
            this.f607j.f623d = i4;
            this.f607j.f620a = this.f599b;
            this.f607j.f627h = i5;
            this.f607j.f628i = i6;
            this.f607j.f625f = this.f601d;
            this.f607j.f626g = this.f602e;
            if (this.f607j.f625f <= 0 || this.f607j.f626g <= 0) {
                if (90 == this.f607j.f623d || 270 == this.f607j.f623d) {
                    this.f607j.f625f = i7;
                    this.f607j.f626g = i8;
                } else {
                    this.f607j.f625f = i8;
                    this.f607j.f626g = i7;
                }
            }
            if (this.l == EnumC0157d.MODE_SAME_AS_OUTPUT) {
                if (90 == this.f607j.f623d || 270 == this.f607j.f623d) {
                    i8 = this.f607j.f626g;
                    i7 = this.f607j.f625f;
                } else {
                    i8 = this.f607j.f625f;
                    i7 = this.f607j.f626g;
                }
            } else if (this.l != EnumC0157d.MODE_SAME_AS_INPUT) {
                com.tencent.liteav.basic.util.d b2 = b(i8, i7, this.f607j.f623d, this.f607j.f625f, this.f607j.f626g);
                i8 = ((b2.f460a + 7) / 8) * 8;
                i7 = ((b2.f461b + 7) / 8) * 8;
            }
            this.f607j.f624e = this.f600c;
            if (!a(this.f607j, i8, i7)) {
                TXCLog.e("TXCVideoPreprocessor", "init failed!");
                AppMethodBeat.o(221528);
                return false;
            }
        } else if (!(i5 == this.f607j.f627h && i6 == this.f607j.f628i)) {
            this.f607j.f627h = i5;
            this.f606i.k = i5;
            this.f607j.f628i = i6;
            this.f606i.l = i6;
            this.f605h.b(i6);
        }
        AppMethodBeat.o(221528);
        return true;
    }

    private com.tencent.liteav.basic.util.d b(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        AppMethodBeat.i(221529);
        if (i4 == 90 || i4 == 270) {
            i8 = i5;
            i7 = i6;
        } else {
            i8 = i6;
            i7 = i5;
        }
        int min = Math.min(i7, i8);
        int min2 = Math.min(i2, i3);
        int[] iArr = {TAVExporter.VIDEO_EXPORT_WIDTH, 1080, TAVExporter.VIDEO_EXPORT_HEIGHT};
        for (int i9 = 0; i9 < 3; i9++) {
            int i10 = iArr[i9];
            if (min <= i10 && min2 >= i10) {
                float f2 = (1.0f * ((float) i10)) / ((float) min);
                com.tencent.liteav.basic.util.d dVar = new com.tencent.liteav.basic.util.d((int) (((float) i7) * f2), (int) (((float) i8) * f2));
                AppMethodBeat.o(221529);
                return dVar;
            }
        }
        com.tencent.liteav.basic.util.d dVar2 = new com.tencent.liteav.basic.util.d(i2, i3);
        AppMethodBeat.o(221529);
        return dVar2;
    }

    private boolean a(c cVar, int i2, int i3) {
        AppMethodBeat.i(221530);
        this.f606i.f613d = cVar.f621b;
        this.f606i.f614e = cVar.f622c;
        this.f606i.m = cVar.f629j;
        this.f606i.f616g = i2;
        this.f606i.f615f = i3;
        this.f606i.f617h = (cVar.f623d + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.f606i.f611b = cVar.f625f;
        this.f606i.f612c = cVar.f626g;
        this.f606i.f610a = 0;
        this.f606i.f619j = cVar.f620a;
        this.f606i.f618i = cVar.f624e;
        this.f606i.k = cVar.f627h;
        this.f606i.l = cVar.f628i;
        if (this.f605h == null) {
            this.f605h = new c(this.f598a, cVar.f620a);
            this.f605h.a(this.f603f);
        }
        boolean a2 = this.f605h.a(this.f606i);
        AppMethodBeat.o(221530);
        return a2;
    }

    public void a(int i2) {
        AppMethodBeat.i(221531);
        if (i2 != this.f603f) {
            this.f603f = i2;
            if (this.f605h != null) {
                this.f605h.a(this.f603f);
            }
        }
        AppMethodBeat.o(221531);
    }

    public synchronized void b() {
        AppMethodBeat.i(221532);
        if (this.f605h != null) {
            this.f605h.a();
        }
        this.f607j = null;
        AppMethodBeat.o(221532);
    }

    public synchronized void b(int i2) {
        AppMethodBeat.i(221533);
        if (this.f605h != null) {
            this.f605h.d(i2);
        }
        this.q.a("beautyStyle", i2);
        AppMethodBeat.o(221533);
    }

    public synchronized void c(int i2) {
        AppMethodBeat.i(221534);
        if (i2 > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
            i2 = 9;
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
            i2 = 0;
        }
        if (this.f605h != null) {
            this.f605h.c(i2);
        }
        this.q.a("beautyLevel", i2);
        AppMethodBeat.o(221534);
    }

    public synchronized void d(int i2) {
        AppMethodBeat.i(221535);
        if (i2 > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i2 = 9;
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i2 = 0;
        }
        if (this.f605h != null) {
            this.f605h.e(i2);
        }
        this.q.a("whiteLevel", i2);
        AppMethodBeat.o(221535);
    }

    public synchronized void e(int i2) {
        AppMethodBeat.i(221536);
        if (i2 > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
            i2 = 9;
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
            i2 = 0;
        }
        if (this.f605h != null) {
            this.f605h.g(i2);
        }
        this.q.a("ruddyLevel", i2);
        AppMethodBeat.o(221536);
    }

    public void f(int i2) {
        AppMethodBeat.i(221537);
        if (i2 > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i2 = 9;
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i2 = 0;
        }
        if (this.f605h != null) {
            this.f605h.f(i2);
        }
        AppMethodBeat.o(221537);
    }

    public synchronized void a(String str) {
        AppMethodBeat.i(221538);
        if (this.f605h != null) {
            this.f605h.a(str);
        }
        AppMethodBeat.o(221538);
    }

    public synchronized void c(boolean z) {
        AppMethodBeat.i(221539);
        if (this.f605h != null) {
            this.f605h.b(z);
        }
        AppMethodBeat.o(221539);
    }

    @TargetApi(18)
    public boolean a(String str, boolean z) {
        AppMethodBeat.i(221540);
        if (Build.VERSION.SDK_INT < 18) {
            AppMethodBeat.o(221540);
            return false;
        }
        if (this.f605h != null) {
            this.f605h.a(str, z);
        }
        AppMethodBeat.o(221540);
        return true;
    }

    public synchronized void g(int i2) {
        AppMethodBeat.i(221541);
        if (this.f605h != null) {
            this.f605h.h(i2);
        }
        this.q.a("eyeBigScale", i2);
        AppMethodBeat.o(221541);
    }

    public synchronized void h(int i2) {
        AppMethodBeat.i(221542);
        if (this.f605h != null) {
            this.f605h.i(i2);
        }
        this.q.a("faceSlimLevel", i2);
        AppMethodBeat.o(221542);
    }

    public void i(int i2) {
        AppMethodBeat.i(221543);
        if (this.f605h != null) {
            this.f605h.j(i2);
        }
        this.q.a("faceVLevel", i2);
        AppMethodBeat.o(221543);
    }

    public void j(int i2) {
        AppMethodBeat.i(221544);
        if (this.f605h != null) {
            this.f605h.k(i2);
        }
        this.q.a("faceShortLevel", i2);
        AppMethodBeat.o(221544);
    }

    public void k(int i2) {
        AppMethodBeat.i(221545);
        if (this.f605h != null) {
            this.f605h.l(i2);
        }
        this.q.a("chinLevel", i2);
        AppMethodBeat.o(221545);
    }

    public void l(int i2) {
        AppMethodBeat.i(221546);
        if (this.f605h != null) {
            this.f605h.m(i2);
        }
        this.q.a("noseSlimLevel", i2);
        AppMethodBeat.o(221546);
    }

    public void m(int i2) {
        AppMethodBeat.i(221547);
        if (this.f605h != null) {
            this.f605h.n(i2);
        }
        this.q.a("eyeLightenLevel", i2);
        AppMethodBeat.o(221547);
    }

    public void n(int i2) {
        AppMethodBeat.i(221548);
        if (this.f605h != null) {
            this.f605h.o(i2);
        }
        this.q.a("toothWhitenLevel", i2);
        AppMethodBeat.o(221548);
    }

    public void o(int i2) {
        AppMethodBeat.i(221549);
        if (this.f605h != null) {
            this.f605h.p(i2);
        }
        this.q.a("wrinkleRemoveLevel", i2);
        AppMethodBeat.o(221549);
    }

    public void p(int i2) {
        AppMethodBeat.i(221550);
        if (this.f605h != null) {
            this.f605h.q(i2);
        }
        this.q.a("pounchRemoveLevel", i2);
        AppMethodBeat.o(221550);
    }

    public void q(int i2) {
        AppMethodBeat.i(221551);
        if (this.f605h != null) {
            this.f605h.r(i2);
        }
        this.q.a("smileLinesRemoveLevel", i2);
        AppMethodBeat.o(221551);
    }

    public void r(int i2) {
        AppMethodBeat.i(221552);
        if (this.f605h != null) {
            this.f605h.s(i2);
        }
        this.q.a("foreheadLevel", i2);
        AppMethodBeat.o(221552);
    }

    public void s(int i2) {
        AppMethodBeat.i(221553);
        if (this.f605h != null) {
            this.f605h.t(i2);
        }
        this.q.a("eyeDistanceLevel", i2);
        AppMethodBeat.o(221553);
    }

    public void t(int i2) {
        AppMethodBeat.i(221554);
        if (this.f605h != null) {
            this.f605h.u(i2);
        }
        this.q.a("eyeAngleLevel", i2);
        AppMethodBeat.o(221554);
    }

    public void u(int i2) {
        AppMethodBeat.i(221555);
        if (this.f605h != null) {
            this.f605h.v(i2);
        }
        this.q.a("mouthShapeLevel", i2);
        AppMethodBeat.o(221555);
    }

    public void v(int i2) {
        AppMethodBeat.i(221556);
        if (this.f605h != null) {
            this.f605h.w(i2);
        }
        this.q.a("noseWingLevel", i2);
        AppMethodBeat.o(221556);
    }

    public void w(int i2) {
        AppMethodBeat.i(221557);
        if (this.f605h != null) {
            this.f605h.x(i2);
        }
        this.q.a("nosePositionLevel", i2);
        AppMethodBeat.o(221557);
    }

    public void x(int i2) {
        AppMethodBeat.i(221558);
        if (this.f605h != null) {
            this.f605h.y(i2);
        }
        this.q.a("lipsThicknessLevel", i2);
        AppMethodBeat.o(221558);
    }

    public void y(int i2) {
        AppMethodBeat.i(221559);
        if (this.f605h != null) {
            this.f605h.z(i2);
        }
        this.q.a("faceBeautyLevel", i2);
        AppMethodBeat.o(221559);
    }

    public synchronized void a(float f2) {
        AppMethodBeat.i(221560);
        if (this.f605h != null) {
            this.f605h.a(f2);
        }
        AppMethodBeat.o(221560);
    }

    public synchronized void a(Bitmap bitmap) {
        AppMethodBeat.i(221561);
        if (this.f605h != null) {
            this.f605h.a(bitmap);
        }
        AppMethodBeat.o(221561);
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(221562);
        super.setID(str);
        setStatusValue(3001, this.q.a());
        AppMethodBeat.o(221562);
    }

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<d> f608a;

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, String> f609b = new HashMap<>();

        public a(d dVar) {
            AppMethodBeat.i(221508);
            this.f608a = new WeakReference<>(dVar);
            AppMethodBeat.o(221508);
        }

        public void a(String str, int i2) {
            String id;
            AppMethodBeat.i(221509);
            this.f609b.put(str, String.valueOf(i2));
            d dVar = this.f608a.get();
            if (!(dVar == null || (id = dVar.getID()) == null || id.length() <= 0)) {
                dVar.setStatusValue(3001, a());
            }
            AppMethodBeat.o(221509);
        }

        public String a() {
            AppMethodBeat.i(221510);
            String str = "";
            for (String str2 : this.f609b.keySet()) {
                str = str + str2 + ":" + this.f609b.get(str2) + " ";
            }
            String str3 = "{" + str + "}";
            AppMethodBeat.o(221510);
            return str3;
        }
    }
}

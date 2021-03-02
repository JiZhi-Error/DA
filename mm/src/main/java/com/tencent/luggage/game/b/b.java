package com.tencent.luggage.game.b;

import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.a.c;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.f.h;
import com.tencent.luggage.a.e;
import com.tencent.luggage.game.b.a.c;
import com.tencent.luggage.game.c.e;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class b implements IImageDecodeService.b {
    public static final b cux = new b();
    private final int cuv = 2048;
    private final int cuw = 2048;
    private boolean cuy;
    private WeakReference<com.tencent.luggage.game.d.a.a.b> cuz = null;

    /* renamed from: com.tencent.luggage.game.b.b$b  reason: collision with other inner class name */
    public static final class C0168b implements c.b {
        private int cuC = 14883;
    }

    static {
        AppMethodBeat.i(130469);
        AppMethodBeat.o(130469);
    }

    protected b() {
    }

    public final void a(MBRuntime mBRuntime, AppBrandRuntime appBrandRuntime, boolean z) {
        AppMethodBeat.i(130465);
        this.cuy = z;
        Log.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
        this.cuz = new WeakReference<>((!z || appBrandRuntime == null || !(appBrandRuntime.NY() instanceof d)) ? null : (com.tencent.luggage.game.d.a.a.b) ((d) appBrandRuntime.NY()).S(com.tencent.luggage.game.d.a.a.b.class));
        BaseImageDecodeService Rg = mBRuntime.Rg();
        a aVar = new a(appBrandRuntime, (byte) 0);
        Rg.addImageStreamFetcher(new com.tencent.luggage.game.b.a.a(aVar), true);
        Rg.addImageStreamFetcher(new com.tencent.luggage.game.b.a.b(aVar), false);
        Rg.setKvReportDelegate(new C0168b());
        com.tencent.magicbrush.b.a aVar2 = new com.tencent.magicbrush.b.a();
        aVar2.aW(2048, 2048);
        Rg.setBitmapDecodeSlave(aVar2);
        Rg.addDecodeEventListener(this);
        AppMethodBeat.o(130465);
    }

    /* access modifiers changed from: package-private */
    public static class a implements c.b, c.AbstractC0167c {
        private final WeakReference<AppBrandRuntime> cuB;

        /* synthetic */ a(AppBrandRuntime appBrandRuntime, byte b2) {
            this(appBrandRuntime);
        }

        private a(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(222859);
            this.cuB = new WeakReference<>(appBrandRuntime);
            AppMethodBeat.o(222859);
        }

        @Override // com.tencent.luggage.game.b.a.c.a
        public final String LR() {
            AppMethodBeat.i(222860);
            if (this.cuB.get() != null) {
                String str = this.cuB.get().mAppId;
                AppMethodBeat.o(222860);
                return str;
            }
            AppMethodBeat.o(222860);
            return "";
        }

        @Override // com.tencent.luggage.game.b.a.c.b
        public final q getFileSystem() {
            AppMethodBeat.i(222861);
            if (this.cuB.get() != null) {
                q fileSystem = this.cuB.get().getFileSystem();
                AppMethodBeat.o(222861);
                return fileSystem;
            }
            AppMethodBeat.o(222861);
            return null;
        }

        @Override // com.tencent.luggage.game.b.a.c.AbstractC0167c
        public final int LS() {
            AppMethodBeat.i(222862);
            int LT = LT();
            AppMethodBeat.o(222862);
            return LT;
        }

        private int LT() {
            AppMethodBeat.i(222863);
            AppBrandRuntime appBrandRuntime = this.cuB.get();
            if (appBrandRuntime == null) {
                AppMethodBeat.o(222863);
                return 0;
            }
            com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) appBrandRuntime.av(com.tencent.mm.plugin.appbrand.s.a.class);
            if (aVar == null) {
                AppMethodBeat.o(222863);
                return 0;
            }
            int i2 = aVar.nhH;
            AppMethodBeat.o(222863);
            return i2;
        }

        @Override // com.tencent.luggage.game.b.a.c.AbstractC0167c
        public final int LU() {
            AppMethodBeat.i(222864);
            int LT = LT();
            AppMethodBeat.o(222864);
            return LT;
        }

        @Override // com.tencent.luggage.game.b.a.c.AbstractC0167c
        public final String getUserAgentString() {
            AppMethodBeat.i(222865);
            AppBrandRuntime appBrandRuntime = this.cuB.get();
            if (appBrandRuntime == null) {
                AppMethodBeat.o(222865);
                return "";
            }
            com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) appBrandRuntime.av(com.tencent.mm.plugin.appbrand.s.a.class);
            if (aVar == null) {
                AppMethodBeat.o(222865);
                return "";
            }
            String str = aVar.nhM;
            AppMethodBeat.o(222865);
            return str;
        }

        @Override // com.tencent.luggage.game.b.a.c.AbstractC0167c
        public final String a(ImageDecodeConfig.ReferrerPolicy referrerPolicy) {
            String str;
            AppMethodBeat.i(222866);
            AppBrandRuntime appBrandRuntime = this.cuB.get();
            if (appBrandRuntime != null) {
                com.tencent.mm.plugin.appbrand.jsapi.u.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.u.a) e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
                if (aVar != null) {
                    if (referrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
                        referrerPolicy = a(aVar.x(appBrandRuntime.NY()));
                    }
                    if (referrerPolicy == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
                        referrerPolicy = a(aVar.bIw());
                    }
                    if (referrerPolicy == ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
                        str = aVar.y(appBrandRuntime.NY());
                        AppMethodBeat.o(222866);
                        return str;
                    }
                } else {
                    Log.w("MicroMsg.ImageFetcherConfigImp", "referrer helper is null");
                }
            }
            str = null;
            AppMethodBeat.o(222866);
            return str;
        }

        private static ImageDecodeConfig.ReferrerPolicy a(com.tencent.mm.plugin.appbrand.jsapi.u.c cVar) {
            if (cVar == null) {
                return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
            }
            if (cVar == com.tencent.mm.plugin.appbrand.jsapi.u.c.NO_REFERRER) {
                return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
            }
            if (cVar == com.tencent.mm.plugin.appbrand.jsapi.u.c.ORIGIN) {
                return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
            }
            return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
    public final void a(String str, IImageDecodeService.b.a aVar, com.github.henryye.nativeiv.api.a aVar2) {
        AppMethodBeat.i(130466);
        switch (aVar) {
            case OK:
                com.tencent.luggage.game.e.a Nn = com.tencent.luggage.game.e.a.Nn();
                long j2 = aVar2.baM;
                long j3 = aVar2.baN;
                h.RTc.aX(new Runnable(j2) {
                    /* class com.tencent.luggage.game.e.a.AnonymousClass4 */
                    final /* synthetic */ long cxK;

                    {
                        this.cxK = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(130693);
                        if (this.cxK <= 0) {
                            AppMethodBeat.o(130693);
                            return;
                        }
                        synchronized (a.this.cxG) {
                            try {
                                if (this.cxK < 5120) {
                                    if (a.this.cxG.hM(0)) {
                                        a.this.cxG.put(0, a.this.cxG.get(0) + 1);
                                    } else {
                                        a.this.cxG.put(0, 1);
                                    }
                                } else if (this.cxK < 10240) {
                                    if (a.this.cxG.hM(1)) {
                                        a.this.cxG.put(1, a.this.cxG.get(1) + 1);
                                    } else {
                                        a.this.cxG.put(1, 1);
                                    }
                                } else if (this.cxK < 20480) {
                                    if (a.this.cxG.hM(2)) {
                                        a.this.cxG.put(2, a.this.cxG.get(2) + 1);
                                    } else {
                                        a.this.cxG.put(2, 1);
                                    }
                                } else if (this.cxK < 51200) {
                                    if (a.this.cxG.hM(3)) {
                                        a.this.cxG.put(3, a.this.cxG.get(3) + 1);
                                    } else {
                                        a.this.cxG.put(3, 1);
                                    }
                                } else if (this.cxK < 102400) {
                                    if (a.this.cxG.hM(4)) {
                                        a.this.cxG.put(4, a.this.cxG.get(4) + 1);
                                    } else {
                                        a.this.cxG.put(4, 1);
                                    }
                                } else if (this.cxK < 153600) {
                                    if (a.this.cxG.hM(5)) {
                                        a.this.cxG.put(5, a.this.cxG.get(5) + 1);
                                    } else {
                                        a.this.cxG.put(5, 1);
                                    }
                                } else if (this.cxK < 204800) {
                                    if (a.this.cxG.hM(6)) {
                                        a.this.cxG.put(6, a.this.cxG.get(6) + 1);
                                    } else {
                                        a.this.cxG.put(6, 1);
                                    }
                                } else if (this.cxK < 512000) {
                                    if (a.this.cxG.hM(7)) {
                                        a.this.cxG.put(7, a.this.cxG.get(7) + 1);
                                    } else {
                                        a.this.cxG.put(7, 1);
                                    }
                                } else if (this.cxK < 1048576) {
                                    if (a.this.cxG.hM(8)) {
                                        a.this.cxG.put(8, a.this.cxG.get(8) + 1);
                                    } else {
                                        a.this.cxG.put(8, 1);
                                    }
                                } else if (this.cxK < 2097152) {
                                    if (a.this.cxG.hM(9)) {
                                        a.this.cxG.put(9, a.this.cxG.get(9) + 1);
                                    } else {
                                        a.this.cxG.put(9, 1);
                                    }
                                } else if (this.cxK < 3145728) {
                                    if (a.this.cxG.hM(10)) {
                                        a.this.cxG.put(10, a.this.cxG.get(10) + 1);
                                    } else {
                                        a.this.cxG.put(10, 1);
                                    }
                                } else if (a.this.cxG.hM(11)) {
                                    a.this.cxG.put(11, a.this.cxG.get(11) + 1);
                                } else {
                                    a.this.cxG.put(11, 1);
                                }
                            } finally {
                                AppMethodBeat.o(130693);
                            }
                        }
                    }
                });
                Nn.cxF.add(Long.valueOf(j3));
                h.RTc.aX(new Runnable(str, aVar2) {
                    /* class com.tencent.luggage.game.e.a.AnonymousClass6 */
                    final /* synthetic */ com.github.henryye.nativeiv.api.a cxL;
                    final /* synthetic */ String val$path;

                    {
                        this.val$path = r2;
                        this.cxL = r3;
                    }

                    public final void run() {
                        AppMethodBeat.i(130695);
                        synchronized (a.this.cxA) {
                            try {
                                if (a.this.cxB && !a.this.cxA.contains(this.val$path) && this.cxL != null) {
                                    if (a.this.cxC != 0) {
                                        if (a.this.cxA.size() < a.this.cxC) {
                                            Log.d("MicroMsg.MBNiReporter", "reportDecodeInfo mMaxSampleNum report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", Integer.valueOf(a.this.cxA.size()), this.cxL.baO, a.this.appId, Integer.valueOf(a.this.cxE), Long.valueOf(this.cxL.baM), Long.valueOf(this.cxL.mHeight), Long.valueOf(this.cxL.mWidth));
                                            a.a(a.this, this.val$path, this.cxL);
                                        }
                                    } else if (Math.random() < a.this.cxD) {
                                        Log.d("MicroMsg.MBNiReporter", "reportDecodeInfo mSampleRate report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", Integer.valueOf(a.this.cxA.size()), this.cxL.baO, a.this.appId, Integer.valueOf(a.this.cxE), Long.valueOf(this.cxL.baM), Long.valueOf(this.cxL.mHeight), Long.valueOf(this.cxL.mWidth));
                                        a.a(a.this, this.val$path, this.cxL);
                                    }
                                }
                            } finally {
                                AppMethodBeat.o(130695);
                            }
                        }
                    }
                });
                if (aVar2.baN >= 1000) {
                    hG(11);
                    AppMethodBeat.o(130466);
                    return;
                }
                break;
            case NOT_EXIST:
                if (TextUtils.isEmpty(aVar2.baP)) {
                    a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0y));
                } else {
                    a(str, e.a.ERROR, String.format("%s: %s", MMApplicationContext.getContext().getString(R.string.a0y), aVar2.baP));
                }
                hG(7);
                AppMethodBeat.o(130466);
                return;
            case PRE_DECODE_ERROR:
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0z));
                hG(5);
                AppMethodBeat.o(130466);
                return;
            case UNSUPPORTED_IMG_FORMAT:
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0u));
                hG(0);
                AppMethodBeat.o(130466);
                return;
            case HUGE_SIZE:
                a(str, e.a.ERROR, String.format(MMApplicationContext.getContext().getString(R.string.a10), Integer.valueOf(aVar2.mMaxWidth), Integer.valueOf(aVar2.mMaxHeight), Long.valueOf(aVar2.mWidth), Long.valueOf(aVar2.mHeight)));
                hG(3);
                AppMethodBeat.o(130466);
                return;
            case IO_ERROR:
                Log.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", str);
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0v));
                hG(4);
                AppMethodBeat.o(130466);
                return;
            case OUT_OF_MEMORY:
                Log.e("MicroMsg.MBImageHandlerRegistry", "OUT_OF_MEMORY path:%s", str);
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0w));
                hG(1);
                AppMethodBeat.o(130466);
                return;
            case NATIVE_DECODE_ERROR:
                Log.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", str);
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0r));
                hG(5);
                AppMethodBeat.o(130466);
                return;
            case THROW_EXCEPTION:
                Log.e("MicroMsg.MBImageHandlerRegistry", "THROW_EXCEPTION path:%s", str);
                a(str, e.a.ERROR, MMApplicationContext.getContext().getString(R.string.a0x));
                hG(16);
                AppMethodBeat.o(130466);
                return;
            case LEGACY_MODE:
                Log.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", str);
                hG(8);
                break;
        }
        AppMethodBeat.o(130466);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
    public final void a(String str, Object obj, IImageDecodeService.c cVar, ImageDecodeConfig imageDecodeConfig) {
    }

    private void a(String str, e.a aVar, String str2) {
        AppMethodBeat.i(130467);
        if (this.cuz.get() != null) {
            this.cuz.get().Mg().a(aVar, str + ": " + str2);
        }
        AppMethodBeat.o(130467);
    }

    private static void hG(int i2) {
        AppMethodBeat.i(130468);
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(807, (long) i2, 1, false);
        AppMethodBeat.o(130468);
    }
}

package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a.a;
import com.tencent.tbs.one.impl.a.a.d;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.c;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.common.g;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public String f2490a;

    /* renamed from: b  reason: collision with root package name */
    public h f2491b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<TBSOneCallback<File>> f2492c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TBSOneCallback<TBSOneComponent>> f2493d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2494e;

    /* renamed from: f  reason: collision with root package name */
    d.a f2495f;

    /* renamed from: g  reason: collision with root package name */
    public int f2496g;

    /* renamed from: h  reason: collision with root package name */
    int f2497h;

    /* renamed from: i  reason: collision with root package name */
    int f2498i;

    /* renamed from: j  reason: collision with root package name */
    String f2499j;
    public File k;
    public a l;
    private e m;
    private Map<String, ClassLoader> n;

    public b(h hVar, String str) {
        AppMethodBeat.i(173830);
        this.f2490a = str;
        this.f2491b = hVar;
        AppMethodBeat.o(173830);
    }

    private File a(String str) {
        String shouldOverrideFilePath;
        AppMethodBeat.i(173837);
        if (this.f2491b.b()) {
            TBSOneDelegate tBSOneDelegate = this.f2491b.f2758f;
            if (tBSOneDelegate == null || (shouldOverrideFilePath = tBSOneDelegate.shouldOverrideFilePath(this.f2491b.f2754b, this.f2490a, this.f2495f.f2560c, str)) == null) {
                File a2 = f.a(f.a(this.f2491b.f2753a), this.f2490a, str);
                AppMethodBeat.o(173837);
                return a2;
            }
            File file = new File(shouldOverrideFilePath);
            AppMethodBeat.o(173837);
            return file;
        }
        File file2 = new File(this.k, str);
        if (!file2.exists()) {
            com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s in installation directory", file2.getAbsolutePath());
        }
        AppMethodBeat.o(173837);
        return file2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.ClassLoader a(android.content.Context r18, java.lang.String r19) {
        /*
        // Method dump skipped, instructions count: 661
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.c.b.a(android.content.Context, java.lang.String):java.lang.ClassLoader");
    }

    private void a(a aVar) {
        AppMethodBeat.i(173843);
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished loading component %s", this.f2491b.f2754b, this.f2490a, aVar);
        this.l = aVar;
        int i2 = this.f2496g;
        this.f2496g = 100;
        TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f2493d.toArray(new TBSOneCallback[0]);
        this.f2493d.clear();
        for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
            tBSOneCallback.onProgressChanged(i2, 100);
            tBSOneCallback.onCompleted(aVar);
        }
        AppMethodBeat.o(173843);
    }

    static /* synthetic */ void a(b bVar, final int i2, final int i3, final float f2) {
        AppMethodBeat.i(173845);
        if (!m.b()) {
            m.b(new Runnable() {
                /* class com.tencent.tbs.one.impl.c.b.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(173884);
                    b.a(b.this, i2, i3, f2);
                    AppMethodBeat.o(173884);
                }
            });
            AppMethodBeat.o(173845);
            return;
        }
        int min = Math.min(Math.max(0, i2), 100);
        int min2 = Math.min(Math.max(0, i3), 100);
        int i4 = bVar.f2497h;
        int i5 = (int) ((((float) (min2 - min)) * f2) + ((float) i4));
        Object[] objArr = {bVar.f2491b.f2754b, bVar.f2490a, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
        bVar.f2497h = i5;
        bVar.a(i5, 20, 90);
        AppMethodBeat.o(173845);
    }

    private String b(String str) {
        TBSOneDelegate tBSOneDelegate;
        String shouldOverrideLibrarySearchPath;
        AppMethodBeat.i(173839);
        String join = TextUtils.join(File.pathSeparator, d());
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Collected librarySearchPath %s", this.f2491b.f2754b, this.f2490a, join);
        if (!this.f2491b.b() || (tBSOneDelegate = this.f2491b.f2758f) == null || (shouldOverrideLibrarySearchPath = tBSOneDelegate.shouldOverrideLibrarySearchPath(this.f2491b.f2754b, this.f2490a, this.f2495f.f2560c, str, join)) == null) {
            AppMethodBeat.o(173839);
            return join;
        }
        AppMethodBeat.o(173839);
        return shouldOverrideLibrarySearchPath;
    }

    private static ClassLoader c() {
        AppMethodBeat.i(188040);
        try {
            Method method = Class.forName("dalvik.system.VMStack").getMethod("getCallingClassLoader", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke instanceof ClassLoader) {
                ClassLoader classLoader = (ClassLoader) invoke;
                AppMethodBeat.o(188040);
                return classLoader;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(188040);
        return null;
    }

    private Set<String> d() {
        AppMethodBeat.i(188041);
        HashSet hashSet = new HashSet();
        hashSet.add(this.k.getAbsolutePath());
        String[] strArr = this.f2495f.f2563f;
        if (strArr != null) {
            for (String str : strArr) {
                hashSet.addAll(this.f2491b.d(str).d());
            }
        }
        AppMethodBeat.o(188041);
        return hashSet;
    }

    @Override // com.tencent.tbs.one.impl.a.a.d.a
    public final void a() {
        AppMethodBeat.i(173834);
        final String str = this.f2490a;
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing component and dependencies", this.f2491b.f2754b, str);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(173879);
                if (b.this.f2495f == null) {
                    String str = b.this.f2490a;
                    com.tencent.tbs.one.impl.a.f.c("[%s] {%s} Unknown error, finished installing component and dependencies but config is null, last error: [%d] %s", b.this.f2491b.f2754b, str, Integer.valueOf(b.this.f2498i), b.this.f2499j);
                    com.tencent.tbs.one.impl.common.d dVar = b.this.f2491b.f2760h;
                    com.tencent.tbs.one.impl.common.h.a(dVar != null ? dVar.f2555a : -1, str, -1, 101, String.format(Locale.US, "ComponentConfig is null, last error: [%d] %s", Integer.valueOf(b.this.f2498i), b.this.f2499j), null);
                    AppMethodBeat.o(173879);
                    return;
                }
                b.this.a(90);
                File a2 = b.this.f2491b.a(str, b.this.f2495f.f2560c);
                b bVar = b.this;
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing component at %s", bVar.f2491b.f2754b, bVar.f2490a, a2.getAbsolutePath());
                bVar.k = a2;
                TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) bVar.f2492c.toArray(new TBSOneCallback[0]);
                bVar.f2492c.clear();
                for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
                    tBSOneCallback.onProgressChanged(bVar.f2496g, 100);
                    tBSOneCallback.onCompleted(a2);
                }
                if (b.this.f2493d.size() > 0) {
                    b.this.b();
                }
                AppMethodBeat.o(173879);
            }
        });
        AppMethodBeat.o(173834);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        AppMethodBeat.i(173842);
        Object[] objArr = {this.f2491b.f2754b, this.f2490a, Integer.valueOf(this.f2496g), Integer.valueOf(i2)};
        if (i2 - this.f2496g > 2) {
            int i3 = this.f2496g;
            this.f2496g = i2;
            TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f2492c.toArray(new TBSOneCallback[0]);
            TBSOneCallback[] tBSOneCallbackArr2 = (TBSOneCallback[]) this.f2493d.toArray(new TBSOneCallback[0]);
            for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
                tBSOneCallback.onProgressChanged(i3, i2);
            }
            for (TBSOneCallback tBSOneCallback2 : tBSOneCallbackArr2) {
                tBSOneCallback2.onProgressChanged(i3, i2);
            }
        }
        AppMethodBeat.o(173842);
    }

    public final void a(int i2, int i3, int i4) {
        AppMethodBeat.i(173841);
        a((int) (((((float) Math.min(Math.max(0, i2), 100)) / 100.0f) * ((float) (i4 - i3))) + ((float) i3)));
        AppMethodBeat.o(173841);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d.a
    public final void a(final int i2, final String str, final Throwable th) {
        AppMethodBeat.i(173833);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(173847);
                b.this.b(i2, str, th);
                AppMethodBeat.o(173847);
            }
        });
        AppMethodBeat.o(173833);
    }

    public final void a(final Bundle bundle) {
        AppMethodBeat.i(188039);
        String str = this.f2491b.f2754b;
        String str2 = this.f2490a;
        if (this.f2494e) {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Have started loading component", str, str2);
            AppMethodBeat.o(188039);
            return;
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loading DEPS", str, str2);
        this.f2494e = true;
        h hVar = this.f2491b;
        AnonymousClass1 r1 = new c<com.tencent.tbs.one.impl.common.d>() {
            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
            public final void a(int i2, int i3) {
                AppMethodBeat.i(173880);
                b.this.a(i3, 0, 20);
                AppMethodBeat.o(173880);
            }

            @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(173881);
                b.this.b(i2, str, th);
                AppMethodBeat.o(173881);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
            public final /* synthetic */ void a(com.tencent.tbs.one.impl.common.d dVar) {
                float f2;
                AppMethodBeat.i(173882);
                com.tencent.tbs.one.impl.common.d dVar2 = dVar;
                b bVar = b.this;
                Bundle bundle = bundle;
                bVar.a(20);
                String str = bVar.f2491b.f2754b;
                int i2 = dVar2.f2555a;
                String str2 = bVar.f2490a;
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished loading DEPS#%d", str, str2, Integer.valueOf(i2));
                d.a b2 = dVar2.b(str2);
                if (b2 == null) {
                    bVar.b(309, "Failed to get info for component ".concat(String.valueOf(str2)), null);
                    AppMethodBeat.o(173882);
                    return;
                }
                String[] strArr = b2.f2563f;
                if (strArr != null) {
                    for (String str3 : strArr) {
                        if (dVar2.b(str3) == null) {
                            bVar.b(TPNativePlayerInitConfig.INT_PIXEL_FORMAT, "Failed to get info for dependency ".concat(String.valueOf(str3)), null);
                            AppMethodBeat.o(173882);
                            return;
                        }
                    }
                    f2 = 1.0f / ((float) (strArr.length + 1));
                } else {
                    f2 = 1.0f;
                }
                bVar.f2495f = b2;
                bVar.f2497h = 0;
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = strArr == null ? "" : TextUtils.join(", ", strArr);
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Installing component and dependencies [%s]", objArr);
                a aVar = new a();
                aVar.b(new com.tencent.tbs.one.impl.a.a.b(bundle, b2, f2, str, str2) {
                    /* class com.tencent.tbs.one.impl.c.b.AnonymousClass2 */

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ Bundle f2502d;

                    /* renamed from: e  reason: collision with root package name */
                    final /* synthetic */ d.a f2503e;

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ float f2504f;

                    /* renamed from: g  reason: collision with root package name */
                    final /* synthetic */ String f2505g;

                    /* renamed from: h  reason: collision with root package name */
                    final /* synthetic */ String f2506h;

                    {
                        this.f2502d = r2;
                        this.f2503e = r3;
                        this.f2504f = r4;
                        this.f2505g = r5;
                        this.f2506h = r6;
                    }

                    @Override // com.tencent.tbs.one.impl.a.a.b
                    public final void a(final com.tencent.tbs.one.impl.a.a.c cVar) {
                        AppMethodBeat.i(173846);
                        m.a(new Runnable() {
                            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(173877);
                                b.this.f2491b.a(AnonymousClass2.this.f2502d, AnonymousClass2.this.f2503e, new l<com.tencent.tbs.one.impl.e.e<File>>() {
                                    /* class com.tencent.tbs.one.impl.c.b.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.tbs.one.impl.a.l
                                    public final void a(int i2, int i3) {
                                        AppMethodBeat.i(173871);
                                        b.a(b.this, i2, i3, AnonymousClass2.this.f2504f);
                                        AppMethodBeat.o(173871);
                                    }

                                    @Override // com.tencent.tbs.one.impl.a.l
                                    public final void a(int i2, String str, Throwable th) {
                                        AppMethodBeat.i(173872);
                                        cVar.a(i2, str, th);
                                        AppMethodBeat.o(173872);
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.tbs.one.impl.a.l
                                    public final /* synthetic */ void a(com.tencent.tbs.one.impl.e.e<File> eVar) {
                                        AppMethodBeat.i(173873);
                                        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing component itself from source %s", AnonymousClass2.this.f2505g, AnonymousClass2.this.f2506h, eVar.f2728a);
                                        cVar.c();
                                        AppMethodBeat.o(173873);
                                    }
                                });
                                AppMethodBeat.o(173877);
                            }
                        });
                        AppMethodBeat.o(173846);
                    }
                });
                h hVar = bVar.f2491b;
                if (strArr != null) {
                    for (String str4 : strArr) {
                        aVar.b(new com.tencent.tbs.one.impl.a.a.b(hVar, bundle, str4, f2, str, str2) {
                            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass3 */

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ h f2511d;

                            /* renamed from: e  reason: collision with root package name */
                            final /* synthetic */ Bundle f2512e;

                            /* renamed from: f  reason: collision with root package name */
                            final /* synthetic */ String f2513f;

                            /* renamed from: g  reason: collision with root package name */
                            final /* synthetic */ float f2514g;

                            /* renamed from: h  reason: collision with root package name */
                            final /* synthetic */ String f2515h;

                            /* renamed from: i  reason: collision with root package name */
                            final /* synthetic */ String f2516i;

                            {
                                this.f2511d = r2;
                                this.f2512e = r3;
                                this.f2513f = r4;
                                this.f2514g = r5;
                                this.f2515h = r6;
                                this.f2516i = r7;
                            }

                            @Override // com.tencent.tbs.one.impl.a.a.b
                            public final void a(final com.tencent.tbs.one.impl.a.a.c cVar) {
                                AppMethodBeat.i(173810);
                                m.a(new Runnable() {
                                    /* class com.tencent.tbs.one.impl.c.b.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(173878);
                                        AnonymousClass3.this.f2511d.a(AnonymousClass3.this.f2512e, AnonymousClass3.this.f2513f, new TBSOneCallback<File>() {
                                            /* class com.tencent.tbs.one.impl.c.b.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final /* synthetic */ void onCompleted(File file) {
                                                AppMethodBeat.i(173876);
                                                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished installing dependency %s", AnonymousClass3.this.f2515h, AnonymousClass3.this.f2516i, AnonymousClass3.this.f2513f);
                                                cVar.c();
                                                AppMethodBeat.o(173876);
                                            }

                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final void onError(int i2, String str) {
                                                AppMethodBeat.i(173875);
                                                cVar.a(i2, "Failed to install dependency " + AnonymousClass3.this.f2513f + ", caused by: " + str, null);
                                                AppMethodBeat.o(173875);
                                            }

                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final void onProgressChanged(int i2, int i3) {
                                                AppMethodBeat.i(173874);
                                                b.a(b.this, i2, i3, AnonymousClass3.this.f2514g);
                                                AppMethodBeat.o(173874);
                                            }
                                        });
                                        AppMethodBeat.o(173878);
                                    }
                                });
                                AppMethodBeat.o(173810);
                            }
                        });
                    }
                }
                com.tencent.tbs.one.impl.a.a.e eVar = new com.tencent.tbs.one.impl.a.a.e(AsyncTask.THREAD_POOL_EXECUTOR);
                eVar.f2343a = bVar;
                eVar.a(aVar);
                AppMethodBeat.o(173882);
            }
        };
        String str3 = hVar.f2754b;
        com.tencent.tbs.one.impl.a.f.a("[%s] Loading DEPS", str3);
        if (hVar.f2760h != null) {
            com.tencent.tbs.one.impl.a.f.a("[%s] Loaded DEPS#%d", str3, Integer.valueOf(hVar.f2760h.f2555a));
            r1.a(hVar.f2760h);
            AppMethodBeat.o(188039);
            return;
        }
        if (hVar.f2761i == null) {
            hVar.f2761i = new com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.common.d>(bundle) {
                /* class com.tencent.tbs.one.impl.e.h.AnonymousClass1 */

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Bundle f2763b;

                {
                    this.f2763b = r2;
                }

                @Override // com.tencent.tbs.one.impl.a.a
                public final void a() {
                    AppMethodBeat.i(174028);
                    h.this.a(this.f2763b, new c<e<com.tencent.tbs.one.impl.common.d>>() {
                        /* class com.tencent.tbs.one.impl.e.h.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                        public final void a(int i2, int i3) {
                            AppMethodBeat.i(174135);
                            AnonymousClass1.this.a(i3);
                            AppMethodBeat.o(174135);
                        }

                        @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                        public final void a(int i2, String str, Throwable th) {
                            AppMethodBeat.i(174136);
                            h.this.f2761i = null;
                            AnonymousClass1.this.a(i2, str, th);
                            AppMethodBeat.o(174136);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                        public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                            AppMethodBeat.i(174137);
                            e<com.tencent.tbs.one.impl.common.d> eVar2 = eVar;
                            h.this.f2761i = null;
                            h.this.a(eVar2);
                            AnonymousClass1.this.a((Object) eVar2.f2729b);
                            AppMethodBeat.o(174137);
                        }
                    });
                    AppMethodBeat.o(174028);
                }
            };
        }
        hVar.f2761i.a(r1);
        AppMethodBeat.o(188039);
    }

    public final void a(Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188038);
        if (this.k != null) {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Installed component at %s", this.f2491b.f2754b, this.f2490a, this.k);
            if (tBSOneCallback != null) {
                tBSOneCallback.onProgressChanged(0, 100);
                tBSOneCallback.onCompleted(this.k);
            }
            AppMethodBeat.o(188038);
            return;
        }
        if (tBSOneCallback != null) {
            tBSOneCallback.onProgressChanged(0, this.f2496g);
            this.f2492c.add(tBSOneCallback);
        }
        a(bundle);
        AppMethodBeat.o(188038);
    }

    public final void b() {
        AppMethodBeat.i(173832);
        String str = this.f2491b.f2754b;
        String str2 = this.f2490a;
        int i2 = this.f2495f.f2560c;
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Initializing component", str, str2);
        a aVar = new a(str2, this.f2495f.f2559b, i2, this.k);
        File a2 = a("MANIFEST");
        if (a2.exists()) {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Initializing component according to MANIFEST file %s", str, str2, a2.getAbsolutePath());
            try {
                this.m = e.a(a2);
                Pair<String, String>[] pairArr = this.m.f2569f;
                if (pairArr != null) {
                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Registering event receivers", str, str2, pairArr);
                    for (Pair<String, String> pair : pairArr) {
                        h hVar = this.f2491b;
                        g gVar = new g(str2, (String) pair.second, (String) pair.first);
                        String str3 = gVar.f2578c;
                        List<g> list = hVar.k.get(str3);
                        if (list == null) {
                            list = new ArrayList<>();
                            hVar.k.put(str3, list);
                        }
                        list.add(gVar);
                    }
                } else {
                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} No event receivers", str, str2);
                }
                Context context = this.f2491b.f2753a;
                String str4 = this.m.f2565b;
                com.tencent.tbs.one.impl.c.b.b bVar = null;
                if (!TextUtils.isEmpty(str4)) {
                    File a3 = a(str4);
                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Creating resource context %s from %s", str, str2, str4, a3.getAbsolutePath());
                    if (!a3.exists()) {
                        b(105, "Failed to find resource file " + a3.getAbsolutePath(), null);
                        AppMethodBeat.o(173832);
                        return;
                    }
                    bVar = new com.tencent.tbs.one.impl.c.b.b(context, a3.getAbsolutePath());
                    aVar.f2415a = bVar;
                } else {
                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} No resource file", str, str2);
                }
                String str5 = this.m.f2566c;
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        ClassLoader a4 = a(context, str5);
                        aVar.f2416b = a4;
                        String str6 = this.m.f2567d;
                        if (!TextUtils.isEmpty(str6)) {
                            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Constructing entry object %s", str, str2, str6);
                            HashMap hashMap = new HashMap();
                            hashMap.put("callerContext", context);
                            if (bVar != null) {
                                bVar.f2540a.f2533a = a4;
                                hashMap.put("resourcesContext", bVar);
                            }
                            hashMap.put("classLoader", a4);
                            hashMap.put("installationDirectory", this.k);
                            hashMap.put("optimizedDirectory", this.k);
                            hashMap.put("librarySearchPath", b(str5));
                            hashMap.put("versionName", this.f2495f.f2559b);
                            hashMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, Integer.valueOf(i2));
                            hashMap.put("eventEmitter", this.f2491b.l);
                            try {
                                aVar.f2417c = a4.loadClass(str6).getConstructor(Map.class).newInstance(hashMap);
                            } catch (ClassNotFoundException e2) {
                                b(405, "Failed to load entry class " + str6 + " in " + str5 + "\n" + Log.getStackTraceString(e2), null);
                                AppMethodBeat.o(173832);
                                return;
                            } catch (NoSuchMethodException e3) {
                                b(406, "Failed to find entry class " + str6 + " constructor in " + str5 + "\n" + Log.getStackTraceString(e3), null);
                                AppMethodBeat.o(173832);
                                return;
                            } catch (Exception e4) {
                                b(407, "Failed to construct the entry object with " + str6 + " in " + str5 + "\n" + Log.getStackTraceString(e4), null);
                                AppMethodBeat.o(173832);
                                return;
                            }
                        } else {
                            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} No entry class", str, str2);
                        }
                    } catch (TBSOneException e5) {
                        b(e5.getErrorCode(), e5.getMessage(), e5.getCause());
                        AppMethodBeat.o(173832);
                        return;
                    }
                } else {
                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} No entry dex file", str, str2);
                }
            } catch (TBSOneException e6) {
                b(e6.getErrorCode(), e6.getMessage(), e6.getCause());
                AppMethodBeat.o(173832);
                return;
            }
        } else {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} No MANIFEST file", str, str2);
        }
        a(aVar);
        AppMethodBeat.o(173832);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, String str, Throwable th) {
        int i3 = -1;
        AppMethodBeat.i(173844);
        String str2 = this.f2490a;
        com.tencent.tbs.one.impl.a.f.b("Failed to install or load component %s, error: [%d] %s", str2, Integer.valueOf(i2), str);
        com.tencent.tbs.one.impl.a.f.c("[%s] {%s} Failed to install or load component, error: [%d] %s", this.f2491b.f2754b, str2, Integer.valueOf(i2), str, th);
        com.tencent.tbs.one.impl.common.d dVar = this.f2491b.f2760h;
        int i4 = dVar != null ? dVar.f2555a : -1;
        if (this.f2495f != null) {
            i3 = this.f2495f.f2560c;
        }
        com.tencent.tbs.one.impl.common.h.a(i4, str2, i3, i2, str, th);
        this.f2498i = i2;
        this.f2499j = str;
        this.f2495f = null;
        this.m = null;
        this.k = null;
        this.l = null;
        this.f2496g = 0;
        this.f2494e = false;
        TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f2492c.toArray(new TBSOneCallback[0]);
        this.f2492c.clear();
        TBSOneCallback[] tBSOneCallbackArr2 = (TBSOneCallback[]) this.f2493d.toArray(new TBSOneCallback[0]);
        this.f2493d.clear();
        for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
            tBSOneCallback.onError(i2, str);
        }
        for (TBSOneCallback tBSOneCallback2 : tBSOneCallbackArr2) {
            tBSOneCallback2.onError(i2, str);
        }
        AppMethodBeat.o(173844);
    }
}

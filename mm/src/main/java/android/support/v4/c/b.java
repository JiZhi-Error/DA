package android.support.v4.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.c.c;
import android.support.v4.content.a.f;
import android.support.v4.e.h;
import android.support.v4.e.m;
import android.support.v4.e.n;
import android.support.v4.graphics.d;
import android.support.v4.graphics.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class b {
    static final h<String, Typeface> JW = new h<>(16);
    static final n<String, ArrayList<c.a<c>>> NA = new n<>();
    private static final Comparator<byte[]> NB = new Comparator<byte[]>() {
        /* class android.support.v4.c.b.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                return bArr3.length - bArr4.length;
            }
            for (int i2 = 0; i2 < bArr3.length; i2++) {
                if (bArr3[i2] != bArr4[i2]) {
                    return bArr3[i2] - bArr4[i2];
                }
            }
            return 0;
        }
    };
    private static final c Nz = new c("fonts");
    static final Object sLock = new Object();

    static c a(Context context, a aVar, int i2) {
        List<List<byte[]>> a2;
        ProviderInfo providerInfo;
        a aVar2;
        int i3;
        int i4 = -3;
        try {
            PackageManager packageManager = context.getPackageManager();
            Resources resources = context.getResources();
            String str = aVar.Nt;
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(str)));
            } else if (!resolveContentProvider.packageName.equals(aVar.Nu)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + aVar.Nu);
            } else {
                List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a3, NB);
                if (aVar.Nw != null) {
                    a2 = aVar.Nw;
                } else {
                    a2 = android.support.v4.content.a.c.a(resources, aVar.Nx);
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= a2.size()) {
                        providerInfo = null;
                        break;
                    }
                    ArrayList arrayList = new ArrayList(a2.get(i5));
                    Collections.sort(arrayList, NB);
                    if (b(a3, arrayList)) {
                        providerInfo = resolveContentProvider;
                        break;
                    }
                    i5++;
                }
                if (providerInfo == null) {
                    aVar2 = new a(1, null);
                } else {
                    aVar2 = new a(0, a(context, aVar, providerInfo.authority));
                }
                if (aVar2.mStatusCode == 0) {
                    Typeface a4 = d.a(context, aVar2.NF, i2);
                    if (a4 != null) {
                        i3 = 0;
                    } else {
                        i3 = -3;
                    }
                    return new c(a4, i3);
                }
                if (aVar2.mStatusCode == 1) {
                    i4 = -2;
                }
                return new c(null, i4);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            return new c(null, -1);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        final Typeface NG;
        final int NH;

        c(Typeface typeface, int i2) {
            this.NG = typeface;
            this.NH = i2;
        }
    }

    public static Typeface a(final Context context, final a aVar, final f.a aVar2, final Handler handler, boolean z, int i2, final int i3) {
        AnonymousClass2 r1;
        final String str = aVar.Ny + "-" + i3;
        Typeface typeface = JW.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.a(typeface);
            }
            return typeface;
        } else if (!z || i2 != -1) {
            AnonymousClass1 r4 = new Callable<c>() {
                /* class android.support.v4.c.b.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ c call() {
                    c a2 = b.a(context, aVar, i3);
                    if (a2.NG != null) {
                        b.JW.put(str, a2.NG);
                    }
                    return a2;
                }
            };
            if (z) {
                try {
                    return ((c) Nz.a(r4, i2)).NG;
                } catch (InterruptedException e2) {
                    return null;
                }
            } else {
                if (aVar2 == null) {
                    r1 = null;
                } else {
                    r1 = new c.a<c>() {
                        /* class android.support.v4.c.b.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // android.support.v4.c.c.a
                        public final /* synthetic */ void D(c cVar) {
                            c cVar2 = cVar;
                            if (cVar2 == null) {
                                aVar2.a(1, handler);
                            } else if (cVar2.NH == 0) {
                                aVar2.a(cVar2.NG, handler);
                            } else {
                                aVar2.a(cVar2.NH, handler);
                            }
                        }
                    };
                }
                synchronized (sLock) {
                    if (NA.containsKey(str)) {
                        if (r1 != null) {
                            NA.get(str).add(r1);
                        }
                        return null;
                    }
                    if (r1 != null) {
                        ArrayList<c.a<c>> arrayList = new ArrayList<>();
                        arrayList.add(r1);
                        NA.put(str, arrayList);
                    }
                    c cVar = Nz;
                    cVar.post(new Runnable(r4, new Handler(), new c.a<c>() {
                        /* class android.support.v4.c.b.AnonymousClass3 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
                            if (r1 >= r0.size()) goto L_0x0012;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
                            r0.get(r1).D(r5);
                            r1 = r1 + 1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
                            r1 = 0;
                         */
                        @Override // android.support.v4.c.c.a
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final /* synthetic */ void D(android.support.v4.c.b.c r5) {
                            /*
                                r4 = this;
                                android.support.v4.c.b$c r5 = (android.support.v4.c.b.c) r5
                                java.lang.Object r1 = android.support.v4.c.b.sLock
                                monitor-enter(r1)
                                android.support.v4.e.n<java.lang.String, java.util.ArrayList<android.support.v4.c.c$a<android.support.v4.c.b$c>>> r0 = android.support.v4.c.b.NA     // Catch:{ all -> 0x0030 }
                                java.lang.String r2 = r3     // Catch:{ all -> 0x0030 }
                                java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0030 }
                                java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0030 }
                                if (r0 != 0) goto L_0x0013
                                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                            L_0x0012:
                                return
                            L_0x0013:
                                android.support.v4.e.n<java.lang.String, java.util.ArrayList<android.support.v4.c.c$a<android.support.v4.c.b$c>>> r2 = android.support.v4.c.b.NA     // Catch:{ all -> 0x0030 }
                                java.lang.String r3 = r3     // Catch:{ all -> 0x0030 }
                                r2.remove(r3)     // Catch:{ all -> 0x0030 }
                                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                                r1 = 0
                                r2 = r1
                            L_0x001d:
                                int r1 = r0.size()
                                if (r2 >= r1) goto L_0x0012
                                java.lang.Object r1 = r0.get(r2)
                                android.support.v4.c.c$a r1 = (android.support.v4.c.c.a) r1
                                r1.D(r5)
                                int r1 = r2 + 1
                                r2 = r1
                                goto L_0x001d
                            L_0x0030:
                                r0 = move-exception
                                monitor-exit(r1)
                                throw r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.c.b.AnonymousClass3.D(java.lang.Object):void");
                        }
                    }) {
                        /* class android.support.v4.c.c.AnonymousClass2 */
                        final /* synthetic */ Handler NL;
                        final /* synthetic */ a NM;
                        final /* synthetic */ Callable val$callable;

                        {
                            this.val$callable = r2;
                            this.NL = r3;
                            this.NM = r4;
                        }

                        public final void run() {
                            final Object obj;
                            try {
                                obj = this.val$callable.call();
                            } catch (Exception e2) {
                                obj = null;
                            }
                            this.NL.post(new Runnable() {
                                /* class android.support.v4.c.c.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AnonymousClass2.this.NM.D(obj);
                                }
                            });
                        }
                    });
                    return null;
                }
            }
        } else {
            c a2 = a(context, aVar, i3);
            if (aVar2 != null) {
                if (a2.NH == 0) {
                    aVar2.a(a2.NG, handler);
                } else {
                    aVar2.a(a2.NH, handler);
                }
            }
            return a2.NG;
        }
    }

    /* renamed from: android.support.v4.c.b$b  reason: collision with other inner class name */
    public static class C0019b {
        public final int JF;
        public final boolean JG;
        public final int JI;
        final int mResultCode;
        public final Uri mUri;

        public C0019b(Uri uri, int i2, int i3, boolean z, int i4) {
            this.mUri = (Uri) m.checkNotNull(uri);
            this.JI = i2;
            this.JF = i3;
            this.JG = z;
            this.mResultCode = i4;
        }
    }

    public static class a {
        final C0019b[] NF;
        final int mStatusCode;

        public a(int i2, C0019b[] bVarArr) {
            this.mStatusCode = i2;
            this.NF = bVarArr;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0019b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0019b bVar : bVarArr) {
            if (bVar.mResultCode == 0) {
                Uri uri = bVar.mUri;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, j.a(context, (CancellationSignal) null, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.support.v4.c.b.C0019b[] a(android.content.Context r18, android.support.v4.c.a r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 367
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.c.b.a(android.content.Context, android.support.v4.c.a, java.lang.String):android.support.v4.c.b$b[]");
    }
}

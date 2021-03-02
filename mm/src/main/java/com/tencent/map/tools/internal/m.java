package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.spec.AlgorithmParameterSpec;
import java.util.zip.GZIPOutputStream;

public class m {

    /* renamed from: e  reason: collision with root package name */
    private static final String f1366e = m.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Context f1367a;

    /* renamed from: b  reason: collision with root package name */
    public ModuleUncaughtListener f1368b;

    /* renamed from: c  reason: collision with root package name */
    public File f1369c;

    /* renamed from: d  reason: collision with root package name */
    public n f1370d;

    /* renamed from: f  reason: collision with root package name */
    private DexClassLoader f1371f;

    /* renamed from: g  reason: collision with root package name */
    private h f1372g;

    /* renamed from: h  reason: collision with root package name */
    private j f1373h;

    /* renamed from: i  reason: collision with root package name */
    private i f1374i;

    /* renamed from: j  reason: collision with root package name */
    private ModuleEncryptListener f1375j = new ModuleEncryptListener() {
        /* class com.tencent.map.tools.internal.m.AnonymousClass1 */

        @Override // com.tencent.map.tools.sheet.listener.ModuleEncryptListener
        public final byte[] enCryptModleData(byte[] bArr) {
            AppMethodBeat.i(180819);
            byte[] a2 = m.a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep", t.G);
            AppMethodBeat.o(180819);
            return a2;
        }
    };

    static {
        AppMethodBeat.i(180825);
        AppMethodBeat.o(180825);
    }

    public m(Context context) {
        AppMethodBeat.i(180820);
        this.f1367a = context;
        this.f1372g = new h(context);
        this.f1373h = new j(context);
        this.f1374i = new i(context, g.a(context).f1338h);
        g.a(context).f1336f = this.f1375j;
        AppMethodBeat.o(180820);
    }

    public final synchronized DexClassLoader a() {
        boolean z;
        DexClassLoader dexClassLoader = null;
        synchronized (this) {
            AppMethodBeat.i(180821);
            if (this.f1371f != null) {
                dexClassLoader = this.f1371f;
                AppMethodBeat.o(180821);
            } else if (this.f1367a == null) {
                AppMethodBeat.o(180821);
            } else {
                v.a(this.f1367a).a("load");
                y.f1433a = System.currentTimeMillis();
                h hVar = this.f1372g;
                s.a(hVar.f1342a);
                x.a(hVar.f1342a, x.f1424a);
                x.a(hVar.f1342a, x.f1425b);
                x.a(hVar.f1342a, x.f1426c);
                String str = t.k;
                String b2 = x.b(hVar.f1342a, t.C, "");
                g.a(hVar.f1342a).a("DCV", b2 + "_" + str);
                if (!str.equals(b2)) {
                    z = l.a(hVar.f1342a, str);
                } else {
                    z = true;
                }
                if (!z) {
                    AppMethodBeat.o(180821);
                } else {
                    if (!this.f1372g.a()) {
                        l.a(this.f1367a, t.k);
                    }
                    this.f1371f = this.f1373h.a();
                    i iVar = this.f1374i;
                    iVar.f1346c = false;
                    q.a(iVar.f1345b, 10006, 0);
                    iVar.f1347d.startup(iVar.f1345b);
                    v.a(this.f1367a).b("load");
                    dexClassLoader = this.f1371f;
                    AppMethodBeat.o(180821);
                }
            }
        }
        return dexClassLoader;
    }

    public final synchronized int a(String str) {
        int i2 = 1;
        synchronized (this) {
            AppMethodBeat.i(180822);
            DexClassLoader a2 = a();
            if (a2 == null) {
                AppMethodBeat.o(180822);
            } else {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = (String) x.a(this.f1367a.getClassLoader(), "findLibrary", new Class[]{String.class}, new Object[]{str});
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            AppMethodBeat.o(180822);
                            i2 = 0;
                        }
                    }
                    String str3 = x.f1430g;
                    if (str3 == null || str3.equals(BuildConfig.KINDA_DEFAULT)) {
                        AppMethodBeat.o(180822);
                        i2 = 3;
                    } else {
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            if (Build.VERSION.SDK_INT >= 28) {
                                x.a(runtime, "nativeLoad", new Class[]{String.class, ClassLoader.class}, new Object[]{str3, a2});
                            } else {
                                x.a(runtime, "nativeLoad", new Class[]{String.class, ClassLoader.class, String.class}, new Object[]{str3, a2, null});
                            }
                            AppMethodBeat.o(180822);
                            i2 = 0;
                        } catch (NoSuchMethodError e2) {
                            AppMethodBeat.o(180822);
                            i2 = 2;
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(180822);
                    i2 = 2;
                }
            }
        }
        return i2;
    }

    private static byte[] a(byte[] bArr) {
        AppMethodBeat.i(180823);
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
        }
        AppMethodBeat.o(180823);
        return bArr2;
    }

    static /* synthetic */ byte[] a(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        AppMethodBeat.i(193528);
        if (bArr == null || bArr.length == 0) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(193528);
            return bArr2;
        }
        byte[] encryptAes256 = EncryptAesUtils.encryptAes256(a(bArr), str, algorithmParameterSpec);
        if (encryptAes256 == null || encryptAes256.length == 0) {
            byte[] bArr3 = new byte[0];
            AppMethodBeat.o(193528);
            return bArr3;
        }
        byte[] bArr4 = new byte[(encryptAes256.length + 2)];
        int length = encryptAes256.length;
        byte[] bArr5 = new byte[2];
        for (int i2 = 0; i2 < 2; i2++) {
            bArr5[i2] = Integer.valueOf(length & 255).byteValue();
            length >>= 8;
        }
        System.arraycopy(bArr5, 0, bArr4, 0, 2);
        System.arraycopy(encryptAes256, 0, bArr4, 2, encryptAes256.length);
        AppMethodBeat.o(193528);
        return bArr4;
    }
}

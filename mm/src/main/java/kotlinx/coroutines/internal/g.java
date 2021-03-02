package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.a.j;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class g {
    public static final g TVK = new g();

    static {
        AppMethodBeat.i(192440);
        AppMethodBeat.o(192440);
    }

    private g() {
    }

    public static List<MainDispatcherFactory> hNF() {
        List<MainDispatcherFactory> a2;
        MainDispatcherFactory mainDispatcherFactory;
        MainDispatcherFactory mainDispatcherFactory2;
        AppMethodBeat.i(192436);
        if (!h.hNG()) {
            List<MainDispatcherFactory> a3 = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
            AppMethodBeat.o(192436);
            return a3;
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException e2) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException e3) {
                mainDispatcherFactory2 = null;
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            a2 = arrayList;
        } catch (Throwable th) {
            a2 = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        AppMethodBeat.o(192436);
        return a2;
    }

    private static List<String> f(URL url) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5 = null;
        AppMethodBeat.i(192438);
        String url2 = url.toString();
        if (n.J(url2, ShareConstants.DEXMODE_JAR, false)) {
            String a2 = n.a(n.oB(url2, "jar:file:"), '!');
            String oB = n.oB(url2, "!/");
            JarFile jarFile = new JarFile(a2, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(oB)), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                try {
                    List<String> b2 = b(bufferedReader);
                    b.a(bufferedReader, null);
                    try {
                        jarFile.close();
                        return b2;
                    } finally {
                        AppMethodBeat.o(192438);
                    }
                } catch (Throwable th6) {
                    th3 = th6;
                    th4 = th;
                    b.a(bufferedReader, th4);
                    AppMethodBeat.o(192438);
                    throw th3;
                }
            } catch (Throwable th7) {
                th2 = th7;
                th5 = th;
                jarFile.close();
                AppMethodBeat.o(192438);
                throw th2;
            }
        } else {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> b3 = b(bufferedReader2);
                b.a(bufferedReader2, null);
                AppMethodBeat.o(192438);
                return b3;
            } catch (Throwable th8) {
                th = th8;
                th5 = th;
                b.a(bufferedReader2, th5);
                AppMethodBeat.o(192438);
                throw th;
            }
        }
    }

    private static List<String> b(BufferedReader bufferedReader) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(192439);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                List<String> p = j.p(linkedHashSet);
                AppMethodBeat.o(192439);
                return p;
            }
            String oz = n.oz(readLine, "#");
            if (oz == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(192439);
                throw tVar;
            }
            String obj = n.trim(oz).toString();
            String str = obj;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i2);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (!z) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal service provider class name: ".concat(String.valueOf(obj)).toString());
                AppMethodBeat.o(192439);
                throw illegalArgumentException;
            }
            if (obj.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj);
            }
        }
    }

    private static <S> List<S> a(Class<S> cls, ClassLoader classLoader) {
        ArrayList arrayList;
        AppMethodBeat.i(192437);
        try {
            ArrayList<URL> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
            p.g(list, "java.util.Collections.list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (URL url : list) {
                j.a((Collection) arrayList2, (Iterable) f(url));
            }
            Set r = j.r((Iterable) arrayList2);
            if (!(!r.isEmpty())) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
                AppMethodBeat.o(192437);
                throw illegalArgumentException;
            }
            Set<String> set = r;
            ArrayList arrayList3 = new ArrayList(j.a(set, 10));
            for (String str : set) {
                Class<?> cls2 = Class.forName(str, false, classLoader);
                if (!cls.isAssignableFrom(cls2)) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
                    AppMethodBeat.o(192437);
                    throw illegalArgumentException2;
                }
                arrayList3.add(cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
            }
            arrayList = arrayList3;
            AppMethodBeat.o(192437);
            return arrayList;
        } catch (Throwable th) {
            arrayList = j.p(ServiceLoader.load(cls, classLoader));
        }
    }
}

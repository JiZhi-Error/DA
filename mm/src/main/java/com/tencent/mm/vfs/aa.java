package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.g;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class aa {
    private static final Pattern ReO = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");

    public interface b {
        boolean a(FileSystem.b bVar);
    }

    static {
        AppMethodBeat.i(13334);
        AppMethodBeat.o(13334);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri parseUri(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.aa.parseUri(java.lang.String):android.net.Uri");
    }

    public static String z(Uri uri) {
        AppMethodBeat.i(13324);
        StringBuilder sb = new StringBuilder();
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.isEmpty()) {
            sb.append(scheme).append(':');
        }
        String authority = uri.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            sb.append("//").append(authority);
        }
        String path = uri.getPath();
        if (path != null) {
            sb.append(path);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(13324);
        return sb2;
    }

    static String aa(String str, Map<String, String> map) {
        AppMethodBeat.i(13325);
        if (str == null) {
            AppMethodBeat.o(13325);
            return null;
        }
        Matcher matcher = ReO.matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder(str.length());
            int i2 = 0;
            while (true) {
                String str2 = map.get(matcher.group(1));
                if (str2 == null) {
                    AppMethodBeat.o(13325);
                    return null;
                }
                sb.append(str.substring(i2, matcher.start())).append(str2);
                i2 = matcher.end();
                if (!matcher.find()) {
                    String sb2 = sb.append(str.substring(i2)).toString();
                    AppMethodBeat.o(13325);
                    return sb2;
                }
            }
        } else {
            AppMethodBeat.o(13325);
            return str;
        }
    }

    static String q(String str, boolean z, boolean z2) {
        boolean z3 = true;
        AppMethodBeat.i(13326);
        if (str.isEmpty()) {
            AppMethodBeat.o(13326);
            return str;
        }
        int i2 = str.startsWith(FilePathGenerator.ANDROID_DIR_SEP) ? 1 : 0;
        if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP) && str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(i2), FilePathGenerator.ANDROID_DIR_SEP);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z && "..".equals(nextToken)) {
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
                z3 = false;
            } else if ((!z || !".".equals(nextToken)) && !"".equals(nextToken)) {
                arrayList.add(nextToken);
            } else {
                z3 = false;
            }
        }
        if (!z3) {
            StringBuilder sb = new StringBuilder();
            if (!z2 && i2 > 0) {
                sb.append('/');
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                sb.append(it.next());
                while (it.hasNext()) {
                    sb.append('/');
                    sb.append(it.next());
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(13326);
            return sb2;
        } else if (z2) {
            String substring = str.substring(i2);
            AppMethodBeat.o(13326);
            return substring;
        } else {
            AppMethodBeat.o(13326);
            return str;
        }
    }

    static String bpf(String str) {
        AppMethodBeat.i(187763);
        File file = new File(str);
        try {
            String canonicalPath = file.getCanonicalPath();
            AppMethodBeat.o(187763);
            return canonicalPath;
        } catch (IOException e2) {
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(187763);
            return absolutePath;
        }
    }

    static String bpg(String str) {
        AppMethodBeat.i(13327);
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf <= 0) {
            AppMethodBeat.o(13327);
            return null;
        }
        String substring = str.substring(0, lastIndexOf);
        AppMethodBeat.o(13327);
        return substring;
    }

    static String b(Uri uri, boolean z) {
        AppMethodBeat.i(13328);
        g.e a2 = g.hYQ().a(uri, (g.e) null);
        if (!a2.valid()) {
            AppMethodBeat.o(13328);
            return null;
        } else if ((a2.Rcl.hdR() & 2) != 0) {
            String dz = a2.Rcl.dz(a2.path, z);
            AppMethodBeat.o(13328);
            return dz;
        } else {
            AppMethodBeat.o(13328);
            return null;
        }
    }

    public static void bph(String str) {
        AppMethodBeat.i(187764);
        if (str.isEmpty()) {
            AppMethodBeat.o(187764);
            return;
        }
        File file = new File(g.hYQ().Vmo, str + ".timestamp");
        try {
            file.createNewFile();
            file.setLastModified(System.currentTimeMillis());
            AppMethodBeat.o(187764);
        } catch (IOException e2) {
            Log.w("VFS.Utils", e2, "Unable to update timestamp: ".concat(String.valueOf(str)));
            AppMethodBeat.o(187764);
        }
    }

    public static long bpi(String str) {
        AppMethodBeat.i(187765);
        if (str.isEmpty()) {
            AppMethodBeat.o(187765);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - new File(g.hYQ().Vmo, str + ".timestamp").lastModified();
        AppMethodBeat.o(187765);
        return currentTimeMillis;
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(13329);
        if (closeable == null) {
            AppMethodBeat.o(13329);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(13329);
        } catch (IOException e2) {
            Log.w("VFS.Utils", "Failed to close object: " + e2.toString());
            AppMethodBeat.o(13329);
        }
    }

    public static long a(FileSystem.b bVar, String str, FileSystem.b bVar2, String str2) {
        InputStream inputStream;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(187766);
        long j2 = 0;
        try {
            inputStream = bVar.openRead(str);
            try {
                outputStream = bVar2.dw(str2, false);
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                closeQuietly(inputStream);
                closeQuietly(outputStream);
                AppMethodBeat.o(187766);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        j2 += (long) read;
                    } else {
                        closeQuietly(inputStream);
                        closeQuietly(outputStream);
                        AppMethodBeat.o(187766);
                        return j2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(inputStream);
                closeQuietly(outputStream);
                AppMethodBeat.o(187766);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            inputStream = null;
            closeQuietly(inputStream);
            closeQuietly(outputStream);
            AppMethodBeat.o(187766);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends RuntimeException {
        a(Class<?> cls, int i2, int i3) {
            super("Version mismatch when unmarhelling " + cls.getName() + " (" + i3 + " expected, " + i2 + " got");
            AppMethodBeat.i(13322);
            AppMethodBeat.o(13322);
        }
    }

    public static void a(Parcel parcel, Class<? extends FileSystem> cls, int i2) {
        AppMethodBeat.i(13331);
        int hashCode = cls.getName().hashCode() ^ i2;
        int readInt = parcel.readInt();
        if (readInt != hashCode) {
            a aVar = new a(cls, readInt, hashCode);
            AppMethodBeat.o(13331);
            throw aVar;
        }
        AppMethodBeat.o(13331);
    }

    public static void b(Parcel parcel, Class<? extends FileSystem> cls, int i2) {
        AppMethodBeat.i(13332);
        parcel.writeInt(cls.getName().hashCode() ^ i2);
        AppMethodBeat.o(13332);
    }

    public static <T> List<T> c(Iterable<? extends T> iterable) {
        AppMethodBeat.i(13333);
        if (iterable == null) {
            AppMethodBeat.o(13333);
            return null;
        } else if (iterable instanceof List) {
            List<T> list = (List) iterable;
            AppMethodBeat.o(13333);
            return list;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            AppMethodBeat.o(13333);
            return arrayList;
        }
    }

    public static void a(FileSystem.b bVar, b bVar2) {
        AppMethodBeat.i(187767);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        do {
            FileSystem.b bVar3 = (FileSystem.b) arrayList.remove(arrayList.size() - 1);
            if (bVar3 != null) {
                bVar2.a(bVar3);
                if (bVar3 instanceof c) {
                    List<FileSystem.b> hdS = ((c) bVar3).hdS();
                    for (int size = hdS.size() - 1; size >= 0; size--) {
                        arrayList.add(hdS.get(size));
                    }
                }
            }
        } while (!arrayList.isEmpty());
        AppMethodBeat.o(187767);
    }
}

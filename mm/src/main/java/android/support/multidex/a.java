package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static final String zD = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> zE = new HashSet();
    private static final boolean zF = o(System.getProperty("java.vm.version"));

    static /* synthetic */ void a(Object obj, String str, Object[] objArr) {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    public static void K(Context context) {
        if (!zF) {
            if (Build.VERSION.SDK_INT < 4) {
                throw new RuntimeException("Multi dex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
            try {
                ApplicationInfo L = L(context);
                if (L != null) {
                    synchronized (zE) {
                        String str = L.sourceDir;
                        if (!zE.contains(str)) {
                            zE.add(str);
                            if (Build.VERSION.SDK_INT > 20) {
                                new StringBuilder("MultiDex is not guaranteed to work in SDK version ").append(Build.VERSION.SDK_INT).append(": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"").append(System.getProperty("java.vm.version")).append("\"");
                            }
                            try {
                                ClassLoader classLoader = context.getClassLoader();
                                if (classLoader != null) {
                                    try {
                                        M(context);
                                    } catch (Throwable th) {
                                    }
                                    File file = new File(L.dataDir, zD);
                                    List<File> a2 = b.a(context, L, file, false);
                                    if (f(a2)) {
                                        a(classLoader, file, a2);
                                    } else {
                                        List<File> a3 = b.a(context, L, file, true);
                                        if (f(a3)) {
                                            a(classLoader, file, a3);
                                        } else {
                                            throw new RuntimeException("Zip files were not valid.");
                                        }
                                    }
                                }
                            } catch (RuntimeException e2) {
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                throw new RuntimeException("Multi dex installation failed (" + e3.getMessage() + ").");
            }
        }
    }

    private static ApplicationInfo L(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (RuntimeException e2) {
            return null;
        }
    }

    private static boolean o(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            b.install(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            C0013a.install(classLoader, list, file);
        } else {
            c.install(classLoader, list);
        }
    }

    private static boolean f(List<File> list) {
        for (File file : list) {
            if (!b.l(file)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static Field findField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e2) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    public static Method findMethod(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e2) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void M(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (!file2.delete()) {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                }
            }
            if (!file.delete()) {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        static void install(ClassLoader classLoader, List<File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = a.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(list);
            a.a(obj, "dexElements", (Object[]) a.findMethod(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList2, file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                Field findField = a.findField(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(classLoader);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(classLoader, iOExceptionArr);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.multidex.a$a  reason: collision with other inner class name */
    public static final class C0013a {
        static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = a.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList(list);
            a.a(obj, "dexElements", (Object[]) a.findMethod(obj, "makeDexElements", new Class[]{ArrayList.class, File.class}).invoke(obj, arrayList, file));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        static void install(ClassLoader classLoader, List<File> list) {
            int size = list.size();
            Field findField = a.findField(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) findField.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ShareConstants.DEX_SUFFIX, 0);
            }
            findField.set(classLoader, sb.toString());
            a.a(classLoader, "mPaths", strArr);
            a.a(classLoader, "mFiles", fileArr);
            a.a(classLoader, "mZips", zipFileArr);
            a.a(classLoader, "mDexs", dexFileArr);
        }
    }
}

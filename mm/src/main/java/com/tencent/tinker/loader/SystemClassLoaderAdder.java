package com.tencent.tinker.loader;

import android.app.Application;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

public class SystemClassLoaderAdder {
    public static final String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
    public static final String CHECK_DEX_FIELD = "isPatch";
    private static final String TAG = "Tinker.ClassLoaderAdder";
    private static int sPatchDexCount = 0;

    public static void installDexes(Application application, ClassLoader classLoader, File file, List<File> list, boolean z, boolean z2) {
        ShareTinkerLog.i(TAG, "installDexes dexOptDir: " + file.getAbsolutePath() + ", dex size:" + list.size(), new Object[0]);
        if (!list.isEmpty()) {
            List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
            if (Build.VERSION.SDK_INT < 24 || z) {
                injectDexesInternal(classLoader, createSortedAdditionalPathEntries, file);
            } else {
                classLoader = NewClassLoaderInjector.inject(application, classLoader, file, z2, createSortedAdditionalPathEntries);
            }
            sPatchDexCount = createSortedAdditionalPathEntries.size();
            ShareTinkerLog.i(TAG, "after loaded classloader: " + classLoader + ", dex size:" + sPatchDexCount, new Object[0]);
            if (!checkDexInstall(classLoader)) {
                uninstallPatchDex(classLoader);
                throw new TinkerRuntimeException(ShareConstants.CHECK_DEX_INSTALL_FAIL);
            }
        }
    }

    static void injectDexesInternal(ClassLoader classLoader, List<File> list, File file) {
        if (Build.VERSION.SDK_INT >= 23) {
            V23.install(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 19) {
            V19.install(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            V14.install(classLoader, list, file);
        } else {
            V4.install(classLoader, list, file);
        }
    }

    public static void installApk(PathClassLoader pathClassLoader, List<File> list) {
        if (!list.isEmpty()) {
            List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
            ArkHot.install(pathClassLoader, createSortedAdditionalPathEntries);
            sPatchDexCount = createSortedAdditionalPathEntries.size();
            ShareTinkerLog.i(TAG, "after loaded classloader: " + pathClassLoader + ", dex size:" + sPatchDexCount, new Object[0]);
            checkDexInstall(pathClassLoader);
        }
    }

    public static void uninstallPatchDex(ClassLoader classLoader) {
        if (sPatchDexCount > 0) {
            if (Build.VERSION.SDK_INT >= 14) {
                ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField(classLoader, "pathList").get(classLoader), "dexElements", sPatchDexCount);
                return;
            }
            ShareReflectUtil.reduceFieldArray(classLoader, "mPaths", sPatchDexCount);
            ShareReflectUtil.reduceFieldArray(classLoader, "mFiles", sPatchDexCount);
            ShareReflectUtil.reduceFieldArray(classLoader, "mZips", sPatchDexCount);
            try {
                ShareReflectUtil.reduceFieldArray(classLoader, "mDexs", sPatchDexCount);
            } catch (Exception e2) {
            }
        }
    }

    private static boolean checkDexInstall(ClassLoader classLoader) {
        boolean booleanValue = ((Boolean) ShareReflectUtil.findField(Class.forName(CHECK_DEX_CLASS, true, classLoader), CHECK_DEX_FIELD).get(null)).booleanValue();
        ShareTinkerLog.w(TAG, "checkDexInstall result:".concat(String.valueOf(booleanValue)), new Object[0]);
        return booleanValue;
    }

    private static List<File> createSortedAdditionalPathEntries(List<File> list) {
        ArrayList<File> arrayList = new ArrayList(list);
        final HashMap hashMap = new HashMap();
        for (File file : arrayList) {
            String name = file.getName();
            hashMap.put(name, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(name).matches()));
        }
        Collections.sort(arrayList, new Comparator<File>() {
            /* class com.tencent.tinker.loader.SystemClassLoaderAdder.AnonymousClass1 */

            public final int compare(File file, File file2) {
                int i2;
                int i3;
                if (file == null && file2 == null) {
                    return 0;
                }
                if (file == null) {
                    return -1;
                }
                if (file2 == null) {
                    return 1;
                }
                String name = file.getName();
                String name2 = file2.getName();
                if (name.equals(name2)) {
                    return 0;
                }
                if (name.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    return 1;
                }
                if (name2.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    return -1;
                }
                boolean booleanValue = ((Boolean) hashMap.get(name)).booleanValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(name2)).booleanValue();
                if (booleanValue && booleanValue2) {
                    int indexOf = name.indexOf(46);
                    int indexOf2 = name2.indexOf(46);
                    if (indexOf > 7) {
                        i2 = Integer.parseInt(name.substring(7, indexOf));
                    } else {
                        i2 = 1;
                    }
                    if (indexOf2 > 7) {
                        i3 = Integer.parseInt(name2.substring(7, indexOf2));
                    } else {
                        i3 = 1;
                    }
                    if (i2 == i3) {
                        return 0;
                    }
                    return i2 < i3 ? -1 : 1;
                } else if (booleanValue) {
                    return -1;
                } else {
                    if (booleanValue2) {
                        return 1;
                    }
                    return name.compareTo(name2);
                }
            }
        });
        return arrayList;
    }

    static final class ArkHot {
        private ArkHot() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list) {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.classloader.ExtendedClassLoaderHelper");
            for (File file : list) {
                String canonicalPath = file.getCanonicalPath();
                Method declaredMethod = loadClass.getDeclaredMethod("applyPatch", ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, classLoader, canonicalPath);
                ShareTinkerLog.i(SystemClassLoaderAdder.TAG, "ArkHot install path = ".concat(String.valueOf(canonicalPath)), new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class V23 {
        private V23() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makePathElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    ShareTinkerLog.w(SystemClassLoaderAdder.TAG, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] makePathElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException e2) {
                ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makePathElements(List,File,List) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException e3) {
                    ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                    try {
                        ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: try use v19 instead", new Object[0]);
                        return V19.makeDexElements(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e4) {
                        ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                        throw e4;
                    }
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class V19 {
        private V19() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    ShareTinkerLog.w(SystemClassLoaderAdder.TAG, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }

        /* access modifiers changed from: private */
        public static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e2) {
                ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e3) {
                    ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                    throw e3;
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class V14 {
        private V14() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class V4 {
        private V4() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) {
            int size = list.size();
            Field findField = ShareReflectUtil.findField(classLoader, "path");
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
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, SharePatchFileUtil.optimizedPathFor(next, file), 0);
            }
            findField.set(classLoader, sb.toString());
            ShareReflectUtil.expandFieldArray(classLoader, "mPaths", strArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mFiles", fileArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mZips", zipFileArr);
            try {
                ShareReflectUtil.expandFieldArray(classLoader, "mDexs", dexFileArr);
            } catch (Exception e2) {
            }
        }
    }
}

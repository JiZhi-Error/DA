package com.tencent.tinker.lib.a;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public static boolean a(ApplicationLike applicationLike, String str) {
        String d2 = com.tencent.tinker.lib.e.b.d(applicationLike);
        if (ShareTinkerInternals.isNullOrNil(d2)) {
            ShareTinkerLog.e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
            return false;
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
        if (patchDirectory == null) {
            ShareTinkerLog.e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(new File(patchDirectory.getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + SharePatchFileUtil.getPatchVersionDirectory(d2)).getAbsolutePath() + "/lib/lib/" + str);
        if (!file.exists()) {
            ShareTinkerLog.e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", file);
            return false;
        }
        ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
        if (classLoader == null) {
            ShareTinkerLog.e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
            return false;
        }
        ShareTinkerLog.i("Tinker.LoadLibrary", "before hack classloader:" + classLoader.toString(), new Object[0]);
        try {
            Method declaredMethod = a.class.getDeclaredMethod("a", ClassLoader.class, File.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, classLoader, file);
            ShareTinkerLog.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            return true;
        } catch (Throwable th) {
            ShareTinkerLog.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            throw th;
        }
    }

    private static void a(ClassLoader classLoader, File file) {
        ArrayList arrayList;
        if (file == null || !file.exists()) {
            ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
            try {
                Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
                List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    arrayList = new ArrayList(2);
                } else {
                    arrayList = list;
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (file.equals((File) it.next())) {
                            it.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                arrayList.add(0, file);
                List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list2.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list2);
                Field findField = ShareReflectUtil.findField(obj, "nativeLibraryPathElements");
                findField.set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class).invoke(obj, arrayList2));
            } catch (Throwable th) {
                ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage());
                b.b(classLoader, file);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                b.b(classLoader, file);
            } catch (Throwable th2) {
                ShareTinkerLog.e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(Build.VERSION.SDK_INT), th2.getMessage());
                C2215a.b(classLoader, file);
            }
        } else if (Build.VERSION.SDK_INT >= 14) {
            C2215a.b(classLoader, file);
        } else {
            c.b(classLoader, file);
        }
    }

    static final class c {
        static void b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field findField = ShareReflectUtil.findField(classLoader, "libPath");
            String[] split = ((String) findField.get(classLoader)).split(":");
            StringBuilder sb = new StringBuilder(path);
            for (String str : split) {
                if (str != null && !path.equals(str)) {
                    sb.append(':').append(str);
                }
            }
            findField.set(classLoader, sb.toString());
            Field findField2 = ShareReflectUtil.findField(classLoader, "libraryPathElements");
            List list = (List) findField2.get(classLoader);
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (path.equals((String) it.next())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            list.add(0, path);
            findField2.set(classLoader, list);
        }
    }

    /* renamed from: com.tencent.tinker.lib.a.a$a  reason: collision with other inner class name */
    static final class C2215a {
        /* access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            Field findField = ShareReflectUtil.findField(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) findField.get(obj);
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            findField.set(obj, arrayList.toArray(new File[0]));
        }
    }

    static final class b {
        /* access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            ArrayList arrayList;
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                arrayList = new ArrayList(2);
            } else {
                arrayList = list;
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (file.equals((File) it.next())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            arrayList.add(0, file);
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list2.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list2);
            Method findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            Object[] objArr = {arrayList2, null, new ArrayList()};
            ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) findMethod.invoke(obj, objArr));
        }
    }
}

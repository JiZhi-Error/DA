package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class f {
    private static Field ZM;
    private static boolean ZN;
    private static Class ZO;
    private static boolean ZP;
    private static Field ZQ;
    private static boolean ZR;
    private static Field ZS;
    private static boolean ZT;

    static void a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!ZN) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                ZM = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            ZN = true;
        }
        if (ZM != null) {
            try {
                map = (Map) ZM.get(resources);
            } catch (IllegalAccessException e3) {
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!ZN) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                ZM = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            ZN = true;
        }
        Object obj = null;
        if (ZM != null) {
            try {
                obj = ZM.get(resources);
            } catch (IllegalAccessException e3) {
            }
        }
        if (obj != null) {
            M(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        Object obj2 = null;
        if (!ZT) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                ZS = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            ZT = true;
        }
        if (ZS != null) {
            try {
                obj = ZS.get(resources);
            } catch (IllegalAccessException e3) {
                obj = null;
            }
            if (obj != null) {
                if (!ZN) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        ZM = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                    }
                    ZN = true;
                }
                if (ZM != null) {
                    try {
                        obj2 = ZM.get(obj);
                    } catch (IllegalAccessException e5) {
                    }
                }
                if (obj2 != null) {
                    M(obj2);
                }
            }
        }
    }

    private static void M(Object obj) {
        LongSparseArray longSparseArray;
        if (!ZP) {
            try {
                ZO = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
            }
            ZP = true;
        }
        if (ZO != null) {
            if (!ZR) {
                try {
                    Field declaredField = ZO.getDeclaredField("mUnthemedEntries");
                    ZQ = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                }
                ZR = true;
            }
            if (ZQ != null) {
                try {
                    longSparseArray = (LongSparseArray) ZQ.get(obj);
                } catch (IllegalAccessException e4) {
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}

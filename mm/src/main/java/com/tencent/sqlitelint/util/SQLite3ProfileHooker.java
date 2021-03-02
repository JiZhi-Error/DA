package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class SQLite3ProfileHooker {
    private static final String TAG = "SQLiteLint.SQLite3ProfileHooker";
    private static volatile boolean sIsTryHook;

    private static native boolean nativeDoHook();

    private static native void nativeStartProfile();

    private static native void nativeStopProfile();

    public static void hook() {
        AppMethodBeat.i(52959);
        SLog.i(TAG, "hook sIsTryHook: %b", Boolean.valueOf(sIsTryHook));
        nativeStartProfile();
        if (!sIsTryHook) {
            SLog.i(TAG, "hook hookRet: %b", Boolean.valueOf(doHook()));
            sIsTryHook = true;
        }
        AppMethodBeat.o(52959);
    }

    public static void unHook() {
        AppMethodBeat.i(52960);
        if (sIsTryHook) {
            SLog.i(TAG, "unHook unHookRet: %b", Boolean.valueOf(doUnHook()));
            sIsTryHook = false;
        }
        AppMethodBeat.o(52960);
    }

    private static boolean doHook() {
        AppMethodBeat.i(52961);
        if (!hookOpenSQLite3Profile()) {
            SLog.i(TAG, "doHook hookOpenSQLite3Profile failed", new Object[0]);
            AppMethodBeat.o(52961);
            return false;
        }
        boolean nativeDoHook = nativeDoHook();
        AppMethodBeat.o(52961);
        return nativeDoHook;
    }

    private static boolean doUnHook() {
        AppMethodBeat.i(52962);
        unHookOpenSQLite3Profile();
        nativeStopProfile();
        AppMethodBeat.o(52962);
        return true;
    }

    private static boolean hookOpenSQLite3Profile() {
        AppMethodBeat.i(52963);
        try {
            Class<?> cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, true);
            declaredField.setAccessible(false);
            AppMethodBeat.o(52963);
            return true;
        } catch (ClassNotFoundException e2) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e2.getLocalizedMessage());
            AppMethodBeat.o(52963);
            return false;
        } catch (IllegalAccessException e3) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e3.getLocalizedMessage());
            AppMethodBeat.o(52963);
            return false;
        } catch (NoSuchFieldException e4) {
            SLog.e(TAG, "prepareHookBeforeOpenDatabase: e=%s", e4.getLocalizedMessage());
            AppMethodBeat.o(52963);
            return false;
        }
    }

    private static boolean unHookOpenSQLite3Profile() {
        AppMethodBeat.i(52964);
        try {
            Class<?> cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, false);
            declaredField.setAccessible(false);
            AppMethodBeat.o(52964);
            return true;
        } catch (ClassNotFoundException e2) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e2.getLocalizedMessage());
            AppMethodBeat.o(52964);
            return false;
        } catch (IllegalAccessException e3) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e3.getLocalizedMessage());
            AppMethodBeat.o(52964);
            return false;
        } catch (NoSuchFieldException e4) {
            SLog.e(TAG, "unHookOpenSQLite3Profile: e=%s", e4.getLocalizedMessage());
            AppMethodBeat.o(52964);
            return false;
        }
    }
}

package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class CursorFieldHelper {
    private static final Map<Class<?>, IGetMethod> GET_METHODS = new HashMap();
    private static final Map<Class<?>, String> GET_TYPE = new HashMap();
    private static final Map<Class<?>, ISetMethod> SET_METHODS = new HashMap();
    private static final String TAG = "MicroMsg.SDK.CursorFieldHelper";

    public interface IGetMethod {
        void invoke(Field field, Object obj, ContentValues contentValues);
    }

    public interface ISetMethod {
        void invoke(Field field, Object obj, Cursor cursor, int i2);
    }

    CursorFieldHelper() {
    }

    static {
        AppMethodBeat.i(158081);
        try {
            SET_METHODS.put(byte[].class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230504);
                    CursorFieldHelper.keep_setBlob(field, obj, cursor, i2);
                    AppMethodBeat.o(230504);
                }
            });
            SET_METHODS.put(Short.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230515);
                    CursorFieldHelper.keep_setShort(field, obj, cursor, i2);
                    AppMethodBeat.o(230515);
                }
            });
            SET_METHODS.put(Short.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230525);
                    CursorFieldHelper.keep_setShort(field, obj, cursor, i2);
                    AppMethodBeat.o(230525);
                }
            });
            SET_METHODS.put(Boolean.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass4 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230526);
                    CursorFieldHelper.keep_setBoolean(field, obj, cursor, i2);
                    AppMethodBeat.o(230526);
                }
            });
            SET_METHODS.put(Boolean.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass5 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230527);
                    CursorFieldHelper.keep_setBoolean(field, obj, cursor, i2);
                    AppMethodBeat.o(230527);
                }
            });
            SET_METHODS.put(Integer.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230528);
                    CursorFieldHelper.keep_setInt(field, obj, cursor, i2);
                    AppMethodBeat.o(230528);
                }
            });
            SET_METHODS.put(Integer.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230529);
                    CursorFieldHelper.keep_setInt(field, obj, cursor, i2);
                    AppMethodBeat.o(230529);
                }
            });
            SET_METHODS.put(Float.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass8 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230530);
                    CursorFieldHelper.keep_setFloat(field, obj, cursor, i2);
                    AppMethodBeat.o(230530);
                }
            });
            SET_METHODS.put(Float.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230531);
                    CursorFieldHelper.keep_setFloat(field, obj, cursor, i2);
                    AppMethodBeat.o(230531);
                }
            });
            SET_METHODS.put(Double.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass10 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230505);
                    CursorFieldHelper.keep_setDouble(field, obj, cursor, i2);
                    AppMethodBeat.o(230505);
                }
            });
            SET_METHODS.put(Double.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass11 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230506);
                    CursorFieldHelper.keep_setDouble(field, obj, cursor, i2);
                    AppMethodBeat.o(230506);
                }
            });
            SET_METHODS.put(Long.TYPE, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass12 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230507);
                    CursorFieldHelper.keep_setLong(field, obj, cursor, i2);
                    AppMethodBeat.o(230507);
                }
            });
            SET_METHODS.put(Long.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass13 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230508);
                    CursorFieldHelper.keep_setLong(field, obj, cursor, i2);
                    AppMethodBeat.o(230508);
                }
            });
            SET_METHODS.put(String.class, new ISetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass14 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.ISetMethod
                public final void invoke(Field field, Object obj, Cursor cursor, int i2) {
                    AppMethodBeat.i(230509);
                    CursorFieldHelper.keep_setString(field, obj, cursor, i2);
                    AppMethodBeat.o(230509);
                }
            });
            GET_METHODS.put(byte[].class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass15 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230510);
                    CursorFieldHelper.keep_getBlob(field, obj, contentValues);
                    AppMethodBeat.o(230510);
                }
            });
            GET_METHODS.put(Short.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass16 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230511);
                    CursorFieldHelper.keep_getShort(field, obj, contentValues);
                    AppMethodBeat.o(230511);
                }
            });
            GET_METHODS.put(Short.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass17 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230512);
                    CursorFieldHelper.keep_getShort(field, obj, contentValues);
                    AppMethodBeat.o(230512);
                }
            });
            GET_METHODS.put(Boolean.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass18 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230513);
                    CursorFieldHelper.keep_getBoolean(field, obj, contentValues);
                    AppMethodBeat.o(230513);
                }
            });
            GET_METHODS.put(Boolean.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass19 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230514);
                    CursorFieldHelper.keep_getBoolean(field, obj, contentValues);
                    AppMethodBeat.o(230514);
                }
            });
            GET_METHODS.put(Integer.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass20 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230516);
                    CursorFieldHelper.keep_getInt(field, obj, contentValues);
                    AppMethodBeat.o(230516);
                }
            });
            GET_METHODS.put(Integer.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass21 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230517);
                    CursorFieldHelper.keep_getInt(field, obj, contentValues);
                    AppMethodBeat.o(230517);
                }
            });
            GET_METHODS.put(Float.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass22 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230518);
                    CursorFieldHelper.keep_getFloat(field, obj, contentValues);
                    AppMethodBeat.o(230518);
                }
            });
            GET_METHODS.put(Float.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass23 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230519);
                    CursorFieldHelper.keep_getFloat(field, obj, contentValues);
                    AppMethodBeat.o(230519);
                }
            });
            GET_METHODS.put(Double.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass24 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230520);
                    CursorFieldHelper.keep_getDouble(field, obj, contentValues);
                    AppMethodBeat.o(230520);
                }
            });
            GET_METHODS.put(Double.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass25 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230521);
                    CursorFieldHelper.keep_getDouble(field, obj, contentValues);
                    AppMethodBeat.o(230521);
                }
            });
            GET_METHODS.put(Long.TYPE, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass26 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230522);
                    CursorFieldHelper.keep_getLong(field, obj, contentValues);
                    AppMethodBeat.o(230522);
                }
            });
            GET_METHODS.put(Long.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass27 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230523);
                    CursorFieldHelper.keep_getLong(field, obj, contentValues);
                    AppMethodBeat.o(230523);
                }
            });
            GET_METHODS.put(String.class, new IGetMethod() {
                /* class com.tencent.mm.sdk.storage.CursorFieldHelper.AnonymousClass28 */

                @Override // com.tencent.mm.sdk.storage.CursorFieldHelper.IGetMethod
                public final void invoke(Field field, Object obj, ContentValues contentValues) {
                    AppMethodBeat.i(230524);
                    CursorFieldHelper.keep_getString(field, obj, contentValues);
                    AppMethodBeat.o(230524);
                }
            });
            GET_TYPE.put(byte[].class, "BLOB");
            GET_TYPE.put(Short.TYPE, "SHORT");
            GET_TYPE.put(Short.class, "SHORT");
            GET_TYPE.put(Boolean.TYPE, "INTEGER");
            GET_TYPE.put(Boolean.class, "INTEGER");
            GET_TYPE.put(Integer.TYPE, "INTEGER");
            GET_TYPE.put(Integer.class, "INTEGER");
            GET_TYPE.put(Float.TYPE, "FLOAT");
            GET_TYPE.put(Float.class, "FLOAT");
            GET_TYPE.put(Double.TYPE, "DOUBLE");
            GET_TYPE.put(Double.class, "DOUBLE");
            GET_TYPE.put(Long.TYPE, "LONG");
            GET_TYPE.put(Long.class, "LONG");
            GET_TYPE.put(String.class, "TEXT");
            AppMethodBeat.o(158081);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158081);
        }
    }

    public static String type(Class<?> cls) {
        AppMethodBeat.i(158064);
        String str = GET_TYPE.get(cls);
        AppMethodBeat.o(158064);
        return str;
    }

    public static IGetMethod getter(Class<?> cls) {
        AppMethodBeat.i(230532);
        IGetMethod iGetMethod = GET_METHODS.get(cls);
        AppMethodBeat.o(230532);
        return iGetMethod;
    }

    public static ISetMethod setter(Class<?> cls) {
        AppMethodBeat.i(230533);
        ISetMethod iSetMethod = SET_METHODS.get(cls);
        AppMethodBeat.o(230533);
        return iSetMethod;
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158065);
        try {
            field.set(obj, cursor.getBlob(i2));
            AppMethodBeat.o(158065);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158065);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158066);
        try {
            contentValues.put(IAutoDBItem.getColName(field), (byte[]) field.get(obj));
            AppMethodBeat.o(158066);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158066);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158067);
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i2));
                AppMethodBeat.o(158067);
                return;
            }
            field.set(obj, Short.valueOf(cursor.getShort(i2)));
            AppMethodBeat.o(158067);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158067);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158068);
        try {
            contentValues.put(IAutoDBItem.getColName(field), Short.valueOf(field.getShort(obj)));
            AppMethodBeat.o(158068);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158068);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158069);
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i2) != 0);
                AppMethodBeat.o(158069);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i2)));
            AppMethodBeat.o(158069);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158069);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158070);
        try {
            contentValues.put(IAutoDBItem.getColName(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
            AppMethodBeat.o(158070);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158070);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158071);
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i2));
                AppMethodBeat.o(158071);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i2)));
            AppMethodBeat.o(158071);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158071);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158072);
        try {
            if (!field.getType().equals(Integer.TYPE)) {
                contentValues.put(IAutoDBItem.getColName(field), (Integer) field.get(obj));
                AppMethodBeat.o(158072);
                return;
            }
            contentValues.put(IAutoDBItem.getColName(field), Integer.valueOf(field.getInt(obj)));
            AppMethodBeat.o(158072);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158072);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158073);
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i2));
                AppMethodBeat.o(158073);
                return;
            }
            field.set(obj, Float.valueOf(cursor.getFloat(i2)));
            AppMethodBeat.o(158073);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158073);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158074);
        try {
            if (!field.getType().equals(Float.TYPE)) {
                contentValues.put(IAutoDBItem.getColName(field), (Float) field.get(obj));
                AppMethodBeat.o(158074);
                return;
            }
            contentValues.put(IAutoDBItem.getColName(field), Float.valueOf(field.getFloat(obj)));
            AppMethodBeat.o(158074);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158074);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158075);
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i2));
                AppMethodBeat.o(158075);
                return;
            }
            field.set(obj, Double.valueOf(cursor.getDouble(i2)));
            AppMethodBeat.o(158075);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158075);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158076);
        try {
            if (!field.getType().equals(Double.TYPE)) {
                contentValues.put(IAutoDBItem.getColName(field), (Double) field.get(obj));
                AppMethodBeat.o(158076);
                return;
            }
            contentValues.put(IAutoDBItem.getColName(field), Double.valueOf(field.getDouble(obj)));
            AppMethodBeat.o(158076);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158076);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158077);
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i2));
                AppMethodBeat.o(158077);
                return;
            }
            field.set(obj, Long.valueOf(cursor.getLong(i2)));
            AppMethodBeat.o(158077);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158077);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158078);
        try {
            if (!field.getType().equals(Long.TYPE)) {
                contentValues.put(IAutoDBItem.getColName(field), (Long) field.get(obj));
                AppMethodBeat.o(158078);
                return;
            }
            contentValues.put(IAutoDBItem.getColName(field), Long.valueOf(field.getLong(obj)));
            AppMethodBeat.o(158078);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158078);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i2) {
        AppMethodBeat.i(158079);
        try {
            field.set(obj, cursor.getString(i2));
            AppMethodBeat.o(158079);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158079);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(158080);
        try {
            contentValues.put(IAutoDBItem.getColName(field), (String) field.get(obj));
            AppMethodBeat.o(158080);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(158080);
        }
    }
}

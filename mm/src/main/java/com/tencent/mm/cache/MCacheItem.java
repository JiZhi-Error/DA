package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MCacheItem implements Parcelable {
    public static final Parcelable.Creator<MCacheItem> CREATOR = new Parcelable.Creator<MCacheItem>() {
        /* class com.tencent.mm.cache.MCacheItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MCacheItem[] newArray(int i2) {
            return new MCacheItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MCacheItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131948);
            MCacheItem mCacheItem = new MCacheItem(parcel);
            AppMethodBeat.o(131948);
            return mCacheItem;
        }
    };
    private IAutoDBItem gpG;

    static {
        AppMethodBeat.i(131969);
        AppMethodBeat.o(131969);
    }

    public MCacheItem(Parcel parcel) {
        AppMethodBeat.i(131966);
        this.gpG = c(parcel);
        AppMethodBeat.o(131966);
    }

    public MCacheItem(IAutoDBItem iAutoDBItem) {
        this.gpG = iAutoDBItem;
    }

    private IAutoDBItem c(Parcel parcel) {
        AppMethodBeat.i(131967);
        try {
            Class<?> cls = Class.forName(parcel.readString());
            try {
                this.gpG = (IAutoDBItem) cls.newInstance();
            } catch (Exception e2) {
            }
            Field[] validFields = IAutoDBItem.getValidFields(cls);
            for (Field field : validFields) {
                Method method = a.GET_METHODS.get(field.getType());
                if (method != null) {
                    try {
                        method.invoke(null, parcel, field, this.gpG);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e3));
                    }
                }
            }
            IAutoDBItem iAutoDBItem = this.gpG;
            AppMethodBeat.o(131967);
            return iAutoDBItem;
        } catch (Exception e4) {
            Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e4));
            AppMethodBeat.o(131967);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(131968);
        parcel.writeString(this.gpG.getClass().getName());
        Field[] validFields = IAutoDBItem.getValidFields(this.gpG.getClass());
        for (Field field : validFields) {
            Method method = a.SET_METHODS.get(field.getType());
            if (method != null) {
                try {
                    method.invoke(null, parcel, field, this.gpG);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        AppMethodBeat.o(131968);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public static Map<Class<?>, Method> GET_METHODS = new HashMap();
        public static Map<Class<?>, Method> SET_METHODS = new HashMap();

        a() {
        }

        static {
            AppMethodBeat.i(131965);
            try {
                SET_METHODS.put(byte[].class, a.class.getMethod("keep_writeByteArray", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Short.TYPE, a.class.getMethod("keep_writeShort", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Short.class, a.class.getMethod("keep_writeShort", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Boolean.class, a.class.getMethod("keep_writeBoolean", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Integer.TYPE, a.class.getMethod("keep_writeInt", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Integer.class, a.class.getMethod("keep_writeInt", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Float.TYPE, a.class.getMethod("keep_writeFloat", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Float.class, a.class.getMethod("keep_writeFloat", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Double.TYPE, a.class.getMethod("keep_writeDouble", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Double.class, a.class.getMethod("keep_writeDouble", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Long.TYPE, a.class.getMethod("keep_writeLong", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(Long.class, a.class.getMethod("keep_writeLong", Parcel.class, Field.class, Object.class));
                SET_METHODS.put(String.class, a.class.getMethod("keep_writeString", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(byte[].class, a.class.getMethod("keep_readByteArray", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Short.TYPE, a.class.getMethod("keep_readShort", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Short.class, a.class.getMethod("keep_readShort", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Boolean.class, a.class.getMethod("keep_readBoolean", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Integer.TYPE, a.class.getMethod("keep_readInt", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Integer.class, a.class.getMethod("keep_readInt", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Float.TYPE, a.class.getMethod("keep_readFloat", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Float.class, a.class.getMethod("keep_readFloat", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Double.TYPE, a.class.getMethod("keep_readDouble", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Double.class, a.class.getMethod("keep_readDouble", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Long.TYPE, a.class.getMethod("keep_readLong", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(Long.class, a.class.getMethod("keep_readLong", Parcel.class, Field.class, Object.class));
                GET_METHODS.put(String.class, a.class.getMethod("keep_readString", Parcel.class, Field.class, Object.class));
                AppMethodBeat.o(131965);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131965);
            }
        }

        public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131949);
            try {
                parcel.writeByteArray((byte[]) field.get(obj));
                AppMethodBeat.o(131949);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131949);
            }
        }

        public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131950);
            try {
                parcel.writeInt(field.getShort(obj));
                AppMethodBeat.o(131950);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131950);
            }
        }

        public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131951);
            try {
                parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
                AppMethodBeat.o(131951);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131951);
            }
        }

        public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131952);
            try {
                parcel.writeInt(field.getInt(obj));
                AppMethodBeat.o(131952);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131952);
            }
        }

        public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131953);
            try {
                parcel.writeFloat(field.getFloat(obj));
                AppMethodBeat.o(131953);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131953);
            }
        }

        public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131954);
            try {
                parcel.writeDouble(field.getDouble(obj));
                AppMethodBeat.o(131954);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131954);
            }
        }

        public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131955);
            try {
                parcel.writeLong(field.getLong(obj));
                AppMethodBeat.o(131955);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131955);
            }
        }

        public static void keep_writeString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131956);
            try {
                parcel.writeString((String) field.get(obj));
                AppMethodBeat.o(131956);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131956);
            }
        }

        public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131957);
            try {
                field.set(obj, parcel.createByteArray());
                AppMethodBeat.o(131957);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131957);
            }
        }

        public static void keep_readShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131958);
            try {
                field.setShort(obj, (short) parcel.readInt());
                AppMethodBeat.o(131958);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131958);
            }
        }

        public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131959);
            try {
                field.setBoolean(obj, parcel.readInt() != 0);
                AppMethodBeat.o(131959);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131959);
            }
        }

        public static void keep_readInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131960);
            try {
                field.setInt(obj, parcel.readInt());
                AppMethodBeat.o(131960);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131960);
            }
        }

        public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131961);
            try {
                field.setFloat(obj, parcel.readFloat());
                AppMethodBeat.o(131961);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131961);
            }
        }

        public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131962);
            try {
                field.setDouble(obj, parcel.readDouble());
                AppMethodBeat.o(131962);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131962);
            }
        }

        public static void keep_readLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131963);
            try {
                field.set(obj, Long.valueOf(parcel.readLong()));
                AppMethodBeat.o(131963);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131963);
            }
        }

        public static void keep_readString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(131964);
            try {
                field.set(obj, parcel.readString());
                AppMethodBeat.o(131964);
            } catch (Exception e2) {
                Log.e("MicroMsg.MCacheItem", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(131964);
            }
        }
    }
}

package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns = {"_id", "key", "type", "value"};
    private final ContentResolver cr;
    private REditor editor = null;
    private final HashMap<String, Object> values = new HashMap<>();

    static class REditor implements SharedPreferences.Editor {
        private boolean clear = false;
        private ContentResolver cr;
        private Set<String> remove = new HashSet();
        private Map<String, Object> values = new HashMap();

        public REditor(ContentResolver contentResolver) {
            AppMethodBeat.i(3782);
            this.cr = contentResolver;
            AppMethodBeat.o(3782);
        }

        public void apply() {
        }

        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        public boolean commit() {
            int i2;
            boolean z;
            AppMethodBeat.i(3789);
            ContentValues contentValues = new ContentValues();
            if (this.clear) {
                this.cr.delete(a.f1495a, null, null);
                this.clear = false;
            }
            Iterator<String> it = this.remove.iterator();
            while (it.hasNext()) {
                this.cr.delete(a.f1495a, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.values.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                    i2 = 0;
                } else if (value instanceof Integer) {
                    i2 = 1;
                } else if (value instanceof Long) {
                    i2 = 2;
                } else if (value instanceof String) {
                    i2 = 3;
                } else if (value instanceof Boolean) {
                    i2 = 4;
                } else if (value instanceof Float) {
                    i2 = 5;
                } else if (value instanceof Double) {
                    i2 = 6;
                } else {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value.getClass().toString());
                    i2 = 0;
                }
                if (i2 == 0) {
                    z = false;
                } else {
                    contentValues.put("type", Integer.valueOf(i2));
                    contentValues.put("value", value.toString());
                    z = true;
                }
                if (z) {
                    this.cr.update(a.f1495a, contentValues, "key = ?", new String[]{entry.getKey()});
                }
            }
            AppMethodBeat.o(3789);
            return true;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(3787);
            this.values.put(str, Boolean.valueOf(z));
            this.remove.remove(str);
            AppMethodBeat.o(3787);
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f2) {
            AppMethodBeat.i(3786);
            this.values.put(str, Float.valueOf(f2));
            this.remove.remove(str);
            AppMethodBeat.o(3786);
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i2) {
            AppMethodBeat.i(3784);
            this.values.put(str, Integer.valueOf(i2));
            this.remove.remove(str);
            AppMethodBeat.o(3784);
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j2) {
            AppMethodBeat.i(3785);
            this.values.put(str, Long.valueOf(j2));
            this.remove.remove(str);
            AppMethodBeat.o(3785);
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            AppMethodBeat.i(3783);
            this.values.put(str, str2);
            this.remove.remove(str);
            AppMethodBeat.o(3783);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public SharedPreferences.Editor remove(String str) {
            AppMethodBeat.i(3788);
            this.remove.add(str);
            AppMethodBeat.o(3788);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        AppMethodBeat.i(3768);
        this.cr = context.getContentResolver();
        AppMethodBeat.o(3768);
    }

    private Object getValue(String str) {
        AppMethodBeat.i(3769);
        try {
            Cursor query = this.cr.query(a.f1495a, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.o(3769);
                return null;
            }
            Object a2 = query.moveToFirst() ? com.tencent.mm.opensdk.channel.a.a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            AppMethodBeat.o(3769);
            return a2;
        } catch (Exception e2) {
            Log.e(TAG, "getValue exception:" + e2.getMessage());
            AppMethodBeat.o(3769);
            return null;
        }
    }

    public boolean contains(String str) {
        AppMethodBeat.i(3776);
        if (getValue(str) != null) {
            AppMethodBeat.o(3776);
            return true;
        }
        AppMethodBeat.o(3776);
        return false;
    }

    public SharedPreferences.Editor edit() {
        AppMethodBeat.i(3777);
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        REditor rEditor = this.editor;
        AppMethodBeat.o(3777);
        return rEditor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        AppMethodBeat.i(3770);
        try {
            Cursor query = this.cr.query(a.f1495a, this.columns, null, null, null);
            if (query == null) {
                AppMethodBeat.o(3770);
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), com.tencent.mm.opensdk.channel.a.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            HashMap<String, Object> hashMap = this.values;
            AppMethodBeat.o(3770);
            return hashMap;
        } catch (Exception e2) {
            Log.e(TAG, "getAll exception:" + e2.getMessage());
            HashMap<String, Object> hashMap2 = this.values;
            AppMethodBeat.o(3770);
            return hashMap2;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(3775);
        Object value = getValue(str);
        if (value != null && (value instanceof Boolean)) {
            z = ((Boolean) value).booleanValue();
        }
        AppMethodBeat.o(3775);
        return z;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(3774);
        Object value = getValue(str);
        if (value != null && (value instanceof Float)) {
            f2 = ((Float) value).floatValue();
        }
        AppMethodBeat.o(3774);
        return f2;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(3772);
        Object value = getValue(str);
        if (value != null && (value instanceof Integer)) {
            i2 = ((Integer) value).intValue();
        }
        AppMethodBeat.o(3772);
        return i2;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(3773);
        Object value = getValue(str);
        if (value != null && (value instanceof Long)) {
            j2 = ((Long) value).longValue();
        }
        AppMethodBeat.o(3773);
        return j2;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(3771);
        Object value = getValue(str);
        if (value != null && (value instanceof String)) {
            str2 = (String) value;
        }
        AppMethodBeat.o(3771);
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}

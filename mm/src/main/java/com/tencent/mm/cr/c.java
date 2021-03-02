package com.tencent.mm.cr;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c implements SharedPreferences, SharedPreferences.Editor {
    MultiProcessMMKV Rzl;

    public c(MultiProcessMMKV multiProcessMMKV) {
        this.Rzl = multiProcessMMKV;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        AppMethodBeat.i(152921);
        HashMap hashMap = new HashMap();
        String[] allKeys = this.Rzl.allKeys();
        if (allKeys == null) {
            AppMethodBeat.o(152921);
        } else {
            for (String str : allKeys) {
                hashMap.put(str, "");
            }
            AppMethodBeat.o(152921);
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(152922);
        String string = this.Rzl.getString(str, str2);
        AppMethodBeat.o(152922);
        return string;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        AppMethodBeat.i(152923);
        Set<String> stringSet = this.Rzl.getStringSet(str, set);
        AppMethodBeat.o(152923);
        return stringSet;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(152924);
        int i3 = this.Rzl.getInt(str, i2);
        AppMethodBeat.o(152924);
        return i3;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(152925);
        long j3 = this.Rzl.getLong(str, j2);
        AppMethodBeat.o(152925);
        return j3;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(152926);
        float f3 = this.Rzl.getFloat(str, f2);
        AppMethodBeat.o(152926);
        return f3;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(152927);
        boolean z2 = this.Rzl.getBoolean(str, z);
        AppMethodBeat.o(152927);
        return z2;
    }

    public boolean contains(String str) {
        AppMethodBeat.i(152928);
        boolean contains = this.Rzl.contains(str);
        AppMethodBeat.o(152928);
        return contains;
    }

    public SharedPreferences.Editor edit() {
        AppMethodBeat.i(152929);
        SharedPreferences.Editor edit = this.Rzl.edit();
        AppMethodBeat.o(152929);
        return edit;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(152930);
        this.Rzl.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.o(152930);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(152931);
        this.Rzl.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.o(152931);
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        AppMethodBeat.i(152932);
        SharedPreferences.Editor putString = this.Rzl.putString(str, str2);
        AppMethodBeat.o(152932);
        return putString;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.i(152933);
        SharedPreferences.Editor putStringSet = this.Rzl.putStringSet(str, set);
        AppMethodBeat.o(152933);
        return putStringSet;
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        AppMethodBeat.i(152934);
        SharedPreferences.Editor putInt = this.Rzl.putInt(str, i2);
        AppMethodBeat.o(152934);
        return putInt;
    }

    public SharedPreferences.Editor putLong(String str, long j2) {
        AppMethodBeat.i(152935);
        SharedPreferences.Editor putLong = this.Rzl.putLong(str, j2);
        AppMethodBeat.o(152935);
        return putLong;
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        AppMethodBeat.i(152936);
        SharedPreferences.Editor putFloat = this.Rzl.putFloat(str, f2);
        AppMethodBeat.o(152936);
        return putFloat;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        AppMethodBeat.i(152937);
        SharedPreferences.Editor putBoolean = this.Rzl.putBoolean(str, z);
        AppMethodBeat.o(152937);
        return putBoolean;
    }

    public SharedPreferences.Editor remove(String str) {
        AppMethodBeat.i(152938);
        SharedPreferences.Editor remove = this.Rzl.remove(str);
        AppMethodBeat.o(152938);
        return remove;
    }

    public SharedPreferences.Editor clear() {
        AppMethodBeat.i(152939);
        SharedPreferences.Editor clear = this.Rzl.clear();
        AppMethodBeat.o(152939);
        return clear;
    }

    public boolean commit() {
        AppMethodBeat.i(152940);
        boolean commit = this.Rzl.commit();
        AppMethodBeat.o(152940);
        return commit;
    }

    public void apply() {
        AppMethodBeat.i(152941);
        this.Rzl.apply();
        AppMethodBeat.o(152941);
    }
}

package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.Set;

public class ImmutableBundle {
    private static final String TAG = "MicroMsg.ImmutableBundle";
    private boolean mImmutable;
    ArrayMap<String, Object> mMap;

    public ImmutableBundle(ArrayMap<String, Object> arrayMap) {
        AppMethodBeat.i(200846);
        this.mMap = null;
        this.mImmutable = false;
        this.mMap = new ArrayMap<>(arrayMap);
        AppMethodBeat.o(200846);
    }

    public ImmutableBundle() {
        AppMethodBeat.i(125223);
        this.mMap = null;
        this.mImmutable = false;
        this.mMap = new ArrayMap<>();
        AppMethodBeat.o(125223);
    }

    public void putAll(ArrayMap arrayMap) {
        AppMethodBeat.i(200847);
        if (this.mImmutable) {
            AppMethodBeat.o(200847);
            return;
        }
        this.mMap.putAll((ArrayMap<? extends String, ? extends Object>) arrayMap);
        AppMethodBeat.o(200847);
    }

    public void markImmutable() {
        this.mImmutable = true;
    }

    public int size() {
        AppMethodBeat.i(200848);
        int size = this.mMap.size();
        AppMethodBeat.o(200848);
        return size;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(200849);
        boolean isEmpty = this.mMap.isEmpty();
        AppMethodBeat.o(200849);
        return isEmpty;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(200850);
        boolean containsKey = this.mMap.containsKey(str);
        AppMethodBeat.o(200850);
        return containsKey;
    }

    public Object get(String str) {
        AppMethodBeat.i(200851);
        Object obj = this.mMap.get(str);
        AppMethodBeat.o(200851);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(200852);
        Set<String> keySet = this.mMap.keySet();
        AppMethodBeat.o(200852);
        return keySet;
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.i(200853);
        boolean z = getBoolean(str, false);
        AppMethodBeat.o(200853);
        return z;
    }

    /* access modifiers changed from: package-private */
    public void typeWarning(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        AppMethodBeat.i(125224);
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
        AppMethodBeat.o(125224);
    }

    /* access modifiers changed from: package-private */
    public void typeWarning(String str, Object obj, String str2, ClassCastException classCastException) {
        AppMethodBeat.i(200854);
        typeWarning(str, obj, str2, "<null>", classCastException);
        AppMethodBeat.o(200854);
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(200855);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200855);
        } else {
            try {
                z = ((Boolean) obj).booleanValue();
                AppMethodBeat.o(200855);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Boolean", Boolean.valueOf(z), e2);
                AppMethodBeat.o(200855);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public byte getByte(String str) {
        AppMethodBeat.i(200856);
        byte byteValue = getByte(str, (byte) 0).byteValue();
        AppMethodBeat.o(200856);
        return byteValue;
    }

    /* access modifiers changed from: package-private */
    public Byte getByte(String str, byte b2) {
        AppMethodBeat.i(200857);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            Byte valueOf = Byte.valueOf(b2);
            AppMethodBeat.o(200857);
            return valueOf;
        }
        try {
            Byte b3 = (Byte) obj;
            AppMethodBeat.o(200857);
            return b3;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Byte", Byte.valueOf(b2), e2);
            Byte valueOf2 = Byte.valueOf(b2);
            AppMethodBeat.o(200857);
            return valueOf2;
        }
    }

    /* access modifiers changed from: package-private */
    public char getChar(String str) {
        AppMethodBeat.i(200858);
        char c2 = getChar(str, 0);
        AppMethodBeat.o(200858);
        return c2;
    }

    /* access modifiers changed from: package-private */
    public char getChar(String str, char c2) {
        AppMethodBeat.i(200859);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200859);
        } else {
            try {
                c2 = ((Character) obj).charValue();
                AppMethodBeat.o(200859);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Character", Character.valueOf(c2), e2);
                AppMethodBeat.o(200859);
            }
        }
        return c2;
    }

    /* access modifiers changed from: package-private */
    public short getShort(String str) {
        AppMethodBeat.i(200860);
        short s = getShort(str, 0);
        AppMethodBeat.o(200860);
        return s;
    }

    /* access modifiers changed from: package-private */
    public short getShort(String str, short s) {
        AppMethodBeat.i(200861);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200861);
        } else {
            try {
                s = ((Short) obj).shortValue();
                AppMethodBeat.o(200861);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Short", Short.valueOf(s), e2);
                AppMethodBeat.o(200861);
            }
        }
        return s;
    }

    public int getInt(String str) {
        AppMethodBeat.i(200862);
        int i2 = getInt(str, 0);
        AppMethodBeat.o(200862);
        return i2;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(200863);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200863);
        } else {
            try {
                i2 = ((Integer) obj).intValue();
                AppMethodBeat.o(200863);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, DownloadSetting.TYPE_INTEGER, Integer.valueOf(i2), e2);
                AppMethodBeat.o(200863);
            }
        }
        return i2;
    }

    public long getLong(String str) {
        AppMethodBeat.i(200864);
        long j2 = getLong(str, 0);
        AppMethodBeat.o(200864);
        return j2;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(200865);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200865);
        } else {
            try {
                j2 = ((Long) obj).longValue();
                AppMethodBeat.o(200865);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Long", Long.valueOf(j2), e2);
                AppMethodBeat.o(200865);
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public float getFloat(String str) {
        AppMethodBeat.i(200866);
        float f2 = getFloat(str, 0.0f);
        AppMethodBeat.o(200866);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public float getFloat(String str, float f2) {
        AppMethodBeat.i(200867);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200867);
        } else {
            try {
                f2 = ((Float) obj).floatValue();
                AppMethodBeat.o(200867);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Float", Float.valueOf(f2), e2);
                AppMethodBeat.o(200867);
            }
        }
        return f2;
    }

    public double getDouble(String str) {
        AppMethodBeat.i(200868);
        double d2 = getDouble(str, 0.0d);
        AppMethodBeat.o(200868);
        return d2;
    }

    public double getDouble(String str, double d2) {
        AppMethodBeat.i(200869);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200869);
        } else {
            try {
                d2 = ((Double) obj).doubleValue();
                AppMethodBeat.o(200869);
            } catch (ClassCastException e2) {
                typeWarning(str, obj, "Double", Double.valueOf(d2), e2);
                AppMethodBeat.o(200869);
            }
        }
        return d2;
    }

    public String getString(String str) {
        AppMethodBeat.i(125226);
        Object obj = this.mMap.get(str);
        try {
            String str2 = (String) obj;
            AppMethodBeat.o(125226);
            return str2;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "String", e2);
            AppMethodBeat.o(125226);
            return null;
        }
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(200870);
        String string = getString(str);
        if (string == null) {
            AppMethodBeat.o(200870);
            return str2;
        }
        AppMethodBeat.o(200870);
        return string;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCharSequence(String str) {
        AppMethodBeat.i(200871);
        Object obj = this.mMap.get(str);
        try {
            CharSequence charSequence = (CharSequence) obj;
            AppMethodBeat.o(200871);
            return charSequence;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "CharSequence", e2);
            AppMethodBeat.o(200871);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCharSequence(String str, CharSequence charSequence) {
        AppMethodBeat.i(200872);
        CharSequence charSequence2 = getCharSequence(str);
        if (charSequence2 == null) {
            AppMethodBeat.o(200872);
            return charSequence;
        }
        AppMethodBeat.o(200872);
        return charSequence2;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Integer> getIntegerArrayList(String str) {
        AppMethodBeat.i(200873);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200873);
            return null;
        }
        try {
            ArrayList<Integer> arrayList = (ArrayList) obj;
            AppMethodBeat.o(200873);
            return arrayList;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "ArrayList<Integer>", e2);
            AppMethodBeat.o(200873);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> getStringArrayList(String str) {
        AppMethodBeat.i(200874);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200874);
            return null;
        }
        try {
            ArrayList<String> arrayList = (ArrayList) obj;
            AppMethodBeat.o(200874);
            return arrayList;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "ArrayList<String>", e2);
            AppMethodBeat.o(200874);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<CharSequence> getCharSequenceArrayList(String str) {
        AppMethodBeat.i(200875);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200875);
            return null;
        }
        try {
            ArrayList<CharSequence> arrayList = (ArrayList) obj;
            AppMethodBeat.o(200875);
            return arrayList;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "ArrayList<CharSequence>", e2);
            AppMethodBeat.o(200875);
            return null;
        }
    }

    public boolean[] getBooleanArray(String str) {
        AppMethodBeat.i(200876);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200876);
            return null;
        }
        try {
            boolean[] zArr = (boolean[]) obj;
            AppMethodBeat.o(200876);
            return zArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "byte[]", e2);
            AppMethodBeat.o(200876);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getByteArray(String str) {
        AppMethodBeat.i(200877);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200877);
            return null;
        }
        try {
            byte[] bArr = (byte[]) obj;
            AppMethodBeat.o(200877);
            return bArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "byte[]", e2);
            AppMethodBeat.o(200877);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public short[] getShortArray(String str) {
        AppMethodBeat.i(200878);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200878);
            return null;
        }
        try {
            short[] sArr = (short[]) obj;
            AppMethodBeat.o(200878);
            return sArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "short[]", e2);
            AppMethodBeat.o(200878);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public char[] getCharArray(String str) {
        AppMethodBeat.i(200879);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200879);
            return null;
        }
        try {
            char[] cArr = (char[]) obj;
            AppMethodBeat.o(200879);
            return cArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "char[]", e2);
            AppMethodBeat.o(200879);
            return null;
        }
    }

    public int[] getIntArray(String str) {
        AppMethodBeat.i(200880);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200880);
            return null;
        }
        try {
            int[] iArr = (int[]) obj;
            AppMethodBeat.o(200880);
            return iArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "int[]", e2);
            AppMethodBeat.o(200880);
            return null;
        }
    }

    public long[] getLongArray(String str) {
        AppMethodBeat.i(200881);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200881);
            return null;
        }
        try {
            long[] jArr = (long[]) obj;
            AppMethodBeat.o(200881);
            return jArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "long[]", e2);
            AppMethodBeat.o(200881);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public float[] getFloatArray(String str) {
        AppMethodBeat.i(200882);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200882);
            return null;
        }
        try {
            float[] fArr = (float[]) obj;
            AppMethodBeat.o(200882);
            return fArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "float[]", e2);
            AppMethodBeat.o(200882);
            return null;
        }
    }

    public double[] getDoubleArray(String str) {
        AppMethodBeat.i(200883);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200883);
            return null;
        }
        try {
            double[] dArr = (double[]) obj;
            AppMethodBeat.o(200883);
            return dArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "double[]", e2);
            AppMethodBeat.o(200883);
            return null;
        }
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.i(200884);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200884);
            return null;
        }
        try {
            String[] strArr = (String[]) obj;
            AppMethodBeat.o(200884);
            return strArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "String[]", e2);
            AppMethodBeat.o(200884);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence[] getCharSequenceArray(String str) {
        AppMethodBeat.i(200885);
        Object obj = this.mMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(200885);
            return null;
        }
        try {
            CharSequence[] charSequenceArr = (CharSequence[]) obj;
            AppMethodBeat.o(200885);
            return charSequenceArr;
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "CharSequence[]", e2);
            AppMethodBeat.o(200885);
            return null;
        }
    }
}

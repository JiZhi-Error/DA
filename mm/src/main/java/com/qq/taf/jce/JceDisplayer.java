package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class JceDisplayer {
    private int _level = 0;
    private StringBuilder sb;

    private void ps(String str) {
        AppMethodBeat.i(109596);
        for (int i2 = 0; i2 < this._level; i2++) {
            this.sb.append('\t');
        }
        if (str != null) {
            this.sb.append(str).append(": ");
        }
        AppMethodBeat.o(109596);
    }

    public JceDisplayer(StringBuilder sb2, int i2) {
        this.sb = sb2;
        this._level = i2;
    }

    public JceDisplayer(StringBuilder sb2) {
        this.sb = sb2;
    }

    public final JceDisplayer display(boolean z, String str) {
        AppMethodBeat.i(109597);
        ps(str);
        this.sb.append(z ? 'T' : 'F').append('\n');
        AppMethodBeat.o(109597);
        return this;
    }

    public final JceDisplayer displaySimple(boolean z, boolean z2) {
        AppMethodBeat.i(109598);
        this.sb.append(z ? 'T' : 'F');
        if (z2) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109598);
        return this;
    }

    public final JceDisplayer display(byte b2, String str) {
        AppMethodBeat.i(109599);
        ps(str);
        this.sb.append((int) b2).append('\n');
        AppMethodBeat.o(109599);
        return this;
    }

    public final JceDisplayer displaySimple(byte b2, boolean z) {
        AppMethodBeat.i(109600);
        this.sb.append((int) b2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109600);
        return this;
    }

    public final JceDisplayer display(char c2, String str) {
        AppMethodBeat.i(109601);
        ps(str);
        this.sb.append(c2).append('\n');
        AppMethodBeat.o(109601);
        return this;
    }

    public final JceDisplayer displaySimple(char c2, boolean z) {
        AppMethodBeat.i(109602);
        this.sb.append(c2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109602);
        return this;
    }

    public final JceDisplayer display(short s, String str) {
        AppMethodBeat.i(109603);
        ps(str);
        this.sb.append((int) s).append('\n');
        AppMethodBeat.o(109603);
        return this;
    }

    public final JceDisplayer displaySimple(short s, boolean z) {
        AppMethodBeat.i(109604);
        this.sb.append((int) s);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109604);
        return this;
    }

    public final JceDisplayer display(int i2, String str) {
        AppMethodBeat.i(109605);
        ps(str);
        this.sb.append(i2).append('\n');
        AppMethodBeat.o(109605);
        return this;
    }

    public final JceDisplayer displaySimple(int i2, boolean z) {
        AppMethodBeat.i(109606);
        this.sb.append(i2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109606);
        return this;
    }

    public final JceDisplayer display(long j2, String str) {
        AppMethodBeat.i(109607);
        ps(str);
        this.sb.append(j2).append('\n');
        AppMethodBeat.o(109607);
        return this;
    }

    public final JceDisplayer displaySimple(long j2, boolean z) {
        AppMethodBeat.i(109608);
        this.sb.append(j2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109608);
        return this;
    }

    public final JceDisplayer display(float f2, String str) {
        AppMethodBeat.i(109609);
        ps(str);
        this.sb.append(f2).append('\n');
        AppMethodBeat.o(109609);
        return this;
    }

    public final JceDisplayer displaySimple(float f2, boolean z) {
        AppMethodBeat.i(109610);
        this.sb.append(f2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109610);
        return this;
    }

    public final JceDisplayer display(double d2, String str) {
        AppMethodBeat.i(109611);
        ps(str);
        this.sb.append(d2).append('\n');
        AppMethodBeat.o(109611);
        return this;
    }

    public final JceDisplayer displaySimple(double d2, boolean z) {
        AppMethodBeat.i(109612);
        this.sb.append(d2);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109612);
        return this;
    }

    public final JceDisplayer display(String str, String str2) {
        AppMethodBeat.i(109613);
        ps(str2);
        if (str == null) {
            this.sb.append("null\n");
        } else {
            this.sb.append(str).append('\n');
        }
        AppMethodBeat.o(109613);
        return this;
    }

    public final JceDisplayer displaySimple(String str, boolean z) {
        AppMethodBeat.i(109614);
        if (str == null) {
            this.sb.append(BuildConfig.COMMAND);
        } else {
            this.sb.append(str);
        }
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109614);
        return this;
    }

    public final JceDisplayer display(byte[] bArr, String str) {
        AppMethodBeat.i(109615);
        ps(str);
        if (bArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109615);
        } else if (bArr.length == 0) {
            this.sb.append(bArr.length).append(", []\n");
            AppMethodBeat.o(109615);
        } else {
            this.sb.append(bArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (byte b2 : bArr) {
                jceDisplayer.display(b2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109615);
        }
        return this;
    }

    public final JceDisplayer displaySimple(byte[] bArr, boolean z) {
        AppMethodBeat.i(109616);
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109616);
        } else {
            this.sb.append(HexUtil.bytes2HexStr(bArr));
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109616);
        }
        return this;
    }

    public final JceDisplayer display(char[] cArr, String str) {
        AppMethodBeat.i(109617);
        ps(str);
        if (cArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109617);
        } else if (cArr.length == 0) {
            this.sb.append(cArr.length).append(", []\n");
            AppMethodBeat.o(109617);
        } else {
            this.sb.append(cArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (char c2 : cArr) {
                jceDisplayer.display(c2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109617);
        }
        return this;
    }

    public final JceDisplayer displaySimple(char[] cArr, boolean z) {
        AppMethodBeat.i(109618);
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109618);
        } else {
            this.sb.append(new String(cArr));
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109618);
        }
        return this;
    }

    public final JceDisplayer display(short[] sArr, String str) {
        AppMethodBeat.i(109619);
        ps(str);
        if (sArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109619);
        } else if (sArr.length == 0) {
            this.sb.append(sArr.length).append(", []\n");
            AppMethodBeat.o(109619);
        } else {
            this.sb.append(sArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (short s : sArr) {
                jceDisplayer.display(s, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109619);
        }
        return this;
    }

    public final JceDisplayer displaySimple(short[] sArr, boolean z) {
        AppMethodBeat.i(109620);
        if (sArr == null || sArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109620);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < sArr.length; i2++) {
                short s = sArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(s, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109620);
        }
        return this;
    }

    public final JceDisplayer display(int[] iArr, String str) {
        AppMethodBeat.i(109621);
        ps(str);
        if (iArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109621);
        } else if (iArr.length == 0) {
            this.sb.append(iArr.length).append(", []\n");
            AppMethodBeat.o(109621);
        } else {
            this.sb.append(iArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 : iArr) {
                jceDisplayer.display(i2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109621);
        }
        return this;
    }

    public final JceDisplayer displaySimple(int[] iArr, boolean z) {
        AppMethodBeat.i(109622);
        if (iArr == null || iArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109622);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(i3, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109622);
        }
        return this;
    }

    public final JceDisplayer display(long[] jArr, String str) {
        AppMethodBeat.i(109623);
        ps(str);
        if (jArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109623);
        } else if (jArr.length == 0) {
            this.sb.append(jArr.length).append(", []\n");
            AppMethodBeat.o(109623);
        } else {
            this.sb.append(jArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (long j2 : jArr) {
                jceDisplayer.display(j2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109623);
        }
        return this;
    }

    public final JceDisplayer displaySimple(long[] jArr, boolean z) {
        AppMethodBeat.i(109624);
        if (jArr == null || jArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109624);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < jArr.length; i2++) {
                long j2 = jArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(j2, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109624);
        }
        return this;
    }

    public final JceDisplayer display(float[] fArr, String str) {
        AppMethodBeat.i(109625);
        ps(str);
        if (fArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109625);
        } else if (fArr.length == 0) {
            this.sb.append(fArr.length).append(", []\n");
            AppMethodBeat.o(109625);
        } else {
            this.sb.append(fArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (float f2 : fArr) {
                jceDisplayer.display(f2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109625);
        }
        return this;
    }

    public final JceDisplayer displaySimple(float[] fArr, boolean z) {
        AppMethodBeat.i(109626);
        if (fArr == null || fArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109626);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < fArr.length; i2++) {
                float f2 = fArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(f2, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109626);
        }
        return this;
    }

    public final JceDisplayer display(double[] dArr, String str) {
        AppMethodBeat.i(109627);
        ps(str);
        if (dArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109627);
        } else if (dArr.length == 0) {
            this.sb.append(dArr.length).append(", []\n");
            AppMethodBeat.o(109627);
        } else {
            this.sb.append(dArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (double d2 : dArr) {
                jceDisplayer.display(d2, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109627);
        }
        return this;
    }

    public final JceDisplayer displaySimple(double[] dArr, boolean z) {
        AppMethodBeat.i(109628);
        if (dArr == null || dArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109628);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < dArr.length; i2++) {
                double d2 = dArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(d2, false);
            }
            this.sb.append("[");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109628);
        }
        return this;
    }

    public final <K, V> JceDisplayer display(Map<K, V> map, String str) {
        AppMethodBeat.i(109629);
        ps(str);
        if (map == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109629);
        } else if (map.isEmpty()) {
            this.sb.append(map.size()).append(", {}\n");
            AppMethodBeat.o(109629);
        } else {
            this.sb.append(map.size()).append(", {\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            JceDisplayer jceDisplayer2 = new JceDisplayer(this.sb, this._level + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                jceDisplayer.display('(', (String) null);
                jceDisplayer2.display((Object) entry.getKey(), (String) null);
                jceDisplayer2.display((Object) entry.getValue(), (String) null);
                jceDisplayer.display(')', (String) null);
            }
            display('}', (String) null);
            AppMethodBeat.o(109629);
        }
        return this;
    }

    public final <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z) {
        AppMethodBeat.i(109630);
        if (map == null || map.isEmpty()) {
            this.sb.append("{}");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109630);
        } else {
            this.sb.append("{");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 2);
            boolean z2 = true;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!z2) {
                    this.sb.append(",");
                }
                jceDisplayer.displaySimple((Object) entry.getKey(), true);
                jceDisplayer.displaySimple((Object) entry.getValue(), false);
                z2 = false;
            }
            this.sb.append("}");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109630);
        }
        return this;
    }

    public final <T> JceDisplayer display(T[] tArr, String str) {
        AppMethodBeat.i(109631);
        ps(str);
        if (tArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(109631);
        } else if (tArr.length == 0) {
            this.sb.append(tArr.length).append(", []\n");
            AppMethodBeat.o(109631);
        } else {
            this.sb.append(tArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (T t : tArr) {
                jceDisplayer.display((Object) t, (String) null);
            }
            display(']', (String) null);
            AppMethodBeat.o(109631);
        }
        return this;
    }

    public final <T> JceDisplayer displaySimple(T[] tArr, boolean z) {
        AppMethodBeat.i(109632);
        if (tArr == null || tArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109632);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i2 = 0; i2 < tArr.length; i2++) {
                T t = tArr[i2];
                if (i2 != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple((Object) t, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109632);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.qq.taf.jce.JceDisplayer */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> JceDisplayer display(Collection<T> collection, String str) {
        AppMethodBeat.i(109633);
        if (collection == null) {
            ps(str);
            this.sb.append("null\t");
            AppMethodBeat.o(109633);
            return this;
        }
        JceDisplayer display = display(collection.toArray(), str);
        AppMethodBeat.o(109633);
        return display;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.qq.taf.jce.JceDisplayer */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> JceDisplayer displaySimple(Collection<T> collection, boolean z) {
        AppMethodBeat.i(109634);
        if (collection == null) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(109634);
            return this;
        }
        JceDisplayer displaySimple = displaySimple(collection.toArray(), z);
        AppMethodBeat.o(109634);
        return displaySimple;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.qq.taf.jce.JceDisplayer */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> JceDisplayer display(T t, String str) {
        AppMethodBeat.i(109635);
        if (t == null) {
            this.sb.append("null\n");
        } else if (t instanceof Byte) {
            display(t.byteValue(), str);
        } else if (t instanceof Boolean) {
            display(t.booleanValue(), str);
        } else if (t instanceof Short) {
            display(t.shortValue(), str);
        } else if (t instanceof Integer) {
            display(t.intValue(), str);
        } else if (t instanceof Long) {
            display(t.longValue(), str);
        } else if (t instanceof Float) {
            display(t.floatValue(), str);
        } else if (t instanceof Double) {
            display(t.doubleValue(), str);
        } else if (t instanceof String) {
            display((String) t, str);
        } else if (t instanceof Map) {
            display((Map) t, str);
        } else if (t instanceof List) {
            display((Collection) t, str);
        } else if (t instanceof JceStruct) {
            display((JceStruct) t, str);
        } else if (t instanceof byte[]) {
            display((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            display((boolean[]) t, str);
        } else if (t instanceof short[]) {
            display((short[]) t, str);
        } else if (t instanceof int[]) {
            display((int[]) t, str);
        } else if (t instanceof long[]) {
            display((long[]) t, str);
        } else if (t instanceof float[]) {
            display((float[]) t, str);
        } else if (t instanceof double[]) {
            display((double[]) t, str);
        } else if (t.getClass().isArray()) {
            display((Object[]) t, str);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type.");
            AppMethodBeat.o(109635);
            throw jceEncodeException;
        }
        AppMethodBeat.o(109635);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.qq.taf.jce.JceDisplayer */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> JceDisplayer displaySimple(T t, boolean z) {
        AppMethodBeat.i(109636);
        if (t == null) {
            this.sb.append("null\n");
        } else if (t instanceof Byte) {
            displaySimple(t.byteValue(), z);
        } else if (t instanceof Boolean) {
            displaySimple(t.booleanValue(), z);
        } else if (t instanceof Short) {
            displaySimple(t.shortValue(), z);
        } else if (t instanceof Integer) {
            displaySimple(t.intValue(), z);
        } else if (t instanceof Long) {
            displaySimple(t.longValue(), z);
        } else if (t instanceof Float) {
            displaySimple(t.floatValue(), z);
        } else if (t instanceof Double) {
            displaySimple(t.doubleValue(), z);
        } else if (t instanceof String) {
            displaySimple((String) t, z);
        } else if (t instanceof Map) {
            displaySimple((Map) t, z);
        } else if (t instanceof List) {
            displaySimple((Collection) t, z);
        } else if (t instanceof JceStruct) {
            displaySimple((JceStruct) t, z);
        } else if (t instanceof byte[]) {
            displaySimple((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            displaySimple((boolean[]) t, z);
        } else if (t instanceof short[]) {
            displaySimple((short[]) t, z);
        } else if (t instanceof int[]) {
            displaySimple((int[]) t, z);
        } else if (t instanceof long[]) {
            displaySimple((long[]) t, z);
        } else if (t instanceof float[]) {
            displaySimple((float[]) t, z);
        } else if (t instanceof double[]) {
            displaySimple((double[]) t, z);
        } else if (t.getClass().isArray()) {
            displaySimple((Object[]) t, z);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type.");
            AppMethodBeat.o(109636);
            throw jceEncodeException;
        }
        AppMethodBeat.o(109636);
        return this;
    }

    public final JceDisplayer display(JceStruct jceStruct, String str) {
        AppMethodBeat.i(109637);
        display('{', str);
        if (jceStruct == null) {
            this.sb.append('\t').append(BuildConfig.COMMAND);
        } else {
            jceStruct.display(this.sb, this._level + 1);
        }
        display('}', (String) null);
        AppMethodBeat.o(109637);
        return this;
    }

    public final JceDisplayer displaySimple(JceStruct jceStruct, boolean z) {
        AppMethodBeat.i(109638);
        this.sb.append("{");
        if (jceStruct == null) {
            this.sb.append('\t').append(BuildConfig.COMMAND);
        } else {
            jceStruct.displaySimple(this.sb, this._level + 1);
        }
        this.sb.append("}");
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(109638);
        return this;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.i(109639);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(1.2d);
        System.out.println(sb2.toString());
        AppMethodBeat.o(109639);
    }
}

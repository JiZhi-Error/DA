package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.b.h;

public abstract class b implements Serializable {
    public static final b UgR = new a();
    public static final b UgS = new C2382b();
    public static final b UgT = new c();
    public static final b UgU = new d();
    public static final b UgV = new e();
    private static final ThreadLocal UgW = new ThreadLocal();
    String But = "[";
    String Buu = "]";
    boolean UgX = true;
    boolean UgY = true;
    boolean UgZ = false;
    boolean Uha = true;
    private String Uhb = "=";
    boolean Uhc = false;
    boolean Uhd = false;
    String Uhe = ",";
    private String Uhf = "{";
    private String Uhg = ",";
    private boolean Uhh = true;
    private String Uhi = "}";
    private boolean Uhj = true;
    String Uhk = "<null>";
    private String Uhl = "<size=";
    private String Uhm = ">";
    private String Uhn = "<";
    private String Uho = ">";

    private static Map hPN() {
        return (Map) UgW.get();
    }

    private static boolean gC(Object obj) {
        Map hPN = hPN();
        return hPN != null && hPN.containsKey(obj);
    }

    static void gD(Object obj) {
        if (obj != null) {
            Map hPN = hPN();
            if (hPN == null) {
                hPN = new WeakHashMap();
                UgW.set(hPN);
            }
            hPN.put(obj, null);
        }
    }

    static void gE(Object obj) {
        Map hPN;
        if (obj != null && (hPN = hPN()) != null) {
            hPN.remove(obj);
            if (hPN.isEmpty()) {
                UgW.set(null);
            }
        }
    }

    protected b() {
    }

    public final void b(StringBuffer stringBuffer, Object obj) {
        if (obj == null) {
            b(stringBuffer);
        } else {
            a(stringBuffer, null, obj, this.Uhj);
        }
        c(stringBuffer);
    }

    private void a(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (!gC(obj) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character)) {
            gD(obj);
            try {
                if (obj instanceof Collection) {
                    if (z) {
                        stringBuffer.append((Collection) obj);
                    } else {
                        a(stringBuffer, ((Collection) obj).size());
                    }
                } else if (obj instanceof Map) {
                    if (z) {
                        stringBuffer.append((Map) obj);
                    } else {
                        a(stringBuffer, ((Map) obj).size());
                    }
                } else if (obj instanceof long[]) {
                    if (z) {
                        a(stringBuffer, (long[]) obj);
                    } else {
                        a(stringBuffer, ((long[]) obj).length);
                    }
                } else if (obj instanceof int[]) {
                    if (z) {
                        a(stringBuffer, (int[]) obj);
                    } else {
                        a(stringBuffer, ((int[]) obj).length);
                    }
                } else if (obj instanceof short[]) {
                    if (z) {
                        a(stringBuffer, (short[]) obj);
                    } else {
                        a(stringBuffer, ((short[]) obj).length);
                    }
                } else if (obj instanceof byte[]) {
                    if (z) {
                        a(stringBuffer, (byte[]) obj);
                    } else {
                        a(stringBuffer, ((byte[]) obj).length);
                    }
                } else if (obj instanceof char[]) {
                    if (z) {
                        a(stringBuffer, (char[]) obj);
                    } else {
                        a(stringBuffer, ((char[]) obj).length);
                    }
                } else if (obj instanceof double[]) {
                    if (z) {
                        a(stringBuffer, (double[]) obj);
                    } else {
                        a(stringBuffer, ((double[]) obj).length);
                    }
                } else if (obj instanceof float[]) {
                    if (z) {
                        a(stringBuffer, (float[]) obj);
                    } else {
                        a(stringBuffer, ((float[]) obj).length);
                    }
                } else if (obj instanceof boolean[]) {
                    if (z) {
                        a(stringBuffer, (boolean[]) obj);
                    } else {
                        a(stringBuffer, ((boolean[]) obj).length);
                    }
                } else if (obj.getClass().isArray()) {
                    if (z) {
                        a(stringBuffer, str, (Object[]) obj);
                    } else {
                        a(stringBuffer, ((Object[]) obj).length);
                    }
                } else if (z) {
                    stringBuffer.append(obj);
                } else {
                    c(stringBuffer, obj);
                }
            } finally {
                gE(obj);
            }
        } else {
            org.apache.commons.b.e.a(stringBuffer, obj);
        }
    }

    private void c(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append(this.Uhn);
        stringBuffer.append(org.apache.commons.b.b.bE(obj.getClass()));
        stringBuffer.append(this.Uho);
    }

    private void a(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            if (obj == null) {
                b(stringBuffer);
            } else {
                a(stringBuffer, str, obj, this.Uhh);
            }
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(jArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(iArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append((int) sArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append((int) bArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(cArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(dArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(fArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void a(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append(this.Uhf);
        for (int i2 = 0; i2 < zArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.Uhg);
            }
            stringBuffer.append(zArr[i2]);
        }
        stringBuffer.append(this.Uhi);
    }

    private void b(StringBuffer stringBuffer) {
        stringBuffer.append(this.Uhk);
    }

    /* access modifiers changed from: package-private */
    public final void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.Uhe);
    }

    private void a(StringBuffer stringBuffer, int i2) {
        stringBuffer.append(this.Uhl);
        stringBuffer.append(i2);
        stringBuffer.append(this.Uhm);
    }

    /* access modifiers changed from: protected */
    public final void bvm(String str) {
        if (str == null) {
            str = "";
        }
        this.Buu = str;
    }

    static final class a extends b {
        a() {
        }

        private Object readResolve() {
            return b.UgR;
        }
    }

    static final class c extends b {
        c() {
            this.UgX = false;
        }

        private Object readResolve() {
            return b.UgT;
        }
    }

    static final class d extends b {
        d() {
            this.UgZ = true;
            this.Uha = false;
        }

        private Object readResolve() {
            return b.UgU;
        }
    }

    static final class e extends b {
        e() {
            AppMethodBeat.i(40699);
            this.UgY = false;
            this.Uha = false;
            this.UgX = false;
            this.But = "";
            bvm("");
            AppMethodBeat.o(40699);
        }

        private Object readResolve() {
            return b.UgV;
        }
    }

    /* renamed from: org.apache.commons.b.a.b$b  reason: collision with other inner class name */
    static final class C2382b extends b {
        C2382b() {
            AppMethodBeat.i(40698);
            this.But = "[";
            String stringBuffer = new StringBuffer().append(h.TTr).append("  ").toString();
            this.Uhe = stringBuffer == null ? "" : stringBuffer;
            this.Uhc = true;
            bvm(new StringBuffer().append(h.TTr).append("]").toString());
            AppMethodBeat.o(40698);
        }

        private Object readResolve() {
            return b.UgS;
        }
    }
}

package com.tencent.soter.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a {
    public abstract a ac(String... strArr);

    public abstract a ad(String... strArr);

    public abstract AlgorithmParameterSpec hlq();

    public abstract a hlr();

    public static a hw(String str, int i2) {
        if (!com.tencent.soter.core.a.hlj()) {
            d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new C2192a();
        } else if (Build.VERSION.SDK_INT >= 23) {
            return new b(str, i2);
        } else {
            return new c(str, i2);
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public static class b extends a {
        private KeyGenParameterSpec.Builder RPp = null;

        public b(String str, int i2) {
            AppMethodBeat.i(88633);
            this.RPp = new KeyGenParameterSpec.Builder(str, i2);
            AppMethodBeat.o(88633);
        }

        @Override // com.tencent.soter.core.b.a
        public final AlgorithmParameterSpec hlq() {
            AppMethodBeat.i(88634);
            KeyGenParameterSpec build = this.RPp.build();
            AppMethodBeat.o(88634);
            return build;
        }

        @Override // com.tencent.soter.core.b.a
        @SuppressLint({"WrongConstant"})
        public final a ac(String... strArr) {
            AppMethodBeat.i(88635);
            this.RPp.setDigests(strArr);
            AppMethodBeat.o(88635);
            return this;
        }

        @Override // com.tencent.soter.core.b.a
        @SuppressLint({"WrongConstant"})
        public final a ad(String... strArr) {
            AppMethodBeat.i(88636);
            this.RPp.setSignaturePaddings(strArr);
            AppMethodBeat.o(88636);
            return this;
        }

        @Override // com.tencent.soter.core.b.a
        public final a hlr() {
            AppMethodBeat.i(88637);
            this.RPp.setUserAuthenticationRequired(true);
            AppMethodBeat.o(88637);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends a {
        private Date RPA;
        private String[] RPB;
        private String[] RPC;
        private String[] RPD;
        private String[] RPE;
        private boolean RPF = true;
        private boolean RPG;
        private int RPH = -1;
        private final String RPq;
        private int RPr;
        private int RPs = -1;
        private AlgorithmParameterSpec RPt;
        private X500Principal RPu;
        private BigInteger RPv;
        private Date RPw;
        private Date RPx;
        private Date RPy;
        private Date RPz;

        public c(String str, int i2) {
            AppMethodBeat.i(88638);
            if (str == null) {
                NullPointerException nullPointerException = new NullPointerException("keystoreAlias == null");
                AppMethodBeat.o(88638);
                throw nullPointerException;
            } else if (str.isEmpty()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("keystoreAlias must not be empty");
                AppMethodBeat.o(88638);
                throw illegalArgumentException;
            } else {
                this.RPq = str;
                this.RPr = i2;
                AppMethodBeat.o(88638);
            }
        }

        @Override // com.tencent.soter.core.b.a
        public final a ac(String... strArr) {
            AppMethodBeat.i(88639);
            this.RPB = ae(strArr);
            AppMethodBeat.o(88639);
            return this;
        }

        @Override // com.tencent.soter.core.b.a
        public final a ad(String... strArr) {
            AppMethodBeat.i(88640);
            this.RPD = ae(strArr);
            AppMethodBeat.o(88640);
            return this;
        }

        @Override // com.tencent.soter.core.b.a
        public final a hlr() {
            this.RPG = true;
            return this;
        }

        @Override // com.tencent.soter.core.b.a
        public final AlgorithmParameterSpec hlq() {
            AppMethodBeat.i(88641);
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE).newInstance(this.RPq, Integer.valueOf(this.RPs), this.RPt, this.RPu, this.RPv, this.RPw, this.RPx, this.RPy, this.RPz, this.RPA, Integer.valueOf(this.RPr), this.RPB, this.RPC, this.RPD, this.RPE, Boolean.valueOf(this.RPF), Boolean.valueOf(this.RPG), Integer.valueOf(this.RPH));
            AppMethodBeat.o(88641);
            return algorithmParameterSpec;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.soter.core.b.a$a  reason: collision with other inner class name */
    public static class C2192a extends a {
        @Override // com.tencent.soter.core.b.a
        public final AlgorithmParameterSpec hlq() {
            return null;
        }

        @Override // com.tencent.soter.core.b.a
        public final a ac(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.b.a
        public final a ad(String... strArr) {
            return null;
        }

        @Override // com.tencent.soter.core.b.a
        public final a hlr() {
            return null;
        }
    }

    public static String[] ae(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}

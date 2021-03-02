package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class a<T> {
    final Set<Class<? super T>> bKJ;
    final Set<f> bKK;
    final d<T> bKL;
    private final int zzad;

    private a(Set<Class<? super T>> set, Set<f> set2, int i2, d<T> dVar) {
        AppMethodBeat.i(4072);
        this.bKJ = Collections.unmodifiableSet(set);
        this.bKK = Collections.unmodifiableSet(set2);
        this.zzad = i2;
        this.bKL = dVar;
        AppMethodBeat.o(4072);
    }

    /* synthetic */ a(Set set, Set set2, int i2, d dVar, byte b2) {
        this(set, set2, i2, dVar);
    }

    @KeepForSdk
    public static <T> a<T> a(Class<T> cls, T t) {
        AppMethodBeat.i(4075);
        a<T> xZ = z(cls).a(new j(t)).xZ();
        AppMethodBeat.o(4075);
        return xZ;
    }

    @KeepForSdk
    public static <T> C0121a<T> z(Class<T> cls) {
        AppMethodBeat.i(4074);
        C0121a<T> aVar = new C0121a<>(cls, new Class[0], (byte) 0);
        AppMethodBeat.o(4074);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(4073);
        String str = "Component<" + Arrays.toString(this.bKJ.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.bKK.toArray()) + "}";
        AppMethodBeat.o(4073);
        return str;
    }

    public final boolean xX() {
        return this.zzad == 1;
    }

    public final boolean xY() {
        return this.zzad == 2;
    }

    @KeepForSdk
    /* renamed from: com.google.firebase.components.a$a  reason: collision with other inner class name */
    public static class C0121a<T> {
        private final Set<Class<? super T>> bKJ;
        private final Set<f> bKK;
        private d<T> bKL;
        public int zzad;

        private C0121a(Class<T> cls, Class<? super T>... clsArr) {
            AppMethodBeat.i(4068);
            this.bKJ = new HashSet();
            this.bKK = new HashSet();
            this.zzad = 0;
            r.zza(cls, "Null interface");
            this.bKJ.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                r.zza(cls2, "Null interface");
            }
            Collections.addAll(this.bKJ, clsArr);
            AppMethodBeat.o(4068);
        }

        /* synthetic */ C0121a(Class cls, Class[] clsArr, byte b2) {
            this(cls, clsArr);
        }

        @KeepForSdk
        public final C0121a<T> a(d<T> dVar) {
            AppMethodBeat.i(4070);
            this.bKL = (d) r.zza(dVar, "Null factory");
            AppMethodBeat.o(4070);
            return this;
        }

        @KeepForSdk
        public final a<T> xZ() {
            AppMethodBeat.i(4071);
            r.b(this.bKL != null, "Missing required property: factory.");
            a<T> aVar = new a<>(new HashSet(this.bKJ), new HashSet(this.bKK), this.zzad, this.bKL, (byte) 0);
            AppMethodBeat.o(4071);
            return aVar;
        }

        @KeepForSdk
        public final C0121a<T> a(f fVar) {
            AppMethodBeat.i(4069);
            r.zza(fVar, "Null dependency");
            if (!(!this.bKJ.contains(fVar.bKM))) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
                AppMethodBeat.o(4069);
                throw illegalArgumentException;
            }
            this.bKK.add(fVar);
            AppMethodBeat.o(4069);
            return this;
        }
    }
}

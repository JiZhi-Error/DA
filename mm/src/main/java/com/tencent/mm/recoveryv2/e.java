package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public interface e {

    public interface a {
        String getDescription();
    }

    String getDescription();

    void guu();

    void guv();

    public static abstract class b implements e {
        protected final List<a> Bar = new ArrayList();
        protected final StringBuilder NBD = new StringBuilder();
        final String mName;

        public b(String str) {
            this.mName = str;
        }

        @Override // com.tencent.mm.recoveryv2.e
        public final String getDescription() {
            return this.NBD.toString();
        }

        /* access modifiers changed from: protected */
        public final b bhz(String str) {
            this.Bar.add(new c(str));
            return this;
        }

        /* access modifiers changed from: protected */
        public final b bhA(String str) {
            this.Bar.add(new C2045b(str));
            return this;
        }

        public static abstract class a implements a {
            public SharedPreferences.Editor NBE;
            String key;
            Object value;

            /* access modifiers changed from: protected */
            public abstract void a(SharedPreferences.Editor editor);

            public a(String str, Object obj) {
                this.key = str;
                this.value = obj;
            }

            public final void perform() {
                if (this.NBE == null) {
                    throw new IllegalStateException("Call #attach first!");
                }
                a(this.NBE);
            }
        }

        static class c extends a {
            public c(String str) {
                super(str, Integer.MAX_VALUE);
                AppMethodBeat.i(193781);
                AppMethodBeat.o(193781);
            }

            @Override // com.tencent.mm.recoveryv2.e.b.a
            public final void a(SharedPreferences.Editor editor) {
                AppMethodBeat.i(193782);
                editor.putInt(this.key, ((Integer) this.value).intValue());
                AppMethodBeat.o(193782);
            }

            @Override // com.tencent.mm.recoveryv2.e.a
            public final String getDescription() {
                AppMethodBeat.i(193783);
                String str = "putInt(" + this.key + ", " + this.value + ")";
                AppMethodBeat.o(193783);
                return str;
            }
        }

        /* renamed from: com.tencent.mm.recoveryv2.e$b$b  reason: collision with other inner class name */
        static class C2045b extends a {
            public C2045b(String str) {
                super(str, Boolean.FALSE);
            }

            @Override // com.tencent.mm.recoveryv2.e.b.a
            public final void a(SharedPreferences.Editor editor) {
                AppMethodBeat.i(193779);
                editor.putBoolean(this.key, ((Boolean) this.value).booleanValue());
                AppMethodBeat.o(193779);
            }

            @Override // com.tencent.mm.recoveryv2.e.a
            public final String getDescription() {
                AppMethodBeat.i(193780);
                String str = "putBoolean(" + this.key + ", " + this.value + ")";
                AppMethodBeat.o(193780);
                return str;
            }
        }
    }
}

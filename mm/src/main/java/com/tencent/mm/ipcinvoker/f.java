package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class f {
    public String hmX;

    public f(String str) {
        this.hmX = str;
    }

    public static String bo(Object obj) {
        AppMethodBeat.i(158730);
        String str = "Token#IPCObserver#" + obj.hashCode();
        AppMethodBeat.o(158730);
        return str;
    }

    public static class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(158728);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("Token");
            com.tencent.mm.ipcinvoker.d.c.ayj().a(bundle2.getString("Event"), new c(string) {
                /* class com.tencent.mm.ipcinvoker.f.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(158727);
                    dVar.bn(bundle);
                    AppMethodBeat.o(158727);
                }
            });
            AppMethodBeat.o(158728);
        }
    }

    public static class b implements b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(158729);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("Token");
            com.tencent.mm.ipcinvoker.d.c.ayj().b(bundle2.getString("Event"), new c(string) {
                /* class com.tencent.mm.ipcinvoker.f.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                }
            });
            AppMethodBeat.o(158729);
        }
    }

    static abstract class c implements e {
        String token;

        c(String str) {
            this.token = str;
            Assert.assertNotNull(str);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.token.equals(((c) obj).token);
        }
    }
}

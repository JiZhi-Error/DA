package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private static final b zpT = new b((byte) 0);
    private aa zpU;

    static {
        AppMethodBeat.i(116928);
        AppMethodBeat.o(116928);
    }

    public static void addSyncDoCmdCallback(z zVar) {
        AppMethodBeat.i(116921);
        zpT.add(zVar);
        AppMethodBeat.o(116921);
    }

    public static void removeSyncDoCmdCallback(z zVar) {
        AppMethodBeat.i(116922);
        zpT.remove(zVar);
        AppMethodBeat.o(116922);
    }

    /* access modifiers changed from: package-private */
    public static final class b extends com.tencent.mm.co.a<z> implements z {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aQ(final Object obj) {
            AppMethodBeat.i(116918);
            a(new a.AbstractC0297a<z>() {
                /* class com.tencent.mm.plugin.messenger.foundation.f.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(z zVar) {
                    AppMethodBeat.i(116915);
                    zVar.aQ(obj);
                    AppMethodBeat.o(116915);
                }
            });
            AppMethodBeat.o(116918);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aR(final Object obj) {
            AppMethodBeat.i(116919);
            a(new a.AbstractC0297a<z>() {
                /* class com.tencent.mm.plugin.messenger.foundation.f.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(z zVar) {
                    AppMethodBeat.i(116916);
                    zVar.aR(obj);
                    AppMethodBeat.o(116916);
                }
            });
            AppMethodBeat.o(116919);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aS(final Object obj) {
            AppMethodBeat.i(116920);
            a(new a.AbstractC0297a<z>() {
                /* class com.tencent.mm.plugin.messenger.foundation.f.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(z zVar) {
                    AppMethodBeat.i(116917);
                    zVar.aS(obj);
                    AppMethodBeat.o(116917);
                }
            });
            AppMethodBeat.o(116920);
        }
    }

    static class a implements aa {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void dkt() {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
        public final void a(ca caVar, de deVar) {
        }
    }

    @Override // com.tencent.mm.plugin.zero.a.f
    public final void dz(Object obj) {
        AppMethodBeat.i(116923);
        c<aa> eiz = ab.eiz();
        if (eiz != null) {
            this.zpU = eiz.get();
        }
        if (this.zpU == null) {
            this.zpU = new a((byte) 0);
        }
        if (obj instanceof k) {
            ((l) g.af(l.class)).eiy().aEs(((k) obj).TAG);
            zpT.aQ(obj);
            AppMethodBeat.o(116923);
            return;
        }
        if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((l) g.af(l.class)).eiy().aEs((String) obj);
                zpT.aQ(obj);
                AppMethodBeat.o(116923);
                return;
            }
        } else if (obj instanceof q.c) {
            ((l) g.af(l.class)).eiy().aEs(obj.toString());
            zpT.aQ(obj);
        }
        AppMethodBeat.o(116923);
    }

    @Override // com.tencent.mm.plugin.zero.a.f
    public final void a(abn abn, byte[] bArr, boolean z) {
        AppMethodBeat.i(116924);
        x Qn = x.a.Qn(abn.Lms);
        if (Qn != null) {
            try {
                Qn.a(abn, bArr, z, this.zpU);
                AppMethodBeat.o(116924);
            } catch (IOException e2) {
                Log.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e2.getMessage());
                RuntimeException runtimeException = new RuntimeException("docmd: parse protobuf error");
                AppMethodBeat.o(116924);
                throw runtimeException;
            }
        } else {
            Log.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(abn.Lms));
            AppMethodBeat.o(116924);
        }
    }

    @Override // com.tencent.mm.plugin.zero.a.f
    public final void dA(Object obj) {
        AppMethodBeat.i(116925);
        if (obj instanceof k) {
            this.zpU.dkt();
            ((l) g.af(l.class)).eiy().aEt(((k) obj).TAG);
            zpT.aR(obj);
            AppMethodBeat.o(116925);
        } else if (!(obj instanceof String) || !obj.equals("NetSceneInit")) {
            if (obj instanceof q.c) {
                this.zpU.dkt();
                ((l) g.af(l.class)).eiy().aEt(obj.toString());
                zpT.aR(obj);
            }
            AppMethodBeat.o(116925);
        } else {
            this.zpU.dkt();
            ((l) g.af(l.class)).eiy().aEt((String) obj);
            zpT.aR(obj);
            AppMethodBeat.o(116925);
        }
    }

    @Override // com.tencent.mm.plugin.zero.a.f
    public final void dB(Object obj) {
        AppMethodBeat.i(116926);
        if (obj instanceof k) {
            ((l) g.af(l.class)).eiy().aEt(((k) obj).TAG);
        }
        AppMethodBeat.o(116926);
    }

    @Override // com.tencent.mm.plugin.zero.a.f
    public final void dC(Object obj) {
        AppMethodBeat.i(116927);
        if (obj instanceof q.c) {
            zpT.aS(obj);
        }
        AppMethodBeat.o(116927);
    }
}

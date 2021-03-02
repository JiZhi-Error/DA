package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0007\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "", "()V", "CANCELED", "Companion", "FAILED", "OK", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "plugin-appbrand-integration_release"})
public abstract class b {
    public static final C0676b mbI = new C0676b((byte) 0);

    private b() {
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$Companion;", "", "()V", "FROM_ALBUM", "", "FROM_CAMERA", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.b$b  reason: collision with other inner class name */
    public static final class C0676b {
        private C0676b() {
        }

        public /* synthetic */ C0676b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class c extends b {
        final String message;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(50517);
            if (this == obj || ((obj instanceof c) && p.j(this.message, ((c) obj).message))) {
                AppMethodBeat.o(50517);
                return true;
            }
            AppMethodBeat.o(50517);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(50516);
            String str = this.message;
            if (str != null) {
                int hashCode = str.hashCode();
                AppMethodBeat.o(50516);
                return hashCode;
            }
            AppMethodBeat.o(50516);
            return 0;
        }

        public final String toString() {
            AppMethodBeat.i(50515);
            String str = "FAILED(message=" + this.message + ")";
            AppMethodBeat.o(50515);
            return str;
        }

        public c(String str) {
            super((byte) 0);
            this.message = str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "files", "", "Lcom/tencent/mm/vfs/VFSFile;", "from", "", "(Ljava/util/List;I)V", "getFiles", "()Ljava/util/List;", "getFrom", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    public static final class d extends b {
        final int from;
        final List<o> mbK;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.from == r4.from) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 50521(0xc559, float:7.0795E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.media.b.d
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.jsapi.media.b$d r4 = (com.tencent.mm.plugin.appbrand.jsapi.media.b.d) r4
                java.util.List<com.tencent.mm.vfs.o> r0 = r3.mbK
                java.util.List<com.tencent.mm.vfs.o> r1 = r4.mbK
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.from
                int r1 = r4.from
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.b.d.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(50520);
            List<o> list = this.mbK;
            int hashCode = ((list != null ? list.hashCode() : 0) * 31) + this.from;
            AppMethodBeat.o(50520);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(50519);
            String str = "OK(files=" + this.mbK + ", from=" + this.from + ")";
            AppMethodBeat.o(50519);
            return str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.mm.vfs.o> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(List<? extends o> list, int i2) {
            super((byte) 0);
            p.h(list, "files");
            AppMethodBeat.i(50518);
            this.mbK = list;
            this.from = i2;
            AppMethodBeat.o(50518);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "()V", "plugin-appbrand-integration_release"})
    public static final class a extends b {
        public static final a mbJ = new a();

        static {
            AppMethodBeat.i(50514);
            AppMethodBeat.o(50514);
        }

        private a() {
            super((byte) 0);
        }
    }
}

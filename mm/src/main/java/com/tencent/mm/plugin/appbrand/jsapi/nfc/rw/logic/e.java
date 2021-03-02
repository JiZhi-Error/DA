package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "T", "", "()V", "Failure", "Success", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class e<T> {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "ret", "(Ljava/lang/Object;)V", "getRet", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Success;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class b<T> extends e<T> {
        public final T miW;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(183695);
            if (this == obj || ((obj instanceof b) && p.j(this.miW, ((b) obj).miW))) {
                AppMethodBeat.o(183695);
                return true;
            }
            AppMethodBeat.o(183695);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(183694);
            T t = this.miW;
            if (t != null) {
                int hashCode = t.hashCode();
                AppMethodBeat.o(183694);
                return hashCode;
            }
            AppMethodBeat.o(183694);
            return 0;
        }

        public final String toString() {
            AppMethodBeat.i(183693);
            String str = "Success(ret=" + ((Object) this.miW) + ")";
            AppMethodBeat.o(183693);
            return str;
        }

        public b(T t) {
            super((byte) 0);
            this.miW = t;
        }
    }

    private e() {
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult$Failure;", "T", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a<T> extends e<T> {
        public final int errCode;
        public final String errMsg;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.errMsg, r4.errMsg) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 183692(0x2cd8c, float:2.57407E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e.a
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e$a r4 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e.a) r4
                int r0 = r3.errCode
                int r1 = r4.errCode
                if (r0 != r1) goto L_0x0023
                java.lang.String r0 = r3.errMsg
                java.lang.String r1 = r4.errMsg
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(183691);
            int i2 = this.errCode * 31;
            String str = this.errMsg;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(183691);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(183690);
            String str = "Failure(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
            AppMethodBeat.o(183690);
            return str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i2, String str) {
            super((byte) 0);
            p.h(str, "errMsg");
            AppMethodBeat.i(183689);
            this.errCode = i2;
            this.errMsg = str;
            AppMethodBeat.o(183689);
        }
    }
}

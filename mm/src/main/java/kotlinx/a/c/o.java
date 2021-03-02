package kotlinx.a.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0017\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016¨\u0006\u001d"}, hxF = {"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "number", "", "(Ljava/lang/Number;)V", DownloadSetting.TYPE_BOOLEAN, "", "(Z)V", "string", "", "(Ljava/lang/String;)V", "body", "", "isString", "(Ljava/lang/Object;Z)V", "getBody", "()Ljava/lang/Object;", "content", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "()Z", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class o extends v {
    public static final a TZR = new a((byte) 0);
    private final String TZO;
    private final Object TZP;
    public final boolean TZQ;
    final String content;

    static {
        AppMethodBeat.i(225775);
        AppMethodBeat.o(225775);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, hxF = {"Lkotlinx/serialization/json/JsonLiteral$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "kotlinx-serialization-runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Object obj, boolean z) {
        super((byte) 0);
        p.h(obj, "body");
        AppMethodBeat.i(225773);
        this.TZP = obj;
        this.TZQ = z;
        this.content = this.TZP.toString();
        this.TZO = this.content;
        AppMethodBeat.o(225773);
    }

    @Override // kotlinx.a.c.v
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public o(String str) {
        this(str, true);
        p.h(str, "string");
        AppMethodBeat.i(225774);
        AppMethodBeat.o(225774);
    }

    @Override // kotlinx.a.c.v
    public final String toString() {
        AppMethodBeat.i(225770);
        if (this.TZQ) {
            StringBuilder sb = new StringBuilder();
            kotlinx.a.c.a.p.b(sb, this.content);
            String sb2 = sb.toString();
            p.g(sb2, "StringBuilder().apply(builderAction).toString()");
            AppMethodBeat.o(225770);
            return sb2;
        }
        String str = this.content;
        AppMethodBeat.o(225770);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225771);
        if (this == obj) {
            AppMethodBeat.o(225771);
            return true;
        } else if (obj == null || (!p.j(aa.bp(getClass()), aa.bp(obj.getClass())))) {
            AppMethodBeat.o(225771);
            return false;
        } else if (this.TZQ != ((o) obj).TZQ) {
            AppMethodBeat.o(225771);
            return false;
        } else if (!p.j(this.content, ((o) obj).content)) {
            AppMethodBeat.o(225771);
            return false;
        } else {
            AppMethodBeat.o(225771);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(225772);
        int hashCode = (Boolean.valueOf(this.TZQ).hashCode() * 31) + this.content.hashCode();
        AppMethodBeat.o(225772);
        return hashCode;
    }
}

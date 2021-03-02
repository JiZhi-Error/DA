package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class k extends IOException {
    public q TDK = null;

    public k(String str) {
        super(str);
    }

    static k hJD() {
        AppMethodBeat.i(59481);
        k kVar = new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.o(59481);
        return kVar;
    }

    static k hJE() {
        AppMethodBeat.i(59482);
        k kVar = new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.o(59482);
        return kVar;
    }

    static k hJF() {
        AppMethodBeat.i(59483);
        k kVar = new k("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.o(59483);
        return kVar;
    }

    static k hJG() {
        AppMethodBeat.i(59484);
        k kVar = new k("Protocol message contained an invalid tag (zero).");
        AppMethodBeat.o(59484);
        return kVar;
    }

    static k hJH() {
        AppMethodBeat.i(59485);
        k kVar = new k("Protocol message end-group tag did not match expected tag.");
        AppMethodBeat.o(59485);
        return kVar;
    }

    static k hJI() {
        AppMethodBeat.i(59486);
        k kVar = new k("Protocol message tag had invalid wire type.");
        AppMethodBeat.o(59486);
        return kVar;
    }

    static k hJJ() {
        AppMethodBeat.i(59487);
        k kVar = new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        AppMethodBeat.o(59487);
        return kVar;
    }

    static k hJK() {
        AppMethodBeat.i(59488);
        k kVar = new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        AppMethodBeat.o(59488);
        return kVar;
    }
}

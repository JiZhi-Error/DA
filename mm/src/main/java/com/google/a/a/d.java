package com.google.a.a;

import java.io.IOException;

public final class d extends IOException {
    private d(String str) {
        super(str);
    }

    static d HY() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static d HZ() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static d Ia() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    static d Ib() {
        return new d("Protocol message contained an invalid tag (zero).");
    }

    static d Ic() {
        return new d("Protocol message end-group tag did not match expected tag.");
    }

    static d Id() {
        return new d("Protocol message tag had invalid wire type.");
    }

    static d Ie() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
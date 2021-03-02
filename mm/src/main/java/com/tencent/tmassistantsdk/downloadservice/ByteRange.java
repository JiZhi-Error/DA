package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteRange {
    protected static final String BYTES_UNIT = "bytes";
    protected static final Pattern CONTENT_RANGE_HEADER_PATTERN = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
    protected static final String INVALID_RANGE_HEADER_REGEX = "((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)";
    protected static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
    protected static final String UNIT_REGEX = "([^=\\s]+)";
    protected static final String VALID_CONTENT_RANGE_HEADER_REGEX = "bytes\\s+(\\d+)-(\\d+)/(\\d+)";
    protected static final String VALID_RANGE_HEADER_REGEX = "([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)";
    protected final Long end;
    protected final long start;

    static {
        AppMethodBeat.i(101945);
        AppMethodBeat.o(101945);
    }

    public ByteRange(long j2) {
        this(j2, (Long) null);
    }

    public ByteRange(long j2, long j3) {
        this(j2, Long.valueOf(j3));
        AppMethodBeat.i(101938);
        if (j2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("If end is provided, start must be positive.");
            AppMethodBeat.o(101938);
            throw illegalArgumentException;
        } else if (j3 < j2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("end must be >= start.");
            AppMethodBeat.o(101938);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(101938);
        }
    }

    protected ByteRange(long j2, Long l) {
        this.start = j2;
        this.end = l;
    }

    public boolean hasEnd() {
        return this.end != null;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        AppMethodBeat.i(101939);
        if (!hasEnd()) {
            IllegalStateException illegalStateException = new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
            AppMethodBeat.o(101939);
            throw illegalStateException;
        }
        long longValue = this.end.longValue();
        AppMethodBeat.o(101939);
        return longValue;
    }

    public String toString() {
        AppMethodBeat.i(101940);
        if (this.end != null) {
            String str = "bytes=" + this.start + "-" + this.end;
            AppMethodBeat.o(101940);
            return str;
        } else if (this.start < 0) {
            String str2 = "bytes=" + this.start;
            AppMethodBeat.o(101940);
            return str2;
        } else {
            String str3 = "bytes=" + this.start + "-";
            AppMethodBeat.o(101940);
            return str3;
        }
    }

    public static ByteRange parseContentRange(String str) {
        AppMethodBeat.i(101941);
        Matcher matcher = CONTENT_RANGE_HEADER_PATTERN.matcher(str);
        if (!matcher.matches()) {
            Throwable th = new Throwable("Invalid content-range format: ".concat(String.valueOf(str)));
            AppMethodBeat.o(101941);
            throw th;
        }
        ByteRange byteRange = new ByteRange(Util.safeParseLong(matcher.group(1)), Util.safeParseLong(matcher.group(2)));
        AppMethodBeat.o(101941);
        return byteRange;
    }

    public static long getTotalSize(String str) {
        AppMethodBeat.i(101942);
        int indexOf = str.indexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (indexOf == -1) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException();
            AppMethodBeat.o(101942);
            throw notFoundException;
        }
        long safeParseLong = Util.safeParseLong(str.substring(indexOf + 1));
        AppMethodBeat.o(101942);
        return safeParseLong;
    }

    public int hashCode() {
        AppMethodBeat.i(101943);
        int hashCode = Long.valueOf(this.start).hashCode() + 629;
        if (this.end != null) {
            hashCode = (hashCode * 37) + this.end.hashCode();
        }
        AppMethodBeat.o(101943);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(101944);
        if (obj instanceof ByteRange) {
            ByteRange byteRange = (ByteRange) obj;
            if (this.start != byteRange.getStart()) {
                AppMethodBeat.o(101944);
                return false;
            } else if (hasEnd() != byteRange.hasEnd()) {
                AppMethodBeat.o(101944);
                return false;
            } else if (hasEnd()) {
                boolean equals = this.end.equals(Long.valueOf(byteRange.getEnd()));
                AppMethodBeat.o(101944);
                return equals;
            } else {
                AppMethodBeat.o(101944);
                return true;
            }
        } else {
            AppMethodBeat.o(101944);
            return false;
        }
    }
}

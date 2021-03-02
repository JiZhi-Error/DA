package com.danikula.videocache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetRequest {
    private static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern URL_PATTERN = Pattern.compile("GET /(.*) HTTP");
    public final boolean partial;
    public final long rangeOffset;
    public final String uri;

    static {
        AppMethodBeat.i(183564);
        AppMethodBeat.o(183564);
    }

    public GetRequest(String str) {
        AppMethodBeat.i(183561);
        Preconditions.checkNotNull(str);
        long findRangeOffset = findRangeOffset(str);
        this.rangeOffset = Math.max(0L, findRangeOffset);
        this.partial = findRangeOffset >= 0;
        this.uri = findUri(str);
        AppMethodBeat.o(183561);
    }

    public static GetRequest read(InputStream inputStream) {
        AppMethodBeat.i(183562);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine).append('\n');
            } else {
                GetRequest getRequest = new GetRequest(sb.toString());
                AppMethodBeat.o(183562);
                return getRequest;
            }
        }
    }

    private long findRangeOffset(String str) {
        AppMethodBeat.i(223130);
        Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.find()) {
            long parseLong = Long.parseLong(matcher.group(1));
            AppMethodBeat.o(223130);
            return parseLong;
        }
        AppMethodBeat.o(223130);
        return -1;
    }

    private String findUri(String str) {
        AppMethodBeat.i(223131);
        Matcher matcher = URL_PATTERN.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(223131);
            return group;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
        AppMethodBeat.o(223131);
        throw illegalArgumentException;
    }

    public String toString() {
        AppMethodBeat.i(183563);
        String str = "GetRequest{rangeOffset=" + this.rangeOffset + ", partial=" + this.partial + ", uri='" + this.uri + '\'' + '}';
        AppMethodBeat.o(183563);
        return str;
    }
}

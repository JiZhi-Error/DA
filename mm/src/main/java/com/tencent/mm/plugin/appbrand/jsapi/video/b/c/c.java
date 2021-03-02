package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c {
    public static HashMap<String, c> myA = new HashMap<>();
    public static final c myu = new c("unknown");
    public static final c myv = new c("application/octet-stream");
    public static final c myw = new c("video/mp4");
    private static final byte[] myx = {117, 110, 107, 110, 111, 119, 110};
    public String myy;
    public String myz;

    static {
        AppMethodBeat.i(234787);
        AppMethodBeat.o(234787);
    }

    private c(String str) {
        this.myy = str;
    }

    public static String abb(String str) {
        AppMethodBeat.i(234781);
        try {
            String encode = b.encode(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            AppMethodBeat.o(234781);
            return encode;
        } catch (UnsupportedEncodingException e2) {
            String encode2 = b.encode(myx);
            AppMethodBeat.o(234781);
            return encode2;
        }
    }

    private static String abc(String str) {
        AppMethodBeat.i(234782);
        try {
            String str2 = new String(b.decode(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(234782);
            return str2;
        } catch (UnsupportedEncodingException e2) {
            String cVar = myu.toString();
            AppMethodBeat.o(234782);
            return cVar;
        }
    }

    public static c abd(String str) {
        AppMethodBeat.i(234783);
        if (TextUtils.isEmpty(str)) {
            c cVar = myu;
            AppMethodBeat.o(234783);
            return cVar;
        } else if (str.equals("video/mp4")) {
            c cVar2 = myw;
            AppMethodBeat.o(234783);
            return cVar2;
        } else if (str.equals("unknown")) {
            c cVar3 = myu;
            AppMethodBeat.o(234783);
            return cVar3;
        } else {
            c cVar4 = new c(str);
            AppMethodBeat.o(234783);
            return cVar4;
        }
    }

    public static c abe(String str) {
        c abd;
        AppMethodBeat.i(234784);
        if (myA.containsKey(str)) {
            abd = myA.get(str);
        } else {
            abd = abd(abc(str));
            myA.put(str, abd);
        }
        AppMethodBeat.o(234784);
        return abd;
    }

    public final String toString() {
        return this.myy;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(234785);
        if (this == obj) {
            AppMethodBeat.o(234785);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(234785);
            return false;
        } else {
            c cVar = (c) obj;
            if (this.myy == null ? cVar.myy != null : !this.myy.equals(cVar.myy)) {
                AppMethodBeat.o(234785);
                return false;
            }
            AppMethodBeat.o(234785);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(234786);
        if (this.myy != null) {
            int hashCode = this.myy.hashCode();
            AppMethodBeat.o(234786);
            return hashCode;
        }
        AppMethodBeat.o(234786);
        return 0;
    }
}

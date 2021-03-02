package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.b.b.b;
import org.b.g.e;

public final class g {
    private String Uit;
    private InputStream aFm;
    public int code;
    private Map<String, String> headers;

    g(HttpURLConnection httpURLConnection) {
        boolean z;
        InputStream errorStream;
        AppMethodBeat.i(40511);
        try {
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.headers = h(httpURLConnection);
            if (this.code < 200 || this.code >= 400) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            this.aFm = errorStream;
            AppMethodBeat.o(40511);
        } catch (UnknownHostException e2) {
            b bVar = new b("The IP address of a host could not be determined.", e2);
            AppMethodBeat.o(40511);
            throw bVar;
        }
    }

    private static Map<String, String> h(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(40512);
        HashMap hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, httpURLConnection.getHeaderFields().get(str).get(0));
        }
        AppMethodBeat.o(40512);
        return hashMap;
    }

    public final String getBody() {
        AppMethodBeat.i(40513);
        if (this.Uit != null) {
            String str = this.Uit;
            AppMethodBeat.o(40513);
            return str;
        }
        this.Uit = e.X(this.aFm);
        String str2 = this.Uit;
        AppMethodBeat.o(40513);
        return str2;
    }
}

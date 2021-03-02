package org.b.d;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.b.b.a;
import org.b.b.b;
import org.b.g.d;

/* access modifiers changed from: package-private */
public class f {
    private String MiI = null;
    private j Uim;
    private e Uin;
    private e Uio;
    private byte[] Uip = null;
    private boolean Uiq = false;
    private Long Uir = null;
    private Long Uis = null;
    private String charset;
    private HttpURLConnection connection;
    private Map<String, String> headers;
    private String url;

    public f(j jVar, String str) {
        AppMethodBeat.i(40519);
        this.Uim = jVar;
        this.url = str;
        this.Uin = new e();
        this.Uio = new e();
        this.headers = new HashMap();
        AppMethodBeat.o(40519);
    }

    public String hQd() {
        AppMethodBeat.i(40521);
        e eVar = this.Uin;
        String str = this.url;
        d.j(str, "Cannot append to null URL");
        String hQj = eVar.hQj();
        if (hQj.equals("")) {
            AppMethodBeat.o(40521);
            return str;
        }
        String str2 = String.valueOf(String.valueOf(str) + (str.indexOf(63) != -1 ? "&" : '?')) + hQj;
        AppMethodBeat.o(40521);
        return str2;
    }

    private void g(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(40522);
        for (String str : this.headers.keySet()) {
            httpURLConnection.setRequestProperty(str, this.headers.get(str));
        }
        AppMethodBeat.o(40522);
    }

    public void addHeader(String str, String str2) {
        AppMethodBeat.i(40523);
        this.headers.put(str, str2);
        AppMethodBeat.o(40523);
    }

    public void oL(String str, String str2) {
        AppMethodBeat.i(40524);
        this.Uin.Uil.add(new d(str, str2));
        AppMethodBeat.o(40524);
    }

    public e hQb() {
        AppMethodBeat.i(40525);
        try {
            e eVar = new e();
            eVar.bvv(new URL(this.url).getQuery());
            eVar.a(this.Uin);
            AppMethodBeat.o(40525);
            return eVar;
        } catch (MalformedURLException e2) {
            b bVar = new b("Malformed URL", e2);
            AppMethodBeat.o(40525);
            throw bVar;
        }
    }

    public e hQg() {
        return this.Uio;
    }

    public String getUrl() {
        return this.url;
    }

    public String hQh() {
        AppMethodBeat.i(40526);
        String replace = this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
        AppMethodBeat.o(40526);
        return replace;
    }

    private byte[] hQk() {
        AppMethodBeat.i(40527);
        if (this.Uip != null) {
            byte[] bArr = this.Uip;
            AppMethodBeat.o(40527);
            return bArr;
        }
        try {
            byte[] bytes = (this.MiI != null ? this.MiI : this.Uio.hQj()).getBytes(hQe());
            AppMethodBeat.o(40527);
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            b bVar = new b("Unsupported Charset: " + hQe(), e2);
            AppMethodBeat.o(40527);
            throw bVar;
        }
    }

    public j hQc() {
        return this.Uim;
    }

    public String hQe() {
        AppMethodBeat.i(40528);
        if (this.charset == null) {
            String name = Charset.defaultCharset().name();
            AppMethodBeat.o(40528);
            return name;
        }
        String str = this.charset;
        AppMethodBeat.o(40528);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(40529);
        String format = String.format("@Request(%s %s)", hQc(), getUrl());
        AppMethodBeat.o(40529);
        return format;
    }

    public g hQf() {
        AppMethodBeat.i(40520);
        try {
            String hQd = hQd();
            if (this.connection == null) {
                System.setProperty("http.keepAlive", this.Uiq ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
                this.connection = (HttpURLConnection) new URL(hQd).openConnection();
            }
            this.connection.setRequestMethod(this.Uim.name());
            if (this.Uir != null) {
                this.connection.setConnectTimeout(this.Uir.intValue());
            }
            if (this.Uis != null) {
                this.connection.setReadTimeout(this.Uis.intValue());
            }
            g(this.connection);
            if (this.Uim.equals(j.PUT) || this.Uim.equals(j.POST)) {
                HttpURLConnection httpURLConnection = this.connection;
                byte[] hQk = hQk();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(hQk.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(hQk);
            }
            g gVar = new g(this.connection);
            AppMethodBeat.o(40520);
            return gVar;
        } catch (Exception e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(40520);
            throw aVar;
        }
    }
}

package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class x implements y {
    public Map<String, List<String>> bFE = null;
    public HttpURLConnection connection;
    public int jDL;
    String jEW;
    public URL url;

    public x(URL url2, int i2) {
        AppMethodBeat.i(132849);
        this.url = url2;
        this.jDL = i2;
        this.connection = (HttpURLConnection) this.url.openConnection();
        if (1 == this.jDL) {
            this.connection.setInstanceFollowRedirects(false);
        }
        AppMethodBeat.o(132849);
    }

    @Override // com.tencent.mm.network.y
    public final void disconnect() {
        AppMethodBeat.i(132850);
        if (this.connection != null) {
            try {
                this.connection.getInputStream().close();
            } catch (Exception e2) {
                e2.getMessage();
            }
            this.connection.disconnect();
        }
        AppMethodBeat.o(132850);
    }

    @Override // com.tencent.mm.network.y
    public final int getResponseCode() {
        AppMethodBeat.i(132851);
        if (1 == this.jDL && this.bFE == null) {
            this.bFE = this.connection.getRequestProperties();
        }
        try {
            int responseCode = this.connection.getResponseCode();
            if (1 == this.jDL && 302 == responseCode) {
                String headerField = this.connection.getHeaderField("Location");
                if (headerField == null) {
                    AppMethodBeat.o(132851);
                    return responseCode;
                }
                this.url = new URL(this.url, headerField);
                try {
                    this.connection.getInputStream().close();
                } catch (Exception e2) {
                    e2.getMessage();
                }
                this.connection.disconnect();
                this.connection = (HttpURLConnection) this.url.openConnection();
                this.connection.setInstanceFollowRedirects(false);
                if (this.bFE != null) {
                    for (String str : this.bFE.keySet()) {
                        if (!str.equals("Host") && !str.equals("X-Online-Host")) {
                            List<String> list = this.bFE.get(str);
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                this.connection.setRequestProperty(str, list.get(i2));
                            }
                        }
                    }
                }
                this.connection.setRequestProperty("Host", this.url.getHost());
                this.connection.setRequestProperty("X-Online-Host", this.url.getHost());
                int responseCode2 = getResponseCode();
                AppMethodBeat.o(132851);
                return responseCode2;
            }
            if (1 == this.jDL && 200 != responseCode && NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                d.reportFailIp(this.jEW);
            }
            AppMethodBeat.o(132851);
            return responseCode;
        } catch (Exception e3) {
            if (1 == this.jDL && 200 != -1 && NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                d.reportFailIp(this.jEW);
            }
            AppMethodBeat.o(132851);
            throw e3;
        }
    }

    @Override // com.tencent.mm.network.y
    public final void setRequestMethod(String str) {
        AppMethodBeat.i(132852);
        this.connection.setRequestMethod(str);
        AppMethodBeat.o(132852);
    }

    public final void connect() {
        AppMethodBeat.i(132853);
        if (1 == this.jDL && this.bFE == null) {
            this.bFE = this.connection.getRequestProperties();
        }
        this.connection.connect();
        AppMethodBeat.o(132853);
    }

    @Override // com.tencent.mm.network.y
    public final int getContentLength() {
        AppMethodBeat.i(132854);
        int contentLength = this.connection.getContentLength();
        AppMethodBeat.o(132854);
        return contentLength;
    }

    @Override // com.tencent.mm.network.y
    public final String getContentType() {
        AppMethodBeat.i(132855);
        String contentType = this.connection.getContentType();
        AppMethodBeat.o(132855);
        return contentType;
    }

    @Override // com.tencent.mm.network.y
    public final Map<String, List<String>> getHeaderFields() {
        AppMethodBeat.i(132856);
        if (1 == this.jDL && this.bFE == null) {
            this.bFE = this.connection.getRequestProperties();
        }
        Map<String, List<String>> headerFields = this.connection.getHeaderFields();
        AppMethodBeat.o(132856);
        return headerFields;
    }

    @Override // com.tencent.mm.network.y
    public final String getHeaderField(String str) {
        AppMethodBeat.i(132857);
        if (1 == this.jDL && this.bFE == null) {
            this.bFE = this.connection.getRequestProperties();
        }
        String headerField = this.connection.getHeaderField(str);
        AppMethodBeat.o(132857);
        return headerField;
    }

    @Override // com.tencent.mm.network.y
    public final int getHeaderFieldInt(String str, int i2) {
        AppMethodBeat.i(132858);
        if (1 == this.jDL && this.bFE == null) {
            this.bFE = this.connection.getRequestProperties();
        }
        int headerFieldInt = this.connection.getHeaderFieldInt(str, i2);
        AppMethodBeat.o(132858);
        return headerFieldInt;
    }

    @Override // com.tencent.mm.network.y
    public final InputStream getInputStream() {
        AppMethodBeat.i(132859);
        if (1 == this.jDL) {
            if (this.bFE == null) {
                this.bFE = this.connection.getRequestProperties();
            }
            getResponseCode();
        }
        InputStream inputStream = this.connection.getInputStream();
        AppMethodBeat.o(132859);
        return inputStream;
    }

    @Override // com.tencent.mm.network.y
    public final void setRequestProperty(String str, String str2) {
        AppMethodBeat.i(132863);
        this.connection.setRequestProperty(str, str2);
        AppMethodBeat.o(132863);
    }

    @Override // com.tencent.mm.network.y
    public final void setUseCaches(boolean z) {
        AppMethodBeat.i(132864);
        this.connection.setUseCaches(z);
        AppMethodBeat.o(132864);
    }

    @Override // com.tencent.mm.network.y
    public final void setConnectTimeout(int i2) {
        AppMethodBeat.i(132865);
        this.connection.setConnectTimeout(i2);
        AppMethodBeat.o(132865);
    }

    @Override // com.tencent.mm.network.y
    public final void setReadTimeout(int i2) {
        AppMethodBeat.i(132866);
        this.connection.setReadTimeout(i2);
        AppMethodBeat.o(132866);
    }

    @Override // com.tencent.mm.network.y
    public final void RU(String str) {
        AppMethodBeat.i(132867);
        this.connection.setRequestProperty("Referer", str);
        AppMethodBeat.o(132867);
    }

    public final String toString() {
        AppMethodBeat.i(132868);
        String httpURLConnection = this.connection.toString();
        AppMethodBeat.o(132868);
        return httpURLConnection;
    }

    @Override // com.tencent.mm.network.y
    public final String bjP() {
        return this.jEW;
    }

    @Override // com.tencent.mm.network.y
    public final int bjQ() {
        return this.jDL;
    }

    @Override // com.tencent.mm.network.y
    public final String getHost() {
        AppMethodBeat.i(132869);
        String host = this.url.getHost();
        AppMethodBeat.o(132869);
        return host;
    }
}

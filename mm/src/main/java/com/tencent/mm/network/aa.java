package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class aa {
    public HttpsURLConnection jFs;

    public aa(String str) {
        this(new URL(str));
        AppMethodBeat.i(132883);
        AppMethodBeat.o(132883);
    }

    private aa(URL url) {
        AppMethodBeat.i(132884);
        this.jFs = null;
        try {
            this.jFs = (HttpsURLConnection) url.openConnection();
            AppMethodBeat.o(132884);
        } catch (MalformedURLException e2) {
            Log.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e2.getMessage());
            Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132884);
        } catch (IOException e3) {
            Log.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e3.getMessage());
            Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", Util.stackTraceToString(e3));
            AppMethodBeat.o(132884);
        } catch (Exception e4) {
            Log.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e4.getMessage());
            Log.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", Util.stackTraceToString(e4));
            AppMethodBeat.o(132884);
        }
    }

    public final void disconnect() {
        AppMethodBeat.i(132885);
        if (this.jFs != null) {
            try {
                this.jFs.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.MMHttpsUrlConnection", e2.getMessage());
            }
            this.jFs.disconnect();
        }
        AppMethodBeat.o(132885);
    }

    public final void setConnectTimeout(int i2) {
        AppMethodBeat.i(132886);
        this.jFs.setConnectTimeout(i2);
        AppMethodBeat.o(132886);
    }

    public final void setReadTimeout(int i2) {
        AppMethodBeat.i(132887);
        this.jFs.setReadTimeout(i2);
        AppMethodBeat.o(132887);
    }

    public final void RU(String str) {
        AppMethodBeat.i(132888);
        this.jFs.setRequestProperty("Referer", str);
        AppMethodBeat.o(132888);
    }

    public final void bjX() {
        AppMethodBeat.i(132889);
        this.jFs.setUseCaches(true);
        AppMethodBeat.o(132889);
    }
}

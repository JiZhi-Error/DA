package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class x {
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String mAuthInfo;
    String mHost;
    String mPath;
    int mPort;
    String mScheme;

    static {
        AppMethodBeat.i(103144);
        AppMethodBeat.o(103144);
    }

    public x(String str) {
        AppMethodBeat.i(103142);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(103142);
            throw nullPointerException;
        }
        this.mScheme = "";
        this.mHost = "";
        this.mPort = -1;
        this.mPath = FilePathGenerator.ANDROID_DIR_SEP;
        this.mAuthInfo = "";
        Matcher matcher = sAddressPattern.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.mScheme = group.toLowerCase();
            }
            String group2 = matcher.group(2);
            if (group2 != null) {
                this.mAuthInfo = group2;
            }
            String group3 = matcher.group(3);
            if (group3 != null) {
                this.mHost = group3;
            }
            String group4 = matcher.group(4);
            if (group4 != null && group4.length() > 0) {
                try {
                    this.mPort = Util.getInt(group4, this.mPort);
                } catch (NumberFormatException e2) {
                    Exception exc = new Exception("Bad port");
                    AppMethodBeat.o(103142);
                    throw exc;
                }
            }
            String group5 = matcher.group(5);
            if (group5 != null && group5.length() > 0) {
                if (group5.charAt(0) == '/') {
                    this.mPath = group5;
                } else {
                    this.mPath = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(group5));
                }
            }
            if (this.mPort == 443 && this.mScheme.equals("")) {
                this.mScheme = "https";
            } else if (this.mPort == -1) {
                if (this.mScheme.equals("https")) {
                    this.mPort = JsApiPauseDownloadTask.CTRL_INDEX;
                } else {
                    this.mPort = 80;
                }
            }
            if (this.mScheme.equals("")) {
                this.mScheme = "http";
            }
            AppMethodBeat.o(103142);
            return;
        }
        Exception exc2 = new Exception("Bad address");
        AppMethodBeat.o(103142);
        throw exc2;
    }

    public final String toString() {
        AppMethodBeat.i(103143);
        String str = "";
        if ((this.mPort != 443 && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
            str = ":" + Integer.toString(this.mPort);
        }
        String str2 = "";
        if (this.mAuthInfo.length() > 0) {
            str2 = this.mAuthInfo + "@";
        }
        String str3 = this.mScheme + "://" + str2 + this.mHost + str + this.mPath;
        AppMethodBeat.o(103143);
        return str3;
    }
}

package org.xwalk.core.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress {
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PATH = 5;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_SCHEME = 1;
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    private String mAuthInfo;
    private String mHost;
    private String mPath;
    private int mPort;
    private String mScheme;

    public static class ParseException extends RuntimeException {
        public String response;

        ParseException(String str) {
            this.response = str;
        }
    }

    static {
        AppMethodBeat.i(155349);
        AppMethodBeat.o(155349);
    }

    public WebAddress(String str) {
        AppMethodBeat.i(155347);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(155347);
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
                this.mScheme = group.toLowerCase(Locale.ROOT);
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
                    this.mPort = Integer.parseInt(group4);
                } catch (NumberFormatException e2) {
                    ParseException parseException = new ParseException("Bad port");
                    AppMethodBeat.o(155347);
                    throw parseException;
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
            AppMethodBeat.o(155347);
            return;
        }
        ParseException parseException2 = new ParseException("Bad address");
        AppMethodBeat.o(155347);
        throw parseException2;
    }

    public String toString() {
        AppMethodBeat.i(155348);
        String str = "";
        if ((this.mPort != 443 && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
            str = ":" + Integer.toString(this.mPort);
        }
        String str2 = "";
        if (this.mAuthInfo.length() > 0) {
            str2 = this.mAuthInfo + "@";
        }
        String str3 = this.mScheme + "://" + str2 + this.mHost + str + this.mPath;
        AppMethodBeat.o(155348);
        return str3;
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public void setHost(String str) {
        this.mHost = str;
    }

    public String getHost() {
        return this.mHost;
    }

    public void setPort(int i2) {
        this.mPort = i2;
    }

    public int getPort() {
        return this.mPort;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setAuthInfo(String str) {
        this.mAuthInfo = str;
    }

    public String getAuthInfo() {
        return this.mAuthInfo;
    }
}

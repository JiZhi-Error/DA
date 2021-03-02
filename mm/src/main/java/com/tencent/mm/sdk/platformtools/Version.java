package com.tencent.mm.sdk.platformtools;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Version implements Comparable<Version> {
    private String[] version = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Version version2) {
        AppMethodBeat.i(200912);
        int compareTo = compareTo(version2);
        AppMethodBeat.o(200912);
        return compareTo;
    }

    public Version(String str) {
        AppMethodBeat.i(200910);
        if (str != null) {
            this.version = str.split("\\.");
        }
        if (this.version == null || this.version.length == 0) {
            this.version = new String[]{str};
        }
        AppMethodBeat.o(200910);
    }

    public int compareTo(Version version2) {
        AppMethodBeat.i(200911);
        int i2 = 0;
        while (i2 < version2.version.length && i2 < this.version.length) {
            int compareTo = this.version[i2].compareTo(version2.version[i2]);
            if (compareTo != 0) {
                AppMethodBeat.o(200911);
                return compareTo;
            }
            i2++;
        }
        if (this.version.length > version2.version.length) {
            int compareTo2 = this.version[this.version.length - 1].compareTo(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.o(200911);
            return compareTo2;
        }
        int compareTo3 = AppEventsConstants.EVENT_PARAM_VALUE_NO.compareTo(version2.version[version2.version.length - 1]);
        AppMethodBeat.o(200911);
        return compareTo3;
    }
}

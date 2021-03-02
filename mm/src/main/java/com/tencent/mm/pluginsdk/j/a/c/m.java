package com.tencent.mm.pluginsdk.j.a.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public final String JYs;
    public final Exception Kab;
    public final Bundle bundle;
    public final long contentLength;
    public final String contentType;
    public final String filePath;
    final String groupId;
    public final int httpStatusCode;
    public final int status;
    public final String url;

    private m(String str, String str2, String str3, String str4, long j2, String str5, int i2, Exception exc, int i3) {
        AppMethodBeat.i(152030);
        this.bundle = new Bundle();
        this.groupId = str;
        this.JYs = str2;
        this.url = str3;
        this.filePath = str4;
        this.contentLength = j2;
        this.contentType = str5;
        this.status = i2;
        this.Kab = exc;
        this.httpStatusCode = i3;
        AppMethodBeat.o(152030);
    }

    public m(String str, String str2, String str3, String str4, long j2, String str5, int i2, Exception exc) {
        this(str, str2, str3, str4, j2, str5, i2, exc, -1);
    }

    public m(l lVar, long j2) {
        this(lVar.avy(), lVar.JYs, lVar.url, lVar.getFilePath(), j2, null, 2, null, -1);
        AppMethodBeat.i(152031);
        AppMethodBeat.o(152031);
    }

    public m(e eVar, long j2, String str) {
        this(eVar.avy(), eVar.gnA(), eVar.getURL(), eVar.getFilePath(), j2, str, 2, null, -1);
        AppMethodBeat.i(152032);
        AppMethodBeat.o(152032);
    }

    public m(e eVar, Exception exc, int i2, int i3) {
        this(eVar.avy(), eVar.gnA(), eVar.getURL(), eVar.getFilePath(), -1, null, i3, exc, i2);
        AppMethodBeat.i(152033);
        AppMethodBeat.o(152033);
    }

    public m(e eVar, Exception exc, int i2) {
        this(eVar, exc, -1, i2);
    }

    public final Bundle getExtras() {
        return this.bundle;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String toString() {
        AppMethodBeat.i(152034);
        String str = "NetworkResponse{urlKey='" + this.JYs + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.contentLength + ", contentType='" + this.contentType + '\'' + ", status=" + this.status + ", e=" + this.Kab + '}';
        AppMethodBeat.o(152034);
        return str;
    }
}

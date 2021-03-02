package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private String Sap;
    private String model;
    private String prefix;
    public String tag;
    public String taskId;

    public b(String str) {
        this(str, "", "", "");
    }

    public b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(189275);
        this.prefix = "";
        this.Sap = "";
        this.taskId = "";
        this.model = "";
        this.tag = "TPLogger";
        this.prefix = str;
        this.Sap = str2;
        this.taskId = str3;
        this.model = str4;
        hnE();
        AppMethodBeat.o(189275);
    }

    public b(b bVar, String str) {
        AppMethodBeat.i(189276);
        this.prefix = "";
        this.Sap = "";
        this.taskId = "";
        this.model = "";
        this.tag = "TPLogger";
        a(bVar, str);
        AppMethodBeat.o(189276);
    }

    public final void a(b bVar, String str) {
        AppMethodBeat.i(189277);
        if (bVar != null) {
            this.prefix = bVar.prefix;
            this.Sap = bVar.Sap;
            this.taskId = bVar.taskId;
        } else {
            this.prefix = "";
            this.Sap = "";
            this.taskId = "";
        }
        this.model = str;
        hnE();
        AppMethodBeat.o(189277);
    }

    public final void hnE() {
        AppMethodBeat.i(189278);
        this.tag = this.prefix;
        if (!TextUtils.isEmpty(this.Sap)) {
            this.tag += "_C" + this.Sap;
        }
        if (!TextUtils.isEmpty(this.taskId)) {
            this.tag += "_T" + this.taskId;
        }
        if (!TextUtils.isEmpty(this.model)) {
            this.tag += "_" + this.model;
        }
        AppMethodBeat.o(189278);
    }

    public final String toString() {
        AppMethodBeat.i(189279);
        String str = "TPLoggerContext{prefix='" + this.prefix + '\'' + ", classId='" + this.Sap + '\'' + ", taskId='" + this.taskId + '\'' + ", model='" + this.model + '\'' + ", tag='" + this.tag + '\'' + '}';
        AppMethodBeat.o(189279);
        return str;
    }
}

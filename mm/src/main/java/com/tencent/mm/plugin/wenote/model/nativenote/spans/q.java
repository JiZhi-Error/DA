package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q {
    NONE("", "", "", "", false),
    NOTEUL("<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true),
    NOTEOL("<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true),
    NOTETODO("", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    
    public String mStartTag;
    public String qTt;
    public boolean qTu;
    public String qTv;
    public String qTw;
    public boolean qTx;
    public boolean qTy = false;

    public static q valueOf(String str) {
        AppMethodBeat.i(30661);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(30661);
        return qVar;
    }

    static {
        AppMethodBeat.i(30662);
        AppMethodBeat.o(30662);
    }

    public static q b(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof m) {
            return NOTEOL;
        }
        if (paragraphStyle instanceof k) {
            return NOTETODO;
        }
        return null;
    }

    private q(String str, String str2, String str3, String str4, boolean z) {
        this.mStartTag = str;
        this.qTt = str2;
        this.qTv = str3;
        this.qTw = str4;
        this.qTu = false;
        this.qTx = z;
    }

    public final boolean cEw() {
        return this == NOTEUL;
    }

    public final boolean cEx() {
        return this == NOTEOL;
    }

    public final boolean cEy() {
        return this == NOTETODO;
    }
}

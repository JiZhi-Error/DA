package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o {
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

    public static o valueOf(String str) {
        AppMethodBeat.i(181955);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(181955);
        return oVar;
    }

    static {
        AppMethodBeat.i(181956);
        AppMethodBeat.o(181956);
    }

    public static o a(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof k) {
            return NOTEOL;
        }
        if (paragraphStyle instanceof s) {
            return NOTETODO;
        }
        return null;
    }

    private o(String str, String str2, String str3, String str4, boolean z) {
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

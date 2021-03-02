package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.ehv;

public enum k {
    MMNEWTIPS_SHOWTYPE_NONE("无红点", 10000),
    MMNEWTIPS_SHOWTYPE_REDPOINT("普通红点", 0),
    MMNEWTIPS_SHOWTYPE_NEW("New 红点", 1),
    MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE("带 TITLE 红点", 2),
    MMNEWTIPS_SHOWTYPE_REDPOINT_ICON("带 ICON 红点", 3),
    MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON("同时带 TITLE 和 ICON 红点", 4),
    MMNEWTIPS_SHOWTYPE_COUNTER("计数红点", 5);
    
    public final String ADM;
    public final int value;

    public static k valueOf(String str) {
        AppMethodBeat.i(127254);
        k kVar = (k) Enum.valueOf(k.class, str);
        AppMethodBeat.o(127254);
        return kVar;
    }

    static {
        AppMethodBeat.i(127257);
        AppMethodBeat.o(127257);
    }

    private k(String str, int i2) {
        this.ADM = str;
        this.value = i2;
    }

    public static k TE(int i2) {
        switch (i2) {
            case 0:
                return MMNEWTIPS_SHOWTYPE_REDPOINT;
            case 1:
                return MMNEWTIPS_SHOWTYPE_NEW;
            case 2:
                return MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE;
            case 3:
                return MMNEWTIPS_SHOWTYPE_REDPOINT_ICON;
            case 4:
                return MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON;
            case 5:
                return MMNEWTIPS_SHOWTYPE_COUNTER;
            case 10000:
                return MMNEWTIPS_SHOWTYPE_NONE;
            default:
                return MMNEWTIPS_SHOWTYPE_REDPOINT;
        }
    }

    public static ehv a(k kVar, c cVar) {
        AppMethodBeat.i(127255);
        ehv ehv = new ehv();
        switch (kVar) {
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE:
                ehv.title = cVar.field_title;
                break;
            case MMNEWTIPS_SHOWTYPE_REDPOINT_ICON:
                ehv.url = cVar.field_icon_url;
                break;
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON:
                ehv.url = cVar.field_icon_url;
                ehv.title = cVar.field_title;
                break;
        }
        AppMethodBeat.o(127255);
        return ehv;
    }

    public final String toString() {
        AppMethodBeat.i(127256);
        String str = "NewTipsShowType{commet='" + this.ADM + '\'' + ", value=" + this.value + '}';
        AppMethodBeat.o(127256);
        return str;
    }
}

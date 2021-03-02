package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j implements Serializable {
    final List<String> bZq;
    final e cXX;
    final String cYa;
    final b cYc;
    final a cYd;
    final String className;
    final String extra;

    public enum a {
        OBJECT,
        CLASS,
        THREAD,
        ARRAY
    }

    public enum b {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    public j(String str, b bVar, a aVar, String str2, String str3, e eVar, List<String> list) {
        this.cYa = str;
        this.cYc = bVar;
        this.cYd = aVar;
        this.className = str2;
        this.extra = str3;
        this.cXX = eVar;
        this.bZq = Collections.unmodifiableList(new ArrayList(list));
    }

    public final String toString() {
        String str;
        String str2 = "";
        if (this.cYc == b.STATIC_FIELD) {
            str2 = str2 + "static ";
        }
        if (this.cYd == a.ARRAY || this.cYd == a.THREAD) {
            str2 = str2 + this.cYd.name().toLowerCase(Locale.US) + " ";
        }
        String str3 = str2 + this.className;
        if (this.cYa != null) {
            str = str3 + " " + this.cYa;
        } else {
            str = str3 + " instance";
        }
        if (this.extra != null) {
            str = str + " " + this.extra;
        }
        if (this.cXX != null) {
            return str + " , matching exclusion " + this.cXX.cXU;
        }
        return str;
    }
}

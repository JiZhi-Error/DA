package com.google.a;

import java.util.List;

public final class ca extends RuntimeException {
    private final List<String> bZL;

    public ca() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.bZL = null;
    }

    public ca(List<String> list) {
        super(D(list));
        this.bZL = list;
    }

    private static String D(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}

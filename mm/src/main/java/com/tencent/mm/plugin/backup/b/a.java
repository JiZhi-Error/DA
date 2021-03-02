package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<a> oIJ = new LinkedList<>();

    public abstract void ceH();

    public static void a(a aVar) {
        oIJ.add(aVar);
    }

    public static void ceG() {
        Iterator<a> it = oIJ.iterator();
        while (it.hasNext()) {
            it.next().ceH();
        }
        oIJ.clear();
    }
}

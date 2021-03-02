package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f {
    public static ArrayList<c> kgc;
    private static String qQn;

    public static void c(Context context, ArrayList<c> arrayList) {
        AppMethodBeat.i(30463);
        if (kgc != null) {
            kgc.clear();
        }
        kgc = arrayList;
        HashSet hashSet = new HashSet();
        if (kgc != null) {
            Iterator<c> it = kgc.iterator();
            while (it.hasNext()) {
                c next = it.next();
                String d2 = com.tencent.mm.plugin.wenote.c.c.d(next);
                if (!Util.isNullOrNil(d2)) {
                    hashSet.add(d2);
                }
                String e2 = com.tencent.mm.plugin.wenote.c.c.e(next);
                if (!Util.isNullOrNil(e2)) {
                    hashSet.add(e2);
                }
            }
        }
        ao.tbJ = hashSet;
        StringBuilder sb = new StringBuilder("");
        if (kgc != null) {
            for (int i2 = 0; i2 < kgc.size(); i2++) {
                if (i2 != kgc.size() - 1) {
                    sb.append(com.tencent.mm.plugin.wenote.c.c.a(context, kgc.get(i2))).append("<br/>");
                } else {
                    sb.append(com.tencent.mm.plugin.wenote.c.c.a(context, kgc.get(i2)));
                }
            }
        }
        String alM = com.tencent.mm.plugin.wenote.c.c.alM(sb.toString());
        qQn = alM;
        ClipboardHelper.setText(a.alS(alM));
        AppMethodBeat.o(30463);
    }

    public static ArrayList<c> cDk() {
        boolean z;
        AppMethodBeat.i(30464);
        ArrayList<c> arrayList = new ArrayList<>();
        if (kgc == null) {
            AppMethodBeat.o(30464);
            return arrayList;
        }
        Iterator<c> it = kgc.iterator();
        while (it.hasNext()) {
            c c2 = com.tencent.mm.plugin.wenote.c.c.c(it.next());
            if (c2 == null) {
                z = false;
            } else {
                z = true;
                int type = c2.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d2 = com.tencent.mm.plugin.wenote.c.c.d(c2);
                    if (Util.isNullOrNil(d2) || !s.YS(d2)) {
                        z = false;
                    }
                }
                if (type == 2 || type == 6) {
                    String e2 = com.tencent.mm.plugin.wenote.c.c.e(c2);
                    if (Util.isNullOrNil(e2) || !s.YS(e2)) {
                        z = false;
                    }
                }
            }
            if (z) {
                arrayList.add(c2);
            }
        }
        AppMethodBeat.o(30464);
        return arrayList;
    }

    public static void clearData() {
        AppMethodBeat.i(30465);
        if (kgc != null) {
            kgc.clear();
        }
        qQn = "";
        ao.tbJ = null;
        AppMethodBeat.o(30465);
    }

    public static boolean cDm() {
        AppMethodBeat.i(30466);
        ClipboardManager clipboardManager = (ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            AppMethodBeat.o(30466);
            return true;
        } else if (com.tencent.mm.plugin.wenote.c.c.alK(clipboardManager.getText().toString()) >= 16384) {
            AppMethodBeat.o(30466);
            return true;
        } else {
            AppMethodBeat.o(30466);
            return false;
        }
    }

    public static int cDn() {
        boolean z;
        boolean z2;
        String str;
        AppMethodBeat.i(30467);
        ClipboardManager clipboardManager = (ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard");
        if (clipboardManager == null || clipboardManager.getText() == null || clipboardManager.getText().length() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (kgc == null || kgc.size() <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            AppMethodBeat.o(30467);
            return 1;
        } else if (!z && z2) {
            AppMethodBeat.o(30467);
            return 2;
        } else if (z) {
            AppMethodBeat.o(30467);
            return 3;
        } else {
            try {
                CharSequence text = clipboardManager.getText();
                if (text instanceof Spanned) {
                    str = b.a((Spanned) text);
                } else {
                    str = text.toString();
                }
            } catch (Exception e2) {
                Log.e("WNNoteClipboardManager", "get clipboard data error : ", e2);
                str = "";
            }
            if (str.equals(qQn)) {
                AppMethodBeat.o(30467);
                return 3;
            }
            AppMethodBeat.o(30467);
            return 2;
        }
    }
}

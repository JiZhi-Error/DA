package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b {
    public static ArrayList<a> kgc;
    private static String qQn;

    public static void c(Context context, ArrayList<a> arrayList) {
        AppMethodBeat.i(181719);
        if (kgc != null) {
            kgc.clear();
        }
        kgc = arrayList;
        ao.tbJ = cDl();
        StringBuilder sb = new StringBuilder("");
        if (kgc != null) {
            for (int i2 = 0; i2 < kgc.size(); i2++) {
                if (i2 != kgc.size() - 1) {
                    sb.append(com.tencent.mm.plugin.editor.b.a(context, kgc.get(i2))).append("<br/>");
                } else {
                    sb.append(com.tencent.mm.plugin.editor.b.a(context, kgc.get(i2)));
                }
            }
        }
        String alM = com.tencent.mm.plugin.editor.b.alM(sb.toString());
        qQn = alM;
        ClipboardHelper.setText(com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(alM));
        AppMethodBeat.o(181719);
    }

    public static ArrayList<a> cDk() {
        AppMethodBeat.i(181720);
        ArrayList<a> arrayList = new ArrayList<>();
        if (kgc == null) {
            AppMethodBeat.o(181720);
            return arrayList;
        }
        Iterator<a> it = kgc.iterator();
        while (it.hasNext()) {
            a a2 = com.tencent.mm.plugin.editor.b.a(it.next());
            if (d(a2)) {
                arrayList.add(a2);
            }
        }
        AppMethodBeat.o(181720);
        return arrayList;
    }

    public static void clearData() {
        AppMethodBeat.i(181721);
        if (kgc != null) {
            kgc.clear();
        }
        qQn = "";
        ao.tbJ = null;
        AppMethodBeat.o(181721);
    }

    private static Set<String> cDl() {
        AppMethodBeat.i(181722);
        HashSet hashSet = new HashSet();
        if (kgc == null) {
            AppMethodBeat.o(181722);
            return hashSet;
        }
        Iterator<a> it = kgc.iterator();
        while (it.hasNext()) {
            a next = it.next();
            String b2 = com.tencent.mm.plugin.editor.b.b(next);
            if (!Util.isNullOrNil(b2)) {
                hashSet.add(b2);
            }
            String c2 = com.tencent.mm.plugin.editor.b.c(next);
            if (!Util.isNullOrNil(c2)) {
                hashSet.add(c2);
            }
        }
        AppMethodBeat.o(181722);
        return hashSet;
    }

    private static boolean d(a aVar) {
        AppMethodBeat.i(181723);
        if (aVar == null) {
            AppMethodBeat.o(181723);
            return false;
        }
        boolean z = true;
        int type = aVar.getType();
        if (type == 2 || type == 6 || type == 4 || type == 5) {
            String b2 = com.tencent.mm.plugin.editor.b.b(aVar);
            if (Util.isNullOrNil(b2) || !s.YS(b2)) {
                z = false;
            }
        }
        if (type == 2 || type == 6) {
            String c2 = com.tencent.mm.plugin.editor.b.c(aVar);
            if (Util.isNullOrNil(c2) || !s.YS(c2)) {
                z = false;
            }
        }
        AppMethodBeat.o(181723);
        return z;
    }

    public static boolean cDm() {
        AppMethodBeat.i(181724);
        ClipboardManager clipboardManager = (ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            AppMethodBeat.o(181724);
            return true;
        } else if (com.tencent.mm.plugin.editor.b.alK(clipboardManager.getText().toString()) >= 16384) {
            AppMethodBeat.o(181724);
            return true;
        } else {
            AppMethodBeat.o(181724);
            return false;
        }
    }

    public static int cDn() {
        boolean z;
        boolean z2;
        String str;
        AppMethodBeat.i(181725);
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
            AppMethodBeat.o(181725);
            return 1;
        } else if (!z && z2) {
            AppMethodBeat.o(181725);
            return 2;
        } else if (z) {
            AppMethodBeat.o(181725);
            return 3;
        } else {
            try {
                CharSequence text = clipboardManager.getText();
                if (text instanceof Spanned) {
                    str = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned) text);
                } else {
                    str = text.toString();
                }
            } catch (Exception e2) {
                Log.e("EditorClipboardManager", "get clipboard data error : ", e2);
                str = "";
            }
            if (str.equals(qQn)) {
                AppMethodBeat.o(181725);
                return 3;
            }
            AppMethodBeat.o(181725);
            return 2;
        }
    }
}

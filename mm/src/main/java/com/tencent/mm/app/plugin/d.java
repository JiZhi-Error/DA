package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.b;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d implements p {
    @Override // com.tencent.mm.pluginsdk.p
    public final String v(Context context, String str) {
        String str2;
        String format;
        AppMethodBeat.i(19664);
        ArrayList<u> cn = b.cn(context, str);
        if (cn.size() == 0) {
            AppMethodBeat.o(19664);
        } else {
            Collections.sort(cn, new Comparator<u>() {
                /* class com.tencent.mm.app.plugin.d.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(u uVar, u uVar2) {
                    int i2 = uVar.start;
                    int i3 = uVar2.start;
                    if (i2 < i3) {
                        return -1;
                    }
                    if (i2 > i3) {
                        return 1;
                    }
                    return 0;
                }
            });
            Iterator<u> it = cn.iterator();
            String str3 = str;
            while (true) {
                if (it.hasNext()) {
                    u next = it.next();
                    String str4 = null;
                    int i2 = next.start;
                    int i3 = next.end;
                    switch (next.type) {
                        case 1:
                            str4 = "<a href=\"%s\">%s</a>";
                            break;
                        case 24:
                            str4 = "<a href=\"%s@mailto@\">%s</a>";
                            break;
                        case 25:
                            str4 = "<a href=\"%s@tel@\">%s</a>";
                            break;
                    }
                    if (str4 != null) {
                        String str5 = next.url;
                        if (next.type != 1 || str5.startsWith(HttpWrapperBase.PROTOCAL_HTTP)) {
                            format = String.format(str4, str5.trim(), str5.trim());
                        } else {
                            format = String.format(str4, HttpWrapperBase.PROTOCAL_HTTP + str5.trim(), str5.trim());
                        }
                        str2 = a(str3, i2, i3, format);
                        if (str2.length() == 0) {
                        }
                    } else {
                        str2 = str3;
                    }
                    str3 = str2;
                } else {
                    str = str3;
                }
            }
            Log.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
            AppMethodBeat.o(19664);
        }
        return str;
    }

    private static String a(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(19665);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || i2 >= i3) {
            AppMethodBeat.o(19665);
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(str.subSequence(0, i2 + 0));
            sb.append(str2);
            sb.append(str.subSequence(i3 + 0, str.length()));
            str2.length();
            String sb2 = sb.toString();
            AppMethodBeat.o(19665);
            return sb2;
        } catch (Exception e2) {
            Log.e("MicroMsg.QrCodeURLHelper", e2.getMessage());
            AppMethodBeat.o(19665);
            return "";
        }
    }

    @Override // com.tencent.mm.pluginsdk.p
    public final boolean a(Context context, String str, DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(19666);
        Log.d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(19666);
            return false;
        }
        if (str.endsWith("@mailto@")) {
            n.b(context, str.substring(0, str.length() - 8), onDismissListener);
        } else if (str.endsWith("@tel@")) {
            String substring = str.substring(0, str.length() - 5);
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 3);
            n.a(context, substring, onDismissListener, bundle);
        } else {
            AppMethodBeat.o(19666);
            return false;
        }
        AppMethodBeat.o(19666);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.p
    public final boolean gw(String str) {
        AppMethodBeat.i(19667);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(19667);
            return false;
        } else if (str.endsWith("@mailto@") || str.endsWith("@tel@")) {
            AppMethodBeat.o(19667);
            return true;
        } else {
            AppMethodBeat.o(19667);
            return false;
        }
    }
}

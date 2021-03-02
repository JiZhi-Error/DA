package com.tencent.mm.search.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/search/report/SimilarEmojiIdKey;", "", "()V", "KEY", "", "enableReport", "", "start", "markEmojiLoad", "", "markEmojiLoadTime", "time", "markSendDialogSimilarEmoji", "markSendSosSimilarEmoji", "markShowSimilarEmojiDialog", "markShowSimilarEmojiMenu", "markShowSosPage", "markSimilarRequest", "markSimilarRequestTime", "plugin-emojisdk_release"})
public final class a {
    public static final a NJv = new a();

    static {
        AppMethodBeat.i(105851);
        AppMethodBeat.o(105851);
    }

    private a() {
    }

    public static void gxr() {
        AppMethodBeat.i(105841);
        h.INSTANCE.F(1257, 1);
        AppMethodBeat.o(105841);
    }

    public static void gxs() {
        AppMethodBeat.i(105842);
        h.INSTANCE.F(1257, 2);
        AppMethodBeat.o(105842);
    }

    public static void gxt() {
        AppMethodBeat.i(105843);
        h.INSTANCE.F(1257, 3);
        AppMethodBeat.o(105843);
    }

    public static void gxu() {
        AppMethodBeat.i(105844);
        h.INSTANCE.F(1257, 4);
        AppMethodBeat.o(105844);
    }

    public static void gxv() {
        AppMethodBeat.i(105845);
        h.INSTANCE.F(1257, 5);
        AppMethodBeat.o(105845);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void gxw() {
        AppMethodBeat.i(105846);
        switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext())) {
            case 1:
                h.INSTANCE.F(1257, 109);
                break;
            case 2:
                h.INSTANCE.F(1257, 100);
                AppMethodBeat.o(105846);
                return;
            case 3:
                h.INSTANCE.F(1257, 103);
                AppMethodBeat.o(105846);
                return;
            case 4:
                h.INSTANCE.F(1257, 106);
                AppMethodBeat.o(105846);
                return;
        }
        AppMethodBeat.o(105846);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MF(long j2) {
        AppMethodBeat.i(105847);
        switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext())) {
            case 1:
                h.INSTANCE.n(1257, 110, j2);
                break;
            case 2:
                h.INSTANCE.n(1257, 101, j2);
                AppMethodBeat.o(105847);
                return;
            case 3:
                h.INSTANCE.n(1257, 104, j2);
                AppMethodBeat.o(105847);
                return;
            case 4:
                h.INSTANCE.n(1257, 107, j2);
                AppMethodBeat.o(105847);
                return;
        }
        AppMethodBeat.o(105847);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void gxx() {
        AppMethodBeat.i(105848);
        switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext())) {
            case 1:
                h.INSTANCE.F(1257, 124);
                break;
            case 2:
                h.INSTANCE.F(1257, 115);
                AppMethodBeat.o(105848);
                return;
            case 3:
                h.INSTANCE.F(1257, 118);
                AppMethodBeat.o(105848);
                return;
            case 4:
                h.INSTANCE.F(1257, 121);
                AppMethodBeat.o(105848);
                return;
        }
        AppMethodBeat.o(105848);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MG(long j2) {
        AppMethodBeat.i(105849);
        switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext())) {
            case 1:
                h.INSTANCE.n(1257, 125, j2);
                break;
            case 2:
                h.INSTANCE.n(1257, 116, j2);
                AppMethodBeat.o(105849);
                return;
            case 3:
                h.INSTANCE.n(1257, 119, j2);
                AppMethodBeat.o(105849);
                return;
            case 4:
                h.INSTANCE.n(1257, 122, j2);
                AppMethodBeat.o(105849);
                return;
        }
        AppMethodBeat.o(105849);
    }

    public static boolean MH(long j2) {
        AppMethodBeat.i(105850);
        if (System.currentTimeMillis() - j2 > 10000) {
            AppMethodBeat.o(105850);
            return false;
        }
        AppMethodBeat.o(105850);
        return true;
    }
}

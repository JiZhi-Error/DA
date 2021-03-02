package com.tencent.mm.cj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a {
    private static String GvH = "";
    private static boolean Own;
    private static String Owo = "";
    private static boolean Owp;
    public static final C0295a Owq = new C0295a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", DownloadInfo.FILENAME, "isTransVoiceScene", "plugin-audiologic_release"})
    /* renamed from: com.tencent.mm.cj.a$a  reason: collision with other inner class name */
    public static final class C0295a {
        private C0295a() {
        }

        public /* synthetic */ C0295a(byte b2) {
            this();
        }

        public static void blJ(String str) {
            AppMethodBeat.i(185491);
            p.h(str, "<set-?>");
            a.Owo = str;
            AppMethodBeat.o(185491);
        }

        public static boolean blI(String str) {
            AppMethodBeat.i(148678);
            if (!a.Own || !p.j(a.GvH, str)) {
                AppMethodBeat.o(148678);
                return false;
            }
            AppMethodBeat.o(148678);
            return true;
        }

        public static boolean blK(String str) {
            AppMethodBeat.i(185492);
            if (!a.Owp || !p.j(a.Owo, str)) {
                AppMethodBeat.o(185492);
                return false;
            }
            AppMethodBeat.o(185492);
            return true;
        }
    }

    static {
        AppMethodBeat.i(148679);
        AppMethodBeat.o(148679);
    }
}

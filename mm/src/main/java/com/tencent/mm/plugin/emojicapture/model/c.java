package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\nH\u0002¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"})
public final class c implements a {
    private final String TAG = "MicroMsg.EmojiCaptureCommand";

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(154);
        p.h(strArr, "args");
        p.h(str, ch.COL_USERNAME);
        Log.i(this.TAG, "processCommand: " + e.a(strArr, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        if (strArr.length <= 1) {
            AppMethodBeat.o(154);
            return false;
        }
        String str2 = strArr[1];
        switch (str2.hashCode()) {
            case -1890252483:
                if (str2.equals("sticker") && strArr.length > 2) {
                    String str3 = strArr[2];
                    switch (str3.hashCode()) {
                        case -1408207997:
                            if (str3.equals("assets")) {
                                com.tencent.mm.plugin.xlabeffect.e eVar = com.tencent.mm.plugin.xlabeffect.e.JRF;
                                com.tencent.mm.plugin.xlabeffect.e.glw();
                                break;
                            }
                            break;
                        case 94746185:
                            if (str3.equals("clean")) {
                                com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
                                com.tencent.mm.sticker.a.b.gzh();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(154);
                    return true;
                }
        }
        AppMethodBeat.o(154);
        return false;
    }
}

package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "plugin-gamelife_release"})
public final class a implements c {
    private final String md5;
    final String url;

    public a(String str) {
        AppMethodBeat.i(241382);
        this.url = str;
        String str2 = this.url;
        this.md5 = MD5Util.getMD5String(str2 == null ? "" : str2);
        AppMethodBeat.o(241382);
    }

    @Override // com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(241380);
        String str = "gamelife_avatar_" + this.md5;
        AppMethodBeat.o(241380);
        return str;
    }

    public final String getPath() {
        AppMethodBeat.i(241381);
        String str = ((PluginGameLife) g.ah(PluginGameLife.class)).getAvatarPath() + auA();
        AppMethodBeat.o(241381);
        return str;
    }
}

package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/jump/TextStatusJumpManager;", "", "()V", "TAG", "", "singletons", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "Lkotlin/collections/HashMap;", "doJump", "", "sourceId", "textStatusID", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class e {
    public static final HashMap<String, b> FYa;
    public static final e FYb = new e();

    static {
        AppMethodBeat.i(216129);
        HashMap<String, b> hashMap = new HashMap<>();
        FYa = hashMap;
        hashMap.put("demo@inner", new a());
        FYa.put("music_player@inner", new d());
        FYa.put("live_player@inner", new c());
        FYa.put("wedraw@inner", new f());
        AppMethodBeat.o(216129);
    }

    private e() {
    }
}

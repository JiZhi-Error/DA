package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001a2\u00020\u0001:\u0003\u0018\u0019\u001aJ@\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rH&J\"\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0017H&¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "dealBlackList", "", "context", "Landroid/content/Context;", "sessionId", "", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "", "isAssociateWithWAGame", "callback", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "userName", "scene", "", "enterSendGift", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "BlackListAssociateCallback", "BlackListSetCallback", "Companion", "plugin-gamelife_release"})
public interface c extends com.tencent.mm.kernel.b.a {
    public static final C1413c yaa = C1413c.yab;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
    public interface a {
        void U(boolean z, boolean z2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "", "onDone", "", "isBlackList", "", "plugin-gamelife_release"})
    public interface b {
        void mM(boolean z);
    }

    void dealBlackList(Context context, String str, i<Boolean> iVar, i<Boolean> iVar2, b bVar);

    void enterGameLifeProfileUI(Context context, String str, int i2);

    void enterSendGift(Context context, String str);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$Companion;", "", "()V", "CLASS", "", "plugin-gamelife_release"})
    /* renamed from: com.tencent.mm.plugin.gamelife.c$c  reason: collision with other inner class name */
    public static final class C1413c {
        static final /* synthetic */ C1413c yab = new C1413c();

        static {
            AppMethodBeat.i(241191);
            AppMethodBeat.o(241191);
        }

        private C1413c() {
        }
    }
}

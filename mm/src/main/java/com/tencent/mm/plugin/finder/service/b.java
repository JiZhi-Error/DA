package com.tencent.mm.plugin.finder.service;

import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0015\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"})
public final class b implements n {
    private final a vvN = a.bqt("FinderConversationNotify");

    public b() {
        AppMethodBeat.i(251450);
        AppMethodBeat.o(251450);
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final void ave(String str) {
        AppMethodBeat.i(251442);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(251442);
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251442);
            throw runtimeException;
        } else {
            ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().avs(str);
            AppMethodBeat.o(251442);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final int avf(String str) {
        boolean z;
        AppMethodBeat.i(251443);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(251443);
            return 0;
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251443);
            throw runtimeException;
        } else {
            int avf = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().avf(str);
            AppMethodBeat.o(251443);
            return avf;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final boolean avg(String str) {
        boolean z;
        AppMethodBeat.i(251444);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(251444);
            return false;
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251444);
            throw runtimeException;
        } else {
            boolean cZv = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().avq(str).cZv();
            AppMethodBeat.o(251444);
            return cZv;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final String avh(String str) {
        AppMethodBeat.i(251445);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(251445);
            return "";
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251445);
            throw runtimeException;
        } else {
            String str3 = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().avq(str).field_editingMsg;
            if (str3 == null) {
                str3 = "";
            }
            AppMethodBeat.o(251445);
            return str3;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final boolean gT(String str, String str2) {
        AppMethodBeat.i(251446);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(251446);
            return false;
        } else if (str2 == null) {
            AppMethodBeat.o(251446);
            return false;
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251446);
            throw runtimeException;
        } else {
            e conversationStorage = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
            p.h(str, "sessionId");
            p.h(str2, "editing");
            c avq = conversationStorage.avq(str);
            avq.field_editingMsg = str2;
            boolean update = conversationStorage.update(avq.systemRowid, avq, false);
            conversationStorage.doNotify(avq.field_sessionId, 7, avq);
            Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + update + " editing=" + str2 + " sessionId=" + str);
            AppMethodBeat.o(251446);
            return update;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final boolean bt(String str, boolean z) {
        AppMethodBeat.i(251447);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(251447);
        } else if (!as.avl(str)) {
            RuntimeException runtimeException = new RuntimeException("sessionId[" + str + "] is not session");
            AppMethodBeat.o(251447);
            throw runtimeException;
        } else {
            ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().bt(str, z);
            AppMethodBeat.o(251447);
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final void m(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(251448);
        if (iOnStorageChange != null) {
            ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().add(this.vvN, iOnStorageChange);
            AppMethodBeat.o(251448);
            return;
        }
        AppMethodBeat.o(251448);
    }

    @Override // com.tencent.mm.plugin.i.a.n
    public final void l(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(251449);
        if (iOnStorageChange != null) {
            ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().remove(iOnStorageChange);
            AppMethodBeat.o(251449);
            return;
        }
        AppMethodBeat.o(251449);
    }
}

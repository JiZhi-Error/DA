package com.tencent.mm.emoji.b.b;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u00102\u001a\u00020.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020.0-J\u0006\u00104\u001a\u00020.J\u0014\u00105\u001a\u00020.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020.0-R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010(\"\u0004\b1\u0010*¨\u00067"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "smileyRecentMaxCount", "getSmileyRecentMaxCount", "setSmileyRecentMaxCount", "addSendListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i {
    public static final a gYr = new a((byte) 0);
    public boolean gYf;
    public boolean gYg = true;
    public boolean gYh = true;
    public boolean gYi = true;
    public boolean gYj;
    public boolean gYk = true;
    public boolean gYl;
    public boolean gYm = true;
    public boolean gYn;
    public boolean gYo = true;
    public int gYp = 8;
    public final LinkedList<kotlin.g.a.a<x>> gYq = new LinkedList<>();
    public int scene = ChatFooterPanel.KbB;

    static {
        AppMethodBeat.i(105543);
        AppMethodBeat.o(105543);
    }

    public i() {
        AppMethodBeat.i(105542);
        AppMethodBeat.o(105542);
    }

    public final void eb(boolean z) {
        AppMethodBeat.i(105539);
        this.gYn = z;
        Iterator<T> it = this.gYq.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        AppMethodBeat.o(105539);
    }

    public final void g(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(105540);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.gYq.remove(aVar);
        AppMethodBeat.o(105540);
    }

    public final void avt() {
        boolean z;
        AppMethodBeat.i(105541);
        if (this.scene == ChatFooterPanel.KbC) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(66832, Boolean.FALSE);
            if (!(obj instanceof Boolean)) {
                obj = null;
            }
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            if (z != this.gYn) {
                eb(z);
            }
        }
        AppMethodBeat.o(105541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig$Companion;", "", "()V", "convertScene", "", "panelScene", "isShowCaptureEntrance", "", "scene", "isShowCustomEntrance", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int ph(int i2) {
            if (i2 != ChatFooterPanel.KbC) {
                if (i2 == ChatFooterPanel.KbH) {
                    return 3;
                }
                if (i2 == ChatFooterPanel.KbI) {
                    return 4;
                }
                if (i2 == ChatFooterPanel.KbJ) {
                    return 5;
                }
            }
            return 2;
        }
    }

    public static final boolean pf(int i2) {
        AppMethodBeat.i(105544);
        com.tencent.mm.kernel.b.a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        com.tencent.mm.pluginsdk.a.e provider = ((d) ah).getProvider();
        p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (!provider.avf() || !(i2 == ChatFooterPanel.KbC || i2 == ChatFooterPanel.KbH || i2 == ChatFooterPanel.KbI || i2 == ChatFooterPanel.KbJ)) {
            AppMethodBeat.o(105544);
            return false;
        }
        AppMethodBeat.o(105544);
        return true;
    }

    public static final boolean pg(int i2) {
        return i2 == ChatFooterPanel.KbC;
    }
}

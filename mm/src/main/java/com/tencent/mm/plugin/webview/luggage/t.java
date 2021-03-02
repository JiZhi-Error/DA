package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "iconFromJsApi", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "webMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/WebMultiTaskData;", "fillMultiTaskInfo", "", "getTaskId", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onCreate", "multiTaskType", "multiTaskId", "onMenuMultiTaskSelected", "enterMultiTask", "setIconFromJsApi", "icon", "setIconFromPreverify", "Companion", "plugin-webview_release"})
public final class t extends c {
    private static final Set<String> IUM;
    private static final String IVd = IVd;
    public static final a IVe = new a((byte) 0);
    private static final String TAG = TAG;
    private final g IVa;
    private final fah IVb = new fah();
    public String IVc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(g gVar, com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        Intent intent;
        p.h(gVar, "page");
        p.h(aVar, "adapter");
        AppMethodBeat.i(210318);
        this.IVa = gVar;
        com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
        if (aVar2 != null) {
            intent = aVar2.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
            if (aVar3 == null) {
                p.hyc();
            }
            Intent intent2 = aVar3.getIntent();
            if (intent2 == null) {
                p.hyc();
            }
            b.b(intent2, this.IVb);
        }
        AppMethodBeat.o(210318);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper$Companion;", "", "()V", "GAME_APPID", "", "getGAME_APPID", "()Ljava/lang/String;", "TAG", "getTAG", "sSavedKeysForWebPage", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(210319);
        HashSet hashSet = new HashSet();
        IUM = hashSet;
        hashSet.add("title");
        hashSet.add("webpageTitle");
        hashSet.add("hide_option_menu");
        hashSet.add("translate_webview");
        hashSet.add("srcUsername");
        hashSet.add("srcDisplayname");
        hashSet.add("mode");
        hashSet.add("KTemplateId");
        hashSet.add("KPublisherId");
        String str = e.p.Ozw;
        p.g(str, "ConstantsUI.WebViewUI.KTmplScene");
        hashSet.add(str);
        String str2 = e.p.Ozx;
        p.g(str2, "ConstantsUI.WebViewUI.KTmplSubScene");
        hashSet.add(str2);
        hashSet.add("pay_channel");
        hashSet.add("key_download_restrict");
        hashSet.add("key_wallet_region");
        hashSet.add("key_function_id");
        String str3 = e.p.OzA;
        p.g(str3, "ConstantsUI.WebViewUI.KTmplItemShowType");
        hashSet.add(str3);
        hashSet.add("geta8key_scene");
        hashSet.add("biz_video_msg_id");
        hashSet.add("biz_video_msg_index");
        hashSet.add("biz_video_msg_svr_id");
        hashSet.add("biz_mp_msg_info");
        String str4 = e.p.OzI;
        p.g(str4, "ConstantsUI.WebViewUI.KAdUxInfoForJsApiPay");
        hashSet.add(str4);
        hashSet.add("key_menu_hide_expose");
        hashSet.add("webviewCurrentProcess");
        AppMethodBeat.o(210319);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void G(int i2, String str) {
        Intent intent;
        AppMethodBeat.i(210312);
        super.G(i2, str);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        MultiTaskInfo multiTaskInfo = (aVar == null || (intent = aVar.getIntent()) == null) ? null : (MultiTaskInfo) intent.getParcelableExtra("KMutilTaskInfo");
        if (multiTaskInfo != null) {
            this.Abp = multiTaskInfo;
        }
        AppMethodBeat.o(210312);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void ic(boolean z) {
        AppMethodBeat.i(210313);
        bPu();
        super.ic(z);
        AppMethodBeat.o(210313);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(210314);
        bPu();
        boolean O = super.O(i2, z);
        AppMethodBeat.o(210314);
        return O;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        AppMethodBeat.i(210315);
        boolean cpz = this.IVa.cpz();
        AppMethodBeat.o(210315);
        return cpz;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        AppMethodBeat.i(210316);
        boolean cpz = this.IVa.cpz();
        AppMethodBeat.o(210316);
        return cpz;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void bPu() {
        AppMethodBeat.i(210317);
        try {
            this.IVb.edo = this.IVa.coX();
            this.IVb.title = this.IVa.getTitle();
            MultiTaskInfo multiTaskInfo = this.Abp;
            if (multiTaskInfo != null) {
                multiTaskInfo.field_data = this.IVb.toByteArray();
                AppMethodBeat.o(210317);
                return;
            }
            AppMethodBeat.o(210317);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + e2.getMessage());
            AppMethodBeat.o(210317);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean dki() {
        return true;
    }

    public final String bjl() {
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            return multiTaskInfo.field_id;
        }
        return null;
    }
}

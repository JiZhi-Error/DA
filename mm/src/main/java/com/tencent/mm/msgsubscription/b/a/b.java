package com.tencent.mm.msgsubscription.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J6\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¨\u0006$"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgServiceProxy;", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "()V", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "templateId", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSwitchOpened", "Companion", "plugin-comm_release"})
public final class b extends com.tencent.mm.msgsubscription.b.a {
    public static final a jAg = new a((byte) 0);

    static {
        AppMethodBeat.i(223328);
        AppMethodBeat.o(223328);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        super(null);
    }

    @Override // com.tencent.mm.msgsubscription.b.a
    public final void bG(String str, String str2) {
        AppMethodBeat.i(223321);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        Log.w("MicroMsg.SubscribeMsgServiceProxy", "isTemplateMsgSubscribed not implemented in non-mm process");
        AppMethodBeat.o(223321);
    }

    @Override // com.tencent.mm.msgsubscription.b.a
    public final void a(String str, SubscribeMsgTmpItem subscribeMsgTmpItem, ISubscribeMsgService.b bVar) {
        AppMethodBeat.i(223322);
        p.h(str, "bizUsername");
        p.h(subscribeMsgTmpItem, "tmpItem");
        Log.w("MicroMsg.SubscribeMsgServiceProxy", "switchSubscribeStatus not implemented in non-mm process");
        AppMethodBeat.o(223322);
    }

    @Override // com.tencent.mm.msgsubscription.b.a, com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(223323);
        p.h(str, "bizUsername");
        p.h(list, "subscribeMsgList");
        Log.w("MicroMsg.SubscribeMsgServiceProxy", "saveSubscribeMsgUiStatus not implemented in non-mm process");
        AppMethodBeat.o(223323);
    }

    @Override // com.tencent.mm.msgsubscription.b.a
    public final void Z(String str, boolean z) {
        AppMethodBeat.i(223324);
        p.h(str, "bizUsername");
        Log.w("MicroMsg.SubscribeMsgServiceProxy", "updateLocalSwitchOpened not implemented in non-mm process");
        AppMethodBeat.o(223324);
    }

    @Override // com.tencent.mm.msgsubscription.b.a, com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(223325);
        p.h(context, "context");
        p.h(bundle, "extra");
        super.a(context, str, str2, bundle);
        AppMethodBeat.o(223325);
    }

    @Override // com.tencent.mm.msgsubscription.b.a, com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(Context context, int i2, int i3, String str, Bundle bundle) {
        AppMethodBeat.i(223326);
        p.h(context, "context");
        p.h(str, "bizAppId");
        super.a(context, i2, i3, str, bundle);
        AppMethodBeat.o(223326);
    }

    @Override // com.tencent.mm.msgsubscription.b.a
    public final void a(Context context, int i2, String str, String str2) {
        AppMethodBeat.i(223327);
        p.h(context, "context");
        p.h(str, "bizUsername");
        p.h(str2, "nickname");
        Log.w("MicroMsg.SubscribeMsgServiceProxy", "goToSettingManagerUI not implemented in non-mm process");
        AppMethodBeat.o(223327);
    }
}

package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J7\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\b2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0004¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "Lcom/tencent/mm/pluginsdk/model/app/AppMessageStorage$IAppMessageStorageInterceptor;", "()V", "get", "Lcom/tencent/mm/message/AppMessage;", "msgId", "", "insertNotify", "", "item", "isNotify", "replace", "shouldIntercept", "updateNotify", "keys", "", "", "(Lcom/tencent/mm/message/AppMessage;Z[Ljava/lang/String;)Z", "toGameLifeAppMessage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Companion", "plugin-gamelife_release"})
public final class b implements l.b {
    public static final a yci = new a((byte) 0);

    static {
        AppMethodBeat.i(241397);
        AppMethodBeat.o(241397);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.l.b
    public final boolean a(k kVar, boolean z) {
        AppMethodBeat.i(241392);
        if (kVar == null) {
            AppMethodBeat.o(241392);
            return false;
        }
        boolean insertNotify = ((PluginGameLife) g.ah(PluginGameLife.class)).getAppMessageStorage().insertNotify(b(kVar), z);
        Log.i("GameLife.AppMessageInterceptor", "[insert ret:" + insertNotify + "] appid:" + kVar.field_appId + " title:" + kVar.field_title + " desc:" + kVar.field_description + ' ' + "type:" + kVar.field_type + " msgId:" + kVar.field_msgId);
        AppMethodBeat.o(241392);
        return insertNotify;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.l.b
    public final boolean b(k kVar, boolean z) {
        AppMethodBeat.i(241393);
        if (kVar == null) {
            AppMethodBeat.o(241393);
            return false;
        }
        boolean replace = ((PluginGameLife) g.ah(PluginGameLife.class)).getAppMessageStorage().replace(b(kVar), z);
        Log.i("GameLife.AppMessageInterceptor", "[replace ret:" + replace + "] appid:" + kVar.field_appId + " title:" + kVar.field_title + " desc:" + kVar.field_description + ' ' + "type:" + kVar.field_type + " msgId:" + kVar.field_msgId);
        AppMethodBeat.o(241393);
        return replace;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.l.b
    public final k GL(long j2) {
        AppMethodBeat.i(241394);
        a aVar = new a();
        aVar.field_msgId = j2;
        if (!((PluginGameLife) g.ah(PluginGameLife.class)).getAppMessageStorage().get(aVar, new String[0])) {
            Log.i("GameLife.AppMessageInterceptor", "[get] msg:" + j2 + " not found!");
            AppMethodBeat.o(241394);
            return null;
        }
        Log.i("GameLife.AppMessageInterceptor", "[get] appId:" + aVar.field_appId + " title:" + aVar.field_title + " desc:" + aVar.field_description + " type:" + aVar.field_type + " msgId:" + aVar.field_msgId);
        k kVar = new k();
        kVar.field_appId = aVar.field_appId;
        kVar.field_description = aVar.field_description;
        kVar.field_msgId = aVar.field_msgId;
        kVar.field_source = aVar.field_source;
        kVar.field_title = aVar.field_title;
        kVar.field_type = aVar.field_type;
        kVar.field_xml = aVar.field_xml;
        AppMethodBeat.o(241394);
        return kVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.l.b
    public final boolean GM(long j2) {
        return (j2 >= 4500001 && j2 <= 5000000) || (j2 >= 208000001 && j2 <= 308000000);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.l.b
    public final boolean a(k kVar, boolean z, String... strArr) {
        AppMethodBeat.i(241395);
        p.h(strArr, "keys");
        if (kVar == null) {
            AppMethodBeat.o(241395);
            return false;
        }
        boolean updateNotify = ((PluginGameLife) g.ah(PluginGameLife.class)).getAppMessageStorage().updateNotify(b(kVar), z, (String[]) Arrays.copyOf(strArr, strArr.length));
        Log.i("GameLife.AppMessageInterceptor", "[update ret:" + updateNotify + "] appid:" + kVar.field_appId + " title:" + kVar.field_title + " desc:" + kVar.field_description + ' ' + "type:" + kVar.field_type + " msgId:" + kVar.field_msgId);
        AppMethodBeat.o(241395);
        return updateNotify;
    }

    private static a b(k kVar) {
        AppMethodBeat.i(241396);
        p.h(kVar, "$this$toGameLifeAppMessage");
        a aVar = new a();
        aVar.field_appId = kVar.field_appId;
        aVar.field_description = kVar.field_description;
        aVar.field_msgId = kVar.field_msgId;
        aVar.field_source = kVar.field_source;
        aVar.field_title = kVar.field_title;
        aVar.field_type = kVar.field_type;
        aVar.field_xml = kVar.field_xml;
        AppMethodBeat.o(241396);
        return aVar;
    }
}

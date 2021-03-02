package com.tencent.mm.plugin.textstatus.d;

import android.view.View;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.c.ch;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "contentView", "Landroid/view/View;", "setLoadLogicParam", "loadLogicParam", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "update", "", ch.COL_USERNAME, "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "LoadLogicParam", "plugin-textstatus_release"})
public interface d {
    void a(a aVar);

    boolean aNc(String str);

    boolean b(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar);

    void ba(View view);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "", "isLoadThumb", "", "(Z)V", "()Z", "setLoadThumb", "plugin-textstatus_release"})
    public static final class a {
        boolean FYG;

        public a(boolean z) {
            this.FYG = z;
        }

        public /* synthetic */ a() {
            this(true);
        }
    }
}

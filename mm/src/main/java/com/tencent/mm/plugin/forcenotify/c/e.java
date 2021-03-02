package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "forcePushId", "", "(Ljava/lang/String;)V", "getForcePushId", "()Ljava/lang/String;", "plugin-force-notify_release"})
public abstract class e implements a {
    public final String wMn;

    public e(String str) {
        p.h(str, "forcePushId");
        this.wMn = str;
    }
}

package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activityView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "(Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;)V", "canPost", "", "getCanPost", "()Z", "setCanPost", "(Z)V", "intent", "Landroid/content/Intent;", "getActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "onCreate", "", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "restore", "save", "shouldInterceptBackPress", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1311a vUG = new C1311a((byte) 0);
    public Intent intent;
    public final FinderExtendActivityView vUF;

    static {
        AppMethodBeat.i(253237);
        AppMethodBeat.o(253237);
    }

    public a(FinderExtendActivityView finderExtendActivityView) {
        p.h(finderExtendActivityView, "activityView");
        AppMethodBeat.i(253236);
        this.vUF = finderExtendActivityView;
        AppMethodBeat.o(253236);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget$Companion;", "", "()V", "IS_SHOW_CREATE", "", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.upload.postui.a$a  reason: collision with other inner class name */
    public static final class C1311a {
        private C1311a() {
        }

        public /* synthetic */ C1311a(byte b2) {
            this();
        }
    }

    public final void aq(Intent intent2) {
        AppMethodBeat.i(253235);
        p.h(intent2, "intent");
        int intExtra = intent2.getIntExtra("key_activity_type", 100);
        Intent intent3 = this.intent;
        if (intent3 == null) {
            p.btv("intent");
        }
        intent3.putExtra("saveActivity", true);
        this.vUF.b(intent2, intExtra);
        FinderExtendActivityView finderExtendActivityView = this.vUF;
        Intent intent4 = this.intent;
        if (intent4 == null) {
            p.btv("intent");
        }
        finderExtendActivityView.setIntentParam(intent4);
        AppMethodBeat.o(253235);
    }
}

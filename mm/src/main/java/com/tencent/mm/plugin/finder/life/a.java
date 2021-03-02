package com.tencent.mm.plugin.finder.life;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0019R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "callback", "reLifeObserver", "Landroid/support/v7/app/AppCompatActivity;", "removeObserver", "STATUS", "plugin-finder_release"})
public abstract class a {
    public EnumC1174a ueU = EnumC1174a.ON_ANY;
    public final EnumC1174a[] ueV = {EnumC1174a.ON_CREATE, EnumC1174a.ON_START, EnumC1174a.ON_RESUME, EnumC1174a.ON_ANY};
    UILifecycleObserver ueW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.life.a$a  reason: collision with other inner class name */
    public enum EnumC1174a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        static {
            AppMethodBeat.i(166289);
            AppMethodBeat.o(166289);
        }

        public static EnumC1174a valueOf(String str) {
            AppMethodBeat.i(166291);
            EnumC1174a aVar = (EnumC1174a) Enum.valueOf(EnumC1174a.class, str);
            AppMethodBeat.o(166291);
            return aVar;
        }
    }

    public final void a(MMFragmentActivity mMFragmentActivity, UILifecycleObserver uILifecycleObserver) {
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i("Finder.EventObserver", "life " + mMFragmentActivity + ' ' + this);
        this.ueW = new SupportLifecycle$life$1(this, uILifecycleObserver, mMFragmentActivity);
        UILifecycleObserver uILifecycleObserver2 = this.ueW;
        if (uILifecycleObserver2 != null) {
            mMFragmentActivity.getLifecycle().addObserver(uILifecycleObserver2);
        }
    }
}

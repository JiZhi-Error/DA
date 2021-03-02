package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "(Landroid/content/Context;Landroid/os/Handler;)V", "audioManager", "Landroid/media/AudioManager;", "deliverSelfNotifications", "", "onChange", "", "selfChange", "Companion", "luggage-xweb-ext_release"})
public final class i extends ContentObserver {
    public static final a mLk = new a((byte) 0);
    private final AudioManager audioManager;

    static {
        AppMethodBeat.i(139678);
        AppMethodBeat.o(139678);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context) {
        super(null);
        p.h(context, "context");
        AppMethodBeat.i(139677);
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(139677);
            throw tVar;
        }
        this.audioManager = (AudioManager) systemService;
        AppMethodBeat.o(139677);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver$Companion;", "", "()V", "TAG", "", "luggage-xweb-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean deliverSelfNotifications() {
        return false;
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(139676);
        Log.i("SettingsContentObserver", "Volume now ".concat(String.valueOf(this.audioManager.getStreamVolume(3))));
        AppMethodBeat.o(139676);
    }
}

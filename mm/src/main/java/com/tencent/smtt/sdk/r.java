package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.n;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.tav.core.AssetExtension;

/* access modifiers changed from: package-private */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2123a = null;

    /* renamed from: b  reason: collision with root package name */
    private Object f2124b = null;

    public r(DexLoader dexLoader, Context context) {
        AppMethodBeat.i(188401);
        this.f2123a = dexLoader;
        this.f2124b = this.f2123a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
        AppMethodBeat.o(188401);
    }

    public boolean a() {
        AppMethodBeat.i(55178);
        if (this.f2124b != null) {
            AppMethodBeat.o(55178);
            return true;
        }
        AppMethodBeat.o(55178);
        return false;
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(188402);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
        AppMethodBeat.o(188402);
    }

    public void a(TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.i(188403);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
        AppMethodBeat.o(188403);
    }

    public float b() {
        AppMethodBeat.i(188404);
        Float f2 = (Float) this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", n.NAME, new Class[0], new Object[0]);
        if (f2 != null) {
            float floatValue = f2.floatValue();
            AppMethodBeat.o(188404);
            return floatValue;
        }
        AppMethodBeat.o(188404);
        return 0.0f;
    }

    public void a(float f2) {
        AppMethodBeat.i(188405);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", com.tencent.mm.plugin.appbrand.jsapi.z.r.NAME, new Class[]{Float.TYPE}, Float.valueOf(f2));
        AppMethodBeat.o(188405);
    }

    public void a(String str, Bundle bundle) {
        AppMethodBeat.i(188406);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
        AppMethodBeat.o(188406);
    }

    public void a(int i2) {
        AppMethodBeat.i(188407);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", MessengerShareContentUtility.SUBTITLE, new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        AppMethodBeat.o(188407);
    }

    public void b(int i2) {
        AppMethodBeat.i(188408);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        AppMethodBeat.o(188408);
    }

    public void c() {
        AppMethodBeat.i(188409);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
        AppMethodBeat.o(188409);
    }

    public void d() {
        AppMethodBeat.i(188410);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", AssetExtension.SCENE_PLAY, new Class[0], new Object[0]);
        AppMethodBeat.o(188410);
    }

    public void a(long j2) {
        AppMethodBeat.i(188411);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j2));
        AppMethodBeat.o(188411);
    }

    public void e() {
        AppMethodBeat.i(188412);
        this.f2123a.invokeMethod(this.f2124b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
        AppMethodBeat.o(188412);
    }
}

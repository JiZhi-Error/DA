package com.tencent.mm.plugin.mv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.ui.uic.KeyboardProviderUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvCommentUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvLyricUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSongInfoUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvMainUI extends BaseMusicMvUI {
    private final String TAG = "MicroMsg.Mv.MusicMvMainUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256864);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256864);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256863);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256863);
        return view;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(256858);
        Set<Class<? extends UIComponent>> importUIComponents = super.importUIComponents();
        if (importUIComponents != null) {
            Set<Class<? extends UIComponent>> b2 = ak.b(importUIComponents, ak.setOf((Object[]) new Class[]{MusicMvDataUIC.class, MusicMvShareUIC.class, MusicMvSongInfoUIC.class, MusicMvInfoUIC.class, MusicMvChattingUIC.class, MusicMvMainUIC.class, KeyboardProviderUIC.class, MusicMvDebugUIC.class, MusicMvLyricUIC.class, MusicMvCommentUIC.class}));
            AppMethodBeat.o(256858);
            return b2;
        }
        AppMethodBeat.o(256858);
        return null;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256859);
        super.onCreate(bundle);
        if (!k.isInit()) {
            finish();
            Log.e(this.TAG, "MusicPlayerManager is not init!");
            AppMethodBeat.o(256859);
            return;
        }
        Intent intent = getIntent();
        p.g(intent, "intent");
        b.as(intent.getExtras());
        hideTitleView();
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.ac_));
        hideActionbarLine();
        AppMethodBeat.o(256859);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bec;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(256860);
        super.onNewIntent(intent);
        Log.i(this.TAG, "onNewIntent");
        AppMethodBeat.o(256860);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256861);
        super.onResume();
        c cVar = c.Akc;
        c.onResume();
        AppMethodBeat.o(256861);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256862);
        super.onPause();
        c cVar = c.Akc;
        c.hWr();
        AppMethodBeat.o(256862);
    }
}

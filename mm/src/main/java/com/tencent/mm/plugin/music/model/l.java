package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fJ\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010(\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u001e\u0010)\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$J(\u0010,\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicUIUtil;", "", "()V", "CANCEL_JUMP", "", "FROM_ACTION_BAR_RIGHT", "FROM_SONG_DIALOG", "JUMP_ERROR_WITH_NO_WRAPPER", "JUMP_TO_APP", "JUMP_TO_APPBRAND", "JUMP_TO_BIZ", "JUMP_TO_CALLBACK", "JUMP_TO_SHAKE_QQ_MUSIC", "JUMP_TO_WEB", "TAG", "", "doJumpToApp", "context", "Landroid/content/Context;", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "callback", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "formatFinderNumber", "number", "getBgAndLyricColor", "", "bitmap", "Landroid/graphics/Bitmap;", "getCurrentMusic", "Lcom/tencent/mm/plugin/music/model/storage/Music;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "isChinesePeople", "", "isoCode", "jumpToSongWebUrl", "", "launchQQMusic", "setWindowStyle", "isShowStatusBar", "isShowNavigationBar", "updatePlayIcon", "isChecked", "playBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "playBtnColor", "plugin-music_release"})
public final class l {
    public static final l AkI = new l();

    static {
        AppMethodBeat.i(219994);
        AppMethodBeat.o(219994);
    }

    private l() {
    }

    public static void a(Context context, f fVar) {
        AppMethodBeat.i(261715);
        String str = fVar.jfd == null ? fVar.jfb : fVar.jfd;
        Log.i("MusicUIUtil", "launch H5 url:%s", str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(261715);
    }

    public static void aq(Activity activity) {
        AppMethodBeat.i(219992);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Window window = activity.getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        p.g(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(5894);
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = activity.getWindow();
            p.g(window2, "activity.window");
            window2.setStatusBarColor(0);
            Window window3 = activity.getWindow();
            p.g(window3, "activity.window");
            window3.setNavigationBarColor(0);
        }
        activity.getWindow().setFormat(-3);
        AppMethodBeat.o(219992);
    }

    public static com.tencent.mm.plugin.music.model.e.a au(Activity activity) {
        com.tencent.mm.plugin.music.model.e.a aVar;
        AppMethodBeat.i(219993);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.plugin.music.f.c.a aS = com.tencent.mm.plugin.music.f.c.b.aS(e.class);
        p.g(aS, "MusicCoreService.service…PrivateLogic::class.java)");
        com.tencent.mm.plugin.music.model.e.a etY = ((e) aS).etY();
        if (etY == null) {
            String str = "";
            if (activity.getIntent().hasExtra("db_music_id")) {
                str = activity.getIntent().getStringExtra("db_music_id");
                p.g(str, "activity.intent.getStrin…MusicPlayerUI.KDBMusicId)");
            }
            if (!TextUtils.isEmpty(str)) {
                aVar = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).aHL(str);
                AppMethodBeat.o(219993);
                return aVar;
            }
        }
        aVar = etY;
        AppMethodBeat.o(219993);
        return aVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class a implements f.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent UZf;
        final /* synthetic */ al UZg;

        public a(Context context, Intent intent, al alVar) {
            this.$context = context;
            this.UZf = intent;
            this.UZg = alVar;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(261712);
            try {
                Context context = this.$context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.UZf);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/music/model/MusicUIUtil$launchQQMusic$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/music/model/MusicUIUtil$launchQQMusic$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                al alVar = this.UZg;
                if (alVar != null) {
                    alVar.v(true, false);
                    AppMethodBeat.o(261712);
                    return;
                }
                AppMethodBeat.o(261712);
            } catch (Exception e2) {
                Log.printErrStackTrace("MusicUIUtil", e2, "launchQQMusic exception", new Object[0]);
                al alVar2 = this.UZg;
                if (alVar2 != null) {
                    alVar2.v(false, false);
                    AppMethodBeat.o(261712);
                    return;
                }
                AppMethodBeat.o(261712);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class b implements f.c {
        final /* synthetic */ al UZg;

        public b(al alVar) {
            this.UZg = alVar;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(261713);
            al alVar = this.UZg;
            if (alVar != null) {
                alVar.v(false, true);
                AppMethodBeat.o(261713);
                return;
            }
            AppMethodBeat.o(261713);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
    public static final class c<I, O> implements com.tencent.f.e.a<P, R> {
        final /* synthetic */ f.a UZh;

        public c(f.a aVar) {
            this.UZh = aVar;
        }

        @Override // com.tencent.f.e.a
        public final /* synthetic */ Object bT(Object obj) {
            AppMethodBeat.i(261714);
            this.UZh.show();
            AppMethodBeat.o(261714);
            return null;
        }
    }
}

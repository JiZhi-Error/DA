package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.music.model.j;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0005H\u0014J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u001a\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010!\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J-\u0010\"\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0007H\u0014J\b\u0010\u0004\u001a\u00020\u0007H\u0002J\u0006\u0010*\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "router", "", "captureMvCover", "", "createMainUI", "intent", "Landroid/content/Intent;", "createMv", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditFinish", "p0", "", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onNewIntent", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "takePhoto", "Companion", "plugin-mv_release"})
public final class MusicMvRouterUI extends BaseMusicMvUI implements CaptureDataManager.b {
    public static final a Ary = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int ubR = -1;

    static {
        AppMethodBeat.i(256944);
        AppMethodBeat.o(256944);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256946);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256946);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256945);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256945);
        return view;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI$Companion;", "", "()V", "TAG", "", "TAKE_PHOTO_REQUEST_CODE", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256937);
        super.onCreate(bundle);
        this.ubR = getIntent().getIntExtra("KEY_MUSIC_ROUTER", -1);
        switch (this.ubR) {
            case 1:
                aML();
                AppMethodBeat.o(256937);
                return;
            case 2:
                e baZ = e.baZ();
                p.g(baZ, "SubCoreVideoControl.getCore()");
                VideoTransPara bbe = baZ.bbe();
                Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(bbe)));
                j jVar = j.AkE;
                String dEC = j.dEC();
                j jVar2 = j.AkE;
                RecordConfigProvider a2 = RecordConfigProvider.a(dEC, j.euz(), bbe, 0, 14);
                a2.BOu = Boolean.FALSE;
                a2.BOr = Boolean.TRUE;
                a2.BOs = Boolean.FALSE;
                a2.BOx = true;
                UICustomParam.a aVar = new UICustomParam.a();
                aVar.dy(true);
                aVar.apC();
                a2.BOn = aVar.apG();
                a2.F(1, MusicMvEditPhotoPluginLayout.class.getName());
                CaptureDataManager.BOb.a(this);
                com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(this, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, R.anim.ei, R.anim.ej, a2);
                AppMethodBeat.o(256937);
                return;
            case 3:
                Intent intent = new Intent(this, MusicMvMakerUI.class);
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_track_data");
                if (byteArrayExtra != null) {
                    intent.putExtra("key_track_data", byteArrayExtra);
                }
                d.a(intent, getIntent(), "key_mv_from_scene");
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(256937);
                return;
            default:
                Log.e("MicroMsg.Mv.MusicMvRouterUI", "unknown router: " + this.ubR);
                AppMethodBeat.o(256937);
                return;
        }
    }

    private void aML() {
        AppMethodBeat.i(256938);
        e baZ = e.baZ();
        p.g(baZ, "SubCoreVideoControl.getCore()");
        VideoTransPara bbe = baZ.bbe();
        Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(bbe)));
        j jVar = j.AkE;
        String dEC = j.dEC();
        j jVar2 = j.AkE;
        RecordConfigProvider a2 = RecordConfigProvider.a(dEC, j.euz(), bbe, bbe.duration * 1000, 14);
        a2.BOu = Boolean.FALSE;
        a2.BOr = Boolean.FALSE;
        a2.BOt = Boolean.TRUE;
        int intExtra = getIntent().getIntExtra("KEY_REQUIRE_VIDEO_DURATION", 1000);
        Log.i("MicroMsg.Mv.MusicMvRouterUI", "record require duration:".concat(String.valueOf(intExtra)));
        a2.BOw = 1000;
        a2.BOv = intExtra;
        a2.BOK = getContext().getString(R.string.fw9, new Object[]{Integer.valueOf((int) (((float) intExtra) / 1000.0f))});
        a2.BOJ.BOM = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_enable_beautify, true);
        a2.BOJ.hDb = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_skin_smooth, -1);
        a2.BOJ.hDc = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_eye_morph, -1);
        a2.BOJ.hDd = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_face_morph, -1);
        a2.BOJ.hDe = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_skin_bright, -1);
        a2.BOJ.hDf = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_eye_bright, -1);
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.apC();
        aVar.dz(false);
        aVar.apF();
        aVar.dx(true);
        aVar.dy(true);
        aVar.dv(true);
        aVar.dw(true);
        a2.BOn = aVar.apG();
        a2.BOo = i.e.CONTAIN;
        a2.F(2, MusicMvEditVideoPluginLayout.class.getName());
        CaptureDataManager.BOb.a(this);
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, R.anim.ei, R.anim.ej, a2);
        AppMethodBeat.o(256938);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ad  */
    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r8, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel r9, android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.MusicMvRouterUI.a(android.content.Context, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager$CaptureVideoNormalModel, android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(256940);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 233 && i3 == 0) {
            Log.i("MicroMsg.Mv.MusicMvRouterUI", "cancel take photo");
            setResult(0);
            finish();
        }
        AppMethodBeat.o(256940);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(256941);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (iArr.length == 0) {
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(currentThread.getId()));
            AppMethodBeat.o(256941);
            return;
        }
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(currentThread2.getId()));
        switch (i2) {
            case 16:
                if (iArr.length == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z3 = false;
                }
                if (!z3 || iArr[0] != 0) {
                    h.a((Context) getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.fl0), com.tencent.mm.cb.a.aI(getContext(), R.string.flp), com.tencent.mm.cb.a.aI(getContext(), R.string.e_k), com.tencent.mm.cb.a.aI(getContext(), R.string.fl1), false, (DialogInterface.OnClickListener) new b(this), (DialogInterface.OnClickListener) new c(this));
                    AppMethodBeat.o(256941);
                    return;
                }
                aML();
                AppMethodBeat.o(256941);
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z3 = false;
                }
                if (z3 && iArr[0] == 0) {
                    aML();
                    break;
                }
        }
        AppMethodBeat.o(256941);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ MusicMvRouterUI Arz;

        b(MusicMvRouterUI musicMvRouterUI) {
            this.Arz = musicMvRouterUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(256935);
            dialogInterface.dismiss();
            this.Arz.finish();
            AppCompatActivity context = this.Arz.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(256935);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ MusicMvRouterUI Arz;

        c(MusicMvRouterUI musicMvRouterUI) {
            this.Arz = musicMvRouterUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(256936);
            dialogInterface.dismiss();
            this.Arz.finish();
            AppMethodBeat.o(256936);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(256942);
        super.onNewIntent(intent);
        if (intent != null) {
            int intExtra = intent.getIntExtra("KEY_MUSIC_ROUTER", -1);
            if (intExtra == 4) {
                overridePendingTransition(R.anim.eq, -1);
                finish();
                AppMethodBeat.o(256942);
                return;
            }
            if (intExtra == 5) {
                p.h(intent, "intent");
                Intent intent2 = new Intent(this, MusicMvMainUI.class);
                intent2.addFlags(67108864);
                byte[] byteArrayExtra = intent.getByteArrayExtra("key_track_data");
                if (byteArrayExtra != null) {
                    intent2.putExtra("key_track_data", byteArrayExtra);
                }
                intent2.putExtra("key_seek_to_start", intent.getBooleanExtra("key_seek_to_start", false));
                overridePendingTransition(R.anim.eq, -1);
                com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
                com.tencent.mm.plugin.music.model.c.sm(true);
                com.tencent.mm.plugin.music.model.c cVar2 = com.tencent.mm.plugin.music.model.c.Akc;
                com.tencent.mm.plugin.music.model.c.cjj();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
            }
            AppMethodBeat.o(256942);
            return;
        }
        AppMethodBeat.o(256942);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256943);
        super.onResume();
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        com.tencent.mm.plugin.music.model.c cVar2 = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.cjj();
        AppMethodBeat.o(256943);
    }
}

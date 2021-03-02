package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.jsapi.share.u;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a;
import com.tencent.mm.plugin.emojicapture.c.a;
import com.tencent.mm.plugin.emojicapture.c.b;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0010\u001d\b\u0007\u0018\u0000 02\u00020\u0001:\u000201B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0014J\b\u0010#\u001a\u00020\u0015H\u0014J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0016J\u0012\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020 H\u0014J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020 H\u0014J\b\u0010/\u001a\u00020 H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI extends MMActivity {
    public static final a rrZ = new a((byte) 0);
    private final String TAG = "MicroMsg.EmojiCaptureUI";
    private String haD;
    private long hdz;
    private final EmojiCaptureReporter rqJ = new EmojiCaptureReporter();
    private CaptureContainer rrR;
    private CaptureEditorContainer rrS;
    private a.AbstractC0967a rrT;
    private b.a rrU;
    private boolean rrV;
    private EmojiCaptureReceiver rrW;
    private final f rrX = new f(this);
    private final d rrY = new d(this);
    private int scene = 2;
    private int state;

    static {
        AppMethodBeat.i(473);
        AppMethodBeat.o(473);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiCaptureUI() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.y.e.CTRL_INDEX);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.y.e.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$Companion;", "", "()V", "REQ_CODE_CHOOSE_IMAGE_FOR_EMOJI", "", "REQ_CODE_CROP_IMAGE_FOR_EMOJI", "REQ_CODE_SAVE_EMOJI_ALBUM", "REQ_CODE_SAVE_EMOJI_CAPTURE", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    public static final class f implements b {
        q qVq;
        final /* synthetic */ EmojiCaptureUI rsa;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(EmojiCaptureUI emojiCaptureUI) {
            this.rsa = emojiCaptureUI;
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void b(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
            AppMethodBeat.i(457);
            p.h(bVar, "emojiCaptureInfo");
            Log.i(this.rsa.TAG, "prepareEditor " + bVar.videoPath);
            com.tencent.mm.plugin.emojicapture.model.f fVar = com.tencent.mm.plugin.emojicapture.model.f.roC;
            if (!com.tencent.mm.plugin.emojicapture.model.f.anm(bVar.videoPath)) {
                Log.i(this.rsa.TAG, "prepareEditor: video invalid");
                EmojiCaptureReporter.Gi(2);
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cIT();
                cJC();
                AppMethodBeat.o(457);
                return;
            }
            CaptureEditorContainer captureEditorContainer = this.rsa.rrS;
            if (captureEditorContainer != null) {
                captureEditorContainer.setVisibility(0);
            }
            CaptureEditorContainer captureEditorContainer2 = this.rsa.rrS;
            if (captureEditorContainer2 != null) {
                captureEditorContainer2.setAlpha(0.0f);
            }
            b.a aVar = this.rsa.rrU;
            if (aVar != null) {
                aVar.a(bVar);
            }
            a.AbstractC0967a aVar2 = this.rsa.rrT;
            if (aVar2 != null) {
                aVar2.sA();
            }
            this.rsa.state = 2;
            AppMethodBeat.o(457);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void cJC() {
            AppMethodBeat.i(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
            Log.i(this.rsa.TAG, "go2Capture");
            CaptureContainer captureContainer = this.rsa.rrR;
            if (captureContainer != null) {
                captureContainer.setVisibility(0);
            }
            CaptureEditorContainer captureEditorContainer = this.rsa.rrS;
            if (captureEditorContainer != null) {
                captureEditorContainer.setVisibility(8);
            }
            CaptureContainer captureContainer2 = this.rsa.rrR;
            if (captureContainer2 != null) {
                captureContainer2.onResume();
            }
            this.rsa.state = 0;
            AppMethodBeat.o(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void cJD() {
            AppMethodBeat.i(459);
            Log.i(this.rsa.TAG, "onEditorPrepared");
            if (this.rsa.state == 2) {
                CaptureEditorContainer captureEditorContainer = this.rsa.rrS;
                if (captureEditorContainer != null) {
                    captureEditorContainer.setAlpha(1.0f);
                }
                CaptureContainer captureContainer = this.rsa.rrR;
                if (captureContainer != null) {
                    captureContainer.setVisibility(8);
                }
                cJE();
                this.rsa.state = 1;
            }
            AppMethodBeat.o(459);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void ano(String str) {
            AppMethodBeat.i(460);
            b.a aVar = this.rsa.rrU;
            if (aVar != null) {
                aVar.ank(str);
                AppMethodBeat.o(460);
                return;
            }
            AppMethodBeat.o(460);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void a(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
            AppMethodBeat.i(461);
            p.h(context, "context");
            p.h(charSequence, "msg");
            com.tencent.mm.ac.d.h(new a(this, context, charSequence, z, 0, onCancelListener));
            Log.i(this.rsa.TAG, "showLoading: " + this.qVq);
            AppMethodBeat.o(461);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void cJE() {
            AppMethodBeat.i(462);
            q qVar = this.qVq;
            if (qVar != null) {
                qVar.dismiss();
            }
            Log.i(this.rsa.TAG, "dismissLoading: " + this.qVq);
            AppMethodBeat.o(462);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
        public final void s(boolean z, String str) {
            AppMethodBeat.i(463);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("key_enter_time", this.rsa.hdz);
                intent.putExtra("gif_md5", str);
                this.rsa.setResult(-1, intent);
            } else {
                this.rsa.rqJ.dtZ = System.currentTimeMillis() - this.rsa.rqJ.hdz;
                EmojiCaptureReporter.a(6, this.rsa.rqJ.hdz, this.rsa.rqJ.dtZ, 0, 0, 0, 0, 0, this.rsa.rqJ.scene);
                this.rsa.setResult(0);
            }
            this.rsa.finish();
            AppMethodBeat.o(463);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ f rsc;
            final /* synthetic */ CharSequence rsd;
            final /* synthetic */ boolean rse;
            final /* synthetic */ int rsf = 0;
            final /* synthetic */ DialogInterface.OnCancelListener rsg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, Context context, CharSequence charSequence, boolean z, int i2, DialogInterface.OnCancelListener onCancelListener) {
                super(0);
                this.rsc = fVar;
                this.$context = context;
                this.rsd = charSequence;
                this.rse = z;
                this.rsg = onCancelListener;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(456);
                q qVar = this.rsc.qVq;
                if (qVar != null) {
                    qVar.dismiss();
                }
                this.rsc.qVq = q.a(this.$context, this.rsd, this.rse, this.rsf, this.rsg);
                x xVar = x.SXb;
                AppMethodBeat.o(456);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
    public static final class d extends IListener<ko> {
        final /* synthetic */ EmojiCaptureUI rsa;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(EmojiCaptureUI emojiCaptureUI) {
            this.rsa = emojiCaptureUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ko koVar) {
            CaptureContainer captureContainer;
            AppMethodBeat.i(v.CTRL_INDEX);
            ko koVar2 = koVar;
            p.h(koVar2, "event");
            if (!(koVar2.dPG == null || (captureContainer = this.rsa.rrR) == null)) {
                Log.i(this.rsa.TAG, "summerhardcoder system event [%s] BackCamera[%s]", Integer.valueOf(koVar2.dPG.keycode), Boolean.valueOf(captureContainer.rtd));
                if (koVar2.dPG.keycode == 1 && captureContainer.rtd) {
                    captureContainer.aPb();
                }
            }
            AppMethodBeat.o(v.CTRL_INDEX);
            return false;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(u.CTRL_INDEX);
        Log.i(this.TAG, "onCreate");
        overridePendingTransition(R.anim.p, -1);
        supportRequestWindowFeature(1);
        setSelfNavigationBarVisible(8);
        super.onCreate(bundle);
        getWindow().addFlags(67109888);
        this.scene = getIntent().getIntExtra("enter_scene", this.scene);
        this.hdz = getIntent().getLongExtra("key_enter_time", 0);
        this.haD = getIntent().getStringExtra(ch.COL_USERNAME);
        this.rqJ.scene = this.scene;
        this.rqJ.hdz = this.hdz;
        k.ejI();
        g.b.aao();
        int intExtra = getIntent().getIntExtra("key_capture_max_duration", 5);
        String stringExtra = getIntent().getStringExtra("key_imitated_md5");
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        com.tencent.mm.plugin.emojicapture.model.d.rou = intExtra;
        this.rqJ.rnQ = stringExtra;
        this.rrR = (CaptureContainer) findViewById(R.id.aj9);
        this.rrS = (CaptureEditorContainer) findViewById(R.id.bx2);
        long currentTicks = Util.currentTicks();
        EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.a.cJA();
        EmojiCaptureProxy.a aVar3 = EmojiCaptureProxy.rrF;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.rrE.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new e(this, currentTicks));
        }
        com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
        com.tencent.mm.plugin.emojicapture.model.e.cIN();
        AppMethodBeat.o(u.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ long iiX;
        final /* synthetic */ EmojiCaptureUI rsa;

        e(EmojiCaptureUI emojiCaptureUI, long j2) {
            this.rsa = emojiCaptureUI;
            this.iiX = j2;
        }

        public final void run() {
            AppMethodBeat.i(455);
            Log.i(this.rsa.TAG, "connect cost " + Util.ticksToNow(this.iiX));
            EmojiCaptureUI.b(this.rsa);
            AppMethodBeat.o(455);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a1n;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        AppMethodBeat.i(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        if (EmojiCaptureProxy.rrE.getEnableAutoRotate()) {
            AppMethodBeat.o(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
            return 7;
        }
        AppMethodBeat.o(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(bg.CTRL_INDEX);
        super.onPause();
        if (this.state == 0) {
            CaptureContainer captureContainer = this.rrR;
            if (captureContainer != null) {
                Log.i(captureContainer.TAG, "PauseCapture");
                CaptureDecoration decoration = captureContainer.getDecoration();
                decoration.rtj.pause();
                decoration.rtk.pause();
                captureContainer.rtc.stopPreview();
                AppMethodBeat.o(bg.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(bg.CTRL_INDEX);
            return;
        }
        b.a aVar = this.rrU;
        if (aVar != null) {
            aVar.pause();
            AppMethodBeat.o(bg.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(bg.CTRL_INDEX);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
        super.onResume();
        if (this.state == 0) {
            if (com.tencent.mm.pluginsdk.permission.b.e(this, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
                CaptureContainer captureContainer = this.rrR;
                if (captureContainer != null) {
                    captureContainer.onResume();
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
                    return;
                }
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
                return;
            }
            Log.i(this.TAG, "initOnCreateAfterConnected: no permission");
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
            return;
        }
        b.a aVar = this.rrU;
        if (aVar != null) {
            aVar.resume();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.l.a.CTRL_INDEX);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        CaptureContainer captureContainer;
        CaptureContainer captureContainer2;
        AppMethodBeat.i(a.C0672a.CTRL_INDEX);
        p.h(keyEvent, "event");
        if (ae.gKt.gFC == 1 && i2 == 700 && (captureContainer = this.rrR) != null && captureContainer.rtd && (captureContainer2 = this.rrR) != null) {
            captureContainer2.aPb();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(a.C0672a.CTRL_INDEX);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ad.a.d.CTRL_INDEX);
        b.a aVar = this.rrU;
        if (aVar == null || !aVar.Ul()) {
            b.a.a(this.rrX, false);
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ad.a.d.CTRL_INDEX);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(470);
        EventCenter.instance.removeListener(this.rrY);
        super.onDestroy();
        a.AbstractC0967a aVar = this.rrT;
        if (aVar != null) {
            aVar.destroy();
        }
        CaptureContainer captureContainer = this.rrR;
        if (captureContainer != null) {
            EditorStickerView editorStickerView = captureContainer.rsS;
            com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
            com.tencent.mm.sticker.loader.e.b(editorStickerView.rtF);
            com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
        }
        b.a aVar2 = this.rrU;
        if (aVar2 != null) {
            aVar2.destroy();
        }
        if (this.rrW != null) {
            unregisterReceiver(this.rrW);
        }
        EmojiCaptureProxy.a aVar3 = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.a.cJB();
        com.tencent.mm.plugin.emojicapture.model.e eVar2 = com.tencent.mm.plugin.emojicapture.model.e.roB;
        com.tencent.mm.plugin.emojicapture.model.e.cIO();
        com.tencent.mm.media.g.c.igu.aMA();
        AppMethodBeat.o(470);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(471);
        super.finish();
        overridePendingTransition(-1, R.anim.q);
        AppMethodBeat.o(471);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
    public static final class c implements com.tencent.mm.pluginsdk.permission.c {
        final /* synthetic */ EmojiCaptureUI rsa;

        c(EmojiCaptureUI emojiCaptureUI) {
            this.rsa = emojiCaptureUI;
        }

        @Override // com.tencent.mm.pluginsdk.permission.c
        public final void b(int i2, int[] iArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(256435);
            p.g(iArr, "grantResults");
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (iArr[i3] != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                i3++;
            }
            if (z2) {
                int i4 = R.string.fl0;
                Integer m = kotlin.a.e.m(iArr, 0);
                if (m != null && m.intValue() == 0) {
                    i4 = R.string.flb;
                }
                h.a((Context) this.rsa.getContext(), i4, (int) R.string.flp, (int) R.string.e_k, (int) R.string.sz, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c.AnonymousClass1 */
                    final /* synthetic */ c rsb;

                    {
                        this.rsb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(451);
                        p.h(dialogInterface, "dialog");
                        dialogInterface.dismiss();
                        AppCompatActivity context = this.rsb.rsa.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(451);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c.AnonymousClass2 */
                    final /* synthetic */ c rsb;

                    {
                        this.rsb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(452);
                        p.h(dialogInterface, "dialog");
                        dialogInterface.dismiss();
                        this.rsb.rsa.finish();
                        AppMethodBeat.o(452);
                    }
                });
            }
            AppMethodBeat.o(256435);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
    public interface b {
        void a(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener);

        void ano(String str);

        void b(com.tencent.mm.plugin.emojicapture.model.a.b bVar);

        void cJC();

        void cJD();

        void cJE();

        void s(boolean z, String str);

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static /* synthetic */ void a(b bVar, Context context, CharSequence charSequence) {
                AppMethodBeat.i(449);
                bVar.a(context, charSequence, false, null);
                AppMethodBeat.o(449);
            }

            public static /* synthetic */ void a(b bVar, boolean z) {
                AppMethodBeat.i(450);
                bVar.s(z, null);
                AppMethodBeat.o(450);
            }
        }
    }

    public static final /* synthetic */ void b(EmojiCaptureUI emojiCaptureUI) {
        long j2;
        boolean z;
        int i2;
        AppMethodBeat.i(JsApiAddDownloadTask.CTRL_INDEX);
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        com.tencent.mm.pluginsdk.a.e provider = ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider();
        p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        com.tencent.mm.plugin.emojicapture.model.d.rot = provider.ave();
        if (com.tencent.mm.aq.b.bby().bbB()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(933, 0);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(933, 1);
        }
        com.tencent.mm.plugin.emojicapture.model.d.rov = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).roa;
        com.tencent.mm.plugin.emojicapture.model.d.rox = ((com.tencent.mm.plugin.emojicapture.api.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emojicapture.api.a.class)).stickerRecommendCount();
        com.tencent.mm.plugin.emojicapture.b.a.rnZ.init();
        Log.i(emojiCaptureUI.TAG, "onCreate useCpuCrop:".concat(String.valueOf(((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO)));
        VideoTransPara videoTransPara = (VideoTransPara) emojiCaptureUI.getIntent().getParcelableExtra("key_video_params");
        String stringExtra = emojiCaptureUI.getIntent().getStringExtra("key_imitated_md5");
        String stringExtra2 = emojiCaptureUI.getIntent().getStringExtra("lens_id");
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo amm = ((com.tencent.mm.plugin.emoji.b.d) ah2).getProvider().amm(stringExtra);
        emojiCaptureUI.rrV = emojiCaptureUI.getIntent().getBooleanExtra("sticker_enable", emojiCaptureUI.rrV);
        emojiCaptureUI.rqJ.rnR = amm != null ? amm.field_lensId : null;
        EmojiCaptureReporter emojiCaptureReporter = emojiCaptureUI.rqJ;
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        emojiCaptureReporter.rnX = com.tencent.mm.plugin.emojicapture.model.d.rox;
        CaptureContainer captureContainer = emojiCaptureUI.rrR;
        if (captureContainer != null) {
            p.g(videoTransPara, "videoPara");
            emojiCaptureUI.rrT = new com.tencent.mm.plugin.emojicapture.e.a(emojiCaptureUI, captureContainer, videoTransPara, emojiCaptureUI.rrX, emojiCaptureUI.rqJ);
            captureContainer.setPresenter(emojiCaptureUI.rrT);
            captureContainer.setReporter(emojiCaptureUI.rqJ);
            boolean z2 = emojiCaptureUI.rrV;
            String str = emojiCaptureUI.haD;
            Log.i(captureContainer.TAG, "setup: " + z2 + ", " + (amm != null ? amm.getMd5() : null) + ", " + stringExtra2);
            captureContainer.rrV = z2;
            captureContainer.rsU.setImitateEmoji(amm);
            if (z2) {
                String str2 = amm != null ? amm.field_lensId : null;
                String str3 = !(str2 == null || str2.length() == 0) ? amm != null ? amm.field_lensId : null : stringExtra2;
                EditorStickerView editorStickerView = captureContainer.rsS;
                EmojiCaptureReporter emojiCaptureReporter2 = captureContainer.rqJ;
                if (emojiCaptureReporter2 != null) {
                    j2 = emojiCaptureReporter2.hdz;
                } else {
                    j2 = 0;
                }
                if (amm != null) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(editorStickerView.TAG, "setup: " + j2 + ", " + str3);
                editorStickerView.hdz = j2;
                editorStickerView.rtv = str3;
                if (Util.isNullOrNil(str)) {
                    EmojiCaptureReporter emojiCaptureReporter3 = editorStickerView.rqJ;
                    if (emojiCaptureReporter3 != null) {
                        emojiCaptureReporter3.rnW = 1;
                    }
                } else {
                    EmojiCaptureReporter emojiCaptureReporter4 = editorStickerView.rqJ;
                    if (emojiCaptureReporter4 != null) {
                        emojiCaptureReporter4.rnW = 2;
                    }
                }
                com.tencent.mm.plugin.emojicapture.model.a.f fVar = editorStickerView.rtx;
                chx chx = new chx();
                chx.session_id = String.valueOf(j2);
                chx.pWm = str;
                fVar.rpg = chx.toByteArray();
                if (Util.isNullOrNil(str)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                fVar.requestType = i2;
                String str4 = str3;
                if (!(str4 == null || str4.length() == 0)) {
                    editorStickerView.rty.setSelection(str3);
                    editorStickerView.rtx.ann(str3);
                } else if (z) {
                    editorStickerView.rty.rpu = 0;
                }
                com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                com.tencent.mm.sticker.loader.e.a(editorStickerView.rtF);
                captureContainer.rsS.setReporter(captureContainer.rqJ);
                captureContainer.rsS.setShow(true);
            } else {
                captureContainer.rsS.setShow(false);
                captureContainer.rsU.setStickerInfo(null);
            }
        }
        CaptureEditorContainer captureEditorContainer = emojiCaptureUI.rrS;
        if (captureEditorContainer != null) {
            emojiCaptureUI.rrU = new com.tencent.mm.plugin.emojicapture.e.c(emojiCaptureUI, captureEditorContainer, emojiCaptureUI.rrX, stringExtra, emojiCaptureUI.rqJ);
            captureEditorContainer.setPresenter(emojiCaptureUI.rrU);
            captureEditorContainer.setReporter(emojiCaptureUI.rqJ);
        }
        if (com.tencent.mm.pluginsdk.permission.b.e(emojiCaptureUI, "android.permission.CAMERA", "android.permission.RECORD_AUDIO")) {
            CaptureContainer captureContainer2 = emojiCaptureUI.rrR;
            if (captureContainer2 != null) {
                captureContainer2.onResume();
            }
        } else {
            com.tencent.mm.pluginsdk.permission.b.a(1001, new c(emojiCaptureUI), new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
            Log.i(emojiCaptureUI.TAG, "initOnCreateAfterConnected: no permission");
        }
        EventCenter.instance.addListener(emojiCaptureUI.rrY);
        emojiCaptureUI.rrW = new EmojiCaptureReceiver();
        IntentFilter intentFilter = new IntentFilter("com.tencent.mm.Emoji_Capture_Res");
        intentFilter.addAction("com.tencent.mm.Emoji_Capture_Upload");
        emojiCaptureUI.registerReceiver(emojiCaptureUI.rrW, intentFilter);
        EmojiCaptureReporter.Gi(0);
        AppMethodBeat.o(JsApiAddDownloadTask.CTRL_INDEX);
    }
}

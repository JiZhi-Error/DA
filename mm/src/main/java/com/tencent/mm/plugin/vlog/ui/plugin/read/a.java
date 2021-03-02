package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u000204J\u0018\u00109\u001a\u0002042\u0006\u0010:\u001a\u0002062\u0006\u0010;\u001a\u000206H\u0002J\u0006\u0010<\u001a\u000204J\u0006\u0010=\u001a\u000204J\b\u0010>\u001a\u000204H\u0016J\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\rH\u0016J,\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\b\u0010D\u001a\u0004\u0018\u0001062\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u0002042\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\"\u0010J\u001a\u0002042\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0011H\u0016J\b\u0010O\u001a\u000204H\u0016J\u0006\u0010P\u001a\u000204J\u0006\u0010Q\u001a\u000204J\u000e\u0010R\u001a\u0002042\u0006\u0010S\u001a\u00020TR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR#\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R#\u0010&\u001a\n !*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b'\u0010\u0014R#\u0010)\u001a\n !*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b*\u0010\u0014R#\u0010,\u001a\n !*\u0004\u0018\u00010-0-8BX\u0002¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b.\u0010/R\u0016\u00101\u001a\n !*\u0004\u0018\u00010202X\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"})
public final class a implements i, t, e.c, e.d {
    public static final C1872a GLP = new C1872a((byte) 0);
    private static int wJJ;
    long CbW;
    private long CbX;
    com.tencent.mm.plugin.recordvideo.ui.editor.item.i GLJ;
    private final kotlin.f GLK = kotlin.g.ah(new f(this));
    private final kotlin.f GLL = kotlin.g.ah(new g(this));
    private final kotlin.f GLM = kotlin.g.ah(new d(this));
    private final kotlin.f GLN = kotlin.g.ah(new e(this));
    private final Runnable GLO = new b(this);
    private boolean aWP;
    private final VideoTransPara irT;
    ViewGroup parent;
    int wJG = -1;
    private final d wJI;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(191804);
        AppMethodBeat.o(191804);
    }

    private final ViewGroup fEe() {
        AppMethodBeat.i(191792);
        ViewGroup viewGroup = (ViewGroup) this.GLK.getValue();
        AppMethodBeat.o(191792);
        return viewGroup;
    }

    private final ViewGroup fEf() {
        AppMethodBeat.i(191793);
        ViewGroup viewGroup = (ViewGroup) this.GLN.getValue();
        AppMethodBeat.o(191793);
        return viewGroup;
    }

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191803);
        this.parent = viewGroup;
        this.wgr = dVar;
        LayoutInflater.from(this.parent.getContext()).inflate(R.layout.a18, this.parent, true);
        this.parent.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.read.a.AnonymousClass1 */
            final /* synthetic */ a GLQ;

            {
                this.GLQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191779);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.GLQ.aWP) {
                    this.GLQ.cO();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191779);
            }
        });
        ((TextView) this.GLM.getValue()).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.read.a.AnonymousClass2 */
            final /* synthetic */ a GLQ;

            {
                this.GLQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191780);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.GLQ;
                aVar.wJG = -1;
                aVar.hideLoading();
                aVar.parent.setVisibility(8);
                d.b.a(aVar.wgr, d.c.BWP);
                d.b.a(aVar.wgr, d.c.BWv);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191780);
            }
        });
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(5207, this);
        this.wJI = new d();
        com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
        p.g(baZ, "SubCoreVideoControl.getCore()");
        this.irT = baZ.bbf();
        AppMethodBeat.o(191803);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191805);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191805);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "REPORT_KEY_MULTI_VIDEO_EDIT_CLICK_READ", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_FAIL", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_SUCCESS", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.read.a$a  reason: collision with other inner class name */
    public static final class C1872a {
        private C1872a() {
        }

        public /* synthetic */ C1872a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a GLQ;

        b(a aVar) {
            this.GLQ = aVar;
        }

        public final void run() {
            AppMethodBeat.i(191781);
            this.GLQ.cO();
            AppMethodBeat.o(191781);
        }
    }

    public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        String str;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2;
        AppMethodBeat.i(191794);
        p.h(aVar, "data");
        if (aVar instanceof q) {
            str = String.valueOf(((q) aVar).text);
        } else if (aVar instanceof o) {
            str = ((o) aVar).text;
        } else {
            str = "";
        }
        if (!(aVar instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.i)) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        this.GLJ = (com.tencent.mm.plugin.recordvideo.ui.editor.item.i) aVar2;
        showLoading();
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        ll(aUg, str);
        com.tencent.mm.plugin.vlog.model.report.a aVar3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.report(110);
        AppMethodBeat.o(191794);
    }

    private void showLoading() {
        AppMethodBeat.i(191795);
        this.aWP = true;
        ViewGroup fEe = fEe();
        p.g(fEe, "ttsLoadingContainer");
        fEe.setVisibility(0);
        ViewGroup fEf = fEf();
        p.g(fEf, "ttsFailedContainer");
        fEf.setVisibility(4);
        this.parent.setVisibility(0);
        AppMethodBeat.o(191795);
    }

    public final void hideLoading() {
        AppMethodBeat.i(191796);
        this.aWP = false;
        ViewGroup fEe = fEe();
        p.g(fEe, "ttsLoadingContainer");
        fEe.setVisibility(4);
        AppMethodBeat.o(191796);
    }

    public final void cIh() {
        AppMethodBeat.i(191797);
        ViewGroup fEe = fEe();
        p.g(fEe, "ttsLoadingContainer");
        fEe.setVisibility(4);
        ViewGroup fEf = fEf();
        p.g(fEf, "ttsFailedContainer");
        fEf.setVisibility(0);
        this.parent.postDelayed(this.GLO, 2000);
        com.tencent.mm.plugin.vlog.model.report.a aVar = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.report(112);
        AppMethodBeat.o(191797);
    }

    public final void cO() {
        AppMethodBeat.i(191798);
        ViewGroup fEf = fEf();
        p.g(fEf, "ttsFailedContainer");
        fEf.setVisibility(4);
        this.parent.getHandler().removeCallbacks(this.GLO);
        this.parent.setVisibility(8);
        d.b.a(this.wgr, d.c.BWP);
        d.b.a(this.wgr, d.c.BWv);
        AppMethodBeat.o(191798);
    }

    private final void ll(String str, String str2) {
        AppMethodBeat.i(191799);
        b bVar = new b(str, str2);
        int i2 = wJJ;
        wJJ = i2 + 1;
        this.wJG = i2;
        bVar.wJG = this.wJG;
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(bVar);
        AppMethodBeat.o(191799);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        Integer num;
        AppMethodBeat.i(191800);
        if ((qVar instanceof b) && ((b) qVar).wJG == this.wJG) {
            hideLoading();
            if (i2 == 0 && i3 == 0) {
                String str2 = com.tencent.mm.plugin.sight.base.b.eVt() + '/' + UUID.randomUUID();
                String str3 = str2 + ".wav";
                StringBuilder append = new StringBuilder("tts success, input text:").append(((b) qVar).GLT).append(", speech size:");
                byte[] bArr = ((b) qVar).GLS;
                if (bArr != null) {
                    num = Integer.valueOf(bArr.length);
                } else {
                    num = null;
                }
                Log.i("MicroMsg.EditorReadPlugin", append.append(num).append(", speech duration:").append(((b) qVar).durationMs).append(", path:").append(str2).toString());
                s.C(str2, ((b) qVar).GLS);
                kotlinx.coroutines.f.b(bn.TUK, ba.hMV(), new c(this, str2, str3, qVar, null), 2);
                AppMethodBeat.o(191800);
                return;
            }
            Log.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b) qVar).GLT + ", errType:" + i2 + ", errCode:" + i3);
            cIh();
        }
        AppMethodBeat.o(191800);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191801);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(5207, this);
        AppMethodBeat.o(191801);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        AppMethodBeat.i(191802);
        this.CbW = acVar != null ? acVar.Gez.getDurationMs() : 0;
        AppMethodBeat.o(191802);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        this.CbX = j2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.vlog.ui.plugin.read.EditReadPlugin$onSceneEnd$1", f = "EditReadPlugin.kt", hxM = {TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4}, m = "invokeSuspend")
    public static final class c extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ a GLQ;
        Object L$0;
        final /* synthetic */ com.tencent.mm.ak.q hvN;
        int label;
        private ai p$;
        Object pED;
        final /* synthetic */ String wJM;
        final /* synthetic */ String wJN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str, String str2, com.tencent.mm.ak.q qVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.GLQ = aVar;
            this.wJM = str;
            this.wJN = str2;
            this.hvN = qVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(191786);
            p.h(dVar, "completion");
            c cVar = new c(this.GLQ, this.wJM, this.wJN, this.hvN, dVar);
            cVar.p$ = (ai) obj;
            AppMethodBeat.o(191786);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(191787);
            Object invokeSuspend = ((c) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(191787);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            z.a aVar;
            long j2;
            AppMethodBeat.i(191785);
            kotlin.d.a.a aVar2 = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    final z.a aVar3 = new z.a();
                    aVar3.SYB = false;
                    this.L$0 = aiVar;
                    this.pED = aVar3;
                    this.label = 1;
                    if (kotlinx.coroutines.g.a(ba.hMW(), new m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                        /* class com.tencent.mm.plugin.vlog.ui.plugin.read.a.c.AnonymousClass1 */
                        final /* synthetic */ c GLR;
                        int label;
                        private ai p$;

                        {
                            this.GLR = r2;
                        }

                        @Override // kotlin.d.b.a.a
                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            AppMethodBeat.i(191783);
                            p.h(dVar, "completion");
                            AnonymousClass1 r0 = 

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
                            static final class f extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
                                final /* synthetic */ a GLQ;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                f(a aVar) {
                                    super(0);
                                    this.GLQ = aVar;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ ViewGroup invoke() {
                                    AppMethodBeat.i(191790);
                                    ViewGroup viewGroup = (ViewGroup) this.GLQ.parent.findViewById(R.id.ivx);
                                    AppMethodBeat.o(191790);
                                    return viewGroup;
                                }
                            }

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "invoke"})
                            static final class g extends kotlin.g.b.q implements kotlin.g.a.a<MMProcessBar> {
                                final /* synthetic */ a GLQ;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                g(a aVar) {
                                    super(0);
                                    this.GLQ = aVar;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ MMProcessBar invoke() {
                                    AppMethodBeat.i(191791);
                                    MMProcessBar mMProcessBar = (MMProcessBar) this.GLQ.parent.findViewById(R.id.ivy);
                                    AppMethodBeat.o(191791);
                                    return mMProcessBar;
                                }
                            }

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
                            static final class d extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
                                final /* synthetic */ a GLQ;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                d(a aVar) {
                                    super(0);
                                    this.GLQ = aVar;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ TextView invoke() {
                                    AppMethodBeat.i(191788);
                                    TextView textView = (TextView) this.GLQ.parent.findViewById(R.id.ivv);
                                    AppMethodBeat.o(191788);
                                    return textView;
                                }
                            }

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
                            static final class e extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
                                final /* synthetic */ a GLQ;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                e(a aVar) {
                                    super(0);
                                    this.GLQ = aVar;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ ViewGroup invoke() {
                                    AppMethodBeat.i(191789);
                                    ViewGroup viewGroup = (ViewGroup) this.GLQ.parent.findViewById(R.id.ivw);
                                    AppMethodBeat.o(191789);
                                    return viewGroup;
                                }
                            }
                        }

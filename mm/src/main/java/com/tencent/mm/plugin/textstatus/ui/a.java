package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.k;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 m2\u00020\u0001:\u0001mB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020\u0006H\u0016J\b\u0010R\u001a\u00020PH\u0016J\u0010\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020/H\u0016J\u0010\u0010U\u001a\u00020P2\u0006\u0010T\u001a\u00020/H\u0016J\u0010\u0010V\u001a\u00020P2\u0006\u0010T\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020PH\u0016J\b\u0010X\u001a\u00020PH\u0016J\b\u0010Y\u001a\u00020PH\u0016J\u0010\u0010Z\u001a\u00020P2\u0006\u0010[\u001a\u00020\u0016H\u0016J\b\u0010\\\u001a\u00020PH\u0016J\b\u0010]\u001a\u00020PH\u0016J\b\u0010^\u001a\u00020PH\u0016J\b\u0010_\u001a\u00020PH\u0016J\b\u0010`\u001a\u00020PH\u0016J\u0010\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020cH\u0016J\u0006\u0010d\u001a\u00020PJ\u0012\u0010e\u001a\u00020P2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\u0012\u0010h\u001a\u00020P2\b\u0010i\u001a\u0004\u0018\u00010>H\u0016J\u0006\u0010j\u001a\u00020PJ\u0010\u0010k\u001a\u00020P2\u0006\u0010C\u001a\u00020DH\u0016J\u0006\u0010l\u001a\u00020PR\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/BackPreview;", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "back", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setContext", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "isInOpen", "", "()Z", "setInOpen", "(Z)V", "isPlaying", "setPlaying", "ivMask", "Landroid/widget/ImageView;", "getIvMask", "()Landroid/widget/ImageView;", "setIvMask", "(Landroid/widget/ImageView;)V", "ivPreview", "getIvPreview", "setIvPreview", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "lastIsLocal", "getLastIsLocal", "setLastIsLocal", "lastVideoHeight", "", "getLastVideoHeight", "()I", "setLastVideoHeight", "(I)V", "lastVideoWidth", "getLastVideoWidth", "setLastVideoWidth", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "statusUIListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "getStatusUIListener", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "setStatusUIListener", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;)V", ch.COL_USERNAME, "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "destroyVideo", "", "getView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", AssetExtension.SCENE_PLAY, "setCardView", "cardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusBrowseUIListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "stop", "update", "updateMask", "Companion", "plugin-textstatus_release"})
public final class a implements b {
    public static final C1827a GcC = new C1827a((byte) 0);
    private MMTPRecyclerVideoLayout AuG;
    private com.tencent.mm.plugin.textstatus.f.f.a FYx;
    private int GcA;
    private int GcB;
    private View Gcs = LayoutInflater.from(this.context).inflate(R.layout.c29, (ViewGroup) null, false);
    private ImageView Gct;
    private FrameLayout Gcu;
    private ImageView Gcv;
    private e Gcw;
    private boolean Gcx;
    private long Gcy;
    private boolean Gcz;
    private Context context;
    private boolean gVd;
    private String username = "";

    static {
        AppMethodBeat.i(216360);
        AppMethodBeat.o(216360);
    }

    public a(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(216359);
        this.context = context2;
        View findViewById = this.Gcs.findViewById(R.id.e4w);
        p.g(findViewById, "back.findViewById(R.id.iv_preview)");
        this.Gct = (ImageView) findViewById;
        View findViewById2 = this.Gcs.findViewById(R.id.e_a);
        p.g(findViewById2, "back.findViewById(R.id.layout_video)");
        this.Gcu = (FrameLayout) findViewById2;
        View findViewById3 = this.Gcs.findViewById(R.id.e4t);
        p.g(findViewById3, "back.findViewById(R.id.iv_mask)");
        this.Gcv = (ImageView) findViewById3;
        this.Gcy = -1;
        AppMethodBeat.o(216359);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/BackPreview$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.ui.a$a  reason: collision with other inner class name */
    public static final class C1827a {
        private C1827a() {
        }

        public /* synthetic */ C1827a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostOpen(boolean z) {
        AppMethodBeat.i(216347);
        Log.i("MicroMsg.TxtStatus.BackPreview", "[onPostOpen]");
        play();
        AppMethodBeat.o(216347);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostClose() {
        AppMethodBeat.i(216348);
        Log.i("MicroMsg.TxtStatus.BackPreview", "[onPostClose]");
        stop();
        AppMethodBeat.o(216348);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEk() {
        this.Gcx = true;
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEl() {
        this.Gcx = false;
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEm() {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEn() {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UC(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UD(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UE(int i2) {
    }

    @Override // com.tencent.mm.plugin.textstatus.a.b
    public final View getView() {
        AppMethodBeat.i(216349);
        View view = this.Gcs;
        p.g(view, "back");
        AppMethodBeat.o(216349);
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        if (r1 == null) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void play() {
        /*
        // Method dump skipped, instructions count: 444
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.ui.a.play():void");
    }

    private void fwh() {
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        com.tencent.mm.plugin.thumbplayer.e.b player2;
        AppMethodBeat.i(216351);
        Log.i("MicroMsg.TxtStatus.BackPreview", "[destroyVideo]");
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player2 = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player2.stopAsync();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (!(mMTPRecyclerVideoLayout2 == null || (player = mMTPRecyclerVideoLayout2.getPlayer()) == null)) {
            player.recycle();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout3 = this.AuG;
        if (!(mMTPRecyclerVideoLayout3 == null || (effector = mMTPRecyclerVideoLayout3.getEffector()) == null)) {
            effector.release();
        }
        this.AuG = null;
        this.Gcu.removeAllViews();
        AppMethodBeat.o(216351);
    }

    private void stop() {
        com.tencent.mm.plugin.thumbplayer.e.b player;
        AppMethodBeat.i(216352);
        String str = this.username;
        if (str == null || n.aL(str)) {
            AppMethodBeat.o(216352);
            return;
        }
        this.gVd = false;
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player.pause();
        }
        this.Gcu.setVisibility(8);
        this.Gct.setVisibility(0);
        fwh();
        fwi();
        AppMethodBeat.o(216352);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.j
    public final void DV(String str) {
        AppMethodBeat.i(216353);
        p.h(str, ch.COL_USERNAME);
        this.username = str;
        new k.e(str, this);
        f fVar = f.FXJ;
        this.FYx = f.aTf(str);
        Log.i("MicroMsg.TxtStatus.BackPreview", "[update TextStatusinfo]:" + this.FYx);
        com.tencent.mm.plugin.textstatus.f.f.a aVar = this.FYx;
        if (aVar == null) {
            e eVar = this.Gcw;
            if (eVar != null) {
                eVar.eEe();
                AppMethodBeat.o(216353);
                return;
            }
            AppMethodBeat.o(216353);
            return;
        }
        if (aVar.field_MediaType == 2) {
            com.tencent.mm.plugin.textstatus.e.a.a(com.tencent.mm.plugin.textstatus.e.a.FYI, this.context, str, this.Gct);
        } else {
            com.tencent.mm.plugin.textstatus.e.a aVar2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
            com.tencent.mm.plugin.textstatus.e.a.a(this.context, str, this.Gct, false);
        }
        e eVar2 = this.Gcw;
        if (eVar2 != null) {
            eVar2.eEf();
        }
        fwi();
        AppMethodBeat.o(216353);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvv() {
        AppMethodBeat.i(216354);
        Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowDestroy:%s", Boolean.valueOf(this.Gcx));
        fwh();
        this.Gcw = null;
        AppMethodBeat.o(216354);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvw() {
        AppMethodBeat.i(216355);
        Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowResume:%s", Boolean.valueOf(this.Gcx));
        if (this.Gcx) {
            play();
        }
        AppMethodBeat.o(216355);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvx() {
        AppMethodBeat.i(216356);
        Log.i("MicroMsg.TxtStatus.BackPreview", "onStatusShowPause:%s", Boolean.valueOf(this.Gcx));
        if (this.Gcx) {
            stop();
        }
        AppMethodBeat.o(216356);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.l
    public final void cd(float f2) {
        AppMethodBeat.i(216357);
        this.Gcv.setAlpha(0.4f * (1.0f - f2));
        AppMethodBeat.o(216357);
    }

    private void fwi() {
        com.tencent.mm.plugin.textstatus.f.f.a aVar;
        AppMethodBeat.i(216358);
        com.tencent.mm.plugin.textstatus.f.f.a aVar2 = this.FYx;
        String str = aVar2 != null ? aVar2.field_backgroundId : null;
        if (!(str == null || n.aL(str)) || ((aVar = this.FYx) != null && aVar.fvV())) {
            this.Gcv.setVisibility(8);
            AppMethodBeat.o(216358);
            return;
        }
        this.Gcv.setVisibility(0);
        AppMethodBeat.o(216358);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.b
    public final void a(e eVar) {
        this.Gcw = eVar;
    }
}

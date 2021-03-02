package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.b.a.kj;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001)\u0018\u00002\u00020\u0001:\u0001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020;H\u0002J\u001e\u0010A\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020=H\u0002J\u0006\u0010F\u001a\u00020;J\b\u0010G\u001a\u00020=H\u0002J\u0006\u0010H\u001a\u00020=J?\u0010I\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\t2\b\u0010K\u001a\u0004\u0018\u00010\t2\b\u0010L\u001a\u0004\u0018\u00010\f2\b\u0010M\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020=2\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020=J\u0010\u0010S\u001a\u00020=2\u0006\u0010T\u001a\u00020;H\u0002J\u000e\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020WJ\u0015\u0010X\u001a\u00020=2\b\u0010Q\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020=2\u0006\u0010F\u001a\u00020;J\b\u0010[\u001a\u00020=H\u0002J\u001e\u0010\\\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020 0]2\u0006\u0010@\u001a\u00020;H\u0002J\b\u0010^\u001a\u00020=H\u0002J\b\u0010_\u001a\u00020=H\u0002J\b\u0010`\u001a\u00020=H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;)V", "mAdapter", "Lcom/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter;", "mClickClosePanel", "Landroid/view/View;", "mCloseBtn", "Landroid/widget/TextView;", "mEditCleanBtn", "Landroid/widget/ImageView;", "mEditView", "Landroid/widget/EditText;", "mFinishBtn", "Landroid/widget/Button;", "mLastSelectItem", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mLastSelectTimestamp", "", "mRelatedRecId", "getMRelatedRecId", "()J", "setMRelatedRecId", "(J)V", "mScrollListener", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1;", "mSearchIcon", "mSearchNoResultTv", "mSearchOffset", "mSearchPanel", "mSearchRequestId", "mSearchResultView", "Landroid/support/v7/widget/RecyclerView;", "mSearchString", "mSearchingView", "Landroid/widget/LinearLayout;", "mSelectedPosition", "mTagsPanel", "mTranslateOffset", "showImeRunnable", "Ljava/lang/Runnable;", "back", "", "backAndPausePlayer", "", "cleanAndPausePlayer", "doSearch", "loadMore", "handleResult", "audioList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isShow", "reportSelect", "reset", "resetStyle", "bgResId", "textColor", "text", "textCursor", "recMusicIconResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "selectItem", "position", "selectSearchItem", "setImeVisibility", "visible", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setSelection", "(Ljava/lang/Integer;)V", "setShow", "showNoResult", "showResultList", "Ljava/util/ArrayList;", "showSearchPanel", "showSearching", "showTagsPanel", "AudioSearchCallback", "plugin-recordvideo_release"})
public final class EditorAudioSearchView extends RelativeLayout {
    private int CaK;
    private View CaL;
    private View CaM;
    private View CaN;
    private TextView CaO;
    EditText CaP;
    private RecyclerView CaQ;
    private TextView CaR;
    private LinearLayout CaS;
    private ImageView CaT;
    private ImageView CaU;
    com.tencent.mm.plugin.recordvideo.ui.a.a CaV;
    int CaW = -1;
    private String CaX;
    private AudioCacheInfo CaY;
    private long CaZ;
    private a Cba;
    private final l Cbb = new l(this);
    final String TAG = "MicroMsg.EditorAudioSearchView";
    Button nAa;
    private final Runnable ruJ = new n(this);
    private int wKo;
    private long wKp;
    private long wKq;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$AudioSearchCallback;", "", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-recordvideo_release"})
    public interface a {
        void b(AudioCacheInfo audioCacheInfo);

        void e(AudioCacheInfo audioCacheInfo);

        void eLQ();

        void eLR();
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ EditorAudioSearchView Cbc;
        final /* synthetic */ boolean Cbd;

        b(EditorAudioSearchView editorAudioSearchView, boolean z) {
            this.Cbc = editorAudioSearchView;
            this.Cbd = z;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(75904);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(this.Cbc.TAG, "LogStory: SearchdMusic callback " + i2 + ' ' + i3 + ", " + aVar.errMsg);
            if (i2 == 0 && i3 == 0) {
                clk clk = (clk) aVar.iLC;
                this.Cbc.wKp = clk.BPd;
                this.Cbc.wKo++;
                LinkedList<clp> linkedList = clk.MqJ;
                EditorAudioSearchView editorAudioSearchView = this.Cbc;
                p.g(linkedList, "audioList");
                EditorAudioSearchView.a(editorAudioSearchView, linkedList, this.Cbd);
                c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.tj(this.Cbc.wKp);
                c.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.xE(this.Cbc.CaX);
                Log.i(this.Cbc.TAG, "get audio list ".concat(String.valueOf(clk)));
                Void r0 = com.tencent.mm.vending.c.a.QZL;
                AppMethodBeat.o(75904);
                return r0;
            }
            if (this.Cbc.wKo == 0) {
                EditorAudioSearchView.q(this.Cbc);
            }
            Void r02 = com.tencent.mm.vending.c.a.QZL;
            AppMethodBeat.o(75904);
            return r02;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "invoke"})
    public static final class i extends q implements kotlin.g.a.m<Integer, AudioCacheInfo, x> {
        final /* synthetic */ EditorAudioSearchView Cbc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(EditorAudioSearchView editorAudioSearchView) {
            super(2);
            this.Cbc = editorAudioSearchView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(75911);
            int intValue = num.intValue();
            p.h(audioCacheInfo, "info");
            com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.Cbc.CaV;
            if (aVar == null || intValue != aVar.getItemCount()) {
                this.Cbc.VS(intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75911);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(EditorAudioSearchView editorAudioSearchView, boolean z) {
        AppMethodBeat.i(75933);
        editorAudioSearchView.setImeVisibility(z);
        AppMethodBeat.o(75933);
    }

    public static final /* synthetic */ void b(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(75931);
        editorAudioSearchView.eLL();
        AppMethodBeat.o(75931);
    }

    public static final /* synthetic */ void f(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(75932);
        editorAudioSearchView.eLO();
        AppMethodBeat.o(75932);
    }

    public static final /* synthetic */ void q(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(75936);
        editorAudioSearchView.eLN();
        AppMethodBeat.o(75936);
    }

    public final long getMRelatedRecId() {
        return this.wKq;
    }

    public final void setMRelatedRecId(long j2) {
        this.wKq = j2;
    }

    public final a getCallback() {
        return this.Cba;
    }

    public final void setCallback(a aVar) {
        this.Cba = aVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
    public static final class l extends RecyclerView.l {
        final /* synthetic */ EditorAudioSearchView Cbc;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(237613);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(237613);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AudioCacheInfo VR;
            AppMethodBeat.i(75915);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(75915);
                    throw tVar;
                }
                int ku = ((LinearLayoutManager) layoutManager).ku();
                c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.ti((long) ku);
                com.tencent.mm.plugin.recordvideo.ui.a.a aVar2 = this.Cbc.CaV;
                if (!(aVar2 == null || ku != aVar2.getItemCount() - 1 || (VR = aVar2.VR(ku)) == null)) {
                    int i3 = VR.type;
                    AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                    if (i3 == AudioCacheInfo.BPl) {
                        EditorAudioSearchView.b(this.Cbc, true);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$mScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(75915);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorAudioSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75929);
        init();
        AppMethodBeat.o(75929);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorAudioSearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75930);
        init();
        AppMethodBeat.o(75930);
    }

    private final void init() {
        AppMethodBeat.i(75918);
        View.inflate(getContext(), R.layout.bzw, this);
        this.CaO = (TextView) findViewById(R.id.i_4);
        this.CaP = (EditText) findViewById(R.id.i_5);
        this.nAa = (Button) findViewById(R.id.i_9);
        this.CaQ = (RecyclerView) findViewById(R.id.i_e);
        this.CaR = (TextView) findViewById(R.id.i_c);
        this.CaS = (LinearLayout) findViewById(R.id.i_b);
        this.CaT = (ImageView) findViewById(R.id.i_6);
        this.CaL = findViewById(R.id.i_h);
        this.CaM = findViewById(R.id.i_f);
        this.CaN = findViewById(R.id.i_3);
        this.CaU = (ImageView) findViewById(R.id.i_7);
        ImageView imageView = this.CaU;
        if (imageView != null) {
            imageView.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_search, com.tencent.mm.cb.a.n(getContext(), R.color.act)));
        }
        Button button = this.nAa;
        if (button != null) {
            button.setEnabled(false);
        }
        ImageView imageView2 = this.CaT;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_close2, com.tencent.mm.cb.a.n(getContext(), R.color.act)));
        }
        ImageView imageView3 = this.CaT;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new c(this));
        }
        RecyclerView recyclerView = this.CaQ;
        ViewGroup.LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(75918);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = au.aD(getContext()) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        RecyclerView recyclerView2 = this.CaQ;
        if (recyclerView2 != null) {
            getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
        }
        RecyclerView recyclerView3 = this.CaQ;
        if (recyclerView3 != null) {
            recyclerView3.a(this.Cbb);
        }
        this.CaV = new com.tencent.mm.plugin.recordvideo.ui.a.a();
        RecyclerView recyclerView4 = this.CaQ;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.CaV);
        }
        TextView textView = this.CaO;
        if (textView != null) {
            textView.setOnClickListener(new d(this));
        }
        Button button2 = this.nAa;
        if (button2 != null) {
            button2.setOnClickListener(new e(this));
        }
        EditText editText = this.CaP;
        if (editText != null) {
            editText.setOnFocusChangeListener(new f(this));
        }
        EditText editText2 = this.CaP;
        if (editText2 != null) {
            editText2.addTextChangedListener(new g(this));
        }
        EditText editText3 = this.CaP;
        if (editText3 != null) {
            editText3.setOnEditorActionListener(new h(this));
        }
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.CaV;
        if (aVar != null) {
            aVar.rsD = new i(this);
        }
        View view = this.CaN;
        if (view != null) {
            view.setOnClickListener(new j(this));
        }
        setOnClickListener(k.Cbe);
        this.CaK = au.az(getContext()).y;
        setTranslationY((float) this.CaK);
        eLM();
        AppMethodBeat.o(75918);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        c(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void onClick(View view) {
            Editable text;
            EditText editText;
            AppMethodBeat.i(75905);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText2 = this.Cbc.CaP;
            if (!(editText2 == null || (text = editText2.getText()) == null)) {
                if (!(text.length() == 0) && (editText = this.Cbc.CaP) != null) {
                    editText.setText((CharSequence) null);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75905);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        d(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(75906);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditorAudioSearchView.b(this.Cbc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75906);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        e(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(75907);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.Cbc.CaV;
            if (aVar != null) {
                if (this.Cbc.CaW == -1 || this.Cbc.CaW >= aVar.getItemCount()) {
                    a callback = this.Cbc.getCallback();
                    if (callback != null) {
                        callback.b(null);
                    }
                    EditorAudioSearchView.f(this.Cbc);
                    c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.th(1);
                    c.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    c.a.eKk();
                } else {
                    a callback2 = this.Cbc.getCallback();
                    if (callback2 != null) {
                        callback2.b(aVar.VR(this.Cbc.CaW));
                    }
                    EditorAudioSearchView.f(this.Cbc);
                    c.a aVar4 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.th(0);
                    c.a aVar5 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    c.a.eKk();
                }
                this.Cbc.reset();
            }
            EditText editText = this.Cbc.CaP;
            if (editText != null) {
                editText.clearFocus();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75907);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    public static final class f implements View.OnFocusChangeListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        f(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(75908);
            EditorAudioSearchView.a(this.Cbc, z);
            AppMethodBeat.o(75908);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-recordvideo_release"})
    public static final class g implements TextWatcher {
        final /* synthetic */ EditorAudioSearchView Cbc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(75909);
            if ((editable != null ? editable.length() : 0) > 0) {
                ImageView imageView = this.Cbc.CaT;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    AppMethodBeat.o(75909);
                    return;
                }
                AppMethodBeat.o(75909);
                return;
            }
            ImageView imageView2 = this.Cbc.CaT;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                AppMethodBeat.o(75909);
                return;
            }
            AppMethodBeat.o(75909);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
    public static final class h implements TextView.OnEditorActionListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        h(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            String str;
            AppMethodBeat.i(75910);
            if (3 == i2) {
                if (this.Cbc.CaX != null) {
                    String str2 = this.Cbc.CaX;
                    p.g(textView, "textView");
                    CharSequence text = textView.getText();
                    if (!Util.isEqual(str2, text != null ? text.toString() : null)) {
                        EditorAudioSearchView.f(this.Cbc);
                        c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                        com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.th(2);
                        c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                        c.a.eKk();
                        c.a aVar3 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                        com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.tk(this.Cbc.getMRelatedRecId());
                    }
                }
                EditorAudioSearchView editorAudioSearchView = this.Cbc;
                p.g(textView, "textView");
                CharSequence text2 = textView.getText();
                if (text2 != null) {
                    str = text2.toString();
                } else {
                    str = null;
                }
                editorAudioSearchView.CaX = str;
                if (!Util.isNullOrNil(this.Cbc.CaX)) {
                    com.tencent.mm.plugin.recordvideo.ui.a.a aVar4 = this.Cbc.CaV;
                    if (aVar4 != null) {
                        aVar4.setSelection(null);
                    }
                    com.tencent.mm.plugin.recordvideo.ui.a.a aVar5 = this.Cbc.CaV;
                    if (aVar5 != null) {
                        aVar5.setSelection(null);
                    }
                    RecyclerView recyclerView = this.Cbc.CaQ;
                    if (recyclerView != null) {
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$6", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                    }
                    com.tencent.mm.plugin.recordvideo.ui.a.a aVar6 = this.Cbc.CaV;
                    if (aVar6 != null) {
                        aVar6.gj(new LinkedList());
                    }
                    Button button = this.Cbc.nAa;
                    if (button != null) {
                        button.setEnabled(false);
                    }
                    this.Cbc.wKp = 0;
                    this.Cbc.CaW = -1;
                    this.Cbc.wKo = 0;
                    com.tencent.mm.plugin.recordvideo.ui.a.a aVar7 = this.Cbc.CaV;
                    if (aVar7 != null) {
                        aVar7.BZP = this.Cbc.CaX;
                    }
                    this.Cbc.CaY = null;
                    this.Cbc.CaZ = 0;
                    EditorAudioSearchView.o(this.Cbc);
                    EditorAudioSearchView.b(this.Cbc, false);
                    a callback = this.Cbc.getCallback();
                    if (callback != null) {
                        callback.eLQ();
                    }
                }
            }
            AppMethodBeat.o(75910);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ EditorAudioSearchView Cbc;

        j(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(75912);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditorAudioSearchView.b(this.Cbc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75912);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        public static final k Cbe = new k();

        static {
            AppMethodBeat.i(75914);
            AppMethodBeat.o(75914);
        }

        k() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(75913);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75913);
        }
    }

    public final void VS(int i2) {
        AppMethodBeat.i(75919);
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.CaV;
        if (aVar == null || aVar.va != i2) {
            this.CaW = i2;
            com.tencent.mm.plugin.recordvideo.ui.a.a aVar2 = this.CaV;
            AudioCacheInfo VR = aVar2 != null ? aVar2.VR(i2) : null;
            if (VR != null) {
                int i3 = VR.type;
                AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                if (i3 == AudioCacheInfo.BPk) {
                    a aVar4 = this.Cba;
                    if (aVar4 != null) {
                        aVar4.e(null);
                    }
                    this.CaY = VR;
                    this.CaZ = System.currentTimeMillis();
                }
            }
            if (VR != null) {
                int i4 = VR.type;
                AudioCacheInfo.a aVar5 = AudioCacheInfo.BPo;
                if (i4 == AudioCacheInfo.BPj) {
                    com.tencent.mm.plugin.recordvideo.ui.a.a aVar6 = this.CaV;
                    if (aVar6 != null) {
                        aVar6.setSelection(Integer.valueOf(i2));
                    }
                    a aVar7 = this.Cba;
                    if (aVar7 != null) {
                        aVar7.e(VR);
                    }
                    Button button = this.nAa;
                    if (button != null) {
                        button.setEnabled(true);
                    }
                    eLO();
                }
            }
            this.CaY = VR;
            this.CaZ = System.currentTimeMillis();
        }
        AppMethodBeat.o(75919);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ EditorAudioSearchView Cbc;

        n(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.i(75917);
            InputMethodManager inputMethodManager = (InputMethodManager) this.Cbc.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.Cbc.CaP, 0);
                AppMethodBeat.o(75917);
                return;
            }
            AppMethodBeat.o(75917);
        }
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(75920);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(75920);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(75920);
            return;
        }
        AppMethodBeat.o(75920);
    }

    private final void eLL() {
        AppMethodBeat.i(75921);
        eLO();
        c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.th(1);
        c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        c.a.eKk();
        reset();
        EditText editText = this.CaP;
        if (editText != null) {
            editText.clearFocus();
        }
        a aVar3 = this.Cba;
        if (aVar3 != null) {
            aVar3.eLQ();
        }
        a aVar4 = this.Cba;
        if (aVar4 != null) {
            aVar4.eLR();
            AppMethodBeat.o(75921);
            return;
        }
        AppMethodBeat.o(75921);
    }

    private final void eLM() {
        AppMethodBeat.i(75922);
        View view = this.CaL;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.CaM;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(75922);
            return;
        }
        AppMethodBeat.o(75922);
    }

    private final void eLN() {
        AppMethodBeat.i(75923);
        LinearLayout linearLayout = this.CaS;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RecyclerView recyclerView = this.CaQ;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        TextView textView = this.CaR;
        if (textView != null) {
            textView.setVisibility(0);
            AppMethodBeat.o(75923);
            return;
        }
        AppMethodBeat.o(75923);
    }

    private final void eLO() {
        Integer num = null;
        AppMethodBeat.i(75924);
        if (this.CaY != null) {
            StringBuilder sb = new StringBuilder();
            c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            if (Util.isNullOrNil(com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.ain())) {
                AudioCacheInfo audioCacheInfo = this.CaY;
                if (audioCacheInfo != null) {
                    num = Integer.valueOf(audioCacheInfo.BOX);
                }
                sb.append(num).append(":1:").append(System.currentTimeMillis() - this.CaZ);
            } else {
                StringBuilder append = sb.append(";");
                AudioCacheInfo audioCacheInfo2 = this.CaY;
                if (audioCacheInfo2 != null) {
                    num = Integer.valueOf(audioCacheInfo2.BOX);
                }
                append.append(num).append(":1:").append(System.currentTimeMillis() - this.CaZ);
            }
            c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            kj kjVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPC;
            kjVar.xF(kjVar.ain() + sb.toString());
        }
        AppMethodBeat.o(75924);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(75925);
        if (z) {
            c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
            com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.tk(this.wKq);
            setVisibility(0);
            animate().translationY(0.0f).start();
            EditText editText = this.CaP;
            if (editText != null) {
                editText.requestFocus();
                AppMethodBeat.o(75925);
                return;
            }
            AppMethodBeat.o(75925);
            return;
        }
        animate().translationY((float) this.CaK).withEndAction(new m(this)).start();
        EditText editText2 = this.CaP;
        if (editText2 != null) {
            editText2.clearFocus();
            AppMethodBeat.o(75925);
            return;
        }
        AppMethodBeat.o(75925);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class m implements Runnable {
        final /* synthetic */ EditorAudioSearchView Cbc;

        m(EditorAudioSearchView editorAudioSearchView) {
            this.Cbc = editorAudioSearchView;
        }

        public final void run() {
            AppMethodBeat.i(75916);
            this.Cbc.setVisibility(8);
            AppMethodBeat.o(75916);
        }
    }

    public final boolean bJw() {
        AppMethodBeat.i(237614);
        if (getVisibility() == 0) {
            AppMethodBeat.o(237614);
            return true;
        }
        AppMethodBeat.o(237614);
        return false;
    }

    public final void setMusicPlayer(v vVar) {
        AppMethodBeat.i(75926);
        p.h(vVar, "player");
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.CaV;
        if (aVar != null) {
            aVar.setMusicPlayer(vVar);
            AppMethodBeat.o(75926);
            return;
        }
        AppMethodBeat.o(75926);
    }

    public final void reset() {
        AppMethodBeat.i(75927);
        this.wKo = 0;
        this.CaW = -1;
        this.wKp = 0;
        Button button = this.nAa;
        if (button != null) {
            button.setEnabled(false);
        }
        EditText editText = this.CaP;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.CaV;
        if (aVar != null) {
            aVar.setSelection(null);
        }
        RecyclerView recyclerView = this.CaQ;
        if (recyclerView != null) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar2 = this.CaV;
        if (aVar2 != null) {
            aVar2.gj(new LinkedList());
        }
        eLM();
        this.CaX = null;
        this.CaY = null;
        this.CaZ = 0;
        AppMethodBeat.o(75927);
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.i(75928);
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = this.CaV;
        if (aVar != null) {
            aVar.setSelection(num);
            AppMethodBeat.o(75928);
            return;
        }
        AppMethodBeat.o(75928);
    }

    public final boolean eLP() {
        AppMethodBeat.i(237615);
        if (getVisibility() == 0) {
            EditText editText = this.CaP;
            if (Util.isNullOrNil(editText != null ? editText.getText() : null)) {
                eLL();
            } else {
                eLO();
                c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c.BPC.th(1);
                c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                c.a.eKk();
                reset();
                a aVar3 = this.Cba;
                if (aVar3 != null) {
                    aVar3.eLQ();
                }
            }
            AppMethodBeat.o(237615);
            return true;
        }
        AppMethodBeat.o(237615);
        return false;
    }

    public static final /* synthetic */ void o(EditorAudioSearchView editorAudioSearchView) {
        AppMethodBeat.i(75934);
        View view = editorAudioSearchView.CaL;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = editorAudioSearchView.CaM;
        if (view2 != null) {
            view2.setVisibility(0);
            AppMethodBeat.o(75934);
            return;
        }
        AppMethodBeat.o(75934);
    }

    public static final /* synthetic */ void b(EditorAudioSearchView editorAudioSearchView, boolean z) {
        AppMethodBeat.i(75935);
        Log.d(editorAudioSearchView.TAG, "doSearch " + editorAudioSearchView.CaX);
        if (!Util.isNullOrNil(editorAudioSearchView.CaX)) {
            if (!z) {
                LinearLayout linearLayout = editorAudioSearchView.CaS;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                RecyclerView recyclerView = editorAudioSearchView.CaQ;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                TextView textView = editorAudioSearchView.CaR;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
            long j2 = editorAudioSearchView.wKp;
            String str = editorAudioSearchView.CaX;
            if (str == null) {
                p.hyc();
            }
            new com.tencent.mm.plugin.recordvideo.model.audio.f(j2, str, editorAudioSearchView.wKo, editorAudioSearchView.wKq, (byte) 0).aYI().b(new b(editorAudioSearchView, z));
        }
        AppMethodBeat.o(75935);
    }

    public static final /* synthetic */ void a(EditorAudioSearchView editorAudioSearchView, LinkedList linkedList, boolean z) {
        AppMethodBeat.i(75937);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            AudioCacheInfo a2 = AudioCacheInfo.a.a((clp) obj, AudioCacheInfo.BPj);
            AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
            a2.source = AudioCacheInfo.BPn;
            a2.position = 0;
            a2.BPd = editorAudioSearchView.wKq;
            arrayList.add(a2);
            i2 = i3;
        }
        if (linkedList.size() == 10) {
            AudioCacheInfo.a aVar4 = AudioCacheInfo.BPo;
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
            audioCacheInfo.type = AudioCacheInfo.BPl;
            arrayList.add(audioCacheInfo);
        }
        if (!linkedList.isEmpty() || editorAudioSearchView.wKo != 1) {
            LinearLayout linearLayout = editorAudioSearchView.CaS;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            RecyclerView recyclerView = editorAudioSearchView.CaQ;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            TextView textView = editorAudioSearchView.CaR;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (z) {
                com.tencent.mm.plugin.recordvideo.ui.a.a aVar5 = editorAudioSearchView.CaV;
                if (aVar5 != null) {
                    aVar5.gk(arrayList);
                    AppMethodBeat.o(75937);
                    return;
                }
                AppMethodBeat.o(75937);
                return;
            }
            com.tencent.mm.plugin.recordvideo.ui.a.a aVar6 = editorAudioSearchView.CaV;
            if (aVar6 != null) {
                aVar6.gj(arrayList);
                AppMethodBeat.o(75937);
                return;
            }
            AppMethodBeat.o(75937);
            return;
        }
        editorAudioSearchView.eLN();
        AppMethodBeat.o(75937);
    }
}

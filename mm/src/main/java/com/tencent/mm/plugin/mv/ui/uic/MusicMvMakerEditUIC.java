package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.panel.layout.a;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 |2\u00020\u0001:\n|}~\u0001\u0001\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010D\u001a\u00020\u0019J\u0012\u0010E\u001a\u0004\u0018\u00010=2\b\u0010F\u001a\u0004\u0018\u00010=J\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u0004\u0018\u00010JJ>\u0010K\u001a\u00020H26\u0010L\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\r¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020H0MJ\u0006\u0010R\u001a\u00020HJ?\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\r2%\b\u0002\u0010V\u001a\u001f\u0012\u0013\u0012\u00110X¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020H\u0018\u00010WH\u0002J\u0006\u0010Z\u001a\u00020HJ\"\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\u00162\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020\u0019H\u0016J\b\u0010a\u001a\u00020HH\u0016J\u0006\u0010b\u001a\u00020HJ\b\u0010c\u001a\u00020HH\u0016J\b\u0010d\u001a\u00020HH\u0016J\u0006\u0010e\u001a\u00020HJ\u0010\u0010f\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0016H\u0002J\u0010\u0010g\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0016H\u0002J\u0006\u0010h\u001a\u00020HJ\u0018\u0010i\u001a\u00020H2\u0006\u0010j\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0016H\u0002J\u0006\u0010k\u001a\u00020HJ\u0018\u0010l\u001a\u00020H2\u0006\u0010j\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0016H\u0002J\u000e\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020\u0016J\u001a\u0010o\u001a\u00020H2\b\u0010p\u001a\u0004\u0018\u00010_2\u0006\u0010]\u001a\u00020\u0016H\u0002J\u000e\u0010q\u001a\u00020H2\u0006\u0010^\u001a\u00020rJ\u000e\u0010s\u001a\u00020H2\u0006\u0010^\u001a\u00020tJ\u0018\u0010u\u001a\u00020H2\u0006\u0010v\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u0016H\u0002J$\u0010x\u001a\u00020H2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0z2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\r0zH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0013j\b\u0012\u0004\u0012\u00020\r`\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0013j\b\u0012\u0004\u0012\u00020\r`\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R#\u00102\u001a\n 4*\u0004\u0018\u000103038BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b5\u00106R\u0012\u00108\u001a\u000609R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fromScene", "", "initMusicDataList", "isEdit", "", "()Z", "setEdit", "(Z)V", "isEditNewItem", "setEditNewItem", "itemDecoration", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "getItemDecoration", "()Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "itemDecoration$delegate", "lastPos", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "mvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mvCardRV$delegate", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVItemSizeResolver;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "checkCanDoNext", "createMvData", "originTrackData", "disableCurrentSyncMusic", "", "getCurrentCardView", "Landroid/view/View;", "getCurrentEditData", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "itemData", "initEditUI", "makeMediaThumbTransition", "pos", "newItem", "onAnimationEnd", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "nextAnimationInfo", "moveToNextItem", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDestroy", "onNextBtnClicked", "onPause", "onResume", "pauseVideo", "refreshVideo", "refreshView", "resumeVideo", "rollbackItemImpl", "item", "rollbackLastEditItem", "rollbackToInitItem", "takePhoto", "minDuration", "takePhotoFinished", "result", "updateAlbumItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "updateFinderItem", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "updateLyric", "currentPos", "totalDuration", "updateMusicItemList", "itemList", "", "originItemList", "Companion", "IMVEditItemAction", "IMVItemSizeResolver", "ItemEditActionCallback", "MVEditActionCallback", "MVItemSizeResolver", "MusicMVVideoItemConverterFactory", "plugin-mv_release"})
public final class MusicMvMakerEditUIC extends UIComponent {
    public static final a AuH = new a((byte) 0);
    public com.tencent.mm.plugin.music.model.e.a AkC;
    public csp AqY;
    private final kotlin.f AtV = kotlin.g.ah(new h(this));
    public final com.tencent.mm.emoji.panel.layout.a AtW;
    public final ArrayList<com.tencent.mm.plugin.mv.a.d> AuA = new ArrayList<>();
    private final kotlin.f AuB;
    public final f AuC;
    private final d.a AuD;
    public e AuE;
    public boolean AuF;
    public MMTPRecyclerVideoLayout AuG;
    private final kotlin.f Auz;
    public int fromScene;
    public final ArrayList<com.tencent.mm.plugin.mv.a.d> kgc = new ArrayList<>();
    public int tex;
    public boolean thl;
    private final kotlin.f vat;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
    public interface b {
        void a(int i2, com.tencent.mm.plugin.mv.a.d dVar, View view);

        void b(int i2, com.tencent.mm.plugin.mv.a.d dVar, View view);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "", "getItemWidth", "", "getPadding", "plugin-mv_release"})
    public interface c {
        int getItemWidth();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"})
    public interface e {
        void a(com.tencent.mm.plugin.mv.a.d dVar, boolean z, com.tencent.mm.plugin.mv.a.f fVar);

        void b(com.tencent.mm.plugin.mv.a.d dVar);

        void c(com.tencent.mm.plugin.mv.a.d dVar);

        void evF();
    }

    static {
        AppMethodBeat.i(257249);
        AppMethodBeat.o(257249);
    }

    public final WxRecyclerView evW() {
        AppMethodBeat.i(257232);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) this.Auz.getValue();
        AppMethodBeat.o(257232);
        return wxRecyclerView;
    }

    public final com.tencent.mm.plugin.music.ui.view.b evX() {
        AppMethodBeat.i(257235);
        com.tencent.mm.plugin.music.ui.view.b bVar = (com.tencent.mm.plugin.music.ui.view.b) this.AuB.getValue();
        AppMethodBeat.o(257235);
        return bVar;
    }

    public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d> getAdapter() {
        AppMethodBeat.i(257233);
        WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d> wxRecyclerAdapter = (WxRecyclerAdapter) this.AtV.getValue();
        AppMethodBeat.o(257233);
        return wxRecyclerAdapter;
    }

    public final LinearLayoutManager getLayoutManager() {
        AppMethodBeat.i(257234);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.vat.getValue();
        AppMethodBeat.o(257234);
        return linearLayoutManager;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.mv.a.f, x> {
        final /* synthetic */ MusicMvMakerEditUIC AuI;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuX;
        final /* synthetic */ int prP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2, com.tencent.mm.plugin.mv.a.d dVar) {
            super(1);
            this.AuI = musicMvMakerEditUIC;
            this.prP = i2;
            this.AuX = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.mv.a.f fVar) {
            AppMethodBeat.i(257229);
            com.tencent.mm.plugin.mv.a.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "animationInfo");
            e eVar = this.AuI.AuE;
            if (eVar != null) {
                eVar.a(this.AuX, true, fVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(257229);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.mv.a.f, x> {
        final /* synthetic */ MusicMvMakerEditUIC AuI;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuX;
        final /* synthetic */ int prP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2, com.tencent.mm.plugin.mv.a.d dVar) {
            super(1);
            this.AuI = musicMvMakerEditUIC;
            this.prP = i2;
            this.AuX = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.mv.a.f fVar) {
            AppMethodBeat.i(257230);
            com.tencent.mm.plugin.mv.a.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "animationInfo");
            e eVar = this.AuI.AuE;
            if (eVar != null) {
                eVar.a(this.AuX, true, fVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(257230);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvMakerEditUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257248);
        this.Auz = kotlin.g.ah(new p(appCompatActivity));
        this.vat = kotlin.g.ah(new m(appCompatActivity));
        this.AuB = kotlin.g.ah(new l(appCompatActivity));
        this.AtW = new com.tencent.mm.emoji.panel.layout.a();
        this.AuC = new f();
        this.tex = -1;
        this.AuD = new o(this);
        AppMethodBeat.o(257248);
    }

    public static final /* synthetic */ void a(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2) {
        AppMethodBeat.i(257251);
        musicMvMakerEditUIC.Tq(i2);
        AppMethodBeat.o(257251);
    }

    public static final /* synthetic */ WxRecyclerAdapter d(MusicMvMakerEditUIC musicMvMakerEditUIC) {
        AppMethodBeat.i(257253);
        WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d> adapter = musicMvMakerEditUIC.getAdapter();
        AppMethodBeat.o(257253);
        return adapter;
    }

    public static final /* synthetic */ WxRecyclerView f(MusicMvMakerEditUIC musicMvMakerEditUIC) {
        AppMethodBeat.i(257254);
        WxRecyclerView evW = musicMvMakerEditUIC.evW();
        AppMethodBeat.o(257254);
        return evW;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$Companion;", "", "()V", "TAG", "", "TAKE_PHOTO_REQUESTCODE", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
    static final class o implements d.a {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        o(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            this.AuI = musicMvMakerEditUIC;
        }

        @Override // com.tencent.mm.plugin.music.f.a.d.a
        public final void fn(final int i2, final int i3) {
            AppMethodBeat.i(257221);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.o.AnonymousClass1 */
                final /* synthetic */ o Vah;

                {
                    this.Vah = r1;
                }

                public final void run() {
                    AppMethodBeat.i(259266);
                    MusicMvMakerEditUIC.c(this.Vah.AuI, i2);
                    AppMethodBeat.o(259266);
                }
            });
            AppMethodBeat.o(257221);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
    public static final class i implements View.OnLayoutChangeListener {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        public i(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            this.AuI = musicMvMakerEditUIC;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(257209);
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "initEditUI: " + i3 + ", " + i5 + "; " + i7 + ", " + i9);
            this.AuI.AuC.gRD = i4 - i2;
            AppMethodBeat.o(257209);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$initEditUI$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
    public static final class j implements a.c {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public j(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            this.AuI = musicMvMakerEditUIC;
        }

        @Override // com.tencent.mm.emoji.panel.layout.a.c
        public final void pq(int i2) {
            AppMethodBeat.i(257210);
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onPageSettle: " + i2 + ", last " + this.AuI.tex);
            if (this.AuI.tex == i2) {
                AppMethodBeat.o(257210);
                return;
            }
            MusicMvMakerEditUIC.a(this.AuI, i2);
            MusicMvMakerEditUIC.b(this.AuI, i2);
            e eVar = this.AuI.AuE;
            if (eVar != null) {
                Object obj = this.AuI.kgc.get(i2);
                kotlin.g.b.p.g(obj, "dataList[position]");
                eVar.b((com.tencent.mm.plugin.mv.a.d) obj);
                AppMethodBeat.o(257210);
                return;
            }
            AppMethodBeat.o(257210);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$initEditUI$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "plugin-mv_release"})
    public static final class k extends RecyclerView.c {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public k(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            this.AuI = musicMvMakerEditUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(257213);
            super.onChanged();
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onChanged: " + MusicMvMakerEditUIC.d(this.AuI).getItemCount());
            if (this.AuI.AtW.hbQ == -1) {
                MusicMvMakerEditUIC.f(this.AuI).post(new a(this));
            }
            AppMethodBeat.o(257213);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ k AuJ;

            a(k kVar) {
                this.AuJ = kVar;
            }

            public final void run() {
                AppMethodBeat.i(257211);
                this.AuJ.AuI.AtW.f(MusicMvMakerEditUIC.f(this.AuJ.AuI));
                AppMethodBeat.o(257211);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(257214);
            if (obj == null) {
                Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onItemRangeChanged, start:" + i2 + ", itemCount:" + i3 + ", lastPos:" + this.AuI.tex + ", payload:" + obj);
                onItemRangeChanged(i2, i3);
            }
            AppMethodBeat.o(257214);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(257215);
            super.onItemRangeChanged(i2, i3);
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onItemRangeChanged, start:" + i2 + ", itemCount:" + i3 + ", lastPos:" + this.AuI.tex);
            int i4 = i2 + i3;
            int i5 = this.AuI.tex;
            if (i2 > i5) {
                AppMethodBeat.o(257215);
                return;
            }
            if (i4 > i5) {
                MusicMvMakerEditUIC.f(this.AuI).post(new b(this));
            }
            AppMethodBeat.o(257215);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class b implements Runnable {
            final /* synthetic */ k AuJ;

            b(k kVar) {
                this.AuJ = kVar;
            }

            public final void run() {
                AppMethodBeat.i(257212);
                MusicMvMakerEditUIC.b(this.AuJ.AuI, this.AuJ.AuI.tex);
                AppMethodBeat.o(257212);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        AppMethodBeat.i(257236);
        super.onDestroy();
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player.recycle();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (mMTPRecyclerVideoLayout2 == null || (effector = mMTPRecyclerVideoLayout2.getEffector()) == null) {
            AppMethodBeat.o(257236);
            return;
        }
        effector.release();
        AppMethodBeat.o(257236);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class v implements Runnable {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        public v(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            this.AuI = musicMvMakerEditUIC;
        }

        public final void run() {
            AppMethodBeat.i(257231);
            this.AuI.AtW.f(MusicMvMakerEditUIC.f(this.AuI));
            AppMethodBeat.o(257231);
        }
    }

    public final void a(int i2, com.tencent.mm.plugin.mv.a.d dVar, kotlin.g.a.b<? super com.tencent.mm.plugin.mv.a.f, x> bVar) {
        AppMethodBeat.i(257237);
        View findViewByPosition = getLayoutManager().findViewByPosition(i2);
        if (findViewByPosition != null) {
            ImageView imageView = (ImageView) findViewByPosition.findViewById(R.id.fre);
            if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setAlpha(0.0f);
                d.g gVar = dVar.Apo;
                if (gVar != null) {
                    gVar.a(imageView, new n(imageView, dVar, bVar));
                    AppMethodBeat.o(257237);
                    return;
                }
                AppMethodBeat.o(257237);
                return;
            }
            AppMethodBeat.o(257237);
            return;
        }
        AppMethodBeat.o(257237);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "attached", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$makeMediaThumbTransition$1$1$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$$special$$inlined$let$lambda$1"})
    static final class n implements h.a {
        final /* synthetic */ ImageView AuK;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuL;
        final /* synthetic */ kotlin.g.a.b AuM;

        n(ImageView imageView, com.tencent.mm.plugin.mv.a.d dVar, kotlin.g.a.b bVar) {
            this.AuK = imageView;
            this.AuL = dVar;
            this.AuM = bVar;
        }

        @Override // com.tencent.mm.plugin.gallery.ui.h.a
        public final void dSs() {
            AppMethodBeat.i(257220);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.n.AnonymousClass1 */
                final /* synthetic */ n AuN;

                {
                    this.AuN = r1;
                }

                public final void run() {
                    AppMethodBeat.i(257219);
                    this.AuN.AuK.animate().alpha(1.0f).setDuration(200).withEndAction(new Runnable(this) {
                        /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.n.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 AuO;

                        {
                            this.AuO = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(257218);
                            this.AuO.AuN.AuK.setVisibility(4);
                            com.tencent.mm.plugin.mv.a.f eC = com.tencent.mm.plugin.mv.a.g.eC(this.AuO.AuN.AuK);
                            kotlin.g.a.b bVar = this.AuO.AuN.AuM;
                            if (bVar != null) {
                                bVar.invoke(eC);
                                AppMethodBeat.o(257218);
                                return;
                            }
                            AppMethodBeat.o(257218);
                        }
                    }).start();
                    AppMethodBeat.o(257219);
                }
            });
            AppMethodBeat.o(257220);
        }
    }

    public final void k(kotlin.g.a.m<? super Integer, ? super com.tencent.mm.plugin.mv.a.d, x> mVar) {
        AppMethodBeat.i(259267);
        kotlin.g.b.p.h(mVar, "callback");
        int i2 = this.AtW.hbQ;
        com.tencent.mm.plugin.mv.a.d dVar = (com.tencent.mm.plugin.mv.a.d) kotlin.a.j.L(this.kgc, i2);
        if (dVar != null) {
            mVar.invoke(Integer.valueOf(i2), dVar);
            AppMethodBeat.o(259267);
            return;
        }
        AppMethodBeat.o(259267);
    }

    public final View evY() {
        AppMethodBeat.i(257238);
        View findViewByPosition = getLayoutManager().findViewByPosition(this.AtW.hbQ);
        AppMethodBeat.o(257238);
        return findViewByPosition;
    }

    public final boolean evZ() {
        boolean z;
        AppMethodBeat.i(257239);
        ArrayList<com.tencent.mm.plugin.mv.a.d> arrayList = this.kgc;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().Apq != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(257239);
                    return true;
                }
            }
        }
        AppMethodBeat.o(257239);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0226, code lost:
        if ((r0 == null || r0.length() == 0) != false) goto L_0x0228;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01a5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.csp d(com.tencent.mm.protocal.protobuf.csp r15) {
        /*
        // Method dump skipped, instructions count: 711
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.d(com.tencent.mm.protocal.protobuf.csp):com.tencent.mm.protocal.protobuf.csp");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(257241);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvSaveDraftUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvSaveDraftUIC.class)).a(d(this.AqY), this.thl, 2);
        AppMethodBeat.o(257241);
        return true;
    }

    public final void cWX() {
        com.tencent.mm.plugin.thumbplayer.d.b bVar;
        com.tencent.mm.plugin.thumbplayer.d.c cVar;
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        AppMethodBeat.i(257242);
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "pauseVideo");
        RecyclerView.v ch = evW().ch(this.tex);
        if (ch == null) {
            AppMethodBeat.o(257242);
            return;
        }
        kotlin.g.b.p.g(ch, "mvCardRV.findViewHolderF…sition(lastPos) ?: return");
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = (MMTPRecyclerVideoLayout) ch.aus.findViewById(R.id.fqq);
        if (mMTPRecyclerVideoLayout != null) {
            com.tencent.mm.plugin.thumbplayer.e.b player2 = mMTPRecyclerVideoLayout.getPlayer();
            if (player2 != null) {
                player2.dFp();
            }
            com.tencent.mm.plugin.thumbplayer.e.b player3 = mMTPRecyclerVideoLayout.getPlayer();
            if (player3 != null) {
                player3.stop();
            }
        }
        if (this.tex >= 0) {
            com.tencent.mm.plugin.mv.a.d dVar = this.kgc.get(this.tex);
            kotlin.g.b.p.g(dVar, "dataList[lastPos]");
            com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
            if (mMTPRecyclerVideoLayout2 == null || (player = mMTPRecyclerVideoLayout2.getPlayer()) == null) {
                bVar = null;
            } else {
                bVar = player.VfQ;
            }
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout3 = this.AuG;
            if (mMTPRecyclerVideoLayout3 == null || (effector = mMTPRecyclerVideoLayout3.getEffector()) == null) {
                cVar = null;
            } else {
                cVar = effector.Vfv;
            }
            com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
            com.tencent.mm.plugin.mv.a.k.a(getActivity(), this.AqY, this.tex, dVar2, bVar, cVar);
        }
        AppMethodBeat.o(257242);
    }

    public final void cWY() {
        AppMethodBeat.i(257243);
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "resumeVideo");
        getAdapter().ci(this.AtW.hbQ);
        AppMethodBeat.o(257243);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(257244);
        super.onPause();
        cWX();
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().c(this.AuD);
        AppMethodBeat.o(257244);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(257245);
        super.onResume();
        cWY();
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().b(this.AuD);
        AppMethodBeat.o(257245);
    }

    public final void Tq(int i2) {
        AppMethodBeat.i(257246);
        if (i2 != this.tex) {
            com.tencent.mm.plugin.mv.a.d dVar = (com.tencent.mm.plugin.mv.a.d) kotlin.a.j.L(this.kgc, this.tex);
            if (dVar != null && dVar.uOQ) {
                dVar.uOQ = false;
                dVar.Apn = false;
                RecyclerView.v ch = evW().ch(this.tex);
                if (ch instanceof com.tencent.mm.view.recyclerview.h) {
                    a.c cVar = com.tencent.mm.plugin.mv.ui.a.a.JRL;
                    a.c.a((com.tencent.mm.view.recyclerview.h) ch, dVar);
                }
            }
            com.tencent.mm.plugin.mv.a.d dVar2 = (com.tencent.mm.plugin.mv.a.d) kotlin.a.j.L(this.kgc, i2);
            if (dVar2 != null) {
                if (!dVar2.uOQ) {
                    dVar2.uOQ = true;
                    dVar2.Apn = true;
                    RecyclerView.v ch2 = evW().ch(i2);
                    if (ch2 instanceof com.tencent.mm.view.recyclerview.h) {
                        a.c cVar2 = com.tencent.mm.plugin.mv.ui.a.a.JRL;
                        a.c.a((com.tencent.mm.view.recyclerview.h) ch2, dVar2);
                    }
                }
                AppMethodBeat.o(257246);
                return;
            }
        }
        AppMethodBeat.o(257246);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t¸\u0006\n"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$refreshVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPos", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "plugin-mv_release", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$$special$$inlined$let$lambda$2"})
    public static final class r implements com.tencent.mm.plugin.thumbplayer.view.e {
        final /* synthetic */ MusicMvMakerEditUIC AuI;
        long AuQ;
        final /* synthetic */ com.tencent.mm.plugin.thumbplayer.d.a AuR;
        final /* synthetic */ RecyclerView.v AuS;
        final /* synthetic */ long AuT;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuU;

        r(com.tencent.mm.plugin.thumbplayer.d.a aVar, MusicMvMakerEditUIC musicMvMakerEditUIC, RecyclerView.v vVar, long j2, com.tencent.mm.plugin.mv.a.d dVar) {
            this.AuR = aVar;
            this.AuI = musicMvMakerEditUIC;
            this.AuS = vVar;
            this.AuT = j2;
            this.AuU = dVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.view.e
        public final void Hv(final long j2) {
            AppMethodBeat.i(257227);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.r.AnonymousClass1 */
                final /* synthetic */ r AuV;

                {
                    this.AuV = r3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    int cR;
                    int i2 = 0;
                    AppMethodBeat.i(257226);
                    if (this.AuV.AuU.uOQ) {
                        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                        com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                        kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                        int etn = etW.etn();
                        int durationMs = this.AuV.AuU.getDurationMs();
                        d.h hVar = this.AuV.AuU.App;
                        if (!(hVar instanceof d.i)) {
                            hVar = null;
                        }
                        d.i iVar = (d.i) hVar;
                        if (iVar == null || !iVar.isDefault) {
                            if (durationMs > 0) {
                                i2 = kotlin.h.a.cR((((float) (j2 - this.AuV.AuT)) * 100.0f) / ((float) durationMs));
                            }
                            if (this.AuV.AuQ > j2 && this.AuV.AuU.Apn) {
                                Log.d("MicroMsg.Mv.MusicMvMakerEditUIC", "musicTimeMs:" + etn + ", lastPlayPos:" + this.AuV.AuQ + ", timeMs:" + j2 + ", startMs:" + this.AuV.AuT);
                                com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
                                kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
                                euj2.etW().tG(this.AuV.AuU.Apl);
                            }
                            this.AuV.AuQ = j2;
                        } else {
                            if (etn > this.AuV.AuU.Apm && ((long) etn) != this.AuV.AuQ && this.AuV.AuU.Apn) {
                                Log.d("MicroMsg.Mv.MusicMvMakerEditUIC", "musicTimeMs:" + etn + ", lastPlayPos:" + this.AuV.AuQ + ", item startMs:" + this.AuV.AuU.Apl + ", item endMs:" + this.AuV.AuU.Apm + ", loop");
                                com.tencent.mm.plugin.music.e.k euj3 = com.tencent.mm.plugin.music.e.k.euj();
                                kotlin.g.b.p.g(euj3, "MusicPlayerManager.Instance()");
                                euj3.etW().tG(this.AuV.AuU.Apl);
                            }
                            this.AuV.AuQ = (long) etn;
                            if (durationMs <= 0) {
                                cR = 0;
                            } else {
                                cR = kotlin.h.a.cR((((float) (etn - this.AuV.AuU.Apl)) * 100.0f) / ((float) this.AuV.AuU.getDurationMs()));
                            }
                            i2 = cR;
                        }
                        View findViewById = this.AuV.AuS.aus.findViewById(R.id.g8s);
                        kotlin.g.b.p.g(findViewById, "holder.itemView.findView…r>(R.id.part_mv_seek_bar)");
                        ((ProgressBar) findViewById).setProgress(i2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257226);
                    return xVar;
                }
            });
            AppMethodBeat.o(257227);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(257247);
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onActivityResult, requestCodec:" + i2 + ", resultCodec:" + i3);
        switch (i2) {
            case 1024:
                com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                euj.etW().resume();
                kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new q(this, intent, i3, null), 2);
                break;
        }
        AppMethodBeat.o(257247);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class s implements Runnable {
        final /* synthetic */ MusicMvMakerEditUIC AuI;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.d AuW;
        final /* synthetic */ int prP;

        s(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2, com.tencent.mm.plugin.mv.a.d dVar) {
            this.AuI = musicMvMakerEditUIC;
            this.prP = i2;
            this.AuW = dVar;
        }

        public final void run() {
            AppMethodBeat.i(257228);
            e eVar = this.AuI.AuE;
            if (eVar != null) {
                eVar.evF();
            }
            e eVar2 = this.AuI.AuE;
            if (eVar2 != null) {
                eVar2.a(this.AuW, true, null);
                AppMethodBeat.o(257228);
                return;
            }
            AppMethodBeat.o(257228);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVItemSizeResolver;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;)V", "viewWidth", "", "getViewWidth", "()I", "setViewWidth", "(I)V", "getItemWidth", "getPadding", "plugin-mv_release"})
    public final class f implements c {
        public int gRD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.c
        public final int getItemWidth() {
            AppMethodBeat.i(257204);
            if (this.gRD == 0) {
                int jn = com.tencent.mm.cb.a.jn(MusicMvMakerEditUIC.this.getActivity()) - (getPadding() * 2);
                AppMethodBeat.o(257204);
                return jn;
            }
            int padding = this.gRD - (getPadding() * 2);
            AppMethodBeat.o(257204);
            return padding;
        }

        public static int getPadding() {
            AppMethodBeat.i(257205);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 70);
            AppMethodBeat.o(257205);
            return fromDPToPix;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$ItemEditActionCallback;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;)V", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
    public final class d implements b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.b
        public final void a(int i2, com.tencent.mm.plugin.mv.a.d dVar, View view) {
            AppMethodBeat.i(257202);
            kotlin.g.b.p.h(dVar, "item");
            kotlin.g.b.p.h(view, "itemView");
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onRollback: ".concat(String.valueOf(i2)));
            MusicMvMakerEditUIC.a(MusicMvMakerEditUIC.this, dVar, i2);
            e eVar = MusicMvMakerEditUIC.this.AuE;
            if (eVar != null) {
                eVar.c(dVar);
                AppMethodBeat.o(257202);
                return;
            }
            AppMethodBeat.o(257202);
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.b
        public final void b(int i2, com.tencent.mm.plugin.mv.a.d dVar, View view) {
            AppMethodBeat.i(257203);
            kotlin.g.b.p.h(dVar, "item");
            kotlin.g.b.p.h(view, "itemView");
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onEdit: ".concat(String.valueOf(i2)));
            ImageView imageView = (ImageView) view.findViewById(R.id.frj);
            if (imageView != null) {
                com.tencent.mm.plugin.mv.a.f eC = com.tencent.mm.plugin.mv.a.g.eC(imageView);
                e eVar = MusicMvMakerEditUIC.this.AuE;
                if (eVar != null) {
                    eVar.a(dVar, false, eC);
                    AppMethodBeat.o(257203);
                    return;
                }
                AppMethodBeat.o(257203);
                return;
            }
            AppMethodBeat.o(257203);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MusicMVVideoItemConverterFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;)V", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
    public final class g implements com.tencent.mm.view.recyclerview.f {
        private final c ArU;
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        public g(MusicMvMakerEditUIC musicMvMakerEditUIC, c cVar) {
            kotlin.g.b.p.h(cVar, "sizeResolver");
            this.AuI = musicMvMakerEditUIC;
            AppMethodBeat.i(257207);
            this.ArU = cVar;
            AppMethodBeat.o(257207);
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(257206);
            com.tencent.mm.plugin.mv.ui.a.a aVar = new com.tencent.mm.plugin.mv.ui.a.a(this.ArU, new d());
            AppMethodBeat.o(257206);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC$onActivityResult$1", f = "MusicMvMakerEditUIC.kt", hxM = {}, m = "invokeSuspend")
    static final class q extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ MusicMvMakerEditUIC AuI;
        final /* synthetic */ Intent AuP;
        final /* synthetic */ int lGC;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(MusicMvMakerEditUIC musicMvMakerEditUIC, Intent intent, int i2, kotlin.d.d dVar) {
            super(2, dVar);
            this.AuI = musicMvMakerEditUIC;
            this.AuP = intent;
            this.lGC = i2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(257224);
            kotlin.g.b.p.h(dVar, "completion");
            q qVar = new q(this.AuI, this.AuP, this.lGC, dVar);
            qVar.p$ = (ai) obj;
            AppMethodBeat.o(257224);
            return qVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(257225);
            Object invokeSuspend = ((q) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(257225);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(257223);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MusicMvMakerEditUIC.a(this.AuI, this.AuP, this.lGC);
                    x xVar = x.SXb;
                    AppMethodBeat.o(257223);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(257223);
                    throw illegalStateException;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<WxRecyclerView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxRecyclerView invoke() {
            AppMethodBeat.i(257222);
            WxRecyclerView wxRecyclerView = (WxRecyclerView) this.uQi.findViewById(R.id.fr0);
            AppMethodBeat.o(257222);
            return wxRecyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d>> {
        final /* synthetic */ MusicMvMakerEditUIC AuI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MusicMvMakerEditUIC musicMvMakerEditUIC) {
            super(0);
            this.AuI = musicMvMakerEditUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d> invoke() {
            AppMethodBeat.i(257208);
            WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new g(this.AuI, this.AuI.AuC), this.AuI.kgc, true);
            AppMethodBeat.o(257208);
            return wxRecyclerAdapter;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayoutManager> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayoutManager invoke() {
            AppMethodBeat.i(257217);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(0, false);
            AppMethodBeat.o(257217);
            return linearLayoutManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.music.ui.view.b> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.music.ui.view.b invoke() {
            AppMethodBeat.i(257216);
            com.tencent.mm.plugin.music.ui.view.b bVar = new com.tencent.mm.plugin.music.ui.view.b(this.uQi);
            AppMethodBeat.o(257216);
            return bVar;
        }
    }

    public static final /* synthetic */ void a(MusicMvMakerEditUIC musicMvMakerEditUIC, com.tencent.mm.plugin.mv.a.d dVar, int i2) {
        AppMethodBeat.i(257250);
        if (i2 < musicMvMakerEditUIC.AuA.size()) {
            com.tencent.mm.plugin.mv.a.d dVar2 = musicMvMakerEditUIC.AuA.get(i2);
            kotlin.g.b.p.g(dVar2, "initMusicDataList[position]");
            com.tencent.mm.plugin.mv.a.d dVar3 = dVar2;
            dVar3.uOQ = dVar.uOQ;
            dVar.Apq = null;
            musicMvMakerEditUIC.kgc.set(i2, dVar3);
            musicMvMakerEditUIC.getAdapter().ci(i2);
            musicMvMakerEditUIC.Tq(i2);
        }
        AppMethodBeat.o(257250);
    }

    public static final /* synthetic */ void b(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2) {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        com.tencent.mm.plugin.thumbplayer.d.a evA;
        ViewParent viewParent;
        ViewParent viewParent2;
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout;
        com.tencent.mm.plugin.thumbplayer.e.b player;
        com.tencent.mm.plugin.thumbplayer.d.b bVar;
        com.tencent.mm.plugin.thumbplayer.d.c cVar;
        com.tencent.mm.plugin.thumbplayer.c.a effector;
        com.tencent.mm.plugin.thumbplayer.e.b player2;
        AppMethodBeat.i(257252);
        Log.printInfoStack("MicroMsg.Mv.MusicMvMakerEditUIC", "refreshVideo: " + i2 + ' ' + musicMvMakerEditUIC.tex, new Object[0]);
        if (musicMvMakerEditUIC.tex >= 0 && (mMTPRecyclerVideoLayout = musicMvMakerEditUIC.AuG) != null && (player = mMTPRecyclerVideoLayout.getPlayer()) != null && player.isPlaying()) {
            com.tencent.mm.plugin.mv.a.d dVar = musicMvMakerEditUIC.kgc.get(musicMvMakerEditUIC.tex);
            kotlin.g.b.p.g(dVar, "dataList[lastPos]");
            com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = musicMvMakerEditUIC.AuG;
            if (mMTPRecyclerVideoLayout2 == null || (player2 = mMTPRecyclerVideoLayout2.getPlayer()) == null) {
                bVar = null;
            } else {
                bVar = player2.VfQ;
            }
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout3 = musicMvMakerEditUIC.AuG;
            if (mMTPRecyclerVideoLayout3 == null || (effector = mMTPRecyclerVideoLayout3.getEffector()) == null) {
                cVar = null;
            } else {
                cVar = effector.Vfv;
            }
            com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
            com.tencent.mm.plugin.mv.a.k.a(musicMvMakerEditUIC.getActivity(), musicMvMakerEditUIC.AqY, musicMvMakerEditUIC.tex, dVar2, bVar, cVar);
        }
        RecyclerView.v ch = musicMvMakerEditUIC.evW().ch(i2);
        if (ch == null) {
            AppMethodBeat.o(257252);
            return;
        }
        kotlin.g.b.p.g(ch, "mvCardRV.findViewHolderF…ition(position) ?: return");
        com.tencent.mm.plugin.mv.a.d dVar3 = musicMvMakerEditUIC.kgc.get(i2);
        kotlin.g.b.p.g(dVar3, "dataList[position]");
        com.tencent.mm.plugin.mv.a.d dVar4 = dVar3;
        musicMvMakerEditUIC.tex = i2;
        if (dVar4.Apn) {
            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
            euj.etW().tG(dVar4.Apl);
        }
        d.h hVar = dVar4.App;
        long evz = hVar != null ? hVar.evz() : 0;
        StringBuilder sb = new StringBuilder("refreshVideo mediaInfo:");
        d.h hVar2 = dVar4.App;
        if (hVar2 != null) {
            aVar = hVar2.evA();
        } else {
            aVar = null;
        }
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", sb.append(aVar).toString());
        d.h hVar3 = dVar4.App;
        if (hVar3 == null || (evA = hVar3.evA()) == null) {
            AppMethodBeat.o(257252);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) ch.aus.findViewById(R.id.j44);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout4 = musicMvMakerEditUIC.AuG;
        if (mMTPRecyclerVideoLayout4 != null) {
            viewParent = mMTPRecyclerVideoLayout4.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout5 = musicMvMakerEditUIC.AuG;
            if (mMTPRecyclerVideoLayout5 != null) {
                viewParent2 = mMTPRecyclerVideoLayout5.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(257252);
                throw tVar;
            }
            ((ViewGroup) viewParent2).removeView(musicMvMakerEditUIC.AuG);
        }
        frameLayout.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(musicMvMakerEditUIC.AuG, layoutParams);
        View findViewById = ch.aus.findViewById(R.id.g8s);
        kotlin.g.b.p.g(findViewById, "holder.itemView.findView…r>(R.id.part_mv_seek_bar)");
        ((ProgressBar) findViewById).setProgress(0);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout6 = musicMvMakerEditUIC.AuG;
        if (mMTPRecyclerVideoLayout6 != null) {
            mMTPRecyclerVideoLayout6.fxd();
            mMTPRecyclerVideoLayout6.setKeepScreenOn(true);
            com.tencent.mm.plugin.thumbplayer.e.b player3 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player3 != null) {
                player3.dFs();
            }
            mMTPRecyclerVideoLayout6.setMediaInfo(evA);
            com.tencent.mm.plugin.thumbplayer.e.b player4 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player4 != null) {
                player4.wcA = true;
            }
            com.tencent.mm.plugin.thumbplayer.e.b player5 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player5 != null) {
                player5.fwW();
            }
            com.tencent.mm.plugin.thumbplayer.e.b player6 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player6 != null) {
                player6.setLoop(true);
            }
            com.tencent.mm.plugin.thumbplayer.c.a.a(mMTPRecyclerVideoLayout6.getEffector());
            com.tencent.mm.plugin.thumbplayer.e.b player7 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player7 != null) {
                player7.at(evz, ((long) dVar4.getDurationMs()) + evz);
            }
            com.tencent.mm.plugin.thumbplayer.e.b player8 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player8 != null) {
                player8.fwU();
            }
            com.tencent.mm.plugin.thumbplayer.e.b player9 = mMTPRecyclerVideoLayout6.getPlayer();
            if (player9 != null) {
                player9.a(new r(evA, musicMvMakerEditUIC, ch, evz, dVar4), 30);
                AppMethodBeat.o(257252);
                return;
            }
            AppMethodBeat.o(257252);
            return;
        }
        AppMethodBeat.o(257252);
    }

    public static final /* synthetic */ void a(MusicMvMakerEditUIC musicMvMakerEditUIC, Intent intent, int i2) {
        String str;
        String str2;
        AppMethodBeat.i(257255);
        if (i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("KEY_RECORD_VIDEO_PATH");
            if (stringExtra == null) {
                str = "";
            } else {
                str = stringExtra;
            }
            String stringExtra2 = intent.getStringExtra("KEY_RECORD_VIDEO_THUMB_PATH");
            if (stringExtra2 == null) {
                str2 = "";
            } else {
                str2 = stringExtra2;
            }
            boolean YS = com.tencent.mm.vfs.s.YS(str);
            boolean YS2 = com.tencent.mm.vfs.s.YS(str2);
            int i3 = musicMvMakerEditUIC.AtW.hbQ;
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "takePhotoFinished, videoPath:" + str + ", videoExist:" + YS + ", thumbPath:" + str2 + ", thumbExist:" + YS2 + ", pos:" + i3);
            if (YS) {
                com.tencent.mm.plugin.sight.base.a cc = com.tencent.mm.plugin.sight.base.e.cc(str, true);
                com.tencent.mm.plugin.mv.a.d dVar = new com.tencent.mm.plugin.mv.a.d();
                d.b bVar = com.tencent.mm.plugin.mv.a.d.Aps;
                com.tencent.mm.plugin.mv.a.d dVar2 = musicMvMakerEditUIC.kgc.get(i3);
                kotlin.g.b.p.g(dVar2, "dataList[pos]");
                d.b.a(dVar2, dVar);
                dVar.type = 3;
                dVar.Apo = new d.a(str2, str);
                kotlin.g.b.p.g(musicMvMakerEditUIC.AuA.get(i3), "initMusicDataList[pos]");
                dVar.Apq = musicMvMakerEditUIC.kgc.get(i3);
                d.i iVar = new d.i(str + '_' + str.hashCode(), str, (long) cc.videoDuration);
                iVar.videoWidth = cc.width;
                iVar.videoHeight = cc.height;
                dVar.App = iVar;
                musicMvMakerEditUIC.kgc.set(i3, dVar);
                com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                com.tencent.mm.plugin.mv.a.l.axc(1);
                com.tencent.mm.plugin.mv.a.l lVar2 = com.tencent.mm.plugin.mv.a.l.UZs;
                com.tencent.mm.plugin.mv.a.l.a(i3, dVar);
                com.tencent.f.h.RTc.aV(new s(musicMvMakerEditUIC, i3, dVar));
            }
        }
        AppMethodBeat.o(257255);
    }

    public static final /* synthetic */ void c(MusicMvMakerEditUIC musicMvMakerEditUIC, int i2) {
        AppMethodBeat.i(257256);
        RecyclerView.v ch = musicMvMakerEditUIC.evW().ch(musicMvMakerEditUIC.tex);
        if (ch == null) {
            AppMethodBeat.o(257256);
            return;
        }
        kotlin.g.b.p.g(ch, "mvCardRV.findViewHolderF…sition(lastPos) ?: return");
        TextView textView = (TextView) ch.aus.findViewById(R.id.frf);
        kotlin.g.b.p.g(textView, "lyricView");
        textView.setText(musicMvMakerEditUIC.kgc.get(musicMvMakerEditUIC.tex).Tj(i2));
        AppMethodBeat.o(257256);
    }
}

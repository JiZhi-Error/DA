package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010g\u001a\u00020hH\u0002J\u0010\u0010\f\u001a\u00020h2\u0006\u0010i\u001a\u00020\rH\u0002J\u0010\u0010j\u001a\u00020h2\u0006\u0010k\u001a\u00020&H\u0002J\u0010\u0010l\u001a\u00020h2\u0006\u0010k\u001a\u00020&H\u0002J\u0010\u0010m\u001a\u00020h2\u0006\u0010k\u001a\u00020&H\u0002J\b\u0010n\u001a\u00020hH\u0002J\b\u0010o\u001a\u00020hH\u0016J\u0016\u0010p\u001a\u00020\u00052\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0016\u0010r\u001a\u00020\u00052\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0002J\u0016\u0010s\u001a\u00020\u00052\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0002J\b\u0010t\u001a\u00020\rH\u0014J\u0010\u0010u\u001a\u00020h2\u0006\u0010v\u001a\u00020&H\u0002J\b\u0010w\u001a\u00020hH\u0002J\b\u0010x\u001a\u00020hH\u0002J\b\u0010y\u001a\u00020hH\u0002J\b\u0010z\u001a\u00020hH\u0002J\b\u0010{\u001a\u00020hH\u0002J\b\u0010|\u001a\u00020hH\u0002J$\u0010}\u001a\u00020h2\u0006\u0010~\u001a\u00020\r2\u0006\u0010\u001a\u00020\r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u0014\u0010\u0001\u001a\u00020h2\t\u0010\u0001\u001a\u0004\u0018\u000105H\u0016J\u0015\u0010\u0001\u001a\u00020h2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020hH\u0014J\t\u0010\u0001\u001a\u00020hH\u0014J\t\u0010\u0001\u001a\u00020hH\u0014J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0014J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0002J\u0012\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020&H\u0002J\u0012\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020&H\u0002J\u0007\u0010\u0001\u001a\u00020hJ\t\u0010\u0001\u001a\u00020hH\u0002J\t\u0010\u0001\u001a\u00020hH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R\u001c\u0010=\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\u001c\u0010@\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R \u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R\u001c\u0010F\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00101\"\u0004\bH\u00103R\u001c\u0010I\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00107\"\u0004\bT\u00109R\u001c\u0010U\u001a\u0004\u0018\u00010VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\t\"\u0004\b]\u0010\u000bR\u001c\u0010^\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\t\"\u0004\b`\u0010\u000bR\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "setCancelTv", "(Landroid/widget/TextView;)V", "chooseMode", "", "getChooseMode", "()I", "setChooseMode", "(I)V", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "chooseWhiteListRoom", "Ljava/util/ArrayList;", "getChooseWhiteListRoom", "()Ljava/util/ArrayList;", "setChooseWhiteListRoom", "(Ljava/util/ArrayList;)V", "chooseWhiteUser", "getChooseWhiteUser", "setChooseWhiteUser", "finishTv", "getFinishTv", "setFinishTv", "foldIconOpen", "", "getFoldIconOpen", "()Z", "setFoldIconOpen", "(Z)V", "maxUserCount", "getMaxUserCount", "setMaxUserCount", "publicChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPublicChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPublicChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "publicGroup", "Landroid/view/View;", "getPublicGroup", "()Landroid/view/View;", "setPublicGroup", "(Landroid/view/View;)V", "shareChooseIcon", "getShareChooseIcon", "setShareChooseIcon", "shareGroup", "getShareGroup", "setShareGroup", "titleGroup", "getTitleGroup", "setTitleGroup", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListChooseIcon", "getWhiteListChooseIcon", "setWhiteListChooseIcon", "whiteListContent", "getWhiteListContent", "setWhiteListContent", "whiteListFoldIv", "Landroid/widget/ImageView;", "getWhiteListFoldIv", "()Landroid/widget/ImageView;", "setWhiteListFoldIv", "(Landroid/widget/ImageView;)V", "whiteListGroup", "getWhiteListGroup", "setWhiteListGroup", "whiteListRv", "Landroid/support/v7/widget/RecyclerView;", "getWhiteListRv", "()Landroid/support/v7/widget/RecyclerView;", "setWhiteListRv", "(Landroid/support/v7/widget/RecyclerView;)V", "whiteListTipsTv", "getWhiteListTipsTv", "setWhiteListTipsTv", "whiteListTitleTv", "getWhiteListTitleTv", "setWhiteListTitleTv", "whitelistAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "getWhitelistAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "setWhitelistAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;)V", "checkWhiteListState", "", "mode", "choosePublicMode", "choose", "chooseShareMode", "chooseWhiteListMode", "expandWhiteListGroupPanel", "finish", "formatSelectedList", "selectedList", "formatSelectedListRoom", "formatSelectedUser", "getLayoutId", "goBack", "isCancel", "goToSelectRoom", "goToSelectUser", "goToSelectWhiteList", "hideWhiteList", "initLayout", "initLogic", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "parseInten", "setFinishBtnEnable", "enable", "setWhiteListFoldState", WeChatBrands.Business.GROUP_OPEN, "setWindowStyle", "showWhiteList", "updateAdapter", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI14 extends MMFinderUI implements View.OnClickListener {
    private static String UIJ = "KEY_PARAMS_MAX_ROOM_COUNT";
    private static String UIK = "KEY_PARAMS_CHOOSE_WHITE_LIST_ROOM";
    private static String UIL = "KEY_PARAMS_CHOOSE_WHITE_LIST_USER";
    private static String UIM = "KEY_PARAMS_MAX_USER_COUNT";
    private static String ueA = "KEY_PARAMS_CHOOSE_WHITE_LIST";
    public static final a ueB = new a((byte) 0);
    private static String uey = "KEY_PARAMS_VISIBILITY_MODE";
    private static String uez = "KEY_PARAMS_WHITE_LIST";
    private final String TAG = "FinderLiveVisitorWhiteListUI";
    private FinderLiveWhiteListGroupAdapter UIF;
    private ArrayList<String> UIG = new ArrayList<>();
    private ArrayList<String> UIH = new ArrayList<>();
    private int UII;
    private HashMap _$_findViewCache;
    View hRR;
    private TextView ued;
    private TextView uee;
    private View uef;
    private WeImageView ueg;
    private View uei;
    private WeImageView uej;
    private View uek;
    private WeImageView uel;
    private TextView uem;
    private TextView uen;
    private ImageView ueo;
    private View uep;
    private RecyclerView ueq;
    private int uet;
    private LinkedList<avh> ueu = new LinkedList<>();
    private LinkedList<avh> uev = new LinkedList<>();
    private boolean uex;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245712);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245712);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245711);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245711);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "type", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14$initLayout$2$1"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ OccupyFinderUI14 ueC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OccupyFinderUI14 occupyFinderUI14) {
            super(1);
            this.ueC = occupyFinderUI14;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(260261);
            switch (num.intValue()) {
                case 0:
                    OccupyFinderUI14.a(this.ueC);
                    break;
                case 1:
                    OccupyFinderUI14.b(this.ueC);
                    break;
                case 2:
                    OccupyFinderUI14.c(this.ueC);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260261);
            return xVar;
        }
    }

    public OccupyFinderUI14() {
        AppMethodBeat.i(245707);
        AppMethodBeat.o(245707);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u000e\u0010\u001b\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14$Companion;", "", "()V", "KEY_PARAMS_CHOOSE_WHITE_LIST", "", "getKEY_PARAMS_CHOOSE_WHITE_LIST", "()Ljava/lang/String;", "setKEY_PARAMS_CHOOSE_WHITE_LIST", "(Ljava/lang/String;)V", "KEY_PARAMS_CHOOSE_WHITE_LIST_ROOM", "getKEY_PARAMS_CHOOSE_WHITE_LIST_ROOM", "setKEY_PARAMS_CHOOSE_WHITE_LIST_ROOM", "KEY_PARAMS_CHOOSE_WHITE_LIST_USER", "getKEY_PARAMS_CHOOSE_WHITE_LIST_USER", "setKEY_PARAMS_CHOOSE_WHITE_LIST_USER", "KEY_PARAMS_MAX_ROOM_COUNT", "getKEY_PARAMS_MAX_ROOM_COUNT", "setKEY_PARAMS_MAX_ROOM_COUNT", "KEY_PARAMS_MAX_USER_COUNT", "getKEY_PARAMS_MAX_USER_COUNT", "setKEY_PARAMS_MAX_USER_COUNT", "KEY_PARAMS_VISIBILITY_MODE", "getKEY_PARAMS_VISIBILITY_MODE", "setKEY_PARAMS_VISIBILITY_MODE", "KEY_PARAMS_WHITE_LIST", "getKEY_PARAMS_WHITE_LIST", "setKEY_PARAMS_WHITE_LIST", "REQUEST_CODE_SELECT_ROOM", "", "REQUEST_CODE_SELECT_USER", "REQUEST_CODE_SELECT_WHITE_LIST", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245708);
        AppMethodBeat.o(245708);
    }

    public final void setTitleGroup(View view) {
        this.hRR = view;
    }

    public final void setPublicGroup(View view) {
        this.uef = view;
    }

    public final void setShareGroup(View view) {
        this.uei = view;
    }

    public final void setWhiteListGroup(View view) {
        this.uek = view;
    }

    public final void setWhiteListContent(View view) {
        this.uep = view;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(245686);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        context.getWindow().addFlags(2097280);
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        context2.getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            AppCompatActivity context3 = getContext();
            p.g(context3, "context");
            context3.getWindow().clearFlags(67108864);
            AppCompatActivity context4 = getContext();
            p.g(context4, "context");
            Window window = context4.getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            AppCompatActivity context5 = getContext();
            p.g(context5, "context");
            context5.getWindow().addFlags(Integer.MIN_VALUE);
            AppCompatActivity context6 = getContext();
            p.g(context6, "context");
            Window window2 = context6.getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            AppCompatActivity context7 = getContext();
            p.g(context7, "context");
            Window window3 = context7.getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        AppCompatActivity context8 = getContext();
        p.g(context8, "context");
        context8.getWindow().setFormat(-3);
        AppCompatActivity context9 = getContext();
        p.g(context9, "context");
        context9.getWindow().setSoftInputMode(51);
        Log.i(this.TAG, "[onCreate]");
        this.hRR = findViewById(R.id.iq_);
        View view = this.hRR;
        if (view != null) {
            view.post(new c(this));
        }
        this.ued = (TextView) findViewById(R.id.aik);
        TextView textView = this.ued;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.uee = (TextView) findViewById(R.id.d54);
        TextView textView2 = this.uee;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        this.uef = findViewById(R.id.glz);
        View view2 = this.uef;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        this.ueg = (WeImageView) findViewById(R.id.gly);
        this.uei = findViewById(R.id.hpf);
        View view3 = this.uei;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        this.uej = (WeImageView) findViewById(R.id.hp7);
        this.uek = findViewById(R.id.jnp);
        View view4 = this.uek;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        this.uel = (WeImageView) findViewById(R.id.jnj);
        this.uem = (TextView) findViewById(R.id.jnr);
        this.uen = (TextView) findViewById(R.id.jnq);
        this.ueo = (ImageView) findViewById(R.id.jno);
        this.uep = findViewById(R.id.jnl);
        this.ueq = (RecyclerView) findViewById(R.id.jnm);
        this.UIF = new FinderLiveWhiteListGroupAdapter();
        FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter = this.UIF;
        if (finderLiveWhiteListGroupAdapter != null) {
            finderLiveWhiteListGroupAdapter.UPj = new b(this);
        }
        RecyclerView recyclerView = this.ueq;
        if (recyclerView != null) {
            recyclerView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
            recyclerView.setAdapter(this.UIF);
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = au.aD(recyclerView.getContext());
            }
        }
        Serializable serializableExtra = getIntent().getSerializableExtra(uez);
        if (!(serializableExtra instanceof List)) {
            serializableExtra = null;
        }
        List list = (List) serializableExtra;
        if (list != null) {
            m mVar = m.vVH;
            m.b(list, this.ueu);
        }
        Serializable serializableExtra2 = getIntent().getSerializableExtra(ueA);
        if (!(serializableExtra2 instanceof List)) {
            serializableExtra2 = null;
        }
        List list2 = (List) serializableExtra2;
        if (list2 != null) {
            m mVar2 = m.vVH;
            m.b(list2, this.uev);
        }
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(UIK);
        if (stringArrayListExtra != null) {
            this.UIG.clear();
            this.UIG.addAll(stringArrayListExtra);
        }
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra(UIL);
        if (stringArrayListExtra2 != null) {
            this.UIH.clear();
            this.UIH.addAll(stringArrayListExtra2);
        }
        this.UII = getIntent().getIntExtra(UIM, 0);
        this.uet = getIntent().getIntExtra(uey, 0);
        FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter2 = this.UIF;
        if (finderLiveWhiteListGroupAdapter2 != null) {
            LinkedList<avh> linkedList = this.ueu;
            p.h(linkedList, "list");
            finderLiveWhiteListGroupAdapter2.UPx.clear();
            finderLiveWhiteListGroupAdapter2.UPx.addAll(linkedList);
        }
        hSL();
        Log.i(this.TAG, "initLogic chooseMode:" + this.uet + ", visitorWhiteList size:" + this.ueu.size() + ",chooseWhiteList size:" + this.uev.size());
        LinkedList<avh> linkedList2 = this.uev;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            this.uet |= 1;
        }
        ArrayList<String> arrayList = this.UIG;
        if (arrayList == null || arrayList.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.uet |= 2;
        }
        ArrayList<String> arrayList2 = this.UIH;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.uet |= 4;
        }
        IT(this.uet);
        AppMethodBeat.o(245686);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ OccupyFinderUI14 ueC;

        c(OccupyFinderUI14 occupyFinderUI14) {
            this.ueC = occupyFinderUI14;
        }

        public final void run() {
            ViewGroup.LayoutParams layoutParams;
            ViewParent viewParent;
            ViewGroup viewGroup = null;
            AppMethodBeat.i(245685);
            int statusBarHeight = au.getStatusBarHeight(this.ueC.getContext());
            View view = this.ueC.hRR;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = statusBarHeight;
            }
            View view2 = this.ueC.hRR;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.updateViewLayout(this.ueC.hRR, marginLayoutParams);
                AppMethodBeat.o(245685);
                return;
            }
            AppMethodBeat.o(245685);
        }
    }

    private static String bl(ArrayList<String> arrayList) {
        AppMethodBeat.i(260262);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (T t : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjJ(t);
            p.g(bjJ, "contact");
            sb.append(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(bjJ, bjJ.getUsername()));
            if (i2 < arrayList.size() - 1) {
                sb.append(",");
            }
            i2 = i3;
        }
        String sb2 = sb.toString();
        p.g(sb2, "result.toString()");
        AppMethodBeat.o(260262);
        return sb2;
    }

    private static String bD(ArrayList<String> arrayList) {
        AppMethodBeat.i(260263);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (T t : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjJ(t);
            p.g(bjJ, "contact");
            sb.append(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(bjJ, bjJ.getUsername()));
            if (i2 < arrayList.size() - 1) {
                sb.append(",");
            }
            i2 = i3;
        }
        String sb2 = sb.toString();
        p.g(sb2, "result.toString()");
        AppMethodBeat.o(260263);
        return sb2;
    }

    private static String al(LinkedList<avh> linkedList) {
        AppMethodBeat.i(260264);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (T t : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            sb.append(t.title);
            if (i2 < linkedList.size() - 1) {
                sb.append(",");
            }
            i2 = i3;
        }
        String sb2 = sb.toString();
        p.g(sb2, "result.toString()");
        AppMethodBeat.o(260264);
        return sb2;
    }

    private final void hSL() {
        AppMethodBeat.i(260265);
        FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter = this.UIF;
        if (finderLiveWhiteListGroupAdapter != null) {
            LinkedList<FinderLiveWhiteListGroupAdapter.b> linkedList = new LinkedList<>();
            linkedList.add(new FinderLiveWhiteListGroupAdapter.b(0, bl(this.UIG)));
            if (this.UII > 0) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hUN()) {
                    linkedList.add(new FinderLiveWhiteListGroupAdapter.b(2, bD(this.UIH)));
                    linkedList.add(new FinderLiveWhiteListGroupAdapter.b(1, al(this.uev)));
                    finderLiveWhiteListGroupAdapter.bT(linkedList);
                    AppMethodBeat.o(260265);
                    return;
                }
            }
            Log.i(this.TAG, "maxUserCount invalid");
            linkedList.add(new FinderLiveWhiteListGroupAdapter.b(1, al(this.uev)));
            finderLiveWhiteListGroupAdapter.bT(linkedList);
            AppMethodBeat.o(260265);
            return;
        }
        AppMethodBeat.o(260265);
    }

    private final void hSM() {
        AppMethodBeat.i(260266);
        nf(false);
        hSN();
        if (this.uex) {
            nh(false);
        } else {
            nh(true);
        }
        deB();
        AppMethodBeat.o(260266);
    }

    private final void IT(int i2) {
        AppMethodBeat.i(245687);
        Log.i(this.TAG, "chooseMode:".concat(String.valueOf(i2)));
        if (i2 == 0) {
            nf(true);
            hSN();
            nh(false);
            ne(true);
            k kVar = k.vkd;
            k.dpl().a(s.aq.PUBLIC);
            AppMethodBeat.o(245687);
            return;
        }
        if (d.cW(i2, 2) || d.cW(i2, 4) || d.cW(i2, 1)) {
            hSM();
        }
        AppMethodBeat.o(245687);
    }

    private final void deB() {
        AppMethodBeat.i(245688);
        if (this.uev.size() > 0 || this.UIG.size() > 0 || this.UIH.size() > 0) {
            ne(true);
            AppMethodBeat.o(245688);
            return;
        }
        ne(false);
        AppMethodBeat.o(245688);
    }

    private final void ne(boolean z) {
        AppMethodBeat.i(245689);
        TextView textView = this.uee;
        if (textView != null) {
            textView.setEnabled(z);
        }
        if (z) {
            TextView textView2 = this.uee;
            if (textView2 != null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                textView2.setTextColor(context.getResources().getColor(R.color.am));
                AppMethodBeat.o(245689);
                return;
            }
            AppMethodBeat.o(245689);
            return;
        }
        TextView textView3 = this.uee;
        if (textView3 != null) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            textView3.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_2));
            AppMethodBeat.o(245689);
            return;
        }
        AppMethodBeat.o(245689);
    }

    private final void nf(boolean z) {
        AppMethodBeat.i(245690);
        if (z) {
            WeImageView weImageView = this.ueg;
            if (weImageView != null) {
                weImageView.setVisibility(0);
                AppMethodBeat.o(245690);
                return;
            }
            AppMethodBeat.o(245690);
            return;
        }
        WeImageView weImageView2 = this.ueg;
        if (weImageView2 != null) {
            weImageView2.setVisibility(8);
            AppMethodBeat.o(245690);
            return;
        }
        AppMethodBeat.o(245690);
    }

    private final void hSN() {
        AppMethodBeat.i(260267);
        WeImageView weImageView = this.uej;
        if (weImageView != null) {
            weImageView.setVisibility(8);
            AppMethodBeat.o(260267);
            return;
        }
        AppMethodBeat.o(260267);
    }

    private final void nh(boolean z) {
        AppMethodBeat.i(245692);
        if (z) {
            View view = this.uep;
            if (view != null) {
                view.setVisibility(0);
            }
            ni(true);
            deC();
            WeImageView weImageView = this.uel;
            if (weImageView != null) {
                weImageView.setVisibility(0);
                AppMethodBeat.o(245692);
                return;
            }
            AppMethodBeat.o(245692);
            return;
        }
        WeImageView weImageView2 = this.uel;
        if (weImageView2 != null) {
            weImageView2.setVisibility(8);
        }
        View view2 = this.uep;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ni(false);
        deD();
        WeImageView weImageView3 = this.uel;
        if (weImageView3 != null) {
            weImageView3.setVisibility(8);
            AppMethodBeat.o(245692);
            return;
        }
        AppMethodBeat.o(245692);
    }

    private final void deC() {
        AppMethodBeat.i(245693);
        FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter = this.UIF;
        if (finderLiveWhiteListGroupAdapter != null) {
            finderLiveWhiteListGroupAdapter.notifyDataSetChanged();
        }
        RecyclerView recyclerView = this.ueq;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
            AppMethodBeat.o(245693);
            return;
        }
        AppMethodBeat.o(245693);
    }

    private final void deD() {
        AppMethodBeat.i(245694);
        RecyclerView recyclerView = this.ueq;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
            AppMethodBeat.o(245694);
            return;
        }
        AppMethodBeat.o(245694);
    }

    private final void ni(boolean z) {
        AppMethodBeat.i(245696);
        if (this.uex == z) {
            Log.i(this.TAG, "setWhiteListFoldState open:" + z + " same with foldIconOpen!");
            AppMethodBeat.o(245696);
            return;
        }
        this.uex = z;
        if (this.uex) {
            ImageView imageView = this.ueo;
            if (imageView != null) {
                imageView.setRotationX(180.0f);
                AppMethodBeat.o(245696);
                return;
            }
            AppMethodBeat.o(245696);
            return;
        }
        ImageView imageView2 = this.ueo;
        if (imageView2 != null) {
            imageView2.setRotationX(0.0f);
            AppMethodBeat.o(245696);
            return;
        }
        AppMethodBeat.o(245696);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(245698);
        super.onStart();
        Log.i(this.TAG, "[onStart]");
        AppMethodBeat.o(245698);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245699);
        super.onResume();
        Log.i(this.TAG, "[onResume]");
        AppMethodBeat.o(245699);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245700);
        super.onPause();
        Log.i(this.TAG, "[onPause]");
        AppMethodBeat.o(245700);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(245701);
        super.onStop();
        Log.i(this.TAG, "[onStop]");
        AppMethodBeat.o(245701);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245702);
        super.onDestroy();
        Log.i(this.TAG, "[onDestroy]");
        AppMethodBeat.o(245702);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cfe;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(245703);
        super.onSwipeBack();
        mD(true);
        AppMethodBeat.o(245703);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245704);
        super.finish();
        AppMethodBeat.o(245704);
    }

    private final void mD(boolean z) {
        ArrayList arrayList;
        Intent intent;
        ArrayList arrayList2;
        AppMethodBeat.i(245705);
        Log.i(this.TAG, "goBack isCancel:" + z + " chooseMode:" + this.uet + " chooseWhiteList.size:" + this.uev.size() + " chooseWhiteListRoom:" + this.UIG);
        if (z) {
            setResult(0);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra(uey, this.uet);
            String str = ueA;
            LinkedList<avh> linkedList = this.uev;
            if (linkedList != null) {
                LinkedList<avh> linkedList2 = linkedList;
                ArrayList arrayList3 = new ArrayList(j.a(linkedList2, 10));
                Iterator<T> it = linkedList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().toByteArray());
                }
                arrayList = arrayList3;
                intent = intent2;
            } else {
                arrayList = null;
                intent = intent2;
            }
            if (!(arrayList instanceof Serializable)) {
                arrayList2 = null;
            } else {
                arrayList2 = arrayList;
            }
            intent.putExtra(str, arrayList2);
            intent2.putStringArrayListExtra(UIK, this.UIG);
            intent2.putStringArrayListExtra(UIL, this.UIH);
            setResult(-1, intent2);
        }
        finish();
        AppMethodBeat.o(245705);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(245706);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.aik) {
            mD(true);
        } else if (valueOf != null && valueOf.intValue() == R.id.d54) {
            mD(false);
        } else if (valueOf != null && valueOf.intValue() == R.id.glz) {
            this.uet = 0;
            IT(this.uet);
        } else if ((valueOf == null || valueOf.intValue() != R.id.hpf) && valueOf != null && valueOf.intValue() == R.id.jnp) {
            hSM();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245706);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = false;
        String str = null;
        ArrayList<String> arrayList = null;
        List list = null;
        AppMethodBeat.i(260268);
        super.onActivityResult(i2, i3, intent);
        Log.i(this.TAG, "onActivityResult requestCode:" + i2 + " resultCode:" + i3);
        switch (i2) {
            case 0:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra(UIK);
                }
                Log.i(this.TAG, "onActivityResult REQUEST_CODE_SELECT_ROOM selectedResult:".concat(String.valueOf(arrayList)));
                if (arrayList != null) {
                    this.UIG.clear();
                    this.UIG.addAll(arrayList);
                    ArrayList<String> arrayList2 = this.UIG;
                    if (arrayList2 == null || arrayList2.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        this.uet |= 2;
                        deB();
                    }
                    hSL();
                    FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter = this.UIF;
                    if (finderLiveWhiteListGroupAdapter != null) {
                        finderLiveWhiteListGroupAdapter.notifyDataSetChanged();
                        AppMethodBeat.o(260268);
                        return;
                    }
                    AppMethodBeat.o(260268);
                    return;
                }
                break;
            case 1:
                Serializable serializableExtra = intent != null ? intent.getSerializableExtra(ueA) : null;
                if (serializableExtra instanceof List) {
                    list = serializableExtra;
                }
                List list2 = list;
                if (list2 != null) {
                    m mVar = m.vVH;
                    m.b(list2, this.uev);
                    LinkedList<avh> linkedList = this.uev;
                    if (linkedList == null || linkedList.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        this.uet |= 1;
                        deB();
                    }
                    hSL();
                    FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter2 = this.UIF;
                    if (finderLiveWhiteListGroupAdapter2 != null) {
                        finderLiveWhiteListGroupAdapter2.notifyDataSetChanged();
                    }
                }
                Log.i(this.TAG, "onActivityResult REQUEST_CODE_SELECT_WHITE_LIST chooseWhiteList.size:" + this.uev.size());
                AppMethodBeat.o(260268);
                return;
            case 2:
                if (intent != null) {
                    str = intent.getStringExtra("Select_Contact");
                }
                List<String> stringToList = Util.stringToList(str, ",");
                if (stringToList != null) {
                    this.UIH.clear();
                    this.UIH.addAll(stringToList);
                    ArrayList<String> arrayList3 = this.UIH;
                    if (((arrayList3 == null || arrayList3.isEmpty()) ? 1 : null) == null) {
                        this.uet |= 4;
                        deB();
                    }
                    hSL();
                    FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter3 = this.UIF;
                    if (finderLiveWhiteListGroupAdapter3 != null) {
                        finderLiveWhiteListGroupAdapter3.notifyDataSetChanged();
                        AppMethodBeat.o(260268);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(260268);
    }

    public static final /* synthetic */ void a(OccupyFinderUI14 occupyFinderUI14) {
        AppMethodBeat.i(260269);
        Intent intent = new Intent(occupyFinderUI14, OccupyFinderUI18.class);
        intent.putStringArrayListExtra(UIK, occupyFinderUI14.UIG);
        occupyFinderUI14.startActivityForResult(intent, 0);
        AppMethodBeat.o(260269);
    }

    public static final /* synthetic */ void b(OccupyFinderUI14 occupyFinderUI14) {
        AppMethodBeat.i(260270);
        Intent intent = new Intent(occupyFinderUI14, OccupyFinderUI17.class);
        String str = uez;
        LinkedList<avh> linkedList = occupyFinderUI14.ueu;
        ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toByteArray());
        }
        intent.putExtra(str, arrayList);
        String str2 = ueA;
        LinkedList<avh> linkedList2 = occupyFinderUI14.uev;
        ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
        Iterator<T> it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().toByteArray());
        }
        intent.putExtra(str2, arrayList2);
        occupyFinderUI14.startActivityForResult(intent, 1);
        AppMethodBeat.o(260270);
    }

    public static final /* synthetic */ void c(OccupyFinderUI14 occupyFinderUI14) {
        AppMethodBeat.i(260271);
        Intent intent = new Intent();
        intent.setClassName(occupyFinderUI14, "com.tencent.mm.ui.contact.SelectContactUI");
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", occupyFinderUI14.getString(R.string.d1m));
        intent.putExtra("without_openim", true);
        intent.putExtra("list_attr", u.Q(u.ll(u.PWT, TPMediaCodecProfileLevel.HEVCMainTierLevel62), 131072));
        intent.putExtra("already_select_contact", Util.listToString(occupyFinderUI14.UIH, ","));
        intent.putExtra("max_limit_num", occupyFinderUI14.UII > 0 ? occupyFinderUI14.UII : 500);
        intent.putExtra("Forbid_SelectChatRoom", true);
        intent.putExtra("KForceDarkMode", true);
        occupyFinderUI14.startActivityForResult(intent, 2);
        AppMethodBeat.o(260271);
    }
}

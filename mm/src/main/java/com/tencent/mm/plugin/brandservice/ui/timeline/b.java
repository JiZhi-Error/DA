package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.p;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.an;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.av;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aw;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0016\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u000200J\u0018\u0010E\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010\u00072\u0006\u0010G\u001a\u000200J\u0016\u0010H\u001a\u00020@2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010I\u001a\u00020@2\b\u0010J\u001a\u0004\u0018\u00010>J\u0016\u0010K\u001a\u00020@2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020L0\u0006H\u0002J,\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J,\u0010S\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J&\u0010T\u001a\u00020@2\u0006\u0010O\u001a\u0002002\u0006\u0010F\u001a\u00020\u00072\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020NJ,\u0010W\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J,\u0010X\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J,\u0010Y\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J,\u0010Z\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J,\u0010[\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J\u0016\u0010\\\u001a\u00020@2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010^\u001a\u00020\t2\b\u0010F\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010_\u001a\u000200H\u0016J\u0012\u0010`\u001a\u0004\u0018\u00010\u00072\u0006\u0010O\u001a\u000200H\u0016J\u0010\u0010a\u001a\u00020<2\u0006\u0010O\u001a\u000200H\u0016J\u0010\u0010b\u001a\u0002002\u0006\u0010O\u001a\u000200H\u0016J\b\u0010c\u001a\u00020@H\u0002J\u0010\u0010d\u001a\u0002002\u0006\u0010F\u001a\u00020\u0007H\u0002J$\u0010e\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0016J,\u0010f\u001a\u0004\u0018\u00010N2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010N2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010g\u001a\u000200H\u0016J\u0016\u0010h\u001a\u00020@2\u0006\u0010i\u001a\u00020j2\u0006\u0010F\u001a\u00020\u0007J\b\u0010k\u001a\u00020@H\u0002J\b\u0010l\u001a\u00020\tH\u0016J\u0018\u0010m\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010n\u001a\u000200H\u0002J\u0006\u0010o\u001a\u00020\tJ\u000e\u0010o\u001a\u00020@2\u0006\u0010n\u001a\u000200J\b\u00105\u001a\u00020@H\u0002J\b\u0010p\u001a\u00020@H\u0016J \u0010q\u001a\u00020@2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020N2\u0006\u0010u\u001a\u00020vH\u0016J\u001a\u0010w\u001a\u00020@2\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010{H\u0002J\u0006\u0010|\u001a\u00020@J\u0010\u0010}\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010\u0007J\u000e\u0010~\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0007J\b\u0010\u001a\u00020@H\u0002J\u0007\u0010\u0001\u001a\u00020@J\u0007\u0010\u0001\u001a\u00020@J\u0007\u0010\u0001\u001a\u00020@J\u0007\u0010\u0001\u001a\u00020@J\u0007\u0010\u0001\u001a\u00020@J\t\u0010\u0001\u001a\u00020@H\u0002J\t\u0010\u0001\u001a\u00020@H\u0002JF\u0010\u0001\u001a\u00020@2\u0007\u0010\u0001\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010O\u001a\u0002002\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010G\u001a\u000200J\u0007\u0010\u0001\u001a\u00020@J\t\u0010\u0001\u001a\u00020@H\u0002J\u0011\u0010\u0001\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010\u0007J\u0019\u0010\u0001\u001a\u00020@2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002J\u0017\u0010\u0001\u001a\u00020@2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\t\u0010\u0001\u001a\u00020@H\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010&\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070.X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/view/View$OnCreateContextMenuListener;", "mContext", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "keepPos", "", "keepData", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "bizTimeLineHotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;Ljava/util/List;ZZLcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;)V", "avatarClickListener", "Landroid/view/View$OnClickListener;", "bizTimeLineImgLoader", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizTimeLineImgLoader;", "bizTimeLineItemClickCallback", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/IBizTimeLineItemClickCallback;", "canGetRecommendFeed", "doingGetRecommendFeeds", "doingInitRecommendFeeds", "expandedReaderItem", "", "Lcom/tencent/mm/message/BizReaderItem;", "firstItem", "getFirstItem", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "isAllSameGroupData", "()Z", "isPause", "items", "getItems", "()Ljava/util/List;", "getKeepData", "lastItem", "getLastItem", "getList", "getMContext", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "mInfo", "mKeepPos", "mList", "", "mMessageIndex", "", "mRecList", "menuItemSelectedListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineMMMenuItemListener;", "newMsgLineItem", "noMoreData", "getNoMoreData", "setNoMoreData", "(Z)V", "onBizInfoChange", "Lcom/tencent/mm/storage/BizTimeLineInfoStorage$IOnBizInfoChange;", "smallestGroupId", "", "talkerSet", "", "checkNoMoreData", "", "checkList", "checkPreload", "startPos", "endPos", "clickRecCardReport", "info", "messageIndex", "doUpdateListCellPosition", "enterSession", "taker", "feedToBizTimeLineInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "fillingBizMsg", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "fillingCanvas", "fillingCommInfo", "topLayout", "newTipsLayout", "fillingNewMsgLine", "fillingRecCard", "fillingRecFeed", "fillingTextMsg", "fillingUnknownMsg", "filterAndAddList", "originList", "filterMsg", "getCount", "getItem", "getItemId", "getItemViewType", "getMoreRecommendFeeds", "getMsgItemCount", "getView", "getViewInternal", "getViewTypeCount", "initHeader", "slot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem;", "initRecommendFeeds", "isEmpty", "isShowNewTips", "pos", "loadMoreData", "notifyDataSetChanged", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDataChange", "stg", "", "notifyInfo", "Lcom/tencent/mm/storage/BizTimeLineInfoStorage$BizNotifyInfo;", "onDestroy", "onExpand", "onFeedBack", "onGetRecommendFeedFail", "onPause", "onResume", "resetKeep", "resetList", "resetNewMsgStatus", "resetNoMoreData", "resetSmallestGroupId", "setCommonAction", "item", "reader", "Lcom/tencent/mm/message/BizMMReader;", "clickView", "multiMsg", "showMoreMenu", "switchToMsgMode", "updateGroupId", "updateList", "updateListCellPosition", "updateNewMsgLine", "Companion", "ItemViewType", "plugin-brandservice_release"})
public final class b extends BaseAdapter implements View.OnCreateContextMenuListener {
    public static int prA;
    public static int prB;
    public static int prC;
    public static int prD;
    private static Long prE;
    private static Long prF;
    public static final a prG = new a((byte) 0);
    public static int prq;
    public static int prr;
    public static int prs;
    public static int prt;
    public static int pru;
    public static int prv;
    public static int prw;
    private static int prx;
    public static int pry;
    public static int prz;
    boolean dLD;
    private final List<z> list;
    public final List<z> nZr = new LinkedList();
    final aa.c pmx;
    List<z> pqW = new LinkedList();
    private final z pqX;
    public z pqY;
    public f pqZ;
    public int pra;
    public BizTimeLineHotView prb;
    public com.tencent.mm.plugin.brandservice.ui.timeline.preload.d prc;
    private final al prd;
    private long pre;
    boolean prf;
    private final Set<String> prg;
    public Set<v> prh;
    private final View.OnClickListener pri;
    private final h prj;
    boolean prk;
    private boolean prl;
    private boolean prm;
    private boolean prn;
    final BizTimeLineUI pro;
    private final boolean prp;

    static {
        AppMethodBeat.i(195251);
        AppMethodBeat.o(195251);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "aBoolean", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)Ljava/lang/Void;"})
    public static final class o<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ b prH;

        o(b bVar) {
            this.prH = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(195237);
            Boolean bool = (Boolean) obj;
            p.g(bool, "aBoolean");
            if (bool.booleanValue()) {
                this.prH.pro.cmD();
            }
            AppMethodBeat.o(195237);
            return null;
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(195252);
        bVar.cmm();
        AppMethodBeat.o(195252);
    }

    public static final /* synthetic */ void a(b bVar, List list2) {
        AppMethodBeat.i(195254);
        cB(list2);
        AppMethodBeat.o(195254);
    }

    public static final /* synthetic */ void b(b bVar, List list2) {
        AppMethodBeat.i(195256);
        bVar.cD(list2);
        AppMethodBeat.o(195256);
    }

    public static final /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(195253);
        bVar.cms();
        AppMethodBeat.o(195253);
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(5888);
        z De = De(i2);
        AppMethodBeat.o(5888);
        return De;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.tencent.mm.storage.z> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(BizTimeLineUI bizTimeLineUI, List<? extends z> list2, boolean z, boolean z2, f fVar, BizTimeLineHotView bizTimeLineHotView) {
        p.h(bizTimeLineUI, "mContext");
        p.h(list2, "list");
        p.h(fVar, "report");
        p.h(bizTimeLineHotView, "bizTimeLineHotView");
        AppMethodBeat.i(195250);
        this.pro = bizTimeLineUI;
        this.list = list2;
        this.prp = z2;
        z zVar = new z();
        zVar.dDG = 1;
        this.pqX = zVar;
        this.pqZ = fVar;
        this.pre = -1;
        this.prg = new HashSet();
        this.prh = new HashSet();
        this.pmx = new k(this);
        this.pri = new View$OnClickListenerC0873b(this, fVar);
        this.prj = new c(fVar, bizTimeLineHotView);
        this.prl = true;
        cmv();
        cC(this.list);
        this.prb = bizTimeLineHotView;
        if (prq == 0) {
            pru = this.pro.getResources().getDimensionPixelSize(R.dimen.tc);
            prv = this.pro.getResources().getDimensionPixelSize(R.dimen.t8);
            prw = this.pro.getResources().getDimensionPixelSize(R.dimen.hs);
            prx = this.pro.getResources().getDimensionPixelSize(R.dimen.ib);
            prz = this.pro.getResources().getDimensionPixelSize(R.dimen.th);
            prA = this.pro.getResources().getDimensionPixelOffset(R.dimen.hs);
            pry = this.pro.getResources().getDimensionPixelOffset(R.dimen.ir);
            prB = com.tencent.mm.cb.a.fromDPToPix((Context) this.pro, 2);
            prD = com.tencent.mm.cb.a.fromDPToPix((Context) this.pro, 40);
            prC = com.tencent.mm.cb.a.fromDPToPix((Context) this.pro, 8);
            int jn = com.tencent.mm.cb.a.jn(this.pro);
            int jo = com.tencent.mm.cb.a.jo(this.pro);
            jn = jn >= jo ? jo : jn;
            int density = jn - ((int) (com.tencent.mm.cb.a.getDensity(this.pro) * 16.0f));
            int density2 = jn - ((int) ((com.tencent.mm.cb.a.getDensity(this.pro) * 16.0f) * 2.0f));
            prq = (int) (((float) density) / 2.35f);
            prr = (int) (((float) density2) / 2.35f);
            prs = (int) (((float) density) / 1.7777778f);
            prt = (int) (((float) density2) / 1.7777778f);
        }
        ag.ban().a(this.pmx, Looper.getMainLooper());
        cA(this.list);
        cB(this.list);
        this.prf = z;
        cml();
        this.prc = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.d(this.pro, prq, pru, this.nZr);
        this.prd = new al(this, this.pro);
        com.tencent.mm.plugin.brandservice.ui.timeline.item.l.cmM();
        AppMethodBeat.o(195250);
    }

    private final void cml() {
        z cmp;
        AppMethodBeat.i(5866);
        cmq();
        if (a.cmx()) {
            AppMethodBeat.o(5866);
            return;
        }
        if (this.prf && (cmp = cmp()) != null && !cmp.gAA()) {
            long j2 = -1;
            for (z zVar : this.nZr) {
                if (j2 == -1 || j2 == zVar.gAo()) {
                    j2 = zVar.gAo();
                } else {
                    prE = Long.valueOf(zVar.field_orderFlag);
                    AppMethodBeat.o(5866);
                    return;
                }
            }
        }
        AppMethodBeat.o(5866);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "stg", "", "kotlin.jvm.PlatformType", "notifyInfo", "Lcom/tencent/mm/storage/BizTimeLineInfoStorage$BizNotifyInfo;", "onNotifyChange"})
    static final class k implements aa.c {
        final /* synthetic */ b prH;

        k(b bVar) {
            this.prH = bVar;
        }

        @Override // com.tencent.mm.storage.aa.c
        public final void a(final Object obj, final aa.a aVar) {
            AppMethodBeat.i(195233);
            if (aVar == null || !aVar.NQF) {
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.b.k.AnonymousClass1 */
                    final /* synthetic */ k prQ;

                    {
                        this.prQ = r1;
                    }

                    public final boolean queueIdle() {
                        AppMethodBeat.i(195232);
                        Looper.myQueue().removeIdleHandler(this);
                        if (this.prQ.prH.pro == null || this.prQ.prH.pro.isFinishing()) {
                            AppMethodBeat.o(195232);
                        } else {
                            b bVar = this.prQ.prH;
                            p.g(obj, "stg");
                            b.a(bVar, aVar);
                            AppMethodBeat.o(195232);
                        }
                        return false;
                    }
                });
                AppMethodBeat.o(195233);
                return;
            }
            AppMethodBeat.o(195233);
        }
    }

    private final boolean b(z zVar) {
        Long l2;
        Long l3 = null;
        AppMethodBeat.i(195238);
        if (zVar != null) {
            l2 = Long.valueOf(zVar.gAo());
        } else {
            l2 = null;
        }
        z cmp = cmp();
        if (cmp != null) {
            l3 = Long.valueOf(cmp.gAo());
        }
        if (!p.j(l2, l3)) {
            AppMethodBeat.o(195238);
            return false;
        } else if (zVar == null || zVar.field_type == 34 || zVar.field_type == 3) {
            AppMethodBeat.o(195238);
            return true;
        } else {
            AppMethodBeat.o(195238);
            return false;
        }
    }

    public final void c(z zVar) {
        AppMethodBeat.i(195239);
        p.h(zVar, "info");
        Log.i("MicroMsg.BizTimeLineAdapter", "onFeedBack");
        this.pqW.remove(zVar);
        List<z> list2 = this.pqW;
        if (list2 == null || list2.isEmpty()) {
            Log.w("MicroMsg.BizTimeLineAdapter", "onFeedBack mRecList is empty");
            cmm();
        }
        notifyDataSetChanged();
        p.a aVar = com.tencent.mm.model.p.iCa;
        kotlin.g.b.p.h(zVar, "info");
        if (zVar.NQr == null) {
            AppMethodBeat.o(195239);
            return;
        }
        bub aTJ = p.a.aTJ();
        if (aTJ != null) {
            LinkedList<dkr> linkedList = aTJ.MaI;
            kotlin.g.b.p.g(linkedList, "it.RecommendCard");
            T t = null;
            for (T t2 : linkedList) {
                String str = t2.KUk;
                dkr dkr = zVar.NQr;
                if (kotlin.g.b.p.j(str, dkr != null ? dkr.KUk : null)) {
                    Log.i("Micromsg.BizTLRecFeedsDataUtil", "onRemove first screen data");
                    t = t2;
                }
            }
            if (t != null) {
                aTJ.MaI.remove(t);
                p.a aVar2 = com.tencent.mm.model.p.iCa;
                p.a.a(aTJ);
            }
            AppMethodBeat.o(195239);
            return;
        }
        AppMethodBeat.o(195239);
    }

    public final int getCount() {
        AppMethodBeat.i(5868);
        if (a.cmx()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnj()) {
                int size = this.nZr.size() + this.pqW.size() + 1;
                AppMethodBeat.o(5868);
                return size;
            }
        }
        int size2 = this.nZr.size();
        AppMethodBeat.o(5868);
        return size2;
    }

    public final z De(int i2) {
        int size;
        AppMethodBeat.i(5869);
        if (i2 >= this.nZr.size() || i2 < 0) {
            if (a.cmx()) {
                if (i2 == this.nZr.size()) {
                    z zVar = this.pqX;
                    AppMethodBeat.o(5869);
                    return zVar;
                } else if (this.pqW.size() > 0 && (i2 - this.nZr.size()) - 1 < this.pqW.size() && size >= 0) {
                    z zVar2 = this.pqW.get(size);
                    AppMethodBeat.o(5869);
                    return zVar2;
                }
            }
            AppMethodBeat.o(5869);
            return null;
        }
        z zVar3 = this.nZr.get(i2);
        AppMethodBeat.o(5869);
        return zVar3;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(5870);
        z De = De(i2);
        if (De == null) {
            Log.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
            AppMethodBeat.o(5870);
            return 0;
        }
        switch (De.field_type) {
            case 1:
                AppMethodBeat.o(5870);
                return 2;
            case 285212721:
                AppMethodBeat.o(5870);
                return 1;
            case 620757041:
                AppMethodBeat.o(5870);
                return 3;
            case 637534257:
                AppMethodBeat.o(5870);
                return 4;
            default:
                if (De.gAr()) {
                    AppMethodBeat.o(5870);
                    return 5;
                } else if (De.gAs()) {
                    AppMethodBeat.o(5870);
                    return 6;
                } else {
                    AppMethodBeat.o(5870);
                    return 0;
                }
        }
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        r rVar;
        View view2;
        com.tencent.mm.plugin.brandservice.ui.timeline.item.z zVar;
        an anVar;
        ak akVar;
        av avVar;
        aw awVar;
        am amVar;
        boolean z;
        TextView textView;
        View view3 = null;
        AppMethodBeat.i(5871);
        kotlin.g.b.p.h(viewGroup, "parent");
        z De = De(i2);
        if (De == null) {
            View view4 = new View(this.pro);
            AppMethodBeat.o(5871);
            return view4;
        }
        if (i2 == getCount() - 1 && !this.prk) {
            com.tencent.f.h.RTc.aV(new i(this, i2));
        }
        switch (De.field_type) {
            case 1:
                if (view == null) {
                    an anVar2 = new an();
                    view = anVar2.b(this.pro, this);
                    kotlin.g.b.p.g(view, "convertView");
                    view.setTag(anVar2);
                    anVar = anVar2;
                } else {
                    Object tag = view.getTag();
                    if (tag == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineTextItem");
                        AppMethodBeat.o(5871);
                        throw tVar;
                    }
                    anVar = (an) tag;
                }
                anVar.b(De, i2, view);
                view2 = view;
                break;
            case 285212721:
                if (!this.prf) {
                    com.tencent.mm.plugin.brandservice.ui.b.c.w(De);
                }
                if (view == null) {
                    akVar = new ak();
                    view = View.inflate(this.pro, R.layout.jy, null);
                    View findViewById = view.findViewById(R.id.a7s);
                    if (findViewById == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                        AppMethodBeat.o(5871);
                        throw tVar2;
                    }
                    akVar.pxI = (LinearLayout) findViewById;
                    View findViewById2 = view.findViewById(R.id.hr2);
                    if (findViewById2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                        AppMethodBeat.o(5871);
                        throw tVar3;
                    }
                    akVar.pxJ = (LinearLayout) findViewById2;
                    View findViewById3 = view.findViewById(R.id.hr3);
                    if (findViewById3 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type android.widget.TextView");
                        AppMethodBeat.o(5871);
                        throw tVar4;
                    }
                    akVar.pxK = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.a8m);
                    if (findViewById4 == null) {
                        t tVar5 = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                        AppMethodBeat.o(5871);
                        throw tVar5;
                    }
                    akVar.pwz = (LinearLayout) findViewById4;
                    View findViewById5 = view.findViewById(R.id.a8c);
                    if (findViewById5 == null) {
                        t tVar6 = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                        AppMethodBeat.o(5871);
                        throw tVar6;
                    }
                    akVar.pwA = (LinearLayout) findViewById5;
                    akVar.puO = view;
                    akVar.cne();
                    kotlin.g.b.p.g(view, "convertView");
                    view.setTag(akVar);
                } else {
                    Object tag2 = view.getTag();
                    if (tag2 == null) {
                        t tVar7 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineItemHolder");
                        AppMethodBeat.o(5871);
                        throw tVar7;
                    }
                    akVar = (ak) tag2;
                }
                akVar.a(this.pro, this);
                akVar.a(De, i2, view);
                view2 = view;
                break;
            case 620757041:
                if (!this.prf) {
                    com.tencent.mm.plugin.brandservice.ui.b.c.y(De);
                }
                if (view == null) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.item.z zVar2 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.z(this.pro, this);
                    view = zVar2.pwy;
                    view.setTag(zVar2);
                    zVar = zVar2;
                } else {
                    Object tag3 = view.getTag();
                    if (tag3 == null) {
                        t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardNew");
                        AppMethodBeat.o(5871);
                        throw tVar8;
                    }
                    zVar = (com.tencent.mm.plugin.brandservice.ui.timeline.item.z) tag3;
                }
                kotlin.g.b.p.h(De, "info");
                kotlin.g.b.p.h(view, "convertView");
                if (De.gAD() != null) {
                    if (com.tencent.mm.plugin.brandservice.ui.timeline.item.l.CT(De.NQn.style)) {
                        ege ege = De.NQn;
                        kotlin.g.b.p.g(ege, "info.wrapper");
                        if (af.b(ege, De)) {
                            int Di = com.tencent.mm.plugin.brandservice.ui.timeline.item.z.Di(De.NQn.style);
                            Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + De.NQn.style + ", clientShowType = " + Di);
                            b bVar = zVar.psQ;
                            LinearLayout linearLayout = zVar.pwA;
                            kotlin.g.b.p.g(linearLayout, "topLayout");
                            LinearLayout linearLayout2 = zVar.pwz;
                            kotlin.g.b.p.g(linearLayout2, "newTipsLayout");
                            bVar.a(i2, De, linearLayout, linearLayout2);
                            zVar.pwt.hide();
                            zVar.pws.hide();
                            zVar.pwr.hide();
                            zVar.pwu.hide();
                            zVar.pwv.hide();
                            zVar.pww.hide();
                            zVar.pwx.hide();
                            switch (Di) {
                                case 1:
                                    zVar.pwt.b(De, i2, view, zVar.pwy);
                                    break;
                                case 2:
                                    zVar.pwr.a(De, i2, view, zVar.pwy);
                                    break;
                                case 3:
                                    zVar.pws.a(De, i2, view, zVar.pwy);
                                    break;
                                case 4:
                                    zVar.pwu.a(De, i2, view, zVar.pwy);
                                    break;
                                case 5:
                                    zVar.pwv.a(De, i2, view, zVar.pwy);
                                    break;
                                case 6:
                                    zVar.pww.a(De, i2, view, zVar.pwy);
                                    break;
                                case 7:
                                    zVar.pwx.a(De, i2, view, zVar.pwy);
                                    break;
                            }
                        } else {
                            zVar.cnd();
                            Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
                        }
                    } else {
                        zVar.cnd();
                        Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + De.NQn.style + " not support");
                    }
                } else {
                    zVar.cnd();
                    Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
                }
                view2 = view;
                break;
            case 637534257:
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(66);
                com.tencent.mm.storage.r rVar2 = com.tencent.mm.storage.r.NPl;
                if (com.tencent.mm.storage.r.gzL()) {
                    String str = String.valueOf(De.field_msgId) + "_" + De.gAG();
                    if (!De.pvs) {
                        com.tencent.mm.plugin.biz.b.c cVar = com.tencent.mm.plugin.biz.b.c.pfv;
                        if (!com.tencent.mm.plugin.biz.b.c.d(str, view)) {
                            com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                            com.tencent.mm.plugin.webcanvas.l.LV(68);
                            View view5 = new View(this.pro);
                            view5.setVisibility(8);
                            view2 = view5;
                            break;
                        }
                    }
                    De.pvs = true;
                    if (view == null) {
                        rVar = new r(this.pro, this);
                        ViewGroup cmQ = rVar.cmQ();
                        cmQ.setTag(rVar);
                        view = cmQ;
                    } else {
                        Object tag4 = view.getTag();
                        if (tag4 == null) {
                            t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCanvas");
                            AppMethodBeat.o(5871);
                            throw tVar9;
                        }
                        rVar = (r) tag4;
                    }
                    rVar.a(De, i2, view, viewGroup);
                    com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(67);
                    com.tencent.mm.plugin.biz.b.c cVar2 = com.tencent.mm.plugin.biz.b.c.pfv;
                    com.tencent.mm.plugin.biz.b.c.ahj(str);
                    view2 = view;
                    break;
                } else {
                    View view6 = new View(this.pro);
                    view6.setVisibility(8);
                    view2 = view6;
                    break;
                }
            default:
                if (!De.gAr()) {
                    if (!De.gAs()) {
                        if (view == null) {
                            avVar = new av();
                            view = avVar.cU(this.pro);
                            kotlin.g.b.p.g(view, "convertView");
                            view.setTag(avVar);
                        } else {
                            Object tag5 = view.getTag();
                            if (tag5 == null) {
                                t tVar10 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineUnknownItem");
                                AppMethodBeat.o(5871);
                                throw tVar10;
                            }
                            avVar = (av) tag5;
                        }
                        a(avVar, De);
                        LinearLayout linearLayout3 = avVar.pwA;
                        kotlin.g.b.p.g(linearLayout3, "unknownItem.topLayout");
                        LinearLayout linearLayout4 = avVar.pwz;
                        kotlin.g.b.p.g(linearLayout4, "unknownItem.newTipsLayout");
                        a(i2, De, linearLayout3, linearLayout4);
                        view2 = view;
                        break;
                    } else {
                        if (view == null) {
                            aw awVar2 = new aw(this.pro, this);
                            view = awVar2.pwy;
                            view.setTag(awVar2);
                            awVar = awVar2;
                        } else {
                            Object tag6 = view.getTag();
                            if (tag6 == null) {
                                t tVar11 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTlRecFeedCard");
                                AppMethodBeat.o(5871);
                                throw tVar11;
                            }
                            awVar = (aw) tag6;
                        }
                        awVar.c(De, i2, view);
                        De.NQm = this.pqW.indexOf(De);
                        view2 = view;
                        break;
                    }
                } else {
                    if (view == null) {
                        am amVar2 = new am();
                        view = amVar2.cU(this.pro);
                        kotlin.g.b.p.g(view, "convertView");
                        view.setTag(amVar2);
                        amVar = amVar2;
                    } else {
                        Object tag7 = view.getTag();
                        if (tag7 == null) {
                            t tVar12 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineNewMsgLineItem");
                            AppMethodBeat.o(5871);
                            throw tVar12;
                        }
                        amVar = (am) tag7;
                    }
                    if (this.prn) {
                        ProgressBar progressBar = amVar.progressBar;
                        kotlin.g.b.p.g(progressBar, "item.progressBar");
                        progressBar.setVisibility(0);
                    } else {
                        ProgressBar progressBar2 = amVar.progressBar;
                        kotlin.g.b.p.g(progressBar2, "item.progressBar");
                        progressBar2.setVisibility(8);
                    }
                    p.a aVar = com.tencent.mm.model.p.iCa;
                    String decodeString = p.a.aTI().decodeString("RecommendFeedsWording", "");
                    if (decodeString != null) {
                        String str2 = decodeString;
                        if (str2 == null || kotlin.n.n.aL(str2)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z && (textView = amVar.pyd) != null) {
                            textView.setText(decodeString);
                        }
                    }
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnk()) {
                        LinearLayout linearLayout5 = amVar.pyc;
                        kotlin.g.b.p.g(linearLayout5, "item.expandLayout");
                        linearLayout5.setVisibility(8);
                        LinearLayout linearLayout6 = amVar.pyf;
                        kotlin.g.b.p.g(linearLayout6, "item.noMsgLayout");
                        linearLayout6.setVisibility(0);
                        LinearLayout linearLayout7 = amVar.pyf;
                        kotlin.g.b.p.g(linearLayout7, "item.noMsgLayout");
                        LinearLayout linearLayout8 = amVar.pyf;
                        kotlin.g.b.p.g(linearLayout8, "item.noMsgLayout");
                        ViewGroup.LayoutParams layoutParams = linearLayout8.getLayoutParams();
                        if (layoutParams == null) {
                            t tVar13 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            AppMethodBeat.o(5871);
                            throw tVar13;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.topMargin = prC * 5;
                        layoutParams2.bottomMargin = prC * 5;
                        linearLayout7.setLayoutParams(layoutParams2);
                        List<z> list2 = this.nZr;
                        if (list2 == null || list2.isEmpty()) {
                            TextView textView2 = amVar.pyg;
                            kotlin.g.b.p.g(textView2, "item.noMsgTv");
                            textView2.setText(this.pro.getString(R.string.ai6));
                            com.tencent.mm.model.o oVar = com.tencent.mm.model.o.iBV;
                            com.tencent.mm.model.o.Aa(12);
                        } else {
                            TextView textView3 = amVar.pyg;
                            kotlin.g.b.p.g(textView3, "item.noMsgTv");
                            textView3.setText(this.pro.getString(R.string.ai4));
                            com.tencent.mm.model.o oVar2 = com.tencent.mm.model.o.iBV;
                            com.tencent.mm.model.o.Aa(13);
                        }
                    } else {
                        LinearLayout linearLayout9 = amVar.pyc;
                        kotlin.g.b.p.g(linearLayout9, "item.expandLayout");
                        linearLayout9.setVisibility(0);
                        if (this.nZr.size() == 0) {
                            LinearLayout linearLayout10 = amVar.pyf;
                            kotlin.g.b.p.g(linearLayout10, "item.noMsgLayout");
                            LinearLayout linearLayout11 = amVar.pyf;
                            kotlin.g.b.p.g(linearLayout11, "item.noMsgLayout");
                            ViewGroup.LayoutParams layoutParams3 = linearLayout11.getLayoutParams();
                            if (layoutParams3 == null) {
                                t tVar14 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                                AppMethodBeat.o(5871);
                                throw tVar14;
                            }
                            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                            layoutParams4.topMargin = prC * 8;
                            layoutParams4.bottomMargin = prC;
                            linearLayout10.setLayoutParams(layoutParams4);
                            LinearLayout linearLayout12 = amVar.pyf;
                            kotlin.g.b.p.g(linearLayout12, "item.noMsgLayout");
                            linearLayout12.setVisibility(0);
                            TextView textView4 = amVar.pyg;
                            kotlin.g.b.p.g(textView4, "item.noMsgTv");
                            textView4.setText(this.pro.getString(R.string.ai5));
                            com.tencent.mm.model.o oVar3 = com.tencent.mm.model.o.iBV;
                            com.tencent.mm.model.o.Aa(14);
                        } else {
                            LinearLayout linearLayout13 = amVar.pyf;
                            kotlin.g.b.p.g(linearLayout13, "item.noMsgLayout");
                            linearLayout13.setVisibility(8);
                        }
                    }
                    com.tencent.mm.model.o oVar4 = com.tencent.mm.model.o.iBV;
                    com.tencent.mm.model.o.Aa(10);
                    com.tencent.mm.model.o oVar5 = com.tencent.mm.model.o.iBV;
                    com.tencent.mm.model.o.dk(0, i2);
                    amVar.pyc.setOnClickListener(new d(this, i2));
                    view2 = view;
                    break;
                }
                break;
        }
        if (view2 != null) {
            Object tag8 = view2.getTag();
            if (!(tag8 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
                tag8 = null;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.item.a aVar3 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a) tag8;
            if (aVar3 != null) {
                aVar3.psm = De;
                aVar3.position = i2;
            }
            view3 = view2;
        }
        if (!this.prf && !this.dLD) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.b bVar2 = this.pqZ.pst;
            if (bVar2 != null) {
                String id = De.getId();
                kotlin.g.b.p.g(id, "info.id");
                kotlin.g.b.p.h(id, "id");
                bVar2.pyN.put(id, Boolean.TRUE);
            }
            if (De.gAq()) {
                this.pqZ.e(De);
                ahO(De.field_talker);
            }
        }
        AppMethodBeat.o(5871);
        return view3;
    }

    public final void ahO(String str) {
        AppMethodBeat.i(5872);
        if (str == null) {
            AppMethodBeat.o(5872);
            return;
        }
        com.tencent.mm.kernel.a aAf = com.tencent.mm.kernel.g.aAf();
        kotlin.g.b.p.g(aAf, "MMKernel.account()");
        if (aAf.azn() && !this.prg.contains(str)) {
            ab.av(str, 2);
            this.prg.add(str);
        }
        AppMethodBeat.o(5872);
    }

    public final void d(z zVar) {
        AppMethodBeat.i(5873);
        if (zVar == null) {
            Log.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
            AppMethodBeat.o(5873);
            return;
        }
        long gAo = zVar.gAo();
        aa ban = ag.ban();
        kotlin.g.b.p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long gAS = ban.gAS();
        Log.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", Boolean.valueOf(this.prf), Long.valueOf(gAo), Long.valueOf(gAS));
        if (!this.prf && gAo == gAS) {
            long j2 = zVar.field_orderFlag;
            com.tencent.mm.co.g.ey(Long.valueOf(j2)).h(new n(j2)).b(new o(this));
        }
        AppMethodBeat.o(5873);
    }

    private final boolean a(z zVar, int i2) {
        Long l2;
        AppMethodBeat.i(5874);
        if (a.cmx()) {
            AppMethodBeat.o(5874);
            return false;
        } else if (prE != null) {
            Long l3 = prE;
            long j2 = zVar.field_orderFlag;
            if (l3 != null && l3.longValue() == j2) {
                AppMethodBeat.o(5874);
                return true;
            }
            AppMethodBeat.o(5874);
            return false;
        } else {
            long gAo = zVar.gAo();
            long j3 = 0;
            z De = De(i2 - 1);
            if (De != null) {
                j3 = De.gAo();
            }
            if (gAo == j3 || prF == null || (l2 = prF) == null || j3 != l2.longValue()) {
                AppMethodBeat.o(5874);
                return false;
            }
            prE = Long.valueOf(zVar.field_orderFlag);
            AppMethodBeat.o(5874);
            return true;
        }
    }

    public final void a(int i2, z zVar, View view, View view2) {
        AppMethodBeat.i(5875);
        kotlin.g.b.p.h(zVar, "info");
        kotlin.g.b.p.h(view, "topLayout");
        kotlin.g.b.p.h(view2, "newTipsLayout");
        if (i2 > 0) {
            view.setVisibility(0);
            if (a(zVar, i2)) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
                view.setMinimumHeight(prw);
            }
        } else {
            if (this.pro.cmF()) {
                view.setMinimumHeight(prB * 2);
            } else {
                view.setMinimumHeight(prw);
            }
            view.setVisibility(0);
            view2.setVisibility(8);
        }
        d(zVar);
        AppMethodBeat.o(5875);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ b prH;

        d(b bVar, int i2) {
            this.prH = bVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195217);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$fillingNewMsgLine$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.model.o oVar = com.tencent.mm.model.o.iBV;
            com.tencent.mm.model.o.Aa(11);
            com.tencent.mm.model.o oVar2 = com.tencent.mm.model.o.iBV;
            com.tencent.mm.model.o.dk(1, this.gUj);
            b.a(this.prH);
            this.prH.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$fillingNewMsgLine$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195217);
        }
    }

    private final void cmm() {
        AppMethodBeat.i(195240);
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kl(false);
        int size = this.nZr.size();
        if (!cmu()) {
            cms();
            AppMethodBeat.o(195240);
            return;
        }
        if (this.nZr.size() > size) {
            if (size > 0) {
                prE = Long.valueOf(this.nZr.get(size).field_orderFlag);
            }
            cmt();
        }
        AppMethodBeat.o(195240);
    }

    public final void a(v vVar, z zVar, int i2, u uVar, View view, boolean z, int i3) {
        AppMethodBeat.i(5876);
        kotlin.g.b.p.h(vVar, "item");
        kotlin.g.b.p.h(zVar, "info");
        kotlin.g.b.p.h(view, "clickView");
        ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(vVar, zVar, i2, uVar, view, z, i3, this.prj);
        if (vVar.type == 5) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                view.setOnClickListener(new l(this, i3, vVar, zVar));
            }
        }
        AppMethodBeat.o(5876);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ b prH;
        final /* synthetic */ z prL;
        final /* synthetic */ int prT;
        final /* synthetic */ v prU;

        l(b bVar, int i2, v vVar, z zVar) {
            this.prH = bVar;
            this.prT = i2;
            this.prU = vVar;
            this.prL = zVar;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(195234);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$setCommonAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.prT == 0) {
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                MPVideoPreviewMgr.aiJ(this.prU.vid);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            Bundle bundle = new Bundle();
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.prL.field_talker);
            if (Kn == null || Kn.arv()) {
                i2 = 90;
            } else {
                i2 = 157;
            }
            bundle.putInt(e.b.OyQ, i2);
            bundle.putInt(e.b.OyR, this.prH.pro.getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000));
            bundle.putInt("geta8key_scene", 56);
            MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
            bundle.putString("biz_video_autoplay_id", MPVideoPreviewMgr.aiN(this.prU.vid));
            bundle.putString("webpageTitle", this.prU.title);
            com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(this.prU.vid);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(this.prH.pro, this.prL.field_msgId, this.prL.field_msgSvrId, this.prT, bundle);
            this.prH.prj.a(this.prL, this.prT, currentTimeMillis);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$setCommonAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195234);
        }
    }

    public final void a(aj ajVar, z zVar) {
        AppMethodBeat.i(5877);
        kotlin.g.b.p.h(ajVar, "slot");
        kotlin.g.b.p.h(zVar, "info");
        a.b.d(ajVar.gvv, zVar.field_talker);
        String displayName = com.tencent.mm.model.aa.getDisplayName(zVar.field_talker);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(zVar.field_talker);
        if (Kn == null || !Kn.arE()) {
            TextView textView = ajVar.pvG;
            kotlin.g.b.p.g(textView, "slot.nickNameTV");
            TextView textView2 = ajVar.pvG;
            kotlin.g.b.p.g(textView2, "slot.nickNameTV");
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.pro, displayName, textView2.getTextSize()));
        } else {
            Drawable drawable = this.pro.getResources().getDrawable(R.drawable.c0a);
            TextView textView3 = ajVar.pvG;
            kotlin.g.b.p.g(textView3, "slot.nickNameTV");
            int textSize = (int) textView3.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
            SpannableString spannableString = new SpannableString("@");
            spannableString.setSpan(aVar, 0, 1, 33);
            TextView textView4 = ajVar.pvG;
            kotlin.g.b.p.g(textView4, "slot.nickNameTV");
            StringBuilder sb = new StringBuilder();
            TextView textView5 = ajVar.pvG;
            kotlin.g.b.p.g(textView5, "slot.nickNameTV");
            textView4.setText(TextUtils.concat(sb.append(com.tencent.mm.pluginsdk.ui.span.l.b(this.pro, displayName, textView5.getTextSize()).toString()).append("  ").toString(), spannableString));
        }
        com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(ajVar.pvG);
        View view = ajVar.pxF;
        kotlin.g.b.p.g(view, "slot.avatarLL");
        view.setTag(zVar);
        ajVar.pxF.setOnClickListener(this.pri);
        if (com.tencent.mm.storage.ab.gBe()) {
            TextView textView6 = ajVar.timeTV;
            kotlin.g.b.p.g(textView6, "slot.timeTV");
            textView6.setVisibility(0);
            View view2 = ajVar.pxG;
            kotlin.g.b.p.g(view2, "slot.moreLayout");
            view2.setVisibility(8);
            TextView textView7 = ajVar.timeTV;
            kotlin.g.b.p.g(textView7, "slot.timeTV");
            textView7.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.pro, zVar.field_createTime));
            ajVar.pxF.setOnLongClickListener(new f(this, zVar));
            AppMethodBeat.o(5877);
            return;
        }
        TextView textView8 = ajVar.timeTV;
        kotlin.g.b.p.g(textView8, "slot.timeTV");
        textView8.setVisibility(8);
        View view3 = ajVar.pxG;
        kotlin.g.b.p.g(view3, "slot.moreLayout");
        view3.setVisibility(0);
        ajVar.pxF.setOnLongClickListener(null);
        ajVar.pxG.setOnClickListener(new g(this, zVar));
        com.tencent.mm.ui.tools.o.hp(ajVar.pxG);
        AppMethodBeat.o(5877);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class f implements View.OnLongClickListener {
        final /* synthetic */ b prH;
        final /* synthetic */ z prL;

        f(b bVar, z zVar) {
            this.prH = bVar;
            this.prL = zVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195223);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            this.prH.pqY = this.prL;
            this.prH.pqZ.f(this.prH.pqY, 20);
            this.prH.cmn();
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195223);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ b prH;
        final /* synthetic */ z prL;

        g(b bVar, z zVar) {
            this.prH = bVar;
            this.prL = zVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195224);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.prH.pqY = this.prL;
            this.prH.pqZ.f(this.prH.pqY, 19);
            this.prH.cmn();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195224);
        }
    }

    public final void cmn() {
        AppMethodBeat.i(195241);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.pro, 1, false);
        eVar.a(new m(this));
        eVar.a(this.prd);
        eVar.dGm();
        AppMethodBeat.o(195241);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class m implements o.f {
        final /* synthetic */ b prH;

        m(b bVar) {
            this.prH = bVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(195235);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
            z zVar = this.prH.pqY;
            if (zVar == null) {
                kotlin.g.b.p.hyc();
            }
            as Kn = aSN.Kn(zVar.field_talker);
            mVar.kV(10, R.string.ahr);
            if (Kn != null && Kn.arv()) {
                mVar.a(2, this.prH.pro.getResources().getColor(R.color.Red), this.prH.pro.getString(R.string.eur));
            }
            AppMethodBeat.o(195235);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.b$b  reason: collision with other inner class name */
    static final class View$OnClickListenerC0873b implements View.OnClickListener {
        final /* synthetic */ b prH;
        final /* synthetic */ f prI;

        View$OnClickListenerC0873b(b bVar, f fVar) {
            this.prH = bVar;
            this.prI = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195215);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.b.p.g(view, "v");
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.storage.BizTimeLineInfo");
                AppMethodBeat.o(195215);
                throw tVar;
            }
            z zVar = (z) tag;
            String str = zVar.field_talker;
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(zVar.field_talker);
            if (zVar.gAu() || Kn == null || Kn.arv()) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                intent.putExtra("KOpenArticleSceneFromScene", 90);
                intent.putExtra("specific_chat_from_scene", 2);
                intent.putExtra("preChatTYPE", 11);
                com.tencent.mm.br.c.f(this.prH.pro, ".ui.chatting.ChattingUI", intent);
                this.prI.h(zVar);
                com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
                com.tencent.mm.plugin.brandservice.b.c.t(3, str, "");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
                intent2.putExtra("force_get_contact", true);
                intent2.putExtra("key_use_new_contact_profile", true);
                com.tencent.mm.br.c.b(this.prH.pro, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                this.prI.g(zVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195215);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "kotlin.jvm.PlatformType", "pos", "", "clickTime", "onClick"})
    static final class c implements h {
        final /* synthetic */ f prI;
        final /* synthetic */ BizTimeLineHotView prJ;

        c(f fVar, BizTimeLineHotView bizTimeLineHotView) {
            this.prI = fVar;
            this.prJ = bizTimeLineHotView;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.timeline.h
        public final void a(z zVar, int i2, int i3) {
            AppMethodBeat.i(195216);
            this.prI.a(zVar, i2, i3);
            this.prJ.o(zVar);
            AppMethodBeat.o(195216);
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(5878);
        kotlin.g.b.p.h(contextMenu, "menu");
        kotlin.g.b.p.h(view, "v");
        kotlin.g.b.p.h(contextMenuInfo, "menuInfo");
        AppMethodBeat.o(5878);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(5879);
        super.notifyDataSetChanged();
        Log.d("MicroMsg.BizTimeLineAdapter", "notifyDataSetChanged");
        AppMethodBeat.o(5879);
    }

    public final z cmo() {
        AppMethodBeat.i(5880);
        if (this.nZr.size() > 0) {
            z zVar = this.nZr.get(this.nZr.size() - 1);
            AppMethodBeat.o(5880);
            return zVar;
        }
        AppMethodBeat.o(5880);
        return null;
    }

    public final z cmp() {
        AppMethodBeat.i(5881);
        if (this.nZr.size() > 0) {
            z zVar = this.nZr.get(0);
            AppMethodBeat.o(5881);
            return zVar;
        }
        AppMethodBeat.o(5881);
        return null;
    }

    private final void cA(List<? extends z> list2) {
        AppMethodBeat.i(5882);
        Log.d("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d", Integer.valueOf(list2.size()));
        LinkedList linkedList = new LinkedList();
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!b((z) list2.get(i2))) {
                linkedList.add(list2.get(i2));
            }
        }
        this.nZr.addAll(linkedList);
        AppMethodBeat.o(5882);
    }

    public static void cB(List<? extends z> list2) {
        int i2;
        AppMethodBeat.i(5867);
        com.tencent.mm.pluginsdk.ui.applet.g gVar = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1) && !list2.isEmpty()) {
            Log.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", Integer.valueOf(list2.size()));
            long currentTimeMillis = System.currentTimeMillis();
            z zVar = (z) list2.get(0);
            zVar.pxD = 1;
            int size = list2.size();
            int i3 = 1;
            int i4 = 1;
            z zVar2 = zVar;
            while (i3 < size) {
                z zVar3 = (z) list2.get(i3);
                switch (zVar2.field_type) {
                    case 1:
                        i2 = 1;
                        break;
                    case 285212721:
                        i2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).b(zVar2.field_msgId, zVar2.field_content);
                        if (zVar2.field_isExpand) {
                            break;
                        } else {
                            i2 = Math.min(i2, 2);
                            break;
                        }
                    default:
                        i2 = 1;
                        break;
                }
                i4 += i2;
                zVar3.pxD = i4;
                i3++;
                zVar2 = zVar3;
            }
            Log.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), 1, Integer.valueOf(list2.size()));
        }
        AppMethodBeat.o(5867);
    }

    public final void cmq() {
        AppMethodBeat.i(5884);
        z cmp = cmp();
        if (cmp != null) {
            prF = Long.valueOf(cmp.gAo());
        }
        prE = null;
        AppMethodBeat.o(5884);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(5885);
        if (super.isEmpty()) {
            ae bap = ag.bap();
            kotlin.g.b.p.g(bap, "SubCoreBiz.getBizTimeLineSingleMsgStg()");
            if (bap.ctM() > 0) {
                AppMethodBeat.o(5885);
                return false;
            } else if (!com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.cns()) {
                AppMethodBeat.o(5885);
                return false;
            }
        }
        boolean isEmpty = super.isEmpty();
        AppMethodBeat.o(5885);
        return isEmpty;
    }

    private final void cmr() {
        AppMethodBeat.i(5886);
        aa ban = ag.ban();
        kotlin.g.b.p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
        z gAP = ban.gAP();
        if (gAP != null) {
            this.pre = gAP.gAo();
        }
        AppMethodBeat.o(5886);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r4.prn == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void cC(java.util.List<? extends com.tencent.mm.storage.z> r5) {
        /*
            r4 = this;
            r3 = 195242(0x2faaa, float:2.73592E-40)
            r2 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x0012
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0041
        L_0x0012:
            r0 = r2
        L_0x0013:
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a r0 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL
            boolean r0 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnk()
            if (r0 == 0) goto L_0x003d
            boolean r0 = com.tencent.mm.plugin.brandservice.ui.timeline.b.a.cmx()
            if (r0 == 0) goto L_0x003a
            java.util.List<com.tencent.mm.storage.z> r0 = r4.pqW
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x002f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0043
        L_0x002f:
            r0 = r2
        L_0x0030:
            if (r0 == 0) goto L_0x003d
            boolean r0 = r4.prm
            if (r0 != 0) goto L_0x003d
            boolean r0 = r4.prn
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            r4.cms()
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x0041:
            r0 = r1
            goto L_0x0013
        L_0x0043:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.b.cC(java.util.List):void");
    }

    private final void cms() {
        AppMethodBeat.i(195243);
        this.prk = true;
        this.pro.cms();
        AppMethodBeat.o(195243);
    }

    private final void cmt() {
        AppMethodBeat.i(195244);
        this.prk = false;
        this.pro.cmt();
        AppMethodBeat.o(195244);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ b prH;
        final /* synthetic */ int prP;

        i(b bVar, int i2) {
            this.prH = bVar;
            this.prP = i2;
        }

        public final void run() {
            AppMethodBeat.i(195230);
            if (this.prP == this.prH.getCount() - 1 && !this.prH.prk) {
                Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", Integer.valueOf(this.prP), Integer.valueOf(this.prH.getCount()));
                if (!this.prH.cmu()) {
                    b.c(this.prH);
                    AppMethodBeat.o(195230);
                    return;
                }
                a aVar = b.prG;
                if (!a.cmx()) {
                    this.prH.prc.onLoadMore();
                }
            }
            AppMethodBeat.o(195230);
        }
    }

    public final boolean cmu() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(195245);
        if (a.cmx()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnj()) {
                cmw();
                AppMethodBeat.o(195245);
                return true;
            }
        }
        aa ban = ag.ban();
        z cmo = cmo();
        List<z> aU = ban.aU(10, cmo != null ? cmo.field_orderFlag : MAlarmHandler.NEXT_FIRE_INTERVAL);
        if (com.tencent.mm.storage.ab.gBd()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cni()) {
                List<z> list2 = aU;
                if (list2 == null || list2.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && this.prl) {
                    List<z> list3 = this.pqW;
                    if (list3 == null || list3.isEmpty()) {
                        z2 = true;
                    }
                    if (z2) {
                        cmw();
                    }
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kl(true);
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar4 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kn(true);
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar5 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.km(true);
                    notifyDataSetChanged();
                    AppMethodBeat.o(195245);
                    return true;
                }
            }
        }
        if (a.cmx()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar6 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnj()) {
                List<z> list4 = aU;
                if (!(list4 == null || list4.isEmpty())) {
                    z zVar = aU.get(aU.size() - 1);
                    kotlin.g.b.p.g(zVar, "list[list.size - 1]");
                    long gAo = zVar.gAo();
                    z cmp = cmp();
                    if (cmp != null && gAo == cmp.gAo()) {
                        p.a aVar7 = com.tencent.mm.model.p.iCa;
                        int aTH = p.a.aTH();
                        if (aU.size() + this.nZr.size() >= aTH) {
                            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar8 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.km(true);
                            aU = kotlin.a.j.b(aU, aTH - this.nZr.size());
                        }
                    }
                }
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar9 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a.km(true);
            }
        }
        kotlin.g.b.p.g(aU, "list");
        cA(aU);
        com.tencent.mm.plugin.brandservice.ui.b.c.a(aU, new j(this));
        notifyDataSetChanged();
        if (aU.size() > 0) {
            AppMethodBeat.o(195245);
            return true;
        }
        AppMethodBeat.o(195245);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ b prH;

        j(b bVar) {
            this.prH = bVar;
        }

        public final void run() {
            AppMethodBeat.i(195231);
            b.a(this.prH, this.prH.nZr);
            AppMethodBeat.o(195231);
        }
    }

    private final void cD(List<? extends dkr> list2) {
        AppMethodBeat.i(195246);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            z zVar = new z();
            zVar.dDG = 2;
            zVar.NQr = it.next();
            p.a aVar = com.tencent.mm.model.p.iCa;
            zVar.field_orderFlag = com.tencent.mm.model.p.iBY.incrementAndGet();
            this.pqW.add(zVar);
        }
        List<z> list3 = this.pqW;
        if (!(list3 == null || list3.isEmpty()) && this.prk) {
            cmt();
        }
        notifyDataSetChanged();
        AppMethodBeat.o(195246);
    }

    private final void cmv() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(195247);
        if (!com.tencent.mm.storage.ab.gBd()) {
            AppMethodBeat.o(195247);
            return;
        }
        if (!this.prp) {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kl(true);
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.km(this.list.size() < 10);
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
            aa ban = ag.ban();
            kotlin.g.b.p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
            if (ban.getCount() <= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kn(z3);
        } else {
            p.a aVar4 = com.tencent.mm.model.p.iCa;
            List<z> list2 = com.tencent.mm.model.p.iBX;
            List<z> list3 = list2;
            if (list3 == null || list3.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.pqW = list2;
                AppMethodBeat.o(195247);
                return;
            }
        }
        z.a aVar5 = new z.a();
        aVar5.SYB = false;
        p.a aVar6 = com.tencent.mm.model.p.iCa;
        bub aTJ = p.a.aTJ();
        if (aTJ != null) {
            LinkedList<dkr> linkedList = aTJ.MaI;
            LinkedList<dkr> linkedList2 = linkedList;
            if (linkedList2 == null || linkedList2.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                cD(linkedList);
                Log.i("MicroMsg.BizTimeLineAdapter", "initRecommendFeeds use save data");
            } else {
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar7 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kl(false);
                aVar5.SYB = true;
            }
        }
        com.tencent.f.h.RTc.b(new h(this, aVar5), "GetRecommendFeeds");
        AppMethodBeat.o(195247);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ b prH;
        final /* synthetic */ z.a prM;

        h(b bVar, z.a aVar) {
            this.prH = bVar;
            this.prM = aVar;
        }

        public final void run() {
            AppMethodBeat.i(259599);
            kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.b.h.AnonymousClass1 */
                Object L$0;
                int label;
                private ai p$;
                final /* synthetic */ h prN;

                {
                    this.prN = r2;
                }

                @Override // kotlin.d.b.a.a
                public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                    AppMethodBeat.i(259597);
                    kotlin.g.b.p.h(dVar, "completion");
                    AnonymousClass1 r0 = 

                    /* access modifiers changed from: package-private */
                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
                    public static final class e implements Runnable {
                        final /* synthetic */ b prH;

                        e(b bVar) {
                            this.prH = bVar;
                        }

                        public final void run() {
                            AppMethodBeat.i(259593);
                            if (this.prH.prm || this.prH.prn || !this.prH.prl) {
                                if (!this.prH.prl) {
                                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.b.e.AnonymousClass1 */
                                        final /* synthetic */ e prK;

                                        {
                                            this.prK = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // kotlin.g.a.a
                                        public final /* synthetic */ x invoke() {
                                            AppMethodBeat.i(195218);
                                            b.c(this.prK.prH);
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(195218);
                                            return xVar;
                                        }
                                    });
                                }
                                AppMethodBeat.o(259593);
                                return;
                            }
                            this.prH.prm = true;
                            kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                                /* class com.tencent.mm.plugin.brandservice.ui.timeline.b.e.AnonymousClass2 */
                                Object L$0;
                                int label;
                                private ai p$;
                                final /* synthetic */ e prK;

                                {
                                    this.prK = r2;
                                }

                                @Override // kotlin.d.b.a.a
                                public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                    AppMethodBeat.i(259591);
                                    kotlin.g.b.p.h(dVar, "completion");
                                    AnonymousClass2 r0 = 

                                    private final void cmw() {
                                        AppMethodBeat.i(195248);
                                        com.tencent.f.h.RTc.b(new e(this), "GetRecommendFeeds");
                                        AppMethodBeat.o(195248);
                                    }

                                    public final void fc(int i2, int i3) {
                                        AppMethodBeat.i(5887);
                                        ArrayList arrayList = new ArrayList();
                                        if (i2 <= i3) {
                                            while (true) {
                                                com.tencent.mm.storage.z De = De(i2);
                                                if (De != null && De.field_type == 285212721) {
                                                    Log.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + De.field_msgId);
                                                    String[] strArr = new String[3];
                                                    strArr[0] = String.valueOf(De.field_msgId);
                                                    String str = De.field_content;
                                                    kotlin.g.b.p.g(str, "info.field_content");
                                                    strArr[1] = str;
                                                    strArr[2] = De.field_isExpand ? "-1" : "2";
                                                    arrayList.add(strArr);
                                                }
                                                if (i2 == i3) {
                                                    break;
                                                }
                                                i2++;
                                            }
                                        }
                                        if (arrayList.size() > 0) {
                                            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).k(arrayList, 90);
                                        }
                                        AppMethodBeat.o(5887);
                                    }

                                    public final void b(com.tencent.mm.storage.z zVar, int i2) {
                                        AppMethodBeat.i(195249);
                                        this.pqZ.a(zVar, i2, (int) (System.currentTimeMillis() / 1000));
                                        AppMethodBeat.o(195249);
                                    }

                                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$Companion;", "", "()V", "TAG", "", "coverHeight", "", "coverHeightForPicAndVideo", "coverHeightForRecFeed", "coverHeightForRecFeedPicAndVideo", "itemLineBigPadding", "itemLineNormalPadding", "maxGroupId", "", "Ljava/lang/Long;", "newMsgOrderFlag", "padding2DP", "padding40", "padding8DP", "paddingBig", "paddingMiddle", "paddingNormal", "paddingSmall", "getPaddingSmall", "()I", "setPaddingSmall", "(I)V", "showRecFeeds", "", "getShowRecFeeds", "()Z", "subItemPicSize", "plugin-brandservice_release"})
                                    public static final class a {
                                        private a() {
                                        }

                                        public /* synthetic */ a(byte b2) {
                                            this();
                                        }

                                        public static boolean cmx() {
                                            AppMethodBeat.i(195214);
                                            if (com.tencent.mm.storage.ab.gBd()) {
                                                com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                                                if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cni()) {
                                                    AppMethodBeat.o(195214);
                                                    return true;
                                                }
                                            }
                                            AppMethodBeat.o(195214);
                                            return false;
                                        }
                                    }

                                    /* access modifiers changed from: package-private */
                                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)Z"})
                                    public static final class n<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
                                        final /* synthetic */ long prV;

                                        n(long j2) {
                                            this.prV = j2;
                                        }

                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Object call(Object obj) {
                                            AppMethodBeat.i(195236);
                                            Boolean valueOf = Boolean.valueOf(com.tencent.mm.storage.ab.Nb(this.prV));
                                            AppMethodBeat.o(195236);
                                            return valueOf;
                                        }
                                    }

                                    public static final /* synthetic */ void e(b bVar) {
                                        AppMethodBeat.i(195255);
                                        List<com.tencent.mm.storage.z> list2 = bVar.pqW;
                                        if (list2 == null || list2.isEmpty()) {
                                            Log.w("MicroMsg.BizTimeLineAdapter", "onGetRecommendFeedFail mRecList is empty");
                                            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                                            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.kl(false);
                                        } else {
                                            com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                                            if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cnj()) {
                                                bVar.cms();
                                            }
                                        }
                                        bVar.notifyDataSetChanged();
                                        AppMethodBeat.o(195255);
                                    }

                                    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c7  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public static final /* synthetic */ void a(com.tencent.mm.plugin.brandservice.ui.timeline.b r12, com.tencent.mm.storage.aa.a r13) {
                                        /*
                                        // Method dump skipped, instructions count: 883
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.b.a(com.tencent.mm.plugin.brandservice.ui.timeline.b, com.tencent.mm.storage.aa$a):void");
                                    }
                                }

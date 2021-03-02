package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.d.d;
import com.tencent.mm.plugin.textstatus.f.k;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u0000 Æ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004Æ\u0001Ç\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\\H\u0016J\t\u0010\u0001\u001a\u00020\u000bH\u0016J\t\u0010 \u0001\u001a\u00020\u001cH\u0016J\n\u0010¡\u0001\u001a\u00030\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u0001H\u0002J\"\u0010£\u0001\u001a\u00030\u00012\u0006\u0010B\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010|\u001a\u00020cH\u0003J\n\u0010¤\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010¥\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000203H\u0003J\t\u0010¦\u0001\u001a\u00020\\H\u0002J\u0015\u0010§\u0001\u001a\u00030\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u0013\u0010©\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010«\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010¬\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u000bH\u0016J\n\u0010­\u0001\u001a\u00030\u0001H\u0016J\n\u0010®\u0001\u001a\u00030\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020\\H\u0016J\n\u0010²\u0001\u001a\u00030\u0001H\u0016J\n\u0010³\u0001\u001a\u00030\u0001H\u0016J3\u0010´\u0001\u001a\u00030\u00012\u0007\u0010µ\u0001\u001a\u00020\u000b2\u0007\u0010¶\u0001\u001a\u00020\u000b2\t\u0010·\u0001\u001a\u0004\u0018\u0001032\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\n\u0010º\u0001\u001a\u00030\u0001H\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0016J\n\u0010¼\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010½\u0001\u001a\u00030\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\n\u0010À\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010Á\u0001\u001a\u00030\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u001fH\u0016J\u0015\u0010Ã\u0001\u001a\u00030\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\u0015\u0010Ä\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u000103H\u0016J\b\u0010Å\u0001\u001a\u00030\u0001R\u001a\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010&\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00107\"\u0004\bA\u00109R\u001a\u0010B\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R6\u0010a\u001a\u001e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0bj\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d`eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010q\u001a\u00020cX.¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010s\"\u0004\bx\u0010uR\u001c\u0010y\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010s\"\u0004\b{\u0010uR\u001a\u0010|\u001a\u00020cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010s\"\u0004\b~\u0010uR\u001c\u0010\u001a\u00020cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001d\u0010\u0001\u001a\u00020cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001d\u0010\u0001\u001a\u00020cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001d\u0010\u0001\u001a\u00020cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001f\u0010\u0001\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001f\u0010\u0001\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR\u001f\u0010\u0001\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010s\"\u0005\b\u0001\u0010uR!\u0010\u0001\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017¨\u0006È\u0001"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "backgroundId", "getBackgroundId", "()I", "setBackgroundId", "(I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconAvatarNotifyNoStatus", "getIconAvatarNotifyNoStatus", "setIconAvatarNotifyNoStatus", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivRealAddStatus", "getIvRealAddStatus", "setIvRealAddStatus", "lastExposedSessionId", "", "lastStatusId", "layoutAddStatus", "getLayoutAddStatus", "()Landroid/view/View;", "setLayoutAddStatus", "(Landroid/view/View;)V", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutNoStatus", "getLayoutNoStatus", "setLayoutNoStatus", "layoutNotify", "getLayoutNotify", "()Landroid/widget/LinearLayout;", "setLayoutNotify", "(Landroid/widget/LinearLayout;)V", "layoutNotifyNoStatus", "getLayoutNotifyNoStatus", "setLayoutNotifyNoStatus", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "moreTabState", "Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "getMoreTabState", "()Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "setMoreTabState", "(Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;)V", "needUpdateBack", "", "getNeedUpdateBack", "()Z", "setNeedUpdateBack", "(Z)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvAddStatus", "getTvAddStatus", "()Landroid/widget/TextView;", "setTvAddStatus", "(Landroid/widget/TextView;)V", "tvChatCount", "getTvChatCount", "setTvChatCount", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvDescNotifyNoStatus", "getTvDescNotifyNoStatus", "setTvDescNotifyNoStatus", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNew", "getTvNew", "setTvNew", "tvNewInvisible", "getTvNewInvisible", "setTvNewInvisible", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", ch.COL_USERNAME, "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "fixLayout", "", "loadRes", "getLayoutId", "getView", "goDetail", "handleAddStatus", "handleNotify", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initData", "isSelf", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "resumeNormalHeader", "setEventListener", "l", "setItemClickListener", "update", "updateNewTips", "Companion", "MoreTabState", "plugin-textstatus_release"})
public final class d implements View.OnClickListener, com.tencent.mm.ak.i, com.tencent.mm.plugin.textstatus.a.d {
    public static final a Gdb = new a((byte) 0);
    private static final String TAG = TAG;
    private f.a FXT;
    private TextView FYd;
    private TextView FYe;
    private TextView FYg;
    private ImageView FYh;
    private TextView FYj;
    private ImageView FYo;
    private ImageView FYp;
    private TextView FYq;
    com.tencent.mm.plugin.textstatus.f.f.a FYx;
    private RelativeLayout GcI;
    private ImageView GcJ;
    public View GcK;
    public TextView GcL;
    View GcM;
    ImageView GcN;
    private ImageView GcO;
    private TextView GcP;
    LinearLayout GcQ;
    private ImageView GcR;
    private TextView GcS;
    LinearLayout GcT;
    private TextView GcU;
    private com.tencent.mm.plugin.textstatus.d.c GcV;
    private HashMap<TextView, ColorStateList> GcW;
    private b GcX;
    private final LinearLayout GcZ;
    private final int Gda = 0;
    private TextView VeL;
    boolean VeM;
    private String VeN;
    private String VeO;
    private View.OnClickListener dec;
    q gut;
    private final RelativeLayout hOX;
    int jLt;
    Context mContext;
    private String sessionId;
    private final View tlx;
    private String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "", "(Ljava/lang/String;I)V", "ADD", "NORMAL", "plugin-textstatus_release"})
    public enum b {
        ADD,
        NORMAL;

        static {
            AppMethodBeat.i(216371);
            AppMethodBeat.o(216371);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(216373);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(216373);
            return bVar;
        }
    }

    public d(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout) {
        p.h(context, "context");
        AppMethodBeat.i(216396);
        this.hOX = relativeLayout;
        this.GcZ = linearLayout;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c2n, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(cont…tLayoutId(), null, false)");
        this.tlx = inflate;
        this.mContext = context;
        this.GcW = new HashMap<>();
        this.jLt = R.drawable.bv3;
        this.VeM = true;
        com.tencent.mm.plugin.textstatus.d.e eVar = com.tencent.mm.plugin.textstatus.d.e.FYH;
        this.GcV = com.tencent.mm.plugin.textstatus.d.e.fvR();
        this.GcV.ba(this.tlx);
        this.FYd = (TextView) this.tlx.findViewById(R.id.iyr);
        this.FYg = (TextView) this.tlx.findViewById(R.id.iyd);
        this.FYe = (TextView) this.tlx.findViewById(R.id.ix3);
        this.FYj = (TextView) this.tlx.findViewById(R.id.iy7);
        this.GcJ = (ImageView) this.tlx.findViewById(R.id.aeu);
        View findViewById = this.tlx.findViewById(R.id.aew);
        p.g(findViewById, "cardView.findViewById(R.id.btn_like)");
        this.FYo = (ImageView) findViewById;
        this.FYp = (ImageView) this.tlx.findViewById(R.id.du8);
        View findViewById2 = this.tlx.findViewById(R.id.dtg);
        p.g(findViewById2, "cardView.findViewById(R.id.icon_avatar_notify)");
        this.GcO = (ImageView) findViewById2;
        View findViewById3 = this.tlx.findViewById(R.id.ix4);
        p.g(findViewById3, "cardView.findViewById(R.id.tv_desc_notify)");
        this.GcP = (TextView) findViewById3;
        View findViewById4 = this.tlx.findViewById(R.id.e_1);
        p.g(findViewById4, "cardView.findViewById(R.id.layout_notify)");
        this.GcQ = (LinearLayout) findViewById4;
        View findViewById5 = this.tlx.findViewById(R.id.dth);
        p.g(findViewById5, "cardView.findViewById(R.…_avatar_notify_no_status)");
        this.GcR = (ImageView) findViewById5;
        View findViewById6 = this.tlx.findViewById(R.id.ix5);
        p.g(findViewById6, "cardView.findViewById(R.…tv_desc_notify_no_status)");
        this.GcS = (TextView) findViewById6;
        View findViewById7 = this.tlx.findViewById(R.id.e_2);
        p.g(findViewById7, "cardView.findViewById(R.….layout_notify_no_status)");
        this.GcT = (LinearLayout) findViewById7;
        View findViewById8 = this.tlx.findViewById(R.id.ixv);
        p.g(findViewById8, "cardView.findViewById(R.id.tv_like_num)");
        this.FYq = (TextView) findViewById8;
        View findViewById9 = this.tlx.findViewById(R.id.iy3);
        p.g(findViewById9, "cardView.findViewById(R.id.tv_new)");
        this.GcU = (TextView) findViewById9;
        View findViewById10 = this.tlx.findViewById(R.id.k2x);
        p.g(findViewById10, "cardView.findViewById(R.id.tv_new_invisible)");
        this.VeL = (TextView) findViewById10;
        this.FYh = (ImageView) this.tlx.findViewById(R.id.j23);
        this.GcI = (RelativeLayout) this.tlx.findViewById(R.id.e9s);
        View findViewById11 = this.tlx.findViewById(R.id.e_0);
        p.g(findViewById11, "cardView.findViewById(R.id.layout_no_status)");
        this.GcK = findViewById11;
        View findViewById12 = this.tlx.findViewById(R.id.iwj);
        p.g(findViewById12, "cardView.findViewById(R.id.tv_add_status)");
        this.GcL = (TextView) findViewById12;
        this.GcM = this.tlx.findViewById(R.id.e9l);
        this.GcN = (ImageView) this.tlx.findViewById(R.id.e4x);
        com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        com.tencent.mm.plugin.textstatus.j.f.B(this.GcO, (float) com.tencent.mm.cb.a.fromDPToPix(context, 10.0f));
        com.tencent.mm.plugin.textstatus.j.f fVar2 = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        com.tencent.mm.plugin.textstatus.j.f.B(this.GcR, (float) com.tencent.mm.cb.a.fromDPToPix(context, 10.0f));
        this.tlx.setOnClickListener(this);
        c cVar = new c(this);
        ImageView imageView = this.GcN;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        View view = this.GcM;
        if (view != null) {
            view.setOnClickListener(cVar);
        }
        this.GcX = b.ADD;
        this.sessionId = "";
        this.VeN = "";
        this.VeO = "";
        AppMethodBeat.o(216396);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216397);
        AppMethodBeat.o(216397);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ d Gdf;

        c(d dVar) {
            this.Gdf = dVar;
        }

        public final void onClick(View view) {
            long j2;
            AppMethodBeat.i(216374);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            m mVar = new m();
            if (com.tencent.mm.plugin.textstatus.a.p.fvF()) {
                ImageView imageView = this.Gdf.GcN;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                View view2 = this.Gdf.GcM;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_DEFAULT_BACKGROUND_ID", this.Gdf.jLt);
            mVar.sessionId = this.Gdf.sessionId;
            if (this.Gdf.FYx == null) {
                j2 = 3;
            } else {
                j2 = 4;
            }
            mVar.VdK = j2;
            bundle.putByteArray("SET_TEXT_PARAMS", mVar.toByteArray());
            TextStatusDoWhatActivity.a aVar = TextStatusDoWhatActivity.GdF;
            TextStatusDoWhatActivity.a.g(this.Gdf.mContext, bundle);
            this.Gdf.VeM = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216374);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ d Gdf;

        i(d dVar) {
            this.Gdf = dVar;
        }

        public final void run() {
            AppMethodBeat.i(258442);
            d.a(this.Gdf);
            AppMethodBeat.o(258442);
        }
    }

    private final void fwk() {
        WeImageView weImageView;
        WeImageView weImageView2;
        TextView textView;
        NoMeasuredTextView noMeasuredTextView;
        AppMethodBeat.i(216379);
        LinearLayout linearLayout = this.GcZ;
        if (!(linearLayout == null || (noMeasuredTextView = (NoMeasuredTextView) linearLayout.findViewById(R.id.fz_)) == null)) {
            noMeasuredTextView.setTextColor(this.mContext.getResources().getColor(R.color.FG_0));
        }
        LinearLayout linearLayout2 = this.GcZ;
        if (!(linearLayout2 == null || (textView = (TextView) linearLayout2.findViewById(R.id.j1l)) == null)) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.FG_1));
            textView.setAlpha(1.0f);
        }
        LinearLayout linearLayout3 = this.GcZ;
        if (!(linearLayout3 == null || (weImageView2 = (WeImageView) linearLayout3.findViewById(R.id.gny)) == null)) {
            weImageView2.setIconColor(this.mContext.getResources().getColor(R.color.FG_1));
        }
        LinearLayout linearLayout4 = this.GcZ;
        if (linearLayout4 == null || (weImageView = (WeImageView) linearLayout4.findViewById(R.id.uk)) == null) {
            AppMethodBeat.o(216379);
            return;
        }
        weImageView.setIconColor(this.mContext.getResources().getColor(R.color.FG_2));
        AppMethodBeat.o(216379);
    }

    @SuppressLint({"ResourceType"})
    private final void a(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        String string;
        com.tencent.mm.plugin.textstatus.f.f.b bVar = null;
        AppMethodBeat.i(216380);
        if (p.j(com.tencent.mm.plugin.auth.a.a.ceA(), this.username)) {
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            int ctM = com.tencent.mm.plugin.textstatus.b.f.fvN().ctM();
            if (ctM > 0) {
                com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                Cursor rawQuery = com.tencent.mm.plugin.textstatus.b.f.fvN().db.rawQuery("select rowid, * from TextStatusLike order by CreateTime DESC LIMIT 1", null);
                p.g(rawQuery, "db.rawQuery(sql, null)");
                if (rawQuery != null) {
                    bVar = new com.tencent.mm.plugin.textstatus.f.f.b();
                    if (rawQuery.moveToNext()) {
                        bVar.convertFrom(rawQuery);
                    }
                    rawQuery.close();
                }
                if (bVar != null) {
                    com.tencent.mm.plugin.textstatus.b.f fVar3 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                    as aTn = com.tencent.mm.plugin.textstatus.b.f.fvO().aTn(bVar.field_HashUserName);
                    if (aTn == null || !aTn.arv()) {
                        imageView.setImageResource(R.raw.default_avatar);
                    } else {
                        a.b.c(imageView, aTn.getUsername());
                    }
                }
                if (ctM < 99) {
                    string = this.mContext.getString(R.string.hnm, Integer.valueOf(ctM));
                } else {
                    string = this.mContext.getString(R.string.hnn);
                }
                p.g(string, "if(unreadCnt < 99){\n    …o_many)\n                }");
                textView.setText(string);
                linearLayout.setVisibility(0);
                linearLayout.post(new RunnableC1828d(this, linearLayout, ctM));
                SecDataUIC.a aVar = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
                if (yVar != null) {
                    yVar.VdV = ctM;
                }
                linearLayout.setOnClickListener(new g(this, ctM));
                AppMethodBeat.o(216380);
                return;
            }
        }
        linearLayout.setVisibility(8);
        AppMethodBeat.o(216380);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.textstatus.ui.d$d  reason: collision with other inner class name */
    public static final class RunnableC1828d implements Runnable {
        final /* synthetic */ d Gdf;
        final /* synthetic */ LinearLayout VeP;
        final /* synthetic */ int VeQ;

        RunnableC1828d(d dVar, LinearLayout linearLayout, int i2) {
            this.Gdf = dVar;
            this.VeP = linearLayout;
            this.VeQ = i2;
        }

        public final void run() {
            AppMethodBeat.i(258439);
            try {
                if (this.VeP.getGlobalVisibleRect(new Rect())) {
                    com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.h(9, String.valueOf(this.VeQ), this.Gdf.sessionId);
                    AppMethodBeat.o(258439);
                    return;
                }
            } catch (Throwable th) {
                Log.printErrStackTrace(d.TAG, th, "[expose notify]err", new Object[0]);
            }
            AppMethodBeat.o(258439);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ d Gdf;
        final /* synthetic */ int VeQ;

        g(d dVar, int i2) {
            this.Gdf = dVar;
            this.VeQ = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258440);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusLikeListActivity.b bVar2 = TextStatusLikeListActivity.Gfx;
            TextStatusLikeListActivity.b.hs(this.Gdf.mContext);
            this.Gdf.GcQ.setVisibility(8);
            this.Gdf.GcT.setVisibility(8);
            com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.h(10, String.valueOf(this.VeQ), this.Gdf.sessionId);
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar3 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(41, String.valueOf(this.VeQ), yVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258440);
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final View getView() {
        return this.tlx;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.j
    public final void DV(String str) {
        ViewGroup.LayoutParams layoutParams;
        WeImageView weImageView;
        WeImageView weImageView2;
        NoMeasuredTextView noMeasuredTextView;
        TextView textView;
        String str2;
        ViewGroup.LayoutParams layoutParams2;
        String str3 = null;
        AppMethodBeat.i(216381);
        Log.i(TAG, "[update] username:%s", str);
        String str4 = str;
        if (str4 == null || n.aL(str4)) {
            AppMethodBeat.o(216381);
            return;
        }
        new k.e(str, this);
        this.username = str;
        new k.e(str, this);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar != null) {
            com.tencent.mm.plugin.textstatus.f.f.a aVar2 = this.FYx;
            if (!TextUtils.equals(aVar2 != null ? aVar2.field_StatusID : null, this.VeO)) {
                yVar.sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
            }
            String str5 = yVar.sessionId;
            p.g(str5, "it.sessionId");
            this.sessionId = str5;
            yVar.username = str;
            yVar.VdU = 5;
        }
        this.GcV.a(new d.a(false));
        boolean aNc = this.GcV.aNc(str);
        if (!aNc) {
            LinearLayout linearLayout = this.GcZ;
            if (linearLayout != null) {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
            }
            this.tlx.getLayoutParams().height = -2;
            RelativeLayout relativeLayout = this.hOX;
            if (!(relativeLayout == null || (layoutParams2 = relativeLayout.getLayoutParams()) == null)) {
                layoutParams2.height = -2;
            }
        } else {
            int i2 = ah.jS(this.mContext).width;
            RelativeLayout relativeLayout2 = this.hOX;
            if (!(relativeLayout2 == null || (layoutParams = relativeLayout2.getLayoutParams()) == null)) {
                layoutParams.height = i2;
            }
            RelativeLayout relativeLayout3 = this.hOX;
            if (relativeLayout3 != null) {
                RelativeLayout relativeLayout4 = this.hOX;
                relativeLayout3.setLayoutParams(relativeLayout4 != null ? relativeLayout4.getLayoutParams() : null);
            }
            LinearLayout linearLayout2 = this.GcZ;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
            }
        }
        if (!aNc) {
            RelativeLayout relativeLayout5 = this.GcI;
            if (relativeLayout5 != null) {
                relativeLayout5.setVisibility(8);
            }
            ImageView imageView = this.FYh;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            View view = this.GcK;
            if (view == null) {
                p.btv("layoutNoStatus");
            }
            view.setVisibility(0);
            fwk();
            if (com.tencent.mm.plugin.textstatus.a.p.fvF()) {
                this.GcU.setVisibility(0);
                this.VeL.setVisibility(4);
                com.tencent.mm.plugin.textstatus.k.a aVar3 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(19, (String) null, (String) null, 6);
            } else {
                this.GcU.setVisibility(8);
                this.VeL.setVisibility(8);
            }
            this.tlx.post(new i(this));
            this.GcX = b.ADD;
        } else {
            RelativeLayout relativeLayout6 = this.GcI;
            if (relativeLayout6 != null) {
                relativeLayout6.setVisibility(0);
            }
            ImageView imageView2 = this.FYh;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View view2 = this.GcK;
            if (view2 == null) {
                p.btv("layoutNoStatus");
            }
            view2.setVisibility(8);
            LinearLayout linearLayout3 = this.GcZ;
            if (!(linearLayout3 == null || (textView = (TextView) linearLayout3.findViewById(R.id.j1l)) == null)) {
                textView.setTextColor(-1);
                textView.setAlpha(0.6f);
            }
            LinearLayout linearLayout4 = this.GcZ;
            if (!(linearLayout4 == null || (noMeasuredTextView = (NoMeasuredTextView) linearLayout4.findViewById(R.id.fz_)) == null)) {
                noMeasuredTextView.setTextColor(-1);
            }
            LinearLayout linearLayout5 = this.GcZ;
            if (!(linearLayout5 == null || (weImageView2 = (WeImageView) linearLayout5.findViewById(R.id.gny)) == null)) {
                weImageView2.setIconColor(-1);
            }
            LinearLayout linearLayout6 = this.GcZ;
            if (!(linearLayout6 == null || (weImageView = (WeImageView) linearLayout6.findViewById(R.id.uk)) == null)) {
                weImageView.setIconColor(-1);
            }
            this.GcX = b.NORMAL;
        }
        if (this.GcX == b.ADD) {
            a(this.GcT, this.GcR, this.GcS);
        } else {
            a(this.GcQ, this.GcO, this.GcP);
        }
        com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        com.tencent.mm.plugin.textstatus.f.f.a aVar4 = this.FYx;
        if (aVar4 != null) {
            str3 = aVar4.field_IconID;
        }
        String name = com.tencent.mm.plugin.textstatus.j.b.getName(str3);
        TextView textView2 = this.FYd;
        if (textView2 != null) {
            textView2.setText(this.mContext.getString(R.string.hnv) + name);
        }
        SecDataUIC.a aVar5 = SecDataUIC.CWq;
        y yVar2 = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar2 == null || TextUtils.equals(yVar2.sessionId, this.VeN)) {
            AppMethodBeat.o(216381);
            return;
        }
        com.tencent.mm.plugin.textstatus.k.a aVar6 = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.a(1, yVar2);
        String str6 = yVar2.sessionId;
        p.g(str6, "it.sessionId");
        this.VeN = str6;
        com.tencent.mm.plugin.textstatus.f.f.a aVar7 = this.FYx;
        if (aVar7 == null || (str2 = aVar7.field_StatusID) == null) {
            str2 = "";
        }
        this.VeO = str2;
        com.tencent.mm.plugin.textstatus.k.a aVar8 = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.a(yVar2);
        AppMethodBeat.o(216381);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvv() {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(216382);
        fwk();
        RelativeLayout relativeLayout = this.hOX;
        if (relativeLayout != null) {
            relativeLayout.removeView(this.tlx);
        }
        RelativeLayout relativeLayout2 = this.hOX;
        if (!(relativeLayout2 == null || (layoutParams = relativeLayout2.getLayoutParams()) == null)) {
            layoutParams.height = -2;
        }
        LinearLayout linearLayout = this.GcZ;
        if (linearLayout != null) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 40));
            AppMethodBeat.o(216382);
            return;
        }
        AppMethodBeat.o(216382);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvw() {
        AppMethodBeat.i(216383);
        DV(this.username);
        AppMethodBeat.o(216383);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvx() {
        AppMethodBeat.i(216384);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216384);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.l
    public final void cd(float f2) {
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final void f(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final void a(f.a aVar) {
        this.FXT = aVar;
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostOpen(boolean z) {
        AppMethodBeat.i(216385);
        this.GcV.onPostOpen(z);
        AppMethodBeat.o(216385);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostClose() {
        AppMethodBeat.i(216386);
        this.GcV.onPostClose();
        AppMethodBeat.o(216386);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEk() {
        AppMethodBeat.i(216387);
        com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.a(17, "1", (String) null, 4);
        this.GcV.eEk();
        AppMethodBeat.o(216387);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEl() {
        AppMethodBeat.i(216388);
        this.GcV.eEl();
        AppMethodBeat.o(216388);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEm() {
        AppMethodBeat.i(216389);
        this.GcV.eEm();
        AppMethodBeat.o(216389);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEn() {
        AppMethodBeat.i(216390);
        this.GcV.eEn();
        AppMethodBeat.o(216390);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UC(int i2) {
        AppMethodBeat.i(216391);
        this.GcV.UC(i2);
        AppMethodBeat.o(216391);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UD(int i2) {
        AppMethodBeat.i(216392);
        this.GcV.UD(i2);
        AppMethodBeat.o(216392);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UE(int i2) {
        AppMethodBeat.i(216393);
        this.GcV.UE(i2);
        AppMethodBeat.o(216393);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(216394);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        View.OnClickListener onClickListener = this.dec;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.iko && TextUtils.equals(this.username, com.tencent.mm.plugin.auth.a.a.ceA()) && this.GcX != b.ADD) {
            com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.mContext);
            lVar.a(new e(this));
            lVar.a(new f(this));
            lVar.a(new h(this));
            lVar.gXI();
            SecDataUIC.a aVar = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(31, yVar);
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e implements o.f {
        final /* synthetic */ d Gdf;

        e(d dVar) {
            this.Gdf = dVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(216376);
            mVar.d(R.id.fdj, this.Gdf.mContext.getString(R.string.hns));
            mVar.d(R.id.fd6, this.Gdf.mContext.getString(R.string.hnc));
            AppMethodBeat.o(216376);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class f implements o.g {
        final /* synthetic */ d Gdf;

        f(d dVar) {
            this.Gdf = dVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            com.tencent.mm.plugin.textstatus.f.f.a aVar;
            AppMethodBeat.i(216377);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == R.id.fdn) {
                d.b(this.Gdf);
                AppMethodBeat.o(216377);
            } else if (itemId == R.id.fdj) {
                TextStatusEditActivity.a aVar2 = TextStatusEditActivity.GeM;
                TextStatusEditActivity.a.b(this.Gdf.mContext, null);
                com.tencent.mm.plugin.textstatus.k.a aVar3 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(16, (String) null, (String) null, 6);
                SecDataUIC.a aVar4 = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
                if (yVar != null) {
                    com.tencent.mm.plugin.textstatus.k.a aVar5 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.a(32, yVar);
                    AppMethodBeat.o(216377);
                    return;
                }
                AppMethodBeat.o(216377);
            } else if (itemId == R.id.fd6) {
                com.tencent.mm.plugin.textstatus.f.f.a aVar6 = this.Gdf.FYx;
                if (aVar6 != null) {
                    d dVar = this.Gdf;
                    Context context = this.Gdf.mContext;
                    this.Gdf.mContext.getString(R.string.hn8);
                    dVar.gut = com.tencent.mm.ui.base.h.a(context, this.Gdf.mContext.getString(R.string.hn8), false, (DialogInterface.OnCancelListener) null);
                    String str = aVar6.field_StatusID;
                    p.g(str, "this.field_StatusID");
                    com.tencent.mm.plugin.textstatus.f.a aVar7 = new com.tencent.mm.plugin.textstatus.f.a(str, 1);
                    com.tencent.mm.kernel.g.azz().a(aVar7.getType(), new com.tencent.mm.plugin.textstatus.d.f(this.Gdf));
                    com.tencent.mm.kernel.g.azz().b(aVar7);
                }
                SecDataUIC.a aVar8 = SecDataUIC.CWq;
                y yVar2 = (y) SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
                if (yVar2 != null) {
                    com.tencent.mm.plugin.textstatus.k.a aVar9 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.a(33, yVar2);
                    AppMethodBeat.o(216377);
                    return;
                }
                AppMethodBeat.o(216377);
            } else if (itemId != R.id.fd1 || (aVar = this.Gdf.FYx) == null) {
                AppMethodBeat.o(216377);
            } else {
                d dVar2 = this.Gdf;
                Context context2 = this.Gdf.mContext;
                this.Gdf.mContext.getString(R.string.hn8);
                dVar2.gut = com.tencent.mm.ui.base.h.a(context2, this.Gdf.mContext.getString(R.string.hn8), false, (DialogInterface.OnCancelListener) null);
                String str2 = aVar.field_StatusID;
                p.g(str2, "this.field_StatusID");
                com.tencent.mm.plugin.textstatus.f.a aVar10 = new com.tencent.mm.plugin.textstatus.f.a(str2, 2);
                com.tencent.mm.kernel.g.azz().a(aVar10.getType(), new com.tencent.mm.plugin.textstatus.d.f(this.Gdf));
                com.tencent.mm.kernel.g.azz().b(aVar10);
                AppMethodBeat.o(216377);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    static final class h implements e.a {
        final /* synthetic */ d Gdf;

        h(d dVar) {
            this.Gdf = dVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.a
        public final void onClick() {
            AppMethodBeat.i(258441);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(34, yVar);
                AppMethodBeat.o(258441);
                return;
            }
            AppMethodBeat.o(258441);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216395);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.b) {
            com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.b) qVar).getType(), this);
            boolean z = false;
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                com.tencent.mm.ui.base.h.X(this.mContext, this.mContext.getString(R.string.hn7), "");
            }
            f.a aVar = this.FXT;
            if (aVar != null) {
                aVar.dV(Boolean.valueOf(z));
            }
        }
        q qVar2 = this.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216395);
            return;
        }
        AppMethodBeat.o(216395);
    }

    public static final /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(216398);
        try {
            if (dVar.VeM) {
                com.tencent.mm.plugin.textstatus.j.e eVar = com.tencent.mm.plugin.textstatus.j.e.Ggj;
                dVar.jLt = com.tencent.mm.plugin.textstatus.j.e.fwL();
                dVar.VeM = false;
            }
            Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(dVar.GcM);
            Bitmap decodeResource = BitmapFactory.decodeResource(dVar.mContext.getResources(), dVar.jLt);
            Bitmap createBitmap = Bitmap.createBitmap(bitmapFromView.getWidth(), bitmapFromView.getHeight(), bitmapFromView.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(7);
            canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(bitmapFromView, 0.0f, 0.0f, paint);
            ImageView imageView = dVar.GcN;
            if (imageView != null) {
                imageView.setImageBitmap(createBitmap);
            }
            ImageView imageView2 = dVar.GcN;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View view = dVar.GcM;
            if (view != null) {
                view.setVisibility(4);
                AppMethodBeat.o(216398);
                return;
            }
            AppMethodBeat.o(216398);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "[handleAddStatus err]", new Object[0]);
            ImageView imageView3 = dVar.GcN;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
            View view2 = dVar.GcM;
            if (view2 != null) {
                view2.setVisibility(0);
                AppMethodBeat.o(216398);
                return;
            }
            AppMethodBeat.o(216398);
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(216399);
        ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).showStatusDetail(dVar.mContext, dVar.username);
        AppMethodBeat.o(216399);
    }
}

package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.a;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.upload.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.v;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0002\"%\u0018\u0000 ¾\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0012\u0004\u0012\u00020\u00060\u0007:\u0004¾\u0001¿\u0001B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010p\u001a\u00020\u001eH\u0002J\u0018\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\fH\u0016J\b\u0010u\u001a\u00020vH\u0002J\b\u0010w\u001a\u00020vH\u0002J\u0018\u0010x\u001a\u00020v2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010y\u001a\u00020sH\u0002J\u0010\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u00020sH\u0002J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020s0}2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020s0}H\u0002J\u0016\u0010\u001a\u00020v2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020s0}H\u0002J\u0016\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020AH\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\u0014\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\u0001\u001a\u0004\u0018\u00010s2\u0007\u0010\u0001\u001a\u000207H\u0016J\u0010\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u000207J\t\u0010\u0001\u001a\u00020\u001eH\u0016J)\u0010\u0001\u001a\u00020v2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u00012\u0006\u0010{\u001a\u00020s2\u0006\u0010t\u001a\u00020\fH\u0002J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\fH\u0002J\u0012\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\t\u0010\u0001\u001a\u00020vH\u0002J\u0019\u0010\u0001\u001a\u00020v2\u0006\u0010{\u001a\u00020s2\u0006\u0010t\u001a\u00020\fH\u0016J(\u0010\u0001\u001a\u00020v2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\f\u0010~\u001a\b\u0012\u0004\u0012\u00020s0}H\u0002Jr\u0010\u0001\u001a\u00020v2\u0006\u00100\u001a\u0002012\u0007\u0010\u0001\u001a\u00020k2\u0006\u0010@\u001a\u00020A2\b\u0010N\u001a\u0004\u0018\u00010O2\u0007\u0010\u0001\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\f2\u0006\u0010P\u001a\u0002072\n\u0010 \u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010i\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0007\u0010¡\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020v2\u0007\u0010¢\u0001\u001a\u00020kH\u0017J\u001b\u0010£\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0006\u0010y\u001a\u00020sH\u0016J\u0011\u0010¦\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020sH\u0016J\u001b\u0010§\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0006\u0010y\u001a\u00020sH\u0016J\u001c\u0010¨\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010©\u0001\u001a\u00020\u001eH\u0016J\t\u0010ª\u0001\u001a\u00020vH\u0016J\u001b\u0010«\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030¥\u00012\u0006\u0010{\u001a\u00020sH\u0016J5\u0010¬\u0001\u001a\u00020v2\u000e\u0010­\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060®\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010©\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u00020\u0006H\u0016J5\u0010°\u0001\u001a\u00020\f2\u000e\u0010­\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060®\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010©\u0001\u001a\u00020\u001e2\u0007\u0010¯\u0001\u001a\u00020\u0006H\u0016J\u001c\u0010±\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020\u001eH\u0016J\u001b\u0010²\u0001\u001a\u00020v2\u0007\u0010³\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u001eH\u0016J\t\u0010µ\u0001\u001a\u00020vH\u0002J\u0012\u0010¶\u0001\u001a\u00020v2\u0007\u0010·\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010¸\u0001\u001a\u00020v2\u0007\u0010¹\u0001\u001a\u00020\u001eH\u0016J\t\u0010º\u0001\u001a\u00020vH\u0002J\u0013\u0010»\u0001\u001a\u00020v2\b\b\u0002\u0010t\u001a\u00020\fH\u0002J\u0007\u0010¼\u0001\u001a\u00020vJ\u0013\u0010½\u0001\u001a\u00020v2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u001e8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u000e¢\u0006\u0004\n\u0002\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0018\u00010,R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b/\u0010\u0010R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX.¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R\u000e\u0010E\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R\u000e\u0010H\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030LX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\u0004\u0018\u00010R8BX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\u001a\u0010X\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010 \"\u0004\bZ\u0010?R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001e\u0010g\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\"\u0004\bh\u0010\u0010R\u000e\u0010i\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006À\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "enterTimeMs", "", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "exposeScene", "getExposeScene", "setExposeScene", "(I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"})
public final class f implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, g.c<com.tencent.mm.view.recyclerview.h>, g.d<com.tencent.mm.view.recyclerview.h> {
    public static final a tNf = new a((byte) 0);
    final Context context;
    private boolean efT = true;
    private volatile boolean isDetached = true;
    private volatile com.tencent.mm.bw.b lastBuffer;
    private long sGC;
    int scene = 2;
    public boolean tAj;
    private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
    public int tMM = 58;
    final com.tencent.mm.plugin.finder.feed.model.c tMN = new com.tencent.mm.plugin.finder.feed.model.c();
    private FinderItem tMO;
    public com.tencent.mm.plugin.finder.view.builder.b tMP;
    private b tMQ;
    private CommentDrawerContract.CloseDrawerCallback tMR;
    private boolean tMS;
    private boolean tMT;
    private boolean tMU = true;
    private boolean tMV;
    private boolean tMW;
    private com.tencent.mm.loader.g.i tMX;
    boolean tMY;
    private boolean tMZ;
    boolean tNa;
    private FinderCommentDrawer tNb;
    private e tNc = new e(this);
    private final IListener<hs> tNd = new c(this);
    private final d tNe = new d(this);
    Dialog tipDialog;
    private long tuj;
    private boolean tzn = true;

    static {
        AppMethodBeat.i(165695);
        AppMethodBeat.o(165695);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.f$f  reason: collision with other inner class name */
    public static final class DialogInterface$OnClickListenerC1146f implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ f tNg;
        final /* synthetic */ com.tencent.mm.plugin.finder.model.s tzs;

        DialogInterface$OnClickListenerC1146f(f fVar, Context context, com.tencent.mm.plugin.finder.model.s sVar) {
            this.tNg = fVar;
            this.$context = context;
            this.tzs = sVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.f$f$d */
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ DialogInterface$OnClickListenerC1146f tNo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(DialogInterface$OnClickListenerC1146f fVar) {
                super(0);
                this.tNo = fVar;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$deleteComment$1$succCallback$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.f$f$d$a */
            static final class a extends kotlin.g.b.q implements kotlin.g.a.b<FinderCommentInfo, Boolean> {
                final /* synthetic */ d tNq;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(d dVar) {
                    super(1);
                    this.tNq = dVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(FinderCommentInfo finderCommentInfo) {
                    boolean z;
                    AppMethodBeat.i(178223);
                    FinderCommentInfo finderCommentInfo2 = finderCommentInfo;
                    if (finderCommentInfo2.commentId == 0 || finderCommentInfo2.commentId != this.tNq.tNo.tzs.uOf.field_actionInfo.tuf) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(178223);
                    return valueOf;
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(165646);
                Dialog dialog = this.tNo.tNg.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (this.tNo.tzs.uOf.field_actionInfo.tuf != 0) {
                    for (T t : this.tNo.tNg.tMN.data) {
                        if (t.uOf.dyb().commentId == this.tNo.tzs.uOf.field_actionInfo.tuf) {
                            an anVar = t.uOf;
                            anVar.La(anVar.dyb().expandCommentCount - 1);
                            if (t.uOf.dyb().expandCommentCount < 0) {
                                t.uOf.La(0);
                            }
                            LinkedList<FinderCommentInfo> linkedList = t.uOf.dyb().levelTwoComment;
                            if (linkedList != null) {
                                com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) new a(this));
                            }
                        }
                    }
                }
                b bVar = this.tNo.tNg.tMQ;
                if (bVar != null) {
                    bVar.a(this.tNo.tzs.uOf.dyb().commentId, this.tNo.tzs.uOf.field_localCommentId, false);
                }
                if (this.tNo.tzs.uOf.field_actionInfo.tuf == 0) {
                    e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                    FinderItem Fy = e.a.Fy(this.tNo.tzs.uOf.field_feedId);
                    if (Fy != null && this.tNo.tzs.uOf.dyb().expandCommentCount > 0 && this.tNo.tzs.uOf.dyb().expandCommentCount <= Fy.getCommentCount()) {
                        Fy.setCommentCount(Fy.getCommentCount() - this.tNo.tzs.uOf.dyb().expandCommentCount);
                        y yVar = y.vXH;
                        y.A(Fy);
                    }
                }
                if (this.tNo.tzs.uOf.dyb().commentId == 0) {
                    y yVar2 = y.vXH;
                    y.a(f.h(this.tNo.tNg).getCommentList(), f.h(this.tNo.tNg).getId(), 0, this.tNo.tzs.uOf.dyg());
                    if (f.h(this.tNo.tNg).getCommentCount() > 0) {
                        FinderItem h2 = f.h(this.tNo.tNg);
                        h2.setCommentCount(h2.getCommentCount() - 1);
                    }
                }
                u.makeText(this.tNo.$context, (int) R.string.cl9, 0).show();
                x xVar = x.SXb;
                AppMethodBeat.o(165646);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.f$f$a */
        static final class a implements DialogInterface.OnCancelListener {
            public static final a tNn = new a();

            static {
                AppMethodBeat.i(165642);
                AppMethodBeat.o(165642);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            T t;
            boolean z;
            boolean z2;
            AppMethodBeat.i(165647);
            Dialog dialog = this.tNg.tipDialog;
            if (dialog != null) {
                dialog.show();
            } else {
                f fVar = this.tNg;
                Context context = this.$context;
                this.$context.getString(R.string.zb);
                fVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.$context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tNn);
            }
            d dVar = new d(this);
            b bVar = new b(this, dVar, new c(this));
            if (this.tzs.uOf.dyi() || this.tzs.uOf.field_localCommentId == 0) {
                bVar.invoke();
                AppMethodBeat.o(165647);
                return;
            }
            b.a aVar = com.tencent.mm.plugin.finder.upload.b.vRM;
            com.tencent.mm.plugin.finder.upload.b bVar2 = com.tencent.mm.plugin.finder.upload.b.vRL;
            an anVar = this.tzs.uOf;
            kotlin.g.b.p.h(anVar, "wantDeleteItem");
            bVar2.vRJ.d(new com.tencent.mm.plugin.finder.upload.a(anVar));
            com.tencent.mm.loader.g.d<com.tencent.mm.plugin.finder.upload.a> dVar2 = bVar2.vRJ;
            com.tencent.mm.plugin.finder.upload.a aVar2 = new com.tencent.mm.plugin.finder.upload.a(anVar);
            kotlin.g.b.p.h(aVar2, "t");
            Iterator<T> it = dVar2.iba.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (kotlin.g.b.p.j(next.first.auK(), aVar2.auK())) {
                    t = next;
                    break;
                }
            }
            if (t != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + anVar + " is running");
                z2 = false;
            } else {
                Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene ".concat(String.valueOf(anVar)));
                ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().Fw(anVar.field_localCommentId);
                z2 = true;
            }
            if (!z2) {
                Dialog dialog2 = this.tNg.tipDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                u.makeText(this.$context, (int) R.string.d6j, 0).show();
                AppMethodBeat.o(165647);
                return;
            }
            dVar.invoke();
            AppMethodBeat.o(165647);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.f$f$c */
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ DialogInterface$OnClickListenerC1146f tNo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(DialogInterface$OnClickListenerC1146f fVar) {
                super(0);
                this.tNo = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(165645);
                Dialog dialog = this.tNo.tNg.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                u.makeText(this.tNo.$context, (int) R.string.d6i, 0).show();
                x xVar = x.SXb;
                AppMethodBeat.o(165645);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.f$f$b */
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.a tAv;
            final /* synthetic */ kotlin.g.a.a tAw;
            final /* synthetic */ DialogInterface$OnClickListenerC1146f tNo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(DialogInterface$OnClickListenerC1146f fVar, kotlin.g.a.a aVar, kotlin.g.a.a aVar2) {
                super(0);
                this.tNo = fVar;
                this.tAv = aVar;
                this.tAw = aVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(165644);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNo.$context);
                new com.tencent.mm.plugin.finder.cgi.b(this.tNo.tzs.uOf.dyb().commentId, this.tNo.tzs.uOf.field_feedId, f.h(this.tNo.tNg).getObjectNonceId(), this.tNo.tNg.scene, fH != null ? fH.dIx() : null).aYI().a(this.tNo.tNg).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.f.DialogInterface$OnClickListenerC1146f.b.AnonymousClass1 */
                    final /* synthetic */ b tNp;

                    {
                        this.tNp = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(165643);
                        c.a aVar = (c.a) obj;
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            this.tNp.tAv.invoke();
                        } else {
                            this.tNp.tAw.invoke();
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(165643);
                        return xVar;
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(165644);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ f tNg;
        final /* synthetic */ LinkedList tNr;
        final /* synthetic */ com.tencent.mm.plugin.finder.model.s tzU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(f fVar, LinkedList linkedList, com.tencent.mm.plugin.finder.model.s sVar) {
            super(1);
            this.tNg = fVar;
            this.tNr = linkedList;
            this.tzU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(178225);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.g.AnonymousClass1 */
                final /* synthetic */ g tNs;

                {
                    this.tNs = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(178224);
                    LinkedList<FinderCommentInfo> linkedList = this.tNs.tNr;
                    kotlin.g.b.p.g(linkedList, "level2Comments");
                    ArrayList arrayList = new ArrayList();
                    for (FinderCommentInfo finderCommentInfo : linkedList) {
                        com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        kotlin.g.b.p.g(finderCommentInfo, "commentInfo");
                        com.tencent.mm.plugin.finder.model.s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(finderCommentInfo, f.h(this.tNs.tNg).getId(), this.tNs.tzU.lT());
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                    f.a(this.tNs.tNg, (List) arrayList, this.tNs.tzU, true);
                    this.tNs.tNg.tNa = true;
                    hVar2.a(com.tencent.mm.loader.g.j.OK);
                    x xVar = x.SXb;
                    AppMethodBeat.o(178224);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(178225);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final i tNt = new i();

        static {
            AppMethodBeat.i(178226);
            AppMethodBeat.o(178226);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ f tNg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(f fVar) {
            super(1);
            this.tNg = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            String mD5String;
            int i2;
            AppMethodBeat.i(165651);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            StringBuilder sb = new StringBuilder("loadMoreData before lastBuffer ");
            if (this.tNg.lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar = this.tNg.lastBuffer;
                mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
            }
            Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNg.context);
            if (fH != null) {
                i2 = fH.tCE;
            } else {
                i2 = 0;
            }
            long id = f.h(this.tNg).getId();
            String objectNonceId = f.h(this.tNg).getObjectNonceId();
            int i3 = this.tNg.scene;
            String userName = f.h(this.tNg).getUserName();
            com.tencent.mm.bw.b bVar2 = this.tNg.lastBuffer;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.tNg.context);
            new af(id, objectNonceId, i2, i3, userName, false, bVar2, null, 0, null, false, false, null, fH2 != null ? fH2.dIx() : null, 0, 24480).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.j.AnonymousClass1 */
                final /* synthetic */ j tNu;

                {
                    this.tNu = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    AppMethodBeat.i(165649);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "loadMoreData resp null");
                        ArrayList arrayList = new ArrayList();
                        AppMethodBeat.o(165649);
                        return arrayList;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        f.a(this.tNu.tNg, ((ars) aVar.iLC).LDf == 1);
                        this.tNu.tNg.lastBuffer = ((ars) aVar.iLC).lastBuffer;
                        StringBuilder sb = new StringBuilder("loadMoreData after lastBuffer ");
                        if (this.tNu.tNg.lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tNu.tNg.lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
                        ArrayList arrayList2 = new ArrayList();
                        LinkedList<FinderCommentInfo> linkedList = ((ars) aVar.iLC).LDe;
                        kotlin.g.b.p.g(linkedList, "it.resp.commentInfo");
                        LinkedList<FinderCommentInfo> linkedList2 = linkedList;
                        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(linkedList2, 10));
                        for (T t : linkedList2) {
                            com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                            kotlin.g.b.p.g(t, "commentInfo");
                            arrayList3.add(com.tencent.mm.plugin.finder.storage.logic.a.b(t, f.h(this.tNu.tNg).getId()));
                        }
                        arrayList2.addAll(arrayList3);
                        List b2 = f.b(this.tNu.tNg, arrayList2);
                        AppMethodBeat.o(165649);
                        return b2;
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        AppMethodBeat.o(165649);
                        return arrayList4;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.j.AnonymousClass2 */
                final /* synthetic */ j tNu;

                {
                    this.tNu = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    RefreshLoadMoreLayout rlLayout;
                    RefreshLoadMoreLayout rlLayout2;
                    RecyclerView recyclerView;
                    RecyclerView.a adapter;
                    AppMethodBeat.i(165650);
                    List<? extends com.tencent.mm.plugin.finder.model.s> list = (List) obj;
                    kotlin.g.b.p.g(list, LocaleUtil.ITALIAN);
                    if (!list.isEmpty()) {
                        int size = this.tNu.tNg.tMN.data.size();
                        this.tNu.tNg.tMN.a(list, false, true);
                        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNu.tNg.tMP;
                        if (!(bVar == null || (rlLayout2 = bVar.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null)) {
                            adapter.as(size, this.tNu.tNg.tMN.data.size() - size);
                        }
                    } else {
                        Log.w("Finder.DrawerPresenter", "[loadMoreData] empty!");
                    }
                    RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                    cVar.Rmj = this.tNu.tNg.tMU;
                    cVar.Rmk = list.size();
                    if (cVar.Rmk > 0) {
                        cVar.jLE = false;
                    }
                    com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tNu.tNg.tMP;
                    if (!(bVar2 == null || (rlLayout = bVar2.getRlLayout()) == null)) {
                        rlLayout.onPreFinishLoadMoreSmooth(cVar);
                    }
                    hVar2.a(com.tencent.mm.loader.g.j.OK);
                    x xVar = x.SXb;
                    AppMethodBeat.o(165650);
                    return xVar;
                }
            }).a(this.tNg);
            x xVar = x.SXb;
            AppMethodBeat.o(165651);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ f tNg;
        final /* synthetic */ z.d tNv;
        final /* synthetic */ com.tencent.mm.plugin.finder.model.s tzU;
        final /* synthetic */ boolean tzV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(f fVar, com.tencent.mm.plugin.finder.model.s sVar, z.d dVar, boolean z) {
            super(1);
            this.tNg = fVar;
            this.tzU = sVar;
            this.tNv = dVar;
            this.tzV = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            String mD5String;
            AppMethodBeat.i(178229);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            StringBuilder sb = new StringBuilder("loadMoreLevel2Comments before lastBuffer ");
            if (this.tzU.uOf.dyb().lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar = this.tzU.uOf.dyb().lastBuffer;
                mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
            }
            Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
            long id = f.h(this.tNg).getId();
            String objectNonceId = f.h(this.tNg).getObjectNonceId();
            int i2 = this.tNv.SYE;
            int i3 = this.tNg.scene;
            String userName = f.h(this.tNg).getUserName();
            boolean z = this.tzV;
            an anVar = this.tzU.uOf;
            com.tencent.mm.bw.b bVar2 = this.tzU.uOf.dyb().lastBuffer;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNg.context);
            new af(id, objectNonceId, i2, i3, userName, false, bVar2, anVar, 0, null, z, false, null, fH != null ? fH.dIx() : null, 0, 23328).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.k.AnonymousClass1 */
                final /* synthetic */ k tNw;

                {
                    this.tNw = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    AppMethodBeat.i(178227);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "loadMoreLevel2Comments resp null");
                        kotlin.o oVar = new kotlin.o(-2, v.SXr);
                        AppMethodBeat.o(178227);
                        return oVar;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        StringBuilder sb = new StringBuilder("loadMoreLevel2Comments after lastBuffer ");
                        if (this.tNw.tzU.uOf.dyb().lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tNw.tzU.uOf.dyb().lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
                        LinkedList<FinderCommentInfo> linkedList = ((ars) aVar.iLC).LDe;
                        kotlin.g.b.p.g(linkedList, "it.resp.commentInfo");
                        LinkedList<FinderCommentInfo> linkedList2 = linkedList;
                        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
                        for (T t : linkedList2) {
                            com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                            kotlin.g.b.p.g(t, "commentInfo");
                            arrayList.add(com.tencent.mm.plugin.finder.storage.logic.a.b(t, f.h(this.tNw.tNg).getId(), this.tNw.tzU.lT()));
                        }
                        kotlin.o oVar2 = new kotlin.o(0, arrayList);
                        AppMethodBeat.o(178227);
                        return oVar2;
                    } else if (aVar.errCode == -4032) {
                        kotlin.o oVar3 = new kotlin.o(-1, v.SXr);
                        AppMethodBeat.o(178227);
                        return oVar3;
                    } else {
                        kotlin.o oVar4 = new kotlin.o(0, v.SXr);
                        AppMethodBeat.o(178227);
                        return oVar4;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.k.AnonymousClass2 */
                final /* synthetic */ k tNw;

                {
                    this.tNw = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(178228);
                    kotlin.o oVar = (kotlin.o) obj;
                    int intValue = oVar.first.intValue();
                    B b2 = oVar.second;
                    if (intValue == 0) {
                        f.a(this.tNw.tNg, b2, this.tNw.tzU, this.tNw.tzV);
                    } else if (intValue == -1) {
                        b bVar = this.tNw.tNg.tMQ;
                        if (bVar != null) {
                            bVar.a(this.tNw.tzU.uOf.dyb().commentId, this.tNw.tzU.uOf.field_localCommentId, true);
                        }
                        if (this.tNw.tzU.uOf.field_actionInfo.tuf == 0) {
                            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                            FinderItem Fy = e.a.Fy(this.tNw.tzU.uOf.field_feedId);
                            if (Fy != null) {
                                Fy.setCommentCount(Fy.getCommentCount() - 1);
                                if (Fy.getCommentCount() < 0) {
                                    Fy.setCommentCount(0);
                                }
                                if (this.tNw.tzU.uOf.dyb().expandCommentCount > 0 && this.tNw.tzU.uOf.dyb().expandCommentCount <= Fy.getCommentCount()) {
                                    Fy.setCommentCount(Fy.getCommentCount() - this.tNw.tzU.uOf.dyb().expandCommentCount);
                                }
                                y yVar = y.vXH;
                                y.A(Fy);
                                this.tNw.tNg.dcD();
                            }
                        }
                        u.makeText(this.tNw.tNg.context, (int) R.string.d89, 0).show();
                    }
                    hVar2.a(com.tencent.mm.loader.g.j.OK);
                    x xVar = x.SXb;
                    AppMethodBeat.o(178228);
                    return xVar;
                }
            }).a(this.tNg);
            x xVar = x.SXb;
            AppMethodBeat.o(178229);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.model.s, x> {
        final /* synthetic */ f tNg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(f fVar) {
            super(1);
            this.tNg = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.model.s sVar) {
            AppMethodBeat.i(243744);
            com.tencent.mm.plugin.finder.model.s sVar2 = sVar;
            kotlin.g.b.p.h(sVar2, "commentItem");
            this.tNg.a(sVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(243744);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.model.s, x> {
        final /* synthetic */ f tNg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(f fVar) {
            super(1);
            this.tNg = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.model.s sVar) {
            AppMethodBeat.i(165660);
            com.tencent.mm.plugin.finder.model.s sVar2 = sVar;
            kotlin.g.b.p.h(sVar2, "commentItem");
            this.tNg.a(sVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(165660);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final r tNA = new r();

        static {
            AppMethodBeat.i(243745);
            AppMethodBeat.o(243745);
        }

        r() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ f tNg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(f fVar) {
            super(1);
            this.tNg = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            String mD5String;
            int i2;
            AppMethodBeat.i(178234);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            StringBuilder sb = new StringBuilder("preloadNextPage before lastBuffer ");
            if (this.tNg.lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar = this.tNg.lastBuffer;
                mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
            }
            Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNg.context);
            if (fH != null) {
                i2 = fH.tCE;
            } else {
                i2 = 0;
            }
            long id = f.h(this.tNg).getId();
            String objectNonceId = f.h(this.tNg).getObjectNonceId();
            int i3 = this.tNg.scene;
            String userName = f.h(this.tNg).getUserName();
            com.tencent.mm.bw.b bVar2 = this.tNg.lastBuffer;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.tNg.context);
            new af(id, objectNonceId, i2, i3, userName, false, bVar2, null, 0, null, false, false, null, fH2 != null ? fH2.dIx() : null, 0, 24480).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.s.AnonymousClass1 */
                final /* synthetic */ s tNB;

                {
                    this.tNB = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    AppMethodBeat.i(178232);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "preloadNextPage CgiGetFinderFeedComment resp null");
                        ArrayList arrayList = new ArrayList();
                        AppMethodBeat.o(178232);
                        return arrayList;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        f.a(this.tNB.tNg, ((ars) aVar.iLC).LDf == 1);
                        this.tNB.tNg.lastBuffer = ((ars) aVar.iLC).lastBuffer;
                        StringBuilder sb = new StringBuilder("preloadNextPage after lastBuffer ");
                        if (this.tNB.tNg.lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tNB.tNg.lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
                        ArrayList arrayList2 = new ArrayList();
                        LinkedList<FinderCommentInfo> linkedList = ((ars) aVar.iLC).LDe;
                        kotlin.g.b.p.g(linkedList, "it.resp.commentInfo");
                        LinkedList<FinderCommentInfo> linkedList2 = linkedList;
                        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(linkedList2, 10));
                        for (T t : linkedList2) {
                            com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                            kotlin.g.b.p.g(t, "commentInfo");
                            arrayList3.add(com.tencent.mm.plugin.finder.storage.logic.a.b(t, f.h(this.tNB.tNg).getId()));
                        }
                        arrayList2.addAll(arrayList3);
                        List b2 = f.b(this.tNB.tNg, arrayList2);
                        AppMethodBeat.o(178232);
                        return b2;
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        AppMethodBeat.o(178232);
                        return arrayList4;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.s.AnonymousClass2 */
                final /* synthetic */ s tNB;

                {
                    this.tNB = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    RefreshLoadMoreLayout rlLayout;
                    RefreshLoadMoreLayout rlLayout2;
                    RecyclerView recyclerView;
                    RecyclerView.a adapter;
                    AppMethodBeat.i(178233);
                    List<? extends com.tencent.mm.plugin.finder.model.s> list = (List) obj;
                    kotlin.g.b.p.g(list, LocaleUtil.ITALIAN);
                    if (!list.isEmpty()) {
                        int size = this.tNB.tNg.tMN.data.size();
                        this.tNB.tNg.tMN.a(list, false, true);
                        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNB.tNg.tMP;
                        if (!(bVar == null || (rlLayout2 = bVar.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null)) {
                            adapter.as(size, this.tNB.tNg.tMN.data.size() - size);
                        }
                    } else {
                        Log.w("Finder.DrawerPresenter", "[preloadNextPage] empty!");
                    }
                    RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                    cVar.Rmj = this.tNB.tNg.tMU;
                    cVar.Rmk = list.size();
                    cVar.jLE = false;
                    com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tNB.tNg.tMP;
                    if (!(bVar2 == null || (rlLayout = bVar2.getRlLayout()) == null)) {
                        rlLayout.onPreFinishLoadMoreSmooth(cVar);
                    }
                    hVar2.a(com.tencent.mm.loader.g.j.OK);
                    this.tNB.tNg.tMY = true;
                    x xVar = x.SXb;
                    AppMethodBeat.o(178233);
                    return xVar;
                }
            }).a(this.tNg);
            x xVar = x.SXb;
            AppMethodBeat.o(178234);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ f tNg;
        final /* synthetic */ boolean tzV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(f fVar, boolean z) {
            super(1);
            this.tNg = fVar;
            this.tzV = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            int i2;
            AppMethodBeat.i(165668);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            Log.i("Finder.DrawerPresenter", "refreshData " + this.tzV);
            final long currentTimeMillis = System.currentTimeMillis();
            final z.f fVar = new z.f();
            fVar.SYG = (T) v.SXr;
            final z.f fVar2 = new z.f();
            fVar2.SYG = (T) v.SXr;
            if (this.tNg.tuj == 0) {
                fVar.SYG = (T) ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().Ft(f.h(this.tNg).getId());
                if (!this.tNg.tzn) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : fVar.SYG) {
                        if (((an) obj).field_actionInfo.tuf != 0) {
                            arrayList.add(obj);
                        }
                    }
                    fVar2.SYG = (T) arrayList;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : fVar.SYG) {
                        if (((an) obj2).field_actionInfo.tuf == 0) {
                            arrayList2.add(obj2);
                        }
                    }
                    fVar.SYG = (T) arrayList2;
                }
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNg.context);
            if (fH != null) {
                i2 = fH.tCE;
            } else {
                i2 = 0;
            }
            long id = f.h(this.tNg).getId();
            String objectNonceId = f.h(this.tNg).getObjectNonceId();
            int i3 = this.tNg.scene;
            String userName = f.h(this.tNg).getUserName();
            com.tencent.mm.bw.b bVar = this.tNg.lastBuffer;
            long j2 = this.tzV ? this.tNg.tuj : 0;
            boolean z = this.tzV;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.tNg.context);
            new af(id, objectNonceId, i2, i3, userName, false, bVar, null, j2, null, z, false, null, fH2 != null ? fH2.dIx() : null, 0, 23200).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.t.AnonymousClass1 */
                final /* synthetic */ t tNC;

                {
                    this.tNC = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    Object obj2;
                    boolean z;
                    AppMethodBeat.i(178239);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "refreshData resp null");
                        kotlin.o oVar = new kotlin.o(Boolean.FALSE, null);
                        AppMethodBeat.o(178239);
                        return oVar;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        this.tNC.tNg.lastBuffer = ((ars) aVar.iLC).lastBuffer;
                        StringBuilder append = new StringBuilder("refreshData oldVersion:").append(this.tNC.tNg.tzn).append(", lastBuffer ");
                        if (this.tNC.tNg.lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tNC.tNg.lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", append.append(mD5String).toString());
                        if (this.tNC.tzV) {
                            f.a(this.tNC.tNg, ((ars) aVar.iLC).LDf == 1);
                            f.b(this.tNC.tNg, ((ars) aVar.iLC).upContinueFlag == 1);
                            int i2 = ((ars) aVar.iLC).commentCount;
                            f.h(this.tNC.tNg).setCommentCount(i2);
                            Log.i("Finder.DrawerPresenter", "first fetch, svrCount:" + i2 + ", oldVersion:" + this.tNC.tNg.tzn);
                        } else {
                            f.b(this.tNC.tNg, ((ars) aVar.iLC).upContinueFlag == 1);
                        }
                        ArrayList arrayList = new ArrayList();
                        LinkedList<FinderCommentInfo> linkedList = ((ars) aVar.iLC).LDe;
                        kotlin.g.b.p.g(linkedList, "it.resp.commentInfo");
                        ArrayList arrayList2 = arrayList;
                        for (T t : linkedList) {
                            com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                            kotlin.g.b.p.g(t, "commentInfo");
                            com.tencent.mm.plugin.finder.model.s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(t, f.h(this.tNC.tNg).getId());
                            b2.uOb = this.tNC.tNg.tMW && b2.lT() == this.tNC.tNg.tuj && this.tNC.tNg.tuj != 0;
                            if (b2.uOb) {
                                this.tNC.tNg.tMW = false;
                            }
                            arrayList2.add(b2);
                        }
                        f.a(this.tNC.tNg, arrayList);
                        int size = arrayList.size();
                        f.a(this.tNC.tNg, fVar2.SYG, arrayList);
                        int size2 = arrayList.size() - size;
                        List b3 = f.b(this.tNC.tNg, arrayList);
                        int size3 = b3.size();
                        for (an anVar : fVar.SYG) {
                            Iterator it = b3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                Object next = it.next();
                                com.tencent.mm.plugin.finder.model.s sVar = (com.tencent.mm.plugin.finder.model.s) next;
                                if (sVar.uOf.dyg() == null || !kotlin.g.b.p.j(sVar.uOf.dyg(), anVar.dyg())) {
                                    z = false;
                                    continue;
                                } else {
                                    z = true;
                                    continue;
                                }
                                if (z) {
                                    obj2 = next;
                                    break;
                                }
                            }
                            if (((com.tencent.mm.plugin.finder.model.s) obj2) == null) {
                                Log.i("Finder.DrawerPresenter", "merge local item: " + anVar.dyg());
                                com.tencent.mm.plugin.finder.model.s sVar2 = new com.tencent.mm.plugin.finder.model.s(anVar);
                                sVar2.uNY = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), anVar.getContent());
                                b3.add(sVar2);
                            }
                        }
                        int size4 = b3.size() - size3;
                        Log.i("Finder.DrawerPresenter", "merge respCount:" + ((ars) aVar.iLC).commentCount + ", preSize: " + ((ars) aVar.iLC).LDe.size() + ", afterSize:" + b3.size() + ", diffsize1:" + size2 + ", diffSize2:" + size4);
                        FinderItem h2 = f.h(this.tNC.tNg);
                        h2.setCommentCount(size4 + size2 + h2.getCommentCount());
                        kotlin.o oVar2 = new kotlin.o(Boolean.TRUE, b3);
                        AppMethodBeat.o(178239);
                        return oVar2;
                    } else if (aVar.errCode == -4014 || aVar.errCode == -4032) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.f.t.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 tNF;

                            {
                                this.tNF = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                FinderCommentDrawer dHw;
                                AppMethodBeat.i(178236);
                                f.a aVar = new f.a(MMApplicationContext.getContext());
                                aVar.bow(MMApplicationContext.getContext().getString(R.string.d20)).Dq(true);
                                aVar.b(AnonymousClass1.tNG).show();
                                com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNF.tNC.tNg.tMP;
                                if (!(bVar == null || (dHw = bVar.dHw()) == null)) {
                                    dHw.dGw();
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(178236);
                                return xVar;
                            }
                        });
                        kotlin.o oVar3 = new kotlin.o(Boolean.TRUE, null);
                        AppMethodBeat.o(178239);
                        return oVar3;
                    } else {
                        y yVar = y.vXH;
                        if (y.gp(aVar.errType, aVar.errCode)) {
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.finder.feed.f.t.AnonymousClass1.AnonymousClass2 */
                                final /* synthetic */ AnonymousClass1 tNF;

                                {
                                    this.tNF = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    FinderCommentDrawer dHw;
                                    AppMethodBeat.i(178238);
                                    f.a aVar = new f.a(MMApplicationContext.getContext());
                                    aVar.bow(MMApplicationContext.getContext().getString(R.string.cms)).Dq(true);
                                    aVar.b(AnonymousClass1.tNH).show();
                                    com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNF.tNC.tNg.tMP;
                                    if (!(bVar == null || (dHw = bVar.dHw()) == null)) {
                                        dHw.dGw();
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(178238);
                                    return xVar;
                                }
                            });
                            kotlin.o oVar4 = new kotlin.o(Boolean.TRUE, null);
                            AppMethodBeat.o(178239);
                            return oVar4;
                        }
                        kotlin.o oVar5 = new kotlin.o(Boolean.FALSE, null);
                        AppMethodBeat.o(178239);
                        return oVar5;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.f.t.AnonymousClass2 */
                final /* synthetic */ t tNC;

                {
                    this.tNC = r1;
                }

                /* JADX WARNING: Removed duplicated region for block: B:84:0x020b  */
                /* JADX WARNING: Removed duplicated region for block: B:94:0x0228  */
                /* JADX WARNING: Removed duplicated region for block: B:97:0x022d  */
                @Override // com.tencent.mm.vending.c.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ java.lang.Object call(java.lang.Object r15) {
                    /*
                    // Method dump skipped, instructions count: 838
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.f.t.AnonymousClass2.call(java.lang.Object):java.lang.Object");
                }
            }).a(this.tNg);
            x xVar = x.SXb;
            AppMethodBeat.o(165668);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(Context context2) {
        kotlin.g.b.p.h(context2, "context");
        AppMethodBeat.i(243753);
        this.context = context2;
        AppMethodBeat.o(243753);
    }

    public static final /* synthetic */ void a(f fVar, boolean z) {
        AppMethodBeat.i(165701);
        fVar.mX(z);
        AppMethodBeat.o(165701);
    }

    public static final /* synthetic */ void b(f fVar, boolean z) {
        AppMethodBeat.i(165702);
        fVar.mW(z);
        AppMethodBeat.o(165702);
    }

    public static final /* synthetic */ void e(f fVar) {
        AppMethodBeat.i(165698);
        fVar.mY(false);
        AppMethodBeat.o(165698);
    }

    public static final /* synthetic */ FinderItem h(f fVar) {
        AppMethodBeat.i(165700);
        FinderItem finderItem = fVar.tMO;
        if (finderItem == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        AppMethodBeat.o(165700);
        return finderItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        RecyclerView recyclerView;
        FinderCommentDrawer dHw;
        FinderCommentFooter dHv;
        boolean z;
        AppMethodBeat.i(243748);
        com.tencent.mm.view.recyclerview.h hVar2 = hVar;
        kotlin.g.b.p.h(aVar, "adapter");
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(hVar2, "holder");
        int lU = hVar2.lU();
        s.a aVar2 = com.tencent.mm.plugin.finder.model.s.uOj;
        if (lU != com.tencent.mm.plugin.finder.model.s.uOi && !this.tAj) {
            if (i2 < 0) {
                Log.i("Finder.DrawerPresenter", "onItemClick position:".concat(String.valueOf(i2)));
                AppMethodBeat.o(243748);
                return;
            }
            com.tencent.mm.plugin.finder.model.s IL = this.tMN.IL(i2);
            if ((!IL.uNZ || !((FinderCollapsibleTextView) hVar2.Mn(R.id.b8e)).dGq()) && IL.uOf.dyi()) {
                com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
                if (!(bVar == null || (dHv = bVar.dHv()) == null)) {
                    an anVar = IL.uOf;
                    if (this.scene == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    kotlin.g.b.p.h(anVar, "commentObj");
                    if (z) {
                        String str = dHv.wle;
                        StringBuilder sb = new StringBuilder(" ");
                        Resources resources = dHv.getResources();
                        y yVar = y.vXH;
                        dHv.f(str, sb.append(resources.getString(R.string.b8p, dHv.awQ(y.hf(anVar.getUsername(), anVar.getNickname())))).toString(), anVar);
                    } else {
                        dHv.f(dHv.wle, " " + dHv.getResources().getString(R.string.b8p, dHv.awQ(anVar.getNickname())), anVar);
                    }
                    MMEditText mMEditText = dHv.wkS;
                    if (mMEditText == null) {
                        kotlin.g.b.p.btv("editText");
                    }
                    mMEditText.setShowSoftInputOnFocus(true);
                    MMEditText mMEditText2 = dHv.wkS;
                    if (mMEditText2 == null) {
                        kotlin.g.b.p.btv("editText");
                    }
                    mMEditText2.requestFocus();
                    dHv.cH(true);
                }
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                int i3 = rect.bottom;
                com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tMP;
                FinderCommentDrawer dHw2 = bVar2 != null ? bVar2.dHw() : null;
                if (dHw2 == null) {
                    kotlin.g.b.p.hyc();
                }
                dHw2.getGlobalVisibleRect(rect);
                int i4 = rect.bottom - i3;
                com.tencent.mm.plugin.finder.view.builder.b bVar3 = this.tMP;
                FinderCommentFooter dHv2 = bVar3 != null ? bVar3.dHv() : null;
                if (dHv2 == null) {
                    kotlin.g.b.p.hyc();
                }
                if (i4 < dHv2.getHeight()) {
                    int height = i4 - dHv2.getHeight();
                    com.tencent.mm.plugin.finder.view.builder.b bVar4 = this.tMP;
                    if (bVar4 == null || (dHw = bVar4.dHw()) == null) {
                        recyclerView = null;
                    } else {
                        recyclerView = dHw.getRecyclerView();
                    }
                    if (recyclerView == null) {
                        kotlin.g.b.p.hyc();
                    }
                    recyclerView.animate().translationY((float) height).setDuration(90).start();
                }
            }
        }
        AppMethodBeat.o(243748);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.d
    public final /* synthetic */ boolean b(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        boolean z = true;
        AppMethodBeat.i(243749);
        kotlin.g.b.p.h(aVar, "adapter");
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(hVar, "holder");
        if (this.tAj) {
            AppMethodBeat.o(243749);
        } else if (i2 < 0) {
            Log.i("Finder.DrawerPresenter", "onItemLongClick position:".concat(String.valueOf(i2)));
            AppMethodBeat.o(243749);
        } else {
            com.tencent.mm.plugin.finder.model.s IL = this.tMN.IL(i2);
            com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(this.context);
            FinderItem finderItem = this.tMO;
            if (finderItem == null) {
                kotlin.g.b.p.btv("feedObj");
            }
            String userName = finderItem.getUserName();
            if (this.scene != 1) {
                z = false;
            }
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            int i3 = TouchableLayout.kuv;
            TouchableLayout.a aVar4 = TouchableLayout.Rni;
            aVar2.a(view, 0, 0, new a.c(IL, userName, z), new a.d(IL, this.tMM, new q(this)), i3, TouchableLayout.kuw);
            AppMethodBeat.o(243749);
        }
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(com.tencent.mm.plugin.finder.view.builder.b bVar) {
        AppMethodBeat.i(165687);
        kotlin.g.b.p.h(bVar, "callback");
        this.isDetached = false;
        AppMethodBeat.o(165687);
    }

    private final void mW(boolean z) {
        AppMethodBeat.i(165670);
        this.tMT = z;
        Log.i("Finder.DrawerPresenter", "set upContinue ".concat(String.valueOf(z)));
        AppMethodBeat.o(165670);
    }

    private final void mX(boolean z) {
        AppMethodBeat.i(165671);
        this.tMU = z;
        Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(z)));
        AppMethodBeat.o(165671);
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(165673);
        kotlin.g.b.p.h(aVar, "p0");
        this.tLP.add(aVar);
        AppMethodBeat.o(165673);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentErrorEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class e extends IListener<ht> {
        final /* synthetic */ f tNg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(f fVar) {
            this.tNg = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ht htVar) {
            AppMethodBeat.i(165641);
            ht htVar2 = htVar;
            kotlin.g.b.p.h(htVar2, "event");
            switch (htVar2.dMp.errCode) {
                case -4013:
                    if (!Util.isNullOrNil(htVar2.dMp.errMsg)) {
                        com.tencent.mm.ac.d.h(new a(this, htVar2));
                        break;
                    }
                    break;
                default:
                    com.tencent.mm.ac.d.h(new b(this));
                    break;
            }
            AppMethodBeat.o(165641);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ e tNk;
            final /* synthetic */ ht tNl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, ht htVar) {
                super(0);
                this.tNk = eVar;
                this.tNl = htVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                View dHx;
                View dHx2;
                AppMethodBeat.i(165639);
                com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNk.tNg.tMP;
                if (!(bVar == null || (dHx2 = bVar.dHx()) == null)) {
                    dHx2.setVisibility(0);
                }
                com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tNk.tNg.tMP;
                if (bVar2 != null) {
                    TextView textView = bVar2.wse;
                    if (textView == null) {
                        kotlin.g.b.p.btv("headerErrTv");
                    }
                    if (textView != null) {
                        textView.setText(this.tNl.dMp.errMsg);
                    }
                }
                com.tencent.mm.plugin.finder.view.builder.b bVar3 = this.tNk.tNg.tMP;
                if (!(bVar3 == null || (dHx = bVar3.dHx()) == null)) {
                    dHx.setOnClickListener(new View.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.feed.f.e.a.AnonymousClass1 */
                        final /* synthetic */ a tNm;

                        {
                            this.tNm = r1;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(165638);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1$callback$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                            com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tNm.tNk.tNg.tMP;
                            Context context = bVar2 != null ? bVar2.getContext() : null;
                            if (context == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(165638);
                                throw tVar;
                            }
                            com.tencent.mm.plugin.finder.utils.a.am((Activity) context);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1$callback$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(165638);
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(165639);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ e tNk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar) {
                super(0);
                this.tNk = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                View dHx;
                AppMethodBeat.i(165640);
                com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNk.tNg.tMP;
                if (!(bVar == null || (dHx = bVar.dHx()) == null)) {
                    dHx.setVisibility(8);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(165640);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final void a(FinderCommentDrawer finderCommentDrawer, com.tencent.mm.plugin.finder.view.builder.b bVar, FinderItem finderItem, CommentDrawerContract.CloseDrawerCallback closeDrawerCallback, int i2, boolean z, long j2, an anVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        FinderCommentDrawer dHw;
        FinderCommentFooter dHv;
        com.tencent.mm.plugin.finder.view.builder.b bVar2;
        FinderCommentFooter dHv2;
        com.tencent.mm.plugin.finder.view.builder.b bVar3;
        RefreshLoadMoreLayout rlLayout;
        RefreshLoadMoreLayout rlLayout2;
        RecyclerView recyclerView;
        RefreshLoadMoreLayout rlLayout3;
        RecyclerView recyclerView2;
        RecyclerView.a adapter;
        MMEditText editText;
        String str;
        FinderCommentFooter dHv3;
        AppMethodBeat.i(243746);
        kotlin.g.b.p.h(finderCommentDrawer, "drawer");
        kotlin.g.b.p.h(bVar, "builder");
        kotlin.g.b.p.h(finderItem, "feedObj");
        this.isDetached = false;
        this.sGC = System.currentTimeMillis();
        Log.i("Finder.DrawerPresenter", "onAttach " + finderItem.getId() + ", " + i2 + ", " + z + ", " + j2);
        this.tMP = bVar;
        this.tNb = finderCommentDrawer;
        this.tMO = finderItem;
        this.tMV = z;
        this.scene = i2;
        this.tMR = closeDrawerCallback;
        this.tuj = j2;
        this.efT = z2;
        this.tMW = z3;
        this.tMX = new com.tencent.mm.loader.g.i("FinderCommentExecutor");
        com.tencent.mm.loader.g.i iVar = this.tMX;
        if (iVar != null) {
            iVar.start();
        }
        kotlin.o<f.b, Boolean> a2 = this.tMN.a(finderItem.getId(), finderItem, j2, z2, bVar.tzm.getCommentScene());
        A a3 = a2.first;
        boolean booleanValue = a2.second.booleanValue();
        int i3 = a3.pos;
        com.tencent.mm.bw.b bVar4 = a3.lastBuffer;
        boolean z6 = a3.tMT;
        boolean z7 = a3.tMU;
        boolean z8 = a3.vGe;
        this.lastBuffer = bVar4;
        this.tMS = booleanValue;
        mW(z6);
        mX(z7);
        this.tzn = z5;
        this.tMY = true;
        this.tMZ = z4;
        this.tNa = z8;
        if (this.tMT) {
            bVar.pb(true);
        } else {
            bVar.pb(false);
            com.tencent.mm.plugin.finder.view.builder.b bVar5 = this.tMP;
            if (!(bVar5 == null || (dHw = bVar5.dHw()) == null)) {
                dHw.hge();
            }
        }
        bVar.dHv().setFooterMode(0);
        if (j2 == 0) {
            com.tencent.mm.plugin.finder.view.builder.b bVar6 = this.tMP;
            if (!(bVar6 == null || (dHv3 = bVar6.dHv()) == null)) {
                y yVar = y.vXH;
                dHv3.hk(y.LD(this.scene), finderItem.getNickName());
            }
        } else {
            int i4 = 0;
            Iterator<com.tencent.mm.plugin.finder.model.s> it = this.tMN.data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i4 = -1;
                    break;
                }
                if (it.next().lT() == j2) {
                    break;
                }
                i4++;
            }
            if (i4 >= 0) {
                com.tencent.mm.plugin.finder.model.s sVar = this.tMN.data.get(i4);
                sVar.uOb = true;
                com.tencent.mm.plugin.finder.view.builder.b bVar7 = this.tMP;
                if (!(bVar7 == null || (dHv = bVar7.dHv()) == null)) {
                    y yVar2 = y.vXH;
                    String LD = y.LD(this.scene);
                    y yVar3 = y.vXH;
                    String username = sVar.uOf.getUsername();
                    String nickname = sVar.uOf.getNickname();
                    if (nickname == null) {
                        nickname = "";
                    }
                    dHv.e(LD, y.hf(username, nickname), sVar.uOf);
                }
            }
        }
        bVar.getRlLayout().getRecyclerView().setLayoutFrozen(false);
        this.tMQ = new b(this, bVar.getRlLayout().getRecyclerView());
        EventCenter.instance.addListener(this.tNd);
        try {
            RecyclerView.a adapter2 = bVar.getRlLayout().getRecyclerView().getAdapter();
            if (adapter2 != null) {
                adapter2.a(this.tNe);
            }
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace("Finder.DrawerPresenter", e2, "", new Object[0]);
        }
        bVar.getRlLayout().setActionCallback(new m(this));
        bVar.dHv().setModeChangeCallback(this);
        if (getCommentCount() <= 0) {
            bVar.dHs().setText(bVar.getContext().getResources().getString(R.string.cj_));
        } else {
            bVar.dHs().setText(bVar.getContext().getResources().getString(R.string.cjf, com.tencent.mm.plugin.finder.utils.k.gm(this.scene, getCommentCount())));
        }
        bVar.dHv().getReplyBtn().setOnClickListener(new n(this, bVar));
        if (anVar != null) {
            FinderCommentFooter dHv4 = bVar.dHv();
            y yVar4 = y.vXH;
            String LD2 = y.LD(this.scene);
            y yVar5 = y.vXH;
            dHv4.e(LD2, y.hf(anVar.getUsername(), anVar.getNickname()), anVar);
        }
        if (dcC() != null) {
            if (i2 == 2) {
                com.tencent.mm.ui.g.a.a.c(dcC(), com.tencent.mm.model.z.aTY());
            } else {
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
                if (asG == null || (str = asG.cXH()) == null) {
                    str = "";
                }
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
                ImageView dcC = dcC();
                if (dcC == null) {
                    kotlin.g.b.p.hyc();
                }
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka.a(aVar2, dcC, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            }
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar8 = this.tMP;
        if (bVar8 != null) {
            bVar8.hideLoading();
        }
        if (!z) {
            if (!booleanValue) {
                mY(true);
                com.tencent.mm.plugin.finder.view.builder.b bVar9 = this.tMP;
                if (bVar9 != null) {
                    bVar9.showLoading();
                }
            } else if (!booleanValue || i3 != 0 || j2 != 0 || this.tNa) {
                com.tencent.mm.plugin.finder.view.builder.b bVar10 = this.tMP;
                if (!(bVar10 == null || (rlLayout3 = bVar10.getRlLayout()) == null || (recyclerView2 = rlLayout3.getRecyclerView()) == null || (adapter = recyclerView2.getAdapter()) == null)) {
                    adapter.notifyDataSetChanged();
                }
                com.tencent.mm.plugin.finder.view.builder.b bVar11 = this.tMP;
                if (!(bVar11 == null || (rlLayout2 = bVar11.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null)) {
                    recyclerView.post(new o(this, i3));
                }
            } else {
                this.lastBuffer = null;
                mX(true);
                mY(true);
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsr().value().intValue() == 1) {
                bVar.dHw().setBackgroundColorRes(R.color.ac_);
            } else {
                bVar.dHw().setBackgroundColorRes(R.color.ad);
            }
            bVar.dHw().setSquaresBackgroundResource(R.drawable.xf);
            bVar.getRlLayout().setVisibility(0);
            bVar.getHeaderLayout().setVisibility(0);
            if (!(finderItem.getCommentCount() != 0 || finderCommentDrawer.getReason() == 4 || (editText = getEditText()) == null)) {
                editText.postDelayed(new l(editText, this), 200);
            }
        } else {
            bVar.dHw().setSquaresBackgroundResource(R.color.ac_);
            bVar.dHw().setBackgroundColorRes(R.color.ac_);
            bVar.getHeaderLayout().setVisibility(8);
            bVar.getRlLayout().setVisibility(8);
            MMEditText editText2 = getEditText();
            if (editText2 != null) {
                editText2.requestFocus();
            }
            if (!(this.tAj || (bVar2 = this.tMP) == null || (dHv2 = bVar2.dHv()) == null)) {
                dHv2.cH(true);
            }
        }
        if (!(this.tMU || (bVar3 = this.tMP) == null || (rlLayout = bVar3.getRlLayout()) == null)) {
            RefreshLoadMoreLayout.e(rlLayout);
        }
        this.tNc.alive();
        AppMethodBeat.o(243746);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class m extends RefreshLoadMoreLayout.a {
        final /* synthetic */ f tNg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(f fVar) {
            this.tNg = fVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(165654);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            com.tencent.f.h.RTc.aX(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(165654);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ m tNy;

            a(m mVar) {
                this.tNy = mVar;
            }

            public final void run() {
                AppMethodBeat.i(165652);
                f.c(this.tNy.tNg);
                AppMethodBeat.o(165652);
            }
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(165655);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.a(cVar);
            f.d(this.tNg);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(165655);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ m tNy;

            b(m mVar) {
                this.tNy = mVar;
            }

            public final void run() {
                AppMethodBeat.i(165653);
                f.e(this.tNy.tNg);
                AppMethodBeat.o(165653);
            }
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(243743);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            com.tencent.f.h.RTc.aX(new b(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(243743);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(165657);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            f.f(this.tNg);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(165657);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ f tNg;
        final /* synthetic */ com.tencent.mm.plugin.finder.view.builder.b tNz;

        n(f fVar, com.tencent.mm.plugin.finder.view.builder.b bVar) {
            this.tNg = fVar;
            this.tNz = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178230);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f.a(this.tNg, this.tNz.dHv().getScene());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178230);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class o implements Runnable {
        final /* synthetic */ int prP;
        final /* synthetic */ f tNg;

        o(f fVar, int i2) {
            this.tNg = fVar;
            this.prP = i2;
        }

        public final void run() {
            RefreshLoadMoreLayout rlLayout;
            RecyclerView recyclerView;
            AppMethodBeat.i(178231);
            if (this.prP > 0 && this.prP < this.tNg.tMN.data.size()) {
                com.tencent.mm.plugin.finder.view.builder.b bVar = this.tNg.tMP;
                RecyclerView.LayoutManager layoutManager = (bVar == null || (rlLayout = bVar.getRlLayout()) == null || (recyclerView = rlLayout.getRecyclerView()) == null) ? null : recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(178231);
                    throw tVar;
                }
                ((LinearLayoutManager) layoutManager).ah(this.prP, 0);
            }
            AppMethodBeat.o(178231);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
    static final class l implements Runnable {
        final /* synthetic */ f tNg;
        final /* synthetic */ MMEditText tNx;

        l(MMEditText mMEditText, f fVar) {
            this.tNx = mMEditText;
            this.tNg = fVar;
        }

        public final void run() {
            com.tencent.mm.plugin.finder.view.builder.b bVar;
            FinderCommentFooter dHv;
            AppMethodBeat.i(243742);
            this.tNx.requestFocus();
            if (this.tNg.tAj || (bVar = this.tNg.tMP) == null || (dHv = bVar.dHv()) == null) {
                AppMethodBeat.o(243742);
                return;
            }
            dHv.cH(true);
            AppMethodBeat.o(243742);
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final int getCommentScene() {
        AppMethodBeat.i(243747);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.context);
        if (fH != null) {
            int i2 = fH.tCE;
            AppMethodBeat.o(243747);
            return i2;
        }
        AppMethodBeat.o(243747);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        int i2;
        RefreshLoadMoreLayout rlLayout;
        RefreshLoadMoreLayout rlLayout2;
        RecyclerView recyclerView;
        RefreshLoadMoreLayout rlLayout3;
        RecyclerView recyclerView2;
        RecyclerView.a adapter;
        RefreshLoadMoreLayout rlLayout4;
        int i3;
        RefreshLoadMoreLayout rlLayout5;
        RecyclerView recyclerView3;
        RecyclerView.a adapter2;
        FinderCommentFooter dHv;
        RefreshLoadMoreLayout rlLayout6;
        RecyclerView recyclerView4;
        RefreshLoadMoreLayout rlLayout7;
        RecyclerView recyclerView5;
        AppMethodBeat.i(165675);
        if (this.isDetached) {
            Log.i("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
            AppMethodBeat.o(165675);
            return;
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.context);
        if (fH != null) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            String str = fH.sessionId;
            String str2 = fH.sGE;
            String str3 = fH.sGQ;
            int i4 = fH.tCE;
            FinderItem finderItem = this.tMO;
            if (finderItem == null) {
                kotlin.g.b.p.btv("feedObj");
            }
            long longValue = (finderItem != null ? Long.valueOf(finderItem.getId()) : null).longValue();
            long j2 = this.sGC;
            long currentTimeMillis = System.currentTimeMillis();
            FinderCommentDrawer finderCommentDrawer = this.tNb;
            com.tencent.mm.plugin.finder.report.k.a(str, str2, str3, i4, longValue, j2, currentTimeMillis, finderCommentDrawer != null ? finderCommentDrawer.getReason() : 0);
        }
        this.isDetached = true;
        this.tMY = false;
        com.tencent.mm.loader.g.i iVar = this.tMX;
        if (iVar != null) {
            iVar.stop();
        }
        this.tMX = null;
        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
        if (((bVar == null || (rlLayout7 = bVar.getRlLayout()) == null || (recyclerView5 = rlLayout7.getRecyclerView()) == null) ? null : recyclerView5.getLayoutManager()) instanceof LinearLayoutManager) {
            com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tMP;
            RecyclerView.LayoutManager layoutManager = (bVar2 == null || (rlLayout6 = bVar2.getRlLayout()) == null || (recyclerView4 = rlLayout6.getRecyclerView()) == null) ? null : recyclerView4.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(165675);
                throw tVar;
            }
            i2 = ((LinearLayoutManager) layoutManager).ks();
        } else {
            i2 = -1;
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar3 = this.tMP;
        if (!(bVar3 == null || (dHv = bVar3.dHv()) == null)) {
            dHv.setFooterMode(0);
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar4 = this.tMP;
        if (!(bVar4 == null || (rlLayout5 = bVar4.getRlLayout()) == null || (recyclerView3 = rlLayout5.getRecyclerView()) == null || (adapter2 = recyclerView3.getAdapter()) == null)) {
            adapter2.b(this.tNe);
        }
        Iterator<T> it = this.tLP.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.tLP.clear();
        EventCenter.instance.removeListener(this.tNd);
        FinderItem finderItem2 = this.tMO;
        if (finderItem2 == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        finderItem2.setCommentCount(getCommentCount());
        e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        FinderItem finderItem3 = this.tMO;
        if (finderItem3 == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        e.a.n(finderItem3);
        StringBuilder sb = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
        FinderItem finderItem4 = this.tMO;
        if (finderItem4 == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        Log.i("Finder.DrawerPresenter", sb.append(finderItem4.getId()).append(" commentCount ").append(getCommentCount()).toString());
        CommentDrawerContract.CloseDrawerCallback closeDrawerCallback = this.tMR;
        if (closeDrawerCallback != null) {
            closeDrawerCallback.g(getCommentCount(), this.tMN.data);
        }
        if (this.tMV || !this.efT) {
            this.tMN.nc(true);
        } else {
            if (this.tuj != 0) {
                int i5 = 0;
                for (T t2 : this.tMN.data) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        kotlin.a.j.hxH();
                    }
                    T t3 = t2;
                    if (t3.lT() == this.tuj) {
                        t3.uOc = false;
                        i3 = i5;
                    } else {
                        i3 = i2;
                    }
                    i5 = i6;
                    i2 = i3;
                }
            }
            com.tencent.mm.plugin.finder.feed.model.c cVar = this.tMN;
            com.tencent.mm.bw.b bVar5 = this.lastBuffer;
            boolean z = this.tMT;
            boolean z2 = this.tMU;
            boolean z3 = this.tNa;
            com.tencent.mm.plugin.finder.model.t tVar2 = cVar.tUL;
            if (tVar2 != null) {
                cVar.data.remove(tVar2);
            }
            cVar.tUL = null;
            if (cVar.data.size() >= 0 && i2 >= 0) {
                c.a.a(cVar.tUJ, cVar.tUK, cVar.data);
            }
            cVar.data.clear();
            if (i2 >= 0 && !com.tencent.mm.plugin.finder.feed.model.c.tUM) {
                com.tencent.mm.plugin.finder.storage.data.f.vGd.a(cVar.tUJ, cVar.tUK, i2, bVar5, z, z2, z3);
            }
        }
        this.lastBuffer = null;
        mW(false);
        mX(true);
        MMEditText editText = getEditText();
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar6 = this.tMP;
        if (!(bVar6 == null || (rlLayout4 = bVar6.getRlLayout()) == null)) {
            rlLayout4.setHasBottomMore(true);
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar7 = this.tMP;
        if (!(bVar7 == null || (rlLayout3 = bVar7.getRlLayout()) == null || (recyclerView2 = rlLayout3.getRecyclerView()) == null || (adapter = recyclerView2.getAdapter()) == null)) {
            adapter.notifyDataSetChanged();
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar8 = this.tMP;
        if (!(bVar8 == null || (rlLayout2 = bVar8.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null)) {
            recyclerView.setLayoutFrozen(true);
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar9 = this.tMP;
        if (!(bVar9 == null || (rlLayout = bVar9.getRlLayout()) == null)) {
            rlLayout.setActionCallback(null);
        }
        this.tMP = null;
        this.tNc.dead();
        AppMethodBeat.o(165675);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentFooter.b
    public final void onModeChange(int i2, int i3) {
        com.tencent.mm.plugin.finder.view.builder.b bVar;
        FinderCommentFooter dHv;
        FinderCommentDrawer dHw;
        RecyclerView recyclerView;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator duration;
        AppMethodBeat.i(165676);
        Log.i("Finder.DrawerPresenter", "[onModeChange] from=" + i2 + " to=" + i3);
        if (i3 == 0) {
            com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tMP;
            if (!(bVar2 == null || (dHw = bVar2.dHw()) == null || (recyclerView = dHw.getRecyclerView()) == null || (animate = recyclerView.animate()) == null || (translationY = animate.translationY(0.0f)) == null || (duration = translationY.setDuration(180)) == null)) {
                duration.start();
            }
            if (!(!this.isDetached || (bVar = this.tMP) == null || (dHv = bVar.dHv()) == null)) {
                y yVar = y.vXH;
                String LD = y.LD(this.scene);
                FinderItem finderItem = this.tMO;
                if (finderItem == null) {
                    kotlin.g.b.p.btv("feedObj");
                }
                dHv.hk(LD, finderItem.getNickName());
                AppMethodBeat.o(165676);
                return;
            }
        }
        AppMethodBeat.o(165676);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<hs> {
        final /* synthetic */ f tNg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.tNg = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hs hsVar) {
            hs.a aVar;
            FinderCommentDrawer dHw;
            AppMethodBeat.i(165631);
            hs hsVar2 = hsVar;
            if (hsVar2 == null || (aVar = hsVar2.dMm) == null || aVar.feedId != f.h(this.tNg).getId()) {
                AppMethodBeat.o(165631);
                return false;
            }
            b bVar = new b(this, hsVar2);
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
            if (kotlin.g.b.p.j(currentThread, mainLooper.getThread())) {
                bVar.invoke();
            } else {
                com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tNg.tMP;
                if (!(bVar2 == null || (dHw = bVar2.dHw()) == null)) {
                    dHw.post(new a(bVar));
                }
            }
            AppMethodBeat.o(165631);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;

            a(kotlin.g.a.a aVar) {
                this.qgW = aVar;
            }

            public final void run() {
                AppMethodBeat.i(165629);
                this.qgW.invoke();
                AppMethodBeat.o(165629);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ c tNi;
            final /* synthetic */ hs tNj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar, hs hsVar) {
                super(0);
                this.tNi = cVar;
                this.tNj = hsVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2;
                boolean z;
                RefreshLoadMoreLayout rlLayout;
                RecyclerView recyclerView;
                RefreshLoadMoreLayout rlLayout2;
                Boolean bool = null;
                boolean z2 = false;
                AppMethodBeat.i(165630);
                Boolean bool2 = Boolean.FALSE;
                int i3 = this.tNj.dMm.opType;
                a.C1279a aVar = com.tencent.mm.plugin.finder.storage.a.vwq;
                if (i3 == com.tencent.mm.plugin.finder.storage.a.vwp) {
                    int size = this.tNi.tNg.tMN.data.size();
                    b bVar = this.tNi.tNg.tMQ;
                    if (bVar != null) {
                        cd cdVar = this.tNj.dMm.dMo;
                        if (cdVar == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.LocalFinderCommentObject");
                            AppMethodBeat.o(165630);
                            throw tVar;
                        }
                        an anVar = (an) cdVar;
                        kotlin.g.b.p.h(anVar, "target");
                        com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        int b2 = bVar.tNg.tMN.b(com.tencent.mm.plugin.finder.storage.logic.a.b(anVar));
                        RecyclerView.a adapter = bVar.hak.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                        if (anVar.field_actionInfo.tuf != 0) {
                            com.tencent.mm.plugin.finder.view.builder.b bVar2 = bVar.tNg.tMP;
                            if (!(bVar2 == null || (rlLayout2 = bVar2.getRlLayout()) == null)) {
                                rlLayout2.ag(b.a.tNh);
                            }
                            com.tencent.mm.plugin.finder.view.builder.b bVar3 = bVar.tNg.tMP;
                            if (!(bVar3 == null || (rlLayout = bVar3.getRlLayout()) == null || (recyclerView = rlLayout.getRecyclerView()) == null)) {
                                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(b2, new com.tencent.mm.hellhoundlib.b.a());
                                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
                                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
                            }
                        }
                        bool = Boolean.TRUE;
                    }
                    int size2 = this.tNi.tNg.tMN.data.size();
                    FinderItem h2 = f.h(this.tNi.tNg);
                    h2.setCommentCount((size2 - size) + h2.getCommentCount());
                } else {
                    a.C1279a aVar3 = com.tencent.mm.plugin.finder.storage.a.vwq;
                    if (i3 == com.tencent.mm.plugin.finder.storage.a.vwo) {
                        b bVar4 = this.tNi.tNg.tMQ;
                        if (bVar4 != null) {
                            cd cdVar2 = this.tNj.dMm.dMo;
                            if (cdVar2 == null) {
                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.LocalFinderCommentObject");
                                AppMethodBeat.o(165630);
                                throw tVar2;
                            }
                            an anVar2 = (an) cdVar2;
                            kotlin.g.b.p.h(anVar2, "target");
                            com.tencent.mm.plugin.finder.feed.model.c cVar = bVar4.tNg.tMN;
                            kotlin.g.b.p.h(anVar2, "item");
                            if (anVar2.dyb().commentId != 0) {
                                Iterator<com.tencent.mm.plugin.finder.model.s> it = cVar.data.iterator();
                                i2 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        i2 = -1;
                                        break;
                                    }
                                    if (it.next().uOf.dyb().commentId == anVar2.dyb().commentId) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                Iterator<com.tencent.mm.plugin.finder.model.s> it2 = cVar.data.iterator();
                                i2 = 0;
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i2 = -1;
                                        break;
                                    }
                                    if (it2.next().uOf.field_localCommentId == anVar2.field_localCommentId) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            if (i2 >= 0 && i2 < cVar.data.size()) {
                                kotlin.g.b.p.h(anVar2, "<set-?>");
                                cVar.data.get(i2).uOf = anVar2;
                            }
                            kotlin.o oVar = new kotlin.o(Integer.valueOf(i2), 1);
                            int intValue = oVar.first.intValue();
                            oVar.second.intValue();
                            if (intValue >= 0) {
                                RecyclerView.a adapter2 = bVar4.hak.getAdapter();
                                if (intValue < (adapter2 != null ? adapter2.getItemCount() : 0)) {
                                    RecyclerView.a adapter3 = bVar4.hak.getAdapter();
                                    if (adapter3 != null) {
                                        adapter3.b(intValue, 1);
                                    }
                                    z2 = true;
                                }
                            }
                            bool = Boolean.valueOf(z2);
                        }
                    } else {
                        bool = bool2;
                    }
                }
                Log.i("Finder.DrawerPresenter", "[onNotifyChange] " + this.tNj + " result=" + bool);
                x xVar = x.SXb;
                AppMethodBeat.o(165630);
                return xVar;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015f  */
    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.ImageView r13, int r14) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.f.a(android.widget.ImageView, int):void");
    }

    public final void a(com.tencent.mm.plugin.finder.model.s sVar) {
        AppMethodBeat.i(165678);
        kotlin.g.b.p.h(sVar, "item");
        Context context2 = this.context;
        if (context2 != null) {
            com.tencent.mm.ui.base.h.a(context2, (int) R.string.d6h, 0, new DialogInterface$OnClickListenerC1146f(this, context2, sVar), (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(165678);
            return;
        }
        AppMethodBeat.o(165678);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final int dcA() {
        return this.scene;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final void af(View view, int i2) {
        RefreshLoadMoreLayout rlLayout;
        RecyclerView recyclerView;
        AppMethodBeat.i(165681);
        kotlin.g.b.p.h(view, "view");
        if (i2 < 0) {
            Log.i("Finder.DrawerPresenter", "onClickResendComment position:".concat(String.valueOf(i2)));
            AppMethodBeat.o(165681);
            return;
        }
        an anVar = this.tMN.IL(i2).uOf;
        if (anVar.field_state == -1) {
            b.a aVar = com.tencent.mm.plugin.finder.upload.b.vRM;
            com.tencent.mm.plugin.finder.upload.b bVar = com.tencent.mm.plugin.finder.upload.b.vRL;
            kotlin.g.b.p.h(anVar, "unsentComment");
            Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "rePost ".concat(String.valueOf(anVar)));
            anVar.field_state = 1;
            anVar.field_canRemove = 0;
            anVar.FC(cl.aWy() / 1000);
            anVar.field_postTime = cl.aWy();
            anVar.field_tryCount = 0;
            bVar.a(new com.tencent.mm.plugin.finder.upload.a(anVar));
            com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tMP;
            if (!(bVar2 == null || (rlLayout = bVar2.getRlLayout()) == null || (recyclerView = rlLayout.getRecyclerView()) == null)) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
                AppMethodBeat.o(165681);
                return;
            }
        }
        AppMethodBeat.o(165681);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final void a(View view, com.tencent.mm.plugin.finder.model.s sVar) {
        AppMethodBeat.i(243750);
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(sVar, "item");
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(view.getContext(), 1, false);
        FinderItem finderItem = this.tMO;
        if (finderItem == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        eVar.a(new a.C1326a(sVar, finderItem.getUserName()));
        eVar.a(new a.d(sVar, this.tMM, new p(this)));
        eVar.dGm();
        AppMethodBeat.o(243750);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final FinderItem dcB() {
        AppMethodBeat.i(165684);
        FinderItem finderItem = this.tMO;
        if (finderItem == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        AppMethodBeat.o(165684);
        return finderItem;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class h implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ f tNg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(f fVar) {
            this.tNg = fVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(165648);
            if (this.tNg.tzn) {
                s.a aVar = com.tencent.mm.plugin.finder.model.s.uOj;
                if (i2 == com.tencent.mm.plugin.finder.model.s.uOi) {
                    com.tencent.mm.plugin.finder.convert.j jVar = new com.tencent.mm.plugin.finder.convert.j(this.tNg);
                    AppMethodBeat.o(165648);
                    return jVar;
                }
                com.tencent.mm.plugin.finder.convert.h hVar = new com.tencent.mm.plugin.finder.convert.h(this.tNg, true);
                AppMethodBeat.o(165648);
                return hVar;
            }
            s.a aVar2 = com.tencent.mm.plugin.finder.model.s.uOj;
            if (i2 == com.tencent.mm.plugin.finder.model.s.uOg) {
                com.tencent.mm.plugin.finder.convert.h hVar2 = new com.tencent.mm.plugin.finder.convert.h(this.tNg, false);
                AppMethodBeat.o(165648);
                return hVar2;
            }
            s.a aVar3 = com.tencent.mm.plugin.finder.model.s.uOj;
            if (i2 == com.tencent.mm.plugin.finder.model.s.uOh) {
                com.tencent.mm.plugin.finder.convert.k kVar = new com.tencent.mm.plugin.finder.convert.k(this.tNg);
                AppMethodBeat.o(165648);
                return kVar;
            }
            s.a aVar4 = com.tencent.mm.plugin.finder.model.s.uOj;
            if (i2 == com.tencent.mm.plugin.finder.model.s.uOi) {
                com.tencent.mm.plugin.finder.convert.j jVar2 = new com.tencent.mm.plugin.finder.convert.j(this.tNg);
                AppMethodBeat.o(165648);
                return jVar2;
            }
            y yVar = y.vXH;
            y.dQ("Finder.DrawerPresenter", i2);
            com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
            AppMethodBeat.o(165648);
            return fVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final WxRecyclerAdapter<?> fm(Context context2) {
        AppMethodBeat.i(165685);
        kotlin.g.b.p.h(context2, "context");
        WxRecyclerAdapter<?> wxRecyclerAdapter = new WxRecyclerAdapter<>(new h(this), this.tMN.data);
        wxRecyclerAdapter.au(false);
        wxRecyclerAdapter.RqP = this;
        wxRecyclerAdapter.RqO = this;
        AppMethodBeat.o(165685);
        return wxRecyclerAdapter;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final RecyclerView.h fi(Context context2) {
        AppMethodBeat.i(165686);
        kotlin.g.b.p.h(context2, "context");
        int[] iArr = new int[4];
        iArr[0] = (int) context2.getResources().getDimension(R.dimen.cp);
        com.tencent.mm.plugin.finder.view.decoration.a aVar = new com.tencent.mm.plugin.finder.view.decoration.a(new ColorDrawable(context2.getResources().getColor(R.color.BW_90)), (int) context2.getResources().getDimension(R.dimen.a4d), iArr, (int) context2.getResources().getDimension(R.dimen.a4e));
        AppMethodBeat.o(165686);
        return aVar;
    }

    private final MMEditText getEditText() {
        FinderCommentFooter dHv;
        AppMethodBeat.i(165688);
        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
        if (bVar == null || (dHv = bVar.dHv()) == null) {
            AppMethodBeat.o(165688);
            return null;
        }
        MMEditText editText = dHv.getEditText();
        AppMethodBeat.o(165688);
        return editText;
    }

    private final ImageView dcC() {
        FinderCommentFooter dHv;
        AppMethodBeat.i(165689);
        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
        if (bVar == null || (dHv = bVar.dHv()) == null) {
            AppMethodBeat.o(165689);
            return null;
        }
        ImageView avatarView = dHv.getAvatarView();
        AppMethodBeat.o(165689);
        return avatarView;
    }

    private final Resources getResources() {
        Context context2;
        AppMethodBeat.i(165691);
        com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
        if (bVar == null || (context2 = bVar.getContext()) == null) {
            AppMethodBeat.o(165691);
            return null;
        }
        Resources resources = context2.getResources();
        AppMethodBeat.o(165691);
        return resources;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
    public static final class d extends RecyclerView.c {
        final /* synthetic */ f tNg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(f fVar) {
            this.tNg = fVar;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        @SuppressLint({"StringFormatMatches"})
        public final void onChanged() {
            AppMethodBeat.i(165632);
            super.onChanged();
            this.tNg.dcD();
            AppMethodBeat.o(165632);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(165633);
            super.onItemRangeInserted(i2, i3);
            this.tNg.dcD();
            AppMethodBeat.o(165633);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(165634);
            super.onItemRangeChanged(i2, i3);
            this.tNg.dcD();
            AppMethodBeat.o(165634);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(165635);
            super.onItemRangeChanged(i2, i3, obj);
            this.tNg.dcD();
            AppMethodBeat.o(165635);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(165636);
            super.onItemRangeRemoved(i2, i3);
            this.tNg.dcD();
            AppMethodBeat.o(165636);
        }
    }

    public final void dcD() {
        TextView dHs;
        TextView dHs2;
        String str = null;
        AppMethodBeat.i(178243);
        if (getCommentCount() <= 0) {
            com.tencent.mm.plugin.finder.view.builder.b bVar = this.tMP;
            if (bVar == null || (dHs2 = bVar.dHs()) == null) {
                AppMethodBeat.o(178243);
                return;
            }
            Resources resources = getResources();
            if (resources != null) {
                str = resources.getString(R.string.cj_);
            }
            dHs2.setText(str);
            AppMethodBeat.o(178243);
            return;
        }
        com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tMP;
        if (bVar2 == null || (dHs = bVar2.dHs()) == null) {
            AppMethodBeat.o(178243);
            return;
        }
        Resources resources2 = getResources();
        if (resources2 != null) {
            str = resources2.getString(R.string.cjf, String.valueOf(getCommentCount()));
        }
        dHs.setText(str);
        AppMethodBeat.o(178243);
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(165693);
        fVar.mY(true);
        AppMethodBeat.o(165693);
    }

    private final void mY(boolean z) {
        AppMethodBeat.i(165692);
        com.tencent.mm.loader.g.i iVar = this.tMX;
        if (iVar != null) {
            iVar.a(new com.tencent.mm.loader.g.h(new t(this, z)));
            AppMethodBeat.o(165692);
            return;
        }
        AppMethodBeat.o(165692);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final com.tencent.mm.plugin.finder.model.s EC(long j2) {
        T t2;
        boolean z;
        AppMethodBeat.i(178244);
        if (j2 == 0) {
            AppMethodBeat.o(178244);
            return null;
        }
        Iterator<T> it = this.tMN.data.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            T next = it.next();
            if (next.uOf.dyb().commentId == j2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t2 = next;
                break;
            }
        }
        T t3 = t2;
        AppMethodBeat.o(178244);
        return t3;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final void a(com.tencent.mm.plugin.finder.model.s sVar, boolean z) {
        int i2;
        boolean z2 = false;
        AppMethodBeat.i(178245);
        kotlin.g.b.p.h(sVar, "rootComment");
        this.tNa = true;
        z.d dVar = new z.d();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        dVar.SYE = i2;
        if (z) {
            LinkedList<FinderCommentInfo> linkedList = sVar.uOf.dyb().levelTwoComment;
            if (!Util.isNullOrNil(linkedList)) {
                Iterator<T> it = this.tMN.data.iterator();
                while (true) {
                    if (it.hasNext()) {
                        long j2 = it.next().uOf.dyb().commentId;
                        kotlin.g.b.p.g(linkedList, "level2Comments");
                        if (j2 == linkedList.getFirst().commentId) {
                            break;
                        }
                    } else {
                        com.tencent.mm.loader.g.i iVar = this.tMX;
                        if (iVar != null) {
                            iVar.a(new com.tencent.mm.loader.g.h(new g(this, linkedList, sVar)));
                        }
                        z2 = true;
                    }
                }
            }
            if (z2) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(sVar, 1, dVar.SYE);
                AppMethodBeat.o(178245);
                return;
            }
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(sVar, 2, dVar.SYE);
        } else {
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(sVar, 3, dVar.SYE);
        }
        com.tencent.mm.loader.g.i iVar2 = this.tMX;
        if (iVar2 != null) {
            iVar2.a(new com.tencent.mm.loader.g.h(new k(this, sVar, dVar, z)));
            AppMethodBeat.o(178245);
            return;
        }
        AppMethodBeat.o(178245);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final int dcE() {
        int i2;
        an anVar;
        AppMethodBeat.i(243751);
        ArrayList<com.tencent.mm.plugin.finder.model.s> arrayList = this.tMN.data;
        if (!Util.isNullOrNil(arrayList)) {
            com.tencent.mm.plugin.finder.model.s sVar = (com.tencent.mm.plugin.finder.model.s) kotlin.a.j.kt(arrayList);
            if (sVar == null || (anVar = sVar.uOf) == null) {
                i2 = -1;
                AppMethodBeat.o(243751);
                return i2;
            } else if (anVar.dyh()) {
                i2 = 0;
                AppMethodBeat.o(243751);
                return i2;
            }
        }
        i2 = -1;
        AppMethodBeat.o(243751);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final int dcF() {
        AppMethodBeat.i(243752);
        ArrayList<com.tencent.mm.plugin.finder.model.s> arrayList = this.tMN.data;
        if (!Util.isNullOrNil(arrayList)) {
            int i2 = 0;
            for (T t2 : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t3 = t2;
                if (t3.uOf.field_actionInfo.tuf != 0 || t3.uOf.dyh()) {
                    i2 = i3;
                } else {
                    AppMethodBeat.o(243752);
                    return i2;
                }
            }
        }
        AppMethodBeat.o(243752);
        return -1;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final void IG(int i2) {
        AppMethodBeat.i(178247);
        ArrayList<com.tencent.mm.plugin.finder.model.s> arrayList = this.tMN.data;
        Log.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + i2 + ", dataList size:" + arrayList.size() + ", canPreload:" + this.tMY);
        if (i2 >= 0 && i2 < arrayList.size()) {
            int size = arrayList.size() - i2;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (size <= com.tencent.mm.plugin.finder.storage.c.drR() && this.tMY) {
                this.tMY = false;
                com.tencent.mm.loader.g.i iVar = this.tMX;
                if (iVar != null) {
                    iVar.a(new com.tencent.mm.loader.g.h(new s(this)));
                    AppMethodBeat.o(178247);
                    return;
                }
            }
        }
        AppMethodBeat.o(178247);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final boolean isCommentClose() {
        return this.tMZ;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroid/support/v7/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"})
    public final class b {
        final RecyclerView hak;
        final /* synthetic */ f tNg;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            public static final a tNh = new a();

            static {
                AppMethodBeat.i(178221);
                AppMethodBeat.o(178221);
            }

            a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ x invoke() {
                return x.SXb;
            }
        }

        public b(f fVar, RecyclerView recyclerView) {
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            this.tNg = fVar;
            AppMethodBeat.i(165628);
            this.hak = recyclerView;
            AppMethodBeat.o(165628);
        }

        public final void a(long j2, long j3, boolean z) {
            RecyclerView.a adapter;
            boolean z2;
            AppMethodBeat.i(178222);
            if (j2 != 0) {
                int size = this.tNg.tMN.data.size();
                com.tencent.mm.plugin.finder.feed.model.c cVar = this.tNg.tMN;
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                int i3 = -1;
                for (T t : cVar.data) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    T t2 = t;
                    if (t2.uOf.dyb().commentId == j2) {
                        i3 = i2;
                    }
                    if (t2.uOf.dyb().commentId == j2 || t2.uOf.field_actionInfo.tuf == j2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(t);
                    }
                    i2 = i4;
                }
                ArrayList arrayList2 = arrayList;
                int size2 = arrayList2.size();
                cVar.data.removeAll(arrayList2);
                kotlin.o oVar = new kotlin.o(Integer.valueOf(i3), Integer.valueOf(size2));
                if (z && oVar.first.intValue() >= 0) {
                    if (oVar.second.intValue() + oVar.first.intValue() <= size && (adapter = this.hak.getAdapter()) != null) {
                        adapter.at(oVar.first.intValue(), oVar.second.intValue());
                    }
                }
            } else {
                this.tNg.tMN.EE(j3);
            }
            RecyclerView.a adapter2 = this.hak.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
                AppMethodBeat.o(178222);
                return;
            }
            AppMethodBeat.o(178222);
        }
    }

    private final int getCommentCount() {
        int i2;
        AppMethodBeat.i(165672);
        StringBuilder append = new StringBuilder("calculateCommentCount ").append(this.tMN.data.size()).append(", ");
        FinderItem finderItem = this.tMO;
        if (finderItem == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        Log.i("Finder.DrawerPresenter", append.append(finderItem.getCommentCount()).toString());
        int size = this.tMN.data.size();
        if (this.tMN.tUL == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        int i3 = size - i2;
        FinderItem finderItem2 = this.tMO;
        if (finderItem2 == null) {
            kotlin.g.b.p.btv("feedObj");
        }
        int max = Math.max(i3, finderItem2.getCommentCount());
        AppMethodBeat.o(165672);
        return max;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
    public final boolean b(com.tencent.mm.plugin.finder.model.s sVar, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(178246);
        kotlin.g.b.p.h(sVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        if (sVar.uOf.field_actionInfo.tuf == 0) {
            if (!z) {
                AppMethodBeat.o(178246);
                return false;
            }
            com.tencent.mm.plugin.finder.feed.model.c cVar = this.tMN;
            kotlin.g.b.p.h(sVar, "root");
            if (sVar.lT() != 0) {
                Iterator<T> it = cVar.data.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().uOf.field_actionInfo.tuf == sVar.lT()) {
                            z3 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z3 = false;
            if (!z3) {
                AppMethodBeat.o(178246);
                return true;
            }
            AppMethodBeat.o(178246);
            return false;
        } else if (z) {
            com.tencent.mm.plugin.finder.feed.model.c cVar2 = this.tMN;
            kotlin.g.b.p.h(sVar, "level2Comment");
            Iterator<T> it2 = cVar2.data.iterator();
            int i2 = 0;
            int i3 = -1;
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                T next = it2.next();
                int i4 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = next;
                if (!com.tencent.mm.plugin.finder.feed.model.c.b(t2, sVar)) {
                    if (i3 >= 0 && com.tencent.mm.plugin.finder.feed.model.c.a(t2, sVar)) {
                        Log.d(cVar2.TAG, "hasLevel2ItemAfter cur:" + i3 + ", after:" + i2);
                        z2 = true;
                        break;
                    }
                    i2 = i4;
                } else {
                    i3 = i2;
                    i2 = i4;
                }
            }
            if (!z2) {
                AppMethodBeat.o(178246);
                return true;
            }
            AppMethodBeat.o(178246);
            return false;
        } else if (!this.tMN.c(sVar)) {
            AppMethodBeat.o(178246);
            return true;
        } else {
            AppMethodBeat.o(178246);
            return false;
        }
    }

    public static final /* synthetic */ void c(f fVar) {
        AppMethodBeat.i(165696);
        com.tencent.mm.loader.g.i iVar = fVar.tMX;
        if (iVar != null) {
            iVar.a(new com.tencent.mm.loader.g.h(new j(fVar)));
            AppMethodBeat.o(165696);
            return;
        }
        AppMethodBeat.o(165696);
    }

    public static final /* synthetic */ void d(f fVar) {
        com.tencent.mm.plugin.finder.view.builder.b bVar;
        RefreshLoadMoreLayout rlLayout;
        AppMethodBeat.i(165697);
        if (fVar.tMU || (bVar = fVar.tMP) == null || (rlLayout = bVar.getRlLayout()) == null) {
            AppMethodBeat.o(165697);
            return;
        }
        RefreshLoadMoreLayout.e(rlLayout);
        AppMethodBeat.o(165697);
    }

    public static final /* synthetic */ void f(f fVar) {
        FinderCommentDrawer dHw;
        AppMethodBeat.i(165699);
        if (!fVar.tMT) {
            com.tencent.mm.plugin.finder.view.builder.b bVar = fVar.tMP;
            if (bVar != null) {
                bVar.pb(false);
            }
            com.tencent.mm.plugin.finder.view.builder.b bVar2 = fVar.tMP;
            if (!(bVar2 == null || (dHw = bVar2.dHw()) == null)) {
                dHw.hge();
                AppMethodBeat.o(165699);
                return;
            }
        }
        AppMethodBeat.o(165699);
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.finder.feed.f r35, int r36) {
        /*
        // Method dump skipped, instructions count: 1010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.f.a(com.tencent.mm.plugin.finder.feed.f, int):void");
    }

    public static final /* synthetic */ void a(f fVar, List list) {
        boolean z;
        AppMethodBeat.i(178249);
        if (fVar.tuj != 0) {
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                com.tencent.mm.plugin.finder.model.s sVar = (com.tencent.mm.plugin.finder.model.s) obj;
                boolean z2 = false;
                LinkedList<FinderCommentInfo> linkedList = sVar.uOf.dyb().levelTwoComment;
                if (linkedList != null) {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        if (it.next().commentId == fVar.tuj) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    LinkedList<FinderCommentInfo> linkedList2 = sVar.uOf.dyb().levelTwoComment;
                    kotlin.g.b.p.g(linkedList2, "root.commentObj.levelTwoComment");
                    ArrayList arrayList2 = new ArrayList();
                    for (T t2 : linkedList2) {
                        com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        kotlin.g.b.p.g(t2, "commentInfo");
                        FinderItem finderItem = fVar.tMO;
                        if (finderItem == null) {
                            kotlin.g.b.p.btv("feedObj");
                        }
                        com.tencent.mm.plugin.finder.model.s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(t2, finderItem.getId(), sVar.lT());
                        if (!fVar.tMW || b2.lT() != fVar.tuj) {
                            z = false;
                        } else {
                            z = true;
                        }
                        b2.uOb = z;
                        if (b2.uOb) {
                            fVar.tMW = false;
                        }
                        if (b2 != null) {
                            arrayList2.add(b2);
                        }
                    }
                    arrayList.addAll(arrayList2);
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3 = i4;
                }
            }
            if (i2 >= 0 && arrayList.size() > 0) {
                list.addAll(i2 + 1, arrayList);
                fVar.tNa = true;
            }
        }
        AppMethodBeat.o(178249);
    }

    public static final /* synthetic */ void a(f fVar, List list, List list2) {
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(178250);
        ArrayList arrayList = new ArrayList();
        ArrayList<FinderCommentInfo> arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FinderCommentInfo finderCommentInfo = ((an) it.next()).field_actionInfo.LAn;
            if (finderCommentInfo != null) {
                int i4 = 0;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    i3 = i4;
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (((FinderCommentInfo) it2.next()).commentId == finderCommentInfo.commentId) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    i4 = i3 + 1;
                }
                if (i3 < 0 && finderCommentInfo.commentId != 0) {
                    kotlin.g.b.p.g(finderCommentInfo, "rootComment");
                    arrayList2.add(finderCommentInfo);
                }
            }
        }
        for (FinderCommentInfo finderCommentInfo2 : arrayList2) {
            int i5 = 0;
            Iterator it3 = list2.iterator();
            while (true) {
                i2 = i5;
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((com.tencent.mm.plugin.finder.model.s) it3.next()).uOf.dyb().commentId == finderCommentInfo2.commentId) {
                    break;
                }
                i5 = i2 + 1;
            }
            if (i2 >= 0) {
                list2.remove(i2);
                Log.i("Finder.DrawerPresenter", "mergeLocalLevel2Comments, remove level1ExistIndex:" + i2 + ", id:" + finderCommentInfo2.commentId);
            }
            com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
            FinderItem finderItem = fVar.tMO;
            if (finderItem == null) {
                kotlin.g.b.p.btv("feedObj");
            }
            arrayList.add(com.tencent.mm.plugin.finder.storage.logic.a.b(finderCommentInfo2, finderItem.getId()));
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                an anVar = (an) it4.next();
                if (anVar.field_actionInfo.tuf == finderCommentInfo2.commentId) {
                    com.tencent.mm.plugin.finder.model.s sVar = new com.tencent.mm.plugin.finder.model.s(anVar);
                    sVar.uNY = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), anVar.getContent());
                    arrayList.add(sVar);
                }
            }
        }
        if (arrayList.size() > 0) {
            Log.i("Finder.DrawerPresenter", "mergeLocalLevel2Comments, total local size: " + arrayList.size() + ", level1 size:" + arrayList2.size());
        }
        list2.addAll(arrayList);
        AppMethodBeat.o(178250);
    }

    public static final /* synthetic */ List b(f fVar, List list) {
        AppMethodBeat.i(243754);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            com.tencent.mm.plugin.finder.model.s sVar = (com.tencent.mm.plugin.finder.model.s) obj;
            arrayList.add(sVar);
            if (sVar.uOf.field_actionInfo.tuf == 0 && sVar.uOf.dyb().levelTwoComment.size() > 0 && (i2 >= list.size() - 1 || ((com.tencent.mm.plugin.finder.model.s) list.get(i2 + 1)).uOf.field_actionInfo.tuf == 0)) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dso().value().intValue() == 1) {
                    int size = sVar.uOf.dyb().levelTwoComment.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        FinderCommentInfo remove = sVar.uOf.dyb().levelTwoComment.remove();
                        com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        kotlin.g.b.p.g(remove, "level2Comment");
                        FinderItem finderItem = fVar.tMO;
                        if (finderItem == null) {
                            kotlin.g.b.p.btv("feedObj");
                        }
                        com.tencent.mm.plugin.finder.model.s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(remove, finderItem.getId(), sVar.lT());
                        b2.uOe = true;
                        arrayList.add(b2);
                    }
                    sVar.uOd -= size;
                    if (sVar.uOd < 0) {
                        sVar.uOd = 0;
                    }
                }
            }
            i2 = i3;
        }
        AppMethodBeat.o(243754);
        return arrayList;
    }

    public static final /* synthetic */ void a(f fVar, List list, com.tencent.mm.plugin.finder.model.s sVar, boolean z) {
        com.tencent.mm.plugin.finder.view.builder.b bVar;
        RefreshLoadMoreLayout rlLayout;
        RecyclerView recyclerView;
        RecyclerView.a adapter;
        RefreshLoadMoreLayout rlLayout2;
        AppMethodBeat.i(178251);
        com.tencent.mm.plugin.finder.feed.model.c cVar = fVar.tMN;
        kotlin.g.b.p.h(list, "itemList");
        kotlin.g.b.p.h(sVar, "rootComment");
        List<com.tencent.mm.plugin.finder.model.s> dV = cVar.dV(list);
        if (dV.size() > 1) {
            kotlin.a.j.a((List) dV, (Comparator) new c.C1158c());
        }
        int t2 = cVar.t(sVar.uOf.dyb().commentId, z);
        cVar.data.addAll(t2, dV);
        kotlin.o oVar = new kotlin.o(Integer.valueOf(t2), Integer.valueOf(dV.size()));
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        Log.i("Finder.DrawerPresenter", "insertLevel2CommentsAndNotify, positionInsert:" + intValue + ", itemCount:" + intValue2 + ", level2Comments size:" + list.size() + ", down:" + z + ", rootCommentId:" + sVar.lT());
        if (intValue2 < 0 || intValue < 0 || intValue >= fVar.tMN.data.size() || intValue + intValue2 > fVar.tMN.data.size() || (bVar = fVar.tMP) == null || (rlLayout = bVar.getRlLayout()) == null || (recyclerView = rlLayout.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null) {
            AppMethodBeat.o(178251);
            return;
        }
        if (intValue2 > 0) {
            adapter.as(intValue, intValue2);
        }
        if (!z || intValue - 1 < 0) {
            if (!z && intValue + intValue2 < fVar.tMN.data.size()) {
                adapter.b(intValue2 + intValue, 1);
            }
            AppMethodBeat.o(178251);
            return;
        }
        adapter.b(intValue - 1, 1);
        com.tencent.mm.plugin.finder.view.builder.b bVar2 = fVar.tMP;
        if (bVar2 == null || (rlLayout2 = bVar2.getRlLayout()) == null) {
            AppMethodBeat.o(178251);
            return;
        }
        rlLayout2.ag(i.tNt);
        AppMethodBeat.o(178251);
    }
}

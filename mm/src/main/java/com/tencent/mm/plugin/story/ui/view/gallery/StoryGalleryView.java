package com.tencent.mm.plugin.story.ui.view.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jr;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.ui.StoryRangeDetailUI;
import com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u000b*\u00023[\u0018\u0000 Á\u00012\u00020\u0001:\u0004Á\u0001Â\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\u0002\u0010\u000eJ\b\u0010|\u001a\u00020\"H\u0002J\b\u0010}\u001a\u00020\"H\u0002J\u0013\u0010~\u001a\u00020\"2\t\u0010\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010\u0001\u001a\u00020\"2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0001\u001a\u00020\u0007J\t\u0010\u0001\u001a\u00020\"H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J\t\u0010\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0002J\t\u0010\u0001\u001a\u00020\"H\u0002J\t\u0010\u0001\u001a\u00020\tH\u0002J\t\u0010\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0002J\t\u0010\u0001\u001a\u00020\"H\u0016J\u001d\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010RH\u0002J\u0012\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J(\u0010 \u0001\u001a\u00020\"2\u0007\u0010¡\u0001\u001a\u00020\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010>2\t\u0010£\u0001\u001a\u0004\u0018\u00010WH\u0002J\t\u0010¤\u0001\u001a\u00020\"H\u0002J\t\u0010¥\u0001\u001a\u00020\"H\u0002J\t\u0010¦\u0001\u001a\u00020\"H\u0016J\t\u0010§\u0001\u001a\u00020\"H\u0016J\u0012\u0010¨\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020\tH\u0016J#\u0010ª\u0001\u001a\u00020\"2\u0006\u0010H\u001a\u00020\t2\u0007\u0010«\u0001\u001a\u00020\t2\u0007\u0010©\u0001\u001a\u00020\tH\u0016J\u0012\u0010¬\u0001\u001a\u00020\"2\u0007\u0010­\u0001\u001a\u00020\u0016H\u0002J\t\u0010®\u0001\u001a\u00020\"H\u0002J\u0012\u0010¯\u0001\u001a\u00020\"2\u0007\u0010°\u0001\u001a\u00020NH\u0002J\u0007\u0010±\u0001\u001a\u00020\"J\u0010\u0010²\u0001\u001a\u00020\"2\u0007\u0010³\u0001\u001a\u00020\tJ\u0012\u0010´\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010µ\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010¶\u0001\u001a\u00020\"2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0002J\u0015\u0010¹\u0001\u001a\u00020\"2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016J\u0007\u0010º\u0001\u001a\u00020\"J\u0010\u0010»\u0001\u001a\u00020\"2\u0007\u0010¼\u0001\u001a\u000208J\u0014\u0010½\u0001\u001a\u00020\"2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010¾\u0001\u001a\u00020\"H\u0016J\u0012\u0010¿\u0001\u001a\u00020\"2\u0007\u0010À\u0001\u001a\u00020\tH\u0002R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fX\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0004¢\u0006\u0004\n\u0002\u00104R>\u00105\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060\u000bj\b\u0012\u0004\u0012\u000206`\r0\u000bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060\u000bj\b\u0012\u0004\u0012\u000206`\r`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010(\"\u0004\bG\u0010*R\u000e\u0010H\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R\u000e\u0010K\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020[X\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0019\"\u0004\bh\u0010\u001bR\u0010\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010o\u001a\u00060pR\u00020nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020vX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010(\"\u0004\b{\u0010*¨\u0006Ã\u0001"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "expectPos", "", "needAction", "", "checkedFavList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;IZLjava/util/ArrayList;)V", "activePanel", "addReadNumRunnable", "Ljava/lang/Runnable;", "browseUIListener", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "canDragScale", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getCheckedFavList", "()Ljava/util/ArrayList;", "clickListener", "Lkotlin/Function0;", "commentPostStateListener", "Lkotlin/Function2;", "", "commentScrolling", "currentItemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "deleteWhenFirstEmpty", "getDeleteWhenFirstEmpty", "()Z", "setDeleteWhenFirstEmpty", "(Z)V", "dirty", "dragCloseConsumer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "getExpectPos", "()I", "galleryContainer", "Landroid/widget/FrameLayout;", "galleryGroupUpdateCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1;", "galleryGroups", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "getGalleryType", "()Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "hRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "hasDispatchCancel", "holderView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "horizontalAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "isFirstPost", "setFirstPost", "isMute", "isNeedReset", "setNeedReset", "isSelf", "jumpItemReport", "lastItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "lastSelectColumn", "mIsActive", "maskView", "Landroid/view/View;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "needCancelTouch", "pageIndicator", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "pageSnapHelper", "Landroid/support/v7/widget/PagerSnapHelper;", "postListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1;", "presenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "pullDownHint", "Landroid/widget/TextView;", "pullDownListView", "scrollUpHintCheck", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "selectedColumn", "selectedRow", "sessionId", "getSessionId", "setSessionId", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vLogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "vRecyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "verticalAdapter", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "verticalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "verticalScrollOffset", "", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "videoViewMgrFromPreLoad", "getVideoViewMgrFromPreLoad", "setVideoViewMgrFromPreLoad", "addListeners", "addVideoReadNumber", "bindPullDownListView", "wrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "canScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "centerLayoutParams", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "checkDoPreloadBeforeEnterGallery", "verticalIndex", "horizontalIndex", "checkLayoutEnv", "checkUpdate", "contentScrollType", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fadeInMaskView", "fadeOutMaskView", "needVerticalControl", "onBackPressed", "onClosing", "offset", "onDeleteStory", "onDestroy", "onItemSelected", "position", "childView", "onListInnerScroll", "onOpening", "onPause", "onPreImageMode", "onPreVideoMode", "onResume", "onRowSelected", "row", "rowView", "horizontalControlView", "onSetFavoriteStory", "onSetPrivacy", "onStart", "onStop", "onSwitchImageMode", "enableReport", "onSwitchVideoMode", "fromPreCache", "remixItem", "taskId", "removeListeners", "resendItem", "storyVideoItem", "reset", "setCanDragScale", "canScale", "setCurrentHItem", "setCurrentVItem", "setDataInternal", "dataSeed", "", "setDataSeed", "setFilterList", "setGalleryScaleListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStoryBrowseUIListener", "showPullDownHint", "toggleActiveState", "newActive", "Companion", "IOnGalleryScale", "plugin-story_release"})
public final class StoryGalleryView extends AbsStoryGallery {
    public static final a FGV = new a((byte) 0);
    private static final String TAG = TAG;
    private final kotlin.g.a.a<Boolean> FEi;
    private final n.a FFH;
    private b FFz;
    private final GalleryRecyclerView FGA;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> FGB;
    private com.tencent.mm.plugin.story.g.f FGC;
    private com.tencent.mm.plugin.story.api.g FGD;
    private boolean FGE;
    private c FGF;
    private final GalleryVerticalControlView FGG;
    private a FGH;
    private com.tencent.mm.plugin.vlog.ui.preview.a FGI;
    private final e FGJ;
    private boolean FGK;
    private final kotlin.g.a.m<Boolean, Long, x> FGL;
    private final g FGM;
    private int FGN;
    private boolean FGO;
    private com.tencent.mm.plugin.story.f.d.j FGP;
    private boolean FGQ;
    private boolean FGR;
    private final o FGS;
    private Runnable FGT;
    private final ArrayList<Long> FGU;
    private n FGc;
    private l FGd;
    private boolean FGm;
    private boolean FGn;
    private View FGo;
    private final TextView FGp;
    private StoryGalleryItemView FGq;
    private FrameLayout FGr;
    private RecyclerView FGs;
    private GalleryHorizontalControlView FGt;
    private com.tencent.mm.plugin.story.ui.a.g FGu;
    private final ak FGv;
    private final i FGw;
    private int FGx;
    private float FGy;
    private final GalleryRecyclerView.b FGz;
    private final int FrQ;
    private int Fre;
    private boolean dJM;
    private boolean dirty;
    private com.tencent.mm.ui.m.b gZR;
    private boolean guh;
    private boolean hVn;
    private boolean hVo;
    private boolean hVp;
    private final GalleryHolderView holderView;
    private String jVv;
    private boolean mIsActive;
    private View maskView;
    private String sessionId;
    private com.tencent.mm.ui.base.q tipDialog;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public interface b {
        void aJl();

        void ca(float f2);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "state", "", FirebaseAnalytics.b.INDEX, "isSelf", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.q<Integer, Integer, Boolean, x> {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(StoryGalleryView storyGalleryView) {
            super(3);
            this.FGW = storyGalleryView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Integer num, Integer num2, Boolean bool) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(120459);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            boolean booleanValue = bool.booleanValue();
            this.FGW.hVn = intValue == 3;
            GalleryRecyclerView galleryRecyclerView = this.FGW.FGA;
            if (!this.FGW.hVn) {
                z = true;
            } else {
                z = false;
            }
            galleryRecyclerView.setScrollEnable(z);
            StoryGalleryView storyGalleryView = this.FGW;
            if (intValue == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            storyGalleryView.hVo = z2;
            MMHandlerThread.removeRunnable(this.FGW.gZR.had);
            com.tencent.mm.ui.m.b bVar = this.FGW.gZR;
            if (this.FGW.hVn) {
                z3 = false;
            }
            bVar.QnF = z3;
            com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
            if (fVar != null) {
                fVar.B(intValue, intValue2, booleanValue);
            }
            if (intValue == 3) {
                this.FGW.FGG.setVisibility(4);
                GalleryHorizontalControlView galleryHorizontalControlView = this.FGW.FGt;
                if (galleryHorizontalControlView != null) {
                    galleryHorizontalControlView.setVisibility(4);
                }
            } else {
                this.FGW.FGG.setVisibility(0);
                GalleryHorizontalControlView galleryHorizontalControlView2 = this.FGW.FGt;
                if (galleryHorizontalControlView2 != null) {
                    galleryHorizontalControlView2.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120459);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", FirebaseAnalytics.b.INDEX, "", "isSelf", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Boolean, x> {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(StoryGalleryView storyGalleryView) {
            super(2);
            this.FGW = storyGalleryView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Boolean bool) {
            AppMethodBeat.i(120460);
            int intValue = num.intValue();
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
            if (fVar != null) {
                fVar.B(3, intValue, booleanValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120460);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(StoryGalleryView storyGalleryView) {
            super(1);
            this.FGW = storyGalleryView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(120461);
            int intValue = num.intValue();
            this.FGW.hVn = intValue == 3;
            GalleryRecyclerView galleryRecyclerView = this.FGW.FGA;
            if (!this.FGW.hVn) {
                z = true;
            } else {
                z = false;
            }
            galleryRecyclerView.setScrollEnable(z);
            StoryGalleryView storyGalleryView = this.FGW;
            if (intValue == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            storyGalleryView.hVo = z2;
            MMHandlerThread.removeRunnable(this.FGW.gZR.had);
            com.tencent.mm.ui.m.b bVar = this.FGW.gZR;
            if (this.FGW.hVn) {
                z3 = false;
            }
            bVar.QnF = z3;
            x xVar = x.SXb;
            AppMethodBeat.o(120461);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.m<Integer, View, x> {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(StoryGalleryView storyGalleryView) {
            super(2);
            this.FGW = storyGalleryView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, View view) {
            AppMethodBeat.i(120462);
            int intValue = num.intValue();
            View view2 = view;
            kotlin.g.b.p.h(view2, "child");
            StoryGalleryView.a(this.FGW, intValue, view2);
            x xVar = x.SXb;
            AppMethodBeat.o(120462);
            return xVar;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoryGalleryView(Context context, n.a aVar, int i2, boolean z, ArrayList arrayList, int i3) {
        this(context, aVar, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) == 0 ? z : false, (i3 & 16) != 0 ? new ArrayList() : arrayList);
        AppMethodBeat.i(120504);
        AppMethodBeat.o(120504);
    }

    public static final /* synthetic */ void a(StoryGalleryView storyGalleryView, Object obj) {
        AppMethodBeat.i(120507);
        storyGalleryView.setDataInternal(obj);
        AppMethodBeat.o(120507);
    }

    public static final /* synthetic */ void d(StoryGalleryView storyGalleryView, boolean z) {
        AppMethodBeat.i(120513);
        storyGalleryView.wa(z);
        AppMethodBeat.o(120513);
    }

    public final ArrayList<Long> getCheckedFavList() {
        return this.FGU;
    }

    public final int getExpectPos() {
        return this.FrQ;
    }

    public final n.a getGalleryType() {
        return this.FFH;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryGalleryView(final Context context, n.a aVar, int i2, boolean z, ArrayList<Long> arrayList) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(aVar, "galleryType");
        kotlin.g.b.p.h(arrayList, "checkedFavList");
        AppMethodBeat.i(120503);
        this.FFH = aVar;
        this.FrQ = i2;
        this.FGU = arrayList;
        this.FGw = new i();
        this.Fre = -1;
        this.FGx = -1;
        this.dirty = true;
        this.FGB = new ArrayList<>();
        this.FGK = true;
        Log.i(TAG, " StoryGalleryView " + this.FFH);
        o oVar = o.FIq;
        n fsK = o.fsK();
        if (fsK == null) {
            this.FGc = new n();
            this.FGm = false;
        } else {
            this.FGm = true;
            this.FGc = fsK;
        }
        this.FGd = new l();
        this.FGI = new com.tencent.mm.plugin.vlog.ui.preview.a();
        o oVar2 = o.FIq;
        o.clean();
        this.FGv = new i();
        this.gZR = new com.tencent.mm.ui.m.b(context);
        View.inflate(context, R.layout.c0_, this);
        View findViewById = findViewById(R.id.ib5);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.story_gallery_recycler)");
        this.FGA = (GalleryRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.iay);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.story_gallery_mask_view)");
        this.maskView = findViewById2;
        View findViewById3 = findViewById(R.id.iau);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.story_gallery_holder_layout)");
        this.holderView = (GalleryHolderView) findViewById3;
        View findViewById4 = findViewById(R.id.iam);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.story_gallery_control_layout)");
        this.FGG = (GalleryVerticalControlView) findViewById4;
        View findViewById5 = findViewById(R.id.ial);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.story_gallery_container)");
        this.FGr = (FrameLayout) findViewById5;
        ViewGroup.LayoutParams layoutParams = this.FGG.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(120503);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i3 = layoutParams2.topMargin;
        layoutParams2.setMargins(0, ao.aQ(context) ? i3 + ao.aP(context) : i3, 0, 0);
        this.FGG.setLayoutParams(layoutParams2);
        View findViewById6 = findViewById(R.id.ici);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.story_pull_hint)");
        this.FGp = (TextView) findViewById6;
        this.FGG.setOnAllFav(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass1 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120419);
                int size = this.FGW.FGB.size();
                int i2 = this.FGW.Fre;
                if (i2 >= 0 && size > i2) {
                    int size2 = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size();
                    int i3 = this.FGW.FGx;
                    if (i3 >= 0 && size2 > i3) {
                        Intent intent = new Intent(context, StoryFavAlbumUI.class);
                        Object obj = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).get(this.FGW.FGx);
                        kotlin.g.b.p.g(obj, "galleryGroups[selectedRow][selectedColumn]");
                        intent.putExtra(ch.COL_USERNAME, ((com.tencent.mm.plugin.story.f.d.h) obj).userName);
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$1", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$1", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120419);
                return xVar;
            }
        });
        GalleryVerticalControlView galleryVerticalControlView = this.FGG;
        n.a aVar2 = this.FFH;
        kotlin.g.b.p.h(aVar2, "galleryType");
        galleryVerticalControlView.FFH = aVar2;
        switch (g.$EnumSwitchMapping$0[aVar2.ordinal()]) {
            case 1:
                galleryVerticalControlView.FFI = new com.tencent.mm.plugin.story.ui.a.b();
                Context context2 = galleryVerticalControlView.getContext();
                kotlin.g.b.p.g(context2, "context");
                galleryVerticalControlView.FFJ = new AvatarLayoutManager(context2);
                galleryVerticalControlView.DnY.setVisibility(8);
                ViewGroup.LayoutParams layoutParams3 = galleryVerticalControlView.jBO.getLayoutParams();
                if (layoutParams3 != null) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    layoutParams4.setMarginStart(com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 64));
                    layoutParams4.setMarginEnd(com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 20));
                    layoutParams4.addRule(17, galleryVerticalControlView.FFB.getId());
                    layoutParams4.addRule(21);
                    break;
                } else {
                    t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(120503);
                    throw tVar2;
                }
            case 2:
                galleryVerticalControlView.jBO.setVisibility(8);
                galleryVerticalControlView.DnY.setVisibility(8);
                if (!z) {
                    galleryVerticalControlView.FFF.setVisibility(8);
                    break;
                } else {
                    galleryVerticalControlView.FFF.setVisibility(0);
                    break;
                }
            case 3:
                galleryVerticalControlView.jBO.setVisibility(8);
                galleryVerticalControlView.FFF.setVisibility(8);
                galleryVerticalControlView.DnY.setVisibility(8);
                galleryVerticalControlView.FFG.setVisibility(0);
                break;
            case 4:
                galleryVerticalControlView.jBO.setVisibility(8);
                galleryVerticalControlView.DnY.bringToFront();
                if (z) {
                    galleryVerticalControlView.FFF.setVisibility(0);
                } else {
                    galleryVerticalControlView.FFF.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams5 = galleryVerticalControlView.FFF.getLayoutParams();
                if (layoutParams5 != null) {
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                    layoutParams6.removeRule(21);
                    layoutParams6.addRule(16, galleryVerticalControlView.DnY.getId());
                    layoutParams6.setMarginEnd(com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 4));
                    break;
                } else {
                    t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(120503);
                    throw tVar3;
                }
            case 5:
                galleryVerticalControlView.FFI = new com.tencent.mm.plugin.story.ui.a.c();
                Context context3 = galleryVerticalControlView.getContext();
                kotlin.g.b.p.g(context3, "context");
                galleryVerticalControlView.FFJ = new AvatarLayoutManager(context3);
                galleryVerticalControlView.DnY.bringToFront();
                ViewGroup.LayoutParams layoutParams7 = galleryVerticalControlView.jBO.getLayoutParams();
                if (layoutParams7 != null) {
                    RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
                    layoutParams8.setMarginStart(0);
                    layoutParams8.setMarginEnd(0);
                    layoutParams8.removeRule(17);
                    layoutParams8.removeRule(21);
                    layoutParams8.addRule(13);
                    ViewGroup.LayoutParams layoutParams9 = galleryVerticalControlView.FFD.getLayoutParams();
                    if (layoutParams9 != null) {
                        ((FrameLayout.LayoutParams) layoutParams9).height = com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 96);
                        break;
                    } else {
                        t tVar4 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        AppMethodBeat.o(120503);
                        throw tVar4;
                    }
                } else {
                    t tVar5 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(120503);
                    throw tVar5;
                }
            case 6:
            case 7:
                galleryVerticalControlView.DnY.setVisibility(8);
                break;
        }
        galleryVerticalControlView.FFD.setLayoutManager(galleryVerticalControlView.FFJ);
        galleryVerticalControlView.FFD.setAdapter(galleryVerticalControlView.FFI);
        galleryVerticalControlView.FFD.setFocusable(false);
        this.holderView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass4 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.story.api.g gVar;
                AppMethodBeat.i(120422);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.FGW.FGB.size() == 1 && ((ArrayList) this.FGW.FGB.get(0)).isEmpty() && (gVar = this.FGW.FGD) != null) {
                    gVar.eEd();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120422);
            }
        });
        this.FGz = new GalleryRecyclerView.b();
        this.FGA.setAdapter(this.FGz);
        this.FGA.setFocusable(false);
        this.FGA.setOnRowSelected(new kotlin.g.a.q<Integer, RecyclerView, GalleryHorizontalControlView, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass5 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(Integer num, RecyclerView recyclerView, GalleryHorizontalControlView galleryHorizontalControlView) {
                AppMethodBeat.i(120423);
                StoryGalleryView.a(this.FGW, num.intValue(), recyclerView, galleryHorizontalControlView);
                x xVar = x.SXb;
                AppMethodBeat.o(120423);
                return xVar;
            }
        });
        this.FGA.setOnScrollCallback(new kotlin.g.a.m<Integer, Float, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass6 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, Float f2) {
                int fromDPToPix;
                AppMethodBeat.i(120424);
                int intValue = num.intValue();
                float floatValue = f2.floatValue();
                this.FGW.FGy = ((float) intValue) + floatValue;
                GalleryVerticalControlView galleryVerticalControlView = this.FGW.FGG;
                int i2 = intValue + 1;
                float f3 = 1.0f - floatValue;
                if (galleryVerticalControlView.FFH == n.a.MultiUserGallery) {
                    fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 52);
                } else {
                    fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(galleryVerticalControlView.getContext(), 32);
                }
                AvatarLayoutManager avatarLayoutManager = galleryVerticalControlView.FFJ;
                if (avatarLayoutManager != null) {
                    avatarLayoutManager.ah(i2, (int) (((float) fromDPToPix) * f3));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120424);
                return xVar;
            }
        });
        this.FGz.FFg = new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass7 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(120425);
                int intValue = num.intValue();
                com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
                if (fVar != null) {
                    fVar.aaO(intValue);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120425);
                return xVar;
            }
        };
        this.FGG.setOnClose(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass8 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120426);
                if (this.FGW.FFz != null) {
                    com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.aaT(12);
                    b bVar = this.FGW.FFz;
                    if (bVar != null) {
                        bVar.aJl();
                    }
                } else {
                    com.tencent.mm.plugin.story.api.g gVar = this.FGW.FGD;
                    if (gVar != null) {
                        gVar.eEd();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120426);
                return xVar;
            }
        });
        this.FGG.setOnMenu(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass9 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                a aVar;
                a aVar2;
                boolean z;
                boolean z2;
                a aVar3;
                boolean z3;
                com.tencent.mm.plugin.story.i.j jVar;
                a aVar4;
                boolean z4;
                com.tencent.mm.plugin.story.i.j jVar2;
                a aVar5;
                a aVar6;
                AppMethodBeat.i(120431);
                if (this.FGW.dJM) {
                    int size = this.FGW.FGB.size();
                    int i2 = this.FGW.Fre;
                    if (i2 >= 0 && size > i2) {
                        int size2 = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size();
                        int i3 = this.FGW.FGx;
                        if (i3 >= 0 && size2 > i3) {
                            Object obj = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).get(this.FGW.FGx);
                            kotlin.g.b.p.g(obj, "galleryGroups[selectedRow][selectedColumn]");
                            final com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) obj;
                            a aVar7 = this.FGW.FGH;
                            if (aVar7 != null) {
                                aVar7.dismiss();
                            }
                            this.FGW.FGH = new a(context);
                            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(hVar.FoT.ecf);
                            if (aba != null) {
                                if (!((aba.frH() ? aba : null) == null || (aVar6 = this.FGW.FGH) == null)) {
                                    aVar6.FED = true;
                                }
                            }
                            if (aba != null) {
                                if (aba.field_storyID == 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    jVar2 = aba;
                                } else {
                                    jVar2 = null;
                                }
                                if (!(jVar2 == null || (aVar5 = this.FGW.FGH) == null)) {
                                    aVar5.FEG = false;
                                }
                            }
                            if (aba != null) {
                                if (aba.field_storyID == 0 || aba.frL()) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    jVar = aba;
                                } else {
                                    jVar = null;
                                }
                                if (!(jVar == null || (aVar4 = this.FGW.FGH) == null)) {
                                    aVar4.FEE = false;
                                }
                            }
                            if (this.FGW.getGalleryType() == n.a.FavSelfStoryGallery && (aVar3 = this.FGW.FGH) != null) {
                                aVar3.nze = false;
                            }
                            a aVar8 = this.FGW.FGH;
                            if (aVar8 != null) {
                                if (aba == null || !aba.frJ() || aba.frL()) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                aVar8.EHQ = z2;
                            }
                            a aVar9 = this.FGW.FGH;
                            if (aVar9 != null) {
                                if (aba == null || !aba.frK()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                aVar9.FEF = z;
                            }
                            a aVar10 = this.FGW.FGH;
                            if (!(aVar10 == null || !aVar10.EHQ || (aVar2 = this.FGW.FGH) == null)) {
                                aVar2.FEG = false;
                            }
                            a aVar11 = this.FGW.FGH;
                            if (!(aVar11 == null || !aVar11.FEF || (aVar = this.FGW.FGH) == null)) {
                                aVar.FEE = false;
                            }
                            a aVar12 = this.FGW.FGH;
                            if (aVar12 != null) {
                                aVar12.FEz = new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass9.AnonymousClass2 */
                                    final /* synthetic */ AnonymousClass9 FGX;

                                    {
                                        this.FGX = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(120428);
                                        StoryGalleryView.t(this.FGX.FGW);
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(120428);
                                        return xVar;
                                    }
                                };
                            }
                            a aVar13 = this.FGW.FGH;
                            if (aVar13 != null) {
                                aVar13.FEA = new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass9.AnonymousClass3 */
                                    final /* synthetic */ AnonymousClass9 FGX;

                                    {
                                        this.FGX = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(120429);
                                        StoryGalleryView.f(hVar.FoT);
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(120429);
                                        return xVar;
                                    }
                                };
                            }
                            a aVar14 = this.FGW.FGH;
                            if (aVar14 != null) {
                                aVar14.FEB = new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass9.AnonymousClass4 */
                                    final /* synthetic */ AnonymousClass9 FGX;

                                    {
                                        this.FGX = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(120430);
                                        StoryGalleryView.u(this.FGX.FGW);
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(120430);
                                        return xVar;
                                    }
                                };
                            }
                            a aVar15 = this.FGW.FGH;
                            if (aVar15 != null) {
                                aVar15.FEC = new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass9.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass9 FGX;

                                    {
                                        this.FGX = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(120427);
                                        StoryGalleryView.v(this.FGX.FGW);
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(120427);
                                        return xVar;
                                    }
                                };
                            }
                            a aVar16 = this.FGW.FGH;
                            if (aVar16 != null) {
                                aVar16.show();
                            }
                            this.FGW.hVo = true;
                            com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                            com.tencent.mm.plugin.story.h.h.fqm().sj(7);
                            com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                            com.tencent.mm.plugin.story.h.h.fqm().wR(String.valueOf(aba != null ? Long.valueOf(aba.field_storyID) : null));
                            com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                            com.tencent.mm.plugin.story.h.h.fqn();
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120431);
                return xVar;
            }
        });
        wa(false);
        this.FGG.setOnCheckedFav(new kotlin.g.a.m<CompoundButton, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass10 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(CompoundButton compoundButton, Boolean bool) {
                AppMethodBeat.i(120432);
                CompoundButton compoundButton2 = compoundButton;
                boolean booleanValue = bool.booleanValue();
                kotlin.g.b.p.h(compoundButton2, "checkBox");
                int size = this.FGW.FGB.size();
                int i2 = this.FGW.Fre;
                if (i2 >= 0 && size > i2) {
                    int size2 = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size();
                    int i3 = this.FGW.FGx;
                    if (i3 >= 0 && size2 > i3) {
                        Object obj = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).get(this.FGW.FGx);
                        kotlin.g.b.p.g(obj, "galleryGroups[selectedRow][selectedColumn]");
                        long j2 = ((com.tencent.mm.plugin.story.f.d.h) obj).FoV.field_storyID;
                        a aVar = StoryGalleryView.FGV;
                        Log.i(StoryGalleryView.TAG, "onCheckedFav " + j2 + ' ' + booleanValue);
                        if (booleanValue) {
                            int size3 = this.FGW.getCheckedFavList().size();
                            a.c cVar = a.c.FvH;
                            if (size3 >= a.c.frl()) {
                                compoundButton2.setChecked(false);
                                com.tencent.mm.ui.base.h.X(context, "", context.getResources().getString(R.string.hhy));
                            } else if (!this.FGW.getCheckedFavList().contains(Long.valueOf(j2))) {
                                this.FGW.getCheckedFavList().add(Long.valueOf(j2));
                            }
                        } else {
                            this.FGW.getCheckedFavList().remove(Long.valueOf(j2));
                        }
                        xb xbVar = new xb();
                        xbVar.edv.edw = booleanValue;
                        xbVar.edv.edx = j2;
                        EventCenter.instance.publish(xbVar);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120432);
                return xVar;
            }
        });
        this.FGG.setOnClickRangeIcon(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass11 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120433);
                if (this.FGW.dJM) {
                    int size = this.FGW.FGB.size();
                    int i2 = this.FGW.Fre;
                    if (i2 >= 0 && size > i2) {
                        int size2 = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size();
                        int i3 = this.FGW.FGx;
                        if (i3 >= 0 && size2 > i3) {
                            Object obj = ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).get(this.FGW.FGx);
                            kotlin.g.b.p.g(obj, "galleryGroups[selectedRow][selectedColumn]");
                            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(((com.tencent.mm.plugin.story.f.d.h) obj).FoT.ecf);
                            Intent intent = new Intent(context, StoryRangeDetailUI.class);
                            a.f fVar = a.f.FvQ;
                            intent.putExtra(a.f.frr(), aba != null ? Integer.valueOf((int) aba.systemRowid) : null);
                            Context context = context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$9", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$9", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120433);
                return xVar;
            }
        });
        this.FEi = new kotlin.g.a.a<Boolean>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass2 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                String str;
                com.tencent.mm.plugin.story.f.d.j videoItem;
                AppMethodBeat.i(120420);
                if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    String fau = j.b.fau();
                    StoryGalleryItemView storyGalleryItemView = this.FGW.FGq;
                    if (storyGalleryItemView == null || (videoItem = storyGalleryItemView.getVideoItem()) == null) {
                        str = null;
                    } else {
                        str = videoItem.username;
                    }
                    if (Util.isEqual(fau, str)) {
                        a aVar = StoryGalleryView.FGV;
                        Log.i(StoryGalleryView.TAG, "toggleActiveState  skip");
                        AppMethodBeat.o(120420);
                        return true;
                    }
                }
                this.FGW.FGK = !this.FGW.FGK;
                StoryGalleryView.d(this.FGW, this.FGW.FGK);
                AppMethodBeat.o(120420);
                return true;
            }
        };
        com.tencent.mm.plugin.story.f.c cVar = com.tencent.mm.plugin.story.f.c.FlK;
        com.tencent.mm.plugin.story.f.c.a(this);
        this.FGJ = new e(this, this.FGA, this.FGw);
        this.FGL = new kotlin.g.a.m<Boolean, Long, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.AnonymousClass3 */
            final /* synthetic */ StoryGalleryView FGW;

            {
                this.FGW = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, Long l) {
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
                ArrayList arrayList;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
                AppMethodBeat.i(120421);
                boolean booleanValue = bool.booleanValue();
                long longValue = l.longValue();
                StoryGalleryItemView storyGalleryItemView = this.FGW.FGq;
                if (storyGalleryItemView != null && com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                    StoryMsgView storyMsgView = storyGalleryItemView.Fyh;
                    if (booleanValue && Util.isEqual(longValue, storyMsgView.edx) && !storyMsgView.Fyt.isEmpty()) {
                        if (storyMsgView.dJM) {
                            StoryMsgListView storyMsgListView = storyMsgView.Fyt.get(1);
                            com.tencent.mm.plugin.story.f.d.g gVar = storyMsgView.FoU;
                            if (gVar == null || (linkedList2 = gVar.FoQ) == null) {
                                arrayList = new ArrayList();
                            } else {
                                arrayList = linkedList2;
                            }
                            storyMsgListView.hB(arrayList);
                        } else {
                            StoryMsgListView storyMsgListView2 = storyMsgView.Fyt.get(0);
                            com.tencent.mm.plugin.story.f.d.g gVar2 = storyMsgView.FoU;
                            storyMsgListView2.hB((gVar2 == null || (linkedList = gVar2.FoQ) == null) ? new ArrayList() : linkedList);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120421);
                return xVar;
            }
        };
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.i(this.FGL);
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sk((long) NetStatusUtil.getIOSNetType(context));
        this.FGM = new g(this, context);
        this.FGN = -1;
        this.FGS = new o(this);
        this.FGT = new d(this);
        AppMethodBeat.o(120503);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static SpannableString k(CharSequence charSequence, int i2) {
            AppMethodBeat.i(120434);
            kotlin.g.b.p.h(charSequence, "text");
            Context context = MMApplicationContext.getContext();
            Drawable m = ar.m(context, R.raw.story_downward_arrow, i2);
            m.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(context, 14), com.tencent.mm.cb.a.fromDPToPix(context, 20));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(m, 1);
            SpannableString spannableString = new SpannableString("#" + charSequence);
            spannableString.setSpan(aVar, 0, 1, 17);
            AppMethodBeat.o(120434);
            return spannableString;
        }
    }

    static {
        AppMethodBeat.i(120505);
        AppMethodBeat.o(120505);
    }

    public final boolean getVideoViewMgrFromPreLoad() {
        return this.FGm;
    }

    public final void setVideoViewMgrFromPreLoad(boolean z) {
        this.FGm = z;
    }

    public final boolean getDeleteWhenFirstEmpty() {
        return this.FGn;
    }

    public final void setDeleteWhenFirstEmpty(boolean z) {
        this.FGn = z;
    }

    public final String getChatRoom() {
        return this.jVv;
    }

    public final void setChatRoom(String str) {
        AppMethodBeat.i(120472);
        this.jVv = str;
        this.FGG.setChatRoom(str);
        AppMethodBeat.o(120472);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final void setGalleryScaleListener(b bVar) {
        AppMethodBeat.i(120473);
        kotlin.g.b.p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.FFz = bVar;
        if (this.FFH == n.a.MultiUserGallery || this.FFH == n.a.HistoryGallery || this.FFH == n.a.FavSelfStoryGallery || this.FFH == n.a.FavOtherStoryGallery) {
            d dVar = new d();
            dVar.FwM = this;
            this.gZR.a(dVar);
        }
        this.gZR.a(new f(this, bVar));
        AppMethodBeat.o(120473);
    }

    public final void abg(int i2) {
        AppMethodBeat.i(120474);
        if (this.FGB.size() > 0 && this.FGB.get(0).size() > i2) {
            Log.printInfoStack(TAG, "checkDoPreloadBeforeEnterGallery", new Object[0]);
            if (this.FGB.get(0).size() > i2 && !Util.isNullOrNil(this.FGB.get(0).get(i2).FoT.Fpd.Url)) {
                Log.i(TAG, "checkDoPreloadBeforeEnterGallery, add [0," + i2 + "] item");
                m.a(m.FHB, kotlin.a.j.ac(this.FGB.get(0).get(i2).FoT));
                AppMethodBeat.o(120474);
                return;
            }
        }
        AppMethodBeat.o(120474);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u001a"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "deleteGroup", "", "groupIndex", "", "notifyDeleteResult", "isOk", "", "notifyGroup", "notifyIndicator", "notifyItemsChange", "start", "count", "notifyItemsInsert", "notifyItemsRemove", "notifySetFavResult", "favorite", "success", "notifySetPrivacyResult", "isPrivacy", "updateGroup", "items", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "updateGroupCount", "plugin-story_release"})
    public static final class g implements com.tencent.mm.plugin.story.g.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ StoryGalleryView FGW;

        g(StoryGalleryView storyGalleryView, Context context) {
            this.FGW = storyGalleryView;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void au(boolean z, boolean z2) {
            AppMethodBeat.i(120446);
            if (z2) {
                this.FGW.FGG.vZ(z);
                AppMethodBeat.o(120446);
                return;
            }
            if (z) {
                com.tencent.mm.ui.base.h.X(this.$context, "", this.$context.getResources().getString(R.string.hhy));
            }
            AppMethodBeat.o(120446);
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void vR(boolean z) {
            AppMethodBeat.i(120447);
            this.FGW.FGG.vY(z);
            AppMethodBeat.o(120447);
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void vQ(boolean z) {
            AppMethodBeat.i(120448);
            com.tencent.mm.ui.base.q qVar = this.FGW.tipDialog;
            if (qVar != null) {
                qVar.dismiss();
            }
            if (!z) {
                u.makeText(this.$context, this.$context.getResources().getString(R.string.hh9), 0).show();
                AppMethodBeat.o(120448);
                return;
            }
            com.tencent.mm.plugin.story.f.d dVar = com.tencent.mm.plugin.story.f.d.FlN;
            com.tencent.mm.plugin.story.f.d.fnL();
            AppMethodBeat.o(120448);
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void aaL(int i2) {
            AppMethodBeat.i(120449);
            if (i2 <= 1) {
                this.FGW.FGJ.fsn();
            }
            this.FGW.FGB.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                this.FGW.FGB.add(new ArrayList());
            }
            AppMethodBeat.o(120449);
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void u(int i2, List<com.tencent.mm.plugin.story.f.d.h> list) {
            com.tencent.mm.plugin.story.ui.a.g gVar;
            AppMethodBeat.i(120450);
            kotlin.g.b.p.h(list, "items");
            a aVar = StoryGalleryView.FGV;
            Log.printInfoStack(StoryGalleryView.TAG, "updateGroup, groupIndex:" + i2 + ", items:" + list.size() + ", active:" + this.FGW.mIsActive + ", galleryType:" + this.FGW.getGalleryType(), new Object[0]);
            if (i2 >= this.FGW.FGB.size()) {
                AppMethodBeat.o(120450);
                return;
            }
            ((ArrayList) this.FGW.FGB.get(i2)).clear();
            ((ArrayList) this.FGW.FGB.get(i2)).addAll(list);
            this.FGW.FGz.hw(this.FGW.FGB);
            if (this.FGW.Fre == i2 && (gVar = this.FGW.FGu) != null) {
                gVar.hw(list);
            }
            if (this.FGW.FGB.size() != 1 || !list.isEmpty()) {
                this.FGW.post(new e(this));
                com.tencent.mm.plugin.story.api.g gVar2 = this.FGW.FGD;
                if (gVar2 != null) {
                    gVar2.eEc();
                }
                this.FGW.holderView.setVisibility(8);
                if (!this.FGW.mIsActive) {
                    this.FGW.maskView.setAlpha(1.0f);
                    this.FGW.maskView.setVisibility(0);
                }
            } else {
                com.tencent.mm.plugin.story.api.g gVar3 = this.FGW.FGD;
                if (gVar3 != null) {
                    gVar3.eEb();
                }
                this.FGW.maskView.setVisibility(8);
                if (this.FGW.getGalleryType() == n.a.SelfTabGallery) {
                    this.FGW.holderView.setVisibility(0);
                    com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqm().sj(1);
                    com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqn();
                } else {
                    this.FGW.holderView.setVisibility(8);
                }
            }
            if (i2 != 0 || this.FGW.mIsActive || this.FGW.getGalleryType() == n.a.HistoryGallery || this.FGW.getGalleryType() == n.a.MultiUserGallery) {
                if (i2 == 1) {
                    this.FGW.getGalleryType();
                    n.a aVar2 = n.a.MultiUserGallery;
                }
                AppMethodBeat.o(120450);
                return;
            }
            this.FGW.abg(0);
            AppMethodBeat.o(120450);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class e implements Runnable {
            final /* synthetic */ g FGZ;

            e(g gVar) {
                this.FGZ = gVar;
            }

            public final void run() {
                AppMethodBeat.i(120445);
                this.FGZ.FGW.fmQ();
                AppMethodBeat.o(120445);
            }
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void aaM(int i2) {
            AppMethodBeat.i(120451);
            a aVar = StoryGalleryView.FGV;
            Log.i(StoryGalleryView.TAG, "deleteGroup: exitCheck " + this.FGW.getDeleteWhenFirstEmpty() + ' ' + i2 + ' ' + this.FGW.Fre);
            if (this.FGW.getDeleteWhenFirstEmpty() && i2 == 0 && this.FGW.Fre <= 0) {
                com.tencent.mm.plugin.story.api.g gVar = this.FGW.FGD;
                if (gVar != null) {
                    gVar.eEd();
                    AppMethodBeat.o(120451);
                    return;
                }
                AppMethodBeat.o(120451);
                return;
            }
            int size = this.FGW.FGB.size();
            if (i2 >= 0 && size > i2) {
                this.FGW.FGB.remove(i2);
                this.FGW.FGz.hw(this.FGW.FGB);
                this.FGW.FGz.ck(i2);
                com.tencent.mm.plugin.story.ui.a.d<?> dVar = this.FGW.FGG.FFI;
                if (dVar != null && i2 >= 0 && i2 < dVar.kgc.size() - 2) {
                    dVar.kgc.remove(i2 + 1);
                    dVar.ck(i2 + 1);
                }
            }
            if (this.FGW.FGB.size() <= 1) {
                this.FGW.FGJ.fsn();
            }
            if (this.FGW.FGB.isEmpty()) {
                com.tencent.mm.plugin.story.api.g gVar2 = this.FGW.FGD;
                if (gVar2 != null) {
                    gVar2.eEb();
                }
                this.FGW.maskView.setVisibility(8);
                AppMethodBeat.o(120451);
                return;
            }
            com.tencent.mm.plugin.story.api.g gVar3 = this.FGW.FGD;
            if (gVar3 != null) {
                gVar3.eEc();
            }
            if (!this.FGW.mIsActive) {
                this.FGW.maskView.setAlpha(1.0f);
                this.FGW.maskView.setVisibility(0);
            }
            AppMethodBeat.o(120451);
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void aaN(int i2) {
            AppMethodBeat.i(120452);
            a aVar = StoryGalleryView.FGV;
            Log.printInfoStack(StoryGalleryView.TAG, "notifyGroup, groupIndex:" + i2 + ", selectedRow:" + this.FGW.Fre, new Object[0]);
            if (this.FGW.Fre == i2) {
                com.tencent.mm.plugin.story.ui.a.g gVar = this.FGW.FGu;
                if (gVar != null) {
                    gVar.notifyDataSetChanged();
                    AppMethodBeat.o(120452);
                    return;
                }
                AppMethodBeat.o(120452);
                return;
            }
            this.FGW.FGA.post(new a(this, i2));
            AppMethodBeat.o(120452);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ g FGZ;
            final /* synthetic */ int FHa;

            a(g gVar, int i2) {
                this.FGZ = gVar;
                this.FHa = i2;
            }

            public final void run() {
                AppMethodBeat.i(120441);
                this.FGZ.FGW.FGz.ci(this.FHa);
                AppMethodBeat.o(120441);
            }
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void ay(int i2, int i3, int i4) {
            AppMethodBeat.i(120453);
            if (this.FGW.Fre == i2) {
                com.tencent.mm.plugin.story.ui.a.g gVar = this.FGW.FGu;
                if (gVar != null) {
                    gVar.as(i3, i4);
                    AppMethodBeat.o(120453);
                    return;
                }
                AppMethodBeat.o(120453);
                return;
            }
            this.FGW.FGA.post(new c(this, i2));
            AppMethodBeat.o(120453);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ g FGZ;
            final /* synthetic */ int FHa;

            c(g gVar, int i2) {
                this.FGZ = gVar;
                this.FHa = i2;
            }

            public final void run() {
                AppMethodBeat.i(120443);
                this.FGZ.FGW.FGz.ci(this.FHa);
                AppMethodBeat.o(120443);
            }
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void az(int i2, int i3, int i4) {
            AppMethodBeat.i(120454);
            if (this.FGW.Fre == i2) {
                com.tencent.mm.plugin.story.ui.a.g gVar = this.FGW.FGu;
                if (gVar != null) {
                    gVar.at(i3, i4);
                    AppMethodBeat.o(120454);
                    return;
                }
                AppMethodBeat.o(120454);
                return;
            }
            this.FGW.FGA.post(new d(this, i2));
            AppMethodBeat.o(120454);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ g FGZ;
            final /* synthetic */ int FHa;

            d(g gVar, int i2) {
                this.FGZ = gVar;
                this.FHa = i2;
            }

            public final void run() {
                AppMethodBeat.i(120444);
                this.FGZ.FGW.FGz.ci(this.FHa);
                AppMethodBeat.o(120444);
            }
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void aA(int i2, int i3, int i4) {
            AppMethodBeat.i(120455);
            if (this.FGW.Fre == i2) {
                com.tencent.mm.plugin.story.ui.a.g gVar = this.FGW.FGu;
                if (gVar != null) {
                    gVar.aq(i3, i4);
                    AppMethodBeat.o(120455);
                    return;
                }
                AppMethodBeat.o(120455);
                return;
            }
            this.FGW.FGA.post(new b(this, i2));
            AppMethodBeat.o(120455);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ g FGZ;
            final /* synthetic */ int FHa;

            b(g gVar, int i2) {
                this.FGZ = gVar;
                this.FHa = i2;
            }

            public final void run() {
                AppMethodBeat.i(120442);
                this.FGZ.FGW.FGz.ci(this.FHa);
                AppMethodBeat.o(120442);
            }
        }

        @Override // com.tencent.mm.plugin.story.g.c
        public final void fpA() {
            GalleryHorizontalControlView galleryHorizontalControlView;
            AppMethodBeat.i(120456);
            int size = this.FGW.FGB.size();
            int i2 = this.FGW.Fre;
            if (i2 < 0) {
                AppMethodBeat.o(120456);
            } else if (size <= i2 || (galleryHorizontalControlView = this.FGW.FGt) == null) {
                AppMethodBeat.o(120456);
            } else {
                Object obj = this.FGW.FGB.get(this.FGW.Fre);
                kotlin.g.b.p.g(obj, "galleryGroups[selectedRow]");
                galleryHorizontalControlView.hw((List) obj);
                AppMethodBeat.o(120456);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean canScrollHorizontally(int i2) {
        return this.mIsActive;
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void fmS() {
        AppMethodBeat.i(120476);
        if (ao.gJI()) {
            int i2 = au.az(getContext()).y;
            ViewGroup.LayoutParams layoutParams = this.FGr.getLayoutParams();
            layoutParams.width = (int) (((float) i2) * 0.5625f);
            layoutParams.height = i2;
            kotlin.g.b.p.g(layoutParams, "this");
            f(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.FGr.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
        }
        this.FGA.getLayoutParams().width = this.FGr.getLayoutParams().width;
        this.FGA.getLayoutParams().height = this.FGr.getLayoutParams().height;
        this.FGG.getLayoutParams().width = this.FGr.getLayoutParams().width;
        ViewGroup.LayoutParams layoutParams3 = this.FGG.getLayoutParams();
        kotlin.g.b.p.g(layoutParams3, "verticalControlView.layoutParams");
        f(layoutParams3);
        AppMethodBeat.o(120476);
    }

    private static void f(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(120477);
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
            AppMethodBeat.o(120477);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
            AppMethodBeat.o(120477);
        } else {
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
            }
            AppMethodBeat.o(120477);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeInMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(120439);
            this.FGW.maskView.setVisibility(0);
            AppMethodBeat.o(120439);
        }
    }

    private final void fsq() {
        AppMethodBeat.i(120478);
        Log.d(TAG, "fadeOutMaskView");
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sn(System.currentTimeMillis());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.maskView, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new f(this));
        ofFloat.start();
        AppMethodBeat.o(120478);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeOutMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(120440);
            this.FGW.maskView.setVisibility(8);
            AppMethodBeat.o(120440);
        }
    }

    public final void setNeedReset(boolean z) {
        this.FGQ = z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onPostEnd", "", ch.COL_LOCALID, "", "isOk", "", "onPostNotify", "onPostStart", "plugin-story_release"})
    public static final class o implements com.tencent.mm.plugin.story.api.k {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        @Override // com.tencent.mm.plugin.story.api.k
        public final void fni() {
            com.tencent.mm.plugin.story.g.f fVar;
            AppMethodBeat.i(120466);
            if (!this.FGW.dJM || (fVar = this.FGW.FGC) == null) {
                AppMethodBeat.o(120466);
                return;
            }
            fVar.fpz();
            AppMethodBeat.o(120466);
        }

        @Override // com.tencent.mm.plugin.story.api.k
        public final void aaE(int i2) {
            AppMethodBeat.i(120467);
            a aVar = StoryGalleryView.FGV;
            Log.i(StoryGalleryView.TAG, "onPostStart ".concat(String.valueOf(i2)));
            if (this.FGW.dJM) {
                if (this.FGW.mIsActive) {
                    this.FGW.setNeedReset(true);
                    AppMethodBeat.o(120467);
                    return;
                }
                com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
                if (fVar != null) {
                    fVar.fpz();
                }
                if (this.FGW.FGB.size() == 1 && ((ArrayList) this.FGW.FGB.get(0)).size() > 0) {
                    this.FGW.setCurrentHItem(0);
                }
                if (this.FGW.FGB.size() == 1 && ((ArrayList) this.FGW.FGB.get(0)).size() == 1) {
                    MMHandlerThread.postToMainThread(new a(this, i2));
                }
            }
            AppMethodBeat.o(120467);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ o FHd;
            final /* synthetic */ int Fqu;

            a(o oVar, int i2) {
                this.FHd = oVar;
                this.Fqu = i2;
            }

            public final void run() {
                AppMethodBeat.i(120465);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, true);
                a aVar = StoryGalleryView.FGV;
                Log.i(StoryGalleryView.TAG, "onPostStart " + this.Fqu + " and ret " + z);
                if (z) {
                    this.FHd.FGW.setFirstPost(true);
                    this.FHd.FGW.ar(true, false);
                }
                AppMethodBeat.o(120465);
            }
        }

        @Override // com.tencent.mm.plugin.story.api.k
        public final void fnh() {
            AppMethodBeat.i(120468);
            i.a aVar = com.tencent.mm.plugin.story.f.i.Fmb;
            ThreadPool.post(i.a.RunnableC1759a.Fmc, "Story_cleanAudioFile");
            if (this.FGW.dJM) {
                if (this.FGW.mIsActive) {
                    this.FGW.setNeedReset(true);
                    AppMethodBeat.o(120468);
                    return;
                }
                com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
                if (fVar != null) {
                    fVar.fpz();
                    AppMethodBeat.o(120468);
                    return;
                }
            }
            AppMethodBeat.o(120468);
        }
    }

    public final void setFirstPost(boolean z) {
        this.FGR = z;
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void setDataSeed(Object obj) {
        AppMethodBeat.i(120479);
        this.dJM = this.FFH == n.a.SelfGallery || this.FFH == n.a.SelfTabGallery || this.FFH == n.a.HistoryGallery || this.FFH == n.a.FavSelfStoryGallery;
        String str = this.jVv;
        if (str == null || !(obj instanceof ArrayList) || !((ArrayList) obj).isEmpty()) {
            setDataInternal(obj);
            AppMethodBeat.o(120479);
            return;
        }
        Log.i(TAG, "setDataSeed: chat room empty user list, fetch again");
        com.tencent.mm.plugin.story.f.f.d dVar = new com.tencent.mm.plugin.story.f.f.d(str);
        dVar.FpR = new r(this, dVar);
        dVar.start();
        AppMethodBeat.o(120479);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J.\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setDataSeed$1", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "updateChatRoomState", "", "hasStory", "", "hasUnread", "updateGalleryUserList", "userList", "", "", "unreadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateUserState", ch.COL_USERNAME, "plugin-story_release"})
    public static final class r implements l.a {
        final /* synthetic */ StoryGalleryView FGW;
        final /* synthetic */ com.tencent.mm.plugin.story.f.f.d FHe;

        r(StoryGalleryView storyGalleryView, com.tencent.mm.plugin.story.f.f.d dVar) {
            this.FGW = storyGalleryView;
            this.FHe = dVar;
        }

        @Override // com.tencent.mm.plugin.story.api.l.a
        public final void a(List<String> list, ArrayList<String> arrayList) {
            AppMethodBeat.i(120471);
            kotlin.g.b.p.h(list, "userList");
            kotlin.g.b.p.h(arrayList, "unreadList");
            a aVar = StoryGalleryView.FGV;
            Log.i(StoryGalleryView.TAG, "updateGalleryUserList: " + list.size());
            StoryGalleryView.a(this.FGW, list);
            com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
            com.tencent.mm.plugin.story.h.b.hv(list);
            this.FHe.destroy();
            AppMethodBeat.o(120471);
        }

        @Override // com.tencent.mm.plugin.story.api.l.a
        public final void as(boolean z, boolean z2) {
        }

        @Override // com.tencent.mm.plugin.story.api.l.a
        public final void cs(String str, boolean z) {
        }
    }

    private final void setDataInternal(Object obj) {
        boolean z;
        AppMethodBeat.i(120480);
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
        this.FGC = com.tencent.mm.plugin.story.g.d.a(obj, this.FGM, this.FFH, this.jVv);
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.aaP(this.FrQ);
        }
        Log.i(TAG, "presenter " + this.FGC + " galleryType " + this.FFH);
        com.tencent.mm.plugin.story.g.f fVar2 = this.FGC;
        if (fVar2 != null) {
            fVar2.fpz();
        }
        switch (k.$EnumSwitchMapping$0[this.FFH.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            GalleryVerticalControlView galleryVerticalControlView = this.FGG;
            galleryVerticalControlView.FFB.setVisibility(0);
            galleryVerticalControlView.jBO.setVisibility(8);
            galleryVerticalControlView.FFF.setVisibility(8);
        } else if (obj instanceof com.tencent.mm.plugin.story.api.p) {
            this.FGG.setUserList(com.tencent.mm.plugin.story.f.d.f.a((com.tencent.mm.plugin.story.api.p) obj));
        } else if (obj instanceof List) {
            this.FGG.setUserList((List) obj);
        }
        if (this.FFH == n.a.SelfTabGallery && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            GalleryHolderView galleryHolderView = this.holderView;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(120480);
                throw tVar;
            }
            galleryHolderView.setInitMargin(((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
        }
        AppMethodBeat.o(120480);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void a(PullDownListView pullDownListView) {
        AppMethodBeat.i(120481);
        this.FGo = pullDownListView;
        this.FGF = new c();
        c cVar = this.FGF;
        if (cVar != null) {
            cVar.FEL = this;
        }
        c cVar2 = this.FGF;
        if (cVar2 != null) {
            cVar2.FEK = pullDownListView;
        }
        c cVar3 = this.FGF;
        if (cVar3 != null) {
            this.gZR.a(cVar3);
            AppMethodBeat.o(120481);
            return;
        }
        AppMethodBeat.o(120481);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void onResume() {
        StoryGalleryItemView storyGalleryItemView;
        AppMethodBeat.i(120482);
        Log.i(TAG, "LogStory: onResume " + hashCode() + ", galleryType:" + this.FFH + " videoViewMgr " + this.FGc);
        this.dirty = true;
        fsr();
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.resume();
        }
        com.tencent.mm.plugin.story.f.d.j jVar = this.FGP;
        if (jVar == null || !jVar.foX()) {
            com.tencent.mm.plugin.story.f.d.j jVar2 = this.FGP;
            if (jVar2 == null || !jVar2.foY()) {
                n nVar = this.FGc;
                if (nVar != null) {
                    nVar.onUIResume();
                }
            } else {
                com.tencent.mm.plugin.vlog.ui.preview.a aVar = this.FGI;
                if (aVar != null) {
                    aVar.onUIResume();
                }
            }
        } else {
            l lVar = this.FGd;
            if (lVar != null) {
                lVar.onUIResume();
            }
        }
        StoryGalleryItemView storyGalleryItemView2 = this.FGq;
        if (storyGalleryItemView2 != null) {
            storyGalleryItemView2.onResume();
        }
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.fpN();
        com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.fpN();
        if (!this.mIsActive || (storyGalleryItemView = this.FGq) == null) {
            AppMethodBeat.o(120482);
            return;
        }
        storyGalleryItemView.fso();
        AppMethodBeat.o(120482);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void onStart() {
        AppMethodBeat.i(120483);
        Log.i(TAG, "LogStory, onStart " + hashCode() + " galleryType:" + this.FFH);
        AppMethodBeat.o(120483);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void onPause() {
        AppMethodBeat.i(120484);
        Log.i(TAG, "LogStory: onPause " + hashCode() + " galleryType:" + this.FFH + " videoViewMgr " + this.FGc);
        this.dirty = true;
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.pause();
        }
        n nVar = this.FGc;
        if (nVar != null) {
            nVar.onUIPause();
        }
        l lVar = this.FGd;
        if (lVar != null) {
            lVar.onUIPause();
        }
        com.tencent.mm.plugin.vlog.ui.preview.a aVar = this.FGI;
        if (aVar != null) {
            aVar.onUIPause();
        }
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.onPause();
        }
        a aVar2 = this.FGH;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaT(11);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.foR();
        reset();
        AppMethodBeat.o(120484);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void onStop() {
        AppMethodBeat.i(120485);
        Log.i(TAG, "LogStory, onStop:" + hashCode());
        AppMethodBeat.o(120485);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void onDestroy() {
        AppMethodBeat.i(120486);
        Log.i(TAG, "LogStory, onDestroy " + hashCode() + " galleryType:" + this.FFH + " videoViewMgr " + this.FGc);
        com.tencent.mm.plugin.story.f.c cVar = com.tencent.mm.plugin.story.f.c.FlK;
        com.tencent.mm.plugin.story.f.c.b(this);
        dS();
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.destroy();
        }
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.onDestroy();
        }
        n nVar = this.FGc;
        if (nVar != null) {
            nVar.onUIDestroy();
        }
        l lVar = this.FGd;
        if (lVar != null) {
            lVar.onUIDestroy();
        }
        com.tencent.mm.plugin.vlog.ui.preview.a aVar = this.FGI;
        if (aVar != null) {
            aVar.onUIDestroy();
        }
        m mVar = m.FHB;
        m.fsw();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foi().FqA = null;
        com.tencent.mm.plugin.story.f.b.b bVar2 = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.j(this.FGL);
        m mVar2 = m.FHB;
        int fsz = m.fsz();
        Log.i(TAG, "onDestroy speed " + fsz + ' ');
        com.tencent.mm.plugin.story.h.b bVar3 = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.aaS(fsz);
        this.FGJ.destroy();
        AppMethodBeat.o(120486);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final boolean onBackPressed() {
        boolean z = false;
        AppMethodBeat.i(120487);
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaT(10);
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        boolean onBackPressed = storyGalleryItemView != null ? storyGalleryItemView.onBackPressed() : false;
        Log.d(TAG, "onBackPressed commentView result:".concat(String.valueOf(onBackPressed)));
        if (!onBackPressed && this.mIsActive) {
            com.tencent.mm.plugin.story.api.g gVar = this.FGD;
            if (gVar != null) {
                gVar.eEd();
            }
            if (onBackPressed || this.mIsActive) {
                z = true;
            }
            onBackPressed = z;
        }
        Log.d(TAG, "onBackPressed result:".concat(String.valueOf(onBackPressed)));
        AppMethodBeat.o(120487);
        return onBackPressed;
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void ar(boolean z, boolean z2) {
        ar.a aVar;
        String str;
        String str2;
        Long l2;
        com.tencent.mm.plugin.story.f.d.j videoItem;
        com.tencent.mm.plugin.story.f.d.j videoItem2;
        com.tencent.mm.plugin.story.f.d.j videoItem3;
        String str3;
        com.tencent.mm.plugin.story.f.d.j videoItem4;
        com.tencent.mm.plugin.story.f.d.j videoItem5;
        boolean z3;
        String str4 = null;
        AppMethodBeat.i(120488);
        Log.printInfoStack(TAG, "LogStory: onSwitchVideoMode isMute:" + z + " videoViewMgr " + this.FGc + " videoViewMgrFromPreLoad " + this.FGm, new Object[0]);
        this.FGK = true;
        this.FGA.setActive(true);
        this.mIsActive = true;
        this.guh = z;
        if (!this.guh) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            if (!((PluginFinder) ah).isAnchorLiving()) {
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                if (!((PluginFinder) ah2).isVisitorLiving()) {
                    z3 = false;
                    this.guh = z3;
                }
            }
            z3 = true;
            this.guh = z3;
        }
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.setMute(this.guh);
        }
        if (this.FGB.size() > 0 && this.Fre >= 0 && this.Fre < this.FGB.size() && this.FGx < this.FGB.get(this.Fre).size() && this.FGx >= 0) {
            Log.i(TAG, "help LogStory: onItemSelected " + this.mIsActive);
            com.tencent.mm.plugin.story.f.d.j jVar = this.FGB.get(this.Fre).get(this.FGx).FoT;
            m mVar = m.FHB;
            m.e(this.FGB, this.Fre, this.FGx);
            m.FHB.h(jVar);
        }
        StoryGalleryItemView storyGalleryItemView2 = this.FGq;
        if (storyGalleryItemView2 != null) {
            storyGalleryItemView2.fso();
        }
        com.tencent.mm.plugin.story.f.d.j jVar2 = this.FGP;
        if (jVar2 == null || !jVar2.foX()) {
            com.tencent.mm.plugin.story.f.d.j jVar3 = this.FGP;
            if (jVar3 != null && jVar3.foY()) {
                com.tencent.mm.plugin.vlog.ui.preview.a aVar2 = this.FGI;
                if (aVar2 != null) {
                    aVar2.PF();
                }
            } else if (this.FGm) {
                n nVar = this.FGc;
                if (nVar != null) {
                    nVar.fst();
                }
            } else {
                n nVar2 = this.FGc;
                if (nVar2 != null) {
                    nVar2.PF();
                }
            }
        } else {
            l lVar = this.FGd;
            if (lVar != null) {
                lVar.PF();
            }
        }
        setEnabled(true);
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.aaK(1);
        }
        if (!(this.FFH == n.a.HistoryGallery || this.FFH == n.a.MultiUserGallery || this.FFH == n.a.FavSelfStoryGallery || this.FFH == n.a.FavOtherStoryGallery)) {
            abg(1);
        }
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            this.holderView.fsm();
        }
        if (this.FFH == n.a.SelfTabGallery) {
            aVar = ar.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC;
        } else if (this.FFH == n.a.ProfileGallery) {
            aVar = ar.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
        } else {
            aVar = null;
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "storage()");
        aAh.azQ().set(aVar, Boolean.TRUE);
        this.FGp.setVisibility(8);
        if (!z2) {
            AppMethodBeat.o(120488);
            return;
        }
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fql();
        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
        StoryGalleryItemView storyGalleryItemView3 = this.FGq;
        if (storyGalleryItemView3 == null || (videoItem5 = storyGalleryItemView3.getVideoItem()) == null) {
            str = null;
        } else {
            str = videoItem5.username;
        }
        if (!com.tencent.mm.plugin.story.h.h.aSm(str)) {
            com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().sp(1);
            StoryGalleryItemView storyGalleryItemView4 = this.FGq;
            if (storyGalleryItemView4 == null || (videoItem4 = storyGalleryItemView4.getVideoItem()) == null) {
                str3 = null;
            } else {
                str3 = videoItem4.username;
            }
            if (ab.IS(str3)) {
                com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqi().sq(1);
            }
        }
        com.tencent.mm.plugin.story.h.h hVar5 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().st(1);
        StoryGalleryItemView storyGalleryItemView5 = this.FGq;
        if (storyGalleryItemView5 == null || (videoItem3 = storyGalleryItemView5.getVideoItem()) == null) {
            str2 = null;
        } else {
            str2 = videoItem3.username;
        }
        if (ab.IS(str2)) {
            com.tencent.mm.plugin.story.h.h hVar6 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().su(1);
        }
        com.tencent.mm.plugin.story.h.h hVar7 = com.tencent.mm.plugin.story.h.h.FuH;
        StoryGalleryItemView storyGalleryItemView6 = this.FGq;
        if (storyGalleryItemView6 == null || (videoItem2 = storyGalleryItemView6.getVideoItem()) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(videoItem2.edx);
        }
        if (!com.tencent.mm.plugin.story.h.h.aSn(String.valueOf(l2))) {
            com.tencent.mm.plugin.story.h.h hVar8 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().sr(1);
            StoryGalleryItemView storyGalleryItemView7 = this.FGq;
            if (!(storyGalleryItemView7 == null || (videoItem = storyGalleryItemView7.getVideoItem()) == null)) {
                str4 = videoItem.username;
            }
            if (ab.IS(str4)) {
                com.tencent.mm.plugin.story.h.h hVar9 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqi().ss(1);
            }
        }
        com.tencent.mm.plugin.story.h.h hVar10 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sv(1);
        com.tencent.mm.plugin.story.h.h hVar11 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sn(System.currentTimeMillis());
        com.tencent.mm.plugin.story.h.h hVar12 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqh();
        if (this.FGB.size() == 1 && this.FGB.get(0).size() == 0) {
            com.tencent.mm.plugin.story.h.h hVar13 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqk();
            AppMethodBeat.o(120488);
        } else if (this.FGB.size() <= this.Fre || this.Fre < 0 || this.FGx < 0 || this.FGB.get(this.Fre).size() <= this.FGx) {
            com.tencent.mm.plugin.story.h.h hVar14 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqk();
            AppMethodBeat.o(120488);
        } else {
            StoryGalleryItemView storyGalleryItemView8 = this.FGq;
            if (storyGalleryItemView8 != null) {
                storyGalleryItemView8.fsi();
            }
            fss();
            wa(true);
            com.tencent.mm.plugin.story.h.h hVar15 = com.tencent.mm.plugin.story.h.h.FuH;
            jr fqy = com.tencent.mm.plugin.story.h.h.fqy();
            com.tencent.mm.plugin.story.h.h hVar16 = com.tencent.mm.plugin.story.h.h.FuH;
            fqy.sO(com.tencent.mm.plugin.story.h.h.fqi().ahy());
            com.tencent.mm.plugin.story.h.h hVar17 = com.tencent.mm.plugin.story.h.h.FuH;
            jr fqy2 = com.tencent.mm.plugin.story.h.h.fqy();
            com.tencent.mm.plugin.story.h.h hVar18 = com.tencent.mm.plugin.story.h.h.FuH;
            fqy2.sM(com.tencent.mm.plugin.story.h.h.fqi().ahw());
            com.tencent.mm.plugin.story.h.h hVar19 = com.tencent.mm.plugin.story.h.h.FuH;
            jr fqy3 = com.tencent.mm.plugin.story.h.h.fqy();
            com.tencent.mm.plugin.story.h.h hVar20 = com.tencent.mm.plugin.story.h.h.FuH;
            fqy3.sN(com.tencent.mm.plugin.story.h.h.fqi().ahx());
            com.tencent.mm.plugin.story.h.h hVar21 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqy().wX(this.FGB.get(this.Fre).get(this.FGx).userName);
            com.tencent.mm.plugin.story.h.h hVar22 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqy().wY(String.valueOf(this.FGB.get(this.Fre).get(this.FGx).edx));
            com.tencent.mm.plugin.story.h.h hVar23 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqz();
            AppMethodBeat.o(120488);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void vI(boolean z) {
        com.tencent.mm.plugin.story.g.f fVar;
        AppMethodBeat.i(120489);
        Log.i(TAG, "LogStory: onSwitchImageMode videoViewMgr " + this.FGc);
        this.FGA.setActive(false);
        this.mIsActive = false;
        com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
        com.tencent.mm.plugin.story.f.e.a.fpa();
        if (this.FGQ && this.dJM && (fVar = this.FGC) != null) {
            fVar.fpz();
        }
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView != null) {
            if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                storyGalleryItemView.Fyh.hide();
            } else {
                StoryCommentView storyCommentView = storyGalleryItemView.Fyg;
                storyCommentView.xN(2);
                storyCommentView.isActive = false;
                storyCommentView.hide();
            }
        }
        n nVar = this.FGc;
        if (nVar != null) {
            nVar.aw(true, z);
        }
        l lVar = this.FGd;
        if (lVar != null) {
            lVar.wb(true);
        }
        com.tencent.mm.plugin.vlog.ui.preview.a aVar2 = this.FGI;
        if (aVar2 != null) {
            aVar2.wb(true);
        }
        setEnabled(false);
        com.tencent.mm.plugin.story.g.f fVar2 = this.FGC;
        if (fVar2 != null) {
            fVar2.aaK(0);
        }
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.holderView;
            galleryHolderView.FEP.setVisibility(4);
            galleryHolderView.mPa.setVisibility(0);
        }
        wa(false);
        AppMethodBeat.o(120489);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void fmO() {
        AppMethodBeat.i(120490);
        fsq();
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            this.holderView.fsl();
        }
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.cJk();
            AppMethodBeat.o(120490);
            return;
        }
        AppMethodBeat.o(120490);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void fmP() {
        AppMethodBeat.i(120491);
        if (this.FGB.size() != 1 || !this.FGB.get(0).isEmpty()) {
            Log.d(TAG, "fadeInMaskView");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.maskView, "alpha", 0.0f, 1.0f);
            ofFloat.addListener(new e(this));
            ofFloat.start();
        } else {
            fsq();
        }
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.holderView;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(galleryHolderView.mPa, "alpha", galleryHolderView.mPa.getAlpha(), galleryHolderView.FEU), ObjectAnimator.ofFloat(galleryHolderView.FEP, "alpha", galleryHolderView.FEP.getAlpha(), 0.0f));
            animatorSet.setDuration(100L);
            animatorSet.start();
        }
        AppMethodBeat.o(120491);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void setStoryBrowseUIListener(com.tencent.mm.plugin.story.api.g gVar) {
        if (gVar != null) {
            this.FGD = gVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ StoryGalleryView FGW;
        final /* synthetic */ int gUj;

        q(StoryGalleryView storyGalleryView, int i2) {
            this.FGW = storyGalleryView;
            this.gUj = i2;
        }

        public final void run() {
            AppMethodBeat.i(120470);
            a aVar = StoryGalleryView.FGV;
            Log.d(StoryGalleryView.TAG, "setCurrentVItem " + this.gUj + ", all:" + this.FGW.FGB.size());
            if (this.gUj < this.FGW.FGB.size()) {
                GalleryRecyclerView galleryRecyclerView = this.FGW.FGA;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.gUj, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(galleryRecyclerView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setCurrentVItem$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                galleryRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(galleryRecyclerView, "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setCurrentVItem$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            AppMethodBeat.o(120470);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void setCurrentVItem(int i2) {
        AppMethodBeat.i(120492);
        GalleryRecyclerView galleryRecyclerView = this.FGA;
        if (galleryRecyclerView != null) {
            galleryRecyclerView.post(new q(this, i2));
            AppMethodBeat.o(120492);
            return;
        }
        AppMethodBeat.o(120492);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class p implements Runnable {
        final /* synthetic */ StoryGalleryView FGW;
        final /* synthetic */ int gUj;

        p(StoryGalleryView storyGalleryView, int i2) {
            this.FGW = storyGalleryView;
            this.gUj = i2;
        }

        public final void run() {
            AppMethodBeat.i(120469);
            if (this.FGW.Fre != -1 && this.FGW.Fre < this.FGW.FGB.size() && this.gUj < ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size()) {
                a aVar = StoryGalleryView.FGV;
                Log.d(StoryGalleryView.TAG, "setCurrentHItem=" + this.FGW.Fre + " galleryGroups.size=" + this.FGW.FGB.size() + " galleryGroups[selectedRow].size=" + ((ArrayList) this.FGW.FGB.get(this.FGW.Fre)).size() + " hRecyclerView=" + this.FGW.FGs);
                RecyclerView recyclerView = this.FGW.FGs;
                if (recyclerView != null) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.gUj, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setCurrentHItem$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setCurrentHItem$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    AppMethodBeat.o(120469);
                    return;
                }
            }
            AppMethodBeat.o(120469);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void setCurrentHItem(int i2) {
        AppMethodBeat.i(120493);
        RecyclerView recyclerView = this.FGs;
        if (recyclerView != null) {
            recyclerView.post(new p(this, i2));
            AppMethodBeat.o(120493);
            return;
        }
        AppMethodBeat.o(120493);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void fmQ() {
        AppMethodBeat.i(222926);
        ar.a aVar = null;
        if (this.FFH == n.a.ProfileGallery) {
            aVar = ar.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
        }
        if (aVar != null) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "storage()");
            if (!aAh.azQ().getBoolean(aVar, false)) {
                ViewGroup.LayoutParams layoutParams = this.FGp.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(222926);
                    throw tVar;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                au.ay(getContext());
                marginLayoutParams.topMargin = -getTop();
                this.FGp.setLayoutParams(marginLayoutParams);
                this.FGp.setVisibility(0);
                TextView textView = this.FGp;
                String string = getResources().getString(R.string.hj1);
                kotlin.g.b.p.g(string, "resources.getString(R.string.story_pull_hint)");
                textView.setText(a.k(string, this.FGp.getCurrentTextColor()));
            }
        }
        AppMethodBeat.o(222926);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void fmR() {
        AppMethodBeat.i(120494);
        com.tencent.mm.plugin.story.g.f fVar = this.FGC;
        if (fVar != null) {
            fVar.fpz();
        }
        reset();
        AppMethodBeat.o(120494);
    }

    private void reset() {
        AppMethodBeat.i(120495);
        Log.i(TAG, "reset " + Util.getStack() + " isFirstPost : " + this.FGR);
        if (this.FGR && this.mIsActive) {
            vI(false);
        }
        if (this.FGR) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.FALSE);
            this.FGR = false;
        }
        AppMethodBeat.o(120495);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void aaB(int i2) {
        AppMethodBeat.i(120496);
        Log.d(TAG, "onOpening ".concat(String.valueOf(i2)));
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.holderView;
            float min = Math.min(((float) Math.abs(i2)) / ((float) Math.abs(galleryHolderView.FET)), 1.0f);
            galleryHolderView.FEP.setAlpha(min);
            galleryHolderView.mPa.setAlpha(1.0f - min);
            galleryHolderView.FEP.setVisibility(0);
        }
        AppMethodBeat.o(120496);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void aaC(int i2) {
        AppMethodBeat.i(120497);
        Log.d(TAG, "onClosing ".concat(String.valueOf(i2)));
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.holderView;
            float min = Math.min(1.0f, ((float) Math.abs(i2)) / ((float) Math.abs(galleryHolderView.FET)));
            galleryHolderView.FEP.setAlpha(1.0f - min);
            galleryHolderView.mPa.setAlpha(min);
            galleryHolderView.FEP.setVisibility(0);
        }
        AppMethodBeat.o(120497);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryGallery
    public final void UE(int i2) {
        AppMethodBeat.i(120498);
        Log.d(TAG, "onListInnerScroll ".concat(String.valueOf(i2)));
        if (this.FFH == n.a.SelfTabGallery && this.holderView.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.holderView;
            float min = 1.0f - Math.min(((float) Math.abs(i2)) / ((float) com.tencent.mm.cb.a.fromDPToPix(galleryHolderView.getContext(), 16)), 1.0f);
            Log.d(GalleryHolderView.TAG, "onListInnerScroll " + i2 + ' ' + min);
            galleryHolderView.mPa.setAlpha(min);
            galleryHolderView.FEU = min;
        }
        AppMethodBeat.o(120498);
    }

    public final void setCanDragScale(boolean z) {
        this.FGE = z;
    }

    private final void fsr() {
        AppMethodBeat.i(120499);
        if (this.dJM) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foi().a(this.FGS);
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foi().ac(new c(this));
        }
        AppMethodBeat.o(120499);
    }

    private final void dS() {
        AppMethodBeat.i(120500);
        if (this.dJM) {
            Log.i(TAG, "removeListeners");
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foi().b(this.FGS);
        }
        AppMethodBeat.o(120500);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ StoryGalleryView FGW;

        d(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        public final void run() {
            AppMethodBeat.i(120438);
            StoryGalleryItemView storyGalleryItemView = this.FGW.FGq;
            if (storyGalleryItemView == null || storyGalleryItemView.getVideoItem() == null) {
                AppMethodBeat.o(120438);
                return;
            }
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.k foc = j.b.foc();
            StoryGalleryItemView storyGalleryItemView2 = this.FGW.FGq;
            if (storyGalleryItemView2 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.plugin.story.f.d.j videoItem = storyGalleryItemView2.getVideoItem();
            if (videoItem == null) {
                kotlin.g.b.p.hyc();
            }
            int b2 = com.tencent.mm.plugin.story.i.k.b(foc, videoItem.edx);
            a aVar = StoryGalleryView.FGV;
            String str = StoryGalleryView.TAG;
            StringBuilder sb = new StringBuilder("storyId :");
            StoryGalleryItemView storyGalleryItemView3 = this.FGW.FGq;
            if (storyGalleryItemView3 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.plugin.story.f.d.j videoItem2 = storyGalleryItemView3.getVideoItem();
            if (videoItem2 == null) {
                kotlin.g.b.p.hyc();
            }
            Log.i(str, sb.append(videoItem2.edx).append(" read times + 1  ,result:").append(b2).toString());
            AppMethodBeat.o(120438);
        }
    }

    private final void fss() {
        AppMethodBeat.i(120501);
        String str = TAG;
        StringBuilder sb = new StringBuilder("addVideoReadNumber ");
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView == null) {
            kotlin.g.b.p.hyc();
        }
        com.tencent.mm.plugin.story.f.d.j videoItem = storyGalleryItemView.getVideoItem();
        if (videoItem == null) {
            kotlin.g.b.p.hyc();
        }
        Log.d(str, sb.append(videoItem.edx).append("  time:").append(System.currentTimeMillis()).toString());
        MMHandlerThread.removeRunnable(this.FGT);
        MMHandlerThread.postToMainThreadDelayed(this.FGT, 500);
        AppMethodBeat.o(120501);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class h implements f.c {
        final /* synthetic */ StoryGalleryView FGW;
        final /* synthetic */ com.tencent.mm.plugin.story.i.j FHb;

        h(StoryGalleryView storyGalleryView, com.tencent.mm.plugin.story.i.j jVar) {
            this.FGW = storyGalleryView;
            this.FHb = jVar;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            boolean z2 = false;
            AppMethodBeat.i(120458);
            a aVar = StoryGalleryView.FGV;
            Log.i(StoryGalleryView.TAG, "delete click and click ok it " + this.FGW.Fre + ' ' + this.FGW.FGx);
            if (z) {
                com.tencent.mm.plugin.story.i.j jVar = this.FHb;
                if (jVar != null) {
                    if (!(jVar.field_storyID != 0)) {
                        jVar = null;
                    }
                    if (jVar != null) {
                        z2 = true;
                    }
                }
                StoryGalleryView storyGalleryView = this.FGW;
                Context context = this.FGW.getContext();
                this.FGW.getContext().getString(R.string.zb);
                storyGalleryView.tipDialog = com.tencent.mm.ui.base.h.a(context, this.FGW.getContext().getString(R.string.hha), z2, new DialogInterface.OnCancelListener(this) {
                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.h.AnonymousClass1 */
                    final /* synthetic */ h FHc;

                    {
                        this.FHc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(120457);
                        a aVar = StoryGalleryView.FGV;
                        Log.i(StoryGalleryView.TAG, "delete click and click cancel it " + this.FHc.FGW.Fre + ' ' + this.FHc.FGW.FGx);
                        com.tencent.mm.plugin.story.g.f fVar = this.FHc.FGW.FGC;
                        if (fVar != null) {
                            int unused = this.FHc.FGW.Fre;
                            int unused2 = this.FHc.FGW.FGx;
                            fVar.fpy();
                            AppMethodBeat.o(120457);
                            return;
                        }
                        AppMethodBeat.o(120457);
                    }
                });
                com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
                if (fVar != null) {
                    fVar.je(this.FGW.Fre, this.FGW.FGx);
                    AppMethodBeat.o(120458);
                    return;
                }
            }
            AppMethodBeat.o(120458);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class n implements DialogInterface.OnClickListener {
        final /* synthetic */ StoryGalleryView FGW;

        n(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            boolean z;
            AppMethodBeat.i(120464);
            com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
            if (fVar != null) {
                int i3 = this.FGW.Fre;
                int i4 = this.FGW.FGx;
                a aVar = this.FGW.FGH;
                if (aVar != null) {
                    z = aVar.EHQ;
                } else {
                    z = false;
                }
                fVar.C(i3, i4, z);
                AppMethodBeat.o(120464);
                return;
            }
            AppMethodBeat.o(120464);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ StoryGalleryView FGW;

        m(StoryGalleryView storyGalleryView) {
            this.FGW = storyGalleryView;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            boolean z;
            AppMethodBeat.i(120463);
            com.tencent.mm.plugin.story.g.f fVar = this.FGW.FGC;
            if (fVar != null) {
                int i3 = this.FGW.Fre;
                int i4 = this.FGW.FGx;
                a aVar = this.FGW.FGH;
                if (aVar != null) {
                    z = aVar.FEF;
                } else {
                    z = false;
                }
                fVar.D(i3, i4, z);
                AppMethodBeat.o(120463);
                return;
            }
            AppMethodBeat.o(120463);
        }
    }

    private final void wa(boolean z) {
        AppMethodBeat.i(120502);
        Log.i(TAG, "toggleActiveState ".concat(String.valueOf(z)));
        StoryGalleryItemView storyGalleryItemView = this.FGq;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.wa(z);
        }
        this.FGG.wa(z);
        AppMethodBeat.o(120502);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ StoryGalleryView FGW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(StoryGalleryView storyGalleryView) {
            super(0);
            this.FGW = storyGalleryView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(120437);
            a aVar = StoryGalleryView.FGV;
            Log.i(StoryGalleryView.TAG, "is receive a message to update");
            if (this.FGW.dJM) {
                if (this.FGW.mIsActive) {
                    a aVar2 = StoryGalleryView.FGV;
                    Log.i(StoryGalleryView.TAG, "is receive a message to update but is was not allow ");
                    this.FGW.setNeedReset(true);
                } else {
                    a aVar3 = StoryGalleryView.FGV;
                    Log.i(StoryGalleryView.TAG, "is receive a message to update and do it  ");
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.c.AnonymousClass1 */
                        final /* synthetic */ c FGY;

                        {
                            this.FGY = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(120436);
                            com.tencent.mm.plugin.story.g.f fVar = this.FGY.FGW.FGC;
                            if (fVar != null) {
                                fVar.fpz();
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(120436);
                            return xVar;
                        }
                    });
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120437);
            return xVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v33, types: [kotlin.g.a.m, kotlin.g.a.m<? super android.widget.CompoundButton, ? super java.lang.Boolean, kotlin.x>] */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02a4, code lost:
        if ((r0 == null || r0.isEmpty()) == false) goto L_0x02a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04d1  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x063b  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x065d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0185  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView r10, int r11, android.view.View r12) {
        /*
        // Method dump skipped, instructions count: 1650
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.a(com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView, int, android.view.View):void");
    }

    public static final /* synthetic */ void a(StoryGalleryView storyGalleryView, int i2, RecyclerView recyclerView, GalleryHorizontalControlView galleryHorizontalControlView) {
        GalleryHorizontalControlView galleryHorizontalControlView2;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.a aVar;
        AppMethodBeat.i(120508);
        Log.i(TAG, "LogStory: onRowSelected " + i2 + ", " + recyclerView);
        if (storyGalleryView.Fre != i2 || !kotlin.g.b.p.j(storyGalleryView.FGs, recyclerView)) {
            storyGalleryView.FGO = storyGalleryView.mIsActive;
            storyGalleryView.FGN = -1;
            storyGalleryView.Fre = i2;
            RecyclerView recyclerView2 = storyGalleryView.FGs;
            GalleryLayoutManager galleryLayoutManager = (GalleryLayoutManager) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (galleryLayoutManager != null) {
                galleryLayoutManager.uyJ = null;
            }
            storyGalleryView.FGs = recyclerView;
            storyGalleryView.FGt = galleryHorizontalControlView;
            int size = storyGalleryView.FGB.size();
            int i3 = storyGalleryView.Fre;
            if (i3 >= 0 && size > i3 && (galleryHorizontalControlView2 = storyGalleryView.FGt) != null) {
                ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = storyGalleryView.FGB.get(storyGalleryView.Fre);
                kotlin.g.b.p.g(arrayList, "galleryGroups[selectedRow]");
                galleryHorizontalControlView2.hw(arrayList);
            }
            RecyclerView recyclerView3 = storyGalleryView.FGs;
            if (recyclerView3 != null) {
                layoutManager = recyclerView3.getLayoutManager();
            } else {
                layoutManager = null;
            }
            GalleryLayoutManager galleryLayoutManager2 = (GalleryLayoutManager) layoutManager;
            if (galleryLayoutManager2 != null) {
                galleryLayoutManager2.uyJ = new l(storyGalleryView);
            }
            if (galleryLayoutManager2 != null) {
                galleryLayoutManager2.nz(true);
            }
            storyGalleryView.FGv.f(recyclerView);
            RecyclerView recyclerView4 = storyGalleryView.FGs;
            if (recyclerView4 != null) {
                aVar = recyclerView4.getAdapter();
            } else {
                aVar = null;
            }
            storyGalleryView.FGu = (com.tencent.mm.plugin.story.ui.a.g) aVar;
            if (!storyGalleryView.FGB.get(i2).isEmpty()) {
                com.tencent.mm.plugin.story.f.d.h hVar = storyGalleryView.FGB.get(i2).get(0);
                kotlin.g.b.p.g(hVar, "galleryGroups[row][0]");
                com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                if (!com.tencent.mm.plugin.story.h.h.aSm(hVar2.userName)) {
                    com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                    jo fqi = com.tencent.mm.plugin.story.h.h.fqi();
                    fqi.sp(fqi.ahz() + 1);
                    if (ab.IS(hVar2.userName)) {
                        com.tencent.mm.plugin.story.h.h hVar5 = com.tencent.mm.plugin.story.h.h.FuH;
                        jo fqi2 = com.tencent.mm.plugin.story.h.h.fqi();
                        fqi2.sq(fqi2.ahA() + 1);
                    }
                }
            }
            com.tencent.mm.plugin.story.h.h hVar6 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.aaT(4);
        }
        AppMethodBeat.o(120508);
    }

    public static final /* synthetic */ void t(StoryGalleryView storyGalleryView) {
        String string;
        AppMethodBeat.i(120509);
        com.tencent.mm.plugin.story.f.d.h hVar = storyGalleryView.FGB.get(storyGalleryView.Fre).get(storyGalleryView.FGx);
        kotlin.g.b.p.g(hVar, "galleryGroups[selectedRow][selectedColumn]");
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(hVar.FoT.ecf);
        if (aba == null || !aba.frK()) {
            string = storyGalleryView.getContext().getString(R.string.hh_);
        } else {
            string = storyGalleryView.getContext().getString(R.string.hhz);
        }
        kotlin.g.b.p.g(string, "if (storyInfo?.checkFavo…elete_positive)\n        }");
        f.a aVar = new f.a(storyGalleryView.getContext());
        aVar.bow(string).boA(storyGalleryView.getContext().getString(R.string.hh_)).apb(-65536).Dq(true);
        aVar.c(new h(storyGalleryView, aba)).show();
        Log.i(TAG, "delete click");
        AppMethodBeat.o(120509);
    }

    public static final /* synthetic */ void f(com.tencent.mm.plugin.story.f.d.j jVar) {
        AppMethodBeat.i(120510);
        if (jVar.foV()) {
            String str = jVar.Fpd.taskId;
            kotlin.g.b.p.g(str, "storyVideoItem.media.taskId");
            com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
            com.tencent.mm.plugin.story.f.e.a.aSe(str);
            AppMethodBeat.o(120510);
            return;
        }
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(jVar.ecf);
        if (aba != null) {
            aba.clearItemDie();
            edu frI = aba.frI();
            frI.ibG = 0;
            frI.MsZ = (long) cl.aWB();
            frI.md5 = "";
            a.g gVar = a.g.FvU;
            frI.Mpa = a.g.fru();
            StringBuilder sb = new StringBuilder();
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            String sb2 = sb.append(j.b.fau()).append(Util.currentTicks()).append(cl.aWz()).toString();
            Charset charset = kotlin.n.d.UTF_8;
            if (sb2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(120510);
                throw tVar;
            }
            byte[] bytes = sb2.getBytes(charset);
            kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            frI.izX = com.tencent.mm.b.g.getMessageDigest(bytes);
            aba.field_createTime = cl.aWB();
            byte[] byteArray = frI.toByteArray();
            kotlin.g.b.p.g(byteArray, "postinfo.toByteArray()");
            aba.setPostBuf(byteArray);
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().a((int) aba.systemRowid, aba);
            AppMethodBeat.o(120510);
            return;
        }
        AppMethodBeat.o(120510);
    }

    public static final /* synthetic */ void u(StoryGalleryView storyGalleryView) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(120511);
        a aVar = storyGalleryView.FGH;
        if (aVar != null) {
            z = aVar.EHQ;
        } else {
            z = false;
        }
        if (!z) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            if (aAh.azQ().getBoolean(ar.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, true)) {
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                com.tencent.mm.ui.base.h.d(storyGalleryView.getContext(), "", storyGalleryView.getContext().getString(R.string.hi4), new n(storyGalleryView));
                AppMethodBeat.o(120511);
                return;
            }
        }
        com.tencent.mm.plugin.story.g.f fVar = storyGalleryView.FGC;
        if (fVar != null) {
            int i2 = storyGalleryView.Fre;
            int i3 = storyGalleryView.FGx;
            a aVar2 = storyGalleryView.FGH;
            if (aVar2 != null) {
                z2 = aVar2.EHQ;
            }
            fVar.C(i2, i3, z2);
            AppMethodBeat.o(120511);
            return;
        }
        AppMethodBeat.o(120511);
    }

    public static final /* synthetic */ void v(StoryGalleryView storyGalleryView) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(120512);
        a aVar = storyGalleryView.FGH;
        if (aVar != null) {
            z = aVar.FEF;
        } else {
            z = false;
        }
        if (!z) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.k foc = j.b.foc();
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            int size = foc.cy(j.b.fau(), true).size();
            a.c cVar = a.c.FvH;
            if (size >= a.c.frl()) {
                Context context = storyGalleryView.getContext();
                Context context2 = storyGalleryView.getContext();
                kotlin.g.b.p.g(context2, "context");
                com.tencent.mm.ui.base.h.X(context, "", context2.getResources().getString(R.string.hhy));
                AppMethodBeat.o(120512);
                return;
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            if (aAh.azQ().getBoolean(ar.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, true)) {
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                Context context3 = storyGalleryView.getContext();
                Context context4 = storyGalleryView.getContext();
                kotlin.g.b.p.g(context4, "context");
                com.tencent.mm.ui.base.h.d(context3, "", context4.getResources().getString(R.string.hi3), new m(storyGalleryView));
                AppMethodBeat.o(120512);
                return;
            }
        }
        com.tencent.mm.plugin.story.g.f fVar = storyGalleryView.FGC;
        if (fVar != null) {
            int i2 = storyGalleryView.Fre;
            int i3 = storyGalleryView.FGx;
            a aVar2 = storyGalleryView.FGH;
            if (aVar2 != null) {
                z2 = aVar2.FEF;
            }
            fVar.D(i2, i3, z2);
            AppMethodBeat.o(120512);
            return;
        }
        AppMethodBeat.o(120512);
    }
}

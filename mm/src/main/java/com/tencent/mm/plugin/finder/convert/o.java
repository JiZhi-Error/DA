package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.MediaBanner;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Õ\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001%\b&\u0018\u0000 ¨\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004¨\u0001©\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u001d\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001d\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010,J\u0015\u00100\u001a\u00020\u00072\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u001d\u00102\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001d\u00103\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001d\u00104\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001d\u00105\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J-\u00106\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH&¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0003J\u0018\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J(\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u0017\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010+\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010IJ \u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0002H\u0002J%\u0010M\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010N\u001a\u00020OH\u0002¢\u0006\u0002\u0010PJ'\u0010Q\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\b\u0010R\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0002\u0010SJ'\u0010T\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\b\u0010U\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0002\u0010SJ\u0015\u0010V\u001a\u00020\u00072\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0015\u0010W\u001a\u00020\u00072\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J6\u0010X\u001a\u00020(2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u0006\u0010_\u001a\u00020^2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J*\u0010`\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010a\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J)\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020f0e2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010gJE\u0010h\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u00072\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010]H\u0017¢\u0006\u0002\u0010lJ \u0010m\u001a\u00020(2\u0006\u0010n\u001a\u00020o2\u0006\u0010)\u001a\u00020*2\u0006\u00108\u001a\u00020\tH\u0017J-\u0010p\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0016¢\u0006\u0002\u00109J \u0010q\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010r\u001a\u00020^2\u0006\u0010s\u001a\u00020tH\u0016J \u0010u\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010r\u001a\u00020^2\u0006\u0010b\u001a\u00020cH\u0016J\u001d\u0010v\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010wJ-\u0010x\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0016¢\u0006\u0002\u00109JS\u0010y\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\b\b\u0002\u0010z\u001a\u00020\u00072\b\b\u0002\u0010{\u001a\u00020|2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\b\b\u0002\u0010\u001a\u00020\t2\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0014¢\u0006\u0003\u0010\u0001J3\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00020\u00022\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0002J*\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00002\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010\u0001J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010wJ\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J/\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\t\u0010+\u001a\u0005\u0018\u00010\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0003\u0010\u0001J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010,J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010wJ\u0019\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0002J'\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\t\u0010+\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010DH\u0002J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ*\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*2\t\b\u0002\u0010\u0001\u001a\u00020\u0007H\u0017¢\u0006\u0003\u0010\u0001J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J(\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0003\u0010\u0001J\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ\u001e\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001e\u0010 \u0001\u001a\u00020(2\u0006\u0010+\u001a\u00028\u00002\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010wJ\u001f\u0010¡\u0001\u001a\u00020(2\b\u0010¢\u0001\u001a\u00030£\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0002J\u0011\u0010¦\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0011\u0010§\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0016\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u001b\u0010!\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b\"\u0010\u000eR\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006ª\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "avatarRectControl", "displayHeight", "getDisplayHeight", "()I", "displayHeight$delegate", "Lkotlin/Lazy;", "isFromAd", "()Z", "isFromAd$delegate", "isRealNameLike", "navigationBarHeight", "getNavigationBarHeight", "navigationBarHeight$delegate", "rect", "Landroid/graphics/Rect;", "getSafeMode", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "getTabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1;", "adjustOptionLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "adjustSeekLayout", "adjustUserLayout", "calculateMediaLayoutParams", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkScrollToNextFeed", "checkShowFollowLikeLayout", "checkShowLittleFollowLayout", "checkShowShareSnsLayout", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "formatDesc", "incCount", "suffix", "", "descTv", "Landroid/widget/TextView;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "handleCampaignOnClick", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "handleLinkTvOnClick", "link", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "handlePoiOnClick", "poiText", "isNewsObject", "isShowRealNameRecommendLayout", "likeAvatarAnimator", "likeCount", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "avatarLayoutList", "", "Landroid/view/View;", "parent", "likeFeed", "likeAction", "e", "Landroid/view/MotionEvent;", "mergeContent", "Lkotlin/Pair;", "Landroid/text/SpannableString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)Lkotlin/Pair;", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onDeepEnjoyMedia", "onMediaClick", "view", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onPostFinished", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "onUnFocusFeedCenter", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "refreshAwesomeIv", "isLike", "isPrivate", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshCommentLayout", "refreshDescContent", "refreshFav", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFollowState", "refreshForwardCount", "refreshFriendFollowCount", "refreshFullGuideTips", "refreshLivingIcon", "refreshMoreBtn", "refreshNewsLayout", "userName", "refreshNickname", "refreshPostProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshPrivateIcon", "refreshRead", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshSelfScene", "refreshUpdateTime", "setGroupLikeIcon", "imageView", "Landroid/widget/ImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "shareFeed", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class o<T extends BaseFinderFeed> extends com.tencent.mm.view.recyclerview.e<T> {
    public static final a tBI = new a((byte) 0);
    final int dLS;
    private Rect rect = new Rect();
    private final HashSet<b<T>> tAb = new HashSet<>();
    private final boolean tAf;
    private final boolean tAg;
    private final com.tencent.mm.plugin.finder.feed.i tAi;
    private boolean tAj;
    private final kotlin.f tBE = kotlin.g.ah(h.tBQ);
    final kotlin.f tBF = kotlin.g.ah(l.tCc);
    private final kotlin.f tBG = kotlin.g.ah(new i(this));
    private final FinderFeedFullConvert$uiLifecycleObserver$1 tBH;
    private final kotlin.f tTb = kotlin.g.ah(new aw(this));

    private boolean cZC() {
        return ((Boolean) this.tBG.getValue()).booleanValue();
    }

    private int getTopBarHeight() {
        return ((Number) this.tTb.getValue()).intValue();
    }

    public abstract void g(com.tencent.mm.view.recyclerview.h hVar, T t2);

    public final int getDisplayHeight() {
        return ((Number) this.tBE.getValue()).intValue();
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "txt", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$4$1"})
    public static final class at extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ String nNF;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ int tBW;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        at(String str, o oVar, com.tencent.mm.view.recyclerview.h hVar, int i2, BaseFinderFeed baseFinderFeed) {
            super(1);
            this.nNF = str;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBW = i2;
            this.tAz = baseFinderFeed;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(260201);
            kotlin.g.b.p.h(str, "txt");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                o.b(this.tzq, this.tAz, this.nNF);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(260201);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "txt", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$2$1"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ z.a UHX;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableString tBR;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ int tBZ;
        final /* synthetic */ z.a tCa;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(o oVar, SpannableString spannableString, SpannableStringBuilder spannableStringBuilder, com.tencent.mm.view.recyclerview.h hVar, NeatTextView neatTextView, float f2, int i2, BaseFinderFeed baseFinderFeed, int i3, z.a aVar, int i4, int i5, int i6, z.a aVar2) {
            super(1);
            this.tBP = oVar;
            this.tBR = spannableString;
            this.tBS = spannableStringBuilder;
            this.tzq = hVar;
            this.tBT = neatTextView;
            this.tBU = f2;
            this.tBV = i2;
            this.tAz = baseFinderFeed;
            this.tBW = i3;
            this.UHX = aVar;
            this.tBX = i4;
            this.tBY = i5;
            this.tBZ = i6;
            this.tCa = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(242894);
            String str2 = str;
            kotlin.g.b.p.h(str2, "txt");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af).dxX() && !this.tAz.isPreview) {
                o.a(this.tBP, this.tzq, this.tAz, str2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242894);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "txt", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$3$1"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ String nNF;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ z.a tCa;
        final /* synthetic */ int tCb;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str, o oVar, com.tencent.mm.view.recyclerview.h hVar, SpannableStringBuilder spannableStringBuilder, NeatTextView neatTextView, float f2, int i2, z.a aVar, int i3, int i4, int i5, BaseFinderFeed baseFinderFeed, int i6) {
            super(1);
            this.nNF = str;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBS = spannableStringBuilder;
            this.tBT = neatTextView;
            this.tBU = f2;
            this.tBV = i2;
            this.tCa = aVar;
            this.tBW = i3;
            this.tBY = i4;
            this.tBX = i5;
            this.tAz = baseFinderFeed;
            this.tCb = i6;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(242895);
            kotlin.g.b.p.h(str, "txt");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                o.b(this.tzq, this.tAz, this.nNF);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242895);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$1$1"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ azs UHV;
        final /* synthetic */ z.d UHW;
        final /* synthetic */ z.a UHX;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableString tBR;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(azs azs, o oVar, com.tencent.mm.view.recyclerview.h hVar, NeatTextView neatTextView, SpannableString spannableString, z.d dVar, SpannableStringBuilder spannableStringBuilder, float f2, int i2, BaseFinderFeed baseFinderFeed, int i3, int i4, int i5, z.a aVar) {
            super(1);
            this.UHV = azs;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBT = neatTextView;
            this.tBR = spannableString;
            this.UHW = dVar;
            this.tBS = spannableStringBuilder;
            this.tBU = f2;
            this.tBV = i2;
            this.tAz = baseFinderFeed;
            this.tBW = i3;
            this.tBX = i4;
            this.tBY = i5;
            this.UHX = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(260197);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af).dxX() && !this.tAz.isPreview) {
                o.a(this.tzq, this.tAz, this.UHV);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(260197);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, String str) {
        Log.i("Finder.FeedFullConvert", "[handlePoiOnClick] poiText=" + str + ' ');
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drN()) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drP()) {
                Intent intent = new Intent();
                intent.putExtra("key_topic_type", 2);
                intent.putExtra("key_ref_object_id", baseFinderFeed.feedObject.getId());
                intent.putExtra("key_topic_title", str);
                intent.putExtra("key_topic_poi_location", baseFinderFeed.feedObject.getLocation().toByteArray());
                intent.putExtra("KEY_TAB_TYPE", oVar.dLS);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                com.tencent.mm.plugin.finder.utils.a.O(context2, intent);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                Context context3 = hVar.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                if (fH != null) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    long lT = baseFinderFeed.lT();
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.finder.report.k.a(lT, str, 2, fH.tCE);
                    com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b(fH);
                    if (b2 != null) {
                        b2.cZR().Eu(baseFinderFeed.lT());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        Context context4 = hVar.getContext();
        kotlin.g.b.p.g(context4, "holder.context");
        com.tencent.mm.plugin.finder.utils.y.a(context4, baseFinderFeed.feedObject.getLocation());
    }

    public static final /* synthetic */ void f(BaseFinderFeed baseFinderFeed) {
        if (baseFinderFeed.feedObject.getId() != 0) {
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            if (c.a.FT(baseFinderFeed.feedObject.getId())) {
                hg hgVar = new hg();
                hgVar.dLJ.id = baseFinderFeed.feedObject.getId();
                EventCenter.instance.publish(hgVar);
                Log.i("Finder.FeedFullConvert", "deleteItem by id " + baseFinderFeed.feedObject.getId());
                return;
            }
        }
        if (baseFinderFeed.feedObject.getLocalId() >= 0) {
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            FinderItem FS = c.a.FS(baseFinderFeed.feedObject.getLocalId());
            c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.FV(baseFinderFeed.feedObject.getLocalId());
            r.d dVar = r.d.vhx;
            r.d.ol(baseFinderFeed.feedObject.isLongVideo());
            if (FS != null) {
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.e(baseFinderFeed.feedObject);
            }
            if (baseFinderFeed.feedObject.isLongVideo()) {
                r.d dVar2 = r.d.vhx;
                r.d.dow();
            }
            hg hgVar2 = new hg();
            hgVar2.dLJ.localId = baseFinderFeed.feedObject.getLocalId();
            EventCenter.instance.publish(hgVar2);
            Log.i("Finder.FeedFullConvert", "deleteItem by localId " + baseFinderFeed.feedObject.getLocalId() + ", posting:true");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.tencent.mm.plugin.finder.convert.o<T extends com.tencent.mm.plugin.finder.model.BaseFinderFeed> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z2, List list) {
        a(hVar, (BaseFinderFeed) aVar, i2, i3, z2, (List<Object>) list);
    }

    public o(com.tencent.mm.plugin.finder.feed.i iVar, boolean z2, int i2) {
        boolean z3 = true;
        kotlin.g.b.p.h(iVar, "contract");
        this.tAi = iVar;
        this.tAj = z2;
        this.dLS = i2;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAf = com.tencent.mm.plugin.finder.storage.c.dsp().value().intValue() == 1;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAg = com.tencent.mm.plugin.finder.storage.c.dsq().value().intValue() != 1 ? false : z3;
        this.tBH = new FinderFeedFullConvert$uiLifecycleObserver$1(this);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$Companion;", "", "()V", "MENU_ID_ONLY_POSTER_CAN_SEE", "", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        com.tencent.mm.plugin.finder.event.base.c MA;
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        View view = hVar.aus;
        kotlin.g.b.p.g(view, "holder.itemView");
        view.getLayoutParams().width = -1;
        View view2 = hVar.aus;
        kotlin.g.b.p.g(view2, "holder.itemView");
        view2.getLayoutParams().height = -1;
        recyclerView.getLayoutParams().height = -1;
        recyclerView.getLayoutParams().width = -1;
        ViewParent parent = recyclerView.getParent();
        if (parent == null) {
            throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup) parent).getLayoutParams().width = -1;
        ViewParent parent2 = recyclerView.getParent();
        if (parent2 == null) {
            throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup) parent2).getLayoutParams().height = -1;
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setIndicatorStyle(MediaBanner.d.NONE);
        finderMediaBanner.setNeedSpaceView(false);
        finderMediaBanner.removeView(finderMediaBanner.wog);
        ((ImageView) hVar.Mn(R.id.x1)).setOnClickListener(new y(hVar));
        NeatTextView neatTextView = (NeatTextView) hVar.Mn(R.id.ik5);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        kotlin.g.b.p.g(neatTextView, "contentTv");
        neatTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(neatTextView, com.tencent.mm.plugin.finder.utils.y.eh(neatTextView)));
        b<T> bVar = new b<>(this, hVar);
        hVar.aus.addOnAttachStateChangeListener(bVar);
        bVar.alive();
        this.tAb.add(bVar);
        View Mn = hVar.Mn(R.id.xk);
        Mn.setOnTouchListener(new s());
        Mn.setOnClickListener(new t(this, hVar));
        Mn.setOnLongClickListener(new u(this, hVar));
        kotlin.g.b.p.g(Mn, "awesomeContainer");
        Mn.setHapticFeedbackEnabled(false);
        View Mn2 = hVar.Mn(R.id.d8o);
        if (Mn2 != null) {
            Mn2.setOnClickListener(v.AnonymousClass1.UIb);
            TextView textView = (TextView) Mn2.findViewById(R.id.gsc);
            if (textView != null) {
                textView.setTextSize(1, 12.0f);
            }
            TextView textView2 = (TextView) Mn2.findViewById(R.id.cbj);
            if (textView2 != null) {
                textView2.setTextSize(1, 12.0f);
            }
            TextView textView3 = (TextView) Mn2.findViewById(R.id.hp9);
            if (textView3 != null) {
                textView3.setTextSize(1, 12.0f);
            }
            TextView textView4 = (TextView) Mn2.findViewById(R.id.eba);
            if (textView4 != null) {
                textView4.setTextSize(1, 12.0f);
            }
            TextView textView5 = (TextView) Mn2.findViewById(R.id.b8o);
            if (textView5 != null) {
                textView5.setTextSize(1, 12.0f);
            }
        }
        TextView textView6 = (TextView) hVar.Mn(R.id.ed3);
        if (textView6 != null) {
            textView6.setTextSize(1, 10.0f);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null && (MA = fH.MA(this.dLS)) != null) {
            MA.a(new au(this, hVar));
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class y implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        y(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            int i2;
            s.p pVar;
            long j2;
            long j3;
            AppMethodBeat.i(242918);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$onAvatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                i2 = fH.tCE;
            } else {
                i2 = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("finder_username", baseFinderFeed.feedObject.getUserName());
            intent.putExtra("finder_read_feed_id", baseFinderFeed.feedObject.getId());
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            FinderReporterUIC.a.a(context2, intent, baseFinderFeed.lT(), 1, false, 64);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            kotlin.g.b.p.g(baseFinderFeed, "item");
            long lR = (long) this.qhp.lR();
            String valueOf = String.valueOf(i2);
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            kotlin.g.b.p.h(valueOf, "commentscene");
            if (baseFinderFeed.cxn() == 9) {
                pVar = s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING;
            } else {
                pVar = s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR;
            }
            long lT = baseFinderFeed.lT();
            awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
            if (liveInfo != null) {
                j2 = liveInfo.liveId;
            } else {
                j2 = 0;
            }
            String userName = baseFinderFeed.feedObject.getUserName();
            awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
            if (liveInfo2 != null) {
                j3 = (long) liveInfo2.uBn;
            } else {
                j3 = -1;
            }
            com.tencent.mm.plugin.finder.report.live.k.b(new com.tencent.mm.plugin.finder.report.live.p(lT, j2, userName, lR, j3, pVar, valueOf));
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context3 = this.qhp.getContext();
            kotlin.g.b.p.g(context3, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context3, intent);
            if (this.qhp.getContext() instanceof MMActivity) {
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                Context context4 = this.qhp.getContext();
                if (context4 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(242918);
                    throw tVar;
                }
                com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context4).get(FinderReporterUIC.class));
                if (b2 != null) {
                    b2.cZR().Eq(baseFinderFeed.lT());
                }
            }
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(3, baseFinderFeed.lT(), i2, 1, baseFinderFeed.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$onAvatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242918);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class s implements View.OnTouchListener {
        final /* synthetic */ Runnable UHZ = null;

        s() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(260202);
            kotlin.g.b.p.g(motionEvent, "event");
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                view.removeCallbacks(this.UHZ);
            }
            AppMethodBeat.o(260202);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class t implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ o tBP;

        t(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.qhp = hVar;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
            java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.replaceUnknownTypes(MethodInvokeVisitor.java:299)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:258)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
            */
        public final void onClick(android.view.View r9) {
            /*
            // Method dump skipped, instructions count: 147
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.o.t.onClick(android.view.View):void");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class u implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ o tBP;

        u(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(260206);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (!this.tBP.tAi.dbZ()) {
                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dtQ().value().intValue() == 1) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                        Log.i("Finder.FeedFullConvert", "onLongClick Private Like:" + this.qhp.lR());
                        ImageView imageView = (ImageView) this.qhp.Mn(R.id.dts);
                        kotlin.g.b.p.g(imageView, "awesomeIv");
                        if ((imageView.getTag() instanceof Integer) && kotlin.g.b.p.j(imageView.getTag(), 0)) {
                            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 1, true);
                            eVar.setTitleView(com.tencent.mm.ui.aa.jQ(this.qhp.getContext()).inflate(R.layout.aip, (ViewGroup) null));
                            eVar.a(new o.f(this) {
                                /* class com.tencent.mm.plugin.finder.convert.o.u.AnonymousClass1 */
                                final /* synthetic */ u UIa;

                                {
                                    this.UIa = r1;
                                }

                                @Override // com.tencent.mm.ui.base.o.f
                                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                    AppMethodBeat.i(260204);
                                    kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
                                    if (mVar.gKQ()) {
                                        Context context = this.UIa.qhp.getContext();
                                        kotlin.g.b.p.g(context, "holder.context");
                                        mVar.d(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, context.getResources().getString(R.string.d6_));
                                    }
                                    AppMethodBeat.o(260204);
                                }
                            });
                            eVar.a(new o.g(this) {
                                /* class com.tencent.mm.plugin.finder.convert.o.u.AnonymousClass2 */
                                final /* synthetic */ u UIa;

                                {
                                    this.UIa = r1;
                                }

                                /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
                                    java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
                                    	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
                                    	at java.util.ArrayList.get(ArrayList.java:435)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.replaceUnknownTypes(MethodInvokeVisitor.java:299)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:258)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
                                    	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
                                    */
                                @Override // com.tencent.mm.ui.base.o.g
                                public final void onMMMenuItemSelected(android.view.MenuItem r5, int r6) {
                                    /*
                                        r4 = this;
                                        r3 = 260205(0x3f86d, float:3.64625E-40)
                                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                                        java.lang.String r0 = "menuItem"
                                        kotlin.g.b.p.g(r5, r0)
                                        int r0 = r5.getItemId()
                                        switch(r0) {
                                            case 10003: goto L_0x0017;
                                            default: goto L_0x0013;
                                        }
                                    L_0x0013:
                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                                        return
                                    L_0x0017:
                                        com.tencent.mm.plugin.finder.convert.o$u r0 = r4.UIa
                                        com.tencent.mm.plugin.finder.convert.o r0 = r0.tBP
                                        com.tencent.mm.plugin.finder.convert.o$u r1 = r4.UIa
                                        com.tencent.mm.view.recyclerview.h r1 = r1.qhp
                                        r2 = 1
                                        com.tencent.mm.plugin.finder.convert.o.a(r0, r1, r2)
                                        goto L_0x0013
                                        switch-data {10003->0x0017, }
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.o.u.AnonymousClass2.onMMMenuItemSelected(android.view.MenuItem, int):void");
                                }
                            });
                            eVar.dGm();
                        }
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(260206);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$5", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"})
    public static final class au extends com.tencent.mm.plugin.finder.event.base.d {
        private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ o tBP;
        private long tCi;

        au(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.qhp = hVar;
            AppMethodBeat.i(260213);
            AppMethodBeat.o(260213);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.tencent.mm.plugin.finder.convert.o */
        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.tencent.mm.plugin.finder.convert.o */
        /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.tencent.mm.plugin.finder.convert.o */
        /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.tencent.mm.plugin.finder.convert.o */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(260210);
            kotlin.g.b.p.h(bVar, "ev");
            if (!(bVar instanceof c.a) || ((c.a) bVar).type != 2) {
                if (!(bVar instanceof c.a) || ((c.a) bVar).type != 3) {
                    if ((bVar instanceof com.tencent.mm.plugin.finder.event.base.h) && ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 6) {
                        if (((BaseFinderFeed) this.qhp.hgv()).lT() == this.tCi && this.tCi != ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIC) {
                            o oVar = this.tBP;
                            com.tencent.mm.view.recyclerview.h hVar = this.qhp;
                            Object hgv = this.qhp.hgv();
                            kotlin.g.b.p.g(hgv, "holder.getAssociatedObject()");
                            oVar.c(hVar, (BaseFinderFeed) hgv, this.qhp.lR());
                        }
                        this.tCi = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIC;
                        FeedData feedData = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIF;
                        if (feedData == null) {
                            AppMethodBeat.o(260210);
                            return;
                        } else if (feedData.getMediaType() == 2) {
                            this.hAk.removeCallbacksAndMessages(null);
                            this.hAk.postDelayed(new a(this, bVar), 10000);
                            AppMethodBeat.o(260210);
                            return;
                        }
                    } else if ((bVar instanceof com.tencent.mm.plugin.finder.event.base.h) && ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 10 && ((BaseFinderFeed) this.qhp.hgv()).lT() == ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIC) {
                        o oVar2 = this.tBP;
                        com.tencent.mm.view.recyclerview.h hVar2 = this.qhp;
                        Object hgv2 = this.qhp.hgv();
                        kotlin.g.b.p.g(hgv2, "holder.getAssociatedObject()");
                        oVar2.c(hVar2, (BaseFinderFeed) hgv2, this.qhp.lR());
                    }
                } else if (((BaseFinderFeed) this.qhp.hgv()).lT() == ((c.a) bVar).feedId) {
                    int i2 = ((c.a) bVar).jcu;
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (i2 > com.tencent.mm.plugin.finder.storage.c.drG()) {
                        int i3 = ((c.a) bVar).offset;
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        if (i3 == com.tencent.mm.plugin.finder.storage.c.drG()) {
                            Log.i("Finder.FeedFullConvert", "onEventHappen: VIDEO_PROGRESS mega video deep enjoy total = " + ((c.a) bVar).jcu + ", offset = " + ((c.a) bVar).offset);
                            o oVar3 = this.tBP;
                            com.tencent.mm.view.recyclerview.h hVar3 = this.qhp;
                            Object hgv3 = this.qhp.hgv();
                            kotlin.g.b.p.g(hgv3, "holder.getAssociatedObject()");
                            this.qhp.lR();
                            oVar3.e(hVar3, (BaseFinderFeed) hgv3);
                            AppMethodBeat.o(260210);
                            return;
                        }
                    }
                }
            } else if (((BaseFinderFeed) this.qhp.hgv()).lT() == ((c.a) bVar).feedId) {
                o oVar4 = this.tBP;
                com.tencent.mm.view.recyclerview.h hVar4 = this.qhp;
                Object hgv4 = this.qhp.hgv();
                kotlin.g.b.p.g(hgv4, "holder.getAssociatedObject()");
                this.qhp.lR();
                oVar4.e(hVar4, (BaseFinderFeed) hgv4);
                AppMethodBeat.o(260210);
                return;
            }
            AppMethodBeat.o(260210);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
        static final class a implements Runnable {
            final /* synthetic */ au UIc;
            final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b tCk;

            a(au auVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
                this.UIc = auVar;
                this.tCk = bVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.tencent.mm.plugin.finder.convert.o */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(260209);
                if (((BaseFinderFeed) this.UIc.qhp.hgv()).lT() == ((com.tencent.mm.plugin.finder.event.base.h) this.tCk).tIC) {
                    o oVar = this.UIc.tBP;
                    com.tencent.mm.view.recyclerview.h hVar = this.UIc.qhp;
                    Object hgv = this.UIc.qhp.hgv();
                    kotlin.g.b.p.g(hgv, "holder.getAssociatedObject()");
                    this.UIc.qhp.lR();
                    oVar.e(hVar, (BaseFinderFeed) hgv);
                }
                AppMethodBeat.o(260209);
            }
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void onRelease() {
            AppMethodBeat.i(260211);
            super.onRelease();
            this.hAk.removeCallbacksAndMessages(null);
            AppMethodBeat.o(260211);
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(260212);
            kotlin.g.b.p.h(cVar, "dispatcher");
            kotlin.g.b.p.h(bVar, "event");
            if ((bVar instanceof c.a) || (bVar instanceof com.tencent.mm.plugin.finder.event.base.h)) {
                AppMethodBeat.o(260212);
                return true;
            }
            AppMethodBeat.o(260212);
            return false;
        }
    }

    public final void c(com.tencent.mm.view.recyclerview.h hVar, T t2, int i2) {
        int i3;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
        FinderFullSeekBarLayout finderFullSeekBarLayout = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        if (finderFullSeekBarLayout != null) {
            Object tag = finderFullSeekBarLayout.getPauseIcon().getTag();
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            boolean z2 = i3 == 1;
            Log.i("Finder.FeedFullConvert", "[onUnFocusFeedCenter] tabType=" + this.dLS + " pos=" + i2 + " isInSeekMode=" + finderFullSeekBarLayout.wbG + " isPlaying=" + z2 + " id=" + com.tencent.mm.ac.d.zs(t2.lT()));
            if (finderFullSeekBarLayout.wbG && z2) {
                finderFullSeekBarLayout.awG("onUnFocusFeedCenter");
            }
        }
        View Mn = hVar.Mn(R.id.d37);
        if (Mn != null) {
            Mn.setVisibility(8);
        }
    }

    public final void e(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        Object obj;
        FinderLikeDrawer finderLikeDrawer;
        String str = null;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
        if (!this.tAi.dbZ() && !t2.isDeepEnjoy) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwy().value().intValue() == 1) {
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                if (fH != null) {
                    i2 = fH.tCE;
                } else {
                    i2 = 0;
                }
                RecyclerView recyclerView = hVar.getRecyclerView();
                kotlin.g.b.p.g(recyclerView, "holder.recyclerView");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    i3 = adapter.getItemCount();
                } else {
                    i3 = 0;
                }
                com.tencent.mm.plugin.finder.view.e dcg = this.tAi.dcg();
                if (dcg == null || !dcg.dGs()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Context context2 = hVar.getContext();
                if (!(context2 instanceof Activity)) {
                    context2 = null;
                }
                Activity activity = (Activity) context2;
                if (activity == null || (finderLikeDrawer = (FinderLikeDrawer) activity.findViewById(R.id.clq)) == null || !finderLikeDrawer.dGs()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                View Mn = hVar.Mn(R.id.hph);
                if (Mn != null) {
                    obj = Mn.getTag();
                } else {
                    obj = null;
                }
                boolean j2 = kotlin.g.b.p.j(obj, Boolean.TRUE);
                Log.i("Finder.FeedFullConvert", "[checkScrollToNextFeed] isDrawerOpen=" + z2 + " isLikeDrawerOpen=" + z3 + " isShowBottomSheet=" + j2 + ' ' + "position=" + hVar.lR() + " itemCount=" + i3 + " commentScene=" + i2);
                if (!j2 && !z2 && !z3 && hVar.lR() + 1 < i3 && (i2 == 38 || i2 == 25)) {
                    RecyclerView recyclerView2 = hVar.getRecyclerView();
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(hVar.lR() + 1, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView2.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert", "checkScrollToNextFeed", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
            }
            t2.isDeepEnjoy = true;
            com.tencent.mm.plugin.finder.api.g gVar = t2.contact;
            int i4 = gVar != null ? gVar.field_liveStatus : 2;
            StringBuilder append = new StringBuilder("[checkShowLittleFollowLayout] tabType=").append(this.dLS).append(" liveStatus=").append(i4).append(" id=").append(com.tencent.mm.ac.d.zs(t2.lT())).append(" nickname=");
            com.tencent.mm.plugin.finder.api.g gVar2 = t2.contact;
            if (gVar2 != null) {
                str = gVar2.getNickname();
            }
            Log.i("Finder.FeedFullConvert", append.append(str).toString());
            if (i4 != 1) {
                View Mn2 = hVar.Mn(R.id.ed3);
                kotlin.g.b.p.g(Mn2, "followTv");
                if (Mn2.getVisibility() != 0) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                    if (!c.a.asJ(t2.feedObject.field_username) && this.dLS != 3) {
                        Mn2.setVisibility(0);
                        Mn2.setAlpha(0.0f);
                        Mn2.animate().alpha(1.0f).setDuration(300).setListener(new e(Mn2, hVar, t2)).start();
                        f(t2, hVar);
                    }
                }
            }
            f(hVar, t2);
            f(t2, hVar);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$checkShowLittleFollowLayout$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class e extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View UHU;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        e(View view, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.UHU = view;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(242888);
            View view = this.UHU;
            kotlin.g.b.p.g(view, "followTv");
            view.setAlpha(1.0f);
            com.tencent.mm.plugin.finder.report.aj ajVar = com.tencent.mm.plugin.finder.report.aj.viU;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.aj.a(fH != null ? fH.dIx() : null, "follow", true, this.tAr.lT());
            AppMethodBeat.o(242888);
        }
    }

    private final void f(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        View Mn;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean z2 = com.tencent.mm.plugin.finder.storage.c.dwq().value().intValue() == 1;
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(t2.feedObject.getFeedObject());
        boolean booleanValue = m2.first.booleanValue();
        m2.second.booleanValue();
        StringBuilder append = new StringBuilder("[checkShowFollowLikeLayout] isLike=").append(booleanValue).append(" tabType=").append(this.dLS).append(" id=").append(com.tencent.mm.ac.d.zs(t2.lT())).append(" nickname=");
        com.tencent.mm.plugin.finder.api.g gVar = t2.contact;
        Log.i("Finder.FeedFullConvert", append.append(gVar != null ? gVar.getNickname() : null).toString());
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVb().value().intValue() == 1) {
                Mn = hVar.Mn(R.id.jzh);
            } else {
                Mn = hVar.Mn(R.id.d82);
            }
            kotlin.g.b.p.g(Mn, "followLikeLayout");
            if (Mn.getVisibility() != 0 && !booleanValue && d(t2)) {
                Mn.setVisibility(0);
                Mn.setAlpha(0.0f);
                Mn.animate().alpha(1.0f).setDuration(300).setListener(new d(Mn, hVar, t2)).start();
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$checkShowFollowLikeLayout$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class d extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ View tCp;

        d(View view, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tCp = view;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(242887);
            View view = this.tCp;
            kotlin.g.b.p.g(view, "followLikeLayout");
            view.setAlpha(1.0f);
            com.tencent.mm.plugin.finder.report.aj ajVar = com.tencent.mm.plugin.finder.report.aj.viU;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.aj.a(fH != null ? fH.dIx() : null, "follow_like", true, this.tAr.lT());
            AppMethodBeat.o(242887);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$4$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class m implements HardTouchableLayout.b {
        final /* synthetic */ HardTouchableLayout tAC;
        final /* synthetic */ o tBP;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        m(HardTouchableLayout hardTouchableLayout, o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAC = hardTouchableLayout;
            this.tBP = oVar;
            this.tzq = hVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242898);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            Log.i("Finder.FeedFullConvert", "onDoubleClick " + ((BaseFinderFeed) this.tzq.hgv()));
            this.tBP.a(this.tzq, this.tAC, motionEvent);
            AppMethodBeat.o(242898);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$6$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$let$lambda$1"})
    /* renamed from: com.tencent.mm.plugin.finder.convert.o$o  reason: collision with other inner class name */
    public static final class View$OnClickListenerC1103o implements View.OnClickListener {
        final /* synthetic */ o tCd;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        View$OnClickListenerC1103o(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tCd = oVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242900);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            o oVar = this.tCd;
            com.tencent.mm.view.recyclerview.h hVar = this.tzq;
            kotlin.g.b.p.g(view, LocaleUtil.ITALIAN);
            oVar.b(hVar, view, ((BaseFinderFeed) this.tzq.hgv()).feedObject.getFeedObject());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242900);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$6$2$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$let$lambda$2"})
    public static final class p implements HardTouchableLayout.g {
        final /* synthetic */ o tCd;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        p(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tCd = oVar;
            this.tzq = hVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242901);
            kotlin.g.b.p.h(view, "view");
            if (motionEvent == null) {
                AppMethodBeat.o(242901);
                return;
            }
            Rect rect = new Rect();
            View Mn = this.tzq.Mn(R.id.clr);
            if (Mn != null) {
                Mn.getGlobalVisibleRect(rect);
            }
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.tCd.b(this.tzq, view, ((BaseFinderFeed) this.tzq.hgv()).feedObject.getFeedObject());
            }
            AppMethodBeat.o(242901);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class q implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        q(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tBP = oVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(242903);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 0, false);
            eVar.a(this.tBP.tAi.a(this.tAr, eVar));
            eVar.b(this.tBP.tAi.i(this.tAr));
            eVar.a(this.tBP.tAi.j(this.tAr));
            eVar.b(this.tBP.tAi.j(this.tAr));
            kotlin.g.b.p.g(view, LocaleUtil.ITALIAN);
            view.setTag(Boolean.TRUE);
            eVar.b(new e.b(this) {
                /* class com.tencent.mm.plugin.finder.convert.o.q.AnonymousClass1 */
                final /* synthetic */ q tCe;

                {
                    this.tCe = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    bbn bbn;
                    AppMethodBeat.i(242902);
                    View view = view;
                    kotlin.g.b.p.g(view, LocaleUtil.ITALIAN);
                    view.setTag(Boolean.FALSE);
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    Context context = this.tCe.qhp.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    if (fH != null) {
                        bbn = fH.dIx();
                    } else {
                        bbn = null;
                    }
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(((BaseFinderFeed) this.tCe.qhp.hgv()).feedObject.getId(), 2, 3, "", bbn, 0, (FinderItem) null, 96);
                    AppMethodBeat.o(242902);
                }
            });
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242903);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class r implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        r(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final boolean onLongClick(View view) {
            com.tencent.mm.plugin.finder.loader.s sVar;
            FinderVideoLayout.b playInfo;
            AppMethodBeat.i(242904);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.qhp.Mn(R.id.ckd);
            if (finderVideoLayout == null || (playInfo = finderVideoLayout.getPlayInfo()) == null) {
                sVar = null;
            } else {
                sVar = playInfo.uPf;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.qhp.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(242904);
                throw tVar;
            }
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            ((FinderDebugUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderDebugUIC.class)).a(context2, this.tAr, sVar, this.qhp);
            this.qhp.getRecyclerView().requestLayout();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242904);
            return true;
        }
    }

    private static void f(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        TextView textView = (TextView) hVar.aus.findViewById(R.id.fzc);
        kotlin.g.b.p.g(textView, "nickTv");
        textView.setText(t2.feedObject.getNickNameSpan());
        com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
        textView.setOnClickListener(new aj(hVar));
        View Mn = hVar.Mn(R.id.w0);
        View Mn2 = hVar.Mn(R.id.ed3);
        View Mn3 = hVar.Mn(R.id.czt);
        kotlin.g.b.p.g(Mn3, "livingIcon");
        if (Mn3.getVisibility() == 0) {
            Mn2 = Mn3;
        }
        float ez = com.tencent.mm.cb.a.ez(hVar.getContext());
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        float dimension = context.getResources().getDimension(R.dimen.cf);
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        float dimension2 = context2.getResources().getDimension(R.dimen.cb);
        View findViewById = hVar.aus.findViewById(R.id.hph);
        if (!(findViewById == null || (layoutParams2 = findViewById.getLayoutParams()) == null || !(layoutParams2 instanceof LinearLayout.LayoutParams))) {
            if (ez >= 1.125f) {
                ((LinearLayout.LayoutParams) layoutParams2).setMarginEnd((int) dimension2);
            } else {
                ((LinearLayout.LayoutParams) layoutParams2).setMarginEnd((int) dimension);
            }
        }
        View findViewById2 = hVar.aus.findViewById(R.id.xk);
        if (!(findViewById2 == null || (layoutParams = findViewById2.getLayoutParams()) == null || !(layoutParams instanceof LinearLayout.LayoutParams))) {
            if (ez >= 1.125f) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginEnd((int) dimension2);
            } else {
                ((LinearLayout.LayoutParams) layoutParams).setMarginEnd((int) dimension);
            }
        }
        kotlin.g.b.p.g(Mn, "authIcon");
        if (Mn.getVisibility() == 0) {
            kotlin.g.b.p.g(Mn2, "otherIcon");
            if (Mn2.getVisibility() == 0) {
                Context context3 = hVar.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                textView.setMaxWidth((int) context3.getResources().getDimension(R.dimen.cp));
                return;
            }
        }
        if (Mn.getVisibility() != 0) {
            kotlin.g.b.p.g(Mn2, "otherIcon");
            if (Mn2.getVisibility() == 0) {
                Context context4 = hVar.getContext();
                kotlin.g.b.p.g(context4, "holder.context");
                textView.setMaxWidth((int) context4.getResources().getDimension(R.dimen.bw));
                return;
            }
        }
        if (Mn.getVisibility() == 0) {
            kotlin.g.b.p.g(Mn2, "otherIcon");
            if (Mn2.getVisibility() != 0) {
                Context context5 = hVar.getContext();
                kotlin.g.b.p.g(context5, "holder.context");
                textView.setMaxWidth((int) context5.getResources().getDimension(R.dimen.by));
                return;
            }
        }
        Context context6 = hVar.getContext();
        kotlin.g.b.p.g(context6, "holder.context");
        textView.setMaxWidth((int) context6.getResources().getDimension(R.dimen.c2));
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class aj implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        aj(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242929);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View Mn = this.qhp.Mn(R.id.x1);
            if (Mn != null) {
                Mn.callOnClick();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242929);
        }
    }

    public void g(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(t2, "item");
        kotlin.g.b.p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.czt);
        com.tencent.mm.plugin.finder.api.g gVar = t2.contact;
        if ((gVar != null ? gVar.field_liveStatus : 2) == 1) {
            if (Mn != null) {
                Mn.setVisibility(0);
            }
            if (Mn != null) {
                Mn.setOnClickListener(new ah(hVar, t2));
            }
            TextView textView = (TextView) hVar.Mn(R.id.ed3);
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (Mn != null) {
            Mn.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ah implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        ah(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(242927);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshLivingIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.api.g gVar = this.tAr.contact;
            if (gVar != null) {
                str = gVar.getUsername();
            } else {
                str = null;
            }
            new com.tencent.mm.plugin.finder.view.r(context, str, this.qhp.lR(), this.tAr.feedObject.isLiveFeed()).dzC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshLivingIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242927);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ae implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        ae(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tBP = oVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242924);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.qhp.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20912, 3, 5, this.tAr.feedObject.getUserName(), this.tAr.feedObject.getNickName());
            } else if (o.c(this.tAr)) {
                o.a(this.tBP, this.qhp, this.tAr, false, 0, 4, 56);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242924);
        }
    }

    private final void h(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        TextView textView;
        String str;
        View Mn = hVar.Mn(R.id.d8o);
        if (Mn != null && (textView = (TextView) Mn.findViewById(R.id.hp9)) != null) {
            int forwardCount = t2.feedObject.getForwardCount();
            if (forwardCount > 0 || this.tAi.dbZ()) {
                String gm = com.tencent.mm.plugin.finder.utils.k.gm(!this.tAi.dbZ() ? 2 : 1, forwardCount);
                kotlin.g.b.p.g(gm, "FinderFormatUtil.formatN…ENE_FINDER, forwardCount)");
                com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
                str = gm;
            } else {
                String string = hVar.getContext().getString(R.string.d9k);
                kotlin.g.b.p.g(string, "holder.context.getString…g.finder_share_icon_text)");
                com.tencent.mm.ui.ao.b(textView.getPaint());
                str = string;
            }
            textView.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public static boolean c(T t2) {
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.h(t2) || t2.feedObject.isPostFinish()) {
            return true;
        }
        if (t2.feedObject.isPostFailed() || (!t2.feedObject.isPostFinish() && t2.feedObject.getPostInfo().Mpc < 100)) {
            return false;
        }
        return true;
    }

    public void h(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        Context context;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        if (finderMediaBanner != null) {
            if (finderMediaBanner.getContext() instanceof Activity) {
                Context context2 = finderMediaBanner.getContext();
                if (context2 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                }
                context = ((Activity) context2).getBaseContext();
            } else {
                context = finderMediaBanner.getContext();
            }
            kotlin.g.b.p.g(context, "baseContext");
            Resources resources = context.getResources();
            kotlin.g.b.p.g(resources, "baseContext.resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            int displayHeight = getDisplayHeight();
            float f2 = 0.45f * ((float) displayHeight);
            int cR = kotlin.h.a.cR(((float) displayHeight) * 0.05f);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            float eA = com.tencent.mm.plugin.finder.utils.y.eA(t2.feedObject.isLongVideo() ? t2.feedObject.getLongVideoMediaList() : t2.feedObject.getMediaList());
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVc().value().intValue() == 0) {
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.bl(eA)) {
                    Context context3 = finderMediaBanner.getContext();
                    kotlin.g.b.p.g(context3, "context");
                    int dimension = (int) context3.getResources().getDimension(R.dimen.bu);
                    finderMediaBanner.getPagerView().getLayoutParams().width = i2;
                    finderMediaBanner.getPagerView().getLayoutParams().height = kotlin.h.a.cR(((float) i2) * eA);
                    if (((float) i2) * eA <= ((float) (displayHeight - (dimension * 2)))) {
                        ViewGroup.LayoutParams layoutParams = finderMediaBanner.getLayoutParams();
                        if (layoutParams == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        ((FrameLayout.LayoutParams) layoutParams).topMargin = (-dimension) / 2;
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = finderMediaBanner.getLayoutParams();
                        if (layoutParams2 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
                    }
                } else {
                    finderMediaBanner.getPagerView().getLayoutParams().width = i2;
                    finderMediaBanner.getPagerView().getLayoutParams().height = displayHeight;
                    ViewGroup.LayoutParams layoutParams3 = finderMediaBanner.getLayoutParams();
                    if (layoutParams3 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    ((FrameLayout.LayoutParams) layoutParams3).topMargin = 0;
                }
            } else {
                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.bl(eA) || hVar.lU() == 2) {
                    float f3 = eA * ((float) i2);
                    float f4 = f3 * 0.5f;
                    finderMediaBanner.getPagerView().getLayoutParams().width = i2;
                    finderMediaBanner.getPagerView().getLayoutParams().height = kotlin.h.a.cR(f3);
                    Context context4 = hVar.getContext();
                    kotlin.g.b.p.g(context4, "holder.context");
                    int dimension2 = (int) context4.getResources().getDimension(R.dimen.bw);
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.hVc().value().intValue() == 1) {
                        ViewGroup.LayoutParams layoutParams4 = finderMediaBanner.getLayoutParams();
                        if (layoutParams4 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = 0;
                        if (f2 - f4 >= ((float) getTopBarHeight())) {
                            ViewGroup.LayoutParams layoutParams5 = finderMediaBanner.getLayoutParams();
                            if (layoutParams5 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams5).gravity = 17;
                            ViewGroup.LayoutParams layoutParams6 = finderMediaBanner.getLayoutParams();
                            if (layoutParams6 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams6).topMargin = -cR;
                        } else if (((float) getTopBarHeight()) + f3 > ((float) displayHeight)) {
                            ViewGroup.LayoutParams layoutParams7 = finderMediaBanner.getLayoutParams();
                            if (layoutParams7 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams7).gravity = 17;
                            ViewGroup.LayoutParams layoutParams8 = finderMediaBanner.getLayoutParams();
                            if (layoutParams8 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams8).topMargin = 0;
                        } else {
                            ViewGroup.LayoutParams layoutParams9 = finderMediaBanner.getLayoutParams();
                            if (layoutParams9 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams9).topMargin = getTopBarHeight();
                            ViewGroup.LayoutParams layoutParams10 = finderMediaBanner.getLayoutParams();
                            if (layoutParams10 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams10).gravity = 48;
                        }
                    } else {
                        ViewGroup.LayoutParams layoutParams11 = finderMediaBanner.getLayoutParams();
                        if (layoutParams11 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        ((FrameLayout.LayoutParams) layoutParams11).bottomMargin = 0;
                        if (f2 - f4 >= ((float) getTopBarHeight())) {
                            ViewGroup.LayoutParams layoutParams12 = finderMediaBanner.getLayoutParams();
                            if (layoutParams12 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams12).gravity = 17;
                            ViewGroup.LayoutParams layoutParams13 = finderMediaBanner.getLayoutParams();
                            if (layoutParams13 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams13).topMargin = -cR;
                        } else if (((float) getTopBarHeight()) + f3 > ((float) displayHeight)) {
                            ViewGroup.LayoutParams layoutParams14 = finderMediaBanner.getLayoutParams();
                            if (layoutParams14 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams14).gravity = 17;
                            ViewGroup.LayoutParams layoutParams15 = finderMediaBanner.getLayoutParams();
                            if (layoutParams15 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams15).topMargin = 0;
                        } else {
                            ViewGroup.LayoutParams layoutParams16 = finderMediaBanner.getLayoutParams();
                            if (layoutParams16 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams16).bottomMargin = dimension2;
                            ViewGroup.LayoutParams layoutParams17 = finderMediaBanner.getLayoutParams();
                            if (layoutParams17 == null) {
                                throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                            ((FrameLayout.LayoutParams) layoutParams17).gravity = 80;
                        }
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams18 = finderMediaBanner.getLayoutParams();
                    if (layoutParams18 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    ((FrameLayout.LayoutParams) layoutParams18).gravity = 17;
                    finderMediaBanner.getPagerView().getLayoutParams().width = i2;
                    finderMediaBanner.getPagerView().getLayoutParams().height = displayHeight;
                    ViewGroup.LayoutParams layoutParams19 = finderMediaBanner.getLayoutParams();
                    if (layoutParams19 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    ((FrameLayout.LayoutParams) layoutParams19).topMargin = 0;
                    ViewGroup.LayoutParams layoutParams20 = finderMediaBanner.getLayoutParams();
                    if (layoutParams20 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    ((FrameLayout.LayoutParams) layoutParams20).bottomMargin = 0;
                }
            }
            finderMediaBanner.requestLayout();
        }
    }

    public boolean b(com.tencent.mm.view.recyclerview.h hVar, View view, FinderObject finderObject) {
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(finderObject, "finderObj");
        return false;
    }

    private final void i(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        String str;
        View Mn = hVar.Mn(R.id.cc3);
        if (!this.tAi.dbZ()) {
            kotlin.g.b.p.g(Mn, "favView");
            Mn.setVisibility(8);
            return;
        }
        kotlin.g.b.p.g(Mn, "favView");
        Mn.setVisibility(0);
        Mn.setOnClickListener(new af(this, hVar));
        c.a aVar = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        int l2 = com.tencent.mm.plugin.finder.upload.action.c.dBq().l(t2.feedObject.getFeedObject());
        TextView textView = (TextView) hVar.Mn(R.id.cbj);
        if (textView != null) {
            com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
            if (l2 > 0) {
                str = com.tencent.mm.plugin.finder.utils.k.gm(!this.tAi.dbZ() ? 2 : 1, l2);
            } else {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            textView.setText(str);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class af implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ o tBP;

        af(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242925);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.tBP.tAi.dbZ()) {
                Log.i("Finder.FeedFullConvert", "onClickFav:" + this.qhp.lR());
                o.a(this.tBP, this.qhp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242925);
        }
    }

    private final void b(com.tencent.mm.view.recyclerview.h hVar, T t2, int i2) {
        View Mn = hVar.Mn(R.id.cf0);
        if (t2.showCommentEdu) {
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af2).dxX()) {
                kotlin.g.b.p.g(Mn, "layout");
                Mn.setVisibility(0);
                Mn.setOnClickListener(new ac(this, hVar, t2, i2));
                return;
            }
        }
        kotlin.g.b.p.g(Mn, "layout");
        Mn.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ac implements View.OnClickListener {
        final /* synthetic */ int kVT;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        ac(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2) {
            this.tBP = oVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
            this.kVT = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242922);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            com.tencent.mm.plugin.finder.storage.c.KQ(2);
            o.a(this.tBP, this.qhp, this.tAr, true, rect.top - com.tencent.mm.view.d.e(this.qhp.getContext(), 16.0f), this.kVT, 24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242922);
        }
    }

    public static /* synthetic */ void a(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, boolean z2, int i2, int i3, int i4) {
        int i5 = 0;
        boolean z3 = (i4 & 4) != 0 ? false : z2;
        int i6 = (i4 & 32) != 0 ? -1 : i2;
        if ((i4 & 64) == 0) {
            i5 = i3;
        }
        oVar.a(hVar, baseFinderFeed, z3, i6, i5);
    }

    /* access modifiers changed from: protected */
    public void a(com.tencent.mm.view.recyclerview.h hVar, T t2, boolean z2, int i2, int i3) {
        int i4;
        FinderCommentDrawer finderCommentDrawer;
        FrameLayout footerLayout;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
        com.tencent.mm.plugin.finder.view.e dcg = this.tAi.dcg();
        z.d dVar = new z.d();
        dVar.SYE = 0;
        if (z2) {
            if (i2 >= 0) {
                i4 = i2;
            } else {
                this.rect.setEmpty();
                hVar.aus.getGlobalVisibleRect(this.rect);
                i4 = this.rect.bottom;
            }
            hVar.getRecyclerView().getGlobalVisibleRect(this.rect);
            int i5 = this.rect.bottom - i4;
            View findViewById = (dcg == null || (finderCommentDrawer = dcg.tNb) == null || (footerLayout = finderCommentDrawer.getFooterLayout()) == null) ? null : footerLayout.findViewById(R.id.b8r);
            if (findViewById != null) {
                findViewById.postDelayed(new aa(this, findViewById, hVar, i5, i4), 200);
            }
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtx().value().intValue() == 1) {
                hVar.getRecyclerView().kQ();
                hVar.aus.findViewById(R.id.fbd).getGlobalVisibleRect(this.rect);
                int i6 = this.rect.top;
                hVar.getRecyclerView().getGlobalVisibleRect(this.rect);
                dVar.SYE = i6 - this.rect.top;
                Log.d("Finder.FeedFullConvert", "[openCommentDrawer] offset=" + dVar.SYE + ' ' + hVar.getRecyclerView());
                hVar.getRecyclerView().smoothScrollBy(0, dVar.SYE);
            }
        }
        ab abVar = new ab(this, t2, hVar, dVar);
        if (hVar.getContext() instanceof MMActivity) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = hVar.getContext();
            if (context == null) {
                throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            }
            com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class));
            if (b2 != null) {
                b2.cZR().En(t2.lT());
            }
        }
        boolean z3 = false;
        if (!this.tAi.dbZ()) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.h(t2)) {
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.i(t2.contact)) {
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    com.tencent.mm.plugin.finder.storage.c.KQ(2);
                    z3 = true;
                }
            }
        }
        if (dcg != null) {
            dcg.a(t2.feedObject, z2, 0, 0 != 0, true, null, z3, i3, abVar);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final h tBQ = new h();

        static {
            AppMethodBeat.i(242892);
            AppMethodBeat.o(242892);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(242891);
            Integer valueOf = Integer.valueOf(com.tencent.mm.ui.ao.az(MMApplicationContext.getContext()).y);
            AppMethodBeat.o(242891);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class aa implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ View tAL;
        final /* synthetic */ int tAM;
        final /* synthetic */ int tAN;
        final /* synthetic */ o tBP;

        aa(o oVar, View view, com.tencent.mm.view.recyclerview.h hVar, int i2, int i3) {
            this.tBP = oVar;
            this.tAL = view;
            this.qhp = hVar;
            this.tAM = i2;
            this.tAN = i3;
        }

        public final void run() {
            AppMethodBeat.i(242920);
            int height = this.tAL.getHeight();
            int keyBordHeightPx = (KeyBoardUtil.getKeyBordHeightPx(this.qhp.getContext()) - this.tAM) + height;
            Log.i("Finder.FeedFullConvert", "[openCommentDrawer] offset=" + keyBordHeightPx + " itemBottom=" + this.tAN + " recyclerViewBottom=" + this.tBP.rect.bottom + " editLayoutHeight=" + height);
            if (keyBordHeightPx > 0) {
                FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tBP.tAi.getVideoCore().weS;
                if (finderVideoAutoPlayManager != null) {
                    FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, "openCommentDrawer", true);
                }
                this.qhp.getRecyclerView().smoothScrollBy(0, keyBordHeightPx);
            }
            AppMethodBeat.o(242920);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final l tCc = new l();

        static {
            AppMethodBeat.i(242897);
            AppMethodBeat.o(242897);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(242896);
            Integer valueOf = Integer.valueOf(com.tencent.mm.ui.au.aD(MMApplicationContext.getContext()));
            AppMethodBeat.o(242896);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class aw extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ o tBP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aw(o oVar) {
            super(0);
            this.tBP = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260215);
            Integer valueOf = Integer.valueOf(((Number) this.tBP.tBF.getValue()).intValue() + com.tencent.mm.ui.au.eu(MMApplicationContext.getContext()));
            AppMethodBeat.o(260215);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ o tBP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(o oVar) {
            super(0);
            this.tBP = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            Intent intent;
            boolean z = true;
            AppMethodBeat.i(242893);
            MMActivity activity = this.tBP.tAi.getActivity();
            if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra("is_from_ad", false)) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242893);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
    public static final class ab implements CommentDrawerContract.CloseDrawerCallback {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.d tAO;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        ab(o oVar, BaseFinderFeed baseFinderFeed, com.tencent.mm.view.recyclerview.h hVar, z.d dVar) {
            this.tBP = oVar;
            this.tAr = baseFinderFeed;
            this.qhp = hVar;
            this.tAO = dVar;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
        public final void g(int i2, List<? extends com.tencent.mm.plugin.finder.model.s> list) {
            AppMethodBeat.i(242921);
            kotlin.g.b.p.h(list, "data");
            this.tBP.i((o) this.tAr, (BaseFinderFeed) this.qhp);
            FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tBP.tAi.getVideoCore().weS;
            if (finderVideoAutoPlayManager != null) {
                FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, "openCommentDrawer", false);
            }
            if (this.tBP.tAi.dbZ()) {
                View Mn = this.qhp.Mn(R.id.b8o);
                kotlin.g.b.p.g(Mn, "holder.getView<TextView>(R.id.comment_count_tv)");
                ((TextView) Mn).setText(com.tencent.mm.plugin.finder.utils.k.gm(1, this.tAr.feedObject.getCommentCount()));
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtx().value().intValue() == 1) {
                this.qhp.getRecyclerView().smoothScrollBy(0, -this.tAO.SYE);
            }
            AppMethodBeat.o(242921);
        }
    }

    public void a(com.tencent.mm.view.recyclerview.h hVar, View view, MotionEvent motionEvent) {
        boolean z2;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(motionEvent, "e");
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        if (baseFinderFeed.feedObject.isPostFinish() && !this.tAi.dbZ() && !baseFinderFeed.isPreview) {
            j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(baseFinderFeed.feedObject.getFeedObject());
            boolean booleanValue = m2.first.booleanValue();
            boolean booleanValue2 = m2.second.booleanValue();
            if (booleanValue && booleanValue2) {
                return;
            }
            if (booleanValue) {
                WeImageView f2 = f(hVar);
                com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
                String str = Lj == null ? "" : com.tencent.mm.ui.ao.isDarkMode() ? Lj.LJE : Lj.LJF;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), f2, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                } else {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                        Context context = hVar.getContext();
                        Context context2 = hVar.getContext();
                        kotlin.g.b.p.g(context2, "holder.context");
                        f2.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.finder_filled_like_lock, context2.getResources().getColor(R.color.Red_90)));
                    } else {
                        Context context3 = hVar.getContext();
                        Context context4 = hVar.getContext();
                        kotlin.g.b.p.g(context4, "holder.context");
                        f2.setImageDrawable(com.tencent.mm.ui.ar.m(context3, R.raw.finder_full_like, context4.getResources().getColor(R.color.Red_90)));
                    }
                }
                com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                com.tencent.mm.plugin.finder.view.animation.c.a((View) f2, 1.4f, motionEvent, true, 16);
                return;
            }
            a(hVar, 2, false, motionEvent);
        }
    }

    @SuppressLint({"ResourceType"})
    private static WeImageView f(com.tencent.mm.view.recyclerview.h hVar) {
        WeImageView weImageView = new WeImageView(hVar.getContext());
        weImageView.setVisibility(4);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        int dimension = (int) context.getResources().getDimension(R.dimen.co);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        weImageView.setLayoutParams(layoutParams);
        weImageView.setImageResource(R.raw.finder_full_like);
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        weImageView.setIconColor(context2.getResources().getColor(R.color.Red_90));
        View Mn = hVar.Mn(R.id.fbg);
        if (!(Mn instanceof ViewGroup)) {
            Mn = null;
        }
        ViewGroup viewGroup = (ViewGroup) Mn;
        if (viewGroup != null) {
            viewGroup.addView(weImageView);
        }
        return weImageView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.mm.plugin.finder.convert.o<T extends com.tencent.mm.plugin.finder.model.BaseFinderFeed> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean a(com.tencent.mm.view.recyclerview.h hVar, int i2, boolean z2, MotionEvent motionEvent) {
        com.tencent.mm.plugin.finder.event.a b2;
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(baseFinderFeed.feedObject.getFeedObject());
        boolean booleanValue = m2.first.booleanValue();
        boolean booleanValue2 = m2.second.booleanValue();
        boolean z3 = !booleanValue;
        if (z3) {
            View Mn = hVar.Mn(R.id.dts);
            WeImageView f2 = f(hVar);
            f2.setLayerPaint(null);
            com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
            String str = Lj == null ? "" : Lj.LJE;
            if (z2) {
                a(f2, Lj);
            } else {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                    Context context = hVar.getContext();
                    Context context2 = hVar.getContext();
                    kotlin.g.b.p.g(context2, "holder.context");
                    f2.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.finder_filled_like_lock, context2.getResources().getColor(R.color.Red_90)));
                } else {
                    String str2 = str;
                    if (!(str2 == null || str2.length() == 0)) {
                        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), f2, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                    } else {
                        Context context3 = hVar.getContext();
                        Context context4 = hVar.getContext();
                        kotlin.g.b.p.g(context4, "holder.context");
                        f2.setImageDrawable(com.tencent.mm.ui.ar.m(context3, R.raw.finder_full_like, context4.getResources().getColor(R.color.Red_90)));
                    }
                }
            }
            com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
            com.tencent.mm.plugin.finder.view.animation.c.a((View) f2, 1.4f, motionEvent, true, 16);
            com.tencent.mm.plugin.finder.view.animation.c cVar2 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
            kotlin.g.b.p.g(Mn, "likeIcon");
            com.tencent.mm.plugin.finder.view.animation.c.ei(Mn);
            if (i2 == 2 || z2) {
                a(hVar);
            }
            View Mn2 = hVar.Mn(R.id.d37);
            if (Mn2 != null) {
                Mn2.setVisibility(8);
            }
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dux().value().intValue() == 1) {
                baseFinderFeed.showCommentEdu = false;
                kotlin.g.b.p.g(baseFinderFeed, "item");
                b(hVar, baseFinderFeed, 1);
            }
        }
        boolean z4 = z3 ? false : booleanValue2;
        com.tencent.mm.plugin.finder.feed.i iVar = this.tAi;
        kotlin.g.b.p.g(baseFinderFeed, "item");
        iVar.a(baseFinderFeed, z3, z2, i2, z4);
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(baseFinderFeed, z3, z2, com.tencent.mm.plugin.finder.upload.action.j.vUv.n(baseFinderFeed.feedObject.getFeedObject()), hVar);
        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.v(baseFinderFeed) && !z2) {
            if (z3) {
                baseFinderFeed.feedObject.getFeedObject().incFriendLikeCount++;
            } else if (!booleanValue2) {
                FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                feedObject.incFriendLikeCount--;
            }
        }
        hn hnVar = new hn();
        hnVar.dLW.id = baseFinderFeed.lT();
        hnVar.dLW.type = 4;
        hnVar.dLW.dLZ = (!z3 || !z2) ? z3 ? 1 : 0 : 2;
        EventCenter.instance.publish(hnVar);
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        Context context5 = hVar.getContext();
        kotlin.g.b.p.g(context5, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context5);
        if (!(fH == null || (b2 = FinderReporterUIC.b(fH)) == null)) {
            a.b cZR = b2.cZR();
            if (z3) {
                cZR.Eo(baseFinderFeed.lT());
            } else {
                cZR.Ep(baseFinderFeed.lT());
            }
        }
        return z3;
    }

    private static void a(com.tencent.mm.view.recyclerview.h hVar) {
        hVar.aus.performHapticFeedback(0, 3);
    }

    private final int a(boolean z2, BaseFinderFeed baseFinderFeed) {
        if (this.tAi.dbZ()) {
            return R.raw.finder_filled_like_private;
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact) || z2) {
            return R.raw.finder_filled_like_lock;
        }
        return R.raw.finder_full_like;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.mm.plugin.finder.convert.o<T extends com.tencent.mm.plugin.finder.model.BaseFinderFeed> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void a(BaseFinderFeed baseFinderFeed, boolean z2, boolean z3, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        Drawable m2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        boolean z4 = false;
        int i3 = 1;
        FinderFullSeekBarLayout finderFullSeekBarLayout = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        if (finderFullSeekBarLayout != null) {
            finderFullSeekBarLayout.tNO = baseFinderFeed;
        }
        if (baseFinderFeed.isDeepEnjoy) {
            Object hgv = hVar.hgv();
            kotlin.g.b.p.g(hgv, "holder.getAssociatedObject()");
            f(hVar, (BaseFinderFeed) hgv);
        }
        ImageView imageView = (ImageView) hVar.Mn(R.id.dts);
        if (z2) {
            if (z3) {
                kotlin.g.b.p.g(imageView, "awesomeIv");
                imageView.setTag(2);
            } else {
                kotlin.g.b.p.g(imageView, "awesomeIv");
                imageView.setTag(1);
            }
            Context context = hVar.getContext();
            int a2 = a(z3, baseFinderFeed);
            Context context2 = hVar.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            m2 = com.tencent.mm.ui.ar.m(context, a2, context2.getResources().getColor(R.color.Red_90));
        } else {
            kotlin.g.b.p.g(imageView, "awesomeIv");
            imageView.setTag(0);
            Context context3 = hVar.getContext();
            int a3 = a(z3 && z2, baseFinderFeed);
            Context context4 = hVar.getContext();
            kotlin.g.b.p.g(context4, "holder.context");
            m2 = com.tencent.mm.ui.ar.m(context3, a3, context4.getResources().getColor(R.color.v9));
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean i4 = com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact);
        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
        if (z3 && z2 && !i4) {
            a(imageView, Lj);
        } else if (Lj == null || i4 || z3) {
            imageView.setLayerPaint(null);
            if (Lj != null) {
                str = Lj.LJL;
            } else {
                str = null;
            }
            String str6 = str;
            if ((str6 == null || str6.length() == 0) || this.tAi.dbZ() || i4) {
                imageView.setImageDrawable(m2);
            } else {
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
                if (Lj != null) {
                    str5 = Lj.LJL;
                }
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str5, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                djY.a(pVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE)).c(imageView);
            }
        } else {
            if (z2) {
                str2 = Lj.LJE;
            } else {
                str2 = Lj.LJL;
            }
            imageView.setLayerPaint(null);
            com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY2 = com.tencent.mm.plugin.finder.loader.m.djY();
            com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(str2, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
            com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
            djY2.a(pVar2, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE)).c(imageView);
        }
        TextView textView = (TextView) hVar.Mn(R.id.eba);
        if (this.tAi.dbZ()) {
            kotlin.g.b.p.g(textView, "likeTv");
            com.tencent.mm.ui.ao.b(textView.getPaint());
            j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            textView.setText(com.tencent.mm.plugin.finder.utils.k.Lx(com.tencent.mm.plugin.finder.upload.action.j.vUv.n(baseFinderFeed.feedObject.getFeedObject())));
            return;
        }
        if (i2 > 0) {
            if (!this.tAi.dbZ()) {
                i3 = 2;
            }
            String gm = com.tencent.mm.plugin.finder.utils.k.gm(i3, i2);
            kotlin.g.b.p.g(gm, "FinderFormatUtil.formatN….SCENE_FINDER, likeCount)");
            kotlin.g.b.p.g(textView, "likeTv");
            com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
            str4 = gm;
        } else {
            if (Lj != null) {
                String str7 = Lj.LJI;
                if (str7 == null || str7.length() == 0) {
                    z4 = true;
                }
                if (!z4) {
                    String str8 = Lj.LJI;
                    str3 = str8 == null ? "" : str8;
                    kotlin.g.b.p.g(textView, "likeTv");
                    com.tencent.mm.ui.ao.b(textView.getPaint());
                    str4 = str3;
                }
            }
            String string = hVar.getContext().getString(R.string.cps);
            kotlin.g.b.p.g(string, "holder.context.getString…g.finder_like_count_text)");
            str3 = string;
            kotlin.g.b.p.g(textView, "likeTv");
            com.tencent.mm.ui.ao.b(textView.getPaint());
            str4 = str3;
        }
        textView.setText(str4);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i(T r5, com.tencent.mm.view.recyclerview.h r6) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.o.i(com.tencent.mm.plugin.finder.model.BaseFinderFeed, com.tencent.mm.view.recyclerview.h):void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ad implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        ad(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tBP = oVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242923);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.qhp.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20912, 3, 5, this.tAr.feedObject.getUserName(), this.tAr.feedObject.getNickName());
            } else {
                o.a(this.tBP, this.qhp, this.tAr, false, 0, 0, 120);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshCommentLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242923);
        }
    }

    private final void d(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
        Integer num;
        azw azw;
        FinderObject feedObject;
        FinderObject feedObject2;
        azx azx;
        LinkedList<azw> linkedList = (finderItem == null || (feedObject2 = finderItem.getFeedObject()) == null || (azx = feedObject2.hotTopics) == null) ? null : azx.Gbc;
        StringBuilder sb = new StringBuilder("showNewsIndicator objectType: ");
        if (finderItem == null || (feedObject = finderItem.getFeedObject()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(feedObject.objectType);
        }
        Log.i("Finder.FeedFullConvert", sb.append(num).append(" size:").append(linkedList != null ? Integer.valueOf(linkedList.size()) : null).toString());
        if (linkedList != null) {
            Iterator<azw> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    azw = null;
                    break;
                }
                azw next = it.next();
                if (next != null && next.LJN == 5) {
                    azw = next;
                    break;
                }
            }
        } else {
            azw = null;
        }
        if (azw != null) {
            Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic " + azw.twp + ' ' + azw.riB + ' ' + azw.LJO);
            if (hVar.getContext() instanceof FinderShareFeedRelUI) {
                Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic ui is FinderShareFeedRelUI block");
                View Mn = hVar.Mn(R.id.clv);
                if (Mn != null) {
                    Mn.setVisibility(8);
                }
                View Mn2 = hVar.Mn(R.id.clw);
                if (Mn2 != null) {
                    Mn2.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView = (TextView) hVar.Mn(R.id.cex);
            if (textView != null) {
                if (azw.LJO > 0) {
                    textView.setTextColor(textView.getResources().getColor(R.color.vj));
                } else {
                    textView.setTextColor(textView.getResources().getColor(R.color.v6));
                }
                textView.setBackgroundResource(R.drawable.yn);
            }
            WeImageView weImageView = (WeImageView) hVar.Mn(R.id.d1l);
            if (weImageView != null) {
                weImageView.setIconColor(weImageView.getResources().getColor(R.color.v4));
            }
            View Mn3 = hVar.Mn(R.id.clv);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
                Mn3.setOnClickListener(new ai(Mn3, azw, this, hVar, finderItem, str));
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.cex);
            if (textView2 != null) {
                StringBuilder sb2 = new StringBuilder();
                Context context = textView2.getContext();
                kotlin.g.b.p.g(context, "context");
                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), sb2.append(context.getResources().getString(R.string.d36)).append(azw.riB).toString()));
            }
            TextView textView3 = (TextView) hVar.Mn(R.id.cew);
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (azw != null) {
                return;
            }
        }
        Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] topic null let");
        View Mn4 = hVar.Mn(R.id.clv);
        if (Mn4 != null) {
            Mn4.setVisibility(8);
        }
        View Mn5 = hVar.Mn(R.id.clw);
        if (Mn5 != null) {
            Mn5.setVisibility(8);
        }
        kotlin.x xVar = kotlin.x.SXb;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$2$3$1", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$$special$$inlined$apply$lambda$1"})
    public static final class ai implements View.OnClickListener {
        final /* synthetic */ FinderItem $item$inlined;
        final /* synthetic */ o tBP;
        final /* synthetic */ azw tBo;
        final /* synthetic */ String tBp;
        final /* synthetic */ View tCl;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        ai(View view, azw azw, o oVar, com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
            this.tCl = view;
            this.tBo = azw;
            this.tBP = oVar;
            this.tzq = hVar;
            this.$item$inlined = finderItem;
            this.tBp = str;
        }

        public final void onClick(View view) {
            long j2;
            long j3;
            FinderObject feedObject;
            Long l;
            int i2 = 0;
            AppMethodBeat.i(242928);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.tBo.LJO > 0) {
                j2 = 1;
                Intent intent = new Intent();
                intent.putExtra("key_topic_type", this.tBo.LJN);
                intent.putExtra("key_topic_title", this.tBo.riB);
                intent.putExtra("KEY_TOPIC_ID", this.tBo.twp);
                com.tencent.mm.bw.b bVar2 = this.tBo.LJP;
                if (bVar2 != null) {
                    intent.putExtra("KEY_HOT_TOPIC_BUFFER", bVar2.zy);
                }
                intent.putExtra("key_hot_topic_type", this.tBo.LJN);
                FinderItem finderItem = this.$item$inlined;
                intent.putExtra("KEY_CLICK_FEED_ID", finderItem != null ? Long.valueOf(finderItem.getId()) : null);
                FinderItem finderItem2 = this.$item$inlined;
                if (finderItem2 != null) {
                    l = Long.valueOf(finderItem2.getId());
                } else {
                    l = null;
                }
                intent.putExtra("key_ref_object_id", l);
                intent.putExtra("KEY_TAB_TYPE", this.tBP.dLS);
                String str = this.tBp;
                if (str == null) {
                    str = "";
                }
                intent.putExtra("key_from_user", str);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = this.tzq.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = this.tzq.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                com.tencent.mm.plugin.finder.utils.a.P(context2, intent);
            } else {
                o oVar = this.tBP;
                Object hgv = this.tzq.hgv();
                kotlin.g.b.p.g(hgv, "holder.getAssociatedObject()");
                boolean d2 = oVar.d((o) ((BaseFinderFeed) hgv));
                Log.i("Finder.FeedFullConvert", "[refreshNewsLayout] hot news not support jump! isShowRealNameRecommendLayout=".concat(String.valueOf(d2)));
                if (d2) {
                    this.tCl.setVisibility(8);
                }
                j2 = 0;
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            FinderItem finderItem3 = this.$item$inlined;
            if (finderItem3 == null || (feedObject = finderItem3.getFeedObject()) == null) {
                j3 = 0;
            } else {
                j3 = feedObject.id;
            }
            long j4 = this.tBo.twp;
            String str2 = this.tBo.riB;
            if (str2 == null) {
                str2 = "";
            }
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            Context context3 = this.tzq.getContext();
            kotlin.g.b.p.g(context3, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
            if (fH != null) {
                i2 = fH.tCE;
            }
            com.tencent.mm.plugin.finder.report.k.a(j3, 2, j4, str2, j2, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshNewsLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242928);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onBindViewHolder$5$1"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(o oVar, BaseFinderFeed baseFinderFeed, com.tencent.mm.view.recyclerview.h hVar) {
            super(0);
            this.tBP = oVar;
            this.tAz = baseFinderFeed;
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
            java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.replaceUnknownTypes(MethodInvokeVisitor.java:299)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:258)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
            */
        @Override // kotlin.g.a.a
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r4 = this;
                r3 = 242899(0x3b4d3, float:3.40374E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.plugin.finder.upload.action.j$a r0 = com.tencent.mm.plugin.finder.upload.action.j.vUw
                com.tencent.mm.plugin.finder.upload.action.j r0 = com.tencent.mm.plugin.finder.upload.action.j.dBt()
                com.tencent.mm.plugin.finder.model.BaseFinderFeed r1 = r4.tAz
                com.tencent.mm.plugin.finder.storage.FinderItem r1 = r1.feedObject
                com.tencent.mm.protocal.protobuf.FinderObject r1 = r1.getFeedObject()
                kotlin.o r1 = r0.m(r1)
                A r0 = r1.first
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r2 = r0.booleanValue()
                B r0 = r1.second
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r2 == 0) goto L_0x003d
                if (r0 != 0) goto L_0x003d
                java.lang.String r0 = "Finder.FeedFullConvert"
                java.lang.String r1 = "[onPrivateLikeClickListener] cancel normal like before private liek action happens."
                com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
                com.tencent.mm.plugin.finder.convert.o r0 = r4.tBP
                com.tencent.mm.view.recyclerview.h r1 = r4.tzq
                r2 = 0
                com.tencent.mm.plugin.finder.convert.o.a(r0, r1, r2)
            L_0x003d:
                com.tencent.mm.plugin.finder.convert.o r0 = r4.tBP
                com.tencent.mm.view.recyclerview.h r1 = r4.tzq
                r2 = 1
                boolean r0 = com.tencent.mm.plugin.finder.convert.o.a(r0, r1, r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.o.n.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"ResourceType"})
    private final void a(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        int i2;
        int i3;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        TextView textView = (TextView) hVar.Mn(R.id.ed3);
        textView.setOnClickListener(new ag(this, hVar, t2));
        kotlin.g.b.p.g(textView, "followIv");
        textView.setTextSize(0, (float) com.tencent.mm.cb.a.aH(textView.getContext(), R.dimen.a3));
        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
        boolean asJ = c.a.asJ(t2.feedObject.field_username);
        if (this.tAj) {
            hVar.mf(R.id.ed3, 8);
        } else {
            if (!(this.dLS == 3 || !asJ || i2 == 1)) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.h(t2)) {
                    com.tencent.mm.plugin.finder.api.g gVar = t2.contact;
                    if (gVar != null) {
                        i3 = gVar.field_liveStatus;
                    } else {
                        i3 = 2;
                    }
                    if (i3 == 1) {
                        textView.setVisibility(8);
                        return;
                    }
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    Context context2 = textView.getContext();
                    kotlin.g.b.p.g(context2, "followIv.context");
                    textView.setText(context2.getResources().getString(R.string.dzl));
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    textView.setTextColor(context3.getResources().getColor(R.color.v5));
                    textView.setBackgroundResource(R.drawable.z6);
                }
            }
            if (asJ || this.dLS == 3) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setAlpha(1.0f);
                Context context4 = textView.getContext();
                kotlin.g.b.p.g(context4, "followIv.context");
                textView.setText(context4.getResources().getString(R.string.hp0));
                Context context5 = hVar.getContext();
                kotlin.g.b.p.g(context5, "holder.context");
                textView.setTextColor(context5.getResources().getColor(R.color.am));
                textView.setBackgroundResource(R.drawable.z4);
            }
        }
        if (cZC()) {
            textView.setAlpha(1.0f);
            textView.setVisibility(0);
        } else if (!t2.isDeepEnjoy) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ag implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        ag(o oVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tBP = oVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(242926);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFollowState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.aj ajVar = com.tencent.mm.plugin.finder.report.aj.viU;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.aj.a(fH != null ? fH.dIx() : null, "follow", false, this.tAr.lT());
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            if (!c.a.asJ(this.tAr.feedObject.field_username)) {
                com.tencent.mm.plugin.finder.feed.i iVar = this.tBP.tAi;
                BaseFinderFeed baseFinderFeed = this.tAr;
                c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                if (!c.a.asJ(this.tAr.feedObject.field_username)) {
                    z = true;
                } else {
                    z = false;
                }
                iVar.b(baseFinderFeed, z);
                this.tBP.a((o) this.qhp, (com.tencent.mm.view.recyclerview.h) this.tAr);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshFollowState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242926);
        }
    }

    public void a(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, Boolean bool) {
        String str;
        awt awt;
        FinderObject feedObject;
        FinderObject feedObject2;
        String userName;
        kotlin.g.b.p.h(hVar, "holder");
        FinderFeedLiveNoticeView finderFeedLiveNoticeView = (FinderFeedLiveNoticeView) hVar.Mn(R.id.cly);
        if (finderItem == null || (userName = finderItem.getUserName()) == null) {
            str = "";
        } else {
            str = userName;
        }
        if (finderFeedLiveNoticeView != null) {
            if (kotlin.g.b.p.j(bool, Boolean.FALSE)) {
                finderFeedLiveNoticeView.setVisibility(8);
            }
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            if (com.tencent.mm.plugin.finder.utils.y.b(context, finderItem)) {
                if (hVar.getContext() instanceof MMActivity) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    Context context2 = hVar.getContext();
                    if (context2 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    }
                    com.tencent.mm.ui.component.a.b((MMActivity) context2).get(FinderLiveNoticePreLoadUIC.class);
                    awt = com.tencent.mm.plugin.finder.feed.model.f.atq(str);
                } else {
                    awt = null;
                }
                if (awt != null) {
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    finderFeedLiveNoticeView.a(context3, awt, str, true);
                } else if (finderFeedLiveNoticeView.getVisibility() == 0) {
                    Log.i("Finder.FeedFullConvert", "notice info no cache ,request again");
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    Context context4 = hVar.getContext();
                    if (context4 == null) {
                        throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    }
                    ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b((MMActivity) context4).get(FinderLiveNoticePreLoadUIC.class)).wyi.a((finderItem == null || (feedObject2 = finderItem.getFeedObject()) == null) ? null : Long.valueOf(feedObject2.id), (finderItem == null || (feedObject = finderItem.getFeedObject()) == null) ? null : feedObject.objectNonceId);
                } else {
                    finderFeedLiveNoticeView.setVisibility(8);
                }
            } else {
                finderFeedLiveNoticeView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean d(T t2) {
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        LinkedList<FinderCommentInfo> p2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.p(t2.feedObject.getFeedObject());
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        int o = com.tencent.mm.plugin.finder.upload.action.j.vUv.o(t2.feedObject.getFeedObject());
        if (this.tAf && !Util.isNullOrNil(p2) && o > 0 && !this.tAi.dbZ()) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.i(t2.contact)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$1$1"})
    public static final class av implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        av(o oVar, BaseFinderFeed baseFinderFeed, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.tAz = baseFinderFeed;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260214);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View Mn = this.tzq.Mn(R.id.hph);
            if (Mn != null) {
                Mn.callOnClick();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260214);
        }
    }

    private final void a(T t2, com.tencent.mm.view.recyclerview.h hVar, boolean z2) {
        float f2;
        kotlin.o U;
        String str;
        String hf;
        String string;
        View Mn;
        String str2;
        String str3;
        String str4;
        String str5;
        View Mn2;
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        LinkedList<FinderCommentInfo> p2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.p(t2.feedObject.getFeedObject());
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        int o = com.tencent.mm.plugin.finder.upload.action.j.vUv.o(t2.feedObject.getFeedObject());
        if (!d(t2)) {
            Log.i("Finder.FeedFullConvert", "[refreshRealNameRecommendLayout] tabType:" + this.dLS + ", " + Util.isNullOrNil(p2) + ", " + o + ' ' + this.tAf);
            View Mn3 = hVar.Mn(R.id.gto);
            if (Mn3 != null) {
                Mn3.setVisibility(8);
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVb().value().intValue() == 1) {
                Mn2 = hVar.Mn(R.id.jzh);
            } else {
                Mn2 = hVar.Mn(R.id.d82);
            }
            kotlin.g.b.p.g(Mn2, "followLikeLayout");
            Mn2.setVisibility(8);
            return;
        }
        if (this.tAg) {
            f2 = 0.1f;
        } else {
            f2 = 0.5f;
        }
        boolean z3 = this.tAg;
        View Mn4 = hVar.Mn(R.id.gto);
        if (Mn4 != null) {
            Mn4.setVisibility(0);
            ArrayList<ImageView> arrayList = new ArrayList();
            arrayList.add(hVar.Mn(R.id.da_));
            arrayList.add(hVar.Mn(R.id.dab));
            arrayList.add(hVar.Mn(R.id.dad));
            ArrayList arrayList2 = new ArrayList();
            FrameLayout frameLayout = (FrameLayout) hVar.Mn(R.id.daa);
            FrameLayout frameLayout2 = (FrameLayout) hVar.Mn(R.id.dac);
            FrameLayout frameLayout3 = (FrameLayout) hVar.Mn(R.id.dae);
            FrameLayout frameLayout4 = (FrameLayout) hVar.Mn(R.id.daj);
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVb().value().intValue() == 1) {
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                Integer valueOf = Integer.valueOf((int) context.getResources().getDimension(R.dimen.cj));
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                U = kotlin.s.U(valueOf, Integer.valueOf((int) context2.getResources().getDimension(R.dimen.ci)));
            } else {
                Context context3 = hVar.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                Integer valueOf2 = Integer.valueOf((int) context3.getResources().getDimension(R.dimen.ce));
                Context context4 = hVar.getContext();
                kotlin.g.b.p.g(context4, "holder.context");
                U = kotlin.s.U(valueOf2, Integer.valueOf((int) context4.getResources().getDimension(R.dimen.cc)));
            }
            int intValue = U.first.intValue();
            int intValue2 = U.second.intValue();
            if (this.tAg) {
                kotlin.g.b.p.g(frameLayout, "layout1");
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = intValue;
                layoutParams2.height = intValue;
                frameLayout.setLayoutParams(layoutParams2);
                kotlin.g.b.p.g(frameLayout2, "layout2");
                ViewGroup.LayoutParams layoutParams3 = frameLayout2.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.leftMargin = intValue;
                layoutParams4.width = intValue;
                layoutParams4.height = intValue;
                frameLayout2.setLayoutParams(layoutParams4);
                kotlin.g.b.p.g(frameLayout3, "layout3");
                ViewGroup.LayoutParams layoutParams5 = frameLayout3.getLayoutParams();
                if (layoutParams5 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                layoutParams6.leftMargin = intValue * 2;
                layoutParams6.width = intValue;
                layoutParams6.height = intValue;
                frameLayout3.setLayoutParams(layoutParams6);
                kotlin.g.b.p.g(frameLayout4, "layoutExtra");
                ViewGroup.LayoutParams layoutParams7 = frameLayout4.getLayoutParams();
                if (layoutParams7 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) layoutParams7;
                layoutParams8.width = intValue;
                layoutParams8.height = intValue;
                frameLayout4.setLayoutParams(layoutParams8);
                for (ImageView imageView : arrayList) {
                    ViewGroup.LayoutParams layoutParams9 = imageView != null ? imageView.getLayoutParams() : null;
                    if (layoutParams9 != null) {
                        layoutParams9.width = intValue2;
                    }
                    if (layoutParams9 != null) {
                        layoutParams9.height = intValue2;
                    }
                    if (imageView != null) {
                        imageView.setLayoutParams(layoutParams9);
                    }
                }
                View Mn5 = hVar.Mn(R.id.daf);
                ViewGroup.LayoutParams layoutParams10 = Mn5 != null ? Mn5.getLayoutParams() : null;
                if (layoutParams10 != null) {
                    layoutParams10.width = intValue2;
                }
                if (layoutParams10 != null) {
                    layoutParams10.height = intValue2;
                }
                if (Mn5 != null) {
                    Mn5.setLayoutParams(layoutParams10);
                }
            }
            arrayList2.add(frameLayout);
            arrayList2.add(frameLayout2);
            arrayList2.add(frameLayout3);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) hVar.Mn(R.id.a2z);
            if (roundLinearLayout != null) {
                roundLinearLayout.setRadius(f2);
                View childAt = roundLinearLayout.getChildAt(0);
                kotlin.g.b.p.g(childAt, "it.getChildAt(0)");
                childAt.setBackground(null);
                kotlin.x xVar = kotlin.x.SXb;
            }
            RoundLinearLayout roundLinearLayout2 = (RoundLinearLayout) hVar.Mn(R.id.a30);
            if (roundLinearLayout2 != null) {
                roundLinearLayout2.setRadius(f2);
                View childAt2 = roundLinearLayout2.getChildAt(0);
                kotlin.g.b.p.g(childAt2, "it.getChildAt(0)");
                childAt2.setBackground(null);
                kotlin.x xVar2 = kotlin.x.SXb;
            }
            RoundLinearLayout roundLinearLayout3 = (RoundLinearLayout) hVar.Mn(R.id.a31);
            if (roundLinearLayout3 != null) {
                roundLinearLayout3.setRadius(f2);
                View childAt3 = roundLinearLayout3.getChildAt(0);
                kotlin.g.b.p.g(childAt3, "it.getChildAt(0)");
                childAt3.setBackground(null);
                kotlin.x xVar3 = kotlin.x.SXb;
            }
            RoundLinearLayout roundLinearLayout4 = (RoundLinearLayout) hVar.Mn(R.id.dag);
            if (roundLinearLayout4 != null) {
                roundLinearLayout4.setRadius(f2);
                kotlin.x xVar4 = kotlin.x.SXb;
            }
            j.a aVar3 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(t2.feedObject.getFeedObject());
            new ap(arrayList, arrayList2, new ao(m2.first.booleanValue(), m2.second.booleanValue(), this, hVar, f2, t2, z2, p2, z3, o), this, hVar, f2, t2, z2, p2, z3, o).invoke();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!z3) {
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                String str6 = p2.get(0).username;
                if (str6 == null) {
                    str = "";
                } else {
                    str = str6;
                }
                String str7 = p2.get(0).nickname;
                if (str7 == null) {
                    str7 = "";
                }
                hf = com.tencent.mm.plugin.finder.utils.y.hf(str, str7);
            } else if (p2.size() <= 3) {
                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                FinderCommentInfo finderCommentInfo = (FinderCommentInfo) kotlin.a.j.kv(p2);
                if (finderCommentInfo == null || (str5 = finderCommentInfo.username) == null) {
                    str3 = "";
                } else {
                    str3 = str5;
                }
                FinderCommentInfo finderCommentInfo2 = (FinderCommentInfo) kotlin.a.j.kv(p2);
                if (finderCommentInfo2 == null || (str4 = finderCommentInfo2.nickname) == null) {
                    str4 = "";
                }
                hf = com.tencent.mm.plugin.finder.utils.y.hf(str3, str4);
            } else {
                com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                String str8 = p2.get(2).username;
                if (str8 == null) {
                    str2 = "";
                } else {
                    str2 = str8;
                }
                String str9 = p2.get(2).nickname;
                if (str9 == null) {
                    str9 = "";
                }
                hf = com.tencent.mm.plugin.finder.utils.y.hf(str2, str9);
            }
            String byc = com.tencent.mm.plugin.finder.utils.y.byc(hf);
            TextView textView = (TextView) hVar.Mn(R.id.gtq);
            if (textView != null) {
                Context context5 = hVar.getContext();
                kotlin.g.b.p.g(context5, "holder.context");
                textView.setTextColor(context5.getResources().getColor(R.color.am));
                com.tencent.mm.ui.ao.a(textView.getPaint(), 0.1f);
                textView.setTextSize(1, 15.0f);
                textView.setText("");
                kotlin.x xVar5 = kotlin.x.SXb;
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.gtn);
            kotlin.g.b.p.g(textView2, "descTv");
            textView2.setMaxLines(2);
            Context context6 = hVar.getContext();
            kotlin.g.b.p.g(context6, "holder.context");
            textView2.setTextColor(context6.getResources().getColor(R.color.am));
            com.tencent.mm.ui.ao.a(textView2.getPaint(), 0.1f);
            textView2.setTextSize(1, 15.0f);
            com.tencent.mm.plugin.finder.utils.y yVar5 = com.tencent.mm.plugin.finder.utils.y.vXH;
            boolean v2 = com.tencent.mm.plugin.finder.utils.y.v(t2);
            int i2 = t2.feedObject.getFeedObject().incFriendLikeCount;
            int i3 = o - i2;
            com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(t2.feedObject.getFeedObject().objectType);
            if (o <= 1) {
                string = Lj == null ? hVar.getContext().getString(R.string.d7o) : "";
            } else {
                if (Lj != null) {
                    String str10 = Lj.LJz;
                    if (!(str10 == null || str10.length() == 0)) {
                        String str11 = Lj.LJz;
                        string = str11 != null ? kotlin.n.n.j(str11, "$$", String.valueOf(i3 + i2), true) : null;
                    }
                }
                string = hVar.getContext().getString(R.string.d7n, String.valueOf(i3 + i2));
            }
            String str12 = byc + ' ' + string;
            if (i2 <= 0 || !v2) {
                textView2.setText(str12);
            } else {
                a(i2, hVar, str12, textView2);
            }
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            boolean z4 = com.tencent.mm.plugin.finder.storage.c.dwq().value().intValue() == 1;
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVb().value().intValue() == 1) {
                Mn = hVar.Mn(R.id.jzh);
            } else {
                Mn = hVar.Mn(R.id.d82);
            }
            if (z4) {
                j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                kotlin.o<Boolean, Boolean> m3 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(t2.feedObject.getFeedObject());
                boolean booleanValue = m3.first.booleanValue();
                m3.second.booleanValue();
                if (!t2.isDeepEnjoy || booleanValue) {
                    kotlin.g.b.p.g(Mn, "followLikeLayout");
                    Mn.setVisibility(8);
                } else {
                    kotlin.g.b.p.g(Mn, "followLikeLayout");
                    Mn.setVisibility(0);
                    Mn.setAlpha(1.0f);
                }
                Mn.setOnClickListener(new aq(Mn, this, hVar, f2, t2, z2, p2, z3, o));
            } else {
                kotlin.g.b.p.g(Mn, "followLikeLayout");
                Mn.setVisibility(8);
            }
            View Mn6 = hVar.Mn(R.id.gtp);
            if (Mn6 != null) {
                Mn6.setOnClickListener(new ar(this, hVar, f2, t2, z2, p2, z3, o));
                kotlin.x xVar6 = kotlin.x.SXb;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$5"})
    public static final class aq implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ View tCp;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        aq(View view, o oVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2) {
            this.tCp = view;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242937);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.aj ajVar = com.tencent.mm.plugin.finder.report.aj.viU;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.tzq.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.aj.a(fH != null ? fH.dIx() : null, "follow_like", false, this.tAz.lT());
            this.tzq.Mn(R.id.xk).callOnClick();
            this.tCp.animate().alpha(0.0f).setDuration(200).setListener(new com.tencent.mm.plugin.finder.animation.a(this) {
                /* class com.tencent.mm.plugin.finder.convert.o.aq.AnonymousClass1 */
                final /* synthetic */ aq tCq;

                {
                    this.tCq = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(242936);
                    View view = this.tCq.tCp;
                    kotlin.g.b.p.g(view, "followLikeLayout");
                    view.setVisibility(8);
                    View view2 = this.tCq.tCp;
                    kotlin.g.b.p.g(view2, "followLikeLayout");
                    view2.setAlpha(1.0f);
                    AppMethodBeat.o(242936);
                }
            }).start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242937);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$6"})
    public static final class ar implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        ar(o oVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2) {
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
        }

        public final void onClick(View view) {
            FinderLikeDrawer finderLikeDrawer;
            AppMethodBeat.i(242938);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.tzq.getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                finderLikeDrawer = (FinderLikeDrawer) activity.findViewById(R.id.clq);
            } else {
                finderLikeDrawer = null;
            }
            if (finderLikeDrawer == null) {
                kotlin.g.b.p.hyc();
            }
            finderLikeDrawer.a(this.tAz.feedObject, o.a(this.tAz));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242938);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void c(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        int i2;
        if (this.tAf) {
            j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            if (!Util.isNullOrNil(com.tencent.mm.plugin.finder.upload.action.j.vUv.p(t2.feedObject.getFeedObject()))) {
                hVar.mf(R.id.gvw, 8);
                return;
            }
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        int i3 = fH != null ? fH.tCE : 0;
        if (i3 == 3 || i3 == 16 || i3 == 27 || i3 == 9 || i3 == 18 || i3 == 31 || i3 == 29 || (i3 == 20 && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE))) {
            int i4 = t2.feedObject.getFeedObject().recommendType;
            hVar.mf(R.id.gvw, 0);
            String str = t2.feedObject.getFeedObject().recommendReason;
            if (!(str == null || str.length() == 0)) {
                TextView textView = (TextView) hVar.Mn(R.id.gvx);
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                textView.setTextColor(context2.getResources().getColor(R.color.v7));
                kotlin.g.b.p.g(textView, "reasonTv");
                SpannableString h2 = com.tencent.mm.pluginsdk.ui.span.l.h(hVar.getContext(), t2.feedObject.getFeedObject().recommendReason, (int) textView.getTextSize());
                Context context3 = hVar.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                int color = context3.getResources().getColor(R.color.v2);
                Context context4 = hVar.getContext();
                kotlin.g.b.p.g(context4, "holder.context");
                Resources resources = context4.getResources();
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
                kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
                if (!((com.tencent.mm.plugin.i.a.ad) af2).dxX()) {
                    i2 = R.color.vj;
                } else {
                    i2 = R.color.v9;
                }
                int color2 = resources.getColor(i2);
                com.tencent.mm.pluginsdk.ui.span.p[] pVarArr = (com.tencent.mm.pluginsdk.ui.span.p[]) h2.getSpans(0, h2.length(), com.tencent.mm.pluginsdk.ui.span.p.class);
                if (pVarArr != null) {
                    for (com.tencent.mm.pluginsdk.ui.span.p pVar : pVarArr) {
                        pVar.setColor(color2, color);
                    }
                }
                textView.setText(h2);
                textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                return;
            }
            Log.w("Finder.FeedFullConvert", "hide recommend layout type=" + i4 + " recommendReason=" + t2.feedObject.getFeedObject().recommendReason + " feedId=" + t2.feedObject.getFeedObject().id);
            hVar.mf(R.id.gvw, 8);
            return;
        }
        hVar.mf(R.id.gvw, 8);
    }

    private static void a(int i2, com.tencent.mm.view.recyclerview.h hVar, String str, TextView textView) {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        sb.append("(+" + i2 + ')');
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Red)), length, sb.length(), 17);
        textView.setText(spannableStringBuilder);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
    public static final class b<T extends BaseFinderFeed> extends IListener<hf> implements View.OnAttachStateChangeListener {
        final com.tencent.mm.view.recyclerview.h tAm;
        final o<T> tBJ;

        public b(o<T> oVar, com.tencent.mm.view.recyclerview.h hVar) {
            kotlin.g.b.p.h(oVar, "parent");
            kotlin.g.b.p.h(hVar, "holder");
            AppMethodBeat.i(242885);
            this.tBJ = oVar;
            this.tAm = hVar;
            if (this.tAm.getContext() instanceof MMActivity) {
                Context context = this.tAm.getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(242885);
                    throw tVar;
                }
                ((MMActivity) context).getLifecycle().addObserver(((o) this.tBJ).tBH);
            }
            AppMethodBeat.o(242885);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            AppMethodBeat.i(242882);
            com.tencent.mm.ac.d.h(new a(this, hfVar));
            AppMethodBeat.o(242882);
            return false;
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(242883);
            kotlin.g.b.p.h(view, "v");
            AppMethodBeat.o(242883);
        }

        public final void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(242884);
            kotlin.g.b.p.h(view, "v");
            AppMethodBeat.o(242884);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ hf tAo;
            final /* synthetic */ b tBK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, hf hfVar) {
                super(0);
                this.tBK = bVar;
                this.tAo = hfVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                String str;
                String str2;
                hf.a aVar;
                com.tencent.mm.plugin.finder.api.g gVar;
                String str3 = null;
                AppMethodBeat.i(242881);
                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.tBK.tAm.hgv();
                if (baseFinderFeed == null || (gVar = baseFinderFeed.contact) == null) {
                    str = null;
                } else {
                    str = gVar.getUsername();
                }
                if (str != null) {
                    hf hfVar = this.tAo;
                    if (hfVar == null || (aVar = hfVar.dLI) == null) {
                        str2 = null;
                    } else {
                        str2 = aVar.username;
                    }
                    com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
                    if (gVar2 != null) {
                        str3 = gVar2.getUsername();
                    }
                    if (kotlin.g.b.p.j(str2, str3)) {
                        this.tBK.tBJ.a((o) this.tBK.tAm, (com.tencent.mm.view.recyclerview.h) baseFinderFeed);
                        this.tBK.tBJ.c(baseFinderFeed, this.tBK.tAm);
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(242881);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$1$2"})
    public static final class w implements View.OnClickListener {
        final /* synthetic */ azs UHV;
        final /* synthetic */ z.d UHW;
        final /* synthetic */ z.a UHX;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableString tBR;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        w(azs azs, o oVar, com.tencent.mm.view.recyclerview.h hVar, NeatTextView neatTextView, SpannableString spannableString, z.d dVar, SpannableStringBuilder spannableStringBuilder, float f2, int i2, BaseFinderFeed baseFinderFeed, int i3, int i4, int i5, z.a aVar) {
            this.UHV = azs;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBT = neatTextView;
            this.tBR = spannableString;
            this.UHW = dVar;
            this.tBS = spannableStringBuilder;
            this.tBU = f2;
            this.tBV = i2;
            this.tAz = baseFinderFeed;
            this.tBW = i3;
            this.tBX = i4;
            this.tBY = i5;
            this.UHX = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260198);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            o.a(this.tzq, this.tAz, this.UHV);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260198);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$1$3"})
    public static final class x implements View.OnClickListener {
        final /* synthetic */ azs UHV;
        final /* synthetic */ z.d UHW;
        final /* synthetic */ z.a UHX;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableString tBR;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        x(azs azs, o oVar, com.tencent.mm.view.recyclerview.h hVar, NeatTextView neatTextView, SpannableString spannableString, z.d dVar, SpannableStringBuilder spannableStringBuilder, float f2, int i2, BaseFinderFeed baseFinderFeed, int i3, int i4, int i5, z.a aVar) {
            this.UHV = azs;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBT = neatTextView;
            this.tBR = spannableString;
            this.UHW = dVar;
            this.tBS = spannableStringBuilder;
            this.tBU = f2;
            this.tBV = i2;
            this.tAz = baseFinderFeed;
            this.tBW = i3;
            this.tBX = i4;
            this.tBY = i5;
            this.UHX = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260199);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            o.a(this.tzq, this.tAz, this.UHV);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260199);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$2$2"})
    public static final class as implements View.OnClickListener {
        final /* synthetic */ z.a UHX;
        final /* synthetic */ SpannableString UHY;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ SpannableString tBR;
        final /* synthetic */ SpannableStringBuilder tBS;
        final /* synthetic */ NeatTextView tBT;
        final /* synthetic */ float tBU;
        final /* synthetic */ int tBV;
        final /* synthetic */ int tBW;
        final /* synthetic */ int tBX;
        final /* synthetic */ int tBY;
        final /* synthetic */ int tBZ;
        final /* synthetic */ z.a tCa;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        as(SpannableString spannableString, o oVar, SpannableString spannableString2, SpannableStringBuilder spannableStringBuilder, com.tencent.mm.view.recyclerview.h hVar, NeatTextView neatTextView, float f2, int i2, BaseFinderFeed baseFinderFeed, int i3, z.a aVar, int i4, int i5, int i6, z.a aVar2) {
            this.UHY = spannableString;
            this.tBP = oVar;
            this.tBR = spannableString2;
            this.tBS = spannableStringBuilder;
            this.tzq = hVar;
            this.tBT = neatTextView;
            this.tBU = f2;
            this.tBV = i2;
            this.tAz = baseFinderFeed;
            this.tBW = i3;
            this.UHX = aVar;
            this.tBX = i4;
            this.tBY = i5;
            this.tBZ = i6;
            this.tCa = aVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260200);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            o.a(this.tBP, this.tzq, this.tAz, this.UHY.toString());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$mergeContent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260200);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void j(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(t2, "item");
        kotlin.g.b.p.h(hVar, "holder");
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.h(t2)) {
            View Mn = hVar.Mn(R.id.d11);
            if (Mn != null) {
                Mn.setVisibility(8);
            }
            View Mn2 = hVar.Mn(R.id.d8o);
            if (Mn2 != null) {
                Mn2.setVisibility(0);
            }
        } else if (!t2.feedObject.isPostFinish() && t2.feedObject.getPostInfo().Mpc < 100) {
            View Mn3 = hVar.Mn(R.id.d11);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
            }
            View Mn4 = hVar.Mn(R.id.d8o);
            if (Mn4 != null) {
                Mn4.setVisibility(8);
            }
            FinderPostProgressView finderPostProgressView = (FinderPostProgressView) hVar.Mn(R.id.gfq);
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            finderPostProgressView.setBackColor(context.getResources().getColor(R.color.v1));
            View Mn5 = hVar.Mn(R.id.gfr);
            View Mn6 = hVar.Mn(R.id.gfa);
            TextView textView = (TextView) hVar.Mn(R.id.car);
            View Mn7 = hVar.Mn(R.id.gfn);
            View Mn8 = hVar.Mn(R.id.gf7);
            kotlin.g.b.p.g(Mn8, "delArea");
            Mn8.setVisibility(0);
            if (t2.feedObject.isPostFailed()) {
                kotlin.g.b.p.g(Mn6, "failedArea");
                Mn6.setVisibility(0);
                kotlin.g.b.p.g(Mn5, "progressArea");
                Mn5.setVisibility(8);
                if (!t2.feedObject.isPostFailedCanRetry()) {
                    kotlin.g.b.p.g(Mn7, "retryArea");
                    Mn7.setVisibility(8);
                } else {
                    kotlin.g.b.p.g(Mn7, "retryArea");
                    Mn7.setVisibility(0);
                }
                if (t2.feedObject.isPostNoAuth()) {
                    kotlin.g.b.p.g(textView, "failedTv");
                    Context context2 = hVar.getContext();
                    kotlin.g.b.p.g(context2, "holder.context");
                    textView.setText(Html.fromHtml(context2.getResources().getString(R.string.d5m)));
                    textView.setOnClickListener(new ak(this));
                    Mn7.setVisibility(0);
                } else if (t2.feedObject.isEventClosed()) {
                    kotlin.g.b.p.g(textView, "failedTv");
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    textView.setText(context3.getResources().getString(R.string.d5l));
                } else if (t2.feedObject.isEventExpired()) {
                    kotlin.g.b.p.g(textView, "failedTv");
                    Context context4 = hVar.getContext();
                    kotlin.g.b.p.g(context4, "holder.context");
                    textView.setText(context4.getResources().getString(R.string.jcv));
                } else {
                    kotlin.g.b.p.g(textView, "failedTv");
                    Context context5 = hVar.getContext();
                    kotlin.g.b.p.g(context5, "holder.context");
                    textView.setText(context5.getResources().getString(R.string.cpf));
                }
            } else {
                kotlin.g.b.p.g(Mn6, "failedArea");
                Mn6.setVisibility(8);
                kotlin.g.b.p.g(Mn5, "progressArea");
                Mn5.setVisibility(0);
                kotlin.g.b.p.g(Mn7, "retryArea");
                Mn7.setVisibility(8);
                ValueAnimator ofInt = ValueAnimator.ofInt(finderPostProgressView.getProgress(), t2.feedObject.getPostInfo().Mpc);
                ofInt.addUpdateListener(new al(finderPostProgressView));
                ValueAnimator duration = ofInt.setDuration(400L);
                if (duration != null) {
                    duration.start();
                }
                hVar.setTag(ofInt);
            }
            Mn8.setOnClickListener(new am(this, t2));
            Mn7.setOnClickListener(new an(t2));
        } else if (t2.isFinishPostSoon) {
            e(t2, hVar);
            t2.isFinishPostSoon = false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ak implements View.OnClickListener {
        final /* synthetic */ o tBP;

        ak(o oVar) {
            this.tBP = oVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242930);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MMActivity activity = this.tBP.tAi.getActivity();
            if (activity != null) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.h(activity, ".ui.FinderHomeUI");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242930);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class al implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderPostProgressView tAY;

        al(FinderPostProgressView finderPostProgressView) {
            this.tAY = finderPostProgressView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(242931);
            FinderPostProgressView finderPostProgressView = this.tAY;
            kotlin.g.b.p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(242931);
                throw tVar;
            }
            finderPostProgressView.setProgress(((Integer) animatedValue).intValue());
            this.tAY.invalidate();
            AppMethodBeat.o(242931);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class am implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ o tBP;

        am(o oVar, BaseFinderFeed baseFinderFeed) {
            this.tBP = oVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242932);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            o.f(this.tAr);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242932);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class an implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAr;

        an(BaseFinderFeed baseFinderFeed) {
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242933);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g.vSH.t(this.tAr.feedObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshPostProgress$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242933);
        }
    }

    private static void a(ImageView imageView, azu azu) {
        String str = azu != null ? azu.LJJ : null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            imageView.setLayerPaint(null);
            Context context = imageView.getContext();
            Context context2 = imageView.getContext();
            kotlin.g.b.p.g(context2, "imageView.context");
            imageView.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.icons_filled_like_group, context2.getResources().getColor(R.color.Red_90)));
            return;
        }
        imageView.setLayerPaint(null);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
        com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        djY.a(pVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ o tBP;

        f(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tBP = oVar;
            this.qhp = hVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str;
            int i3;
            Intent intent;
            Intent intent2;
            AppMethodBeat.i(242889);
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            String zs = com.tencent.mm.ac.d.zs(!baseFinderFeed.feedObject.isPostFinish() ? 0 : baseFinderFeed.feedObject.getId());
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                str = fH.sGQ;
            } else {
                str = null;
            }
            objArr[0] = str;
            objArr[1] = zs;
            objArr[2] = 1;
            objArr[3] = com.tencent.mm.plugin.sns.data.r.eZx();
            hVar.a(21180, objArr);
            MMActivity activity = this.tBP.tAi.getActivity();
            if (activity == null || (intent2 = activity.getIntent()) == null || !intent2.getBooleanExtra("key_form_sns", false)) {
                MMActivity activity2 = this.tBP.tAi.getActivity();
                if (activity2 == null || (intent = activity2.getIntent()) == null) {
                    i3 = 0;
                } else {
                    i3 = intent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) ? 2 : 0;
                }
            } else {
                i3 = 1;
            }
            s.a aVar2 = com.tencent.mm.plugin.finder.utils.s.vWt;
            MMActivity activity3 = this.tBP.tAi.getActivity();
            if (activity3 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(baseFinderFeed, "currItem");
            s.a.a(activity3, baseFinderFeed, 5, i3, 4);
            AppMethodBeat.o(242889);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class g implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        g(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            String str;
            AppMethodBeat.i(242890);
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            String zs = com.tencent.mm.ac.d.zs(!baseFinderFeed.feedObject.isPostFinish() ? 0 : baseFinderFeed.feedObject.getId());
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                str = fH.sGQ;
            } else {
                str = null;
            }
            objArr[0] = str;
            objArr[1] = zs;
            objArr[2] = 0;
            objArr[3] = com.tencent.mm.plugin.sns.data.r.eZx();
            hVar.a(21180, objArr);
            AppMethodBeat.o(242890);
        }
    }

    public void e(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        boolean z2;
        kotlin.g.b.p.h(t2, "item");
        kotlin.g.b.p.h(hVar, "holder");
        Log.i("Finder.FeedFullConvert", "[onPostFinished] feed=" + com.tencent.mm.ac.d.zs(t2.lT()));
        g(hVar);
        FinderFullSeekBarLayout finderFullSeekBarLayout = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        if (finderFullSeekBarLayout != null) {
            z2 = finderFullSeekBarLayout.wbG;
        } else {
            z2 = false;
        }
        View Mn = hVar.Mn(R.id.d11);
        if (Mn != null) {
            Mn.setVisibility(8);
        }
        View Mn2 = hVar.Mn(R.id.d11);
        if (Mn2 != null) {
            Mn2.setTag(R.id.d33, Boolean.FALSE);
        }
        if (!z2) {
            View Mn3 = hVar.Mn(R.id.d8o);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
            }
        } else {
            View Mn4 = hVar.Mn(R.id.d8o);
            if (Mn4 != null) {
                Mn4.setTag(R.id.d33, Boolean.TRUE);
            }
            View Mn5 = hVar.Mn(R.id.d8o);
            if (Mn5 != null) {
                Mn5.setVisibility(8);
            }
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.dCF()) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.i(t2.contact)) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dsS() < 6) {
                    z.f fVar = new z.f();
                    fVar.SYG = (T) hVar.Mn(R.id.d37);
                    if (fVar.SYG == null) {
                        fVar.SYG = (T) ((ViewStub) hVar.Mn(R.id.d38)).inflate();
                    }
                    T t3 = fVar.SYG;
                    kotlin.g.b.p.g(t3, "tips");
                    t3.setVisibility(0);
                    T t4 = fVar.SYG;
                    kotlin.g.b.p.g(t4, "tips");
                    t4.setAlpha(0.0f);
                    fVar.SYG.animate().setDuration(300).alpha(1.0f).start();
                    fVar.SYG.postDelayed(new z(fVar), 5000);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class z implements Runnable {
        final /* synthetic */ z.f tBq;

        z(z.f fVar) {
            this.tBq = fVar;
        }

        public final void run() {
            AppMethodBeat.i(242919);
            T t = this.tBq.SYG;
            kotlin.g.b.p.g(t, "tips");
            t.setVisibility(8);
            AppMethodBeat.o(242919);
        }
    }

    public static void g(com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(hVar, "holder");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        View Mn = hVar.Mn(R.id.d33);
        View Mn2 = hVar.Mn(R.id.ggj);
        if (Mn2 != null) {
            Mn2.post(new c(Mn2, hVar, finderMediaBanner, Mn));
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$adjustSeekLayout$1$1"})
    public static final class c implements Runnable {
        final /* synthetic */ View tBL;
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ View tBO;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        c(View view, com.tencent.mm.view.recyclerview.h hVar, FinderMediaBanner finderMediaBanner, View view2) {
            this.tBL = view;
            this.tzq = hVar;
            this.tBM = finderMediaBanner;
            this.tBO = view2;
        }

        public final void run() {
            AppMethodBeat.i(242886);
            View Mn = this.tzq.Mn(R.id.gto);
            kotlin.g.b.p.g(Mn, "recommendRealNameLayout");
            if (Mn.getVisibility() != 0) {
                Mn = this.tzq.Mn(R.id.bfb);
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.tzq.aus.getLocationInWindow(iArr);
            this.tBM.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - iArr[0];
            iArr2[1] = iArr2[1] - iArr[1];
            Mn.getLocationInWindow(iArr3);
            iArr3[0] = iArr3[0] - iArr[0];
            iArr3[1] = iArr3[1] - iArr[1];
            View view = this.tBO;
            kotlin.g.b.p.g(view, "seekLayout");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(242886);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i2 = layoutParams2.topMargin;
            Context context = this.tzq.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.cn);
            int i3 = iArr2[1];
            FinderMediaBanner finderMediaBanner = this.tBM;
            kotlin.g.b.p.g(finderMediaBanner, "banner");
            if (i3 + finderMediaBanner.getHeight() + this.tBL.getHeight() > iArr3[1]) {
                layoutParams2.topMargin = iArr3[1] - dimension;
            } else {
                int i4 = iArr2[1];
                FinderMediaBanner finderMediaBanner2 = this.tBM;
                kotlin.g.b.p.g(finderMediaBanner2, "banner");
                layoutParams2.topMargin = i4 + finderMediaBanner2.getHeight();
            }
            if (layoutParams2.topMargin != i2) {
                this.tBO.requestLayout();
            }
            AppMethodBeat.o(242886);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
    public static final class ao extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ boolean tCm;
        final /* synthetic */ boolean tCn;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ao(boolean z, boolean z2, o oVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z3, LinkedList linkedList, boolean z4, int i2) {
            super(0);
            this.tCm = z;
            this.tCn = z2;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z3;
            this.tBd = linkedList;
            this.tBe = z4;
            this.tBf = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(242934);
            if (!this.tBc || !this.tCm || this.tCn || this.tBd.size() <= 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242934);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
    public static final class ap extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ o tBP;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ List tBh;
        final /* synthetic */ List tBi;
        final /* synthetic */ kotlin.g.a.a tCo;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ap(List list, List list2, kotlin.g.a.a aVar, o oVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2) {
            super(0);
            this.tBh = list;
            this.tBi = list2;
            this.tCo = aVar;
            this.tBP = oVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            String str;
            AppMethodBeat.i(242935);
            int i2 = 0;
            for (Object obj : this.tBh) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                ImageView imageView = (ImageView) obj;
                if (imageView != null) {
                    ViewParent parent = imageView.getParent();
                    if (!(parent instanceof RoundLinearLayout)) {
                        parent = null;
                    }
                    RoundLinearLayout roundLinearLayout = (RoundLinearLayout) parent;
                    if (roundLinearLayout != null) {
                        roundLinearLayout.setRadius(this.tBb);
                    }
                    if (i2 >= this.tBd.size()) {
                        View view = (View) this.tBi.get(i2);
                        if (view != null) {
                            view.setVisibility(8);
                            i2 = i3;
                        } else {
                            i2 = i3;
                        }
                    } else {
                        if (((Boolean) this.tCo.invoke()).booleanValue()) {
                            View view2 = (View) this.tBi.get(i2);
                            if (view2 != null) {
                                view2.setVisibility(4);
                            }
                        } else {
                            View view3 = (View) this.tBi.get(i2);
                            if (view3 != null) {
                                view3.setVisibility(0);
                            }
                        }
                        String str2 = ((FinderCommentInfo) this.tBd.get(i2)).headUrl;
                        if (str2 == null) {
                            str = "";
                        } else {
                            str = str2;
                        }
                        kotlin.g.b.p.g(str, "likeList[index].headUrl ?: \"\"");
                        if (kotlin.g.b.p.j(((FinderCommentInfo) this.tBd.get(i2)).username, com.tencent.mm.model.z.aTY())) {
                            a.b.d(imageView, com.tencent.mm.model.z.aTY(), 0.0f);
                            i2 = i3;
                        } else {
                            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkc = com.tencent.mm.plugin.finder.loader.m.dkc();
                            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
                            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            dkc.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.RECT_AVATAR));
                        }
                    }
                }
                i2 = i3;
            }
            if (((Boolean) this.tCo.invoke()).booleanValue()) {
                LinkedList linkedList = this.tBd;
                List list = this.tBi;
                View view4 = this.tzq.aus;
                kotlin.g.b.p.g(view4, "holder.itemView");
                o.b(linkedList, list, view4, this.tBP.tAg);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242935);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x03a9, code lost:
        if ((r11.length() > 0) != false) goto L_0x03ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x063d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x069d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x06a0  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x071a  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x071d  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0735  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0762  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x07d3  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x07d8  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x07f7  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0817  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0827  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0836  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0867  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x08f0  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x093b  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0977  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x09ad  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x09bf  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x09fa  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0aaf  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0ab4  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0ab8  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0d45  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0e25  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0e3c  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0e4e  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0e59  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0e5c  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0ed3  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0f0a  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0f18  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0f28  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0f39  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0f4e  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0f85  */
    /* JADX WARNING: Removed duplicated region for block: B:410:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0385  */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.view.recyclerview.h r53, T r54, int r55, int r56, boolean r57, java.util.List<java.lang.Object> r58) {
        /*
        // Method dump skipped, instructions count: 4044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.o.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List):void");
    }

    public static com.tencent.mm.bw.b a(T t2) {
        kotlin.g.b.p.h(t2, "item");
        return t2.likeBuffer;
    }

    public static final /* synthetic */ void a(o oVar, com.tencent.mm.view.recyclerview.h hVar) {
        View Mn;
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.v(baseFinderFeed.feedObject.getFeedObject())) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            String string = hVar.getContext().getString(R.string.d5z);
            kotlin.g.b.p.g(string, "holder.context.getString…g.finder_private_ban_fav)");
            com.tencent.mm.plugin.finder.utils.y.aF(context, string);
            return;
        }
        c.a aVar = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        boolean z2 = !com.tencent.mm.plugin.finder.upload.action.c.dBq().k(baseFinderFeed.feedObject.getFeedObject());
        oVar.tAi.a(baseFinderFeed.feedObject, z2, hVar);
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtS().value().intValue() == 1 && (Mn = hVar.Mn(R.id.ccz)) != null) {
                com.tencent.mm.plugin.finder.view.animation.b bVar = com.tencent.mm.plugin.finder.view.animation.b.wry;
                com.tencent.mm.plugin.finder.view.animation.b.ei(Mn);
            }
        }
        if (oVar.tAj && z2) {
            com.tencent.mm.ui.base.u.makeText(hVar.getContext(), (int) R.string.d3d, 0).show();
        }
    }

    public static final /* synthetic */ void b(LinkedList linkedList, List list, View view, boolean z2) {
        com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        com.tencent.mm.plugin.finder.view.animation.c.c(linkedList, list, view, z2);
    }

    public static final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, azs azs) {
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (!((com.tencent.mm.plugin.i.a.ad) af2).dxX() && !baseFinderFeed.isPreview) {
            Intent intent = new Intent();
            intent.putExtra("key_activity_id", azs.twd);
            intent.putExtra("key_activity_name", azs.eventName);
            intent.putExtra("key_nick_name", azs.LJx);
            intent.putExtra("key_feed_ref_id", baseFinderFeed.feedObject.getFeedObject().id);
            Log.i("Finder.FeedFullConvert", "eventTopicId :" + azs.twd + " eventName:" + azs.eventName + " refId: " + baseFinderFeed.feedObject.getFeedObject().id);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = hVar.getContext();
            if (context == null) {
                throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            }
            com.tencent.mm.plugin.finder.utils.a.aa((MMActivity) context, intent);
        }
    }

    public static final /* synthetic */ void b(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, String str) {
        int i2;
        com.tencent.mm.plugin.finder.event.a b2;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        Intent intent = new Intent();
        String d2 = com.tencent.mm.ag.m.d(str, 156, i2 + 10000, (int) (System.currentTimeMillis() / 1000));
        Log.i("Finder.FeedFullConvert", "click linkLayout, url:" + str + ", urlWithReportParams:" + d2);
        intent.putExtra("rawUrl", d2);
        com.tencent.mm.br.c.b(hVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (fH2 != null && (b2 = FinderReporterUIC.b(fH2)) != null) {
            b2.cZR().Ez(baseFinderFeed.lT());
        }
    }
}

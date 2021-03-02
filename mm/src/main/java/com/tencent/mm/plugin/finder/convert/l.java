package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Size;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.b.a.bu;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000÷\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013*\u00010\b&\u0018\u0000 Ö\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004Ö\u0001×\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020:H\u0004J\u001d\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020E2\u0006\u0010=\u001a\u00020>H\u0002J\u0015\u0010F\u001a\u00020\u00072\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010GJ\u001d\u0010H\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IJ-\u0010J\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH&¢\u0006\u0002\u0010MJ5\u0010N\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0006\u0010O\u001a\u00020P2\u0006\u00109\u001a\u00020:2\u0006\u0010Q\u001a\u00020R2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010SJ\u0018\u0010T\u001a\u0002032\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010X\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002J7\u0010Y\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010Z\u001a\u00020\u00072\b\b\u0002\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010]J*\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\b\u0010`\u001a\u0004\u0018\u00010R2\u0006\u0010a\u001a\u00020bH\u0002J0\u0010^\u001a\u0002032\u0006\u0010c\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\u0006\u0010`\u001a\u00020R2\u0006\u0010a\u001a\u00020bH\u0002J\u0017\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010<\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010fJ \u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0002H\u0002J'\u0010j\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\b\u0010k\u001a\u0004\u0018\u00010RH\u0002¢\u0006\u0002\u0010lJ'\u0010m\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\b\u0010n\u001a\u0004\u0018\u00010RH\u0002¢\u0006\u0002\u0010lJ\u0016\u0010o\u001a\u0002032\u0006\u0010p\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>J\u0010\u0010q\u001a\u0002032\u0006\u0010D\u001a\u00020EH\u0002J=\u0010r\u001a\u0002032\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u0002072\u0006\u0010<\u001a\u00028\u00002\u0006\u0010t\u001a\u00020u2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010v\u001a\u00020\tH\u0002¢\u0006\u0002\u0010wJO\u0010x\u001a\u0002032\u0006\u0010y\u001a\u00020R2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u0002072\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>2\b\u0010z\u001a\u0004\u0018\u00010e2\u0006\u0010{\u001a\u00020\u00072\b\b\u0002\u0010v\u001a\u00020\tH\u0002¢\u0006\u0002\u0010|J9\u0010}\u001a\u0002032\f\u0010~\u001a\b\u0012\u0004\u0012\u00020P02\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010E0\u00012\u0007\u0010\u0001\u001a\u00020E2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\"\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u0007H\u0002J#\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J.\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0016¢\u0006\u0002\u0010MJK\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00072\u0011\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010\u0001J#\u0010\u0001\u001a\u0002032\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010L\u001a\u00020\tH\u0016J$\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020E2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001a\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020EH\u0016J\u001e\u0010\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0002\u0010?J\u0011\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0016JY\u0010\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0001\u001a\u00020:2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0014¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u0002032\u0006\u0010U\u001a\u00020\u0002H\u0002J3\u0010 \u0001\u001a\u0002032\u0006\u0010<\u001a\u00020\u00022\u0007\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0002J\u0019\u0010¢\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\b\u0010£\u0001\u001a\u00030¤\u0001J*\u0010¥\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010¦\u0001J\u001e\u0010§\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J#\u0010¨\u0001\u001a\u0002032\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0002J\u0011\u0010«\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002J/\u0010¬\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\t\u0010<\u001a\u0005\u0018\u00010¤\u00012\u000b\b\u0002\u0010­\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010®\u0001J\u001e\u0010¯\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IJ\u001e\u0010°\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010IJ\u001e\u0010±\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\t\u0010²\u0001\u001a\u000203H\u0016J\u001e\u0010³\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IJ#\u0010´\u0001\u001a\u0002032\u0007\u0010¡\u0001\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J\u001e\u0010µ\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\u001e\u0010¶\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IJ*\u0010·\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>2\t\b\u0002\u0010¸\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0003\u0010¹\u0001J(\u0010º\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>2\u0007\u0010»\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0003\u0010¹\u0001J\u001e\u0010¼\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\u001e\u0010½\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IJ\u001e\u0010¾\u0001\u001a\u0002032\u0006\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\u001a\u0010¿\u0001\u001a\u0002032\u0007\u0010À\u0001\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0016J\u001f\u0010Á\u0001\u001a\u0002032\b\u0010Â\u0001\u001a\u00030Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0002J%\u0010Æ\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010Ç\u0001\u001a\u00020R2\t\u0010<\u001a\u0005\u0018\u00010¤\u0001H\u0002J\u0011\u0010È\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0016J\u0011\u0010É\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0016J'\u0010Ê\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\t\u0010<\u001a\u0005\u0018\u00010¤\u00012\t\u0010Ë\u0001\u001a\u0004\u0018\u00010RH\u0002J'\u0010Ì\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\t\u0010<\u001a\u0005\u0018\u00010¤\u00012\t\u0010Í\u0001\u001a\u0004\u0018\u00010RH\u0002J1\u0010Î\u0001\u001a\u0002032\u0007\u0010¡\u0001\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u00002\t\b\u0002\u0010Ï\u0001\u001a\u00020\u0007¢\u0006\u0003\u0010Ð\u0001J\u0018\u0010Ñ\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>2\u0007\u0010Ò\u0001\u001a\u00020\u0007J'\u0010Ó\u0001\u001a\u0002032\u0006\u0010D\u001a\u00020E2\u0006\u0010=\u001a\u00020>2\u0006\u0010<\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Ô\u0001J\u0011\u0010Õ\u0001\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0&X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0013R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000X\u0004¢\u0006\u0004\n\u0002\u00101¨\u0006Ø\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "FINDER_FOLLOW_PAT_ENTRANCE_VALUE", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "MENU_ID_UNFOLLOW", "avatarRectControl", "feedHeadBarStyle", "getFeedHeadBarStyle", "()I", "setFeedHeadBarStyle", "(I)V", "hideSelfTipsRunnable", "Ljava/lang/Runnable;", "isRealNameLike", "onAvatarClickListener", "Landroid/view/View$OnClickListener;", "getOnAvatarClickListener", "()Landroid/view/View$OnClickListener;", "setOnAvatarClickListener", "(Landroid/view/View$OnClickListener;)V", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateOpArea", "item", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "canFetchSimilarFeeds", "context", "Landroid/content/Context;", "checkHideLikeTips", "tipsView", "Landroid/view/View;", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkShowShareSnsLayout", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "fetchSimilarFeeds", "enable", "enableOnClick", "fromFav", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ZZZ)V", "formatDesc", "incCount", "suffix", "descTv", "Landroid/widget/TextView;", "preCount", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "handleLinkTvOnClick", "link", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "handlePoiOnClick", "poiText", "hideOrDimissMoreBtn", "ifShow", "hideSelfFeedLikeTips", "jumpFoldedUI", "feedList", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "jumpRelatedUI", "title", "lastBuffer", "needRefresh", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "likeAvatorAnimator", "likeCount", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "likeLocalFeed", "isPrivate", "onBindFinish", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onPostFinished", "onViewRecycled", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshBgmTag", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshExposeLayout", "refreshFavIv", "isFav", "favCount", "refreshFeedHeaderBar", "refreshFinderLiveNoticeView", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFoldedLayout", "refreshFollowState", "refreshHeaderFooterWording", "refreshImgBgmTag", "refreshLiveIcon", "refreshLocalAwesomeIv", "refreshOpLayout", "refreshPrivateIcon", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshSimilarEntrance", "refreshUpdateTime", "setFooterOpLayoutVisibility", "visibility", "setGroupLikeIcon", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "setNewsTitle", "topicName", "setNicknameCalculateWidth", "shareFeed", "showActivityInfo", "nickName", "showNewsIndicator", "userName", "showOrDimissSelfFeedLikeTips", "isBind", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "showPrivateFeedLikeTips", "isPrivateClick", "showSelfFeedLikeTips", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class l<T extends BaseFinderFeed> extends com.tencent.mm.view.recyclerview.e<T> {
    public static final a tAk = new a((byte) 0);
    final int dLS;
    private Rect rect;
    private int tAa;
    private final HashSet<b<T>> tAb;
    public View.OnClickListener tAc;
    private Runnable tAd;
    private final FinderFeedConvert$uiLifecycleObserver$1 tAe;
    private final boolean tAf;
    private final boolean tAg;
    private final int tAh;
    private final com.tencent.mm.plugin.finder.feed.i tAi;
    protected boolean tAj;
    Dialog tipDialog;
    private final int tzW;
    private final int tzX;
    private final int tzY;
    private final int tzZ;

    public abstract void a(com.tencent.mm.view.recyclerview.h hVar, T t2, int i2);

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
    public static final class af extends kotlin.g.b.q implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            super(2);
            this.tAp = lVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(View view, FinderCommentInfo finderCommentInfo) {
            AppMethodBeat.i(165370);
            View view2 = view;
            final FinderCommentInfo finderCommentInfo2 = finderCommentInfo;
            kotlin.g.b.p.h(view2, "view");
            if (finderCommentInfo2 != null && Util.isEqual(finderCommentInfo2.username, com.tencent.mm.model.z.aTY())) {
                TouchableLayout.a aVar = TouchableLayout.Rni;
                int i2 = TouchableLayout.kuv;
                TouchableLayout.a aVar2 = TouchableLayout.Rni;
                new com.tencent.mm.ui.widget.b.a(view2.getContext()).a(view2, 0, 0, AnonymousClass1.tAP, new o.g(this) {
                    /* class com.tencent.mm.plugin.finder.convert.l.af.AnonymousClass2 */
                    final /* synthetic */ af tAQ;

                    {
                        this.tAQ = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(165366);
                        if (menuItem != null) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (!Util.isNullOrNil(finderCommentInfo2.content)) {
                                        ClipboardHelper.setText(MMApplicationContext.getContext(), finderCommentInfo2.content, finderCommentInfo2.content);
                                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.ta, 0).show();
                                        AppMethodBeat.o(165366);
                                        return;
                                    }
                                    break;
                                case 1:
                                    l lVar = this.tAQ.tAp;
                                    Context context = this.tAQ.qhp.getContext();
                                    kotlin.g.b.p.g(context, "holder.context");
                                    l.a(lVar, context, finderCommentInfo2, this.tAQ.tAr.lT(), this.tAQ.tAr.feedObject.getObjectNonceId(), this.tAQ.tAr);
                                    break;
                            }
                        }
                        AppMethodBeat.o(165366);
                    }
                }, i2, TouchableLayout.kuw);
            } else if (finderCommentInfo2 != null) {
                TouchableLayout.a aVar3 = TouchableLayout.Rni;
                int i3 = TouchableLayout.kuv;
                TouchableLayout.a aVar4 = TouchableLayout.Rni;
                new com.tencent.mm.ui.widget.b.a(view2.getContext()).a(view2, 0, 0, AnonymousClass3.tAR, new o.g() {
                    /* class com.tencent.mm.plugin.finder.convert.l.af.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(165369);
                        if (menuItem != null) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (!Util.isNullOrNil(finderCommentInfo2.content)) {
                                        ClipboardHelper.setText(MMApplicationContext.getContext(), finderCommentInfo2.content, finderCommentInfo2.content);
                                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.ta, 0).show();
                                        AppMethodBeat.o(165369);
                                        return;
                                    }
                                    break;
                                case 1:
                                    com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                                    Context context = MMApplicationContext.getContext();
                                    kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                                    com.tencent.mm.plugin.finder.feed.logic.a.a(context, finderCommentInfo2.commentId, 0, 0, 12);
                                    break;
                            }
                        }
                        AppMethodBeat.o(165369);
                    }
                }, i3, TouchableLayout.kuw);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165370);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
    public static final class ag extends kotlin.g.b.q implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ag(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            super(2);
            this.tAp = lVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(View view, FinderCommentInfo finderCommentInfo) {
            AppMethodBeat.i(165371);
            FinderCommentInfo finderCommentInfo2 = finderCommentInfo;
            kotlin.g.b.p.h(view, "view");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.qhp.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20912, 3, 5, this.tAr.feedObject.getUserName(), this.tAr.feedObject.getNickName());
            } else if (finderCommentInfo2 == null || finderCommentInfo2.commentId == 0) {
                l.a(this.tAp, this.qhp, this.tAr, false, 0, null, 0, 0, 120);
            } else {
                l lVar = this.tAp;
                com.tencent.mm.view.recyclerview.h hVar = this.qhp;
                BaseFinderFeed baseFinderFeed = this.tAr;
                long j2 = finderCommentInfo2.commentId;
                com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                l.a(lVar, hVar, baseFinderFeed, false, j2, com.tencent.mm.plugin.finder.storage.logic.a.a(finderCommentInfo2, this.tAr.feedObject.getId()), 0, 0, 96);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165371);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
    public static final class ah extends kotlin.g.b.q implements kotlin.g.a.m<FinderCommentInfo, Boolean, kotlin.x> {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(l lVar, BaseFinderFeed baseFinderFeed) {
            super(2);
            this.tAp = lVar;
            this.tAr = baseFinderFeed;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(FinderCommentInfo finderCommentInfo, Boolean bool) {
            AppMethodBeat.i(165372);
            FinderCommentInfo finderCommentInfo2 = finderCommentInfo;
            bool.booleanValue();
            kotlin.g.b.p.h(finderCommentInfo2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            this.tAp.tAi.a(this.tAr.feedObject, finderCommentInfo2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165372);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class ar extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ FinderCollapsibleTextView tAB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ar(FinderCollapsibleTextView finderCollapsibleTextView) {
            super(1);
            this.tAB = finderCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(242850);
            if (bool.booleanValue()) {
                FinderCollapsibleTextView finderCollapsibleTextView = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams = finderCollapsibleTextView.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242850);
                    throw tVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R.id.h71);
            } else {
                FinderCollapsibleTextView finderCollapsibleTextView2 = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView2, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams2 = finderCollapsibleTextView2.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242850);
                    throw tVar2;
                }
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(16);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242850);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class as extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ FinderCollapsibleTextView tAB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        as(FinderCollapsibleTextView finderCollapsibleTextView) {
            super(1);
            this.tAB = finderCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(242851);
            if (bool.booleanValue()) {
                FinderCollapsibleTextView finderCollapsibleTextView = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams = finderCollapsibleTextView.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242851);
                    throw tVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R.id.h71);
            } else {
                FinderCollapsibleTextView finderCollapsibleTextView2 = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView2, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams2 = finderCollapsibleTextView2.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242851);
                    throw tVar2;
                }
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(16);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242851);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.b<c.a<atp>, Boolean> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ boolean tAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(BaseFinderFeed baseFinderFeed, boolean z, com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tAr = baseFinderFeed;
            this.tAy = z;
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(c.a<atp> aVar) {
            int i2;
            String str;
            String str2;
            int i3 = 0;
            String str3 = null;
            AppMethodBeat.i(242817);
            c.a<atp> aVar2 = aVar;
            this.tAr.doingRelReq = false;
            if (aVar2 != null && aVar2.errType == 0 && aVar2.errCode == 0) {
                aqv aqv = new aqv();
                aqv.tbD = ((atp) aVar2.iLC).object;
                aqv.lastBuffer = ((atp) aVar2.iLC).lastBuffer;
                aqv.continueFlag = ((atp) aVar2.iLC).continueFlag;
                String str4 = ((atp) aVar2.iLC).LAH;
                if (str4 == null) {
                    str4 = "";
                }
                aqv.dQx = str4;
                Log.i("Finder.FeedConvert", "CgiFinderGetFeedRelList succ, attach to item and post event, " + this.tAr.lT() + ", " + aqv.tbD.size());
                if (!aqv.tbD.isEmpty()) {
                    if (this.tAr.attachFavInfo == null) {
                        this.tAr.attachFavInfo = new com.tencent.mm.plugin.finder.storage.k(aqv);
                        com.tencent.mm.plugin.finder.storage.k kVar = this.tAr.attachFavInfo;
                        if (kVar != null) {
                            kVar.vDG = this.tAy;
                        }
                    } else {
                        com.tencent.mm.plugin.finder.storage.k kVar2 = this.tAr.attachFavInfo;
                        if (kVar2 != null) {
                            kVar2.vDI = aqv;
                        }
                    }
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    Context context = this.qhp.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                    long lT = this.tAr.lT();
                    if (fH != null) {
                        i2 = fH.tCE;
                    } else {
                        i2 = 0;
                    }
                    if (fH != null) {
                        str = fH.sGE;
                    } else {
                        str = null;
                    }
                    if (fH != null) {
                        str2 = fH.sGQ;
                    } else {
                        str2 = null;
                    }
                    if (fH != null) {
                        str3 = fH.sessionId;
                    }
                    com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
                    long lT2 = this.tAr.lT();
                    if (fH != null) {
                        i3 = fH.tCE;
                    }
                    com.tencent.mm.plugin.finder.report.k.a(lT, 1, i2, str, str2, str3, com.tencent.mm.plugin.finder.report.k.G(lT2, i3), this.tAy ? 1 : 2);
                }
            } else {
                this.tAr.attachFavInfo = null;
            }
            hn hnVar = new hn();
            hnVar.dLW.id = this.tAr.lT();
            hnVar.dLW.type = 6;
            Boolean valueOf = Boolean.valueOf(EventCenter.instance.publish(hnVar));
            AppMethodBeat.o(242817);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(BaseFinderFeed baseFinderFeed, com.tencent.mm.view.recyclerview.h hVar) {
            super(1);
            this.tAr = baseFinderFeed;
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(242818);
            boolean booleanValue = bool.booleanValue();
            this.tAr.isContentCollapsed = booleanValue;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                if (!booleanValue) {
                    com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b(fH);
                    if (b2 != null) {
                        b2.cZR().El(this.tAr.lT());
                    }
                } else {
                    com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b(fH);
                    if (b3 != null) {
                        b3.cZR().Em(this.tAr.lT());
                    }
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242818);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ FinderCollapsibleTextView tAB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderCollapsibleTextView finderCollapsibleTextView) {
            super(1);
            this.tAB = finderCollapsibleTextView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(242821);
            if (bool.booleanValue()) {
                FinderCollapsibleTextView finderCollapsibleTextView = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams = finderCollapsibleTextView.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242821);
                    throw tVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R.id.h71);
            } else {
                FinderCollapsibleTextView finderCollapsibleTextView2 = this.tAB;
                kotlin.g.b.p.g(finderCollapsibleTextView2, "collapseTextLayout");
                ViewGroup.LayoutParams layoutParams2 = finderCollapsibleTextView2.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(242821);
                    throw tVar2;
                }
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(16);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242821);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, String str) {
        boolean z2 = true;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drN()) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drP()) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.h(baseFinderFeed) && !baseFinderFeed.feedObject.isPostFinish() && (baseFinderFeed.feedObject.isPostFailed() || (!baseFinderFeed.feedObject.isPostFinish() && baseFinderFeed.feedObject.getPostInfo().Mpc < 100))) {
                    z2 = false;
                }
                if (z2) {
                    Intent intent = new Intent();
                    intent.putExtra("key_topic_type", 2);
                    intent.putExtra("key_ref_object_id", baseFinderFeed.feedObject.getId());
                    intent.putExtra("key_topic_title", str);
                    intent.putExtra("key_topic_poi_location", baseFinderFeed.feedObject.getLocation().toByteArray());
                    intent.putExtra("KEY_TAB_TYPE", lVar.dLS);
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
                Log.i("Finder.FeedConvert", "click poi but isPostOk false");
                return;
            }
        }
        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
        Context context4 = hVar.getContext();
        kotlin.g.b.p.g(context4, "holder.context");
        com.tencent.mm.plugin.finder.utils.y.a(context4, baseFinderFeed.feedObject.getLocation());
    }

    public static final /* synthetic */ void a(BaseFinderFeed baseFinderFeed, boolean z2) {
        if (baseFinderFeed.feedObject.getId() != 0) {
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            if (c.a.FT(baseFinderFeed.feedObject.getId())) {
                hg hgVar = new hg();
                hgVar.dLJ.id = baseFinderFeed.feedObject.getId();
                EventCenter.instance.publish(hgVar);
                Log.i("Finder.FeedConvert", "deleteItem by id " + baseFinderFeed.feedObject.getId());
                return;
            }
        }
        if (baseFinderFeed.feedObject.getLocalId() >= 0) {
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            FinderItem FS = c.a.FS(baseFinderFeed.feedObject.getLocalId());
            c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.FV(baseFinderFeed.feedObject.getLocalId());
            if (z2) {
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
            } else {
                r.d dVar3 = r.d.vhx;
                r.d.om(baseFinderFeed.feedObject.isLongVideo());
                if (baseFinderFeed.feedObject.isLongVideo()) {
                    r.d dVar4 = r.d.vhx;
                    r.d.dox();
                }
            }
            hg hgVar2 = new hg();
            hgVar2.dLJ.localId = baseFinderFeed.feedObject.getLocalId();
            EventCenter.instance.publish(hgVar2);
            Log.i("Finder.FeedConvert", "deleteItem by localId " + baseFinderFeed.feedObject.getLocalId() + ", posting:" + z2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.tencent.mm.plugin.finder.convert.l<T extends com.tencent.mm.plugin.finder.model.BaseFinderFeed> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z2, List list) {
        a(hVar, (BaseFinderFeed) aVar, i2, i3, z2, (List<Object>) list);
    }

    public /* synthetic */ l(com.tencent.mm.plugin.finder.feed.i iVar, boolean z2) {
        this(iVar, z2, 0);
    }

    public l(com.tencent.mm.plugin.finder.feed.i iVar, boolean z2, int i2) {
        boolean z3 = true;
        kotlin.g.b.p.h(iVar, "contract");
        this.tAi = iVar;
        this.tAj = z2;
        this.dLS = i2;
        this.tzW = 10000;
        this.tzX = 10001;
        this.tzY = 10002;
        this.tzZ = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAa = com.tencent.mm.plugin.finder.storage.c.dtV().value().intValue();
        this.tAb = new HashSet<>();
        this.tAe = new FinderFeedConvert$uiLifecycleObserver$1(this);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAf = com.tencent.mm.plugin.finder.storage.c.dsp().value().intValue() == 1;
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAg = com.tencent.mm.plugin.finder.storage.c.dsq().value().intValue() != 1 ? false : z3;
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.tAh = com.tencent.mm.plugin.finder.storage.c.dvx().value().intValue();
        this.rect = new Rect();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$Companion;", "", "()V", "TAG", "", "payloadsAttachInfo", "", "payloadsCommentEdu", "payloadsExposeInfoType", "payloadsFavInfoType", "payloadsLiveNotice", "payloadsLiveStatus", "payloadsPlayMusic", "payloadsPostEnd", "payloadsProgressType", "payloadsRefreshAddForward", "payloadsRefreshComment", "payloadsRefreshForward", "payloadsRefreshLike", "payloadsRefreshOpCount", "payloadsStopMusic", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        this.tAc = new p(hVar);
        View Mn = hVar.Mn(R.id.d8o);
        z.f fVar = new z.f();
        fVar.SYG = (T) new com.tencent.mm.ui.ak(Mn);
        kotlin.g.b.p.g(Mn, "footerTouchDelegateView");
        Mn.setTouchDelegate(fVar.SYG);
        ImageView imageView = (ImageView) hVar.Mn(R.id.x1);
        View.OnClickListener onClickListener = this.tAc;
        if (onClickListener == null) {
            kotlin.g.b.p.btv("onAvatarClickListener");
        }
        imageView.setOnClickListener(onClickListener);
        imageView.post(new u(imageView));
        TextView textView = (TextView) hVar.Mn(R.id.fzc);
        View.OnClickListener onClickListener2 = this.tAc;
        if (onClickListener2 == null) {
            kotlin.g.b.p.btv("onAvatarClickListener");
        }
        textView.setOnClickListener(onClickListener2);
        kotlin.g.b.p.g(textView, "nickTv");
        com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        textView.setTextColor(context.getResources().getColor(R.color.fr));
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        ((WeImageView) hVar.Mn(R.id.fjv)).setIconColor(context2.getResources().getColor(R.color.fo));
        HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) hVar.Mn(R.id.fbg);
        if (hardTouchableLayout != null) {
            hardTouchableLayout.setEnableScale(false);
            hardTouchableLayout.setOnInterceptTouchEventCallback(new v());
            hardTouchableLayout.setOnDoubleClickListener(new n(hardTouchableLayout, this, hVar));
            hardTouchableLayout.setOnSingleClickListener(new o(hardTouchableLayout, this, hVar));
            Context context3 = hardTouchableLayout.getContext();
            kotlin.g.b.p.g(context3, "mediaContainer.context");
            int dimension = (int) context3.getResources().getDimension(R.dimen.cq);
            if (this.tAa == 0) {
                ViewGroup.LayoutParams layoutParams = hardTouchableLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                ((FrameLayout.LayoutParams) layoutParams).topMargin = dimension;
                View Mn2 = hVar.Mn(R.id.ceg);
                kotlin.g.b.p.g(Mn2, LocaleUtil.ITALIAN);
                Mn2.setBackground(null);
                Mn2.setTag(Boolean.FALSE);
            } else if (this.tAa == 1) {
                ViewGroup.LayoutParams layoutParams2 = hardTouchableLayout.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
                View Mn3 = hVar.Mn(R.id.ceg);
                kotlin.g.b.p.g(Mn3, LocaleUtil.ITALIAN);
                Mn3.setBackground(hardTouchableLayout.getResources().getDrawable(R.drawable.w2));
                Mn3.setTag(Boolean.TRUE);
            }
        }
        z.f fVar2 = new z.f();
        fVar2.SYG = null;
        z.f fVar3 = new z.f();
        fVar3.SYG = (T) hVar.Mn(R.id.xk);
        fVar3.SYG.setOnTouchListener(new w(fVar2));
        fVar3.SYG.setOnClickListener(new x(this, hVar));
        fVar3.SYG.setOnLongClickListener(new y(this, hVar));
        fVar3.SYG.setHapticFeedbackEnabled(false);
        fVar3.SYG.post(new z(fVar3, hVar, fVar));
        z.f fVar4 = new z.f();
        fVar4.SYG = (T) hVar.Mn(R.id.b8z);
        fVar4.SYG.post(new aa(fVar4, hVar, fVar));
        FinderCollapsibleTextView finderCollapsibleTextView = (FinderCollapsibleTextView) hVar.Mn(R.id.ik5);
        finderCollapsibleTextView.getContentTextView().setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(finderCollapsibleTextView.getContentTextView(), new com.tencent.mm.pluginsdk.ui.span.o(hVar.getContext())));
        z.f fVar5 = new z.f();
        fVar5.SYG = (T) hVar.Mn(R.id.ccn);
        T t2 = fVar5.SYG;
        if (t2 != null) {
            t2.setOnClickListener(new ab(this, hVar));
        }
        T t3 = fVar5.SYG;
        if (t3 != null) {
            t3.post(new q(hVar, fVar5, fVar));
        }
        z.f fVar6 = new z.f();
        fVar6.SYG = (T) hVar.Mn(R.id.hph);
        T t4 = fVar6.SYG;
        if (t4 != null) {
            t4.setOnClickListener(new r(this, hVar));
        }
        T t5 = fVar6.SYG;
        if (t5 != null) {
            t5.post(new s(hVar, fVar6, fVar));
        }
        hVar.Mn(R.id.fjv).setOnLongClickListener(new t(hVar));
        View Mn4 = hVar.Mn(R.id.b92);
        kotlin.g.b.p.g(Mn4, "holder.getView<View>(R.id.comment_layout)");
        Mn4.setClickable(false);
        b<T> bVar = new b<>(this, hVar);
        hVar.aus.addOnAttachStateChangeListener(bVar);
        bVar.alive();
        this.tAb.add(bVar);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        p(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(242824);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
            String name = this.qhp.getContext().getClass().getName();
            kotlin.g.b.p.g(name, "holder.context.javaClass.name");
            if ((kotlin.g.b.p.j(name, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI") || kotlin.g.b.p.j(name, "FinderProfileTimeLineUI")) && (baseFinderFeed instanceof BaseFinderFeed)) {
                com.tencent.mm.plugin.finder.report.live.k.vkd.a(baseFinderFeed, (long) this.qhp.lR(), s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, "1");
            }
            if (i2 == 1 || i2 == 8) {
                Log.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(3, baseFinderFeed.lT(), i2, 1, baseFinderFeed.feedObject.getUserName());
                Context context2 = this.qhp.getContext();
                if (context2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(242824);
                    throw tVar;
                }
                ((Activity) context2).finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(242824);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("finder_username", baseFinderFeed.feedObject.getUserName());
            intent.putExtra("finder_read_feed_id", baseFinderFeed.feedObject.getId());
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context3 = this.qhp.getContext();
            kotlin.g.b.p.g(context3, "holder.context");
            FinderReporterUIC.a.a(context3, intent, baseFinderFeed.lT(), 1, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context4 = this.qhp.getContext();
            kotlin.g.b.p.g(context4, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context4, intent);
            if (this.qhp.getContext() instanceof MMActivity) {
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                Context context5 = this.qhp.getContext();
                if (context5 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(242824);
                    throw tVar2;
                }
                com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context5).get(FinderReporterUIC.class));
                if (b2 != null) {
                    b2.cZR().Eq(baseFinderFeed.lT());
                }
            }
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(3, baseFinderFeed.lT(), i2, 1, baseFinderFeed.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242824);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class u implements Runnable {
        final /* synthetic */ ImageView tAG;

        u(ImageView imageView) {
            this.tAG = imageView;
        }

        public final void run() {
            AppMethodBeat.i(242829);
            Rect rect = new Rect();
            this.tAG.getHitRect(rect);
            rect.inset(rect.width() * -2, -rect.width());
            ImageView imageView = this.tAG;
            kotlin.g.b.p.g(imageView, "avatarView");
            ViewParent parent = imageView.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(242829);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.tAG));
            AppMethodBeat.o(242829);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class v implements HardTouchableLayout.c {
        v() {
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.c
        public final boolean S(MotionEvent motionEvent) {
            AppMethodBeat.i(242830);
            kotlin.g.b.p.h(motionEvent, "event");
            AppMethodBeat.o(242830);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class n implements HardTouchableLayout.b {
        final /* synthetic */ HardTouchableLayout tAC;
        final /* synthetic */ l tAp;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        n(HardTouchableLayout hardTouchableLayout, l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAC = hardTouchableLayout;
            this.tAp = lVar;
            this.tzq = hVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242822);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            Log.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + ((BaseFinderFeed) this.tzq.hgv()));
            this.tAp.a(this.tzq, this.tAC);
            AppMethodBeat.o(242822);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class o implements HardTouchableLayout.g {
        final /* synthetic */ HardTouchableLayout tAC;
        final /* synthetic */ l tAp;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        o(HardTouchableLayout hardTouchableLayout, l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAC = hardTouchableLayout;
            this.tAp = lVar;
            this.tzq = hVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242823);
            kotlin.g.b.p.h(view, "view");
            Log.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + ((BaseFinderFeed) this.tzq.hgv()));
            this.tAp.a(this.tzq, this.tAC, ((BaseFinderFeed) this.tzq.hgv()).feedObject.getFeedObject());
            AppMethodBeat.o(242823);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class w implements View.OnTouchListener {
        final /* synthetic */ z.f tAH;

        w(z.f fVar) {
            this.tAH = fVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242831);
            kotlin.g.b.p.g(motionEvent, "event");
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                view.removeCallbacks(this.tAH.SYG);
            }
            AppMethodBeat.o(242831);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class x implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        x(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165361);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("Finder.FeedConvert", "onClickLike:" + this.qhp.lR());
            this.tAp.a((l) this.qhp, (com.tencent.mm.view.recyclerview.h) 1, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165361);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class y implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        y(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(242834);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtQ().value().intValue() == 1) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                    Log.i("Finder.FeedConvert", "onLongClick Private Like:" + this.qhp.lR());
                    WeImageView weImageView = (WeImageView) this.qhp.Mn(R.id.dts);
                    kotlin.g.b.p.g(weImageView, "awesomeIv");
                    if ((weImageView.getTag() instanceof Integer) && kotlin.g.b.p.j(weImageView.getTag(), 0)) {
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 1, true);
                        eVar.setTitleView(com.tencent.mm.ui.aa.jQ(this.qhp.getContext()).inflate(R.layout.aip, (ViewGroup) null));
                        eVar.a(new o.f(this) {
                            /* class com.tencent.mm.plugin.finder.convert.l.y.AnonymousClass1 */
                            final /* synthetic */ y tAI;

                            {
                                this.tAI = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                AppMethodBeat.i(242832);
                                kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
                                if (mVar.gKQ()) {
                                    int i2 = this.tAI.tAp.tzZ;
                                    Context context = this.tAI.qhp.getContext();
                                    kotlin.g.b.p.g(context, "holder.context");
                                    mVar.d(i2, context.getResources().getString(R.string.d6_));
                                }
                                AppMethodBeat.o(242832);
                            }
                        });
                        eVar.a(new o.g(this) {
                            /* class com.tencent.mm.plugin.finder.convert.l.y.AnonymousClass2 */
                            final /* synthetic */ y tAI;

                            {
                                this.tAI = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(242833);
                                kotlin.g.b.p.g(menuItem, "menuItem");
                                if (menuItem.getItemId() == this.tAI.tAp.tzZ) {
                                    this.tAI.tAp.a((l) this.tAI.qhp, (com.tencent.mm.view.recyclerview.h) 1, true);
                                }
                                AppMethodBeat.o(242833);
                            }
                        });
                        eVar.dGm();
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242834);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class z implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.f tAE;
        final /* synthetic */ z.f tAJ;

        z(z.f fVar, com.tencent.mm.view.recyclerview.h hVar, z.f fVar2) {
            this.tAJ = fVar;
            this.qhp = hVar;
            this.tAE = fVar2;
        }

        public final void run() {
            AppMethodBeat.i(242835);
            Rect rect = new Rect();
            this.tAJ.SYG.getHitRect(rect);
            int aH = com.tencent.mm.cb.a.aH(this.qhp.getContext(), R.dimen.ct);
            rect.inset(-aH, -aH);
            T t = this.tAJ.SYG;
            kotlin.g.b.p.g(t, "awesomeView");
            this.tAE.SYG.a(new com.tencent.mm.ui.al(rect, t));
            AppMethodBeat.o(242835);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class aa implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.f tAE;
        final /* synthetic */ z.f tAK;

        aa(z.f fVar, com.tencent.mm.view.recyclerview.h hVar, z.f fVar2) {
            this.tAK = fVar;
            this.qhp = hVar;
            this.tAE = fVar2;
        }

        public final void run() {
            AppMethodBeat.i(242836);
            Rect rect = new Rect();
            this.tAK.SYG.getHitRect(rect);
            int aH = com.tencent.mm.cb.a.aH(this.qhp.getContext(), R.dimen.ct);
            rect.inset(-aH, -aH);
            T t = this.tAK.SYG;
            kotlin.g.b.p.g(t, "commentView");
            this.tAE.SYG.a(new com.tencent.mm.ui.al(rect, t));
            AppMethodBeat.o(242836);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ab implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        ab(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242837);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("Finder.FeedConvert", "onClickFav:" + this.qhp.lR());
            l.a(this.tAp, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242837);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class q implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.f tAD;
        final /* synthetic */ z.f tAE;

        q(com.tencent.mm.view.recyclerview.h hVar, z.f fVar, z.f fVar2) {
            this.qhp = hVar;
            this.tAD = fVar;
            this.tAE = fVar2;
        }

        public final void run() {
            AppMethodBeat.i(242825);
            int aH = com.tencent.mm.cb.a.aH(this.qhp.getContext(), R.dimen.ct);
            Rect rect = new Rect();
            this.tAD.SYG.getHitRect(rect);
            rect.inset(-aH, -aH);
            this.tAE.SYG.a(new com.tencent.mm.ui.al(rect, this.tAD.SYG));
            AppMethodBeat.o(242825);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class r implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        r(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242826);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("Finder.FeedConvert", "onClickShare:" + this.qhp.lR());
            this.tAp.c(this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242826);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    static final class s implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.f tAE;
        final /* synthetic */ z.f tAF;

        s(com.tencent.mm.view.recyclerview.h hVar, z.f fVar, z.f fVar2) {
            this.qhp = hVar;
            this.tAF = fVar;
            this.tAE = fVar2;
        }

        public final void run() {
            AppMethodBeat.i(242827);
            int aH = com.tencent.mm.cb.a.aH(this.qhp.getContext(), R.dimen.ct);
            Rect rect = new Rect();
            this.tAF.SYG.getHitRect(rect);
            rect.inset(-aH, -aH);
            this.tAE.SYG.a(new com.tencent.mm.ui.al(rect, this.tAF.SYG));
            AppMethodBeat.o(242827);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class t implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        t(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            com.tencent.mm.plugin.finder.loader.s sVar;
            FinderVideoLayout.b playInfo;
            AppMethodBeat.i(242828);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
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
                AppMethodBeat.o(242828);
                throw tVar;
            }
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            kotlin.g.b.p.g(baseFinderFeed, "item");
            ((FinderDebugUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderDebugUIC.class)).a(context2, baseFinderFeed, sVar, this.qhp);
            this.qhp.aus.requestLayout();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242828);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$1"})
    public static final class bk implements View.OnClickListener {
        final /* synthetic */ FinderItem $item$inlined;
        final /* synthetic */ azs UHS;
        final /* synthetic */ String UHT;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        bk(azs azs, com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
            this.UHS = azs;
            this.tzq = hVar;
            this.$item$inlined = finderItem;
            this.UHT = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260196);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("key_activity_id", this.UHS.twd);
            intent.putExtra("key_activity_name", this.UHS.eventName);
            intent.putExtra("key_nick_name", this.UHS.LJx);
            intent.putExtra("key_feed_ref_id", this.$item$inlined.getFeedObject().id);
            Log.i("Finder.FeedConvert", "eventTopicId :" + this.UHS.twd + " eventName:" + this.UHS.eventName + " nickName:" + this.UHT + " refId: " + this.$item$inlined.getFeedObject().id);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.tzq.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260196);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.utils.a.aa((MMActivity) context, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260196);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.mm.plugin.finder.convert.l<T extends com.tencent.mm.plugin.finder.model.BaseFinderFeed> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void a(com.tencent.mm.view.recyclerview.h hVar, int i2, boolean z2) {
        com.tencent.mm.plugin.finder.event.a b2;
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(baseFinderFeed.feedObject.getFeedObject());
        boolean booleanValue = m2.first.booleanValue();
        boolean booleanValue2 = m2.second.booleanValue();
        boolean z3 = !booleanValue;
        if (z3) {
            View Mn = hVar.Mn(R.id.dts);
            WeImageView weImageView = (WeImageView) hVar.Mn(R.id.ebe);
            if (weImageView != null) {
                com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
                String str = Lj == null ? "" : com.tencent.mm.ui.ao.isDarkMode() ? Lj.LJE : Lj.LJF;
                if (z2) {
                    a(weImageView, Lj);
                } else {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                        Context context = hVar.getContext();
                        Context context2 = hVar.getContext();
                        kotlin.g.b.p.g(context2, "holder.context");
                        weImageView.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.finder_filled_like_lock, context2.getResources().getColor(R.color.Red_90)));
                    } else {
                        String str2 = str;
                        if (!(str2 == null || str2.length() == 0)) {
                            Drawable drawable = weImageView.getDrawable();
                            if (drawable != null) {
                                drawable.clearColorFilter();
                            }
                            weImageView.setClearColorFilter(true);
                            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                        } else {
                            Context context3 = hVar.getContext();
                            Context context4 = hVar.getContext();
                            kotlin.g.b.p.g(context4, "holder.context");
                            weImageView.setImageDrawable(com.tencent.mm.ui.ar.m(context3, R.raw.icon_filled_awesome, context4.getResources().getColor(R.color.Red_90)));
                        }
                    }
                }
                com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                com.tencent.mm.plugin.finder.view.animation.c.a((View) weImageView, 0.0f, (MotionEvent) null, false, 30);
                com.tencent.mm.plugin.finder.view.animation.c cVar2 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                kotlin.g.b.p.g(Mn, "likeIcon");
                com.tencent.mm.plugin.finder.view.animation.c.ei(Mn);
            }
            if (i2 == 1 || i2 == 2 || z2) {
                a(hVar);
            }
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dtO() > 0) {
                    a(hVar, false);
                }
            } else if (!z2) {
                com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dux().value().intValue() == 1) {
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dux().value().intValue() == 1) {
                        baseFinderFeed.showCommentEdu = true;
                        kotlin.g.b.p.g(baseFinderFeed, "item");
                        b(hVar, baseFinderFeed, 1);
                    }
                }
                boolean z4 = baseFinderFeed.triggerConfig.vDV;
                com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dud().value().intValue() == 1) {
                    z4 = true;
                }
                kotlin.g.b.p.g(baseFinderFeed, "item");
                a(baseFinderFeed, hVar, z4, true, false);
            }
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dux().value().intValue() == 1) {
                baseFinderFeed.showCommentEdu = false;
                kotlin.g.b.p.g(baseFinderFeed, "item");
                b(hVar, baseFinderFeed, 1);
            }
        }
        boolean z5 = z3 ? false : booleanValue2;
        com.tencent.mm.plugin.finder.feed.i iVar = this.tAi;
        kotlin.g.b.p.g(baseFinderFeed, "item");
        iVar.a(baseFinderFeed, z3, z2, i2, z5);
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(baseFinderFeed, z3, z2, com.tencent.mm.plugin.finder.upload.action.j.vUv.n(baseFinderFeed.feedObject.getFeedObject()), hVar);
        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.v(baseFinderFeed) && !z2) {
            if (z3) {
                baseFinderFeed.feedObject.getFeedObject().incFriendLikeCount++;
            } else if (!booleanValue2) {
                FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                feedObject.incFriendLikeCount--;
            }
        }
        a((l) z3, (boolean) hVar, (com.tencent.mm.view.recyclerview.h) baseFinderFeed, (BaseFinderFeed) false);
        hn hnVar = new hn();
        hnVar.dLW.id = baseFinderFeed.lT();
        hnVar.dLW.type = 4;
        hnVar.dLW.dLZ = (!z3 || !z2) ? z3 ? 1 : 0 : 2;
        EventCenter.instance.publish(hnVar);
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        Context context5 = hVar.getContext();
        kotlin.g.b.p.g(context5, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context5);
        if (fH != null && (b2 = FinderReporterUIC.b(fH)) != null) {
            a.b cZR = b2.cZR();
            if (z3) {
                cZR.Eo(baseFinderFeed.lT());
            } else {
                cZR.Ep(baseFinderFeed.lT());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void a(com.tencent.mm.view.recyclerview.h hVar) {
        hVar.aus.performHapticFeedback(0, 3);
    }

    private final void a(T t2, com.tencent.mm.view.recyclerview.h hVar, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        boolean z6 = false;
        if ((!z2 || !z3) && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED)) {
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            if (fk(context)) {
                com.tencent.mm.ui.base.u.makeText(hVar.getContext(), "enable:" + z2 + ", enableOnClick:" + z3, 0).show();
            }
        }
        StringBuilder append = new StringBuilder("CgiFinderGetFeedRelList fromFav:").append(z4).append(", ").append(t2.doingRelReq).append(", ");
        if (t2.feedObject.getFoldedLayout() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        StringBuilder append2 = append.append(z5).append(", ");
        if (t2.attachFavInfo == null) {
            z6 = true;
        }
        Log.i("Finder.FeedConvert", append2.append(z6).append(", ").append(this.dLS).append(", ").append(z2).append(", enableOnClick:").append(z3).toString());
        if (z2 && !t2.doingRelReq && t2.attachFavInfo == null) {
            Context context2 = hVar.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            if (fk(context2)) {
                t2.doingRelReq = true;
                if (z3) {
                    t2.attachFavInfo = new com.tencent.mm.plugin.finder.storage.k(null);
                    com.tencent.mm.plugin.finder.storage.k kVar = t2.attachFavInfo;
                    if (kVar != null) {
                        kVar.vDG = z4;
                    }
                    c(hVar, t2);
                }
                long j2 = t2.feedObject.field_id;
                String objectNonceId = t2.feedObject.getObjectNonceId();
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context3 = hVar.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                com.tencent.mm.ac.d.b(new com.tencent.mm.plugin.finder.cgi.l(j2, objectNonceId, fH != null ? fH.dIx() : null).aYI(), new f(t2, z4, hVar));
            }
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void b(com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(hVar, "holder");
        super.b(hVar);
    }

    public final void c(com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(hVar, "holder");
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.u(baseFinderFeed.feedObject.getFeedObject())) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            String string = hVar.getContext().getString(R.string.d61);
            kotlin.g.b.p.g(string, "holder.context.getString…finder_private_ban_share)");
            com.tencent.mm.plugin.finder.utils.y.aF(context, string);
        } else if (baseFinderFeed.feedObject.isPrivate()) {
            com.tencent.mm.ui.base.u.a(hVar.getContext(), hVar.getContext().getString(R.string.d67), bd.tBn);
        } else {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(hVar.getContext(), 1, false);
            eVar.a(new be(this));
            eVar.a(new bf(this, baseFinderFeed));
            eVar.b(new bg(hVar));
            eVar.dGm();
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    public static final class bd implements u.b {
        public static final bd tBn = new bd();

        static {
            AppMethodBeat.i(242861);
            AppMethodBeat.o(242861);
        }

        bd() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            TextView textView;
            AppMethodBeat.i(242860);
            if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                AppMethodBeat.o(242860);
                return;
            }
            textView.setTextSize(1, 14.0f);
            AppMethodBeat.o(242860);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class be implements o.f {
        final /* synthetic */ l tAp;

        be(l lVar) {
            this.tAp = lVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(242862);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(this.tAp.tzX, R.string.d9q);
                mVar.kV(this.tAp.tzY, R.string.d9r);
            }
            AppMethodBeat.o(242862);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class bf implements o.g {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        bf(l lVar, BaseFinderFeed baseFinderFeed) {
            this.tAp = lVar;
            this.tAr = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(242863);
            kotlin.g.b.p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.tAp.tzX) {
                this.tAp.tAi.a(this.tAr.feedObject);
                AppMethodBeat.o(242863);
                return;
            }
            if (itemId == this.tAp.tzY) {
                com.tencent.mm.plugin.finder.feed.i iVar = this.tAp.tAi;
                BaseFinderFeed baseFinderFeed = this.tAr;
                kotlin.g.b.p.g(baseFinderFeed, "item");
                iVar.k(baseFinderFeed);
            }
            AppMethodBeat.o(242863);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onDismiss"})
    public static final class bg implements e.b {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        bg(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            bbn bbn;
            AppMethodBeat.i(242864);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                bbn = fH.dIx();
            } else {
                bbn = null;
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(((BaseFinderFeed) this.qhp.hgv()).feedObject.getId(), 1, 3, "", bbn, 0, (FinderItem) null, 96);
            AppMethodBeat.o(242864);
        }
    }

    private static int a(boolean z2, boolean z3, BaseFinderFeed baseFinderFeed) {
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
            if (z2) {
                return R.raw.finder_filled_like_lock;
            }
            return R.raw.finder_outlined_like_lock;
        } else if (!z2) {
            return R.raw.icon_outlined_awesome;
        } else {
            if (!z3) {
                return R.raw.icon_filled_awesome;
            }
            return R.raw.finder_filled_like_lock;
        }
    }

    private static void a(BaseFinderFeed baseFinderFeed, boolean z2, boolean z3, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.o oVar;
        String str;
        String str2;
        String str3;
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.dts);
        if (z2) {
            if (z3) {
                kotlin.g.b.p.g(weImageView, "awesomeIv");
                weImageView.setTag(2);
            } else {
                kotlin.g.b.p.g(weImageView, "awesomeIv");
                weImageView.setTag(1);
            }
            Integer valueOf = Integer.valueOf(a(true, z3, baseFinderFeed));
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            oVar = new kotlin.o(valueOf, Integer.valueOf(context.getResources().getColor(R.color.Red_90)));
        } else {
            kotlin.g.b.p.g(weImageView, "awesomeIv");
            weImageView.setTag(0);
            Integer valueOf2 = Integer.valueOf(a(false, z3, baseFinderFeed));
            Context context2 = hVar.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            oVar = new kotlin.o(valueOf2, Integer.valueOf(context2.getResources().getColor(R.color.fo)));
        }
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean i3 = com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact);
        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
        if (z3 && z2 && !i3) {
            a(weImageView, Lj);
        } else if (Lj == null || i3 || z3) {
            weImageView.setImageResource(intValue);
            weImageView.setIconColor(intValue2);
        } else {
            if (z2) {
                str = com.tencent.mm.ui.ao.isDarkMode() ? Lj.LJE : Lj.LJF;
            } else {
                str = com.tencent.mm.ui.ao.isDarkMode() ? Lj.LJG : Lj.LJH;
            }
            Drawable drawable = weImageView.getDrawable();
            if (drawable != null) {
                drawable.clearColorFilter();
            }
            weImageView.setClearColorFilter(true);
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
        }
        TextView textView = (TextView) hVar.Mn(R.id.cf2);
        if (i2 > 0) {
            String gm = com.tencent.mm.plugin.finder.utils.k.gm(2, i2);
            kotlin.g.b.p.g(gm, "FinderFormatUtil.formatN…cene.SCENE_WX, likeCount)");
            kotlin.g.b.p.g(textView, "likeTv");
            com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
            str3 = gm;
        } else {
            com.tencent.mm.plugin.finder.storage.logic.g gVar2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj2 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
            if (Lj2 != null) {
                String str4 = Lj2.LJI;
                if (!(str4 == null || str4.length() == 0)) {
                    String str5 = Lj2.LJI;
                    str2 = str5 == null ? "" : str5;
                    kotlin.g.b.p.g(textView, "likeTv");
                    com.tencent.mm.ui.ao.b(textView.getPaint());
                    str3 = str2;
                }
            }
            String string = hVar.getContext().getString(R.string.cps);
            kotlin.g.b.p.g(string, "holder.context.getString…g.finder_like_count_text)");
            str2 = string;
            kotlin.g.b.p.g(textView, "likeTv");
            com.tencent.mm.ui.ao.b(textView.getPaint());
            str3 = str2;
        }
        textView.setText(str3);
    }

    private static void a(WeImageView weImageView, azu azu) {
        String str = azu != null ? azu.LJJ : null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Context context = weImageView.getContext();
            Context context2 = weImageView.getContext();
            kotlin.g.b.p.g(context2, "imageView.context");
            weImageView.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.icons_filled_like_group, context2.getResources().getColor(R.color.Red_90)));
            return;
        }
        Drawable drawable = weImageView.getDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();
        }
        weImageView.setClearColorFilter(true);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
    }

    private static void a(boolean z2, com.tencent.mm.view.recyclerview.h hVar, boolean z3) {
        kotlin.o oVar;
        boolean z4;
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.gkt);
        if (z2) {
            if (z3) {
                if (weImageView != null) {
                    weImageView.setTag(2);
                }
            } else if (weImageView != null) {
                weImageView.setTag(1);
            }
            Object hgv = hVar.hgv();
            kotlin.g.b.p.g(hgv, "holder.getAssociatedObject()");
            Integer valueOf = Integer.valueOf(a(true, z3, (BaseFinderFeed) hgv));
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            oVar = new kotlin.o(valueOf, Integer.valueOf(context.getResources().getColor(R.color.Red_90)));
        } else {
            if (weImageView != null) {
                weImageView.setTag(0);
            }
            Object hgv2 = hVar.hgv();
            kotlin.g.b.p.g(hgv2, "holder.getAssociatedObject()");
            Integer valueOf2 = Integer.valueOf(a(false, z3, (BaseFinderFeed) hgv2));
            Context context2 = hVar.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            oVar = new kotlin.o(valueOf2, Integer.valueOf(context2.getResources().getColor(R.color.fo)));
        }
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        if (weImageView != null) {
            com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(baseFinderFeed.feedObject.getFeedObject().objectType);
            String str = Lj == null ? "" : com.tencent.mm.ui.ao.isDarkMode() ? Lj.LJG : Lj.LJH;
            if (!z3 || !z2) {
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!com.tencent.mm.plugin.finder.utils.y.dnv()) {
                        Drawable drawable = weImageView.getDrawable();
                        if (drawable != null) {
                            drawable.clearColorFilter();
                        }
                        weImageView.setClearColorFilter(true);
                        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                        return;
                    }
                }
                weImageView.setImageResource(intValue);
                weImageView.setIconColor(intValue2);
                return;
            }
            a(weImageView, Lj);
        }
    }

    private static void a(com.tencent.mm.view.recyclerview.h hVar, boolean z2) {
        kotlin.g.b.p.h(hVar, "holder");
        z.f fVar = new z.f();
        fVar.SYG = (T) hVar.Mn(R.id.d1h);
        if (fVar.SYG == null) {
            fVar.SYG = (T) ((ViewStub) hVar.Mn(R.id.d1i)).inflate();
        }
        T t2 = fVar.SYG;
        kotlin.g.b.p.g(t2, "tips");
        if (t2.getVisibility() != 0) {
            if (z2) {
                TextView textView = (TextView) fVar.SYG.findViewById(R.id.d1g);
                if (textView != null) {
                    textView.setText(hVar.getContext().getString(R.string.d66));
                }
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                com.tencent.mm.plugin.finder.storage.c.KU(com.tencent.mm.plugin.finder.storage.c.dtP() - 1);
            } else {
                TextView textView2 = (TextView) fVar.SYG.findViewById(R.id.d1g);
                if (textView2 != null) {
                    textView2.setText(hVar.getContext().getString(R.string.d65));
                }
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                com.tencent.mm.plugin.finder.storage.c.KT(com.tencent.mm.plugin.finder.storage.c.dtO() - 1);
            }
            T t3 = fVar.SYG;
            kotlin.g.b.p.g(t3, "tips");
            t3.setVisibility(0);
            T t4 = fVar.SYG;
            kotlin.g.b.p.g(t4, "tips");
            t4.setAlpha(1.0f);
            fVar.SYG.animate().cancel();
            fVar.SYG.animate().alpha(0.0f).setDuration(300).setStartDelay(2000).setListener(new bi(fVar)).start();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showPrivateFeedLikeTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class bi implements Animator.AnimatorListener {
        final /* synthetic */ z.f tBq;

        bi(z.f fVar) {
            this.tBq = fVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(242866);
            T t = this.tBq.SYG;
            kotlin.g.b.p.g(t, "tips");
            t.setVisibility(8);
            AppMethodBeat.o(242866);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z2, com.tencent.mm.view.recyclerview.h hVar, T t2, boolean z3) {
        View Mn;
        View view;
        View Mn2;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCF()) {
            View Mn3 = hVar.Mn(R.id.ebq);
            if (Mn3 != null) {
                Mn3.setVisibility(8);
            }
            View Mn4 = hVar.Mn(R.id.d37);
            if (Mn4 != null) {
                Mn4.setVisibility(8);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.i(t2.contact)) {
            View Mn5 = hVar.Mn(R.id.ebq);
            if (Mn5 != null) {
                Mn5.setVisibility(8);
            }
            View Mn6 = hVar.Mn(R.id.d37);
            if (Mn6 != null) {
                Mn6.setVisibility(8);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.h(t2) && t2.showLikeTips && !t2.feedObject.isPostFailed()) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsS() < 6) {
                View Mn7 = hVar.Mn(R.id.d37);
                if (Mn7 == null) {
                    view = ((ViewStub) hVar.Mn(R.id.d38)).inflate();
                } else {
                    view = Mn7;
                }
                if (!t2.feedObject.isPostFinish()) {
                    if (z2) {
                        t2.showLikeTips = false;
                        kotlin.g.b.p.g(view, "tips");
                        dT(view);
                    } else {
                        View Mn8 = hVar.Mn(R.id.d35);
                        kotlin.g.b.p.g(Mn8, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
                        ((TextView) Mn8).setText(com.tencent.mm.cb.a.aI(hVar.getContext(), R.string.cnw));
                        if (z3) {
                            kotlin.g.b.p.g(view, "tips");
                            if (a(view, hVar)) {
                                t2.showLikeTips = false;
                            }
                        }
                        kotlin.g.b.p.g(view, "tips");
                        if (view.getVisibility() != 0 && ((Mn2 = hVar.Mn(R.id.ebq)) == null || Mn2.getVisibility() != 0)) {
                            view.setVisibility(0);
                            Runnable runnable = this.tAd;
                            if (runnable != null) {
                                view.removeCallbacks(runnable);
                            }
                            this.tAd = new bj(this, t2, view);
                            view.postDelayed(this.tAd, 5000);
                        }
                    }
                    View Mn9 = hVar.Mn(R.id.ebq);
                    if (Mn9 != null) {
                        Mn9.setVisibility(0);
                        return;
                    }
                    return;
                }
                View Mn10 = hVar.Mn(R.id.ebq);
                if (Mn10 != null) {
                    Mn10.setVisibility(8);
                }
                if (z2) {
                    t2.showLikeTips = false;
                    kotlin.g.b.p.g(view, "tips");
                    dT(view);
                    return;
                }
                View Mn11 = hVar.Mn(R.id.d35);
                kotlin.g.b.p.g(Mn11, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
                ((TextView) Mn11).setText(com.tencent.mm.cb.a.aI(hVar.getContext(), R.string.cnw));
                kotlin.g.b.p.g(view, "tips");
                if (a(view, hVar) && z3) {
                    t2.showLikeTips = false;
                    return;
                }
                return;
            }
        }
        View Mn12 = hVar.Mn(R.id.d37);
        if (Mn12 != null) {
            Mn12.setVisibility(8);
        }
        View Mn13 = hVar.Mn(R.id.gkw);
        if (Mn13 != null && Mn13.getVisibility() == 0 && (Mn = hVar.Mn(R.id.ebq)) != null) {
            Mn.setVisibility(0);
        }
    }

    private final boolean a(View view, com.tencent.mm.view.recyclerview.h hVar) {
        int i2;
        RecyclerView recyclerView = hVar.getRecyclerView();
        kotlin.g.b.p.g(recyclerView, "holder.recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            if (layoutManager != null) {
                if (layoutManager == null) {
                    throw new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                }
                int ks = ((LinearLayoutManager) layoutManager).ks();
                int ku = ((LinearLayoutManager) layoutManager).ku();
                RecyclerView recyclerView2 = hVar.getRecyclerView();
                kotlin.g.b.p.g(recyclerView2, "holder.recyclerView");
                RecyclerView.a adapter = recyclerView2.getAdapter();
                if (adapter == null) {
                    i2 = -1;
                } else if (adapter == null) {
                    throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                } else {
                    i2 = hVar.lQ() - ((com.tencent.mm.view.recyclerview.g) adapter).RqM.size();
                }
                if (ks < ku && i2 >= 0 && (i2 < ks || i2 > ku)) {
                    dT(view);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class bj implements Runnable {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ View tBr;

        bj(l lVar, BaseFinderFeed baseFinderFeed, View view) {
            this.tAp = lVar;
            this.tAr = baseFinderFeed;
            this.tBr = view;
        }

        public final void run() {
            AppMethodBeat.i(242867);
            this.tAr.showLikeTips = false;
            this.tBr.setVisibility(8);
            this.tAp.tAd = null;
            AppMethodBeat.o(242867);
        }
    }

    private final void dT(View view) {
        view.setVisibility(8);
        Runnable runnable = this.tAd;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.tAd = null;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        c(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str;
            int i3;
            Intent intent;
            Intent intent2;
            AppMethodBeat.i(242815);
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
            MMActivity activity = this.tAp.tAi.getActivity();
            if (activity == null || (intent2 = activity.getIntent()) == null || !intent2.getBooleanExtra("key_form_sns", false)) {
                MMActivity activity2 = this.tAp.tAi.getActivity();
                if (activity2 == null || (intent = activity2.getIntent()) == null) {
                    i3 = 0;
                } else {
                    i3 = intent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) ? 2 : 0;
                }
            } else {
                i3 = 1;
            }
            s.a aVar2 = com.tencent.mm.plugin.finder.utils.s.vWt;
            MMActivity activity3 = this.tAp.tAi.getActivity();
            if (activity3 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(baseFinderFeed, "currItem");
            s.a.a(activity3, baseFinderFeed, 5, i3, 4);
            AppMethodBeat.o(242815);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        d(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            String str;
            AppMethodBeat.i(242816);
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
            AppMethodBeat.o(242816);
        }
    }

    private final void a(boolean z2, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.o oVar;
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.cbi);
        TextView textView = (TextView) hVar.Mn(R.id.cbj);
        if (weImageView != null) {
            if (z2) {
                Integer valueOf = Integer.valueOf((int) R.raw.finder_icons_filled_star);
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                oVar = new kotlin.o(valueOf, Integer.valueOf(context.getResources().getColor(R.color.Orange_100)));
            } else {
                Integer valueOf2 = Integer.valueOf((int) R.raw.finder_icons_outlined_star);
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                oVar = new kotlin.o(valueOf2, Integer.valueOf(context2.getResources().getColor(R.color.FG_0)));
            }
            int intValue = oVar.first.intValue();
            int intValue2 = oVar.second.intValue();
            weImageView.setImageResource(intValue);
            weImageView.setIconColor(intValue2);
        }
        if (textView == null) {
            return;
        }
        if (this.tAi.dbZ()) {
            com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
            textView.setText(i2 > 0 ? com.tencent.mm.plugin.finder.utils.k.gm(2, i2) : "");
            return;
        }
        textView.setText(R.string.cmg);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
    public static final class b<T extends BaseFinderFeed> extends IListener<hf> implements View.OnAttachStateChangeListener {
        final l<T> tAl;
        final com.tencent.mm.view.recyclerview.h tAm;

        public b(l<T> lVar, com.tencent.mm.view.recyclerview.h hVar) {
            kotlin.g.b.p.h(lVar, "parent");
            kotlin.g.b.p.h(hVar, "holder");
            AppMethodBeat.i(165341);
            this.tAl = lVar;
            this.tAm = hVar;
            if (this.tAm.getContext() instanceof MMActivity) {
                Context context = this.tAm.getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(165341);
                    throw tVar;
                }
                ((MMActivity) context).getLifecycle().addObserver(((l) this.tAl).tAe);
            }
            AppMethodBeat.o(165341);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            AppMethodBeat.i(165338);
            com.tencent.mm.ac.d.h(new a(this, hfVar));
            AppMethodBeat.o(165338);
            return false;
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(165339);
            kotlin.g.b.p.h(view, "v");
            AppMethodBeat.o(165339);
        }

        public final void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(165340);
            kotlin.g.b.p.h(view, "v");
            AppMethodBeat.o(165340);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ b tAn;
            final /* synthetic */ hf tAo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, hf hfVar) {
                super(0);
                this.tAn = bVar;
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
                AppMethodBeat.i(165335);
                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.tAn.tAm.hgv();
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
                        this.tAn.tAl.a((l) this.tAn.tAm, (com.tencent.mm.view.recyclerview.h) baseFinderFeed);
                        this.tAn.tAl.c((l) baseFinderFeed, (BaseFinderFeed) this.tAn.tAm);
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165335);
                return xVar;
            }
        }
    }

    public void a(int i2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(hVar, "holder");
        hVar.mf(R.id.d8r, i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"ResourceType"})
    private final void a(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        int i2;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
        boolean asJ = c.a.asJ(t2.feedObject.field_username);
        if (this.tAj) {
            hVar.mf(R.id.d88, 8);
        } else {
            if (!(this.dLS == 3 || !asJ || i2 == 1)) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.h(t2)) {
                    hVar.mf(R.id.d88, 0);
                    TextView textView = (TextView) hVar.Mn(R.id.d88);
                    kotlin.g.b.p.g(textView, "followIv");
                    Context context2 = textView.getContext();
                    kotlin.g.b.p.g(context2, "followIv.context");
                    textView.setText(context2.getResources().getString(R.string.dzl));
                    textView.setTextSize(0, (float) com.tencent.mm.cb.a.aH(textView.getContext(), R.dimen.c5));
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    textView.setTextColor(context3.getResources().getColor(R.color.FG_1));
                    textView.setBackgroundResource(R.drawable.yy);
                }
            }
            if (!asJ || this.dLS == 3) {
                hVar.mf(R.id.d88, 8);
            }
        }
        if (i2 != 1 || ((long) t2.feedObject.getCreateTime()) * 1000 < cl.aWy() - Util.MILLSECONDS_OF_DAY) {
            hVar.mf(R.id.gvw, 0);
        } else {
            hVar.mf(R.id.gvw, 8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.convert.l$l  reason: collision with other inner class name */
    public static final class View$OnClickListenerC1102l implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        View$OnClickListenerC1102l(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            bbn dIx;
            AppMethodBeat.i(242820);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 0, false);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            kotlin.g.b.p.g(baseFinderFeed, "item");
            if (com.tencent.mm.plugin.finder.utils.y.w(baseFinderFeed)) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                Context context = this.qhp.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                eVar.a(com.tencent.mm.plugin.finder.utils.m.a(context, baseFinderFeed, eVar));
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                int i2 = this.tAp.dLS;
                Context context2 = this.qhp.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                eVar.b(com.tencent.mm.plugin.finder.utils.m.a(i2, context2, baseFinderFeed));
            } else {
                eVar.a(this.tAp.tAi.a(baseFinderFeed, eVar));
                eVar.b(this.tAp.tAi.i(baseFinderFeed));
            }
            eVar.a(this.tAp.tAi.j(baseFinderFeed));
            eVar.b(this.tAp.tAi.j(baseFinderFeed));
            eVar.b(new e.b(this) {
                /* class com.tencent.mm.plugin.finder.convert.l.View$OnClickListenerC1102l.AnonymousClass1 */
                final /* synthetic */ View$OnClickListenerC1102l tAA;

                {
                    this.tAA = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    bbn bbn;
                    AppMethodBeat.i(242819);
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    Context context = this.tAA.qhp.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    if (fH != null) {
                        bbn = fH.dIx();
                    } else {
                        bbn = null;
                    }
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(((BaseFinderFeed) this.tAA.qhp.hgv()).feedObject.getId(), 2, 3, "", bbn, 0, (FinderItem) null, 96);
                    AppMethodBeat.o(242819);
                }
            });
            eVar.dGm();
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.C(baseFinderFeed.feedObject)) {
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context3 = this.qhp.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                if (!(fH == null || (dIx = fH.dIx()) == null)) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(dIx, baseFinderFeed.feedObject.field_id, Integer.valueOf(baseFinderFeed.feedObject.getFeedObject().follow_feed_count));
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242820);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
    public static final class g implements Runnable {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ View tzP;
        final /* synthetic */ TextView tzQ;
        final /* synthetic */ String tzR;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        g(View view, TextView textView, String str, l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tzP = view;
            this.tzQ = textView;
            this.tzR = str;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tAz = baseFinderFeed;
        }

        public final void run() {
            AppMethodBeat.i(165348);
            View view = this.tzP;
            kotlin.g.b.p.g(view, "positionLayout");
            int width = view.getWidth();
            if (width > 0) {
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
                TextView textView = this.tzQ;
                kotlin.g.b.p.g(textView, "poiTv");
                if (textView.getPaint().measureText(this.tzR) + ((float) fromDPToPix) > ((float) width)) {
                    TextView textView2 = this.tzQ;
                    kotlin.g.b.p.g(textView2, "poiTv");
                    TextView textView3 = this.tzQ;
                    kotlin.g.b.p.g(textView3, "poiTv");
                    textView2.setText(TextUtils.ellipsize(this.tzR, textView3.getPaint(), (float) (width - fromDPToPix), TextUtils.TruncateAt.END));
                }
            }
            AppMethodBeat.o(165348);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ String tzR;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        h(String str, l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.tzR = str;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tAz = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165349);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            l.a(this.tAp, this.tzq, this.tAz, this.tzR);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165349);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$1"})
    public static final class i implements Runnable {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ TextView tzL;
        final /* synthetic */ String tzM;
        final /* synthetic */ View tzN;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        i(TextView textView, String str, l lVar, com.tencent.mm.view.recyclerview.h hVar, View view, BaseFinderFeed baseFinderFeed) {
            this.tzL = textView;
            this.tzM = str;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tzN = view;
            this.tAz = baseFinderFeed;
        }

        public final void run() {
            AppMethodBeat.i(165350);
            View view = this.tzN;
            kotlin.g.b.p.g(view, "linkLayout");
            int width = view.getWidth();
            if (width > 0) {
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
                TextView textView = this.tzL;
                kotlin.g.b.p.g(textView, "linkTv");
                if (textView.getPaint().measureText(this.tzM) + ((float) fromDPToPix) > ((float) width)) {
                    TextView textView2 = this.tzL;
                    kotlin.g.b.p.g(textView2, "linkTv");
                    TextView textView3 = this.tzL;
                    kotlin.g.b.p.g(textView3, "linkTv");
                    textView2.setText(TextUtils.ellipsize(this.tzM, textView3.getPaint(), (float) (width - fromDPToPix), TextUtils.TruncateAt.END));
                }
            }
            AppMethodBeat.o(165350);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$2"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ String nNF;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ View tzN;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        j(String str, l lVar, com.tencent.mm.view.recyclerview.h hVar, View view, BaseFinderFeed baseFinderFeed) {
            this.nNF = str;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tzN = view;
            this.tAz = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165351);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            l.a(this.tzq, this.tAz, this.nNF);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165351);
        }
    }

    private static void a(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, Boolean bool) {
        String str;
        awt awt;
        FinderObject feedObject;
        FinderObject feedObject2;
        String userName;
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
                    Log.i("Finder.FeedConvert", "update live notice from cache");
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    FinderFeedLiveNoticeView.a(finderFeedLiveNoticeView, context3, awt, str);
                } else if (finderFeedLiveNoticeView.getVisibility() == 0) {
                    Log.i("Finder.FeedConvert", "notice info no cache ,request again");
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

    private final void c(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
        Integer num;
        Integer num2;
        FinderObject feedObject;
        FinderObject feedObject2;
        azx azx;
        azw azw = null;
        LinkedList<azw> linkedList = (finderItem == null || (feedObject2 = finderItem.getFeedObject()) == null || (azx = feedObject2.hotTopics) == null) ? null : azx.Gbc;
        StringBuilder sb = new StringBuilder("showNewsIndicator objectType: ");
        if (finderItem == null || (feedObject = finderItem.getFeedObject()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(feedObject.objectType);
        }
        StringBuilder append = sb.append(num).append(" size:");
        if (linkedList != null) {
            num2 = Integer.valueOf(linkedList.size());
        } else {
            num2 = null;
        }
        Log.i("Finder.FeedConvert", append.append(num2).toString());
        if (linkedList != null) {
            Iterator<azw> it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    azw next = it.next();
                    if (next != null && next.LJN == 5) {
                        azw = next;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (azw != null) {
            Log.i("Finder.FeedConvert", "showNewsIndicator topic " + azw.twp + ' ' + azw.riB + ' ' + azw.LJO);
            if (hVar.getContext() instanceof FinderShareFeedRelUI) {
                Log.i("Finder.FeedConvert", "showNewsIndicator topic ui is FinderShareFeedRelUI block");
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
                    textView.setTextColor(textView.getResources().getColor(R.color.Link_80));
                } else {
                    textView.setTextColor(textView.getResources().getColor(R.color.FG_1));
                }
            }
            View Mn3 = hVar.Mn(R.id.clv);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
                Mn3.setOnClickListener(new bh(azw, this, hVar, finderItem, str));
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
        Log.i("Finder.FeedConvert", "showNewsIndicator topic null let");
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
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$2$2$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$2"})
    public static final class bh implements View.OnClickListener {
        final /* synthetic */ FinderItem $item$inlined;
        final /* synthetic */ l tAp;
        final /* synthetic */ azw tBo;
        final /* synthetic */ String tBp;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        bh(azw azw, l lVar, com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, String str) {
            this.tBo = azw;
            this.tAp = lVar;
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
            AppMethodBeat.i(242865);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
                intent.putExtra("KEY_TAB_TYPE", this.tAp.dLS);
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
                Log.i("Finder.FeedConvert", "hot news not support jump!");
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242865);
        }
    }

    private static void b(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        boolean z2;
        com.tencent.mm.plugin.finder.api.g gVar = t2.contact;
        int i2 = gVar != null ? gVar.field_liveStatus : 2;
        View Mn = hVar.Mn(R.id.cw_);
        StringBuilder sb = new StringBuilder("refreshLiveIcon username:");
        com.tencent.mm.plugin.finder.api.g gVar2 = t2.contact;
        StringBuilder append = sb.append(gVar2 != null ? gVar2.getNickname() : null).append(",liveStatus:").append(i2).append(",onliveView is null:");
        if (Mn == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("Finder.FeedConvert", append.append(z2).toString());
        if (i2 == 1) {
            if (Mn != null) {
                Mn.setVisibility(0);
            }
            Mn.post(new ak(Mn));
            if (Mn != null) {
                Mn.setOnClickListener(new al(hVar, t2));
            }
            TextView textView = (TextView) hVar.Mn(R.id.d88);
            kotlin.g.b.p.g(textView, "followTv");
            if (Util.isNullOrNil(textView.getText().toString())) {
                textView.setVisibility(8);
            }
        } else if (Mn != null) {
            Mn.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class ak implements Runnable {
        final /* synthetic */ View tAW;

        ak(View view) {
            this.tAW = view;
        }

        public final void run() {
            AppMethodBeat.i(242843);
            Rect rect = new Rect();
            this.tAW.getHitRect(rect);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.bt);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            View view = this.tAW;
            kotlin.g.b.p.g(view, "onliveView");
            ViewParent parent = view.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(242843);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.tAW));
            AppMethodBeat.o(242843);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class al implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        al(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(242844);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.api.g gVar = this.tAr.contact;
            if (gVar != null) {
                str = gVar.getUsername();
            } else {
                str = null;
            }
            new com.tencent.mm.plugin.finder.view.r(context, str, this.qhp.lR(), this.tAr.feedObject.isLiveFeed()).dzC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242844);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class aj implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ List tAU;
        final /* synthetic */ ard tAV;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        aj(l lVar, List list, BaseFinderFeed baseFinderFeed, ard ard, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.tAU = list;
            this.tAr = baseFinderFeed;
            this.tAV = ard;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242842);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            l.a(this.tAU, this.tAr, this.tAV, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242842);
        }
    }

    private final void c(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        ViewGroup.LayoutParams layoutParams;
        boolean z2;
        com.tencent.mm.plugin.finder.storage.k kVar = t2.attachFavInfo;
        if (kVar != null) {
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            if (fk(context)) {
                ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.cf6);
                if (viewGroup != null) {
                    layoutParams = viewGroup.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                    layoutParams = null;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (kVar.vDG) {
                    if (layoutParams2 != null) {
                        layoutParams2.gravity = 3;
                    }
                } else if (layoutParams2 != null) {
                    layoutParams2.gravity = 5;
                }
                TextView textView = (TextView) hVar.Mn(R.id.cf7);
                List<BaseFinderFeed> dxB = kVar.dxB();
                if (kVar.vDI == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String string = Util.isNullOrNil(kVar.getWording()) ? hVar.getContext().getString(R.string.cmk) : kVar.getWording();
                kotlin.g.b.p.g(string, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
                if (textView != null) {
                    textView.setText(string);
                }
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                if (viewGroup != null) {
                    viewGroup.setOnClickListener(new bb(this, kVar, hVar, dxB, t2, z2, viewGroup));
                    return;
                }
                return;
            }
        }
        View Mn = hVar.Mn(R.id.cf6);
        if (Mn != null) {
            Mn.setOnClickListener(null);
        }
        if (Mn != null) {
            Mn.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class bb implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ List tAU;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ com.tencent.mm.plugin.finder.storage.k tBk;
        final /* synthetic */ boolean tBl;
        final /* synthetic */ ViewGroup tBm;

        bb(l lVar, com.tencent.mm.plugin.finder.storage.k kVar, com.tencent.mm.view.recyclerview.h hVar, List list, BaseFinderFeed baseFinderFeed, boolean z, ViewGroup viewGroup) {
            this.tAp = lVar;
            this.tBk = kVar;
            this.qhp = hVar;
            this.tAU = list;
            this.tAr = baseFinderFeed;
            this.tBl = z;
            this.tBm = viewGroup;
        }

        public final void onClick(View view) {
            int i2;
            String str;
            String str2;
            int i3;
            com.tencent.mm.bw.b bVar;
            int i4 = 1;
            String str3 = null;
            AppMethodBeat.i(242859);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                String string = Util.isNullOrNil(this.tBk.getWording()) ? this.qhp.getContext().getString(R.string.cmk) : this.tBk.getWording();
                kotlin.g.b.p.g(string, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
                List list = this.tAU;
                BaseFinderFeed baseFinderFeed = this.tAr;
                com.tencent.mm.view.recyclerview.h hVar = this.qhp;
                aqv aqv = this.tBk.vDI;
                if (aqv == null || (bVar = aqv.lastBuffer) == null) {
                    bVar = null;
                }
                l.a(string, list, baseFinderFeed, hVar, bVar, this.tBl);
            } else {
                ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.tBm.getContext());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20912, 3, 5, this.tAr.feedObject.getUserName(), this.tAr.feedObject.getNickName());
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            long lT = this.tAr.lT();
            if (fH != null) {
                i2 = fH.tCE;
            } else {
                i2 = 0;
            }
            if (fH != null) {
                str = fH.sGE;
            } else {
                str = null;
            }
            if (fH != null) {
                str2 = fH.sGQ;
            } else {
                str2 = null;
            }
            if (fH != null) {
                str3 = fH.sessionId;
            }
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            long lT2 = this.tAr.lT();
            if (fH != null) {
                i3 = fH.tCE;
            } else {
                i3 = 0;
            }
            String G = com.tencent.mm.plugin.finder.report.k.G(lT2, i3);
            if (!this.tBk.vDG) {
                i4 = 2;
            }
            com.tencent.mm.plugin.finder.report.k.a(lT, 3, i2, str, str2, str3, G, i4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242859);
        }
    }

    private final boolean fk(Context context) {
        int i2;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        return this.dLS == 3 || this.dLS == 1 || this.dLS == 4 || i2 == 16;
    }

    public void d(com.tencent.mm.view.recyclerview.h hVar, T t2) {
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(t2, "item");
    }

    static /* synthetic */ void a(List list, BaseFinderFeed baseFinderFeed, ard ard, com.tencent.mm.view.recyclerview.h hVar) {
        if (!Util.isNullOrNil(list)) {
            Log.i("Finder.FeedConvert", "jumpFoldedUI item ".concat(String.valueOf(baseFinderFeed)));
            Intent intent = new Intent();
            intent.putExtra("FEED_ID", baseFinderFeed.feedObject.getId());
            intent.putExtra("FEED_NONCE_ID", baseFinderFeed.feedObject.getObjectNonceId());
            if (ard.tQR == 1) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                intent.putExtra("NICKNAME", com.tencent.mm.plugin.finder.utils.y.hf(ard.username, ""));
                kotlin.g.b.p.g(intent.putExtra("FOLED_TYPE", 1), "intent.putExtra(Constant…utType.Folded_FriendLike)");
            } else if (ard.tQR == 2) {
                intent.putExtra("NICKNAME", baseFinderFeed.feedObject.getNickName());
                intent.putExtra("FOLED_TYPE", 2);
            }
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.a(0, list, (com.tencent.mm.bw.b) null, intent);
            FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.Gu(cl.aWA());
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.V(context, intent);
        }
    }

    private final void a(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        if (this.tAi.dbZ()) {
            hVar.mf(R.id.d8o, 8);
            hVar.mf(R.id.hjd, 0);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (((Boolean) com.tencent.mm.plugin.finder.storage.c.dtM().value()).booleanValue() && t2.feedObject.field_id % 2 == 0) {
                if (kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, LocaleUtil.CHINA) || kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, LocaleUtil.HONGKONG) || kotlin.g.b.p.j(com.tencent.mm.plugin.finder.utils.k.vVD, LocaleUtil.TAIWAN)) {
                    t2.feedObject.setReadCount(9998);
                    t2.feedObject.setForwardCount(99980000);
                    t2.feedObject.setLikeCount(120000000);
                    t2.feedObject.setCommentCount(120000000);
                    t2.feedObject.setFavCount(120000000);
                } else {
                    t2.feedObject.setReadCount(999);
                    t2.feedObject.setForwardCount(1000);
                    t2.feedObject.setLikeCount(1000000);
                    t2.feedObject.setCommentCount(990000000);
                    t2.feedObject.setFavCount(1200000000);
                }
            }
            View Mn = hVar.Mn(R.id.hjq);
            kotlin.g.b.p.g(Mn, "holder.getView<TextView>(R.id.self_read_count_tv)");
            ((TextView) Mn).setText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getReadCount()));
            View Mn2 = hVar.Mn(R.id.hji);
            kotlin.g.b.p.g(Mn2, "holder.getView<TextView>…id.self_forward_count_tv)");
            ((TextView) Mn2).setText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getForwardCount()));
            View Mn3 = hVar.Mn(R.id.hjk);
            kotlin.g.b.p.g(Mn3, "holder.getView<TextView>(R.id.self_like_count_tv)");
            j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            ((TextView) Mn3).setText(com.tencent.mm.plugin.finder.utils.k.Lx(com.tencent.mm.plugin.finder.upload.action.j.vUv.n(t2.feedObject.getFeedObject())));
            View Mn4 = hVar.Mn(R.id.hj9);
            kotlin.g.b.p.g(Mn4, "holder.getView<TextView>…id.self_comment_count_tv)");
            ((TextView) Mn4).setText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getCommentCount()));
            View Mn5 = hVar.Mn(R.id.hjc);
            kotlin.g.b.p.g(Mn5, "holder.getView<TextView>(R.id.self_fav_count_tv)");
            ((TextView) Mn5).setText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getFavCount()));
            hVar.Mn(R.id.hjj).setOnClickListener(new am(hVar, t2));
            hVar.Mn(R.id.hjs).setOnClickListener(new an(this, hVar));
            hVar.mf(R.id.b92, 0);
            hVar.mf(R.id.j0j, 0);
            hVar.e(R.id.j0j, com.tencent.mm.plugin.finder.utils.k.f(hVar.getContext(), ((long) t2.feedObject.getCreateTime()) * 1000));
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(R.dimen.bd);
            ((TextView) hVar.Mn(R.id.hjq)).setTextSize(0, dimensionPixelSize);
            ((TextView) hVar.Mn(R.id.hji)).setTextSize(0, dimensionPixelSize);
            ((TextView) hVar.Mn(R.id.hjk)).setTextSize(0, dimensionPixelSize);
            ((TextView) hVar.Mn(R.id.hj9)).setTextSize(0, dimensionPixelSize);
            ((TextView) hVar.Mn(R.id.hjc)).setTextSize(0, dimensionPixelSize);
            b(t2, hVar);
            return;
        }
        hVar.mf(R.id.d8o, 0);
        hVar.mf(R.id.hjd, 8);
        c.a aVar2 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        boolean k2 = com.tencent.mm.plugin.finder.upload.action.c.dBq().k(t2.feedObject.getFeedObject());
        c.a aVar3 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        a(k2, com.tencent.mm.plugin.finder.upload.action.c.dBq().l(t2.feedObject.getFeedObject()), hVar);
        j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(t2.feedObject.getFeedObject());
        boolean booleanValue = m2.first.booleanValue();
        boolean booleanValue2 = m2.second.booleanValue();
        j.a aVar5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(t2, booleanValue, booleanValue2, com.tencent.mm.plugin.finder.upload.action.j.vUv.n(t2.feedObject.getFeedObject()), hVar);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class am implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ BaseFinderFeed tAr;

        am(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed) {
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            FinderLikeDrawer finderLikeDrawer;
            AppMethodBeat.i(242845);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                finderLikeDrawer = (FinderLikeDrawer) activity.findViewById(R.id.cln);
            } else {
                finderLikeDrawer = null;
            }
            if (finderLikeDrawer == null) {
                kotlin.g.b.p.hyc();
            }
            finderLikeDrawer.a(this.tAr.feedObject, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242845);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class an implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;

        an(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAp = lVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242846);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tAp.c(this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242846);
        }
    }

    private static void b(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        View Mn = hVar.Mn(R.id.hjq);
        kotlin.g.b.p.g(Mn, "holder.getView<TextView>(R.id.self_read_count_tv)");
        float measureText = ((TextView) Mn).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getReadCount())) + 1.0f;
        View Mn2 = hVar.Mn(R.id.hji);
        kotlin.g.b.p.g(Mn2, "holder.getView<TextView>…id.self_forward_count_tv)");
        float measureText2 = ((TextView) Mn2).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getForwardCount())) + 1.0f;
        View Mn3 = hVar.Mn(R.id.hjk);
        kotlin.g.b.p.g(Mn3, "holder.getView<TextView>(R.id.self_like_count_tv)");
        float measureText3 = ((TextView) Mn3).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getLikeCount())) + 1.0f;
        View Mn4 = hVar.Mn(R.id.hj9);
        kotlin.g.b.p.g(Mn4, "holder.getView<TextView>…id.self_comment_count_tv)");
        float measureText4 = ((TextView) Mn4).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getCommentCount())) + 1.0f;
        View Mn5 = hVar.Mn(R.id.hjc);
        kotlin.g.b.p.g(Mn5, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.by);
        int jn = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
        float measureText5 = ((TextView) Mn5).getPaint().measureText(com.tencent.mm.plugin.finder.utils.k.Lx(t2.feedObject.getFavCount())) + 1.0f + measureText + measureText2 + measureText3 + measureText4 + (((float) context.getResources().getDimensionPixelSize(R.dimen.ce)) * 5.0f) + ((float) dimensionPixelSize);
        Log.d("Finder.FeedConvert", "contentWidthSum : " + measureText5 + " ,screenWidth : " + jn);
        View Mn6 = hVar.Mn(R.id.hjf);
        View Mn7 = hVar.Mn(R.id.hje);
        kotlin.g.b.p.g(Mn7, "holder.getView<LinearLay…ter_op_layout_first_line)");
        LinearLayout linearLayout = (LinearLayout) Mn7;
        View Mn8 = hVar.Mn(R.id.hjg);
        kotlin.g.b.p.g(Mn8, "holder.getView<LinearLay…er_op_layout_second_line)");
        LinearLayout linearLayout2 = (LinearLayout) Mn8;
        if (measureText5 < ((float) jn)) {
            linearLayout2.setVisibility(8);
            linearLayout2 = linearLayout;
        } else {
            linearLayout2.setVisibility(0);
        }
        kotlin.g.b.p.g(Mn6, "rightPart");
        ViewParent parent = Mn6.getParent();
        if (parent == null) {
            throw new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        ((LinearLayout) parent).removeView(Mn6);
        linearLayout2.addView(Mn6);
    }

    private final void a(T t2, com.tencent.mm.view.recyclerview.h hVar, boolean z2) {
        String str;
        String str2;
        String str3;
        SpannableString c2;
        String str4;
        SpannableString c3;
        String str5;
        String str6;
        String str7;
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        LinkedList<FinderCommentInfo> p2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.p(t2.feedObject.getFeedObject());
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        int o2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.o(t2.feedObject.getFeedObject());
        if (this.tAf && !Util.isNullOrNil(p2) && o2 > 0 && !this.tAi.dbZ()) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.i(t2.contact)) {
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                boolean v2 = com.tencent.mm.plugin.finder.utils.y.v(t2);
                float f2 = this.tAg ? 0.2f : 0.5f;
                boolean z3 = this.tAg;
                View Mn = hVar.Mn(R.id.gto);
                if (Mn != null) {
                    Mn.setVisibility(0);
                    ArrayList<ImageView> arrayList = new ArrayList();
                    arrayList.add(hVar.Mn(R.id.da_));
                    arrayList.add(hVar.Mn(R.id.dab));
                    arrayList.add(hVar.Mn(R.id.dad));
                    ArrayList arrayList2 = new ArrayList();
                    FrameLayout frameLayout = (FrameLayout) hVar.Mn(R.id.daa);
                    FrameLayout frameLayout2 = (FrameLayout) hVar.Mn(R.id.dac);
                    FrameLayout frameLayout3 = (FrameLayout) hVar.Mn(R.id.dae);
                    FrameLayout frameLayout4 = (FrameLayout) hVar.Mn(R.id.daj);
                    if (this.tAg) {
                        kotlin.g.b.p.g(frameLayout, "layout1");
                        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                        if (layoutParams == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        Context context = hVar.getContext();
                        kotlin.g.b.p.g(context, "holder.context");
                        layoutParams2.width = (int) context.getResources().getDimension(R.dimen.cf);
                        Context context2 = hVar.getContext();
                        kotlin.g.b.p.g(context2, "holder.context");
                        layoutParams2.height = (int) context2.getResources().getDimension(R.dimen.cf);
                        frameLayout.setLayoutParams(layoutParams2);
                        kotlin.g.b.p.g(frameLayout2, "layout2");
                        ViewGroup.LayoutParams layoutParams3 = frameLayout2.getLayoutParams();
                        if (layoutParams3 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                        Context context3 = hVar.getContext();
                        kotlin.g.b.p.g(context3, "holder.context");
                        layoutParams4.leftMargin = (int) context3.getResources().getDimension(R.dimen.cf);
                        Context context4 = hVar.getContext();
                        kotlin.g.b.p.g(context4, "holder.context");
                        layoutParams4.width = (int) context4.getResources().getDimension(R.dimen.cf);
                        Context context5 = hVar.getContext();
                        kotlin.g.b.p.g(context5, "holder.context");
                        layoutParams4.height = (int) context5.getResources().getDimension(R.dimen.cf);
                        frameLayout2.setLayoutParams(layoutParams4);
                        kotlin.g.b.p.g(frameLayout3, "layout3");
                        ViewGroup.LayoutParams layoutParams5 = frameLayout3.getLayoutParams();
                        if (layoutParams5 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                        Context context6 = hVar.getContext();
                        kotlin.g.b.p.g(context6, "holder.context");
                        layoutParams6.leftMargin = (int) context6.getResources().getDimension(R.dimen.cp);
                        Context context7 = hVar.getContext();
                        kotlin.g.b.p.g(context7, "holder.context");
                        layoutParams6.width = (int) context7.getResources().getDimension(R.dimen.cf);
                        Context context8 = hVar.getContext();
                        kotlin.g.b.p.g(context8, "holder.context");
                        layoutParams6.height = (int) context8.getResources().getDimension(R.dimen.cf);
                        frameLayout3.setLayoutParams(layoutParams6);
                        kotlin.g.b.p.g(frameLayout4, "layoutExtra");
                        ViewGroup.LayoutParams layoutParams7 = frameLayout4.getLayoutParams();
                        if (layoutParams7 == null) {
                            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) layoutParams7;
                        Context context9 = hVar.getContext();
                        kotlin.g.b.p.g(context9, "holder.context");
                        layoutParams8.width = (int) context9.getResources().getDimension(R.dimen.cf);
                        Context context10 = hVar.getContext();
                        kotlin.g.b.p.g(context10, "holder.context");
                        layoutParams8.height = (int) context10.getResources().getDimension(R.dimen.cf);
                        frameLayout4.setLayoutParams(layoutParams8);
                        for (ImageView imageView : arrayList) {
                            ViewGroup.LayoutParams layoutParams9 = imageView != null ? imageView.getLayoutParams() : null;
                            if (layoutParams9 != null) {
                                Context context11 = hVar.getContext();
                                kotlin.g.b.p.g(context11, "holder.context");
                                layoutParams9.width = (int) context11.getResources().getDimension(R.dimen.ce);
                            }
                            if (layoutParams9 != null) {
                                Context context12 = hVar.getContext();
                                kotlin.g.b.p.g(context12, "holder.context");
                                layoutParams9.height = (int) context12.getResources().getDimension(R.dimen.ce);
                            }
                            if (imageView != null) {
                                imageView.setLayoutParams(layoutParams9);
                            }
                        }
                        View Mn2 = hVar.Mn(R.id.daf);
                        ViewGroup.LayoutParams layoutParams10 = Mn2 != null ? Mn2.getLayoutParams() : null;
                        if (layoutParams10 != null) {
                            Context context13 = hVar.getContext();
                            kotlin.g.b.p.g(context13, "holder.context");
                            layoutParams10.width = (int) context13.getResources().getDimension(R.dimen.ce);
                        }
                        if (layoutParams10 != null) {
                            Context context14 = hVar.getContext();
                            kotlin.g.b.p.g(context14, "holder.context");
                            layoutParams10.height = (int) context14.getResources().getDimension(R.dimen.ce);
                        }
                        if (Mn2 != null) {
                            Mn2.setLayoutParams(layoutParams10);
                        }
                    }
                    arrayList2.add(frameLayout);
                    arrayList2.add(frameLayout2);
                    arrayList2.add(frameLayout3);
                    RoundLinearLayout roundLinearLayout = (RoundLinearLayout) hVar.Mn(R.id.a2z);
                    if (roundLinearLayout != null) {
                        roundLinearLayout.setRadius(f2);
                        kotlin.x xVar = kotlin.x.SXb;
                    }
                    RoundLinearLayout roundLinearLayout2 = (RoundLinearLayout) hVar.Mn(R.id.a30);
                    if (roundLinearLayout2 != null) {
                        roundLinearLayout2.setRadius(f2);
                        kotlin.x xVar2 = kotlin.x.SXb;
                    }
                    RoundLinearLayout roundLinearLayout3 = (RoundLinearLayout) hVar.Mn(R.id.a31);
                    if (roundLinearLayout3 != null) {
                        roundLinearLayout3.setRadius(f2);
                        kotlin.x xVar3 = kotlin.x.SXb;
                    }
                    RoundLinearLayout roundLinearLayout4 = (RoundLinearLayout) hVar.Mn(R.id.dag);
                    if (roundLinearLayout4 != null) {
                        roundLinearLayout4.setRadius(f2);
                        kotlin.x xVar4 = kotlin.x.SXb;
                    }
                    z.a aVar3 = new z.a();
                    z.a aVar4 = new z.a();
                    j.a aVar5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                    kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(t2.feedObject.getFeedObject());
                    aVar3.SYB = m2.first.booleanValue();
                    aVar4.SYB = m2.second.booleanValue();
                    z.f fVar = new z.f();
                    fVar.SYG = (T) new ay(aVar3, aVar4, this, hVar, f2, t2, z2, p2, z3, o2, v2);
                    new az(arrayList, arrayList2, fVar, this, hVar, f2, t2, z2, p2, z3, o2, v2).invoke();
                    TextView textView = (TextView) hVar.Mn(R.id.gtq);
                    if (textView != null) {
                        if (z3) {
                            if (p2.size() <= 3) {
                                Context context15 = hVar.getContext();
                                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                                FinderCommentInfo finderCommentInfo = (FinderCommentInfo) kotlin.a.j.kv(p2);
                                if (finderCommentInfo == null || (str7 = finderCommentInfo.username) == null) {
                                    str5 = "";
                                } else {
                                    str5 = str7;
                                }
                                FinderCommentInfo finderCommentInfo2 = (FinderCommentInfo) kotlin.a.j.kv(p2);
                                if (finderCommentInfo2 == null || (str6 = finderCommentInfo2.nickname) == null) {
                                    str6 = "";
                                }
                                c3 = com.tencent.mm.pluginsdk.ui.span.l.c(context15, com.tencent.mm.plugin.finder.utils.y.hf(str5, str6));
                            } else {
                                Context context16 = hVar.getContext();
                                com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                                String str8 = p2.get(2).username;
                                if (str8 == null) {
                                    str4 = "";
                                } else {
                                    str4 = str8;
                                }
                                String str9 = p2.get(2).nickname;
                                if (str9 == null) {
                                    str9 = "";
                                }
                                c3 = com.tencent.mm.pluginsdk.ui.span.l.c(context16, com.tencent.mm.plugin.finder.utils.y.hf(str4, str9));
                            }
                            c2 = c3;
                        } else {
                            Context context17 = hVar.getContext();
                            com.tencent.mm.plugin.finder.utils.y yVar5 = com.tencent.mm.plugin.finder.utils.y.vXH;
                            String str10 = p2.get(0).username;
                            if (str10 == null) {
                                str3 = "";
                            } else {
                                str3 = str10;
                            }
                            String str11 = p2.get(0).nickname;
                            if (str11 == null) {
                                str11 = "";
                            }
                            c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context17, com.tencent.mm.plugin.finder.utils.y.hf(str3, str11));
                        }
                        textView.setText(c2);
                        kotlin.x xVar5 = kotlin.x.SXb;
                    }
                    TextView textView2 = (TextView) hVar.Mn(R.id.gtn);
                    int i2 = t2.feedObject.getFeedObject().incFriendLikeCount;
                    int i3 = o2 - i2;
                    if (o2 == 1) {
                        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                        if (com.tencent.mm.plugin.finder.storage.logic.g.Lj(t2.feedObject.getFeedObject().objectType) == null) {
                            str2 = hVar.getContext().getString(R.string.d7o);
                        } else {
                            str2 = "";
                        }
                        kotlin.g.b.p.g(str2, "if (wordingConfig == nul…里不需要文案了\n                }");
                        if (i2 <= 0 || !v2) {
                            kotlin.g.b.p.g(textView2, "descTv");
                            textView2.setText(str2);
                        } else {
                            if (str2 == null) {
                                str2 = "";
                            }
                            kotlin.g.b.p.g(textView2, "descTv");
                            a(i2, hVar, str2, textView2);
                        }
                    } else {
                        com.tencent.mm.plugin.finder.storage.logic.g gVar2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(t2.feedObject.getFeedObject().objectType);
                        if (Lj != null) {
                            String str12 = Lj.LJz;
                            if (!(str12 == null || str12.length() == 0)) {
                                String str13 = Lj.LJz;
                                str = str13 != null ? kotlin.n.n.j(str13, "$$", String.valueOf(i3 + i2), true) : null;
                                if (i2 > 0 || !v2) {
                                    kotlin.g.b.p.g(textView2, "descTv");
                                    textView2.setText(str);
                                } else {
                                    if (str == null) {
                                        str = "";
                                    }
                                    kotlin.g.b.p.g(textView2, "descTv");
                                    a(i3, i2, hVar, str, textView2);
                                }
                            }
                        }
                        str = hVar.getContext().getString(R.string.d7n, String.valueOf(i3 + i2));
                        if (i2 > 0) {
                        }
                        kotlin.g.b.p.g(textView2, "descTv");
                        textView2.setText(str);
                    }
                    View Mn3 = hVar.Mn(R.id.gtp);
                    if (Mn3 != null) {
                        Mn3.setOnClickListener(new ba(this, hVar, f2, t2, z2, p2, z3, o2, v2));
                        kotlin.x xVar6 = kotlin.x.SXb;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        Log.i("Finder.FeedConvert", "refreshRealNameRecommendLayout tabType:" + this.dLS + ", " + Util.isNullOrNil(p2) + ", " + o2 + ' ' + this.tAf);
        View Mn4 = hVar.Mn(R.id.gto);
        if (Mn4 != null) {
            Mn4.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
    public static final class ba implements View.OnClickListener {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ boolean tBg;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        ba(l lVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2, boolean z3) {
            this.tAp = lVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
            this.tBg = z3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.tencent.mm.plugin.finder.convert.l */
        /* JADX WARN: Multi-variable type inference failed */
        public final void onClick(View view) {
            FinderLikeDrawer finderLikeDrawer;
            AppMethodBeat.i(242858);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bfp bfp = new bfp();
            bfp.feedId = this.tAz.lT();
            bfp.objectNonceId = this.tAz.feedObject.getObjectNonceId();
            bfp.scene = 2;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.tzq.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            bfp.ttO = fH != null ? fH.dIx() : null;
            Context context2 = this.tzq.getContext();
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                finderLikeDrawer = (FinderLikeDrawer) activity.findViewById(R.id.clq);
            } else {
                finderLikeDrawer = null;
            }
            if (finderLikeDrawer == null) {
                kotlin.g.b.p.hyc();
            }
            finderLikeDrawer.a(this.tAz.feedObject, this.tAp.a(this.tAz));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242858);
        }
    }

    private static void a(int i2, com.tencent.mm.view.recyclerview.h hVar, String str, TextView textView) {
        String str2 = "(+" + i2 + ')';
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        sb.append(str2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Red)), length, sb.length(), 17);
        textView.setText(spannableStringBuilder);
    }

    private static void a(int i2, int i3, com.tencent.mm.view.recyclerview.h hVar, String str, TextView textView) {
        String.valueOf(i2 + i3);
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        sb.append("(+" + i3 + ')');
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Red)), length, sb.length(), 17);
        textView.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void c(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        int i2;
        boolean z2;
        boolean z3;
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
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        if (i2 == 3 || i2 == 16 || i2 == 27 || i2 == 9 || i2 == 18 || i2 == 31 || i2 == 29 || (i2 == 20 && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE))) {
            hVar.mf(R.id.gvw, 8);
            String str = t2.feedObject.getFeedObject().recommendReason;
            if (str == null || str.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                int i3 = t2.feedObject.getFeedObject().recommendType;
                hVar.mf(R.id.gvo, 8);
                hVar.mf(R.id.gvw, 0);
                String str2 = t2.feedObject.getFeedObject().recommendReason;
                if (str2 == null || str2.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    TextView textView = (TextView) hVar.Mn(R.id.gvx);
                    kotlin.g.b.p.g(textView, "reasonTv");
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.h(hVar.getContext(), t2.feedObject.getFeedObject().recommendReason, (int) textView.getTextSize()));
                    textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                    return;
                }
                Log.w("Finder.FeedConvert", "hide recommend layout type=" + i3 + " recommendReason=" + t2.feedObject.getFeedObject().recommendReason + " feedId=" + t2.feedObject.getFeedObject().id);
                hVar.mf(R.id.gvw, 8);
                return;
            }
            return;
        }
        hVar.mf(R.id.gvw, 8);
    }

    public static void a(boolean z2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.fjv);
        if (z2) {
            kotlin.g.b.p.g(Mn, "moreBtn");
            Mn.setVisibility(0);
            return;
        }
        kotlin.g.b.p.g(Mn, "moreBtn");
        Mn.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01d3, code lost:
        if (((com.tencent.mm.plugin.i.a.ad) r0).dxX() == false) goto L_0x01d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(T r13, com.tencent.mm.view.recyclerview.h r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 886
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.l.b(com.tencent.mm.plugin.finder.model.BaseFinderFeed, com.tencent.mm.view.recyclerview.h, boolean):void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\u000b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$3"})
    public static final class ao implements View.OnTouchListener {
        final /* synthetic */ l tAX;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        ao(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAX = lVar;
            this.tzq = hVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242847);
            kotlin.g.b.p.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                WeImageView weImageView = (WeImageView) this.tzq.Mn(R.id.gkt);
                if (((weImageView != null ? weImageView.getTag() : null) instanceof Integer) && kotlin.g.b.p.j(weImageView.getTag(), 0)) {
                    l.a(this.tzq);
                }
            }
            AppMethodBeat.o(242847);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$2", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$4"})
    public static final class ap implements View.OnClickListener {
        final /* synthetic */ l tAX;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        ap(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAX = lVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242848);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("Finder.FeedConvert", "onClickLikeLocal:" + this.tzq.lR());
            l.b(this.tAX, this.tzq, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242848);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$3", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$5"})
    public static final class aq implements View.OnLongClickListener {
        final /* synthetic */ l tAX;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        aq(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tAX = lVar;
            this.tzq = hVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(242849);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtQ().value().intValue() == 1) {
                Log.i("Finder.FeedConvert", "onLongClickLikeLocal:" + this.tzq.lR());
                WeImageView weImageView = (WeImageView) this.tzq.Mn(R.id.gkt);
                if (((weImageView != null ? weImageView.getTag() : null) instanceof Integer) && kotlin.g.b.p.j(weImageView.getTag(), 0)) {
                    l.b(this.tAX, this.tzq, true);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242849);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class at implements View.OnClickListener {
        final /* synthetic */ l tAp;

        at(l lVar) {
            this.tAp = lVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242852);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MMActivity activity = this.tAp.tAi.getActivity();
            if (activity != null) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.h(activity, ".ui.FinderHomeUI");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242852);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class au implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderPostProgressView tAY;

        au(FinderPostProgressView finderPostProgressView) {
            this.tAY = finderPostProgressView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(242853);
            FinderPostProgressView finderPostProgressView = this.tAY;
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(242853);
                throw tVar;
            }
            finderPostProgressView.setProgress(((Integer) animatedValue).intValue());
            this.tAY.invalidate();
            AppMethodBeat.o(242853);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class av implements View.OnClickListener {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        av(l lVar, BaseFinderFeed baseFinderFeed) {
            this.tAp = lVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165378);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            l.a(this.tAr, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165378);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class aw implements View.OnClickListener {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        aw(l lVar, BaseFinderFeed baseFinderFeed) {
            this.tAp = lVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242854);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            l.a(this.tAr, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242854);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ax implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAr;

        ax(BaseFinderFeed baseFinderFeed) {
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242855);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g.vSH.t(this.tAr.feedObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242855);
        }
    }

    public final void a(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem) {
        FinderImgFeedMusicTag finderImgFeedMusicTag;
        azr azr;
        azr azr2;
        FinderObjectDesc finderObjectDesc;
        azr azr3;
        azk azk;
        azr azr4;
        azr azr5;
        azr azr6 = null;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(finderItem, "finderItem");
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((com.tencent.mm.plugin.i.a.ad) af2).dxX()) {
            Log.i("Finder.FeedConvert", "refreshBgmTag return for 青少年模式");
            return;
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.D(finderItem)) {
            Log.i("Finder.FeedConvert", "refreshBgmTag: this feed has long video attachment, do not need to refresh bgm");
            return;
        }
        FinderImgFeedMusicTag finderImgFeedMusicTag2 = (FinderImgFeedMusicTag) hVar.aus.findViewById(R.id.a38);
        kotlin.g.b.p.g(finderImgFeedMusicTag2, "tag");
        finderImgFeedMusicTag2.setVisibility(8);
        finderImgFeedMusicTag2.setTag(R.id.d0m, Boolean.FALSE);
        if (this.tAh == 1) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.x(finderItem.getFeedObject())) {
                finderImgFeedMusicTag = null;
            } else {
                finderImgFeedMusicTag = finderImgFeedMusicTag2;
            }
            if (finderImgFeedMusicTag != null) {
                finderImgFeedMusicTag.setTag(R.id.d0m, Boolean.TRUE);
                if (finderItem.getMediaType() == 2) {
                    FinderObjectDesc finderObjectDesc2 = finderItem.getFeedObject().objectDesc;
                    if (finderObjectDesc2 != null) {
                        azr2 = finderObjectDesc2.feedBgmInfo;
                    } else {
                        azr2 = null;
                    }
                    if (azr2 != null && ((finderObjectDesc = finderItem.getFeedObject().objectDesc) == null || (azr5 = finderObjectDesc.feedBgmInfo) == null || azr5.LJw != 0)) {
                        FinderObjectDesc finderObjectDesc3 = finderItem.getFeedObject().objectDesc;
                        String str = (finderObjectDesc3 == null || (azr4 = finderObjectDesc3.feedBgmInfo) == null) ? null : azr4.groupId;
                        if (!(str == null || str.length() == 0)) {
                            FinderObjectDesc finderObjectDesc4 = finderItem.getFeedObject().objectDesc;
                            if (finderObjectDesc4 != null && (azr3 = finderObjectDesc4.feedBgmInfo) != null && (azk = azr3.musicInfo) != null) {
                                finderImgFeedMusicTag.a(azk);
                                finderImgFeedMusicTag.setViewPager((FinderMediaBanner) hVar.Mn(R.id.fbd));
                                return;
                            }
                            return;
                        }
                    }
                    finderImgFeedMusicTag.setVisibility(8);
                    finderImgFeedMusicTag.dle();
                    finderImgFeedMusicTag.setViewPager(null);
                } else if (finderItem.getMediaType() == 4) {
                    FinderObjectDesc finderObjectDesc5 = finderItem.getFeedObject().objectDesc;
                    if (finderObjectDesc5 != null) {
                        azr6 = finderObjectDesc5.feedBgmInfo;
                    }
                    if (azr6 != null) {
                        FinderObjectDesc finderObjectDesc6 = finderItem.getFeedObject().objectDesc;
                        if (finderObjectDesc6 == null || (azr = finderObjectDesc6.feedBgmInfo) == null || azr.LJw != 1) {
                            finderImgFeedMusicTag.setVisibility(8);
                        }
                    }
                }
            }
        }
    }

    private final void d(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        Log.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + t2.feedObject.field_id + ", localId:" + t2.feedObject.getLocalId() + ", " + t2.feedObject.getFeedObject().commentClose + " pos:" + hVar.lR());
        t2.feedObject.getFeedObject();
        if (t2.feedObject.getCommentCount() <= 0) {
            t2.feedObject.getCommentList().size();
        }
        if (t2.feedObject.getLikeCount() <= 0) {
            t2.feedObject.getLikeList().size();
        }
        FinderFeedExposeLayout finderFeedExposeLayout = (FinderFeedExposeLayout) hVar.Mn(R.id.b92);
        kotlin.g.b.p.g(finderFeedExposeLayout, "exposeLayout");
        finderFeedExposeLayout.setVisibility(0);
        finderFeedExposeLayout.setOnCommentLongClickListener(new af(this, hVar, t2));
        finderFeedExposeLayout.setOnCommentClickListener(new ag(this, hVar, t2));
        View view = hVar.aus;
        kotlin.g.b.p.g(view, "holder.itemView");
        finderFeedExposeLayout.a(view, t2.feedObject, t2.feedObject.getCommentList(), t2.feedObject.getCommentCount(), t2.feedObject.getLikeCount(), t2.feedObject.getFriendLikeCount(), new ah(this, t2));
        if (Util.isNullOrNil(t2.feedObject.getCommentList())) {
            finderFeedExposeLayout.setVisibility(8);
        } else {
            finderFeedExposeLayout.setVisibility(0);
        }
        ImageView imageView = (ImageView) hVar.Mn(R.id.hj8);
        if (t2.feedObject.isCommentClose()) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.In(t2.feedObject.field_username)) {
                kotlin.g.b.p.g(imageView, "commentIcon");
                imageView.setImageDrawable(com.tencent.mm.ui.ar.m(imageView.getContext(), R.raw.icon_outlined_close_comment, com.tencent.mm.cb.a.n(imageView.getContext(), R.color.fo)));
                View Mn = hVar.Mn(R.id.hj7);
                Mn.setOnClickListener(new ai(finderFeedExposeLayout, Mn));
            }
        }
        kotlin.g.b.p.g(imageView, "commentIcon");
        imageView.setImageDrawable(com.tencent.mm.ui.ar.m(imageView.getContext(), R.raw.icons_outlined_comment, com.tencent.mm.cb.a.n(imageView.getContext(), R.color.fo)));
        View Mn2 = hVar.Mn(R.id.hj7);
        Mn2.setOnClickListener(new ai(finderFeedExposeLayout, Mn2));
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ai implements View.OnClickListener {
        final /* synthetic */ FinderFeedExposeLayout tAS;
        final /* synthetic */ View tAT;

        ai(FinderFeedExposeLayout finderFeedExposeLayout, View view) {
            this.tAS = finderFeedExposeLayout;
            this.tAT = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242841);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.m<View, FinderCommentInfo, kotlin.x> onCommentClickListener = this.tAS.getOnCommentClickListener();
            if (onCommentClickListener != null) {
                View view2 = this.tAT;
                kotlin.g.b.p.g(view2, "selfCommentContainer");
                onCommentClickListener.invoke(view2, null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242841);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ l tAp;
        final /* synthetic */ FinderCommentInfo tAq;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ String tAs;
        final /* synthetic */ long txv;

        e(l lVar, Context context, FinderCommentInfo finderCommentInfo, BaseFinderFeed baseFinderFeed, long j2, String str) {
            this.tAp = lVar;
            this.$context = context;
            this.tAq = finderCommentInfo;
            this.tAr = baseFinderFeed;
            this.txv = j2;
            this.tAs = str;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a tAt = new a();

            static {
                AppMethodBeat.i(165342);
                AppMethodBeat.o(165342);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            long j2;
            AppMethodBeat.i(165347);
            Dialog dialog = this.tAp.tipDialog;
            if (dialog != null) {
                dialog.show();
            } else {
                l lVar = this.tAp;
                Context context = this.$context;
                this.$context.getString(R.string.zb);
                lVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.$context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tAt);
            }
            b bVar = new b(this, new d(this), new c(this));
            if (this.tAq.commentId != 0) {
                bVar.invoke();
                AppMethodBeat.o(165347);
                return;
            }
            com.tencent.mm.plugin.finder.storage.a finderActionStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage();
            String str = this.tAq.client_id;
            if (str != null) {
                j2 = Long.parseLong(str);
            } else {
                j2 = 0;
            }
            finderActionStorage.Fv(j2);
            AppMethodBeat.o(165347);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ e tAu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(e eVar) {
                super(0);
                this.tAu = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(165346);
                Dialog dialog = this.tAu.tAp.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (this.tAu.tAq.commentId == 0) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    LinkedList<FinderCommentInfo> commentList = this.tAu.tAr.feedObject.getCommentList();
                    long j2 = this.tAu.txv;
                    String str = this.tAu.tAq.client_id;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.finder.utils.y.a(commentList, j2, 0, str);
                }
                c.a aVar = com.tencent.mm.plugin.finder.feed.model.c.tUN;
                com.tencent.mm.plugin.finder.storage.data.f.vGd.FF(this.tAu.tAr.feedObject.getId());
                com.tencent.mm.ui.base.u.makeText(this.tAu.$context, (int) R.string.cl9, 0).show();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165346);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ e tAu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(e eVar) {
                super(0);
                this.tAu = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(165345);
                Dialog dialog = this.tAu.tAp.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                com.tencent.mm.ui.base.u.makeText(this.tAu.$context, (int) R.string.d6i, 0).show();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165345);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ e tAu;
            final /* synthetic */ kotlin.g.a.a tAv;
            final /* synthetic */ kotlin.g.a.a tAw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar, kotlin.g.a.a aVar, kotlin.g.a.a aVar2) {
                super(0);
                this.tAu = eVar;
                this.tAv = aVar;
                this.tAw = aVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(165344);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tAu.$context);
                new com.tencent.mm.plugin.finder.cgi.b(this.tAu.tAq.commentId, this.tAu.txv, this.tAu.tAs, 2, fH != null ? fH.dIx() : null).aYI().b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.finder.convert.l.e.b.AnonymousClass1 */
                    final /* synthetic */ b tAx;

                    {
                        this.tAx = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(165343);
                        c.a aVar = (c.a) obj;
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            this.tAx.tAv.invoke();
                        } else {
                            this.tAx.tAw.invoke();
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(165343);
                        return xVar;
                    }
                });
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(165344);
                return xVar;
            }
        }
    }

    public static /* synthetic */ void a(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, boolean z2, long j2, com.tencent.mm.plugin.finder.storage.an anVar, int i2, int i3, int i4) {
        com.tencent.mm.plugin.finder.storage.an anVar2;
        int i5;
        int i6;
        FinderCommentDrawer finderCommentDrawer;
        FrameLayout footerLayout;
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            j2 = 0;
        }
        if ((i4 & 16) != 0) {
            anVar2 = null;
        } else {
            anVar2 = anVar;
        }
        if ((i4 & 32) != 0) {
            i5 = -1;
        } else {
            i5 = i2;
        }
        if ((i4 & 64) != 0) {
            i6 = 0;
        } else {
            i6 = i3;
        }
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(baseFinderFeed, "item");
        com.tencent.mm.plugin.finder.view.e dcg = lVar.tAi.dcg();
        z.d dVar = new z.d();
        dVar.SYE = 0;
        if (z2) {
            if (i5 < 0) {
                lVar.rect.setEmpty();
                hVar.aus.getGlobalVisibleRect(lVar.rect);
                i5 = lVar.rect.bottom;
            }
            hVar.getRecyclerView().getGlobalVisibleRect(lVar.rect);
            int i7 = lVar.rect.bottom - i5;
            View findViewById = (dcg == null || (finderCommentDrawer = dcg.tNb) == null || (footerLayout = finderCommentDrawer.getFooterLayout()) == null) ? null : footerLayout.findViewById(R.id.b8r);
            if (findViewById != null) {
                findViewById.postDelayed(new ac(lVar, findViewById, hVar, i7, i5), 200);
            }
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtx().value().intValue() == 1) {
                hVar.getRecyclerView().kQ();
                hVar.aus.findViewById(R.id.fbd).getGlobalVisibleRect(lVar.rect);
                int i8 = lVar.rect.top;
                hVar.getRecyclerView().getGlobalVisibleRect(lVar.rect);
                dVar.SYE = i8 - lVar.rect.top;
                Log.d("Finder.FeedConvert", "[openCommentDrawer] offset=" + dVar.SYE + ' ' + hVar.getRecyclerView());
                hVar.getRecyclerView().smoothScrollBy(0, dVar.SYE);
            }
        }
        ad adVar = new ad(lVar, hVar, baseFinderFeed, dVar);
        if (hVar.getContext() instanceof MMActivity) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = hVar.getContext();
            if (context == null) {
                throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            }
            com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class));
            if (b2 != null) {
                b2.cZR().En(baseFinderFeed.lT());
            }
        }
        boolean z3 = false;
        if (!lVar.tAi.dbZ()) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.h(baseFinderFeed)) {
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    com.tencent.mm.plugin.finder.storage.c.KQ(2);
                    z3 = true;
                }
            }
        }
        if (dcg != null) {
            dcg.a(baseFinderFeed.feedObject, z2, j2, j2 != 0, true, anVar2, z3, i6, adVar);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class ac implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ View tAL;
        final /* synthetic */ int tAM;
        final /* synthetic */ int tAN;
        final /* synthetic */ l tAp;

        ac(l lVar, View view, com.tencent.mm.view.recyclerview.h hVar, int i2, int i3) {
            this.tAp = lVar;
            this.tAL = view;
            this.qhp = hVar;
            this.tAM = i2;
            this.tAN = i3;
        }

        public final void run() {
            AppMethodBeat.i(242838);
            int height = this.tAL.getHeight();
            int keyBordHeightPx = (KeyBoardUtil.getKeyBordHeightPx(this.qhp.getContext()) - this.tAM) + height;
            Log.i("Finder.FeedConvert", "[openCommentDrawer] offset=" + keyBordHeightPx + " itemBottom=" + this.tAN + " recyclerViewBottom=" + this.tAp.rect.bottom + " editLayoutHeight=" + height);
            if (keyBordHeightPx > 0) {
                FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tAp.tAi.getVideoCore().weS;
                if (finderVideoAutoPlayManager != null) {
                    FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, "openCommentDrawer", true);
                }
                this.qhp.getRecyclerView().smoothScrollBy(0, keyBordHeightPx);
            }
            AppMethodBeat.o(242838);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
    public static final class ad implements CommentDrawerContract.CloseDrawerCallback {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ z.d tAO;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        ad(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, z.d dVar) {
            this.tAp = lVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
            this.tAO = dVar;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
        public final void g(int i2, List<? extends com.tencent.mm.plugin.finder.model.s> list) {
            AppMethodBeat.i(242839);
            kotlin.g.b.p.h(list, "data");
            ((FinderFeedExposeLayout) this.qhp.Mn(R.id.b92)).Mo(this.tAr.feedObject.getCommentCount());
            FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tAp.tAi.getVideoCore().weS;
            if (finderVideoAutoPlayManager != null) {
                FinderVideoAutoPlayManager.a(finderVideoAutoPlayManager, "openCommentDrawer", false);
            }
            if (this.tAp.tAi.dbZ()) {
                View Mn = this.qhp.Mn(R.id.hj9);
                kotlin.g.b.p.g(Mn, "holder.getView<TextView>…id.self_comment_count_tv)");
                ((TextView) Mn).setText(com.tencent.mm.plugin.finder.utils.k.gm(1, this.tAr.feedObject.getCommentCount()));
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtx().value().intValue() == 1) {
                this.qhp.getRecyclerView().smoothScrollBy(0, -this.tAO.SYE);
            }
            AppMethodBeat.o(242839);
        }
    }

    public void a(com.tencent.mm.view.recyclerview.h hVar, View view, FinderObject finderObject) {
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(finderObject, "finderObj");
    }

    public void a(com.tencent.mm.view.recyclerview.h hVar, View view) {
        boolean z2;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(view, "view");
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
                WeImageView weImageView = (WeImageView) hVar.Mn(R.id.ebe);
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
                    kotlin.g.b.p.g(weImageView, "likeIconBanner");
                    Drawable drawable = weImageView.getDrawable();
                    if (drawable != null) {
                        drawable.clearColorFilter();
                    }
                    weImageView.setClearColorFilter(true);
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                } else {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (com.tencent.mm.plugin.finder.utils.y.i(baseFinderFeed.contact)) {
                        Context context = hVar.getContext();
                        Context context2 = hVar.getContext();
                        kotlin.g.b.p.g(context2, "holder.context");
                        weImageView.setImageDrawable(com.tencent.mm.ui.ar.m(context, R.raw.finder_filled_like_lock, context2.getResources().getColor(R.color.Red_90)));
                    } else {
                        Context context3 = hVar.getContext();
                        Context context4 = hVar.getContext();
                        kotlin.g.b.p.g(context4, "holder.context");
                        weImageView.setImageDrawable(com.tencent.mm.ui.ar.m(context3, R.raw.icon_filled_awesome, context4.getResources().getColor(R.color.Red_90)));
                    }
                }
                com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                kotlin.g.b.p.g(weImageView, "likeIconBanner");
                com.tencent.mm.plugin.finder.view.animation.c.a((View) weImageView, 0.0f, (MotionEvent) null, false, 30);
                return;
            }
            a(hVar, 2, false);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
    public static final class bc implements Runnable {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        bc(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void run() {
            int i2;
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(165379);
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            if (baseFinderFeed == null) {
                Log.w("Finder.FeedConvert", "item is null??");
                AppMethodBeat.o(165379);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.qhp.Mn(R.id.aq9);
            kotlin.g.b.p.g(linearLayout, "centerLl");
            if (linearLayout.getWidth() > 0) {
                ImageView imageView = (ImageView) this.qhp.Mn(R.id.w0);
                TextView textView = (TextView) this.qhp.Mn(R.id.d88);
                kotlin.g.b.p.g(imageView, "authIconIv");
                if (imageView.getVisibility() == 0) {
                    i2 = imageView.getWidth();
                } else {
                    i2 = 0;
                }
                kotlin.g.b.p.g(textView, "followTv");
                if (textView.getVisibility() != 0) {
                    i3 = 0;
                } else if (textView.getText() != null) {
                    float aG = (float) com.tencent.mm.cb.a.aG(this.qhp.getContext(), R.dimen.ci);
                    TextPaint paint = textView.getPaint();
                    CharSequence text = textView.getText();
                    CharSequence text2 = textView.getText();
                    if (text2 != null) {
                        i5 = text2.length();
                    } else {
                        i5 = 0;
                    }
                    i3 = (int) (paint.measureText(text, 0, i5) + aG);
                } else {
                    i3 = textView.getWidth();
                }
                TextView textView2 = (TextView) this.qhp.Mn(R.id.fzc);
                kotlin.g.b.p.g(textView2, "nicknameTv");
                TextPaint paint2 = textView2.getPaint();
                SpannableString nickNameSpan = baseFinderFeed.feedObject.getNickNameSpan();
                SpannableString nickNameSpan2 = baseFinderFeed.feedObject.getNickNameSpan();
                if (nickNameSpan2 != null) {
                    i4 = nickNameSpan2.length();
                } else {
                    i4 = 0;
                }
                if (paint2.measureText(nickNameSpan, 0, i4) + ((float) (i2 + i3)) > ((float) linearLayout.getWidth())) {
                    textView2.setText(TextUtils.ellipsize(baseFinderFeed.feedObject.getNickNameSpan(), textView2.getPaint(), (float) ((linearLayout.getWidth() - i2) - i3), TextUtils.TruncateAt.END));
                    AppMethodBeat.o(165379);
                    return;
                }
            }
            this.qhp.e(R.id.fzc, baseFinderFeed.feedObject.getNickNameSpan());
            AppMethodBeat.o(165379);
        }
    }

    protected static void a(FinderMediaBanner finderMediaBanner, List<? extends cjl> list, long j2) {
        boolean z2;
        boolean z3 = true;
        kotlin.g.b.p.h(finderMediaBanner, "banner");
        kotlin.g.b.p.h(list, "mediaList");
        if (kotlin.a.j.kt(list) == null) {
            Log.e("Finder.FeedConvert", "feedId=" + j2 + " mediaList first null");
            return;
        }
        r0 = (cjl) kotlin.a.j.ks(list);
        float f2 = 0.0f;
        for (T t2 : list) {
            Size a2 = com.tencent.mm.plugin.finder.storage.data.j.a(t2, false);
            float height = (1.0f * ((float) a2.getHeight())) / ((float) a2.getWidth());
            if (f2 >= height) {
                height = f2;
                t2 = t2;
            }
            f2 = height;
        }
        Size a3 = com.tencent.mm.plugin.finder.storage.data.j.a(t2, false);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        Context context = finderMediaBanner.getContext();
        kotlin.g.b.p.g(context, "banner.context");
        kotlin.r<Integer, Integer, Integer> g2 = com.tencent.mm.plugin.finder.utils.y.g(context, a3.getWidth(), a3.getHeight());
        ViewGroup.LayoutParams layoutParams = finderMediaBanner.getPagerView().getLayoutParams();
        if (layoutParams.width != g2.second.intValue()) {
            layoutParams.width = g2.second.intValue();
            z2 = true;
        } else {
            z2 = false;
        }
        if (layoutParams.height != g2.SWY.intValue()) {
            layoutParams.height = g2.SWY.intValue();
        } else {
            z3 = z2;
        }
        if (z3) {
            finderMediaBanner.requestLayout();
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
                Mn.setOnClickListener(new ae(this, hVar, t2, i2));
                return;
            }
        }
        kotlin.g.b.p.g(Mn, "layout");
        Mn.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ae implements View.OnClickListener {
        final /* synthetic */ int kVT;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAr;

        ae(l lVar, com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, int i2) {
            this.tAp = lVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
            this.kVT = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242840);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            com.tencent.mm.plugin.finder.storage.c.KQ(2);
            l.a(this.tAp, this.qhp, this.tAr, true, 0, null, rect.top - com.tencent.mm.view.d.e(this.qhp.getContext(), 16.0f), this.kVT, 24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242840);
        }
    }

    private static void e(T t2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.g.b.p.h(t2, "item");
        kotlin.g.b.p.h(hVar, "holder");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
    public static final class ay extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ z.a tAZ;
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ z.a tBa;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ boolean tBg;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ay(z.a aVar, z.a aVar2, l lVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2, boolean z3) {
            super(0);
            this.tAZ = aVar;
            this.tBa = aVar2;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
            this.tBg = z3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(242856);
            if (!this.tBc || !this.tAZ.SYB || this.tBa.SYB || this.tBd.size() <= 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242856);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
    public static final class az extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ l tAp;
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ float tBb;
        final /* synthetic */ boolean tBc;
        final /* synthetic */ LinkedList tBd;
        final /* synthetic */ boolean tBe;
        final /* synthetic */ int tBf;
        final /* synthetic */ boolean tBg;
        final /* synthetic */ List tBh;
        final /* synthetic */ List tBi;
        final /* synthetic */ z.f tBj;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        az(List list, List list2, z.f fVar, l lVar, com.tencent.mm.view.recyclerview.h hVar, float f2, BaseFinderFeed baseFinderFeed, boolean z, LinkedList linkedList, boolean z2, int i2, boolean z3) {
            super(0);
            this.tBh = list;
            this.tBi = list2;
            this.tBj = fVar;
            this.tAp = lVar;
            this.tzq = hVar;
            this.tBb = f2;
            this.tAz = baseFinderFeed;
            this.tBc = z;
            this.tBd = linkedList;
            this.tBe = z2;
            this.tBf = i2;
            this.tBg = z3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            String str;
            AppMethodBeat.i(242857);
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
                        if (((Boolean) this.tBj.SYG.invoke()).booleanValue()) {
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
            if (((Boolean) this.tBj.SYG.invoke()).booleanValue()) {
                LinkedList linkedList = this.tBd;
                List list = this.tBi;
                View view4 = this.tzq.aus;
                kotlin.g.b.p.g(view4, "holder.itemView");
                l.a(linkedList, list, view4, this.tAp.tAg);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(242857);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0216, code lost:
        if (r2 == null) goto L_0x0218;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x05ca  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x05cd  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x08a5  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x08af  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x08b9  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0916  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0926  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0936  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x099b  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x09eb  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0a4d  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0a9a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.view.recyclerview.h r13, T r14, int r15, int r16, boolean r17, java.util.List<java.lang.Object> r18) {
        /*
        // Method dump skipped, instructions count: 2754
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.l.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List):void");
    }

    static /* synthetic */ void a(String str, List list, BaseFinderFeed baseFinderFeed, com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.bw.b bVar, boolean z2) {
        Log.i("Finder.FeedConvert", "jumpRelatedUI item " + baseFinderFeed + ", needRefresh:" + z2 + ", initSize:" + list.size());
        Intent intent = new Intent();
        intent.putExtra("FEED_ID", baseFinderFeed.feedObject.getId());
        intent.putExtra("FEED_NONCE_ID", baseFinderFeed.feedObject.getObjectNonceId());
        intent.putExtra("TITLE_WORDING", str);
        intent.putExtra("AUTO_REFRESH", z2);
        intent.putExtra("GET_REL_SCENE", 5);
        if (!z2) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.a(0, list, bVar, intent);
        }
        FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
        FinderFoldedScrollLayout.Gu(cl.aWA());
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.W(context, intent);
    }

    public com.tencent.mm.bw.b a(T t2) {
        kotlin.g.b.p.h(t2, "item");
        return t2.likeBuffer;
    }

    private static void b(BaseFinderFeed baseFinderFeed) {
        for (T t2 : baseFinderFeed.feedObject.getMediaList()) {
            if (t2.mediaType <= 0) {
                t2.mediaType = baseFinderFeed.feedObject.getMediaType();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.mm.plugin.finder.convert.l */
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void a(l lVar, com.tencent.mm.view.recyclerview.h hVar) {
        String str;
        View Mn;
        String str2 = null;
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
        lVar.tAi.a(baseFinderFeed.feedObject, z2, hVar);
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtS().value().intValue() == 1 && (Mn = hVar.Mn(R.id.ccz)) != null) {
                com.tencent.mm.plugin.finder.view.animation.b bVar = com.tencent.mm.plugin.finder.view.animation.b.wry;
                com.tencent.mm.plugin.finder.view.animation.b.ei(Mn);
            }
        }
        if (lVar.tAj && z2) {
            com.tencent.mm.ui.base.u.makeText(hVar.getContext(), (int) R.string.d3d, 0).show();
        }
        boolean z3 = baseFinderFeed.triggerConfig.vDT;
        boolean z4 = baseFinderFeed.triggerConfig.vDU;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dud().value().intValue() == 1) {
            z4 = true;
            z3 = true;
        }
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtP() > 0) {
                Context context2 = hVar.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                if (lVar.fk(context2)) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    long j2 = baseFinderFeed.feedObject.field_id;
                    kotlin.g.b.p.h(context3, "context");
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                    bbn dIx = fH != null ? fH.dIx() : null;
                    bu buVar = new bu();
                    if (dIx != null) {
                        str = dIx.sGE;
                    } else {
                        str = null;
                    }
                    buVar.ki(str);
                    buVar.eH(dIx != null ? (long) dIx.tCE : 0);
                    if (dIx != null) {
                        str2 = dIx.sGQ;
                    }
                    buVar.kj(str2);
                    buVar.kh(com.tencent.mm.ac.d.zs(j2));
                    buVar.bfK();
                    com.tencent.mm.plugin.finder.report.k.a(buVar);
                    a(hVar, true);
                    return;
                }
            }
            kotlin.g.b.p.g(baseFinderFeed, "item");
            lVar.a(baseFinderFeed, hVar, z3, z4, true);
        }
    }

    public static final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, BaseFinderFeed baseFinderFeed, String str) {
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
        Log.i("Finder.FeedConvert", "click linkLayout, url:" + str + ", urlWithReportParams:" + d2);
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

    public static final /* synthetic */ void a(LinkedList linkedList, List list, View view, boolean z2) {
        com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        com.tencent.mm.plugin.finder.view.animation.c.c(linkedList, list, view, z2);
    }

    public static final /* synthetic */ void b(l lVar, com.tencent.mm.view.recyclerview.h hVar, boolean z2) {
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        if (baseFinderFeed.feedObject.getLocalId() <= 0) {
            Log.i("Finder.FeedConvert", "localId invalid, " + baseFinderFeed.feedObject.getLocalId());
            return;
        }
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean z3 = !com.tencent.mm.plugin.finder.upload.action.j.vUv.Ga(baseFinderFeed.feedObject.getLocalId()).first.booleanValue();
        Log.i("Finder.FeedConvert", "likeLocalFeed " + baseFinderFeed.feedObject.getLocalId() + ", isLike:" + z3 + ", isPrivate:" + z2);
        if (z2) {
            a(hVar);
        }
        if (lVar.tAi instanceof com.tencent.mm.plugin.finder.feed.at) {
            kotlin.g.b.p.g(baseFinderFeed, "item");
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(((com.tencent.mm.plugin.finder.feed.at) lVar.tAi).gte).get(FinderReporterUIC.class)).dIx();
            j.a aVar3 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            com.tencent.mm.plugin.finder.upload.action.j.vUv.a(baseFinderFeed.feedObject.getLocalId(), dIx, z3, baseFinderFeed.showLikeTips, z2);
        } else if (lVar.tAi instanceof ab.b) {
            kotlin.g.b.p.g(baseFinderFeed, "item");
            kotlin.g.b.p.h(baseFinderFeed, "feed");
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            bbn dIx2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(((ab.b) lVar.tAi).gte).get(FinderReporterUIC.class)).dIx();
            j.a aVar5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            com.tencent.mm.plugin.finder.upload.action.j.vUv.a(baseFinderFeed.feedObject.getLocalId(), dIx2, z3, baseFinderFeed.showLikeTips, z2);
        }
        a(z3, hVar, z2);
        kotlin.g.b.p.g(baseFinderFeed, "item");
        lVar.a((l) z3, (boolean) hVar, (com.tencent.mm.view.recyclerview.h) baseFinderFeed, (BaseFinderFeed) false);
    }

    public static final /* synthetic */ void a(l lVar, Context context, FinderCommentInfo finderCommentInfo, long j2, String str, BaseFinderFeed baseFinderFeed) {
        com.tencent.mm.ui.base.h.a(context, (int) R.string.d6h, 0, new e(lVar, context, finderCommentInfo, baseFinderFeed, j2, str), (DialogInterface.OnClickListener) null);
    }
}

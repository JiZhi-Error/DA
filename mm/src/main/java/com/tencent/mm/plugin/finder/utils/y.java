package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.search.f;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.c;
import com.tencent.mm.plugin.finder.view.n;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.r;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y {
    private static final String TAG = TAG;
    public static int UVj = com.tencent.mm.plugin.finder.storage.c.hVa().value().intValue();
    private static final boolean aXs = BuildInfo.DEBUG;
    private static final int heightPixels;
    private static long lastClickTime;
    private static long tCi = -1;
    public static int vXA = com.tencent.mm.plugin.finder.storage.c.dwr().value().intValue();
    private static int vXB = com.tencent.mm.plugin.finder.storage.c.dws().value().intValue();
    private static int vXC = com.tencent.mm.plugin.finder.storage.c.dwt().value().intValue();
    private static int vXD = com.tencent.mm.plugin.finder.storage.c.dwu().value().intValue();
    private static int vXE = com.tencent.mm.plugin.finder.storage.c.dww().value().intValue();
    private static int vXF = com.tencent.mm.plugin.finder.storage.c.dwv().value().intValue();
    private static int vXG = com.tencent.mm.plugin.finder.storage.c.dwx().value().intValue();
    public static final y vXH = new y();
    private static final int vXu;
    private static final int vXv;
    private static final Set<Integer> vXw = ak.setOf((Object) 2013);
    private static final Rect vXx = new Rect();
    private static JSONObject vXy;
    private static boolean vXz = true;
    private static final int vfH = com.tencent.mm.plugin.finder.storage.c.dvI().value().intValue();

    static {
        AppMethodBeat.i(167970);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        vXu = (int) context.getResources().getDimension(R.dimen.c5);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        vXv = (int) context2.getResources().getDimension(R.dimen.ag3);
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        Resources resources = context3.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        heightPixels = resources.getDisplayMetrics().heightPixels;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar9 = com.tencent.mm.plugin.finder.storage.c.vCb;
        AppMethodBeat.o(167970);
    }

    private y() {
    }

    public static Set<Integer> dCz() {
        return vXw;
    }

    public static int dCA() {
        AppMethodBeat.i(261478);
        int aWy = (int) (cl.aWy() / 1000);
        AppMethodBeat.o(261478);
        return aWy;
    }

    public static com.tencent.mm.plugin.sight.base.a awl(String str) {
        AppMethodBeat.i(167939);
        p.h(str, "filePath");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(167939);
            return null;
        }
        com.tencent.mm.plugin.sight.base.a cc = com.tencent.mm.plugin.sight.base.e.cc(str, true);
        if (cc == null) {
            cc = new com.tencent.mm.plugin.sight.base.a();
        }
        if (cc.height <= 0 || cc.width <= 0) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(s.k(str, false));
                cc.width = Util.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                cc.height = Util.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                cc.videoBitrate = Util.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
            }
        }
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str);
        Log.i(TAG, "width %d, height %d, rotate %d", Integer.valueOf(cc.width), Integer.valueOf(cc.height), Integer.valueOf(mp4RotateVFS));
        if (mp4RotateVFS == 270 || mp4RotateVFS == 90) {
            int i2 = cc.height;
            cc.height = cc.width;
            cc.width = i2;
        }
        AppMethodBeat.o(167939);
        return cc;
    }

    public static Point awm(String str) {
        AppMethodBeat.i(167940);
        p.h(str, "filePath");
        Point point = new Point();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(str, options);
        point.x = options.outWidth;
        point.y = options.outHeight;
        Exif fromFile = Exif.fromFile(str);
        p.g(fromFile, "Exif.fromFile(filePath)");
        if (fromFile.getOrientationInDegree() % TXLiveConstants.RENDER_ROTATION_180 != 0) {
            int i2 = point.y;
            point.y = point.x;
            point.x = i2;
        }
        AppMethodBeat.o(167940);
        return point;
    }

    public static long Lz(int i2) {
        return ((long) i2) * 1000;
    }

    public static int Gg(long j2) {
        return (int) (j2 / 1000);
    }

    public static int a(BaseFinderFeed baseFinderFeed, cjl cjl, int i2) {
        int i3 = 0;
        AppMethodBeat.i(253585);
        p.h(baseFinderFeed, "item");
        p.h(cjl, "mediaObj");
        if (i2 > 0) {
            Size a2 = com.tencent.mm.plugin.finder.storage.data.j.a(cjl, false);
            if (baseFinderFeed.feedObject.isLiveFeed() || a2.getWidth() <= 0) {
                i3 = (int) ((3.5d * ((double) i2)) / 3.0d);
            } else {
                i3 = (a2.getHeight() * i2) / a2.getWidth();
            }
            if (((float) i3) > ((float) i2) * 1.3166667f) {
                i3 = (int) (((float) i2) * 1.3166667f);
            } else if (((float) i3) < ((float) i2) * 0.95f) {
                i3 = (int) (((float) i2) * 0.95f);
                Log.i(TAG, "calculateStaggeredLayoutParams: originWidth:" + i2 + " targetHeightL:" + i3);
            }
            AppMethodBeat.o(253585);
        } else {
            AppMethodBeat.o(253585);
        }
        return i3;
    }

    public static /* synthetic */ void a(Activity activity, float f2, float f3, View view) {
        AppMethodBeat.i(253587);
        a(activity, f2, f3, view, (cjx) null);
        AppMethodBeat.o(253587);
    }

    public static void a(Activity activity, float f2, float f3, View view, cjx cjx) {
        LinkedList<Float> linkedList;
        LinkedList<Float> linkedList2;
        AppMethodBeat.i(253586);
        p.h(activity, "context");
        p.h(view, "targetView");
        r<Integer, Integer, Integer> a2 = a(activity, f2, f3);
        int intValue = a2.second.intValue();
        int intValue2 = a2.SWY.intValue();
        if (cjx != null) {
            float f4 = ((float) intValue) / f2;
            if (Float.compare(1.0f, f4) != 0) {
                bej bej = cjx.Mpr;
                if (bej == null) {
                    bej = new bej();
                }
                p.g(bej, "it.matrix ?: FinderViewMatrix()");
                Matrix matrix = new Matrix();
                LinkedList<Float> linkedList3 = bej.LOe;
                p.g(linkedList3, "originMatrix.value");
                matrix.setValues(kotlin.a.j.t((Collection<Float>) linkedList3));
                matrix.postScale(f4, f4);
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                bej bej2 = cjx.Mpr;
                if (!(bej2 == null || (linkedList2 = bej2.LOe) == null)) {
                    linkedList2.clear();
                }
                bej bej3 = cjx.Mpr;
                if (!(bej3 == null || (linkedList = bej3.LOe) == null)) {
                    linkedList.addAll(kotlin.a.e.s(fArr));
                }
                cjx.width = intValue;
                cjx.height = intValue2;
                erf erf = cjx.Mpq;
                if (erf != null) {
                    erf.left = 0;
                }
                erf erf2 = cjx.Mpq;
                if (erf2 != null) {
                    erf2.right = intValue;
                }
                erf erf3 = cjx.Mpq;
                if (erf3 != null) {
                    erf3.top = intValue2;
                }
                erf erf4 = cjx.Mpq;
                if (erf4 != null) {
                    erf4.bottom = 0;
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(intValue, intValue2);
        }
        layoutParams.width = intValue;
        layoutParams.height = intValue2;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(253586);
    }

    public static r<Integer, Integer, Integer> a(Activity activity, float f2, float f3) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(253588);
        p.h(activity, "context");
        Point az = ao.az(activity);
        boolean z = (az.x == 0 || az.y == 0) ? false : true;
        if (z) {
            i2 = az.y;
        } else {
            Resources resources = activity.getResources();
            p.g(resources, "context.resources");
            i2 = resources.getDisplayMetrics().heightPixels;
        }
        if (z) {
            i3 = az.x;
        } else {
            Resources resources2 = activity.getResources();
            p.g(resources2, "context.resources");
            i3 = resources2.getDisplayMetrics().widthPixels;
        }
        if (f3 / f2 > ((float) i2) / ((float) i3)) {
            i4 = i2;
        } else {
            i4 = (int) ((((float) i3) * f3) / f2);
        }
        if (i2 == i4) {
            i3 = (int) ((((float) i2) * f2) / f3);
        }
        r<Integer, Integer, Integer> rVar = new r<>(Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(253588);
        return rVar;
    }

    public static r<Integer, Integer, Integer> g(Context context, int i2, int i3) {
        int bj;
        int i4;
        AppMethodBeat.i(253589);
        p.h(context, "context");
        if (context instanceof Activity) {
            context = ((Activity) context).getBaseContext();
        }
        p.g(context, "baseContext");
        Resources resources = context.getResources();
        p.g(resources, "baseContext.resources");
        int i5 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = context.getResources();
        p.g(resources2, "baseContext.resources");
        int na = kotlin.k.j.na(i5, resources2.getDisplayMetrics().heightPixels);
        float f2 = (1.0f * ((float) i3)) / ((float) i2);
        int ordinal = ImageView.ScaleType.CENTER_CROP.ordinal();
        if (Math.abs(i2 - i3) <= 10) {
            i4 = na;
            bj = na;
        } else {
            bj = (int) (bj(f2) * ((float) na));
            i4 = na;
        }
        r<Integer, Integer, Integer> rVar = new r<>(Integer.valueOf(ordinal), Integer.valueOf(i4), Integer.valueOf(bj));
        AppMethodBeat.o(253589);
        return rVar;
    }

    public static float bj(float f2) {
        if (f2 < 0.5625f) {
            return 0.5625f;
        }
        if (f2 < 1.0f || f2 < 1.3166667f) {
            return f2;
        }
        return 1.3166667f;
    }

    public static r<Integer, Integer, Integer> go(int i2, int i3) {
        AppMethodBeat.i(253590);
        r<Integer, Integer, Integer> rVar = new r<>(Integer.valueOf(ImageView.ScaleType.FIT_XY.ordinal()), Integer.valueOf(vXv), Integer.valueOf((int) (((1.0f * ((float) i3)) / ((float) i2)) * ((float) vXv))));
        AppMethodBeat.o(253590);
        return rVar;
    }

    public static /* synthetic */ boolean bk(float f2) {
        AppMethodBeat.i(253592);
        boolean b2 = b(f2, -1);
        AppMethodBeat.o(253592);
        return b2;
    }

    public static boolean b(float f2, int i2) {
        AppMethodBeat.i(253591);
        if (i2 == -1) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            i2 = com.tencent.mm.plugin.finder.storage.c.dtV().value().intValue();
        }
        if (i2 != 2 || f2 < 1.3166667f) {
            AppMethodBeat.o(253591);
            return false;
        }
        AppMethodBeat.o(253591);
        return true;
    }

    public static /* synthetic */ boolean bE(Activity activity) {
        AppMethodBeat.i(261480);
        boolean a2 = a(activity, (af.a<Boolean>) null);
        AppMethodBeat.o(261480);
        return a2;
    }

    public static boolean a(Activity activity, af.a<Boolean> aVar) {
        AppMethodBeat.i(261479);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
        Log.i(TAG, "check has realname userFlag %d", Integer.valueOf(i2));
        if ((i2 & 1) != 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 35, 1);
            String string = activity.getString(R.string.d8l);
            p.g(string, "activity.getString(R.str…lf_contact_need_realname)");
            if (!Util.isNullOrNil((String) null)) {
                string = String.valueOf((Object) null);
            }
            String string2 = activity.getString(R.string.cj3);
            p.g(string2, "activity.getString(R.str…er_check_real_name_title)");
            if (!Util.isNullOrNil((String) null)) {
                string2 = String.valueOf((Object) null);
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.view.c.wjK;
            Activity activity2 = activity;
            p.h(activity2, "context");
            c.a.a(activity2, string2, string, activity.getString(R.string.d8m), activity.getString(R.string.sz), new f(activity, aVar), new g(aVar), null);
            AppMethodBeat.o(261479);
            return false;
        }
        AppMethodBeat.o(261479);
        return true;
    }

    public static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ af.a UVk;
        final /* synthetic */ Activity msB;

        f(Activity activity, af.a aVar) {
            this.msB = activity;
            this.UVk = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(167938);
            a aVar = a.vUU;
            a.am(this.msB);
            af.a aVar2 = this.UVk;
            if (aVar2 != null) {
                aVar2.bn(Boolean.TRUE);
            }
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.at(7, false);
            AppMethodBeat.o(167938);
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        final /* synthetic */ af.a UVk;

        g(af.a aVar) {
            this.UVk = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(253570);
            af.a aVar = this.UVk;
            if (aVar != null) {
                aVar.bn(Boolean.FALSE);
            }
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.at(7, false);
            AppMethodBeat.o(253570);
        }
    }

    public static /* synthetic */ boolean a(Context context, String str, bed bed) {
        AppMethodBeat.i(253595);
        boolean a2 = a(context, str, false, bed);
        AppMethodBeat.o(253595);
        return a2;
    }

    public static boolean a(Context context, String str, boolean z, bed bed) {
        AppMethodBeat.i(253594);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (Util.isNullOrNil(z.aUg())) {
            Log.i(TAG, "need create finder contact");
            String string = context.getString(R.string.ck_);
            p.g(string, "activity.getString(R.str…reate_contact_dialog_tip)");
            if (!Util.isNullOrNil(str)) {
                string = String.valueOf(str);
            }
            c.a aVar = com.tencent.mm.plugin.finder.view.c.wjK;
            c.a.a(context, context.getString(R.string.ckh), string, context.getString(R.string.ckf), context.getString(R.string.ck8), new c(z, bed, context), new d(z), new e(z));
            AppMethodBeat.o(253594);
            return false;
        }
        AppMethodBeat.o(253594);
        return true;
    }

    public static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean vXN;
        final /* synthetic */ bed vXO;
        final /* synthetic */ Context vXP;

        c(boolean z, bed bed, Context context) {
            this.vXN = z;
            this.vXO = bed;
            this.vXP = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(167933);
            com.tencent.mm.kernel.g.ah(aj.class);
            if (this.vXN) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(10);
            } else {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(12);
            }
            Intent intent = new Intent();
            intent.putExtra("key_create_scene", 3);
            intent.putExtra("scene", 1);
            bed bed = this.vXO;
            if (bed != null) {
                intent.putExtra("key_prepare_resp", bed.toByteArray());
            }
            a aVar = a.vUU;
            a.w(this.vXP, intent);
            AppMethodBeat.o(167933);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean vXN;

        d(boolean z) {
            this.vXN = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(167934);
            com.tencent.mm.kernel.g.ah(aj.class);
            if (this.vXN) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(11);
            } else {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(13);
            }
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(5);
            AppMethodBeat.o(167934);
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        final /* synthetic */ boolean vXN;

        e(boolean z) {
            this.vXN = z;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(167936);
            com.tencent.mm.kernel.g.ah(aj.class);
            if (this.vXN) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(11);
            } else {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(13);
            }
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(5);
            AppMethodBeat.o(167936);
        }
    }

    public static boolean af(Context context, int i2) {
        AppMethodBeat.i(253596);
        p.h(context, "context");
        boolean z = (i2 & 64) != 0;
        if (z) {
            f.a aVar = new f.a(MMApplicationContext.getContext());
            aVar.bow(context.getResources().getString(R.string.d1a)).Dq(true);
            aVar.apa(R.string.j34).b(h.vXR).b(i.vXS).show();
        }
        AppMethodBeat.o(253596);
        return z;
    }

    /* access modifiers changed from: package-private */
    public static final class h implements f.c {
        public static final h vXR = new h();

        static {
            AppMethodBeat.i(253572);
            AppMethodBeat.o(253572);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i implements DialogInterface.OnDismissListener {
        public static final i vXS = new i();

        static {
            AppMethodBeat.i(253573);
            AppMethodBeat.o(253573);
        }

        i() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public static boolean b(ImageView imageView, String str, int i2, int i3) {
        AppMethodBeat.i(253597);
        p.h(imageView, "imageView");
        p.h(str, "path");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = BitmapUtil.calculateInSampleSize(options.outWidth, options.outHeight, i2, i3);
        options.inJustDecodeBounds = false;
        options.inMutable = true;
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        imageView.setImageBitmap(decodeFile);
        if (decodeFile != null) {
            AppMethodBeat.o(253597);
            return true;
        }
        AppMethodBeat.o(253597);
        return false;
    }

    public static int a(cjk cjk) {
        AppMethodBeat.i(167947);
        p.h(cjk, "content");
        if (cjk.mediaList.size() == 0) {
            AppMethodBeat.o(167947);
            return 4;
        }
        int i2 = cjk.mediaList.get(0).mediaType;
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        if (!c.a.dyN().contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(167947);
            return i2;
        } else if (i2 != 4 || cjk.mediaList.size() <= 1) {
            LinkedList<cjl> linkedList = cjk.mediaList;
            if (linkedList != null) {
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    if (it.next().mediaType != i2) {
                        AppMethodBeat.o(167947);
                        return 8;
                    }
                }
            }
            AppMethodBeat.o(167947);
            return i2;
        } else {
            AppMethodBeat.o(167947);
            return 8;
        }
    }

    public static boolean r(FinderObject finderObject) {
        int i2;
        LinkedList<FinderMedia> linkedList;
        LinkedList<FinderMedia> linkedList2;
        FinderMedia finderMedia;
        LinkedList<FinderMedia> linkedList3;
        AppMethodBeat.i(167948);
        p.h(finderObject, "obj");
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        List<Integer> dyN = c.a.dyN();
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (dyN.contains(Integer.valueOf(finderObjectDesc != null ? finderObjectDesc.mediaType : 0))) {
            AppMethodBeat.o(167948);
            return true;
        }
        FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
        if (finderObjectDesc2 == null || (linkedList3 = finderObjectDesc2.media) == null || linkedList3.size() != 0) {
            FinderObjectDesc finderObjectDesc3 = finderObject.objectDesc;
            if (finderObjectDesc3 == null || (linkedList2 = finderObjectDesc3.media) == null || (finderMedia = linkedList2.get(0)) == null) {
                i2 = 0;
            } else {
                i2 = finderMedia.mediaType;
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            if (!c.a.dyN().contains(Integer.valueOf(i2))) {
                AppMethodBeat.o(167948);
                return false;
            }
            FinderObjectDesc finderObjectDesc4 = finderObject.objectDesc;
            if (!(finderObjectDesc4 == null || (linkedList = finderObjectDesc4.media) == null)) {
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    if (it.next().mediaType != i2) {
                        AppMethodBeat.o(167948);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(167948);
            return true;
        }
        AppMethodBeat.o(167948);
        return false;
    }

    public static boolean a(FinderObject finderObject, String str) {
        AppMethodBeat.i(253598);
        p.h(finderObject, "obj");
        p.h(str, "invokeSource");
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        int i2 = finderObjectDesc != null ? finderObjectDesc.mediaType : 0;
        awe awe = finderObject.liveInfo;
        Integer valueOf = awe != null ? Integer.valueOf(awe.liveStatus) : null;
        Log.d(TAG, str + " isAcceptLiveObj mediaType:" + i2 + " liveState:" + valueOf);
        if (i2 != 9) {
            Log.w(TAG, str + " isAcceptLiveObj return for invalid mediaType:" + i2);
            AppMethodBeat.o(253598);
            return false;
        } else if (valueOf != null && valueOf.intValue() == 2) {
            Log.w(TAG, str + " isAcceptLiveObj return for invalid liveState:" + valueOf);
            AppMethodBeat.o(253598);
            return false;
        } else {
            AppMethodBeat.o(253598);
            return true;
        }
    }

    public static /* synthetic */ boolean s(FinderObject finderObject) {
        AppMethodBeat.i(253599);
        p.h(finderObject, "obj");
        p.h("", "invokeSource");
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        int i2 = finderObjectDesc != null ? finderObjectDesc.mediaType : 0;
        Log.d(TAG, "" + " isAcceptVideoObj mediaType:" + i2);
        if (i2 != 4) {
            Log.w(TAG, "" + " isAcceptVideoObj return for invalid mediaType:" + i2);
            AppMethodBeat.o(253599);
            return false;
        }
        AppMethodBeat.o(253599);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if ((r0 != null ? java.lang.Integer.valueOf(r0.mediaType) : null) == null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int t(com.tencent.mm.protocal.protobuf.FinderObject r7) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.y.t(com.tencent.mm.protocal.protobuf.FinderObject):int");
    }

    public static String byc(String str) {
        int i2;
        AppMethodBeat.i(261481);
        p.h(str, "text");
        kotlin.n.k kVar = new kotlin.n.k("[一-龥]");
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            String substring = str.substring(i3, i3 + 1);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (kVar.aJ(substring)) {
                i5++;
                i2 = i4;
            } else {
                i2 = i4 + 1;
            }
            if ((i5 * 2) + i2 > 14) {
                StringBuilder sb = new StringBuilder();
                String substring2 = str.substring(0, i3);
                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String sb2 = sb.append(substring2).append("...").toString();
                AppMethodBeat.o(261481);
                return sb2;
            }
            i3++;
            i4 = i2;
        }
        AppMethodBeat.o(261481);
        return str;
    }

    public static /* synthetic */ String hf(String str, String str2) {
        AppMethodBeat.i(167951);
        String he = he(str, str2);
        AppMethodBeat.o(167951);
        return he;
    }

    public static String he(String str, String str2) {
        AppMethodBeat.i(167950);
        if (Util.isNullOrNil(str)) {
            if (str2 == null) {
                str2 = "";
            }
            AppMethodBeat.o(167950);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            if (c.a.bxz(str)) {
                if (Util.isNullOrNil(str2)) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                    if (str == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
                    if (asG != null) {
                        str2 = asG.getNickname();
                    } else {
                        str2 = "";
                    }
                } else if (str2 == null) {
                    str2 = "";
                }
                p.g(stringBuffer.append("displayName is is finder contact"), "buf.append(\"displayName is is finder contact\")");
            } else {
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                p.g(Kn, UserDataStore.CITY);
                if (Kn.arH() != 0 && !Util.isNullOrNil(Kn.arJ())) {
                    str2 = Kn.arJ();
                    p.g(str2, "ct.displayRemark");
                    p.g(stringBuffer.append("displayName is ".concat(String.valueOf(str2))), "buf.append(\"displayName is $displayName\")");
                } else if (Util.isNullOrNil(str2)) {
                    str2 = Kn.getUsername();
                    p.g(str2, "ct.getUsername()");
                } else if (str2 == null) {
                    str2 = "";
                }
            }
            AppMethodBeat.o(167950);
        }
        return str2;
    }

    public static boolean isFriend(String str) {
        AppMethodBeat.i(167952);
        if (str == null) {
            AppMethodBeat.o(167952);
            return false;
        } else if (kotlin.n.n.nm(str, "@stranger") || !(!p.j(str, z.aTY())) || !ab.IS(str)) {
            AppMethodBeat.o(167952);
            return false;
        } else {
            AppMethodBeat.o(167952);
            return true;
        }
    }

    public static boolean dCB() {
        AppMethodBeat.i(178458);
        if (!Util.isNullOrNil(z.aUg())) {
            AppMethodBeat.o(178458);
            return true;
        }
        AppMethodBeat.o(178458);
        return false;
    }

    public static String dCC() {
        AppMethodBeat.i(167953);
        String obj = ClipboardHelper.getText().toString();
        if (obj == null) {
            obj = "";
        }
        AppMethodBeat.o(167953);
        return obj;
    }

    public static /* synthetic */ void a(Context context, axt axt) {
        AppMethodBeat.i(253601);
        a(context, axt, true);
        AppMethodBeat.o(253601);
    }

    public static void a(Context context, axt axt, boolean z) {
        AppMethodBeat.i(253600);
        p.h(context, "context");
        p.h(axt, FirebaseAnalytics.b.LOCATION);
        if (Util.isNullOrNil(axt.LIb)) {
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) axt.latitude);
            intent.putExtra("kwebmap_lng", (double) axt.dTj);
            String str = axt.kHV;
            if (Util.isNullOrNil(str)) {
                str = axt.fuK;
            }
            intent.putExtra("kPoiName", str);
            intent.putExtra("Kwebmap_locaion", axt.ErZ);
            intent.putExtra("kShowshare", z);
            com.tencent.mm.br.c.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
            AppMethodBeat.o(253600);
            return;
        }
        ae aeVar = ae.SYK;
        String str2 = com.tencent.mm.protocal.d.KyX;
        p.g(str2, "ConstantsProtocal.MM_NEAR_LIFE_URI");
        String format = String.format(str2, Arrays.copyOf(new Object[]{axt.LIb}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", format);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        AppMethodBeat.o(253600);
    }

    public static void m(List<? extends FinderItem> list, String str) {
        AppMethodBeat.i(167955);
        p.h(list, "list");
        p.h(str, "tag");
        int i2 = 0;
        Log.v(TAG, "---------------------------------------------------------------------printAllItemStart " + str + " count " + list.size() + "---------------------------------------------------------------------");
        for (T t : list) {
            Integer valueOf = Integer.valueOf(t.getCreateTime());
            String str2 = TAG;
            StringBuilder append = new StringBuilder("#").append(i2).append(" print item id:").append(t.getId()).append(" rowid:").append(t.getLocalId()).append(" time: ").append(valueOf).append(" sourceFlag:").append(((FinderItem) t).field_sourceFlag).append(" username:");
            FinderObject finderObject = t.getFinderObject();
            Log.i(str2, append.append(finderObject != null ? finderObject.username : null).toString());
            i2++;
        }
        Log.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + str + "---------------------------------------------------------------------");
        AppMethodBeat.o(167955);
    }

    public static boolean In(String str) {
        AppMethodBeat.i(167957);
        if (Util.isNullOrNil(z.aUg()) || Util.isNullOrNil(str) || !kotlin.n.n.I(str, z.aUg(), false)) {
            AppMethodBeat.o(167957);
            return false;
        }
        AppMethodBeat.o(167957);
        return true;
    }

    public static boolean awn(String str) {
        AppMethodBeat.i(167958);
        boolean isEqual = Util.isEqual(str, z.aTY());
        AppMethodBeat.o(167958);
        return isEqual;
    }

    public static azy u(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(167959);
        p.h(baseFinderFeed, "feed");
        azy azy = new azy();
        azy.refObjectFlag = 1;
        if (baseFinderFeed.feedObject.getRefObjectFlag() == 1) {
            azy.refObjectId = baseFinderFeed.feedObject.getRefObjectId();
            azy.refObjectContact = baseFinderFeed.feedObject.getRefObjectContact();
        } else {
            azy.refObjectId = baseFinderFeed.feedObject.getId();
            com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
            if (gVar == null) {
                p.hyc();
            }
            azy.refObjectContact = com.tencent.mm.plugin.finder.api.b.a(gVar);
        }
        AppMethodBeat.o(167959);
        return azy;
    }

    public static void a(LinkedList<FinderCommentInfo> linkedList, long j2, long j3, String str) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(167960);
        p.h(linkedList, "commentList");
        p.h(str, ClientInfoTable.Columns.CLIENTID);
        if (j3 != 0) {
            Iterator<FinderCommentInfo> it = linkedList.iterator();
            i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().commentId == j3) {
                    break;
                }
                i2++;
            }
        } else {
            Iterator<FinderCommentInfo> it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i3 = -1;
                    break;
                } else if (p.j(it2.next().client_id, str)) {
                    break;
                } else {
                    i3++;
                }
            }
            i2 = i3;
        }
        if (i2 >= 0) {
            linkedList.remove(i2);
            Log.i(TAG, "update expose commentList, remove at ".concat(String.valueOf(i2)));
            hv hvVar = new hv();
            hvVar.dMr.feedId = j2;
            hv.a aVar = hvVar.dMr;
            azt azt = new azt();
            azt.commentList = linkedList;
            aVar.dMs = azt;
            EventCenter.instance.publish(hvVar);
        }
        AppMethodBeat.o(167960);
    }

    public static void A(FinderItem finderItem) {
        AppMethodBeat.i(178459);
        p.h(finderItem, LocaleUtil.ITALIAN);
        hv hvVar = new hv();
        hvVar.dMr.feedId = finderItem.field_id;
        hvVar.dMr.dMt = finderItem.getCommentCount();
        EventCenter.instance.publish(hvVar);
        AppMethodBeat.o(178459);
    }

    public static /* synthetic */ String dCD() {
        AppMethodBeat.i(253603);
        String LA = LA(0);
        AppMethodBeat.o(253603);
        return LA;
    }

    public static String LA(int i2) {
        AppMethodBeat.i(167961);
        String str = "";
        switch (i2) {
            case 1:
                str = "follow";
                break;
            case 2:
                str = "feed";
                break;
            case 3:
                str = "fans";
                break;
            case 4:
                str = "preload";
                break;
            case 7:
                str = EnvConsts.ACTIVITY_MANAGER_SRVNAME;
                break;
        }
        if (Util.isNullOrNil(str)) {
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String sb2 = sb.append(aAh.azM()).append("finder/page/").toString();
            AppMethodBeat.o(167961);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        String sb4 = sb3.append(aAh2.azM()).append("finder/page/").append(str).append('/').toString();
        AppMethodBeat.o(167961);
        return sb4;
    }

    public static int LB(int i2) {
        switch (i2) {
            case 1:
                return 18;
            case 2:
                return 16;
            case 3:
                return 17;
            case 4:
                return 20;
            default:
                return -1;
        }
    }

    public static boolean LC(int i2) {
        return i2 == 1;
    }

    public static String dP(String str, int i2) {
        AppMethodBeat.i(167962);
        p.h(str, "key");
        String string = MMApplicationContext.getContext().getString(i2);
        p.g(string, "MMApplicationContext.getContext().getString(resId)");
        AppMethodBeat.o(167962);
        return string;
    }

    public static boolean gp(int i2, int i3) {
        return i3 == -4012 && i2 == 4;
    }

    public static long dCE() {
        return tCi;
    }

    public static final class a {
        boolean daZ;
        public FeedData feed;
        public long feedId;
        public String mediaId;
        public com.tencent.mm.view.recyclerview.h tAm;
        public final LinkedList<a> vXI;
        public int vXJ;
        public int vXK;

        public a() {
            this(false, null, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
            if (kotlin.g.b.p.j(r5.tAm, r6.tAm) != false) goto L_0x0046;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 253564(0x3de7c, float:3.55319E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0046
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.utils.y.a
                if (r0 == 0) goto L_0x004b
                com.tencent.mm.plugin.finder.utils.y$a r6 = (com.tencent.mm.plugin.finder.utils.y.a) r6
                boolean r0 = r5.daZ
                boolean r1 = r6.daZ
                if (r0 != r1) goto L_0x004b
                long r0 = r5.feedId
                long r2 = r6.feedId
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x004b
                java.lang.String r0 = r5.mediaId
                java.lang.String r1 = r6.mediaId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                com.tencent.mm.plugin.finder.storage.FeedData r0 = r5.feed
                com.tencent.mm.plugin.finder.storage.FeedData r1 = r6.feed
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                int r0 = r5.vXJ
                int r1 = r6.vXJ
                if (r0 != r1) goto L_0x004b
                int r0 = r5.vXK
                int r1 = r6.vXK
                if (r0 != r1) goto L_0x004b
                com.tencent.mm.view.recyclerview.h r0 = r5.tAm
                com.tencent.mm.view.recyclerview.h r1 = r6.tAm
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
            L_0x0046:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x004a:
                return r0
            L_0x004b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x004a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.y.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(253563);
            boolean z = this.daZ;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            long j2 = this.feedId;
            int i6 = ((i3 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            String str = this.mediaId;
            int hashCode = ((str != null ? str.hashCode() : 0) + i6) * 31;
            FeedData feedData = this.feed;
            int hashCode2 = ((((((feedData != null ? feedData.hashCode() : 0) + hashCode) * 31) + this.vXJ) * 31) + this.vXK) * 31;
            com.tencent.mm.view.recyclerview.h hVar = this.tAm;
            if (hVar != null) {
                i2 = hVar.hashCode();
            }
            int i7 = hashCode2 + i2;
            AppMethodBeat.o(253563);
            return i7;
        }

        public a(boolean z, long j2, String str, FeedData feedData, int i2, int i3, com.tencent.mm.view.recyclerview.h hVar) {
            p.h(str, "mediaId");
            AppMethodBeat.i(253561);
            this.daZ = z;
            this.feedId = j2;
            this.mediaId = str;
            this.feed = feedData;
            this.vXJ = i2;
            this.vXK = i3;
            this.tAm = hVar;
            this.vXI = new LinkedList<>();
            AppMethodBeat.o(253561);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(boolean r11, java.lang.String r12, int r13) {
            /*
                r10 = this;
                r5 = 0
                r9 = 253562(0x3de7a, float:3.55316E-40)
                r6 = 0
                r0 = r13 & 1
                if (r0 == 0) goto L_0x0022
                r1 = 1
            L_0x000a:
                r0 = r13 & 4
                if (r0 == 0) goto L_0x0020
                java.lang.String r4 = ""
            L_0x0011:
                r2 = 0
                r0 = r10
                r7 = r6
                r8 = r5
                r0.<init>(r1, r2, r4, r5, r6, r7, r8)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
                return
            L_0x0020:
                r4 = r12
                goto L_0x0011
            L_0x0022:
                r1 = r11
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.y.a.<init>(boolean, java.lang.String, int):void");
        }

        public final String toString() {
            boolean z = true;
            AppMethodBeat.i(253560);
            StringBuilder append = new StringBuilder("isValid=").append(this.daZ).append(" feedType=").append(this.vXJ).append(" feedPosition=").append(this.vXK).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" mediaId=").append(this.mediaId).append(" holder=").append(this.tAm != null).append(" centerList=").append(this.vXI.size()).append(" feed=");
            if (this.feed != null) {
                z = false;
            }
            String sb = append.append(z).toString();
            AppMethodBeat.o(253560);
            return sb;
        }
    }

    public static /* synthetic */ a a(RecyclerView recyclerView, int i2, int i3, Set set, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        FeedData feedData;
        int abs;
        LinkedList<cjl> linkedList;
        String str;
        boolean z;
        boolean z2;
        AppMethodBeat.i(253604);
        if ((i4 & 2) != 0) {
            i5 = Integer.MIN_VALUE;
        } else {
            i5 = i2;
        }
        if ((i4 & 4) != 0) {
            i6 = Integer.MIN_VALUE;
        } else {
            i6 = i3;
        }
        if ((i4 & 8) != 0) {
            set = vXw;
        }
        p.h(recyclerView, "recyclerView");
        p.h(set, "otherCareType");
        long uptimeMillis = SystemClock.uptimeMillis();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(253604);
            throw tVar;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (i5 == Integer.MIN_VALUE) {
            i5 = linearLayoutManager.ks();
        }
        if (i6 == Integer.MIN_VALUE) {
            i7 = linearLayoutManager.ku();
        } else {
            i7 = i6;
        }
        if (i5 < 0 || i7 < i5 || i7 < 0) {
            a aVar = new a(false, null, 126);
            AppMethodBeat.o(253604);
            return aVar;
        }
        LinkedList linkedList2 = new LinkedList();
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
            AppMethodBeat.o(253604);
            throw tVar2;
        }
        WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
        int i9 = 0;
        Iterator<D> it = wxRecyclerAdapter.data.iterator();
        while (true) {
            if (!it.hasNext()) {
                i9 = -1;
                break;
            }
            D next = it.next();
            if (next.cxn() == 4 || next.cxn() == 2013 || next.cxn() == 9) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                break;
            }
            i9++;
        }
        int size = i9 + wxRecyclerAdapter.RqM.size();
        int i10 = 0;
        Iterator<D> it2 = wxRecyclerAdapter.data.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i10 = -1;
                break;
            }
            D next2 = it2.next();
            if (next2.cxn() == 4 || next2.cxn() == 2 || next2.cxn() == 9) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            i10++;
        }
        int size2 = i10 + wxRecyclerAdapter.RqM.size();
        int i11 = heightPixels;
        float f2 = ((float) i11) * 0.4f;
        a aVar2 = new a(false, null, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        if (i5 <= i7) {
            int i12 = i5;
            int i13 = Integer.MAX_VALUE;
            while (true) {
                RecyclerView.v cg = recyclerView.cg(i12);
                if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                    cg = null;
                }
                com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
                if (hVar == null) {
                    i8 = i13;
                } else {
                    Object hgv = hVar.hgv();
                    if (!(hgv instanceof bo)) {
                        hgv = null;
                    }
                    bo boVar = (bo) hgv;
                    if (boVar == null) {
                        i8 = i13;
                    } else {
                        int cxn = boVar.cxn();
                        if ((boVar instanceof BaseFinderFeed) || set.contains(Integer.valueOf(cxn)) || (boVar instanceof bm)) {
                            if (boVar instanceof BaseFinderFeed) {
                                FeedData.a aVar3 = FeedData.Companion;
                                feedData = FeedData.a.s((BaseFinderFeed) boVar);
                            } else if (boVar instanceof bm) {
                                FeedData.a aVar4 = FeedData.Companion;
                                feedData = FeedData.a.a((bm) boVar);
                            } else if (boVar instanceof ag) {
                                FeedData.a aVar5 = FeedData.Companion;
                                ag agVar = (ag) boVar;
                                p.h(agVar, "feed");
                                feedData = new FeedData();
                                feedData.setFeedId(agVar.tQQ.id);
                                feedData.setMediaType(agVar.cxn());
                                feedData.setRvFeedList(agVar.rvFeedList);
                            } else {
                                feedData = null;
                            }
                            View Mn = ((boVar instanceof BaseFinderFeed) || (boVar instanceof bm)) ? hVar.Mn(R.id.fbd) : hVar.aus;
                            vXx.setEmpty();
                            if (!Mn.getGlobalVisibleRect(vXx)) {
                                Log.v(TAG, "getGlobalVisibleRect error continue " + vXx);
                                i8 = i13;
                            } else {
                                Rect rect = vXx;
                                rect.top = android.support.v4.b.a.clamp(rect.top, 0, i11);
                                Rect rect2 = vXx;
                                rect2.bottom = android.support.v4.b.a.clamp(rect2.bottom, 0, i11);
                                if (vXx.height() <= 0) {
                                    Log.v(TAG, "mediaRect.height() error continue " + vXx);
                                    i8 = i13;
                                } else {
                                    if (i12 == size && size2 == size) {
                                        abs = 0;
                                    } else {
                                        abs = (int) Math.abs(f2 - ((float) vXx.top));
                                    }
                                    if (cxn == 4 || cxn == 2013 || (cxn == 2 && feedData != null && feedData.getHasBgmInfo())) {
                                        int height = vXx.height();
                                        p.g(Mn, "mediaView");
                                        if (height > Mn.getHeight() / 2) {
                                            abs -= i11;
                                        }
                                    }
                                    if (abs < i13) {
                                        aVar2.vXJ = boVar.cxn();
                                        aVar2.vXK = i12;
                                        aVar2.tAm = hVar;
                                        aVar2.feedId = boVar.lT();
                                        aVar2.feed = feedData;
                                        View Mn2 = hVar.Mn(R.id.fbd);
                                        if (feedData != null) {
                                            linkedList = feedData.getMediaList();
                                        } else {
                                            linkedList = null;
                                        }
                                        if (!(Mn2 == null || linkedList == null)) {
                                            FinderMediaBanner finderMediaBanner = (FinderMediaBanner) Mn2;
                                            if (finderMediaBanner.getFocusPosition() >= 0 && finderMediaBanner.getFocusPosition() < linkedList.size()) {
                                                cjl cjl = (cjl) kotlin.a.j.L(linkedList, finderMediaBanner.getFocusPosition());
                                                if (cjl == null || (str = cjl.mediaId) == null) {
                                                    str = "";
                                                }
                                                p.h(str, "<set-?>");
                                                aVar2.mediaId = str;
                                            }
                                        }
                                        boolean z3 = aVar2.daZ;
                                        long j2 = aVar2.feedId;
                                        String str2 = aVar2.mediaId;
                                        FeedData feedData2 = aVar2.feed;
                                        int i14 = aVar2.vXJ;
                                        int i15 = aVar2.vXK;
                                        com.tencent.mm.view.recyclerview.h hVar2 = aVar2.tAm;
                                        p.h(str2, "mediaId");
                                        linkedList2.add(new a(z3, j2, str2, feedData2, i14, i15, hVar2));
                                        i8 = abs;
                                    }
                                }
                            }
                        }
                        i8 = i13;
                    }
                }
                if (i12 == i7) {
                    break;
                }
                i12++;
                i13 = i8;
            }
        }
        aVar2.vXI.addAll(linkedList2);
        if (tCi != aVar2.feedId) {
            Log.i(TAG, "[findCenterFeed] cost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms firstFeedIndex=" + size2 + " firstVideoFeedIndex=" + size + ", centerResult=[" + aVar2 + ']');
            tCi = aVar2.feedId;
        }
        AppMethodBeat.o(253604);
        return aVar2;
    }

    public static kotlin.o<Double, Double> awo(String str) {
        AppMethodBeat.i(167965);
        p.h(str, "path");
        ab abVar = new ab(new ExifInterface(s.k(str, false)));
        Float f2 = abVar.vYl;
        Float f3 = abVar.vYk;
        if (f3 == null || f2 == null) {
            AppMethodBeat.o(167965);
            return null;
        }
        kotlin.o<Double, Double> oVar = new kotlin.o<>(Double.valueOf((double) f3.floatValue()), Double.valueOf((double) f2.floatValue()));
        AppMethodBeat.o(167965);
        return oVar;
    }

    public static kotlin.o<Double, Double> awp(String str) {
        AppMethodBeat.i(167966);
        try {
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(167966);
                return null;
            }
            com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
            dVar.setDataSource(str);
            String extractMetadata = dVar.extractMetadata(23);
            dVar.release();
            Log.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(extractMetadata)));
            if (!TextUtils.isEmpty(extractMetadata)) {
                p.g(extractMetadata, "locationString");
                if (extractMetadata == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(167966);
                    throw tVar;
                }
                char[] charArray = extractMetadata.toCharArray();
                p.g(charArray, "(this as java.lang.String).toCharArray()");
                StringBuilder sb = new StringBuilder();
                for (char c2 : charArray) {
                    if (c2 == '+' || c2 == '-' || c2 == '.' || TextUtils.isDigitsOnly(String.valueOf(c2) + "")) {
                        sb.append(c2);
                    }
                }
                String sb2 = sb.toString();
                p.g(sb2, "locSb.toString()");
                int b2 = kotlin.n.n.b((CharSequence) sb2, '+');
                if (-1 == b2) {
                    b2 = kotlin.n.n.b((CharSequence) sb2, '-');
                }
                if (sb2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(167966);
                    throw tVar2;
                }
                String substring = sb2.substring(0, b2);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                double parseDouble = Double.parseDouble(substring);
                if (sb2 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(167966);
                    throw tVar3;
                }
                String substring2 = sb2.substring(b2);
                p.g(substring2, "(this as java.lang.String).substring(startIndex)");
                kotlin.o<Double, Double> oVar = new kotlin.o<>(Double.valueOf(parseDouble), Double.valueOf(Double.parseDouble(substring2)));
                AppMethodBeat.o(167966);
                return oVar;
            }
            AppMethodBeat.o(167966);
            return null;
        } catch (Throwable th) {
            AppMethodBeat.o(167966);
            return null;
        }
    }

    public static String LD(int i2) {
        String str;
        AppMethodBeat.i(167967);
        if (i2 == 2) {
            str = z.aUa();
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(167967);
        } else {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG == null || (str = asG.getNickname()) == null) {
                str = "";
            }
            AppMethodBeat.o(167967);
        }
        return str;
    }

    public static String LE(int i2) {
        AppMethodBeat.i(178461);
        if (i2 == 2) {
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            AppMethodBeat.o(178461);
            return aTY;
        }
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        AppMethodBeat.o(178461);
        return aUg;
    }

    public static int LF(int i2) {
        if (i2 == 2) {
            return 1;
        }
        return 2;
    }

    public static boolean LG(int i2) {
        return (i2 & 2) != 0;
    }

    public static boolean LH(int i2) {
        return (i2 & 8) != 0;
    }

    public static boolean LI(int i2) {
        return (i2 & 1) != 0;
    }

    public static Bitmap c(InputStream inputStream, int i2, int i3) {
        AppMethodBeat.i(167968);
        p.h(inputStream, "inputStream");
        b.a aVar = com.tencent.mm.plugin.gallery.picker.b.b.xkW;
        Bitmap a2 = b.a.a(inputStream, i2, i3, true, false);
        AppMethodBeat.o(167968);
        return a2;
    }

    public static String al(String str, String str2, String str3) {
        AppMethodBeat.i(178462);
        p.h(str, "countryCode");
        p.h(str2, "provinceCode");
        p.h(str3, "cityCode");
        RegionCodeDecoder.gEm();
        String country = RegionCodeDecoder.getCountry(str);
        RegionCodeDecoder.gEm();
        String mV = RegionCodeDecoder.mV(str, str2);
        RegionCodeDecoder.gEm();
        String br = RegionCodeDecoder.br(str, str2, str3);
        if (!Util.isNullOrNil(br)) {
            String str4 = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It(mV) + " " + br;
            AppMethodBeat.o(178462);
            return str4;
        } else if (!Util.isNullOrNil(mV)) {
            String str5 = country + ' ' + mV;
            AppMethodBeat.o(178462);
            return str5;
        } else if (!Util.isNullOrNil(country)) {
            p.g(country, "countryName");
            AppMethodBeat.o(178462);
            return country;
        } else {
            AppMethodBeat.o(178462);
            return "";
        }
    }

    public static String hg(String str, String str2) {
        AppMethodBeat.i(167969);
        if (!Util.isNullOrNil(str, str2)) {
            String string = MMApplicationContext.getResources().getString(R.string.d0r, str, str2);
            AppMethodBeat.o(167969);
            return string;
        } else if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(167969);
            return str;
        } else if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(167969);
            return str2;
        } else {
            AppMethodBeat.o(167969);
            return "";
        }
    }

    public static String hh(String str, String str2) {
        AppMethodBeat.i(253606);
        if (!Util.isNullOrNil(str)) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            str2 = he(str, str2);
        } else if (str2 == null) {
            AppMethodBeat.o(253606);
            return "";
        }
        AppMethodBeat.o(253606);
        return str2;
    }

    public static void a(com.tencent.mm.view.recyclerview.h hVar, String str, com.tencent.mm.plugin.finder.model.s sVar) {
        byte[] bArr;
        AppMethodBeat.i(253607);
        p.h(hVar, "holder");
        p.h(str, "feedUserName");
        p.h(sVar, "item");
        Intent intent = new Intent();
        if (Util.isNullOrNil(str) || !p.j(str, z.aUg())) {
            intent.putExtra("Action", 2);
            intent.putExtra("IsPoster", false);
        } else {
            intent.putExtra("IsPoster", true);
            if (sVar.uOf.dyb().blacklist_flag == 0 && !Util.isNullOrNil(sVar.uOf.getUsername()) && !z.aTY().equals(sVar.uOf.getUsername())) {
                intent.putExtra("Action", 1);
            }
            intent.putExtra("feedUser", str);
        }
        intent.putExtra("Avatar", sVar.uOf.dyc());
        intent.putExtra("Nickname", sVar.uOf.getNickname());
        intent.putExtra("CommentId", sVar.uOf.dyb().commentId);
        intent.putExtra("FeedId", sVar.uOf.field_feedId);
        intent.putExtra("FeedNonceId", sVar.uOf.field_objectNonceId);
        intent.putExtra("V5UserName", sVar.uOf.getUsername());
        FinderCommentInfo dyb = sVar.uOf.dyb();
        if (!(dyb == null || dyb.msgInfo == null)) {
            aps aps = sVar.uOf.dyb().msgInfo;
            if (aps != null) {
                bArr = aps.toByteArray();
            } else {
                bArr = null;
            }
            intent.putExtra("ContactMsgInfo", bArr);
        }
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        a(context, sVar.uOf.getUsername(), intent, (kotlin.g.a.b<? super String, x>) null);
        if (sVar.uOf.dyb() == null) {
            Log.i(TAG, "commentInfo = null");
            AppMethodBeat.o(253607);
            return;
        }
        if (sVar.uOf.dyb().msgInfo == null) {
            Log.i(TAG, "msgInfo is null ,feedId:" + sVar.uOf.field_feedId + ",comentId:" + sVar.uOf.dyb().commentId);
        }
        AppMethodBeat.o(253607);
    }

    public static com.tencent.mm.plugin.finder.view.d a(Context context, String str, Intent intent, kotlin.g.a.b<? super String, x> bVar) {
        AppMethodBeat.i(253608);
        p.h(context, "context");
        Log.i(TAG, "jump to wx profile %s", str);
        Intent intent2 = new Intent();
        intent2.putExtras(intent);
        if (!Util.isNullOrNil(str)) {
            intent2.putExtra("Username", str);
        }
        n.a aVar = com.tencent.mm.plugin.finder.view.n.wpY;
        com.tencent.mm.plugin.finder.view.d a2 = n.a.a(context, intent2, bVar);
        AppMethodBeat.o(253608);
        return a2;
    }

    public static void mk(Context context) {
        AppMethodBeat.i(261482);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=page/agreement/finder_live_user_event");
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(261482);
    }

    public static String awq(String str) {
        AppMethodBeat.i(178463);
        p.h(str, "desc");
        if (str.length() > 5) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 5);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String sb2 = sb.append(substring).append("***").toString();
            AppMethodBeat.o(178463);
            return sb2;
        }
        AppMethodBeat.o(178463);
        return str;
    }

    public static int LJ(int i2) {
        switch (i2) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 4:
                return 2;
            case 128:
                return 4;
            case 256:
                return 10;
            case 512:
                return 5;
            case 1024:
                return 6;
            case 2048:
                return 7;
            case 4096:
                return 8;
            case 8192:
                return 14;
            default:
                return 3;
        }
    }

    public static ar.a LK(int i2) {
        switch (i2) {
            case 0:
                return ar.a.USERINFO_FINDER_TIMELINE_ALL_LASTBUF_STRING_SYNC;
            case 1:
                return ar.a.USERINFO_FINDER_TIMELINE_FRIEND_LASTBUF_STRING_SYNC;
            case 2:
                return ar.a.USERINFO_FINDER_TIMELINE_LBS_LASTBUF_STRING_SYNC;
            case 3:
                return ar.a.USERINFO_FINDER_TIMELINE_FOLLOW_LASTBUF_STRING_SYNC;
            case 4:
                return ar.a.USERINFO_FINDER_TIMELINE_MACHINE_LASTBUF_STRING_SYNC;
            default:
                return ar.a.USERINFO_FINDER_TIMELINE_ALL_LASTBUF_STRING_SYNC;
        }
    }

    public static int LL(int i2) {
        switch (i2) {
            case 0:
            default:
                return 1;
            case 1:
                return 512;
            case 2:
                return 1024;
            case 3:
                return 2048;
            case 4:
                return 4096;
            case 1001:
                return 33024;
        }
    }

    public static boolean dCF() {
        AppMethodBeat.i(253609);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if ((aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & 32) != 0) {
            AppMethodBeat.o(253609);
            return true;
        }
        AppMethodBeat.o(253609);
        return false;
    }

    public static boolean dnv() {
        AppMethodBeat.i(253610);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if ((aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & 1024) != 0) {
            AppMethodBeat.o(253610);
            return true;
        }
        AppMethodBeat.o(253610);
        return false;
    }

    public static boolean dCG() {
        AppMethodBeat.i(253611);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if ((aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            AppMethodBeat.o(253611);
            return true;
        }
        AppMethodBeat.o(253611);
        return false;
    }

    public static boolean dCH() {
        AppMethodBeat.i(253612);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if ((aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & 8192) != 0) {
            AppMethodBeat.o(253612);
            return true;
        }
        AppMethodBeat.o(253612);
        return false;
    }

    public static boolean LM(int i2) {
        return (32768 & i2) != 0;
    }

    public static boolean LN(int i2) {
        return (65536 & i2) != 0;
    }

    public static boolean awr(String str) {
        int i2;
        AppMethodBeat.i(253613);
        if (p.j(str, z.aUg())) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
        } else {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
            if (asG != null) {
                i2 = asG.field_extFlag;
            } else {
                i2 = 0;
            }
        }
        if ((i2 & 2048) != 0) {
            AppMethodBeat.o(253613);
            return true;
        }
        AppMethodBeat.o(253613);
        return false;
    }

    public static boolean i(com.tencent.mm.plugin.finder.api.g gVar) {
        int i2;
        AppMethodBeat.i(253614);
        if (p.j(gVar != null ? gVar.getUsername() : null, z.aUg())) {
            boolean dnv = dnv();
            AppMethodBeat.o(253614);
            return dnv;
        }
        if (gVar != null) {
            i2 = gVar.field_extFlag;
        } else {
            i2 = 0;
        }
        if ((i2 & 1024) != 0) {
            AppMethodBeat.o(253614);
            return true;
        }
        AppMethodBeat.o(253614);
        return false;
    }

    public static boolean u(FinderObject finderObject) {
        AppMethodBeat.i(253615);
        p.h(finderObject, ch.COL_FINDEROBJECT);
        if ((finderObject.permissionFlag & 1) == 0) {
            AppMethodBeat.o(253615);
            return true;
        }
        AppMethodBeat.o(253615);
        return false;
    }

    public static boolean v(FinderObject finderObject) {
        AppMethodBeat.i(253616);
        p.h(finderObject, ch.COL_FINDEROBJECT);
        if ((finderObject.permissionFlag & 2) == 0) {
            AppMethodBeat.o(253616);
            return true;
        }
        AppMethodBeat.o(253616);
        return false;
    }

    public static boolean w(FinderObject finderObject) {
        AppMethodBeat.i(253617);
        p.h(finderObject, ch.COL_FINDEROBJECT);
        if ((finderObject.permissionFlag & 4) != 0) {
            AppMethodBeat.o(253617);
            return true;
        }
        AppMethodBeat.o(253617);
        return false;
    }

    public static boolean b(cng cng) {
        if (cng != null && (cng.permissionFlag & 4) == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(cng cng) {
        if (cng != null && (cng.permissionFlag & 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean d(cng cng) {
        if (cng != null && (cng.permissionFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean x(FinderObject finderObject) {
        AppMethodBeat.i(253618);
        p.h(finderObject, ch.COL_FINDEROBJECT);
        if ((finderObject.permissionFlag & 8) == 0) {
            AppMethodBeat.o(253618);
            return true;
        }
        AppMethodBeat.o(253618);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static final class o implements u.b {
        public static final o vYd = new o();

        static {
            AppMethodBeat.i(253583);
            AppMethodBeat.o(253583);
        }

        o() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            TextView textView;
            AppMethodBeat.i(253582);
            if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                AppMethodBeat.o(253582);
                return;
            }
            textView.setTextSize(1, 14.0f);
            AppMethodBeat.o(253582);
        }
    }

    public static void aF(Context context, String str) {
        AppMethodBeat.i(253619);
        p.h(context, "context");
        p.h(str, "wording");
        u.a(context, str, o.vYd);
        AppMethodBeat.o(253619);
    }

    public static void a(TextView textView, Spannable spannable) {
        AppMethodBeat.i(253620);
        p.h(textView, "tv");
        p.h(spannable, "text");
        textView.setOnTouchListener(eh(textView));
        AppMethodBeat.o(253620);
    }

    public static View.OnTouchListener eh(View view) {
        AppMethodBeat.i(253621);
        p.h(view, "tv");
        j jVar = new j(view);
        AppMethodBeat.o(253621);
        return jVar;
    }

    public static final class j implements View.OnTouchListener {
        final /* synthetic */ View vXT;

        j(View view) {
            this.vXT = view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v29, types: [android.text.Spannable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
            /*
            // Method dump skipped, instructions count: 293
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.y.j.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public static boolean h(cjl cjl) {
        acn acn;
        return cjl == null || (acn = cjl.MfU) == null || !acn.Lng;
    }

    public static int i(cjl cjl) {
        acn acn;
        if (cjl != null && cjl.mediaType == 9) {
            return 2;
        }
        if (cjl == null || (acn = cjl.MfU) == null || !acn.Lng) {
            return 0;
        }
        return 1;
    }

    public static boolean j(cjl cjl) {
        AppMethodBeat.i(253622);
        p.h(cjl, "localFinderMedia");
        if (!cjl.MoO || cjl.uOR == null) {
            AppMethodBeat.o(253622);
            return false;
        }
        AppMethodBeat.o(253622);
        return true;
    }

    public static List<com.tencent.mm.plugin.finder.event.base.g> a(int i2, int i3, RecyclerView recyclerView) {
        AppMethodBeat.i(253623);
        p.h(recyclerView, "recyclerView");
        LinkedList linkedList = new LinkedList();
        if (i2 < 0 || i3 < 0 || i2 > i3) {
            List<com.tencent.mm.plugin.finder.event.base.g> v = kotlin.a.j.v((Collection) linkedList);
            AppMethodBeat.o(253623);
            return v;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter instanceof WxRecyclerAdapter) {
            ArrayList<D> arrayList = ((WxRecyclerAdapter) adapter).data;
            if (i2 <= i3) {
                while (true) {
                    int size = i2 - ((WxRecyclerAdapter) adapter).RqM.size();
                    if (size >= 0 && size < arrayList.size()) {
                        D d2 = arrayList.get(size);
                        if (d2.lT() != 0 && (d2 instanceof bo)) {
                            com.tencent.mm.plugin.finder.event.base.g gVar = new com.tencent.mm.plugin.finder.event.base.g((bo) d2, size, (byte) 0);
                            com.tencent.mm.view.recyclerview.i iVar = ((WxRecyclerAdapter) adapter).Rrv.get(d2.lT());
                            if (iVar != null) {
                                gVar.tIw = iVar;
                            }
                            linkedList.add(gVar);
                        }
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
        } else if (adapter instanceof f.b) {
            List<BaseFinderFeed> dpH = ((f.b) adapter).dpH();
            if (i2 <= i3) {
                while (true) {
                    int KL = ((f.b) adapter).KL(i2);
                    if (KL >= 0 && KL < dpH.size()) {
                        BaseFinderFeed baseFinderFeed = dpH.get(KL);
                        if (baseFinderFeed.lT() != 0) {
                            linkedList.add(new com.tencent.mm.plugin.finder.event.base.g(baseFinderFeed, KL, (byte) 0));
                        }
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
        }
        List<com.tencent.mm.plugin.finder.event.base.g> v2 = kotlin.a.j.v((Collection) linkedList);
        AppMethodBeat.o(253623);
        return v2;
    }

    public static final class b {
        public LinkedList<com.tencent.mm.plugin.finder.event.base.g> vXL;
        public LinkedList<bo> vXM;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.vXM, r4.vXM) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 253569(0x3de81, float:3.55326E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.utils.y.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.finder.utils.y$b r4 = (com.tencent.mm.plugin.finder.utils.y.b) r4
                java.util.LinkedList<com.tencent.mm.plugin.finder.event.base.g> r0 = r3.vXL
                java.util.LinkedList<com.tencent.mm.plugin.finder.event.base.g> r1 = r4.vXL
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.util.LinkedList<com.tencent.mm.plugin.finder.model.bo> r0 = r3.vXM
                java.util.LinkedList<com.tencent.mm.plugin.finder.model.bo> r1 = r4.vXM
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.y.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(253568);
            LinkedList<com.tencent.mm.plugin.finder.event.base.g> linkedList = this.vXL;
            int hashCode = (linkedList != null ? linkedList.hashCode() : 0) * 31;
            LinkedList<bo> linkedList2 = this.vXM;
            if (linkedList2 != null) {
                i2 = linkedList2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(253568);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(253567);
            String str = "VisibleFeedDataObj(feedDataList=" + this.vXL + ", notFeedDataList=" + this.vXM + ")";
            AppMethodBeat.o(253567);
            return str;
        }

        public /* synthetic */ b() {
            this(new LinkedList(), new LinkedList());
            AppMethodBeat.i(253566);
            AppMethodBeat.o(253566);
        }

        private b(LinkedList<com.tencent.mm.plugin.finder.event.base.g> linkedList, LinkedList<bo> linkedList2) {
            p.h(linkedList, "feedDataList");
            p.h(linkedList2, "notFeedDataList");
            AppMethodBeat.i(253565);
            this.vXL = linkedList;
            this.vXM = linkedList2;
            AppMethodBeat.o(253565);
        }
    }

    public static b a(RecyclerView recyclerView, Rect rect) {
        RecyclerView.v bi;
        FinderFoldedScrollLayout finderFoldedScrollLayout;
        ViewParent parent;
        ViewParent parent2;
        WxRecyclerAdapter<?> wxRecyclerAdapter;
        AppMethodBeat.i(253624);
        p.h(recyclerView, "recyclerView");
        p.h(rect, "globalVisibleRect");
        b bVar = new b();
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter instanceof WxRecyclerAdapter) {
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (!(childAt == null || (bi = recyclerView.bi(childAt)) == null || !(bi instanceof com.tencent.mm.view.recyclerview.h))) {
                    com.tencent.mm.view.recyclerview.a aVar = (com.tencent.mm.view.recyclerview.a) ((com.tencent.mm.view.recyclerview.h) bi).hgv();
                    int bw = RecyclerView.bw(childAt) - ((WxRecyclerAdapter) adapter).RqM.size();
                    if ((aVar instanceof bo) && aVar.lT() != 0) {
                        com.tencent.mm.plugin.finder.event.base.g gVar = new com.tencent.mm.plugin.finder.event.base.g((bo) aVar, bw, (byte) 0);
                        if (aVar instanceof BaseFinderFeed) {
                            com.tencent.mm.view.recyclerview.i iVar = ((WxRecyclerAdapter) adapter).Rrv.get(aVar.lT());
                            if (iVar != null) {
                                if (((BaseFinderFeed) aVar).feedObject.getFoldedLayout() != null) {
                                    Rect rect2 = new Rect();
                                    recyclerView.getChildVisibleRect(childAt, rect2, null);
                                    iVar.Rrc = rect.top;
                                    iVar.Rrd = rect.bottom;
                                    iVar.Rrb = rect2.top;
                                    FinderFoldedScrollLayout finderFoldedScrollLayout2 = (FinderFoldedScrollLayout) childAt.findViewById(R.id.cet);
                                    if (finderFoldedScrollLayout2 != null) {
                                        if (finderFoldedScrollLayout2.getVisibility() == 0) {
                                            finderFoldedScrollLayout = finderFoldedScrollLayout2;
                                        } else {
                                            finderFoldedScrollLayout = null;
                                        }
                                        if (!(finderFoldedScrollLayout == null || (parent = finderFoldedScrollLayout.getParent()) == null || (parent2 = parent.getParent()) == null || !(parent2 instanceof View))) {
                                            iVar.Rre = ((View) parent2).getTop();
                                            iVar.Rri = new WeakReference<>(finderFoldedScrollLayout.getAdapter());
                                            iVar.Rrh = finderFoldedScrollLayout.getAdapter().Rry;
                                            if (iVar.Rre == 0) {
                                                ((View) parent2).post(new k(parent2, finderFoldedScrollLayout, iVar, aVar, gVar, childAt, recyclerView, adapter, rect, bVar));
                                            } else if ((iVar.Rrd - iVar.Rrc) - iVar.Rrb > iVar.Rre) {
                                                if (!iVar.Rrf) {
                                                    iVar.Rrf = true;
                                                    WeakReference<WxRecyclerAdapter<?>> weakReference = iVar.Rri;
                                                    if (!(weakReference == null || (wxRecyclerAdapter = weakReference.get()) == null)) {
                                                        wxRecyclerAdapter.onResume();
                                                    }
                                                }
                                            } else if (iVar.Rrf) {
                                                iVar.Rrf = false;
                                                iVar.Rrg = true;
                                            }
                                        }
                                    }
                                }
                                gVar.tIw = iVar;
                            }
                        } else {
                            com.tencent.mm.view.recyclerview.i iVar2 = ((WxRecyclerAdapter) adapter).Rrv.get(aVar.lT());
                            if (iVar2 != null) {
                                gVar.tIw = iVar2;
                            }
                        }
                        if (!(aVar instanceof com.tencent.mm.plugin.finder.model.x)) {
                            bVar.vXL.add(gVar);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(253624);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public static final class k implements Runnable {
        final /* synthetic */ RecyclerView tCC;
        final /* synthetic */ ViewParent vXU;
        final /* synthetic */ FinderFoldedScrollLayout vXV;
        final /* synthetic */ com.tencent.mm.view.recyclerview.i vXW;
        final /* synthetic */ com.tencent.mm.view.recyclerview.a vXX;
        final /* synthetic */ com.tencent.mm.plugin.finder.event.base.g vXY;
        final /* synthetic */ View vXZ;
        final /* synthetic */ RecyclerView.a vYa;
        final /* synthetic */ Rect vYb;
        final /* synthetic */ b vYc;

        k(ViewParent viewParent, FinderFoldedScrollLayout finderFoldedScrollLayout, com.tencent.mm.view.recyclerview.i iVar, com.tencent.mm.view.recyclerview.a aVar, com.tencent.mm.plugin.finder.event.base.g gVar, View view, RecyclerView recyclerView, RecyclerView.a aVar2, Rect rect, b bVar) {
            this.vXU = viewParent;
            this.vXV = finderFoldedScrollLayout;
            this.vXW = iVar;
            this.vXX = aVar;
            this.vXY = gVar;
            this.vXZ = view;
            this.tCC = recyclerView;
            this.vYa = aVar2;
            this.vYb = rect;
            this.vYc = bVar;
        }

        public final void run() {
            WxRecyclerAdapter<?> wxRecyclerAdapter;
            AppMethodBeat.i(253575);
            this.vXW.Rre = ((View) this.vXU).getTop();
            if ((this.vXW.Rrd - this.vXW.Rrc) - this.vXW.Rrb > this.vXW.Rre) {
                if (!this.vXW.Rrf) {
                    this.vXW.Rrf = true;
                    WeakReference<WxRecyclerAdapter<?>> weakReference = this.vXW.Rri;
                    if (weakReference == null || (wxRecyclerAdapter = weakReference.get()) == null) {
                        AppMethodBeat.o(253575);
                        return;
                    }
                    wxRecyclerAdapter.onResume();
                    AppMethodBeat.o(253575);
                    return;
                }
            } else if (this.vXW.Rrf) {
                this.vXW.Rrf = false;
                this.vXW.Rrg = true;
            }
            AppMethodBeat.o(253575);
        }
    }

    public static JSONArray r(RecyclerView recyclerView) {
        int i2 = 0;
        AppMethodBeat.i(253625);
        p.h(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
            AppMethodBeat.o(253625);
            throw tVar;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] n2 = staggeredGridLayoutManager.n(null);
        int[] o2 = staggeredGridLayoutManager.o(null);
        int min = Math.min(n2 != null ? n2[0] : 0, n2 != null ? n2[1] : 0);
        int i3 = o2 != null ? o2[0] : 0;
        if (o2 != null) {
            i2 = o2[1];
        }
        List<com.tencent.mm.plugin.finder.event.base.g> a2 = a(min, Math.max(i3, i2), recyclerView);
        JSONArray jSONArray = new JSONArray();
        for (T t : a2) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedid", com.tencent.mm.ac.d.zs(t.tIu.lT()));
            jSONObject.put("feedindex", t.tIv);
            com.tencent.mm.view.recyclerview.i iVar = t.tIw;
            if (iVar != null) {
                jSONObject.put("x", iVar.Rrj + 1);
                jSONObject.put("width", iVar.width);
                jSONObject.put("height", iVar.height);
            }
            jSONArray.put(jSONObject);
        }
        AppMethodBeat.o(253625);
        return jSONArray;
    }

    public static JSONObject dCI() {
        AppMethodBeat.i(253626);
        if (vXy == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("screenwidth", com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()));
            jSONObject.put("screenheight", com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
            vXy = jSONObject;
        }
        JSONObject jSONObject2 = vXy;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        AppMethodBeat.o(253626);
        return jSONObject2;
    }

    public static int gq(int i2, int i3) {
        if (i3 != 0) {
            return (int) ((100.0f * ((float) i2)) / ((float) i3));
        }
        return 0;
    }

    public static boolean LO(int i2) {
        switch (i2) {
            case 15:
            case 19:
            case 22:
            case 23:
            case 24:
            case 26:
            case 28:
            case 30:
            case 32:
            case 33:
            case 35:
                return true;
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 25:
            case 27:
            case 29:
            case 31:
            case 34:
            default:
                return false;
        }
    }

    public static void a(int i2, TextView textView, kotlin.g.a.a<x> aVar) {
        int i3;
        int i4;
        AppMethodBeat.i(253627);
        p.h(textView, "tv");
        p.h(aVar, "onClick");
        Context context = textView.getContext();
        p.g(context, "tv.context");
        Resources resources = context.getResources();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        String string = resources.getString(R.string.cp5, com.tencent.mm.plugin.finder.storage.c.dsg());
        p.g(string, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
        Context context2 = textView.getContext();
        p.g(context2, "tv.context");
        Resources resources2 = context2.getResources();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        String string2 = resources2.getString(R.string.cp6, com.tencent.mm.plugin.finder.storage.c.dsg());
        p.g(string2, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
        int a2 = kotlin.n.n.a((CharSequence) string, string2, 0, false, 6);
        int length = a2 + string2.length();
        SpannableString spannableString = new SpannableString(string);
        if (a2 <= 0 || length > string.length()) {
            i3 = string.length();
            i4 = 0;
        } else {
            i4 = a2;
            i3 = length;
        }
        spannableString.setSpan(new l(aVar, i2, textView), i4, i3, 33);
        Context context3 = textView.getContext();
        p.g(context3, "tv.context");
        textView.setHighlightColor(context3.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        AppMethodBeat.o(253627);
    }

    public static final class l extends ClickableSpan {
        final /* synthetic */ kotlin.g.a.a tPo;
        final /* synthetic */ TextView tPp;
        final /* synthetic */ int tTj;

        l(kotlin.g.a.a aVar, int i2, TextView textView) {
            this.tPo = aVar;
            this.tTj = i2;
            this.tPp = textView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(253576);
            p.h(view, "widget");
            kotlin.g.a.a aVar = this.tPo;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(253576);
                return;
            }
            AppMethodBeat.o(253576);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(253577);
            p.h(textPaint, "ds");
            if (!y.a(y.vXH, this.tTj, 0, 2)) {
                Context context = this.tPp.getContext();
                p.g(context, "tv.context");
                textPaint.setColor(context.getResources().getColor(R.color.Link_80));
            } else {
                Context context2 = this.tPp.getContext();
                p.g(context2, "tv.context");
                textPaint.setColor(context2.getResources().getColor(R.color.vj));
            }
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(253577);
        }
    }

    public static void a(TextView textView, kotlin.g.a.a<x> aVar) {
        int i2;
        int i3;
        AppMethodBeat.i(253628);
        p.h(textView, "tv");
        p.h(aVar, "onClick");
        Context context = textView.getContext();
        p.g(context, "tv.context");
        String string = context.getResources().getString(R.string.faq);
        p.g(string, "tv.context.resources.get…rby_more_reomm_live_tips)");
        Context context2 = textView.getContext();
        p.g(context2, "tv.context");
        String string2 = context2.getResources().getString(R.string.far, string);
        p.g(string2, "tv.context.resources.get…_data_tips, gotoPageTips)");
        int a2 = kotlin.n.n.a((CharSequence) string2, string, 0, false, 6);
        int length = a2 + string.length();
        SpannableString spannableString = new SpannableString(string2);
        if (a2 <= 0 || length > string2.length()) {
            i2 = string2.length();
            i3 = 0;
        } else {
            i3 = a2;
            i2 = length;
        }
        spannableString.setSpan(new m(aVar, textView), i3, i2, 33);
        Context context3 = textView.getContext();
        p.g(context3, "tv.context");
        textView.setHighlightColor(context3.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        AppMethodBeat.o(253628);
    }

    public static final class m extends ClickableSpan {
        final /* synthetic */ kotlin.g.a.a tPo;
        final /* synthetic */ TextView tPp;

        m(kotlin.g.a.a aVar, TextView textView) {
            this.tPo = aVar;
            this.tPp = textView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(253578);
            p.h(view, "widget");
            kotlin.g.a.a aVar = this.tPo;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(253578);
                return;
            }
            AppMethodBeat.o(253578);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(253579);
            p.h(textPaint, "ds");
            Context context = this.tPp.getContext();
            p.g(context, "tv.context");
            textPaint.setColor(context.getResources().getColor(R.color.Link_100));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(253579);
        }
    }

    public static void a(TextView textView, String str, kotlin.g.a.a<x> aVar) {
        int i2;
        int i3;
        AppMethodBeat.i(253629);
        p.h(textView, "tv");
        p.h(str, "tabName");
        p.h(aVar, "onClick");
        Context context = textView.getContext();
        p.g(context, "tv.context");
        String string = context.getResources().getString(R.string.fam);
        p.g(string, "tv.context.resources.get…quare_tab_more_live_tips)");
        Context context2 = textView.getContext();
        p.g(context2, "tv.context");
        String string2 = context2.getResources().getString(R.string.fan, str, string);
        p.g(string2, "tv.context.resources.get…s, tabName, gotoPageTips)");
        int a2 = kotlin.n.n.a((CharSequence) string2, string, 0, false, 6);
        int length = a2 + string.length();
        SpannableString spannableString = new SpannableString(string2);
        if (a2 <= 0 || length > string2.length()) {
            i2 = string2.length();
            i3 = 0;
        } else {
            i3 = a2;
            i2 = length;
        }
        spannableString.setSpan(new n(aVar, textView), i3, i2, 33);
        Context context3 = textView.getContext();
        p.g(context3, "tv.context");
        textView.setHighlightColor(context3.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        AppMethodBeat.o(253629);
    }

    public static final class n extends ClickableSpan {
        final /* synthetic */ kotlin.g.a.a tPo;
        final /* synthetic */ TextView tPp;

        n(kotlin.g.a.a aVar, TextView textView) {
            this.tPo = aVar;
            this.tPp = textView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(253580);
            p.h(view, "widget");
            kotlin.g.a.a aVar = this.tPo;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(253580);
                return;
            }
            AppMethodBeat.o(253580);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(253581);
            p.h(textPaint, "ds");
            Context context = this.tPp.getContext();
            p.g(context, "tv.context");
            textPaint.setColor(context.getResources().getColor(R.color.Link_100));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(253581);
        }
    }

    public static void a(int i2, List<? extends bo> list, bbn bbn) {
        AppMethodBeat.i(253630);
        p.h(list, "remain");
        LinkedList linkedList = new LinkedList();
        for (T t : list) {
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            if (!e.a.al(i2, t.lT())) {
                bdv bdv = new bdv();
                bdv.hFK = t.lT();
                if (t instanceof BaseFinderFeed) {
                    bdv.objectNonceId = t.feedObject.getObjectNonceId();
                }
                if (bbn != null) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    bdv.sessionBuffer = com.tencent.mm.plugin.finder.report.k.G(bdv.hFK, bbn.tCE);
                }
                bdv.dLS = 4;
                linkedList.add(bdv);
            }
        }
        if (!linkedList.isEmpty()) {
            new com.tencent.mm.plugin.finder.cgi.a(linkedList, bbn).aYI();
        }
        AppMethodBeat.o(253630);
    }

    public static String aw(ca caVar) {
        String Ks;
        AppMethodBeat.i(253631);
        p.h(caVar, "msg");
        if (caVar.ajN() == 1) {
            Ks = z.aTY();
            p.g(Ks, "ConfigStorageLogic.getUsernameFromUserInfo()");
        } else if (ab.Eq(caVar.ajO())) {
            Ks = bp.Ks(caVar.getContent());
            p.g(Ks, "MsgInfoStorageLogic.getG…hatMsgTalker(msg.content)");
        } else {
            String ajO = caVar.ajO();
            p.g(ajO, "msg.talker");
            AppMethodBeat.o(253631);
            return ajO;
        }
        AppMethodBeat.o(253631);
        return Ks;
    }

    public static String ax(ca caVar) {
        String aTY;
        AppMethodBeat.i(253632);
        p.h(caVar, "msg");
        if (caVar.ajN() == 1) {
            aTY = caVar.ajO();
            p.g(aTY, "msg.talker");
        } else if (ab.Eq(caVar.ajO())) {
            aTY = caVar.ajO();
            p.g(aTY, "msg.talker");
        } else {
            aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        }
        AppMethodBeat.o(253632);
        return aTY;
    }

    public static String LP(int i2) {
        AppMethodBeat.i(253633);
        switch (i2) {
            case 0:
                AppMethodBeat.o(253633);
                return "TAB_TYPE_ALL";
            case 1:
                AppMethodBeat.o(253633);
                return "TAB_TYPE_FRIEND";
            case 2:
                AppMethodBeat.o(253633);
                return "TAB_TYPE_LBS";
            case 3:
                AppMethodBeat.o(253633);
                return "TAB_TYPE_FOLLOW";
            case 4:
                AppMethodBeat.o(253633);
                return "TAB_TYPE_MACHINE";
            default:
                String concat = "unknow ".concat(String.valueOf(i2));
                AppMethodBeat.o(253633);
                return concat;
        }
    }

    public static void dCJ() {
        AppMethodBeat.i(253634);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        aAh3.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh4, "MMKernel.storage()");
        aAh4.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh5, "MMKernel.storage()");
        aAh5.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh6, "MMKernel.storage()");
        aAh6.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh7, "MMKernel.storage()");
        aAh7.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh8, "MMKernel.storage()");
        aAh8.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh9, "MMKernel.storage()");
        aAh9.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh10, "MMKernel.storage()");
        aAh10.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        AppMethodBeat.o(253634);
    }

    public static void dCK() {
        AppMethodBeat.i(253635);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
        AppMethodBeat.o(253635);
    }

    public static void hT(View view) {
        AppMethodBeat.i(261483);
        if (!(view == null || view.getVisibility() == 0)) {
            view.setVisibility(0);
        }
        AppMethodBeat.o(261483);
    }

    public static int LQ(int i2) {
        if (i2 == 2) {
            return R.color.BW_0_Alpha_0_3;
        }
        return R.color.fo;
    }

    public static boolean B(FinderItem finderItem) {
        AppMethodBeat.i(253638);
        p.h(finderItem, "item");
        if (finderItem.getFeedObject().incFriendLikeCount <= 0 || finderItem.getFeedObject().msgEventFlag != 1) {
            AppMethodBeat.o(253638);
            return false;
        }
        AppMethodBeat.o(253638);
        return true;
    }

    public static <T, E> List<E> a(List<? extends T> list, Class<E> cls) {
        AppMethodBeat.i(253639);
        p.h(list, "dataList");
        p.h(cls, "clazz");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (cls.isInstance(t)) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(253639);
        return arrayList;
    }

    public static /* synthetic */ void a(int i2, List list, com.tencent.mm.bw.b bVar, Intent intent) {
        AppMethodBeat.i(253641);
        a(i2, list, bVar, intent, (com.tencent.mm.plugin.finder.feed.model.a) null);
        AppMethodBeat.o(253641);
    }

    public static void a(int i2, List<? extends bo> list, com.tencent.mm.bw.b bVar, Intent intent, com.tencent.mm.plugin.finder.feed.model.a aVar) {
        AppMethodBeat.i(253640);
        p.h(list, "feedList");
        p.h(intent, "intent");
        FinderEmptyLoader finderEmptyLoader = new FinderEmptyLoader();
        finderEmptyLoader.getDataList().addAll(list);
        finderEmptyLoader.setLastBuffer(bVar);
        finderEmptyLoader.saveCache(intent, i2, aVar);
        AppMethodBeat.o(253640);
    }

    public static Intent a(BaseFinderFeedLoader baseFinderFeedLoader, LinearLayoutManager linearLayoutManager) {
        AppMethodBeat.i(253642);
        p.h(baseFinderFeedLoader, "feedLoader");
        p.h(linearLayoutManager, "layoutManager");
        Intent intent = new Intent();
        DataBuffer dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter();
        com.tencent.mm.bw.b lastBuffer = baseFinderFeedLoader.getLastBuffer();
        int initPos = baseFinderFeedLoader.getInitPos();
        int ks = linearLayoutManager.ks();
        int ku = linearLayoutManager.ku();
        Log.i(TAG, "fixRVPos posStart:" + ks + ", posEnd " + ku + ", initPos:" + initPos);
        if (initPos >= ks && initPos <= ku) {
            ks = -1;
        }
        BaseFeedLoader.saveCacheToIntent$default(baseFinderFeedLoader, intent, dataListJustForAdapter, lastBuffer, ks, null, 16, null);
        AppMethodBeat.o(253642);
        return intent;
    }

    public static /* synthetic */ com.tencent.mm.plugin.finder.feed.model.h a(Intent intent, RecyclerView recyclerView, BaseFeedLoader baseFeedLoader) {
        AppMethodBeat.i(253644);
        com.tencent.mm.plugin.finder.feed.model.h a2 = a(intent, recyclerView, (BaseFeedLoader<bo>) baseFeedLoader, true, (kotlin.g.a.b<? super bo, Boolean>) null);
        AppMethodBeat.o(253644);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.feed.model.h a(Intent intent, RecyclerView recyclerView, BaseFeedLoader<bo> baseFeedLoader, boolean z, kotlin.g.a.b<? super bo, Boolean> bVar) {
        ArrayList<bo> arrayList;
        boolean z2;
        AppMethodBeat.i(253643);
        p.h(intent, "data");
        p.h(recyclerView, "recyclerView");
        p.h(baseFeedLoader, "feedLoader");
        RecyclerView.a adapter = recyclerView.getAdapter();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        baseFeedLoader.initBackCache(intent);
        com.tencent.mm.plugin.finder.feed.model.h backCache = baseFeedLoader.getBackCache();
        if (!(adapter instanceof WxRecyclerAdapter) || !(layoutManager instanceof StaggeredGridLayoutManager) || backCache == null || Util.isNullOrNil(backCache.kgc) || backCache.lastBuffer == null) {
            AppMethodBeat.o(253643);
            return null;
        }
        int size = ((WxRecyclerAdapter) adapter).RqM.size();
        DataBuffer<T> dataList = baseFeedLoader.getDataList();
        if (bVar == null) {
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (T t : dataList) {
                i2++;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                if (i2 >= size) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList2.add(t);
                }
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            int i3 = 0;
            for (T t2 : dataList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                T t3 = t2;
                if (i3 >= size && bVar.invoke(t3).booleanValue()) {
                    arrayList3.add(t3);
                }
                i3 = i4;
            }
            arrayList = arrayList3;
        }
        if (arrayList.size() != backCache.kgc.size()) {
            for (bo boVar : arrayList) {
                dataList.remove(boVar);
            }
            dataList.addAll(backCache.kgc);
            if (z) {
                baseFeedLoader.setLastBuffer(backCache.lastBuffer);
            }
            adapter.notifyDataSetChanged();
        }
        if (backCache.position >= 0) {
            ((StaggeredGridLayoutManager) layoutManager).ah(a(n(backCache.position, backCache.kgc), dataList) + size, 0);
        }
        Log.i(TAG, "mergeBackCacheAndNotify, pos:" + backCache.position + ", headCount:" + size);
        AppMethodBeat.o(253643);
        return backCache;
    }

    public static bo n(int i2, List<? extends bo> list) {
        AppMethodBeat.i(253645);
        p.h(list, "feedList");
        if (i2 < 0 || i2 >= list.size()) {
            AppMethodBeat.o(253645);
            return null;
        }
        bo boVar = (bo) list.get(i2);
        AppMethodBeat.o(253645);
        return boVar;
    }

    public static int a(bo boVar, List<? extends bo> list) {
        int i2;
        AppMethodBeat.i(253646);
        p.h(list, "feedList");
        if (boVar != null) {
            int i3 = 0;
            i2 = 0;
            for (T t : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                if (t.lT() == boVar.lT()) {
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3 = i4;
                }
            }
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(253646);
        return i2;
    }

    public static com.tencent.mm.i.h a(String str, String str2, String str3, int i2, String str4, String str5, String str6, boolean z, h.a aVar, String str7) {
        AppMethodBeat.i(253647);
        p.h(str, "mediaId");
        p.h(str2, "url");
        p.h(str3, "path");
        p.h(str4, "fileFormat");
        p.h(str5, "urlToken");
        p.h(aVar, "videoCallback");
        p.h(str7, "tag");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean dsh = com.tencent.mm.plugin.finder.storage.c.dsh();
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.taskName = "task_FinderUtil";
        hVar.field_mediaId = str;
        hVar.url = str2 + str5;
        hVar.gqC = 60;
        hVar.gqD = 60;
        hVar.gqU = 1;
        hVar.gqP = 8;
        hVar.grb = 0;
        if (!dsh) {
            hVar.field_requestVideoFormat = i2 <= 0 ? com.tencent.mm.modelcontrol.e.L(1, str3) : i2;
        } else {
            hVar.field_requestVideoFormat = 0;
            hVar.videoFlag = str4;
        }
        hVar.field_fullpath = str3;
        hVar.concurrentCount = k.a.wEc;
        hVar.connectionCount = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUs;
        hVar.snsCipherKey = str6;
        hVar.isHotSnsVideo = z;
        hVar.gre = aVar;
        Log.i(str7, "[loadByCdn] finder video, isHot=" + z + " reqFormat=" + i2 + " fileFormat=" + str4 + ",isOpenMultiBitRateDownload=" + dsh + ", decodeKey=" + str6 + ' ' + str5 + " mediaId=" + str + " url=" + hVar.url + ' ');
        AppMethodBeat.o(253647);
        return hVar;
    }

    public static com.tencent.mm.i.h a(String str, String str2, String str3, int i2, String str4, String str5, String str6, boolean z, g.a aVar, g.b bVar, int i3, long j2, String str7) {
        AppMethodBeat.i(253648);
        p.h(str, "mediaId");
        p.h(str2, "url");
        p.h(str3, "path");
        p.h(str4, "fileFormat");
        p.h(str5, "urlToken");
        p.h(str7, "tag");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean dsh = com.tencent.mm.plugin.finder.storage.c.dsh();
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.field_mediaId = str;
        hVar.url = str2 + str5;
        hVar.field_fullpath = str3;
        hVar.snsCipherKey = str6;
        hVar.isHotSnsVideo = z;
        hVar.gqO = 2;
        hVar.gqU = 2;
        hVar.gqP = 8;
        hVar.gqZ = i3;
        hVar.field_preloadRatio = i3;
        hVar.concurrentCount = k.a.wEc;
        hVar.connectionCount = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUr;
        hVar.field_fileType = com.tencent.mm.i.a.gpV;
        hVar.preloadMinSize = j2;
        hVar.grb = 0;
        hVar.gqy = aVar;
        hVar.gqQ = bVar;
        if (!dsh) {
            hVar.field_requestVideoFormat = i2 <= 0 ? com.tencent.mm.modelcontrol.e.L(1, str3) : i2;
        } else {
            hVar.field_requestVideoFormat = 0;
            hVar.videoFlag = str4;
        }
        Log.i(str7, "[createVideoPreloadTask] finder video, isHot=" + z + " reqFormat=" + i2 + " fileFormat=" + str4 + ",isOpenMultiBitRateDownload=" + dsh + ", decodeKey=" + str6 + ' ' + str5 + " mediaId=" + str + " url=" + hVar.url + " preloadPercent:" + i3 + " preloadMinSize:" + j2);
        AppMethodBeat.o(253648);
        return hVar;
    }

    public static /* synthetic */ void a(ImageView imageView, FinderAuthInfo finderAuthInfo) {
        AppMethodBeat.i(253650);
        a(imageView, finderAuthInfo, 1);
        AppMethodBeat.o(253650);
    }

    public static void a(ImageView imageView, FinderAuthInfo finderAuthInfo, int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(253649);
        p.h(imageView, "view");
        imageView.setVisibility(8);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
        if (finderAuthInfo != null) {
            Log.i(TAG, "authType = " + finderAuthInfo.authIconType + ", authIconUrl = " + finderAuthInfo.authIconUrl);
            imageView.setVisibility(0);
            if (finderAuthInfo.authIconType > 0) {
                switch (finderAuthInfo.authIconType) {
                    case 1:
                        String str = finderAuthInfo.authIconUrl;
                        if (str == null || str.length() == 0) {
                            z2 = true;
                        }
                        if (!z2) {
                            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
                            com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(finderAuthInfo.authIconUrl, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            djY.a(pVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                            AppMethodBeat.o(253649);
                            return;
                        } else if (i2 == 0) {
                            imageView.setImageResource(R.raw.icons_filled_star_identify_sold);
                            AppMethodBeat.o(253649);
                            return;
                        } else {
                            imageView.setImageDrawable(com.tencent.mm.ui.ar.m(imageView.getContext(), R.raw.icons_filled_star_identify, com.tencent.mm.cb.a.n(imageView.getContext(), R.color.a3b)));
                            AppMethodBeat.o(253649);
                            return;
                        }
                    case 2:
                        String str2 = finderAuthInfo.authIconUrl;
                        if (str2 == null || str2.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY2 = com.tencent.mm.plugin.finder.loader.m.djY();
                            com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(finderAuthInfo.authIconUrl, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                            com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            djY2.a(pVar2, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                            AppMethodBeat.o(253649);
                            return;
                        } else if (i2 == 0) {
                            imageView.setImageResource(R.raw.icons_filled_star_identify_enterprise_sold);
                            AppMethodBeat.o(253649);
                            return;
                        } else {
                            imageView.setImageResource(R.raw.icons_filled_star_identify_enterprise);
                            AppMethodBeat.o(253649);
                            return;
                        }
                    case 100:
                        imageView.setVisibility(8);
                        AppMethodBeat.o(253649);
                        return;
                    default:
                        imageView.setVisibility(8);
                        AppMethodBeat.o(253649);
                        return;
                }
            } else {
                imageView.setVisibility(8);
                AppMethodBeat.o(253649);
            }
        } else {
            AppMethodBeat.o(253649);
        }
    }

    public static boolean d(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(253651);
        p.h(context, "context");
        Log.e(TAG, "checkShowCgiErrorAlter: errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (!(i2 == 0 && i3 == 0)) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                d.a aVar = new d.a(context);
                aVar.boo(str);
                aVar.Dk(true);
                aVar.aoV(R.string.x_);
                aVar.show();
                AppMethodBeat.o(253651);
                return true;
            }
        }
        AppMethodBeat.o(253651);
        return false;
    }

    public static int LR(int i2) {
        switch (i2) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 11:
                return 5;
            case 14:
                return 6;
            case 15:
                return 7;
            case 18:
                return 15;
            default:
                return -1;
        }
    }

    public static int dCL() {
        Object[] objArr;
        boolean z = true;
        int i2 = 1;
        AppMethodBeat.i(253652);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dtr().value().intValue();
        if (intValue != -1) {
            Log.d(TAG, "harcode user state = ".concat(String.valueOf(intValue)));
            AppMethodBeat.o(253652);
            return intValue;
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        boolean z2 = (aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0) & 2) != 0;
        boolean showPostEntry = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).showPostEntry();
        String aUg = z.aUg();
        if (aUg == null || aUg.length() == 0) {
            objArr = 1;
        } else {
            objArr = null;
        }
        boolean z3 = objArr == null;
        Log.i(TAG, "[checkUserState] hasCreatedIdentity=" + z3 + ", showPostEntry=" + showPostEntry + ", isReviewing=" + z2);
        if (!showPostEntry) {
            Log.i(TAG, "resultState = USER_STATE_NO_POST_QUALITY");
        } else if (z3) {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG == null) {
                p.hyc();
            }
            boolean isBlock = asG.isBlock();
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG2 = c.a.asG(z.aUg());
            if (asG2 == null) {
                p.hyc();
            }
            if (asG2.field_spamStatus != 2) {
                z = false;
            }
            Log.i(TAG, "[checkUserState] isAccountBlocked=" + isBlock + ", isAccountSilent=" + z);
            if (isBlock) {
                Log.i(TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
                i2 = 4;
            } else if (z) {
                Log.i(TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
                i2 = 6;
            } else {
                Log.i(TAG, "resultState = USER_STATE_NORMAL");
                i2 = 3;
            }
        } else if (z2) {
            Log.i(TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
            i2 = 5;
        } else {
            Log.i(TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
            i2 = 2;
        }
        AppMethodBeat.o(253652);
        return i2;
    }

    public static boolean bd(int i2, long j2) {
        AppMethodBeat.i(261484);
        if (i2 > 0 || (j2 != 0 && 1000 * j2 < cl.aWA())) {
            AppMethodBeat.o(261484);
            return true;
        }
        AppMethodBeat.o(261484);
        return false;
    }

    public static /* synthetic */ void Gh(long j2) {
        AppMethodBeat.i(253654);
        a(j2, false, -1);
        AppMethodBeat.o(253654);
    }

    public static void a(long j2, boolean z, int i2) {
        AppMethodBeat.i(253653);
        if (BuildInfo.IS_FLAVOR_PURPLE) {
            hn hnVar = new hn();
            hnVar.dLW.id = j2;
            hnVar.dLW.dLY = z ? 1 : 0;
            hnVar.dLW.dLX = i2;
            hnVar.dLW.type = 7;
            EventCenter.instance.publish(hnVar);
        }
        AppMethodBeat.o(253653);
    }

    public static String LS(int i2) {
        AppMethodBeat.i(253656);
        String str = "¥" + new DecimalFormat("0.00").format(((double) i2) / 100.0d);
        AppMethodBeat.o(253656);
        return str;
    }

    public static boolean dCM() {
        return BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG;
    }

    public static String dCN() {
        AppMethodBeat.i(253657);
        if (dCM()) {
            String mMStack = Util.getStack().toString();
            p.g(mMStack, "Util.getStack().toString()");
            AppMethodBeat.o(253657);
            return mMStack;
        }
        AppMethodBeat.o(253657);
        return "";
    }

    public static String RN(long j2) {
        AppMethodBeat.i(261485);
        if (j2 <= 0) {
            AppMethodBeat.o(261485);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (j2 < 10000) {
            String valueOf = String.valueOf(j2);
            AppMethodBeat.o(261485);
            return valueOf;
        } else if (j2 % 10000 >= 10000) {
            if (LocaleUtil.isChineseAppLang()) {
                ae aeVar = ae.SYK;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.d40);
                p.g(string, "MMApplicationContext.get…mber_more_than_100000000)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(((float) j2) / 10000.0f)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                AppMethodBeat.o(261485);
                return format;
            }
            ae aeVar2 = ae.SYK;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string2 = context2.getResources().getString(R.string.d43);
            p.g(string2, "MMApplicationContext.get…r_more_than_100000000_v2)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(j2 / 1000)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(261485);
            return format2;
        } else if (j2 % 10000 < 1000) {
            ae aeVar3 = ae.SYK;
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            String string3 = context3.getResources().getString(R.string.cti);
            p.g(string3, "MMApplicationContext.get…ve_like_count_int_format)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{Long.valueOf(j2 / 10000)}, 1));
            p.g(format3, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(261485);
            return format3;
        } else if (LocaleUtil.isChineseAppLang()) {
            ae aeVar4 = ae.SYK;
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            String string4 = context4.getResources().getString(R.string.ctg);
            p.g(string4, "MMApplicationContext.get…r_live_like_count_format)");
            String format4 = String.format(string4, Arrays.copyOf(new Object[]{Float.valueOf(((float) j2) / 10000.0f)}, 1));
            p.g(format4, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(261485);
            return format4;
        } else {
            ae aeVar5 = ae.SYK;
            Context context5 = MMApplicationContext.getContext();
            p.g(context5, "MMApplicationContext.getContext()");
            String string5 = context5.getResources().getString(R.string.cth);
            p.g(string5, "MMApplicationContext.get…count_format_not_chinese)");
            String format5 = String.format(string5, Arrays.copyOf(new Object[]{Long.valueOf(j2 / 1000)}, 1));
            p.g(format5, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(261485);
            return format5;
        }
    }

    public static String LT(int i2) {
        AppMethodBeat.i(253658);
        if (i2 <= 0) {
            AppMethodBeat.o(253658);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i2 < 10000) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(253658);
            return valueOf;
        } else if (i2 % 10000 >= 10000) {
            if (LocaleUtil.isChineseAppLang()) {
                ae aeVar = ae.SYK;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.d40);
                p.g(string, "MMApplicationContext.get…mber_more_than_100000000)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(((float) i2) / 10000.0f)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                AppMethodBeat.o(253658);
                return format;
            }
            ae aeVar2 = ae.SYK;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string2 = context2.getResources().getString(R.string.d43);
            p.g(string2, "MMApplicationContext.get…r_more_than_100000000_v2)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 1000)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(253658);
            return format2;
        } else if (i2 % 10000 < 1000) {
            ae aeVar3 = ae.SYK;
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            String string3 = context3.getResources().getString(R.string.cti);
            p.g(string3, "MMApplicationContext.get…ve_like_count_int_format)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 10000)}, 1));
            p.g(format3, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(253658);
            return format3;
        } else if (LocaleUtil.isChineseAppLang()) {
            ae aeVar4 = ae.SYK;
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            String string4 = context4.getResources().getString(R.string.ctg);
            p.g(string4, "MMApplicationContext.get…r_live_like_count_format)");
            String format4 = String.format(string4, Arrays.copyOf(new Object[]{Float.valueOf(((float) i2) / 10000.0f)}, 1));
            p.g(format4, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(253658);
            return format4;
        } else {
            ae aeVar5 = ae.SYK;
            Context context5 = MMApplicationContext.getContext();
            p.g(context5, "MMApplicationContext.getContext()");
            String string5 = context5.getResources().getString(R.string.cth);
            p.g(string5, "MMApplicationContext.get…count_format_not_chinese)");
            String format5 = String.format(string5, Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 1000)}, 1));
            p.g(format5, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(253658);
            return format5;
        }
    }

    public static String LU(int i2) {
        AppMethodBeat.i(253659);
        if (i2 <= 0) {
            AppMethodBeat.o(253659);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i2 < 100) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(253659);
            return valueOf;
        } else {
            AppMethodBeat.o(253659);
            return "...";
        }
    }

    public static com.tencent.mm.plugin.appbrand.api.g c(awc awc) {
        String str;
        AppMethodBeat.i(253660);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        if (awc != null) {
            gVar.appId = awc.LGz;
            gVar.kHw = awc.LGH;
            com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
            xVar.ukr = awc.ukr;
            xVar.ukp = 1;
            gVar.kHx = xVar;
            m mVar = m.vVH;
            gVar.scene = m.dBP() ? 1176 : 1177;
            gVar.kHL = new HalfScreenConfig(true, 10, true, null, false, null, false, null, 248);
            gVar.username = awc.LGI;
            if (dCM() && !Util.isNullOrNil(gVar.username) && (str = gVar.username) != null && !kotlin.n.n.nm(str, "@app")) {
                gVar.username += "@app";
            }
        }
        AppMethodBeat.o(253660);
        return gVar;
    }

    public static boolean c(axg axg) {
        AppMethodBeat.i(253661);
        p.h(axg, "item");
        if (axg.LHO > 0) {
            AppMethodBeat.o(253661);
            return true;
        }
        AppMethodBeat.o(253661);
        return false;
    }

    public static long dCO() {
        AppMethodBeat.i(253662);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwk().value().intValue() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            AppMethodBeat.o(253662);
            return currentTimeMillis;
        }
        long aWA = cl.aWA();
        AppMethodBeat.o(253662);
        return aWA;
    }

    public static r<ArrayList<String>, ArrayList<List<String>>, ArrayList<List<String>>> dCP() {
        AppMethodBeat.i(253663);
        Date date = new Date(dCO());
        Calendar instance = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < 30; i2++) {
            p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            instance.setTime(date);
            instance.set(5, instance.get(5) + i2);
            int i3 = instance.get(5);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            arrayList.add(context.getResources().getString(R.string.cxz, Integer.valueOf(instance.get(2) + 1), Integer.valueOf(i3)));
        }
        for (String str : arrayList) {
            Log.i("getNoticePicker", str);
        }
        if (date.getHours() >= 23 && date.getMinutes() >= 55) {
            arrayList.remove(0);
        }
        ArrayList<List<String>> R = R(arrayList.size(), R.string.cy1, false);
        r<ArrayList<String>, ArrayList<List<String>>, ArrayList<List<String>>> rVar = new r<>(arrayList, R, LW(arrayList.size() * R.size()));
        AppMethodBeat.o(253663);
        return rVar;
    }

    public static com.tencent.mm.bw.b j(com.tencent.mm.bw.a aVar) {
        AppMethodBeat.i(253664);
        p.h(aVar, "$this$toByteString");
        byte[] byteArray = aVar.toByteArray();
        if (byteArray != null) {
            com.tencent.mm.bw.b bVar = new com.tencent.mm.bw.b(byteArray);
            AppMethodBeat.o(253664);
            return bVar;
        }
        AppMethodBeat.o(253664);
        return null;
    }

    public static ArrayList<List<String>> R(int i2, int i3, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(261486);
        ArrayList<String> arrayList = new ArrayList();
        ArrayList<List<String>> arrayList2 = new ArrayList<>();
        for (int i4 = 0; i4 < 24; i4++) {
            String LX = LX(i4);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            arrayList.add(context.getResources().getString(i3, LX));
        }
        for (String str : arrayList) {
            Log.i("getNoticePicker", str);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            arrayList2.add(arrayList);
        }
        Object clone = arrayList.clone();
        if (clone == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            AppMethodBeat.o(261486);
            throw tVar;
        }
        ArrayList arrayList3 = (ArrayList) clone;
        Date date = new Date(dCO());
        Calendar instance = Calendar.getInstance();
        p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        instance.setTime(date);
        int i6 = instance.get(11);
        if (z) {
            if (i6 >= 0) {
                int i7 = 0;
                while (true) {
                    arrayList3.remove(0);
                    if (i7 == i6) {
                        break;
                    }
                    i7++;
                }
            }
            arrayList2.remove(0);
            if (arrayList3.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                arrayList2.add(0, arrayList3);
            }
        } else {
            for (int i8 = 0; i8 < i6; i8++) {
                arrayList3.remove(0);
            }
            arrayList2.remove(0);
            if (date.getMinutes() >= 55) {
                arrayList3.remove(0);
            }
            if (!arrayList3.isEmpty()) {
                arrayList2.add(0, arrayList3);
            }
        }
        AppMethodBeat.o(261486);
        return arrayList2;
    }

    private static ArrayList<List<String>> LW(int i2) {
        AppMethodBeat.i(253666);
        ArrayList<String> arrayList = new ArrayList();
        ArrayList<List<String>> arrayList2 = new ArrayList<>();
        kotlin.k.d a2 = kotlin.k.j.a((kotlin.k.d) kotlin.k.j.mY(0, 60), 5);
        int i3 = a2.SYU;
        int i4 = a2.SYV;
        int i5 = a2.lCq;
        if (i5 < 0 ? i3 >= i4 : i3 <= i4) {
            while (true) {
                String LX = LX(i3);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                arrayList.add(context.getResources().getString(R.string.cy2, LX));
                if (i3 == i4) {
                    break;
                }
                i3 += i5;
            }
        }
        for (String str : arrayList) {
            Log.i("getNoticePicker", str);
        }
        for (int i6 = 0; i6 < i2; i6++) {
            arrayList2.add(arrayList);
        }
        Object clone = arrayList.clone();
        if (clone == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            AppMethodBeat.o(253666);
            throw tVar;
        }
        ArrayList arrayList3 = (ArrayList) clone;
        Date date = new Date(dCO());
        Calendar instance = Calendar.getInstance();
        p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        instance.setTime(date);
        int i7 = (instance.get(12) / 5) + 1;
        for (int i8 = 0; i8 < i7; i8++) {
            arrayList3.remove(0);
        }
        arrayList2.remove(0);
        if (!arrayList3.isEmpty()) {
            arrayList2.add(0, arrayList3);
        }
        AppMethodBeat.o(253666);
        return arrayList2;
    }

    public static String LX(int i2) {
        AppMethodBeat.i(253667);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(253667);
            return concat;
        }
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(253667);
        return valueOf;
    }

    public static void q(TextView textView) {
        AppMethodBeat.i(253668);
        p.h(textView, "tv");
        try {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/WeChatSansStd-Medium.ttf"));
            AppMethodBeat.o(253668);
        } catch (Exception e2) {
            Log.e(TAG, "setTypeface() Exception:" + e2.getMessage());
            AppMethodBeat.o(253668);
        }
    }

    public static FinderImgFeedMusicTag X(RecyclerView.v vVar) {
        FinderImgFeedMusicTag finderImgFeedMusicTag;
        Object obj;
        FinderImgFeedMusicTag finderImgFeedMusicTag2;
        View view;
        AppMethodBeat.i(253669);
        if (vVar == null || (view = vVar.aus) == null) {
            finderImgFeedMusicTag = null;
        } else {
            finderImgFeedMusicTag = (FinderImgFeedMusicTag) view.findViewById(R.id.a38);
        }
        if (finderImgFeedMusicTag != null) {
            obj = finderImgFeedMusicTag.getTag(R.id.d0m);
        } else {
            obj = null;
        }
        if (obj != null) {
            Object tag = finderImgFeedMusicTag.getTag(R.id.d0m);
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(253669);
                throw tVar;
            } else if (((Boolean) tag).booleanValue()) {
                finderImgFeedMusicTag2 = finderImgFeedMusicTag;
                AppMethodBeat.o(253669);
                return finderImgFeedMusicTag2;
            }
        }
        finderImgFeedMusicTag2 = null;
        AppMethodBeat.o(253669);
        return finderImgFeedMusicTag2;
    }

    public static boolean j(com.tencent.mm.plugin.finder.api.g gVar) {
        return (gVar == null || (gVar.field_extFlag & 16384) == 0) ? false : true;
    }

    public static boolean C(FinderItem finderItem) {
        FinderObjectDesc finderObjectDesc;
        azr azr;
        azr azr2;
        FinderObjectDesc finderObjectDesc2;
        azr azr3;
        azr azr4;
        azr azr5;
        azr azr6 = null;
        AppMethodBeat.i(253670);
        p.h(finderItem, "feed");
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            AppMethodBeat.o(253670);
            return false;
        } else if (!x(finderItem.getFinderObject())) {
            AppMethodBeat.o(253670);
            return false;
        } else if (D(finderItem)) {
            AppMethodBeat.o(253670);
            return true;
        } else if (finderItem.getMediaType() == 2) {
            FinderObjectDesc finderObjectDesc3 = finderItem.getFeedObject().objectDesc;
            if (finderObjectDesc3 != null) {
                azr2 = finderObjectDesc3.feedBgmInfo;
            } else {
                azr2 = null;
            }
            if (azr2 != null && ((finderObjectDesc2 = finderItem.getFeedObject().objectDesc) == null || (azr5 = finderObjectDesc2.feedBgmInfo) == null || azr5.LJw != 0)) {
                FinderObjectDesc finderObjectDesc4 = finderItem.getFeedObject().objectDesc;
                String str = (finderObjectDesc4 == null || (azr4 = finderObjectDesc4.feedBgmInfo) == null) ? null : azr4.groupId;
                if (!(str == null || str.length() == 0)) {
                    FinderObjectDesc finderObjectDesc5 = finderItem.getFeedObject().objectDesc;
                    if (finderObjectDesc5 == null || (azr3 = finderObjectDesc5.feedBgmInfo) == null || azr3.musicInfo == null) {
                        AppMethodBeat.o(253670);
                        return false;
                    }
                    AppMethodBeat.o(253670);
                    return true;
                }
            }
            AppMethodBeat.o(253670);
            return false;
        } else if (finderItem.getMediaType() == 4) {
            FinderObjectDesc finderObjectDesc6 = finderItem.getFeedObject().objectDesc;
            if (finderObjectDesc6 != null) {
                azr6 = finderObjectDesc6.feedBgmInfo;
            }
            if (azr6 == null || !((finderObjectDesc = finderItem.getFeedObject().objectDesc) == null || (azr = finderObjectDesc.feedBgmInfo) == null || azr.LJw != 1)) {
                AppMethodBeat.o(253670);
                return true;
            }
            AppMethodBeat.o(253670);
            return false;
        } else {
            AppMethodBeat.o(253670);
            return false;
        }
    }

    public static boolean D(FinderItem finderItem) {
        AppMethodBeat.i(253671);
        p.h(finderItem, "finderItem");
        if (Util.isNullOrNil(finderItem.getLongVideoMediaList()) || vfH != 1) {
            AppMethodBeat.o(253671);
            return false;
        }
        AppMethodBeat.o(253671);
        return true;
    }

    public static boolean aws(String str) {
        boolean z = false;
        AppMethodBeat.i(253672);
        p.h(str, "path");
        long currentTimeMillis = System.currentTimeMillis();
        if (!s.YS(str)) {
            AppMethodBeat.o(253672);
        } else {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = s.dB(str, false);
                com.tencent.mm.plugin.a.a b2 = com.tencent.mm.plugin.a.c.b(randomAccessFile, new byte[8], com.tencent.mm.plugin.a.a.blk);
                p.g(b2, "moovAtom");
                long blQ = b2.blQ() + 8;
                Log.i(TAG, "[isMoovOptimize] cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms beginPos=" + blQ + " remains=" + (b2.getSize() - 8));
                if (blQ > 0) {
                    z = true;
                }
                Util.qualityClose(randomAccessFile);
            } catch (Exception e2) {
                Util.qualityClose(randomAccessFile);
            } catch (Throwable th) {
                Util.qualityClose(randomAccessFile);
                AppMethodBeat.o(253672);
                throw th;
            }
            AppMethodBeat.o(253672);
        }
        return z;
    }

    public static int Lt(int i2) {
        if (i2 % 2 != 0) {
            return i2 - 1;
        }
        return i2;
    }

    public static int e(int i2, int i3, float f2) {
        int i4 = 255;
        AppMethodBeat.i(253673);
        if (f2 <= 0.5f) {
            int alpha = Color.alpha(i2);
            if (alpha != 0) {
                i4 = alpha;
            }
            int argb = Color.argb(Math.min(kotlin.h.a.cR((0.5f - f2) * 255.0f * 2.0f), i4), Color.red(i2), Color.green(i2), Color.blue(i2));
            AppMethodBeat.o(253673);
            return argb;
        }
        int alpha2 = Color.alpha(i3);
        if (alpha2 != 0) {
            i4 = alpha2;
        }
        int argb2 = Color.argb(Math.min(kotlin.h.a.cR((f2 - 0.5f) * 255.0f * 2.0f), i4), Color.red(i3), Color.green(i3), Color.blue(i3));
        AppMethodBeat.o(253673);
        return argb2;
    }

    public static void dCQ() {
        vXz = true;
    }

    public static int dCR() {
        return vXB;
    }

    public static void dCS() {
        AppMethodBeat.i(253674);
        if (vXz) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXA = com.tencent.mm.plugin.finder.storage.c.dwr().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXB = com.tencent.mm.plugin.finder.storage.c.dws().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXC = com.tencent.mm.plugin.finder.storage.c.dwt().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXD = com.tencent.mm.plugin.finder.storage.c.dwu().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXE = com.tencent.mm.plugin.finder.storage.c.dww().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXF = com.tencent.mm.plugin.finder.storage.c.dwv().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
            vXG = com.tencent.mm.plugin.finder.storage.c.dwx().value().intValue();
            com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
            UVj = com.tencent.mm.plugin.finder.storage.c.hVa().value().intValue();
            vXz = false;
            Log.i(TAG, "[checkResetFullScreenConfig] reset config GLOBAL=" + vXA + " HOT=" + vXB + ' ' + "FOLLOW=" + vXC + " FRIEND=" + vXD + ' ' + "SHARE=" + vXE + " OTHER=" + vXF);
            Log.i(TAG, "[checkResetFullScreenConfig] reset config DISABLE_HALF_SCREEN=" + vXG + ' ' + "ALLOW_FILLING_FULL_SCREEN_VALUE=" + UVj);
        }
        AppMethodBeat.o(253674);
    }

    public static boolean isAnyHomeTabEnableFullScreenEnjoy() {
        AppMethodBeat.i(253675);
        dCS();
        if (vXA == 1 || vXF == 1 || vXB == 1 || vXC == 1 || vXD == 1) {
            AppMethodBeat.o(253675);
            return true;
        }
        AppMethodBeat.o(253675);
        return false;
    }

    public static boolean LY(int i2) {
        AppMethodBeat.i(253676);
        dCS();
        if (vXA == 1 || ((vXB == 1 && i2 == 4) || ((vXC == 1 && i2 == 3) || (vXD == 1 && i2 == 1)))) {
            AppMethodBeat.o(253676);
            return true;
        }
        AppMethodBeat.o(253676);
        return false;
    }

    public static boolean isAllHomeTabEnableFullScreenEnjoy() {
        AppMethodBeat.i(253677);
        dCS();
        if (vXA == 1 || (vXB == 1 && vXC == 1 && vXD == 1)) {
            AppMethodBeat.o(253677);
            return true;
        }
        AppMethodBeat.o(253677);
        return false;
    }

    public static boolean isAnyEnableFullScreenEnjoy() {
        AppMethodBeat.i(253678);
        dCS();
        if (vXA == 1 || vXB == 1 || vXC == 1 || vXD == 1 || vXE == 1 || vXF == 1) {
            AppMethodBeat.o(253678);
            return true;
        }
        AppMethodBeat.o(253678);
        return false;
    }

    public static boolean isAllEnableFullScreenEnjoy() {
        AppMethodBeat.i(253679);
        dCS();
        if (vXA == 1 || (vXB == 1 && vXC == 1 && vXD == 1 && vXE == 1 && vXF == 1)) {
            AppMethodBeat.o(253679);
            return true;
        }
        AppMethodBeat.o(253679);
        return false;
    }

    public static boolean isOtherEnableFullScreenEnjoy() {
        AppMethodBeat.i(253680);
        dCS();
        if (vXA == 1 || vXF == 1) {
            AppMethodBeat.o(253680);
            return true;
        }
        AppMethodBeat.o(253680);
        return false;
    }

    public static boolean isDisablePostHalfScreen() {
        AppMethodBeat.i(253681);
        dCS();
        if (vXG != 1 || !isAllEnableFullScreenEnjoy()) {
            AppMethodBeat.o(253681);
            return false;
        }
        AppMethodBeat.o(253681);
        return true;
    }

    public static /* synthetic */ boolean a(y yVar, int i2, int i3, int i4) {
        AppMethodBeat.i(253683);
        if ((i4 & 1) != 0) {
            i2 = Integer.MIN_VALUE;
        }
        if ((i4 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        boolean gr = gr(i2, i3);
        AppMethodBeat.o(253683);
        return gr;
    }

    public static boolean gr(int i2, int i3) {
        AppMethodBeat.i(253682);
        dCS();
        if (vXA == 1 || i2 == 10 || ((vXB == 1 && i2 == 4) || ((vXB == 1 && i3 == 20) || ((vXC == 1 && i2 == 3) || ((vXC == 1 && i3 == 17) || ((vXD == 1 && i2 == 1) || ((vXD == 1 && i3 == 18) || ((vXE == 1 && i2 == 5) || ((vXE == 1 && i2 == 6) || ((vXE == 1 && i3 == 39) || ((vXE == 1 && i3 == 38) || ((vXE == 1 && i3 == 25) || !(!isOtherEnableFullScreenEnjoy() || i2 == 4 || i2 == 3 || i2 == 1 || i2 == 5 || i2 == 6 || i3 == 20 || i3 == 17 || i3 == 18 || i3 == 39 || i3 == 38 || i3 == 25))))))))))))) {
            AppMethodBeat.o(253682);
            return true;
        }
        AppMethodBeat.o(253682);
        return false;
    }

    public static void b(Window window, boolean z) {
        AppMethodBeat.i(253684);
        p.h(window, "window");
        ao.d(window, z);
        ao.e(window, z);
        AppMethodBeat.o(253684);
    }

    public static boolean bl(float f2) {
        AppMethodBeat.i(253685);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (f2 < com.tencent.mm.plugin.finder.storage.c.dwz().value().floatValue()) {
            AppMethodBeat.o(253685);
            return true;
        }
        AppMethodBeat.o(253685);
        return false;
    }

    public static float eA(List<? extends cjl> list) {
        AppMethodBeat.i(253686);
        p.h(list, "list");
        T t = (cjl) kotlin.a.j.ks(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t = it.next();
            if ((t.height * 1.0f) / t.width >= (t.height * 1.0f) / t.width) {
                t = t;
            }
        }
        float f2 = (t.height * 1.0f) / t.width;
        AppMethodBeat.o(253686);
        return f2;
    }

    public static float eB(List<? extends bch> list) {
        AppMethodBeat.i(253687);
        p.h(list, "list");
        T t = (bch) kotlin.a.j.ks(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t = it.next();
            if ((t.height * 1.0f) / t.width >= (t.height * 1.0f) / t.width) {
                t = t;
            }
        }
        float f2 = (t.height * 1.0f) / t.width;
        AppMethodBeat.o(253687);
        return f2;
    }

    public static float eC(List<? extends cok> list) {
        AppMethodBeat.i(253688);
        p.h(list, "list");
        T t = (cok) kotlin.a.j.ks(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t = it.next();
            if ((t.height * 1.0f) / t.width >= (t.height * 1.0f) / t.width) {
                t = t;
            }
        }
        float f2 = (t.height * 1.0f) / t.width;
        AppMethodBeat.o(253688);
        return f2;
    }

    public static boolean k(cjl cjl) {
        AppMethodBeat.i(253689);
        p.h(cjl, "media");
        if ((1.0f * cjl.height) / cjl.width <= 1.3333334f) {
            AppMethodBeat.o(253689);
            return true;
        }
        AppMethodBeat.o(253689);
        return false;
    }

    public static void dQ(String str, int i2) {
        AppMethodBeat.i(253690);
        p.h(str, "logPrefix");
        if (dCM()) {
            RuntimeException runtimeException = new RuntimeException(str + " type:" + i2 + " invalid");
            AppMethodBeat.o(253690);
            throw runtimeException;
        }
        Log.printInfoStack(TAG, str + " type:" + i2 + " invalid", new Object[0]);
        AppMethodBeat.o(253690);
    }

    public static void a(Exception exc, String str) {
        AppMethodBeat.i(253691);
        p.h(exc, "e");
        p.h(str, "extraMsg");
        if (dCM()) {
            Exception exc2 = exc;
            AppMethodBeat.o(253691);
            throw exc2;
        }
        Log.printInfoStack(TAG, str + ' ' + exc.getMessage(), new Object[0]);
        AppMethodBeat.o(253691);
    }

    public static String b(long j2, Context context) {
        String valueOf;
        String valueOf2;
        AppMethodBeat.i(261487);
        p.h(context, "context");
        Calendar instance = Calendar.getInstance();
        Date date = new Date(j2);
        p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        instance.setTime(date);
        int i2 = instance.get(11);
        if (i2 < 10) {
            valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
        } else {
            valueOf = String.valueOf(i2);
        }
        int i3 = instance.get(12);
        if (i3 < 10) {
            valueOf2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i3));
        } else {
            valueOf2 = String.valueOf(i3);
        }
        String string = context.getResources().getString(R.string.j_7, Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), valueOf, valueOf2);
        p.g(string, "context.resources.getStr…      minuteStr\n        )");
        AppMethodBeat.o(261487);
        return string;
    }

    public static String Gi(long j2) {
        String sb;
        AppMethodBeat.i(253693);
        Calendar instance = Calendar.getInstance();
        Date date = new Date(j2);
        p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        instance.setTime(date);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance();
        Date date2 = new Date(cl.aWA());
        p.g(instance2, "todayDate");
        instance2.setTime(date2);
        int i3 = i2 - instance2.get(6);
        Log.i(TAG, "[getFinderLiveNoticeTips] dayDiff:" + i3 + ", bookTime:" + date + ", todayTime:" + date2);
        CharSequence j3 = k.j(MMApplicationContext.getContext(), j2);
        if (LocaleUtil.isChineseAppLang()) {
            switch (i3) {
                case -1:
                    sb = MMApplicationContext.getContext().getString(R.string.dfu) + j3;
                    break;
                case 0:
                    sb = MMApplicationContext.getContext().getString(R.string.dfl) + j3;
                    break;
                case 1:
                    sb = MMApplicationContext.getContext().getString(R.string.dfm) + j3;
                    break;
                case 2:
                    sb = MMApplicationContext.getContext().getString(R.string.crz) + j3;
                    break;
                default:
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    String str = context.getResources().getStringArray(R.array.ar)[(instance.get(7) + 5) % 7];
                    sb = MMApplicationContext.getContext().getString(R.string.cs0, DateFormat.format(MMApplicationContext.getContext().getString(R.string.dec), j2), str) + j3;
                    break;
            }
        } else {
            sb = new StringBuilder().append(instance.get(1)).append('.').append(instance.get(2) + 1).append('.').append(instance.get(5)).append(' ').append(j3).toString();
        }
        Log.d(TAG, "result:".concat(String.valueOf(sb)));
        AppMethodBeat.o(253693);
        return sb;
    }

    public static String awt(String str) {
        AppMethodBeat.i(253694);
        p.h(str, FirebaseAnalytics.b.ORIGIN);
        kotlin.n.k kVar = new kotlin.n.k("(\n\n[\\s]*\n)|(\n[\\s]*\n\n)");
        kotlin.n.k kVar2 = new kotlin.n.k("(\r\n\r\n[\\s]*\r\n)|(\r\n[\\s]*\r\n\r\n)");
        String e2 = new kotlin.n.k("[ ]{11,}").e(kVar2.e(kVar.e(kotlin.n.n.trim(str).toString(), "\n\n"), "\r\n\r\n"), "          ");
        AppMethodBeat.o(253694);
        return e2;
    }

    public static boolean isFastClick() {
        AppMethodBeat.i(253695);
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime >= 500) {
            z = false;
        }
        lastClickTime = currentTimeMillis;
        AppMethodBeat.o(253695);
        return z;
    }

    public static void awu(String str) {
        AppMethodBeat.i(253696);
        p.h(str, "prefix");
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        boolean isPagEnable = ((PluginFinder) ah).isPagEnable();
        boolean isGPVersion = ChannelUtil.isGPVersion();
        Log.i(TAG, str + " tryLoadPagLibrary pag start,gpVersion:" + isGPVersion + ",isPagEnable:" + isPagEnable);
        if (!isGPVersion || isPagEnable) {
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.e(TAG, "loadPagLib account is not ready");
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 200, 1);
                com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
                Log.i(TAG, "loadPagLib result:".concat(String.valueOf(com.tencent.mm.plugin.expansions.d.aoa("pag"))));
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 201, 1);
            }
        }
        Log.i(TAG, str + " tryLoadPagLibrary pag end");
        AppMethodBeat.o(253696);
    }

    public static boolean dCT() {
        AppMethodBeat.i(253697);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(274436);
        if (!(obj instanceof String)) {
            obj = null;
        }
        String nullAs = Util.nullAs((String) obj, WeChatBrands.AppInfo.LANG_CN);
        boolean I = kotlin.n.n.I(WeChatBrands.AppInfo.LANG_CN, nullAs, true);
        Log.i(TAG, "isRegInChina, regCountryIsoCode:" + nullAs + " isChinaReg:" + I);
        AppMethodBeat.o(253697);
        return I;
    }

    public static boolean Gj(long j2) {
        return j2 > 2147483647L || j2 < -2147483648L;
    }

    public static boolean b(Context context, FinderItem finderItem) {
        int i2;
        int i3;
        AppMethodBeat.i(253698);
        p.h(context, "context");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = 0;
        }
        if (!(i2 == 1 || i2 == 8)) {
            if (finderItem != null) {
                i3 = finderItem.getMediaType();
            } else {
                i3 = 0;
            }
            if (i3 != 9) {
                AppMethodBeat.o(253698);
                return true;
            }
        }
        AppMethodBeat.o(253698);
        return false;
    }

    public static boolean dCU() {
        AppMethodBeat.i(253699);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!((Boolean) com.tencent.mm.plugin.finder.storage.c.dwU().value()).booleanValue()) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_HAS_SHOW_LIVE_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(253699);
                throw tVar;
            } else if (((Boolean) obj).booleanValue()) {
                AppMethodBeat.o(253699);
                return true;
            }
        }
        AppMethodBeat.o(253699);
        return false;
    }

    public static /* synthetic */ List a(y yVar, int i2, bbn bbn, int i3, boolean z, int i4, int i5) {
        boolean z2;
        AppMethodBeat.i(253700);
        if ((i5 & 2) != 0) {
            bbn = null;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            z = false;
        }
        LinkedList linkedList = new LinkedList();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabStateVM.a Mq = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(i2);
        if (Mq.wuc.isEmpty() && !z) {
            List<bo> a2 = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, i3);
            for (bo boVar : a2) {
                if (boVar instanceof BaseFinderFeed) {
                    if (bbn != null) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.e(boVar.lT(), bbn.tCE, ((BaseFinderFeed) boVar).feedObject.getFeedObject().sessionBuffer);
                    }
                    for (T t : ((BaseFinderFeed) boVar).feedObject.getFoldedFeedList()) {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.e(t.lT(), 14, t.feedObject.getFeedObject().sessionBuffer);
                    }
                }
            }
            if (bbn != null) {
                e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                int i6 = bbn.tCE;
                ArrayList arrayList = new ArrayList();
                for (Object obj : a2) {
                    if (((bo) obj) instanceof BaseFinderFeed) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<bo> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
                for (bo boVar2 : arrayList2) {
                    if (boVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                        AppMethodBeat.o(253700);
                        throw tVar;
                    }
                    arrayList3.add(((BaseFinderFeed) boVar2).feedObject.getFeedObject());
                }
                e.a.k(i6, arrayList3);
            }
            linkedList.addAll(a2);
            if (bbn != null) {
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                ((FinderTabStreamUnreadVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).o(bbn.tCE, a(linkedList, BaseFinderFeed.class));
            }
        } else if (a(yVar, i4, 0, 2)) {
            ArrayList arrayList4 = new ArrayList();
            for (T t2 : Mq.wuc) {
                T t3 = t2;
                if (!(t3.cxn() == 2011 || t3.cxn() == 2010 || t3.cxn() == 2013 || t3.cxn() == 2014 || t3.cxn() == 2003)) {
                    arrayList4.add(t2);
                }
            }
            linkedList.addAll(arrayList4);
        } else {
            ArrayList arrayList5 = new ArrayList();
            for (T t4 : Mq.wuc) {
                if (!(t4.cxn() == 2017)) {
                    arrayList5.add(t4);
                }
            }
            linkedList.addAll(arrayList5);
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : linkedList) {
            bo boVar3 = (bo) obj2;
            if (boVar3 instanceof BaseFinderFeed) {
                z2 = r(((BaseFinderFeed) boVar3).feedObject.getFeedObject());
            } else {
                z2 = true;
            }
            if (z2) {
                arrayList6.add(obj2);
            }
        }
        ArrayList arrayList7 = arrayList6;
        AppMethodBeat.o(253700);
        return arrayList7;
    }

    public static List<BaseFinderFeed> u(List<? extends BaseFinderFeed> list, int i2) {
        boolean Gz;
        AppMethodBeat.i(253701);
        p.h(list, "cacheDataList");
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
        FinderTabStreamUnreadVM finderTabStreamUnreadVM = (FinderTabStreamUnreadVM) viewModel;
        int i3 = 0;
        for (T t : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            if (i3 >= 2) {
                e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                if (!e.a.al(i2, t2.feedObject.field_id)) {
                    if (t2.feedObject.field_id != 0) {
                        long j2 = t2.feedObject.field_id;
                        switch (i2) {
                            case 1:
                                Gz = finderTabStreamUnreadVM.wuK.Gz(j2);
                                break;
                            case 2:
                            default:
                                Gz = true;
                                break;
                            case 3:
                                Gz = finderTabStreamUnreadVM.wuL.Gz(j2);
                                break;
                            case 4:
                                Gz = finderTabStreamUnreadVM.wuM.Gz(j2);
                                break;
                        }
                        if (!Gz) {
                            arrayList.add(t2);
                        }
                    }
                    i3 = i4;
                } else {
                    AppMethodBeat.o(253701);
                    return arrayList;
                }
            } else {
                i3 = i4;
            }
        }
        AppMethodBeat.o(253701);
        return arrayList;
    }

    public static String dCV() {
        AppMethodBeat.i(253702);
        String mD5String = MD5Util.getMD5String(z.aTY() + System.currentTimeMillis());
        p.g(mD5String, "MD5Util.getMD5String(\"${…em.currentTimeMillis()}\")");
        AppMethodBeat.o(253702);
        return mD5String;
    }

    public static boolean h(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(167956);
        p.h(baseFinderFeed, "feed");
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (!Util.isNullOrNil(z.aUg())) {
            if (gVar != null) {
                str = gVar.field_username;
            } else {
                str = null;
            }
            if (kotlin.n.n.I(str, z.aUg(), false)) {
                AppMethodBeat.o(167956);
                return true;
            }
        }
        AppMethodBeat.o(167956);
        return false;
    }

    public static boolean b(bm bmVar) {
        String str;
        AppMethodBeat.i(253602);
        p.h(bmVar, "feed");
        FinderContact finderContact = bmVar.contact;
        if (!Util.isNullOrNil(z.aUg())) {
            if (finderContact != null) {
                str = finderContact.username;
            } else {
                str = null;
            }
            if (kotlin.n.n.I(str, z.aUg(), false)) {
                AppMethodBeat.o(253602);
                return true;
            }
        }
        AppMethodBeat.o(253602);
        return false;
    }

    public static String a(com.tencent.mm.plugin.finder.model.a aVar) {
        AppMethodBeat.i(253605);
        p.h(aVar, "item");
        com.tencent.mm.plugin.finder.storage.ao aoVar = aVar.uNF;
        if (aoVar.isOverlap()) {
            StringBuilder sb = new StringBuilder();
            Iterator<FinderContact> it = aoVar.field_aggregatedContacts.LIH.iterator();
            while (it.hasNext()) {
                FinderContact next = it.next();
                sb.append(hh(next.username, next.nickname)).append("，");
            }
            String sb2 = sb.toString();
            p.g(sb2, "nickNameList.toString()");
            if (!Util.isNullOrNil(sb2)) {
                int length = sb2.length() - 1;
                if (sb2 == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(253605);
                    throw tVar;
                }
                sb2 = sb2.substring(0, length);
                p.g(sb2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            AppMethodBeat.o(253605);
            return sb2;
        }
        String hh = hh(aoVar.field_username, aoVar.field_nickname);
        AppMethodBeat.o(253605);
        return hh;
    }

    public static boolean v(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(253637);
        p.h(baseFinderFeed, "item");
        if (baseFinderFeed.feedObject.getFeedObject().incFriendLikeCount <= 0 || baseFinderFeed.feedObject.getFeedObject().msgEventFlag != 1) {
            AppMethodBeat.o(253637);
            return false;
        }
        AppMethodBeat.o(253637);
        return true;
    }

    public static boolean w(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(253655);
        p.h(baseFinderFeed, "item");
        if (baseFinderFeed.feedObject.getMediaType() == 9) {
            AppMethodBeat.o(253655);
            return true;
        }
        AppMethodBeat.o(253655);
        return false;
    }

    public static String x(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(253692);
        p.h(baseFinderFeed, "feed");
        if (baseFinderFeed.feedObject.field_finderObject.follow_feed_count > 1) {
            String string = MMApplicationContext.getContext().getString(R.string.cmy, Integer.valueOf(baseFinderFeed.feedObject.field_finderObject.follow_feed_count));
            p.g(string, "MMApplicationContext.get…Object.follow_feed_count)");
            AppMethodBeat.o(253692);
            return string;
        }
        String string2 = MMApplicationContext.getContext().getString(R.string.cmx);
        p.g(string2, "MMApplicationContext.get…follow_pat_entrance_tips)");
        AppMethodBeat.o(253692);
        return string2;
    }
}

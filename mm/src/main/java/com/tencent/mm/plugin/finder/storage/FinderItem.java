package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\b\u0016\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0002B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010×\u0001\u001a\u00030Ø\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0016J\u0007\u0010Û\u0001\u001a\u00020-J\u0013\u0010Ü\u0001\u001a\u00030Ø\u00012\u0007\u0010Ý\u0001\u001a\u00020AH\u0002J\u0007\u0010\u001c\u001a\u00030\u0001J\u0012\u0010Þ\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010ß\u0001\u001a\u00020\u000bJ\n\u0010à\u0001\u001a\u00030á\u0001H\u0014J\b\u0010â\u0001\u001a\u00030\u0001J\b\u0010ã\u0001\u001a\u00030ä\u0001J\u0007\u0010å\u0001\u001a\u00020AJ\b\u0010æ\u0001\u001a\u00030\u0001J\u0007\u0010ç\u0001\u001a\u00020%J\b\u0010è\u0001\u001a\u00030é\u0001J\u0007\u0010ê\u0001\u001a\u00020%J\u0007\u0010ë\u0001\u001a\u00020%J\u0007\u0010ì\u0001\u001a\u00020bJ\u0007\u0010í\u0001\u001a\u00020bJ\u0007\u0010î\u0001\u001a\u00020bJ\u0007\u0010ï\u0001\u001a\u00020bJ\u0007\u0010ð\u0001\u001a\u00020bJ\u0007\u0010ñ\u0001\u001a\u00020bJ\u0010\u0010ò\u0001\u001a\u00020b2\u0007\u0010ß\u0001\u001a\u00020\u000bJ\u0010\u0010ó\u0001\u001a\u00020b2\u0007\u0010ß\u0001\u001a\u00020\u000bJ\u0007\u0010ô\u0001\u001a\u00020bJ\u0007\u0010õ\u0001\u001a\u00020bJ\u0007\u0010ö\u0001\u001a\u00020bJ\u0007\u0010÷\u0001\u001a\u00020bJ\u0007\u0010ø\u0001\u001a\u00020bJ\u0007\u0010ù\u0001\u001a\u00020bJ\u0007\u0010ú\u0001\u001a\u00020bJ\u0007\u0010û\u0001\u001a\u00020bJ\u0012\u0010ü\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010ý\u0001\u001a\u00020%J\b\u0010þ\u0001\u001a\u00030¬\u0001J\b\u0010ÿ\u0001\u001a\u00030Ø\u0001J\b\u0010\u0002\u001a\u00030Ø\u0001J\b\u0010\u0002\u001a\u00030Ø\u0001J\b\u0010\u0002\u001a\u00030Ø\u0001J\u0011\u0010\u0002\u001a\u00030Ø\u00012\u0007\u0010\u0002\u001a\u00020\u000bJ\b\u0010\u0002\u001a\u00030Ø\u0001J\u0012\u0010\u0002\u001a\u00030Ø\u00012\b\u0010\u0002\u001a\u00030é\u0001J\b\u0010\u0002\u001a\u00030Ø\u0001J\u0011\u0010\u0002\u001a\u00030Ø\u00012\u0007\u0010\u0002\u001a\u00020%J\u0011\u0010\u0002\u001a\u00030Ø\u00012\u0007\u0010\u0002\u001a\u00020AR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001e8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R$\u0010(\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00106\u001a\u0002052\u0006\u0010\u0005\u001a\u0002058F@FX\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R$\u0010>\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R$\u0010B\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020A@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020I0MX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010N\u001a\u0004\u0018\u00010O8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010\u0010R$\u0010W\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\bX\u0010\u000e\"\u0004\bY\u0010\u0010R\u001a\u0010Z\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000e\"\u0004\b\\\u0010\u0010R0\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020]0\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b_\u0010\b\"\u0004\b`\u0010\nR\u0011\u0010a\u001a\u00020b8F¢\u0006\u0006\u001a\u0004\ba\u0010cR\u001a\u0010d\u001a\u00020bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010c\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010c\"\u0004\bh\u0010fR\u001a\u0010i\u001a\u00020bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010c\"\u0004\bj\u0010fR$\u0010k\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\bl\u0010\u000e\"\u0004\bm\u0010\u0010R$\u0010n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000e\"\u0004\bp\u0010\u0010R0\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048F@FX\u000e¢\u0006\f\u001a\u0004\br\u0010\b\"\u0004\bs\u0010\nR\u001c\u0010t\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR(\u0010z\u001a\u0004\u0018\u00010y2\b\u0010\u0005\u001a\u0004\u0018\u00010y8F@FX\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0018\u0010\u001a\b\u0012\u0004\u0012\u00020]0\u00048F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR+\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0005\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0005\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R3\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020]0\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR3\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020]0\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR3\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020]0\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR3\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020]0\u00048F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR\u001d\u0010\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R/\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0005\u001a\u0005\u0018\u00010\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R'\u0010¢\u0001\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8F@FX\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010'\"\u0005\b¤\u0001\u0010+R\u001f\u0010¥\u0001\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010/\"\u0005\b§\u0001\u00101R'\u0010¨\u0001\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8F@FX\u000e¢\u0006\u000e\u001a\u0005\b©\u0001\u0010'\"\u0005\bª\u0001\u0010+R\"\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R'\u0010±\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b²\u0001\u0010\u000e\"\u0005\b³\u0001\u0010\u0010R'\u0010´\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010\u000e\"\u0005\b¶\u0001\u0010\u0010R+\u0010¸\u0001\u001a\u00030·\u00012\u0007\u0010\u0005\u001a\u00030·\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R+\u0010½\u0001\u001a\u00030\u00012\u0007\u0010\u0005\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b¾\u0001\u0010\u0001\"\u0006\b¿\u0001\u0010\u0001R+\u0010À\u0001\u001a\u00030\u00012\u0007\u0010\u0005\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\bÁ\u0001\u0010\u0001\"\u0006\bÂ\u0001\u0010\u0001R \u0010Ã\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0001\"\u0006\bÅ\u0001\u0010\u0001R'\u0010Æ\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\u001a\u0005\bÇ\u0001\u0010\u000e\"\u0005\bÈ\u0001\u0010\u0010R\u0015\u0010É\u0001\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0001R \u0010Ë\u0001\u001a\u00030Ì\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010M¢\u0006\t\n\u0000\u001a\u0005\bÓ\u0001\u0010KR'\u0010Ô\u0001\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8F@FX\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0001\u0010'\"\u0005\bÖ\u0001\u0010+¨\u0006\u0002"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "()V", "_clipListExt", "Ljava/util/LinkedList;", "value", "clipListExt", "getClipListExt", "()Ljava/util/LinkedList;", "setClipListExt", "(Ljava/util/LinkedList;)V", "", "commentCount", "getCommentCount", "()I", "setCommentCount", "(I)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentList", "getCommentList", "setCommentList", "comment_close", "getComment_close", "setComment_close", "copyObjectDescMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getCopyObjectDescMedia", "createTime", "getCreateTime", "setCreateTime", "Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", ch.COL_CUSTOMDATA, "getCustomData", "()Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;", "setCustomData", "(Lcom/tencent/mm/protocal/protobuf/FinderCustomFeedData;)V", "debugDescription", "", "getDebugDescription", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "descriptionFullSpan", "Landroid/text/SpannableString;", "getDescriptionFullSpan", "()Landroid/text/SpannableString;", "setDescriptionFullSpan", "(Landroid/text/SpannableString;)V", "descriptionSpan", "getDescriptionSpan", "setDescriptionSpan", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "extReading", "getExtReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setExtReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "favCount", "getFavCount", "setFavCount", "favFlag", "getFavFlag", "setFavFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "foldedFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFoldedFeedList", "()Ljava/util/List;", "foldedFeeds", "", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "setFoldedLayout", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;)V", "forwardCount", "getForwardCount", "setForwardCount", "friendLikeCount", "getFriendLikeCount", "setFriendLikeCount", "fromType", "getFromType", "setFromType", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfVideoMediaExtList", "getHalfVideoMediaExtList", "setHalfVideoMediaExtList", "isLongVideo", "", "()Z", "isPreview", "setPreview", "(Z)V", "isRelatedItem", "setRelatedItem", "isReplaceLongVideoToNormal", "setReplaceLongVideoToNormal", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "likeList", "getLikeList", "setLikeList", "liveFinderMedia", "getLiveFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setLiveFinderMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "liveMediaList", "getLiveMediaList", "", ch.COL_LOCALID, "getLocalId", "()J", "setLocalId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", FirebaseAnalytics.b.LOCATION, m.NAME, "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", ch.COL_LONGVIDEOMEDIAEXTLIST, "getLongVideoMediaExtList", "setLongVideoMediaExtList", "longVideoMediaList", "getLongVideoMediaList", "setLongVideoMediaList", ch.COL_MEDIAEXTLIST, "getMediaExtList", "setMediaExtList", "mediaList", "getMediaList", "setMediaList", "mediaType", "getMediaType", "setMediaType", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "megaVideo", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "nickName", "getNickName", "setNickName", "nickNameSpan", "getNickNameSpan", "setNickNameSpan", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "posTriggerConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "getPosTriggerConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "setPosTriggerConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;)V", "private_flag", "getPrivate_flag", "setPrivate_flag", "readCount", "getReadCount", "setReadCount", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refObjectContact", "getRefObjectContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setRefObjectContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "refObjectFlag", "getRefObjectFlag", "setRefObjectFlag", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedFeedId", "getRelatedFeedId", "setRelatedFeedId", "stickyTime", "getStickyTime", "setStickyTime", "timestamps", "getTimestamps", "topicClickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "getTopicClickExtra", "()Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "setTopicClickExtra", "(Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "topicList", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getTopicList", "userName", "getUserName", "setUserName", "convertFrom", "", "cu", "Landroid/database/Cursor;", "createDescriptionFullSpan", "fixMediaType", "obj", "getCropInfo", FirebaseAnalytics.b.INDEX, "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExpectId", "getFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getFinderObject", "getId", "getNotShareMsg", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getUnsignedId", "info", "isCommentClose", "isEventClosed", "isEventExpired", "isLive", "isLiveFeed", "isMvFeed", "isNeedCrop", "isNeedVideoCompositionPlay", "isNotShare", "isOldVersion", "isOnlySelfSee", "isPostFailed", "isPostFailedCanRetry", "isPostFinish", "isPostNoAuth", "isPrivate", "mediaExt", "mediaId", "parseJsonOfPosTriggerConfig", "setEventClosed", "setEventExpired", "setPostFailed", "setPostFailedAndNoAuth", "setPostFailedAndNotRetry", "errCode", "setPostFinish", "setPostInfo", "field_postinfo", "setPostWaiting", "trackPost", "stage", "updateFinderObject", "svrFeed", "Companion", "PosTriggerConfig", "plugin-finder_release"})
public class FinderItem extends ch {
    public static final a Companion = new a((byte) 0);
    private static final String TAG = TAG;
    private static boolean debugOnlySelfSee;
    private static final IAutoDBItem.MAutoDBInfo info;
    private final LinkedList<FinderItem> _clipListExt;
    private final LinkedList<FinderMedia> copyObjectDescMedia;
    private SpannableString descriptionFullSpan;
    private SpannableString descriptionSpan;
    private FinderObject feedObject;
    private List<BaseFinderFeed> foldedFeeds;
    private ard foldedLayout;
    private int fromType;
    private boolean isPreview;
    private boolean isRelatedItem;
    private boolean isReplaceLongVideoToNormal;
    private cjl liveFinderMedia;
    private int mediaType;
    private SpannableString nickNameSpan;
    private b posTriggerConfig;
    private long relatedFeedId;
    private final long timestamps;
    private w.a topicClickExtra;
    private final List<w.c> topicList;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
    static final class c extends q implements kotlin.g.a.m<String, w.a, x> {
        final /* synthetic */ FinderItem vDW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderItem finderItem) {
            super(2);
            this.vDW = finderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, w.a aVar) {
            AppMethodBeat.i(251741);
            String str2 = str;
            w.a aVar2 = aVar;
            p.h(str2, "topic");
            p.h(aVar2, "clickExtra");
            aVar2.aWF = this.vDW.getTopicClickExtra().aWF;
            w wVar = w.vXp;
            w.a(str2, Long.valueOf(this.vDW.field_id), aVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(251741);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderItem vDW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderItem finderItem) {
            super(1);
            this.vDW = finderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            Context context;
            AppMethodBeat.i(251742);
            String str2 = str;
            p.h(str2, ch.COL_USERNAME);
            com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
            WeakReference<Context> weakReference = this.vDW.getTopicClickExtra().aWF;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            com.tencent.mm.plugin.finder.utils.d.a(context, str2, this.vDW);
            x xVar = x.SXb;
            AppMethodBeat.o(251742);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "topic", "", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "invoke"})
    public static final class e extends q implements kotlin.g.a.m<String, w.a, x> {
        final /* synthetic */ FinderItem vDW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderItem finderItem) {
            super(2);
            this.vDW = finderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, w.a aVar) {
            AppMethodBeat.i(166978);
            String str2 = str;
            w.a aVar2 = aVar;
            p.h(str2, "topic");
            p.h(aVar2, "clickExtra");
            aVar2.aWF = this.vDW.getTopicClickExtra().aWF;
            w wVar = w.vXp;
            w.a(str2, Long.valueOf(this.vDW.field_id), aVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(166978);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderItem vDW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderItem finderItem) {
            super(1);
            this.vDW = finderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            Context context;
            AppMethodBeat.i(251743);
            String str2 = str;
            p.h(str2, ch.COL_USERNAME);
            com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
            WeakReference<Context> weakReference = this.vDW.getTopicClickExtra().aWF;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            com.tencent.mm.plugin.finder.utils.d.a(context, str2, this.vDW);
            x xVar = x.SXb;
            AppMethodBeat.o(251743);
            return xVar;
        }
    }

    public FinderItem() {
        AppMethodBeat.i(167014);
        FinderObject finderObject = new FinderObject();
        finderObject.objectDesc = new FinderObjectDesc();
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc != null) {
            finderObjectDesc.location = new axt();
        }
        this.feedObject = finderObject;
        this.topicClickExtra = new w.a(0);
        this.timestamps = cl.aWA();
        this.topicList = new ArrayList();
        this.copyObjectDescMedia = new LinkedList<>();
        this._clipListExt = new LinkedList<>();
        this.foldedFeeds = new ArrayList();
        AppMethodBeat.o(167014);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u0012*\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ\n\u0010\u001f\u001a\u00020\u001e*\u00020\u0012J\n\u0010 \u001a\u00020\u001a*\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderItem$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugOnlySelfSee", "", "getDebugOnlySelfSee", "()Z", "setDebugOnlySelfSee", "(Z)V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "create", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "type", "", "genFinderItem", ch.COL_FINDEROBJECT, "feedPostingInfo", "Lcom/tencent/mm/protocal/protobuf/FeedPostingInfo;", ch.COL_LOCALID, "", "toFinderItem", "Lcom/tencent/mm/protocal/protobuf/FinderItemPb;", "toFinderItemPb", "toPostingInfo", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static FinderItem a(FinderObject finderObject, int i2) {
            String str;
            AppMethodBeat.i(166977);
            p.h(finderObject, "feedObject");
            FinderItem finderItem = new FinderItem();
            finderItem.setFromType(i2);
            finderItem.setFeedObject(finderObject);
            if (Util.isNullOrNil(finderItem.getFeedObject().nickname) && finderItem.getFeedObject().contact != null) {
                FinderContact finderContact = finderItem.getFeedObject().contact;
                if (!Util.isNullOrNil(finderContact != null ? finderContact.nickname : null)) {
                    FinderObject feedObject = finderItem.getFeedObject();
                    FinderContact finderContact2 = finderItem.getFeedObject().contact;
                    if (finderContact2 == null || (str = finderContact2.nickname) == null) {
                        str = "";
                    }
                    feedObject.nickname = str;
                }
            }
            AppMethodBeat.o(166977);
            return finderItem;
        }

        public static FinderItem a(aud aud, long j2) {
            AppMethodBeat.i(251733);
            p.h(aud, "$this$toFinderItem");
            if (aud.tuO != null) {
                FinderObject finderObject = aud.tuO;
                if (finderObject == null) {
                    finderObject = new FinderObject();
                }
                FinderItem a2 = a(finderObject, aud.LEP, j2);
                AppMethodBeat.o(251733);
                return a2;
            }
            FinderItem finderItem = new FinderItem();
            AppMethodBeat.o(251733);
            return finderItem;
        }

        public static aud l(FinderItem finderItem) {
            AppMethodBeat.i(251734);
            p.h(finderItem, "$this$toFinderItemPb");
            aud aud = new aud();
            aud.tuO = finderItem.getFeedObject();
            aud.LEP = m(finderItem);
            AppMethodBeat.o(251734);
            return aud;
        }

        private static FinderItem a(FinderObject finderObject, anv anv, long j2) {
            AppMethodBeat.i(251735);
            p.h(finderObject, ch.COL_FINDEROBJECT);
            FinderItem finderItem = new FinderItem();
            finderItem.setLocalId(j2);
            finderItem.setFeedObject(finderObject);
            if (anv != null) {
                finderItem.field_localFlag = anv.kdU;
                finderItem.field_postinfo = anv.vTj;
                finderItem.field_mediaExtList = anv.Lzv;
                finderItem.field_reportObject = anv.Lzw;
                finderItem.field_postExtraData = anv.Lzx;
                finderItem.field_customData = anv.Lzy;
                finderItem.field_longVideoMediaExtList = anv.Lzz;
                finderItem.field_halfMediaExtList = anv.LzA;
                finderItem.field_clipList = anv.LzB;
            }
            AppMethodBeat.o(251735);
            return finderItem;
        }

        private static anv m(FinderItem finderItem) {
            AppMethodBeat.i(251736);
            p.h(finderItem, "$this$toPostingInfo");
            anv anv = new anv();
            anv.kdU = finderItem.field_localFlag;
            anv.vTj = finderItem.field_postinfo;
            anv.Lzv = finderItem.field_mediaExtList;
            anv.Lzw = finderItem.field_reportObject;
            anv.Lzx = finderItem.field_postExtraData;
            anv.Lzy = finderItem.field_customData;
            anv.Lzz = finderItem.field_longVideoMediaExtList;
            anv.LzA = finderItem.field_halfMediaExtList;
            anv.LzB = finderItem.field_clipList;
            AppMethodBeat.o(251736);
            return anv;
        }
    }

    static {
        AppMethodBeat.i(167015);
        IAutoDBItem.MAutoDBInfo initAutoDBInfo = ch.initAutoDBInfo(FinderItem.class);
        p.g(initAutoDBInfo, "initAutoDBInfo(FinderItem::class.java)");
        info = initAutoDBInfo;
        AppMethodBeat.o(167015);
    }

    private final void fixMediaType(FinderObject finderObject) {
        LinkedList<FinderMedia> linkedList;
        AppMethodBeat.i(166979);
        y yVar = y.vXH;
        int t = y.t(finderObject);
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) {
            AppMethodBeat.o(166979);
            return;
        }
        for (T t2 : linkedList) {
            if (t2.mediaType == 0) {
                t2.mediaType = t;
            }
        }
        AppMethodBeat.o(166979);
    }

    public final b getPosTriggerConfig() {
        return this.posTriggerConfig;
    }

    public final void setPosTriggerConfig(b bVar) {
        this.posTriggerConfig = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003Jy\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\b\u00101\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001d¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "favRelateListEnable", "", "favRelateListEnableOnClick", "likeRelateListEnable", "isLocalDefault", "jsonStr", "(IIIIILjava/lang/String;ZZZZLjava/lang/String;)V", "getFavRelateListEnable", "()Z", "getFavRelateListEnableOnClick", "setLocalDefault", "(Z)V", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "(Ljava/lang/String;)V", "getLikeRelateListEnable", "getLogic", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class b {
        public String lEd;
        public final int tXx;
        private boolean uUJ;
        public final int vDO;
        public final int vDP;
        public final int vDQ;
        public final int vDR;
        public final String vDS;
        public final boolean vDT;
        public final boolean vDU;
        public final boolean vDV;

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
            if (kotlin.g.b.p.j(r3.lEd, r4.lEd) != false) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 251740(0x3d75c, float:3.52763E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0058
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.storage.FinderItem.b
                if (r0 == 0) goto L_0x005d
                com.tencent.mm.plugin.finder.storage.FinderItem$b r4 = (com.tencent.mm.plugin.finder.storage.FinderItem.b) r4
                int r0 = r3.tXx
                int r1 = r4.tXx
                if (r0 != r1) goto L_0x005d
                int r0 = r3.vDO
                int r1 = r4.vDO
                if (r0 != r1) goto L_0x005d
                int r0 = r3.vDP
                int r1 = r4.vDP
                if (r0 != r1) goto L_0x005d
                int r0 = r3.vDQ
                int r1 = r4.vDQ
                if (r0 != r1) goto L_0x005d
                int r0 = r3.vDR
                int r1 = r4.vDR
                if (r0 != r1) goto L_0x005d
                java.lang.String r0 = r3.vDS
                java.lang.String r1 = r4.vDS
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x005d
                boolean r0 = r3.vDT
                boolean r1 = r4.vDT
                if (r0 != r1) goto L_0x005d
                boolean r0 = r3.vDU
                boolean r1 = r4.vDU
                if (r0 != r1) goto L_0x005d
                boolean r0 = r3.vDV
                boolean r1 = r4.vDV
                if (r0 != r1) goto L_0x005d
                boolean r0 = r3.uUJ
                boolean r1 = r4.uUJ
                if (r0 != r1) goto L_0x005d
                java.lang.String r0 = r3.lEd
                java.lang.String r1 = r4.lEd
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x005d
            L_0x0058:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x005c:
                return r0
            L_0x005d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x005c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.FinderItem.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            int i3 = 1;
            AppMethodBeat.i(251739);
            int i4 = ((((((((this.tXx * 31) + this.vDO) * 31) + this.vDP) * 31) + this.vDQ) * 31) + this.vDR) * 31;
            String str = this.vDS;
            int hashCode = ((str != null ? str.hashCode() : 0) + i4) * 31;
            boolean z = this.vDT;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = (i5 + hashCode) * 31;
            boolean z2 = this.vDU;
            if (z2) {
                z2 = true;
            }
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = z2 ? 1 : 0;
            int i12 = (i9 + i8) * 31;
            boolean z3 = this.vDV;
            if (z3) {
                z3 = true;
            }
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = z3 ? 1 : 0;
            int i16 = (i13 + i12) * 31;
            boolean z4 = this.uUJ;
            if (!z4) {
                i3 = z4 ? 1 : 0;
            }
            int i17 = (i16 + i3) * 31;
            String str2 = this.lEd;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i18 = i17 + i2;
            AppMethodBeat.o(251739);
            return i18;
        }

        public b(int i2, int i3, int i4, int i5, int i6, String str, boolean z, boolean z2, boolean z3, boolean z4, String str2) {
            p.h(str, "logic");
            AppMethodBeat.i(251738);
            this.tXx = i2;
            this.vDO = i3;
            this.vDP = i4;
            this.vDQ = i5;
            this.vDR = i6;
            this.vDS = str;
            this.vDT = z;
            this.vDU = z2;
            this.vDV = z3;
            this.uUJ = z4;
            this.lEd = str2;
            AppMethodBeat.o(251738);
        }

        public /* synthetic */ b(int i2, int i3, int i4, int i5, String str) {
            this(3, i2, i3, i4, i5, str, false, false, false, true, null);
        }

        public final String toString() {
            AppMethodBeat.i(251737);
            String str = "maxUnreadCount=" + this.tXx + ",showTime=" + this.vDO + ",showPercentage=" + this.vDP + ",preLoadTime=" + this.vDQ + ',' + "preLoadPercentage=" + this.vDR + ",logic=" + this.vDS + ",favRelateListEnable=" + this.vDT + ",favRelateListEnableOnClick=" + this.vDU + ",likeRelateListEnable=" + this.vDV + ",isLocalDefault=" + this.uUJ;
            AppMethodBeat.o(251737);
            return str;
        }
    }

    public final b parseJsonOfPosTriggerConfig() {
        String str;
        boolean z;
        boolean z2;
        AppMethodBeat.i(251744);
        b bVar = this.mediaType == 2 ? new b(5, 0, 4, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO) : new b(10, 80, 8, 64, "||");
        String str2 = this.feedObject.posTriggerConfig;
        if (str2 != null) {
            p.g(str2, LocaleUtil.ITALIAN);
            if (str2.length() > 0) {
                str = str2;
            } else {
                str = null;
            }
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = bVar.tXx;
                    if (jSONObject.has("maxUnreadCount")) {
                        i2 = jSONObject.getInt("maxUnreadCount");
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("config");
                    int i3 = bVar.vDO;
                    if (jSONObject2.has("showTime")) {
                        i3 = jSONObject2.getInt("showTime");
                    }
                    int i4 = bVar.vDP;
                    if (jSONObject2.has("showPercentage")) {
                        i4 = jSONObject2.getInt("showPercentage");
                    }
                    int i5 = bVar.vDQ;
                    if (jSONObject2.has("preLoadTime")) {
                        i5 = jSONObject2.getInt("preLoadTime");
                    }
                    int i6 = bVar.vDR;
                    if (jSONObject2.has("preLoadPercentage")) {
                        i6 = jSONObject2.getInt("preLoadPercentage");
                    }
                    String str3 = bVar.vDS;
                    if (jSONObject2.has("logic")) {
                        str3 = jSONObject2.getString("logic");
                        p.g(str3, "config.getString(\"logic\")");
                    }
                    boolean z3 = bVar.vDT;
                    if (jSONObject.has("favRelateListEnable")) {
                        if (jSONObject.optInt("favRelateListEnable") == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2;
                    }
                    boolean z4 = bVar.vDU;
                    if (jSONObject.has("favRelateListEnableOnClick")) {
                        if (jSONObject.optInt("favRelateListEnableOnClick") == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z4 = z;
                    }
                    boolean z5 = bVar.vDV;
                    if (jSONObject.has("likeRelateListEnable")) {
                        z5 = jSONObject.optInt("likeRelateListEnable") == 1;
                    }
                    b bVar2 = new b(i2, i3, i4, i5, i6, str3, z3, z4, z5, false, str);
                    Log.i(TAG, "[parseJsonOfPosTriggerConfig] config=".concat(String.valueOf(bVar2)));
                    AppMethodBeat.o(251744);
                    return bVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(251744);
                    return bVar;
                }
            }
        }
        AppMethodBeat.o(251744);
        return bVar;
    }

    public final FinderObject getFeedObject() {
        return this.feedObject;
    }

    public final void setFeedObject(FinderObject finderObject) {
        String str;
        String str2;
        String str3;
        LinkedList<ayq> linkedList;
        bdq bdq;
        String str4;
        AppMethodBeat.i(166980);
        p.h(finderObject, "value");
        y yVar = y.vXH;
        this.mediaType = y.t(finderObject);
        this.field_createTime = (long) finderObject.createtime;
        this.field_id = finderObject.id;
        String str5 = finderObject.username;
        if (str5 == null) {
            str5 = "";
        }
        this.field_username = str5;
        fixMediaType(finderObject);
        this.feedObject = finderObject;
        this.field_finderObject = finderObject;
        if (this.fromType == 16) {
            Context context = MMApplicationContext.getContext();
            i iVar = i.vvu;
            String str6 = finderObject.nickname;
            if (str6 == null) {
                str6 = "";
            }
            this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.d(context, (CharSequence) i.auZ(str6), 0.0f);
            Context context2 = MMApplicationContext.getContext();
            i iVar2 = i.vvu;
            FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
            if (finderObjectDesc == null || (str4 = finderObjectDesc.description) == null) {
                str4 = "";
            }
            this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.b(context2, i.auY(str4), 0.0f);
        } else {
            Context context3 = MMApplicationContext.getContext();
            String str7 = finderObject.nickname;
            if (str7 != null) {
                str = str7;
            }
            this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.c(context3, str);
            Context context4 = MMApplicationContext.getContext();
            FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
            if (finderObjectDesc2 != null && (str3 = finderObjectDesc2.description) != null) {
                str2 = str3;
            }
            this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.c(context4, str2);
        }
        t tVar = t.vWZ;
        FinderObjectDesc finderObjectDesc3 = finderObject.objectDesc;
        String str8 = (finderObjectDesc3 == null || (bdq = finderObjectDesc3.topic) == null) ? null : bdq.LNs;
        SpannableString spannableString = this.descriptionSpan;
        if (spannableString == null) {
            spannableString = new SpannableString("");
        }
        long j2 = this.field_id;
        List<w.c> list = this.topicList;
        LinkedList<FinderContact> linkedList2 = finderObject.mentionedUserContact;
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
        }
        FinderObjectDesc finderObjectDesc4 = finderObject.objectDesc;
        if (finderObjectDesc4 == null || (linkedList = finderObjectDesc4.mentionedUser) == null) {
            linkedList = new LinkedList<>();
        }
        this.descriptionFullSpan = t.a(str8, spannableString, j2, list, linkedList2, linkedList, new e(this), new f(this));
        if (this.fromType != 16) {
            this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.d(MMApplicationContext.getContext(), (CharSequence) String.valueOf(this.descriptionFullSpan), 0.0f);
        }
        AppMethodBeat.o(166980);
    }

    public final w.a getTopicClickExtra() {
        return this.topicClickExtra;
    }

    public final void setTopicClickExtra(w.a aVar) {
        AppMethodBeat.i(166981);
        p.h(aVar, "<set-?>");
        this.topicClickExtra = aVar;
        AppMethodBeat.o(166981);
    }

    public final long getId() {
        return this.field_id;
    }

    public final String getUnsignedId() {
        AppMethodBeat.i(251745);
        String zs = com.tencent.mm.ac.d.zs(getId());
        AppMethodBeat.o(251745);
        return zs;
    }

    public final long getExpectId() {
        AppMethodBeat.i(251746);
        if (this.field_id == 0) {
            long localId = getLocalId();
            AppMethodBeat.o(251746);
            return localId;
        }
        long j2 = this.field_id;
        AppMethodBeat.o(251746);
        return j2;
    }

    public final String getObjectNonceId() {
        String str = this.feedObject.objectNonceId;
        return str == null ? "" : str;
    }

    public final void setObjectNonceId(String str) {
        AppMethodBeat.i(166983);
        p.h(str, "value");
        this.feedObject.objectNonceId = str;
        AppMethodBeat.o(166983);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final awe getLiveInfo() {
        return this.feedObject.liveInfo;
    }

    public final void setLiveInfo(awe awe) {
        this.feedObject.liveInfo = awe;
    }

    public final SpannableString createDescriptionFullSpan() {
        LinkedList<ayq> linkedList;
        bdq bdq;
        AppMethodBeat.i(251747);
        FinderObject finderObject = this.feedObject;
        t tVar = t.vWZ;
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        String str = (finderObjectDesc == null || (bdq = finderObjectDesc.topic) == null) ? null : bdq.LNs;
        SpannableString spannableString = this.descriptionSpan;
        if (spannableString == null) {
            spannableString = new SpannableString("");
        }
        long j2 = this.field_id;
        List<w.c> list = this.topicList;
        LinkedList<FinderContact> linkedList2 = finderObject.mentionedUserContact;
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
        }
        FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
        if (finderObjectDesc2 == null || (linkedList = finderObjectDesc2.mentionedUser) == null) {
            linkedList = new LinkedList<>();
        }
        SpannableString a2 = t.a(str, spannableString, j2, list, linkedList2, linkedList, new c(this), new d(this));
        AppMethodBeat.o(251747);
        return a2;
    }

    @Override // com.tencent.mm.g.c.ch, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(166984);
        p.h(cursor, "cu");
        super.convertFrom(cursor);
        FinderObject finderObject = this.field_finderObject;
        if (finderObject == null) {
            finderObject = new FinderObject();
        }
        setFeedObject(finderObject);
        this.feedObject.username = z.aUg();
        y yVar = y.vXH;
        this.mediaType = y.t(this.feedObject);
        AppMethodBeat.o(166984);
    }

    public final long getTimestamps() {
        return this.timestamps;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final void setFromType(int i2) {
        this.fromType = i2;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(int i2) {
        this.mediaType = i2;
    }

    public final boolean isRelatedItem() {
        return this.isRelatedItem;
    }

    public final void setRelatedItem(boolean z) {
        this.isRelatedItem = z;
    }

    public final long getRelatedFeedId() {
        return this.relatedFeedId;
    }

    public final void setRelatedFeedId(long j2) {
        this.relatedFeedId = j2;
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public final void setPreview(boolean z) {
        this.isPreview = z;
    }

    public final cng getMegaVideo() {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        AppMethodBeat.i(251748);
        aoq aoq = this.feedObject.attachmentList;
        if (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) {
            AppMethodBeat.o(251748);
            return null;
        }
        cng cng = bei.LIA;
        AppMethodBeat.o(251748);
        return cng;
    }

    public final void setMegaVideo(cng cng) {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        AppMethodBeat.i(251749);
        aoq aoq = this.feedObject.attachmentList;
        if (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) {
            AppMethodBeat.o(251749);
            return;
        }
        bei.LIA = cng;
        AppMethodBeat.o(251749);
    }

    public final long getLocalId() {
        return this.field_localId;
    }

    public final void setLocalId(long j2) {
        this.field_localId = j2;
    }

    public final String getNickName() {
        String str = this.feedObject.nickname;
        return str == null ? "" : str;
    }

    public final void setNickName(String str) {
        AppMethodBeat.i(166985);
        p.h(str, "value");
        this.feedObject.nickname = str;
        this.nickNameSpan = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), str);
        AppMethodBeat.o(166985);
    }

    public final SpannableString getNickNameSpan() {
        return this.nickNameSpan;
    }

    public final void setNickNameSpan(SpannableString spannableString) {
        this.nickNameSpan = spannableString;
    }

    public final String getUserName() {
        String str = this.feedObject.username;
        return str == null ? "" : str;
    }

    public final void setUserName(String str) {
        AppMethodBeat.i(166986);
        p.h(str, "value");
        this.feedObject.username = str;
        AppMethodBeat.o(166986);
    }

    public final int getCreateTime() {
        return this.feedObject.createtime;
    }

    public final void setCreateTime(int i2) {
        this.feedObject.createtime = i2;
    }

    public final int getLikeFlag() {
        return this.feedObject.likeFlag;
    }

    public final void setLikeFlag(int i2) {
        this.feedObject.likeFlag = i2;
    }

    public final int getFavFlag() {
        return this.feedObject.favFlag;
    }

    public final void setFavFlag(int i2) {
        this.feedObject.favFlag = i2;
    }

    public final int getForwardCount() {
        return this.feedObject.forwardCount;
    }

    public final void setForwardCount(int i2) {
        this.feedObject.forwardCount = i2;
    }

    public final int getReadCount() {
        return this.feedObject.readCount;
    }

    public final void setReadCount(int i2) {
        this.feedObject.readCount = i2;
    }

    public final int getLikeCount() {
        return this.feedObject.likeCount;
    }

    public final void setLikeCount(int i2) {
        this.feedObject.likeCount = i2;
    }

    public final int getFavCount() {
        return this.feedObject.favCount;
    }

    public final void setFavCount(int i2) {
        this.feedObject.favCount = i2;
    }

    public final int getFriendLikeCount() {
        return this.feedObject.friendLikeCount;
    }

    public final void setFriendLikeCount(int i2) {
        this.feedObject.friendLikeCount = i2;
    }

    public final int getCommentCount() {
        return this.feedObject.commentCount;
    }

    public final void setCommentCount(int i2) {
        AppMethodBeat.i(166987);
        Log.d(TAG, "setCommentCount " + this.feedObject.hashCode() + ", from:" + getCommentCount() + ", to:" + getCommentCount());
        this.feedObject.commentCount = i2;
        AppMethodBeat.o(166987);
    }

    public final String getDescription() {
        String str;
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        return (finderObjectDesc == null || (str = finderObjectDesc.description) == null) ? "" : str;
    }

    public final void setDescription(String str) {
        AppMethodBeat.i(166988);
        p.h(str, "value");
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc != null) {
            finderObjectDesc.description = str;
        }
        this.descriptionSpan = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), str);
        this.descriptionFullSpan = this.descriptionSpan;
        Log.w(TAG, "unexpecting write!");
        AppMethodBeat.o(166988);
    }

    public final String getDebugDescription() {
        AppMethodBeat.i(251750);
        String description = getDescription();
        int min = Math.min(description.length(), 3);
        if (description == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251750);
            throw tVar;
        }
        String substring = description.substring(0, min);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(251750);
        return substring;
    }

    public final SpannableString getDescriptionSpan() {
        return this.descriptionSpan;
    }

    public final void setDescriptionSpan(SpannableString spannableString) {
        this.descriptionSpan = spannableString;
    }

    public final SpannableString getDescriptionFullSpan() {
        return this.descriptionFullSpan;
    }

    public final void setDescriptionFullSpan(SpannableString spannableString) {
        this.descriptionFullSpan = spannableString;
    }

    public final List<w.c> getTopicList() {
        return this.topicList;
    }

    public final cjl getLiveFinderMedia() {
        return this.liveFinderMedia;
    }

    public final void setLiveFinderMedia(cjl cjl) {
        this.liveFinderMedia = cjl;
    }

    public final LinkedList<cjl> getLiveMediaList() {
        LinkedList<FinderMedia> linkedList;
        AppMethodBeat.i(251751);
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) {
            LinkedList<cjl> linkedList2 = new LinkedList<>();
            AppMethodBeat.o(251751);
            return linkedList2;
        }
        LinkedList<cjl> aA = com.tencent.mm.plugin.finder.storage.data.j.aA(linkedList);
        AppMethodBeat.o(251751);
        return aA;
    }

    public final boolean isReplaceLongVideoToNormal() {
        return this.isReplaceLongVideoToNormal;
    }

    public final void setReplaceLongVideoToNormal(boolean z) {
        this.isReplaceLongVideoToNormal = z;
    }

    public final LinkedList<FinderMedia> getCopyObjectDescMedia() {
        return this.copyObjectDescMedia;
    }

    public final LinkedList<cjl> getMediaList() {
        LinkedList<FinderMedia> linkedList;
        String str;
        awe awe;
        AppMethodBeat.i(166989);
        if (this.mediaType == 9) {
            if (this.liveFinderMedia == null) {
                cjl cjl = new cjl();
                FinderObject finderObject = this.feedObject;
                if (finderObject == null || (awe = finderObject.liveInfo) == null || (str = awe.EzJ) == null) {
                    str = "";
                }
                cjl.url = str;
                cjl.mediaType = 9;
                cjl.thumbUrl = p.I(((cjl) j.ks(getLiveMediaList())).thumbUrl, Util.nullAsNil(((cjl) j.ks(getLiveMediaList())).thumb_url_token));
                cjl.videoDuration = 0;
                cjl.mediaId = MD5Util.getMD5String(cjl.url);
                cjl.width = 1000.0f;
                cjl.height = 1167.0f;
                cjl.md5sum = "";
                cjl.fileSize = 0;
                cjl.bitrate = 0;
                this.liveFinderMedia = cjl;
            }
            LinkedList<cjl> linkedList2 = new LinkedList<>();
            cjl cjl2 = this.liveFinderMedia;
            if (cjl2 != null) {
                linkedList2.add(cjl2);
            }
            AppMethodBeat.o(166989);
            return linkedList2;
        } else if (getMediaExtList().size() > 0) {
            LinkedList<cjl> mediaExtList = getMediaExtList();
            AppMethodBeat.o(166989);
            return mediaExtList;
        } else {
            FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
            if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) {
                LinkedList<cjl> linkedList3 = new LinkedList<>();
                AppMethodBeat.o(166989);
                return linkedList3;
            }
            LinkedList<cjl> aA = com.tencent.mm.plugin.finder.storage.data.j.aA(linkedList);
            AppMethodBeat.o(166989);
            return aA;
        }
    }

    public final void setMediaList(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(166990);
        p.h(linkedList, "value");
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc != null) {
            p.h(linkedList, "$this$toServer");
            LinkedList<FinderMedia> linkedList2 = new LinkedList<>();
            for (T t : linkedList) {
                p.h(t, "$this$toServer");
                FinderMedia finderMedia = new FinderMedia();
                finderMedia.url = t.url;
                finderMedia.thumbUrl = t.thumbUrl;
                finderMedia.mediaType = t.mediaType;
                finderMedia.videoDuration = t.videoDuration;
                finderMedia.width = t.width;
                finderMedia.height = t.height;
                finderMedia.md5sum = t.md5sum;
                finderMedia.fileSize = t.fileSize;
                finderMedia.bitrate = t.bitrate;
                LinkedList<ayh> linkedList3 = finderMedia.spec;
                linkedList3.clear();
                linkedList3.addAll(t.spec);
                finderMedia.coverUrl = t.coverUrl;
                finderMedia.decodeKey = t.decodeKey;
                finderMedia.url_token = t.url_token;
                finderMedia.thumb_url_token = t.thumb_url_token;
                finderMedia.cover_url_token = t.cover_url_token;
                finderMedia.codec_info = t.codec_info;
                finderMedia.hot_flag = t.hot_flag;
                finderMedia.half_rect = t.MoU;
                finderMedia.full_thumb_url = t.MoR;
                finderMedia.full_thumb_url_token = t.MoS;
                finderMedia.full_url = t.full_url;
                finderMedia.full_width = t.full_width;
                finderMedia.full_height = t.full_height;
                finderMedia.full_md5sum = t.full_md5sum;
                finderMedia.full_file_size = t.full_file_size;
                finderMedia.full_bitrate = t.full_bitrate;
                linkedList2.add(finderMedia);
            }
            finderObjectDesc.media = linkedList2;
        }
        if (this.feedObject.id == 0) {
            setMediaExtList(linkedList);
        }
        AppMethodBeat.o(166990);
    }

    public final LinkedList<cjl> getMediaExtList() {
        LinkedList<cjl> linkedList;
        AppMethodBeat.i(166991);
        cjt cjt = this.field_mediaExtList;
        if (cjt == null || (linkedList = cjt.Mpk) == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(166991);
        return linkedList;
    }

    public final void setMediaExtList(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(166992);
        p.h(linkedList, "value");
        if (this.field_mediaExtList == null) {
            this.field_mediaExtList = new cjt();
        }
        this.field_mediaExtList.Mpk = linkedList;
        AppMethodBeat.o(166992);
    }

    public final LinkedList<cjl> getLongVideoMediaList() {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        cng cng;
        cnl cnl;
        LinkedList<cod> linkedList2;
        AppMethodBeat.i(251752);
        if (getLongVideoMediaExtList().size() > 0) {
            LinkedList<cjl> longVideoMediaExtList = getLongVideoMediaExtList();
            AppMethodBeat.o(251752);
            return longVideoMediaExtList;
        }
        aoq aoq = this.feedObject.attachmentList;
        if (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null || (cnl = cng.MtG) == null || (linkedList2 = cnl.media) == null) {
            LinkedList<cjl> linkedList3 = new LinkedList<>();
            AppMethodBeat.o(251752);
            return linkedList3;
        }
        LinkedList<cjl> aB = com.tencent.mm.plugin.finder.storage.data.j.aB(linkedList2);
        AppMethodBeat.o(251752);
        return aB;
    }

    public final void setLongVideoMediaList(LinkedList<cjl> linkedList) {
        LinkedList<aop> linkedList2;
        aop aop;
        bei bei;
        cng cng;
        cnl cnl;
        AppMethodBeat.i(251753);
        p.h(linkedList, "value");
        aoq aoq = this.feedObject.attachmentList;
        if (aoq == null || (linkedList2 = aoq.LAM) == null || (aop = (aop) j.kt(linkedList2)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null || (cnl = cng.MtG) == null) {
            AppMethodBeat.o(251753);
            return;
        }
        cnl.media = o.aC(linkedList);
        AppMethodBeat.o(251753);
    }

    public final LinkedList<cjl> getLongVideoMediaExtList() {
        LinkedList<cjl> linkedList;
        AppMethodBeat.i(251754);
        cjt cjt = this.field_longVideoMediaExtList;
        if (cjt == null || (linkedList = cjt.Mpk) == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(251754);
        return linkedList;
    }

    public final void setLongVideoMediaExtList(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(251755);
        p.h(linkedList, "value");
        if (this.field_longVideoMediaExtList == null) {
            this.field_longVideoMediaExtList = new cjt();
        }
        this.field_longVideoMediaExtList.Mpk = linkedList;
        AppMethodBeat.o(251755);
    }

    public final LinkedList<cjl> getHalfVideoMediaExtList() {
        LinkedList<cjl> linkedList;
        AppMethodBeat.i(251756);
        cjt cjt = this.field_halfMediaExtList;
        if (cjt == null || (linkedList = cjt.Mpk) == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(251756);
        return linkedList;
    }

    public final void setHalfVideoMediaExtList(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(251757);
        p.h(linkedList, "value");
        if (this.field_halfMediaExtList == null) {
            this.field_halfMediaExtList = new cjt();
        }
        this.field_halfMediaExtList.Mpk = linkedList;
        AppMethodBeat.o(251757);
    }

    public final LinkedList<FinderItem> getClipListExt() {
        LinkedList<aud> linkedList;
        AppMethodBeat.i(251758);
        if (!(!this._clipListExt.isEmpty() || this.field_clipList == null || (linkedList = this.field_clipList.MoH) == null)) {
            for (T t : linkedList) {
                LinkedList<FinderItem> linkedList2 = this._clipListExt;
                p.g(t, LocaleUtil.ITALIAN);
                linkedList2.add(a.a((aud) t, 0L));
            }
        }
        LinkedList<FinderItem> linkedList3 = this._clipListExt;
        AppMethodBeat.o(251758);
        return linkedList3;
    }

    public final void setClipListExt(LinkedList<FinderItem> linkedList) {
        LinkedList<aud> linkedList2;
        LinkedList<aud> linkedList3;
        AppMethodBeat.i(251759);
        p.h(linkedList, "value");
        this._clipListExt.clear();
        this._clipListExt.addAll(linkedList);
        if (this.field_clipList == null) {
            this.field_clipList = new cjh();
        }
        cjh cjh = this.field_clipList;
        if (!(cjh == null || (linkedList3 = cjh.MoH) == null)) {
            linkedList3.clear();
        }
        for (T t : linkedList) {
            cjh cjh2 = this.field_clipList;
            if (!(cjh2 == null || (linkedList2 = cjh2.MoH) == null)) {
                linkedList2.add(a.l(t));
            }
        }
        AppMethodBeat.o(251759);
    }

    public final boolean isLongVideo() {
        AppMethodBeat.i(251760);
        if (!getLongVideoMediaList().isEmpty()) {
            AppMethodBeat.o(251760);
            return true;
        }
        AppMethodBeat.o(251760);
        return false;
    }

    public final cjl mediaExt(String str) {
        LinkedList<cjl> linkedList;
        T t;
        AppMethodBeat.i(166993);
        p.h(str, "mediaId");
        cjt cjt = this.field_mediaExtList;
        if (cjt == null || (linkedList = cjt.Mpk) == null) {
            AppMethodBeat.o(166993);
            return null;
        }
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.mediaId, str)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        AppMethodBeat.o(166993);
        return t2;
    }

    public final LinkedList<FinderCommentInfo> getLikeList() {
        AppMethodBeat.i(166994);
        LinkedList<FinderCommentInfo> linkedList = this.feedObject.likeList;
        p.g(linkedList, "feedObject.likeList");
        AppMethodBeat.o(166994);
        return linkedList;
    }

    public final void setLikeList(LinkedList<FinderCommentInfo> linkedList) {
        AppMethodBeat.i(166995);
        p.h(linkedList, "value");
        this.feedObject.likeList = linkedList;
        AppMethodBeat.o(166995);
    }

    public final LinkedList<FinderCommentInfo> getCommentList() {
        AppMethodBeat.i(166996);
        LinkedList<FinderCommentInfo> linkedList = this.feedObject.commentList;
        p.g(linkedList, "feedObject.commentList");
        AppMethodBeat.o(166996);
        return linkedList;
    }

    public final void setCommentList(LinkedList<FinderCommentInfo> linkedList) {
        AppMethodBeat.i(166997);
        p.h(linkedList, "value");
        this.feedObject.commentList = linkedList;
        AppMethodBeat.o(166997);
    }

    public final axt getLocation() {
        axt axt;
        AppMethodBeat.i(166998);
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc == null || (axt = finderObjectDesc.location) == null) {
            axt = new axt();
            axt.fuK = "";
            axt.kHV = "";
        }
        AppMethodBeat.o(166998);
        return axt;
    }

    public final void setLocation(axt axt) {
        AppMethodBeat.i(166999);
        p.h(axt, "value");
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc != null) {
            finderObjectDesc.location = axt;
            AppMethodBeat.o(166999);
            return;
        }
        AppMethodBeat.o(166999);
    }

    public final aqp getExtReading() {
        aqp aqp;
        AppMethodBeat.i(167000);
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc == null || (aqp = finderObjectDesc.extReading) == null) {
            aqp = new aqp();
            aqp.link = "";
            aqp.title = "";
        }
        AppMethodBeat.o(167000);
        return aqp;
    }

    public final void setExtReading(aqp aqp) {
        AppMethodBeat.i(167001);
        p.h(aqp, "value");
        FinderObjectDesc finderObjectDesc = this.feedObject.objectDesc;
        if (finderObjectDesc != null) {
            finderObjectDesc.extReading = aqp;
            AppMethodBeat.o(167001);
            return;
        }
        AppMethodBeat.o(167001);
    }

    public final FinderContact getRefObjectContact() {
        AppMethodBeat.i(167002);
        FinderContact finderContact = this.feedObject.refObjectContact;
        if (finderContact == null) {
            finderContact = new FinderContact();
        }
        AppMethodBeat.o(167002);
        return finderContact;
    }

    public final void setRefObjectContact(FinderContact finderContact) {
        AppMethodBeat.i(167003);
        p.h(finderContact, "value");
        this.feedObject.refObjectContact = finderContact;
        AppMethodBeat.o(167003);
    }

    public final long getRefObjectFlag() {
        return this.feedObject.refObjectFlag;
    }

    public final void setRefObjectFlag(long j2) {
        this.feedObject.refObjectFlag = j2;
    }

    public final long getRefObjectId() {
        return this.feedObject.refObjectId;
    }

    public final void setRefObjectId(long j2) {
        this.feedObject.refObjectId = j2;
    }

    public final int getComment_close() {
        return this.feedObject.commentClose;
    }

    public final void setComment_close(int i2) {
        this.feedObject.commentClose = i2;
    }

    public final int getPrivate_flag() {
        return this.feedObject.privateFlag;
    }

    public final void setPrivate_flag(int i2) {
        this.feedObject.privateFlag = i2;
    }

    public final int getStickyTime() {
        return this.feedObject.stickyTime;
    }

    public final void setStickyTime(int i2) {
        this.feedObject.stickyTime = i2;
    }

    public final List<BaseFinderFeed> getFoldedFeedList() {
        ArrayList arrayList;
        ArrayList arrayList2;
        v vVar;
        LinkedList<FinderObject> linkedList;
        AppMethodBeat.i(251761);
        if (Util.isNullOrNil(this.foldedFeeds)) {
            ard foldedLayout2 = getFoldedLayout();
            if (!Util.isNullOrNil(foldedLayout2 != null ? foldedLayout2.LCW : null)) {
                ard foldedLayout3 = getFoldedLayout();
                if (foldedLayout3 == null || (linkedList = foldedLayout3.LCW) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t : linkedList) {
                        T t2 = t;
                        if ((t2 != null ? t2.objectDesc : null) != null) {
                            arrayList3.add(t);
                        }
                    }
                    arrayList = arrayList3;
                }
                if (arrayList != null) {
                    ArrayList<FinderObject> arrayList4 = arrayList;
                    ArrayList arrayList5 = new ArrayList(j.a(arrayList4, 10));
                    for (FinderObject finderObject : arrayList4) {
                        p.g(finderObject, "feed");
                        FinderItem a2 = a.a(finderObject, 1);
                        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        arrayList5.add(c.a.s(a2));
                    }
                    arrayList2 = arrayList5;
                } else {
                    arrayList2 = null;
                }
                List<BaseFinderFeed> list = this.foldedFeeds;
                if (arrayList2 != null) {
                    vVar = arrayList2;
                } else {
                    vVar = v.SXr;
                }
                list.addAll(vVar);
            }
        }
        List<BaseFinderFeed> list2 = this.foldedFeeds;
        AppMethodBeat.o(251761);
        return list2;
    }

    public final void setFoldedLayout(ard ard) {
        this.foldedLayout = ard;
    }

    public final ard getFoldedLayout() {
        return this.feedObject.foldedLayout;
    }

    /* renamed from: getCreateTime  reason: collision with other method in class */
    public final long m21getCreateTime() {
        return this.field_createTime;
    }

    public final cjm getPostInfo() {
        AppMethodBeat.i(167004);
        cjm cjm = this.field_postinfo;
        if (cjm == null) {
            cjm = new cjm();
        }
        AppMethodBeat.o(167004);
        return cjm;
    }

    public final void setPostInfo(cjm cjm) {
        AppMethodBeat.i(167005);
        p.h(cjm, "field_postinfo");
        this.field_postinfo = cjm;
        AppMethodBeat.o(167005);
    }

    public final void updateFinderObject(FinderObject finderObject) {
        AppMethodBeat.i(167006);
        p.h(finderObject, "svrFeed");
        this.field_username = finderObject.username;
        this.field_finderObject = finderObject;
        setFeedObject(finderObject);
        this.field_id = finderObject.id;
        this.field_createTime = (long) finderObject.createtime;
        AppMethodBeat.o(167006);
    }

    public final FinderObject getFinderObject() {
        return this.feedObject;
    }

    public final cjl getCropInfo(int i2) {
        AppMethodBeat.i(167007);
        LinkedList<cjl> mediaList = getMediaList();
        if (mediaList != null) {
            cjl cjl = (cjl) j.L(mediaList, i2);
            AppMethodBeat.o(167007);
            return cjl;
        }
        AppMethodBeat.o(167007);
        return null;
    }

    public final boolean isNeedCrop(int i2) {
        AppMethodBeat.i(167008);
        cjl cropInfo = getCropInfo(i2);
        if (cropInfo == null) {
            AppMethodBeat.o(167008);
            return false;
        } else if (cropInfo.MoO) {
            AppMethodBeat.o(167008);
            return true;
        } else {
            AppMethodBeat.o(167008);
            return false;
        }
    }

    public final boolean isNeedVideoCompositionPlay(int i2) {
        AppMethodBeat.i(251762);
        cjl cropInfo = getCropInfo(i2);
        y yVar = y.vXH;
        if (!y.h(cropInfo)) {
            AppMethodBeat.o(251762);
            return true;
        }
        AppMethodBeat.o(251762);
        return false;
    }

    public final void setPostWaiting() {
        this.field_localFlag = 1;
    }

    public final void setPostFailed() {
        this.field_localFlag |= 2;
        this.field_localFlag &= -2;
    }

    public final void setPostFailedAndNotRetry(int i2) {
        AppMethodBeat.i(251763);
        setPostFailed();
        this.field_localFlag |= 4;
        if (i2 == -4059) {
            setEventClosed();
            AppMethodBeat.o(251763);
            return;
        }
        if (i2 == -4065) {
            setEventExpired();
        }
        AppMethodBeat.o(251763);
    }

    public final void setEventClosed() {
        this.field_localFlag |= 16;
    }

    public final void setEventExpired() {
        this.field_localFlag |= 18;
    }

    public final void setPostFailedAndNoAuth() {
        AppMethodBeat.i(167010);
        setPostFailed();
        this.field_localFlag |= 8;
        AppMethodBeat.o(167010);
    }

    public final void setPostFinish() {
        this.field_localFlag &= -2;
        this.field_localFlag &= -3;
    }

    public final boolean isEventClosed() {
        return (this.field_localFlag & 16) != 0;
    }

    public final boolean isEventExpired() {
        return (this.field_localFlag & 18) != 0;
    }

    public final boolean isPostFinish() {
        return (this.field_localFlag & 3) == 0;
    }

    public final boolean isPostFailed() {
        return (this.field_localFlag & 2) != 0;
    }

    public final boolean isPostFailedCanRetry() {
        return (this.field_localFlag & 4) == 0;
    }

    public final boolean isPostNoAuth() {
        return (this.field_localFlag & 8) != 0;
    }

    public final String info() {
        String str;
        AppMethodBeat.i(167012);
        StringBuilder append = new StringBuilder("id:").append(this.field_id).append(" username ").append(this.feedObject.username).append(" mediaType ").append(this.mediaType).append(" localFlag ").append(this.field_localFlag).append(" description ");
        String description = getDescription();
        if (description != null) {
            int min = Math.min(description.length(), 3);
            if (description == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(167012);
                throw tVar;
            }
            str = description.substring(0, min);
            p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            str = null;
        }
        String sb = append.append(str).append(" mediaList ").append(g.bN(getMediaList())).toString();
        AppMethodBeat.o(167012);
        return sb;
    }

    public final boolean isOldVersion() {
        return this.feedObject.secondaryShowFlag != 1;
    }

    public final boolean isCommentClose() {
        return this.feedObject.commentClose == 1;
    }

    public final boolean isPrivate() {
        return this.feedObject.privateFlag == 1;
    }

    public final boolean isOnlySelfSee() {
        if (!debugOnlySelfSee && this.feedObject.objectStatus != 1) {
            return false;
        }
        return true;
    }

    public final boolean isNotShare() {
        return this.feedObject.objectStatus == 2;
    }

    public final boolean isLiveFeed() {
        return this.mediaType == 9;
    }

    public final String getNotShareMsg() {
        String str = this.feedObject.sendShareFavWording;
        return str == null ? "" : str;
    }

    public final boolean isLive() {
        return this.mediaType == 9;
    }

    public final boolean isMvFeed() {
        return this.feedObject.objectType == 2;
    }

    public final void trackPost(String str) {
        AppMethodBeat.i(167013);
        p.h(str, "stage");
        try {
            cjm cjm = this.field_postinfo;
            if (cjm != null) {
                String str2 = "localId:" + getLocalId() + ", localFlag:" + this.field_localFlag + ", uploadState:" + cjm.Mpa + ", tryCount:" + cjm.ibG + ", utilNow:" + (cl.aWy() - cjm.Mpd) + "ms, mediaProcessCost:" + cjm.Mpe + "ms, uploadCost:" + cjm.hdA + "ms, doSceneCost:" + cjm.Mpf + "ms, totalCost:" + cjm.zZb + LocaleUtil.MALAY;
                int i2 = 0;
                String str3 = "localId:" + getLocalId() + ", mediaList: ";
                for (T t : getMediaExtList()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    i2 = i3;
                    str3 = str3 + "Index" + i2 + ", fileSize:" + ((((float) s.boW(t2.url)) / 1024.0f) / 1024.0f) + "MB, mediaType:" + t2.mediaType + "; ";
                }
                Log.i("Finder.PostLog", "stage:" + str + ' ' + str2);
                Log.i("Finder.PostLog", "stage:" + str + ' ' + str3);
                AppMethodBeat.o(167013);
                return;
            }
            Log.i("Finder.PostLog", "stage:" + str + " localId:" + getLocalId() + ", postInfo is null");
            AppMethodBeat.o(167013);
        } catch (Throwable th) {
            Log.i("Finder.PostLog", "exception: ".concat(String.valueOf(th)));
            AppMethodBeat.o(167013);
        }
    }

    public final aqg getCustomData() {
        return this.field_customData;
    }

    public final void setCustomData(aqg aqg) {
        this.field_customData = aqg;
    }

    public final axf getFinderLive() {
        String str;
        String str2;
        int i2;
        AppMethodBeat.i(261381);
        axf axf = new axf();
        axf.feedId = com.tencent.mm.ac.d.zs(getId());
        awe liveInfo = getLiveInfo();
        axf.hJs = com.tencent.mm.ac.d.zs(liveInfo != null ? liveInfo.liveId : 0);
        axf.username = this.field_username;
        axf.nickName = getNickName();
        i iVar = i.vvu;
        axf.desc = i.auY(getDescription());
        String str3 = getLiveMediaList().getFirst().coverUrl;
        if (str3 == null || str3.length() == 0) {
            str = p.I(getLiveMediaList().getFirst().thumbUrl, Util.nullAsNil(getLiveMediaList().getFirst().thumb_url_token));
        } else {
            str = getLiveMediaList().getFirst().coverUrl;
        }
        axf.coverUrl = str;
        axf.width = getLiveMediaList().getFirst().width;
        axf.height = getLiveMediaList().getFirst().height;
        FinderContact finderContact = this.feedObject.contact;
        if (finderContact == null || (str2 = finderContact.headUrl) == null) {
            str2 = "";
        }
        axf.headUrl = str2;
        axf.objectNonceId = this.feedObject.objectNonceId;
        awe liveInfo2 = getLiveInfo();
        if (liveInfo2 != null) {
            i2 = liveInfo2.liveStatus;
        } else {
            i2 = 1;
        }
        axf.liveStatus = i2;
        AppMethodBeat.o(261381);
        return axf;
    }
}

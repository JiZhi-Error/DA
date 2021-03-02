package com.tencent.mm.plugin.story.h;

import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002KLB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ\u001a\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0002J\u000e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0014\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/J\u0006\u00100\u001a\u00020\u001fJ\u0010\u00101\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0002J\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\fJ\u0006\u00106\u001a\u00020\u001fJ*\u00107\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0\u001c2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J.\u0010>\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00042\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020BJ\u000e\u0010?\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u001fJ \u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0016\u0010H\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\bJ\u000e\u0010J\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", Constants.EXTINFO, "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b {
    private static long FtA;
    private static long FtB;
    public static h FtC;
    public static boolean FtD;
    public static long FtE;
    private static long FtF;
    private static long FtG;
    private static int FtH;
    private static int FtI;
    private static boolean FtJ;
    private static ArrayList<String> FtK;
    public static final b FtL = new b();
    public static long Ftw;
    public static final Map<Long, a> Ftx;
    public static a Fty;
    public static long Ftz;
    private static boolean isWaiting;
    public static long oIi = 998;
    public static boolean tcf = true;

    static {
        AppMethodBeat.i(119402);
        Map<Long, a> synchronizedMap = Collections.synchronizedMap(new HashMap());
        p.g(synchronizedMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
        Ftx = synchronizedMap;
        AppMethodBeat.o(119402);
    }

    private b() {
    }

    public static void aaR(int i2) {
        if (i2 == 1 || i2 == 2) {
            oIi = 998;
        } else if (i2 == 3) {
            oIi = 1006;
        } else {
            oIi = -1;
        }
    }

    public static void e(long j2, long j3, long j4) {
        AppMethodBeat.i(119390);
        if (j2 < 0) {
            AppMethodBeat.o(119390);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(j2, j3, j4);
        AppMethodBeat.o(119390);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.h.b$b  reason: collision with other inner class name */
    public enum EnumC1767b {
        SHOW(1),
        PLAY(2),
        WAIT(3);
        
        private final int s;

        public static EnumC1767b valueOf(String str) {
            AppMethodBeat.i(119389);
            EnumC1767b bVar = (EnumC1767b) Enum.valueOf(EnumC1767b.class, str);
            AppMethodBeat.o(119389);
            return bVar;
        }

        private EnumC1767b(int i2) {
            this.s = i2;
        }

        static {
            AppMethodBeat.i(119387);
            AppMethodBeat.o(119387);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        public boolean Eva;
        long FtM;
        public long FtN;
        public long FtO;
        public boolean FtP;
        public long FtQ;
        private EnumC1767b FtR;
        private final String dWq;
        public boolean idt;
        public boolean isWaiting;
        public boolean qeT;

        public a(String str, EnumC1767b bVar) {
            p.h(str, "user");
            p.h(bVar, "state");
            AppMethodBeat.i(119386);
            this.dWq = str;
            this.FtR = bVar;
            AppMethodBeat.o(119386);
        }
    }

    public static void clean() {
        AppMethodBeat.i(119391);
        FtA = 0;
        FtB = 0;
        FtG = 0;
        FtJ = false;
        FtH = -1;
        FtI = -1;
        FtE = 0;
        FtF = 0;
        Ftx.clear();
        FtD = false;
        FtC = null;
        isWaiting = false;
        FtK = new ArrayList<>();
        Fty = null;
        AppMethodBeat.o(119391);
    }

    public static void hv(List<String> list) {
        AppMethodBeat.i(119392);
        p.h(list, "list");
        ArrayList<String> arrayList = new ArrayList<>();
        FtK = arrayList;
        arrayList.addAll(list);
        AppMethodBeat.o(119392);
    }

    public static void Kn(long j2) {
        Ftz = j2;
    }

    public static void fpM() {
        FtD = true;
    }

    public static void aaS(int i2) {
        AppMethodBeat.i(119393);
        long milliSecondsToNow = Util.milliSecondsToNow(FtG);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + i2 + " cur: " + milliSecondsToNow);
        if (milliSecondsToNow > 5000) {
            if (i2 < 10) {
                e(oIi, 82, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 100) {
                e(oIi, 83, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 200) {
                e(oIi, 89, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 250) {
                e(oIi, 84, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 450) {
                e(oIi, 85, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 900) {
                e(oIi, 86, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 1350) {
                e(oIi, 87, 1);
                AppMethodBeat.o(119393);
                return;
            } else if (i2 < 1800) {
                e(oIi, 88, 1);
            }
        }
        AppMethodBeat.o(119393);
    }

    public static void d(ArrayList<ArrayList<h>> arrayList, int i2, int i3) {
        boolean z;
        boolean z2;
        a aVar;
        j jVar;
        ArrayList<String> arrayList2;
        boolean z3;
        AppMethodBeat.i(119394);
        p.h(arrayList, "group");
        if (!beE()) {
            AppMethodBeat.o(119394);
            return;
        }
        Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + FtI + ",last_selectedRow:" + FtH + " selectedRow:" + i2 + ",selectedColumn:" + i3);
        if (arrayList.size() > 0) {
            if (arrayList.get(i2).size() <= 0 || i3 + 1 >= arrayList.get(i2).size()) {
                z2 = false;
            } else {
                if (!FtJ) {
                    e(oIi, 101, 1);
                }
                z2 = true;
            }
            if (i2 + 1 < arrayList.size()) {
                if (!FtJ) {
                    e(oIi, 102, 1);
                }
                z3 = true;
            } else {
                z3 = false;
            }
            FtJ = true;
            z = z3;
        } else {
            z = false;
            z2 = false;
        }
        if (!(FtI == -1 || FtH == -1)) {
            if (isWaiting) {
                e(oIi, 100, 1);
                isWaiting = false;
            }
            if (i2 != FtH) {
                if (z2) {
                    e(oIi, 105, 1);
                }
                e(oIi, 106, 1);
                int i4 = i2 - FtH;
                if (i4 == 1) {
                    e(oIi, 110, 1);
                } else if (i4 == 2) {
                    e(oIi, 111, 1);
                } else if (i4 == 3) {
                    e(oIi, 112, 1);
                } else if (i4 >= 4) {
                    e(oIi, 113, 1);
                }
                if (arrayList.size() > 0) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        if (!(i2 + i5 >= arrayList.size() || arrayList.get(i2 + i5).size() <= 0 || (jVar = arrayList.get(i2 + i5).get(0).FoT) == null || jVar.username == null || FtK == null || (arrayList2 = FtK) == null || !arrayList2.contains(jVar.username))) {
                            if (c(jVar) == 1) {
                                if (i5 == 0) {
                                    e(oIi, 120, 1);
                                } else if (i5 == 1) {
                                    e(oIi, 121, 1);
                                } else if (i5 == 2) {
                                    e(oIi, 122, 1);
                                }
                            }
                            if (i5 == 0) {
                                e(oIi, 125, 1);
                            } else if (i5 == 1) {
                                e(oIi, 126, 1);
                            } else if (i5 == 2) {
                                e(oIi, 127, 1);
                            }
                        }
                    }
                }
            } else if (i3 != FtI) {
                if (z) {
                    e(oIi, 103, 1);
                }
                e(oIi, 104, 1);
                int i6 = i3 - FtI;
                if (i6 == 1) {
                    e(oIi, 115, 1);
                } else if (i6 == 2) {
                    e(oIi, 116, 1);
                } else if (i6 == 3) {
                    e(oIi, 117, 1);
                } else if (i6 >= 4) {
                    e(oIi, 118, 1);
                }
            }
            if (FtH >= 0 && FtH < arrayList.size() && FtI >= 0 && FtI < arrayList.get(FtH).size() && !(FtI == i3 && FtH == i2)) {
                long j2 = arrayList.get(FtH).get(FtI).FoT.edx;
                Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + j2 + " lastStoryId " + Ftw);
                if (beE() && Ftx.containsKey(Long.valueOf(j2)) && (aVar = Ftx.get(Long.valueOf(j2))) != null && aVar.FtM <= 0 && !aVar.Eva && aVar.FtN >= 0) {
                    aVar.FtM = Util.milliSecondsToNow(aVar.FtN);
                    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + j2 + ' ' + aVar.FtM + " hasHttp:" + aVar.FtP + "  isWaiting:" + aVar.isWaiting);
                    if (aVar.FtP) {
                        e(oIi, 21, 1);
                        e(oIi, 20, aVar.FtM);
                    }
                    if (aVar.isWaiting) {
                        e(oIi, 23, 1);
                        e(oIi, 22, aVar.FtM);
                    }
                    e(oIi, 25, 1);
                    e(oIi, 24, aVar.FtM);
                    if (aVar.idt) {
                        e(oIi, 26, 1);
                    }
                }
            }
        }
        FtI = i3;
        FtH = i2;
        AppMethodBeat.o(119394);
    }

    public static /* synthetic */ int d(j jVar) {
        AppMethodBeat.i(119396);
        int c2 = c(jVar);
        AppMethodBeat.o(119396);
        return c2;
    }

    private static int c(j jVar) {
        AppMethodBeat.i(119395);
        s sVar = s.Fny;
        n a2 = s.a(jVar);
        if (a2.frQ()) {
            Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + jVar.edx);
            AppMethodBeat.o(119395);
            return 1;
        } else if (a2.field_totalSize <= 0) {
            AppMethodBeat.o(119395);
            return 0;
        } else {
            m mVar = m.FHB;
            if ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) m.fsu().FFU)) {
                Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + a2.field_cacheSize + " totalSize: " + a2.field_totalSize);
                AppMethodBeat.o(119395);
                return 1;
            }
            AppMethodBeat.o(119395);
            return 0;
        }
    }

    public static void M(long j2, boolean z) {
        AppMethodBeat.i(119397);
        if (!Ftx.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(119397);
            return;
        }
        a aVar = Ftx.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.FtQ = Util.nowMilliSecond();
            aVar.qeT = z;
            AppMethodBeat.o(119397);
            return;
        }
        AppMethodBeat.o(119397);
    }

    public static void Ko(long j2) {
        AppMethodBeat.i(119398);
        if (!Ftx.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(119398);
            return;
        }
        a aVar = Ftx.get(Long.valueOf(j2));
        if (aVar != null && aVar.Eva) {
            AppMethodBeat.o(119398);
        } else if (j2 == Ftz) {
            a aVar2 = Fty;
            if (aVar2 == null) {
                AppMethodBeat.o(119398);
            } else if (aVar2.FtQ <= 0) {
                AppMethodBeat.o(119398);
            } else {
                long milliSecondsToNow = Util.milliSecondsToNow(aVar2.FtQ);
                Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(milliSecondsToNow)));
                if (aVar2.qeT) {
                    e(oIi, 62, 1);
                    e(oIi, 63, milliSecondsToNow);
                }
                e(oIi, 60, 1);
                e(oIi, 61, milliSecondsToNow);
                AppMethodBeat.o(119398);
            }
        } else {
            a aVar3 = Ftx.get(Long.valueOf(j2));
            if (aVar3 == null) {
                AppMethodBeat.o(119398);
            } else if (aVar3.FtQ <= 0) {
                AppMethodBeat.o(119398);
            } else {
                long milliSecondsToNow2 = Util.milliSecondsToNow(aVar3.FtQ);
                Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(milliSecondsToNow2)));
                if (aVar3.qeT) {
                    e(oIi, 62, 1);
                    e(oIi, 63, milliSecondsToNow2);
                }
                e(oIi, 60, 1);
                e(oIi, 61, milliSecondsToNow2);
                AppMethodBeat.o(119398);
            }
        }
    }

    public static void fpN() {
        AppMethodBeat.i(119399);
        Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + FtA + " onPlayUser " + FtB);
        FtA = Util.nowMilliSecond();
        AppMethodBeat.o(119399);
    }

    public static void n(String str, long j2, int i2) {
        boolean z;
        a aVar;
        AppMethodBeat.i(119400);
        p.h(str, "user");
        if (!beE()) {
            AppMethodBeat.o(119400);
            return;
        }
        if (FtE > 0 && FtF <= 0) {
            FtF = Util.milliSecondsToNow(FtE);
            e(oIi, 130, 1);
            e(oIi, 131, FtF);
        }
        Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + str + " storyId " + j2 + " selectedColumn " + i2 + " lastStoryId:" + Ftw + " onStoryLauncherTime " + FtF);
        boolean z2 = false;
        if (!(Ftw == j2 || Ftw == 0)) {
            z2 = true;
        }
        long j3 = Ftw;
        Ftw = j2;
        p.h(str, "user");
        ArrayList<String> arrayList = FtK;
        if (arrayList == null || !arrayList.contains(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(119400);
            return;
        }
        if (Ftx.containsKey(Long.valueOf(j3)) && z2 && (aVar = Ftx.get(Long.valueOf(j3))) != null) {
            aVar.Eva = true;
        }
        if (i2 > 0) {
            AppMethodBeat.o(119400);
            return;
        }
        Map<Long, a> map = Ftx;
        Long valueOf = Long.valueOf(j2);
        a aVar2 = new a(str, EnumC1767b.PLAY);
        aVar2.FtN = Util.nowMilliSecond();
        map.put(valueOf, aVar2);
        FtB = Util.nowMilliSecond();
        Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + FtB);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        f aRS = j.b.fod().aRS(str);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + str + " preload " + Util.getSizeKB(aRS.fry()));
        e(oIi, 2, 1);
        if (aRS.fry() > 0) {
            e(oIi, 3, 1);
        }
        if (j2 == Ftz) {
            if (FtD) {
                e(oIi, 6, 1);
            } else {
                e(oIi, 9, 1);
            }
            if (aRS.fry() > 0) {
                if (FtD) {
                    e(oIi, 7, 1);
                } else {
                    e(oIi, 10, 1);
                }
            }
            h hVar = FtC;
            if (hVar != null) {
                if (c(hVar.FoT) == 1) {
                    if (FtD) {
                        e(oIi, 8, 1);
                        AppMethodBeat.o(119400);
                        return;
                    }
                    e(oIi, 11, 1);
                }
                AppMethodBeat.o(119400);
                return;
            }
        }
        AppMethodBeat.o(119400);
    }

    public static void fpO() {
        AppMethodBeat.i(119401);
        FtG = Util.nowMilliSecond();
        AppMethodBeat.o(119401);
    }

    public static boolean beE() {
        if (FtG > 0 && tcf) {
            return true;
        }
        return false;
    }
}

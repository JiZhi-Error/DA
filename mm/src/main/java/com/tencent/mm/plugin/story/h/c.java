package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\u0014\u0010.\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dJ\u0006\u00100\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020\u001fJ\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ*\u00104\u001a\u00020\u001f2\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020706062\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u001e\u0010;\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c {
    private static long FtA;
    private static long FtB;
    private static long FtG;
    private static int FtH;
    private static int FtI;
    private static boolean FtJ;
    private static long FtM;
    public static a FtW;
    private static a FtX;
    private static boolean FtY;
    private static long FtZ;
    private static long Ftz;
    private static boolean Fua;
    public static boolean Fub;
    private static long Fuc;
    private static boolean Fud;
    private static List<String> Fue;
    public static final c Fuf = new c();
    private static boolean hkH;
    private static boolean isWaiting;

    static {
        AppMethodBeat.i(119418);
        AppMethodBeat.o(119418);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        final String dWq;
        final int scene;

        public a(String str, int i2) {
            p.h(str, "user");
            AppMethodBeat.i(119403);
            this.dWq = str;
            this.scene = i2;
            AppMethodBeat.o(119403);
        }
    }

    public static void clean() {
        AppMethodBeat.i(119404);
        Fub = false;
        hkH = true;
        FtA = 0;
        Fua = false;
        FtZ = 0;
        FtB = 0;
        FtG = 0;
        FtJ = false;
        FtH = -1;
        FtI = -1;
        FtM = 0;
        Fud = false;
        isWaiting = false;
        Fue = new ArrayList();
        FtW = new a("", 1);
        AppMethodBeat.o(119404);
    }

    public static void hv(List<String> list) {
        AppMethodBeat.i(119405);
        p.h(list, "unreadList");
        Fue = list;
        AppMethodBeat.o(119405);
    }

    public static void fpP() {
        AppMethodBeat.i(119406);
        Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
        FtY = true;
        h.INSTANCE.n(988, 11, 1);
        AppMethodBeat.o(119406);
    }

    public static void fpQ() {
        AppMethodBeat.i(119407);
        Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
        FtY = true;
        h.INSTANCE.n(988, 12, 1);
        AppMethodBeat.o(119407);
    }

    public static void aSk(String str) {
        AppMethodBeat.i(119408);
        p.h(str, "user");
        Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(str)));
        FtY = false;
        FtX = new a(str, 1);
        h.INSTANCE.n(988, 15, 1);
        AppMethodBeat.o(119408);
    }

    public static void aSl(String str) {
        AppMethodBeat.i(119409);
        p.h(str, "user");
        Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(str)));
        FtY = false;
        FtX = new a(str, 2);
        h.INSTANCE.n(988, 16, 1);
        AppMethodBeat.o(119409);
    }

    public static void Kn(long j2) {
        Ftz = j2;
    }

    public static void Kp(long j2) {
        if (FtG > 0 && j2 != 0 && j2 == Ftz && FtZ <= 0 && FtA > 0) {
            isWaiting = true;
        }
    }

    public static void Kq(long j2) {
        AppMethodBeat.i(119410);
        if (FtG <= 0) {
            AppMethodBeat.o(119410);
            return;
        }
        Fua = true;
        if (FtZ <= 0) {
            Log.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + j2 + " markStoryId " + Ftz + " onPlayCostTime " + FtZ + " onResumeTime " + FtA + "  onPlayUser " + FtB);
        }
        if (j2 != 0 && j2 == Ftz && FtZ <= 0 && FtA > 0) {
            FtZ = Util.milliSecondsToNow(FtA);
            Fuc = Util.nowMilliSecond();
            Log.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + FtZ);
            isWaiting = false;
            if (Fub) {
                if (FtY) {
                    h.INSTANCE.n(988, 32, FtZ);
                    h.INSTANCE.n(988, 33, 1);
                } else {
                    h.INSTANCE.n(988, 36, FtZ);
                    h.INSTANCE.n(988, 37, 1);
                }
            } else if (FtY) {
                h.INSTANCE.n(988, 30, FtZ);
                h.INSTANCE.n(988, 31, 1);
            } else {
                h.INSTANCE.n(988, 34, FtZ);
                h.INSTANCE.n(988, 35, 1);
            }
            h.INSTANCE.n(988, 71, FtZ);
            h.INSTANCE.n(988, 70, 1);
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                h.INSTANCE.n(988, 73, FtZ);
                h.INSTANCE.n(988, 72, 1);
            }
            if (FtZ <= 400) {
                h.INSTANCE.n(988, 100, FtZ);
                AppMethodBeat.o(119410);
                return;
            } else if (FtZ <= 800) {
                h.INSTANCE.n(988, 101, FtZ);
                AppMethodBeat.o(119410);
                return;
            } else if (FtZ <= 1600) {
                h.INSTANCE.n(988, 102, FtZ);
                AppMethodBeat.o(119410);
                return;
            } else if (FtZ <= 3200) {
                h.INSTANCE.n(988, 103, FtZ);
                AppMethodBeat.o(119410);
                return;
            } else if (FtZ <= 5000) {
                h.INSTANCE.n(988, 104, FtZ);
                AppMethodBeat.o(119410);
                return;
            } else {
                h.INSTANCE.n(988, 105, FtZ);
            }
        }
        AppMethodBeat.o(119410);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0144, code lost:
        if (((((float) r0.field_cacheSize) / ((float) r0.field_totalSize)) * 100.0f) >= ((float) com.tencent.mm.plugin.story.ui.view.gallery.m.fsu().FFU)) goto L_0x0146;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.util.ArrayList<java.util.ArrayList<com.tencent.mm.plugin.story.f.d.h>> r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.h.c.d(java.util.ArrayList, int, int):void");
    }

    private static void fpR() {
        AppMethodBeat.i(119412);
        Log.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + FtM + " hasStartHttp " + Fud + " onPlayCostTime: " + FtZ);
        if (FtM == 0 && Fud) {
            if (FtZ == 0) {
                FtM = Util.milliSecondsToNow(FtA);
                h.INSTANCE.n(988, 63, 1);
                h.INSTANCE.n(988, 62, FtM);
                AppMethodBeat.o(119412);
                return;
            }
            FtM = Util.milliSecondsToNow(Fuc);
            h.INSTANCE.n(988, 61, 1);
            h.INSTANCE.n(988, 60, FtM);
        }
        AppMethodBeat.o(119412);
    }

    public static void onDestroy() {
        AppMethodBeat.i(119413);
        if (FtG <= 0) {
            AppMethodBeat.o(119413);
            return;
        }
        fpR();
        AppMethodBeat.o(119413);
    }

    public static void fpS() {
        AppMethodBeat.i(119414);
        if (FtG <= 0) {
            AppMethodBeat.o(119414);
            return;
        }
        Log.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
        Fud = true;
        AppMethodBeat.o(119414);
    }

    public static void fpN() {
        AppMethodBeat.i(119415);
        Log.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + FtA + " onPlayUser " + FtB);
        FtA = Util.nowMilliSecond();
        AppMethodBeat.o(119415);
    }

    public static void bs(String str, long j2) {
        AppMethodBeat.i(119416);
        p.h(str, "user");
        if (FtG <= 0) {
            AppMethodBeat.o(119416);
        } else if (Ftz != j2) {
            Ftz = 0;
            Log.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + Ftz + " storyId " + j2);
            AppMethodBeat.o(119416);
        } else {
            FtB = Util.nowMilliSecond();
            Log.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + FtB);
            a aVar = FtX;
            if (aVar != null && p.j(aVar.dWq, str)) {
                j.b bVar = j.Fmy;
                f aRS = j.b.fod().aRS(str);
                Log.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + str + " preload " + Util.getSizeKB(aRS.fry()) + " canPlay: " + Fua);
                if (aRS.fry() > 0) {
                    if (aVar.scene == 1) {
                        h.INSTANCE.n(988, 21, 1);
                        if (Fua) {
                            h.INSTANCE.n(988, 27, 1);
                        }
                    } else if (aVar.scene == 2) {
                        h.INSTANCE.n(988, 22, 1);
                        if (Fua) {
                            h.INSTANCE.n(988, 28, 1);
                        }
                    }
                }
            }
            FtW = null;
            FtX = null;
            AppMethodBeat.o(119416);
        }
    }

    public static void fpO() {
        AppMethodBeat.i(119417);
        FtG = Util.nowMilliSecond();
        AppMethodBeat.o(119417);
    }
}

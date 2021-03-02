package com.tencent.mm.plugin.story.f;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.f.f;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RJ\u0010\u000b\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u0007*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", ch.COL_USERNAME, "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b implements com.tencent.mm.plugin.story.api.b {
    private static final List<String> FlD = Collections.synchronizedList(new ArrayList());
    private static final List<String> FlE = Collections.synchronizedList(new ArrayList());
    private static int FlF = 0;
    private static boolean FlG = false;
    public static final b FlH = new b();
    private static final String TAG = TAG;
    private static final List<WeakReference<c>> mListeners = Collections.synchronizedList(new ArrayList());

    static {
        AppMethodBeat.i(118638);
        AppMethodBeat.o(118638);
    }

    private b() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        public static final a FlI = new a();

        static {
            AppMethodBeat.i(118632);
            AppMethodBeat.o(118632);
        }

        a() {
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(118631);
            b bVar = b.FlH;
            if (b.FlG) {
                AppMethodBeat.o(118631);
                return;
            }
            b bVar2 = b.FlH;
            b.FlG = true;
            b bVar3 = b.FlH;
            b.FlE.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            b bVar4 = b.FlH;
            List list = b.FlD;
            p.g(list, "mFavourUserList");
            List<String> list2 = list;
            synchronized (list2) {
                try {
                    i2 = 0;
                    for (String str : list2) {
                        f.a aVar = f.FlW;
                        if (f.a.isStoryUnread(str)) {
                            b bVar5 = b.FlH;
                            Log.d(b.TAG, "%s has new story", str);
                            i2 |= 1;
                            arrayList2.add(str);
                        } else {
                            b bVar6 = b.FlH;
                            p.g(str, ch.COL_USERNAME);
                            if (b.aRP(str)) {
                                b bVar7 = b.FlH;
                                Log.d(b.TAG, "%s has story", str);
                                i2 |= 2;
                                arrayList.add(str);
                            }
                            i2 = i2;
                        }
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(118631);
                }
            }
            b bVar8 = b.FlH;
            if (b.FlF != i2) {
                b bVar9 = b.FlH;
                b.FlF = i2;
            }
            b bVar10 = b.FlH;
            b.FlE.addAll(arrayList2);
            b bVar11 = b.FlH;
            b.FlE.addAll(arrayList);
            ArrayList arrayList3 = new ArrayList();
            b bVar12 = b.FlH;
            List list3 = b.mListeners;
            p.g(list3, "mListeners");
            List<WeakReference> list4 = list3;
            synchronized (list4) {
                try {
                    for (WeakReference weakReference : list4) {
                        if (((c) weakReference.get()) == null) {
                            arrayList3.add(weakReference);
                        } else {
                            c cVar = (c) weakReference.get();
                            if (cVar != null) {
                                b bVar13 = b.FlH;
                                cVar.aaD(b.FlF);
                            }
                        }
                    }
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
            b bVar14 = b.FlH;
            b.mListeners.removeAll(arrayList3);
            b bVar15 = b.FlH;
            b.FlG = false;
            b bVar16 = b.FlH;
            String str2 = b.TAG;
            b bVar17 = b.FlH;
            Log.i(str2, "checkStoryStatus:%s nowState:%s", Integer.valueOf(b.FlF), Integer.valueOf(i2));
            AppMethodBeat.o(118631);
        }
    }

    public static void fnD() {
        AppMethodBeat.i(118633);
        ThreadPool.post(a.FlI, "FavourUserChecker_StoryStateChecker");
        AppMethodBeat.o(118633);
    }

    @Override // com.tencent.mm.plugin.story.api.b
    public final void hp(List<String> list) {
        AppMethodBeat.i(118634);
        List<String> list2 = FlD;
        p.g(list2, "mFavourUserList");
        synchronized (list2) {
            try {
                FlD.clear();
                FlD.addAll(list);
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(118634);
                throw th;
            }
        }
        fnD();
        AppMethodBeat.o(118634);
    }

    @Override // com.tencent.mm.plugin.story.api.b
    public final int fna() {
        return FlF;
    }

    @Override // com.tencent.mm.plugin.story.api.b
    public final void fnb() {
        AppMethodBeat.i(118635);
        Log.i(TAG, "setFavourStoryRead:%s", Integer.valueOf(FlF));
        if (FlF != 0) {
            FlF = 2;
        }
        AppMethodBeat.o(118635);
    }

    @Override // com.tencent.mm.plugin.story.api.b
    public final List<String> fnc() {
        AppMethodBeat.i(118636);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(FlE);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(118636);
        return arrayList2;
    }

    @Override // com.tencent.mm.plugin.story.api.b
    public final void h(WeakReference<c> weakReference) {
        AppMethodBeat.i(118637);
        if (!mListeners.contains(weakReference)) {
            mListeners.add(weakReference);
        }
        AppMethodBeat.o(118637);
    }

    public static final /* synthetic */ boolean aRP(String str) {
        AppMethodBeat.i(118639);
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118639);
            return false;
        } else if (str == null) {
            AppMethodBeat.o(118639);
            return false;
        } else {
            n.a aVar = n.FmM;
            i.a aVar2 = i.Fmb;
            boolean fM = n.a.fM(str, ((int) Util.nowSecond()) - i.fnT());
            AppMethodBeat.o(118639);
            return fM;
        }
    }
}

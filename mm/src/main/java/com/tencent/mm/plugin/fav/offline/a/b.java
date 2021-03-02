package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.offline.b.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    public p iRt = new p.a() {
        /* class com.tencent.mm.plugin.fav.offline.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(73551);
            if (i2 == 0 || i2 == 3 || i2 == 2 || i2 == 5) {
                try {
                    b.this.tcC = false;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.offline.FavOfflineService", e2, "", new Object[0]);
                    AppMethodBeat.o(73551);
                    return;
                }
            } else {
                b.this.tcC = true;
            }
            boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
            Log.i("MicroMsg.offline.FavOfflineService", "onNetworkChange st:%d hasNet:%s isWifi:%B, lastIsWifi:%B", Integer.valueOf(i2), Boolean.valueOf(b.this.tcC), Boolean.valueOf(isWifi), Boolean.valueOf(b.this.tcf));
            if (b.this.tcf) {
                b.this.tcf = isWifi;
                if (!isWifi) {
                    b bVar = b.this;
                    if (bVar.tcD != null) {
                        bVar.tcD.cancel(false);
                    }
                    AppMethodBeat.o(73551);
                    return;
                }
            } else {
                b.this.tcf = isWifi;
                if (isWifi) {
                    b.this.cVw();
                }
            }
            AppMethodBeat.o(73551);
        }
    };
    ConcurrentLinkedDeque<String> tcA = new ConcurrentLinkedDeque<>();
    ConcurrentHashMap<String, a> tcB = new ConcurrentHashMap<>();
    public boolean tcC = true;
    Future tcD;
    private Runnable tcE = new Runnable() {
        /* class com.tencent.mm.plugin.fav.offline.a.b.AnonymousClass2 */
        private CountDownLatch rDn;
        private ConcurrentLinkedQueue<String> tcG = new ConcurrentLinkedQueue<>();
        private ConcurrentHashMap<String, String> tcH = new ConcurrentHashMap<>();

        {
            AppMethodBeat.i(73553);
            AppMethodBeat.o(73553);
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x012d  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0206  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 648
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.offline.a.b.AnonymousClass2.run():void");
        }

        private boolean a(a aVar, String str, String str2, String str3) {
            final String name;
            String str4;
            boolean c2;
            int i2;
            int asg;
            AppMethodBeat.i(73555);
            if (!aVar.tcL || b.this.tcf) {
                if (Util.isNullOrNil(str3)) {
                    try {
                        str3 = s.boY(str2);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.offline.FavOfflineService", "replaceImagUrl Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                        AppMethodBeat.o(73555);
                        return false;
                    }
                }
                Pattern compile = Pattern.compile("<img.*?>");
                Pattern compile2 = Pattern.compile("\"http?(.*?)(\"|>|\\s+)");
                Matcher matcher = compile.matcher(str3);
                while (matcher.find()) {
                    Matcher matcher2 = compile2.matcher(matcher.group());
                    if (matcher2.find()) {
                        String group = matcher2.group();
                        if (!Util.isNullOrNil(group)) {
                            this.tcG.add(group.substring(1, group.length() - 1));
                        }
                    }
                }
                Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl pics.size:%s", Integer.valueOf(this.tcG.size()));
                if (this.tcG.size() <= 0) {
                    AppMethodBeat.o(73555);
                    return true;
                }
                if (Util.isNullOrNil(aVar.field_imgDirPath)) {
                    String boZ = s.boZ(str2);
                    String messageDigest = d.getMessageDigest(new o(str2).getName().getBytes());
                    if (Util.isNullOrNil(messageDigest)) {
                        messageDigest = "imagdir";
                    } else if (messageDigest.length() > 20) {
                        messageDigest = messageDigest.substring(0, 20);
                    }
                    String str5 = boZ + FilePathGenerator.ANDROID_DIR_SEP + messageDigest;
                    s.boN(str5);
                    name = messageDigest;
                    str4 = str5;
                } else {
                    String str6 = aVar.field_imgDirPath;
                    name = new o(str6).getName();
                    str4 = str6;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = this.tcG.iterator();
                while (it.hasNext()) {
                    arrayList.add(b.asi(d.getMessageDigest(it.next().getBytes())));
                }
                if (Util.isNullOrNil(str)) {
                    Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: url is null!");
                    c2 = false;
                } else if (arrayList.size() == 0) {
                    Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) urls is null!", str);
                    c2 = false;
                } else {
                    String listToString = Util.listToString(arrayList, ",");
                    a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
                    if (ask == null) {
                        Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) is null!", str);
                        c2 = false;
                    } else if (!Util.isNullOrNil(ask.field_imgPaths)) {
                        Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) field_imgPaths isn't null!", str);
                        c2 = false;
                    } else {
                        ask.field_imgPaths = listToString;
                        c2 = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(ask);
                    }
                }
                Log.i("MicroMsg.offline.FavOfflineService", "updateUrlsResult:%s", Boolean.valueOf(c2));
                long aWz = cl.aWz();
                this.rDn = new CountDownLatch(this.tcG.size());
                Iterator<String> it2 = this.tcG.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    final String next = it2.next();
                    if (aVar.tcL && !((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineService().tcf) {
                        Log.i("MicroMsg.offline.FavOfflineService", "current not wifi, break off downloadImg");
                        b.a(b.this, str);
                        break;
                    }
                    int i4 = i3 + 1;
                    String messageDigest2 = d.getMessageDigest(next.getBytes());
                    if (Util.isNullOrNil(messageDigest2)) {
                        this.rDn.countDown();
                        i3 = i4;
                    } else {
                        final String asi = b.asi(messageDigest2);
                        String str7 = str4 + FilePathGenerator.ANDROID_DIR_SEP + asi;
                        if (s.YS(str7)) {
                            Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl num:%s url:%s fullPath(%s) exist", Long.valueOf(this.rDn.getCount()), next, str7);
                            this.tcH.put(next, "./" + name + FilePathGenerator.ANDROID_DIR_SEP + asi);
                            this.rDn.countDown();
                            i3 = i4;
                        } else {
                            Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl url:%s fullPath:%s", next, str7);
                            c.a aVar2 = new c.a();
                            aVar2.fullPath = str7;
                            aVar2.jbf = true;
                            q.bcV().a(next, aVar2.bdv(), new com.tencent.mm.av.a.c.d() {
                                /* class com.tencent.mm.plugin.fav.offline.a.b.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.av.a.c.d
                                public final void a(boolean z, Object... objArr) {
                                    AppMethodBeat.i(198779);
                                    Object[] objArr2 = new Object[3];
                                    objArr2[0] = AnonymousClass2.this.rDn == null ? BuildConfig.COMMAND : Long.valueOf(AnonymousClass2.this.rDn.getCount());
                                    objArr2[1] = next;
                                    objArr2[2] = Boolean.valueOf(z);
                                    Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl num:%s url:%s, success:%b", objArr2);
                                    if (z) {
                                        AnonymousClass2.this.tcH.put(next, "./" + name + FilePathGenerator.ANDROID_DIR_SEP + asi);
                                    }
                                    if (AnonymousClass2.this.rDn != null) {
                                        AnonymousClass2.this.rDn.countDown();
                                    }
                                    AppMethodBeat.o(198779);
                                }
                            });
                            i3 = i4;
                        }
                    }
                }
                if (i3 < this.tcG.size()) {
                    for (int i5 = 0; i5 < this.tcG.size() - i3; i5++) {
                        this.rDn.countDown();
                    }
                }
                boolean z = false;
                try {
                    z = this.rDn.await(300, TimeUnit.SECONDS);
                } catch (Exception e3) {
                    Log.e("MicroMsg.offline.FavOfflineService", "countDownLatch:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
                }
                long aWz2 = cl.aWz();
                int size = this.tcH.size();
                Log.i("MicroMsg.offline.FavOfflineService", "isNoExceedTime:%s finishNum:%s startTime:%s endTime:%s diff:%s", Boolean.valueOf(z), Integer.valueOf(size), Long.valueOf(aWz), Long.valueOf(aWz2), Long.valueOf(aWz2 - aWz));
                if ((!z || size < i3) && (asg = a.asg(str)) != -1 && asg < 3) {
                    b.a(b.this, str);
                }
                if (size > 0) {
                    String str8 = str3;
                    for (String str9 : this.tcH.keySet()) {
                        if (!Util.isNullOrNil(str9)) {
                            String str10 = this.tcH.get(str9);
                            if (!Util.isNullOrNil(str10)) {
                                str8 = str8.replace("data-src=\"".concat(String.valueOf(str9)), "src=\"".concat(String.valueOf(str10)));
                                Log.d("MicroMsg.offline.FavOfflineService", "replaceImagUrl url:%s replacePath:%s", str9, str10);
                            }
                        }
                        str8 = str8;
                    }
                    boolean deleteFile = s.deleteFile(str2);
                    int i6 = 0;
                    boolean z2 = false;
                    if (deleteFile) {
                        byte[] bytes = str8.getBytes();
                        i6 = s.f(str2, bytes, bytes.length);
                        if (Util.isEqual(i6, 0)) {
                            if (size == this.tcG.size()) {
                                i2 = 2;
                            } else {
                                i2 = 1;
                            }
                            z2 = a.d(str, str2, str4, i2);
                        } else {
                            z2 = a.d(str, str2, str4, 0);
                        }
                    }
                    Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl pics(%s) finishNum(%s) imgPathHashMap(%s) deleteResult(%s) writeResult(%s) updateResult(%s) startTime(%s) endTime(%s) diff(%s)", Integer.valueOf(this.tcG.size()), Integer.valueOf(size), Integer.valueOf(this.tcH.size()), Boolean.valueOf(deleteFile), Integer.valueOf(i6), Boolean.valueOf(z2), Long.valueOf(aWz), Long.valueOf(aWz2), Long.valueOf(aWz2 - aWz));
                } else {
                    Log.i("MicroMsg.offline.FavOfflineService", "replaceImagUrl imgPathHashMap.size() == 0");
                }
                AppMethodBeat.o(73555);
                return true;
            }
            Log.i("MicroMsg.offline.FavOfflineService", "current not wifi");
            b.a(b.this, str);
            AppMethodBeat.o(73555);
            return false;
        }
    };
    boolean tcf;

    public b() {
        AppMethodBeat.i(73556);
        if (!a.cVs()) {
            Log.i("MicroMsg.offline.FavOfflineService", "fav offline switch is close");
            AppMethodBeat.o(73556);
            return;
        }
        this.tcf = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        g.aAg().a(this.iRt);
        cVw();
        AppMethodBeat.o(73556);
    }

    /* access modifiers changed from: package-private */
    public final void cVw() {
        AppMethodBeat.i(73557);
        List<a> cVy = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVy();
        if (cVy != null && cVy.size() > 0) {
            for (a aVar : cVy) {
                if (aVar != null && !Util.isNullOrNil(aVar.field_url)) {
                    this.tcA.add(aVar.field_url);
                    this.tcB.put(aVar.field_url, aVar);
                }
            }
        }
        Log.i("MicroMsg.offline.FavOfflineService", "resetDownloadTask downloadUrlList.size:%s", Integer.valueOf(this.tcA.size()));
        run();
        AppMethodBeat.o(73557);
    }

    public final void add(String str) {
        AppMethodBeat.i(73558);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73558);
            return;
        }
        boolean cVs = a.cVs();
        boolean isMpUrl = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(str);
        boolean z = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str) != null;
        Log.i("MicroMsg.offline.FavOfflineService", "add isOpen:%s isMpUrl:%s isOffline:%s", Boolean.valueOf(cVs), Boolean.valueOf(isMpUrl), Boolean.valueOf(z));
        if (cVs && isMpUrl && !z) {
            a aVar = new a();
            aVar.field_url = str;
            aVar.field_favTime = cl.aWz();
            ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().b(aVar);
            Log.i("MicroMsg.offline.FavOfflineService", "add url:%s", str);
            a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
            if (ask != null) {
                this.tcA.add(str);
                this.tcB.put(str, ask);
                run();
            }
        }
        AppMethodBeat.o(73558);
    }

    public final void ash(String str) {
        AppMethodBeat.i(73559);
        a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
        if (ask != null) {
            Log.i("MicroMsg.offline.FavOfflineService", "addUpdateTask url:%s", str);
            if (this.tcC) {
                a.a(ask);
                ask.tcL = false;
                this.tcA.addFirst(str);
                this.tcB.put(str, ask);
                run();
                AppMethodBeat.o(73559);
                return;
            }
        } else {
            Log.d("MicroMsg.offline.FavOfflineService", "addUpdateTask FavOffline is null!!(url:%s)", str);
            add(str);
        }
        AppMethodBeat.o(73559);
    }

    public final void run() {
        AppMethodBeat.i(73560);
        if (this.tcA.isEmpty()) {
            Log.i("MicroMsg.offline.FavOfflineService", "run() downloadUrlList is empty!");
            AppMethodBeat.o(73560);
            return;
        }
        if (this.tcD == null || this.tcD.isDone()) {
            this.tcD = h.RTc.aX(this.tcE);
        }
        AppMethodBeat.o(73560);
    }

    public static String asi(String str) {
        AppMethodBeat.i(73561);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73561);
            return BuildConfig.COMMAND;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
            if (i2 + 20 < length) {
                sb.append(str.substring(i2, i2 + 20));
                i2 += 20;
            } else {
                sb.append(str.substring(i2, length));
                i2 = length;
            }
        }
        if (sb.length() > 1) {
            String substring = sb.substring(1);
            AppMethodBeat.o(73561);
            return substring;
        }
        AppMethodBeat.o(73561);
        return BuildConfig.COMMAND;
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(73562);
        a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
        if (ask != null) {
            Log.i("MicroMsg.offline.FavOfflineService", "addUnfinishedTask url:%s", str);
            bVar.tcA.add(str);
            bVar.tcB.put(str, ask);
            bVar.run();
            AppMethodBeat.o(73562);
            return;
        }
        Log.d("MicroMsg.offline.FavOfflineService", "addUnfinishedTask FavOffline is null!!(url:%s)", str);
        AppMethodBeat.o(73562);
    }
}

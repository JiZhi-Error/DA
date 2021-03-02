package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class g extends com.tencent.mm.plugin.fts.a.b {
    private i gNh = new i() {
        /* class com.tencent.mm.plugin.fts.b.g.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(52766);
            if (qVar instanceof c) {
                c cVar = (c) qVar;
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", cVar.JVj.toString());
                } else {
                    Log.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    List<String> list = cVar.JVj;
                    if (i3 == -44) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(1);
                        HashMap hashMap = new HashMap();
                        hashMap.put(list.get(0), 0);
                        com.tencent.mm.kernel.g.azz().a(new c(list, linkedList, "你好，我是珍惜", cVar.wZz, hashMap, cVar.wZz), 0);
                    }
                    if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                        Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                    }
                    AppMethodBeat.o(52766);
                    return;
                }
            }
            AppMethodBeat.o(52766);
        }
    };
    private m hgI;
    String[] wZv;
    List<String> wZw;

    public g() {
        AppMethodBeat.i(52779);
        AppMethodBeat.o(52779);
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "SearchTestLogic";
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52780);
        if (!((n) com.tencent.mm.kernel.g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
            AppMethodBeat.o(52780);
            return false;
        }
        Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
        this.hgI = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon();
        AppMethodBeat.o(52780);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        com.tencent.mm.plugin.fts.a.a.a bVar;
        AppMethodBeat.i(52781);
        switch (jVar.kXb) {
            case ShareElfFile.SectionHeader.SHN_ABS /*{ENCODED_INT: 65521}*/:
                bVar = new f(jVar.wWW, jVar.talker);
                break;
            case ShareElfFile.SectionHeader.SHN_COMMON /*{ENCODED_INT: 65522}*/:
            default:
                bVar = new a(this, (byte) 0);
                break;
            case 65523:
                bVar = new e(jVar);
                break;
            case 65524:
                bVar = new d(this, (byte) 0);
                break;
            case 65525:
                bVar = new C1379g(this, (byte) 0);
                break;
            case 65526:
                bVar = new b(jVar);
                break;
        }
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(Integer.MAX_VALUE, bVar);
        AppMethodBeat.o(52781);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(52782);
        com.tencent.mm.kernel.g.azz().b(30, this.gNh);
        AppMethodBeat.o(52782);
        return false;
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52767);
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
            AppMethodBeat.o(52767);
            throw sQLiteDatabaseCorruptException;
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int count;
        private String dFl;

        public f(int i2, String str) {
            this.count = i2;
            this.dFl = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            String str;
            AppMethodBeat.i(52775);
            if (g.this.wZv == null) {
                g.this.wZv = s.boY("/sdcard/test_insert_msg_words.txt").split(",");
            }
            if (g.this.wZw == null) {
                g.this.wZw = new ArrayList();
                if (!Util.isNullOrNil(this.dFl)) {
                    g.this.wZw.add(this.dFl);
                } else {
                    Cursor gCa = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().gCa();
                    while (gCa.moveToNext()) {
                        g.this.wZw.add(gCa.getString(0));
                    }
                    gCa.close();
                }
            }
            if (g.this.wZv != null) {
                for (int i2 = 0; i2 < this.count; i2++) {
                    String K = K(g.this.wZv);
                    ca caVar = new ca();
                    caVar.setType(1);
                    caVar.nv(1);
                    caVar.setStatus(4);
                    caVar.setContent(K);
                    List<String> list = g.this.wZw;
                    if (list.size() > 1) {
                        str = list.get(new Random().nextInt(list.size() - 1));
                    } else {
                        str = list.get(0);
                    }
                    caVar.Cy(str);
                    caVar.setCreateTime(System.currentTimeMillis() - 250327040);
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar);
                    Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(this.count), Integer.valueOf(i2), Integer.valueOf(K.length()), Long.valueOf(caVar.field_msgId));
                }
            }
            AppMethodBeat.o(52775);
            return true;
        }

        private static String K(String[] strArr) {
            AppMethodBeat.i(52776);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < 300; i2++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(52776);
            return stringBuffer2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$g  reason: collision with other inner class name */
    class C1379g extends com.tencent.mm.plugin.fts.a.a.a {
        private C1379g() {
        }

        /* synthetic */ C1379g(g gVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52777);
            if (g.this.wZv == null) {
                String boY = s.boY("/sdcard/test_insert_msg_words.txt");
                g.this.wZv = boY.split(",");
            }
            if (g.this.wZw == null) {
                g.this.wZw = new ArrayList();
                Cursor gCa = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().gCa();
                while (gCa.moveToNext()) {
                    g.this.wZw.add(gCa.getString(0));
                }
                gCa.close();
            }
            if (g.this.wZv != null) {
                int[] iArr = {1000, 2000, 5000, 10000, com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 100000};
                for (int i2 = 0; i2 < 7; i2++) {
                    for (int i3 = 0; i3 < iArr[i2]; i3++) {
                        String K = K(g.this.wZv);
                        ca caVar = new ca();
                        caVar.setType(1);
                        caVar.nv(1);
                        caVar.setStatus(4);
                        caVar.setContent(K);
                        caVar.Cy(g.this.wZw.get(i2));
                        caVar.setCreateTime(System.currentTimeMillis());
                        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar);
                        Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(i3), Integer.valueOf(iArr[i2]), Integer.valueOf(K.length()), Long.valueOf(caVar.field_msgId));
                    }
                }
            }
            AppMethodBeat.o(52777);
            return true;
        }

        private static String K(String[] strArr) {
            AppMethodBeat.i(52778);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < 300; i2++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(52778);
            return stringBuffer2;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private j wTn;

        public b(j jVar) {
            this.wTn = jVar;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52769);
            com.tencent.mm.plugin.fts.a.e.wVl.wVo = com.tencent.mm.plugin.fts.d.dOr().length() / 1048576;
            com.tencent.mm.plugin.fts.a.e.wVl.wVp = dOW();
            com.tencent.mm.plugin.fts.a.e.wVl.wVq = dOX();
            com.tencent.mm.plugin.fts.a.e.wVl.wVs = dOU();
            com.tencent.mm.plugin.fts.a.e.wVl.wVr = dOV();
            ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-301, com.tencent.mm.plugin.fts.a.e.wVl.wVp);
            ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-302, com.tencent.mm.plugin.fts.a.e.wVl.wVq);
            ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-303, com.tencent.mm.plugin.fts.a.e.wVl.wVs);
            ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-304, com.tencent.mm.plugin.fts.a.e.wVl.wVr);
            final k kVar = new k(this.wTn);
            if (this.wTn.wWZ != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.b.g.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(52768);
                        b.this.wTn.wWZ.b(kVar);
                        AppMethodBeat.o(52768);
                    }
                });
            }
            AppMethodBeat.o(52769);
            return true;
        }

        private static long dOU() {
            AppMethodBeat.i(52770);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", "FTS5MetaFavorite", 9), null);
            try {
                if (rawQuery.moveToNext()) {
                    return rawQuery.getLong(0);
                }
                rawQuery.close();
                AppMethodBeat.o(52770);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52770);
            }
        }

        private static long dOV() {
            AppMethodBeat.i(52771);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", "FTS5MetaMessage"), null);
            try {
                if (rawQuery.moveToNext()) {
                    return rawQuery.getLong(0);
                }
                rawQuery.close();
                AppMethodBeat.o(52771);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52771);
            }
        }

        private static long dOW() {
            AppMethodBeat.i(52772);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", "FTS5MetaContact", 131072, 1), null);
            try {
                if (rawQuery.moveToNext()) {
                    return rawQuery.getLong(0);
                }
                rawQuery.close();
                AppMethodBeat.o(52772);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52772);
            }
        }

        private static long dOX() {
            AppMethodBeat.i(52773);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", "FTS5MetaContact", 131075, 38), null);
            try {
                if (rawQuery.moveToNext()) {
                    return rawQuery.getLong(0);
                }
                rawQuery.close();
                AppMethodBeat.o(52773);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52773);
            }
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTS5DBInfoTask";
        }
    }

    class e extends com.tencent.mm.plugin.fts.a.a.a {
        j wWO;

        public e(j jVar) {
            this.wWO = jVar;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTSTestAddChatroomContactTask";
        }
    }

    class c extends p {
        public String wZz = "";

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        public c(int i2, List<Integer> list, String str, String str2, Map<String, Integer> map, String str3) {
            super(i2, list, str, str2, map, str3);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private d() {
        }

        /* synthetic */ d(g gVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52774);
            com.tencent.mm.kernel.g.aAh().hqK.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
            AppMethodBeat.o(52774);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTSClearUnReadCountTask";
        }
    }
}
